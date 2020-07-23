package pres.qianmuna._0_tank

import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import org.itheima.kotlin.game.core.Painter
import org.itheima.kotlin.game.core.Window
import pres.qianmuna._0_tank.business.AutoMovable
import pres.qianmuna._0_tank.business.Blockable
import pres.qianmuna._0_tank.business.Movable
import pres.qianmuna._0_tank.enums.Direction
import pres.qianmuna._0_tank.model.*
import java.io.File

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

    // 图像容器 root
    private val views = arrayListOf<View>()

    // my tank
    private lateinit var tank:Tank

    override fun onCreate() {
        // map create

        // read config
        val file = File(javaClass.getResource("/map/1.map").path)

        // read line
        val lines = file.readLines()
        var lineNum = 0
        lines.forEach { line ->
            var columnNum = 0

            // it : String
            line.toCharArray().forEach {ch ->
                // it : Char
                when(ch){
                    '1' -> views.add(Wall(columnNum++ * Config.BLOCK , lineNum++ * Config.BLOCK))
                    '2' -> views.add(Steel(columnNum++ * Config.BLOCK , lineNum++ * Config.BLOCK))
                    '3' -> views.add(Grass(columnNum++ * Config.BLOCK , lineNum++ * Config.BLOCK))
                    else -> pass()
                }
            }
        }

        tank = Tank(Config.BLOCK * 10, Config.BLOCK * 12)
        views.add(tank)

    }

    // 绘制
    //不停的 刷新//
    override fun onDisplay() {
        // draw img
        views.forEach { it.draw() }

    }

    override fun onKeyPressed(event: KeyEvent) {

        // move tank // dir
        when(event.code){
            KeyCode.W -> tank.moveTank(Direction.UP)
            KeyCode.A -> tank.moveTank(Direction.LEFT)
            KeyCode.S -> tank.moveTank(Direction.DOWN)
            KeyCode.D -> tank.moveTank(Direction.RIGHT)
            //attack
            KeyCode.K -> {
                var bullet = tank.attack()
                // views
                views.add(bullet)

            }
        }
    }

    // server
    override fun onRefresh() {

        // 判断 是否 碰撞

        // move
        //block
        views.filterIsInstance<Movable>()
            .forEach {mov ->

                // tag 碰撞
                var badColl:Direction? = null
                var badBlock:Blockable? = null

                views.filterIsInstance<Blockable>()
                    .forEach blockTag@ {block ->
                        // 碰撞

                        // 碰撞 方向
                        val dir = mov.willCollision(block)

                        // 碰撞？ 跳出
                        dir?.let {
                            badColl = dir
                            badBlock = block
                            return@blockTag
                        }
                    }

                // search block
                // notify msg to mover will collision
                mov.notifyCollision(badColl , badBlock)
            }

        // 子弹 移动
        views.filterIsInstance<AutoMovable>().forEach {
            // 移动
            it.autoMovable()
        }


    }


    private fun pass(){}

}