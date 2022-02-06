package com.springboot.training.spaceover.spaceover.portal.service;

import static com.springboot.training.spaceover.spaceover.portal.utils.constants.SpaceOverPortalConstant.FRONT_SLASH_DELIMITER;
import static com.springboot.training.spaceover.spaceover.portal.utils.constants.SpaceOverPortalConstant.MISSIONS;

import com.springboot.training.spaceover.spaceover.portal.domain.inbound.response.GetSpaceMissionResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.reactive.function.client.WebClient;


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

    public PagedModel<GetSpaceMissionResponse> findSpaceMissions(PageRequest pageRequest) {
        return webClient.get()
            .uri(String.join(FRONT_SLASH_DELIMITER, MISSIONS))
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<PagedModel<GetSpaceMissionResponse>>() { })
            .block();    }

}
