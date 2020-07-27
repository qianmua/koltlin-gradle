

# mysql 索引 原理

    添加 索引
    alter table users_info add index xxx(filds)
    
> 做了什么？ 本质 是什么？

    索引 是一个 特殊 的 数据解构 ， 放在 磁盘中的 占地较大
    
    like 效率低？ 创建 全文 索引
    fulltext key 'xxx'(xxx)
    ....
    
> 二分 查找
    
    折半 ， 对有序 数组 查找 效率搞
    
>    二叉查找树
 
    左树 < root
    右数 > root
    最坏 情况 变成 单链表
    
>    平衡二叉查找树 （AVL）    
 
    左右 树 深度 差 绝对值 不超过1    
    超过 - 左旋 / 右旋
    节点 包含 数据引用地址 ， 左右节点指针
    //
    问题 树高 / 磁盘io 高
     
>    减低树高 -> 多叉树 b树
 
    b树 多路平衡二叉树
    一个 度放多个 节点
    指向 下一个 度 的地址 // 去命中
    2的深度 可以 放入 千万 的数据 - -！
    
    度： 索引 越小 ， 度 越多 16K 动态 计算
    关键字 n 度 n+1
    一个节点 就是一个页 
    
    保持平衡 -> 分裂合并
    
> b+树 加强 b树

    只有 在 叶节点 存放数据
    关键字 n 度 n
    头节点 放置 子节点 头元素
    叶子节点包含 双向指针 ， 指向 前面 和 后面的 指针
    范围查找 直接 从 叶子节点 走， 不用 再去 root 节点io
    节点 包含关键字 子节点 关键字 // 放 下数据 更多 
    
    io 效率 稳定 基本都是 同样的 io次数
    
    比 b树 效率 更好
    
> hash

    hash索引
    // innodb myISAM 不支持 创建啦~
    
    无序
    k -v hash计算
    查找 O(1)
    
    hash碰撞
    范围。
    
    
    
## 存储引擎中的 实现
    
    文件 体现
    MyISAM   一个表 三个文件
    innodb   一个表 两个文件
    
    文件 实现
    FRM 表结构
    
>    myISAM 
 
    MYI MYD 
    // myIndex 存储 索引 （指向）
    // myData  存储 数据       
    非聚集索引
    
>   innodb

    IDB
    数据 跟 索引 文件 在一块    
    聚集 索引 组织 表
    索引 决定 数据 顺序
    
    多个 索引？ 数据 由谁 决定？
    
    索引 键值 逻辑顺序 决定 数据行 物理存储顺序
    // 聚集索引
    
    主键 就是 聚集索引 
    
    其他索引 （二级索引/辅助索引）
    
    辅助索引：
        
        存储索引 和 主键 值
        先找到 主键 再去 主键 索引 查找
        
    
    
## 索引 创建 使用

    注意 索引 占用空间。。
    
    创建 ：
        散列度 越 高 越好
        
    联合索引 几个 关键字 共同 构成索引
    最左前缀原则
    
    不能 跳过 第一个
    
    alter talbe users add index c_n_n(f1 , f2);
    
    select * from users where f1 and f2; // true            
    select * from users where f2 and f1; // true // 优化器  
    select * from users where f1; // true
    select * from users where f2; // false
        
    组合 索引 桥
    index a , b , c
    where a and b and  c // 全名中
    where a and c // 索引命中 a
    where a and b // 索引命中 a.b
    where b and c // 索引 未命中
    where a and b order by c // 索引 全 命中        
        
        
        
> 回表

    二级索引 -> 回表 // 多 扫米哦啊了一棵树
    
>    出现覆盖索引
 
    查找 的字段 包含 用到的 索引
    注意 用到的 索引 ！
    就 避免了 回表的 操作 ，
    
    alter table users add index c_n_n(f1 , f2);
        
    select f1 , f2 from users where f1 // true
    select f1 from users where f1 and f2 // true
    select f1 from users where f2 // true // 优化器强制使用  - -！
    select * from users where f1 // false // 不得不 回表啦~ // * 多个字段了 // 不是 一定， 全部 都有索引。。。
    
> 什么 字段 创建？

    where 
    join 
    order by    
    
    散列度高
    随机无序，频繁更新，不适合 主键
    
    避免 冗余索引 
    
    
> 索引失效

    索引列 使用 函数 ， 表达式 ， 运算符 （不确定的结果）    
    
    类型 隐式转换 ， 字符类型 '123' 数字类型 123 
    
    like 前面% 可能 导致 （最左前缀）
    
    负向查询 <> !=  可能 导致
    
    
    
    
    