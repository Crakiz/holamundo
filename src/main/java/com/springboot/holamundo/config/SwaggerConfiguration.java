package com.springboot.holamundo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;
 
@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket usersApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(usersApiInfo())
                .select()
                .paths(PathSelectors.ant("/*/**"))
                .apis(RequestHandlerSelectors.basePackage("com.springboot.holamundo.controllers"))
                .build()
                .useDefaultResponseMessages(false);
    }


    /**
     * Api info
     * @return ApiInfo
     */
    private ApiInfo usersApiInfo() {
        return new ApiInfoBuilder()
                .title("Service HolaMundo")
                .version("1.0")
                .license("Apache License Version 2.0")
                .build();
    }


    /**
     * Config paths.
     *
     * @return the predicate
     */
    private Predicate<String> userPaths() {
        return regex("/user.*");
    }
}
