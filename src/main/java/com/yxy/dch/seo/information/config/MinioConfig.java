package com.yxy.dch.seo.information.config;

import com.yxy.dch.seo.information.config.pros.MinioProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * minio配置
 *
 * @author yangzhen
 */
@Configuration
@EnableConfigurationProperties(MinioProperties.class)
public class MinioConfig {
}
