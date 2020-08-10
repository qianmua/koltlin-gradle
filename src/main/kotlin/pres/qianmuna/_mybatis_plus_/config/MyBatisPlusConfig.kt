package pres.qianmuna._mybatis_plus_.config

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
@author HJC
@date 2020/8/10  18:18
@description :
@version 1.0
谦谦君子 卑以自牧也
 */
@Configuration
open class MyBatisPlusConfig {

    /**
     * 乐观锁 插件
     */
    @Bean
    open fun optimisticLockerInterceptor():OptimisticLockerInterceptor =
        OptimisticLockerInterceptor()


    /**
     * 分页插件
     */
    @Bean
    open fun paginationInterceptor():PaginationInterceptor =
        PaginationInterceptor()
}