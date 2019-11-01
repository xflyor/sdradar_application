package com.cetc32s.sdradar.plugin.assemble.model.connection;

import java.io.Serializable;

public class ConnectionModel implements Serializable{
	public static final String Name = "SDRADAR_CONNECT_MODEL_1111111111111111111111";
	
	private String source;
	private String target;
	private short id;
	
	
	public ConnectionModel() {
		// TODO Auto-generated constructor stub
		source = "";
		target = "";
		id = 0;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getTarget() {
		return target;
	}


	public void setTarget(String target) {
		this.target = target;
	}


	public short getId() {
		return id;
	}


	public void setId(short id) {
		this.id = id;
	}
	
	
	
	

}
