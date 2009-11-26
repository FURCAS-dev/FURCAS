package com.sap.tc.logging.perf;

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

import com.sap.tc.logging.*;

public class PerfTracing
{
	// $JL-LOG_CONFIG$
  public  static final String   DEF_LOC_NAME = "SATRecorder";
  public  static final String   DEF_CAT_NAME = "/Performance";
  public  static final String   DEF_FILE_PATH = "./log/sat.trc";

  static         final Category catWrp       = Category.PERFORMANCE;
  static         final Location LC           = Location.getLocation (DEF_LOC_NAME, "tc~logging~java", "BC-JAS-ADM-LOG-API");
  private static       Log cLog;
  private              String logPath        = DEF_FILE_PATH;

  public PerfTracing()
  {
      init();
  }

  public PerfTracing(String logPath)
  {
      this.logPath = logPath;
      init();
  }

  private void init()
  {
      if (catWrp.getLogs().size() == 0)
      {
      	cLog = new FileLog (logPath,10000000,10);
      	cLog.setFormatter(new PerfFormatter());
      	catWrp.addLog(cLog);
      }
      catWrp.setEffectiveSeverity(Severity.ALL);
  }

  public void logWrite(ISatRecord record)
  {
      catWrp.infoT (LC, "SATRecord", ((SatRecord) record).getLogArray());
  }
}