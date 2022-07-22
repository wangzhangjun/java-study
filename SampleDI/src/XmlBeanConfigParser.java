
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlBeanConfigParser {

    public void parser(InputStream inputStream) {
        try{
            DocumentBuilderFactory documentBuilderFactory  = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc  = documentBuilder.parse(inputStream);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("bean");

            for(int i =0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if(node.getNodeType() != Node.ELEMENT_NODE)
                    continue;
                Element element = (Element)node;
                // 获取一级xml标签上的bean属性
                System.out.println(element.getAttribute("id"));
                System.out.println(element.getAttribute("class"));
                System.out.println("==========================");
                //获取子标签
                NodeList SecondElementList = element.getElementsByTagName("constructor-arg");
                for(int j = 0; j < SecondElementList.getLength(); j++) {
                    Node SecondNode = SecondElementList.item(j);
                    if(SecondNode.getNodeType() != Node.ELEMENT_NODE) continue;
                    Element secondElement = (Element)SecondNode;
                    System.out.println(secondElement.getAttribute("type"));
                    System.out.println(secondElement.getAttribute("value"));
                }

                System.out.println(element.getElementsByTagName("constructor-arg"));
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
