package pres.qianmuna._cryption_._signature_

import java.security.PrivateKey
import java.security.Signature
import java.security.interfaces.RSAPrivateKey
import java.util.*

/**
@author HJC
@date 2020/7/26  20:34
@description :
@version 1.0
谦谦君子 卑以自牧也
 */
object Demo {

    // 使用 数字签名 校验 数据完整
    // 即使 改变参数 也不会造成影响
    // 公钥解密
    // 然后 信息 摘要比对
    // over

    fun signture(){
        // SHA256
        val instance = Signature.getInstance("SHA256withRSA")

        // 初始化
        // 传入 签名
        // privateKey
//        instance.initSign()

        // 传入 数据 源
        instance.update("56416sadad".toByteArray())

        // 生成签名
        val sign = instance.sign()
        val bytes = Base64.getEncoder().encode(sign)
        println(bytes)


        ///////////////////////////

        // 初始化 签名
        // 传入 公钥
//        instance.initVerify()

        // 传入 数据源
        instance.update("56416sadad".toByteArray())

        // 校验
        val verify = instance.verify(Base64.getDecoder().decode(bytes))
        println(verify)
    }
}

fun main() {

}