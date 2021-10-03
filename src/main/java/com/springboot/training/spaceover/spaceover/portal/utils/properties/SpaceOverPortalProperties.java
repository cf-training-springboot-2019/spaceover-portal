package com.springboot.training.spaceover.spaceover.portal.utils.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class SpaceOverPortalProperties {

    @Value("${spring.application.name:spaceover-portaç}")
    private String applicationName;

    @Value("${server.servlet.context-path:#{null}}")
    private String servletContextPath;

    @Value("${spaceship-manager.api.url:http://localhost:8080}")
    private String spaceshipManagerBaseUrl;

    @Value("${spacemission-manager.api.url:http://localhost:8080}")
    private String spaceMissionManagerBaseUrl;

    @Value("${spacecrewmember-manager.api.url:http://localhost:8080}")
    private String spaceCrewMemberManagerBaseUrl;

}
