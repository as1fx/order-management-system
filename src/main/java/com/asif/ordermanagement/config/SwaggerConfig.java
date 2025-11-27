package com.asif.ordermanagement.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    private static final String security = "BearerAuth";

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title("Order Management & Delivery System Tracking")
                        .description("Backend API documentation for Order Management System (Spring Boot + MySQL + JWT)")
                        .version("1.0")
                )
                .addSecurityItem(new SecurityRequirement()
                        .addList(security)
                )
                .components(new Components()
                        .addSecuritySchemes(security, new SecurityScheme()
                                .name(security)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                        )
                );
    }
}
