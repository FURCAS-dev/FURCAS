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

import java.util.*;
import java.text.*;
import java.io.*;

import com.sap.tc.logging.interfaces.IObjectInfo;

public class Group implements IObjectInfo{

	//================================================ declaration > ====
	
  static final String OPENING_MSG   = "Opening group",
											CLOSING_MSG   = "Closing group",
											NO_GROUP_EMSG = "No such group";

	private String				logVerInUse;
	
	private GUId            id;
	private Group						grpParent;
	private Map							grpChildren;
	private String					grpName;
	private String					grpDescription;
	private int							level;
	private int							indent;
	private String   				lcName;
	private String   				lcSubName;
	private LogController[] relatives;
	private int             severity;
	private boolean					isOpened = true;
	private boolean					isCommitted;
	
	//==== < declaration ============================ constructors > ====
	
  Group(String 					lcName,
  			String 					lcSubName,
  			LogController[] relatives,
  			String 					name,
				String 					description,
  		  Group 					parent,
  		  int 						level,
  		  int							severity){
  		  	
	  this.id        			= new GUId();
	  this.grpParent			= parent;
		this.grpName 	 			= name;
		this.grpDescription = description;
		this.level     			= level;
	  this.lcName       	= lcName;
	  this.lcSubName			= lcSubName;
	  this.relatives 			= relatives;
	  this.severity  			= severity;
	  
	  this.grpParent.addChild(this);
	}

	Group(LogController 	lc,
				String 					lcSubName,
				LogController[] relatives,
				String 					name,
				String 					description,
			  Group 					parent,
			  int 						level,
			  int							severity){
	  
		if (lc == null) throw new IllegalArgumentException();
	  	
	  this.id        			= new GUId();
	  this.grpParent			= parent;
		this.grpName 	 			= name;
		this.grpDescription = description;
		this.level     			= level;
		this.lcName 				= lc.getName();
	  this.lcSubName			= lcSubName;
	  this.relatives 			= relatives;
	  this.severity  			= severity;
	  
		if (lcSubName != null) {
			this.lcName = this.lcName + Location.SEPARATOR + lcSubName;
		}
		
		if (grpParent != null) {
			this.grpParent.addChild(this);
		}
		
	}

	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====
	  
  public GUId getId() {
    return id;
  }
  
  public Group getParent() {
			  return grpParent;
	}
	
	public void addChild(Group group) {
		if (grpChildren == null) {
			grpChildren = new HashMap();
		}
		grpChildren.put(group.getId(), group);
	}
	
	public void removeChild(Group group) {
		if (grpChildren == null || group == null) return;
		grpChildren.remove(group.getId());
	}
	
	public void open(LogController src) {
		if (src == null) return;
		// Write Open Group message
		setCommitted(true);
	}
	
	public synchronized void close(LogController src) {
		if (src == null) return;
		
		// Clear 
		closeInt(src);
		
	}
	
	//*******************************************************
	// Implementation of the IObjectInfo interface
	//*******************************************************
  public void setName(String value) {
		grpName = value;
	}
	
  public String getName() {
	  return grpName;
	}

	public void setDescription(String value) {
		grpDescription = value;
	}

	public String getDescription() {
		return grpDescription;
	}
	
	/**
	 * Gets the version of API.
	 */
	public synchronized String getVerInUse(){
		return logVerInUse;
	}
	
	//*******************************************************

  public String getLocationName() {
    return lcName;
  }

  public void setSubLocationName(String value) {
	  lcSubName = value;
  }
	
  public String getSubLocationName() {
	  return lcSubName;
  }
  
  public LogController[] getRelatives() {
	  return relatives;
	}

  public int getSeverity() {
    return severity;
  }

  public int getLevel() {
	  return level;
	}
	   
	public int getIndent() {
		return indent;
	}
	
	public boolean isOpened() {
		return isOpened;	
	}
	
	public void setCommitted(boolean value) {
		isCommitted = value;	
	}
	
	public boolean isCommitted() {
			return isCommitted;	
	}
	
  public boolean equals(Object obj) {
    if (obj instanceof Group) {
      return ((Group) obj).id == this.id;
    } else {
      return false;
    }
  }

  public int hashCode() {
    return id.hashCode();
  }

	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	
	private void closeInt(LogController src) {
		// Remove children
 		if (grpChildren != null && !grpChildren.isEmpty()) {
	 		Object[] groups = grpChildren.values().toArray();
	 		for (int i = 0; i < groups.length; i++) {
		 		((Group)groups[i]).closeInt(src);
	 		}
	 		grpChildren.clear();
	 		grpChildren = null;
 		}
 		
		// Remove from parent
		if (grpParent != null) grpParent.removeChild(this);
	}
	
	//==== < private ================================== deprecated > ====
	
}
