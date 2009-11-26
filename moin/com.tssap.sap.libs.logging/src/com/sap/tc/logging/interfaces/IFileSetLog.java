package com.sap.tc.logging.interfaces;

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

import java.io.*;

public interface IFileSetLog {
	  
	/**
   * Gets the limit file size used for 
   * sequencing on the rotating output file
   * @return Limit file size
   */
  public int getLimit();

  /**
	 * Sets the limit file size used for 
	 * sequencing on the rotating output file
	 * @return Limit file size
	 */
	public void setLimit(int value);
		
	/**
	 * Gets the size of rotating fileset, number of
	 * files in fileset.
	 * @return Number of files in rotating fileset.
	 */
	public int getSize();
	
	/**
	 * Sets the size of rotating fileset, number of
	 * files in fileset.
	 * @return Number of files in rotating fileset.
	 */
	public void setSize(int value);
	
	/**
	 * Gets the current file index in 
	 * rotating file set
	 * @return Limit file size
	 */
	public int getIndex();

	/**
	 * Sets the current file index in 
	 * rotating file set
	 */
	public void setIndex(int value);

	/**
	 * Check is the file in rotating file set
	 * @return true if file is part of fileset
	 */
	public boolean isInFileSet();

	/**
	 * Gets the current file in 
	 * rotating file set
	 * @return java.io.File 
	 */
	public File getFile();
	
	/**
	 * Gets the file from rotating fileset 
	 * on given position (index). 
	 * @return java.io.File 
	 */
	public File getFile(int index);
	
	/**
	 * Gets the latest (newest) file from the rotating fileset. 
	 * @return java.io.File 
	 */
	public File getFileLatest();
	
	/**
	 * Gets the prime (oldest) file from the rotating fileset. 
	 * @return java.io.File 
	 */
	public File getFilePrime();
	
	/**
	 * Move rotating fileset index to next position.
	 */
	public void next();
	
	/**
	 * Move rotating fileset index to previous position.
	 */
	public void previous();
	
	/**
	 * Move rotating fileset index to the beginning of the fileset 
	 */
	public void moveToBOFS();
	
	/**
	 * Move rotating fileset index to the end of the fileset 
	 */
	public void moveToEOFS();

}
