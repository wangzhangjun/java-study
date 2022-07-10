package com.zhjwang.test01;

public class Test {
    //这样实现不好的方式，是每次都要去增加if，改变代码
    public static void main(String[] args) {
        String str = "支付宝";
        if("支付宝".equals(str)) {   // 为什么不写成str.equals()，防止空指针，万一是str是空，就会抛出异常
            pay(new AliPay());
        }

        if("微信".equals(str)){
            pay(new WechatPay());
        }
    }

    public static void pay(Mtwm m) {
        m.payOnline();
    }
}
