package com.emsby.empmanager.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义的配置类
 * create by lichengong on 2021124
 */
@Configuration
public class myEmpConfig implements WebMvcConfigurer{
    /*将mybatis的分页查询的中间件注入到spring容器中进行管理*/
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

}
