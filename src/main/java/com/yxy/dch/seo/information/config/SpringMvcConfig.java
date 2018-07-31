package com.yxy.dch.seo.information.config;

import com.yxy.dch.seo.information.config.convert.JsonMessageConverter;
import com.yxy.dch.seo.information.config.filter.ApiInterceptor;
import com.yxy.dch.seo.information.config.filter.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * springmvc基础配置类
 *
 * @author yangzhen
 */
@Configuration
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 自定义消息转换器，用于统一封装响应数据。全部用json去处理
     *
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.clear();
        converters.add(jsonMessageConverter());
    }

    @Bean
    public JsonMessageConverter jsonMessageConverter() {
        return new JsonMessageConverter();
    }


    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Bean
    public ApiInterceptor apiInterceptor() {
        return new ApiInterceptor();
    }

    /**
     * 请求拦截配置
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiInterceptor())
                .addPathPatterns(
                        "/api/**",
                        "/data/import",
                        "/swagger/**",
                        "/swagger-resources/**");
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns(
                        "/api/**",
                        "/data/import",
                        "/swagger/**",
                        "/swagger-resources/**")
                .excludePathPatterns(
                        "/api/login"
                );
        super.addInterceptors(registry);
    }

    /**
     * 处理跨域问题
     */
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");//允许域。若是所有：*
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
