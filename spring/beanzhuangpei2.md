# 装配bean2


### 1.自动装配bean的属性
有五种方式：

![](.png)

**自动装配的原理：**

byName:根据属性的名字自动装配，会自动扫描属性名字。

byType:按照类型查找bean,如果有多个，就会抛出异常

constructor:
