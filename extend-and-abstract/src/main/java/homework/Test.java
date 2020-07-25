package homework;

public class Test {

    public static void main(String[] args) {
        Car car = new Car(1,"宝马", 1);
        System.out.println(car.calcRent(2));

        Bus bus = new Bus(2,"金龙",17);
        System.out.println(bus.calcRent(2));
    }

}
