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

import java.io.*;

import com.sap.tc.logging.*;
import com.sap.tc.logging.exceptions.*;

public class LV 
{
	//$JL-CONSOLE_LOG$ $JL-SYS_OUT_ERR$ $JL-LOG_CONFIG$ $JL-EXC$
	//================================================ declaration > ====
	
	LVAction lvAction;
	
	//==== < declaration ============================ constructors > ====
	
	public static void main (String args [])
	{
		new LV (args);
	}

	public LV (String args []) 
	{
		init(new PrintWriter(new BufferedOutputStream(System.out)), args, false);
	}

	public LV (OutputStream outSystem, String args []) 
	{
		init(new PrintWriter(new BufferedOutputStream(outSystem)), args, true);
	}

	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====
	
	public void reset() 
	{
		lvAction.reset(); 
	}
	
	//==== < public ==================================== protected > ====
  //==== < protected =================================== default > ====
  //==== < default ===================================== private > ====
  
  //TODO-BOBAN: isJ2EE flag is temp to prevent invocation of -t option on j2EE console
  private void init(PrintWriter outSystem, String args [], boolean isJ2EE) 
  {
  	boolean isExcOk = true;
  	
		try {
			
			// INIT Logging API Event Log
			//setLoggingEnv();
				
			CmdOptionList optionList;
			LVOptions 		lvOptions;
			
			CmdOptionPrefixes.setPrefixes(LVOptions.optionPrefixes);
			
			optionList = CmdOptionList.parse (args);			
			
			lvOptions  = new LVOptions ();
				
			optionList.evaluate (lvOptions);
				
			lvOptions.outSystem = outSystem;
			
			// Temp flag 
			// -t option does not work in J2EE cmd console!
			if(isJ2EE) {
				lvOptions.isTail 			= false;
				lvOptions.isBatchMode = true;
			}
						
			execute(lvOptions);
		}
		catch (LoggingBaseException ex) {
			outSystem.println (ex.getMessage());
			outSystem.println (ex.getAdditionalInfo());
			isExcOk = false;
		}
		catch (Exception ex) {
			outSystem.println (ex.getMessage());
			isExcOk = false;
		}
		finally {
			if (isExcOk) {
				outSystem.println ("LV Tool finished sucessfully");
			}
			else {
				outSystem.println ("LV Tool terminated with errors!");
			}
			outSystem.flush();
			System.exit (0);
		}	
  }
  
	private void execute (LVOptions lvOpt) throws Exception
	{
		lvAction = new LVAction();
		lvAction.execute(lvOpt);
	}
  
	private void setLoggingEnv() {
		FileLog log = new FileLog("logging.log");
	
		Location loc = Location.getLocation("com.sap.tc.logging", "tc~logging~java", "BC-JAS-ADM-LOG-API");
		loc.addLog(log);
		loc.setEffectiveSeverity(Severity.NONE);
	
		Category.SYS_LOGGING.addLog(log);
		Category.SYS_LOGGING.setEffectiveSeverity(Severity.NONE);
	}
  
  //==== < private ================================== deprecated > ====

}
