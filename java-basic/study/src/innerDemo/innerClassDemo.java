package innerDemo;

public class innerClassDemo {
    private int id = 1;
    private String name ="外部";
    public int getId() {
        return id;
    }
    public void show(){
        innerClass inner = new innerClass();
        System.out.println(inner.innerId); //通过创建对象可以访问内部类的私有属性
    }
    public class  innerClass{
        private int innerId;
        private String name ="nei部";

        //static int test; 注意：内部类是不能声明static的属性的
        public void test(){
            System.out.println("inner class test");
            System.out.println(id); //内部类可以访问外部类的私有属性，在设计模式和重构的时候可以使用
            System.out.println(name);  // 内部
            System.out.println(innerClassDemo.this.name); //外部的要使用this
        }
    };
}

class Test{
    public static void main(String[] args) {
        innerClassDemo demo = new innerClassDemo();
        System.out.println(demo.getId()); //1

        //使用内部类
        innerClassDemo.innerClass innerDemo = new innerClassDemo().new innerClass();
        innerDemo.test();
    }
};
