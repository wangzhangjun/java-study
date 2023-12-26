package OO.singlatoneAndInnerClass

class Test {
    val I = "AAAA"
    // 在kotlin中这个不是一个内部类，所有拿不到外部类的成员
    // 这个叫嵌套类:可以在类的里面再写一个类，但是这个类和外部类不交换数据
    class Sub {
        fun show() {
            //println(I) 出错，拿不到
            println("Sub()")
        }
        class A {
            class B {
                class C {
                }
            }
        }
    }

    // 这个才是内部类
    inner class Sub2 {
        fun show() {
            println(I)
        }
    }
}

fun main() {
    val test = Test.Sub()
    test.show()
    val test2 = Test().Sub2()  // inner class
    test2.show();
}