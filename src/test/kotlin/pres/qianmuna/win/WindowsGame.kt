package pres.qianmuna.win

import javafx.application.Application
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.paint.Color
import org.itheima.kotlin.game.core.Composer
import org.itheima.kotlin.game.core.Painter
import org.itheima.kotlin.game.core.Window

/**
@author HJC
@date 2020/7/19  21:45
@description :
@version 1.0
谦谦君子 卑以自牧也
 */

class WindowsGame :Window(){

    override fun onCreate() {
        println("create windows..")
    }

    override fun onDisplay() {
        // 渲染
//        println("the windows flush..")

        // 放置图片
        Painter.drawImage("" , 0 , 0)

        // draw color
        Painter.drawColor(Color.WHITE , 20 ,20 ,20 , 20)

        //draw text
        Painter.drawText("hello world" , 100 , 100 )
    }

    override fun onKeyPressed(event: KeyEvent) {
        println("log. -> up key word..")
        when( event.code){
            KeyCode.ENTER -> println("enter")
            // music
            KeyCode.A -> Composer.play("")
            else -> println("null key word")
        }
    }

    override fun onRefresh() {
        // flush
        // service
    }

}

fun main() {
    Application.launch(WindowsGame::class.java)
}