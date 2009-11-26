package com.sap.tc.logging.exceptions;

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
 */

import java.io.*;
import java.util.*;
import java.text.*;

import com.sap.tc.logging.*;

public abstract class LoggingBaseException extends Exception
{
	//$JL-CONSOLE_LOG$ $JL-SYS_OUT_ERR$ $JL-EXC$
	//================================================ declaration > ====
	static final long serialVersionUID = 7343005603199954500L;

	public  static final String EMPTY_STRING 			= "";
	public  static final String CORELATE_STRING 	= EMPTY_STRING;
	
	private static final int EXCEPTION_INFO_MIN						= -1;
	private static final int EXCEPTION_INFO_MESSAGE 			= EXCEPTION_INFO_MIN + 1;
	private static final int EXCEPTION_INFO_STACK_TRACE 	= EXCEPTION_INFO_MESSAGE + 1;
	private static final int EXCEPTION_INFO_DESTINATIONS	= EXCEPTION_INFO_STACK_TRACE + 1;
	private static final int EXCEPTION_INFO_MAX						= EXCEPTION_INFO_DESTINATIONS + 1;

	private Throwable exCause;
	private String		messageID; 	
	private String		exceptionInfo;
	private long			exceptionInfoID;
	private String[]	exceptionInfoData 	= new String[3];
	private boolean		exceptionInfoExists	= false;

	//==== < declaration ============================ constructors > ====
			
	public LoggingBaseException() {
		super();
	}

	public LoggingBaseException(Throwable ex) {
		this(ex.getMessage(), ex);
	}
		
	public LoggingBaseException(String msg) {
		super(msg);
	}
	
	public LoggingBaseException(String msg, Throwable ex) {
		super(msg);
		this.exCause = ex;
	}
	
	public LoggingBaseException(String messageID, String message) {
		this (messageID, message, null, null);
	}
	
	public LoggingBaseException(String messageID, String message, Throwable ex) {
		this (messageID, message, null, ex);
	}
	
	public LoggingBaseException(String messageID, String message, Object[] msgArgs) {
		this (messageID, message, msgArgs, null);
	}
	
	public LoggingBaseException(String messageID, String message, Object[] msgArgs, Throwable ex) {
		super((msgArgs == null) ? message : MessageFormat.format(message, msgArgs));
		
		this.messageID = messageID;
		this.exCause 	 = ex;
		
		// Check tracing ...
		Location lcSource = findSource();
		
		if (lcSource.beLogged(Severity.PATH)) {
			logException(lcSource);
		}
	}
	
	/**
	 * messageID as a long data type is not supported any more
	 * @deprecated not supported
	 */
	public LoggingBaseException(long messageID, String message, Object[] msgArgs) {
		this (Long.toString(messageID), message, msgArgs, null);
	}
	
	/**
	 * messageID as a long data type is not supported any more
	 * @deprecated not supported
	 */
	public LoggingBaseException(long messageID, String message, Object[] msgArgs, Throwable ex) {
		this (Long.toString(messageID), message, msgArgs, ex);
	}
	
	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====

	public String getMessageID() {
		return messageID;
	}
	
	public String getAdditionalInfoID() {
		return ExMSGs.LOGGING_MSG_ID_EXCEPTION_INFO;
	}
		
	public String getAdditionalInfo() {
		if (exceptionInfoExists) {
			return MessageFormat.format(ExMSGs.LOGGING_MSG_STR_EXCEPTION_INFO, exceptionInfoData);
		}
		else {
			return EMPTY_STRING;
		}
	}
	
	/**
		* Getter method for root cause.
		* 
		* @return throwable object which caused this exception or null
		*/
	public Throwable getCause() {		
		return exCause;	
	}
	
	/**
	 * @see java.lang.Throwable#printStackTrace()
	 */
	public void printStackTrace() {
		printStackTrace(System.err);
	}

	/**
	 * @see java.lang.Throwable#printStackTrace(java.io.PrintStream)
	 */
	public void printStackTrace(PrintStream s) {
		if(isJDK_1_4_XX()) {
			super.printStackTrace(s);
		}
		else {
			printStackTraceInt(s);
		}
		
	}

	/**
	 * @see java.lang.Throwable#printStackTrace(java.io.PrintWriter)
	 */
	public void printStackTrace(PrintWriter s) {
		if(isJDK_1_4_XX()) {
			super.printStackTrace(s);
		}
		else {
			printStackTraceInt(s);
		}
	}
	
	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====

	private Location findSource() {
		
		String 		source 		= findSourceName();
		Location	lcSource 	= null;
			
		if (source != null) {
			lcSource = Location.getLocation(source, "tc~logging~java", "BC-JAS-ADM-LOG-API");
		}
		else {
			lcSource = Location.getLocation(this.getClass().getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
		}	
		
		return lcSource;
	}
	
	private void logException(Location lcSource) {
								 
		buildExceptionInfo(	EXCEPTION_INFO_MESSAGE,
												lcSource,  
												lcSource.path(Category.SYS_LOGGING,
																			 CORELATE_STRING,
																			 this.getMessageID(),
																			 null,
																			 this.getMessage()));
		
		buildExceptionInfo( EXCEPTION_INFO_STACK_TRACE, 
											  lcSource, 
											  lcSource.traceThrowableT(Severity.PATH, this.getMessage(), this));

		buildExceptionInfo(EXCEPTION_INFO_DESTINATIONS, lcSource, null);			 
	}

	private void buildExceptionInfo(int index, LogController source, LogRecord record) {
		
		switch (index) {
			case EXCEPTION_INFO_MESSAGE:
			case EXCEPTION_INFO_STACK_TRACE:
				if (record != null) {
					exceptionInfoData[index] = record.getId().toString();
				}
				break;
			case EXCEPTION_INFO_DESTINATIONS:
				StringBuffer logNames = new StringBuffer();
				Iterator iter = source.getAllLogs().iterator();
				while (iter.hasNext()) {
					logNames.append(((Log)iter.next()).getName());
				}
				if (logNames.length() > 0) {
					exceptionInfoData[index] = logNames.toString();
				}
				exceptionInfoExists = true;
		}
	}

	private String findSourceName(){
		
		Writer      stack  = new StringWriter();
		PrintWriter writer = new PrintWriter(stack);

		// Take stack trace from Existing exception (this) - no need to create new one
		((Throwable) this).printStackTrace(writer);

		// Stack Trace in string ...
		String myStack = stack.toString();
		
		// Finf the first "at" in stack trace string
		int currPos = 0;
		int lastPos = 0;
			
		while (true){
			currPos = myStack.indexOf("at", currPos);
			
			if (currPos < 0) break;
			
			// Is this realy our "at" ...
			if (myStack.substring((currPos - 1), currPos).trim().length() == 0
			&&  myStack.substring((currPos + 2), currPos + 3).trim().length() == 0) {
					lastPos = currPos;
					break;
			}
			currPos++;
		}
			
		if (lastPos == 0 ) return null; // Something is wrong ...
		
		// Extracting line with our location name from stack trace...
		String myLine = myStack.substring(lastPos + 2);
		
		// Where is the first bracket ... the end of location name + method name
		myLine = myLine.substring(0, myLine.indexOf("("));
			
		// Remove method name
		StringTokenizer strTok = new StringTokenizer(myLine, ".", true);
		
		// Build location name	
		StringBuffer location = new StringBuffer();
		
		int cnt = strTok.countTokens() - 2;
			
		for (int i = 0; i < cnt; i++){
			location.append(strTok.nextToken());
		}
			
		return location.toString();
	}

	private void printStackTraceInt(PrintStream s) {
		super.printStackTrace(s);
	}
	
	private void printStackTraceInt(PrintWriter s) {
		super.printStackTrace(s);
	}

	private boolean isJDK_1_4_XX() {
		int versionNum = 0;
		try {
			versionNum =
				Integer.parseInt(
					System.getProperty("java.version").substring(2, 3));
			if (versionNum < 4) {
				return false;
			}
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}

	//==== < private ================================== deprecated > ====

}
