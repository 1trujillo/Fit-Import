package com.fit_import.Fit_Import.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI fitImportOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API - FitImport Carrito")
                .description("Microservicio que gestiona los ítems del carrito de compras de Fit-Import.")
                .version("1.0.0")
                .contact(new Contact()
                    .name("Jansel Cruz")
                    .email("tu.email@ejemplo.com")
                    .url("https://github.com/1trujillo"))
                .license(new License()
                    .name("Licencia MIT")
                    .url("https://opensource.org/licenses/MIT"))
            );
    }
}

