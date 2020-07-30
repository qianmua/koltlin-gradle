

# jvm 3 

    垃圾回收算法
    
    
    垃圾收集 就会 STW
    
    

> 新生代 (复制)

    serial             
    parNew
    Parallel Scavenge
    
> 老年代 (标记)

    CMS
    Serial Old
    parallel Old
    
> G1 garbage first

    都可用 
    
    
## serial

    jdk 1.3 之前 
    单线程 （原本是做 嵌入式开发 ， 还没 火起来 // 不需要 多线程支持 // 95年 cpu 单核） // java1.5火的
    简单 高效 
    复制算法 （年轻代） 
    STW （ - -！）
    
## parNew

    serial 的 多线程 版本
    多个 垃圾收集线程 
    STW 
    
    
    
    改良：？
    业务代码时间 / 业务代码时间 + 垃圾收集时间 = 吞吐效率
    // 提高吞吐效率
    // 提高吞吐量
    
    
## Parallel Scavenge

    新生代
    复制算法
    并行 多线程 收集器
    关注于 吞吐量
    
## parallel old

    老年代
    标记整理
    关注于 吞吐量
    
## 并发类 收集器

    业务代码 与 垃圾收集 一块 跑 （没有 STW 影响）    
    //
    并发 饭吃一半 来电话 接完电话继续吃
    并行 饭吃一半 来电话 边接电话 边吃饭
    // 吃饭完 在接电话 都不支持
    // 同时
    
> CMS 标记清除
    
    STW // 将 stw 细致划分 ， 停顿时间 少
    //
    初始标记（STW）
    并发标记（STW）
    重新标记（STW） // 增量更新（快）
    并发清理（STW） // 出现垃圾？ // 可以 容忍 ， 下次 在回收
    
    ///////////////////////////////////////////////////////////////
    
    初始标记 // 单线程 
        标记 GCRoots // GCroots 不是 对象 // 是一个引用
        速度快
        创建 线程消耗资源啊
    
    并发 标记 // 多线程
        开启多线程
        缩短 时间
    重新标记    
        前面已经 开了 多线程 直接用 // 
        到点了
    并发清理
        前面多线程直接用     
        
        
    ///////////////////////////////////////////////////////////////
    
    并发 清理  -> 空间碎片
    
> G1 (jdk7) 

    整体 
        标记整理
    region
        复制算法    

    比CMS 时间 更短 (可以设置)
    解决空间碎片 （对内存空间 重定义）
    
    jdk8 推荐 （服务器 配置 最小 6GB....）
        穷人 只配玩 jdk8
    jdk9 默认                
    
    
    //
    将内存重新 划分
    //把 E O S 变为 逻辑区域
    内存 分区分块 （region）
    优先级 清理
    那个块 垃圾多 先清理那个
    
    
    初始标记
    并发标记
    最终标记
    筛选回收 （筛选 选择 优先）
    
                
> ZGC // 零停顿 小于10ms

    最大支持TB级别内存
    压缩算法
    
**parallel 和 parallel old**
    
    
## 使用

    使用内存 小于 100M
    或者 单核
    -XX:+UserSerialGC
    
    允许停顿超1s
    parallel
    
    // 小于1   
    // 要求 高
    ConcMarkSweep
    G1
    
    
    
    
## 参数

    标准参数  不随 版本变化
    
**非标准参数** 
    
> -X 参数

    -Xint
    -Xcomp..

> -XX 参数

    两类
    布尔值 类型
    -XX:[+/-]value
    
    赋值类型
    name=value
    -XX:MaxHeapSize=100M
    
> 其他
    
    // 简写
    -Xms100M  = -XX:initialHeapSize=100M
    -Xmx50m = -XX:MaxHeapSize=50m
    
    -Xss1M = -XX:ThreadStackSize= 1m
    
    // print // 打印 指令
    -XX:+PrintFlagsFinal 
    // 带 : 就是 修改过的
    
    常用：
    OldSize
    MetaspaceSize
    maxMetaspaecSize
    搜搜引擎吧..记不住
    
    
    