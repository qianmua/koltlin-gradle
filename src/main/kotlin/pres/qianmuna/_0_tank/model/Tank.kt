package pres.qianmuna._0_tank.model

import org.itheima.kotlin.game.core.Painter
import pres.qianmuna._0_tank.Config
import pres.qianmuna._0_tank.enums.Direction

/**
@author HJC
@date 2020/7/23  18:14
@description : 我方
@version 1.0
谦谦君子 卑以自牧也
 */
class Tank(override val x: Int, override val y: Int) :View {

    override val width: Int = Config.BLOCK
    override val height: Int= Config.BLOCK

    // default direction
    val currentDirectin:Direction = Direction.UP

    // up down left right
    override fun draw() {
        val dir = when(currentDirectin){
            Direction.UP -> "/img...1"
            Direction.DOWN ->"/img...2"
            Direction.LEFT -> "/img...3"
            Direction.RIGHT -> "/img...4"
        }
        Painter.drawImage(dir , x , y)
    }


}