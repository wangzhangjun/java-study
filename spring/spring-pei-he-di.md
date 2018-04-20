# spring配合DI

spring开发提倡接口编程，更能体现程序之间的解耦。

## 1.体验spring的di配合接口编程的，完成一个字母大小写转换的案例：

**思路：** 1. 创建一个接口 2. 两个类实现接口 3. 把对象配置到spring容器中。 4. 使用

### 1.1.定义一个接口

```text
package com.study.spring.inter;

public interface ChangeLetter {

    //声明一个方法
    public String change();
}
```

### 1.2.两个实现类

```text
package com.study.spring.inter;

public class LowerLetter implements ChangeLetter {

    private String str;

    public String change(){
        //把小写转换成大写
        return str.toLowerCase();
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
```

```text
package com.study.spring.inter;

public class UpperLetter implements ChangeLetter {

    private String str;

    public String change(){
        //把小写转换成大写
        return str.toUpperCase();
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
```

这个时候进行configution

```text
    @Bean
    public ChangeLetter changeLetter(){
//        LowerLetter lowerLetter = new LowerLetter();
//        lowerLetter.setStr("ABC");
//        return lowerLetter;
        UpperLetter upperLetter = new UpperLetter();
        upperLetter.setStr("abc");
        return upperLetter;
    }
```

然后去使用

```text
ChangeLetter changeLetter = ac.getBean(ChangeLetter.class);
System.out.println(changeLetter.change());
```

你会发现只要改了这边的@Bean中的配置，调用地方的代码不用做任何改变，就可以实现调用不同的bean。

