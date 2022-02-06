package com.springboot.training.spaceover.spaceover.portal.domain.inbound.response;

import com.springboot.training.spaceover.spaceover.portal.enums.SpaceCrewMemberRole;
import com.springboot.training.spaceover.spaceover.portal.enums.SpaceCrewMemberStatus;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetSpaceCrewMemberResponse extends RepresentationModel<GetSpaceCrewMemberResponse> {

    private Long id;

    private String name;

    private Long spaceShipId;

    private SpaceCrewMemberStatus status;

    private SpaceCrewMemberRole role;

    private BigDecimal salary;

}
