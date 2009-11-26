
package com.sap.tc.logging.reader;

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

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

import com.sap.tc.logging.FileLogInfoData;
import com.sap.tc.logging.HelperLib;
import com.sap.tc.logging.Severity;
import com.sap.tc.logging.MSGCollection;
import com.sap.tc.logging.interfaces.IFileSetLog;
import com.sap.tc.logging.exceptions.FileOpenException;
import com.sap.tc.logging.exceptions.FileDataException;

public abstract class ReadFileSetLog 	extends    ReadLog
																			implements IFileSetLog 
{
	//================================================ declaration > ====
		private static String strLoc = "ReadFileSetLog";
	
		private static final int 	MODE_MIN 	 			 		= 0; 
		public 	static final int 	MODE_SINGLE_FILE 		= MODE_MIN + 1;
		public 	static final int 	MODE_FILE_SET 	 		= MODE_SINGLE_FILE + 1; 
		private static final int 	MODE_MAX 				 		= MODE_FILE_SET + 1;
	
		private String 	fileName;
		
		private int 		fsSize;
	  private int 		fsLimit;
	  private int 		fsIndex;
	
		private boolean isInFileSet = false;
	//==== < constructors =============================== abstarct > ====
	
	public ReadFileSetLog(String fileName) 
	{
		this.fileName = fileName;
		
		// Trying to get FileHeader info from file...
		
		// First try to get real file name.
		// In a case of the fileset, the fileName must be 
		// expanded to the real file name
		String tmpFileSet = checkForFile(fileName);
	
		try {
			// Then, try to get FileHeader info.
			FileLogInfoData fileHeader = new FileLogInfoData(tmpFileSet);
			
			this.fsSize 	= fileHeader.getFileSetSize();
			this.fsLimit 	= fileHeader.getFileSetLimit();
				
			setPattern(fileName);
			
			// This trick is used to allow opening file form 
			// fileset like single file but with possibility 
			// to change reading mode.
			if (!fileName.equalsIgnoreCase(tmpFileSet)) {
				// Init file set
				moveToEOFS();
				setMode(MODE_FILE_SET);
			}
			else {
				setSource(HelperLib.expandPattern(getPattern(), 0, false, false));
			}
		}
		catch (Exception ex) {
			// Writing message about this task
			ReaderLogger
				.logIntByAPI(Severity.WARNING,
										 ReaderLogger.ReaderLocation,
										 strLoc,
										 MSGCollection.LOGGING_MSG_ID_UNEXPECTED,
										 MSGCollection.LOGGING_MSG_STR_UNEXPECTED,
										 new String[] {fileName});
			ReaderLogger.catchingIntByAPI(ex);											  
		}	
	}
	
	public ReadFileSetLog(String fileName, int size, int limit)
	{
		this.fileName = fileName;
		this.fsSize 	= size;
		this.fsLimit	= limit;
		
		this.isInFileSet = (this.fsSize > 0);
			
		setPattern(fileName);
		
		if (isInFileSet()) {
			// Init file set
			moveToEOFS();
			setMode(MODE_FILE_SET);
		}
		else {
			setSource(HelperLib.expandPattern(getPattern(), 0, false, false));
		}
	}
	
	//==== < abstract ===================================== public > ====
	
  /**
	 * Gets the current file in 
	 * rotating file set
	 * @return java.io.File 
	 */
  public synchronized File getFile() {
	  return new File(expandPattern());
  }

  /**
	 * Gets the file from rotating fileset 
	 * on given position (index). 
	 * @return java.io.File 
	 */
  public synchronized File getFile(int index)  {
  	// Guardian
  	if (index < 0 || index >= getSize()) {
  		return getFile();
  	}
		return new File(expandPattern(index));
  }

  /**
   * Gets the latest (newest) file from the rotating fileset. 
   * @return java.io.File 
   */
  public File getFileLatest() {
		return new File(expandPattern(findEndIndex()));
  }

  /**
   * Gets the prime (oldest) file from the rotating fileset. 
   * @return java.io.File 
   */
  public File getFilePrime(){
		return new File(expandPattern(findStartIndex()));
  }

  /**
	 * Gets the current file index in 
	 * rotating file set
	 * @return Limit file size
	 */
  public synchronized int getIndex() {
	  return fsIndex;
  }
 
  /**
	 * Sets the current file index in 
	 * rotating file set
	 */
	public synchronized void setIndex(int value) {
		this.fsIndex = value;
		setSource(expandPattern());
	}

	/**
	 * Sets the limit file size used for 
	 * sequencing on the rotating output file
	 * @return Limit file size
	 */
	public synchronized void setLimit(int value) {
		this.fsLimit = value;
	}

  /**
	 * Gets the limit file size used for 
	 * sequencing on the rotating output file
	 * @return Limit file size
	 */
  public synchronized int getLimit() {
	  return fsLimit;
  }

  /**
   * Sets the size of rotating fileset, number of
   * files in fileset.
   * @return Number of files in rotating fileset.
   */
  public synchronized void setSize(int value) {
  	this.fsSize = value;
  }

	/**
   * Gets the size of rotating fileset, number of
   * files in fileset.
   * @return Number of files in rotating fileset.
   */
  public synchronized int getSize() {
	  return fsSize;
  }

  /**
	 * Check is the file in rotating file set
	 * @return true if file is part of fileset
	 */
  public synchronized boolean isInFileSet() {
	  return isInFileSet;
  }

  /**
	 * Helper method. Same like (getMode() == MODE_FILE_SET)
	 * Is this Log in FileSet Mode
	 */
	public boolean isInFileSetMode() {
		return (getMode() == MODE_FILE_SET);
  }

	/**
	 * Helper method. Same like (getMode() == MODE_SINGLE_FILE)
	 * Is this Log in SingleFile Mode
	 */
  public boolean isInSingleFileMode() {
		return (getMode() == MODE_SINGLE_FILE);
  }

  /**
	 * Move rotating fileset index to the oldest File in the fileset 
	 */
  public synchronized void moveToBOFS() {
	  setIndex(findStartIndex());
  }
  
  /**
	 * Move rotating fileset index to the newest File in the fileset 
	 */
  public synchronized void moveToEOFS() {
		setIndex(findEndIndex());
  }

  /**
	 * Move rotating fileset index to next position.
	 * Next position is the file in the fileset where
	 * current file last modified date value < next file last modified date value
	 */
  public synchronized void next() {
		if (!isEnd() && isInFileSetMode()) {
	  	setIndex(findNextIndex());
		}
  }

  /**
	 * Move rotating fileset index to previous position.
	 * Previous position is the file in the fileset where
	 * current file last modified date value > previous file last modified date value
	 */
  public synchronized void previous() {
		if (!isStart() && isInFileSetMode()) {
			setIndex(findPreviousIndex());
		}
  }

	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	
	// Find the next file index in the fileset
	private int findNextIndex() {
      int tmpIndex = getIndex() + 1;
      if (tmpIndex == getSize()) {
        return 0;
      } else {
        return tmpIndex;
      }
	}
	
	// Find the previous file index in the fileset
	private int findPreviousIndex() {
      int tmpIndex = getIndex() - 1;
      if (tmpIndex < 0) {
        return (getSize() - 1);
      } else {
        return tmpIndex;
      }
	}
	
	// Find the oldest file index in the fileset
	private int findStartIndex() {
	  
	  int oldestIndex	= getIndex();
	  
	  if (isInFileSet()) {
	  	
	  	long 	oldestDate 		= Long.MAX_VALUE;
	  	File 	file 					= null;

		  for (int i = getSize() - 1; i >= 0; i--) {
			  file = new File(expandPattern(i));
			  if(file.exists()) {
				  if(file.lastModified() <= oldestDate) {
					  oldestDate = file.lastModified();
					  oldestIndex = i;
				  } 
				  else {
					  break;
				  }
			  }
		  }	
	  }
	  return oldestIndex;
  }
	
	// Find the newest file index in the fileset
  private int findEndIndex() {
	  
	  int latestIndex	= getIndex();
	  
	  if (isInFileSet()) {
	
		  long 	latestDate 		= 0;
		  File 	file 					= null;
		
		  for (int i = 0; i < getSize(); i++) {
			  file = new File(this.expandPattern(i));
			  if(file.exists()) {
				  if(file.lastModified() >= latestDate) {
					  latestDate = file.lastModified();
					  latestIndex = i;
				  } 
				  else {
					  break;
				  }
			  }
		  }				
	  }
	  return latestIndex;
  }
	
  public boolean isStart() {
	  return getIndex() == findStartIndex();
  }

  public boolean isEnd() {
	  return getIndex() == findEndIndex();
  }
	
  private String checkForFile(String fileName) {
		
	  String 	tmpFileName 	= fileName;
	  boolean isFileExists 	= false;

	  // Check for the file existence in the file system
	  File file = new File(fileName);

	  if (!(isFileExists = file.exists())) {
			
		  // Try to convert file to the FileSet item and check for existence
		  for (int i = 0; i < 10; i++) {
			  tmpFileName = expandPattern(fileName, i);
			  file = new File(tmpFileName);
			  if (isFileExists = file.exists()) {
			  	this.isInFileSet = true;
				  break;
			  } 
		  }
	  }
	
	  if (!isFileExists) {
		  // There is no such file in file system...
		  //throw new FileOpenException(fileName, new FileNotFoundException(fileName));
			tmpFileName = fileName;
	  }
	
	  return tmpFileName;
  }
	
	
	private String expandPattern()
	{
		return HelperLib.expandPattern(this.fileName, this.fsIndex, this.isInFileSet, false);
	}
	
	private String expandPattern(String fileName, int index)
	{
		return HelperLib.expandPattern(fileName, index, true, false);
	}
	
	private String expandPattern(int index)
	{
		return HelperLib.expandPattern(this.fileName, index, this.isInFileSet, false);
	}
	
	private String expandPattern(int fileIndex, boolean onlyNewFormat)
	{
		return HelperLib.expandPattern(this.fileName, this.fsIndex, this.isInFileSet, onlyNewFormat);
	}
	
	//==== < private ================================== deprecated > ====
	
}
