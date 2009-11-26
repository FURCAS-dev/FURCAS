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

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import java.net.URL;

import java.util.Iterator;
import java.util.List;

import com.sap.tc.logging.*;

class LVAction
    	extends LVActionConstants
{ //$JL-SWITCH$
	//================================================ declaration > ====
	
	private LVReader lvReader;
	
	//==== < declaration ============================ constructors > ====
    
 	protected LVAction (){}

  //==== < constructors =============================== abstarct > ====
  //==== < abstract ===================================== public > ====
  
	public void execute (LVOptions lvOptions) throws Exception
  {
  	switch (lvOptions.action) {
    	case ACTION_READ_FILE_PATH:
				lvOptions.outSystem.println(DESC_ACTION_READ_FILE_PATH);
				lvReader = new LVReader(lvOptions);
				lvReader.read();
        break;

     	case ACTION_VERSION:
				lvOptions.outSystem.println(DESC_ACTION_VERSION);
				lvOptions.outSystem.println(doVersion());
        break;

    	case ACTION_HELP:
				lvOptions.outSystem.println(DESC_ACTION_HELP);
				lvOptions.outSystem.println(doHelp());
        break;
        
			case ACTION_UNKNOWN:
				lvOptions.outSystem.println(DESC_ACTION_UNKNOWN);

	    default:
				lvOptions.outSystem.println("Nothing to do ...");
	      break;
  	}
		lvOptions.outSystem.flush();
	}

	public void reset() 
	{
		lvReader.getLVOptions().isBatchMode = true;
	}

	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====

	private String doVersion () 
	{
		return Version.getVersionHeadFormat();
	}

	private String doHelp () 
  {
		return doVersion () + LVOptions.help;
  }

	//==== < private ================================== deprecated > ====
		
}