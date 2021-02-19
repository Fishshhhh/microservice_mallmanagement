package com.springcloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author 宋雪
 * @Date: 2021/2/10 17:44
 * @Description:
 */
@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
    //自定义接口映射路径
    public static final String DEFAULT_INCLUDE_PATTERN = "/user/.*";
    private final Logger log = LoggerFactory.getLogger(SwaggerConfiguration.class);
    @Bean
    public Docket swaggerSpringfoxDocket(){
        log.debug("Starting Swagger");
        StopWatch watch = new StopWatch();
        watch.start();
        //用于生成对应API接口文档的描述信息，可省略
        ApiInfo apiInfo = new ApiInfo("用户管理API接口测试文档","description","termsOfServiceUrl","contact","version","","");
        DocumentationType documentationType;
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .genericModelSubstitutes(ResponseEntity.class)
                .forCodeGeneration(true)
                .genericModelSubstitutes(ResponseEntity.class)
                .directModelSubstitute(java.time.LocalDate.class,String.class)
                .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
                .directModelSubstitute(java.time.LocalDateTime.class,Date.class)
                .select()
                .paths(regex(DEFAULT_INCLUDE_PATTERN))
                .build();
        watch.stop();
        log.debug("Started Swagger in {} ms",watch.getTotalTimeMillis());
        return docket;
    }

}
