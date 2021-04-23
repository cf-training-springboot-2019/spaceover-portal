package com.springboot.training.spaceover.spaceover.portal.domain.model;

import com.springboot.training.spaceover.spaceover.portal.enums.CrewMemberStatus;
import com.springboot.training.spaceover.spaceover.portal.enums.CrewRole;
import com.springboot.training.spaceover.spaceover.portal.enums.SpaceShipStatus;
import com.springboot.training.spaceover.spaceover.portal.enums.SpaceShipType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
public class CrewMember {

    private Long id;

    private String name;

    private CrewRole role;

    private CrewMemberStatus status;

    private Long spaceShipId;

}