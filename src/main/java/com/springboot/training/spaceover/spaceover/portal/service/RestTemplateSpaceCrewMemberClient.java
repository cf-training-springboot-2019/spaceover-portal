package com.springboot.training.spaceover.spaceover.portal.service;

import static com.springboot.training.spaceover.spaceover.portal.utils.constants.SpaceOverPortalConstant.CREWMEMBERS;
import static com.springboot.training.spaceover.spaceover.portal.utils.constants.SpaceOverPortalConstant.EXTERNAL_SERVICE_INVOKE_ERROR_MSG;
import static com.springboot.training.spaceover.spaceover.portal.utils.constants.SpaceOverPortalConstant.FRONT_SLASH_DELIMITER;

import com.springboot.training.spaceover.spaceover.portal.domain.inbound.response.GetSpaceCrewMemberResponse;
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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

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
            ResponseEntity<PagedModel<GetSpaceCrewMemberResponse>> result = restTemplate.exchange(String.join(FRONT_SLASH_DELIMITER, spaceOverPortalProperties.getSpaceCrewMemberManagerBaseUrl(), CREWMEMBERS),
                    HttpMethod.GET, null, new ParameterizedTypeReference<PagedModel<GetSpaceCrewMemberResponse>>() {
                    });
            return new ArrayList<>(Objects.requireNonNull(result.getBody()).getContent());
        } catch (Exception e) {
            log.error(EXTERNAL_SERVICE_INVOKE_ERROR_MSG, String.join(FRONT_SLASH_DELIMITER, spaceOverPortalProperties.getSpaceMissionManagerBaseUrl(), CREWMEMBERS), e);
            return Collections.emptyList();
        }
    }

    public PagedModel<GetSpaceCrewMemberResponse> findSpaceCrewMembers(PageRequest pageRequest) {
        try {
            HttpEntity<PageRequest> request = new HttpEntity<PageRequest>(pageRequest);
            URI targetUrl = HttpUriBuilder.buildUri(spaceOverPortalProperties.getSpaceCrewMemberManagerBaseUrl(), CREWMEMBERS, pageRequest);
            ResponseEntity<PagedModel<GetSpaceCrewMemberResponse>> result = restTemplate.exchange(targetUrl,
                HttpMethod.GET, null, new ParameterizedTypeReference<PagedModel<GetSpaceCrewMemberResponse>>() {
                });
            return result.getBody();
        } catch (Exception e) {
            log.error(EXTERNAL_SERVICE_INVOKE_ERROR_MSG, String.join(FRONT_SLASH_DELIMITER, spaceOverPortalProperties.getSpaceMissionManagerBaseUrl(), CREWMEMBERS), e);
            return PagedModel.empty();
        }
    }

}
