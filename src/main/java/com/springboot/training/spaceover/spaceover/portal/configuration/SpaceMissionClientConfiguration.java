package com.springboot.training.spaceover.spaceover.portal.configuration;

import com.springboot.training.spaceover.spaceover.portal.service.*;
import com.springboot.training.spaceover.spaceover.portal.utils.properties.SpaceOverPortalProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class SpaceMissionClientConfiguration {

    private final SpaceOverPortalProperties spaceMissionManagerProperties;


    @Bean
    @ConditionalOnProperty(name = "client.provider", havingValue = "rest-template", matchIfMissing = true)
    public SpaceMissionClient restTemplateSpaceMissionClient(final RestTemplate restTemplate, final SpaceOverPortalProperties properties) {
        return new RestTemplateSpaceMissionClient(restTemplate, properties);
    }

    @Bean
    @ConditionalOnProperty(name = "client.provider", havingValue = "web-client")
    public WebClient spaceMissionWebClient() {
        return WebClient.builder().baseUrl(spaceMissionManagerProperties.getSpaceshipManagerBaseUrl()).build();
    }

    @Bean
    @ConditionalOnProperty(name = "client.provider", havingValue = "web-client")
    public SpaceMissionClient webClientSpaceShipClient(final WebClient spaceMissionWebClient) {
        return new WebClientSpaceMissionClient(spaceMissionWebClient);
    }

}
