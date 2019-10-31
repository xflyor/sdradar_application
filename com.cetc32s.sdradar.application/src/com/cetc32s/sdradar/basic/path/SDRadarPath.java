package com.cetc32s.sdradar.basic.path;

import java.io.File;

public class SDRadarPath {
	
	public static String getFileSeparator() {
		return System.getProperty("file.separator");
	}
	
	public static boolean isWin() {		
		String osString = System.getProperty("file.separator");
		if(osString.equals("\\"))return true;		
		if(osString.toLowerCase().startsWith("win"))return true;
		else return false;			
	}
	
	public static boolean isLinux() {
		String osString = System.getProperty("file.separator");
		if(osString.equals("/"))return true;
		else return false;	
	}
	
	
	public static String modifyDirPath(String path) {
		if(path.length()<1)return "";
		
		String separator = System.getProperty("file.separator");	
		String retString = "";
		if(SDRadarPath.isWin()) {			
			retString = path.replace("/", separator);
		}
		if(SDRadarPath.isLinux()) {			
			retString = path.replace("\\", separator);
		}
		
		if(retString.length()>0&&!retString.endsWith(separator))retString+=separator;	
		
		return retString;
		
	}
	
	public static String modifyFilePath(String path) {	
		if(path.length()<1)return "";
		
		String separator = System.getProperty("file.separator");	
		String retString = "";
		if(SDRadarPath.isWin()) {			
			retString = path.replace("/", separator);
		}
		if(SDRadarPath.isLinux()) {			
			retString = path.replace("\\", separator);
		}	

		
		return retString;
		
	}


}
