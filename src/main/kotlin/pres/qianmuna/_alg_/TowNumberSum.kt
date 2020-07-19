package pres.qianmuna._alg_

/**
@author HJC
@date 2020/7/19  19:38
@description :
@version 1.0
谦谦君子 卑以自牧也
 */

fun toNumberSum(){

}


fun whenTest(v1:Int) = when (v1) {
    1 -> 1
    else -> 2
}


fun loopTest(){
    for (v1 in 1..100){

    }
}

fun readTest(){
    println("A")
    val v1= readLine()

}


/*tailrec */fun old(n:Int):Int{
    if (n == 1)
        return 1
    return n * old(n-1)
}

// enum

enum class Week(day:Int , tets:String){
    day1(6 , "7") , day2(2,"A") , day3(3,"B") , day4(4,"C") , day5(5,"D")




}


fun main() {
    var old = old(5)
    println(old)

    println(Week.day1.name)
    println(Week.day1.ordinal)
    println(Week.day1)
}