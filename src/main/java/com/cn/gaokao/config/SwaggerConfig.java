package com.cn.gaokao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cn.gaokao.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(
                        new ApiInfoBuilder()
                                .title("gaokao接口文档")
                                .description("接口文档")
                                .termsOfServiceUrl("localhost:8080/swagger-ui.html")
                                .contact(new Contact("author", "localhost:8080/swagger-ui.html", "110@qq.com"))
                                .version("1.0")
                                .build()
                );
    }
}