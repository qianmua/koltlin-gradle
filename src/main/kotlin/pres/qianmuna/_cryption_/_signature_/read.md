





## 数字签名

    非对称加密 消息摘要 的组合应用
    
    1、校验身份 
    2、校验数据完整
    
    //
    
    // 流程
    
    明文
    sha消息摘要
    私钥加密
    传输（明文 + 密文）
    //
    得到 明文 密文
    公钥 解密 密文
    明文 sha  摘要 
    比对   
    
    