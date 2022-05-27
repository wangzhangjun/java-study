package 面向对象.类和对象;

public class SuperMarket {
    public static void main(String[] args) {
        Merchandise m1 = new Merchandise();
        m1.name = "茉莉花茶包 20 包";
        m1.id = "000099518";
        m1.count = 1000;
        m1.price = 99.9;

        Merchandise m2 = new Merchandise();
        m2.name = "可口可乐 330ml";
        m2.id = "000099519";
        m2.count = 1000;
        m2.price = 3.0;

        // 卖出一个商品1
        int m1ToSold = 1;
        System.out.println("感谢购买" + m1ToSold + "个" + m1.name + "。商品单价为"
                + m1.price + "。消费总价为" + m1.price * m1ToSold + "。");
        m1.count -= m1ToSold;
        System.out.println(m1.id + "剩余的库存数量为" + m1.count);

        // 卖出3个商品2
        int m2ToSold = 3;
        System.out.println("感谢购买" + m2ToSold + "个" + m2.name + "。商品单价为"
                + m2.price + "。消费总价为" + m2.price * m2ToSold + "。");
        m2.count -= m2ToSold;
        System.out.println(m2.id + "剩余的库存数量为" + m2.count);
    }
}
