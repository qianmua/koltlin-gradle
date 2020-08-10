package pres.qianmuna._mybatis_plus_.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import pres.qianmuna._mybatis_plus_.`do`.UserDO
import pres.qianmuna._mybatis_plus_.mapper.UserMapper

/**
@author HJC
@date 2020/8/10  17:26
@description :
@version 1.0
谦谦君子 卑以自牧也
 */
@Controller
open class TestController {


    @Autowired
    private lateinit var userMapper: UserMapper

    @GetMapping("/test1")
    @ResponseBody
    fun queryAll():List<UserDO>?{
        val list = userMapper.selectList(null)
        println(list)
        return list

    }
}