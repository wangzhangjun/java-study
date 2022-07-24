package CustomAnnotation;

@MyAnn(value = {"abc", "dgc"})  //由定义的string[] value决定。如果只有一个属性的话，这个value是可以省略的
@MyAnn2
public class Person {

}
