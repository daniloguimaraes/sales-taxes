package com.daniloguimaraes.salestaxes.config;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.util.Collections;

/**
 * Swagger2 configuration.
 *
 * @author Danilo Guimarães
 * @since 21/07/2018
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Autowired
    private ResourceLoader resourceLoader;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        String description = "Some information...";

        try {
            description = IOUtils.toString(
                    resourceLoader.getResource("classpath:static/api-description.html").getInputStream(), "UTF-8");
        } catch (IOException e) {
            System.err.println(e);
        }

        return new ApiInfo(
                "Sales Taxes",
                description,
                "0.0.1-SNAPSHOT",
                "Terms of service",
                new Contact("Danilo Guimarães", "www.example.com", "guimaraesl.djl@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
