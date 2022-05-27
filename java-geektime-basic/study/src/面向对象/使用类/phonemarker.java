package 面向对象.使用类;

public class phonemarker {
    public static void main(String[] args) {
        phone ph = new phone();
        ph.price = 1.2;
        ph.hasFigurePrintUnlocker = true;
        ph.scre = new screen();
        ph.scre.producer = "京东";
        ph.scre.size = 6.6;

        mainboard mb = new mainboard();
        mb.model = "8888";
        mb.year = 1234;

        mb.cp = new cpu();
        mb.cp.producer = "德州";
        mb.cp.speed = 1.2;

        mb.me = new memory();
        mb.me.producer = "三星";
        mb.me.capacity = 4;

        mb.st = new storage();
        mb.st.producer = "inter";
        mb.st.capacity = 345;
    }
}
