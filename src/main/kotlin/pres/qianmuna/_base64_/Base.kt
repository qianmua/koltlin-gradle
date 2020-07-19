package pres.qianmuna._base64_

import sun.misc.BASE64Decoder
import sun.misc.BASE64Encoder
import java.nio.charset.Charset

/**
@author HJC
@date 2020/7/19  19:21
@description :
@version 1.0
谦谦君子 卑以自牧也
 */

fun main() {
    var decoder = BASE64Decoder()
    var encoder = BASE64Encoder()
    var string = String(decoder.decodeBuffer("yf3WsLzT0L0="), Charset.forName("GB2312"))
    var string2 = String(decoder.decodeBuffer("5oiR5Y+8bm1k"), Charset.forName("UTF8"))
    println(string)
    println(string2)

    var buffer = encoder.encodeBuffer("我叼nmd".toByteArray(Charset.forName("UTF8")))
    println(buffer)
}