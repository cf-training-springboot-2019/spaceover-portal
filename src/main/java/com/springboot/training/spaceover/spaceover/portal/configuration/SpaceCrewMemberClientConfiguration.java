package com.springboot.training.spaceover.spaceover.portal.configuration;

import com.springboot.training.spaceover.spaceover.portal.service.RestTemplateSpaceCrewMemberClient;
import com.springboot.training.spaceover.spaceover.portal.service.SpaceCrewMemberClient;
import com.springboot.training.spaceover.spaceover.portal.service.WebClientSpaceCrewMembersClient;
import com.springboot.training.spaceover.spaceover.portal.utils.properties.SpaceOverPortalProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class SpaceCrewMemberClientConfiguration {

    private final SpaceOverPortalProperties spaceMissionManagerProperties;


    @Bean
    @ConditionalOnProperty(name = "client.provider", havingValue = "rest-template", matchIfMissing = true)
    public SpaceCrewMemberClient restTemplateSpaceCrewMemberClient(final RestTemplate restTemplate, final SpaceOverPortalProperties properties) {
        return new RestTemplateSpaceCrewMemberClient(restTemplate, properties);
    }

    @Bean
    @ConditionalOnProperty(name = "client.provider", havingValue = "web-client")
    public WebClient spaceCrewMemberWebClient() {
        return WebClient.builder().baseUrl(spaceMissionManagerProperties.getSpaceCrewMemberManagerBaseUrl()).build();
    }

    @Bean
    @ConditionalOnProperty(name = "client.provider", havingValue = "web-client")
    public SpaceCrewMemberClient webClientSpaceCrewMemberClient(final WebClient spaceCrewMemberWebClient) {
        return new WebClientSpaceCrewMembersClient(spaceCrewMemberWebClient);
    }

}
