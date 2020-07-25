package pres.qianmuna._0_tank.model

import org.itheima.kotlin.game.core.Painter
import pres.qianmuna._0_tank.Config
import pres.qianmuna._0_tank.business.Attackable
import pres.qianmuna._0_tank.business.Blockable
import pres.qianmuna._0_tank.business.Sufferable

/**
@author HJC
@date 2020/7/19  22:25
@description :
@version 1.0
谦谦君子 卑以自牧也
 */
class Steel(override val x: Int, override val y: Int) :Blockable,Sufferable {

    // location


    // width height
    override var width:Int = Config.BLOCK
    override var height:Int = Config.BLOCK

    // show
    override fun draw(){
        Painter.drawImage("" , x , y)
    }

    /**
     * 不被 攻击
     */
    override fun notifySuffer(attackable: Attackable): Array<View>? = null


}