package pres.qianmuna._mybatis_plus_.`do`

import com.baomidou.mybatisplus.annotation.*
import java.util.*

/**
@author HJC
@date 2020/8/10  17:03
@description :
@version 1.0
谦谦君子 卑以自牧也
 */
@TableName("cms_ad_type")
data class UserDO (
    // auto 自动增长
    //ID_worker         // mp自带策略 生成 19位得值 // 数字类型 可以用这种
    //id_worker_str     // 字符串类型 使用这种
    //input // 手动输入
    //none 输入
    // uuid uuid
    //
    @TableId( type = IdType.AUTO)
    private val id:Long? ,
    private val title:String? ,
    @TableField( fill = FieldFill.INSERT)
    private val gmtCreate:Date? = Date() ,
    @TableField( fill = FieldFill.INSERT_UPDATE)
    private val gmtModified:Date? = Date() ,
    @Version
    private val version:Int? = 0)