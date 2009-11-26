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

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

import java.io.ObjectStreamException;

/**
 * Defines and provides typesafe enums of types of {@link Formatter} used in logging
 * to format a log message and its related information.
 * Currently, there are three types defined:
 * {@link #LISTFORMAT}, {@link #TRACEFORMAT}, {@link #XMLFORMAT}
 */
public class FormatterType implements Serializable{
	
	//================================================ declaration > ====
	
	private static String strLoc = "-FormatterType";

  //Note to subclass, special care is required to enable serialization. Refer to
  //the last section of this class for the 5 declarations that need to be overwritten.

  /**
   * A not-so-human-readable format to be transferred to and processed further
   * by another application, for example, a log viewer.
   * See class (@link ListFormatter}.
   */
  public static final FormatterType LISTFORMAT  = new FormatterType("ListFormat");

  /**
   * A format which is readily understood by users.
   * See class (@link TraceFormatter}.
   */
  public static final FormatterType TRACEFORMAT = new FormatterType("TraceFormat");

  /**
   * See class (@link PerfFormatter}.
   */
  public static final FormatterType PERFFORMAT   = new FormatterType("PerfFormatter");
  
  /**
   * See class (@link XMLFormatter}.
   */
  public static final FormatterType XMLFORMAT   = new FormatterType("XMLFormat");

  /**
   * Unknown format.
   */
  public static final FormatterType UNDEFINEDFORMAT   = new FormatterType("UndefinedFormat");
  
	//  For users who define their own formatter should extend this class and
	//  include their formatter type definition here.
	//  Note to sublcass:
  // - Next 4 declarations are needed for valid serialization.
  // - Be sure to overwrite member variable 'ALLTYPES'for a valid list
  //   of available formatter types
  private static final FormatterType[] PRIVATE_TYPES = { LISTFORMAT,
														 					 TRACEFORMAT,
														 					 PERFFORMAT,
														 					 XMLFORMAT,
														 					 UNDEFINEDFORMAT};
	
	/**
	 * Returns an immutable list of predefined formatter types.
	 */
	public static final List ALLTYPES =	Collections.unmodifiableList(Arrays.asList(PRIVATE_TYPES));
														 
	private final transient String mTypeName;

  private static int nextOrdinal = 0;
	private final int ordinal = nextOrdinal++;

	//==== < declaration ============================ constructors > ====
  //==== < constructors =============================== abstarct > ====
  //==== < abstract ===================================== public > ====

  /**
   * Returns the formatter type in literal string.
   */
  public String toString(){
    return this.mTypeName;
  }

  /**
   * A final method with same behavior as in parent class Object.
   */
  public final boolean equals(Object that){  //final: no more overriding from subclass
    return super.equals(that);
  }

  /**
   * A final method with same behavior as in parent class Object.
   */
  public final int hashCode(){  //final: no more overriding from subclass
    return super.hashCode();
  }

	//==== < public ==================================== protected > ====
	
	protected FormatterType(String aTypeName){
		this.mTypeName = aTypeName;
  }
	
	//==== < protected =================================== default > ====
	
	Object readResolve() throws ObjectStreamException{
		try {
			return PRIVATE_TYPES[ordinal];    //Canonicalize
		}
		catch (ArrayIndexOutOfBoundsException ex){
			APILogger
				.logIntByAPI(Severity.WARNING,
									APILogger.APILocation,
									strLoc,
									MSGCollection.LOGGING_MSG_ID_UNEXPECTED,
									MSGCollection.LOGGING_MSG_STR_UNEXPECTED,
									new String[] {"getting FormatterType(" + ordinal + ")"});
			APILogger.catchingIntByAPI(ex);;		
			return PRIVATE_TYPES[1];    //Return Default Type - TraceFormatter
		}
	}
	
	// Hardcoded to avoid version incompatibility exceptions. Make certain older log viewer clients still work when changing this class!
	private static final long serialVersionUID = 3225006415615133575L;
	
	//==== < default ===================================== private > ====
	//==== < private ================================== deprecated > ====
 
}