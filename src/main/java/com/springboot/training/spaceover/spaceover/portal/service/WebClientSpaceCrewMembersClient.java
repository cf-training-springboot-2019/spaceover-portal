package com.springboot.training.spaceover.spaceover.portal.service;

import static com.springboot.training.spaceover.spaceover.portal.utils.constants.SpaceOverPortalConstant.CREWMEMBERS;
import static com.springboot.training.spaceover.spaceover.portal.utils.constants.SpaceOverPortalConstant.FRONT_SLASH_DELIMITER;

import com.springboot.training.spaceover.spaceover.portal.domain.inbound.response.GetSpaceCrewMemberResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.reactive.function.client.WebClient;

@RequiredArgsConstructor
public class WebClientSpaceCrewMembersClient implements SpaceCrewMemberClient {

    private final WebClient webClient;

    public GetSpaceCrewMemberResponse findBydId(Long id) {
        return webClient.get()
                .uri(String.join(FRONT_SLASH_DELIMITER, CREWMEMBERS, String.valueOf(id)))
                .retrieve()
                .bodyToMono(GetSpaceCrewMemberResponse.class)
                .block();
    }

    public List<GetSpaceCrewMemberResponse> findSpaceCrewMembers() {
        return webClient.get()
                .uri(String.join(FRONT_SLASH_DELIMITER, CREWMEMBERS))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<GetSpaceCrewMemberResponse>>() { })
                .block();    }

    public PagedModel<GetSpaceCrewMemberResponse> findSpaceCrewMembers(PageRequest pageRequest) {
        return webClient.get()
            .uri(String.join(FRONT_SLASH_DELIMITER, CREWMEMBERS))
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<PagedModel<GetSpaceCrewMemberResponse>>() { })
            .block();    }

}
