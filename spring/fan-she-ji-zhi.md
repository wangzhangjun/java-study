# 反射机制

spring之所以做的这么简单易用，其本质都是通过反射机制来完成的。那么什么是Java的反射机制。

Java反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；这种动态获取的信息以及动态调用对象的方法的功能称为Java语言的反射机制。

发射机制的作用：

1.反编译.class-&gt;.Java 2.通过放射机制获取java对象的属性和方法。

发射机制的实现

```text
public class Constomer {
    private int id;
    private String name;

//    public Constomer(){} jvm会自动为你添加无参的构造方法

    public Constomer(String name, int id){

        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

下面通过发射机制来获取Constomer类的属性和方法

```text
import  java.lang.reflect.Method;

import java.lang.reflect.Field;

public class TestRelfect {

    //获取constomer类中的属性和get,set方法
    public static void getProperty(){

        try{
            Class<?> classType = Class.forName("Constomer");//获取对象类型(这里是包名下面的class，因为我没有建包)
            Field[] fileldNames = classType.getDeclaredFields();//通过反射获取到Constomer所有属性

            for(int i = 0; i < fileldNames.length; i++) {
                Field field = fileldNames[i];
                String fieldName = field.getName();
                System.out.println("所有属性为："+ fieldName);

                //将属性的第一个字母截取出来，并且大写化
                String firstLetter = fieldName.substring(0,1).toUpperCase();
                //拼接属性的get方法
                String getMethodName = "get" + firstLetter + fieldName.substring(1);
                //拼接属性的set方法
                String setMethodName = "set" +  firstLetter + fieldName.substring(1);

                //获取get方法
                Method getMethod = classType.getMethod(getMethodName, new Class[]{}); //第二个参数表示的是该方法参数的对象类型
                //获取set方法
                Method setMethod = classType.getMethod(setMethodName, new Class[]{field.getType()}); //第二个参数方法参数的对象类型，每次的类型不一样

                //通过反射新建一个对象
                //相当于调用了有参的构造方法
                Object object = classType.getConstructor(
                        new Class[]{String.class, int.class})
                        .newInstance(new Object[]{"张三", 14});
                //执行get方法
                Object value = getMethod.invoke(object, new Object[]{});
                System.out.println("执行"+ getMethodName + "方法之后的结果是： " + value);

                //执行set方法
                setMethod.invoke(object, new Object[]{value});
                System.out.println("执行"+ setMethodName);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //获取本类的方法
    public static void invokeMethod(){

        //获取本类的对象方法
        Class<?> classType = TestRelfect.class;
        Method method = classType.getMethod("add", new Class[]{int.class, int.class});
    }

    public int add(int num1, int num2){
        return num1 + num2;
    }

    public static void main(String args[]){
        getProperty();
    }
}
```

