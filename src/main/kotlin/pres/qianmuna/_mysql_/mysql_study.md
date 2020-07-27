


# mysql

    mysql 笔记 （二）
    
    
## mysql 执行流程

    一条sql 是如何 执行的？

    client 与 服务 链接 
    ///
    线程 对应 连接 // session
    
    
    连接： tcp
        长连接
        同步

    
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
    
    
## 模块 

## 一条sql 查询执行过程？
    
    
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

    操作 存储 引擎 api(读写 接口)
    
            
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
    
    
## 更新 语句 如何 执行？

    包括 update insert delete
    
> 操作 一条数据

    调用 api 拿到原始数据到 内存
    
    在 server 层 处理
    
    拿到 的 数据 大小?
    
    预读 读取 固定 大小：
        page 页
        默认 大小 16k
    
>缓存 IO 缓冲区     （innodb）

    show variables like 'innodb_buffer_pool';
    (影响 数据库 性能 io 量)
    
    减少 io
    
    提升 效率、
    
    先 写入 内存 缓冲   
    
> 脏数据  dirty

    在 缓冲 区中 没有 同步 到 磁盘
    
    // 刷脏 过程 宕机？
    
    日志
    写入 缓冲的 数据 记录到 日志
    redo log  // 崩溃恢复
    //
    写入 日志 与 写入 磁盘区别
    // 随机 IO // 磁盘 寻址 找到 对应的页
    // 顺序 IO // redo log 不考虑 寻址消费 直接 追加到 文件
    
    记录数据页改动
    大小固定（前面 会 擦除）
    写满会 触发一次 同步
    
    
    事务 日志
    undo log
    撤销日志
    DML 修改 发生 之前 的状态 （update insert delete）

    可以 进行 回滚 操作
    实现 原子性
    
    大小 默认 1G
    
    
> eg:
    
    disk -> innodb buffer pool -> server
    
    写入 ——> 记录 undo log 、redo log               
    写入 buffer pool
    commit
    等待 刷脏
    
    
> buffer pool

    data
    
    change buffer
    
        非唯一索引
        一次性 全部 写入 
        // 提高 效率 
        （唯一索引 需要 校验 判断 为例）        
        
> log buffer

    -> erdo log    
    
    
> buffer 写满了 ？

    LRU 算法(改良) // 最近使用
    冷热 分离 链表  // 类似 java堆
    
    （redis 同样 使用 到 LRU LFU ..）


## service 层 日志

    binlog 二进制 日志 （DDL DML） 语句
    无固定大小
    service实现 所有储存引擎 都可使用
    
    作用：
    
    主从 复制
    数据 恢复
    
> 主从         

    读写 分离
    
    // 从节点 刷新 最新 数据
    
    依赖 主节点 binlog
    
    从节点 同步 binlog （DML语句）
    执行 同步数据
    
    
> 数据恢复（定时备份）

    全量备份 
    。。
    删库了。。。
    
    先恢复 到全量备份 时候 
    然后 解析 binlog
    重新 执行 到 删库 之前
    

> 流程

    cilent ——> service -> update (innodb) -> buffer pool -> redo log 并标记 prepare 、 (事务 开始前 记录)undo log
    ——> 开始commit -> 写入 binlog ——> commit -> redo log 标记 提交commit
    
    // redo log 、 bin log
    
    两阶段 提交
    
    解决 不一致 问题 
    binlog 写入 失败  事务 消失
    //
    bin log 未写入 回滚（undo log） 保证 数据 一致
    bin log 写入 undo 状态 没更新 需要 提交 保证 一致
    
    
    
    
    
        
    
    
       
    
    
    
    
    
    
        
        
        