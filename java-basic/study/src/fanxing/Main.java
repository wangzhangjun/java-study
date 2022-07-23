package fanxing;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ProductGetter<String> stringProductGetter = new ProductGetter<>();
        String[] str = {"apple", "hauewi", "rongyao"};
        for (int i = 0; i < str.length; i++) {
            stringProductGetter.AddProduct(str[i]);
        }

        System.out.println(stringProductGetter.GetProduct());

        System.out.println("============================");

        //注意，泛型是不能指定为基础类型的，比如int, long等
        ProductGetter<Integer> integerProductGetter = new ProductGetter<>();
        int[] intArry = {1000, 500, 5000,900};
        for (int i = 0; i < intArry.length; i++) {
            integerProductGetter.AddProduct(intArry[i]);
        }

        System.out.println(integerProductGetter.GetProduct());

        System.out.println("=============泛型方法=============");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("apple");
        arrayList.add("huawei");
        arrayList.add("chuanyin");
        System.out.println(stringProductGetter.GetProduct(arrayList));

        //这就是泛型方法的好处，虽然stringProductGetter这个类是实例化为String类型的。
        //但是我还是可以传进去int的
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(100);
        arrayList1.add(300);
        arrayList1.add(400);
        System.out.println(stringProductGetter.GetProduct(arrayList1));


        System.out.println("===========静态泛型方法===============");
        ProductGetter.printType(100, "jva", true);

        System.out.println("===============可变参数==============");
        ProductGetter.print(1,2,3,4,5,"string");


    }
}
