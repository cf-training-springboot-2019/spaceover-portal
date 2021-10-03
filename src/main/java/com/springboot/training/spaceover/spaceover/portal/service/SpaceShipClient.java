package com.springboot.training.spaceover.spaceover.portal.service;

import com.springboot.training.spaceover.spaceover.portal.domain.inbound.response.GetSpaceShipResponse;

import java.util.List;

public interface SpaceShipClient {

    GetSpaceShipResponse findBydId(Long id);
    List<GetSpaceShipResponse> findSpaceShips();

}