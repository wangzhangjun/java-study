package com.zhjwang.test02;

import java.lang.annotation.Annotation;

public class Main4 {
    public static void main(String[] args) {
        Class<Student> studentClass = Student.class;
        //获取运行时类的接口
        Class<?>[] interfaces = studentClass.getInterfaces();
        for(Class c : interfaces) {
            System.out.println(c); //interface com.zhjwang.test02.MyInterface
        }

        System.out.println("===============得到父类的接口=============");
        //先得到父类的字节码信息
        Class<? super Student> superclass = studentClass.getSuperclass();
        Class<?>[] interfaces1 = superclass.getInterfaces();
        for(Class c : interfaces1) {
            System.out.println(c); //interface java.io.Serializable
        }

        System.out.println("===============获取包=============");
        Package aPackage = studentClass.getPackage();
        System.out.println(aPackage);//package com.zhjwang.test02
        System.out.println(aPackage.getName()); //com.zhjwang.test02

        System.out.println("===============得到注解=============");
        Annotation[] annotations = studentClass.getAnnotations();
        for(Annotation a : annotations) {
            System.out.println(a); //@com.zhjwang.test02.MyAnnotation("hello")
        }

    }
}
