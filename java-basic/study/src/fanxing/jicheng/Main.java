package fanxing.jicheng;

import jdk.swing.interop.SwingInterOpUtils;

public class Main {
    public static void main(String[] args) {
        Child<String> stringChild = new Child<>();
        stringChild.setValue("agg");
        System.out.println(stringChild.getValue());

        System.out.println("===================");
        ChildSecond childSecond = new ChildSecond();
        childSecond.setValue("zhjwang");
        System.out.println(childSecond.getValue());
    }
}
