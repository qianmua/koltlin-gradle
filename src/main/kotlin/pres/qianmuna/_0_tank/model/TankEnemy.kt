package pres.qianmuna._0_tank.model

import org.itheima.kotlin.game.core.Painter
import pres.qianmuna._0_tank.Config
import pres.qianmuna._0_tank.business.*
import pres.qianmuna._0_tank.enums.Direction
import java.util.*

/**
@author HJC
@date 2020/7/24  16:26
@description : 敌方 坦克
@version 1.0
谦谦君子 卑以自牧也
 */

class TankEnemy(
    override var x: Int, override var y: Int)
    :Movable,AutoMovable,Blockable,AutoAttack,Sufferable{

    override var currentDirection: Direction = Direction.DOWN

    // 修改 方向
    private val badDirection:Direction? = null

    override val speed: Int = 8

    override var blood: Int = 4

    /**
     * 距离 上次触发时间
     */
    private var lastAutoTime = 0L

    /**
     * 频率
     */
    private val attackCD = 700

    private var moveAutoTime = 0L

    private val moveCD = 50

    override fun autoMovable() {
        // 检测 cd
        val millis = System.currentTimeMillis()
        if (millis - moveAutoTime < moveCD)
            return
        moveAutoTime = millis

        // 方向 重叠
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

    /**
     * 自动 攻击
     */
    override fun autoAttack(): View? {
        // 检测 cd
        val millis = System.currentTimeMillis()
        if (millis - lastAutoTime < attackCD)
            return null
        lastAutoTime = millis



        return Bullet(currentDirection){ bW , bH ->
            var bX = 0
            var bY = 0
            val tW = this.width
            val tH = this.height

            when(currentDirection){
                Direction.UP -> {
                    bX = this.x + (tW - bW) / 2
                    bY = this.y - bH / 2
                }
                Direction.DOWN -> {
                    bX = this.x + (tW - bW) / 2
                    bY = this.y + tH - bH / 2
                }
                Direction.RIGHT -> {
                    bX = this.x + tW - bW / 2
                    bY = this.y + (tH - bH) / 2
                }
                Direction.LEFT -> {
                    bX = this.x - bX / 2
                    bY = this.y + (tH + bH) / 2
                }
            }
            Pair(bX , bY)
        }
    }

    /**
     * 被攻击
     */
    override fun notifySuffer(attackable: Attackable): Array<View>? {
        this.blood -= attackable.attackPower
        return arrayOf(Boom(this.x , this.y))
    }

}