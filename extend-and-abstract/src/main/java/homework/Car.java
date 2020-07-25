package homework;

public class Car extends Vehicle {

    private int type;

    public Car() {

    }

    public Car(int no, String brand, int type){
        super(no ,brand);
        this.type = type;
    }

    @Override
    public int calcRent(int day) {
        if(type == 0){
            return 600 * day;
        }else if(type == 1){
            return 500 * day;
        }else if(type == 2){
            return 300 * day;
        }
        System.out.println("车型不匹配");
        return 0;
    }

}
