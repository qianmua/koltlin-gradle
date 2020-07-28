

# jvm


    java源文件 -> javac -> 字节码 -> jvm -> (windows , linux , mac) -> 汇编码 机器码
    
    字节码文件 格式
    ClassFile{
        u4                  magic;  // 头标识 ca fe ba be
        u2                  ....    // 最小版本号
        u2                          // 最大版本号(hex = 34) java8 52
        u2                          // 常量池中 常量数量
        cp_info                     // 读取 u2 的结果 的 数量 -1 （从1开始）
        u2                          // ......
        u2
        u2
        u2
        u2
        u2
        field_info
        ur
        method_info
        u2
        attriable_info
        ....
    }
    // u 表示16进制对 // ca fe ba be // 4个
    // u4 读取 4个字节
    // u2 继续 读取 两个字节
    
    
> 常量池    

    字面常量    文本  字符串 final
    符号引用    lei ， 接口 方法 的 描述
    
    
> 反编译

    javap -v -p file > file.txt    
    //
    
    
## 类加载机制

    装载
    链接
        验证
        准备
        解析
    初始化
    使用
    卸载

    类 -> jvm
    classLoader
    
    bootstrap
    ext
    application
    custom
    
> 双亲委派机制

    保证 类 安全
        
    打破
    
        重写 loadClass 方法
        
        SPI
        
        OSGI
        
        
        
## 运行时 数据区

    栈   （私有）
    堆
    方法区（包含常量池） （线程共享）
    本地方法栈
    pc register
    
    
            
