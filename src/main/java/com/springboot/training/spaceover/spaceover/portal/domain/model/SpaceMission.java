package com.springboot.training.spaceover.spaceover.portal.domain.model;

import com.springboot.training.spaceover.spaceover.portal.enums.SpaceMissionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpaceMission {

    private Long id;

    private String name;

    private String details;

    private SpaceMissionStatus status;

    private BigDecimal revenue;

    private Long spaceShipId;

}