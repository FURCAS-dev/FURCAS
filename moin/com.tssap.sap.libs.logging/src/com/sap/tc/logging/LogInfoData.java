package com.sap.tc.logging;

/**
 * Title:        Logging
 * Description:  Logging API
 * Copyright:    Copyright (c) 2003
 * Company:      SAP AG.
 *               Walldorf, Germany
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAP AG. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAP AG.
 * @version      $Id:$
 * @author			 Robert Boban
 */

import java.util.*;

public abstract class LogInfoData {
		
	//================================================ declaration > ====
	
	private String	 	logName;
	private String	 	logDescription;
	private String	 	logVersion;
	private String		logType;
	private Formatter logFormatter;
	
	private String 		logHeader;
	private String 		logFooter;
	
	private boolean 	isChanged;
	
	//==== < declaration ============================ constructors > ====
	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====
  
	public String getVerInUse() {
	  if (logVersion != null) {
	  	return logVersion;
	  }
	  return Version.getFullVersion();
	}
  
	public String getName(){
	   return logName;
	}
  
	public String getDescription(){
	   return logDescription;
	}
  
	public String getType(){
	  return logType;
  }
  
  public Formatter getFormatter() {
		if (logFormatter != null) {
	  	return logFormatter;
		}
		logFormatter = LoggingManager.DEFAULT_FORMATTER;
		return logFormatter;
  }
  
  public boolean isChanged() {
	  return isChanged;
  }

	public String getHeader() {
		if (logHeader != null) {
			return logHeader;
		}
		return HelperLib.EMPTY_STRING;
	}

	public String getFooter() {
		if (logFooter != null) {
			return logFooter;
		}
		return HelperLib.EMPTY_STRING;
	}

	public int length() {
		return getHeader().length();
	}

	//==== < public ==================================== protected > ====
  
	protected void setVerInUse(String value){
	  logVersion 	= value;
	  isChanged		= true;
  }
  
  protected void setName(String value){
	  logName 	= value;
	  isChanged	= true;
  }
  
  protected void setDescription(String value){
	  logDescription 	= value;
	  isChanged				= true;
  }
  
	protected void setType(int value){
		
	}
	
	public void setFormatter(Formatter value) {
	  this.logFormatter = value;
	  isChanged					= true;
  }
	
	protected void headerIsChanged(){
		isChanged		= true;
	}
	
	protected void resetIsChanged(){
		isChanged		= false;
	}
	
	protected void setHeader(String value) {
		this.logHeader = value;
	}

	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	//==== < private ================================== deprecated > ====
	
}
