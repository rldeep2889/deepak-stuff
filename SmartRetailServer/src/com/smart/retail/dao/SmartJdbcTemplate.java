package com.smart.retail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.smart.retail.mapper.CatalogInfoMapper;
import com.smart.retail.mapper.MasterInfoMapper;
import com.smart.retail.mapper.UserDataMapper;
import com.smart.retail.mapper.UserItemsMapper;
import com.smart.retail.vo.CatalogInfo;
import com.smart.retail.vo.MasterItemDetails;
import com.smart.retail.vo.MasterItemsList;
import com.smart.retail.vo.SmartUserData;
import com.smart.retail.vo.UserItemDetails;

public class SmartJdbcTemplate {

	private JdbcTemplate jdbcTemplate;

	public static SmartJdbcTemplate getSmartJdbcTemplate() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
				 //"classpath*:**/spring-servlet.xml"); 
	//"spring-servlet.xml");

		return (SmartJdbcTemplate) context.getBean("smartJdbcTemplate");
	}

	//@Override
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//@Override
	public void pushUserDetails(SmartUserData userData)
	{
		String SQL = "insert into SMART_USER_DATA (USER_ID, FIRST_NAME , USERNAME , PASSWORD , MOB_NO , EMAIL_ID, DEVICE_ID) values ((select dbms_random.string('L', 16) str from dual),?, ?, ?, ?, ?, ?)";

		int rowsUpdated = jdbcTemplate.update(SQL, userData.getFirstName(), userData.getUserName(), userData.getPassword(),
				userData.getMobNo(), userData.getEmailId(), userData.getDeviceId());
		System.out.println("Created " + rowsUpdated);
		return;
	}
	
	//@Override
	public String getUserIdFromUserData(String userName)
	{
		String SQL = "select * from SMART_USER_DATA where userName = ?";
		SmartUserData userData = jdbcTemplate.queryForObject(SQL,
				new Object[] { userName }, new UserDataMapper());

		return userData.getUserId();
	}

	//@Override
	public MasterItemsList getMasterItemDetails() {

		String SQL = "select * from MASTER_ITEM_DETAILS";
		List<MasterItemDetails> masterDetails = jdbcTemplate.query(SQL,
				new MasterInfoMapper());
		MasterItemsList masterItemsList = new MasterItemsList();
		masterItemsList.setMasterItems(masterDetails);
		
		return masterItemsList;
	}
	
	//@Override
	public void pushUserItems(UserItemDetails userItems)
	{
		String SQL = "insert into USER_ITEM_DETAILS (USER_ID,USER_ITEMS) values (? , ?)";		

		int rowsUpdated = jdbcTemplate.update(SQL, userItems.getUserId(),
				userItems.getUserItems());
		System.out.println("Created " + rowsUpdated);
	}
	
	//@Override
	public void deleteMasterItem(String itemId) {
		
		/** Considering there is only one quantity **/

		String SQL = "delete from MASTER_ITEM_DETAILS where ITEM_ID = ?";

		jdbcTemplate.update(SQL, itemId);
		System.out.println("Deleted Record from Master Table with ITEM_ID = " + itemId );
		return;

	}
	
	//@Override
	public UserItemDetails getUserItemDetailsFromUserId(String userId)
	{
		String SQL = "select * from USER_ITEM_DETAILS where USER_ID = ?";
		UserItemDetails userItem = jdbcTemplate.queryForObject(SQL,
				new Object[] { userId }, new UserItemsMapper());

		return userItem;
	}
	
	public List<UserItemDetails> getAllUserDetailsWithItemId(final String itemId)
	{
		/* 
		 * SELECT IF( 
         EXISTS( SELECT col from tbl where id='n' ),
         colX, colY 
       		) AS 'result'
			FROM TBL;
		 */
		
		/*SELECT
		   SCORE(1),
		   title
		from
		   newsindex
		WHERE
		   CONTAINS(text, 'oracle', 1) > 0;*/
		
		final String SQL = "select * from USER_ITEM_DETAILS where USER_ITEMS like ?";
		PreparedStatementCreator psc = new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement ps = con.prepareStatement(SQL);
				ps.setString(1, "%"+itemId + "%");
				System.out.println("Prepared Statement Query :: "+ps.toString());
				return ps;
			}
		};
		List<UserItemDetails> masterDetails = jdbcTemplate.query(psc,
				new UserItemsMapper());
		
		return masterDetails;
	}

}
