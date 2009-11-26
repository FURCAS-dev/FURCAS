package com.sap.tc.logging;

/**
 * Title:        Logging
 * Description:  Logging API
 * Copyright:    Copyright (c) 2001
 * Company:      SAPMarkets, Inc.
 *               Palo Alto, California, 94303, U.S.A.
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAPMarkets Inc. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAPMarkets.
 * @version      $Id: $
 */

import java.util.*;
import java.text.*;
import java.io.*;

import com.sap.tc.logging.interfaces.IRPPublisher;
import com.sap.tc.logging.messagedepot.MessageAccessor;
import com.sap.tc.logging.messagedepot.MessageID;
import com.sap.tc.logging.messagedepot.LocalizedMessage;

/**
 * Internal form of log messages.
 * @see?   Log
 * @see?   Formatter
 * @see?   Filter
 */

public class 			LogRecord 
			 extends 		ExceptionHandling
			 implements Serializable,
						 			ILogRecordFull {
	//$JL-SER$ $JL-EXC$
	//================================================ declaration > ====
	
	private static Location classLoc = Location.getLocation(LogRecord.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");

  static String version = "$Id:$";

  static final Locale STANDARD_LOCALE = Locale.US;
  static final String NULL_STRING 		= "<null>";
  
  private static final DateFormat timeFormatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,
																																							   DateFormat.MEDIUM,
																																							   Locale.US);
	
  private static final String EMPTY_STRING 			= "";
  private static final String EXCEPTION_POINTER = " \n[EXCEPTION]\n ";

  private static volatile long    lastTimeInSeconds = 0;
	private static volatile String  lastTimeString    = null;
	  
  private static IRPPublisher rpPublisher;

  private GUId       id;
  private int				 lrSize;	
  private long			 lrBookMark				= -1;
  private String		 lrLogName;
	private Date       time;
	private String     timeZone;
	private String	   thrName;
	private String[]   args;
	private Object[]   argsObj;
	private int nonExceptionArgsCount = 0;
 
	private int        severity;
	private String	   sourceName; 
	private String     locationName;
	private String[] 	 relatives;
  
	private String     application;
	private String     user;
	private String     session;
	private String     transaction;
	private String     dsrTransactionID;
    private String     dsrRootContextID;
    private String     dsrConnection;
    private int       dsrCounter = -1;
    
	private long	   correlatorID = UID.EMPTY_CORRELATOR_ID;
	
	private String		 sysName;
	private String		 sysInstanceName;
	private String		 sysHostName;
	private String		 sysNodeID;
   
	private int        msgType 							= 0;
	private String     msgCode;
	private String     msgAlias;
	protected String     resourceBundleName;
	protected String     msgClear;
	protected String     msgDefault;
	protected String     msgLocalized;
	private Throwable  msgException;
    
    String     csnComponent;
    String     dcName;
    
    private boolean internalThread = false;

	//==== < declaration ============================ constructors > ====
  
	LogRecord(LogController  source,
						String         loc,
						int            severity,
						String[] 			 relatives,
						int            msgType,
						String         msg,
						String[]       args) {
					
		this(source,
			   loc,
			   Thread.currentThread(),
			   severity,
			   relatives,
			   msgType,
			   null,
			   null,
			   msg,
			   args,
               null);
		   					
	}
	
	protected LogRecord(LogController   source,
											String          locName,
											int             severity,
											String[] 				relatives,
											int             msgType,
											Object          msgCode,
											String          resourceBundleName,
											String 					msgClear,
											String[]        args) {
		
		 this (source,
					 locName,
					 Thread.currentThread(),
					 severity,
					 relatives,
					 msgType,
					 msgCode,
					 resourceBundleName,
					 msgClear,
					 args,
                     null);	
	}
	
	protected LogRecord(LogController   source,
											String          locName,
											Thread          thr,
											int             severity,
											String[] 		relatives,
											int             msgType,
											Object          msgCode,
											String          resourceBundleName,
											String          msgClear,
											String[]        args,
                                            String          csnComponent) {
    
		//RUNTIME PROPERTIES
		setRuntimeProperties();
        setThreadRuntimeProperties(); //DSRTransaction and Correlation ID 
					 
//		this.id 				= new GUId(getCorrelatorID()); //GUID will contain CorrelatorID
        this.id                 = new GUId();
		this.time 				= new Date();
		if (source != null) {
			this.sourceName = source.getName();
		}
		this.locationName = locName;
		this.thrName 			= thr.toString();
	
		this.relatives 		= relatives;
		this.severity 		= severity;

		this.args 				= args;
		if (args != null) {
			  nonExceptionArgsCount = args.length;
		}	  
	
	  this.msgType 			= msgType;
	  this.msgDefault   = msgClear;
	  this.msgClear 		= msgClear;
      this.csnComponent = csnComponent;
	  
		if (msgCode != null) {
			this.msgCode 		= msgCode.toString();
		} 			
		
	}
    
	protected LogRecord(String msgId,
                        String correlationID,
                        int 	 size,
                        Date  time,
                        String timeZone,
						String source,
						int    severity,
						String loc,
						String[] relatives,
						String thr,
						int msgType,
						String msgCode,
						String msgAlias,
						String resourceBundleName,
						String msgClear,
						Object[] args,
						String application,
						String user,
						String session,
						String transaction,
						String dsrTransaction,
						String dsrRootContextID,
						String dsrConnection,
                        int   dsrCounter,
						MessageAccessor msgAccessor,
                        String csnComponent,
                        String dcName) {
													
		this.id                 = new GUId(msgId);
        try {
            this.correlatorID = Long.parseLong(correlationID);
        } catch (NumberFormatException e) {
            this.correlatorID = UID.EMPTY_CORRELATOR_ID;
        }
	  this.lrSize							= size;
    this.internalThread     = true;
	  this.time               = time;
    this.timeZone           = timeZone;
	  this.sourceName         = source;
	  this.severity           = severity;
	  this.locationName       = loc;
	  this.relatives          = relatives;
	  this.thrName            = thr;
	  this.msgType            = msgType;
	  this.msgCode            = msgCode;
	  this.msgAlias           = msgAlias;
	  this.resourceBundleName = resourceBundleName;
	  this.args               = getArgStrsInt(args);
	  this.argsObj						= args;	  
	  if (args != null) {
		  nonExceptionArgsCount = args.length;
	  }	  
	  this.application        = application;
	  this.user               = user;
	  this.session            = session;
	  this.transaction        = transaction;
      this.dsrTransactionID = dsrTransaction;
      this.dsrRootContextID = dsrRootContextID;
      this.dsrConnection = dsrConnection;
      this.dsrCounter = dsrCounter;
	  this.msgDefault      		= msgClear;
	  this.msgClear         	= msgClear;
      this.csnComponent = csnComponent;
      this.dcName = dcName;
      
		
		if (msgAccessor != null && msgCode != null) {
			try {
				LocalizedMessage locMessage = msgAccessor.getLocalizedMessage(new MessageID(msgCode));
				
				if (locMessage != null) {		
					this.msgLocalized = locMessage.getLongText();
					this.msgClear     = this.msgLocalized;
				} else {
					this.msgLocalized  	= null;
					this.msgClear       = msgClear;
				}
			}
			catch (Exception ex) {
				this.msgLocalized  	= null;
				this.msgClear       = msgClear;
			}
		}		
	}
	
	// Constructing a log record from an already existing log/trace message
	protected LogRecord(String msgId,
										  Date  time,
											String source,
											int    severity,
											String loc,
											String[] relatives,
											String groupId,
											int    level,
											int    indent,
											String thr,
											int msgType,
											String msgCode,
											String resourceBundleName,
											String msgClear,
											Object[] args,
											String application,
											String user,
											String session,
											String transaction,
											String dsrTransaction,
											String dsrRootContextID,
											String dsrConnection,
                                            int dsrCounter) {
        
	  this.id                 = new GUId(msgId);
    this.internalThread     = true;
	  this.time               = time;
	  this.sourceName         = source;
	  this.severity           = severity;
	  this.locationName       = loc;
	  this.relatives          = relatives;
	  this.thrName            = thr;
	  this.msgType            = msgType;
	  this.msgCode            = msgCode;
	  this.resourceBundleName = resourceBundleName;
	  this.msgClear           = msgClear;
	  this.args               = getArgStrsInt(args);
	  this.argsObj						= args;
	  if (args != null) {
		  nonExceptionArgsCount = args.length;
	  }	  
	  this.application        = application;
	  this.user               = user;
	  this.session            = session;
	  this.transaction        = transaction;
      
      this.dsrTransactionID     = dsrTransaction;
      this.dsrRootContextID   = dsrRootContextID;
      this.dsrConnection      = dsrConnection;
      this.dsrCounter         = dsrCounter;
	}
	
	LogRecord(LogController  source,
		  String         loc,
		  int            severity,
		  String[] 			 relatives,
		  int            msgType,
		  String         msg,
		  Object[]       args,
			Throwable      msgException) {
		
		this (source,
					loc,
					severity,
					relatives,
					msgType,
					msg,
					getArgStrsInt(args));	
				
		this.argsObj 			= args;
		this.msgException = msgException;
		
		buildException(source);
		
	}
	
  LogRecord(LogController  source,
						  String         loc,
						  int            severity,
						  String[] 			 relatives,
						  int            msgType,
						  String         msg,
						  Object[]       args) {
		this (source,
					loc,
					severity,
					relatives,
					msgType,
					msg,
					getArgStrsInt(args));	
					
		this.argsObj = args;
	}

  protected LogRecord(LogController   source,
            String          locName,
            int             severity,
            String[]                relatives,
            int             msgType,
            Object          msgCode,
            String          resourceBundleName,
            String                  msgClear,
            Object[]        args,
            Throwable               msgExc) {
      this (source, locName, severity, relatives, msgType, msgCode, resourceBundleName, msgClear, args, msgExc, null);
      
  }
  
  protected LogRecord(LogController   source,
			String          locName,
			int             severity,
			String[] 				relatives,
			int             msgType,
			Object          msgCode,
			String          resourceBundleName,
			String 					msgClear,
			Object[]        args,
			Throwable				msgExc,
            String csnComponent) {
  	
  	this (source,
				  locName,
				  Thread.currentThread(),
				  severity,
				  relatives,
				  msgType,
				  msgCode,
				  resourceBundleName,
				  msgClear,
				  getArgStrsInt(args),
                  csnComponent);
			  	
  	this.argsObj 			= args;
  	this.msgException = msgExc;
  	
  	buildException(source);
  	
  }
  
	protected LogRecord(LogController   source,
						  				String          locName,
						  				int             severity,
						  				String[] 				relatives,
						  				int             msgType,
						  				Object          msgCode,
						  				String          resourceBundleName,
						  				String 					msgClear,
						  				Object[]        args) {
		
	 	this (source,
				  locName,
				  Thread.currentThread(),
				  severity,
				  relatives,
				  msgType,
				  msgCode,
				  resourceBundleName,
				  msgClear,
				  getArgStrsInt(args),
                  null);
				  	
		this.argsObj = args;
	}
	
	protected LogRecord(LogController   source,
												String          locName,
												Thread          thr,
												int             severity,
												String[] 				relatives,
												int             msgType,
												Object          msgCode,
												String          resourceBundleName,
												String          msgClear,
												Object[]        args) {
		
		this (source,
					locName,
					thr,
					severity,
					relatives,
					msgType,
					msgCode,
					resourceBundleName,
					msgClear,
					getArgStrsInt(args),
                    null);		
					
		this.argsObj = args;								
	}
	
	//Constructing a log record from an already existing log/trace message
	protected LogRecord(String msgId,
						 					Date  time,
											String source,
											int    severity,
											String loc,
											LogController[] relatives,
											String groupId,
											int    level,
											int    indent,
											String thr,
											int msgType,
											String msgCode,
											String resourceBundleName,
											String msgClear,
											String[] args,
											String application,
											String user,
											String session,
											String transaction) {
	   
		// The new fields dsrTransaction, dsrRootContextID, dsrConnection and dsrCounter are initialized
	  // with empty string (or zero)
        
	  this(msgId,
				 time,
				 source,
				 severity,
				 loc,
				 convertRelatives(relatives),
				 groupId,
				 level,
				 indent,
				 thr,
				 msgType,
				 msgCode,
				 resourceBundleName,
				 msgClear,
				 args,
				 application,
				 user,
				 session,
				 transaction,
				 EMPTY_STRING,
				 EMPTY_STRING,
				 EMPTY_STRING,
                 0);
	 } 
	 
  /**
		* @deprecated 
		*/
  protected LogRecord(LogController   source,
                      String          locName,
                      Thread          thr,
                      int             severity,
                      LogController[] relatives,
                      int             msgType,
                      Object          msgCode,
                      String          resourceBundleName,
                      String          msgClear,
                      Object[]        args) {
    
		
		this (source,
				  locName,
					thr,
					severity,
					convertRelatives(relatives),
					msgType,
					msgCode,
					resourceBundleName,
					msgClear,
					getArgStrsInt(args));	
					
		this.argsObj = args;		
  }
  
	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====
	
	/**
   * Gets the message identification of this log record.
   * This identification is written to logs via most formatters and allows for
   * unambiguous cross-referencing among messages in different logs.
   * @return Unique message id
   */
  public GUId getId() {
		return id;
  }
  
	/**
   * Gets size of this LogRecord.
   * The LogRecord size represent size of the LogRecord 
   * in the log file.  
   * @return Size in number of bytes.
   */
  public int getSize() {
		return lrSize;
  }
  
  public boolean isThreadInternal() {
	return internalThread;  
  }
  
  public void setThreadInternal(boolean b) {
	internalThread = b;  
  }
  
  /**
   * Gets the instantiation date of this log record in milliseconds.
   * @return Instantiation date in milliseconds
   */
  public Date getTime() {
    if (internalThread) {
	  return time;
	} else {
	  return refreshTime(new Date(System.currentTimeMillis())); 
	}
  }
  
  public Date refreshTime(Date timeStamp) {
	if (time.before(timeStamp)) { 
	  time = timeStamp;
	}
	return time;
  }

  public String getTimeZone() {
      if (timeZone!=null){
        return timeZone;
      } else {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(time);
        
        StringBuilder sb = new StringBuilder(5);
        
        int value = (c.get(Calendar.ZONE_OFFSET) +
             c.get(Calendar.DST_OFFSET)) / 60000;

        if (value >= 0) {
          sb.append('+');
        }
        
        int num = (value / 60) * 100 + (value % 60);
        sb.append(num < 1000 ? "0" + num : num);
        
        timeZone = sb.toString();
        return timeZone;
      }
  }

//**************************************************
	//      Implementation of IPRRecord inteface
	//**************************************************
	
  /**
   * Gets the application on behalf of which this log record was issued.
   * @return Application
   */
  public String getApplication() {
		if (application != null) {
			return application;
		}
		return EMPTY_STRING;
  }
  
  public void setApplication(String value) {
	  application = value;
  }

  /**
   * Gets the user on behalf of which this log record was issued.
   * @return User
   */
  public String getUser() {
		if (user != null) {
			return user;
		}
		return EMPTY_STRING;
  }

  public void setUser(String value) {
		user = value;
  }
	
  /**
   * Gets the session on behalf of which this log record was issued.
   * @return Session
   */
  public String getSession() {
		if (session != null) {
			return session;
		}
		return EMPTY_STRING;
  }

  public void setSession(String value) {
		session = value;
  }
	
  public void setSourceName (String source) {
	sourceName = source;  
  }
  
  /**
   * Gets the application on behalf of which this log record was issued.
   * @return Transaction
   */
  public String getTransaction() {
		if (transaction != null) {
			return transaction;
		}
		return EMPTY_STRING;
  }

  public void setTransaction(String value) {
		transaction = value;
  }
  

  /**
   * @deprecated
   */
  public String getDsrComponent() {
		return EMPTY_STRING;
  }

  /**
   * @deprecated
   */  
  public void setDsrComponent(String value) {
  }
  
  /**
   * @deprecated
   */
  public String getDsrUser() {
		return EMPTY_STRING;
  }
  /**
   * @deprecated
   */
  public void setDsrUser(String value) {
  }
  
  /**
   * @deprecated
   */
  public String getDsrTransaction() {
        return EMPTY_STRING;
  }
  
  /**
   * @deprecated
   */  
  public void setDsrTransaction(String value) {
  }

	
  /*    String getDSRRootContextID();
  void setDSRRootContextID(String value);
  String getDSRTransaction();
  void setDSRTransaction(String value);
  String getDSRConnection();
  void setDSRConnection(String value);
  long getDSRCounter();
  void setDSRCounter(long value);*/
  
  public String getDSRRootContextID() {
      if (dsrRootContextID != null) {
          return dsrRootContextID;
      }
      return EMPTY_STRING;
  }
  
  public void setDSRRootContextID(String value) {
      dsrRootContextID = value;
  }
  
  public String getDSRConnection() {
      if (dsrConnection != null) {
          return dsrConnection;
      }
      return EMPTY_STRING;
  }
  
  public void setDSRConnection(String value) {
      dsrConnection = value;
  }
  
  public int getDSRCounter() {
      return dsrCounter;
  }
  
  public void setDSRCounter(int value) {
      dsrCounter = value;
  }

  /**
   * Gets the DSR (Distributed Statistics Record) transaction on behalf of which
   * this log record was issued.
   * @return DSR transaction
   */
  public String getDSRTransactionID() {
		if (dsrTransactionID != null) {
			return dsrTransactionID;
		}
		return EMPTY_STRING;
  }

  public void setDSRTransactionID(String value) {
		dsrTransactionID = value;
  }
  
  /**
   * Gets the Correlator Id on behalf of which
   * this log record was issued.
   * @return Correlator Id
   */
  public long getCorrelatorID() {
	  return correlatorID;		
  }

  public void setCorrelatorID(long value) {
	  correlatorID = value;
  }
  
  /**
	 * @return Returns the sysHostName.
	 */
	public String getSysHostName() {
		if (sysHostName != null) {
			return sysHostName;
		}
		return EMPTY_STRING;
	}
	
	/**
	 * @param sysHostName The sysHostName to set.
	 */
	public void setSysHostName(String value) {
		this.sysHostName = value;
	}
	
	/**
	 * @return Returns the sysInstanceName.
	 */
	public String getSysInstanceName() {
		if (sysInstanceName != null) {
			return sysInstanceName;
		}
		return EMPTY_STRING;
	}
	
	/**
	 * @param sysInstanceName The sysInstanceName to set.
	 */
	public void setSysInstanceName(String value) {
		this.sysInstanceName = value;
	}
	
	/**
	 * @return Returns the sysName.
	 */
	public String getSysName() {
		if (sysName != null) {
			return sysName;
		}
		return EMPTY_STRING;
	}
	
	/**
	 * @param sysName The sysName to set.
	 */
	public void setSysName(String value) {
		this.sysName = value;
	}
	
	/**
	 * @return Returns the sysNodeID.
	 */
	public String getSysNodeID() {
		if (sysNodeID != null) {
			return sysNodeID;
		}
		return EMPTY_STRING;
	}
	
	/**
	 * @param sysNodeID The sysNodeID to set.
	 */
	public void setSysNodeID(String value) {
		this.sysNodeID = value;
	}
	
	//**************************************************
	//   								GROUP DATA
	//**************************************************
	/**
	 * @deprecated Not supported anymore
	 * @return 
	 */
	public boolean isGroupActive() {
		return false;
	}
		
  /**
   * @deprecated Not supported anymore
   * @return Collections.EMPTY_LIST
   */
  public List getGroups() {
		return Collections.EMPTY_LIST;
  }

  /**
   * @deprecated Not supported anymore
	 * @return null
   */
  public Group getGroup() {
		return null;
  }

	/**
	 * @deprecated Not supported anymore 
	 * @see #getGroupID()
	 * @return null
	 */
  public GUId getGroupId() {
	  return null;
  }
  
  /**
	 * Gets the identification of the group this log record belongs to.
	 * @return Unique group id
     * @deprecated
	 */
  public String getGroupID() {
		return EMPTY_STRING;
	}

	/**
   * Gets the name of the log controller this log record came from.
   * @return Name of log controller
   */
  public String getSourceName(){
		if (sourceName != null) {
			return sourceName;
		}
		return EMPTY_STRING;
  }

  /**
	 * Gets the name of the location the message belonging to this log record
	 * came from.
	 * @return Name of location
	 */
	public String getLocationName() {
	  if (locationName != null) {
			return locationName;
	  }
	  return EMPTY_STRING;
	}
	
	/**
	 * Gets the name of the group this log record belongs to.
	 * @return Group name
     * @deprecated 
	 */
  public String getGroupName() {
		return EMPTY_STRING;
	}
	
	/**
	 * Gets the description of the group this log record belongs to.
	 * @return Description text
     * @deprecated 
	 */
  public String getGroupDescription() {

		return EMPTY_STRING;
	}
	
	/**
   * Gets the indentation of nested groups of this log record. This is the level
   * of this log record less the level of the log record emitted via this log
   * controller and thread before.
   * @return Indentation of nested groups
   * @deprecated
   */
	public int getGroupIndent() {
		return -1;
	}
	
	/**
   * Gets the level of nested groups this log record belongs to. This is
   * equivalent to {@link #getGroups()}<code>.size()</code>.
   * @return Level of nested groups
   * @deprecated
   */
	public int getGroupLevel() {
		  return -1;
	}
	
	/**
   * Gets the name of the thread this log record belongs to
   * @return Name of the thread
   */
	public String getThreadName(){
  	if (thrName != null) {
			return thrName;
   	}
   	return EMPTY_STRING;
 	}

  /**
   * Gets the severity of this log record.
   * @return Severity
   */
  public int getSeverity() {
		return severity;
  }

  /**
   * Gets the type of the message text of this log record.
   * @return Type of message text
   */
  public int getMsgType() {
		return msgType;
  }

  /**
   * Gets the <code>toString</code> result of the language-independent message
   * code of this log record.
   * @return Code of language-independent message
   */
  public String getMsgCode() {
		if (msgCode != null) {
			return msgCode;
		}
		return EMPTY_STRING;
  }
  
  public String getCsnComponent() {
        if (csnComponent != null) {
            return csnComponent;
        }
        return EMPTY_STRING;
  }  
  
  public String getDCName() {
      if (dcName != null) {
          return dcName;
      }
      return EMPTY_STRING;
  }  
  
  /**
   * Gets the unique message alias.
   * @return Unique message alias string.
   */
  public String getMsgAlias() {
		if (msgAlias != null) {
			return msgAlias;
		}
		return EMPTY_STRING;
  }

  /**
   * Gets the name of the resource bundle assigned to the language-independent
   * message belonging to this log record.
   * @return Name of resource bundle
   */
  public String getResourceBundleName() {
		if (resourceBundleName != null) {
			return resourceBundleName;
		}
		return EMPTY_STRING;
  }

  /**
   * Gets the full message of this log record.
   * @return Full message (getMsgClear() + getArgs())
   */
  public String getMessage() {
		if (msgType == MsgType.JAVA) {
		  return LogController.replaceArguments(getMsgClear(), getArgsInt());
		}
		return msgClear;
  }
  
  /**
   * Gets the clear text version of this log record.
   * @return Clear text version
   */
  public String getMsgClear() {
		if (msgClear != null) {
			return msgClear;
		}
		return EMPTY_STRING;
  }
  
  /**
	 * Gets the default text version of this log record.
	 * @return Default text version
	 */
	public String getMsgDefault() {
	  if (msgDefault != null) {
		  return msgDefault;
	  }
	  return EMPTY_STRING;
	}
	
	/**
   * Gets the localized text version of this log record.
   * @return Localized text version
   */
  public String getMsgLocalized() {
		if (msgLocalized != null) {
			return msgLocalized;
		}
		return EMPTY_STRING;
  }
  
  /**
   * Gets the exception of this log record.
   * @return Throwable object
   */
  public Throwable getMsgException() {
		return msgException;
  }
 
  /**
   * Gets the <code>toString</code> results of the argument objects of the
   * template-based message belonging to this log record.
   * @return Unmodifiable list of message argument strings
   */
  public List getArgs() {
		if (args != null) {
		  return Collections.unmodifiableList(new ArrayList(Arrays.asList(args)));
		} 
		else {
		  return Collections.EMPTY_LIST;
		}
  }

  /**
 	 * Gets the argument objects of the template-based message 
 	 * belonging to this log record.
 	 * @return Unmodifiable list of argument objects
 	 */
	public List getArgObjs() {
	  if (argsObj != null) {
			return Collections.unmodifiableList(new ArrayList(Arrays.asList(argsObj)));
	  } 
	  else {
			return Collections.EMPTY_LIST;
	  }
	}
	
	public int getNonExceptionArgsCount() {
		return nonExceptionArgsCount;
	}

  /**
	 * Gets the log controllers related to the source of this log record.
   * @return Unmodifiable collection of related log controllers
   */
	public Collection getRelatives() {
  	if (relatives != null) {
			return Collections.unmodifiableCollection(new ArrayList(Arrays.asList(relatives)));
   	} 
  	else {
			return Collections.EMPTY_LIST;
   	}
 	}

	public boolean equals(Object obj) {
		if (obj instanceof LogRecord) {
		  return this.id.equals(((LogRecord) obj).id);
		} 
		else {
		  return false;
		}
  }

  public int hashCode() {
		return id.hashCode();
  }

  /**
	 * @see com.sap.tc.logging.LogRecord#getBookMark() 
	 * @param value The BookMark value to set.
	 */
	public void setBookMark(long value) {
		this.lrBookMark = value;
	}
	
	/**
	 * BookMark represents a pointer in the Log where this LogRecord starts.
	 * @return Returns the BookMark.
	 */
	public long getBookMark() {
		return lrBookMark;
	}
	
	/**
	 * Log name represents a Log where this LogRecord is written to.
	 * @return Returns the Log Name.
	 */
	public String getLogName() {
		return lrLogName;
	}
	
	/**
	 * @see com.sap.tc.logging.LogRecord#getLogName() 
	 * @param value The Log name to set.
	 */
	public void setLogName(String value) {
		this.lrLogName = value;
	}
	
	//==== < public ==================================== protected > ====
	
	//==== < protected =================================== default > ====
	
	String getTimeString() {
		return formatTime(time);
  }

  /**
   * Gets the log controllers related to the source of this log record.
   * @return Related log controllers
   */
  String[] getRelativesInt() {
		return relatives;
  }

  /**
	 * Gets the <code>toString</code> results of the argument objects of the
	 * template-based message belonging to this log record.
	 * @return Message argument strings
	 */
	static String[] getArgStrsInt(Object[] argsLikeObjects) {

	  String[] argStrs = null;

	  if (argsLikeObjects != null) {
		  argStrs = new String[argsLikeObjects.length];
			for (int i = 0; i < argsLikeObjects.length; i++) {
			  if (argsLikeObjects[i] != null) {
					try {
						  argStrs[i] = argsLikeObjects[i].toString();
					} 
					catch (Exception ex) {
						APILogger
							.logIntByAPI(Severity.WARNING,
							  					 classLoc,
							  					 "[getArgStrsInt()]",
							  					 "ASJ.log_api.000051",
							  					"Message argument error! Invocation of Object.toString() failed", null);
						APILogger.catchingIntByAPI(ex);
					
						argStrs[i] = NULL_STRING;
					}
			  } 
			  else {
				  argStrs[i] = NULL_STRING;
			  }
			}
	  }
	  return argStrs;
	}

  static String formatTime(Date time) {
		// Newly format timestamp only if it actually would change, that is at most
		// once every second, as formatting is very costly. Synchronisation is not
		// necessary as the worst thing that can happen is that the time stamp is
		// unnecessarily formatted two or a few more times.
		long thisTimeInSeconds = time.getTime() / 1000;
	
		if (lastTimeInSeconds != thisTimeInSeconds) {
		  lastTimeString    = timeFormatter.format(time);
		  lastTimeInSeconds = thisTimeInSeconds;
		}
		return lastTimeString;
  }
	
  /**
   * @deprecated
   * @param value
   */
  void setGroupID(String value) {
		return;
	}
	
  /**
   * @deprecated
   * @param value
   */
	void setGroupName(String value) {
		return;
	}
 
    /**
     * @deprecated
     * @param value
     */
	void setGroupDescription(String value) {
		return;
	}
		
    /**
     * @deprecated
     */
	void setGroupIndent(int value) {
		return;
	}

    /**
     * @deprecated
     * @param value
     */
	void setGroupLevel(int value) {
		return;
	}

	Object[] getArgsInt() {
		return args;
  }

	//==== < default ===================================== private > ====
  
	// Get names from relatives list 
	// and put them to the String array
  private static String[] convertRelatives (LogController[] relatives) {
	
	  String[] tmpValues = null;
	
	  if (relatives != null) {
		  tmpValues = new String[relatives.length];
		  	
		  for (int i = 0; i < relatives.length; ++i) {
			  tmpValues[i] = relatives[i].getName();
		}
	  }
	  return tmpValues;	
  }
  
  private void setThreadRuntimeProperties() {
      if (LoggingManager.threadInfoProvider != null) {
          this.correlatorID = LoggingManager.threadInfoProvider.getCorrelationID();
          this.dsrTransactionID = LoggingManager.threadInfoProvider.getDsrTransactionID();
      }
  }
  
  private void setRuntimeProperties() {
    try {
    	if (rpPublisher == null) {
				rpPublisher = LoggingManager.getRuntimePropertiesPublisher();
    	}
			if (rpPublisher != null) {
				rpPublisher.reInitProperties(this);
			}
    }
    catch (Exception ex) {
      // Should not happen...
    }
  }         

	private LogController[] copyRelatives(LogController[] relatives) {
		
		if (relatives != null) {
			
			LogController[] tmpRelatives = null;
			int relativesCnt = 0;
			
			for (int i = 0; i < relatives.length; ++i) {
				if (relatives[i] != null) {
					++relativesCnt;
				}
			}
			
			if (relativesCnt > 0) {
				int j = 0;
				tmpRelatives = new LogController[relativesCnt];
				for (int i = 0; i < relatives.length; ++i) {
					if (relatives[i] != null) {
						tmpRelatives[j] = relatives[i];
						++j;
			  	}
				}
			}
			return tmpRelatives;
		}
		return null;
	}
	
	private String getNewMsg(String msg, int argsLength) {
		return msg + EXCEPTION_POINTER + "{" + (argsLength - 1) + "}";
	}
	
	private Object[] getNewArgs(Object[] args, Throwable exc) {
	  
		Object[] tmpArgs = args;
		
		if (args != null) {
			tmpArgs = new Object[args.length + 1];
		  for (int i = 0;  i < args.length; i++){
				tmpArgs[i] = args[i];
		  }
			tmpArgs[tmpArgs.length -1] = ExceptionManager.getStackTrace(exc);
	  }
	  
	 	return tmpArgs;
	 }
	
	private void buildException(LogController source) {
		//  Build Exception in to message
		if (this.msgException != null && (source != null && source instanceof Location)) {
			// Modify message and arguments
			if (this.argsObj == null) {
				this.argsObj = new Object [] {ExceptionManager.getStackTrace(this.msgException)};
				this.msgType = MsgType.JAVA;
			}
			else {
				// Place exception like new item
				this.argsObj = getNewArgs(this.argsObj, this.msgException);
			}
			// Create argument id for the exception inside message
			this.msgClear = getNewMsg(this.msgClear, this.argsObj.length);
			
			this.args = getArgStrsInt(this.argsObj);
		}
	}
	
	//==== < private ================================== deprecated > ====
	
  /**
   * @deprecated Not supported anymore - always return null
   */
  public LogController getSource() {
    return null;
  }

  /**
	 * @deprecated @see #getLocationName()
	 */
	public String getLocation() {
		return getLocationName();
	}
  
	/**
	 * @deprecated @see #getGroupLevel()
	 */
  public int getLevel() {
    return getGroupLevel();
  }

  /**
   * @deprecated @see #getGroupIndent()
   */
  public int getIndent() {
    return getGroupIndent();
  }
 
	/**
  * @deprecated Not supported anymore - always return null
  */
 	public Thread getThread() {
  	return null;
 	}
    
    /**
     * @deprecated - obsolete - some LogRecord properties were removed and new were introduced with CL 189383 / perforce 3301
     */
    protected LogRecord(LogController   source,
            String          locName,
            Thread          thr,
            int             severity,
            String[]                relatives,
            int             msgType,
            Object          msgCode,
            String          resourceBundleName,
            String          msgClear,
            String[]        args) {
        this(source, locName, thr, severity, relatives, msgType, msgCode, resourceBundleName, msgClear, args, null);
    }
    
    /**
     * @deprecated - obsolete - some LogRecord properties were removed and new were introduced with CL 189383 / perforce 3301
     */    
    protected LogRecord(String msgId,
            int      size,
            Date  time,
            String source,
            int    severity,
            String loc,
            String[] relatives,
            String groupId,
            int    level,
            int    indent,
            String thr,
            int msgType,
            String msgCode,
            String msgAlias,
            String resourceBundleName,
            String msgClear,
            Object[] args,
            String application,
            String user,
            String session,
            String transaction,
            String dsrComponent,
            String dsrUser,
            String dsrTransaction,
            MessageAccessor msgAccessor) {
      this(msgId, "-1", size, time, null, source, severity, loc, relatives,
           thr, msgType, msgCode, msgAlias, resourceBundleName, msgClear,
           args, application, user, session, transaction, dsrTransaction, dsrUser, dsrComponent, -1, msgAccessor,
           null, null);
    }
    
    /**
     * @deprecated - obsolete - some LogRecord properties were removed and new were introduced with CL 189383 / perforce 3301
     */   
    protected LogRecord(String msgId,
            int      size,
            Date  time,
            String source,
            int    severity,
            String loc,
            String[] relatives,
            String groupId,
            int    level,
            int    indent,
            String thr,
            int msgType,
            String msgCode,
            String resourceBundleName,
            String msgClear,
            Object[] args,
            String application,
            String user,
            String session,
            String transaction,
            String dsrComponent,
            String dsrUser,
            String dsrTransaction) {
        this(msgId, "-1", size, time, null, source, severity, loc, relatives,
                thr, msgType, msgCode, null, resourceBundleName, msgClear,
                args, application, user, session, transaction, dsrTransaction, dsrUser, dsrComponent, -1, null,
                null, null);   
    }
    
    /**
     * @deprecated - obsolete - some LogRecord properties were removed and new were introduced with CL 189383 / perforce 3301
     */    
    protected LogRecord(String msgId,
              Date  time,
                String source,
                int    severity,
                String loc,
                String[] relatives,
                String groupId,
                int    level,
                int    indent,
                String thr,
                int msgType,
                String msgCode,
                String resourceBundleName,
                String msgClear,
                Object[] args,
                String application,
                String user,
                String session,
                String transaction,
                String dsrComponent,
                String dsrUser,
                String dsrTransaction) { 
        this(msgId, time, source, severity, loc, relatives, groupId, level, indent,
                thr, msgType, msgCode, resourceBundleName, msgClear, args,
                application, user, session, transaction, dsrComponent, dsrUser, dsrTransaction,
                -1);
    }

}