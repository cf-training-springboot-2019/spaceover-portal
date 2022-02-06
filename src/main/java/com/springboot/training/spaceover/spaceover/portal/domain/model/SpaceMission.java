package com.springboot.training.spaceover.spaceover.portal.domain.model;

import com.springboot.training.spaceover.spaceover.portal.enums.SpaceMissionStatus;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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