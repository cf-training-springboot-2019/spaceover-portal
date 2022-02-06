package com.springboot.training.spaceover.spaceover.portal.service;

import com.springboot.training.spaceover.spaceover.portal.domain.inbound.response.GetSpaceShipResponse;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.PagedModel;

public interface SpaceShipClient {

    GetSpaceShipResponse findBydId(Long id);
    List<GetSpaceShipResponse> findSpaceShips();
    PagedModel<GetSpaceShipResponse> findSpaceShips(PageRequest pageRequest);

}