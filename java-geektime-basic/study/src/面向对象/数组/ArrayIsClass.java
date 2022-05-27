package 面向对象.数组;

public class ArrayIsClass {
    public static void main(String[] args) {
        // 一维数组
        int[] arr;
        arr = new int[3];

        int[] a1 = new int[9];
        int[] a2 = new int[0];
        a2 = a1;

        // 二维数组
        double[][] arr1 = new double[2][3];

        //三维数组
        double[][][] arr2 = new double[2][3][4];
        double[] a3 = new double[5];
        arr2[1][2] = a3; //a3 是double[] 类型的， arr2[][] 也是double类型的

        System.out.println("a2.length=" + a2.length);
        System.out.println(a3.length);
    }
}
