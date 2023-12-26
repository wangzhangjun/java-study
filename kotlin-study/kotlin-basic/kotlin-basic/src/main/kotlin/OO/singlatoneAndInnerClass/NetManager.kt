package OO.singlatoneAndInnerClass

class NetManager {
    // 只有一个实例
    object Holder {
        val instance = NetManager()
    }
    companion object { //相当于 Java static，是不能访问外部的变量的，staic必须访问static的成员变量
        fun getInstance() : NetManager = Holder.instance
    }
    fun show(name: String) {
        println("show:$name");
    }
}

// 客户端
fun main() {
    val net  = NetManager.getInstance()  // 直接调用
    net.show("kt Derry1")
}