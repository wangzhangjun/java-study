package OO.interfacedemo

// 默认是 public final class Person 不能被人家继承的。
// abstract有open的特征 相当于open
abstract class Person : Callback {
    abstract fun getLayoutID() : Int
    abstract fun initView()
}