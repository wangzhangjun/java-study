package CustomAnnotation;


public @interface MyAnn {
    String[] value(); //这是一个成员变量，不是方法,这个参数叫做配置参数，如果你定义了这个配置参数，必须给一个赋值操作
}
