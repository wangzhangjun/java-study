package fanxing.jiekou;

public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple();
        System.out.println(apple.getKey());
        System.out.println("==================");
        Apple2<Integer, String> apple2 = new Apple2<>(123, "NING");
        System.out.println(apple2.getKey());
        System.out.println(apple2.getValue());
    }
}
