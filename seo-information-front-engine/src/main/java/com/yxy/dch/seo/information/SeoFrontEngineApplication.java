package com.yxy.dch.seo.information;

import com.yxy.dch.seo.information.config.pros.FrontEngineProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableConfigurationProperties(FrontEngineProperties.class)
public class SeoFrontEngineApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeoFrontEngineApplication.class, args);
    }
}
