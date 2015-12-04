package com.smart.retail.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class videotobytes {

	public static void main(String[] args) {

		String filepath = "D:\\Client_Confidential\\SmartRetail\\Stuff\\Wildlife.wmv";

		byte[] outputvalue = getByteArrayFromFile(filepath);
		String query = "Insert into blob_table values('" + outputvalue + "')";
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		}

		String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String USER = "GIRISH";
		String PASS = "KAANA";
		try {
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Statement stmt;
		try {
			stmt = conn.createStatement();

			int val = stmt.executeUpdate(query);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static byte[] getVideoBasedOnCatalogId(String catalogId)
	{
		//TODO : Fetch video based on catalog if from db
		
		/** Testing - START **/
		
		/** Testing - END **/
		
		return null;
	}
	
	public static byte[] getByteArrayFromFile(String filepath) {
		try {
			java.io.File file = new java.io.File(filepath);
			java.io.FileInputStream fis = new java.io.FileInputStream(file);
			int fileLength = (int) file.length();
			byte[] incoming_file_data = new byte[fileLength]; // allocate byte
																// array of
																// right size
			fis.read(incoming_file_data, 0, fileLength); // read into byte array
			fis.close();
			return incoming_file_data;
		} catch (Exception err) {
			err.printStackTrace();
			return null;
		}
	}
}
