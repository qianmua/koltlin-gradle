package pres.qianmuna._0_tank.business

import pres.qianmuna._0_tank.model.View

/**
@author HJC
@date 2020/7/24  13:59
@description : 接受攻击
@version 1.0
谦谦君子 卑以自牧也
 */
interface Sufferable:View {

    /**
     * 被攻击
     *
     * @return 攻击 回调
     */
    fun notifySuffer(attackable: Attackable):Array<View>?

    // 默认生命 大小
    val blood: Int
        get() = 3



}