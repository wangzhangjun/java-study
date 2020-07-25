package homework;

public abstract class Vehicle {

    private int no;
    private String brand;

    public Vehicle() {
    }

    //抽象类中的构造方法只是为了给子类调用，并不能构造一个对象
    public Vehicle(int no,String brand) {
        this.brand = brand;
        this.no = no;
    }

    public abstract int calcRent(int day);
}
