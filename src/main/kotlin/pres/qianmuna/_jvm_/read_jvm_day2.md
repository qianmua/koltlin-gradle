

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
                
                


    
## 补充
   
    Minor GC：Eden区。老年代最大的可用连续空间大于新生代的所有对象总空间时触发。
    
    young GC：Eden、S0、S1区。young gen中eden区分配满时触发
    
    Full GC：收集整个堆（young gen、old gen、perm gen）。准备触发young GC时，发现之前young GC的平均晋升大小比目前old gen剩余的空间大，则不触发young GC转而触发full GC；在perm gen分配空间但空间不足，也要触发full GC；System.gc()默认触发full GC。
    
    Major GC：通常是跟full GC等价（收集整个GC堆）。Major GC 主要由 Minor GC 触发。
    
    Minor GC和Major GC：是俗称，不是规范的，没有明确定义。可以理解为是Young GC和Old GC算法的组合。
    
    
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
    
    full GC = minor + major + meta space (非堆 元空间)

     meta space GC 绑定 major GC 有major 有 meta
     
     major 伴随 着 minor GC    
     
> 方法区

    1.7  使用 虚拟机内存
    1.8  使用 本地内存  （动态 扩容 大小不确定 ） // 放到 堆 怕 给 撑爆了。。   
    
    
    类的 静态文件 解构
    
    
## GC 算法


> 判断 什么是垃圾

    引用计数
        效率高
        循环引用 问题 （内存 泄露）
        
    可达性算法 / 根搜索算法
    GC root // 活跃 的一个引用
        可达性/根
        栈帧中局部表中引用的对象
        JNI
        方法区 静态变量 和 常量
        
        
> 回收 时机

    young 不够
    old 不够
    方法区 不够
    // 不确定的
    System.gc
    
    
> 垃圾回收 算法        

    分代收集

    标记清除算法 // 内存 不连续
    
    eden 直接 回收  - - ！
    
    复制算法 （s0 s1区）
        分成 一半
        高效
        // 
        但是 会额外 占用一半空间
        
    标记整理 （老年代）
        解决 内存 碎片问题 / 效率 问题 没有解决
            效率低 （需要更新 所有 引用地址）
            
            
            
#            
            
            
            
            
            
            
            
            
            
        
    
    
    
            
    







    
    
    
    
    
    
    
    
    
    
    
        
    