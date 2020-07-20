package pres.qianmuna.study

import org.junit.Test
import kotlin.random.Random


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

//            const val ans2 = 100

            @JvmField
            val ans = 1

            @JvmStatic
            fun say(){
                println("hello world")
            }
        }


//        @JvmDefault
        fun m1(): Int = 100
    }

    @Test
    // 实验性
    @kotlin.ExperimentalUnsignedTypes
    fun m3(){
        val uint = 1000u
        val ulong = 1000uL
        val ulong2 = ulong.toLong()

    }


    @Test
    fun m4(){
        println(Random.nextInt(100))


        //isNullOrEmpty
        //boolean
        // orEmpty
        // 空容器

        val map1 = {"a" to 1 ; "b" to 2; "c" to 2; "d" to 2; "e" to 2}

        val key = 'a' .. 'c'
        //.capitalize() 首字母 大写
        val map = key.associateWith { it.toString().repeat(6).capitalize() }

        map.forEach { println(it)  }

        // ifEmpty
        // ifBlank
        val str = "        a      "
        println(str.ifBlank { "blank" })


    }

    @Test
    fun m5(){



    }




}

// 测试
//inline class C2(val v1:String )
