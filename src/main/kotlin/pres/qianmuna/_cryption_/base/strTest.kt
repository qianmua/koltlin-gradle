package pres.qianmuna._cryption_.base

import java.lang.StringBuilder

/**
@author HJC
@date 2020/7/25  20:51
@description :
@version 1.0
谦谦君子 卑以自牧也
 */
class strTest {

}

fun m1 (){
    val str = "i love you kotlin"

    val res = with(StringBuilder()){
        for (c in str){
            append(c.toInt().toString() + "")
        }
        toString()
    }

    println(res)
}


fun m2(){
    val ll = 122

    println(Integer.toBinaryString(ll))
}

fun main() {

}