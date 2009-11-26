package com.sap.tc.logging;

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

import java.net.*;
//import java.rmi.server.UID;

public class GUId 
{ //$JL-EQUALS$	$JL-EXC$
	//================================================ declaration > ====
	
	private String id;
	long correlatorID = UID.EMPTY_CORRELATOR_ID;
	
	//==== < declaration ============================ constructors > ====
	
  GUId() {
  }

  GUId(String guid) {
    id = guid;
  }
  
  GUId(long correlatorId) {
	  correlatorID = correlatorId;
  }

	//==== < constructors =============================== abstarct > ====
	
  synchronized public String toString() {
    // Lazily evaluate id because it is not always needed, for example in case
    // of the default pattern of TraceFormatter, and generation is very costly.
    try {
	    if (id == null) {
//	    	id = new UID(correlatorID).toString();
            id = new UID().toString();
	    }
    }
    catch(Throwable ex) {
    	id = " ";	
    }
    return id;
  }

  public boolean equals(Object obj) {
    if (obj instanceof GUId) {
      return this.toString().equalsIgnoreCase(((GUId) obj).toString());
    } else {
      return false;
    }
  }
  
	//==== < abstract ===================================== public > ====
	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	//==== < private ================================== deprecated > ====

}