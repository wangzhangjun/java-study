package com.zhjwang.test02;

public class Test {
    public static void main(String[] args) throws Exception {
        //获取字节码的四种信息
        //方式1
        Person p = new Person();
        Class c1 = p.getClass();
        System.out.println(c1);

        //2
        Class c2 = Person.class;
        System.out.println(c2);

        System.out.println(c1==c2); //true

        //方式1和方式2不常用

        //方式3,用Class提供的静态方法forName
        Class cls = Class.forName("com.zhjwang.test02.Person");
        System.out.println(cls);

        //方式4,利用类的加载器加载
        ClassLoader classLoader = Test.class.getClassLoader();
        Class c4 = classLoader.loadClass("com.zhjwang.test02.Person");
        System.out.println(c4);

    }
}
