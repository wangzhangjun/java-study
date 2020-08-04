package interfacedemo2;

public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Cpu cpu = new InterCpu();
        Disk hardDisk =  new JSDHardDisk();
        computer.show(cpu,hardDisk);
    }
}
