package com.springboot.training.spaceover.spaceover.portal.configuration;

import com.springboot.training.spaceover.spaceover.portal.service.RestTemplateSpaceShipClient;
import com.springboot.training.spaceover.spaceover.portal.service.SpaceShipClient;
import com.springboot.training.spaceover.spaceover.portal.service.WebClientSpaceShipClient;
import com.springboot.training.spaceover.spaceover.portal.utils.properties.SpaceOverPortalProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class SpaceShipClientConfiguration {

    private final SpaceOverPortalProperties spaceMissionManagerProperties;


    @Bean
    @ConditionalOnProperty(name = "client.provider", havingValue = "rest-template", matchIfMissing = true)
    public SpaceShipClient restTemplateSpaceShipClient(final RestTemplate restTemplate, final SpaceOverPortalProperties properties) {
        return new RestTemplateSpaceShipClient(restTemplate, properties);
    }

    @Bean
    @ConditionalOnProperty(name = "client.provider", havingValue = "web-client")
    public WebClient spaceshipWebClient() {
        return WebClient.builder().baseUrl(spaceMissionManagerProperties.getSpaceshipManagerBaseUrl()).build();
    }

    @Bean
    @ConditionalOnProperty(name = "client.provider", havingValue = "web-client")
    public SpaceShipClient webClientSpaceShipClient(final WebClient spaceshipWebClient) {
        return new WebClientSpaceShipClient(spaceshipWebClient);
    }

}
