package com.xyz.apis.payment.support.doc;

import com.xyz.apis.payment.controller.PaymentController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(PaymentController.class.getPackage().getName()))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Payment Service", "A service provides API's related to payments and transactions",
                "1.0","Payment Service T&C",author(),"Payment Service License",null,
                Collections.emptyList());
    }

    private Contact author()
    {
        return new Contact("Mohammad Uzair",null,
                "mohduzairbtech@gmail.com");    }
}
