package pres.qianmuna._mybatis_plus_.controller

import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import pres.qianmuna._mybatis_plus_.`do`.UserDO
import pres.qianmuna._mybatis_plus_.mapper.UserMapper
import java.util.*

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


    @GetMapping("/testAdd")
    @ResponseBody
    fun addTest():String{

        userMapper.insert(UserDO(null,"22" ,null , null))
        return "success"
    }

    @GetMapping("/testUpdate")
    fun updateTest():String{
//        userMapper.update(UserDO(1,"hhh",null , null) , null)
        userMapper.updateById(UserDO(1,"hhh",null , null) )
        return "success"
    }


    @GetMapping("/testLock")
    fun lockVersion():String{
        userMapper.selectById(123456)
        userMapper.updateById(UserDO(1,"hhh") )

        return "Success"
    }

    @GetMapping("/testMoreId")
    fun moreId():String{
        userMapper.selectBatchIds(listOf(1,23,4,56))

        // map
        userMapper.selectByMap(mapOf("name" to "jone" , "age" to 11))

        //wrapper // 条件查询器

        return "success"
    }


    @GetMapping("/testPage")
    fun page():String{

        val page = Page<UserDO>(1,10)

        userMapper.selectPage(page , null)

        page.current // 当前页
        page.records // 数据页
        page.size // 每页数量
        page.total // 总数
        page.pages // 总页数

        page.hasNext() // 有无下一页
        page.hasPrevious() // 有无下一页




        return "success"
    }


}