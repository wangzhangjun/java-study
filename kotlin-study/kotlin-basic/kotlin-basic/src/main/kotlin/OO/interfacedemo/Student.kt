package OO.interfacedemo

class Student : Person() {
    override fun getLayoutID(): Int = 888
    override fun initView() { }
    override fun callbackMethod(): Boolean  = false
}