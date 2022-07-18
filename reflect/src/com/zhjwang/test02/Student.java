package com.zhjwang.test02;

public class Student extends Person{
    private int sno;
    double height;
    protected  double weight;
    public  double score;

    public String showInfo(){
        return "i am a good student";
    }

    private void wrok(){
        System.out.println("coding");
    }

    //construct
    public  Student(){
        System.out.println("无参数构造");
    }
    private Student(int sno) {
        this.sno = sno;
    }
    Student(int sno, double weight) {
        this.sno = sno;
        this.weight = weight;
    }
}
