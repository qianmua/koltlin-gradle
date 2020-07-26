package pres.qianmuna._cryption_._i_md5_

import java.lang.StringBuilder
import java.security.MessageDigest

/**
@author HJC
@date 2020/7/26  19:54
@description :
@version 1.0
谦谦君子 卑以自牧也
 */
class MD5 {
    fun md5(){
        val digest = MessageDigest.getInstance("MD5")
        val digest1 = digest.digest("hello world".toByteArray())
        println(digest1.size)
        val builder = StringBuilder()
        //to hex
        digest1.forEach {
            // hex
            val i = it.toInt() and (0xFF)
            val string = Integer.toHexString(i)
            builder.append(
                if (string.length <=1 ) {
                    builder.append("0")
                    string
                }
                else
                    string
            )
        }
        println(builder.length)
    }
}

fun main() {
    MD5().md5()
}