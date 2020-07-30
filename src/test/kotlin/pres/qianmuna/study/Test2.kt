package pres.qianmuna.study

import org.junit.Test

/**
@author HJC
@date 2020/7/30  17:33
@description :
@version 1.0
谦谦君子 卑以自牧也
 */

class Test2 {

    @Test
    fun m1(){
        var a:Int = 7
        var b:Int = 10

        //b = a--
        b = a
        a -= 1 // a = a-1

        //b = --a
        a -= 1 // a = a-1
        b = a


    }
}