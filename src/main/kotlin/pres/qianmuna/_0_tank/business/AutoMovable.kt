package pres.qianmuna._0_tank.business

import pres.qianmuna._0_tank.enums.Direction
import pres.qianmuna._0_tank.model.View

/**
@author HJC
@date 2020/7/23  21:20
@description :
@version 1.0
谦谦君子 卑以自牧也
 */
interface AutoMovable :View{

    /**
     * 方向
     */
    val currentDirection:Direction

    /**
     * 速度
     * default
     */
    val speed: Int
        get() = 8

    fun autoMovable()

}