package com.zhjwang.test02;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main2 {
    public static void main(String[] args) throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class cls = Student.class;
        //getFields 获取当前运行时类和父类的public成员
        Field[] fields = cls.getFields();
        for(Field f: fields) {
            System.out.println(f);
        }
        System.out.println("============获取运行时类的所有成员变量============");
        Field[] declaredFields = cls.getDeclaredFields();
        for(Field f : declaredFields) {
            System.out.println(f);
        }
        System.out.println("============获取运行时类的指定属性============");
        Field score = cls.getField("score");
        System.out.println(score);
        System.out.println("============获取运行时类的private指定属性============");
        Field sno = cls.getDeclaredField("sno");
        System.out.println(sno);
        System.out.println("============获取运行时类的属性具体结构============");
        //获取修饰符
        int modifiers = sno.getModifiers(); //private
        System.out.println(modifiers); //返回修饰符的个数
        System.out.println(Modifier.toString(modifiers)); //private
        //获取数据类型
        Class type = sno.getType();
        System.out.println(type.getName()); //int
        //获取属性名字
        String name = sno.getName();
        System.out.println(name); //sno

        System.out.println("============给属性赋值============");
        Field score1 = cls.getField("score");
        Object o1 = cls.newInstance();
        score1.set(o1, 98);//给属性设置值的时候，必须要有对象，先创建一个对象，给o1这个对象的score设置具体的值98
        System.out.println(o1);
    }
}
