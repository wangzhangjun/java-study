# final关键字

### 1.final关键字的引入
```
/*
	继承的代码体现

	由于继承中方法有一个现象：方法重写。
	所以，父类的功能，就会被子类给覆盖调。
	有些时候，我们不想让子类去覆盖掉父类的功能，只能让他使用。
	这个时候，针对这种情况，Java就提供了一个关键字：final

	final:最终的意思。常见的是它可以修饰类，方法，变量。
*/
class Fu {
	public final void show() {
		System.out.println("这里是绝密资源,任何人都不能修改");
	}
}

class Zi extends Fu {
	// Zi中的show()无法覆盖Fu中的show()
	public void show() {
		System.out.println("这是一堆垃圾");
	}
}

class ZiDemo {
	public static void main(String[] args) {
		Zi z = new Zi();
		z.show();
	}
}
```

### 2.final关键字的特点
```
/*
	final可以修饰类，方法，变量

	特点：
		final可以修饰类，该类不能被继承。
		final可以修饰方法，该方法不能被重写。(覆盖，复写)
		final可以修饰变量，该变量不能被重新赋值。因为这个变量其实常量。

	常量：
		A:字面值常量
			"hello",10,true
		B:自定义常量
			final int x = 10;
*/

//final class Fu //无法从最终Fu进行继承

class Fu {
	public int num = 10;
	public final int num2 = 20;

	/*
	public final void show() {

	}
	*/
}

class Zi extends Fu {
	// Zi中的show()无法覆盖Fu中的show()
	public void show() {
		num = 100;
		System.out.println(num);

		//无法为最终变量num2分配值
		//num2 = 200;
		System.out.println(num2);
	}
}

class FinalDemo {
	public static void main(String[] args) {
		Zi z = new Zi();
		z.show();
	}
}
```
### 3.final修饰局部变量
```
/*
	面试题：final修饰局部变量的问题
		基本类型：基本类型的值不能发生改变。
		引用类型：引用类型的地址值不能发生改变，但是，该对象的堆内存的值是可以改变的。
*/
class Student {
	int age = 10;
}

class FinalTest {
	public static void main(String[] args) {
		//局部变量是基本数据类型
		int x = 10;
		x = 100;
		System.out.println(x);
		final int y = 10;
		//无法为最终变量y分配值
		//y = 100;
		System.out.println(y);
		System.out.println("--------------");

		//局部变量是引用数据类型
		Student s = new Student();
		System.out.println(s.age);
		s.age = 100;
		System.out.println(s.age);
		System.out.println("--------------");

		final Student ss = new Student();
		System.out.println(ss.age);
		ss.age = 100;
		System.out.println(ss.age);

		//重新分配内存空间
		//无法为最终变量ss分配值
		ss = new Student();
	}
}
```

### 4.final变量初始化的时机
```
/*
	final修饰变量的初始化时机
		A:被final修饰的变量只能赋值一次。
		B:在构造方法完毕前。(非静态的常量)
*/
class Demo {
	//int num = 10;
	//final int num2 = 20;

	int num;
	final int num2;

	{
		//num2 = 10;
	}

	public Demo() {
		num = 100;
		//无法为最终变量num2分配值
		num2 = 200;
	}
}

class FinalTest2 {
	public static void main(String[] args) {
		Demo d = new Demo();
		System.out.println(d.num);
		System.out.println(d.num2);
	}
}
```
