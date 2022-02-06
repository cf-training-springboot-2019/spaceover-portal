package com.springboot.training.spaceover.spaceover.portal.domain.model;

import com.springboot.training.spaceover.spaceover.portal.enums.SpaceShipStatus;
import com.springboot.training.spaceover.spaceover.portal.enums.SpaceShipType;
import java.math.BigInteger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpaceShip {

    private Long id;

    private String name;

    private SpaceShipStatus status;

    private SpaceShipType type;

    private BigInteger maxOccupancy;

    private Long spaceFleetId;

}