package innerDemo2;

public class StaticInnerClass {
    private int id;

    public void test(){
        System.out.println("test");
    }
    static class InnerClass{
        private String name;
        public void show(){
            System.out.println("show");
        }
    }
    public static void main(String[] args) {
        InnerClass innerClass = new StaticInnerClass.InnerClass();
//        InnerClass innerClass = new StaticClass().new InnerClass();

    }
}
