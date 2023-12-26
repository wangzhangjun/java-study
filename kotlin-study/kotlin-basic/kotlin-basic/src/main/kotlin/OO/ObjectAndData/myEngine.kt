package OO.ObjectAndData

// 加了object就相当于单例，只实例化一次，使用的地方直接MyEngine.show()
object MyEngine {
    fun m() {
        println("M run")
    }
    fun show() {
        println("我就只有一个实例")
    }
}