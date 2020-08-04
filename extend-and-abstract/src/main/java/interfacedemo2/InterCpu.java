package interfacedemo2;

public class InterCpu implements Cpu {

    @Override
    public String getBrand() {
        return  "Inter";
    }

    @Override
    public String getHZ() {
        return "1.2G";
    }
}
