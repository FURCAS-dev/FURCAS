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

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


class CmdOption
{
	
	//================================================ declaration > ====

	private static final int namePrefixLength = 2;
	
	private String opPrefix 	= null;
	private String name 			= null;
	private String namePrefix = null;
	private List values 			= new LinkedList ();
	
	//==== < declaration ============================ constructors > ====
	
	CmdOption() {}
	
	CmdOption (String name, String opPrefix)
	{
   	// Check for prefix
   	if (opPrefix.equals(name.substring(0, 1))) {
			if (name.length() < namePrefixLength + opPrefix.length()) { 
				setNamePrefix(name.substring(opPrefix.length()));
				setName(CmdOptionPrefixes.parse(getNamePrefix()));
			}
			else {
				setName (name.substring(opPrefix.length()));
			}	
			setOpPrefix (opPrefix);
   	}
   	else {
   		// Option without prefix
			setName (name);
   	}
	}
  
  //==== < constructors =============================== abstarct > ====
  //==== < abstract ===================================== public > ====
  
  public String getOpPrefix ()
  {
	  return opPrefix;
  }
  
  public String getName ()
  {
	  return name;
  }
  
  public String getNamePrefix ()
	{
		return namePrefix;
	}
	 
  public Iterator getValues ()
	{
		return values.iterator ();
	}

	public String [] toArray ()
	{
		return (String []) values.toArray (new String [values.size ()]);
	}

	public int size ()
	{
		return values.size ();
	}

	public String getValueAt (int index)
	{
		return (String) values.get (index);
	}
	 
  //==== < public ==================================== protected > ====
  //==== < protected =================================== default > ====
  
  void setOpPrefix (String opPrefix)
  {
	  this.opPrefix = opPrefix;
  }
	 
  void setName (String name)
	{
		this.name = name;
	}
	
	void setNamePrefix (String namePrefix)
	{
		this.namePrefix = namePrefix;
	}
	  
	void addValue (String value)
	{
		values.add (value);
	}
	
	String getMethodName (String prefix)
	{
		return prefix + getName ();
	}

	public String toString ()
	{
		StringBuffer buf = new StringBuffer ();

		for (Iterator it = getValues (); it.hasNext (); buf.append (' ')) {
			buf.append ((String) it.next ());
		}

		return buf.toString ();
	}
	  
  //==== < default ===================================== private > ====
  //==== < private ================================== deprecated > ====

}
