# java继承中的构造方法
### 1.继承中构造方法的关系
```
/*
	继承中构造方法的关系
		A:子类中所有的构造方法默认都会访问父类中  ```空参数```  的构造方法
		B:为什么呢?
			因为子类会继承父类中的数据，可能还会使用父类的数据。
			所以，子类初始化之前，一定要先完成父类数据的初始化。

			注意：子类每一个构造方法的第一条语句默认都是：super();
*/
class Father {
	int age;

	public Father() {
		System.out.println("Father的无参构造方法");
	}

	public Father(String name) {
		System.out.println("Father的带参构造方法");
	}
}

class Son extends Father {
	public Son() {
		//super();
		System.out.println("Son的无参构造方法");
	}

	public Son(String name) {
		//super();
		System.out.println("Son的带参构造方法");
	}
}

class ExtendsDemo6 {
	public static void main(String[] args) {
		//创建对象
		Son s = new Son();
		System.out.println("------------");
		Son s2 = new Son("林青霞");
	}
}
```

### 2.继承中构造方法的注意事项
```
/*
	如果父类没有无参构造方法，那么子类的构造方法会出现什么现象呢?
		报错。注意系统会默认的给一个无参构造函数
	如何解决呢?
		A:在父类中加一个无参构造方法
		B:通过使用super关键字去显示的调用父类的带参构造方法
		C:子类通过this去调用本类的其他构造方法
			子类中一定要有一个去访问了父类的构造方法，否则父类数据就没有初始化。例如下面的this首先会去访问Son的无参构造函数，在Son的无参构造函数中会去调用父类的构造

	注意事项：
		this(...)或者super(...)必须出现在第一条语句上。
		如果不是放在第一条语句上，就可能对父类的数据进行了多次初始化，所以必须放在第一条语句上。
*/
class Father {
	/*
	public Father() {
		System.out.println("Father的无参构造方法");
	}
	*/

	public Father(String name) {
		System.out.println("Father的带参构造方法");
	}
}

class Son extends Father {
	public Son() {
		super("随便给");
		System.out.println("Son的无参构造方法");
		//super("随便给");
	}

	public Son(String name) {
		//super("随便给");
		this();
		System.out.println("Son的带参构造方法");
	}
}

class ExtendsDemo7 {
	public static void main(String[] args) {
		Son s = new Son();
		System.out.println("----------------");
		Son ss = new Son("林青霞");
	}
}
```

### 3.继承中成员方法的关系
```
/*
	继承中成员方法的关系:
		A:子类中的方法和父类中的方法声明不一样，这个太简单。
		B:子类中的方法和父类中的方法声明一样，这个该怎么玩呢?
			通过子类对象调用方法：
				a:先找子类中，看有没有这个方法，有就使用
				b:再看父类中，有没有这个方法，有就使用
				c:如果没有就报错。
*/
class Father {
	public void show() {
		System.out.println("show Father");
	}
}

class Son extends Father {
	public void method() {
		System.out.println("method Son");
	}

	public void show() {
		System.out.println("show Son");
	}
}

class ExtendsDemo8 {
	public static void main(String[] args) {
		//创建对象
		Son s = new Son();
		s.show();
		s.method();
		//s.fucntion(); //找不到符号
	}
}
```
