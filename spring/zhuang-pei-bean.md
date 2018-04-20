# 装配bean

在spring容器内拼凑bean叫做装配，装配bean的时候，需要告诉容器哪些bean以及容器如何使用依赖注入将它们配合在一起。

有两种装配的方式：

* 1.XML方式。
* 2.Java代码方式

## 1.基本装配

使用原型bean可能对性能产生影响，尽量不要使用prototype.除非有必要。尽量使用singleton。

## 2.如何给集合类型注入属性

Java中主要的集合有：map,set,list,collection. list可以有相同的集合，但是set不能有相同的。

**注意：** collection col = new ArrayList\(\);这个col只能使用左边的方法。

例如有个bean是员工

```text
package com.study.spring.zhuangbean;

public class Employee {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

然后有个类包好了Employee的一个list

```text
public class Department {

    private String name;

    private String [] EmpName;

//    @Autowired(和下面的是同样的效果),要不使用注入，要么使用@Resource
//    private List<Employee> employeeList;

    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Resource(name = "employeeList")
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
```

配置bean

```text
    @Bean
    public Employee employee1(){
        Employee employee1 = new Employee();
        employee1.setName("em1");
        return employee1;
    }

    @Bean
    public Employee employee2(){
        Employee employee2 = new Employee();
        employee2.setName("em2");
        return employee2;
    }

    @Bean
    public List<Employee> employeeList(){
        List<Employee> eList = new ArrayList<>();
        eList.add(employee1());
        eList.add(employee2());
        return eList;
    }
```

## 3.如何注入map\(使用resource的方法\)

```text
public class Department {

    private String name;

    private String [] EmpName;

    @Resource(name="getMapEmployee")
    private Map<String, Employee> stringEmployeeMap;

    public Map<String, Employee> getStringEmployeeMap() {
        return stringEmployeeMap;
    }

    public void setStringEmployeeMap(Map<String, Employee> stringEmployeeMap) {
        this.stringEmployeeMap = stringEmployeeMap;
    }
```

在配置代码中进行配置

```text
@Bean
public Map<String , Employee> getMapEmployee(){
    Map<String, Employee> configMap = new HashMap<>();
    configMap.put("map1", employee1());
    configMap.put("map2", employee2());
    return configMap;
}
```

## 4.内部bean

## 5.继承装配

在spring中，如果你使用的是beans.xml文件进行配置的话，使用parent关键字进行配置即可

```text
<bean id="animal" class="com.concretepage.Animal" init-method="initA">
  <property name="name" value="Hathi"/>
  <property name="age" value="20"/>
</bean>
<bean id="elephant" class="com.concretepage.Elephant" parent="animal" init-method="initE">
  <property name="age" value="30"/>
  <property name="location" value="Varanasi"/>
</bean>
```

如果你想使用纯Java代码进行配置，那么好像没有一个类似于@parent的东西，但是可以使用如下方法

```text
package com.study.spring.inherit;

public class Student {

    private int age;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

继承

```text
package com.study.spring.inherit;

public class Grad extends Student{

    private String degree;

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }


}
```

配置

```text
package com.study.spring.inherit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InheritConfigution {

    @Bean
    public Student student(){
        Student student = new Student();
        initStudent(student);
        return student;
    }

    @Bean
    public Grad grad(){
        Grad grad = new Grad();
        initStudent(grad);
        grad.setDegree("小学");
        return  grad;
    }

    public void initStudent(Student student){
        student.setName("张三");
        student.setAge(145);
    }
}
```

访问

```text
ApplicationContext ac = new AnnotationConfigApplicationContext(InheritConfigution.class);

 Grad grad = ac.getBean(Grad.class);
 System.out.println(grad.getDegree());
 System.out.println(grad.getAge());
 System.out.println(grad.getName());
```

