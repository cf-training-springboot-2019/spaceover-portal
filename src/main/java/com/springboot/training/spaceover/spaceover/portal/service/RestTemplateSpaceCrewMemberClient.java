package com.springboot.training.spaceover.spaceover.portal.service;

import com.springboot.training.spaceover.spaceover.portal.domain.inbound.response.GetSpaceCrewMemberResponse;
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
public class RestTemplateSpaceCrewMemberClient implements SpaceCrewMemberClient {

    private final RestTemplate restTemplate;

    private final SpaceOverPortalProperties spaceOverPortalProperties;

    public GetSpaceCrewMemberResponse findBydId(Long id) {
        return restTemplate
                .getForEntity(String.join(FRONT_SLASH_DELIMITER, spaceOverPortalProperties.getSpaceCrewMemberManagerBaseUrl(), CREWMEMBERS, String.valueOf(id)),
                        GetSpaceCrewMemberResponse.class).getBody();
    }

    public List<GetSpaceCrewMemberResponse> findSpaceCrewMembers() {
        try {
            ResponseEntity<List<GetSpaceCrewMemberResponse>> result = restTemplate.exchange(String.join(FRONT_SLASH_DELIMITER, spaceOverPortalProperties.getSpaceMissionManagerBaseUrl(), CREWMEMBERS),
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<GetSpaceCrewMemberResponse>>() {
                    });
            return result.getBody();
        } catch (Exception e) {
            log.error(EXTERNAL_SERVICE_INVOKE_ERROR_MSG, String.join(FRONT_SLASH_DELIMITER, spaceOverPortalProperties.getSpaceMissionManagerBaseUrl(), CREWMEMBERS), e);
            return Collections.emptyList();
        }
    }
}
