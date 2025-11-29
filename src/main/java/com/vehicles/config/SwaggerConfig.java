package com.vehicles.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI apiInfo() {
        return new OpenAPI()
            .info(new Info()
                .title("API Veículos")
                .description("Documentação da API de veiculos para o projeto Nube")
                .version("1.0.0"));
    }
}
