# equals和hashcode方法

## 1.hashcode的作用

总的来说，hashCode\(\)在哈希表中起作用，如HashSet、HashMap等。

当我们向哈希表\(如HashSet、HashMap等\)中添加对象object时，首先调用hashCode\(\)方法计算object的哈希码，通过哈希码可以直接定位object在哈希表中的位置\(一般是哈希码对哈希表大小取余\)。如果该位置没有对象，可以直接将object插入该位置；如果该位置有对象\(可能有多个，通过链表实现\)，则调用equals\(\)方法比较这些对象与object是否相等，如果相等，则不需要保存object；如果不相等，则将该对象加入到链表中。

这也就解释了为什么equals\(\)相等，则hashCode\(\)必须相等。如果两个对象equals\(\)相等，则它们在哈希表\(如HashSet、HashMap等\)中只应该出现一次；如果hashCode\(\)不相等，那么它们会被散列到哈希表的不同位置，哈希表中出现了不止一次

## 2.hashcode应该重写的规则

* 如果重写了equals\(\)方法，检查条件“两个对象使用equals\(\)方法判断为相等，则hashCode\(\)方法也应该相等”是否成立，如果不成立，则重写hashCode \(\)方法。
* hashCode\(\)方法不能太过简单，否则哈希冲突过多。
* hashCode\(\)方法不能太过复杂，否则计算复杂度过高，影响性能。

## 3.如何重写

《Effective Java》中提出了一种简单通用的hashCode算法。

A、初始化一个整形变量，为此变量赋予一个非零的常数值，比如int result = 17;

B、选取equals方法中用于比较的所有域（之所以只选择equals\(\)中使用的域，是为了保证上述原则的第1条），然后针对每个域的属性进行计算：

* \(1\) 如果是boolean值，则计算f ? 1:0
* \(2\) 如果是byte\char\short\int,则计算\(int\)f
* \(3\) 如果是long值，则计算\(int\)\(f ^ \(f &gt;&gt;&gt; 32\)\)
* \(4\) 如果是float值，则计算Float.floatToIntBits\(f\)
* \(5\) 如果是double值，则计算Double.doubleToLongBits\(f\)，然后返回的结果是long,再用规则\(3\)去处理long,得到int
* \(6\) 如果是对象应用，如果equals方法中采取递归调用的比较方式，那么hashCode中同样采取递归调用hashCode的方式。否则需要为这个域计算一个范式，比如当这个域的值为null的时候，那么hashCode 值为0
* \(7\) 如果是数组，那么需要为每个元素当做单独的域来处理。java.util.Arrays.hashCode方法包含了8种基本类型数组和引用数组的hashCode计算，算法同上。

C、最后，把每个域的散列码合并到对象的哈希码中。

```text
@Override

public int hashCode() {

int hash = 17;

hash = hash * 31 + getName().hashCode();

hash = hash * 31 + getAge();

return hash;

}
```

