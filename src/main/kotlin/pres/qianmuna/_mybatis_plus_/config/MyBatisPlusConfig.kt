package pres.qianmuna._mybatis_plus_.config

import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector
import com.baomidou.mybatisplus.core.injector.ISqlInjector
import com.baomidou.mybatisplus.extension.injector.methods.LogicDeleteByIdWithFill
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

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

    // 逻辑删
    // 3.1.1 不需要
    /*@Bean
    open fun sqlInjector():ISqlInjector =
        LogicSqlInjector()*/


    /**
     * 性能分析
     * 3.2 推荐第三方
     */
    /*@Bean
    @Profile( "dev" , "test") // 生效 环境
    open fun performanceMonitorInterceptor():PerformanceMonitorInterceptor  {
        val interceptor = PerformanceMonitorInterceptor()
    }*/



}