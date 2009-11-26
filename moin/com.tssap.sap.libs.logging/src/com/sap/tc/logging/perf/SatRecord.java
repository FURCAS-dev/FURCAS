package com.sap.tc.logging.perf;

import java.util.Properties;
import java.util.Enumeration;

/*
 * Title:        SAT structure
 * Description:  class for structure of Single Activity Trace (SAT) record
 * Copyright:    Copyright (c) 2003
 * Company:      SAP AG
 * @author       Robert Boban, Bernd Franz, Gregor Frey
 * @version      1.0
 */

/**
 * the class contains the constants and methods to get the attributes of a
 * Single Active Trace (SAT) record
 * <p>
 * if a record type is not explicitely mentioned in the method documentation
 * it provides the data as generally described in the documentation
 *
 */

public class SatRecord implements ISatRecord
{
	//$JL-EXC$
  /******************** CONSTANTS *********************/
  private static final int F_MIN           					= -1;
 	private static final int F_PROVIDER               	= F_MIN + 1;
 	private static final int F_REC_TYPE               	= F_PROVIDER + 1;
 	private static final int F_SEQ_NUMBER             	= F_REC_TYPE + 1;
 	private static final int F_LEVEL                  	= F_SEQ_NUMBER + 1;
 	private static final int F_NAME                   	= F_LEVEL + 1;
 	private static final int F_USER_NAME              	= F_NAME + 1;
 	private static final int F_STATE                  	= F_USER_NAME + 1;
 	private static final int F_START_TS               	= F_STATE + 1;
 	private static final int F_GROSS_TIME             	= F_START_TS + 1;
 	private static final int F_NET_TIME               	= F_GROSS_TIME + 1;
 	private static final int F_OUT_DATA               	= F_NET_TIME + 1;
 	private static final int F_NUMBER_OF_SUB_RECORDS  	= F_OUT_DATA + 1;
 	private static final int F_DESCRIPTION            	= F_NUMBER_OF_SUB_RECORDS + 1;
 	private static final int F_CLASS_NAME             	= F_DESCRIPTION + 1;
 	private static final int F_CLASS_VERSION          	= F_CLASS_NAME + 1;
 	private static final int F_GROSS_CPU_TIME     		 	= F_CLASS_VERSION + 1;
 	private static final int F_NET_CPU_TIME     		 		= F_GROSS_CPU_TIME + 1;
 	private static final int F_PROPS_COUNTER           	= F_NET_CPU_TIME + 1;

 	private static final int F_PROPERTY               	= F_PROPS_COUNTER + 1;

 	private static final int F_LAST_ELEMENT           	= F_PROPERTY + 1;


  /******************** CONSTRUCTORS ********************/
  public SatRecord()
  {
  }

  protected SatRecord(String args[])
  {
	  setProvider						(args);
	  setRecType						(args);
	  setSeqNumber					(args);
	  setLevel							(args);
	  setName								(args);
	  setUserName 					(args);
	  setState							(args);
	  setStartTS 						(args);
	  setGrossTime					(args);
	  setNetTime  					(args);
		setGrossCpuTime 			(args);
		setNetCpuTime 				(args);
	  setOutData 						(args);
	  setNumberOfSubRecords	(args);
	  setDescr							(args);
	  setClassName          (args);
	  setClassVersion       (args);
	  setPropsCounter				(args);
		setProps							(args);
  }
  /**************** METHODS ******************/

  protected String[] getLogArray()
  {
	  // Check is Properties collection exist
	  // and extract array with additional prop elements
	  int propCount = 0;
	  if (prop != null)
	  {
		  propCount = prop.size() * 2;
	  }

	  String args[] = new String[F_PROPERTY + propCount];

	  args[F_PROVIDER]              = new Integer(provider).toString();
	  args[F_REC_TYPE]              = new Integer(recType).toString();
	  args[F_SEQ_NUMBER]            = new Integer(seqNumber).toString();
	  args[F_LEVEL]                 = new Integer(level).toString();
	  args[F_NAME]                  = name;
	  args[F_USER_NAME]             = userName;
	  args[F_STATE ]                = new Integer(state).toString();
	  args[F_START_TS]              = new Long(startTS).toString();
	  args[F_GROSS_TIME]            = new Long(grossTime).toString();
	  args[F_NET_TIME]              = new Long(netTime).toString();
	  args[F_OUT_DATA]              = new Integer(outData).toString();
	  args[F_NUMBER_OF_SUB_RECORDS] = new Integer(numberOfSubRecords).toString();
	  args[F_DESCRIPTION]           = descr;
	  args[F_CLASS_NAME]            = className;
	  args[F_CLASS_VERSION]         = classVersion;
		args[F_GROSS_CPU_TIME]        = new Long(grossCpuTime).toString();
		args[F_NET_CPU_TIME]          = new Long(netCpuTime).toString();
     
			int counter = 0;
	
	  if (prop != null) {
		  String name   = null;
		  String value   = null;

		  for (Enumeration en = prop.propertyNames(); en.hasMoreElements();) {
			  try {
				  name  = (String) en.nextElement();
				  value = prop.getProperty(name);
			  }
			  catch (Exception ex) {
				  name  = "INVALID";
				  value = "READING ERROR";
			  }

			  // STORE PROPERTY NAME
			  args[F_PROPERTY + counter++] = name;
			  // STORE PROPERTY VALUE
			  args[F_PROPERTY + counter++] = value;
		  }
	  }

			args[F_PROPS_COUNTER] = new Integer(counter).toString();

	  return args;
  }

  /** provider of record; see constants PROVIDERxxx above */
  public int provider = NUMBERNOTAPPL;
  public int getProvider(){return provider;}

  private void setProvider(String[] args) 
  {
	  try {
		  provider = new Integer(args[F_PROVIDER]).intValue();
	  }
	  catch (Exception ex){
		  // Used to support backward compatibility
	  }
  }

  /** type of record; see constants TYPExxx above */
  public int recType = NUMBERNOTAPPL;
  public int getRecType(){return recType;}

  private void setRecType(String[] args) 
  {
	  try {
		  recType = new Integer(args[F_REC_TYPE]).intValue();
	  }
	  catch (Exception ex){
		  // Used to support backward compatibility
	  }
  }
  
  /** sequence number<br>
   *  JARM Request: not applicable<br>
   *  JARM Component: indicates the call sequence of the components; starts with 0
   *  JARM Action: indicates the call sequence of the actions; starts with 0
   *  DSR Action: @Todo Mario, Markus
   *  DSR Call: @Todo Mario, Markus
   *  DSR Trace: @Todo Mario, Markus
   */
  public int seqNumber = NUMBERNOTAPPL;
  public int getSeqNumber(){return seqNumber;}
  
  private void setSeqNumber(String[] args) 
  {
	  try {
		  seqNumber = new Integer(args[F_SEQ_NUMBER]).intValue();
	  }
	  catch (Exception ex){
		  // Used to support backward compatibility
	  }
  }

  /** nesting level<br>
   *  JARM Request: not applicable<br>
   *  JARM Component: indicates, how deep component is nested; 0 <-> main level
   *  JARM Action: not applicable
   *  DSR Action: @Todo Mario, Markus
   *  DSR Call: @Todo Mario, Markus
   *  DSR Trace: @Todo Mario, Markus
   */
  public int level = NUMBERNOTAPPL;
  public int getLevel(){return level;}

  private void setLevel(String[] args) 
	{
		try {
			  level = new Integer(args[F_LEVEL]).intValue();
		}
		catch (Exception ex){
			// Used to support backward compatibility
		}
	}
	
  /** name of activity
   *  JARM Request: name
   *  JARM Component: name
   *  JARM Action: not applicable
   *  DSR Action: @Todo Mario, Markus
   *  DSR Call: @Todo Mario, Markus
   *  DSR Trace: @Todo Mario, Markus
   */
  public String name = STRINGNOTAPPL;
  public String getName(){return name;}

  private void setName(String[] args) 
  {
	  try {
		  name = args[F_NAME];
	  }
	  catch (Exception ex){
		  // Used to support backward compatibility
	  }
  }
  
  /** user name<P>
   *  JARM Request: user
   *  JARM Component: not applicable
   *  JARM Action: not applicable
   *  DSR: user id from the passport, if available, else
   *       name of the principal that is associated with the thread context
   */
  public String userName = STRINGNOTAPPL;
  public String getUserName(){return userName;}
	
  private void setUserName(String[] args) 
  {
	  try {
		  userName = args[F_USER_NAME];
	  }
	  catch (Exception ex){
		  // Used to support backward compatibility
	  }
  }

  /** status of activity; see constants STATUSxxx above
   *  @return int record state
   */
  public int state = NUMBERNOTAPPL;
  public int getState(){return state;}

  private void setState(String[] args) 
	{
		try {
			  state = new Integer(args[F_STATE]).intValue();
		}
		catch (Exception ex){
			// Used to support backward compatibility
		}
	}

  /** the difference, measured in milliseconds,
   *  between the current time and midnight, January 1, 1970 UTC
   */
  public long startTS = NUMBERNOTAPPL;
  public long getStartTS(){return startTS;}

  private void setStartTS(String[] args) 
  {
	  try {
		  startTS = new Long(args[F_START_TS]).longValue();
	  }
	  catch (Exception ex){
		  // Used to support backward compatibility
	  }
  }

  /** duration (in ms) of the activity (elapsed)<br>
   *  JARM Component: constant NUMBERNOTAPPL if component is not closed correctly
   *  JARM Action: not applicable
   *  DSR Action: @Todo Mario, Markus
   *  DSR Call: @Todo Mario, Markus
   *  DSR Trace: @Todo Mario, Markus
	*/
  public long grossTime = NUMBERNOTAPPL;
  public long getGrossTime(){return grossTime;}

  private void setGrossTime(String[] args) 
	{
		try {
			  grossTime = new Long(args[F_GROSS_TIME]).longValue();
		}
		catch (Exception ex){
			// Used to support backward compatibility
		}
	}

  /** net time (in ms) of activity (elapsed); this is the gross time minus the
   *  time which is spend in subcalls<br>
   *  JARM Request: not applicable<br>
   *  JARM Component: constant NUMBERNOTAPPL if component is not closed correctly
   *                  or at least one direct subcomponent is not closed correctly
   *  JARM Action: not applicable
   *  DSR Action: @Todo Mario, Markus
   *  DSR Call: @Todo Mario, Markus
   *  DSR Trace: @Todo Mario, Markus
   */
  public long netTime = NUMBERNOTAPPL;
  public long getNetTime(){return netTime;}

  private void setNetTime(String[] args) 
  {
	  try {
		  netTime = new Long(args[F_NET_TIME]).longValue();
	  }
	  catch (Exception ex){
		  // Used to support backward compatibility
	  }
  }
  
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
	public long grossCpuTime = NUMBERNOTAPPL;
  public long getGrossCpuTime() {return grossCpuTime;}
  
  private void setGrossCpuTime(String[] args) 
	{
		try {
			grossCpuTime = new Long(args[F_GROSS_CPU_TIME]).longValue();
		}
		catch (Exception ex){
			// Used to support backward compatibility
		}
	}

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
  public long netCpuTime = NUMBERNOTAPPL;
  public long getNetCpuTime() {return netCpuTime;}

  private void setNetCpuTime(String[] args) 
  {
	  try {
			netCpuTime = new Long(args[F_NET_CPU_TIME]).longValue();
	  }
	  catch (Exception ex){
		  // Used to support backward compatibility
	  }
  }

  /** amount of transfered data (in bytes)
	*  JARM Action: not applicable
	*/
  public int outData = NUMBERNOTAPPL;
  public int getOutData(){return outData;}

  private void setOutData(String[] args) 
  {
	  try {
		  outData = new Integer(args[F_OUT_DATA]).intValue();
	  }
	  catch (Exception ex){
		  // Used to support backward compatibility
	  }
  }
  
  /** number of sub-records<br>
   *  JARM Request: number of components<br>
   *  JARM Component: number of actions
   *  JARM Action: not applicable
   *  DSR Action: @Todo Mario, Markus
   *  DSR Call: @Todo Mario, Markus
   *  DSR Trace: @Todo Mario, Markus
   */
  public int numberOfSubRecords = NUMBERNOTAPPL;
  public int getNumberOfSubRecords(){return numberOfSubRecords;}

  private void setNumberOfSubRecords(String[] args) 
  {
	  try {
		  numberOfSubRecords = new Integer(args[F_NUMBER_OF_SUB_RECORDS]).intValue();
	  }
	  catch (Exception ex){
		  // Used to support backward compatibility
	  }
  }

  /** description of activity (short text)<br>
   *  JARM Request: applicable starting with 6.30<br>
   *  JARM Component: applicable starting with 6.30
   *  JARM Action: action string
   *  DSR Action: @Todo Mario, Markus
   *  DSR Call: @Todo Mario, Markus
   *  DSR Trace: @Todo Mario, Markus
   */
  public String descr = STRINGNOTAPPL;
  public String getDescr(){return descr;}

  private void setDescr(String[] args) 
	{
		try {
			  descr = args[F_DESCRIPTION];
		}
		catch (Exception ex){
			// Used to support backward compatibility
		}
	}

  /** specific properties for this activity
   *  JARM Request: not applicable<br>
   *  JARM Component: applicable starting with 6.30
   *  JARM Action: not applicable
   *  DSR Action: @Todo Mario, Markus
   *  DSR Call: @Todo Mario, Markus
   *  DSR Trace: @Todo Mario, Markus
   */
  public Properties prop = null;
  public Properties getProps(){return prop;}

  private void setProps(String[] args) 
	{
	  try {
		  if (args.length > F_PROPERTY) {
				String value = null;

				prop = new Properties();

				for (int i = F_PROPERTY; i < args.length; i++){
					try {
						prop.setProperty(args[i].toString(), args[1 + i++].toString());
					}
					catch (Exception ex){
						prop.setProperty("INVALID", "WRITTING ERROR");
					}
				}
			}
		}
		catch (Exception ex){
			  // Used to support backward compatibility
		}
	}

	private int prosCounter = 0;
	private int getPropsCounter(){return prosCounter;}
	
	private void setPropsCounter(String[] args) 
	{
		try {
			prosCounter = new Integer(args[F_PROPS_COUNTER]).intValue();
		}
		catch (Exception ex){
			// Used to support backward compatibility
		}
	}

  /** name of module or class
   *  JARM: N/A
   *  DSR Trace: module name
   */
  public String className = STRINGNOTAPPL;
  public String getClassName(){return className;}

  private void setClassName(String[] args) 
  {
	  try {
		  className = args[F_CLASS_NAME];
	  }
	  catch (Exception ex){
		  // Used to support backward compatibility
	  }
  }

  /** version of module or class
   *  JARM: N/A
   *  DSR Trace: version of module
   */
  public String classVersion = STRINGNOTAPPL;
  public String getClassVersion(){return classVersion;}

  private void setClassVersion(String[] args) 
	{
		try {
			  classVersion = args[F_CLASS_VERSION];
		}
		catch (Exception ex){
			// Used to support backward compatibility
		}
	}

  /** line number in module or class
   *  JARM: N/A
   *  DSR Trace: line in module

  public int lineNumber = NUMBERNOTAPPL;
  public int getLineNumber(){return lineNumber;}*/

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

}