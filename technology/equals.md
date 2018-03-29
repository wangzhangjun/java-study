# java中equals方法和==

### 1.==操作
==一般用于对基础类型进行比较，such as:float,int.......当使用==对两个对象进行比较的时候，注意是比较两个对象的地址，如果地址相同则放回true，如果地址不同则返回false.

### 2.equals方法
equals()方法定义在Object类里面,主要依赖于如何进行重写。

### 3.总结
* 1.使用==比较原生类型如：boolean、int、char等等，使用equals()比较对象
* 2.==返回true如果两个引用指向相同的对象，equals()的返回结果依赖于具体业务实现
* 3.字符串的对比使用equals()代替==操作符。

### 4.assertEquals和assertSame的不同
assertEquals支持boolean,long,int等等java primitiveType变量。

assertSame只支持Object。

**较的逻辑不同，结果可能不同：**

assertEquals(Object A,  Object B) 的比较逻辑：
如果 A,B都是Null,返回true。否则调用 A.equals(B)来判断。

assertSame(Object A, Object B)的比较逻辑：
以A == B运算的结果来判断。
```
static publicvoid assertSame(String message, Object expected, Object actual) {  
    if (expected== actual)   
        return;   
    failNotSame(message, expected, actual);  
 }
```

**所以说assertEquals会调用equals方法，这个方法的重写会影响assertEquals的值，而assertSame只是==判断，即判断地址是否相等**

### 5.其他的单元测试断言
#### 5.1 assertTrue与assertFalse断言
assertTrue与assertFalse可以判断某个条件是真还是假，如果和预期的值相同则测试成功，否则将失败，assertTrue的定义如下：
```
staticpublic void assertTrue(String message, boolean condition) {  
    if (!condition)   
        fail(message);   
}  
```
“condition”表示要测试的状态，如果“condition”的值为false，则测试将会失败。
#### 5.2 assertNull与assertNotNull断言
assertNull与assertNotNull可以验证所测试的对象是否为空或不为空，如果和预期的相同则测试成功，否则测试失败，assertNull定义为：
```
staticpublic void assertNull(String message, Objectobject) {   
    assertTrue(message,object == null);  
 }
```
其中，object就是要测试的对对象，如果object为空，该测试成功，否则失败，是不是很简单。
