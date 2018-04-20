# 接口的中使用泛型定义参数和返回值

## 1.接口的实现方式

1.接口用关键字interface表示 2.类实现接口用implements表示 3.接口不能实例化。（不能创建方法） 4.接口的子类（可以是抽象类，但是意义不大。一般是具体类，但是要具体类重写接口中的所有的方法）

```text
/定义动物培训接口
interface AnimalTrain {
    public abstract void jump();
}

//抽象类实现接口
abstract class Dog implements AnimalTrain {
}

//具体类实现接口
class Cat implements AnimalTrain {
    public void jump() {
        System.out.println("猫可以跳高了");
    }
}

class InterfaceDemo {
    public static void main(String[] args) {
        //AnimalTrain是抽象的; 无法实例化
        //AnimalTrain at = new AnimalTrain();
        //at.jump();

        AnimalTrain at = new Cat();
        at.jump();
    }
}
```

## 2.接口的成员特点

成员变量：

* 只能是常量，并且是静态的。
* 默认修饰符：public static final
* 建议手动给出

  构造方法：

* 接口没有构造方法

  成员方法：

* 只能是抽象方法。（没有方法体）
* 默认修饰符：public abstract
* 建议：自己手动指明

所有的类都默认继承自一个类：object.

```text
interface Inter {
    public int num = 10;
    public final int num2 = 20;
    public static final int num3 = 30;

    //错误: 需要<标识符>
    //public Inter() {}

    //接口方法不能带有主体
    //public void show() {}

    //abstract void show(); //默认public
    public void show(); //默认abstract
}

//接口名+Impl这种格式是接口的实现类格式
/*
class InterImpl implements Inter {
    public InterImpl() {
        super();
    }
}
*/

class InterImpl extends Object implements Inter {
    public InterImpl() {
        super();
    }

    public void show() {}
}

//测试类
class InterfaceDemo2 {
    public static void main(String[] args) {
        //创建对象
        Inter i = new InterImpl();
        System.out.println(i.num);
        System.out.println(i.num2);
        //i.num = 100;
        //i.num2 = 200;
        //System.out.println(i.num); //无法为最终变量num分配值
        //System.out.println(i.num2);//无法为最终变量num2分配值
        System.out.println(Inter.num);
        System.out.println(Inter.num2);
        System.out.println("--------------");
    }
}
```

## 3.类，接口之间的关系

类与类：

* 继承关系，只能单继承，可以多层继承。

类与接口：

* 实现关系，可以单实现，也可以多实现。并且还可以在继承一个类的同时实现多个接口。

接口与接口：

* 继承关系，可以单继承，也可以多继承。

```text
interface Father {
    public abstract void show();
}

interface Mother {
    public abstract void show2();
}

interface Sister extends Father,Mother {

}

//class Son implements Father,Mother //多实现
class Son extends Object implements Father,Mother {
    public void show() {
        System.out.println("show son");
    }

    public void show2() {
        System.out.println("show2 son");
    }
}

class InterfaceDemo3 {
    public static void main(String[] args) {
        //创建对象
        Father f = new Son();
        f.show();
        //f.show2(); //报错

        Mother m = new Son();
        //m.show(); //报错
        m.show2();
    }
}
```

## 2.返回值和参数指定为可变的

```text
package bester;

import java.util.List;

public interface GetBester<T> {

    public T getBester(List<T> list);
}
```

```text
@Override
     public Cookie getBester(List<Cookie> cookieList) {
             int besterIndex = 0;
             int besterNumberOfChocolateChips = 0;
             for(int i = 0; i < cookieList.size(); i++){
                     if(cookieList.get(i).numberOfChocolateChips > besterNumberOfChocolateChips){
                             besterIndex = i;
                             besterNumberOfChocolateChips = cookieList.get(i).numberOfChocolateChips;
                     }
             }
             return cookieList.get(besterIndex);
     }
```

