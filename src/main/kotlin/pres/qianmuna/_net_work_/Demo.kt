package pres.qianmuna._net_work_

import java.net.HttpURLConnection
import java.net.URL

/**
@author HJC
@date 2020/7/21  19:37
@description :
@version 1.0
谦谦君子 卑以自牧也
 */
class Demo {
    companion object{
        fun urlTest(){
            val url = "http://www.baidu.com"
            //打开到此 URL 的连接，并返回一个输入流 InputStream 对象
            URL(url).openStream().use { input ->
                input.bufferedReader().forEachLine {
                    println(it)
                }
            }
        }

        private const val url = "http://wallpaper.apc.360.cn/index.php?c=WallPaper&start=85&count=12&from=360chrome&a=getAppsByCategory&cid=6"
        fun UrlConnTest(){
            var conn:HttpURLConnection? = null
            conn = URL(url).openConnection() as? HttpURLConnection

            conn?.connect()

            conn?.inputStream.use { input ->
                var text = input?.bufferedReader()?.readText()

                println(text)
            }

            conn?.disconnect()
        }
    }
}

fun main() {
    Demo.UrlConnTest()
}