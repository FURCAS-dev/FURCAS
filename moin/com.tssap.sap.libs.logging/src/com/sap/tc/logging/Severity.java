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

import java.lang.*;

import java.util.*;
import java.text.*;
import java.io.*;

/**
 * Collects constants for use as severities as well as some static utility
 * methods. The order of the constants is, with increasing severity:
 * {@link #DEBUG}, {@link #PATH}, {@link #INFO}, {@link #WARNING},
 * {@link #ERROR}, {@link #FATAL}.
 */
public class Severity {

	//================================================ declaration > ====

  /**
   * Offset in between recommended severities.
   */
  protected static final int OFFSET = 100;

  /**
   * Severity that allows all messages to be written.
   */
  public static final int ALL = 0;

  /**
   * Recommended severity for debug messages.
   * Debug messages give detailed information on program execution, above all to
   * developers themselves.
   */
  public static final int DEBUG = ALL + OFFSET;

  /**
   * Recommended severity for path messages.
   * Path messages outline the path of program execution, above all for
   * developers themselves. Typical applications of path messages are method
   * entries and exits.
   */
  public static final int PATH = DEBUG + OFFSET;

  /**
   * Recommended severity for informational messages.
   */
  public static final int INFO = PATH + OFFSET;

  /**
   * Recommended severity of warning messages.
   * Warnings inform about supposed problems which can but need not lead to
   * errors later.
   */
  public static final int WARNING = INFO + OFFSET;

  /**
   * Recommended severity of error messages.
   * Error messages inform about problems the component most probably can
   * recover from.
   */
  public static final int ERROR = WARNING + OFFSET;

  /**
   * Recommended severity of fatal error messages.
   * Fatal errors are problems a component cannot recover from without
   * significant intervention from operators or developers.
   */
  public static final int FATAL = ERROR + OFFSET;

  /**
   * Minimum severity.
   */
  public static final int MIN = ALL;

  /**
   * Maximum severity.
   */
  public static final int MAX = FATAL + OFFSET;

  /**
   * Group severity.
   * Special constant for designating group messages.
   */
  public static final int GROUP = MAX + OFFSET;

  /**
   * Severity that prohibits any messages to be written.
   */
  public static final int NONE = MAX + 1;

  //Provides a list of defined severity levels (static) used for screening message severity.
  //(NB. if customized severity level is allowed, use 'severities'.)
  //TODO: 'GROUP' omitted
  private static final String[] PRIVATE_VALUES =
      {"All", "Debug", "Path", "Info", "Warning", "Error", "Fatal", "Min", "Max", "None"};
  /**
   * List of predefined severity levels (unmodifiable).
   */
  public static final List VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));
  
  protected static final String INVALID_SEVERITY_EMSG = "invalid severity",
								  							UNKNOWN_SEVERITY_EMSG = "unknown severity constant";

  private static HashMap severities = new HashMap();

	static {
	  severities.put("DEBUG", 	new Integer(DEBUG));
	  severities.put("PATH",		new Integer(PATH));
	  severities.put("INFO",		new Integer(INFO));
	  severities.put("WARNING",	new Integer(WARNING));
	  severities.put("ERROR",		new Integer(ERROR));
	  severities.put("FATAL",		new Integer(FATAL));
	  severities.put("GROUP",		new Integer(GROUP));
	  severities.put("MIN",			new Integer(MIN));
	  severities.put("MAX",			new Integer(MAX));
	  severities.put("NONE",		new Integer(NONE));
	  severities.put("ALL",			new Integer(ALL));
	}

	//==== < declaration ============================ constructors > ====
	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====

  public static String toString(int severity) {
		if (severity < DEBUG) {
		  return "All";
		} else if (severity < PATH) {
      return "Debug";
    } else if (severity < INFO) {
      return "Path";
    } else if (severity < WARNING) {
      return "Info";
    } else if (severity < ERROR) {
      return "Warning";
    } else if (severity < FATAL) {
      return "Error";
    } else if (severity <= MAX) {
      return "Fatal";
    } else if (severity == NONE){
      return "None";
    } else if (severity == GROUP) {
      return "Group";
    } else {
      return "Unknown";
    }
  }

  /**
   * Checks whether a severity is within the valid range.
   * @throws IllegalArgumentException Specified severity is smaller than
   *                                  {@link #MIN}
   *                                  or larger than
   *                                  {@link #MAX},
   *                                  and neither
   *                                  {@link #NONE}
   *                                  nor
   *                                  {@link #ALL}
   *                                  nor
   *                                  {@link #GROUP}
   */
  public static void check(int severity) {
    if (   (   severity < MIN
            || MAX < severity)
        && (   severity != NONE
            && severity != ALL
            && severity != GROUP)) {
      throw new IllegalArgumentException(INVALID_SEVERITY_EMSG);
    }
  }

  /**
   * Checks whether a severity is within the valid range for messages.
   * @throws IllegalArgumentException Specified severity is smaller than
   *                                  {@link #MIN}
   *                                  or larger than
   *                                  {@link #MAX}
   */
  public static void msgCheck(int severity) {
    if (   (   severity < MIN
            || MAX < severity)
        && severity != GROUP) {
      throw new IllegalArgumentException(INVALID_SEVERITY_EMSG);
    }
  }

  /**
   * Corrects an invalid severity to the closest valid value.
   * @return Corrected severity
   */
  public static int correct(int severity) {
    try {
      Severity.check(severity);
    }
    catch (IllegalArgumentException e) {
      if (severity < MIN) {
        severity = MIN;
      }
      if (MAX < severity) {
        severity = MAX;
      }
    }
    return severity;
  }

  /**
   * Corrects an invalid severity for a message to the closest valid value.
   * @return Corrected severity
   */
  public static int msgCorrect(int severity) {
    try {
      Severity.msgCheck(severity);
    }
    catch (IllegalArgumentException e) {
      if (severity < MIN) {
        severity = MIN;
      }
      if (MAX < severity) {
        severity = MAX;
      }
    }
    return severity;
  }

  /**
   * Gets the severity of the symbolic constant with the specified name.
   * @param  name Name of symbolic severity constant. Case INSENSITIVE.
   * @throws IllegalArgumentException Specified name is not a symbolic severity
   *                                  constant
   */
  public static int parse(String name){
    //YUE: since there exists discrepancy on case sensitivity between defined values
    //     in HashMap severities and 'toString' method. For backward compatibility,
    //     make changes here to gap the difference, by allowing severity
    //     constant string to be case INsensitive.
    try {
      return ((Integer) severities.get(name.toUpperCase().trim().toUpperCase())).intValue();
    }
    catch (NullPointerException exc) {
      throw new IllegalArgumentException(UNKNOWN_SEVERITY_EMSG);
    }
  }
  
  //==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	//==== < private ================================== deprecated > ====

}