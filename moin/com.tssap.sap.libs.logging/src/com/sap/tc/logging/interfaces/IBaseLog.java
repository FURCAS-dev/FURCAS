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
import com.sap.tc.logging.exceptions.OpenException;
import com.sap.tc.logging.exceptions.CloseException;

public interface IBaseLog extends IObjectInfo, Cloneable {
	
	/**
	 * Gets the name pattern of this file log.
	 * @return Name pattern
	 * @see 	 #setPattern(java.lang.String)
	 */
	public String getPattern();
	
	/**
	 * Sets the name pattern of this log.
	 */
	public void setPattern(String value);
	
	/**
	 * Gets the source name of this file log.
	 * @return Source name
	 * @see 	 #setSource(java.lang.String)
	 */
	public String getSource();

	/**
	 * Sets the source name of this log.
	 * Source name represent a source where messages
	 * will be written, or from where messages will be read.
	 * Full source name will be built based on given pattern.
	 * @see #setPattern(java.lang.String)
	 */
	public void setSource(String value);
	
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
   * @param  formatter - Formatter instance. 
   * if formatter == null, default ListFormatter() will be created! 
   */
  public void setFormatter(Formatter formatter);

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
	 * @return Name of character encoding. Can be null.
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
   * Adds another filter that controls messages flow via this log.
   * The results of all filters for a given message are logically
   * <em>and</em>ed to determine whether a message is to be processed.
   * @param  filter New filter
   */
  public void addFilter(IFilter filter);

  /**
   * Removes a filter so that it no longer controls messages flow via this
   * log.
   * @param  filter Filter to be removed
   */
  public void removeFilter(IFilter filter);
	  
  /**
   * Gets the filter that control messages flow via this log.
   * @return Instance of IFilter stored on given position / index
   */
  public IFilter getFilter(int index);
	  
	/**
	 * Gets the filters that control messages flow via this log.
	 * @return Unmodifiable collection of filters associated with this log
	 */
	public Collection getFilters();

  /**
   * Removes all filters associated with this log.
   */
  public void removeFilters();

  /**
   * Closes this log object.
   */
  public void close()throws CloseException;;
	 
  /**
	 * Open this log object.
	 */
	public void open() throws OpenException;;
	
	/**
	 * Check is this log closed.
	 */
	public boolean isClosed();
	
	/**
	 * Check is this log opened.
	 */
	public boolean isOpened();
	
	/**
	 * Status of this log object.
	 */
	public int status();
	
	/**
	 * Get current working mode
	 */
	public int getMode();
		
	/**
	 * Set current working mode.
	 */
	public void setMode(int mode);
	
}
