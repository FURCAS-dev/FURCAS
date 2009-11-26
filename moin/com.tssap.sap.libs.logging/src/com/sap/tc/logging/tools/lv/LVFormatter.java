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
 * @version      $Id:$
 */

import java.text.*;
import java.util.Iterator;
import java.util.Date;
import java.util.List;

import com.sap.tc.logging.*;

class LVFormatter extends Formatter {
	//$JL-EXC$
	private static final SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss.SSS");
	private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");

	private static final String SPACE = " ";

	private LVFormatPattern formatPattern;
	
	public LVFormatter (String pattern) {
		formatPattern = new LVFormatPattern(pattern);
	}
	
	public String format(LogRecord record) {
		
		StringBuffer 	outBuf 		= new StringBuffer();			
		Iterator 			iter			= LVFormatPattern.parsedOptions.iterator();
		Date 					date			= record.getTime();
		
		while (iter.hasNext()) {
			
			LVFormatOption 	formatOption 	= (LVFormatOption) iter.next();
			String tmpVal									= "";
			
			switch (formatOption.type) {
				case LVFormatPattern.OPT_DATE:
					if (!formatOption.isEnabled) continue; 
					tmpVal = dateFormatter.format(date);
					break;
				case LVFormatPattern.OPT_TIME:
					if (!formatOption.isEnabled) continue; 
					tmpVal = timeFormatter.format(date);
					break;
				case LVFormatPattern.OPT_SEVERITY:
					if (!formatOption.isEnabled) continue; 
					tmpVal = Severity.toString(record.getSeverity()).toUpperCase();
					break;
				case LVFormatPattern.OPT_GUID:
					if (!formatOption.isEnabled) continue; 
					tmpVal = record.getId().toString();
					break;
				case LVFormatPattern.OPT_LOCATION:
					if (!formatOption.isEnabled) continue; 
					tmpVal = record.getLocationName();
					break;
				case LVFormatPattern.OPT_CATEGORY:
					if (!formatOption.isEnabled) continue; 
					tmpVal = getCategory(record);
					break;
				case LVFormatPattern.OPT_MESSAGE:
					if (!formatOption.isEnabled) continue; 
					tmpVal = getMessage(record);
					break;
			}
			
			if (tmpVal != null && tmpVal.length() > 0) { 
				outBuf.append(
					SPACE + printString(tmpVal,
															formatOption.width,
															formatOption.align));
			}
		}
		
		return outBuf.toString();
	}
	
	protected static String printString(String value, int width, int align)
	{
		
			if (value == null) return "";
		
			StringBuffer tmpBuffer = new StringBuffer();
			int pad 							 = 0;
		
			if (width == -1) {	// IGNORE ... PRINT COMPLETE VALUE
				align = LVFormatPattern.ALIGN_LEFT;
			}
			else if (width < value.length()) { // IF WIDTH < VALUE LENGTH - CUT VALUE
				value = value.substring(0, width); 
			} 
			else {
				pad = width - value.length();
			}
		
			for (int i = 0; i < pad; i++) {
				tmpBuffer.append(SPACE);
			}
		
			// ALIGNMENT
			switch (align) {
				case LVFormatPattern.ALIGN_LEFT:
					tmpBuffer.insert(0, value);
					break;
				case LVFormatPattern.ALIGN_CENTER:
					if (pad > 0) {
						tmpBuffer.insert((pad/2), value);		
					}
					else {
						tmpBuffer.append(value);	
					}
					break;
				case LVFormatPattern.ALIGN_RIGHT:
					tmpBuffer.append(value);
					break;
			}
		
			return tmpBuffer.toString();
			
		}

	protected static String getCategory(LogRecord logRec) {					 
			if (logRec.getLocationName().equalsIgnoreCase(logRec.getSourceName())) { // LOCATION
				return logRec.getRelatives().toString();
			}
			else {
				return logRec.getSourceName();
			}
		}

	private String getMessage (LogRecord record) {
		
		String msg = null;
		String msgClear = record.getMsgClear();
		List 	 args 		= record.getArgs();
		
		if (!args.isEmpty()) {
			return formatMessage(msgClear, args.toArray());
		}
		else {
			return msgClear;
		}
	}
	
	private String formatMessage(String msgClear, Object[] args)
	{
		String result;
		try	{
			result = MessageFormat.format(msgClear, args);
		}
		catch (IllegalArgumentException ex) {
			result = "msg [" + msgClear + "]  params [" + args + "]";
		}
		return result;
	}
}
