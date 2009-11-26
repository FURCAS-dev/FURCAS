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
 
public interface IFileLog extends ILog {

	/**
	 * Checks whether this file log writes messages to the end of the specified
	 * file rather than the beginning.
	 * @return <code>true</code> if and only if this file log writes messages to
	 *         the end of the specified file rather than the beginning
	 */
	public boolean isAppend();
		
	/**
	* Gets the file name pattern of this file log.
	* @return File name pattern
	*/
	public String getPattern();
	
	/**
	 * Gets the current file name represented by this FileLog. 
	 * Cann be null;
	 * @return The file name
	 */
	public String getFileName();
			
	/**
	 * Returns the length of the file(s).
	 * @return     the length of this file, measured in bytes.
   * @exception  IOException  if an I/O error occurs.
	 */
	public long getFileLength();
	
	/**
   * Gets the limit file size used for 
   * sequencing on the rotating output file
   * @return Limit file size
   */
	 public int getLimit();

	/**
	 * Gets the max count number of rotating fileset
	 * @return Number of files in rotating fileset.
	 */
	public int getCnt();
	
	/**
	 * Returns the pathname string of the current file
	 * this FileLog object represent.
	 *
	 * @return The pathname
	 */
	public String getPath();
		
	/**
	 * Returns the pathname string of this FileLog object's pattern's parent, or
	 * <code>null</code> if the pattern does not expand to a pathname 
	 * that has a parent directory.
	 *
	 * @return The parent pathname
	 */
	public String getParent();
	
}
