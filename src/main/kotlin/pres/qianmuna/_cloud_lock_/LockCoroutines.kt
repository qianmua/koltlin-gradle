package pres.qianmuna._cloud_lock_

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

/**
@author HJC
@date 2020/7/19  13:22
@description :
@version 1.0
谦谦君子 卑以自牧也
 */

var number = 100

fun buy(){

    while (number > 0){

        if (number > 0){
            number --
            println("thread Name ${Thread.currentThread().name} num get -> $number")
        }
    }
    TimeUnit.MILLISECONDS.sleep(100)

}

fun main() {
    GlobalScope.launch {
        buy()
    }
    GlobalScope.launch {
        buy()
    }
    GlobalScope.launch {
        buy()
    }

    println("kotlin coroutine!")
    TimeUnit.SECONDS.sleep(2)

}