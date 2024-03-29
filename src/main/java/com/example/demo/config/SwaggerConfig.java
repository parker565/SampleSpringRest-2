package com.example.demo.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	//http://localhost:8080/v2/api-docs
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metaData());
	}
	
	private ApiInfo metaData() {
        Collection<VendorExtension> av= new ArrayList<VendorExtension>();
		ApiInfo apiInfo = new ApiInfo("Spring Boot REST API","Spring Boot REST API for Employee Info",
                "1.0","Terms of service",  
                new Contact("John", "https://spring.io", "john@demo.com"),
               "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0", av);
        return apiInfo;
    }
}