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
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.sap.tc.logging.*;


public class CmdOptionList
{
  //$JL-CONSOLE_LOG$ $JL-SYS_OUT_ERR$ $JL-EXC$
	//================================================ declaration > ====

	static final String METHOD_PREFIX    = "parse";
	static final Class  OPTION_CLASS     = new CmdOption ().getClass ();
	
	private List options = null;
	
	//==== < declaration ============================ constructors > ====
	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====
	
	static public CmdOptionList parse (String args [])
  {
	return parse ("-", args, false);
  }
	
	static public CmdOptionList parse (String args [], boolean collect)
	{
		return parse ("-", args, true);
	}
	
	static public CmdOptionList parse (String opPrefix, String args [])
	{
		return parse (opPrefix, args, false);
	}
	
	static public CmdOptionList parse (String opPrefix, String args [], boolean collect)
	{
		CmdOptionList list   = new CmdOptionList ();
		CmdOption     option = new CmdOption (opPrefix + "NoNamePrefix", opPrefix);
	
		for (int i = 0; i < args.length; i++) {
			if (args [i].startsWith (opPrefix)) {
				if (collect) {
					option = list.getOptionByName (args [i]);
			  	if (option == null) {
						option = new CmdOption (args [i], opPrefix);
			  	}
				}
				else {
					option = new CmdOption (args [i], opPrefix);
				}
			}
			else {
				option.addValue (args [i]);
			}
			list.addOption (option);
		}
	
		return list;
	}
	
	public Iterator getOptions ()
	{
		if (options == null) {
		return Collections.EMPTY_LIST.iterator ();
	  }
	  return options.iterator ();
	}

	public CmdOption getOptionByName (String name)
	{
		CmdOption option;

		for (Iterator it = getOptions (); it.hasNext ();) {
			option = (CmdOption) it.next ();
			if (option.getName ().equals (name)) {
				return option;
			}
		}
		return null;
	}

	public void evaluate (Object obj) throws Exception
	{
		Map       methodMap;
		String    methodName;
		Method    method;
		CmdOption option;
	
		methodMap = getParseMethods (obj);
	
		for (Iterator it = getOptions (); it.hasNext (); ) {
			option     = (CmdOption) it.next ();
			methodName = option.getMethodName (METHOD_PREFIX);
			methodName = methodName.toUpperCase();
			method     = (Method) methodMap.get (methodName);
	
			if (method == null) {
				throw new IllegalArgumentException (option.toString());
			}
			method.invoke (obj, new Object [] {option});
		}
	}

	public static void main (String args [])
	{
		try
		{
			CmdOptionList col = CmdOptionList.parse (args);
	
			//col.evaluate (new com.sapmarkets.technology.dmt.main.DMT (args));
	
			System.exit (0);
		}
		catch (Exception ex)
		{
			System.err.println (ex.getMessage ());
			//System.err.println (ExceptionManager.getStackTrace (ex));
			System.exit (1);
		}
	}

			
	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	
	void addOption (CmdOption option)
	{
		if (options == null) {
			options = new LinkedList ();
		}
		options.add (option);
	}
	
	//==== < default ===================================== private > ====
 
	private Map getParseMethods (Object obj)
	{
    Method methods [];
    Class  pTypes  [];
    Class  eTypes  [];
    Map    methMap;

    methMap = new HashMap ();
    methods = obj.getClass ().getMethods ();

    for (int i = 0; i < methods.length; i++) {
    	// Check method name

      if (! methods [i].getName ().startsWith (METHOD_PREFIX)) {
      	continue;
      }

      // Check parameter types

      pTypes = methods [i].getParameterTypes ();

      if (pTypes.length != 1) {
      	continue;
      }

      if (! OPTION_CLASS.isAssignableFrom (pTypes [0])) {
      	continue;
      }

      // Check exception types

      eTypes = methods [i].getExceptionTypes ();

      if (eTypes.length > 1) {
      	continue;
      }

      if (eTypes.length == 1){
      	/*if (! EXCEPTION_CLASS.isAssignableFrom(eTypes [0])) {
                continue;
      	}*/
      }

	    // Now it is a valid method
	    String  methodName = methods [i].getName ();
	
	    methodName = methodName.toUpperCase();
	
	    methMap.put (methodName, methods [i]);
    }

  	return methMap;
	}

	//==== < private ================================== deprecated > ====
  
}
