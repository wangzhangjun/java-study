package OO.construct

// public final class Person 默认就是这样的，不能被继承，可以加open就可以被人家继承了
open class Person(id: Int) // 主构造
{
    // 次构造，必须要调用主构造（this(id)）
    constructor(id: Int, name: String) : this(id) {}
    // 次构造,必须要调用主构造（this(id)）
    constructor(id: Int, sex: Char) : this(id) {}
    // 次构造,必须要调用主构造（this(id)）
    constructor() : this(787) {}
}