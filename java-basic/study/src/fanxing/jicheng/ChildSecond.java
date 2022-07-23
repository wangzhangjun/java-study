package fanxing.jicheng;

//当继承的子类不是泛型的时候，要指明继承父类的泛型类型
public class ChildSecond extends Parent<String>{

    @Override
    public void setValue(String value) {
        super.setValue(value);
    }

    @Override
    public String getValue() {
        return super.getValue();
    }
}
