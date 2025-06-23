package com.serviciosArtisticos.servicios.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    public static final String API_VERSION = "v1";
    public static final String API_TITLE = "Servicios Artísticos";
    public static final String API_DESCRIPTION = "API REST para gestionar reservas y servicios artísticos";

    @Bean
    public OpenAPI springDocOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title(API_TITLE)
                        .version(API_VERSION)
                        .description(API_DESCRIPTION)
                );
    }


}
