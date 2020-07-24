package pres.qianmuna._0_tank.model

import org.itheima.kotlin.game.core.Painter
import pres.qianmuna._0_tank.business.Destroyable

/**
@author HJC
@date 2020/7/24  16:16
@description : 爆炸
@version 1.0
谦谦君子 卑以自牧也
 */
class Boom(override val x: Int, override val y: Int) :Destroyable{


    private val imgPath = ArrayList<String>()
    // 图片指针
    private var index = 0

    init {
        (1..32).forEach { imgPath.add("img.../...$it...jpg") }
    }

    /**
     * 绘制 爆炸 显示
     */
    override fun draw() {

        Painter.drawImage(imgPath[ (index++) %imgPath.size ] , x , y)

    }

    /**
     * 销毁
     */
    override fun isDestroyed(): Boolean = index > imgPath.size

}