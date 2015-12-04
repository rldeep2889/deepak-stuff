package com.smart.retail.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.smart.retail.dao.CatalogJdbcTemplate;
import com.smart.retail.vo.CatalogInfo;

public class CommonUtils {

	public static CatalogInfo getCatalogInfoBasedOnCatalogId(int catalogId) {

		// TODO : Fetch video based on catalog if from db
		byte[] videoByteArray = null;


		
		CatalogInfo catalogInfo = new CatalogInfo();
		
		/** Testing - START **/
/*		videoByteArray = VideoUtils
				.getByteArrayFromFile("D:\\Client_Confidential\\SmartRetail\\Stuff\\Wildlife.wmv");
		
		CatalogJdbcTemplate catalogJdbcTemplate = CatalogJdbcTemplate.getCatalogJdbcTemplate();
		
		catalogJdbcTemplate.create(catalogId, "My Own Fairness Cream ", videoByteArray);*/
		
		//CatalogJdbcTemplate catalogJdbcTemplate = CatalogJdbcTemplate.getCatalogJdbcTemplate();
		
		CatalogJdbcTemplate catalogJdbcTemplate = CatalogJdbcTemplate.getCatalogJdbcTemplate();
		
		catalogInfo = catalogJdbcTemplate.getCatalogInfo(catalogId);
		
		System.out.println(" Got the Catalog Info for Catalog Id :: "+catalogId);

		/*catalogInfo.setCatalogId(catalogId);
		catalogInfo.setVideoByteArray(videoByteArray);
		catalogInfo.setCatalogDesc("This is the Himalayan Fairness Cream");*/
		/** Testing - END **/

		/** Testing as db down Start **/
/*		videoByteArray = VideoUtils
				.getByteArrayFromFile("C:\\Deepak_Stuff\\Client_Confidential\\SmartRetail\\Stuff\\Wildlife.wmv");
		
		catalogInfo.setCatalogId(catalogId);
		catalogInfo.setVideoByteArray(videoByteArray);
		catalogInfo.setCatalogDesc("This is the Himalayan Fairness Cream");
*/		
		
		/** Testing as db down End **/

		return catalogInfo;
	}

}
