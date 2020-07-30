

# jvm 3 

    垃圾回收算法
    

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
    
## parallel Old

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
    
> CMS
    
    STW // 将 stw 细致划分 ， 停顿时间 少
    //
    初始标记（STW）
    并发标记    
    重新标记（STW） // 增量更新（快）
    并发清理