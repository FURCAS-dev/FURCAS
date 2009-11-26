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

class LVFormatPattern {
	
	//================================================ declaration > ====
	
	public static final int 		OPT_MIN							= 0;
	public static final int 		OPT_DATE						= OPT_MIN + 1;
	public static final int 		OPT_TIME						= OPT_DATE + 1;
	public static final int 		OPT_SEVERITY				= OPT_TIME + 1;
	public static final int 		OPT_GUID						= OPT_SEVERITY + 1;
	public static final int 		OPT_LOCATION				= OPT_GUID + 1;
	public static final int 		OPT_CATEGORY				= OPT_LOCATION + 1;
	public static final int 		OPT_MESSAGE					= OPT_CATEGORY + 1;
	public static final int 		OPT_MAX							= OPT_MESSAGE + 1;
	
	private static final String DEFAULT_FORMAT 			= "%d %t %s %m";
	
	private static final int  	DEF_MESSAGE_WIDTH 	= -1;
	private static final int 	 	DEF_DATE_WIDTH 			= 10;
	private static final int 	 	DEF_TIME_WIDTH 			= 12;
	private static final int 	 	DEF_SEVERITY_WIDTH 	= 8;
	private static final int 	 	DEF_GUID_WIDTH 			= 35;
	private static final int 	 	DEF_LOCATION_WIDTH 	= 35;
	private static final int 	 	DEF_CATEGORY_WIDTH 	= 35;
	
	public static final int 		ALIGN_LEFT 					= 1,
															ALIGN_CENTER 				= 2,
															ALIGN_RIGHT 				= 3;
	
	public static List parsedOptions;
		
	public static String help =
	"Format options:\n" +
	"  -format <format pattern>\n" +
	"   With this option the format of a message can be customized\n" +	
	"   Default pattern = " + DEFAULT_FORMAT + "\n" +	
	"   Format pattern elements:\n" +	
	"    %m[a,n]\n" + 
	"     print the message\n" +
	"     <a> is the alignment. \n" +
	"       <l>eft, <c>enter, <r>ight - default is <l>eft\n" +
	"     <n> is the maximum width of the field\n" +	"       default is " + DEF_MESSAGE_WIDTH + " char\n" +			
	"    %d[a,n]\n" + 
	"     print the date of the message\n" +
	"     <a> is the alignment. \n" +
	"       <l>eft, <c>enter, <r>ight - default is <l>eft\n" +
	"     <n> is the maximum width of the field\n" +
	"       default is " + DEF_DATE_WIDTH + " char\n" +		
	"    %t[a,n]\n" + 
	"     print the time of the message\n" +
	"     <a> is the alignment. \n" +
	"       <l>eft, <c>enter, <r>ight - default is <l>eft\n" +
	"     <n> is the maximum width of the field\n" +
	"       default is " + DEF_TIME_WIDTH + " char\n" +		
	"    %s[a,n]\n" + 
	"     print the severity of the message\n" +
	"     <a> is the alignment. \n" +
	"       <l>eft, <c>enter, <r>ight - default is <l>eft\n" +
	"     <n> is the maximum width of the field\n" +
	"       default is " + DEF_SEVERITY_WIDTH + " char\n" +			
	"    %g[a,n]\n" + 
	"     print the guid of the message\n" +
	"     <a> is the alignment. \n" +
	"       <l>eft, <c>enter, <r>ight - default is <l>eft\n" +
	"     <n> is the maximum width of the field\n" +
	"       default is " + DEF_GUID_WIDTH + " char\n" +
	"    %l[a,n]\n" +
	"     print the location of the message\n" +
	"     <a> is the alignment. \n" +
	"       <l>eft, <c>enter, <r>ight - default is <l>eft\n" +
	"     <n> is the maximum width of the field\n" +
	"       default is " + DEF_LOCATION_WIDTH + " char\n" + 
	"    %c[a,n]\n" +
	"     print the category of the message\n" +
	"     <a> is the alignment. \n" +
	"       <l>eft, <c>enter, <r>ight - default is <l>eft\n" +
	"     <n> is the maximum width of the field\n" +
	"       default is " + DEF_CATEGORY_WIDTH + " char\n";
	
	static HashMap formatOptions 		= new HashMap();
	
	static {
		formatOptions.put("D", new LVFormatOption("date", 		OPT_DATE,			DEF_DATE_WIDTH, 		ALIGN_LEFT));
		formatOptions.put("T", new LVFormatOption("time", 		OPT_TIME,			DEF_TIME_WIDTH, 		ALIGN_LEFT));
		formatOptions.put("S", new LVFormatOption("severity", OPT_SEVERITY,	DEF_SEVERITY_WIDTH, ALIGN_LEFT));
		formatOptions.put("G", new LVFormatOption("guid", 		OPT_GUID,			DEF_GUID_WIDTH, 		ALIGN_LEFT));
		formatOptions.put("L", new LVFormatOption("location", OPT_LOCATION,	DEF_LOCATION_WIDTH, ALIGN_LEFT));
		formatOptions.put("C", new LVFormatOption("category", OPT_CATEGORY,	DEF_CATEGORY_WIDTH, ALIGN_LEFT));
		formatOptions.put("M", new LVFormatOption("message",  OPT_MESSAGE,	DEF_MESSAGE_WIDTH, ALIGN_LEFT));
	}  
	
	//==== < declaration ============================ constructors > ====
	
	public LVFormatPattern (String pattern) {
		parse(pattern);
	}
	
	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====
	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	
	private void parse(String pattern) {
		
		StringBuffer 	buf 				= new StringBuffer(pattern);		
		int 					patternLen	= pattern.length();
		char 					curVal			= 0;

		parsedOptions = new LinkedList();

		for(int i = 0; i < patternLen; ++i) {
			
			switch(buf.charAt(i)) {
				case '%': {
					
					String key = String.valueOf(buf.charAt(i + 1)).toUpperCase();
					
					// Find an option in the collection
					if (formatOptions.containsKey(key)) {
						
						LVFormatOption formatOpt = (LVFormatOption) formatOptions.get(key);
						
						// Option is enabled
						formatOpt.isEnabled = true;
						
						// Move to next ...
						i++;
						
						// [a,n]
						// Get align ... [a
						if ((buf.length() > (i + 1)) && buf.charAt(i + 1) == '[') {
							switch (buf.charAt(i + 2)) {
								case 'l': // LEFT
									formatOpt.align = ALIGN_LEFT;
									break;
								case 'c': // CENTER
									formatOpt.align = ALIGN_CENTER;
									break;
								case 'r': // RIGHT
									formatOpt.align = ALIGN_RIGHT;
									break;
							}
							// Jump over [a ...
							i = i + 2;
						}
						
						// Get width ,n] ...
						if ((buf.length() > (i + 1)) && buf.charAt(i + 1) == ',') {
							
							StringBuffer digit = new StringBuffer();
							int index 				 = 0;
							
							for (index = (i + 2); index < patternLen; index++) {
								curVal = buf.charAt(index);
								if (curVal == ']') {
									break;	
								}
								else if (Character.isDigit(curVal)) {
									digit.append(curVal);	
								}
							}
							
							if (index > (i + 2)) {
								formatOpt.width = Integer.parseInt(digit.toString());
							}
							
							// Jump over ,n] ...
							i = index;
						}
						
						parsedOptions.add(formatOpt);
						
					}
				}
			}
		}
	}
	
	//==== < private ================================== deprecated > ====

}
