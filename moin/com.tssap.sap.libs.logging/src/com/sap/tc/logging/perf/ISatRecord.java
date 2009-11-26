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

import java.util.Properties;

public interface ISatRecord {

  /**************** constants ******************/

  /***** provider of SAT record *****/
  /** JARM */
  public static final int PROVIDERJARM 	= 1;
  /** JDSR */
  public static final int PROVIDERDSR 	= 2;
  /** TREX */
  public static final int PROVIDERTREX  	= 3;

  /***** type of SAT record *****/
  /** JARM request */
  public static final int TYPEJARMREQ  		= 10;
  /** JARM Component */
  public static final int TYPEJARMCOMP 		= 11;
  /** JARM Action */
  public static final int TYPEJARMACT 		= 12;
  /** DSR Action */
  public static final int TYPEDSRACTION 		= 20;
  /** DSR External Call */
  public static final int TYPEDSREXTCALL 	= 21;
  /** DSR Internal Call */
  public static final int TYPEDSRINTCALL 	= 22;
  /** DSR Trace */
  public static final int TYPEDSRTRACE 		= 23;
  /** TREX Trace */
  public static final int TYPETREXTRACE 		= 30;	

  /****** attribute not applicable for this type of record *******/
  /** string not applicable */
  public static final String STRINGNOTAPPL = "N/A";
  /** number not applicable */
  public static final int NUMBERNOTAPPL = -1;

  /****** attribute applicable, but value not provided *******/
  /** string not provided;<br>
   *  in 6.20 JARM names could have the value "nameNotDefined" instead of " " */
  public static final String STRINGNOTSET = " ";
  /** number not provided */
  public static final int NUMBERNOTSET = -1;

  /***** state of activity *****/
  /** <pre>
   *  no error occured
   *  JARM Request: all components of request and request itself ended correctly <br>
   *  JARM Component: component ended correctly
   *  JARM Action: N/A
   *  DSR: N/A  all statistics and trace information is collected only if the component works correctly
   *  DSR Trace: N/A
   * </pre>
   */
  public static final int STATEOK                = 0;
  /** <pre>
   *  activity not properly closed
   *  JARM Request: not all components of request were closed
   *  JARM Component: component not closed
   *  JARM Action: N/A
   *  DSR Action: N/A unclosed actions are not being written
   *  DSR Call: N/A unclosed calls are not being written
   *  DSR Trace: N/A trace records does not need to be closed
   * </pre>
   */
  public static final int STATENOTCLOSED         = 1;
  /** <pre>
   *  activity closed because of too many subrecords
   *  JARM Request: request closed because too many component calls were done
   *  JARM Component: N/A
   *  JARM Action: N/A
   *  DSR Action: N/A
   *  DSR Call: N/A
   *  DSR Trace: N/A
   * </pre>
   */
  public static final int STATESUBRECORDOVERFLOW = 2;


  /* *************** methods ***************** */

  /**
   * provider of record; see constants PROVIDERxxx above
   * @return int the information provider
   */
  public int getProvider();

  /**
   * type of record; see constants TYPExxx above .
   * @return int the record type
   */
  public int getRecType();

  /** <pre>
   *  sequence number
   *  JARM Request: N/A
   *  JARM Component: indicates the call sequence of the components; starts with 0
   *  JARM Action: indicates the call sequence of the actions; starts with 0
   *  DSR Action: indicates the action sequence number within a DSR transaction
   *  DSR External Call: N/A - external call can be aggregated into a single call record
   *  DSR Internal Call: indicates the internal call sequence number within a DSR action
   *  DSR Trace: indicated the trace record sequence number within a DSR transaction
   *  </pre>
   * @return int the sequence number corresponding to the record type semantics
   */
  public int getSeqNumber();

  /** <pre>
   *  nesting level
   *  JARM Request: N/A
   *  JARM Component: indicates, how deep component is nested; 0 <-> main level
   *  JARM Action: N/A
   *  DSR Action: allways 0
   *  DSR External Call: allways 0
   *  DSR Internal Call: indicates the level in the call stack; 0 <-> main level
   *  DSR Trace: allways 0
   *  </pre>
   * @return int the nested level which corresponds to the record type semantics
   */
  public int getLevel();

  /** <pre>
   *  name of activity
   *  JARM Request: name
   *  JARM Component: name
   *  JARM Action: N/A
   *  DSR Action: action type
   *  DSR External Call: destination
   *  DSR Internal Call: module name
   *  DSR Trace: module/method name
   *  </pre>
   *  @return String record name
   */
  public String getName();

  /** <pre>
   *  user name
   *  JARM Request: user
   *  JARM Component: N/A
   *  JARM Action: N/A
   *  DSR: user id from the passport (allways available)
   *  </pre>
   * @return String user name associated with the SAT record
   */
  public String getUserName();

  /** status of activity; see constants STATUSxxx above
   *  @return int record state
   */
  public int getState();

  /** start time stamp of activity; difference, measured in milliseconds,
   *  @return long start time stamp in milliseconds since midnight, January 1, 1970 UTC
   */
  public long getStartTS();

  /** <pre>
   *  duration (in ms) of the activity (elapsed)
   *  JARM Component: constant NUMBERNOTAPPL if component is not closed correctly
   *  JARM Action: N/A
   *  DSR Action: responce time
   *  DSR External Call: call time
   *  DSR Internal Call: call time
   *  DSR Trace: duration from trace record
   *  </pre>
   *  @see com.sap.jdsr.writer.DsrISubRecordCall1#getCallTime(int)
   *  @see com.sap.jdsr.writer.DsrISubRecordCall2#getCallTime(int)
   *
   * @return long activity elapsed time in milliseconds
   */
  public long getGrossTime();

  /** <pre>
   *  net time (in ms) of activity (elapsed); this is the gross time minus the
   *  time which was spent in subcalls
   *  JARM Request: N/A
   *  JARM Component: constant NUMBERNOTAPPL if component is not closed correctly
   *                  or at least one direct subcomponent is not closed correctly
   *  JARM Action: N/A
   *  DSR Action: aggregated net time for all nested external calls in the DSR action
   *  DSR External Call: N/A
   *  DSR Trace: N/A
   *  </pre>
   *  @return long net time in milliseconds
   */
  public long getNetTime();
  
  /** <pre>
   *  CPU gross time (in ms) of the activity
   *  JARM Request: constant NUMBERNOTAPPL if CPU time is not available
   *  JARM Component: constant NUMBERNOTAPPL if CPU time is not available                 
   *                  or if component is not closed correctly
   *  JARM Action: N/A
   *  </pre>
   *  @see com.sap.jdsr.writer.DsrISubRecordCall1#getCallTime(int)
   *  @see com.sap.jdsr.writer.DsrISubRecordCall2#getCallTime(int)
   *
   * @return long activity CPU time in milliseconds
   */
  public long getGrossCpuTime();

  /** <pre>
   *  net time (in ms) of activity (CPU); this is the gross time minus the
   *  time which was spent in subcalls
   *  JARM Request: N/A
   *  JARM Component: constant NUMBERNOTAPPL if CPU time is not available
   *                  or if component is not closed correctly
   *                  or at least one direct subcomponent is not closed correctly
   *  JARM Action: N/A
   *  </pre>
   *  @return long net CPU time in milliseconds
   */
  public long getNetCpuTime();

  /** <pre>
   *  amount of transfered data (in bytes)
   *  JARM Action: N/A
   *  DSR Action: aggreageted number of bytes transferred within all nested internal and
   *              external calls
   *  DSR External Call: (aggregated) number of transfered bytes to and from the corresponding
   *                     called component
   *  DSR Internal Call: number of thransfered bytes with the current internal call
   *  DSR Trace: N/A
   *  </pre>
   *  @return int number of transfered bytes (outgoing + ingoing)
   */
  public int getOutData();

  /** <pre>
   *  number of sub-records
   *  JARM Request: number of components
   *  JARM Component: number of actions
   *  JARM Action: N/A
   *  DSR Action: number of all internal end external call records associated with this action
   *  DSR External Call: N/A
   *  DSR Internal Call: N/A
   *  DSR Trace: N/A
   *  </pte>
   *  @return int number of subrecords available in the current SAT record
   */
   public int getNumberOfSubRecords();

  /** <pre>
   *  description of activity (short text)
   *  JARM Request: applicable starting with 6.30
   *  JARM Component: applicable starting with 6.30
   *  JARM Action: action string
   *  DSR Action: Action Additional Info
   *  DSR External Call: Additional Info
   *  DSR Internal Call: Additional Info
   *  DSR Trace: Trace Message
   *  </pre>
   *  @return String activity description
   */
  public String getDescr();

  /** <pre>
   *  specific properties for this activity
   *  JARM Request: N/A
   *  JARM Component: applicable starting with 6.30
   *  JARM Action: N/A
   *  DSR Action: associated component name, component version, predefined action- and service types
   *  DSR Call: associated component name, component version
   *  DSR Trace: Trace File Path, Maximum number of trace files in the ring buffer
   *  </pre>
   *  @return Properties properties for this activity, null if no properties
   *          exist.
   */
   public Properties getProps();

  /** name of module or class
   *  JARM: N/A
   *  DSR Trace: module name
   */
  public String getClassName();

  /** version of module or class
   *  JARM: N/A
   *  DSR Trace: version of module
   */
  public String getClassVersion();

  /*/** line number in module or class
   *  JARM: N/A
   *  DSR Trace: N/A
   */
  //public int getLineNumber();

  /********* not used data of JARM RequestOverview **********/
  //
  // /** component with largest net time */
  // public String compNetTimeName;
  // /** net time of this component */
  // public long compNetTime;
  // /** component with largest amount of outbound data (excluding component which
  //   * belongs directly to the request (level = 0); the data of this component
  //   * is shown in reqOutData)
  //   */
  // public String compOutDataName;
  // /** amount of outbound data of this component;
  //  *  no outbound data given for any component -> value = -1
  //  */
  // public long compOutData;


} // ISatRecord
