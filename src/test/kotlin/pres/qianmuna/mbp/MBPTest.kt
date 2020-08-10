package pres.qianmuna.mbp

import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import pres.qianmuna._mybatis_plus_.mapper.UserMapper

/**
@author HJC
@date 2020/8/10  17:08
@description :
@version 1.0
谦谦君子 卑以自牧也
 */
open class MBPTest {

    @Autowired
    private lateinit var userMapper: UserMapper

    @Test
    fun m1(){
        val list = userMapper.selectList(null)
        list.forEach { println(it) }
    }
}