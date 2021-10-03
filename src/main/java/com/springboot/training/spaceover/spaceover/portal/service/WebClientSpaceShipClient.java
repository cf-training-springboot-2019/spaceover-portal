package com.springboot.training.spaceover.spaceover.portal.service;

import com.springboot.training.spaceover.spaceover.portal.domain.inbound.response.GetSpaceShipResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static com.springboot.training.spaceover.spaceover.portal.utils.constants.SpaceOverPortalConstant.FRONT_SLASH_DELIMITER;
import static com.springboot.training.spaceover.spaceover.portal.utils.constants.SpaceOverPortalConstant.SPACESHIPS;


@RequiredArgsConstructor
public class WebClientSpaceShipClient implements SpaceShipClient {

    private final WebClient webClient;

    @Override
    public GetSpaceShipResponse findBydId(Long id) {
        return webClient.get()
                .uri(String.join(FRONT_SLASH_DELIMITER, SPACESHIPS, String.valueOf(id)))
                .retrieve()
                .bodyToMono(GetSpaceShipResponse.class)
                .block();
    }

    @Override
    public List<GetSpaceShipResponse> findSpaceShips() {
        return webClient.get()
                .uri(String.join(FRONT_SLASH_DELIMITER, SPACESHIPS))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<GetSpaceShipResponse>>() { })
                .block();
    }
}
