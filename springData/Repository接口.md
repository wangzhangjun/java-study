# Repository接口

public interface JpaRepository<T, ID extends Serializable>

T表示你要对哪个实体类进行处理，第二个参数表示第一个参数中的ID的类型。
这个接口是一个空的接口，当我们extends的时候表示的是我们的接口被spring容器管理了起来。


### 1.Repository接口的子接口
* CrudRepository的子接口：继承了Repository,实现了一些基本的CRUD相关方法，如果我们想使用的话，只需要extends这个接口就可以了。

* PagingAndSortingRepository:继承了CrudRepository，实现了分页排序相关的方法。

* JpaRepository：继承了PagingAndSortingRepository，实现了JPA规范的相关方法。

### 2.查询方法约定
![](assets/markdown-img-paste-20180523231636995.png)
![](assets/markdown-img-paste-20180523231651236.png)
