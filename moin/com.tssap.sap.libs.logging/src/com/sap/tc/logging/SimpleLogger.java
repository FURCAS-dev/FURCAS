package com.sap.tc.logging;

/*
 * Title:        Logging
 * Description:  Logging API
 * Copyright:    Copyright (c) 2003
 * Company:      SAP AG
 *               Walldorf, Germany
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAP AG. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAP AG.
 */



/**
 * <p>
 *   Simplier way to write log records to destinations.
 * </p>
 * <p>
 * </p>
 * @see    LogController
 * @see    Severity
 * @see    Location
 * @see    Category
 * @see    LogRecord
 */

/**
 *  Exposes main functionality of SAP Logging API by the means of several, easy to use methods
 */
public class SimpleLogger {

  /**
   * Determines if a message with provided severity will pass severity check for Log Controller and will be written
   * 
   * @param severity Severity to check against
   * @param lc Log Controller to chack against
   * @return true if a message with specified severity will be written through specified Log Controller. False otherwise.
   */
  public static boolean isWritable (int severity, LogController lc) {
    return (lc.getIsActivityTrackingEnabled() && lc.isActivityTracking(severity)) || severity >= lc.getEffectiveSeverity();
  }
 
    /**
     * Issues a trace message through a Location
     * 
     * @param severity severity of the trace message that is issued
     * @param location Location where the message will be dispatched to and from where (if severity check is passed) it will be issued.
     * @param message the message text itself
     * @return LogRecord object encapsulating the message that has been written. null if no message has been written.
     */
    public static LogRecord trace (int severity, Location location, String message)
    {
    LogRecord writtenRec = null;

        if (isWritable(severity, location)) {
            writtenRec = 
                location.logInt(severity, 
                                location, 
                                null, //relatives 
                                null, //subloc
                                null, //msgCode
                                (location == null) ? null : location.csnComponent, //csnComponent
                                (location == null) ? null : location.dcName, //dcName                                
                                message, 
                                MsgType.PLAIN,
                                (Object[]) null,
                                null); //messageException
        }
        return writtenRec;
    }   

    /**
     * Issues a trace message through a Location. Makes use of Message ID concept.
     * 
     * @param severity severity of the trace message that is issued
     * @param location Location where the message will be dispatched to and from where (if severity check is passed) it will be issued.
     * @param messageID messageID to be assigned to this message. MessageID format is [prefix]-[range][number] (e.g. ASJ-jndi-000135) 
     * @param message the message text itself
     * @return LogRecord object encapsulating the message that has been written. null if no message has been written.
     */
    public static LogRecord trace (int severity, Location location, String messageID, String message)
    {
    LogRecord writtenRec = null;

        if (isWritable(severity, location)) {
            writtenRec = 
                 location.logInt(severity, 
                                 location, 
                                 null, //relatives 
                                 null, //subloc
                                 (messageID == null) ? "" : location.vendor + messageID, //msgCode
                                 (location == null) ? null : location.csnComponent, //csnComponent
                                 (location == null) ? null : location.dcName, //dcName                                
                                 message, 
                                 MsgType.PLAIN,
                                 (Object[]) null,
                                 null); //messageException            
        }
        return writtenRec;
    }   
        
    /**
     * Issues a trace message through a Location.
     * 
     * @param severity severity of the trace message that is issued
     * @param location Location where the message will be dispatched to and from where (if severity check is passed) it will be issued.
     * @param message the message text itself
     * @param args values to be placed in the text message. Each of the message placeholders {0}, {1} will be replaced with args[0], args[1], etc.  
     * @return LogRecord object encapsulating the message that has been written. null if no message has been written.
     */    
    public static LogRecord trace (int severity, Location location, String message, Object... args) {
        return trace(severity, location, null, message, args);
    }
    
    /**
     * Issues a trace message through a Location.
     * 
     * @param severity severity of the trace message that is issued
     * @param location Location where the message will be dispatched to and from where (if severity check is passed) it will be issued.
     * @param messageID messageID to be assigned to this message. MessageID format is [prefix]-[range][number] (e.g. ASJ-jndi-000135) 
     * @param message the message text itself
     * @param args values to be placed in the text message. Each of the message placeholders {0}, {1} will be replaced with args[0], args[1], etc.  
     * @return LogRecord object encapsulating the message that has been written. null if no message has been written.
     */    
    public static LogRecord trace (int severity, Location location, String messageID, String message, Object... args)
    {
    LogRecord writtenRec = null;

        if (isWritable(severity, location)) {
            if (args != null) {
                StringBuilder messageBuilder = new StringBuilder(message);
                int ind = 0;
                for (Object o : args) {
                    int ii = messageBuilder.indexOf("{" + ind + "}");
                    if (ii >= 0) {
                      messageBuilder.replace(ii, ii + 3, (o==null)?"null":o.toString());
                    }
                    ind++;
                }
                message = messageBuilder.toString();
            }
           
            writtenRec = 
                    location.logInt(severity, 
                                    location, 
                                    null, //relatives 
                                    null, //subloc
                                    (messageID == null) ? "" : location.vendor + messageID, //msgCode
                                    (location == null) ? null : location.csnComponent, //csnComponent
                                    (location == null) ? null : location.dcName, //dcName                                
                                    message, 
                                    MsgType.PLAIN,
                                    (Object[]) null,
                                    null); //messageException
        }
        return writtenRec;
    }   

    /**
     * Issues a trace message through a Location.
     * 
     * @param severity severity of the trace message that is issued
     * @param location Location where the message will be dispatched to and from where (if severity check is passed) it will be issued. 
     * @param dcName DC name to be written in the trace entry
     * @param csnComponent CSN Component to be written in the trace entry
     * @param messageID messageID to be assigned to this message. MessageID format is [prefix]-[range][number] (e.g. ASJ-jndi-000135) 
     * @param message the message text itself
     * @param exc If not null, the exception stacktrace is formatted and appended at the end of the trace record as a message parameter
     * @param args values to be placed in the text message. Each of the message placeholders {0}, {1} will be replaced with args[0], args[1], etc.  
     * @return LogRecord object encapsulating the message that has been written. null if no message has been written.
     */    
    public static LogRecord trace (int severity, Location location, String dcName,
                                   String csnComponent, String messageID, String message,
                                   Throwable exc, Object... args) {
        LogRecord writtenRec = null;        
        if (isWritable(severity, location)) {
            if (args != null) {
                StringBuilder messageBuilder = new StringBuilder(message);
                int ind = 0;
                for (Object o : args) {
                    int ii = messageBuilder.indexOf("{" + ind + "}");
                    if (ii >= 0) {
                      messageBuilder.replace(ii, ii + 3, (o==null)?"null":o.toString());
                    }
                    ind++;
                }
                message = messageBuilder.toString();
            }
            
            if (dcName != null && csnComponent == null) {
                if (LoggingManager.deployInfoProvider != null) {
                    csnComponent = LoggingManager.deployInfoProvider.getCsnComponentByDcName(dcName);
                }  
            }            
            
            writtenRec = location.logInt(severity,
                                         location,
                                         null,
                                         null,
                                         (messageID == null) ? "" : location.vendor + messageID,
                                         (csnComponent == null) ? ((location == null) ? null : location.csnComponent) : csnComponent,
                                         (dcName == null) ? ((location == null) ? null : location.dcName) : dcName,
                                         message,
                                         MsgType.PLAIN,
                                         null,
                                         exc);                
        }
        return writtenRec;        
    }
    
    /**
     * Issues a trace message through a Location. traceThrowable methods are designed to format and write exception stacktraces.  
     * 
     * @param severity Severity of the trace message that is issued
     * @param location Location where the message will be dispatched to and from where (if severity check is passed) it will be issued.
     * @param message The message text itself. It should be different from exc.getMessage()
     * @param exc The exception stacktrace is formatted and appended at the end of the trace record as a message parameter
     * @return LogRecord object encapsulating the message that has been written. null if no message has been written.
     */
    public static LogRecord traceThrowable (int severity, Location location, String message, Throwable exc)
    {
    LogRecord writtenRec = null;

        if (isWritable(severity, location)) {
            writtenRec = 
                location.logInt(severity, 
                                location, 
                                null, //relatives 
                                null, //subloc
                                null, //msgCode
                                (location == null) ? null : location.csnComponent, //csnComponent
                                (location == null) ? null : location.dcName, //dcName                                
                                message, 
                                MsgType.PLAIN,
                                (Object[]) null,
                                exc); //messageException               
        }
        return writtenRec;
    }
    
    /**
     * Issues a trace message through a Location. Makes use of Message ID concept.
     * traceThrowable methods are designed to format and write exception stacktraces.  
     * 
     * @param severity Severity of the trace message that is issued
     * @param location Location where the message will be dispatched to and from where (if severity check is passed) it will be issued.
     * @param messageID messageID to be assigned to this message. MessageID format is [prefix]-[range][number] (e.g. ASJ-jndi-000135)
     * @param message The message text itself. It should be different from exc.getMessage()
     * @param exc The exception stacktrace is formatted and appended at the end of the trace record as a message parameter
     * @return LogRecord object encapsulating the message that has been written. null if no message has been written.
     */    
    public static LogRecord traceThrowable (int severity, Location location, String messageID, String message, Throwable exc)
    {
    LogRecord writtenRec = null;
        if (isWritable(severity, location)) {
            writtenRec = 
                location.logInt(severity, 
                                location, 
                                null, //relatives 
                                null, //subloc
                                (messageID == null) ? "" : location.vendor + messageID, //msgCode
                                (location == null) ? null : location.csnComponent, //csnComponent
                                (location == null) ? null : location.dcName, //dcName                                
                                message, 
                                MsgType.PLAIN,
                                (Object[]) null,
                                exc); //messageException            
        }
        return writtenRec;
    }

    /**
     * Issues a trace message through a Location. Makes use of Message ID concept.
     * traceThrowable methods are designed to format and write exception stacktraces.  
     * 
     * @param severity Severity of the trace message that is issued
     * @param location Location where the message will be dispatched to and from where (if severity check is passed) it will be issued.
     * @param exc The exception stacktrace is formatted and appended at the end of the trace record as a message parameter 
     * @param messageID messageID to be assigned to this message. MessageID format is [prefix]-[range][number] (e.g. ASJ-jndi-000135)
     * @param message The message text itself. It should be different from exc.getMessage()
     * @param args values to be placed in the text message. Each of the message placeholders {0}, {1} will be replaced with args[0], args[1], etc. 
     * @return LogRecord object encapsulating the message that has been written. null if no message has been written.
     */        
    public static LogRecord traceThrowable (int severity, Location location, Throwable exc, String messageID, String message, Object... args)
    {
    LogRecord writtenRec = null;
        if (isWritable(severity, location)) {
            if (args != null) {
                StringBuilder messageBuilder = new StringBuilder(message);
                int ind = 0;
                for (Object o : args) {
                    int ii = messageBuilder.indexOf("{" + ind + "}");
                    if (ii >= 0) {
                      messageBuilder.replace(ii, ii + 3, (o==null)?"null":o.toString());
                    }
                    ind++;
                }
                message = messageBuilder.toString();                        
            }
            writtenRec = 
                location.logInt(severity, 
                                location, 
                                null, //relatives 
                                null, //subloc
                                (messageID == null) ? "" : location.vendor + messageID, //msgCode
                                (location == null) ? null : location.csnComponent, //csnComponent
                                (location == null) ? null : location.dcName, //dcName                                
                                message, 
                                MsgType.PLAIN,
                                (Object[]) null,
                                exc); //messageException                 
        }
        return writtenRec;
    }   

    /**
     * Issues a log message through a Category. It is also dispatched to traces through the Location provided.
     * Makes use of Message ID concept which should be adopted by each log message.
     * 
     * @param severity severity of the trace message that is issued
     * @param Category Category where the message will be dispatched to and from where (if severity check is passed) it will be issued.
     * @param location If a message has been produced by Category,
     *                 it will also be dispatched to the Location so that it will go to traces as well.
     * @param messageID messageID to be assigned to this message. MessageID format is [prefix]-[range][number] (e.g. ASJ-jndi-000135) 
     * @param message the message text itself
     * @param args values to be placed at the end of the log entry as parameters.
     *             Each of the message placeholders {0}, {1} will correspond to args[0], args[1], etc.
     *             These placeholders will not be replaced in the plain text entry but will be replaced if logs are viewed with Log Viewer.
     * @return LogRecord object encapsulating the message that has been written. null if no message has been written.
     */
    public static LogRecord log (int severity, Category category, Location location,
                                 String messageID, String message, Object... args) {
        
        int typeOfMessage = (args == null) ? MsgType.PLAIN : MsgType.JAVA;

        LogRecord writtenRec = null;
        
        if (isWritable(severity, category)) {
            writtenRec = 
              category.logSeverityInt (severity, 
                                                       location, 
                                                       new LogController[] {location},  
                                                       null, 
                                                       (messageID == null) ? "" : location.vendor + messageID,
                                                       (location == null) ? null : location.csnComponent,
                                                       (location == null) ? null : location.dcName,
                                                       message, 
                                                       typeOfMessage, 
                                                       args);
        } 
        else if (location != null && location.beLogged(severity)) {
            if (args != null) {
                StringBuilder messageBuilder = new StringBuilder(message);
                int ind = 0;
                for (Object o : args) {
                    int ii = messageBuilder.indexOf("{" + ind + "}");
                    if (ii >= 0) {
                      messageBuilder.replace(ii, ii + 3, (o==null)?"null":o.toString());
                    }
                    ind++;
                }
                message = messageBuilder.toString();
            }            
            
            location.logInt(severity, 
                            location, 
                            new LogController[] {category}, //relatives 
                            null, //subloc
                            (messageID == null) ? "" : location.vendor + messageID, //msgCode
                            (location == null) ? null : location.csnComponent, //csnComponent
                            (location == null) ? null : location.dcName, //dcName                                
                            message, 
                            MsgType.PLAIN,
                            args,
                            null); //messageException            
        }
        return writtenRec;
    }

    /**
     * Issues a log message through a Category. It is also dispatched to traces through the Location provided.
     * Makes use of Message ID concept which should be adopted by each log message.
     * 
     * @param severity Severity of the trace message that is issued
     * @param Category Category where the message will be dispatched to and from where (if severity check is passed) it will be issued.
     * @param location If a message has been produced by Category,
     *                 it will also be dispatched to the Location so that it will go to traces as well.
     * @param dcName DC name to be written in the log entry. If dcName and csnComponent are null they are evaluated during runtime.
     * @param csnComponent CSN Component to be written in the log entry. If dcName and csnComponent are null they are evaluated during runtime.                 
     * @param messageID Message ID to be assigned to this message. MessageID format is [prefix]-[range][number] (e.g. ASJ-jndi-000135) 
     * @param message The message text itself
     * @param args Values to be placed at the end of the log entry as parameters.
     *             Each of the message placeholders {0}, {1} will correspond to args[0], args[1], etc.
     *             These placeholders will not be replaced in the plain text entry but will be replaced if logs are viewed with Log Viewer.
     * @return LogRecord object encapsulating the message that has been written. null if no message has been written.
     */
    public static LogRecord log (int severity, Category category, Location location,
                                 String dcName, String csnComponent, String messageID,
                                 String message, Object... args) {
        LogRecord writtenRec = null;
        
        int typeOfMessage = (args == null) ? MsgType.PLAIN : MsgType.JAVA;
        
        if (dcName != null && csnComponent == null) {
            if (LoggingManager.deployInfoProvider != null) {
                csnComponent = LoggingManager.deployInfoProvider.getCsnComponentByDcName(dcName);
            }  
        }
        
        if (isWritable(severity, category)) {
            writtenRec = 
              category.logSeverityInt (severity, 
                                                       location, 
                                                       new LogController[] {location},  
                                                       null, 
                                                       (messageID == null) ? "" : location.vendor + messageID,
                                                       (csnComponent == null) ? ((location == null) ? null : location.csnComponent) : csnComponent,
                                                       (dcName == null) ? ((location == null) ? null : location.dcName) : dcName,
                                                       message, 
                                                       typeOfMessage, 
                                                       args);              
        } else if (location != null && location.beLogged(severity)) {
            if (args != null) {
                StringBuilder messageBuilder = new StringBuilder(message);
                int ind = 0;
                for (Object o : args) {
                    int ii = messageBuilder.indexOf("{" + ind + "}");
                    if (ii >= 0) {
                      messageBuilder.replace(ii, ii + 3, (o==null)?"null":o.toString());
                    }
                    ind++;
                }
                message = messageBuilder.toString();
            }               
            location.logInt(severity,
                            location,
                            new LogController[] {category},
                            null,
                            (messageID == null) ? "" : location.vendor + messageID,
                            (csnComponent == null) ? ((location == null) ? null : location.csnComponent) : csnComponent,
                            (dcName == null) ? ((location == null) ? null : location.dcName) : dcName,
                            message,
                            MsgType.PLAIN,
                            args,
                            null);
        }
        return writtenRec;
    }

    /**
     * Issues a log message through a Category. It is also dispatched to traces through the Location provided.
     * Makes use of Message ID concept which should be adopted by each log message.
     * 
     * @param severity severity of the trace message that is issued
     * @param Category Category where the message will be dispatched to and from where (if severity check is passed) it will be issued.
     * @param location If a message has been produced by Category,
     *                 it will also be dispatched to the Location so that it will go to traces as well.
     * @param messageID messageID to be assigned to this message. MessageID format is [prefix]-[range][number] (e.g. ASJ-jndi-000135) 
     * @param message the message text itself
     * @return LogRecord object encapsulating the message that has been written. null if no message has been written.
     */
    public static LogRecord log (int severity, Category category, Location location,
                                 String messageID, String message) {

    LogRecord writtenRec = null;

    if (isWritable(severity, category)) {
      writtenRec = 
        category.logSeverityInt (severity, 
                                     location, 
                                     new LogController[] {location},    
                                     null, 
                                     (messageID == null) ? "" : location.vendor + messageID,
                                     (location == null) ? null : location.csnComponent,
                                     (location == null) ? null : location.dcName,                                             
                                     message, 
                                     MsgType.PLAIN, 
                                     (Object[]) null);
    } else if (location != null && location.beLogged(severity)) {
      location.logInt(severity, 
                      location, 
                      new LogController[] {category}, //relatives 
                      null, //subloc
                      (messageID == null) ? "" : location.vendor + messageID, //msgCode
                      (location == null) ? null : location.csnComponent, //csnComponent
                      (location == null) ? null : location.dcName, //dcName                                
                      message, 
                      MsgType.PLAIN,
                      (Object[]) null,
                      null); //messageException      
      
    }
    return writtenRec;
  }
    
}

