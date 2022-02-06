package com.springboot.training.spaceover.spaceover.portal.domain.inbound.response;

import java.math.BigInteger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetSpaceShipResponse {

    private Long id;

    private String name;

    private String status;

    private BigInteger maxOccupancy;

    private String type;

}
