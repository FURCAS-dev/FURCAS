package com.sap.tc.logging;

/*
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
 * @author			 Robert Boban
 */
 
import java.text.*;

public class MSGCollection {
		
	// *****************************************************************************************
	// Using Message ID 
	//*****************************************************************************************
	
	private static MsgObject CONFIGURATION_IS_CHANGED;
	public synchronized static MsgObject CONFIGURATION_IS_CHANGED () {
		if (CONFIGURATION_IS_CHANGED == null) {
			CONFIGURATION_IS_CHANGED 
				= new MsgObject("C0000A305666000000000000018FB1F70003D67C779CD2B8", 
											  "The {0} for the {1} {2} has been changed from {3} to {4})!", 
												"TC_LOGGING_CONFIGURATION_IS_CHANGED");
		}
		return CONFIGURATION_IS_CHANGED;
	}
	
	private static MsgObject CONFIGURATION_NEW_ITEM;
	public synchronized static MsgObject CONFIGURATION_NEW_ITEM() {
		if (CONFIGURATION_NEW_ITEM == null) {
			CONFIGURATION_NEW_ITEM  
				= new MsgObject("C0000A305666000000000002018FB1F70003D67C779ECE88", 
									  		"The {0} ({1}) has been added to the {2}!", 
												"TC_LOGGING_CONFIGURATION_NEW_ITEMS");
		}
		return CONFIGURATION_NEW_ITEM;
	}
	
	private static MsgObject CONFIGURATION_RESET;
	public static MsgObject CONFIGURATION_RESET () {
		if (CONFIGURATION_RESET == null) {
			CONFIGURATION_RESET  
				= new MsgObject("C0000A305666000000000004018FB1F70003D67C77A07C38", 
											  "The configuration on {0} reset!", 
												"TC_LOGGING_CONFIGURATION_RESET");
		}
		return CONFIGURATION_RESET;
	}
	
	private static MsgObject CONFIGURATION_REMOVE_ITEM;
	public synchronized static MsgObject CONFIGURATION_REMOVE_ITEM () {
		if (CONFIGURATION_REMOVE_ITEM == null) {
			CONFIGURATION_REMOVE_ITEM  
				= new MsgObject("C0000A305666000000000006018FB1F70003D67C77A202D8", 
											  "The {0} ({1}) has been removed from the {2}!", 
												"TC_LOGGING_CONFIGURATION_REMOVE_ITEMS");
		}
		return CONFIGURATION_REMOVE_ITEM;
	}
	
	private static MsgObject FORMATTER_CHANGED_ON_OPEN_LOG;
	public synchronized static MsgObject FORMATTER_CHANGED_ON_OPEN_LOG () {
		if (FORMATTER_CHANGED_ON_OPEN_LOG == null) {
			FORMATTER_CHANGED_ON_OPEN_LOG  
				= new MsgObject("C0000A305666000000000006018FB1F70003D67C77A202D9", 
											  "Attempting to change Formatter on open IBaseLog {0} instance!!", 
												"TC_LOGGING_FORMATTER_CHANGED_ON_OPEN_LOG");
		}
		return FORMATTER_CHANGED_ON_OPEN_LOG;
	}

	// *****************************************************************************************
		public static String EMPTY_STRING													= "";
		public static String DATE_STRING_PATTERN 									= "EEE MMM dd HH:mm:ss z yyyy";
		
		public static String RESOURCE_BUNDLE_NAME									= "SAP_LOGGING_RES_BUNDLE";
		
		public static String LOGGING_EXC_FORMAT_CHANGE						= "Attempting to change Formatter on open IBaseLog instance!";
		
		
		
		public static String LOGGING_MSG_ID_UNHANDLED 						= "SAP_LOGGING_UNHANDLED";
		public static String LOGGING_MSG_STR_UNHANDLED     				= "Unhandled message: ";
			
		public static String LOGGING_MSG_ID_UNEXPECTED 						= "SAP_LOGGING_UNEXPECTED";
		public static String LOGGING_MSG_STR_UNEXPECTED    				= "Unexcepted error occured on {0}!";

		public static String LOGGING_MSG_ID_OBJECT_IS_NULL	  		= "SAP_LOGGING_OBJECT_IS_NULL";
		public static String LOGGING_MSG_STR_OBJECT_IS_NULL    		= "Excepted object is not specified ({0} == null) for {1}({2})!";
		
		public static String LOGGING_MSG_ID_OBJECT_IS_NULL_DEF 		= "SAP_LOGGING_OBJECT_IS_NULL_DEF";
		public static String LOGGING_MSG_STR_OBJECT_IS_NULL_DEF		= "Excepted object is not specified ({0} == null) for {1}({2})! Default {3} ({4}) is created!";
		
		public static String LOGGING_MSG_ID_FEATURE_IS_DISABLED 	= "SAP_LOGGING_FEATURE_IS_DISABLED";
		public static String LOGGING_MSG_STR_FEATURE_IS_DISABLED	= "You try to use feature ({0}) which is not enabled or not in use!";
			
		public static String LOGGING_MSG_ID_WRONG_SEVERITY_VALUE  = "SAP_LOGGING_WRONG_SEVERITY_VALUE";
		public static String LOGGING_MSG_STR_WRONG_SEVERITY_VALUE = "Attempting to set not existing severity level of {0}. New severity value will be: {1}";
		
		public static String LOGGING_MSG_ID_FILTER_EXCEPTION 		  = "SAP_LOGGING_FILTER_EXCEPTION";
		public static String LOGGING_MSG_STR_FILTER_EXCEPTION     = "Exception in custom filter for this {0} ({1})!";
		
		public static String LOGGING_MSG_ID_WRITE_EXCEPTION 		  = "SAP_LOGGING_WRITE_EXCEPTION";
		public static String LOGGING_MSG_STR_WRITE_EXCEPTION      = "Exception when trying writes a log record to this log({0})!";
		
		public static String LOGGING_MSG_ID_CLOSE_EXCEPTION 		  = "SAP_LOGGING_CLOSE_EXCEPTION";
		public static String LOGGING_MSG_STR_CLOSE_EXCEPTION      = "Exception when trying to close this log({0})!";
		
		public static String LOGGING_MSG_ID_OPEN_EXCEPTION 		  	= "SAP_LOGGING_OPEN_EXCEPTION";
		public static String LOGGING_MSG_STR_OPEN_EXCEPTION       = "Exception when trying to open this log({0})!";
		
		public static String LOGGING_MSG_ID_GROUP_OPEN_LIMIT 		  = "SAP_LOGGING_GROUP_OPEN_LIMIT";
		public static String LOGGING_MSG_STR_GROUP_OPEN_LIMIT     = "You cannot open more groups for this {0}({1}) then you have specified ({2})!";
		
		public static String LOGGING_MSG_ID_UNSUPPORTED_ENCODING 	= "SAP_LOGGING_UNSUPPORTED_ENCODING";
		public static String LOGGING_MSG_STR_UNSUPPORTED_ENCODING = "Unsupported encoding ''{0}''";
	
		public static String LOGGING_MSG_ID_FOLDER_FILE_NOT_FOUND 	= "SAP_LOGGING_FOLDER_FILE_NOT_FOUND";
		public static String LOGGING_MSG_STR_FOLDER_FILE_NOT_FOUND 	= "Folder/file ''{0}'' could not be found or created!";

		public static String LOGGING_MSG_ID_FILE_NOT_FOUND 				= "SAP_LOGGING_FILE_NOT_FOUND";
		public static String LOGGING_MSG_STR_FILE_NOT_FOUND 			= "File ''{0}'' could not be found or created!";

		public static String LOGGING_MSG_ID_FILE_READ 						= "SAP_LOGGING_FILE_READ";
		public static String LOGGING_MSG_STR_FILE_READ 						= "File ''{0}'' could not be read!";

		public static String LOGGING_MSG_ID_NO_PERMISSION_FILE 		= "SAP_LOGGING_NO_PERMISSION_FILE";
		public static String LOGGING_MSG_STR_NO_PERMISSION_FILE 	= "No permission to write/read to/from file ''{0}''!";
		
		public static String LOGGING_MSG_ID_INVALID_CONTENT_FORMAT	= "SAP_LOGGING_INVALID_CONTENT_FORMAT";
		public static String LOGGING_MSG_STR_INVALID_CONTENT_FORMAT	= "Invalid content format. Check if the content is formatted with the assigned formatter.";
		
		public static String LOGGING_MSG_ID_PARSING								= "SAP_LOGGING_PARSING";
		public static String LOGGING_MSG_STR_PARSING							= "One or more messages cannot be parsed!";
		
		public static String LOGGING_MSG_ID_PARSING_ARG						= "SAP_LOGGING_PARSING_ARG";
		public static String LOGGING_MSG_STR_PARSING_ARG					= "One or more messages cannot be parsed: {0}!";
		
		public static String LOGGING_MSG_ID_PARSING_FIELD					= "SAP_LOGGING_PARSING_FIELD";
		public static String LOGGING_MSG_STR_PARSING_FIELD				= "Field {0} cannot be parsed! Message ID : {1}";
		
		public static String LOGGING_MSG_ID_MISSING_FIELDS				= "SAP_LOGGING_MISSING_FIELDS";
		public static String LOGGING_MSG_STR_MISSING_FIELDS				= "One or more message fields are missing! Expected number of fieds is {0} and message have {1}";
		
		public static String LOGGING_MSG_ID_PARSING_ARGS					= "SAP_LOGGING_PARSING_ARGS";
		public static String LOGGING_MSG_STR_PARSING_ARGS					= "Message argument error! Invocation of Object.toString() failed";
		
		public static String LOGGING_MSG_ID_ROLL_READ							= "SAP_LOGGING_MSG_ROLL_READ";
		public static String LOGGING_MSG_STR_ROLL_READ						= "Fail to rollback due to file overwritten. Reset to the oldest message";	
		
		public static String LOGGING_MSG_ID_READ_OVERWRITTEN			= "SAP_LOGGING_MSG_READ_OVERWRITTEN";
		public static String LOGGING_MSG_STR_READ_OVERWRITTEN			= "File currently read ({0}) has been overwritten.";
		
		public static String LOGGING_MSG_ID_HEADER_ERROR					= "SAP_LOGGING_MSG_HEADER_ERROR";
		public static String LOGGING_MSG_STR_HEADER_ERROR					= "File header does not exists or has a wrong format on Log ({0}).";
		
		public static String LOGGING_MSG_ID_NON_EQUAL_PATTERN			= "SAP_LOGGING_MSG_NON_EQUAL_PATTERN";
		public static String LOGGING_MSG_STR_NON_EQUAL_PATTERN		= "File name from the FileHeader pattern ({0}) and file name from the FileLog pattern ({1}) are not equal! /n File name from the FileLog pattern will be used and the FileLog mode is set to MODE_SINGLE_FILE!";
		
		public static String LOGGING_MSG_ID_FORMATTER_ERROR				= "SAP_LOGGING_FORMATTER_ERROR";
		public static String LOGGING_MSG_STR_FORMATTER_ERROR		  = "Attempting to change a formatter on active log {0}! The reset() method must be called first!";
		
		public static String LOGGING_MSG_ID_LOG_REMOVE						= "SAP_LOGGING_LOG_REMOVE";
		public static String LOGGING_MSG_STR_LOG_REMOVE		  			= "Remove log {0} from LogController {1}!";
		
		public static String LOGGING_MSG_ID_BUFFER_READ						= "SAP_LOGGING_BUFFER_READ";
		public static String LOGGING_MSG_STR_BUFFER_READ		  		= "Buffer index error on index {0}!";
		
		public static String LOGGING_MSG_ID_BUFFER_READ_SOURCE		= "SAP_LOGGING_BUFFER_READ_SOURCE";
		public static String LOGGING_MSG_STR_BUFFER_READ_SOURCE		= "Buffer error while reading the source file {0}!";
		
		public static String LOGGING_MSG_ID_LV_INVALID_OPTION			= "SAP_LOGGING_LV_INVALID_OPTION";
		public static String LOGGING_MSG_STR_LV_INVALID_OPTION		= "Invalid {0} option: {1}!";
		
		public static String LOGGING_MSG_ID_EVENT_LOG							= "SAP_LOGGING_EVENT_LOG";
		public static String LOGGING_MSG_STR_EVENT_LOG						= "Logging API event log is {1}!";
		
		public static String LOGGING_MSG_ID_ILLEGAL_ARG						= "SAP_LOGGING_ILLEGAL_ARG";
		public static String LOGGING_MSG_STR_ILLEGAL_ARG					= "Argument {0} have illegal value ({1})! The value must be {2}!";
		
		//================================================ declaration > ====
	  //==== < declaration ============================ constructors > ====
	  //==== < constructors =============================== abstarct > ====
	  //==== < abstract ===================================== public > ====
	  //==== < public ==================================== protected > ====
	  //==== < protected =================================== default > ====
	  //==== < default ===================================== private > ====
	  //==== < private ================================== deprecated > ====
	  
	  public static String getMessage(String pattern, Object[] args) {
	  	// Guardian
	  	if (pattern == null || args == null) return EMPTY_STRING;
			try {	
				return MessageFormat.format(pattern, args);
			}
			catch (Exception ex) {
				return EMPTY_STRING;
			}
	  }
	  
}
