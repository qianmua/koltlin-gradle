

# redis

    单值缓存
    set key value
    get key
    
    对象缓存
    set user:1 value
    mset user:1:name 111 user:1:balance 222
    mget user:1:name user:1:balance
    
    分布式锁
    setnx // 存在 不动作 ， 不存在 创建
    
    /// 计数器
    // 原子 加减
    incr artice：readcount:文章id
    
    
    session 共享
    spring sesssion + redis
    
    分布式 系统 全局序列号
    incrby orderID 10000 // 批量 生成序号
    
> hash

    对象缓存
    hmset user {userid}:name {name} {userid}:bal 11111
    hmget user 1:name 1:bal
    
    同类数据归类整合，方便管理
    比String 消耗小
    节省空间
    
    
    过期 只能 功能 只能作用 在 key
    redis 集群 下 不适合大规模使用
    (BIG KEY) // 全查
    // 阻塞 其他命令
    
    
    分段存储
    给 key 分段
    user0001
    user0002
    user0003....
    
    //购物车
    //用户id
    // 商品id
    // 商品数量
    // hset cart：1001 goodsid1 2
    // hset cart：1001 goodsid4 7
    // hset cart：1002 goodsid10 4
    // hset cart：1003 goodsid5 22
    // 添加 购物车 功能
    // hincrby catr：1001 goodsid1 1000
    // 总数
    // hlen catr:1001
    // 删除 
    // hdel cart：1001 gooodsid1
    // 得到 所有
    // hgetall



    
    
    
    