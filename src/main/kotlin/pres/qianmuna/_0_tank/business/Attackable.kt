package pres.qianmuna._0_tank.business

import pres.qianmuna._0_tank.model.View

/**
@author HJC
@date 2020/7/24  13:59
@description : attack
@version 1.0
谦谦君子 卑以自牧也
 */
interface Attackable:View {

    /**
     * 判断碰撞
     */
    fun isAttacked(sufferable: Sufferable):Boolean

    /**
     * 通知攻击
     */
    fun notifyAttack(sufferable: Sufferable)
}