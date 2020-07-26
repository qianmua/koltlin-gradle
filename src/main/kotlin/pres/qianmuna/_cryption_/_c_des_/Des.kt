package pres.qianmuna._cryption_._c_des_

import java.security.Key
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.DESKeySpec

/**
@author HJC
@date 2020/7/26  17:38
@description :
@version 1.0
谦谦君子 卑以自牧也
 */

class Des {
    /*
    * 三步
    *
    * 创建cipher
    *   （java）
    * 初始化cipher
    *
    * 加/解密
    *
    * */

    companion object{

        fun createCipherEn(input:String = "" , key:String="12345678"):ByteArray?{
            val cipher = Cipher.getInstance("DES")

            // 生成工厂
            val kf = SecretKeyFactory.getInstance("DES")
            // 密钥 // 长度 8位
            val ks = DESKeySpec(key.toByteArray())
            // 生成 key
            val key:Key? = kf.generateSecret(ks)

            // 加解密模式
            // 初始化
            cipher.init(Cipher.ENCRYPT_MODE, key)

            // 加密
            val bytes = cipher.doFinal(input.toByteArray())

            return bytes
        }

        /**
         * 解密
         */
        fun decryptDe(byteArray:ByteArray , key:String = "12345678"):ByteArray?{
            val cipher = Cipher.getInstance("DES")

            // 生成工厂
            val kf = SecretKeyFactory.getInstance("DES")
            // 密钥 // 长度 8位
            val ks = DESKeySpec(key.toByteArray())
            // 生成 key
            val key:Key? = kf.generateSecret(ks)

            // 加解密模式
            // 初始化
            cipher.init(Cipher.DECRYPT_MODE, key)

            // 加密
            val bytes = cipher.doFinal(byteArray)

            return bytes
        }
    }
}

fun main() {
    val en = Des.createCipherEn("111222333444")
    println(en)
    val de = Des.decryptDe(en!!)
    println(String(de!!))
}