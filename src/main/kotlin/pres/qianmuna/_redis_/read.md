

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
    
    (BIG KEY) // 全查
    // 阻塞 其他命令 // big key 会很影响 时间
    
    
    过期 只能 功能 只能作用 在 key
    redis 集群 下 不适合大规模使用
    集群下 数据 分片 // hash 运算 可能和导致 数据 分布 不均匀
    
    
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
    
> list 

    key value
    
    value 是一个 链表
    
    lpush // l left
    rpush // r right
    lpop
    rpop
    lrange  // 区间 取值
    blpop   // 阻塞 // 直到 有
    brpop   // 阻塞 // 做 消息监听
    
    // 数据解构
    // stack lpush + lpop   FILO
    // queue lpush + rpop   DILO
    // blocking MQ lpush brpop 


    公众号消息 （消息流） // 新发的 在 最前面
    // redis 实现
    // FILO
    // LPUSH msg:{userKey} 文章 id
    // LPUSH msg:{userKey} 文章 ID
    // LRANGE userKey 0 4 // 从 指定 区间 取出
    
    // BLPOP key tomeout // 取 阻塞 等待。。。 秒
    // BLPOP key tomeout
    
**redis pipeline 批量执行操作**

> set

    sadd key m[m1,m2,m3] // 放入 一批元素 (key 不存在 自动创建)
    srem key m  删
    smembers key  获取 key 所有 元素  
    scard key   获取 key 个数
    sismember key m 判断是否在key
    
    （随机的）
    SRANDMEMBER key [count] / SPOP key [count] 选出 count 不从key删除 
    spop key  count  选出 count 从key删除
    
    
    //运算操作
    交集
    并集
    差集
    
    
    // 场景
    抽奖
    sadd key{userID}
    // 查看参与
    smembers userID
    //抽奖
    SRANDMEMBER key [count] / SPOP key [count]
    
    点赞 收藏 标签
    sadd like:{id} {userId}
    serm
    // 点赞过？
    // 点赞 列表
    // 点赞数
    
    
    
    关注 模型 // 共同关注
    交集并集差集
    
    
    
> zset

    有序集合
    
    场景
    新闻排行榜
    // 就是说 排序 集合
    
    
    
## 其他数据 类型

    bitmap
    geo
    hyperloglog //     
    
    


    
    
    
    