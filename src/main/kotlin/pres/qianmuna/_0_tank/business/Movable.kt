package pres.qianmuna._0_tank.business

import pres.qianmuna._0_tank.Config
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
        get() = 8

    /**
     * 碰撞
     * @param block
     * @return dir if null -> not Collision
     */
    fun willCollision(block:Blockable):Direction? {

        var x = this.x
        var y = this.y

        when(this.currentDirection){

            Direction.UP -> y -= speed
            Direction.DOWN -> y += speed
            Direction.LEFT -> x -= speed
            Direction.RIGHT -> x += speed

        }

        // 边界 检测
        if (x < 0) return Direction.LEFT
        if (x > Config.WIDTH - this.width) return Direction.RIGHT
        if (y < 0) return Direction.UP
        if (y > Config.HEIGHT - this.height) return Direction.DOWN

        // 碰撞检测
        val coll = checkCollision(block.x, block.y , block.width ,block.height,
            x,y,this.width , this.height)

        return if (coll)
            currentDirection
        else
            null
    }

    /**
     * notifyCollision
     */
    fun notifyCollision(direction: Direction? , block: Blockable?)

    fun attack():Bullet

}