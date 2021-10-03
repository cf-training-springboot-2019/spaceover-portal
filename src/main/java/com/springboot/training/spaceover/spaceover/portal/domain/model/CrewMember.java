package com.springboot.training.spaceover.spaceover.portal.domain.model;

import com.springboot.training.spaceover.spaceover.portal.enums.SpaceCrewMemberRole;
import com.springboot.training.spaceover.spaceover.portal.enums.SpaceCrewMemberStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrewMember {

    private Long id;

    private String name;

    private SpaceCrewMemberRole role;

    private SpaceCrewMemberStatus status;

    private Long spaceShipId;

}