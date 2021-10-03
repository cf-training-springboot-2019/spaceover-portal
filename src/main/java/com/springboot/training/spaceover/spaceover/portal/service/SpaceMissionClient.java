package com.springboot.training.spaceover.spaceover.portal.service;

import com.springboot.training.spaceover.spaceover.portal.domain.inbound.response.GetSpaceMissionResponse;

import java.util.List;

public interface SpaceMissionClient {

    GetSpaceMissionResponse findBydId(Long id);
    List<GetSpaceMissionResponse> findSpaceMissions();

}