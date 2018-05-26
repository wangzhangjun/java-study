# Mac上直接将excel数据导入到mysql中

## 1.从命令行进入到mysql

```text
mysql -u root -p
```

## 2.创建数据库

```text
create database project;
use project;
```

## 3.新建一个表，这个表要和你的excel中的数据对应

```text
create table 11_apply
    -> (
    -> province char(8) primary key, invent int, practical int, aspect int, total int
    -> );
```

## 4.下面就是进行excel数据导入

* 1.将原有的excel另存为csv的格式。

![Optional title](../.gitbook/assets/clipboard_20180313_174245.png)

* 2.删除没用的标题栏，只留数据
* 3.导入数据

  ```text
  load data local infile "/Users/zhjwang/11a.csv" into table 11_applyf_apply fields terminated by "," lines terminated by "\r\n";
  ```

  逗号表示csv文件是以“，”分割的，lines terminated by "\r\n";表示csv文件是以这个换行的。

**注意：可能出错** 

```text
ERROR 1045 (28000): Access denied for user 'user'@'localhost' (using password: YES)
使用这个解决：mysql --local-infile -u user -p
```

如果出现ok，就表示成功。可以使用`select * from tableName`来查看是否导入正确。

