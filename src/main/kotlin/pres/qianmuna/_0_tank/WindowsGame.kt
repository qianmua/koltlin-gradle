package pres.qianmuna._0_tank

import javafx.scene.input.KeyEvent
import org.itheima.kotlin.game.core.Painter
import org.itheima.kotlin.game.core.Window
import pres.qianmuna._0_tank.model.Wall

/**
@author HJC
@date 2020/7/19  22:06
@description :
@version 1.0
谦谦君子 卑以自牧也
 */

class WindowsGame :Window(
    title = "tank game v1.0" ,
    icon = "path" ,
    width = Config.WIDTH ,
    height = Config.HEIGHT){

    private val wall  = Wall()

    override fun onCreate() {
    }

    override fun onDisplay() {
        // draw img


        // draw wall
        wall.draw()

        //draw grass
        Painter.drawImage("" , 20,20)
    }

    override fun onKeyPressed(event: KeyEvent) {
    }

    override fun onRefresh() {
    }

}