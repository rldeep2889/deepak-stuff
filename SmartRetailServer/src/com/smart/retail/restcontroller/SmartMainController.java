package com.smart.retail.restcontroller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import src.com.retail.logic.SmartLogic;

import com.smart.retail.vo.MasterItemDetails;
import com.smart.retail.vo.MasterItemsList;
import com.smart.retail.vo.SmartUserData;
import com.smart.retail.vo.UserItemDetails;

@RestController
public class SmartMainController {

	@RequestMapping(value = "/pushSmartUserData", method = RequestMethod.POST/*, headers = "Accept=application/json"*/,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String pushSmartUserData(@RequestBody SmartUserData userData) {

		System.out.println("Inside pushSmartUserData for User :: "
				+ userData.getFirstName());
		
		String userId = SmartLogic.getUserIdFromUserName(userData);
		
		userData.setUserId(userId);
		
		System.out.println(" userId :: " + userId );
		
		return userData.getUserId();
	}

	@ResponseBody
	@RequestMapping(value = "/getMasterItems", method = RequestMethod.GET/*, headers = "Accept=application/json"*//*, produces = MediaType.APPLICATION_JSON_VALUE*/)
	public MasterItemsList getMasterItemDetails() {

		System.out.println("Inside getMasterItemDetails");

		return SmartLogic.getMasterItems();
	}
	
	@RequestMapping(value = "/publishUserItems", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE /* ,headers = "Accept=application/json"*/)
	public ResponseEntity<UserItemDetails> publish(@RequestBody UserItemDetails userItems)
	{		
		//TODO : Send Success Code / Error
		System.out.println("Inside publish");
		SmartLogic.publishUserItems(userItems);
		
		return new ResponseEntity<UserItemDetails>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/checkOut", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE/* ,headers = "Accept=application/json"*/)
	public ResponseEntity<UserItemDetails> checkout(@RequestBody UserItemDetails userItems)
	{
		//TODO : Push Notification
		//TODO : Notify for missing item
		//TODO : Send Success Code / Error
		System.out.println(" Inside checkout ");
		SmartLogic.checkOutUserItems(userItems);
		
		return new ResponseEntity<UserItemDetails>(HttpStatus.CREATED);
	}

}
