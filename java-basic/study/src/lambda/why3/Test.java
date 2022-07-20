package lambda.why3;

import lambda.why.Student;
import lambda.why2.StudentFilter;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("zhangsan",14,67));
        list.add(new Student("lisi",13,89));
        list.add(new Student("wangwu",15,97));
        list.add(new Student("maliu",12,63));
        list.add(new Student("zhaoqi",17,75));

        getByFilter(list, new StudentFilter() {
            @Override
            public boolean compare(Student student) {
                return student.getScore()>75;
            }
        });

        getByFilter(list, new StudentFilter() {
            @Override
            public boolean compare(Student student) {
                return student.getAge() > 14;
            }
        });
    }
    public  static void getByFilter(ArrayList<Student> students, StudentFilter stufilter) {
        ArrayList<Student> lsit = new ArrayList<Student>();
        for(Student st : students) {
            if(stufilter.compare(st)) {
                lsit.add(st);
            }
        }
        printStu(lsit);
    }

    public static void printStu(ArrayList<Student> students){
        for(Student st : students) {
            System.out.println(st);
        }
    }
}
