package com.cars365.Cars365Apg.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class JwtValidationFilter extends AbstractGatewayFilterFactory<JwtValidationFilter.Config> {

    @Value("${auth.service.url}")
    private String authServiceUrl;

    private final RestTemplate restTemplate;

    public JwtValidationFilter(RestTemplate restTemplate) {
        super(Config.class);
        this.restTemplate = restTemplate;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // Extract Authorization header
            String token = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

            if (token != null && token.startsWith("Bearer ")) {
                token = token.substring(7);  // Extract the token without "Bearer "

                try {
                    // Prepare headers for the auth validation request
                    HttpHeaders authHeaders = new HttpHeaders();
                    authHeaders.set(HttpHeaders.AUTHORIZATION, "Bearer " + token);
                    HttpEntity<Void> requestEntity = new HttpEntity<>(authHeaders);

                    // Call Auth Service to validate the token
                    ResponseEntity<String> validationResponse = restTemplate.exchange(
                            authServiceUrl, HttpMethod.GET, requestEntity, String.class);

                    // If validation is successful (you can customize this as needed)
                    if ("Success".equalsIgnoreCase(validationResponse.getBody())) {
                        return chain.filter(exchange);
                    }
                } catch (Exception e) {
                    // Handle exception (logging, etc.)
                    e.printStackTrace();
                }
            }

            // If JWT is invalid or not present, return Unauthorized
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        };
    }

    public static class Config {
        // Configuration properties for the filter
    }
}