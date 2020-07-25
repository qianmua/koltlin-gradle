package pres.qianmuna._0_tank.business

import pres.qianmuna._0_tank.model.View


/**
@author HJC
@date 2020/7/23  21:34
@description :
@version 1.0
谦谦君子 卑以自牧也
 */
interface Destroyable : View {

    /**
     * 是否销毁
     */
    fun isDestroyed():Boolean

    /**
     * deal
     */
    fun showDestory():Array<View>?{return null}

}