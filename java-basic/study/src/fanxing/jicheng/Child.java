package fanxing.jicheng;

//注意，继承时泛型的标志一定和父类的一样
/*
* 如果子类也是泛型的 ，那么子类的泛型标志要和父类一致
* */
public class Child<T> extends Parent<T> {

    @Override
    public T getValue() {
        return super.getValue();
    }
}
