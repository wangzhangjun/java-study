package OO.construct

fun main() {
    val person = Person() // 次构造
    val person2 = Person(6465) // 主构造
    Person(464, "Derry") // 次构造
    Person(464, 'M') // 次构造
}