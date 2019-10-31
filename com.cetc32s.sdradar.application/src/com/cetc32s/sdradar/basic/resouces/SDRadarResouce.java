package com.cetc32s.sdradar.basic.resouces;

import org.eclipse.core.runtime.Platform;

import com.cetc32s.sdradar.basic.path.SDRadarPath;

public class SDRadarResouce {
	
	public static String getWorkspacePath() {
		String rawPath = Platform.getLocation().toString();
		return SDRadarPath.modifyDirPath(rawPath);		
	}

}
