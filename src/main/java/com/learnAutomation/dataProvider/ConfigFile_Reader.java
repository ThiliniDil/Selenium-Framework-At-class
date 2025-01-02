package com.learnAutomation.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigFile_Reader {
	
	public static String getProperty(String key)  {
		String value=null;
		try {
			File scr=new File(System.getProperty("user.dir")+"./ConfigFile/Config.properties");
			FileInputStream fst=new FileInputStream(scr);
			Properties pro=new Properties();
			pro.load(fst);
			value=pro.getProperty(key);

		} 
		catch (FileNotFoundException e) {
			System.out.println("The File Not Found"+e.getMessage());
			
		} catch (IOException e) {
			System.out.println("The File caouldn't read"+e.getMessage());
		}
		
		return value;
		
	}
	
	

}
