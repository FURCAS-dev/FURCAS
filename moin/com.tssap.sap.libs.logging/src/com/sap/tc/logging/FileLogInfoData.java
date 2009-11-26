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
 * @author			 Robert Boban	
 */
import java.io.*;
import java.util.*;
import java.text.*;

import com.sap.tc.logging.exceptions.FileDataException;

public final class FileLogInfoData extends LogInfoData 
{
	//$JL-EXC$
	//================================================ declaration > ====
	
	private static Location classLoc = Location.getLocation(FileLogInfoData.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
	
	// Header definition
	private static final String HEAD_LINE_START 	= "<!--";
	private static final String HEAD_LINE_END 		= "/-->";
	private static final String HEAD_DEL_LEFT 		= "[";
	private static final String HEAD_DEL_RIGHT 		= "]";

	private static HashMap headerElements = new HashMap();
	
	private static final int 	  MIN 								= 0;
	
	public static final int 		LOG_HEAD						=	MIN + 1;
	private static final String STR_LOG_HEAD				= "LOGHEADER";
	
	public static final int 	 	LOG_HEAD_HELP 			= LOG_HEAD + 1;
	private static final String STR_LOG_HEAD_HELP 	= "HELP";
	
	public static final int 		LOGGING_VERSION 		= LOG_HEAD_HELP + 1;
	private static final String STR_LOGGING_VERSION = "LOGGINGVERSION";
	
	public static final int 		LOG_NAME 						= LOGGING_VERSION + 1;
	private static final String STR_LOG_NAME 				= "NAME";
	
	public static final int 		LOG_DESCRIPT 				= LOG_NAME + 1;
	private static final String STR_LOG_DESCRIPT 		= "DESCRIPTION";
	
	public static final int 		LOG_F_NAME_PATTERN		 	= LOG_DESCRIPT + 1;
	private static final String STR_LOG_F_NAME_PATTERN 	= "PATTERN";
	
	public static final int 		LOG_OWNER 					= LOG_F_NAME_PATTERN + 1;
	private static final String STR_LOG_OWNER 			= "OWNER";
	
	public static final int 		LOG_FORMATTER 			= LOG_OWNER + 1;
	private static final String STR_LOG_FORMATTER		= "FORMATTER";
	
	public static final int 		LOG_ENCODING 				= LOG_FORMATTER + 1;
	private static final String STR_LOG_ENCODING		= "ENCODING";
	
	public static final int 		LOG_FILESET 				= LOG_ENCODING + 1;
	private static final String STR_LOG_FILESET 		= "FILESET";
	
	public static final int 		LOG_PREV_FILE 			= LOG_FILESET + 1;
	private static final String STR_LOG_PREV_FILE		= "PREVIOUSFILE";
	
	public static final int 		LOG_NEXT_FILE 			= LOG_PREV_FILE + 1;
	private static final String STR_LOG_NEXT_FILE		= "NEXTFILE";
	
	private static final int 	  MAX 								= LOG_NEXT_FILE + 1;

	public static final int MAX_NUMBER_OF_HEADER_LINES = MAX + 1;  // Adds the first line from log records too.
		
	static {
		headerElements.put(STR_LOG_HEAD,	new Integer(LOG_HEAD));
		headerElements.put(STR_LOG_HEAD_HELP,		new Integer(LOG_HEAD_HELP));
		headerElements.put(STR_LOGGING_VERSION,	new Integer(LOGGING_VERSION));
		headerElements.put(STR_LOG_NAME,				new Integer(LOG_NAME));
		headerElements.put(STR_LOG_DESCRIPT,		new Integer(LOG_DESCRIPT));
		headerElements.put(STR_LOG_F_NAME_PATTERN,			new Integer(LOG_F_NAME_PATTERN));
		headerElements.put(STR_LOG_OWNER,				new Integer(LOG_OWNER));
		headerElements.put(STR_LOG_FORMATTER,		new Integer(LOG_FORMATTER));
		headerElements.put(STR_LOG_ENCODING,		new Integer(LOG_ENCODING));
		headerElements.put(STR_LOG_FILESET,			new Integer(LOG_FILESET));
		headerElements.put(STR_LOG_PREV_FILE,		new Integer(LOG_PREV_FILE));
		headerElements.put(STR_LOG_NEXT_FILE,		new Integer(LOG_NEXT_FILE));
	}	
	
	private static final	int SETTING_LEVEL_DEFAULT = 0;	
	private static final	int SETTING_LEVEL_CUSTOM 	= 1;
	
	// FileLog info ...
	private String		logPattern;
	private String  	logFileName;
	private String		logEncoding;
	private String		logOwners;
	private String		logFileSet;
	private int				logFileSetIndex;
	private int				logFileSetSize;
	private int				logFileSetLimit;
	private int				logFileHeaderSize;
	private int				logFileFooterSize;
	private String		logFileNext;
	private String		logFilePrev;
	private String 		logFormatterPattern;

	
  //==== < declaration ============================ constructors > ====
  
  public FileLogInfoData(FileLog fileLog) {
		String fileName = fileLog.expandPattern(true);
		init(fileName);
  }
  
  public FileLogInfoData(String fileName) {
		init(fileName);
	}
  
  //==== < constructors =============================== abstarct > ====
  //==== < abstract ===================================== public > ====
  
  /**
   * Build a file header from give FileLog instance
   * @return File header string 
   */
	public static String buildHeader(FileLog fileLog) {
		return format(fileLog);
	}
	
	// **********************************************************
	// Get FileLog info data ...
	// **********************************************************
	
  public String getPattern(){
  	if (logPattern != null) {
			return logPattern;
  	}
		return HelperLib.EMPTY_STRING;
	}
	
	public String getEncoding(){
		if (logEncoding != null) {
			return logEncoding;
		}
		return HelperLib.EMPTY_STRING;
	}
	
	public String getOwners(){
		if (logOwners != null) {
			return logOwners;
		}
		return HelperLib.EMPTY_STRING;
	}
	
	public String getFileSet(){
		if (logFileSetSize > 0) {
			logFileSet = "" + logFileSetIndex + ", " + logFileSetSize + ", " + logFileSetLimit;
		}
		if (logFileSet != null) {
			return logFileSet;
		}
		return HelperLib.EMPTY_STRING;
	}
	
	public int getFileSetIndex(){
	 return logFileSetIndex;
 	}
	
	public int getFileSetSize(){
		return logFileSetSize;
	}

	public int getFileSetLimit(){
		return logFileSetLimit;
	}
	
	public int getFileHeaderSize(){
		return logFileHeaderSize;
	}

	public String getFileName(){
		if (logFileName != null) {
			return logFileName;
		}
		return HelperLib.EMPTY_STRING;
	}
	
	public String getFormatterPattern(){
  	if (logFormatterPattern != null) {
			return logFormatterPattern;
  	}
		return HelperLib.EMPTY_STRING;
	}
	
	public String getFileNext(){
		return this.logFileNext;
	}

	public String getFilePrev(){
		return this.logFilePrev;
	}
	
  //==== < public ==================================== protected > ====
	
	//**********************************************************
  // Set FileLog info data ...
  // **********************************************************
	
	protected void setPattern(String value){
	  this.logPattern = value;
	  headerIsChanged();
  }
  
	protected void setFileName(String value){
	 	this.logFileName = value;
	 	headerIsChanged();
  }

	protected void setEncoding(String value){
	  this.logEncoding = value;
	  headerIsChanged();
  }

  protected void setOwners(List value){
		//this.logOwners 	= value;
		headerIsChanged();
  }

  protected void setFileSetIndex(int value){
  	this.logFileSetIndex = value;
		headerIsChanged();
	}
	
	protected void setFileSet(int size, int limit){
		this.logFileSetSize 	= size;
		this.logFileSetLimit 	= limit;
	  headerIsChanged();
  }
  
  //==== < protected =================================== default > ====
  //==== < default ===================================== private > ====
  
  protected void setFileNext(String value){
	  this.logFileNext = value;
  }

  protected void setFilePrev(String value){
	  this.logFilePrev = value;
  }
  
	private void init (String fileName) {
		setFileName(fileName);
		loadFileLogHeader(fileName);
		resetIsChanged();
	}
  
  private String buildHeaderInt(){
		if (isChanged()) {
			// load new
			setHeader(format());
			resetIsChanged();
		}
		return getHeader();
	}
 
  private static String formatFormatter(Formatter formatter) {
  	String formatterName = formatter.getClass().getName();
	  if (formatter instanceof TraceFormatter) {
			formatterName  += "(" + ((TraceFormatter)formatter).getPattern() + ")";
	  }
	  return formatterName;
  }
	
  private void parseFormatter(String value){
  	
		String strFormatter 	= null;
	  logFormatterPattern 	= null;

  	// Check does Trace formatter have a pattern
  	int startPos = value.indexOf("(");

	  // Trace formatter with pattern
  	if (startPos > 0) {
			strFormatter 				= value.substring(0, startPos);
		  logFormatterPattern = value.substring(startPos + 1, value.length() - 1);
  	}
  	else {
		  strFormatter = value;	
	  }

	  setFormatter(createFormatter(strFormatter));
	
	  if (logFormatterPattern != null
		  && logFormatterPattern.length() > 0 ) {
		  ((TraceFormatter)getFormatter()).setPattern(logFormatterPattern);
	  }
  }
	
	private void setFileSet(String value) {
	  String[] strFromPat = getRotatingSetValues(value);
	  if (strFromPat.length == 3) {
		  setFileSet(new Integer(strFromPat[1].trim()).intValue(),
							   new Integer(strFromPat[2].trim()).intValue()); 
		  setFileSetIndex(new Integer(strFromPat[0].trim()).intValue());
	  }
		headerIsChanged();
	}

	// Load file header data from FileLog
	private void loadFileLogHeader(String fileName) {
		
		// Load first n lines - n == MAX HEAD LINES
		String[] headLines = getFileHeaderLines(fileName);
		
		if (headLines != null) { 
			if (parse(parseHeader(headLines))) {
				// Building header
				buildHeaderInt();
			}
			else {
				setHeader(null);
			}
		}
	}
  
	private String[] getFileHeaderLines(String fileName){
		return getFileHeaderLines(fileName, MAX_NUMBER_OF_HEADER_LINES);
	}
	
  private String[] getFileHeaderLines(String fileName, int cntHeadLines){
	
	  String[] headerLines = new String[cntHeadLines];
	  int headerLineCount  = 0;

	  int							lenghtBOL		= 0;
	  BufferedReader 	file 				= null;
	  
	  try {
	  
	  	// Check for \n and \r
		  lenghtBOL = getEOLLength(fileName);
	  	
		  file = new BufferedReader(new FileReader(fileName));

		  int linesRead 			 = 0;
			int lenLeftLineMark  = HEAD_LINE_START.length();
			int lenRightLineMark = HEAD_LINE_START.length();
		
		  String lineValue;
	
		  while ((lineValue = file.readLine()) != null && headerLineCount < cntHeadLines && linesRead++ < MAX_NUMBER_OF_HEADER_LINES) {
		  
			  if (lineValue.length() < lenLeftLineMark) continue;
		  
			  if (lineValue.substring(0, lenLeftLineMark).equals(HEAD_LINE_START)) {
			  	headerLines[headerLineCount] = lineValue.substring(lenLeftLineMark, lineValue.length() - lenRightLineMark);
			  	logFileHeaderSize += lineValue.length();
			  	headerLineCount++;
			  }

			  if (lineValue.startsWith(ListFormatter.DELIMITER_STR)) {
				String verNumb = lineValue.substring(1, 4);
				Version.setVersionOfFirstRecord(verNumb);
				break;
			  }
			  
		  }
		  
		  if (headerLineCount > 0) {
		  	logFileHeaderSize += headerLineCount * lenghtBOL;
		  }
	  }
	  catch (FileNotFoundException ex) {
		// If there is no file there is no header. This exception can be swallowed.
	  }
	  catch (Exception ex) {
		  APILogger
			  .logIntByAPI(Severity.WARNING,
										classLoc,
										"[getFileHeader(String fileName, int cntHeadLines)]",
										MSGCollection.LOGGING_MSG_ID_UNEXPECTED,
										MSGCollection.LOGGING_MSG_STR_UNEXPECTED,
										new String[] {"FileHeader parsing"});
		  APILogger.catchingIntByAPI(ex);
	  }
	  finally {
			if (file != null) {
				try {
					file.close();
				} 
				catch (IOException e) {
				}
				file = null;
			}
	  }
  
	  if (headerLineCount > 0) {
			String[] finalHeaderLines = new String[headerLineCount];
			System.arraycopy(headerLines, 0, finalHeaderLines,0, headerLineCount);
			return finalHeaderLines;
	  }
	  return null;
  }
  
  private int getEOLLength(String fileName) throws Exception {
  	
  	BufferedReader file 	= null;
 		int 					 pos  	= 0;
 		int						 length = 0;
 		
  	try {
  		if (!new File(fileName).exists()) return length;
  		
  		file = new BufferedReader(new FileReader(fileName));
  	
  		char[] lineByte = new char[8000];
  	
  		file.read(lineByte);
  	
	  	while (pos < 8000) {
	  		if (lineByte[pos] == '\n') {
	  			if (pos > 0 && lineByte[pos - 1] == '\r') {
	  				length = 2;
	  			}
	  			else {
	  				length = 1;
	  			}
	  			break;
	  		}
	  		pos++;
	  	}
	  }
  	catch (Exception ex) {
  		throw new Exception(ex.getMessage());
  	}
	  finally {
			if (file != null) {
				try {
					file.close();
				} 
				catch (IOException e) {
				}
				file = null;
			}
	  }
  	
  	return length;
  }
  
  /**
	* <p>Header written with the specific formatter is read as plain string. This
	* method parses the header lines into a string array.</p>
	* @param A complete header data that can span across multiple lines
	* @return The String array.
	* Note: 
	* Head line format: HEAD_KEY_NAME[HEAD_VALUE]
	* Head line can contain only one line
	*/
	
	private Map parseHeader(String[] headerLines) {
		
  	String 	lineKeyName	= null;
   	String	lineValue		= null;
   	Map 		headLines 	= new HashMap();
	
   	for (int i = 0; i < headerLines.length; i++) {
	
	  	lineKeyName = getKey	(headerLines[i]);
	   	lineValue 	= getValue(headerLines[i]);
	
	   	if ((lineKeyName != null && lineValue != null) && lineKeyName.length() > 0) {		
		  	headLines.put(lineKeyName, lineValue);
	   	}
   	}	
   	return headLines;
	}
	  
	private static String getKey(String value) 
	{
		String lineKey 	= null;
		int pos 				= 0;
		
		if (value == null) return "";
	
		pos = value.indexOf(HEAD_DEL_LEFT);
	
		if (pos > 0) {
			lineKey = value.substring(0, pos);
		}
	
		return lineKey;
	}
	
	private static String getValue(String value) 
	{
		String lineValue 	= null;
		int pos						= 0;
	
		if (value == null) return "";
		
		pos = value.indexOf(HEAD_DEL_LEFT);
	
		if (pos > 0 && (pos + 1) < value.length()) {
			lineValue = value.substring(pos + 1, (value.length() - 1));
		}
		return lineValue;
	}
	
	/*
   * Parsing header lines
   */
  private boolean parse(Map headerLines) {

		int				conKey			= 0;
		String		conValue		= null;
		Map.Entry entry				= null;

		Iterator iter = headerLines.entrySet().iterator();

		while (iter.hasNext()) {
	
			entry 		= (Map.Entry) iter.next();
			conKey  	= parseKeyByName((String) entry.getKey());
			conValue 	= (String) entry.getValue();
	
			switch (conKey) {
				case LOGGING_VERSION:
					setVerInUse(conValue);
					break;
				case LOG_OWNER:
					//setOwners(conValue);
					break;
				case LOG_NAME:
					setName(conValue);
					break;
				case LOG_DESCRIPT:
					setDescription(conValue);
					break;
				case LOG_F_NAME_PATTERN:
					setPattern(conValue);
					break;
				case LOG_FORMATTER:
					parseFormatter(conValue);
					break;
				case LOG_ENCODING:
					setEncoding(conValue);
					break;
				case LOG_FILESET:
					setFileSet(conValue);
					break;

				case LOG_PREV_FILE:
					setFilePrev(conValue);
					break;
				case LOG_NEXT_FILE:
					setFileNext(conValue);
					break;
								
				case LOG_HEAD:
				case LOG_HEAD_HELP:
					continue;

				default:
					APILogger
						.logIntByAPI(Severity.WARNING,
												  classLoc,
												  "[parse()]",
												  MSGCollection.LOGGING_MSG_ID_HEADER_ERROR,
												  MSGCollection.LOGGING_MSG_STR_HEADER_ERROR,
												  new String[] {getPattern()});
					return false;
			}
		}
		return true;
  }
  
  private static int parseKeyByName(String keyName) {
		if (keyName != null && headerElements.containsKey(keyName.toUpperCase())) {
			return ((Integer)headerElements.get(keyName.toUpperCase())).intValue();
	  }
	  return -1;
 	}
 
	//
	// Create header string
	//
	private static String format(FileLog fileLog) {
		
		String 		pattern 		 = "";
	  String [] headerFields = new String[MAX + 1];
		
	  // START
	  headerFields[MIN]	= 
		  formatHeaderLine(STR_LOG_HEAD, "START");
	  // HELP
	  headerFields[LOG_HEAD_HELP]	= 
		  formatHeaderLine(STR_LOG_HEAD_HELP, "Manual modification of the header may cause parsing problem!");
	  // VERSION
	  headerFields[LOGGING_VERSION] = 
		  formatHeaderLine(STR_LOGGING_VERSION, Version.getFullVersion());
	  // NAME
	  if (fileLog.getName() != null) {
		  headerFields[LOG_NAME] = 
			  formatHeaderLine(STR_LOG_NAME, fileLog.getName());
	  }
	  // DESCRIPTION
	  if (fileLog.getDescription() != null) {
		  headerFields[LOG_DESCRIPT] = 
			  formatHeaderLine(STR_LOG_DESCRIPT, fileLog.getDescription());
	  }	
	  // PATTERN
	  pattern = (fileLog.getFileNamePattern());
	  headerFields[LOG_F_NAME_PATTERN] = 
		  formatHeaderLine(STR_LOG_F_NAME_PATTERN, pattern);
	  // OWNERS
	  //headerFields.put(STR_LOG_OWNER, fileLog.getOwner());
	  
	  // FORMATTER
		headerFields[LOG_FORMATTER] = 
			formatHeaderLine(STR_LOG_FORMATTER, formatFormatter(fileLog.getFormatter()));
			
		//ENCODING
		headerFields[LOG_ENCODING] = 
			formatHeaderLine(STR_LOG_ENCODING, fileLog.getEncoding());

	  // FILE SET
		if (fileLog.getCnt() > 0) {
			headerFields[LOG_FILESET] = 
				formatHeaderLine(STR_LOG_FILESET,  "" + fileLog.getIndex() + ", " + fileLog.getCnt() + ", " + fileLog.getLimit());
				
			headerFields[LOG_PREV_FILE] = 
				formatHeaderLine(STR_LOG_PREV_FILE, "" + 
						new FileLog().expandPattern(pattern,(fileLog.getIndex() - 1) < 0 ? (fileLog.getCnt() - 1) : (fileLog.getIndex() - 1), true, true));
			headerFields[LOG_NEXT_FILE] = 
				formatHeaderLine(STR_LOG_NEXT_FILE, "" + 
					new FileLog().expandPattern(pattern, (fileLog.getIndex() + 1) > (fileLog.getCnt() - 1) ? 0 : (fileLog.getIndex() + 1), true, true));
		}
    
	  // END
	  headerFields[MAX] = 
		  formatHeaderLine(STR_LOG_HEAD, "END");
		
		return formatHeader(headerFields);
	}
 
	//
	// Create header string
	//
	private String format() {
		
		String 		pattern 		 = "";
	  String [] headerFields = new String[MAX + 1];
		
	  // START
	  headerFields[MIN]	= 
		  formatHeaderLine(STR_LOG_HEAD, "START");
	  // HELP
	  headerFields[LOG_HEAD_HELP]	= 
		  formatHeaderLine(STR_LOG_HEAD_HELP, "Manual modification of the header may cause parsing problem!");
	  // VERSION
	  headerFields[LOGGING_VERSION] = 
		  formatHeaderLine(STR_LOGGING_VERSION, getVerInUse());
	  // NAME
	  if (getName() != null) {
		  headerFields[LOG_NAME] = 
			  formatHeaderLine(STR_LOG_NAME, getName());
	  }
	  // DESCRIPTION
	  if (getDescription() != null) {
		  headerFields[LOG_DESCRIPT] = 
			  formatHeaderLine(STR_LOG_DESCRIPT, getDescription());
	  }	
	  // PATTERN
	  pattern = (getPattern());
	  headerFields[LOG_F_NAME_PATTERN] = 
		  formatHeaderLine(STR_LOG_F_NAME_PATTERN, pattern);
	  // OWNERS
	  //headerFields.put(STR_LOG_OWNER, fileLog.getOwner());
	  // FORMATTER
		if (getFormatterPattern().length() > 0) {
			headerFields[LOG_FORMATTER] = 
				formatHeaderLine(STR_LOG_FORMATTER, formatFormatter(getFormatter()));
		}
		else {
			headerFields[LOG_FORMATTER] = 
				formatHeaderLine(STR_LOG_FORMATTER, getFormatter().getClass().getName());
		}
		// ENCODING
		if (getEncoding() != null && getEncoding().length() > 0) {
			headerFields[LOG_ENCODING] = 
				formatHeaderLine(STR_LOG_ENCODING, getEncoding());
		}

	  // FILE SET
		if (getFileSet().length() > 0) {
			headerFields[LOG_FILESET] = 
				formatHeaderLine(STR_LOG_FILESET,  getFileSet());
				
			headerFields[LOG_PREV_FILE] = 
				formatHeaderLine(STR_LOG_PREV_FILE, "" + getFilePrev());
			headerFields[LOG_NEXT_FILE] = 
				formatHeaderLine(STR_LOG_NEXT_FILE, "" + getFileNext());
		}
    
	  // END
	  headerFields[MAX] = 
		  formatHeaderLine(STR_LOG_HEAD, "END");
		
		return formatHeader(headerFields);
	}
 
	/**
   * Formats a log header line.
   * @param  Key / Value of the header 
   * @return Header filed line.
   */
  private static String formatHeaderLine (String headerKey, String headerValue){

	  StringBuffer header = new StringBuffer();

	  if (headerKey != null && headerValue != null) {
			  header.append(headerKey);
				header.append(HEAD_DEL_LEFT);
				header.append(headerValue);
				header.append(HEAD_DEL_RIGHT);
	  }
	  return header.toString();
  }
  
  /**
	 * Formats a log header which is then ready to be written to a log.
	 * @param  Key / Value java.util.Map of the header 
	 * @return Formatted log record
	 */
	private static String formatHeader (String[] headerLines){
	
		StringBuffer header = new StringBuffer();
	
		if (headerLines != null && headerLines.length > 0) {
		
			for (int i = 0; i < headerLines.length; i++) {
				if (headerLines[i] != null) {
					header.append(HEAD_LINE_START);
					header.append(headerLines[i]);
					header.append(HEAD_LINE_END + Formatter.EOL);
				}
			}
		}
		return header.toString();
	}
 
	private static Formatter createFormatter(String fType) {
		if (fType == null) return null;
		try {
			return (Formatter) Class.forName(fType).newInstance();
		}
		catch (Exception ex) {
			return null;
		}
	}
 
	private static String[] getRotatingSetValues(String value) 
	{
		if (value == null || value.length() == 0) return new String[0];
	
		StringTokenizer tmpTokens = new StringTokenizer(value, ",", false);
		String[] 				tmpValue 	= new String[3];
	
		if (tmpTokens.countTokens() != 3) return new String[0];
	
		for (int i = 0; i < 3; i++) {
			tmpValue[i] = tmpTokens.nextToken().trim();
		}
		return tmpValue;
	}
 
  //==== < private ================================== deprecated > ====
	
}