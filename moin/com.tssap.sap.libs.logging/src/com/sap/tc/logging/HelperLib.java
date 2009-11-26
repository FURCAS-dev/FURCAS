package com.sap.tc.logging;

/**
 * Title:        Logging
 * Description:  Logging API
 * Copyright:    Copyright (c) 2003
 * Company:      SAP AG.
 *               Walldorf, Germany.
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAPMarkets Inc. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAP AG.
 * @author			 Robert Boban
 */


import java.util.*;
import java.text.*;
import java.io.*;

public final class HelperLib {
	//$JL-EXC$
	public static final String 	NULL_STRING 					= "<null>";
	public static final String 	EMPTY_STRING 					= "";

	private static final int 		OPER_MIN_ID 					= 0;
	private static final int		OPER_EQUAL_ID 				= OPER_MIN_ID + 1;
	private static final String OPER_EQUAL 						= "=";
	private static final int 		OPER_NOT_EQUAL_ID			= OPER_EQUAL_ID + 1;
	private static final String OPER_NOT_EQUAL 				= "!=";
	private static final int 		OPER_DIFF_EQUAL_ID		= OPER_NOT_EQUAL_ID + 1;
	private static final String OPER_DIFF_EQUAL 			= "<>";
	private static final int 		OPER_GREATER_ID 			= OPER_DIFF_EQUAL_ID + 1;
	private static final String OPER_GREATER					= ">";
	private static final int 		OPER_GREATER_EQUAL_ID = OPER_GREATER_ID + 1;
	private static final String OPER_GREATER_EQUAL		= ">=";
	private static final int 		OPER_LOWER_ID 				= OPER_GREATER_EQUAL_ID + 1;
	private static final String OPER_LOWER 						= "<";
	private static final int 		OPER_LOWER_EQUAL_ID 	= OPER_LOWER_ID + 1;
	private static final String OPER_LOWER_EQUAL 			= "<=";
	
	private static Map operaters = new HashMap();
	
	static {
		operaters.put(OPER_EQUAL, 				new Integer(OPER_EQUAL_ID));
		operaters.put(OPER_NOT_EQUAL, 		new Integer(OPER_NOT_EQUAL_ID));
		operaters.put(OPER_DIFF_EQUAL, 		new Integer(OPER_DIFF_EQUAL_ID));
		operaters.put(OPER_GREATER, 			new Integer(OPER_GREATER_ID));
		operaters.put(OPER_GREATER_EQUAL,	new Integer(OPER_GREATER_EQUAL_ID));
		operaters.put(OPER_LOWER, 				new Integer(OPER_LOWER_ID));
		operaters.put(OPER_LOWER_EQUAL, 	new Integer(OPER_LOWER_EQUAL_ID));
	}

	public static int parseOperator(String value) {
		if (operaters.containsKey(value)) {
			return ((Integer) operaters.get(value)).intValue();
		}
		return -1;
	}

	public static boolean compareTwoDates(int operator, Date dateA, Date dateB) {
		int result = dateA.compareTo(dateB);
		switch (operator) {
			case OPER_EQUAL_ID: // ==
				return (result == 0);
			case OPER_GREATER_ID: // >
				return (result > 0);
			case OPER_GREATER_EQUAL_ID: // >=
				return (result == 0 || result > 0); 
			case OPER_LOWER_ID: // <
				return (result < 0);
			case OPER_LOWER_EQUAL_ID: // <=
				return (result == 0 || result < 0);
			case OPER_NOT_EQUAL_ID: // !=
			case OPER_DIFF_EQUAL_ID: // <>
				return (result != 0);
			default:
				
		}
		return false;
	}
	

	//Same as original expandPattern(), but taking an integer value to
	//make is flexible for reader side to perform same pattern resolving task
	//on output file with any sequence number
	public static String expandPattern(String filePattern, 
															 int fileCount, 
															 boolean isRotate, 
															 boolean onlyNewFormat)
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

	private static String  createFileName(String filePattern, String append, boolean onlyNewFormat){
	
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
}
