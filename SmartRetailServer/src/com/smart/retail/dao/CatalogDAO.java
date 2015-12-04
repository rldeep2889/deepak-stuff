package com.smart.retail.dao;

import java.util.List;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.smart.retail.vo.CatalogInfo;

public interface CatalogDAO {
	
	/**
	 * This is the method to be used to initialize database resources ie.
	 * connection.
	 */
	//public void setDataSource(DriverManagerDataSource ds);

	/**
	 * This is the method to be used to create a record in the CatalogInfo
	 * table.
	 */
	public void create(int catalogId, String catalogDesc, byte[] videoByteArray);

	/**
	 * This is the method to be used to list down a record from the CatalogInfo
	 * table corresponding to a passed catalog id.
	 */
	public CatalogInfo getCatalogInfo(int catalogId);

	/**
	 * This is the method to be used to list down all the records from the
	 * CatalogInfo table.
	 */
	public List<CatalogInfo> listCatalogs();

	/**
	 * This is the method to be used to delete a record from the CatalogInfo
	 * table corresponding to a passed catalog id.
	 */
	public void delete(int id);

	/**
	 * This is the method to be used to update a record into the CatalogInfo
	 * table.
	 */
	public void updateCatalogDesc(int catalogId, String catalogDesc, byte[] videoByteArray);
	
	public void updateCatalogVideo(int catalogId, byte[] videoByteArray);
}
