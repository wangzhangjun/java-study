package fanxing;

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
    }
}
