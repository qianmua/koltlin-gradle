package pres.qianmuna._0_tank.model

import org.itheima.kotlin.game.core.Painter
import pres.qianmuna._0_tank.Config

/**
@author HJC
@date 2020/7/19  22:21
@description :
@version 1.0
谦谦君子 卑以自牧也
 */
class Wall :View{
    // location
    override var x:Int = 1
    override var y:Int = 2
    // width height
    override var width:Int = Config.BLOCK
    override var height:Int = Config.BLOCK

    // show
    override fun draw(){
        Painter.drawImage("" , x , y)
    }
}