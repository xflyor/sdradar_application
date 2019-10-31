package com.cetc32s.sdradar.basic.debug;

public class SDRadarDebug {
	private final static boolean DEBUG_MODEL = true;
	private final static String flag = "SDRadar IDE -> ";
	
	public static void println(Object object) {
		if(!DEBUG_MODEL) return;		
		System.out.println(flag+object);		
	}

}
