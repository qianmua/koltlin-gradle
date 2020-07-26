package pres.qianmuna._cryption_._i_sha1_

import java.security.MessageDigest

/**
@author HJC
@date 2020/7/26  20:21
@description :
@version 1.0
谦谦君子 卑以自牧也
 */
object SHA1 {
    fun sha1():StringBuilder{

        // SHA-1
        // SHA-256
        val digest = MessageDigest.getInstance("SHA-256")
        val digest1 = digest.digest("hello world".toByteArray())
        return with(StringBuilder()){
            digest1.forEach {
                append(
                    if (length <=1 ) {
                        append("0")
                        Integer.toHexString(it.toInt() and (0xFF))
                    }
                    else
                        Integer.toHexString(it.toInt() and (0xFF))
                )
            }
            this
        }
    }
}

fun main() {
    println(SHA1.sha1())
}