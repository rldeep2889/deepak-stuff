package com.smart.retail.utils;

public class VideoUtils {


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
	
	/*public static void runVideo()
	{
		JFileChooser fileChooser = new JFileChooser();
		 
		fileChooser.showOpenDialog(null);
		 
		URL mediaUrl=null;
		 
		try {
		 
		mediaUrl = fileChooser.getSelectedFile().toURI().toURL();
		 
		} catch (MalformedURLException ex) {
		 
		System.out.println(ex);
		 
		}
		 
		JFrame mediaTest = new JFrame( "Movie Player" );
		 
		mediaTest.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		 MediaPanel 
		Player mediaPlayer = Manager.createRealizedPlayer( mediaUrl );
		 
		mediaTest.add(mediaPlayer);
		 
		mediaTest.setSize( 800, 700 ); // set the size of the player
		 
		mediaTest.setLocationRelativeTo(null);
		 
		mediaTest.setVisible( true );
		 
		}
	}*/
}
