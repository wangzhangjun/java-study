package extend;

public class Penguin extends Pet {

    public Penguin() {
        System.out.println("Penguin的无参构造方法");
    }

    @Override
    public String toString() {
        return "Penguin's toString";
    }
}
