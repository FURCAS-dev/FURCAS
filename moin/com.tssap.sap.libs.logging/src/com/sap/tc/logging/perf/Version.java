package com.sap.tc.logging.perf;

/**
 * Title:        Logging
 * Description:  Logging API
 * Copyright:    Copyright (c) 2004
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
 * <b>SAT</b><p>
 *
 * @author  Robert Boban
 * @version 1.5
 *
 * </p>
 * <table BORDER>
 *
 *       <caption> SAP Logging SAT Wrapper <caption>
 *
 *       <! The tile of the table>
 *       <tr>
 *       <td><b>Who           </b>
 *       <td><b>Date of Change</b>
 *       <td><b>Version       </b>
 *       <td><b>Comment       </b>
 *
 *       <! The start of the history>
 *       <tr>
 *       <td>Robert Boban
 *       <td>06. July. 2004
 *       <td>1.5
 *       <td>Init versioning
 *       </tr>
 * 
 *       <tr>
 *       <td>Robert Boban
 *       <td>06. July. 2004
 *       <td>1.5.0.1
 *       <td>Adding new field - CPUTime
 *       </tr>
 *
 *       <tr>
 *       <td>Robert Boban
 *       <td>06. July. 2004
 *       <td>1.5.0.2 - 26544
 *       <td>Refactoring
 *       </tr>
 * 
 *       <td>Robert Boban
 *       <td>13. July. 2004
 *       <td>1.5.0.3 - 32917
 *       <td>Fix PerfFormatter to support parse(byte[])
 *       </tr>
 *
 *       <td>Robert Boban
 *       <td>14. Dec. 2005
 *       <td>1.5.71.1001 
 *       <td>Fix PerfFormatter SAT parsing problem
 *       </tr>
 * 
 * </table>
 */

class Version
{
	//$JL-CONSOLE_LOG$ $JL-SYS_OUT_ERR$
	/* =================================================================== */
	// GENERATE ADDITIONAL INFORMATION 
	//
	// BRNACH NAME

	static private final String VERSION_BRANCH 	= "7.x";
		
	/* =================================================================== */
	// GENERATE FULL VERSION NUMBER
	// Generated version number will be/was created 
	// using version number template
	//
	//	VERSION_FINAL = MAJOR.MINOR.BUILD.REVISION
	
	static private final String VERSION_FULL 	= "1.5.7x.1001";
	
	/* =================================================================== */
	// GENERATE PRODUCT VERSION NUMBER
	// Generated version number will be/was created 
	// using component version number template
	//
	//	VERSION_FINAL = MAJOR.MINOR.FIX_BUILD
	
	static private final String VERSION_COMPONENT 	= "1.5.7x";

	/* =================================================================== */
	
	static String getFullVersion () 
	{
	    return VERSION_FULL; // + " - " + VERSION_BRANCH;
	}

	static String getComponentVersion () 
	{
		return VERSION_COMPONENT;
	}
	
	static String getVersionHeadFormat () 
	{
		StringBuffer verFormat = new StringBuffer();
		
		verFormat.append("*********************************************\n");
		verFormat.append("     SAP Logging SAT Wrapper\n");
		verFormat.append("              "  + getFullVersion() + "\n"); 
		verFormat.append("*********************************************\n");
		
		return verFormat.toString();
	}
	/* =================================================================== */
	
	public static void main (String args []) throws Exception
	{
	    System.out.println ("SAP Logging SAT Wrapper " + Version.getFullVersion ());
	
	}
	
	/* =================================================================== */

}

/* == End of file ======================================================== */
