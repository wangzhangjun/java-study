package innerDemo2;

public class MethonInnerClass {
    public void show(int number){
        class InnerClass{
            private String name;
            public void test(int a){
                System.out.println("test");
                System.out.println(a);
                System.out.println(number);
            }
        }
        new InnerClass().test(12);  //必须在这个方法中去new，其他地方new不出来
    }

    public static void main(String[] args) {
        MethonInnerClass  methodInnerClass = new MethonInnerClass();
        methodInnerClass.show(1234);

    }
}
