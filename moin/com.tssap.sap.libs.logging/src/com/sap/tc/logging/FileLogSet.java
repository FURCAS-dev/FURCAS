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
 * @version      $Id:$
 */
 
/**
 * FileLog rotating set
 */

import java.io.*;
import java.util.*;

import com.sap.tc.logging.*;

public class FileLogSet {
	// $JL-EXC$
	//================================================ declaration > ====
	public static final int DEF_LIMIT = 1000000;
	public static final int NO_LIMIT 	= 0;
	public static final int NO_CNT 	 	= 0;
	
	private static final int 	MODE_MIN 	 				= 0; 
	public  static final int 	MODE_SINGLE_FILE 	= MODE_MIN + 1;
	public  static final int 	MODE_FILE_SET 	 	= MODE_SINGLE_FILE + 1; 
	private static final int 	MODE_MAX					= MODE_FILE_SET + 1;
	
	private static final int 	POS_MIN 	 				= 0; 
	public  static final int 	POS_START 				= POS_MIN + 1;
	public  static final int 	POS_CURRENT 			= POS_START + 1;
	public  static final int 	POS_END 	 				= POS_CURRENT + 1; 
	private static final int 	POS_MAX						= POS_END + 1;
	
	
	private String 	filePattern;
	private String 	filePatternFile;
	private String 	filePatternPath;
	private String 	fileLog;
	private String 	fileLogFile;
	private String 	fileLogPath;
	private int 		fsSize;
	private int 		fsLimit;
	private int 		fsIndex 										= -1;
	private int 		fsIndexStart;
	private int 		fsMode											= MODE_SINGLE_FILE;
	private boolean isPartOfFileSet 						= false;
	
	//==== < declaration ============================ constructors > ====
	
	public FileLogSet(String pattern, 
										String logPath, 
										int index, 
										int size, 
										int limit) {
											
		buildPattern 	(pattern);
		buildLog 			(logPath);
		this.fsIndex			= index;
		this.fsIndexStart	= index;
		initFileSet(size, limit);
	}
	
	private FileLogSet() 
	{
	}
	
	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====

	public String getName(){
	  return buildFinallSource();
  }
	  
	public String getPattern(){
	  if (fsMode == MODE_FILE_SET) {
	  	if (getLogPath().length() > 0) {
		  	return getLogPath() + File.separator + getPatternFile();
	  	}
	  	return getPatternFile();
	  }
	  else {
			return getLog();
	  }
  }
  
  public String getPatternFile(){
		if (filePatternFile != null) {
			return filePatternFile;
		}
		return Formatter.EMPTY_STRING;
	}
	
	public String getPatternPath(){
	  if (filePatternFile != null) {
		  return filePatternFile;
	  }
	  return Formatter.EMPTY_STRING;
  }
	
  public String getSource(){
		return getSource(POS_CURRENT);
	}
	
	public String getSource(int pos){
		if (isPartOfFileSet()) {
			switch (pos) {
				case POS_START:
					return expandPattern(findStartIndex(), false);
				case POS_END:
					return expandPattern(findEndIndex(), false);
				default :
			}
			return expandPattern(getIndex(), false);
		}
		else  {
			return getLog();
		}
	}
	
	public int getSize() {
		return this.fsSize;
	}
	
	public int getLimit() {
		return this.fsLimit;
	}
	
	public int getIndex() {
		return this.fsIndex;
	}

	public void moveToStart() {
		setIndex(findStartIndex());			
	}
	
	public void moveToEnd() {
		setIndex(findEndIndex());
	}
	
	public boolean isStart() {
		return getIndex() == findStartIndex();
	}
	
	public boolean isEnd() {
		return getIndex() == findEndIndex();
	}
	
	public void next() {
		if (!isEnd() && isPartOfFileSet()) {
			fsIndex = findNextIndex();
			//fsIndex = (fsIndex + 1) % fsSize;
		} 
	}

	public void previous() {
		if (!isStart() && isPartOfFileSet()) {
			fsIndex = findPreviousIndex();
		} 
	}
		
	public synchronized void reset() {
		this.fsIndex = 0;
	}
	
	/**
	 * Get current working mode of the FileLog
	 * 
	 * return 
	 * 0 == FileLog.MODE_FILE_SET
	 * 1 == FileLog.MODE_SINGLE_FILE
	 */
	public synchronized int getMode(){
		return fsMode;
	}

	/**
	 * Set current working mode of the FileLog
	 * 
	 * mode  
	 * 1 == FileLog.MODE_FILE_SET
	 * 2 == FileLog.MODE_SINGLE_FILE
	 */
	public synchronized void setMode(int mode){
		if (isPartOfFileSet() && (mode > MODE_MIN && mode < MODE_MAX)) {
			this.fsMode = mode;
			if (mode == MODE_FILE_SET) {
				this.fsIndex 			= findStartIndex();
			}
		}
		else {
			this.fsMode = MODE_SINGLE_FILE;
			this.fsIndex = fsIndexStart;
		}
	}

	/**
	 * Does this Log support FileSet Mode
	 */
	public boolean isPartOfFileSet() {
		return isPartOfFileSet;
	}
	
	/**
	 * Helper method. Same like (getMode() == MODE_FILE_SET)
	 * Is this Log in FileSet Mode
	 */
	public boolean isInFileSetMode() {
		return (this.fsMode == MODE_FILE_SET);
	}
	
	/**
	 * Helper method. Same like (getMode() == MODE_SINGLE_FILE)
	 * Is this Log in SingleFile Mode
	 */
	public boolean isInSingleFileMode() {
		return (this.fsMode == MODE_SINGLE_FILE);
	}
	
	public static String buildFileFromPattern(String pattern, int index) {
		return new FileLogSet().expandPattern(pattern, index, true, true);
	}
	
	//==== < public ==================================== protected > ====
	
	protected synchronized void setIndex(int value) {
		if (value < 0 || value > fsSize) {
			value = fsSize;
		}
		this.fsIndex = value;
	}

	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	
	private String getLog(){
		if (fileLog != null) {
			return fileLog;
		}
		return Formatter.EMPTY_STRING;
	}

	private String getLogPath(){
	  if (fileLogPath != null) {
		  return fileLogPath;
	  }
	  return Formatter.EMPTY_STRING;
  }

  private String getLogFile(){
		if (fileLogFile != null) {
			return fileLogFile;
		}
		return Formatter.EMPTY_STRING;
	}
	
	private void initFileSet(int size, int limit)
	{
		if(size	 < 1)  size  = NO_CNT;
		if(limit < 1)  limit = NO_LIMIT; 

		// Killing the FileSet
		if(size == NO_CNT || limit == NO_LIMIT) {
			limit = DEF_LIMIT; 
			size	= NO_CNT;
			setIndex(0);
		}
	
		this.fsSize 					= size;
		this.fsLimit 					= limit;
		
		// Check for file name ...
		String origFile  = getLog();
		String buildFile = expandPattern(buildFinallSource(), true, false);
		
		this.isPartOfFileSet = (size > NO_CNT && origFile.equalsIgnoreCase(buildFile));
	}

	private String expandPattern(int fileIndex, boolean onlyNewFormat)
	{
		return expandPattern(buildFinallSource(), fileIndex, isPartOfFileSet(), onlyNewFormat);
	}
	
	private String expandPattern(String filePattern,  boolean isRotate, boolean onlyNewFormat)
	{
		return expandPattern(filePattern, getIndex(), isRotate, onlyNewFormat);
	}
	
	//Same as original expandPattern(), but taking an integer value to
	//make is flexible for reader side to perform same pattern resolving task
	//on output file with any sequence number
	private String expandPattern(String filePattern, int fileCount, boolean isRotate, boolean onlyNewFormat)
	{
		StringBuffer buf 				= new StringBuffer(filePattern);
		int patternLen 					= filePattern.length();
		boolean numberInserted 	= false;
	
		for(int i = 0; i < patternLen; ++i) {
			String replacement;
	
		  switch(buf.charAt(i)) {
				case '%':
					switch(buf.charAt(i + 1)) {
						case 'g':
						  replacement = Integer.toString(fileCount);
						  buf.replace(i, i + 2, replacement);
						  i += (replacement.length() - 1);
							patternLen += (replacement.length() - 2);
						  numberInserted = true;
						  break;
						case 'h':
							replacement = System.getProperty("user.home");
							buf.replace(i, i + 2, replacement);
							i += (replacement.length() - 1);
							patternLen += (replacement.length() - 2);
							break;
						case 't':
						  try {
							  replacement = System.getProperty("java.io.tmpdir");
						  }
						  catch(SecurityException sE) {
							  try {
								  File file = File.createTempFile("tmp", null);
	
								  replacement = file.getPath();
								  file.delete();
								  replacement = replacement.substring(0, replacement.lastIndexOf(File.separator));
							  }
							  catch(IOException ioE) {
								  replacement = "";
							  }
							}
						  buf.replace(i, i + 2, replacement);
						  i += (replacement.length() - 1);
							patternLen += (replacement.length() - 2);
						  break;
					  case 'u':
						  replacement = new GUId().toString().replace(':', '_');
						  buf.replace(i, i + 2, replacement);
						  i += (replacement.length() - 1);
							patternLen += (replacement.length() - 2);
						  break;
					  case '%':
						  buf.replace(i, i + 2, "%");
						  --patternLen;
						  break;
				  }
				  break;
			  case '/':
				  replacement = File.separator;
				  buf.replace(i, i + 1, replacement);
				  i += (replacement.length() - 1);
				patternLen += (replacement.length() - 1);
				  break;
		  }
	  }

	  if(!isRotate || numberInserted) {
		  return buf.toString();
	  }
	  else {
		return createFileName(buf.toString(), "." + fileCount, onlyNewFormat);
	  }
	}
	
	private String createFileName(String filePattern, String append, boolean onlyNewFormat){
		
		StringBuffer newPattern = new StringBuffer();
		StringBuffer tmpPattern = new StringBuffer();
	
		File 		file 		 		= new File(filePattern);
		String 	fileFolder 	= file.getParent();
		String 	fileName 		= file.getName();
	
		if (fileFolder != null) {
			newPattern.append(fileFolder);
			newPattern.append(File.separator);
		}
	
		int pos = fileName.indexOf(".");
	
		// Create a new file using the new file name format
		if (pos > 0) {
			tmpPattern.append(fileName.substring(0, pos));			
			tmpPattern.append(append);
			tmpPattern.append(fileName.substring(pos));
		}
		else {
			tmpPattern.append(fileName);			
			tmpPattern.append(append);
			tmpPattern.append(".log");
		}
	
		if (!onlyNewFormat) { // Backward compatibility with format : filename.ext.0
		
			String tmpFileName = newPattern.toString() + tmpPattern.toString();
		
			// If the file with new format is not there and 
			// this pattern resolving proc is for reading (onlyNewFormat == false)
			// then return old pattern format
			if (!new File(tmpFileName).exists()) {
			
				tmpPattern = new StringBuffer();
			
				if (pos > 0) {
					tmpPattern.append(fileName);			
					tmpPattern.append(append);
				}
				else {
					tmpPattern.append(fileName);			
					tmpPattern.append(".log");
					tmpPattern.append(append);
				}
			}
		}
	
		newPattern.append(tmpPattern.toString());
	
		return newPattern.toString();
	}
	
	private int findStartIndex() {
		int oldestIndex	= getIndex();
		if (isPartOfFileSet()) {
			long 	oldestDate 		= Long.MAX_VALUE;
			File 	file 					= null;
	
			for (int i = getSize() - 1; i >= 0; i--) {
				file = new File(expandPattern(i, true));
				if(file.exists()) {
					if(file.lastModified() < oldestDate) {
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
	
	private int findEndIndex() {
		int latestIndex	= getIndex();
		if (isPartOfFileSet()) {
			long 	latestDate 		= 0;
			File 	file 					= null;
			
			for (int i = 0; i < getSize(); i++) {
				file = new File(this.expandPattern(i, true));
				if(file.exists()) {
					if(file.lastModified() > latestDate) {
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

	private int findNextIndex() {
		
		File 	file 			= null;
		long 	currDate 	= Long.MAX_VALUE;
		long  lastDate  = 0;
		
		// Get current data
		file = new File(expandPattern(getIndex(), true));
		if(file.exists()) {
			currDate = file.lastModified();
			lastDate = currDate;
		}
		
		int tmpIndex	= getIndex();
		
		while (lastDate <= currDate) {
			tmpIndex = (tmpIndex + 1) % getSize();
			if (tmpIndex == getIndex()) break;
			file = new File(expandPattern(tmpIndex, true));
			if(file.exists()) {
				lastDate = file.lastModified();
			}
		}
		
		return tmpIndex;
	}
	
	private int findPreviousIndex() {
		
		File 	file 			= null;
		long 	currDate 	= Long.MAX_VALUE;
		long  prevDate  = 0;
		
		// Get current data
		file = new File(expandPattern(getIndex(), true));
		if(file.exists()) {
			currDate = file.lastModified();
			prevDate = currDate;
		}
		
		int tmpIndex	= getIndex();
		
		while (prevDate >= currDate) {
			if (tmpIndex == 0) {
				tmpIndex = (getSize() - 1);
			}
			else {
				tmpIndex = (tmpIndex - 1);
			}
			if (tmpIndex == getIndex()) break;
			file = new File(expandPattern(tmpIndex, true));
			if(file.exists()) {
				prevDate = file.lastModified();
			}
		}
		
		return tmpIndex;
	}
	
	
	private String buildFinallSource()
 	{
		if (fileLogPath != null && fileLogPath.length() > 0) {
			return fileLogPath + File.separator + filePatternFile;
		}
		return filePatternFile;
  }
	
  private void buildPattern(String value){
	  if (value != null) {
		  File file = new File(value);
			this.filePatternFile = file.getName();
			this.filePatternPath = file.getParent();
	  }
	  this.filePattern = value;
  }

  private void buildLog(String value){
	  if (value != null) {
		  File file = new File(value);
			this.fileLogFile		= file.getName();
			this.fileLogPath  = file.getParent();
	  }
		this.fileLog = value;;
  }
	
	
	//==== < private ================================== deprecated > ====

}

