package pres.qianmuna._mybatis_plus_.handler

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler
import org.apache.ibatis.reflection.MetaObject
import org.springframework.stereotype.Component
import java.util.*

/**
@author HJC
@date 2020/8/10  17:58
@description :
@version 1.0
谦谦君子 卑以自牧也
 */
@Component
class DateObjectHandler :MetaObjectHandler {

    //添加
    // metaObject 元数据 // 原类型
    override fun insertFill(metaObject: MetaObject?) {
        this.setFieldValByName("gmtCreate" , Date() , metaObject)
        this.setFieldValByName("gmtModified" , Date() , metaObject)
    }

    //修改
    override fun updateFill(metaObject: MetaObject?) {
        this.setFieldValByName("gmtModified" , Date() , metaObject)
    }

    /*
    * ax + by = m
    * cx + dy = n
    * y = (m - ax) / b
    * cbx + (dm - adx) = nb
    * dbx - adx = nb - dm
    * bx - ax = nb/d - m
    * x (b - a) = nb/d - m
    * x = ([nb/d] - m) / ( b - a)
    *
    * x(a - c) + y(b - d) = m - n
    * y = [m - n - x(a - c)] / (b - d)
    *
    * */

}