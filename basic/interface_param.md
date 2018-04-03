# 接口做函数形参
接口做函数参数时，可以转换成实现其接口的类
```
package bester;

public interface BesterTable {
    public boolean isBetterThan(BesterTable bester);
}

```
```
package bester;

public class Rectangle implements BesterTable{
    private double length;
    private double breadth;

    public Rectangle(double breadth, double length) {
        this.breadth = breadth;
        this.length = length;
    }

    public double area() {
        return length * breadth;
    }

    @Override
    public boolean isBetterThan(BesterTable bester) {
        return this.area() > ((Rectangle)bester).area();
    }
}

```
