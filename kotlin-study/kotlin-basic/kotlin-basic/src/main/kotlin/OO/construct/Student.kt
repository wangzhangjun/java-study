package OO.construct

class Student(id: Int) : // Person() // 这种写法是调用无参的次构造
    Person(id) // 这个就是主构造了，其实就是构造函数的重载
{
    //再Kotlin 全部都是没有默认值的，而Java 成员有默认值，但是方法内部没有默认值
    lateinit var name : String  // lateinit懒加载，必须是var。如果没有赋值就不能使用，使用的时候会报错
    var age: Int = 0
}