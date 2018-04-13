# java中的枚举的使用方法(枚举是啥)

### 1.第一种使用方法
```
public enum Color {  
  RED, GREEN, BLANK, YELLOW  
}
```
一般用在switch方法中
```
enum Signal {  
    GREEN, YELLOW, RED  
}  
public class TrafficLight {  
    Signal color = Signal.RED;  
    public void change() {  
        switch (color) {  
        case RED:  
            color = Signal.GREEN;  
            break;  
        case YELLOW:  
            color = Signal.RED;  
            break;  
        case GREEN:  
            color = Signal.YELLOW;  
            break;  
        }  
    }  
}

```
### 2.如果你希望自己可以定义枚举的index,你需要添加get和set方法，但是需要注意在enum实例的最后添加一个分号，而且java必须要求先定会枚举
```
package main.java;

public enum Country {
    Canada("Canada", 1),
    UK("UK", 2),
    USA("USA", 3),
    Germany("GERMANY", 4),
    France("France", 5),
    Italy("Italy", 6);

    private String name;
    private int index;


    private Country(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
  }
```
注意这个时候，构造器只能是private的，绝对不允许是public的，这样可以保证外部代码无法新构造枚举类的实例。这也是完全符合情理的，因为我们知道枚举值是public static final的常量而已。 但枚举类的方法和数据域可以允许外部访问。如何使用
```
        Country country = new Country("dfs", 2);//wrong
        Country country = Country.Canada;
        country.setIndex(10);
        System.out.println(country.getIndex());
```
### 3.覆盖枚举的方法
```
public enum Color {  
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);  
    // 成员变量  
    private String name;  
    private int index;  
    // 构造方法  
    private Color(String name, int index) {  
        this.name = name;  
        this.index = index;  
    }  
    //覆盖方法  
    @Override  
    public String toString() {  
        return this.index+"_"+this.name;  
    }  
}

```
### 4.枚举实现接口
```
public interface Behaviour {  
    void print();  
    String getInfo();  
}  
public enum Color implements Behaviour{  
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);  
    // 成员变量  
    private String name;  
    private int index;  
    // 构造方法  
    private Color(String name, int index) {  
        this.name = name;  
        this.index = index;  
    }  
//接口方法  
    @Override  
    public String getInfo() {  
        return this.name;  
    }  
    //接口方法  
    @Override  
    public void print() {  
        System.out.println(this.index+":"+this.name);  
    }  
}  
```
