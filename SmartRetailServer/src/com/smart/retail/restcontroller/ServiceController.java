package com.smart.retail.restcontroller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smart.retail.utils.CommonUtils;
import com.smart.retail.vo.CatalogInfo;

@RestController
@RequestMapping("/video")
public class ServiceController {

	@RequestMapping(value = "/getVideoFromId", method = RequestMethod.GET, headers = "Accept=application/json"
		,produces = MediaType.APPLICATION_JSON_VALUE)
	public static CatalogInfo getCatalogInfo(
			@RequestParam(value = "catalogId", required = true) int catalogId) {

		CatalogInfo catalogInfo = null;

		catalogInfo = CommonUtils.getCatalogInfoBasedOnCatalogId(catalogId);

		return catalogInfo;
	}
}
