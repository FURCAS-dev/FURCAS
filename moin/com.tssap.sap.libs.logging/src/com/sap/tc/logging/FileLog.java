package com.sap.tc.logging;

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
 */

import java.io.*;
import java.security.*;
import java.text.*;
import java.util.*;
 
import com.sap.tc.logging.interfaces.*;

/**
 * Writes log records to files.
 */

public class   		FileLog 
			 extends 		StreamLog
			 implements IFileLog
{ //$JL-EQUALS$ $JL-EXC$
	//================================================ declaration > ====
	 
	private static String subLoc = "FileLog";
	
	public static final int DEF_LIMIT = Integer.MAX_VALUE;
	public static final int NO_LIMIT 	= 0;
	public static final int NO_CNT 	 	= 0;
	
	public static final int 	MODE_MIN 	 			 = 0; 
	public static final int 	MODE_SINGLE_FILE = MODE_MIN + 1;
	public static final int 	MODE_FILE_SET 	 = MODE_SINGLE_FILE + 1; 
	public static final int 	MODE_MAX 				 = MODE_FILE_SET + 1;
	
  private static final String EOL 						= System.getProperty("line.separator");
	private static final String NO_PATTERN_EMSG = "No pattern!";
	
	private static final int NO_PERMISSION_REPEAT = 1000;
	
	private String 	logPattern;	
	private String  logFileNamePattern;
	private String  logFilePathPattern;					
	private String 	parent;
	private File 		parentFile;
	private boolean append 									= true;
	private int 		limit										= DEF_LIMIT;
	private int 		cnt;
	private int 		number;
	private int     mode										= MODE_SINGLE_FILE;
	
	private int		  fileNotFoundCnt 				= 0;
	private int 		noPermissionCnt 				= 0;
	
	private static final byte FIND_FILE_FLAG = 0x01;
	private byte flags = 0x00;
    
	//==== < declaration ============================ constructors > ====
	 
	/**
	 * Configures this file log for writing to a single file. The name of the file
	 * can be given using a pattern with a number of place holders:
	 * <ul>
	 *   <li><code>/</code> the local file name separator</li>
	 *   <li><code>%h</code> the home directory</li>
	 *   <li><code>%t</code> the system temporary directory</li>
	 *   <li><code>%u</code> a unique number to make the file name unique</li>
	 *   <li><code>%%</code> the percentage sign</li>
	 * </ul>
	 * If the file exists messages are append to the end of the file.
	 * @param  pattern File name pattern
	 * @see    #FileLog(java.lang.String,
	 *                  int,
	 *                  int)
	 */
	public FileLog(String pattern)
	{
		this(pattern, new ListFormatter(), true);
	}

	/**
	 * Same as
	 * {@link #FileLog(java.lang.String)}
	 * but configures for writing with a custom appending logic. If the specified
	 * file exists but the second argument is <code>false</code> file content will
	 * be deleted before writing.
	 * @param  pattern File name pattern
	 * @param  append  If <code>false</code> file content will be deleted before
	 *                 writing
	 */
	public FileLog(String 	pattern, 
								 boolean 	append)
	{
    this(pattern, new ListFormatter(), append);
	}

	/**
	 * Same as
	 * {@link #FileLog(java.lang.String)}
	 * but configures for writing with a custom formatter.
	 * @param  pattern   File name pattern
	 * @param  formatter Formatter
	 * @see    #FileLog(java.lang.String,
	 *                  int,
	 *                  int,
	 *                  Formatter)
	 */
	public FileLog(String 		pattern, 
								 Formatter 	formatter)
	{
		this(pattern, formatter, true);
	}

	/**
	 * Same as
	 * {@link #FileLog(java.lang.String)}
	 * but configures for writing with a custom formatter and appending logic. If
	 * the specified file exists but the third argument is <code>false</code> file
	 * content will be deleted before writing.
	 * @param  pattern   File name pattern
	 * @param  formatter Formatter
	 * @param  append    If <code>false</code> file content will be deleted before
	 *                   writing
	 */
	public FileLog(String 		pattern, 
								 Formatter 	formatter, 
								 boolean 		append)
	{
    super(formatter);
    init(pattern, DEF_LIMIT, NO_CNT);
    this.append = append;
	}

	/**
	 * Same as
	 * {@link #FileLog(java.lang.String)}
	 * but configures for writing with a custom character encoding.
	 * @param  pattern File name pattern
	 * @param  enc     Name of character encoding
	 * @throws UnsupportedEncodingException Character encoding not supported
	 * @see    #FileLog(java.lang.String,
	 *                  java.lang.String,
	 *                  int,
	 *                  int)
	 */
	public FileLog(String pattern, 
								 String enc) throws UnsupportedEncodingException
	{
		this(pattern, enc, new ListFormatter(), true);
	}

	/**
	 * Same as
	 * {@link #FileLog(java.lang.String)}
	 * but configures for writing with a custom character encoding and appending
	 * logic. If the specified file exists but the third argument is
	 * <code>false</code> file content will be deleted before writing.
	 * @param  pattern File name pattern
	 * @param  enc     Name of character encoding
	 * @param  append  If <code>false</code> file content will be deleted before
	 *                 writing
	 * @throws UnsupportedEncodingException Character encoding not supported
	 */
	public FileLog(String 	pattern, 
								 String 	enc, 
								 boolean 	append) throws UnsupportedEncodingException
	{
		this(pattern, enc, new ListFormatter(), append);
	}

	/**
	 * Same as
	 * {@link #FileLog(java.lang.String)}
	 * but configures for writing with a custom formatter and character encoding.
	 * @param  pattern   File name pattern
	 * @param  enc       Name of character encoding
	 * @param  formatter Formatter
	 * @throws UnsupportedEncodingException Character encoding not supported
	 * @see    #FileLog(java.lang.String,
	 *                  java.lang.String,
	 *                  int,
	 *                  int)
	 */
	public FileLog(String 		pattern, 
								 String 		enc, 
								 Formatter 	formatter) throws UnsupportedEncodingException
	{
		this(pattern, enc, formatter, true);
	}

	/**
	 * Same as
	 * {@link #FileLog(java.lang.String)}
	 * but configures for writing with a custom character encoding, formatter and
	 * appending logic. If the specified file exists but the fourth argument is
	 * <code>false</code> file content will be deleted before writing.
	 * @param  pattern   File name pattern
	 * @param  enc       Name of character encoding
	 * @param  formatter Formatter
	 * @param  append    If <code>false</code> file content will be deleted before
	 *                   writing
	 * @throws UnsupportedEncodingException Character encoding not supported
	 */
	public FileLog(String 		pattern, 
								 String 		enc, 
								 Formatter 	formatter, 
								 boolean 		append) throws UnsupportedEncodingException
	{
		super(formatter);
		
		setEncoding(enc);
		
		init(pattern, DEF_LIMIT, NO_CNT);
		
		this.append = append;
	}

	/**
	 * Configures this file log for writing to a rotating set of numbered files.
	 * Each file has a limit on its size, and there is a maximum number of files
	 * in the set. In addition to the placeholders supported by the single file
	 * constructor, <code>%g</code> can be used in the pattern where the number of
	 * the file is supposed to go.
	 * @param  pattern File name pattern
	 * @param  limit   Limit of file sizes in byte or {@link #DEF_LIMIT}
	 * @param  cnt     Maximum number of files in set or {@link #NO_CNT}
	 * @throws IllegalArgumentException Pattern or one, but not both, of
	 *                                  <code>limit</code> and <code>cnt</code>
	 *                                  unspecified
	 * @see    #FileLog(java.lang.String)
	 */
	public FileLog(String pattern, 
								 int 		limit, 
								 int 		cnt)
	{
		this(pattern, limit, cnt, new ListFormatter());
	}

	/**
	 * Same as
	 * {@link #FileLog(java.lang.String,
	 *                 int,
	 *                 int)}
	 * but configures for writing with a custom formatter.
	 * @param  pattern   File name pattern
	 * @param  limit     Limit of file sizes in byte or {@link #DEF_LIMIT}
	 * @param  cnt       Maximum number of files in set or {@link #NO_CNT}
	 * @param  formatter Formatter
	 * @throws IllegalArgumentException Pattern or one, but not both, of
	 *                                  <code>limit</code> and <code>cnt</code>
	 *                                  unspecified
	 * @see    #FileLog(java.lang.String, Formatter)
	 */
	public FileLog(String 		pattern, 
								 int 				limit, 
								 int 				cnt, 
								 Formatter 	formatter)
	{
		super(formatter);
		
		if (cnt <= 0 && limit > 0) {
			throw new IllegalArgumentException(
				MSGCollection.getMessage(MSGCollection.LOGGING_MSG_STR_ILLEGAL_ARG, 
																 new Object[] {"cnt", "" + cnt, "> 0"}));
		}
		if (limit <= 0 && cnt > 0) {
			throw new IllegalArgumentException(
				MSGCollection.getMessage(MSGCollection.LOGGING_MSG_STR_ILLEGAL_ARG, 
																 new Object[] {"limit", "" + limit, "> 0"}));
		}
		
		init(pattern, limit, cnt);
	}

	/**
	 * Same as
	 * {@link #FileLog(java.lang.String,
	 *                 int,
	 *                 int)}
	 * but configures for writing with a custom character encoding.
	 * @param  pattern File name pattern
	 * @param  enc     Name of character encoding
	 * @param  limit   Limit of file sizes in byte or {@link #DEF_LIMIT}
	 * @param  cnt     Maximum number of files in set or {@link #NO_CNT}
	 * @throws UnsupportedEncodingException Character encoding not supported
	 * @throws IllegalArgumentException     Pattern or one, but not both, of
	 *                                      <code>limit</code> and
	 *                                      <code>cnt</code> unspecified
	 * @see    #FileLog(java.lang.String,
	 *                  java.lang.String,
	 *                  int,
	 *                  int)
	 */
	public FileLog(String pattern, 
								 String enc, 
								 int 		limit, 
								 int 		cnt) throws UnsupportedEncodingException
	{
		this(pattern, enc, limit, cnt, new ListFormatter());
	}

	/**
	 * Same as
	 * {@link #FileLog(java.lang.String,
	 *                 int,
	 *                 int)}
	 * but configures for writing with a custom formatter and character encoding.
	 * @param  pattern   File name pattern
	 * @param  enc       Name of character encoding
	 * @param  limit     Limit of file sizes in byte or {@link #DEF_LIMIT}
	 * @param  cnt       Maximum number of files in set or {@link #NO_CNT}
	 * @param  formatter Formatter
	 * @throws UnsupportedEncodingException Character encoding not supported
	 * @throws IllegalArgumentException     Pattern or one, but not both, of
	 *                                      <code>limit</code> and
	 *                                      <code>cnt</code> unspecified
	 * @see    #FileLog(java.lang.String,
	 *                  java.lang.String,
	 *                  int,
	 *                  int)
	 */
	public FileLog(String 		pattern, 
								 String 		enc, 
								 int 				limit, 
								 int 				cnt, 
								 Formatter 	formatter)	throws UnsupportedEncodingException
	{
		super(formatter);
		
		if (cnt <= 0 && limit > 0) {
			throw new IllegalArgumentException(
				MSGCollection.getMessage(MSGCollection.LOGGING_MSG_STR_ILLEGAL_ARG, 
									 							 new Object[] {"cnt", "" + cnt, "> 0"}));
		}
		if (limit <= 0 && cnt > 0) { 
			throw new IllegalArgumentException(
				MSGCollection.getMessage(MSGCollection.LOGGING_MSG_STR_ILLEGAL_ARG, 
																 new Object[] {"limit", "" + limit, "> 0"}));
		}
		
		setEncoding(enc);
		
		init(pattern, limit, cnt);
	}
			
 	protected FileLog(){}
	
	private void init(String pattern, int limit, int cnt)
	{
		if (pattern == null) {
			throw new IllegalArgumentException(
				MSGCollection.getMessage(MSGCollection.LOGGING_MSG_STR_ILLEGAL_ARG, 
																 new Object[] {"pattern", "null", "<> null"}));
		}
		
		setPattern(pattern);
		setName		(pattern);
    
		setIndex(0);
		setRotation(limit, cnt);
	
		try {
			setHeader(new FileLogInfoData(this).getHeader());
		}
		catch (Exception ex) {
			// Writing message about this task
			APILogger
				.logIntByAPI(Severity.WARNING,
									subLoc + "[FileLog(...)]",
									MSGCollection.LOGGING_MSG_ID_UNEXPECTED,
									MSGCollection.LOGGING_MSG_STR_UNEXPECTED,
									new String[] {this.getName()});
			APILogger.catchingIntByAPI(ex);
			handleException(ex);													  
		}	
	}
	
	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====
	
	/**
	 * Get current working mode of the FileLog
	 * 
	 * return 
	 * 0 == FileLog.MODE_FILE_SET
	 * 1 == FileLog.MODE_SINGLE_FILE
	 */
	public synchronized int getMode(){
		return mode;
	}
	
	/**
	 * Set current working mode of the FileLog
	 * 
	 * mode  
	 * 0 == FileLog.MODE_FILE_SET
	 * 1 == FileLog.MODE_SINGLE_FILE
	 */
	public void setMode(int mode){
		int oldValue = -1,
				newValue = mode;
		synchronized (getClass()) {
			oldValue = getMode();
			if (mode > MODE_MIN && mode < MODE_MAX) {
				this.mode = mode;
			}
			else {
				this.mode = MODE_SINGLE_FILE;
			}
			newValue = this.mode;
		}
		if (oldValue != newValue) {
			APILogger.instrumentIntByAPI(subLoc + "[setMode(int mode)]", 
					MSGCollection.CONFIGURATION_IS_CHANGED(),
					new Object[] {"working mode", 
											 "FileLog",
											 this.getName(),
											 "" + oldValue, 
											 "" + newValue});
		}
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
		
		if (size() > 0 || getIndex() > 0) {
			APILogger
		   .instrumentIntByAPI(Severity.DEBUG,
							   subLoc + "[setFormatter()] " + MSGCollection.LOGGING_MSG_STR_FORMATTER_ERROR,
							   new String[] {this.getName()});
		}
		else {
			setFormatterInt(formatter);
		}
		
		if (oldValue != null) {
			APILogger.instrumentIntByAPI(subLoc + "[setFormatter()]", 
					MSGCollection.CONFIGURATION_IS_CHANGED(),
					new Object[] {"formatter", 
												"FileLog",
												this.getName(),
												oldValue, 
												getFormatter().getClass().getName()});
		}
	}
	
	public List calculateFileNames( ) {
		
		LinkedList fileNames = new LinkedList();
		
		for (int i = 0; i < this.cnt; i++) {
			fileNames.add(expandPattern(this.getPattern(), i, (mode == MODE_FILE_SET), true));
		}
		return fileNames;
	}
	
	public static Collection calculateFileNames(String filePattern, int fileCount) {
		
		LinkedList fileNames = new LinkedList();
		int i = 0;
		
		do {
			fileNames.add(new FileLog().expandPattern(filePattern, i, (fileCount > 0), true));
			i++;
		} while (i < fileCount);
		return fileNames;
	}
	
	/**
 	 * Returns the length of the file(s).
 	 * @return     the length of this file, measured in bytes.
   * @exception  IOException  if an I/O error occurs.
	 */
	public long getFileLength()
	{
		long result = 0;

		if (getCnt() == 0) {
			File file = new File(expandPattern(false));
			if(file.exists()) {
				result += file.length();
			}
		}
		else {
			for(int i = 0; i < getCnt(); i++) {
				File file = new File(expandPattern(i, false));
				if(file.exists()) {
					result += file.length();
				}
			}
		}
		return (result > 0) ? result : - 1;
	}
	
	/**
	 * Returns the pathname string of the current file
	 * this FileLog object represent.
	 *
	 * @return The pathname
	 */
	public String getPath()
	{
		return expandPattern(false);
	}
	
	/**
	 * Returns the pathname string of this FileLog object's pattern's parent, or
	 * <code>null</code> if the pattern does not expand to a pathname 
	 * that has a parent directory.
	 *
	 * @return The parent pathname
	 */
	public String getParent()
	{
    String path = expandPattern(false);
    int index = path.lastIndexOf(File.separatorChar);
    if(index > 0)
    {
			return path.substring(0, index);
    }
    return null;
	}
	
	/**
	* Gets the file name pattern of this file log.
	* @return File name pattern
	*/
  public String getPattern()
  {
		if (getFilePathPattern().length() > 0) {
			return getFilePathPattern() + File.separator + getFileNamePattern();
		}
		return getFileNamePattern();
  }

  public String getFilePathPattern(){
	  if (logFilePathPattern != null) {
		  return logFilePathPattern;
	  }
	  return Formatter.EMPTY_STRING;
  }

  public String getFileNamePattern(){
	  if (logFileNamePattern != null) {
		  return logFileNamePattern;
	  }
	  return Formatter.EMPTY_STRING;
  }

  /**
  * Gets the limit file size used for 
  * sequencing on the rotating output file
  * @return Limit file size
  */
  public int getLimit()
	{
		return limit;
	}

	/**
  * Gets the max count number of rotating fileset
  * @return Number of files in rotating fileset.
  */
	public int getCnt()
	{
		return cnt;
	}
	
	/**
  * Gets the current file index in 
  * the rotating file set
  * @return Limit file size
  */
  public synchronized int getIndex()
	{
		return number;
	}
	
	/**
  * Set the max count number of rotating fileset and
  * set the limit file size used for sequencing 
  * on the rotating output file
  *
  * This may change behaviour of the curent rotating fileset in a way:
  *  
  * - Setting an incompatible value to the count or the limit will 
	* kill the rotating file set.
	* Possible incompatibilities are: <code>count <= 0 or/and limit <= 0</code>
	* 
	* - Set FileLog mode to MODE_FILE_SET
	*
	* - All changes are active immediately on a newly created file!
	*  
  */
	public void setRotation(int limit, int cnt)
	{
		int oldCntValue 	= -1, 
				newCntValue		= cnt;
		int oldLimitValue = -1,
				newLimitValue	= limit;
		
		synchronized (getClass()) {
			
			oldCntValue 	= getCnt();
			oldLimitValue = getLimit();
			
			if(cnt 	 < 1)  cnt 		= NO_CNT;
			if(limit < 1)  limit 	= NO_LIMIT; 

			// Killing FileSet
			if(cnt == NO_CNT || limit == NO_LIMIT) {
				limit = DEF_LIMIT; 
				cnt		= NO_CNT;
				setIndex(0);
			}
		
			this.cnt 	 = cnt;
			this.limit = limit;
		
			if (cnt > NO_CNT) this.mode = MODE_FILE_SET;
		
			// Close current File
			close();
			
			newCntValue		= this.cnt;
			newLimitValue = this.limit;
		}
		
		if (oldCntValue != newCntValue || oldLimitValue != newLimitValue) {
			APILogger.instrumentIntByAPI(subLoc + "[setRotation(int limit, int cnt)]", 
					MSGCollection.CONFIGURATION_IS_CHANGED(),
					new Object[] {"rotation", 
											 "FileLog",
											 this.getName(),
											 " cnt:" + oldCntValue + ", limit:"  + oldLimitValue, 
											 " cnt:" + newCntValue + ", limit:"  + newLimitValue});
		}
	}

	/**
	 * Checks whether this file log writes messages to the end of the specified
	 * file rather than the beginning.
	 * @return <code>true</code> if and only if this file log writes messages to
	 *         the end of the specified file rather than the beginning
	 */
	public boolean isAppend()
	{
		return append;
	}

	public boolean equals(Object object)
	{
		if(object instanceof FileLog)
		{
			FileLog fileLog = (FileLog)object;

			return getPattern().equals(fileLog.getPattern());
		}
		else
		{
			return false;
		}
	}

	/**
	 * Returns the pathname string of the file from the file set, 
	 * where the first (oldest) message was written. 
	 *
	 * @return The pathname
	 */
	public String findBeginningOfFileSet() {
		
		String tmpPattern = this.expandPattern(false);
		
		// Am I in a rotating File Set !?
		if (this.getCnt() != this.NO_CNT) {
			
			int 	oldestIndex		= 0;
			long 	oldestDate 		= Long.MAX_VALUE;
			File 	file 					= null;
			
			for (int i = this.getCnt() - 1; i >= 0; i--) {
				
				file = new File(this.expandPattern(i, true));
				
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
			tmpPattern = this.expandPattern(oldestIndex, false);
		}
		return tmpPattern;
	}
	
	/**
	 * Returns the pathname string of the file from the file set, 
	 * where the last (newest) message was written. 
	 *
	 * @return The pathname
	 */
	public String findEndOfFileSet() {
		
		String tmpPattern = this.expandPattern(false);
		
		// Am I in a rotating File Set !?
		if (this.getCnt() != this.NO_CNT) {
			
			int 	latestIndex		= 0;
			long 	latestDate 		= 0;
			File 	file 					= null;
			
			for (int i = 0; i < this.getCnt(); i++) {
				
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
			tmpPattern = this.expandPattern(latestIndex, false);
		}
		return tmpPattern;
	}
	
	//==== < public ==================================== protected > ====

	protected synchronized void setFormatterInt(Formatter formatter) {
		super.setFormatter(formatter);
	}

	/**
	 * Reset all current FileLog settings and
	 * starts from beginning 
	 * Current file
	 */
	protected synchronized void resetInt() {
		// Only in a case of rotatiing file set:
		// Remember on which file from the rotating file 
		// set reset was made. 

		this.close();

		// Rotating file set...
		if (this.cnt != NO_CNT) {
			for (int i = 0; i < this.cnt; i++) {
				this.number = i;
				String filePattern = expandPattern(true);
				File file = new File(filePattern);
				if (file.exists()) {
					LoggingManager.getLoggingManager().notifyReleaseLogfile(this);
					LoggingManager.getLoggingManager().notifyOverwriteLogfile(this);
				}
			}
			this.number = 0;
		}
		else { // normal log
			String filePattern = expandPattern(true);
			File file = new File(filePattern);
			if (file.exists()) {
				LoggingManager.getLoggingManager().notifyReleaseLogfile(this);
				LoggingManager.getLoggingManager().notifyOverwriteLogfile(this);
			}
		}
		setSize(0);
	}
		
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	protected synchronized void writeLogHeader(){
		// Set a temporary write lock here to protect writing of footer.
   if (!isHeaderWritten()) {
	   if (!isSuppressing()) {
		   try {
			   writeInt(getHeader());
				 setHeaderWritten(true);
				 flush();
		   }
		   catch (Exception ex) {
			   APILogger
				   .logIntByAPI(Severity.WARNING,
										     subLoc + "[writeLogHeader()]",
											   MSGCollection.LOGGING_MSG_ID_WRITE_EXCEPTION,
											   MSGCollection.LOGGING_MSG_STR_WRITE_EXCEPTION,
											   new String[] {this.getName()});
			   APILogger.catchingIntByAPI(ex);
		
			   handleException(ex, ExceptionManager.ERR_WRITE);
		   }
	   }
   }	
	}
	
	protected synchronized void writeLogFooter(){
		// Set a temporary write lock here to protect writing of footer.
	  if (isHeaderWritten()) {
		  if (!isSuppressing()) {
				try {
					// To be sure how the footer is writen to the same file
					long tmpCurrFileLen = size();
					setSize(1);
					writeInt(getFooter());
					setSize(tmpCurrFileLen);
			  }
			  catch (Exception ex) {
					APILogger
					   .logIntByAPI(Severity.WARNING,
											    subLoc + "[writeLogFooter()]",
													MSGCollection.LOGGING_MSG_ID_WRITE_EXCEPTION,
													MSGCollection.LOGGING_MSG_STR_WRITE_EXCEPTION,
													new String[] {this.getName()});
					APILogger.catchingIntByAPI(ex);
				
					handleException(ex, ExceptionManager.ERR_WRITE);
				}
			}
			setHeaderWritten(false);
	  }	
  }
	
	protected synchronized void writeInt(String s) throws Exception
	{
		checkFile();
		super.writeInt(s);
		setSize(size() + s.length());
	}
	
	protected boolean equalsPattern(String pattern, boolean onlyNewFormat)
	{
		String currPatern 	= new File(expandPattern(this.getPattern(), this.number, (mode == MODE_FILE_SET), onlyNewFormat)).getName();
		String checkPattern = new File(expandPattern(pattern, this.number, (mode == MODE_FILE_SET), onlyNewFormat)).getName();
		
		return currPatern.equalsIgnoreCase(checkPattern);
	}
	
	protected String expandPattern(boolean onlyNewFormat)
	{
		return expandPattern(this.getPattern(), this.number, (mode == MODE_FILE_SET), onlyNewFormat);
	}
		
	protected String expandPattern(int fileIndex, boolean onlyNewFormat)
	{
		return expandPattern(this.getPattern(), fileIndex, (mode == MODE_FILE_SET), onlyNewFormat);
	}
	
	protected synchronized void setIndex(int value)
	{
		if((value < 1) || ((value > cnt))){
			this.number = 0; 
		} 
		else {
			this.number = value;
		}
	}
	
	protected synchronized void setCnt(int value)
	{
		if((value < 1)){
			this.cnt = 0; 
		} 
		else {
			this.cnt = value;
		}
	}
		
	protected synchronized void setLimit(int value)
	{
		if((value < 1)){
			this.limit = 0; 
		} 
		else {
			this.limit = value;
		}
	}

	protected void setPattern(String pattern)
  {
		if(pattern == null) {
			throw new IllegalArgumentException(NO_PATTERN_EMSG);
	  }
		buildPattern(pattern);
		this.logPattern = pattern;
  }
	
  protected void setAppend(boolean append)
	{
		// Ignore appending logic flag for rotating file set.
		if(cnt == NO_CNT) {
			this.append = append;
		}
	}
	
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	
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
	
	//Same as original expandPattern(), but taking an integer value to
  //make is flexible for reader side to perform same pattern resolving task
  //on output file with any sequence number
  protected String expandPattern(String filePattern, int fileCount, boolean isRotate, boolean onlyNewFormat)
	{
	  StringBuffer buf 				= new StringBuffer(filePattern);
	  int patternLen 					= filePattern.length();
	  boolean numberInserted 	= false;

	  for(int i = 0; i < patternLen; ++i)
	  {
		  String replacement;

		  switch(buf.charAt(i))
		  {
		  	case '%':
			  	switch(buf.charAt(i + 1))
			  	{
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
						  try
						  {
							  replacement = System.getProperty("java.io.tmpdir");
						  }
						  catch(SecurityException sE)
						  {
							  try
							  {
								  File file = File.createTempFile("tmp", null);
		
								  replacement = file.getPath();
								  file.delete();
								  replacement = replacement.substring(0, replacement.lastIndexOf(File.separator));
							  }
							  catch(IOException ioE)
							  {
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
	
	private synchronized void checkFile() throws Exception 
	{
		// Prevent loop in same thread ...
		if ( (flags & FIND_FILE_FLAG) == FIND_FILE_FLAG ) return;

		flags |= FIND_FILE_FLAG;
				
		if (size() < limit && size() > 0) {
			// Contiue with writing to the current file ...
			flags ^= FIND_FILE_FLAG;
			return;
		}
		else {
			
			File file = null;	
			
			// Get next file index
			number = findNextIndex();
			
			// First close the current file 
			// (if any)
			closeInt();
			
			// New file
			file = new File(expandPattern(true));
			// Get length...
			setSize(file.length());
			// if file exists... and is it ready for overwrite...
			if(size() >= limit) { 	
				LoggingManager.getLoggingManager().notifyReleaseLogfile(this);
				LoggingManager.getLoggingManager().notifyOverwriteLogfile(this);
				// Start from BOF...
				setSize(0);
			}
			else if (size() == 0) {
				// No file...
				parentFile = file.getParentFile();
				if (parentFile != null) {
					mkDirsPrivileged();
				}
				parentFile = null;
			}
				
			openFilePrivileged(file);
				
			// Log Header
			if (size() == 0) {
				setHeader(FileLogInfoData.buildHeader(this));
				setHeaderWritten(false);
				writeLogHeader();
			}
		}
		flags ^= FIND_FILE_FLAG;	
	}
	
	private int findNextIndex() {
		
		// Am I in a rotating File Set !?
		if (this.getCnt() != NO_CNT) {
			// File Set is already open !?
			if(getOutputStream() != null) {
				// Get next file index in current File Set
				return (number + 1) % cnt;
			}
			else { // No ... I must discover next index
				File file = null;
				for (int i = 0; i < this.getCnt(); i++) {
					file = new File(expandPattern(i, true));
					if (file.length() < this.getLimit()) return i;
				}
			}
		}
		// Return 0 in a cases:
		// 1. No rotating File Set - single file
		// 2. File Set is filled and start from the beginning
		return 0;
	}


	private void mkDirsPrivileged()throws Exception {
		if(System.getSecurityManager() != null) {
			class mkdirsAction implements PrivilegedExceptionAction {
				public Object run() throws Exception {
					mkDirs();
					return null;
				}
			}
			AccessController.doPrivileged(new mkdirsAction());
		} 
		else {
		  mkDirs();
		}
	}

	private void mkDirs() throws Exception {
		parentFile.mkdirs();
	}

	private void openFilePrivileged(File file)throws Exception
	{
    if(System.getSecurityManager() != null) {
	    class FileOpenAction implements PrivilegedExceptionAction
	    {
        FileOpenAction(File file)
        {
        	this.file = file;
        }

        public Object run() throws Exception
        {
					openFileInt(file);
	        return null;
        }

        File file;
	    }
	    AccessController.doPrivileged(new FileOpenAction(file));
    }
    else {
			openFileInt(file);
    }
	}

	private void openFileInt(File file) throws Exception
	{
  	try {
	    setOutputStream(new FileOutputStream(file.getPath(), (size() > 0) && append));
	    
			// Open stream...
			openInt();
			
			// If file is completly new, set the header flag 
			// to false == Header is not yet writen
	    setHeaderWritten((size() > 0) && append);
	
			fileNotFoundCnt	= 0;
			noPermissionCnt = 0;
			
	    LoggingManager.getLoggingManager().notifyCreateLogfile(file.getAbsolutePath(), this.limit, this.cnt);
  	}
    catch(IOException ex) {
			fileNotFoundCnt = (fileNotFoundCnt + 1) % NO_PERMISSION_REPEAT;
	    if(fileNotFoundCnt == 1) {
				throw ex;
	    }
    }
    catch(SecurityException ex) {
			noPermissionCnt = (noPermissionCnt + 1) % NO_PERMISSION_REPEAT;
			if(noPermissionCnt == 1) {
				throw ex;
			}
    }
	}

	private void buildPattern(String value){
		File file = new File(value);
		logFileNamePattern = file.getName();
		logFilePathPattern = file.getParent();
	}
 
	//==== < private ================================== deprecated > ====
	
	/**
	 * Same like FileLog.getPath() 
	 * Cann be null;
	 * @return FileLog.getPath()
	 * @deprecated A current return value is equal to the java.io.File.getPath() 
	 * (path name) but from the name of the method java.io.File.getName() (file name) is expected.
	 * Please use the FileLog.getPath() for getting a path name value, and
	 * the java.io.File.getName() for getting a file name value.
	 */
	public String getFileName()
	{
		/*try {
			return new File(getPath()).getName();
		}
		catch (Exception ex) {
			return null;
		}*/
		return getPath();
	}
	
	/**
	 * @deprecated Same as {@link #getFileName()}
	 */
	public String getFileCurrentlyBeingWritten()
	{
		return getFileName();
	}

	/**
	 * @deprecated Use <code>new java.io.File(FileLog.getParent())<code>
	 */
	public File getParentFile()
	{
		if(parentFile != null)
		{
			return parentFile;
		}

		String p = this.getParent();
		if(p == null)
		{
			return null;
		}

		parentFile = new File(p);
		return parentFile;
	}

	/**
	 * @deprecated Same as {@link #getPattern()}
	 */
	public String getLogId()
	{
		return getPattern();
	}

}
