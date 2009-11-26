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
 * @version      $Id: //sapmarkets/Logging/630_SP_COR/src/_Logging/java/com/sap/tc/logging/Formatter.java#6 $
 */

import java.lang.*;

import java.util.*;
import java.text.*;
import java.io.*;

import com.sap.tc.logging.interfaces.IMessageBuilder;
import com.sap.tc.logging.interfaces.IMessageDelimiterBuilder;
import com.sap.tc.logging.messagedepot.MessageAccessor;

/**
 * Formats log records on behalf of logs the formatter is registered with.
 * @see    Log
 * @see    LogController
 */
public abstract class Formatter {
	// $JL-EQUALS$
	//================================================ declaration > ====
	
	private FormatterType 	mFormatType;
	private String	     		formatterName = EMPTY_STRING;
	private MessageAccessor	msgAccessor;
  
  protected static final String EOL = System.getProperty("line.separator");

  static final String NULL_STRING 					= "<null>";
  static final String EMPTY_STRING 					= "";
 
  private final static char DELIMITER				= '#'; 		
  private final static int 	DELIMITER_COUNT	= 0;
  
  //==== < declaration ============================ constructors > ====
  
  /*
   * @todo expand if-else logic if additional PREDEFINED formatter types are
   *       introduced by logging framework (corresponding addition should be done
   *       in class 'FormatterType' as well).
   */
  protected Formatter() {
    String fullClass = getClass().getName();

  	// the next IFs can handle nicely:
  	// (1) empty constructor call from both predefined and customized formatter
  	// (2) even when user put fullpath, e.g. 'com.sap.tc.logging.ListFormatter'
  	// in configuration file, so it does get FomatterType.LISTFORMAT instead of
  	// being treated as a customized formatter
		if(fullClass.equals("com.sap.tc.logging.ListFormatter")) {
  		this.mFormatType = FormatterType.LISTFORMAT;
		}
  	else if(fullClass.equals("com.sap.tc.logging.XMLFormatter")) {
  		this.mFormatType = FormatterType.XMLFORMAT;
  	}
    else if(fullClass.equals("com.sap.tc.logging.TraceFormatter")) {
      this.mFormatType = FormatterType.TRACEFORMAT;
    }
		else if(fullClass.equals("com.sap.tc.logging.perf.PerfFormatter")) {
	  	this.mFormatType = FormatterType.PERFFORMAT;
		}
    else {   //customized class
      this.mFormatType = new FormatterType(fullClass);
    }
  }

  //For use only when users has extended the typesafe enum class 'FormatterType'
  //to include their customized formatter type.
  //Otherwise, use constructor Formatter() with empty argument.
  protected Formatter(FormatterType aType){
    if (aType != null) {  //should not happen
      this.mFormatType = aType;
    }
    else {
      this.mFormatType = FormatterType.UNDEFINEDFORMAT;
    }
  }

	//==== < constructors =============================== abstarct > ====
  //==== < abstract ===================================== public > ====
  
  /**
   * Formats a log record which is then ready to be written to a log.
   * @param  rec Log record to be formatted
   * @return Formatted log record
   */
  public abstract String format (LogRecord rec);

  /**
   * Returns the MsgByte object.
   * @return MsgByte
   */
  public IMessageBuilder getMessageBuilder() {
  	IMessageDelimiterBuilder msgDelimiter = new MessageDelimiterBuilder((byte) DELIMITER, 0);
  	return new MessageBuilder(this, msgDelimiter);
  }
  
  /**
   * Returns the header for a set of formatted records.
   * @param  log Target log.
   * @return Header
   */
  public String getHeader(Log log) {
  	return "";
  }

  /**
   * Returns the footer for a set of formatted records.
   * @param  log Target log
   * @return Footer
   */
  public String getFooter(Log log) {
      return "";
  }

  /**
   * Sets a MessageAccessor for this formatter. 
   * MessageAccessor is used for message localization.
   */
  public synchronized void setMessageAccessor(MessageAccessor accessor){
    this.msgAccessor = accessor;
  }
  
  /**
	 * Gets the descriptive name for this formatter. Can be null.
	 */
	public synchronized String getFormatterName(){
	  return formatterName;
	}

	/**
	 * Sets a descriptive name for this formatter. An optional courtesy feature for user
	 * to easily refer to a formatter. Highly recommended if logviewer tool
	 * will be used to browse the output messages.
	 * If no name is specified, nothing will be set and the value is null.
	 */
	public synchronized void setFormatterName(String name){
	  this.formatterName = name;
	}
	
	/**
   * Returns the type of formatter instance.<br>
   * If formatter is the predefined classes provided by logging, an explicit
   * formatter type will be returned.
   * See {@link FormatterType} for the predefined formatter types used in Logging. <br>
   * If the formatter is the customized class provided by the users,
   * the full classname will be included with the format type, use getString() to
   * retrieve it.
   * @return A formatter type
   */
  public final FormatterType getFormatterType(){
    return this.mFormatType;
  }
	
  /**
   * Return true if this formatter supports message parsing formatted with this
   * formatter. Otherwise, return false.
   * See method {@link #parseMsg(String)}.
   */
  public boolean isParsable(){
    return false;
  }

  /**
   * <p>Message written with the specific formatter is read as plain string. This
   * method parses the content and massages the data into appropriate fields,
   * into a LogRecord structure.</p>
   * <p>NOTE: UPDATE this method when newer version of format is defined by the
   * formatter.</p>
   * @param A complete message body and its admin data that can span across
   * multiple lines
   * @return The complete message with its admin data has been broken down and
   * packed in {@link LogRecord}. Return Null if formatter does not support
   * parsing.
   */
  public LogRecord parseMsg(String completeMsgData)  throws ParseException{
    return null;
  }

  public LogRecord parseMsg(byte[] msgChunk) throws ParseException {
  	return parseMsg(new String (msgChunk).trim());
  }

  public LogRecord parseMsg(IMessageBuilder message) throws ParseException {
  	return parseMsg(new String (message.message()).trim());
  }
  
  /**
   * Determine if the message string starts with the valid start(delimiter) of a
   * message record, according to the format defined by the formatter
   */
  public boolean isStartMessage(String msg){
    return true;
  }
  
  /**
   * Determine if the message string reaches the valid end(delimiter) of a
   * complete message record, according to the format defined by the formatter
   */
  public boolean isCompleteMessage(String msg){
    return true;
  }
	
  /**
   * Compare to Formatter clasess.
   * Return true if: 
   * Formatter.getFormatterName() is equal
   * And
   * Formatter.getFormatterType().toString() is equal
   */
  public boolean equals(Object obj) {
    if (obj instanceof Formatter) {	
      return this.mFormatType.toString().equalsIgnoreCase(((Formatter) obj).getFormatterType().toString())
                   & this.formatterName.equalsIgnoreCase(((Formatter) obj).getFormatterName());
    } else {
      return false;
    }
  }
  
	//==== < public ==================================== protected > ====
	
	/**
   * Gets a MessageAccessor for this formatter. 
   * MessageAccessor is used for message localization.
   */
  protected synchronized MessageAccessor getMessageAccessor(){
		return this.msgAccessor;
  }
	
  //==== < protected =================================== default > ====
  //==== < default ===================================== private > ====
  //==== < private ================================== deprecated > ====
  
  /**
   * @deprecated Not Supported any more.
   */
  public boolean isStartMsg(int messageSize, byte[] message)
	{
		return true;	
	}
  
  /**
   * @deprecated Not Supported any more.
   */
	public boolean isCompleteMessage(int messageSize, byte[] message, int delimiterSize, int[] delimiter)
	{
		return true;
	}
  
}