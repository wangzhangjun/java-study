package fanxing.jiekou;

public class Apple2<T, E> implements Generator<T> {

    private T key;
    private E value;

    public Apple2(T key, E value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public T getKey() {
        return key;
    }

    public  E getValue(){
        return value;
    }
}
