

# 分布式锁

    jdk 锁
    数据库 锁
    redis 缓存 锁
    zk 分布式锁
    
## 锁

    多任务
    对同资源写
    互斥
    
    // 竞争锁
    // 占有锁
    // 阻塞
    // 释放锁
    
    
> jdk 锁

    sync
    lock
    
    基于 jvm 锁 
    /// 
    
    不适用 分布式
    
    
> db 锁

    需要 数据库 支持 行锁
    
    // 性能差 无法适应并发 容易 死锁
    
> redis 缓存

    setnx lua 脚本机制 // 保证原子性
    
    // 实现复杂
    // 有死锁可能
    
    
> zk  实现

    基于zk 节点特性 以及 watch 机制
    
    // 实现 复杂
    
    zk 强 一致性算法 //
    
    
## zookeeper

    节点
    znode 类似 linux 目录 解构
    
    客户端 可以对 znode 进行 DRUD
    
    注册 watcher 监控 znode