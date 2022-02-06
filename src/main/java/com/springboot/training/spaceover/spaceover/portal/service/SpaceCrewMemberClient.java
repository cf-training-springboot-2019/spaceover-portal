package com.springboot.training.spaceover.spaceover.portal.service;

import com.springboot.training.spaceover.spaceover.portal.domain.inbound.response.GetSpaceCrewMemberResponse;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.PagedModel;

public interface SpaceCrewMemberClient {

    GetSpaceCrewMemberResponse findBydId(Long id);
    List<GetSpaceCrewMemberResponse> findSpaceCrewMembers();
    PagedModel<GetSpaceCrewMemberResponse> findSpaceCrewMembers(PageRequest pageRequest);

}