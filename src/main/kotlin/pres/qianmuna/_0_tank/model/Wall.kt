package pres.qianmuna._0_tank.model

import org.itheima.kotlin.game.core.Painter
import pres.qianmuna._0_tank.Config
import pres.qianmuna._0_tank.business.Attackable
import pres.qianmuna._0_tank.business.Blockable
import pres.qianmuna._0_tank.business.Destroyable
import pres.qianmuna._0_tank.business.Sufferable

/**
@author HJC
@date 2020/7/19  22:21
@description : 阻挡 掉血 销毁
@version 1.0
谦谦君子 卑以自牧也
 */
class Wall(override val x: Int, override val y: Int) : Blockable,Sufferable ,Destroyable{
    // location

    // width height
    override var width:Int = Config.BLOCK
    override var height:Int = Config.BLOCK

    override var blood: Int = 0
        get() = super.blood

    // show
    override fun draw(){
        Painter.drawImage("" , x , y)
    }

    /**
     * 可被攻击
     */
    override fun notifySuffer(attackable: Attackable) {
        //被抓啦~~
        blood -= attackable.attackPower

    }

    /**
     * 检测 销毁
     */
    override fun isDestroyed(): Boolean = blood <= 0
}