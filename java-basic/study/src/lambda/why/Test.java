package lambda.why;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("zhangsan",14,67));
        list.add(new Student("lisi",13,89));
        list.add(new Student("wangwu",15,97));
        list.add(new Student("maliu",12,63));
        list.add(new Student("zhaoqi",17,75));

        //查找年龄大于14的学生
        findByAge(list);
        System.out.println("---------------------");
        //查找分数大于75的学生
        findByScore(list);

    }
    public static void findByAge(List<Student> list){
        ArrayList<Student> list1 = new ArrayList<Student>();
        for(Student stu: list){
            if(stu.getAge() > 14) {
                list1.add(stu);
            }
        }
        for(Student stu: list1) {
            System.out.println(stu);
        }
    }

    public static void findByScore(ArrayList<Student> list) {
        ArrayList<Student> list2 = new ArrayList<>();
        for(Student st: list) {
            if(st.getScore() > 75) {
                list2.add(st);
            }
        }
        for(Student st: list2) {
            System.out.println(st);
        }
    }
}
