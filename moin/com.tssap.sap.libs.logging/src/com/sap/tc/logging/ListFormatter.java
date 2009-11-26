package com.sap.tc.logging;

/**
 * Title:        Logging
 * Description:  Logging API
 * Copyright:    Copyright (c) 2003
 * Company:      SAP AG.
 *               Walldorf, Germany.
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAPMarkets Inc. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAP AG.
 * @author			 Refactored by Robert Boban
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.sap.tc.logging.interfaces.IMessageBuilder;

/**
 * Formats log records as simple hash-separated columns.
 */
public class ListFormatter extends Formatter
{ //$JL-SWITCH$ $JL-EXC$
	//================================================ declaration > ====
	
	private static Location classLoc = Location.getLocation(ListFormatter.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
    private static final SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyy MM dd HH:mm:ss:SSS");
//    private static final SimpleDateFormat timeZoneFormatter = new SimpleDateFormat("Z");
    
    static final String PATTERN = "yyyy MM dd HH:mm:ss:SSS";
    static int size = PATTERN.length();
    static final char DEL1 = ' ';
    static final char DEL2 = ':';
    static final char ZERO = '0';    
	
	static final String EMPTY_STRING 			= "";

	private static final String 	DEAFULT_COMPATIBILE_VERSION = "2.0";
	private final static int 			INITIAL_CAPACITY = 512;

	private final static String 	DATE_STRING_PATTERN =	"EEE MMM dd HH:mm:ss z yyyy";
	
	private static final int 		F_MIN 									= -1; 
	private static final int 		F_VERSION 							= F_MIN + 1;
	private static final String F_NAME_VERSION 					= "LR_VERSION";
    private static final int        F_DATE_TIME                         = F_VERSION + 1;
    public  static final String F_NAME_DATE_TIME                = "LR_DATE";    
    private static final int        F_TIME_ZONE                         = F_DATE_TIME + 1;
    public  static final String F_NAME_TIME_ZONE                = "LR_TIME_ZONE";
    private static final int        F_SEVERITY                          = F_TIME_ZONE + 1;
    public  static final String F_NAME_SEVERITY                 = "LR_SEVERITY";
    private static final int        F_SOURCE_NAME                   = F_SEVERITY + 1;
    public  static final String F_NAME_SOURCE                       = "LR_SOURCE";
    private static final int        F_MSG_CODE                          = F_SOURCE_NAME + 1;
    private static final String F_NAME_MSG_CODE                 = "LR_MSG_CODE";    
    private static final int        F_CSN_COMPONENT                          = F_MSG_CODE + 1;
    private static final String F_NAME_CSN_COMPONENT                 = "LR_MSG_CSN_COMPONENT";
    private static final int        F_DC_NAME                          = F_CSN_COMPONENT + 1;
    private static final String F_NAME_DC_NAME                 = "LR_MSG_DC_NAME";        
	private static final int 		F_GUID 									= F_DC_NAME + 1;
	private static final String F_NAME_GUID							= "LR_ID";
    private static final int        F_CORRELATION_ID                      = F_GUID + 1;
    private static final String F_NAME_CORRELATION_ID                         = "LR_CORRELATION_ID";    
    private static final int        F_APPLICATION_NAME          = F_CORRELATION_ID + 1;
    public  static final String F_NAME_APPLICATION          = "LR_APPLICATION";
    private static final int        F_LOCATION_NAME                 = F_APPLICATION_NAME + 1;
    public  static final String F_NAME_LOCATION                 = "LR_LOCATION";
    private static final int        F_USER                                  = F_LOCATION_NAME + 1;
    public  static final String F_NAME_USER                         = "LR_USER";
    private static final int        F_SESSION                           = F_USER + 1;
    public  static final String F_NAME_SESSION                  = "LR_SESSION";
    private static final int        F_TRANSACTION                       = F_SESSION + 1;
    public  static final String F_NAME_TRANSACTION          = "LR_TRANSACTION";
    private static final int        F_DSR_ROOT_CONTEXT_ID                   = F_TRANSACTION + 1;
    public  static final String F_NAME_DSR_ROOT_CONTEXT_ID      = "LR_DSR_ROOT_CONTEXT_ID";
    private static final int        F_DSR_TRANSACTION                           = F_DSR_ROOT_CONTEXT_ID + 1;
    public  static final String F_NAME_DSR_TRANSACTION              = "LR_DSR_TRANSACTION";
    private static final int        F_DSR_CONNECTION                = F_DSR_TRANSACTION + 1;
    public  static final String F_NAME_DSR_CONNECTION   = "LR_DSR_CONNECTION";
    private static final int        F_DSR_COUNTER                   = F_DSR_CONNECTION + 1;
    public  static final String F_NAME_DSR_COUNTER      = "LR_DSR_CONNECTION";
    private static final int        F_THREAD_NAME                       = F_DSR_COUNTER + 1;
    public  static final String F_NAME_THREAD_NAME          = "LR_THREAD_NAME";
    private static final int        F_MSG_TYPE                          = F_THREAD_NAME + 1;
    private static final String F_NAME_MSG_TYPE                 = "LR_MSG_TYPE";
    private static final int        F_RES_BUNDLE                        = F_MSG_TYPE + 1;
    private static final String F_NAME_RES_BOUNDLE          = "LR_RESOURCE_BUNDLE";
    private static final int        F_MSG_CLEAR                         = F_RES_BUNDLE + 1;
    public  static final String F_NAME_MSG_CLEAR                = "LR_MESSAGE";
    private static final int        F_MSG_ARGS_CNT                  = F_MSG_CLEAR + 1;
    private static final String F_NAME_ARGS_CNT                 = "LR_MESSAGE ARGS COUNT";
    private static final int        F_MSG_ARGS                          = F_MSG_ARGS_CNT + 1;
    private static final String F_NAME_ARGS                         = "LR_ARGUMENTS";
    
    private static final int        F_MAX                                       = F_MSG_ARGS + 1;    
    
    /**
     * @deprecated
     */
    private static final int        F_DSR_COMPONENT                 = -1;
    /**
     * @deprecated
     */    
    public static final String F_NAME_DSR_COMPONENT        = null;
    /**
     * @deprecated
     */    
    private static final int        F_DSR_USER                          = -1;
    /**
     * @deprecated
     */    
    public  static final String F_NAME_DSR_USER                 = null;
    /**
     * @deprecated
     */        
	private static final int 		F_GROUP_ID							= F_THREAD_NAME + 1;
    /**
     * @deprecated
     */        
	private static final String F_NAME_GROUP_ID					= "LR_GROUP_ID";
    /**
     * @deprecated
     */        
	private static final int 		F_GROUP_LEVEL						= F_GROUP_ID + 1;
    /**
     * @deprecated
     */        
	private static final String F_NAME_GROUP_LEVEL			= "LR_GROUP_LEVEL";
    /**
     * @deprecated
     */        
	private static final int 		F_GROUP_INDENT					= F_GROUP_LEVEL + 1;
    /**
     * @deprecated
     */        
	private static final String F_NAME_GROUP_INDENT			= "LR_GROUP_IDENT";
    /**
     * @deprecated
     */        
	private static final int 		F_RELATIVES_CNT					= F_SEVERITY + 1;
    /**
     * @deprecated
     */        
	private static final String F_NAME_RELATIVES_CNT		= "LR_RELATIVES_COUNT";
    /**
     * @deprecated
     */        
	private static final int 		F_RELATIVES							= F_RELATIVES_CNT + 1;
    /**
     * @deprecated
     */        
	private static final String F_NAME_RELATIVES				= "LR_RELATIVES";

	
    private static final int 		F_MIN_15 									= -1; 
	private static final int 		F_VERSION_15 							= F_MIN_15 + 1;
	private static final int 		F_GUID_15									= F_VERSION_15 + 1;
	private static final int 		F_DATE_TIME_15 						= F_GUID_15 + 1;
	private static final int 		F_SOURCE_NAME_15 					= F_DATE_TIME_15 + 1;
	private static final int 		F_APPLICATION_NAME_15 			= F_SOURCE_NAME_15 + 1;
	private static final int 		F_LOCATION_NAME_15 				= F_APPLICATION_NAME_15 + 1;
	private	static final int 		F_USER_15 									= F_LOCATION_NAME_15 + 1;
	private static final int 		F_SESSION_15 							= F_USER_15 + 1;
	private static final int 		F_TRANSACTION_15						= F_SESSION_15 + 1;
	private static final int 		F_DSR_COMPONENT_15					= F_TRANSACTION_15 + 1;
	private static final int 		F_DSR_USER_15 							= F_DSR_COMPONENT_15 + 1;
	private static final int 		F_DSR_TRANSACTION_15				= F_DSR_USER_15 + 1;
	private static final int 		F_THREAD_NAME_15						= F_DSR_TRANSACTION_15 + 1;
	private static final int 		F_GROUP_ID_15							= F_THREAD_NAME_15 + 1;
	private static final int 		F_GROUP_LEVEL_15						= F_GROUP_ID_15 + 1;
	private static final int 		F_GROUP_INDENT_15					= F_GROUP_LEVEL_15 + 1;
	private static final int 		F_SEVERITY_15							= F_GROUP_INDENT_15 + 1;
	private static final int 		F_RELATIVES_CNT_15					= F_SEVERITY_15 + 1;
	private static final int 		F_RELATIVES_15							= F_RELATIVES_CNT_15 + 1;
	private static final int 		F_MSG_TYPE_15							= F_RELATIVES_15 + 1;
	private static final int 		F_MSG_CODE_15							= F_MSG_TYPE_15 + 1;
	private static final int 		F_RES_BUNDLE_15						= F_MSG_CODE_15 + 1;
	private static final int 		F_MSG_CLEAR_15							= F_RES_BUNDLE_15 + 1;
	private static final int 		F_MSG_ARGS_CNT_15					= F_MSG_CLEAR_15 + 1;
	private static final int 		F_MSG_ARGS_15						= F_MSG_ARGS_CNT_15+ 1;
	private static final int 		F_MAX_15									= F_MSG_ARGS_15 + 1;
	
	//	max number of fields is: F_MSG_CLEAR + number of msg arguments  
	//private static final int F_MIN_No_DELIMITERS		= F_MSG_CLEAR + 2; 
	// in the format(...) method all fileds with VALUE_ALWAYS mark
	
	private static final int F_MIN_No_FIELD_VALUES_16	= 10;
	private static final int F_MIN_No_FIELD_VALUES_15	= 10;
	private static final int F_MIN_No_FIELD_VALUES_14	= 10; 
	private static final int F_MIN_No_FIELD_VALUES_13	= 10; 
	private static final int F_MIN_No_FIELD_VALUES_12	= 10; 
	  
    private static final int F_MIN_No_DELIMITERS_20 = 24;
    private static final int F_MIN_No_DELIMITERS_16	= 10;
	private static final int F_MIN_No_DELIMITERS_15	= 23;
	private static final int F_MIN_No_DELIMITERS_14	= 10; 
	private static final int F_MIN_No_DELIMITERS_13	= 10; 
	private static final int F_MIN_No_DELIMITERS_12	= 10; 
	
	private static final char DELIMITER_CHAR					= '#';	
	private static final char BACKSPACE							= 8;
	private static final char ESCAPE_CHAR 						= '\\';
	
	public  static final String DELIMITER_STR					= String.valueOf(DELIMITER_CHAR);
	private static final String ESCAPE_STR						= String.valueOf(ESCAPE_CHAR);
	private static final String ESCAPED_DELIMITER 				= ESCAPE_STR.concat(DELIMITER_STR);	
  
	private static Map<String, Integer> columns = new HashMap<String, Integer>();
    	
	//==== < declaration ============================ constructors > ====
	
	public ListFormatter()
	{
		super();
	}

	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====
	
	public static Map<String, Integer> getFields() {
	      switch (Version.getVersionIndex(Version.getVersionOfFirstRecord())) {
	        case  Version.VER_CODE_1_5:
	        {
	  		  columns.put(F_NAME_VERSION, 				    new Integer(F_VERSION_15));
			  columns.put(F_NAME_GUID,						new Integer(F_GUID_15));
			  columns.put(F_NAME_DATE_TIME,					new Integer(F_DATE_TIME_15));
			  columns.put(F_NAME_SOURCE,					new Integer(F_SOURCE_NAME_15));
			  columns.put(F_NAME_APPLICATION,				new Integer(F_APPLICATION_NAME_15));
			  columns.put(F_NAME_LOCATION,					new Integer(F_LOCATION_NAME_15));
			  columns.put(F_NAME_USER,						new Integer(F_USER_15));
			  columns.put(F_NAME_SESSION,					new Integer(F_SESSION_15));
			  columns.put(F_NAME_TRANSACTION,				new Integer(F_TRANSACTION_15));
			  columns.put(F_NAME_DSR_COMPONENT,				new Integer(F_DSR_COMPONENT_15));
			  columns.put(F_NAME_DSR_USER,					new Integer(F_DSR_USER_15));
			  columns.put(F_NAME_DSR_TRANSACTION,			new Integer(F_DSR_TRANSACTION_15));
			  columns.put(F_NAME_THREAD_NAME,				new Integer(F_THREAD_NAME_15));
			  columns.put(F_NAME_GROUP_ID,					new Integer(F_GROUP_ID_15));
			  columns.put(F_NAME_GROUP_LEVEL,			    new Integer(F_GROUP_LEVEL_15));
			  columns.put(F_NAME_GROUP_INDENT,			    new Integer(F_GROUP_INDENT_15));
			  columns.put(F_NAME_SEVERITY,				    new Integer(F_SEVERITY_15));
			  columns.put(F_NAME_RELATIVES_CNT,			    new Integer(F_RELATIVES_CNT_15));
			  columns.put(F_NAME_RELATIVES,				    new Integer(F_RELATIVES_15));
			  columns.put(F_NAME_MSG_TYPE,				    new Integer(F_MSG_TYPE_15));
			  columns.put(F_NAME_MSG_CODE,				    new Integer(F_MSG_CODE_15));
			  columns.put(F_NAME_RES_BOUNDLE,			    new Integer(F_RES_BUNDLE_15));
			  columns.put(F_NAME_MSG_CLEAR,				    new Integer(F_MSG_CLEAR_15));
			  columns.put(F_NAME_ARGS_CNT,				    new Integer(F_MSG_ARGS_CNT_15));
			  columns.put(F_NAME_ARGS,					    new Integer(F_MSG_ARGS_15));
	          break;
	        }
	        case  Version.VER_CODE_2_0:
	        {
			  columns.put(F_NAME_VERSION, 					new Integer(F_VERSION));
			  columns.put(F_NAME_DATE_TIME,					new Integer(F_DATE_TIME));
			  columns.put(F_NAME_TIME_ZONE,					new Integer(F_TIME_ZONE));
			  columns.put(F_NAME_SEVERITY,					new Integer(F_SEVERITY));
			  columns.put(F_NAME_SOURCE,					new Integer(F_SOURCE_NAME));
			  columns.put(F_NAME_MSG_CODE,					new Integer(F_MSG_CODE));
			  columns.put(F_NAME_CSN_COMPONENT,				new Integer(F_CSN_COMPONENT));
			  columns.put(F_NAME_DC_NAME,					new Integer(F_DC_NAME));
			  columns.put(F_NAME_GUID,						new Integer(F_GUID));
	          columns.put(F_NAME_CORRELATION_ID,            new Integer(F_CORRELATION_ID));
	          columns.put(F_NAME_APPLICATION,               new Integer(F_APPLICATION_NAME));
	          columns.put(F_NAME_LOCATION,                  new Integer(F_LOCATION_NAME));
	          columns.put(F_NAME_USER,                      new Integer(F_USER));
			  columns.put(F_NAME_SESSION,					new Integer(F_SESSION));
			  columns.put(F_NAME_TRANSACTION,				new Integer(F_TRANSACTION));
			  columns.put(F_NAME_DSR_ROOT_CONTEXT_ID,		new Integer(F_DSR_ROOT_CONTEXT_ID));
			  columns.put(F_NAME_DSR_TRANSACTION,			new Integer(F_DSR_TRANSACTION));
			  columns.put(F_NAME_DSR_CONNECTION,			new Integer(F_DSR_CONNECTION));
			  columns.put(F_NAME_DSR_COUNTER,				new Integer(F_DSR_COUNTER));
			  columns.put(F_NAME_THREAD_NAME,				new Integer(F_THREAD_NAME));
			  columns.put(F_NAME_MSG_TYPE,					new Integer(F_MSG_TYPE));
			  columns.put(F_NAME_RES_BOUNDLE,				new Integer(F_RES_BUNDLE));
			  columns.put(F_NAME_MSG_CLEAR,					new Integer(F_MSG_CLEAR));
			  columns.put(F_NAME_ARGS_CNT,					new Integer(F_MSG_ARGS_CNT));
			  columns.put(F_NAME_ARGS,						new Integer(F_MSG_ARGS));
			  break;
	        }
	      }
		return Collections.unmodifiableMap(columns);
	}
	
  /**
   * Returns the MsgByte object.
   * @return MsgByte
   */
  public IMessageBuilder getMessageBuilder() {
  	
  	MessageDelimiterBuilder msgDelimiter = null;
		
  	switch (Version.getVersionIndex(Version.getVersionOfFirstRecord())) {
            case Version.VER_CODE_2_0:
                msgDelimiter = new MessageDelimiterBuilder((byte) DELIMITER_CHAR, F_MIN_No_DELIMITERS_20);
                msgDelimiter.addDynamicCounter(F_MSG_ARGS_CNT, false);
                break;
			case Version.VER_CODE_1_5:
				msgDelimiter = new MessageDelimiterBuilder((byte) DELIMITER_CHAR, F_MIN_No_DELIMITERS_15);
				msgDelimiter.addDynamicCounter(F_RELATIVES_CNT_15, true);
				msgDelimiter.addDynamicCounter(F_MSG_ARGS_CNT_15 - 1, false);
			case Version.VER_CODE_1_6:
				break;
			case Version.VER_CODE_UNKNOWN:
	}
  	return new MessageBuilder(this, msgDelimiter);
  }

	public static boolean compareField(int fieldIndex, int operater, String valueA, String valueB) {
		
		switch (fieldIndex) {
			case F_SOURCE_NAME: 
			case F_APPLICATION_NAME:
			case F_LOCATION_NAME:
			case F_SESSION:
			case F_TRANSACTION:
			case F_DSR_CONNECTION:
			case F_DSR_ROOT_CONTEXT_ID:
			case F_DSR_TRANSACTION:
			case F_THREAD_NAME:
			case F_MSG_CLEAR:
			case F_SEVERITY:
            case F_VERSION:
            
				return valueA.equalsIgnoreCase(valueB);

			case ListFormatter.F_DATE_TIME:
				try {
					Date d1	= new Date(Long.parseLong(valueA));
					Date d2	= new Date(Long.parseLong(valueB));
					return HelperLib.compareTwoDates(operater, d1, d2);					
				}
				catch (Exception ex) {
				}
				break;
		}
	
		return false;
	}
	
	public String format(LogRecord rec)
	{		
		String msgClear = rec.getMsgClear();
				
		StringBuilder res = new StringBuilder(INITIAL_CAPACITY + msgClear.length());

        res.append(DELIMITER_CHAR);
        res.append(getWorkingVersion());
        res.append(BACKSPACE);         
        res.append(DELIMITER_CHAR);
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(rec.getTime());
        res.append(formatDate(c));
//        res.append(dateTimeFormatter.format(rec.getTime()));        
        res.append(DELIMITER_CHAR);
//        res.append(timeZoneFormatter.format(rec.getTime()));
        res.append(formatTimeZone(c));
        res.append(DELIMITER_CHAR);
        res.append(Severity.toString(rec.getSeverity()));
        res.append(DELIMITER_CHAR);
        escapeAndConcat(rec.getSourceName(), res);
        res.append(DELIMITER_CHAR);        
        res.append(EOL);
        res.append(rec.getMsgCode());
        res.append(DELIMITER_CHAR);  
        res.append(rec.getCsnComponent());
        res.append(DELIMITER_CHAR);
        res.append(rec.getDCName());        
        res.append(DELIMITER_CHAR);        
        res.append(rec.getId());
        res.append(DELIMITER_CHAR);
        if (rec.getCorrelatorID() != UID.EMPTY_CORRELATOR_ID) { 
            res.append(rec.getCorrelatorID());
        }
        res.append(DELIMITER_CHAR);
        escapeAndConcat(rec.getApplication(), res);
        res.append(DELIMITER_CHAR);
        escapeAndConcat(rec.getLocationName(), res);
        res.append(DELIMITER_CHAR);
        escapeAndConcat(rec.getUser(), res);
        res.append(DELIMITER_CHAR);
        escapeAndConcat(rec.getSession(), res);
        res.append(DELIMITER_CHAR);
        escapeAndConcat(rec.getTransaction(), res);        
        res.append(DELIMITER_CHAR);
        escapeAndConcat(rec.getDSRRootContextID(), res);
        res.append(DELIMITER_CHAR);
        escapeAndConcat(rec.getDSRTransactionID(), res);
        res.append(DELIMITER_CHAR);
        escapeAndConcat(rec.getDSRConnection(), res);        
        res.append(DELIMITER_CHAR);
        if (rec.getDSRCounter() != -1) {
          res.append(rec.getDSRCounter());
        }
        res.append(DELIMITER_CHAR);
        escapeAndConcat(rec.getThreadName(), res);
        res.append(DELIMITER_CHAR);
        res.append(MsgType.toString(MsgType.PLAIN));
        res.append(DELIMITER_CHAR);
        res.append(rec.getResourceBundleName());
        res.append(DELIMITER_CHAR);
        res.append(EOL);
        if (rec.getNonExceptionArgsCount() < rec.getArgObjs().size()) {
        	// the last argument of record is an exception comming from
        	// traceThrowableT - it should be replaced with the last
        	// available placeholder - the one after the [EXCEPTION] pointer        	
        	msgClear = LogController.replaceException(rec, rec.getMsgClear());
        	
        	// create a reduced argument list without the exception argument
        	List<Object> reducedArgumentList = new ArrayList<Object>(rec.getArgObjs());
        	reducedArgumentList.remove(rec.getArgsInt().length - 1);
        	escapeAndConcat(LogController.replaceArguments(msgClear, 
        			reducedArgumentList.toArray()), res);
        } else {
        	// no exceptions comming from traceThrowableT in argument list
        	// process normally - just replace arguments
        	escapeAndConcat(LogController.replaceArguments(msgClear, rec.getArgsInt()), res);
        }

        res.append(DELIMITER_CHAR);
        res.append(EOL);
        res.append(EOL);
        
		return res.toString();
	}
    
    private String formatDate(Calendar c) {
        StringBuilder sb = new StringBuilder( size );

        // year
        sb.append( c.get( Calendar.YEAR ) );
        sb.append( DEL1 );

        // month
        int i = c.get( Calendar.MONTH ) + 1;
        if ( i < 10 ) {
          sb.append( ZERO );
        }
        sb.append( i );
        sb.append( DEL1 );

        // day
        i = c.get( Calendar.DAY_OF_MONTH );
        if ( i < 10 ) {
          sb.append( ZERO );
        }
        sb.append( i );
        sb.append( DEL1 );

        // hour
        i = c.get( Calendar.HOUR_OF_DAY);
        if ( i < 10 ) {
          sb.append( ZERO );
        }
        sb.append( i );
        sb.append( DEL2 );

        // minute
        i = c.get( Calendar.MINUTE );
        if ( i < 10 ) {
          sb.append( ZERO );
        }
        sb.append( i );
        sb.append( DEL2 );

        // second
        i = c.get( Calendar.SECOND );
        if ( i < 10 ) {
          sb.append( ZERO );
        }
        sb.append( i );
        sb.append( DEL2 );

        // milisecond
        i = c.get( Calendar.MILLISECOND );
        if ( i < 10 ) {
          sb.append( ZERO );
        }
        if ( i < 100 ) {
          sb.append( ZERO );
        }
        sb.append( i );

        return sb.toString();        
    }
    
    private String formatTimeZone(Calendar c) {
        StringBuilder sb = new StringBuilder(5);
        
        int value = (c.get(Calendar.ZONE_OFFSET) +
             c.get(Calendar.DST_OFFSET)) / 60000;

        if (value >= 0) {
          sb.append('+');
        }
        
        int num = (value / 60) * 100 + (value % 60);
        sb.append(num < 1000 ? "0" + num : num);
        
        return sb.toString();
    }

	/**
	 * Parse message formatted by ListFormatter, current version 1.5.
	 * Also backward compatible with ListFormatter version 1.3 & 1.4<br>
	 * Also work with version 1.2, but may fail for message that spans multiple lines<br>
	 * Can handle string with ending EOL or without ending EOL.
	 */
	public LogRecord parseMsg(String completeMsgData) throws ParseException
	{
		StringTokenizer strTok 	= new StringTokenizer(completeMsgData, DELIMITER_STR, true);
		String 					nextTok = strTok.nextToken();
		
		if (nextTok.equals("1.2")) { //older version(s)
			return parseMsg12(strTok);
		}
		else {
			if (nextTok.equals(DELIMITER_STR)) { //newer version(s)
				String ver = strTok.nextToken();
				if (ver.equals("1.5")) { 
					if (strTok.countTokens() < F_MIN_No_FIELD_VALUES_15) {
						APILogger
							.logIntByAPI(Severity.WARNING,
												  classLoc,
												  "[parseMsg(String completeMsgData)]",
												  "ASJ.log_api.000048",
                          "One or more message fields are missing! Expected number of fieds is {0} and message have {1}",
                          new String[] {"" + F_MIN_No_DELIMITERS_15, "" + strTok.countTokens()});
					}
					return parseMsgLatest(strTok);
				}
				else if (ver.equals("1.4")) { //backward compatible
					if (strTok.countTokens() < 29) {
						APILogger
							.logIntByAPI(Severity.WARNING,
							 					   classLoc,
													 "[parseMsg(String completeMsgData)]",
													 "ASJ.log_api.000049",
                           "One or more message fields are missing! Expected number of fieds is {0} and message have {1}",
                           new String[] {"" + 29, "" + strTok.countTokens()});
					}
							
					return parseMsg14(strTok);
				}
				else if (ver.equals("1.3"))	{ //backward compatible
					if (strTok.countTokens() < 25) {
						APILogger
							.logIntByAPI(Severity.WARNING,
												   classLoc,
													 "[parseMsg(String completeMsgData)]",
													 "ASJ.log_api.000050",
                           "One or more message fields are missing! Expected number of fieds is {0} and message have {1}",
													 new String[] {"" + 29, "" + strTok.countTokens()});
					}
					return parseMsg13(strTok);
				}
			}
		}
		
		APILogger
			.logIntByAPI(Severity.WARNING,
							     classLoc,
									 "[parseMsg(String completeMsgData)]",
									 "ASJ.log_api.000042",
                   "One or more messages cannot be parsed!", null);
		return null;
	}

	public LogRecord parseMsg(byte[] msgChunk) throws ParseException
	{
      switch (Version.getVersionIndex(Version.getVersionOfFirstRecord())) {
        case  Version.VER_CODE_1_5: {
       	  try {
            return parseMsg15(msgChunk);
          } catch (Exception ex){
       	      //$JL-EXC$ 
          }
          break;
	    }
        case  Version.VER_CODE_2_0: {
       	  try {
            return parseMsg20(msgChunk);
          } catch (Exception ex){
       	    //$JL-EXC$ 
          }
          break;
  	    }
      }
      return null;
	}

	public LogRecord parseMsg(IMessageBuilder message) throws ParseException 
	{
      switch (Version.getVersionIndex(Version.getVersionOfFirstRecord())) {
        case  Version.VER_CODE_1_5: {
       	  try {
            return parseMsg15(message);
          } catch (Exception ex){
       	      //$JL-EXC$ 
          }
          break;
	    }
        case  Version.VER_CODE_2_0: {
       	  try {
            return parseMsg20(message);
          } catch (Exception ex){
       	    //$JL-EXC$ 
          }
          break;
  	    }
      }
      return null;
	}
	
	public LogRecord parseMsg15(byte[] msgChunk) throws ParseException
	{
		
		// Guardian...
		if (msgChunk == null || msgChunk.length == 0) return null;
		
		int 			delimiterIndex 	= -1;
		int				relativesCnt 		= 0;
		int				relativesIndex	= 0;
		int				argsCnt 				= 0;
		int				argsIndex 			= 0;
		int 			severity 				= Severity.ALL; //~unknown
		int 			level 					= 0;
		int 			indent 					= 0;
		int 			msgType 				= MsgType.PLAIN;
		
		Date 			time = null;
			
		String 		recordId = null;
		String 		source = null;
		String 		loc = null;
		String 		groupId = null;
		String 		application = null;
		String 		user = null;
		String 		session = null;
		String 		transaction = null;
		String 		dsrComponent = null;
		String 		dsrUser = null;
		String 		dsrTransaction = null;
		String 		thr = null;
		String 		msgCode 	= null;
		String 		msgAlias 	= null;
		String 		resourceBundleName = null;
		String 		msg = null;
		String[] 	args = null;
		String[] 	relativesAsStrings = null;
    
    boolean 	isField = false;
		int 			length = 0;
		int 			fieldStartPos = 0; 
		int 			fieldEndPos = 0;
    
		try {
			
			for(int i = 0; i < msgChunk.length; i++) {
					
				if (msgChunk[i] == DELIMITER_CHAR) {
					if (i > 1 && msgChunk[i - 1] == ESCAPE_CHAR) {
						length++;
						continue; 
					} 
					if (fieldStartPos < 1) {
						fieldStartPos = i + 1;
						delimiterIndex++;
						continue;
					} 
					else {
						i--;
						fieldEndPos = i;
						isField = true;
					}
				}
				else {
					length++;
				}
				
				if (!isField) continue;
				
				String nextToken = new String(msgChunk, fieldStartPos, length);
				
				switch (delimiterIndex) {
						case F_VERSION_15 :
							break; //do nothing
						case F_GUID_15 : 
							recordId = nextToken;
							break;
						case F_DATE_TIME_15 :
							time = new Date(Long.parseLong(nextToken));
							break;
						case F_SOURCE_NAME_15 :
							source = revertEscape(nextToken);
							break;
						case F_APPLICATION_NAME_15 : 
							application = revertEscape(nextToken);
							//though not used currently
							break;
						case F_LOCATION_NAME_15 :
							loc = revertEscape(nextToken);
							break;
						case F_USER_15 : 
							user = revertEscape(nextToken);
							//though not used currently
							break;
						case F_SESSION_15 :
							session = revertEscape(nextToken);
							//though not used currently
							break;
						case F_TRANSACTION_15 : 
							transaction = revertEscape(nextToken);
							//though not used currently
							break;
						case F_DSR_COMPONENT_15 : 
							dsrComponent = revertEscape(nextToken);
							break;
						case F_DSR_USER_15 : 
							dsrUser = revertEscape(nextToken);
							break;
						case F_DSR_TRANSACTION_15 : 
							dsrTransaction = revertEscape(nextToken);
							break;
						case F_THREAD_NAME_15 : 
							thr = revertEscape(nextToken);
							break;
						case F_GROUP_ID_15 : 
							groupId = nextToken;
							break;
						case F_GROUP_LEVEL_15 :
							level = Integer.parseInt(nextToken);
							break;
						case F_GROUP_INDENT_15 : 
							indent = Integer.parseInt(nextToken);
							break;
						case F_SEVERITY_15 :
							severity = Severity.parse(nextToken);
							break;
						case F_RELATIVES_CNT_15 : 
							if (nextToken.length() != 0) {
								relativesCnt = Integer.parseInt(nextToken);
							}
							else {
								// Skip RELATIVES
								delimiterIndex++;
							}
							break;
						case F_RELATIVES_15:
							if (relativesCnt > 0) {
								if (relativesAsStrings == null) {
									relativesAsStrings = new String[relativesCnt];
								}
								relativesAsStrings[relativesIndex] = new String(msgChunk, fieldStartPos, (fieldEndPos - fieldStartPos) + 1); 
								relativesIndex++;
								if (relativesIndex < relativesCnt) {
									delimiterIndex --;
								}
							}
							break;
						case F_MSG_TYPE_15 : 
							msgType = MsgType.parse(nextToken);
							break;
						case F_MSG_CODE_15 : 
							int startPos = 0;
							if ((startPos = nextToken.indexOf("[")) > 1) {
								msgAlias = nextToken.substring(0,startPos);
								msgCode  = nextToken.substring((startPos + 1), (nextToken.length() - 1));
							}
							else {
								msgCode = nextToken;
							}
							break;
						case F_RES_BUNDLE_15 : 
							resourceBundleName = nextToken;
							break;
						case F_MSG_CLEAR_15 : 
							msg = revertEscape(nextToken);
							break;
						case F_MSG_ARGS_CNT_15 :
							if (msgType == MsgType.PLAIN || nextToken.equals(this.EOL)) {
								//'PLAIN' message with EOL ignored (just in case)
								delimiterIndex--;
								break;
							}
							if (nextToken.length() != 0) {
								argsCnt = Integer.parseInt(nextToken);
								args = new String[argsCnt];
							}
							else {
								// Skip ARGS
								delimiterIndex++;
							}
							break;
						case F_MSG_ARGS_15 :
							args[argsIndex] = revertEscape(nextToken);
							if (argsIndex < (argsCnt - 1)) delimiterIndex--;
							argsIndex++;
							break;
			  	default:
							APILogger
								.logIntByAPI(Severity.WARNING,
													   classLoc,
														 "[parseMsgLatest(StringTokenizer _strTok)]",
														 "ASJ.log_api.000043",
                             "Field {0} cannot be parsed! Message ID : {1}",
														 new String[] {"" + delimiterIndex, recordId});
							// Stop parsing ...
							i = msgChunk.length;
							break;
					} //switch
					
					length 				= 0;
					fieldStartPos = 0;
					isField 			= false;
				
				}
			
				if (recordId != null) {
					//create LogRecord, some fields are empty/null
					return (
						new LogRecord(recordId,
													msgChunk.length,
													time,
													source,
													severity,
													loc,
													relativesAsStrings,
													groupId,
													level,
													indent,
													thr,
													msgType,
													msgCode,
													msgAlias,
													resourceBundleName,
													msg,
													args,
													application,
													user,
													session,
													transaction,
													dsrComponent,
													dsrUser,
													dsrTransaction,
													getMessageAccessor()));
				}
			}
			catch (Exception ex) {
				APILogger
					.logIntByAPI(Severity.WARNING,
										   classLoc,
											 "[parseMsgLatest(StringTokenizer _strTok)]",
                       "ASJ.log_api.000044",
                       "Field {0} cannot be parsed! Message ID : {1}",
											 new String[] {"" + delimiterIndex, recordId});
				APILogger.catchingIntByAPI(ex);
				throw new ParseException("Field " + delimiterIndex + " cannot be parsed! Record ID : " + recordId, delimiterIndex);
			}
			return null;
		}
	
	public LogRecord parseMsg15(IMessageBuilder message) throws ParseException 
	{
		//	 Guardian...
		if (message == null || message.size() <= 0) return null;
		
		int currentIndex = 0;
		String 	recordId = null;
		
		try {
			
			// GUID
			currentIndex 						= F_GUID_15;
			recordId	 							= message.getFieldString(F_GUID_15);
			// DATE TIME
			currentIndex 						= F_DATE_TIME_15;
			Date		time 		 				= new Date(Long.parseLong(message.getFieldString(F_DATE_TIME_15)));
			// SOURCE NAME
			currentIndex 						= F_SOURCE_NAME_15;
			String 	source 					= revertEscape(message.getFieldString(F_SOURCE_NAME_15));
			// APPLICATION NAME
			currentIndex 						= F_APPLICATION_NAME_15;
			String 	application 		= revertEscape(message.getFieldString(F_APPLICATION_NAME_15));
			// LOCATION NAME
			currentIndex 						= F_LOCATION_NAME_15;
			String 	loc 						= revertEscape(message.getFieldString(F_LOCATION_NAME_15));
			// USER
			currentIndex 						= F_USER_15;
			String 	user 						= revertEscape(message.getFieldString(F_USER_15));
			// SESSION
			currentIndex 						= F_SESSION_15;
			String 	session 				= revertEscape(message.getFieldString(F_SESSION_15));
			// TRANSACTION
			currentIndex 						= F_TRANSACTION_15;
			String 	transaction 		= revertEscape(message.getFieldString(F_TRANSACTION_15));
			// DSR COMPONENT
			currentIndex 						= F_DSR_COMPONENT_15;
			String 	dsrComponent 		= revertEscape(message.getFieldString(F_DSR_COMPONENT_15));
			// DSR USER
			currentIndex 						= F_DSR_USER_15;
			String 	dsrUser 				= revertEscape(message.getFieldString(F_DSR_USER_15));
			// DSR TRANSACTION
			currentIndex 						= F_DSR_TRANSACTION_15;
			String 	dsrTransaction 	= revertEscape(message.getFieldString(F_DSR_TRANSACTION_15));
			// THREAD NAME
			currentIndex 						= F_THREAD_NAME_15;
			String 	thr 						= revertEscape(message.getFieldString(F_THREAD_NAME_15));
			// GROUP ID
			currentIndex 						= F_GROUP_ID_15;
			String 	groupId 				= message.getFieldString(F_GROUP_ID_15);	
			// GROUP LEVEL
			currentIndex 						= F_GROUP_LEVEL_15;
			int 		level 					= message.getFieldInt(F_GROUP_LEVEL_15);	
			// GROUP INDENT
			currentIndex 						= F_GROUP_INDENT_15;
			int			indent 					= message.getFieldInt(F_GROUP_INDENT_15);	
			// SEVERITY
			currentIndex 						= F_SEVERITY_15;
			int			severity 				= Severity.parse(message.getFieldString(F_SEVERITY_15));
			
			// RELATIVES COUNTER
			currentIndex 						= F_RELATIVES_CNT_15;
			int			relativesCnt		= message.getFieldInt(F_RELATIVES_CNT_15);	
			// RELATIVES
			currentIndex 						= F_RELATIVES_15;
			String []	relativesAsStrings = null;
			if (relativesCnt > 0) {
				relativesAsStrings 	= new String[relativesCnt];
				int i = 0;
				for (i = 0; i < relativesCnt; i++ ) {
					relativesAsStrings[i] = message.getFieldString(F_RELATIVES_15 + i); 
				}
				if (relativesCnt <= 1)  {
					relativesCnt = 0;
				}
				else {
					relativesCnt --;
				}
			}
			else {
				relativesCnt = -1;
			}
			// MSG TYPE
			currentIndex 						= F_MSG_TYPE_15;
			int	msgType 						= MsgType.parse(message.getFieldString(F_MSG_TYPE_15 + relativesCnt));
			// MSG_CODE
			currentIndex 						= F_MSG_CODE_15;
			int 		startPos 				= 0;
			String	msgCode					= message.getFieldString(F_MSG_CODE_15 + relativesCnt);	
			String	msgAlias				=	null;
			if ((startPos = msgCode.indexOf("[")) > 1) {
				msgAlias = msgCode.substring(0,startPos);
				msgCode  = msgCode.substring((startPos + 1), (msgCode.length() - 1));
			}
			// RES_BUNDLE
			currentIndex 								= F_RES_BUNDLE_15;
			String	resourceBundleName 	= message.getFieldString(F_RES_BUNDLE_15 + relativesCnt);
			// MSG_CLEAR
			currentIndex 								= F_MSG_CLEAR_15;
			String	msg 								= revertEscape(message.getFieldString(F_MSG_CLEAR_15 + relativesCnt));
			// MSG_ARGS_COUNTER
			currentIndex 								= F_MSG_ARGS_CNT_15;
			int	argsCnt 								= 0;
			if (msgType == MsgType.PLAIN) {
				//'PLAIN' message with EOL ignored (just in case)
				argsCnt = 0;
			}
			else {
				argsCnt = message.getFieldInt(F_MSG_ARGS_CNT_15 + relativesCnt);	
			}
			// MSG_ARGS
			currentIndex 								= F_MSG_ARGS_15;
			String[] args 							= null;
			if (argsCnt > 0) {
				args = new String[argsCnt];
				for (int i = 0; i < argsCnt; i++ ) {
					args[i] = revertEscape(message.getFieldString(F_MSG_ARGS_15 + relativesCnt + i)); 
				}
			}
						
			if (recordId != null) {
				//create LogRecord, some fields are empty/null
				return (
					new LogRecord(recordId,
												message.size(),
												time,
												source,
												severity,
												loc,
												relativesAsStrings,
												groupId,
												level,
												indent,
												thr,
												msgType,
												msgCode,
												msgAlias,
												resourceBundleName,
												msg,
												args,
												application,
												user,
												session,
												transaction,
												dsrComponent,
												dsrUser,
												dsrTransaction,
												getMessageAccessor()));
			}
		}
		catch (Exception ex) {
				APILogger
					.logIntByAPI(Severity.WARNING,
										   classLoc,
											 "[parseMsgLatest(StringTokenizer _strTok)]",
                       "ASJ.log_api.000045",
                       "Field {0} cannot be parsed! Message ID : {1}",
											 new String[] {"" + currentIndex, recordId});
				APILogger.catchingIntByAPI(ex);
				throw new ParseException("Field " + currentIndex + " cannot be parsed! Record ID : " + recordId, currentIndex);
		}
		return null;
	}
	

	
	public LogRecord parseMsg20(byte[] msgChunk) throws ParseException
	{
		// Guardian...
		if (msgChunk == null || msgChunk.length == 0) return null;
		
		int 			delimiterIndex 	= -1;
		int				argsCnt 				= 0;
		int				argsIndex 			= 0;
		int 			severity 				= Severity.ALL; //~unknown
		int 			msgType 				= MsgType.PLAIN;
		
		Date 			time = null;
        String timeZone = null;
			
		String 		recordId = null;
        String      corrID = null;
		String 		source = null;
		String 		loc = null;
		String 		application = null;
		String 		user = null;
		String 		session = null;
		String 		transaction = null;
		String 		dsrRootContextId = null;
        String 		dsrTransaction = null;
        String      dsrConnection = null;        
        int        dsrCounter = 0;
		String 		thr = null;
		String 		msgCode 	= null;
		String 		msgAlias 	= null;
		String 		resourceBundleName = null;
		String 		msg = null;
		String[] 	args = null;
		String[] 	relativesAsStrings = null;
        String   csnComponent = null;
        String   dcName       = null;
    
    boolean 	isField = false;
		int 			length = 0;
		int 			fieldStartPos = 0; 
		int 			fieldEndPos = 0;
    
		try {
			
			for(int i = 0; i < msgChunk.length; i++) {
					
				if (msgChunk[i] == DELIMITER_CHAR) {
					if (i > 1 && msgChunk[i - 1] == ESCAPE_CHAR) {
						length++;
						continue; 
					} 
					if (fieldStartPos < 1) {
						fieldStartPos = i + 1;
						delimiterIndex++;
						continue;
					} 
					else {
						i--;
						fieldEndPos = i;
						isField = true;
					}
				}
				else {
					length++;
				}
				
				if (!isField) continue;
				
				String nextToken = new String(msgChunk, fieldStartPos, length);
				
				switch (delimiterIndex) {
						case F_VERSION :
							break; //do nothing
						case F_GUID : 
							recordId = nextToken;
							break;
                        case F_CORRELATION_ID:
                            corrID = nextToken;
                            break;
						case F_DATE_TIME :
							time = dateTimeFormatter.parse(nextToken);
							break;
                        case F_TIME_ZONE :
                            timeZone = nextToken;
                            break;
						case F_APPLICATION_NAME : 
							application = revertEscape(nextToken);
							//though not used currently
							break;
						case F_LOCATION_NAME :
							loc = revertEscape(nextToken);
							break;
						case F_USER : 
							user = revertEscape(nextToken);
							//though not used currently
							break;
						case F_SESSION :
							session = revertEscape(nextToken);
							//though not used currently
							break;
						case F_TRANSACTION : 
							transaction = revertEscape(nextToken);
							//though not used currently
							break;
						case F_DSR_ROOT_CONTEXT_ID : 
							dsrRootContextId = revertEscape(nextToken);
							break;
						case F_DSR_TRANSACTION : 
							dsrTransaction = revertEscape(nextToken);
							break;
                        case F_DSR_CONNECTION : 
                            dsrConnection = revertEscape(nextToken);
                            break;
                        case F_DSR_COUNTER : 
                            dsrCounter = Integer.parseInt(nextToken);
                            break;                            
						case F_THREAD_NAME : 
							thr = revertEscape(nextToken);
							break;
						case F_SEVERITY :
							severity = Severity.parse(nextToken);
							break;
                        case F_MSG_CODE :
                            msgCode = nextToken;
                            break;
                        case F_SOURCE_NAME :
                            source = nextToken;
                            break;
                        case F_CSN_COMPONENT :
                            csnComponent = nextToken;
                            break;
                        case F_DC_NAME :
                            dcName = nextToken;
                            break;                            
//						case F_RELATIVES_CNT : 
//							if (nextToken.length() != 0) {
//								relativesCnt = Integer.parseInt(nextToken);
//							}
//							else {
//								// Skip RELATIVES
//								delimiterIndex++;
//							}
//							break;
//						case F_RELATIVES:
//							if (relativesCnt > 0) {
//								if (relativesAsStrings == null) {
//									relativesAsStrings = new String[relativesCnt];
//								}
//								relativesAsStrings[relativesIndex] = new String(msgChunk, fieldStartPos, (fieldEndPos - fieldStartPos) + 1); 
//								relativesIndex++;
//								if (relativesIndex < relativesCnt) {
//									delimiterIndex --;
//								}
//							}
//							break;
//						case F_MSG_TYPE : 
//							msgType = MsgType.parse(nextToken);
//							break;
//						case F_MSG_CODE : 
//							int startPos = 0;
//							if ((startPos = nextToken.indexOf("[")) > 1) {
//								msgAlias = nextToken.substring(0,startPos);
//								msgCode  = nextToken.substring((startPos + 1), (nextToken.length() - 1));
//							}
//							else {
//								msgCode = nextToken;
//							}
//							break;
                        case F_RES_BUNDLE : 
							resourceBundleName = nextToken;
							break;
                        case F_MSG_CLEAR : 
							msg = revertEscape(nextToken);
							break;
						case F_MSG_ARGS_CNT :
							if (msgType == MsgType.PLAIN || nextToken.equals(this.EOL)) {
								//'PLAIN' message with EOL ignored (just in case)
								delimiterIndex--;
								break;
							}
							if (nextToken.length() != 0) {
								argsCnt = Integer.parseInt(nextToken);
								args = new String[argsCnt];
							}
							else {
								// Skip ARGS
								delimiterIndex++;
							}
							break;
						case F_MSG_ARGS :
							args[argsIndex] = revertEscape(nextToken);
							if (argsIndex < (argsCnt - 1)) delimiterIndex--;
							argsIndex++;
							break;
			  	default:
							APILogger
								.logIntByAPI(Severity.WARNING,
													   classLoc,
														 "[parseMsgLatest(StringTokenizer _strTok)]",
                             "ASJ.log_api.000046",
                             "Field {0} cannot be parsed! Message ID : {1}",
														 new String[] {"" + delimiterIndex, recordId});
							// Stop parsing ...
							i = msgChunk.length;
							break;
					} //switch
					
					length 				= 0;
					fieldStartPos = 0;
					isField 			= false;
				
				}
			
				if (recordId != null) {
					//create LogRecord, some fields are empty/null
					return (
						new LogRecord(recordId,
                                      corrID,
                                      msgChunk.length,
                                      time,
                                      timeZone,
                                      source,
                                      severity,
                                      loc,
                                      relativesAsStrings,
                                      thr,
                                      msgType,
                                      msgCode,
                                      msgAlias,
                                      resourceBundleName,
                                      msg,
                                      args,
                                      application,
                                      user,
                                      session,
                                      transaction,
                                      dsrTransaction,                                      
                                      dsrRootContextId,
                                      dsrConnection,
                                      dsrCounter,
                                      getMessageAccessor(),
                                      csnComponent,
                                      dcName));
				}
			}
			catch (Exception ex) {
				APILogger
					.logIntByAPI(Severity.WARNING,
										   classLoc,
											 "[parseMsgLatest(StringTokenizer _strTok)]",
                       "ASJ.log_api.000047",
                       "Field {0} cannot be parsed! Message ID : {1}",
											 new String[] {"" + delimiterIndex, recordId});
				APILogger.catchingIntByAPI(ex);
				throw new ParseException("Field " + delimiterIndex + " cannot be parsed! Record ID : " + recordId, delimiterIndex);
			}
			return null;
		}
	
	public LogRecord parseMsg20(IMessageBuilder message) throws ParseException 
	{
		//	 Guardian...
		if (message == null || message.size() <= 0) return null;
		
		int currentIndex = 0;
		String 	recordID = null;
		
		try {
			
            currentIndex = F_DATE_TIME;
            Date time = dateTimeFormatter.parse(message.getFieldString(F_DATE_TIME));
            currentIndex = F_TIME_ZONE;
            String timeZone = message.getFieldString(F_TIME_ZONE);
            currentIndex = F_SEVERITY;
            int severity = Severity.parse(message.getFieldString(F_SEVERITY));
            currentIndex = F_SOURCE_NAME;
            String  source = revertEscape(message.getFieldString(F_SOURCE_NAME));
            currentIndex = F_MSG_CODE;
            String  msgCode = message.getFieldString(F_MSG_CODE).trim();
            currentIndex = F_CSN_COMPONENT;
            String  csnComponent = message.getFieldString(F_CSN_COMPONENT);
            currentIndex = F_DC_NAME;
            String  dcName = message.getFieldString(F_DC_NAME);
            currentIndex = F_GUID;
            recordID = message.getFieldString(F_GUID);
            currentIndex = F_CORRELATION_ID;
            String correlationID = message.getFieldString(F_CORRELATION_ID);
            currentIndex = F_APPLICATION_NAME;
            String  application = revertEscape(message.getFieldString(F_APPLICATION_NAME));
            currentIndex = F_LOCATION_NAME;
            String  loc = revertEscape(message.getFieldString(F_LOCATION_NAME));
            currentIndex = F_USER;
            String  user = revertEscape(message.getFieldString(F_USER));
            currentIndex = F_SESSION;
            String  session = revertEscape(message.getFieldString(F_SESSION));
            currentIndex = F_TRANSACTION;
            String  transaction = revertEscape(message.getFieldString(F_TRANSACTION));
            currentIndex = F_DSR_ROOT_CONTEXT_ID;
            String  dsrRootContextID = revertEscape(message.getFieldString(F_DSR_ROOT_CONTEXT_ID));
            currentIndex = F_DSR_TRANSACTION;
            String  dsrTransaction  = revertEscape(message.getFieldString(F_DSR_TRANSACTION));
            currentIndex = F_DSR_CONNECTION;
            String  dsrConnection  = revertEscape(message.getFieldString(F_DSR_CONNECTION));
            currentIndex = F_DSR_COUNTER;
            int  dsrCounter  =  message.getFieldInt(F_DSR_COUNTER);
            currentIndex = F_THREAD_NAME;
            String  thr  = revertEscape(message.getFieldString(F_THREAD_NAME));
            currentIndex = F_MSG_TYPE;
            int msgType = MsgType.parse(message.getFieldString(F_MSG_TYPE));
            currentIndex = F_RES_BUNDLE;
            String  resourceBundleName  = message.getFieldString(F_RES_BUNDLE);
            currentIndex = F_MSG_CLEAR;
            String  msg  = revertEscape(removeFirstEOL(message.getFieldString(F_MSG_CLEAR)));
            currentIndex = F_MSG_ARGS_CNT;
            int argsCnt = 0;
            if (msgType == MsgType.PLAIN) {
                //'PLAIN' message with EOL ignored (just in case)
                argsCnt = 0;
            }
            else {
                argsCnt = message.getFieldInt(F_MSG_ARGS_CNT);   
            }            
            currentIndex = F_MSG_ARGS;
            Object[] args = null;
            if (argsCnt > 0) {
                args = new String[argsCnt];
                for (int i = 0; i < argsCnt; i++ ) {
                    args[i] = revertEscape(message.getFieldString(F_MSG_ARGS + i)); 
                }
            }            
            
			if (recordID != null) {
				//create LogRecord, some fields are empty/null
				return (
					new LogRecord(recordID,
                                  correlationID,
                                  message.size(),
                                  time,
                                  timeZone,
                                  source,
                                  severity,
                                  loc,
                                  null,//relativesAsStrings,
                                  thr,
                                  msgType,
                                  msgCode,
                                  null, // message Ailas
                                  resourceBundleName,
                                  msg,
                                  args,
                                  application,
                                  user,
                                  session,
                                  transaction,
                                  dsrTransaction,
                                  dsrRootContextID,
                                  dsrConnection,
                                  dsrCounter,
                                  getMessageAccessor(),
                                  csnComponent,
                                  dcName));
			}
		}
		catch (Exception ex) {
				APILogger
					.logIntByAPI(Severity.WARNING,
										   classLoc,
											 "[parseMsgLatest(StringTokenizer _strTok)]",
                       "ASJ.log_api.000055",
                       "Field {0} cannot be parsed! Message ID : {1}",
											 new String[] {"" + currentIndex, recordID});
				APILogger.catchingIntByAPI(ex);
				throw new ParseException("Field " + currentIndex + " cannot be parsed! Record ID : " + recordID, currentIndex);
		}
		return null;
	}
	

	//==== < public ==================================== protected > ====
	
  /**
   * @param s - what to escape
   * @param sb - where to concatenate the escaped CharSequence s
   */
  protected void escapeAndConcat(CharSequence s, StringBuilder sb)
  {
    if (s == null) return;
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      switch (c) {
        case DELIMITER_CHAR :
          sb.append(ESCAPED_DELIMITER);
          break;
        case BACKSPACE: {
          // skip this char
          break;
        }
        case ESCAPE_CHAR :
          sb.append( "\\\\");
          break;
        default:
          sb.append(c);
          break;
      }
    }
  }
  
  //==== < protected =================================== default > ====
  //==== < default ===================================== private > ====

  private String getWorkingVersion(){
	  return DEAFULT_COMPATIBILE_VERSION;
  }

  private LogRecord parseMsgLatest(StringTokenizer _strTok) 
	{
      
		int 			delimiterIndex = 0;
		int 			severity = Severity.ALL; //~unknown
		int 			msgType = MsgType.PLAIN;
		
		Date 	 time = null;
        String   timeZone = null;
				
		String 		msgId = null;
        String      corrID = null;
		String 		source = null;
		String 		loc = null;
		String 		groupId = null;
		String 		application = null;
		String 		user = null;
		String 		session = null;
		String 		transaction = null;
		String 		dsrRootContextId = null;
		String 		dsrTransaction = null;
        String      dsrConnection = null;
        int        dsrCounter = 0;
		String 		thr = null;
		String 		msgCode = null;
		String    msgAlias = null;
		String 		resourceBundleName = null;
		String 		msg = null;
		String[] 	args = null;
		String[] 	relativesAsStrings = null;
        String     csnComponent = null;
        String     dcName       = null;
    	
		LFStringTokenizer stringTokenizer = new LFStringTokenizer(_strTok);
		
		try {
			
			while (stringTokenizer.hasMoreTokens()) {
				
				String nextToken = stringTokenizer.getNextTokenResolved();

				if (nextToken.equals(DELIMITER_STR)) {
					delimiterIndex++;
					continue;
				}

				switch (delimiterIndex) {
					case F_VERSION :
						break; //do nothing
					case F_GUID : 
						msgId = nextToken;
						break;
                    case F_CORRELATION_ID:
                        corrID = nextToken;
                        break;                        
					case F_DATE_TIME :
						time = new Date(Long.parseLong(nextToken));
						break;
                    case F_TIME_ZONE :
                        timeZone = nextToken;
                        break;
					case F_APPLICATION_NAME : 
						application = revertEscape(nextToken);
						//though not used currently
						break;
					case F_LOCATION_NAME :
						loc = revertEscape(nextToken);
						break;
					case F_USER : 
						user = revertEscape(nextToken);
						//though not used currently
						break;
					case F_SESSION :
						session = revertEscape(nextToken);
						//though not used currently
						break;
					case F_TRANSACTION : 
						transaction = revertEscape(nextToken);
						//though not used currently
						break;
					case F_DSR_ROOT_CONTEXT_ID : 
						dsrRootContextId = revertEscape(nextToken);
						break;
					case F_DSR_TRANSACTION : 
						dsrTransaction = revertEscape(nextToken);
						break;
                    case F_DSR_CONNECTION : 
                        dsrConnection = revertEscape(nextToken);
                        break;                     
                    case F_DSR_COUNTER : 
                        dsrCounter = Integer.parseInt(nextToken);
                        break;                        
					case F_THREAD_NAME : 
						thr = revertEscape(nextToken);
						break;
					case F_SEVERITY :
						severity = Severity.parse(nextToken);
						break;
                    case F_CSN_COMPONENT :
                        csnComponent = nextToken;
                        break;
                    case F_DC_NAME :
                        dcName = nextToken;
                        break;                                                    
//					case F_RELATIVES:  
//						relativesAsStrings = populateRelativesAndMessageArgs(stringTokenizer, nextToken);
//						delimiterIndex++;
//        		if (stringTokenizer.isNextDelimiterConsumed()) delimiterIndex++;
//					break;
					case F_MSG_TYPE : 
						msgType = MsgType.parse(nextToken);
						break;
					case F_MSG_CODE : 
						int startPos = 0;
						if ((startPos = nextToken.indexOf("[")) > 1) {
							msgAlias = nextToken.substring(0,startPos);
							msgCode  = nextToken.substring((startPos + 1), (nextToken.length() - 1));
						}
						else {
							msgCode = nextToken;
						}
						break;
					case F_RES_BUNDLE : 
						resourceBundleName = nextToken;
						break;
					case F_MSG_CLEAR : 
						msg = revertEscape(nextToken);
						break;
					case F_MSG_ARGS_CNT : 
					case F_MSG_ARGS :         	
						if (msgType == MsgType.PLAIN || nextToken.equals(this.EOL)) {
							//'PLAIN' message with EOL ignored (just in case)
							break;
						}
						args = populateRelativesAndMessageArgs(stringTokenizer, nextToken);
        		if (stringTokenizer.isNextDelimiterConsumed()) delimiterIndex++;
						break;
          default:
						APILogger
							.logIntByAPI(Severity.WARNING,
												   classLoc,
													 "[parseMsgLatest(StringTokenizer _strTok)]",
		                       "ASJ.log_api.000056",
		                       "Field {0} cannot be parsed! Message ID : {1}",
													 new String[] {"" + delimiterIndex});
				} //switch
				
				if (stringTokenizer.isNextDelimiterConsumed()) delimiterIndex++;  //while has more token
			}
			
			//create LogRecord, some fields are empty/null
			return (
              new LogRecord(msgId,
                            corrID,
                            0,
                            time,
                            timeZone,
                            source,
                            severity,
                            loc,
                            relativesAsStrings,
                            thr,
                            msgType,
                            msgCode,
                            msgAlias,
                            resourceBundleName,
                            msg,
                            args,
                            application,
                            user,
                            session,
                            transaction,
                            dsrTransaction,                                      
                            dsrRootContextId,
                            dsrConnection,
                            dsrCounter,
                            getMessageAccessor(),
                            csnComponent,
                            dcName));            
		}
		catch (Exception ex) {
			APILogger
				.logIntByAPI(Severity.WARNING,
									   classLoc,
										 "[parseMsgLatest(StringTokenizer _strTok)]",
                     "ASJ.log_api.000057",
                     "Field {0} cannot be parsed! Message ID : {1}",
										 new String[] {"" + delimiterIndex});
			APILogger.catchingIntByAPI(ex);
			return null;
		}

	}

	private String[] populateRelativesAndMessageArgs(LFStringTokenizer strTok,
																									 String nextTok)
	{
		int numRel = Integer.parseInt(nextTok);
    String[] destination = new String[numRel];    
    
    if (!strTok.isNextDelimiterConsumed()) {
    	strTok.getNextTokenResolved();
      //eat up the next delimiter "#"
    }
    
    for (int i = 0; i < numRel; i++) {
			String temp = strTok.getNextTokenResolved();
      if(DELIMITER_STR.equals(temp)) {
      	destination[i] = "";
      }
      else {
      	destination[i] = revertEscape(temp); 
        if (!strTok.isNextDelimiterConsumed() && i != numRel - 1) {
        	strTok.getNextTokenResolved();
          //eat up the next delimiter "#"
        }
      }
    } //End of for loop
		return destination;
	}

	//==== < private ================================== deprecated > ====

	//deal with 1.3/1.4/1.5 only
	//check if '_msg' corresponds to a valid complete message, especially for multiple lines
	/**
	 * Determine if the message string reaches the valid end(delimiter) of a
	 * complete message record, according to the format defined by the formatter.
	 *Can handle string with ending EOL or without ending EOL.<br>
	 * Prerequisite (special for ListFormatter, version 1.5 & below):
	 * parameter 'msg' is a message as complete as possible, passing the tail of
	 * the message may fail (unlike XML format, passing the final line of the 
	 * closing tag is sufficient enough to check for the end of the message).
	 */
	public boolean isCompleteMessage(String msg)
	{
		if (getWorkingVersion().equals("1.2"))
			//currently, with assumption no multiple lines in older versions
			return true;
		if (msg == null)
			return false;
		/***TODO (for 1.6) ***/
		//	if (VERSION.equals("1.6")){		//1.6 or above
		//		if(msg.endsWith("#" + EOL))
		//			return true;
		//		return false;			
		//	}          
		while (!msg.endsWith(DELIMITER_STR))
		{ //use 'while':not really necessary,but just in case
			if (msg.endsWith(this.EOL))
			{
				msg = msg.substring(0, msg.length() - EOL.length());
				continue;
			}
			return false;
		}
		//check the prev char
		//if backslash: 'real' backslash or that coupled with #
		try
		{
			if (msg.substring(0, msg.length() - 1).endsWith(ESCAPE_STR))
			{
				int i;
				for (i = 0;
					(msg.substring(0, msg.length() - i - 1)).endsWith(ESCAPE_STR);
					i++)
				{ //start by trimming the ending '#'
				}
				if ((i % 2) != 0)
				{ // slash does couple with #, # is NOT a delimiter
					return false;
				}
				else
				{
					return isEnoughDelimiter(msg);
				}
			}
			else
				return isEnoughDelimiter(msg);
		}
		catch (Exception e)
		{
			// 'isEnoughDelimiter' is a quick & dirty method for version 1.3-1.5 before EOL is escaped
			//A short parsing has to be done which could give unpredictable exception WHEN
			//the format of the file content has been messed up
			return false;

		}

	}

	/*public boolean isCompleteMessage(IMessageBuilder msgByte)
	{
		if (msgByte.size() < 2) return false;
		
		switch (Version.getVersionIndex(msgByte.getFieldString(0))) {
			
			case Version.VER_CODE_1_5:
				return isCompleteMessage_1_5(msgByte);
			case Version.VER_CODE_1_4:
				break;
			case Version.VER_CODE_1_3:
				break;
			case Version.VER_CODE_1_2:
				break;
			case Version.VER_CODE_1_6:
				break;
			case Version.VER_CODE_UNKNOWN:
				break;
		}
		return false;
	}
	
	private boolean isCompleteMessage_1_5(IMessageBuilder msgByte)
	{
		if (!msgByte.getDelimiter().isComplete()) return false;

		// Check for the RELATIVES
		int relativesCnt 	= msgByte.getFieldInt(F_RELATIVES_CNT);
		if (relativesCnt > 0 && ((msgByte.getDelimiter().size() - relativesCnt) < F_MIN_No_DELIMITERS_15)) return false;
		
		// Check for the ARGS
		int	argsDelIndex = (F_MSG_ARGS_CNT - 1) + relativesCnt; // args delimiter index
		int	argsCnt 		 = msgByte.getFieldInt(argsDelIndex);
		if (argsCnt > 0 && (msgByte.getDelimiter().size() - (argsCnt + relativesCnt) < F_MIN_No_DELIMITERS_15)) return false;
			
		// Last check ...
		return msgByte.isEndOk();
	}*/

	public boolean isParsable()
	{
		return true;
	}

	//deal with 1.3/1.4/1.5 only
	//check if '_msg' started with a valid begnning, especially for cases with multiple lines
	/**
	 * Determine if the message string has a valid start of message record
	 * Prerequisite: parameter 'msg' is supposed to be a string of at least 1
	 * complete line from logfile
	 */
	public boolean isStartMessage(String msg)
	{
		if (getWorkingVersion().equals("1.2"))
			//currently, with assumption no multiple lines in older versions
			return true;
		if (msg == null)
			return false;
		String validStart = DELIMITER_STR;
		//take care: single ending# from finishing EOL (from both msg & arg)
		//         : other '#' should have '\#'
		if (!msg.startsWith(validStart))
		{
			return false;
		}

		if (msg.length() == 1)
			return false;

		//only catch (though very rare): EOL from argument and with value equals to '<VERSION>'  ==> '#<VERSION>'
		//check: number of 'real' delimiter# is small for this case, at most 10 placeholders (java.text.MessageFormat),
		//       that is, at most 9 args with 10 'real' # in this case to cause the problem
		LFStringTokenizer strTok =
			new LFStringTokenizer(new StringTokenizer(msg, DELIMITER_STR, true));

		//cut calculation work, absolutely not the valid start of '#<VERSION>'
		if (strTok.countTokens() < 26)
			//'26': backward compatible to version 1.3
			//minimal number of tokens must exist for a start line
			//either multi-lined or final # eaten up
			return false;
		//for single line scenario: always falls through here
		//take care of potential unreal '\#', '\\\#', ....
		//calculate the 'real' token + 'real' #
		int j = 0;
		for (; strTok.hasMoreTokens(); j++)
		{
			String nextTok = strTok.getNextTokenResolved();
		}
		if (j < 26) //'26': backward compatible to version 1.3
			return false;
		return true;
	}

	//A (quick & dirty) helper method to determine the 'end' of message in 'isCompleteMessage()'.
	//A short parsing is done to determine number of # delimiters that varies on number of arguments(if any)
	//Tackle particular issue: EOL at the beginning of argument (if any)
	//TODO: Once EOL is escaped (eg. version 1.6), this becomes less important
	//param 'msg': supposedly, from the beginning of the message
	private boolean isEnoughDelimiter(String msg)
	{
		LFStringTokenizer strTok =
			new LFStringTokenizer(new StringTokenizer(msg, DELIMITER_STR, true));

		//cut calculation work, absolutely not the valid start of '#<VERSION>'
		if (strTok.countTokens() < 27)
			//'27': backward compatible to version 1.3
			return false;

		//for single line scenario: always falls through here
		//take care of potential unreal '\#', '\\\#', ....
		//calculate the 'real' token + 'real' #
		strTok.getNextTokenResolved(); //#	    
		String versionRead = strTok.getNextTokenResolved();
		int numArgs = 0;
		int baseNumDelim = 0;
		//- variable length due to: relatives & arguments
		//- fixed base number of delimiters for each version varies (no relatives, no arguments)

		if (versionRead.length() > 3) 
		{
			versionRead = versionRead.substring(0, 3);	
		}
		
		if (versionRead.equals("1.3"))
		{
			baseNumDelim = 15;
		}
		else
			if (versionRead.equals("1.4"))
			{
				baseNumDelim = 19;
			}
			else
				if (versionRead.equals("1.5"))
				{
					baseNumDelim = 22;
				}
				else 
		            if (versionRead.equals("2.0"))
		            {
			            baseNumDelim = 23;
		            }

		int numDelim = 0; //started with '#' after version value  			
		while (strTok.hasMoreTokens())
		{
			String nextTok = strTok.getNextTokenResolved();

			if (nextTok.equals(DELIMITER_STR))
			{
				numDelim++;
				if ((numDelim == 10 && versionRead.equals("1.3"))
					|| (numDelim == 14 && versionRead.equals("1.4"))
					|| (numDelim == 17 && versionRead.equals("1.5")))
				{ //relatives
					nextTok = strTok.getNextTokenResolved();
					if (nextTok.equals(DELIMITER_STR))
					{ //no relatives
						numDelim++;
						continue;
					}
					else
					{ //there exists 1+ relatives, skip them
						int numRel = Integer.parseInt(nextTok);
						for (int i = 0;
							i < numRel && strTok.hasMoreTokens();
							i++)
						{
							if (!strTok.isNextDelimiterConsumed())
								strTok.getNextTokenResolved();
							//eat up the next delimiter "#"
							strTok.getNextTokenResolved();
							//eat up the relative token
						}
					}
				}

				continue;
			}
if (numDelim == (baseNumDelim))
			{ //if args exists
				numArgs = Integer.parseInt(nextTok);
			}

			if (strTok.isNextDelimiterConsumed())
				numDelim++;
		}

		//if not having fewer tokens, must include message        	
		if (numArgs > 0)
		{
			return (numDelim == (baseNumDelim + numArgs + 1)) ? true : false;
		}
		else
		{
			return (numDelim == baseNumDelim) ? true : false;
		}
	}

	//escape for '#' (the delimiter of token) is already removed 
	//additional escape for '\' & EOL(1.6) should be trimmed
	protected String revertEscape(String s)
	{
		StringBuffer buf = new StringBuffer(s);
		int len = s.length();

		for (int i = 0; i < len; ++i)
		{
			switch (buf.charAt(i))
			{
				case ESCAPE_CHAR :
					{
						buf.deleteCharAt(i);
						--len;
						//++i;   //char deleted, next char skipped
						break;
					}
			}
		}
		/***TODO (for 1.6) ***/
		//	if (VERSION.equals("1.6")){    //1.6 or above
		//		s = buf.toString();    		
		//    	for(int j=0;j<len;){	//EOL
		//    		j = s.indexOf(EOL, j);	//use String: (not supported by StringBuffer in JDK1.3)
		//	    	if(j <= 0)				//will not be 0, but just in case
		//    			break;
		//			buf.delete(j-1, j);		//blackslash deleted
		//			--len;					
		//			j+=EOL.length() - 1;	//char shifted already
		//			s = buf.toString();
		//	    }    
		//	}	    

		return buf.toString();
	}
	
	private LogRecord parseMsg14(StringTokenizer _strTok) throws ParseException
		{
			int numDelim = 0;

			String msgId = null;
			Date time = null;
			String source = null;
			int severity = Severity.ALL; //~unknown
			String loc = null;
			String groupId = null;
			int level = 0;
			int indent = 0;
			String thr = null;
			int msgType = MsgType.PLAIN;
			String msgCode = null;
			String resourceBundleName = null;
			String msg = null;
			ArrayList args = new ArrayList();
			ArrayList relatives = null;
			String app = null;
			String user = null;
			String session = null;
			String tranx = null;
			int numArgs = 0;

			LFStringTokenizer strTok = new LFStringTokenizer(_strTok);
			try
			{
				while (strTok.hasMoreTokens())
				{
					String nextTok = strTok.getNextTokenResolved();

					if (nextTok.equals(DELIMITER_STR))
					{
						numDelim++;
						if (numDelim == 14)
						{ //relatives
							nextTok = strTok.getNextTokenResolved();
							if (nextTok.equals(DELIMITER_STR))
							{ //no relatives
								numDelim++;
								continue;
							}
							else
							{ //there exists 1+ relatives
								int numRel = Integer.parseInt(nextTok);
								relatives = new ArrayList();
								for (int i = 0; i < numRel; i++)
								{
									if (!strTok.isNextDelimiterConsumed())
										strTok.getNextTokenResolved();
									//eat up the next delimiter "#"
									relatives.add(
										revertEscape(
											strTok.getNextTokenResolved()));
								}
								if (strTok.isNextDelimiterConsumed())
									numDelim++;
								continue;

							}
						} //if # for 'relatives'
						else
						{
							continue;
						}
					}

					switch (numDelim)
					{
						case 0 : //VERSION
							break; //do nothing
						case 1 : //msg GUId
							msgId = nextTok;
							break;
						case 2 : //time
							time = new Date(Long.parseLong(nextTok));
							break;
						case 3 : //sourceName
							source = revertEscape(nextTok);
							break;
						case 4 : //application
							app = revertEscape(nextTok);
							//though not used currently
							break;
						case 5 : //loc Name
							loc = revertEscape(nextTok);
							break;
						case 6 : //user
							user = revertEscape(nextTok);
							//though not used currently
							break;
						case 7 : //session
							session = revertEscape(nextTok);
							//though not used currently
							break;
						case 8 : //transaction
							tranx = revertEscape(nextTok);
							//though not used currently
							break;
						case 9 : //Thread name
							thr = revertEscape(nextTok);
							break;
						case 10 : //groupId
							groupId = nextTok;
							break;
						case 11 : //level
							level = Integer.parseInt(nextTok);
							break;
						case 12 : //indent
							indent = Integer.parseInt(nextTok);
							break;
						case 13 : //severity
							severity = Severity.parse(nextTok);
							break;
							//case 14: relatives handled separately (see beginning of method)

						case 15 : //msgType
							msgType = MsgType.parse(nextTok);
							break;
						case 16 : //msgCode
							msgCode = nextTok;
							break;
						case 17 : //RB    (watch for extra # when RB available)
							resourceBundleName = nextTok;
							break;
						case 18 : //msgClear
							msg = revertEscape(nextTok);
							break;
						case 19 : //#args
							if (nextTok.equals(this.EOL))
								//'PLAIN' message with EOL ignored (just in case)
								break;
							//message type 'PLAIN' will not arrive here
							if (msgType == MsgType.PLAIN)
								throw new ParseException(nextTok, numDelim);
							numArgs = Integer.parseInt(nextTok);
							break;
						default :
							if (numDelim > 19)
							{
								if (numArgs == 0) //something wrong
									throw new ParseException(
										revertEscape(nextTok),
										numDelim);
								else
									if (numDelim > (19 + numArgs * 2))
										throw new ParseException(
											revertEscape(nextTok),
											numDelim);
								if (!nextTok.equals(this.EOL))
									//ignoring ending EOL
									args.add(revertEscape(nextTok)); //append
							}
					} //switch
					if (strTok.isNextDelimiterConsumed())
						numDelim++;

				} //while has more token

				////optional todo: can even be more stringent to check number of # matches the argument number value
				//eg. if(numDelim < (19+numArgs*2))		
				//		throw new ParseException(.....);

				//create LogRecord, some fields are empty/null
				String[] _argsArray = null;
				if (!args.isEmpty())
				{
					_argsArray = new String[args.size()];
					args.toArray(_argsArray);
				}
				String[] relativesArr = null;
				if (relatives != null)
				{
					relativesArr = new String[relatives.size()];
					for (int i = 0; i < relatives.size(); i++)
					{
						String lcName = (String) relatives.get(i);
						if (lcName.startsWith(Category.ROOT_NAME))
							relativesArr[i] = lcName;
						else
							relativesArr[i] = lcName;
					}
				}

				return (new LogRecord(
									msgId,
									time,
									source,
									severity,
									loc,
									relativesArr,
								//can be null
									groupId,
									level,
									indent,
									thr,
									msgType,
									msgCode,
									resourceBundleName,
									msg,
									_argsArray,
									app,
									user,
									session,
									tranx,
									null,
									null,
									null,
                                    0));
					
			}
			catch (Exception e)
			{
				throw new ParseException(e.getMessage(), numDelim);
			}

		}

	
//	provide backward compatibility for version 1.3
	  private LogRecord parseMsg13(StringTokenizer _strTok) throws ParseException
	  {
		  int numDelim = 0;

		  String msgId = null;
		  //     String     time = null;
		  Date time = null;
		  String source = null;
		  int severity = Severity.ALL; //~unknown
		  String loc = null;
		  String groupId = null;
		  int level = 0;
		  int indent = 0;
		  String thr = null;
		  int msgType = MsgType.PLAIN;
		  String msgCode = null;
		  String resourceBundleName = null;
		  String msg = null;
		  ArrayList args = new ArrayList();
		  ArrayList relatives = null;
		  int numArgs = 0;

		  LFStringTokenizer strTok = new LFStringTokenizer(_strTok);
		  try
		  {
			  while (strTok.hasMoreTokens())
			  {
				  String nextTok = strTok.getNextTokenResolved();

				  if (nextTok.equals(DELIMITER_STR))
				  {
					  numDelim++;
					  if (numDelim == 10)
					  { //relatives
						  nextTok = strTok.getNextTokenResolved();
						  if (nextTok.equals(DELIMITER_STR))
						  { //no relatives
							  numDelim++;
							  continue;
						  }
						  else
						  { //there exists 1+ relatives
							  int numRel = Integer.parseInt(nextTok);
							  relatives = new ArrayList();
							  for (int i = 0; i < numRel; i++)
							  {
								  if (!strTok.isNextDelimiterConsumed())
									  strTok.getNextTokenResolved();
								  //eat up the next delimiter "#"
								  relatives.add(
									  revertEscape(
										  strTok.getNextTokenResolved()));
							  }
							  if (strTok.isNextDelimiterConsumed())
								  numDelim++;
							  continue;
						  }
					  } //if # for 'relatives'
					  else
					  {
						  continue;
					  }
				  }

				  switch (numDelim)
				  {
					  case 0 : //VERSION
						  break; //do nothing
					  case 1 : //msg GUId
						  msgId = nextTok;
						  break;
					  case 2 : //time
						  time = new Date(Long.parseLong(nextTok));
						  break;
					  case 3 : //sourceName
						  source = revertEscape(nextTok);
						  break;
					  case 4 : //loc Name
						  loc = revertEscape(nextTok);
						  break;
					  case 5 : //Thread name
						  thr = revertEscape(nextTok);
						  break;
					  case 6 : //groupId
						  groupId = nextTok;
						  break;
					  case 7 : //level
						  level = Integer.parseInt(nextTok);
						  break;
					  case 8 : //indent
						  indent = Integer.parseInt(nextTok);
						  break;
					  case 9 : //severity
						  severity = Severity.parse(nextTok);
						  break;
						  //case 10: relatives handled separately (see beginning of method)

					  case 11 : //msgType
						  msgType = MsgType.parse(nextTok);
						  break;
					  case 12 : //msgCode
						  msgCode = nextTok;
						  break;
					  case 13 : //RB    (watch for extra # when RB available)
						  resourceBundleName = nextTok;
						  break;
					  case 14 : //msgClear
						  msg = revertEscape(nextTok);
						  break;
					  case 15 : //#args
						  if (nextTok.equals(this.EOL))
							  //'PLAIN' message with EOL ignored (just in case)
							  break;
						  //message type 'PLAIN' will not arrive here
						  if (msgType == MsgType.PLAIN)
							  throw new ParseException(nextTok, numDelim);
						  numArgs = Integer.parseInt(nextTok);
						  break;
					  default :
						  if (numDelim > 15)
						  {
							  if (numArgs == 0) //something wrong
								  throw new ParseException(
									  revertEscape(nextTok),
									  numDelim);
							  else
								  if (numDelim > (15 + numArgs * 2))
									  throw new ParseException(
										  revertEscape(nextTok),
										  numDelim);
							  if (!nextTok.equals(this.EOL))
								  args.add(revertEscape(nextTok)); //append
						  }
				  } //switch
				  if (strTok.isNextDelimiterConsumed())
					  numDelim++;

			  } //while has more token

			  ////optional todo: can even be more stringent to check number of # matches the argument number value
			  //eg. if(numDelim < (15+numArgs*2))		
			  //		throw new ParseException(.....);     

			  //create LogRecord, some fields are empty/null
			  String[] _argsArray = null;
			  if (!args.isEmpty())
			  {
				  _argsArray = new String[args.size()];
				  args.toArray(_argsArray);
			  }
			  String[] relativesArr = null;
			  if (relatives != null)
			  {
				  relativesArr = new String[relatives.size()];
				  for (int i = 0; i < relatives.size(); i++)
				  {
					  String lcName = (String) relatives.get(i);
					  if (lcName.startsWith(Category.ROOT_NAME))
						  relativesArr[i] = lcName;
					  else
						  relativesArr[i] = lcName;
				  }
			  }

			return (new LogRecord(
										msgId,
										time,
										source,
										severity,
										loc,
										relativesArr,
									//can be null
										groupId,
										level,
										indent,
										thr,
										msgType,
										msgCode,
										resourceBundleName,
										msg,
										_argsArray,
										null,
										null,
										null,
										null,
										null,
										null,
										null,
                                        0));
		  }
		  catch (Exception e)
		  {
			  throw new ParseException(e.getMessage(), numDelim);
		  }
	  }
	
	
	private LogRecord parseMsg12(StringTokenizer _strTok) throws ParseException
		{
			int numDelim = 0;

			String msgId = null;
			Date time = null;
			String source = null;
			int severity = Severity.ALL; //~unknown
			String loc = null;
			String groupId = null;
			int level = 0;
			int indent = 0;
			String thr = null;
			int msgType = MsgType.PLAIN;
			String msgCode = null;
			String resourceBundleName = null;
			String msg = null;
			ArrayList args = new ArrayList();
		
			LFStringTokenizer strTok = new LFStringTokenizer(_strTok);
			
			while (strTok.hasMoreTokens()) {
				
				String nextTok = strTok.getNextTokenResolved();

				if (nextTok.equals(DELIMITER_STR)) {
					numDelim++;
					continue;
				}

				switch (numDelim) {
					case 1 : //msg GUId
						msgId = nextTok;
						break;
					case 2 : //time, converting to LONG, will have LOSS of precision of the missing MILLIsec from string
						try
						{
							time =
								new Date(
									(new SimpleDateFormat(this
										.DATE_STRING_PATTERN))
										.parse(nextTok)
										.getTime());
						}
						catch (Exception e)
						{
							throw new ParseException(
								"invalid timestamp: " + e.getMessage(),
								0);
						}
						break;
					case 3 : //sourceName
						source = revertEscape(nextTok);
						break;
					case 4 : //severity
						severity = Severity.parse(nextTok);
						break;
					case 5 : //loc Name
						loc = revertEscape(nextTok);
						break;
					case 6 : //groupId
						groupId = nextTok;
						break;
					case 7 : //level
						level = Integer.parseInt(nextTok);
						break;
					case 8 : //indent
						indent = Integer.parseInt(nextTok);
						break;
					case 9 : //Thread name
						thr = revertEscape(nextTok);
						break;
					case 10 : //msgType
						msgType = MsgType.parse(nextTok);
						break;
					case 11 : //msgCode
						msgCode = nextTok;
						break;
					case 12 : //RB    (watch for extra # when RB available)
						resourceBundleName = nextTok;
						break;
					case 13 : //msgClear
						msg = revertEscape(nextTok);
						break;
					case 14 : //#args
						break;
					default :
						if (numDelim > 14)
						{
							if (!nextTok.equals(this.EOL)) //ignoring ending EOL
								args.add(revertEscape(nextTok)); //append
						}

				} //switch
			} //while has more token

			//create LogRecord, some fields are empty/null
			String[] _argsArray = null;
			if (!args.isEmpty())
			{
				_argsArray = new String[args.size()];
				args.toArray(_argsArray);
			}
			
			return (new LogRecord(
							msgId,
							time,
							source,
							severity,
							loc,
							null,
						//can be null
							groupId,
							level,
							indent,
							thr,
							msgType,
							msgCode,
							resourceBundleName,
							msg,
							_argsArray,
							null,
							null,
							null,
							null,
							null,
							null,
							null,
                            0));
		}
		
	//inner class to tokenize string with potential escaped backslash
	private class LFStringTokenizer
	{
		//'java.util.StringTokenizer' is special, changes are effective back outside the caller
		LFStringTokenizer(StringTokenizer strTok)
		{
			theTokenizer = strTok;
		}

		//resolved all potential (if any) escaped backslash and 
		//return the complete token
		//NOTE: the use of StringTokenizer to skip backslash MAY eat up the next delimiter '#'
		String getNextTokenResolved()
		{
			if (!theTokenizer.hasMoreTokens()) return null;
			
			nextDelimConsumed = false;
			String nextTok = theTokenizer.nextToken();
			
			while (nextTok.endsWith(ESCAPE_STR)) {

				int i;
				
				for (i = 0; (nextTok.substring(0, nextTok.length() - i)).endsWith(ESCAPE_STR); i++) { 
					//start with the very last position
				}
				
				if ((i % 2) != 0) { // slash does couple with #, # is NOT a delimiter
					//first get rid of the '\' placeholder
					nextTok = nextTok.substring(0, nextTok.length() - 1);
					
					if (theTokenizer.hasMoreTokens())
						//MUST exist a '#', otherwise, big internal error
						nextTok = nextTok.concat(theTokenizer.nextToken());
					//next: must be '#', skip as delimiter
					if (theTokenizer.hasMoreTokens()) {
						String tmpStr = theTokenizer.nextToken();
						if (tmpStr.equals(DELIMITER_STR))	{ //current Token ends here, eating up '#'
							nextDelimConsumed = true;
							break;
						}
						else {
							nextTok = nextTok.concat(tmpStr);
							//next: get the rest of the content
						}
					}
				}
				else {
					break;
				}
			}
			return nextTok;
		}

		boolean hasMoreTokens()
		{
			return theTokenizer.hasMoreTokens();
		}

		int countTokens()
		{
			return theTokenizer.countTokens();
		}

		boolean isNextDelimiterConsumed()
		{
			return nextDelimConsumed;
		}

		StringTokenizer theTokenizer;
		boolean nextDelimConsumed = false;
	}

	//Version value to be updated when format of the ListFormatter is modified.
	//NOTE: always use decimal for flexible upgrade
	//    : must update 'parseMsg()' accordingly for new format, otherwise, ParseException will be thrown
	//    : (potentially) update 'isStartMessage()' and 'isCompleteMessage' and 'isEnoughDelimiter'
	//      if definition of 

    private String removeFirstEOL(String s) {
      String eol = System.getProperty("line.separator");
      if (s.startsWith(eol)) {
    	return s.substring(eol.length());  
      }
  	  return s;  
    }
}