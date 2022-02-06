package com.springboot.training.spaceover.spaceover.portal.service;

import com.springboot.training.spaceover.spaceover.portal.domain.inbound.response.GetSpaceMissionResponse;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.PagedModel;

public interface SpaceMissionClient {

    GetSpaceMissionResponse findBydId(Long id);
    List<GetSpaceMissionResponse> findSpaceMissions();
    PagedModel<GetSpaceMissionResponse> findSpaceMissions(PageRequest pageRequest);

}