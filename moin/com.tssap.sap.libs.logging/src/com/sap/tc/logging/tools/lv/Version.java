package com.sap.tc.logging.tools.lv;

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

/**
 * <b>Logging Viewer Command Line Tool Version</b><p>
 *
 * @author  Robert Boban
 * @version 2.0
 *
 * </p>
 * <table BORDER>
 *
 *       <caption> Logging Viewer Command Line Tool <caption>
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
 *       <td>17. Feb. 2004
 *       <td>2.0
 *       <td>Init versioning
 *       </tr>
 * 
 *       <tr>
 *       <td>Robert Boban
 *       <td>16. Apr. 2004
 *       <td>2.0.0.2
 *       <td>New formatter option handling
 * 			 <td>%m option
 * 			 <td>[a,n] option
 *       </tr>
 * 
 *			<tr>
 *       <td>Robert Boban
 *       <td>19. Apr. 2004
 *       <td>2.0.0.3
 *       <td>Support for telnet (J2EE)
 *       <td>-t option doesn't work in J2EE cmd console
 *       </tr>
 *
 *			<tr>
 *       <td>Robert Boban
 *       <td>09. Juni. 2004
 *       <td>2.0.0.4
 *       <td>-t option was fixed on LVReader
 *       </tr>
 * 
 *			<tr>
 *       <td>Robert Boban
 *       <td>01. July. 2004
 *       <td>2.0.1.0 - 20394
 *       <td>New parser
 *       <td>-e eventLog option
 *       </tr>
 *
 *			<tr>
 *       <td>Robert Boban
 *       <td>02. July. 2004
 *       <td>2.0.1.1 - 21007
 *       <td>Fix -t option
 *       </tr>
 * 
 *			<tr>
 *       <td>Robert Boban
 *       <td>05. July. 2004
 *       <td>2.0.1.2 - 24097
 *       <td>Fix new reader structure
 *       </tr>
 * 
 *			<tr>
 *       <td>Robert Boban
 *       <td>06. July. 2004
 *       <td>2.0.1.3 - 25800
 *       <td>Fix -e option - logging.log doesn't exists
 *       <td>Fix -t option - null pointer exception
 *       </tr>
 *
 *			<tr>
 *       <td>Robert Boban
 *       <td>12. July. 2004
 *       <td>2.0.1.4 - 100700
 *       <td>Impl - support for ReadLog mode
 *       </tr>
 *
 *			<tr>
 *       <td>Robert Boban
 *       <td>12. July. 2004
 *       <td>2.0.1.5 - 172376
 *       <td>fix - date format
 *       <td>impl - -h fixed
 *       </tr>
 * 
 *			<tr>
 *       <td>Robert Boban
 *       <td>08. Nov. 2004
 *       <td>2.0.1.6 
 *       <td>FileSet
 *       <td>Help
 *       </tr>
 * 
 *			<tr>
 *       <td>Robert Boban
 *       <td>15. Nov. 2004
 *       <td>2.0.1.7 
 *       <td>-fix - FileSet
 *       </tr>
 *
 *			<tr>
 *       <td>Robert Boban
 *       <td>13. Dec. 2004
 *       <td>2.0.1.8 
 *       <td>-fix - The message File '' could not be found or created!
 *       </tr>
 * 
 *			<tr>
 *       <td>Robert Boban
 *       <td>13. Dec. 2004
 *       <td>2.0.1.9 
 *       <td>-fix - Help errors
 * 			 <td>-fix - indexing of files (-i option)
 *       </tr>
 * 
 *			<tr>
 *       <td>Robert Boban
 *       <td>24. Jan. 2005
 *       <td>2.0.1.10
 *       <td>-fix - Help text
 *       </tr>
 * 
 *			<tr>
 *       <td>Robert Boban
 *       <td>21. Jun. 2005
 *       <td>2.0.1.11
 *       <td>-fix - Reading single file / file set file
 *       </tr>
 * 
 * </table>
 */

import com.sap.tc.logging.*;

class Version
{
  
	/* =================================================================== */
	// GENERATE ADDITIONAL INFORMATION 
	//
	// BRNACH NAME

	static private final String VERSION_BRANCH 	= "71";
		
	/* =================================================================== */
	// GENERATE FULL VERSION NUMBER
	// Generated version number will be/was created 
	// using version number template
	//
	//	VERSION_FINAL = MAJOR.MINOR.BUILD.REVISION
	
	static private final String VERSION_FULL 	= "2.0.1.11";
	
	/* =================================================================== */
	// GENERATE PRODUCT VERSION NUMBER
	// Generated version number will be/was created 
	// using component version number template
	//
	//	VERSION_FINAL = MAJOR.MINOR.FIX_BUILD
	
	static private final String VERSION_COMPONENT 	= "2.0.1";

	/* =================================================================== */
	
    static String getFullVersion () 
    {
        return VERSION_FULL + " - " + VERSION_BRANCH;
    }

	static String getComponentVersion () 
	{
		return VERSION_COMPONENT;
	}
	
	static String getVersionHeadFormat () 
	{
		StringBuffer verFormat = new StringBuffer();
		
		verFormat.append("*********************************************\n");
		verFormat.append("     SAP Logging Viewer command line tool\n");
		verFormat.append("              "  + getFullVersion() + "\n"); 
		verFormat.append("                 using\n");
		verFormat.append("            SAP Logging API\n");
		verFormat.append("             "  + com.sap.tc.logging.Version.getFullVersion() + "\n"); 
		verFormat.append("*********************************************\n");
		
		return verFormat.toString();
	}
    /* =================================================================== */

    public static void main (String args []) throws Exception
    {
        System.out.println ("SAP Logging Viewer command line tool version " + Version.getFullVersion ());

    }

    /* =================================================================== */

}

/* == End of file ======================================================== */
