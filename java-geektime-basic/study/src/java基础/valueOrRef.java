package java基础;

import java.util.Arrays;

public class valueOrRef {
    public void SetString(String name) {
        System.out.println(String.class.getName() + "2@" + Integer.toHexString(System.identityHashCode(name))); //地址一样，但是没有改变，特例
        name = "456";
    }

    public void SetArray(int[] arr) {
        arr[0] = 1;
    }

    public static void main(String[] args) {
        String name = "123";
        valueOrRef v1 = new valueOrRef();
        v1.SetString(name);
        //string
        System.out.println(String.class.getName() + "1@" + Integer.toHexString(System.identityHashCode(name))); // 和SetString是一样的
        System.out.println(name);

        //array
        int[] arr1 = {4,2,3};
        System.out.println(Arrays.toString(arr1));
        v1.SetArray(arr1);
        System.out.println(Arrays.toString(arr1)); //会改变

        //总结：在java中一般对象（包括数组）作为参数是引用传递，但是字符串是被当做值传递（划重点）；基本类型变量当做值传递
    }
}
