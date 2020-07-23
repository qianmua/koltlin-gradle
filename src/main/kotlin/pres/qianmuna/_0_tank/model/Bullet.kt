package pres.qianmuna._0_tank.model

import org.itheima.kotlin.game.core.Painter
import pres.qianmuna._0_tank.enums.Direction

/**
@author HJC
@date 2020/7/23  20:12
@description : 子弹 create() //
@version 1.0
谦谦君子 卑以自牧也
 */
class Bullet(private val direction: Direction,create:(width:Int , height:Int) -> Pair<Int , Int>) :View {

    override var x: Int = 0
    override var y: Int = 0

    override var width: Int = 0
    override var height: Int = 0

    // 子弹 位置
    private val imgUrl = when(direction){
        Direction.UP -> {
            this.x = this.x + (32 - 16) / 2
            this.y = this.y - 32 / 2
            "..1"
        }
        Direction.LEFT -> {
            "..2"
        }
        Direction.RIGHT -> {
            "..3"
        }
        Direction.DOWN -> {
            "..4"
        }
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

}