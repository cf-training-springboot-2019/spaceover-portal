package com.springboot.training.spaceover.spaceover.portal.service;

import static com.springboot.training.spaceover.spaceover.portal.utils.constants.SpaceOverPortalConstant.EXTERNAL_SERVICE_INVOKE_ERROR_MSG;
import static com.springboot.training.spaceover.spaceover.portal.utils.constants.SpaceOverPortalConstant.FRONT_SLASH_DELIMITER;
import static com.springboot.training.spaceover.spaceover.portal.utils.constants.SpaceOverPortalConstant.SPACESHIPS;

import com.springboot.training.spaceover.spaceover.portal.domain.inbound.response.GetSpaceShipResponse;
import com.springboot.training.spaceover.spaceover.portal.utils.HttpUriBuilder;
import com.springboot.training.spaceover.spaceover.portal.utils.properties.SpaceOverPortalProperties;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

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
            ResponseEntity<PagedModel<GetSpaceShipResponse>> result = restTemplate.exchange(String.join(FRONT_SLASH_DELIMITER, spaceOverPortalProperties.getSpaceshipManagerBaseUrl(), SPACESHIPS),
                    HttpMethod.GET, null, new ParameterizedTypeReference<PagedModel<GetSpaceShipResponse>>() {
                    });
            return new ArrayList<>(Objects.requireNonNull(result.getBody()).getContent());
        } catch (Exception e) {
            log.error(EXTERNAL_SERVICE_INVOKE_ERROR_MSG, String.join(FRONT_SLASH_DELIMITER, spaceOverPortalProperties.getSpaceshipManagerBaseUrl(), SPACESHIPS), e);
            return Collections.emptyList();
        }
    }

    @Override
    public PagedModel<GetSpaceShipResponse> findSpaceShips(PageRequest pageRequest) {
        try {
            URI targetUrl = HttpUriBuilder
                .buildUri(spaceOverPortalProperties.getSpaceshipManagerBaseUrl(), SPACESHIPS, pageRequest);
            ResponseEntity<PagedModel<GetSpaceShipResponse>> result = restTemplate.exchange(targetUrl,
                HttpMethod.GET, null, new ParameterizedTypeReference<PagedModel<GetSpaceShipResponse>>() {
                });
            return result.getBody();
        } catch (Exception e) {
            log.error(EXTERNAL_SERVICE_INVOKE_ERROR_MSG, String.join(FRONT_SLASH_DELIMITER, spaceOverPortalProperties.getSpaceshipManagerBaseUrl(), SPACESHIPS), e);
            return PagedModel.empty();
        }

    }
}
