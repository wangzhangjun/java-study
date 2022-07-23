package com.zhjwang.test02;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取字节码信息
         Class studentClass = Student.class;
         //获取构造器,但是这个方法只能获取类的public构造器
        Constructor[] constructors = studentClass.getConstructors();
        for(Constructor c : constructors) {
            System.out.println(c);
        }
        System.out.println("==========下面这个可以获取所有的构造器===========");
        Constructor[] constructors1 =  studentClass.getDeclaredConstructors();
        for(Constructor c : constructors1) {
            System.out.println(c);
        }

        System.out.println("===========获取指定的构造器==========");
        Constructor con1 = studentClass.getConstructor();//默认得到空构造器
        System.out.println(con1);
        Constructor con2 = studentClass.getConstructor(double.class, double.class);
        System.out.println(con2); //获取到的是public com.zhjwang.test02.Student(double,double)，带两个构造器

        //得到一个参数的有参构造器，并且是private修饰的
        Constructor con3 = studentClass.getDeclaredConstructor(int.class);
        System.out.println(con3);  //private com.zhjwang.test02.Student(int)

        //有了构造器，就开始构造对象
        Object o = con1.newInstance(); //默认构造
        System.out.println(o);

        Object o2 = con2.newInstance(1.2, 3.4); //有参构造
        System.out.println(o2);

    }
}
