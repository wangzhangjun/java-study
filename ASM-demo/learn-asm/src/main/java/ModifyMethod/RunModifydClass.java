package ModifyMethod;
import java.lang.reflect.Method;

public class RunModifydClass {
    // 测试是否修改成功
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("ModifyMethod.HelloWorld");
        Method m = clazz.getDeclaredMethod("test");
        Method m2 = clazz.getDeclaredMethod("test2");

        Object instance = clazz.newInstance();
        Object instance2 = clazz.newInstance();

        m.invoke(instance);
        System.out.println("===========================");
        m2.invoke(instance2);
    }
}
