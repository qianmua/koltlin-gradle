

# mysql lock 和 事务

    事务 隔离级别
    show global veriables like 'tx_isolation';
    
## 数据库 事务

    什么是 事务？
    
    操作数据库的逻辑顺序得集
    一系列得 操作
    
    事务四大特性
    A   原子性 最小
            undo log 保证
    D   持久性 永久
            page备份
                双写 缓冲
                redo log 数据 恢复 
    I   隔离性 不影响别人数据
            多个事务 隔离 
            MVCC 和 锁
    C   一致性
        ADI 共同保证实现
        
> 什么时候 出现 事务？

    增删改 自动 开始 事务
    
    关闭自动 提交 需要手动cimmit了
    
    手动开启事务
    begin；
    start transction;  // 可以携带 更多得参数
    结束事务
    提交
    回滚
    连接断开 // 不会 提交事务
    
    
> 事务并发 问题

    读一致性问题：

    A:
    事务a查询
    事务b修改
    事务a 查询到 事务b 未提交得数据？ // 脏读 // 读到脏页 
    
    B:
    事务a 读到 事务b提交得 得数据
    两次 读数据 不一致 // 不可重复读 （两次读到数据 不一致）  （update/delete）
    
    C:
    事务a读到范围数据
    第二次读到 更多数据 // 幻读 // insert // 插入 带来的 读不一致性
    
                 
> 事务隔离级别解决：

    读未提交 RU
        为解决 任何问题 事务 未提交 数据 对 其他事务可见
    
    读已提交 RC
        只能 看到 其他事务提交 得 修改 // 出现不可重复读 // 幻读
    
    可重复读 RR （innodb 默认）
        同一个事物 读到结果一致 // 未解决 幻读
         
        
    
    串行化 S （强制 排队）
        最高隔离级别 // 强制事务串行执行
        ->共享锁
        
        
> 读一致性  MVCC 多版本 并发控制
    
        // 如何解决？
        1、LBCC //加锁 阻止其他数据 修改
       
        2、MVCC // 多版本控制 // 根据读取时间点 创建 快照 // 下次 读取 快照中得内容 
            只在 RC RR 中使用
            innodb 隐藏字段 
                row_ID 
                TRX_ID 事务编号 （insert update）
                ROLL_PTR 回滚指针 // 哪个事务删除得他 (delete)
                    // undo log 版本链
                    事务 id 
                    根据 undo log 链 循环 获取 上一个版本
                    
 ## innodb锁
    
    分类：
        
        粒度： 行锁 表锁
        用法： 乐观 悲观锁
        类型： 排他 共享 意向 自增锁
        算法： 间隙 记录 临建 意向插入锁
        产生问题： 死锁
        
> 共享锁 读锁 S

    多个 事务 对 同一数据 共享 同把锁        
    select * from users lock in Share mode;
    // 防止 别人 修改
    
> 排他锁 写  X

    自动添加 delete update insert 默认 加X 锁
    手动添加 select * from users where 1 = 1 for update;

> 意向锁 表级别 

    引擎自动加
    提供 标志 标识
    // 提高 加 表锁 效率
    
    
## 锁

    解决 资源 竞争 问题
    
> 锁得实现？

    不用 索引 ，行锁 会 锁住整张表
    （默认得 ROW_ID）
    //
    实际 是 锁的 索引 //
    通过 锁住索引 锁住行
    ：锁的是聚集索引
    
    
> 行锁的算法    

    锁的 范围
    
    记录record    1        4        7
    间隙gap       - -1     1，4     4-7 7- + (开区间）
    临键next-key   - -1     1，4     4-7 7- + (比区间）
    
    记录锁
        唯一性索引 等值 查询
    
    gap lock 间隙锁    （阻塞 insert）
        记录不存在的区间
        间隙锁 不冲突
        
     临键锁
        范围查询，包含记录 和 区间
        锁住 最后一个 值的 所在 区间
        （8.0 优化）  
        
        
`innodb 解决 幻读 就是 通过 间隙锁`
    
`串行化 就是默认添加个共享锁`    


## 

    普通select 就是 MVCC 通过快照读
        效率高 ， 不是最新 ，也不能阻止修改
    
    加锁的读
    in share mode
    for update
    insert
    update
    delete
        
        RR 可重复度
            RL
            GL
            NKL
        RC 读已提交
            (没有解决幻读)
            RL
            *
    
    
            
    