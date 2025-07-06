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
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API de Fit Import")
                .version("1.0.0")
                .description("Documentación de la API para gestión de productos y usuarios del sistema Fit Import.")
                .contact(new Contact()
                    .name("Soporte Fit Import")
                    .email("soporte@fitimport.com"))
                .license(new License()
                    .name("Licencia MIT")
                    .url("https://opensource.org/licenses/MIT"))
            );
    }
}

