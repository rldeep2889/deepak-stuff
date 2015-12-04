package com.smart.retail.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.smart.retail.mapper.CatalogInfoMapper;
import com.smart.retail.vo.CatalogInfo;

public class CatalogJdbcTemplate implements CatalogDAO {

	JdbcTemplate jdbcTemplate;
	
	

	public static CatalogJdbcTemplate getCatalogJdbcTemplate() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//"spring-servlet.xml");
		 //"classpath*:**/spring-servlet.xml"); 
		 return (CatalogJdbcTemplate)context.getBean("catalogJdbcTemplate");
	 }
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void create(int catalogId, String catalogDesc, byte[] videoByteArray) {

		String SQL = "insert into SMART_RETAIL_CATALOGINFO (catalogId, catalogDesc, videoByteArray) values (?, ?, ?)";

		int rowsUpdated = jdbcTemplate.update(SQL, catalogId,
				catalogDesc, videoByteArray);
		System.out.println("Created " + rowsUpdated + " Record catalogId = "
				+ catalogId + " catalogDesc = " + catalogDesc);
		return;
	}

	@Override
	public CatalogInfo getCatalogInfo(int catalogId) {

		String SQL = "select * from SMART_RETAIL_CATALOGINFO where catalogId = ?";
		CatalogInfo catalogInfo = jdbcTemplate.queryForObject(SQL,
				new Object[] { catalogId }, new CatalogInfoMapper());
		return catalogInfo;
	}

	@Override
	public List<CatalogInfo> listCatalogs() {

		String SQL = "select * from SMART_RETAIL_CATALOGINFO where catalogId = ?";
		List<CatalogInfo> catalogInfos = jdbcTemplate.query(SQL,
				new CatalogInfoMapper());

		return catalogInfos;
	}

	@Override
	public void delete(int catalogId) {

		String SQL = "delete from SMART_RETAIL_CATALOGINFO where catalogId = ?";

		jdbcTemplate.update(SQL, catalogId);
		System.out.println("Deleted Record with ID = " + catalogId);
		return;

	}

	@Override
	public void updateCatalogDesc(int catalogId, String catalogDesc,
			byte[] videoByteArray) {

		String SQL = "update SMART_RETAIL_CATALOGINFO set catalogDesc = ? where catalogId = ?";
		int rowsUpdated = jdbcTemplate
				.update(SQL, catalogDesc, catalogId);
		System.out.println("Updated " + rowsUpdated + " Record with ID = "
				+ catalogId);
		return;
	}

	@Override
	public void updateCatalogVideo(int catalogId, byte[] videoByteArray) {

		String SQL = "update SMART_RETAIL_CATALOGINFO set videoByteArray = ? where catalogId = ?";
		int rowsUpdated = jdbcTemplate.update(SQL, videoByteArray,
				catalogId);
		System.out.println("Updated " + rowsUpdated + " Record with ID = "
				+ catalogId);
		return;

	}


}
