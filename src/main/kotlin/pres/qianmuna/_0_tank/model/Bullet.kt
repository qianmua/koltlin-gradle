package pres.qianmuna._0_tank.model

import org.itheima.kotlin.game.core.Painter
import pres.qianmuna._0_tank.Config
import pres.qianmuna._0_tank.business.Attackable
import pres.qianmuna._0_tank.business.AutoMovable
import pres.qianmuna._0_tank.business.Destroyable
import pres.qianmuna._0_tank.enums.Direction

/**
@author HJC
@date 2020/7/23  20:12
@description : 子弹 create() // 闭包
@version 1.0
谦谦君子 卑以自牧也
 */
class Bullet(
    override val currentDirection: Direction,
    create:(width:Int , height:Int) -> Pair<Int , Int>)
    :AutoMovable,Destroyable ,Attackable {

    override var x: Int = 0
    override var y: Int = 0

    override var width: Int = 0
    override var height: Int = 0

    // 子弹 位置
    private val imgUrl = when(currentDirection){
        Direction.UP -> "..1"
        Direction.LEFT -> "..2"
        Direction.RIGHT -> "..3"
        Direction.DOWN -> "..4"

    }

    init {

        val size = Painter.size(imgUrl)

        this.width = size[0]
        this.height = size[1]

        val pair = create.invoke(this.width, this.height)
        this.x = pair.first
        this.y = pair.second
    }


    /**
     * 画 子弹
     */
    override fun draw() {


        // 绘制子弹
        Painter.drawImage(imgUrl , this.x , this.y)
    }


    /**
     * 子弹 飞行
     */
    override fun autoMovable() {
        // 根据方向 绘制 坐标
        when(currentDirection){
            Direction.UP -> this.y -= super.speed
            Direction.DOWN -> this.y += super.speed
            Direction.LEFT -> this.x -= super.speed
            Direction.RIGHT -> this.x += super.speed
        }

    }


    /**
     * 过期 销毁
     * 离开 屏幕 销毁
     */
    override fun isDestroyed(): Boolean = (this.x < this.width
            || this.x > Config.WIDTH
            || this.y < this.height
            || this.y > Config.WIDTH)

}