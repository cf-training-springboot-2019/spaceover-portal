package com.springboot.training.spaceover.spaceover.portal.service;

import static com.springboot.training.spaceover.spaceover.portal.utils.constants.SpaceOverPortalConstant.EXTERNAL_SERVICE_INVOKE_ERROR_MSG;
import static com.springboot.training.spaceover.spaceover.portal.utils.constants.SpaceOverPortalConstant.FRONT_SLASH_DELIMITER;
import static com.springboot.training.spaceover.spaceover.portal.utils.constants.SpaceOverPortalConstant.MISSIONS;

import com.springboot.training.spaceover.spaceover.portal.domain.inbound.response.GetSpaceMissionResponse;
import com.springboot.training.spaceover.spaceover.portal.utils.HttpUriBuilder;
import com.springboot.training.spaceover.spaceover.portal.utils.properties.SpaceOverPortalProperties;
import java.net.URI;
import java.util.Collections;
import java.util.List;
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
public class RestTemplateSpaceMissionClient implements SpaceMissionClient {

    private final RestTemplate restTemplate;

    private final SpaceOverPortalProperties spaceOverPortalProperties;

    public GetSpaceMissionResponse findBydId(Long id) {
        return restTemplate
                .getForEntity(String.join(FRONT_SLASH_DELIMITER, spaceOverPortalProperties.getSpaceCrewMemberManagerBaseUrl(), MISSIONS, String.valueOf(id)),
                        GetSpaceMissionResponse.class).getBody();
    }

    public List<GetSpaceMissionResponse> findSpaceMissions() {
        try {
            ResponseEntity<List<GetSpaceMissionResponse>> result = restTemplate.exchange(String.join(FRONT_SLASH_DELIMITER, spaceOverPortalProperties.getSpaceMissionManagerBaseUrl(), MISSIONS),
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<GetSpaceMissionResponse>>() {
                    });
            return result.getBody();
        } catch (Exception e) {
            log.error(EXTERNAL_SERVICE_INVOKE_ERROR_MSG, String.join(FRONT_SLASH_DELIMITER, spaceOverPortalProperties.getSpaceCrewMemberManagerBaseUrl(), MISSIONS), e);
            return Collections.emptyList();
        }
    }

    public PagedModel<GetSpaceMissionResponse> findSpaceMissions(PageRequest pageRequest) {
        try {
            URI targetUrl = HttpUriBuilder
                .buildUri(spaceOverPortalProperties.getSpaceMissionManagerBaseUrl(), MISSIONS, pageRequest);
            ResponseEntity<PagedModel<GetSpaceMissionResponse>> result = restTemplate.exchange(targetUrl,
                HttpMethod.GET, null, new ParameterizedTypeReference<PagedModel<GetSpaceMissionResponse>>() {
                });
            return result.getBody();
        } catch (Exception e) {
            log.error(EXTERNAL_SERVICE_INVOKE_ERROR_MSG, String.join(FRONT_SLASH_DELIMITER, spaceOverPortalProperties.getSpaceCrewMemberManagerBaseUrl(), MISSIONS), e);
            return PagedModel.empty();
        }
    }

}
