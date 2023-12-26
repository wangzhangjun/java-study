package OO.ObjectAndData

fun main() {
    val user = UserData(99, "lisi", 'M')
    println(user.sex) // 这就是data class自动生成的get方法
    println(user.name)
    println(user.id)

    val(myID, myName, mySex) = user.copy() // copy 方法
    println("myID:$myID, myName:$myName, mySex:$mySex")

    //_代表不接收，只会copy第二个元素
    val(_, myName2, _) = user.copy()
    println("myName2:$myName2")

    // 加了object，就是单例，不会new多次，可以直接调用
    MyEngine.m()
    MyEngine.m()
    MyEngine.m()
    MyEngine.m()
    MyEngine.m()
}