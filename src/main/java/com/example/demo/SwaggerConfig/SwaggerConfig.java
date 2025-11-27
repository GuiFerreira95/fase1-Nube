package com.example.demo.SwaggerConfig;

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
                .description("Documentação da API do projeto Nube")
                .version("1.0.0"));
    }
}
