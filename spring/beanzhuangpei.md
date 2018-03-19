# 装配bean

在spring容器内拼凑bean叫做装配，装配bean的时候，需要告诉容器哪些bean以及容器如何使用依赖注入将它们配合在一起。

有两种装配的方式：
* 1.XML方式。
* 2.Java代码方式

###  1.基本装配
使用原型bean可能对性能产生影响，尽量不要使用prototype.除非有必要。尽量使用singleton。
