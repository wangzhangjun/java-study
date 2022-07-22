import java.io.InputStream;

public class Main {

    public static void main(String[] args) {

        InputStream in  = Main.class.getClassLoader().getResourceAsStream("beans.xml");
        if(in  == null) {
            System.out.println("open file faile");
            return;
        }
        XmlBeanConfigParser xmlBeanConfigParser = new XmlBeanConfigParser();
        xmlBeanConfigParser.parser(in);
    }
}
