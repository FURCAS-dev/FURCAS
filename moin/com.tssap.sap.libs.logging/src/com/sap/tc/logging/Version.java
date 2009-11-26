// ==========================================================================
//  File $Id:$
// ==========================================================================

package com.sap.tc.logging;

/* == Import list ======================================================== */
import java.util.*;
/* ======================================================================= */

/**
 * <b>Logging API Version</b><p>
 *
 * @author  Robert Boban
 * @version 1.0
 *
 * </p>
 * <table BORDER>
 *
 *       <caption> Logging API version history <caption>
 *
 *       <! The tile of the table>
 *       <tr>
 *       <td><b>Who           </b>
 *       <td><b>Date of Change</b>
 *       <td><b>Version       </b>
 *       <td><b>Comment       </b>
 *
 *       <! The start of the history>
 *
 *  		<tr>
 *       <td>Robert Boban
 *       <td>14.03.2005
 *       <td>1.5.71.1000
 *       <td>- fix reader - ready for the new format
 *		 </tr>
 *  	
 * 		 <tr>
 *       <td>Robert Boban
 *       <td>21.04.2005
 *       <td>1.5.71.1001
 *       <td>- fix reading masked delimiter in prev direction
 * 			 <td>- fix SQLTraceFormatter doesn't overridde new method. 
 *			 <td>- fix LogRecord exception string builder
 *			 <td>- impl Category collection to Public
 *		 </tr>
 *
 *  	 <tr>
 *       <td>Robert Boban
 *       <td>24.04.2005
 *       <td>1.5.71.1002
 *       <td>- fix readNext() loop
 * 			 <td>- fix ArrayIndexOfBound on FileLogInfoData class 
 *			 <td>- fix parser delimiter resolving
 *		 </tr>
 *	  <tr>
 *       <td>Robert Boban
 *       <td>18.07.2005
 *       <td>1.5.7x.1000
 *       <td>- impl BACKSPACE
 *		 </tr>
 *
 *	  <tr>
 *       <td>Robert Boban
 *       <td>18.07.2005
 *       <td>1.5.7x.1001
 *       <td>- impl UNICODE
 *		 </tr>
 *
 *	  <tr>
 *       <td>Robert Boban
 *       <td>8.11.2005
 *       <td>1.5.7x.1002
 *       <td>- fix Double msk delimiter problem (\\#)
 *		 </tr>
 *
 *	  <tr>
 *       <td>Robert Boban
 *       <td>16.01.2006
 *       <td>1.5.7x.1003
 *       <td>- impl Message object on Location
 *		 </tr>
 *
 *	  <tr>
 *       <td>Robert Boban
 *       <td>20.01.2006
 *       <td>1.5.7x.1004
 *       <td>- fix - SQLTrace - delete logs!
 *		 </tr>
 *
 *	  <tr>
 *       <td>Robert Boban
 *       <td>13.03.2006
 *       <td>1.5.7x.1005
 *       <td>- impl - Configuration check
 *       <td>- impl - Activity tracking if check
 *		 </tr>
 *
 *	  <tr>
 *       <td>Robert Boban
 *       <td>19.05.2006
 *       <td>1.5.7x.1006
 *       <td>- fix - Fix a problem with adding the same log to the private and local collection
 *       <td>- fix - wrong beError in fatalT method
 *		 </tr>
 *
 * </table>
 */

public class Version
{
	//$JL-CONSOLE_LOG$ $JL-SYS_OUT_ERR$
  
    public static final int VER_CODE_2_0 		= 20;
    public static final int VER_CODE_1_6 		= 16;
    public static final int VER_CODE_1_5 		= 15;
    public static final int VER_CODE_1_4 		= 14;
    public static final int VER_CODE_1_3 		= 13;
    public static final int VER_CODE_1_2 		= 12;
    public static final int VER_CODE_UNKNOWN = 0;
  
	/* =================================================================== */
	// GENERATE ADDITIONAL INFORMATION 
	//
	// BRNACH NAME

	static private final String VERSION_BRANCH_NAME 	= "7.x";
		
	/* =================================================================== */
	// GENERATE FULL VERSION NUMBER
	// Generated version number will be/was created 
	// using version number template
	//
	//	VERSION_FINAL = MAJOR.MINOR.BUILD.REVISION
	
	static private final int VERSION_MAJOR 			= 2;
	static private final int VERSION_MINOR 			= 0;
	static private final String VERSION_BUILD 	= "7";
	static private final int VERSION_REVISION 	= 1006;
	
	static private final String VERSION_FULL 	= VERSION_MAJOR 
																						+ "." + VERSION_MINOR 
																						+ "." + VERSION_BUILD 
																						+ "." + VERSION_REVISION;
	
	/* =================================================================== */
	// GENERATE PRODUCT VERSION NUMBER
	// Generated version number will be/was created 
	// using component version number template
	//
	//	VERSION_FINAL = MAJOR.MINOR
	
	static private final String VERSION_PRODUCT 	= "2.0";

	//GENERATE PRODUCT BUILD (BRANCH) VERSION NUMBER
	// Generated version number will be/was created 
	// using component version number template
	//
	//	VERSION_FINAL = MAJOR.MINOR.BUILD
	
	static private final String VERSION_BRANCH 	= "1.5.7x";

	private static String verOfFirstRec = "2.0";
	
	/* =================================================================== */
	
	public static boolean isCompatible(String withVersion) {
		
		int		index				= 1;
		String  currVer   = "";
		String  compVer		= "";
		
		// Remove dots ... current version
		StringTokenizer tokens = new StringTokenizer(getFullVersion(),".", false);
		while (tokens.hasMoreTokens()) {
			String token = tokens.nextToken();
			if (index == 4 && token.length() > 4) {
				token = token.substring(0, 4);
			}
			currVer += token;
			index++;
		}
		
		// Remove dots ... comp version
		tokens = new StringTokenizer(withVersion,".", false);
		while (tokens.hasMoreTokens()) {
			String token = tokens.nextToken();
			if (index == 4 && token.length() > 4) {
				token = token.substring(0, 4);
			}
			compVer += token;
			index++;
		}
		
		return (new Integer(currVer).intValue() > new Integer(compVer).intValue());
	}
	
	public static String getFullVersion () 
	{
	    return VERSION_FULL;// + " - " + VERSION_BRANCH_NAME;
	}
	
	public static String getVersion () 
	{
	    return VERSION_FULL;
	}

	public static void setVersionOfFirstRecord(String verOfFirstRecord) {
	  verOfFirstRec = verOfFirstRecord; 
	}

	public static String getVersionOfFirstRecord() {
	  return verOfFirstRec; 
	}
	
	static String getBranchVersion () 
	{
		return VERSION_BRANCH;
	}
	
	public static String getProductVersion () 
	{
		return VERSION_PRODUCT;
	}
	
	public static int getVersionIndex (String value) 
	{
		String msgVersion = value;
		
		if (msgVersion == null)         return VER_CODE_UNKNOWN;
		if (msgVersion.equals("1.5"))   return VER_CODE_1_5;
		if (msgVersion.equals("1.4"))   return VER_CODE_1_5;
		if (msgVersion.equals("1.3"))   return VER_CODE_1_5;
		if (msgVersion.equals("1.2"))   return VER_CODE_1_5;
		if (msgVersion.equals("1.6"))   return VER_CODE_1_6;
        if (msgVersion.equals("2.0"))   return VER_CODE_2_0;
		
		return VER_CODE_UNKNOWN;
	}
	
	static String getVersionHeadFormat () 
	{
		return "";
		/*
		StringBuffer verFormat = new StringBuffer();
		
		verFormat.append("*********************************************" + Formatter.EOL);
		verFormat.append("              SAP Logging API" + Formatter.EOL);
		verFormat.append("               "  + getFullVersion() + Formatter.EOL); 
		verFormat.append("*********************************************" + Formatter.EOL);
		
		return verFormat.toString();*/
	}
    /* =================================================================== */

    public static void main (String args []) throws Exception
    {
        System.out.println ("Logging API Version " + Version.getFullVersion ());

    }

    /* =================================================================== */

}

/* == End of file ======================================================== */
