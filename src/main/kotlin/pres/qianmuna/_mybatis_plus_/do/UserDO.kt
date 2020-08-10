package pres.qianmuna._mybatis_plus_.`do`

import com.baomidou.mybatisplus.annotation.TableName

/**
@author HJC
@date 2020/8/10  17:03
@description :
@version 1.0
谦谦君子 卑以自牧也
 */
@TableName("cms_ad_type")
data class UserDO (
    private val id:Long? ,
    private val title:String? ,
    private val gmtCreate:String? ,
    private val gmtModified:String? )