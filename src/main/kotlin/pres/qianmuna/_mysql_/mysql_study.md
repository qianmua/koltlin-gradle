


# mysql

    mysql 笔记 （二）
    
    
## mysql 执行流程

    一条sql 是如何 执行的？

    client 与 服务 链接 
    ///
    线程 对应 连接 // session
    
> 查看 连接 数

    show global status like 'Thread%';
    
    //
    mysql 会将 长时间 不活动的 链接 断开
    
> mysql 允许 最大 链接数？

    show variables like 'max_connections';
    // 151
    // 默认
    //
    可以支持 的 最大 连接数 是 10w
    
> 默认参数 级别

    session （窗口 ， 会话）
    global (全局)
    
    // show 默认 session
    
    
## 组件 

    一条sql 执行过程？
    
    
> 缓存

    5.7 不建议 使用 // 默认 关闭
    8.0 被移除
    
    show variables like 'query_cache';
    
    
> parser

    解析器
        
        词法解析
        语法解析

        解析树
            select * from table1 where 1=1 and 1=1
            
> pro processor

    预处理
        验证 数据 有效性 // 字段 表 权限 别名 ...
        
    得到 新的 解析 树
        可以被 识别的 解构
        

> optimizer 

    优化器
    
    根据解析树 生成不同执行计划
    
    优化 sql 语句
        1、jion
        2、索引
        3、冗余
    
    是最优的吗？
        否
        
    
> execution plans

    选择 执行计划
    // 查看 执行 计划
    explain sql...
    
> 执行器

    存储 引擎 api
    
            
## 数据库引擎

    存储引擎

    innodb
        事务（ACID） linelock 一致性非锁定读（MVCC） 聚集索引存储
    memory
        
    myisam
    

> 插件式 存储引擎

    不同的业务需求

    查询快 持久
    历史表 归档
    读写 并发 一致性
        

    
    