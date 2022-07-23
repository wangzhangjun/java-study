package com.zhjwang.test02;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class Main3 {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<Student> cls = Student.class;
        // 获取运行时类的方法，还有所有父类的public方法
        Method[] methods = cls.getMethods();
        for(Method m : methods) {
            System.out.println(m);
        }

        System.out.println("===============获取运行类的所有方法=================");
        Method[] declaredMethods = cls.getDeclaredMethods();
        for(Method m : declaredMethods) {
            System.out.println(m);
        }
        System.out.println("===============获取运行类的指定方法=================");
        Method showInfo = cls.getMethod("showInfo");  //获取无参数的showInfo
        Method showInfo1 = cls.getMethod("showInfo", int.class);
        System.out.println(showInfo1);
        System.out.println(showInfo);
        System.out.println("===============获取运行类的指定private方法=================");
        Method wrok = cls.getDeclaredMethod("wrok");
        System.out.println(wrok);

        System.out.println("===============获取运行类方法的具体结构=================");
        //获取方法名字
        System.out.println(wrok.getName());
        int modifiers = wrok.getModifiers();
        System.out.println(Modifier.toString(modifiers));  //private
        //返回值
        System.out.println(wrok.getReturnType());
        //参数列表
        Parameter[] parameters = wrok.getParameters();
        for(Parameter p : parameters) {
            System.out.println(p);  //每个参数的列表
        }
        System.out.println("===============获取运行类方法的注解=================");
        Method myMythod = cls.getMethod("myMythod");
        Annotation[] annotations = myMythod.getAnnotations();  //注意这里只能获取Runtime类型的注解，比如source类型的注解是获取不到的
        for(Annotation a : annotations) {
            System.out.println(a);
        }
        System.out.println("===============获取运行类方法的异常=================");
        Class<?>[] exceptionTypes = myMythod.getExceptionTypes();
        for(Class c : exceptionTypes) {
            System.out.println(c);  //class java.lang.RuntimeException,获取运行时异常
        }

        //调用方法 ：
        Student student = cls.newInstance();
        myMythod.invoke(student);  //调用student对象的方法,无参数
        showInfo1.invoke(student, 1); //带参数的
    }
}
