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

    private var badDir:Direction? = null

    /**
     * 检测 碰撞
     *
     * //
     * 预判
     */
    override fun willCollision(block: Blockable): Direction? {

        var x = this.x
        var y = this.y

        when(this.currentDirection){

            Direction.UP -> y -= speed
            Direction.DOWN -> y += speed
            Direction.LEFT -> x -= speed
            Direction.RIGHT -> x += speed

        }

        // 碰撞检测
        val coll = checkCollision(block.x, block.y , block.width ,block.height,
            x,y,this.width , this.height)

        /*val coll = when {

            block.y + block.height <= y -> false

            y + this.height <= block.y -> false

            block.x + block.width <= x -> false

            else -> x + this.width > block.x
        }*/

        return if (coll)
            currentDirection
        else
            null
    }


    /**
     * 接收碰撞
     */
    override fun notifyCollision(direction: Direction?, block: Blockable?) {
        this.badDir = direction
    }

    /**
     * 发射子弹
     */
    override fun attack(): Bullet = Bullet(this.currentDirection ){ bW , bH ->
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

    /**
     * tank 移动
     */
    fun moveTank(direction: Direction){

        // change direction
        if (this.currentDirection != direction){
            this.currentDirection = direction
            return
        }

        // collision
        if (direction == this.badDir)
            return

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