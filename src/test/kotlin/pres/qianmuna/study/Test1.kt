package pres.qianmuna.study

import org.junit.Test


/**
@author HJC
@date 2020/7/20  22:56
@description :
@version 1.0
谦谦君子 卑以自牧也
 */

class Test1 {

    @Test
    fun m1() {

    }

    fun bar(s:String?){
        if(!s.isNullOrEmpty())
            println("$s , ok!")
    }

    class C1

    private fun test1():String{
        return "A"
    }

    fun C1.query() = when( val v1 = test1()){
        else -> "1"
    }

    interface Foo{
        // static
        companion object{
            @JvmField
            val ans = 1

            @JvmStatic
            fun say(){
                println("hello world")
            }
        }
    }




}