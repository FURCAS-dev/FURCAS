package com.sap.tc.logging.interfaces;

/*
 *  Copyright:   Copyright (c) 2003
 *
 *  Company:     SAP AG
 *               Walldorf, Germany
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAP AG. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAP AG.
 * 
 * @version $Id:$
 */

import java.util.Collection;

import com.sap.tc.logging.*;

public interface ILog extends IObjectInfo, Cloneable {
	
	/**
   * Gets the formatter that dictates the format of log records in this log.
   * @return Formatter
   * @see    #setFormatter(Formatter)
   */
	public Formatter getFormatter();

	/**
   * Sets the formatter that dictates the format of log records in this log.
   * @return Formatter
   * @see    #getFormatter()
   */
  public void setFormatter(Formatter formatter);

	/**
   * Sets the effective severity of this log.
   * @param  severity New effective severity
   */
	public void setEffectiveSeverity(int severity);

	/**
	 * Gets the current effective severity of this log.
	 * @return Effective severity
	 * @return Effective severity if set or
	 *         {@link Severity#ALL}.
	 */
	public int getEffectiveSeverity();

	/**
	 * Gets the header text of this log.
	 * @return Text which represent header of this log.
	 * @see    #setHeader(java.lang.String)
	 */
	public String getHeader();

	/**
	 * Sets the footer text of this log.
	 * @return Text which represent footer of this log.
	 * @see    #setHeader(java.lang.String)
	 */
	public String getFooter();
		
	/**
	 * Gets the canonical name of the character encoding that is used for this
	 * log.
	 * If no character encoding is set the default character encoding of the
	 * platform is used.
	 * @return Name of character encoding
	 * @see    #setEncoding(java.lang.String)
	 */
	public String getEncoding();

	/**
	 * Sets the named character encoding to be used for this log.
	 * If no character encoding is set the default character encoding is used.
	 * @param  enc Name of character encoding
	 * @see    #getEncoding()
	 */
	public void setEncoding(String enc);
	
	/**
   * Gets the current accessibility type of this log.
   * @return Effective severity
   * @return Effective severity if set or
   *         {@link Log#LOG_ACCESSABILITY_TYPE_NORMAL_LOG}
   * 				 {@link Log#LOG_ACCESSABILITY_TYPE_LOCAL_LOG}
   * 				 {@link Log#LOG_ACCESSABILITY_TYPE_PRIVATE_LOG}.
   */
  public int getLogTypeAccessibility() ;

  /**
   * Sets the effective severity of this log.
   * @param  severity New effective severity
   */
  public void setLogTypeAccessibility(int value) ;
	
	/**
	 * This method returns the number that indicates
	 * how many LogRecords have been written so far.
	 * This does not take into account how many LogRecords were there in the file
	 * before the current session has started.
	 * Therefore, please note that this number deals with the number of LogRecords
	 * that have been written in the current session.
	 * @return int Number of LogRecords written so far in the current session.
	 */
	public int getNumberOfLogRecordsWritten();

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
  public boolean beLogged(int severity);

	/**
   * Gets the filters that control writing of messages via this log.
   * @return Unmodifiable collection of filters associated with this log
   */
  public Collection getFilters();

  /**
   * Adds another filter that controls writing of messages via this log.
   * The results of all filters for a given message are logically
   * <em>and</em>ed to determine whether a message is to be written.
   * @param  filter New filter
   */
  public void addFilter(Filter filter);

  /**
   * Removes a filter so that it no longer controls writing of messages via this
   * log.
   * @param  filter Filter to be removed
   */
  public void removeFilter(Filter filter);

  /**
   * Removes all filters associated with this log.
   */
  public void removeFilters();

  /**
	 * Flushes buffered records in this log object.
	 */
	public void flush();
	
	/**
   * Checks whether this log flushes its output stream after each log message.
   * Automatic flushing is switched on in a new log.
   * @return <code>true</code> if and only if this log flushes its output stream
   *         after each log message
   * @see    #setAutoFlush(boolean)
   */
  public boolean isAutoFlush();

  /**
   * Configures this log to flush the output stream after each log message.
   * Automatic flushing is switched on in a new log.
   * @param  autoFlush
   * @see    #isAutoFlush()
   */
  public void setAutoFlush(boolean autoFlush);

  /**
   * Closes output of this log object.
   */
  public void close();
  
  /**
	 * Check is this log closed.
	 */
	public boolean isClosed();
	 
  /**
	 * Open output of this log object.
	 */
	public void open();
	
	/**
	 * Check is this log opened.
	 */
	public boolean isOpened();
	
	/**
	 * Status of this log object.
	 */
	public int status();
	
}
