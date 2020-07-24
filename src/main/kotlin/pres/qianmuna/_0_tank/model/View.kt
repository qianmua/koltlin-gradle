package pres.qianmuna._0_tank.model

import pres.qianmuna._0_tank.Config
import pres.qianmuna._0_tank.business.Blockable
import pres.qianmuna._0_tank.enums.Direction

/**
@author HJC
@date 2020/7/19  22:26
@description :
@version 1.0
谦谦君子 卑以自牧也
 */
interface View {

    val x:Int
    val y:Int

    val width: Int
        get() = Config.BLOCK
    val height: Int
        get() = Config.BLOCK

    fun draw()


    fun checkCollision(x1:Int , y1:Int , w1:Int , h1:Int,
                      x2:Int , y2:Int , w2:Int , h2:Int): Boolean{
        return when {

            y2 + h2<= y1 -> false

            y1 + h1 <= y2 -> false

            x2 + w2 <= x1 -> false

            else -> x1 + w1 > x2
        }
    }

    /*fun checkCollision(view: View):Boolean{
        return false
    }*/
}