package com.springboot.training.spaceover.spaceover.portal.domain.inbound.response;

import com.springboot.training.spaceover.spaceover.portal.enums.SpaceMissionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetSpaceMissionResponse extends RepresentationModel<GetSpaceMissionResponse> {

    private Long id;

    private Long spaceShipId;

    private String name;

    private String details;

    private SpaceMissionStatus status;

    private BigDecimal revenue;

}
