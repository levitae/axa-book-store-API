package axa.recruitment.axabookstore.config;

import com.google.common.base.Predicates;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .apiInfo(apiInfo());
    }
    
    private ApiInfo apiInfo() {
    return new ApiInfo(
      "AXA Book Store API", 
      "A RESTful API built using Spring Boot, JPA and H2 database", 
      "1.0", 
      "Terms of Service", 
      new Contact("Karina Virgi Agustha", "https://github.com/levitae", "karinavirgi.a@gmail.com"), 
      "License of API", "API license URL", Collections.emptyList());
}
}
