package com.springboot.training.spaceover.spaceover.portal.utils;

import static com.springboot.training.spaceover.spaceover.portal.utils.constants.SpaceOverPortalConstant.PAGE_QPARAM;
import static com.springboot.training.spaceover.spaceover.portal.utils.constants.SpaceOverPortalConstant.SIZE_QPARAM;
import static com.springboot.training.spaceover.spaceover.portal.utils.constants.SpaceOverPortalConstant.SORT_QPARAM;

import java.net.URI;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.util.UriComponentsBuilder;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HttpUriBuilder {

	public static URI buildUri(String host, String path, PageRequest pageRequest) {
		return UriComponentsBuilder.fromUriString(host)
				.path( path)
				.queryParam(PAGE_QPARAM, pageRequest.getPageNumber())
				.queryParam(SIZE_QPARAM, pageRequest.getPageSize())
				.queryParam(SORT_QPARAM, pageRequest.getSort())
				.build()
				.toUri();
	}

}
