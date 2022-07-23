package fanxing;

import java.util.ArrayList;
import java.util.Random;

public class ProductGetter<T> {

    private  T produt;
    ArrayList<T> list = new ArrayList<>();

    public  void AddProduct(T t) {
        list.add(t);
    }

    public  T GetProduct(){
        return list.get(new Random().nextInt(list.size()));
    }


    //================================泛型方法
    public<E> E GetProduct(ArrayList<E> list) {
        return list.get(new Random().nextInt(list.size()));
    }

    /*
    * 下面这个方法有什么不一样呢？
    * 经过测试就可以发现，这就不是泛型方法。它是接收不了Int的Arraylist的。只能接收int类型的。
    * */
    public T GetProduct1(ArrayList<T> list) {
        return list.get(new Random().nextInt(list.size()));
    }

    //注意，类的一个成员方法如果使用了类定义的泛型（T），是不能声明为static的
    //所以静态方法必须是泛型方法
//    public static T GetProduct(){
//        return list.get(new Random().nextInt(list.size()));
//    }

    public static<T,E,K> void printType(T t, E e, K k) {
        System.out.println(t.getClass().getSimpleName());
        System.out.println(e.getClass().getSimpleName());
        System.out.println(k.getClass().getSimpleName());
    }


    //泛型可变参数
    public static <E> void print(E...e) {
        for(int i =0; i<e.length; i++) {
            System.out.println(e[i]);
        }
    }

}
