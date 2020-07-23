package pres.qianmuna._0_tank.model

import org.itheima.kotlin.game.core.Painter
import pres.qianmuna._0_tank.Config
import pres.qianmuna._0_tank.business.Blockable
import pres.qianmuna._0_tank.business.Movable
import pres.qianmuna._0_tank.enums.Direction

/**
@author HJC
@date 2020/7/23  18:14
@description : 我方
@version 1.0
谦谦君子 卑以自牧也
 */
class Tank(override var x: Int, override var y: Int) :Movable{

    override val width: Int = Config.BLOCK
    override val height: Int= Config.BLOCK

    // default direction
    override var currentDirection:Direction = Direction.UP

    // speed
    override var speed = 8


    override fun willCollision(block: Blockable): Direction? {
        TODO("Not yet implemented")
    }

    // up down left right
    override fun draw() {
        val dir = when(currentDirection){
            Direction.UP -> "/img...1"
            Direction.DOWN ->"/img...2"
            Direction.LEFT -> "/img...3"
            Direction.RIGHT -> "/img...4"
        }
        Painter.drawImage(dir , x , y)
    }

    fun moveTank(direction: Direction){
        // change direction
        if (this.currentDirection != direction){
            this.currentDirection = direction
            return
        }

        // 越界 判断
        if (this.x+speed >= Config.WIDTH
            || this.x -speed <= 0
            || this.y + speed >= Config.HEIGHT
            || this.y - speed <=0 )
            return

        // location
        when(this.currentDirection){

            Direction.UP -> y -= speed
            Direction.DOWN -> y += speed
            Direction.LEFT -> x -= speed
            Direction.RIGHT -> x += speed

        }

    }


}