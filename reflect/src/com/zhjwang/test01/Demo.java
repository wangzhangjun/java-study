package com.zhjwang.test01;

import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) throws Exception {
        String str = "com.zhjwang.test01.AliPay";  //这个一般是前端传过来的

        Class cls = Class.forName(str);
        Object o = cls.getDeclaredConstructor().newInstance();
        Method me = cls.getMethod("payOnline");
        me.invoke(o);
    }
}
