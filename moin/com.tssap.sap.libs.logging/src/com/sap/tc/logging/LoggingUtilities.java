package com.sap.tc.logging;

import com.sap.tc.logging.Category;
import com.sap.tc.logging.Location;
import com.sap.tc.logging.LogController;
import com.sap.tc.logging.LogRecord;
import com.sap.tc.logging.MsgType;
import com.sap.tc.logging.SimpleLogger;

/*
 * Title:        Logging
 * Description:  Logging API
 * Copyright:    Copyright (c) 2008
 * Company:      SAP AG
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAP AG. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAP AG.
 */

public class LoggingUtilities {

    public static String createExceptionMessage(String msgID, String message, Object... args) {
        if (args != null) {
            StringBuilder messageBuilder = new StringBuilder(message);
            int ind = 0;
            for (Object o : args) {
                int ii = messageBuilder.indexOf("{" + ind + "}");
                if (ii > -1) {
                    messageBuilder.replace(ii, ii + 3, (o==null)?"null":o.toString());                    
                }
                ind++;
            }
            message = messageBuilder.toString();
        }
        
        return msgID + " " + message;
    }
    
    public static LogRecord logAndTrace(int severity, Category category, Location location, Throwable t, String msgId, String dcName, String csnComponent, String msg, Object... messageArgs) {
        
        LogRecord writtenRec = null;
        
        int typeOfLogMessage = (messageArgs == null) ? MsgType.PLAIN : MsgType.JAVA;
        
        if (dcName != null && csnComponent == null) {
            if (LoggingManager.deployInfoProvider != null) {
                csnComponent = LoggingManager.deployInfoProvider.getCsnComponentByDcName(dcName);                  
            }  
        }
        
        if (SimpleLogger.isWritable(severity, category)) {
            writtenRec = 
              category.logSeverityInt (severity, 
                                       location, 
                                       null,  
                                       null, 
                                       (msgId == null) ? "" : location.vendor + msgId,
                                       csnComponent,
                                       dcName,
                                       msg + 
                                         ((t==null) ? "" : System.getProperty("line.separator") + 
                                                           "Error details: " + (t.getMessage()!=null?t.getMessage():"N/A")), 
                                       typeOfLogMessage, 
                                       messageArgs);
        }
        
        if (location != null && location.beLogged(severity)) {
            if (messageArgs != null) {
                StringBuilder messageBuilder = new StringBuilder(msg);
                int ind = 0;
                for (Object o : messageArgs) {
                    int ii = messageBuilder.indexOf("{" + ind + "}");
                    messageBuilder.replace(ii, ii + 3, (o==null)?"null":o.toString());
                    ind++;
                }
                msg = messageBuilder.toString();
            }               
            location.logInt(severity,
                            location,
                            new LogController[] {category},
                            null,
                            (msgId == null) ? "" : location.vendor + msgId,
                            csnComponent,
                            dcName,
                            msg + ((t!=null) ? System.getProperty("line.separator") + ExceptionManager.getStackTrace(t) : "")
                                + (writtenRec!=null ? (System.getProperty("line.separator")+"[Log ID = "+writtenRec.getId()+"]") : ""),
                            MsgType.PLAIN,
                            messageArgs,
                            null);
        }
        return writtenRec;        
    }
    
    public static String getCsnComponentByClassLoaderName(String classLoaderName) {
        if (com.sap.tc.logging.LoggingManager.classLoadInfoProvider != null) {
            return LoggingManager.classLoadInfoProvider.getCsnComponent(classLoaderName);
        }
        return null;
    }

    public static String getCsnComponentByClassLoader(ClassLoader classLoader) {
        if (com.sap.tc.logging.LoggingManager.classLoadInfoProvider != null) {
            return LoggingManager.classLoadInfoProvider.getCsnComponent(classLoader);
        }
        return null;        
    }    
    
    public static String getCsnComponentByDCName(String dcName) {
        if (com.sap.tc.logging.LoggingManager.deployInfoProvider != null) {
            return LoggingManager.deployInfoProvider.getCsnComponentByDcName(dcName);
        }
        return null;
    }
    
    public static String getDcNameByClassLoader(ClassLoader classLoader) {
        if (com.sap.tc.logging.LoggingManager.classLoadInfoProvider != null) {
            return LoggingManager.classLoadInfoProvider.getDcName(classLoader);
        }
        return null;        
    }
    
    public static String getDcNameByClassLoaderName(String classLoaderName) {
        if (com.sap.tc.logging.LoggingManager.classLoadInfoProvider != null) {
            return LoggingManager.classLoadInfoProvider.getDcName(classLoaderName);
        }
        return null;        
    }    

}
