package pres.qianmuna._0_tank

import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import jdk.nashorn.internal.ir.Block
import org.itheima.kotlin.game.core.Window
import pres.qianmuna._0_tank.business.*
import pres.qianmuna._0_tank.enums.Direction
import pres.qianmuna._0_tank.model.*
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.util.concurrent.CopyOnWriteArrayList

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
    // 多线程
    // juc CopyOnWriteArrayList
    private val views = CopyOnWriteArrayList<View>()

    // my tank
    private lateinit var tank:Tank

    // 游戏结束
    private var gameovre = false

    // 最大 敌人数
    private var enemyTotalSize = 15
    // 激活数
    private var enemyActiveSize = 5
    // 出生点
    private val enemyLocation = arrayListOf<Pair<Int, Int>>()
    // 出生点 轮询
    private var bornIndex = 0

    override fun onCreate() {
        // map create

        // read config
        // 打包路径 找不到 的问题
//        val file = File(javaClass.getResource("/map/1.map").path)
        val stream = javaClass.getResourceAsStream("...")
        val reader = BufferedReader(InputStreamReader(stream , "utf-8"))

        // read line
        val lines = reader.readLines()
        var lineNum = 0
        lines.forEach { line ->
            var columnNum = 0

            // it : String
            line.toCharArray().forEach {ch ->
                // it : Char
                when(ch){
                    // 墙
                    '1' -> views.add(Wall(columnNum++ * Config.BLOCK , lineNum++ * Config.BLOCK))
                    // 铁
                    '2' -> views.add(Steel(columnNum++ * Config.BLOCK , lineNum++ * Config.BLOCK))
                    // 艹
                    '3' -> views.add(Grass(columnNum++ * Config.BLOCK , lineNum++ * Config.BLOCK))
                    // 水
                    '4' -> views.add(Water(columnNum++ * Config.BLOCK , lineNum++ * Config.BLOCK))
                    // 敌
                    '5' -> enemyLocation.add(Pair(columnNum++ * Config.BLOCK , lineNum++ * Config.BLOCK))
                    else -> pass()
                }
            }
        }

        // 我方
        tank = Tank(Config.BLOCK * 10, Config.BLOCK * 12)
        views.add(tank)

        // home
        val home = Home(Config.WIDTH / 2 - Config.BLOCK , Config.HEIGHT - 96)
        views.add(home)

    }

    // 绘制
    //不停的 刷新//
    override fun onDisplay() {
        // draw img
        views.forEach { it.draw() }

    }

    override fun onKeyPressed(event: KeyEvent) {

        if (gameovre)
            return

        // move tank // dir
        when(event.code){
            KeyCode.W -> tank.moveTank(Direction.UP)
            KeyCode.A -> tank.moveTank(Direction.LEFT)
            KeyCode.S -> tank.moveTank(Direction.DOWN)
            KeyCode.D -> tank.moveTank(Direction.RIGHT)
            //attack
            KeyCode.K -> {
                val bullet = tank.attack()
                // views
                views.add(bullet)

            }
        }
    }

    // server
    override fun onRefresh() {

        // 销毁
        // attack destroy
        views.filterIsInstance<Destroyable>().forEach {

            if (it.isDestroyed())
                views.remove(it)

            // 敌方 容器
            if (it is TankEnemy)
                enemyTotalSize --

            val destroy = it.showDestory()
            destroy?.let { views.addAll(destroy) }
        }

        // 结束 游戏
        if (gameovre)
            return

        // 判断 是否 碰撞

        // move
        //block
        views.filterIsInstance<Movable>()
            .forEach {mov ->

                // tag 碰撞
                var badColl:Direction? = null
                var badBlock:Blockable? = null

                // 过滤 自己
                views.filter { (it is Blockable) and ( mov != it) }
                    .forEach blockTag@ {block ->
                        block as Blockable
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

        // 检测 攻击 碰撞
        views.filterIsInstance<Attackable>()
            .forEach { atk ->
            views.filterIsInstance<Sufferable>()
                    // 过滤 自己
                    // 自己打自己。。。。
                .filter { (atk.owner != it) and (atk != it) }
                .forEach suf@{ suf ->
                // 产生 碰撞
                if (atk.isAttacked(suf)){

                    // 通知 碰撞
                    atk.notifyAttack(suf)

                    // 遭受 攻击
                    val view = suf.notifySuffer(atk)
                    // 被攻击
                    view?.let {
                        views.addAll(view)
                    }

                    return@suf
                }
            }
        }

        // 敌方 出生
        if ( (enemyTotalSize > 0) and (views.filterIsInstance<TankEnemy>().size < enemyActiveSize) ){
            val pair = enemyLocation[bornIndex++ % enemyLocation.size]
            views.add(TankEnemy(pair.first , pair.second))
        }

        // 检测 自动射击
        // 容器 管理
        views.filterIsInstance<AutoAttack>().forEach {
            val autoAttack = it.autoAttack()
            autoAttack?.let {
                views.add(autoAttack)
            }
        }
        // game over
        if ( (views.filterIsInstance<Home>().isEmpty()) or ( enemyTotalSize <= 0) )
            gameovre  = true
    }


    private fun pass(){}

}