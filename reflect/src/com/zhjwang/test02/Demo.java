package com.zhjwang.test02;


//作为Class的具体实例的种类
public class Demo {
    public static void main(String[] args) {
        Class c1 = Person.class;
        Class c2 = Comparable.class;
        Class c3 = Override.class;

        int[] arr = {1,2,3};
        int[] arr1 = {1,2,3};
        Class c4 =  arr.getClass();
        Class c5 =  arr1.getClass();
        System.out.println(c4 == c5); //true,同一个类型的类信息是相等的

        Class c6 = int.class;
        Class c7 = void.class;

    }
}
