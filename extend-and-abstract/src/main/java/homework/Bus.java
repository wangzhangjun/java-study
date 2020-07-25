package homework;

public class Bus extends Vehicle{

    private int seatCount;

    public Bus() {

    }

    public Bus(int no, String brand, int seatCount) {
        super(no, brand);
        this.seatCount = seatCount;
    }

    @Override
    public int calcRent(int days) {
        if(seatCount > 16){
            return 1500 * days;
        }else{
            return 800 * days;
        }
    }
}
