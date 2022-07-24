package CustomAnnotation;

public @interface MyAnn2 {

    String value() default "abc"; //定义一个注解，并给一个默认值，在使用的时候可以无需传值
}
