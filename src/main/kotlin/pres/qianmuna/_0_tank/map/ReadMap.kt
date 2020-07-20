package pres.qianmuna._0_tank.map

import pres.qianmuna._0_tank.Config
import pres.qianmuna._0_tank.model.Wall
import java.io.File

/**
@author HJC
@date 2020/7/19  22:46
@description :
@version 1.0
谦谦君子 卑以自牧也
 */

class ReadMap {

    /**
     * read map
     */
    fun readMap(){
        val file = File(javaClass.getResource("/map/1.map").path)
        // lines
        var line = 0
        // read line
        var lines = file.readLines()
        lines.forEach {
            var column = 0
            it.toCharArray().forEach {
                when(it){
                    'A' -> Wall(column * Config.BLOCK , line * Config.BLOCK)
                    'B' -> Wall(column * Config.BLOCK , line * Config.BLOCK)
                }
            }
            column++
            line++
        }
    }
}