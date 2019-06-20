package com.xu.xu7x.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>
 *     spring boot2 注意加载静态资源问题：
 *
 * </p>
 * @author xuhongda on 2019/6/12
 * com.xu.bootweb.config
 * com-boot-ex
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 拦截 url 中带有 /static 的请求 ，映射到 static 目录
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //favicon.ico 图标
        registry.addResourceHandler("/favicon.ico").addResourceLocations("classpath:/static/");
    }

}
