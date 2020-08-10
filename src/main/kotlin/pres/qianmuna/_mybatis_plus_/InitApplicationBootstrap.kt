package pres.qianmuna._mybatis_plus_

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
@author HJC
@date 2020/8/10  17:01
@description :
@version 1.0
谦谦君子 卑以自牧也
 */
@SpringBootApplication
@MapperScan(basePackages = ["pres.qianmuna._mybatis_plus_.mapper"])
open class InitApplicationBootstrap

fun main(args: Array<String>) {
    SpringApplication.run(InitApplicationBootstrap::class.java , *args)
}
