package com.zhjwang.test02;

import java.io.Serializable;

public class Person implements Serializable {
    private int age;
    public String name;
    private void eat(){
        System.out.println("person--eat");
    }
    public void sleep(){
        System.out.println("person--sleep");
    }
}
