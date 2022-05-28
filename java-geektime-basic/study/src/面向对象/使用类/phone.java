package 面向对象.使用类;

public class phone {
    screen scre;
    mainboard mb;
    double price;
    boolean hasFigurePrintUnlocker;

    phone ph;  //在类中包含自己，为什么是可以的？因为编译时可以找到Phone。所以编译不报错
}
