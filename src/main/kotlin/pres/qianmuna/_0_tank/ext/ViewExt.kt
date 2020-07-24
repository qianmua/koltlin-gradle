package pres.qianmuna._0_tank.ext

import pres.qianmuna._0_tank.model.View

/**
@author HJC
@date 2020/7/24  14:29
@description : 扩展包
@version 1.0
谦谦君子 卑以自牧也
 */

/**
 * 重载
 */
fun View.checkCollision(view: View):Boolean = checkCollision(x,y,width,height,view.x,view.y,view.width,view.height)

