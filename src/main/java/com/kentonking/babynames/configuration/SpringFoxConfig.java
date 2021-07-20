package com.kentonking.babynames.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    @Bean
    public Docket apiDocket() {

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kentonking.babynames"))
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .apiInfo(apiInfoDetails());
    }

    private ApiInfo apiInfoDetails() {
        return new ApiInfo(
                "Baby Names API",
                "The api provides information about baby names from 1880 to 2014. <strong>** Data pertains to the United States exclusively. **</strong>",
                "1.0",
                "https://kentonking.tech/free-to-use",
                new springfox.documentation.service.Contact("Kenton King", "https://kentonking.tech", "contact@kentonking.tech"),
                "MIT License",
                "https://kentonking.tech/free-to-use",
                Collections.emptyList()
        );
    }
}