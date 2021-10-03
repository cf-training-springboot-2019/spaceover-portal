package com.springboot.training.spaceover.spaceover.portal.service;

import com.springboot.training.spaceover.spaceover.portal.domain.inbound.response.GetSpaceMissionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static com.springboot.training.spaceover.spaceover.portal.utils.constants.SpaceOverPortalConstant.FRONT_SLASH_DELIMITER;
import static com.springboot.training.spaceover.spaceover.portal.utils.constants.SpaceOverPortalConstant.MISSIONS;


@RequiredArgsConstructor
public class WebClientSpaceMissionClient implements SpaceMissionClient {

    private final WebClient webClient;

    public GetSpaceMissionResponse findBydId(Long id) {
        return webClient.get()
                .uri(String.join(FRONT_SLASH_DELIMITER, MISSIONS, String.valueOf(id)))
                .retrieve()
                .bodyToMono(GetSpaceMissionResponse.class)
                .block();
    }

    public List<GetSpaceMissionResponse> findSpaceMissions() {
        return webClient.get()
                .uri(String.join(FRONT_SLASH_DELIMITER, MISSIONS))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<GetSpaceMissionResponse>>() { })
                .block();    }

}
