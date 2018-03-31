# java继承

### 1.继承中的注意事项
```
/*
	继承的注意事项：
		A:子类只能继承父类所有非私有的成员(成员方法和成员变量)
		B:子类不能继承父类的构造方法，但是可以通过super(马上讲)关键字去访问父类构造方法。
		C:不要为了部分功能而去继承
			class A {
				public void show1(){}
				public void show2(){}
			}

			class B {
				public void show2(){}
				public void show3(){}
			}

			//我们发现B类中出现了和A类一样的show2()方法，所以，我们就用继承来体现
			class B extends A {
				public void show3(){}
			}
			这样其实不好，因为这样你不但有了show2(),还多了show1()。
			有可能show1()不是你想要的。

	那么，我们什么时候考虑使用继承呢?
		继承其实体现的是一种关系："is a"。例如以下，苹果是水果的一种，香蕉也是水果的一种，就可以使用继承。
			Person
				Student
				Teacher
			水果
				苹果
				香蕉
				橘子

		采用假设法。
			如果有两个类A,B。只有他们符合A是B的一种，或者B是A的一种，就可以考虑使用继承。
*/
class Father {
	private int num = 10;
	public int num2 = 20;

	//私有方法，子类不能继承
	private void method() {
		System.out.println(num);
		System.out.println(num2);
	}

	public void show() {
		System.out.println(num);
		System.out.println(num2);
	}
}

class Son extends Father {
	public void function() {
		//num可以在Father中访问private
		//System.out.println(num); //子类不能继承父类的私有成员变量
		System.out.println(num2);
	}
}

class ExtendsDemo3 {
	public static void main(String[] args) {
		// 创建对象
		Son s = new Son();
		//s.method(); //子类不能继承父类的私有成员方法
		s.show();
		s.function();
	}
}
```

### 2.继承中的成员变量访问顺序呢
```
/*
	类的组成：
		成员变量：
		构造方法：
		成员方法：
	而现在我们又讲解了继承，所以，我们就应该来考虑一下，类的组成部分的各自关系。

	继承中成员变量的关系:
		A:子类中的成员变量和父类中的成员变量名称不一样，这个太简单。
		B:子类中的成员变量和父类中的成员变量名称一样，这个怎么玩呢?
			在子类方法中访问一个变量的查找顺序：
				a:在子类方法的局部范围找，有就使用
				b:在子类的成员范围找，有就使用
				c:在父类的成员范围找，有就使用
				d:如果还找不到，就报错。
*/
class Father {
	public int num = 10;

	public void method() {
		int num = 50;
	}
}

class Son extends Father {
	public int num2 = 20;
	public int num = 30;

	public void show() {
		int num = 40;
		System.out.println(num);
		System.out.println(num2);
		// 找不到符号
		System.out.println(num3);
	}
}

class ExtendsDemo4 {
	public static void main(String[] args) {
		//创建对象
		Son s = new Son();
		s.show();
	}
}
```

### 3.super关键字的使用
```
/*
	问题是：
		我不仅仅要输出局部范围的num，还要输出本类成员范围的num。怎么办呢?
		我还想要输出父类成员范围的num。怎么办呢?
			如果有一个东西和this相似，但是可以直接访问父类的数据就好了。
			恭喜你，这个关键字是存在的：super。

	this和super的区别?
		分别是什么呢?
			this代表本类对应的引用。
			super代表父类存储空间的标识(可以理解为父类引用,可以操作父类的成员)

		怎么用呢?
			A:调用成员变量
				this.成员变量 调用本类的成员变量
				super.成员变量 调用父类的成员变量
			B:调用构造方法
				this(...)	调用本类的构造方法
				super(...)	调用父类的构造方法
			C:调用成员方法
				this.成员方法 调用本类的成员方法
				super.成员方法 调用父类的成员方法
*/
class Father {
	public int num = 10;
}

class Son extends Father {
	public int num = 20;

	public void show() {
		int num = 30;
		System.out.println(num);
		System.out.println(this.num);
		System.out.println(super.num);
	}
}

class ExtendsDemo5 {
	public static void main(String[] args) {
		Son s = new Son();
		s.show();
	}
}
```
