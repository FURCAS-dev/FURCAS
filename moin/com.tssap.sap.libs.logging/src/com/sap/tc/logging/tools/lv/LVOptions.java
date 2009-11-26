package com.sap.tc.logging.tools.lv;

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
 */

import java.util.*;
import java.io.*;

import com.sap.tc.logging.*;


public class 			LVOptions
    	 extends 		LVActionConstants
    	 implements Cloneable
{
	
	//================================================ declaration > ====
	  
	private static String strLoc = "-LVOptions";
	
	private static String EMPTY_STRING = "";
	
	public int           action       = ACTION_UNKNOWN;
	
	public static final String DEFAULT_FORMAT 		= "%d %t %s %m";
	public static final int 	 DEF_SEVERITY_WIDTH = 8;
	public static final int 	 DEF_GUID_WIDTH 		= 35;
	public static final int 	 DEF_LOCATION_WIDTH = 35;
	public static final int 	 DEF_CATEGORY_WIDTH = 35;
	
	public int 					filSeverity;
	public String 			filLocation;
	public String 			filCategory;
	public String 			filDate;
	
	public String				outFileName	  = null;		
	public String[]			readFileName  = null;
	public String				format  			= DEFAULT_FORMAT;
	public boolean      isTail				= false;
	public boolean 			isBatchMode   = true;
	public boolean 			isIndexed   	= false;
	public boolean 			isFileSet   	= false;
	
	public PrintWriter 	outSystem;
 
 	public LVFormatter 	formatter 		= new LVFormatter(DEFAULT_FORMAT);
 
	static HashMap optionPrefixes 		= new HashMap();
	
	static {
		optionPrefixes.put("O", "out");
		optionPrefixes.put("B", "batch");
		optionPrefixes.put("T", "tail");
		optionPrefixes.put("F", "format");
		optionPrefixes.put("I", "index");
		
		// FILTERS
		optionPrefixes.put("L", "location");
	 	optionPrefixes.put("C", "category");
	 	optionPrefixes.put("D", "date");
	 	optionPrefixes.put("S", "severity");
		
		optionPrefixes.put("E", "eventlog");
		optionPrefixes.put("H", "help");
		optionPrefixes.put("V", "version");
	}  
  
	static public final String help =
			"NAME: lv - print the content of log files\n\n"+
			"SYNOPSIS: lv.bat source [-o outfile] [-t] [-i] [-e] \n" +			"                        [-l location name] [-c category name] \n" +			"                        [-d date] [-s severity] [-f format]\n\n" +

			"DESCRIPTION: The lv utility may be used to print log and trace files \n" +			"written by the SAP logging API with ListFormat, in a human readable format. \n" +			"The tool supports two main operation modes: \n" +			"printing whole files or printing log records from some source files \n" +			"as they are written (this resembles the tail -f command)\n\n" +

		  "General options:\n" + 
			"  source - path to a log directory or a single file. \n" +			"   Note that if you specify a directory as the value of the source \n" +
			"   argument then lv tries to dump the content of all files \n" +
			"   in that directory. But this will only work if all the files are\n" +
			"   written in ListFormat. \n" +
			"   Multiple values must be separated by space.\n" + 
			"  -i[ndex]\n" +
			"   When this switch is set and a list of files has been given as source \n" +			"   each log record is tagged with an index number. This number references \n" +			"   the file in the source file list from where the log record originated.\n"+			"   If only one file is specified for reading, this flag will be ignored.\n" +			"  -o[utfile] <outfile>\n" + 
			"   The filename (outfile) where to write the output.\n" + 
			"   Always writes the complete file and terminates automatic.\n" +
			"  -t[ail]\n" + 
			"   When this switch is set the lv tool will not print the whole content of \n" +			"   the source file or files but will print each new log record as they are \n" +			"   written to the corresponding file.\n" +
			"   This option does not work in J2EE cmd console!\n" +
			"  -e[ventlog]\n" + 
			"   Enable Logging API log.\n" +			"   Logging API messages will be written to the loggingAPI.log and loggingAPI.trc file\n" +
			"  -h[elp]\n" + 
			"   print this help text.\n" +
			"  -v[ersion]\n" + 
			"   print version info.\n" +	LVFormatPattern.help  +
			"Filter options:\n" +
		  "  -l[ocation]\n" +
		  "   print all messages with the given location name\n" + 
			"  -c[ategory]\n" +
			"   print all messages with the given category name\n" +
		  "  -d[ate] using format (dd.MM.yyyy HH:mm:ss)\n" + 
		  "   print all messages with this or a later time stamp\n" + 
		  "  -s[everity] <value> DEBUG|PATH|INFO|WARNING|ERROR|FATAL\n" + 
		  "   display only records with severity >= value\n" + 
		  "   (severities are ordered with ascending severity from DEBUG to FATAL)\n" +
			"\n";
    
	//==== < declaration ============================ constructors > ====
	  
	public LVOptions (){}

	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====
	
	// Support for NO-NAME-PREFIX	argument 

	public void parseNoNamePrefix (CmdOption option)
	{
		readFileName = new String[option.size()];
		
		for (int i = 0; i < option.size(); i++) {
			readFileName[i] = (String) option.getValueAt (i);
		}
		
		action = ACTION_READ_FILE_PATH;
	}

	public void parseEventlog (CmdOption option)
	{
		System.setProperty("eventLog", "all");
		
		LVLogger
			.logIntByAPI(Severity.INFO, 
									 LVLogger.LVLocation, 
									 strLoc, 
									 MSGCollection.LOGGING_MSG_ID_EVENT_LOG,
									 MSGCollection.LOGGING_MSG_STR_EVENT_LOG,
									 new Object[] {"enabled"});
		
	}
	
	public void parseVersion (CmdOption option)
	{
		action = ACTION_VERSION;
	}

	// LV HELP

	public void parseHelp (CmdOption option)
	{
		action = ACTION_HELP;
	}
	
	public Object clone()
	{
		LVOptions cloneMe = new LVOptions();

		return cloneMe;
	}
	
	 public void parseBatch (CmdOption option)
	 {
			isBatchMode = option.getValueAt(0).equalsIgnoreCase("true") && !isTail;
	 }
	 
	 public void parseTail (CmdOption option)
	 {
			isTail = true;
			isBatchMode = false;
	 }
	
	 public void parseIndex(CmdOption option)
	 {
	 		isIndexed = true;
	 }
	
	
	public void parseOut (CmdOption option)
	{
		if (option.size () == 0) {
			outFileName = null;
			parseError (option, "Missing the output file name!");
		}
		else {
			outFileName = option.getValueAt (0);
		}
		isBatchMode = true;
	}
	
	// Set output format
	public void parseFormat (CmdOption option)
  {
		if (option.size () == 0) {
			format  = DEFAULT_FORMAT;
			parseError (option, "Missing the Format value! Default format (" + DEFAULT_FORMAT + ") is used!");
		}
		else {
			StringBuffer tmpBuffer = new StringBuffer();
			for (Iterator iter = option.getValues(); iter.hasNext();) {
				tmpBuffer.append((String) iter.next());
			}
			format = tmpBuffer.toString();
		}
		
		formatter = new LVFormatter(format);
		
	}
	
	// FILTERS
	
	// Print the source location of the message
	public void parseLocation (CmdOption option)
  {
		if (option.size () == 0) {
			filLocation  = null;
			parseError (option, "Missing the filtering Location value!");
		}
		else {
			filLocation = option.getValueAt (0);
		}
	}
	
	// Print the source category of the message
	public void parseCategory (CmdOption option)
  {
		if (option.size () == 0) {
			filCategory  = null;
			parseError (option, "Missing the filtering Category value!");
		}
		else {
			filCategory = option.getValueAt (0);
		}
	}
	
	//	Print the date of the message;
	public void parseDate (CmdOption option)
  {
		if (option.size () != 2) {
			filDate  = null;
		 	parseError (option, "Missing the filtering Date value!");
	 	}
		else {
			filDate = option.getValueAt (0) + " " + option.getValueAt (1);
		}
	}
	
	// Display only records with severity >= value
	
	public void parseSeverity (CmdOption option)
  {
		if (option.size () == 0) {
			filSeverity = Severity.NONE;
			parseError (option, "Missing the filtering Severity value");
		}
		else {
			try {
				filSeverity = Severity.parse(option.getValueAt (0));
			}
			catch (IllegalArgumentException ex) {
				filSeverity = Severity.NONE;;
				parseError (option, ex.getMessage());
			}
		}
	}
	
	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	
	void parseMessage (String txt, CmdOption option, String msg)
	{
		 System.err.println (txt + ": Option " + option.getName () + ": " + msg);
	}

	void parseWarning (CmdOption option, String msg)
	{
		parseMessage ("Warning", option, msg);
	}

	void parseError (CmdOption option, String msg)
	{
		parseMessage ("Error", option, msg);
		System.exit (1);
	}
	
	//==== < default ===================================== private > ====	
	//==== < private ================================== deprecated > ====

}

