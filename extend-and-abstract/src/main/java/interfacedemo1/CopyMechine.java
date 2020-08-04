package interfacedemo1;

public class CopyMechine implements InkBox,Paper{

    @Override
    public void getColor() {
        System.out.println("使用彩色墨盒打印");
    }

    @Override
    public void getWriteAndBlock() {
        System.out.println("使用黑白墨盒打印");
    }

    @Override
    public void getA4() {
        System.out.println("使用A4纸打印");
    }

    @Override
    public void getA5() {
        System.out.println("使用A5纸打印");
    }

    public static void main(String[] args) {
        CopyMechine copyMechine = new CopyMechine();
        copyMechine.getWriteAndBlock();
        copyMechine.getA4();
    }
}
