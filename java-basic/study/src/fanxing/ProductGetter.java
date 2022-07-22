package fanxing;

import java.util.ArrayList;
import java.util.Random;

public class ProductGetter<T> {

    private  T produt;
    ArrayList<T> list = new ArrayList<>();

    public  void AddProduct(T t) {
        list.add(t);
    }

    public T GetProduct(){
        return list.get(new Random().nextInt(list.size()));
    }
}
