package com.zhjwang.test02;

@MyAnnotation(value="hello")
public class Student extends Person implements MyInterface{
    private int sno;
    double height;
    protected  double weight;
    public  double score;

    @MyAnnotation(value="himethod")
    public String showInfo(){
        return "i am a good student";
    }
    public String showInfo(int a){
        return "重载i am a good student";
    }
    @Override
    @MyAnnotation(value="himethod1")
    public void myMythod() {
        System.out.println("override mythod");
    }

    void happy(){
        System.out.println("kaikaixinxi");
    }

    protected int getSno(){
        return sno;
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

    public Student(double height, double weight) {
        this.weight = weight;
        this.height = height;
    }

    protected Student(int sno, double weight, double height) {
        this.sno = sno;
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String
    toString() {
        return "Student{" +
                "sno=" + sno +
                ", height=" + height +
                ", weight=" + weight +
                ", score=" + score +
                '}';
    }
}
