package com.example.etiqa_demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
        contact = @Contact(
            name = "Chung Ho Sam",
            email = "samhoho998@gmail.com"
        ),
        description = "OpenAPI documentation for Etiqa technical assessment",
        title = "OpenAPI documentation - Etiqa technical assessment"
    ),
    servers = {
        @Server(
            description = "Local env",
            url = "http://localhost:8080"
        )
    }
)
public class OpenApiConfig {
}
