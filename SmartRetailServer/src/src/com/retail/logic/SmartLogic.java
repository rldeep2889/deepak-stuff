package src.com.retail.logic;

import java.util.List;

import org.springframework.util.StringUtils;

import com.smart.retail.dao.SmartJdbcTemplate;
import com.smart.retail.vo.MasterItemDetails;
import com.smart.retail.vo.MasterItemsList;
import com.smart.retail.vo.SmartUserData;
import com.smart.retail.vo.UserItemDetails;

public class SmartLogic {
	
	static SmartJdbcTemplate jdbcTemplate = SmartJdbcTemplate.getSmartJdbcTemplate();
	
	public static MasterItemsList getMasterItems()
	{
		return jdbcTemplate.getMasterItemDetails();
	}
	
	public static String getUserIdFromUserName(SmartUserData userData)
	{	
		jdbcTemplate.pushUserDetails(userData);
		
		return jdbcTemplate.getUserIdFromUserData(userData.getUserName());
	}
	
	public static void publishUserItems(UserItemDetails userItems)
	{
		jdbcTemplate.pushUserItems(userItems);
	}
	
	public static void checkOutUserItems(UserItemDetails userItem)
	{
		//jdbcTemplate.pushUserItems(userItems);
		
		UserItemDetails userItemFromDb=jdbcTemplate.getUserItemDetailsFromUserId(userItem.getUserId());
		
		if(userItemFromDb != null)
		{
			System.out.println("UserItem present in db for User with UserID :: "+userItem.getUserId());
			if(!userItemFromDb.getUserItems().equalsIgnoreCase(userItem.getUserItems()))
			{
				notifyForOtherMissingItem(userItem.getUserItems(),userItem.getUserItems());
			}
			
		}

		if(userItem != null && (!StringUtils.isEmpty(userItem.getUserItems())))
		{
			String[] items = splitItems(userItem.getUserItems());
			
			if(items != null)
			{
				for(String item : items)
				{
					if(item != null)
					{						
						List<UserItemDetails> allUserItems = jdbcTemplate.getAllUserDetailsWithItemId(item);

						notifyOtherUsers(userItem.getUserId(),item,allUserItems);
						updateMasterTable(item);
						
					}
				}
			}
			
		}
	
		
	}
	
	private static void notifyForOtherMissingItem(String currentUserItems, String dbUserItems)
	{
		String[] currentItems = splitItems(currentUserItems);
		
		for(String item : currentItems)
		{
			if(!dbUserItems.contains(item))
			{
				//TODO : Push notification for missing items
			}
		}
		
	}

	public static void updateMasterTable(String userItemId)
	{		
		jdbcTemplate.deleteMasterItem(userItemId);
	}
	
	private static boolean notifyOtherUsers(String currentUserId, String currentItem, List<UserItemDetails> allUserItems )
	{
		System.out.println(" Inside notifyOtherUsers for current User :: "+currentUserId);
		for(UserItemDetails userItem : allUserItems)
		{
			if(!(userItem.getUserId().equalsIgnoreCase(currentUserId)) && userItem.getUserItems().contains(currentItem))
			{
				System.out.println("Pushing Notification for other User :: " + userItem.getUserId() + " having common item :: " + currentItem);
				//TODO : Do Push Notification for other users
			}
		}
		return false;
	}
	public static void pushNotification()
	{
		
	}
	
	public static String[] splitItems(String items)
	{
		String[] vals = null;
		
		vals = items.split(",");
		
		return vals;
	}

}
