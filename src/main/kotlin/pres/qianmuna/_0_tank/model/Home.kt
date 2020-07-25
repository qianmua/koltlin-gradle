package pres.qianmuna._0_tank.model

import org.itheima.kotlin.game.core.Painter
import pres.qianmuna._0_tank.Config
import pres.qianmuna._0_tank.business.Attackable
import pres.qianmuna._0_tank.business.Blockable
import pres.qianmuna._0_tank.business.Sufferable

/**
@author HJC
@date 2020/7/25  18:11
@description :
@version 1.0
谦谦君子 卑以自牧也
 */

class Home(override var x: Int, override var y: Int)
    :View,Blockable,Sufferable{

    override var blood: Int = 12

    override var width: Int = Config.BLOCK * 2

    override var height: Int = Config.BLOCK + 32

    /**
     * 绘制 home
     */
    override fun draw()  = when {
        this.blood < 4 -> {
            // 修改 块
            this.width = Config.BLOCK
            this.height = Config.BLOCK
            this.x = (Config.WIDTH - Config.BLOCK) / 2
            this.y = Config.HEIGHT - Config.BLOCK
            Painter.drawImage("home", this.x + 32, this.y + 32)
        }
        this.blood < 8 -> drawHome("path1")
        else -> drawHome("path2")
    }

    private fun drawHome(path:String) {
        // 绘制 围墙
        for (i in 0..3) {
            Painter.drawImage(path, this.x + 32 * i, this.y)
        }
        for (i in 1..2) {
            Painter.drawImage(path, this.x, this.y + 32 * i)
            Painter.drawImage(path, this.x + 96, this.y + 32 * i)
        }
        // 绘制 home
        Painter.drawImage("home", this.x + 32, this.y + 32)
    }

    /**
     * 被攻击
     */
    override fun notifySuffer(attackable: Attackable): Array<View>? {
       this.blood -= attackable.attackPower
        if (this.blood == 4 || this.blood == 8)
            return arrayOf(Boom(x , y))
        return
    }

}