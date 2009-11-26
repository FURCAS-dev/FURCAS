package com.sap.tc.logging;

/*
 * Title:        Logging
 * Description:  Logging API
 * Copyright:    Copyright (c) 2003
 * Company:      SAP AG
 *               Walldorf, Germany
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAP AG. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAP AG.
 */


import java.util.*;
import java.text.*;
import java.io.*;

import com.sap.tc.logging.interfaces.ILog;

/**
 * <p>
 *   Writes log records to destinations.
 *   Writing log records is done on behalf of <em>log controllers</em>. On
 *   logging calls, records are written to the destination associated with the
 *   log in the format dictated by the <em>formatter</em> registered with the
 *   log, if the severity and the filters set for the log do not veto.
 * </p>
 * <p>
 *   Please find fundamental information about the principles of error handling
 *   in the package description. For this class, there are two cases where the
 *   methods {@link #getException()} and {@link #throwException()} are served.
 *   First, methods dealing with severities pass over a
 *   <code>java.lang.IllegalArgumentException</code> if a value is out of range.
 *   Second, output methods encountering problems leave the corresponding
 *   <code>java.io.IOException</code>. Some of these problems are also logged
 *   to the category <code>/System/Logging</code> which in turn writes messages
 *   to the console.
 * </p>
 * @see    LogController
 * @see    Severity
 * @see    Filter
 * @see    Formatter
 * @see    LogRecord
 */
public abstract class Log 
								extends ExceptionHandling
								implements ILog{
	//$JL-EXC$
	//================================================ declaration > ====
	
	private static String subLoc = "Log";
	
	public static final int STATUS_INVALID	= 0;
	public static final int STATUS_CLOSED 	= 1;
	public static final int STATUS_OPENED 	= 2;
	
	// Flag for unit tests, which indicates that actual writes are to be
	// suppressed no matter how other attributes are set.
	private boolean suppressing = false;
  
	// Flag for unit tests, which indicates how many calls since the last reset
 	// would have written messages to this log.
	private int 					loggedCnt = 0;
  
	private boolean 			headerWritten = false,
										  	autoFlush     = true;

	private int       		effSeverity 	= Severity.ALL;
	private int						logTypeAccessibility;
	private HashSet   		filters				= new HashSet();

	private Formatter 		formatter;
	private LinkedList		lcOwners				  = new LinkedList();;
	private LogController	localLogOwner;
 
  private String   	  	logName;
	private String   			logDescription;
	private int						logStatus					= STATUS_CLOSED;
	private String   	  	logHeader					= "";
	private String   			logFooter					= "";
	private long				  logSize;
	private String				logVerInUse;
 
	private Date timeStamp;
	
	private volatile boolean exceptionGuardian = false;
	 
	// LOG ACCESSABILITY TYPE CONSTANTS
	private static final int LOG_ACCESSABILITY_TYPE_MIN 				= 0; 
	
	/**
	 * This type of Log allows regular inheritance; this log will become available 
	 * to all descendants of the parent object.
	 * 
	 * The corresponding API is:
	 * 		
	 * 		static final Location parent = Location.getLocation("com.sap"),
	 * 		Location child = Location.getLocation("com.sap.foo");
	 *		
	 *		parent.addLog(new ConsoleLog());
	 *		parent.setEffectiveSeverity(Severity.NONE);
	 *		child.setEffectiveSeverity(Severity.INFO);
	 * 		child.fatalT("A fatal message from children");
	 * 
	 * This is an unconditional inheritance. As long as the message passes the evaluation 
	 * of severity and filter of the child object, it will be printed out via the inherited log, 
	 * in this case, ConsoleLog.
	 */
 	public  static final int LOG_ACCESSABILITY_TYPE_NORMAL_LOG 	= 1; 
 	
 	/**
 	 * Inheritance is allowed, but with additional condition: 
 	 * final discretion of message printing lies with the original parent object. 
 	 * The log is local, in the sense that it is not available for the descendants 
 	 * if the child message does not pass the severity and filter test of the parent object.
	 * 
	 * 	static final Location parent = Location.getLocation("com.sap")
	 *  Location child = Location.getLocation("com.sap.foo");
	 * 
	 * 	parent.addLocalLog(new ConsoleLog());
	 *  parent.setEffectiveSeverity(Severity.NONE);
	 *  child.setEffectiveSeverity(Severity.INFO);
	 *  child.fatalT("A fatal message from children");
	 *  
	 * Contrary to the NORMAL Log example, the child message will 
	 * not be printed because it does not pass the severity test of the parent.
 	 */
	public  static final int LOG_ACCESSABILITY_TYPE_LOCAL_LOG 	= 2; 
	
	/**
	 * This type of Log completely disables inheritance. 
	 * Log assignment is private: only effective for the parent source object. 
	 * 
	 * 	static final Location parent = Location.getLocation("com.sap"),
	 * 	Location child = Location.getLocation("com.sap.foo");
	 * 	
	 * 	parent.addPrivateLog(new ConsoleLog());
	 *  child.setEffectiveSeverity(Severity.INFO);
	 * 	child.fatalT("A fatal message from children");
	 * 
	 * In this case, child object does not inherit any destination log at all. 
	 * Nothing will be printed even the message passes all the severity and filter tests.
	 */
	public  static final int LOG_ACCESSABILITY_TYPE_PRIVATE_LOG = 3; 
	
	private static final int LOG_ACCESSABILITY_TYPE_MAX 				= 4;  
 
	//==== < declaration ============================ constructors > ====
  
  protected Log() {
	timeStamp = new Date();
    formatter = new ListFormatter();
  }

  protected Log(Formatter formatter) {
	timeStamp = new Date();
    setFormatter(formatter);
  }

  protected void finalize() throws Throwable {
	try {  
	  super.finalize();
	}
	catch (Exception e) {
        // $JL-EXC$ - it is not possible to do anything else
	}
    close();
  }

  //==== < constructors =============================== abstarct > ====
	//==== < abstarct ===================================== public > ====

  //*******************************************************************
	// Implementation of the IObjectInfo interface
	// (ILog extends IObjectInfo)
	//*******************************************************************
  
	/**
	 * Gets the name for this log. Can be null.
	 */
	public synchronized String getName(){
		return logName;
	}

	/**
	 * Sets a name for this log. An optional courtesy feature for user
	 * to easily refer to a log. Highly recommended if logviewer tool
	 * will be used to browse the output messages.
	 * If no name is specified, nothing will be set and the value is null.
	 */
	public synchronized void setName(String name){
		this.logName = name;
	}
	
	/**
	 * Gets the description for this log. Can be null.
	 */
	public synchronized String getDescription(){
		return logDescription;
	}

	/**
	 * Sets a description for this log. An optional courtesy feature for user
	 * to easily refer to a log. Highly recommended if logviewer tool
	 * will be used to browse the output messages.
	 * If no name is specified, nothing will be set and the value is null.
	 */
	public synchronized void setDescription(String value){
		this.logDescription = value;
	}
	
	/**
	 * Gets the version of API.
	 */
	public synchronized String getVerInUse(){
		return logVerInUse;
	}

	//*******************************************************************
	// Implementation of the ILog interface
	//*******************************************************************
	
	/**
	 * Status of this log object.
	 * 
	 * STATUS_CLOSE == 1
	 * STATUS_OPEN 	== 2
	 */
	public int status() {
		return logStatus;
	}
	
	/**
	 * Gets the header text of this log.
	 * @return Text which represent header of this log.
	 * @see    #setHeader(java.lang.String)
	 */
	public String getHeader() {
		return logHeader + getFormatter().getHeader(this);
	}

	/**
	 * Sets the footer text of this log.
	 * @return Text which represent footer of this log.
	 * @see    #setHeader(java.lang.String)
	 */
	public String getFooter() {
		return logFooter + getFormatter().getFooter(this);
	}
	
	/**
   * Gets the current effective severity of this log.
   * @return Effective severity
   * @return Effective severity if set or
   *         {@link Severity#ALL}.
   */
  public synchronized int getEffectiveSeverity() {
		return effSeverity;
  }

  /**
   * Sets the effective severity of this log.
   * @param  severity New effective severity
   */
  public void setEffectiveSeverity(int severity) {
  	int oldValue = -1,
  			newValue = -1;
  	synchronized (getClass()) {
  		oldValue = getEffectiveSeverity();
  		this.effSeverity = Severity.correct(severity);
  		newValue = getEffectiveSeverity();
  	}
		if (oldValue != newValue) {
			APILogger.instrumentIntByAPI(subLoc + "[setEffectiveSeverity(int severity)]", 
				 MSGCollection.CONFIGURATION_IS_CHANGED(),
				 new Object[] {"effective severity",
											 "Log",
											 this.getName(),
											 "" + oldValue, 
											 "" + newValue});
		}
  }
	  
	/**
   * Gets the current accessibility type of this log.
   * 
   * Default = LOG_ACCESSABILITY_TYPE_NORMAL_LOG
   * 
   * @return Accessibility type. 
   *         {@link Log#LOG_ACCESSABILITY_TYPE_NORMAL_LOG}
   * 				 {@link Log#LOG_ACCESSABILITY_TYPE_LOCAL_LOG}
   * 				 {@link Log#LOG_ACCESSABILITY_TYPE_PRIVATE_LOG}.
   */
  public synchronized int getLogTypeAccessibility() {
		return logTypeAccessibility;
  }

  /**
   * Sets the accessibility level for this log.
   * 
   * Note: If you specified value which is not recognized,
   * the accessibility type will be set to PRIVATE. 
   * 
   * @param  new accessibility type
   *         {@link Log#LOG_ACCESSABILITY_TYPE_NORMAL_LOG}
   * 				 {@link Log#LOG_ACCESSABILITY_TYPE_LOCAL_LOG}
   * 				 {@link Log#LOG_ACCESSABILITY_TYPE_PRIVATE_LOG}.
   */
  public void setLogTypeAccessibility(int value) {
  	int oldValue = -1,
  			newValue = -1;
  	synchronized (getClass()) {
  		oldValue = getLogTypeAccessibility();
  		if (value <= LOG_ACCESSABILITY_TYPE_MIN || 
  				value >= LOG_ACCESSABILITY_TYPE_MAX) {
  			value = LOG_ACCESSABILITY_TYPE_PRIVATE_LOG;
  		}
  		logTypeAccessibility = value;
  		newValue = getLogTypeAccessibility();
  	}
		if (oldValue != newValue) {
			APILogger.instrumentIntByAPI(subLoc + "[setLogTypeAccessibility(int value)]", 
					MSGCollection.CONFIGURATION_IS_CHANGED(),
					new Object[] {"accessibility level", 
											 "Log",
											 this.getName(),
											 "" + oldValue, 
											 "" + newValue});
		}
  }

  /**
	 * Gets the formatter that dictates the format of log records in this log.
	 * @return Formatter
	 * @see    #setFormatter(Formatter)
	 */
	public synchronized Formatter getFormatter() {
	  return formatter;
	}

	/**
	 * Sets the formatter that dictates the format of log records in this log.
	 * 
	 * Note: If you send a null like argument the default 
	 * formater (ListFormatter), will be created. 
   * 
	 * @return Formatter
	 * @see    #getFormatter()
	 */
	public void setFormatter(Formatter formatter) {
	  
		String oldValue = (getFormatter() != null) ? getFormatter().getClass().getName() : null;
		
		if (formatter != null) {
			synchronized (getClass()) {
				this.formatter = formatter;
			}
		} 
	  else {
			APILogger
			  .instrumentIntByAPI(Severity.DEBUG,
								  subLoc + "[setFormatter(Formatter formatter)] " + MSGCollection.LOGGING_MSG_STR_OBJECT_IS_NULL_DEF,
							      new String[] {"Formatter", "Log", this.getName(), "Formatter", "ListFormatter"});
										  
			// Set default formatter
			synchronized (getClass()) {
				formatter = new ListFormatter();
			}
	  }
		
		if (oldValue != null) {
			APILogger.instrumentIntByAPI(subLoc + "[setFormatter()]", 
					MSGCollection.CONFIGURATION_IS_CHANGED(),
					new Object[] {"formatter", 
												"Log",
												this.getName(),
												oldValue, 
												getFormatter().getClass().getName()});
		}
	}
	
	
	/**
	 * This method returns the number that indicates
	 * how many LogRecords have been written so far.
	 * This does not take into account how many LogRecords were there in the file
	 * before the current session has started.
	 * Therefore, please note that this number deals with the number of LogRecords
	 * that have been written in the current session.
	 * @return int Number of LogRecords written so far in the current session.
	 */
	public int getNumberOfLogRecordsWritten()
  {
		return getLoggedCount();
  }
	
	/**
	 * Current size of the log.
	 * @return long size of the log.
	 */
	public long size()
  {
		return logSize;
  }
	  
	/**
	 * Gets the canonical name of the character encoding that is used for this
	 * log.
	 * If no character encoding is set the default character encoding of the
	 * platform is used.
	 * @return Name of character encoding
	 * @see    #setEncoding(java.lang.String)
	 */
	public abstract String getEncoding();

	/**
	 * Sets the named character encoding to be used for this log.
	 * If no character encoding is set the default character encoding is used.
	 * @param  enc Name of character encoding
	 * @see    #getEncoding()
	 */
	public abstract void setEncoding(String enc);
		
	//*******************************************************************
  // 								F I L T E R S
  //*******************************************************************
	
  /**
   * Checks whether all filters associated with this log controller agree with
   * writing a log record.
   * @param  rec Log record to be written
   * @return No filter vetoes writing
   */
  public boolean isFiltersAgreeing(LogRecord rec) {
   	
   	if (rec == null) return false;
   	
		if (	filters != null 
			&& !filters.isEmpty()
			&& rec.getSeverity() != Severity.GROUP) {

			Iterator iter = getFilters().iterator();

		  while (iter.hasNext()) {
			  try {
				  if (!((Filter) iter.next()).beLogged(rec)) {
					  return false;
				  }
			  }
			  catch (Exception ex) {
					if (exceptionGuardian) return false;
					exceptionGuardian = true;
			  	APILogger
						  .logIntByAPI(Severity.WARNING,
													subLoc + "[isFiltersAgreeing(LogRecord rec)]",
													MSGCollection.LOGGING_MSG_ID_FILTER_EXCEPTION,
													MSGCollection.LOGGING_MSG_STR_FILTER_EXCEPTION,
													new String[] {"Log", this.getName()});
					APILogger.catchingIntByAPI(ex);
					exceptionGuardian = false;
			  }
		  }
		}
  	return true;
  }
  
  /**
   * Gets the filters that control writing of messages via this log.
   * @return Unmodifiable collection of filters associated with this log
   */
  public Collection getFilters() {
		if (filters != null) {
			synchronized (filters) {
    		return Collections.unmodifiableCollection(new ArrayList(filters));
			}
		}
		return Collections.EMPTY_LIST;
  }

  /**
   * Adds another filter that controls writing of messages via this log.
   * The results of all filters for a given message are logically
   * <em>and</em>ed to determine whether a message is to be written.
   * @param  filter New filter
   */
  public void addFilter(Filter filter) {
		if (filter != null) {
			synchronized (filters) {
				if (!filters.contains(filter)) {
					filters.add(filter);
				}
			}
		} 
    else {
			APILogger
				.logIntByAPI(Severity.WARNING,
											subLoc + "[addFilter(Filter filter)]",
											MSGCollection.LOGGING_MSG_ID_OBJECT_IS_NULL,
											MSGCollection.LOGGING_MSG_STR_OBJECT_IS_NULL,
											new String[] {"Filter", "Log", this.getName()});
    }
  }

  /**
   * Removes a filter so that it no longer controls writing of messages via this
   * log.
   * @param  filter Filter to be removed
   */
  public void removeFilter(Filter filter) {
  	synchronized (filters) {
  		filters.remove(filter);
  	}
		APILogger.instrumentIntByAPI(subLoc + "[removeFilter(Filter filter)]", 
					 MSGCollection.CONFIGURATION_REMOVE_ITEM(),
					 new Object[] {"filter", filter.getClass().getName(), this.getName()});
  }

  /**
   * Removes all filters associated with this log.
   */
  public void removeFilters() {
  	synchronized (filters) {
  		filters.clear();
  	}
  	APILogger.instrumentIntByAPI(subLoc + "[removeFilters()]", 
					 MSGCollection.CONFIGURATION_REMOVE_ITEM(),
					 new Object[] {"Filter", "ALL", this.getName()});
  }
	
  //************************************************************************

  /**
   * Checks whether a message with the specified severity would be written via
   * this log.
   * The purpose of this method is to avoid evaluating the arguments of a
   * logging call, which is expensive and would be superfluous if a message is
   * not written because of its insufficient severity. The result returned is
   * necessary but not sufficient for writing log messages, that is if the
   * method returns <code>false</code> the message is not going to be written
   * but not vice versa. To this end, the method checks whether the specified
   * severity is equal to or higher than the effective severity of the log. It
   * does not take into account filters associated with the log.
   * @param  severity Severity of message to be written
   */
  public boolean beLogged(int severity) {
    return severity >= getEffectiveSeverity();
  }
	
  /**
	  * Writes a log record to this log if no filter vetoes.
	  * @param  rec Record to be written
	  * @deprecated not supported anymore
	  */
  public LogRecord write(LogRecord rec) {
		
		LogRecord writtenRec = null;
		
		try {
			if (beLogged(rec)) {
				writtenRec = writeInternalByAPI(rec);
			}
		}
		catch (Exception ex) {
			if (exceptionGuardian) return null;
			exceptionGuardian = true;
			APILogger
				.logIntByAPI(Severity.WARNING,
											subLoc + "[write(LogRecord rec)]",
											MSGCollection.LOGGING_MSG_ID_WRITE_EXCEPTION,
											MSGCollection.LOGGING_MSG_STR_WRITE_EXCEPTION,
											new String[] {this.getName()});
			APILogger.catchingIntByAPI(ex);
			exceptionGuardian = false;
		}
	
		return writtenRec;
  }

  /**
   * Flushes buffered records in this log object.
   */
  public void flush() {
    try {
      flushInt();
    }
    catch (IOException ex) {
    	if (exceptionGuardian) return;
			exceptionGuardian = true;
    	APILogger
				.logIntByAPI(Severity.WARNING,
											subLoc + "[flush()]",
											MSGCollection.LOGGING_MSG_ID_WRITE_EXCEPTION,
											MSGCollection.LOGGING_MSG_STR_WRITE_EXCEPTION,
											new String[] {this.getName()});
			APILogger.catchingIntByAPI(ex);
			exceptionGuardian = false;
    }
  }

  /**
   * Checks whether this log flushes its output stream after each log message.
   * Automatic flushing is switched on in a new log.
   * @return <code>true</code> if and only if this log flushes its output stream
   *         after each log message
   * @see    #setAutoFlush(boolean)
   */
  public boolean isAutoFlush() {
    return autoFlush;
  }

  /**
   * Configures this log to flush the output stream after each log message.
   * Automatic flushing is switched on in a new log.
   * @param  autoFlush
   * @see    #isAutoFlush()
   */
  public void setAutoFlush(boolean autoFlush) {
  	boolean oldValue = false,
  					newValue = false;
  	synchronized(getClass()) {
  		oldValue = isAutoFlush();
  		this.autoFlush = autoFlush;
  		newValue = isAutoFlush();
  	}
  	if (oldValue != newValue) {
  		APILogger.instrumentIntByAPI(subLoc + "[setAutoFlush(boolean autoFlush)]", 
  				MSGCollection.CONFIGURATION_IS_CHANGED(),
					new Object[] {"auto flush", 
    									 "Log",
    									 this.getName(),
    									 "" + oldValue, 
											 "" + newValue});
  	}
  }

  /**
	 * open output of this log object.
	 */
	public void open() {
	  try {
		 	openInt();
	  }
	  catch (IOException ex) {
	  	if (exceptionGuardian) return;
			exceptionGuardian = true;
	  	APILogger
				.logIntByAPI(Severity.ERROR,
							  		 subLoc + "[open()]",
										 MSGCollection.LOGGING_MSG_ID_OPEN_EXCEPTION,
										 MSGCollection.LOGGING_MSG_STR_OPEN_EXCEPTION,
										 new String[] {this.getName()});
			APILogger.catchingIntByAPI(ex);
			exceptionGuardian = false;
	  }
	}
	
  /**
   * Closes output of this log object.
   */
  public synchronized void close() {
    try {
			writeLogFooter();
    	closeInt();
    	setSize(0);
    }
    catch (Exception ex) {
			APILogger
				.logIntByAPI(Severity.ERROR,
											subLoc + "[close()]",
											MSGCollection.LOGGING_MSG_ID_CLOSE_EXCEPTION,
											MSGCollection.LOGGING_MSG_STR_CLOSE_EXCEPTION,
											new String[] {this.getName()});
			APILogger.catchingIntByAPI(ex);
    }
  }
  
  /**
	 * Check is this log closed.
	 * Helper method. 
	 * Same like: status() == STATUS_CLOSED
	 */
  public synchronized boolean isClosed() {
  	return logStatus == STATUS_CLOSED;
  }
  
	/**
	 * Check is this log opened.
	 * Helper method. 
	 * Same like: status() == STATUS_OPENED
	 */
	public synchronized boolean isOpened() {
	  return logStatus == STATUS_OPENED;
	}

  /**
	* Reset all current Log settings and
	* starts from beginning 
	* Current file
	*/
  public void reset() {
	  try {
		  resetInt();
		  
		  APILogger.instrumentIntByAPI(subLoc + "[reset()]", 
					 MSGCollection.CONFIGURATION_RESET(),
					 new Object[] {this.getName()});
	  }
	  catch (Exception ex) {
		  APILogger
			  .logIntByAPI(Severity.WARNING,
										  subLoc + "[reset()]",
										  MSGCollection.LOGGING_MSG_ID_UNEXPECTED,
										  MSGCollection.LOGGING_MSG_STR_UNEXPECTED,
										  new String[] {this.getName()});
		  APILogger.catchingIntByAPI(ex);
	  }
  }
  
	public boolean isSuppressing() {
		return suppressing;
  }

  public void setSuppressing(boolean suppressing) {
		this.suppressing = suppressing;
  }
  
  public int getLoggedCount() {
	  return loggedCnt;
	}

	public void resetLoggedCount() {
	  loggedCnt = 0;
	} 
	
	public List getOwners(){
		if (!lcOwners.isEmpty()) {
			return lcOwners;
		}
		return Collections.EMPTY_LIST;
	}

	//==== < public ==================================== protected > ====
 
	protected synchronized void setSize(long value)
  {
		this.logSize = value;
  }
	
 	protected synchronized void setStatus(int status) {
 		if (status < STATUS_CLOSED || status > STATUS_OPENED) {
 			this.logStatus = STATUS_INVALID;
 		}
 		else {
			this.logStatus = status;
 		}
 	}
	
	protected synchronized void setHeader(String value) {
		if (value == null) {
			logHeader = "";
		}
		else {
			logHeader = value;
		}
	}

	protected synchronized void setFooter(String value) {
		logFooter = value;
	}
  
	protected synchronized void setVerInUse(String value){
		logVerInUse = value;
	}
  
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
  
	/**
	 * <p>
	 *   Writes a log message string to this log.
	 *   This method is meant as the standard way of implementing the fashion in
	 *   which a log message is written to its destination. Note that this method
	 *   is called inside a <code>synchronized</code> statement that locks this
	 *   log, in order to avoid deadlocks.
	 * </p>
	 * <p>
	 *   If you need access to the log record to be written you should override
	 *   {@link #writeInt(java.lang.String)}. Note that, nevertheless, even in
	 *   this case it is usually necessary to reimplement this method.
	 * </p>
	 * @throws IOException Exception from writing messages to the destination
	 */
  protected void writeInt(String s)throws Exception {}

	/**
	 * Flushes buffered records in this log object.
	 * This method is meant for overriding the fashion in which buffered log
	 * records are flushed. You should not call this method from the outside
	 * because you would ignore common actions that have to take place for each
	 * flush.
	 * @throws IOException Exception from flushing records to the destination
	 */
	protected void flushInt() throws IOException {}
  
	/**
	 * Closes output of this log object.
	 * This method is meant for overriding the fashion in which the log is closed.
	 * You should not call this method from the outside because you would ignore
	 * common actions that have to take place for each close, for example
	 * writing the footer defined by the formatter.
	 * @throws IOException Exception from closing the destination
	 */
	protected void closeInt() throws IOException {}

	/**
	 * Open output of this log object.
	 * This method is meant for overriding the fashion in which the log is open.
	 * You should not call this method from the outside because you would ignore
	 * common actions that have to take place for each open, for example
	 * writing the header defined by the formatter.
	 * @throws IOException Exception from opening the destination
	 */
	protected void openInt() throws IOException {}

	/**
	 * Reset all current FileLog settings and
	 * starts from beginning 
	 * Current file
	 */
	protected void resetInt() throws Exception {}

  /**
   * <p>
   *   Writes a log record to this log.
   *   This method is meant for overriding if you need access to the log record
   *   to be written. You should not call this method from the outside because
   *   you would ignore the checks for severities and filters done in
   *   {@link #write(LogRecord)}. There are three basic use cases in which to
   *   reimplement this method.
   *   <ul>
   *     <li>
   *       You want to do something with the record before writing it in the
   *       standard fashion. In that case, do what is needed and then call
   *       <code>return super.writeInt(rec)</code> as the last statement.
   *     </li>
   *     <li>
   *       Second, you want to do your own special formatting of the record
   *       prior to writing. In that case, consider to write your own formatter
   *       as this is probably a much cleaner way to do so. If for some
   *       unforeseeable reason you cannot achieve the effect you are after, do
   *       the log record formatting into a string and then call
   *       <code>writeInt(java.lang.String)</code> to write it. Finally, return
   *       the string to the caller.
   *     </li>
   *     <li>
   *       Third, you do not want to write the log record as a string at all
   *       but, for example, into a structure such as a database table. In that
   *       case, put the corresponding code into your overriding method and do
   *       not call <code>writeInt(String)</code>. Return <code>null</code> to
   *       the caller.
   *     </li>
   *   </ul>
   *   Note that this method is called inside a <code>synchronized</code>
   *   statement that locks this log, in order to avoid deadlocks.
   * </p>
   * <p>
   *   If you want to override where to write a formatted string to, do not
   *   override this method at all but instead reimplement
   *   <code>writeInt(String)</code>. Note that the first and second use case
   *   usually also necessitate this reimplementation.
   * </p>
   * @throws IOException Exception from writing records to the destination
   * @see    #writeInt(java.lang.String)
   */
  protected synchronized String writeInt(LogRecord rec) throws Exception {
	rec.setThreadInternal(true);  
    timeStamp = rec.refreshTime(timeStamp); 
    String msg = getFormatter().format(rec);
	rec.setThreadInternal(false);  
    
    if (!isSuppressing()) {
      writeInt(msg);
    }
    return msg;
  }

  protected synchronized boolean isHeaderWritten() {
		  return headerWritten;
	}

	protected void setHeaderWritten(boolean headerWritten) {
		this.headerWritten = headerWritten;
	}
	
	protected synchronized void addOwner(String owner){
		lcOwners.add(owner);
	}
	
	protected synchronized void removeOwner(String owner){
		LinkedList newOwners;
		if (lcOwners.contains(owner)) {
			// Keep owners list immutable to avoid reader synchronization.
			newOwners = new LinkedList(lcOwners);
			newOwners.remove(owner);
			lcOwners = newOwners;
		}
	}
	
	protected synchronized void setLocalLogOwner(LogController owner){
		localLogOwner = owner;
	}
	
	protected LogController getLocalLogOwner(){
		return localLogOwner;
	}
	
	//==== < protected =================================== default > ====
	
	boolean beLogged(LogRecord rec) {
		return beLogged(rec.getSeverity()) && isFiltersAgreeing(rec);
	}
	
	/**
	 * Writes a log record to this log if no filter vetoes.
	 * @deprecated Use writeInternalByAPI()
	 */
	LogRecord writeIntByAPI(LogRecord rec) {
		LogRecord writtenRec = null;
		try {
			writtenRec =  writeInternalByAPI(rec);
		}
		catch (Exception ex) {
		}
		return writtenRec;
	}
	
	/**
	 * Writes a log record to this log if no filter vetoes.
	 */
	LogRecord writeInternalByAPI(LogRecord rec) throws Exception {
	
		LogRecord writtenRec = null;
	
		// Write actual message.
		writeInt(rec);

		writtenRec = rec;
  
	  setLogged();
	
		if (autoFlush) {
		  flush();
		}
	
		return writtenRec;
	}

  boolean wasLogged() {
    return loggedCnt > 0;
  }

  void setLogged() {
    ++loggedCnt;
  }
	
  //==== < default ===================================== private > ====

  /**
   * Writes a log header to this log.
   */
	protected synchronized void writeLogHeader(){
		
  }
  
  /**
	* Writes a log footer to this log.
	*/
	protected synchronized void writeLogFooter(){
		
  }
  
  //==== < private ================================== deprecated > ====
	
  /**
   * @deprecated - Not supported anymore - always return null
   */
  public LogRecord getRecord() {
		return null;
	}

	/**
	 * @deprecated Not supported anymore. Always return False! 
	 * @see #LogController.beGroup()
	 */
  public boolean beGroup() {
		return false;
  }
  
  /**
   * @deprecated @see {#getName()}.
   */
  public synchronized String getLogName(){
		return logName;
  }

  /**
   * @deprecated @see {#setName(String name)}.
   */
  public synchronized void setLogName(String name){
		this.logName = name;
  }
	
}
