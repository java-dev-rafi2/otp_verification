package com.rafi.john.dev.otp_verification.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

	@Bean
	OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("OTP Verification API").version("1.0")
						.description("API documentation for OTP Generation and Verification"))
				.servers(List.of(new Server().url("/").description("Default Server URL")));
	}
}