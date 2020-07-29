

# jvm day2 

    byte code
    jvm
    jmm
    
##  运行时 数据区

    方法区 类信息
    pc 线程 切换
    NMS 本地方法栈 （线程生命周期）
    JVMS 虚拟机栈   
    
    
> 栈 数据单位 

    栈帧
        栈帧：
        ...
                
                
## 堆
    
    元空间（非堆）
    
    堆 （ 根据 对象 年龄 分为 old young ）
        old
        
        eden
        s1
        s2
    
    young:
    
    使用四位 标记 年龄 最大 15
    
    young GC / minor GC
    
    // 存活区
    解决 gc 后 内存 分布 不均匀 问题 （内存碎片）//
    
    s0 s1 （from/to） 
    保证 survivor 是有一部分 连续的
    //
    从 s0 - s1 时 minor GC 不用的 使 后面 的连续 （重新 分配 内存地址） 
    保证 使连续的 // 解决内存碎片
    
    // 来回 置换 // 保证 永远有一块空间 闲置
    
    age 到15 放到 old
    
    
> 大对象

    young 不够放 触发一次 gc 不够 -> old

    old 默认 是young 2倍

    担保机制    
    
    到 old 去
    不够 major GC （full GC） // STW sotp the world // JVM GC
    
    full GC = minor + major + meta space (非堆)
    
## 补充
   
    Minor GC：Eden区。老年代最大的可用连续空间大于新生代的所有对象总空间时触发。
    young GC：Eden、S0、S1区。young gen中eden区分配满时触发
    Full GC：收集整个堆（young gen、old gen、perm gen）。准备触发young GC时，发现之前young GC的平均晋升大小比目前old gen剩余的空间大，则不触发young GC转而触发full GC；在perm gen分配空间但空间不足，也要触发full GC；System.gc()默认触发full GC。
    Major GC：通常是跟full GC等价（收集整个GC堆）。Major GC 主要由 Minor GC 触发。
    Minor GC和Major GC：是俗称，不是规范的，没有明确定义。可以理解为是Young GC和Old GC算法的组合。





    
    
    
    
    
    
    
    
    
    
    
        
    