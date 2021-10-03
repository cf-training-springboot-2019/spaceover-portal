package com.springboot.training.spaceover.spaceover.portal.service;

import com.springboot.training.spaceover.spaceover.portal.domain.inbound.response.GetSpaceCrewMemberResponse;

import java.util.List;

public interface SpaceCrewMemberClient {

    GetSpaceCrewMemberResponse findBydId(Long id);
    List<GetSpaceCrewMemberResponse> findSpaceCrewMembers();

}