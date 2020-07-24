package pres.qianmuna._0_tank.model

import org.itheima.kotlin.game.core.Painter
import pres.qianmuna._0_tank.Config
import pres.qianmuna._0_tank.business.AutoMovable
import pres.qianmuna._0_tank.business.Blockable
import pres.qianmuna._0_tank.business.Movable
import pres.qianmuna._0_tank.enums.Direction
import java.util.*

/**
@author HJC
@date 2020/7/24  16:26
@description : 敌方 坦克
@version 1.0
谦谦君子 卑以自牧也
 */

class TankEnemy(override var x: Int, override var y: Int):Movable,AutoMovable,Blockable{

    override var currentDirection: Direction = Direction.DOWN

    // 修改 方向
    private val badDirection:Direction? = null

    override val speed: Int = 1


    override fun autoMovable() {

        if (currentDirection == badDirection){
            currentDirection = randomDirection(badDirection)
            return
        }

        // 根据方向 绘制 坐标
        when(currentDirection){
            Direction.UP -> this.y -= speed
            Direction.DOWN -> this.y += speed
            Direction.LEFT -> this.x -= speed
            Direction.RIGHT -> this.x += speed
        }

        if (x < 0) x = 0
        if (x > Config.WIDTH - this.width) x = Config.WIDTH - this.width
        if (y < 0) y = 0
        if (y > Config.HEIGHT - this.height) y = Config.HEIGHT - this.height

    }


    /**
     * default
     */
    /*override fun willCollision(block: Blockable): Direction? {
    }*/

    override fun notifyCollision(direction: Direction?, block: Blockable?) {

    }

    override fun attack(): Bullet {
        TODO()
    }

    /**
     * 绘制 敌方 坦克
     */
    override fun draw() {
        val dir = when(currentDirection){
            Direction.UP -> "/img...1"
            Direction.DOWN ->"/img...2"
            Direction.LEFT -> "/img...3"
            Direction.RIGHT -> "/img...4"
        }
        Painter.drawImage(dir , x , y)
    }

    /**
     * 随机 方向
     */
    private tailrec fun randomDirection(bad:Direction?):Direction {
        val direction = when (val r = Random().nextInt(4)) {
            0 -> Direction.UP
            1 -> Direction.UP
            2 -> Direction.UP
            3 -> Direction.UP
            else -> TODO()
        }
        return if (direction != bad) direction else randomDirection(direction)

    }


}