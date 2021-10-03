package com.springboot.training.spaceover.spaceover.portal.service;

import com.springboot.training.spaceover.spaceover.portal.domain.inbound.response.GetSpaceShipResponse;
import com.springboot.training.spaceover.spaceover.portal.utils.properties.SpaceOverPortalProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

import static com.springboot.training.spaceover.spaceover.portal.utils.constants.SpaceOverPortalConstant.*;

@Slf4j
@RequiredArgsConstructor
public class RestTemplateSpaceShipClient implements SpaceShipClient {

    private final RestTemplate restTemplate;

    private final SpaceOverPortalProperties spaceOverPortalProperties;

    public GetSpaceShipResponse findBydId(Long id) {
        return restTemplate
                .getForEntity(String.join(FRONT_SLASH_DELIMITER, spaceOverPortalProperties.getSpaceshipManagerBaseUrl(), SPACESHIPS, String.valueOf(id)),
                        GetSpaceShipResponse.class).getBody();
    }

    public List<GetSpaceShipResponse> findSpaceShips() {
        try {
            ResponseEntity<List<GetSpaceShipResponse>> result = restTemplate.exchange(String.join(FRONT_SLASH_DELIMITER, spaceOverPortalProperties.getSpaceshipManagerBaseUrl(), SPACESHIPS),
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<GetSpaceShipResponse>>() {
                    });
            return result.getBody();
        } catch (Exception e) {
            log.error(EXTERNAL_SERVICE_INVOKE_ERROR_MSG, String.join(FRONT_SLASH_DELIMITER, spaceOverPortalProperties.getSpaceshipManagerBaseUrl(), SPACESHIPS), e);
            return Collections.emptyList();
        }
    }
}
