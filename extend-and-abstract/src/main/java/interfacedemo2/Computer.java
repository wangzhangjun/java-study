package interfacedemo2;

public class Computer implements Cpu,Memory,Disk {

    public void show(Cpu cpu,Disk hardDisk){
        System.out.println("计算机的组成如下：");
        System.out.println("cpu:"+cpu.getBrand()+"  ,主频是："+cpu.getHZ());
        System.out.println("硬盘容量是："+hardDisk.getVolumn());
    }

    @Override
    public String getBrand() {
        return null;
    }

    @Override
    public String getHZ() {
        return null;
    }

    @Override
    public String getVolumn() {
        return null;
    }

    @Override
    public String getCapacity() {
        return null;
    }
}
