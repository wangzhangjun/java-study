package innerDemo2;


public class AnnmousInnerClass {
    public static void main(String[] args) {
        Runnable run = new Runnable() {  // Runnable是一个接口，为什么可以new，就是有个匿名类
            @Override
            public void run() {

            }
        };
    }
}
