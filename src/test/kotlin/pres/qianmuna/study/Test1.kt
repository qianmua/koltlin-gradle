package pres.qianmuna.study

import org.junit.Test
import java.util.Arrays.asList
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

        val map1 = mapOf("a" to 1 , "b" to 2, "c" to 2, "d" to 2, "e" to 2)

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

        // 算数
        // + - * / %
        // 中缀函数
        // and or xor shl shr
        println(1 and 2)
        // -- ++ inv


        val map = mapOf("a" to "b" , "b" to "c" )
        val a = map.mapValues { v1 ->
            val (a,b) = v1
            "$a to $b"
        }
        val b = map.mapValues { (v1 , v2) ->
            "$v1 to $v2"
        }

        println(b)

        val	map2	=	mapOf(1	to	"one",	2	to	"two")

        map2.forEach { (_, u) -> println(u) }

    }

    data class Test1(val name:String , val age:Int)

    fun getTest1() = Test1("A" , 18)


    fun test5(s:Any){
        val f = (s as? CharSequence)?.firstOrNull()
        if (f != null)
            // 智能转换
            println(s.count{ it == f })


    }


    @Test
    fun m6(){
        val (name , age) = getTest1()


        val onM = 100_000_000_000

        val b = 0b10101_1001001_10010

        val hex = 0xFF_EE_99_88


        println(hex.toString(16))

        println(test6 { "6" })
    }

    inline fun test6( v1: (String) -> String ):String = v1("nb")



    @Test
    fun m7(){
        val a by lazy { 100 }

        println(a)
        /// page 60

    }
    /// 泛型 枚举
    enum class CE1{
        RED,GREEN,BLUE
    }

    // 泛型
    inline fun <reified T : Enum<T>> sout(){
        println(enumValues<T>().joinToString { it.name })
    }


    @Test
    fun m8(){

        // mod -> rem
        println(100 xor 20)

        val a1 = "100"
        val a2 = a1.toIntOrNull() /*?: -1*/

        val a3 = a2?.toString()

    }

    class C8{
        lateinit var cont:String
    }

    fun C8.copy() = C8().also { it.cont = this.cont }


    @Test
    fun m9(){
        val	words	= "one	two	three	four	five	six	seven	eight	nine	ten".split('	')
        var by = words.groupBy {
            it.first()
        }

        val map1 = mapOf<String,Int>()
        // copy
        val map2 = map1.toMap()

        val a = arrayOf(1,2,3)
        val b = arrayOf(4,5,6)

        val min = minOf(a.size , b.size)
        println(min)


        val list = List(10){ it + 1 }
        println(list)

        val mutList = MutableList(10) { 10 }

        println(mutList)

        val arr = arrayOf("A" , "B" , "c")
        // hash
        println(arr.toString())
        // toString
        println(arr.contentToString())



    }


    private fun add (a:Int, b:Int ):Int = a + b


    @Test
    fun m10(){
        println("this is ${add(10000,2)}")

        val listofTest = listOf("A"  , "B" , "C" , "D")

        // 下标
        for (s in listofTest.indices) {
            println(listofTest[s])
        }
        var index = 0
        while (index < listofTest.size){
            index ++
        }

        val ran = 1 .. 10 + 1
        println(ran.toList())


        if ( -1 !in 0 .. listofTest.lastIndex )
            println("666")


        when{
            "A" in listofTest -> println("6")
            "B" in listofTest -> println("7")
            else -> println("unknow")

        }

    }

    abstract class C10(val sides:List<Double>){
        val v1:Double get() = sides.sum()
        abstract fun m1():Double
        fun m2():Double = 0.0
    }

    fun m101(){
        val mutlist = mutableListOf(1,23,4,5,6)
        mutlist.add(7)
        // if not null
        mutlist?.let {
            println("$it not is null")
        }

        // 调用多次 同一个 对象方法
        val c10 = C101()
        with(c10){
            println(m1())
            for (index in 1..4){
                m2()
            }
            m3()
        }

        //apply 配置 未出现属性 // 构造
        // also

    }

    // 交换
    var a = 1
    var b = 2


    class C101{
        fun m1() = "A"
        fun m2() = "B"
        fun m3() = "C"
    }

    @Test
    fun m11(){
        val i = 100 // 100.val

        //幕后属性
    }
    private val _ele = 100

    val ele
        get() = _ele

    // a++ // err a ++


    fun m111(str:String = ""){/*...*/}

    fun m112(){
        for (i in 0 until 10){
            println(i)
        }
    }


    @Test
    fun m12(){
        // type
        // byte
        // short
        // int
        // long
        // float
        // double

        // 不支持 八进制 表示


        // 较小的类型不能隐式转换为较大的类型


        println(1 shl 2)


        val arr = arrayOfNulls<Int>(10)

        val arr2 = Array(5){it.toDouble()}

        val arr3:Array<out Any>
        arr3 = arr2

        println(arr3.contentToString())

        //
        val arr4 = intArrayOf(2,3,4,5,6)

        val str = "${'$'}999"
        println(str)


    }

    @Test
    fun m13(){

    }

    data class C133(val name:String , val age:String)
    class C1331 constructor(
        /**/
        val name:String ,
        val age:String){

        constructor(name :String, age:String,adddress:String):this(name, age){
            println(66)
        }

    }

    class C1332 private constructor(){}


    class C1333 {
        companion object{

            fun m1(){
                println("6")
            }


        }

        fun m1(){
            println("7")
        }
    }

    @Test
    fun m14(){
        C1333.m1() // 6
        C1333().m1()// 7


        /*if (pres.qianmuna.study.Test1::sub.isLateinit){
            println("1")
        }*/
    }

    var counter = 1


    // 延迟初始化属性与变
    lateinit var sub:String


    interface IC141<out T>{
        fun next():T
    }
    fun testIC141(s:IC141<String>){
        val obj = s
        val obj2 : IC141<Any> = s

        //....
        T1().T2().T3().T4().tm1()
    }

    class T1{
        inner class T2{
            inner class T3{
                inner class T4{
                    fun tm1(){
                        println("?")
                    }
                }
            }
        }
    }


    enum class Pro{
        WAT{
            override fun sig(): Pro  = TAL

        },

        TAL{
            override fun sig(): Pro  = WAT

        };

        abstract fun sig():Pro
    }


    interface IntBina{
        fun apply(v1:Int, v2:Int):Int
        fun applyAsyInt(v1:Int, v2:Int):Int
    }

    enum class IntArt:IntBina{
        SUM{
            override fun apply(v1: Int, v2: Int): Int  = v1 + v2

        } , TIMES{
            override fun apply(v1: Int, v2: Int): Int  = v1 * v2
        };

        override fun applyAsyInt(v1: Int, v2: Int): Int = apply(v1,v2)

    }

    enum class TestMax(val code:Int , val msg:String){
        NOT(404,"not found"),
        ERROR(500,"server error");

    }

    fun testTestMaxEnum(){
        val code = TestMax.NOT.code
        val msg = TestMax.NOT.msg
        // 位置
        val index = TestMax.NOT.ordinal
        // 名称
        val name = TestMax.NOT.name


        val ob = object {
            var x:Int = -1
            var y:Int = -1
        }

        println("${ob.x} : ${ob.y}")

    }

    object TestDate{
        lateinit var str:String
    }

    interface Base{
        fun p()
    }
    class TByBase(val x:Base) :Base by x

    @Test
    fun m15(){

        TByBase(object :Base{
            override fun p() {
                println("100")
            }
        }).x.p()

    }

    val lazStr:String by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        "66"
    }

    // *

    fun foo1(vararg str:String){}

    @Test
    fun m16(){
        foo1( str = *arrayOf("A" , "B" , "C"))

        val	a= arrayOf(1,2,3)
        val	list = listOf(-1, 2 , *a , 5)


    }

    // 中缀
    // 成员 扩展
    // 一个参数
    // 不能有 默认 和 可变参数

    private infix fun Int.maxValue(v1:Int):Boolean = this > v1

    fun testMaxValue(){
        println(1 maxValue 2 + 1) // 1 maxValue( 2 + 3)


        val f1 = fun(x:Int):Int = x * 10

        val f2 = {x:Int -> x * 10}

        val fun1 = fun(ins:List<Int>):Boolean{
            ins.forEach {
                if (it == 0)
                    return true
                // it == 0
            }
            return false
        }

    }

    // 尾递归 优化
    // tailrec
    //






}

// 测试
//inline class C2(val v1:String )
