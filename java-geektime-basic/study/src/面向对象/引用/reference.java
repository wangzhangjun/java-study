package 面向对象.引用;

public class reference {
    public static void main(String[] args) {
        Merchandise m1;
        m1 = new Merchandise();
        Merchandise m2;
        m2 = m1;   // 引用必须是同一种类型。才能赋值

        System.out.println("m1=" + m1);  //m1和m2地址是一样的
        System.out.println("m2=" + m2);

        int[][] test = new int[3][5];
        System.out.println(test.length);
        System.out.println(test[0].length);
    }
}
