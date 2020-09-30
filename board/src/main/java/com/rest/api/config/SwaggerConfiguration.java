package com.rest.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(swaggerInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.rest.api.controller"))
                .paths(PathSelectors.any())
                .build()
                // 기본으로 세팅되는 200,401,403,404 메시지를 표시 하지 않음
                .useDefaultResponseMessages(false);
    }

    // 본 설정값은 https://daddyprogrammer.org/post/313/swagger-api-doc/ 블로그를 참고하여 제작하였습니다.
    private ApiInfo swaggerInfo() {
        return new ApiInfoBuilder().title("Spring API Documentation")
                .description("SpringBoot로 제작한 rest api 입니다.")
                .license("JeonInWoo").licenseUrl("http://hodolee246.tistory.com/").version("1").build();
    }
}