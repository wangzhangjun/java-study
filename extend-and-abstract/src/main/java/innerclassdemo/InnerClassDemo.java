package innerclassdemo;

public class InnerClassDemo {

    private int id;
    private String name;

    public void show(){
        System.out.println("show");
//        System.out.println(age);外部类不能访问内部类的私有属性
        new InnerClass().test(); //外部类不能访问内部类的私有属性,但是如果创建了内部类的对象，此时可以在外部类中访问私有属性
    }

    class InnerClass{
        private int age;
        //static String name = "zhangsan"; 内部类中不能定义静态属性
        public void test(){
            System.out.println("inner test");
            System.out.println(id);  //内部类可以方便的访问外部类的私有属性
            System.out.println(name);
        }
    }
}
