package pres.qianmuna._0_tank.model

import pres.qianmuna._0_tank.Config

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
}