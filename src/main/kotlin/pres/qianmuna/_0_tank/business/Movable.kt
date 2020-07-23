package pres.qianmuna._0_tank.business

import pres.qianmuna._0_tank.enums.Direction
import pres.qianmuna._0_tank.model.Bullet
import pres.qianmuna._0_tank.model.View

/**
@author HJC
@date 2020/7/23  18:45
@description : move able
@version 1.0
谦谦君子 卑以自牧也
 */
interface Movable:View {

    /**
     * driection
     */
    val currentDirection:Direction

    /**
     * speed
     */
    val speed:Int

    /**
     * 碰撞
     * @param block
     * @return dir if null -> not Collision
     */
    fun willCollision(block:Blockable):Direction?

    /**
     * notifyCollision
     */
    fun notifyCollision(direction: Direction? , block: Blockable?)

    fun attack():Bullet

}