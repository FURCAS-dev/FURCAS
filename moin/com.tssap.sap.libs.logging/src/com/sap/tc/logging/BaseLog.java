package com.sap.tc.logging;

/**
 * Copyright: Copyright (c) 2004
 * 
 * Company: SAP AG Walldorf, Germany All rights reserved.
 * 
 * This software is the confidential and proprietary information of SAP AG.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the license
 * agreement you entered into with SAP AG.
 * 
 * @version $Id:$
 * @author Robert Boban
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import com.sap.tc.logging.exceptions.CloseException;
import com.sap.tc.logging.exceptions.OpenException;
import com.sap.tc.logging.interfaces.IBaseLog;
import com.sap.tc.logging.interfaces.IFilter;

public abstract class BaseLog extends ExceptionHandling implements IBaseLog {

  // ================================================ declaration > ====
  private static String strLoc = "BaseLog";

  public static final int STATUS_INVALID = 0;
  public static final int STATUS_CLOSED = 1;
  public static final int STATUS_OPENED = 2;

  private String logName;
  private String logDescription;
  private int logStatus = STATUS_CLOSED;
  private String logPattern;
  private String logSource;
  private String logHeader;
  private String logFooter;
  private String logVerInUse;
  private String logEncoding;
  private int logMode;
  private Formatter logFormatter;

  private IFilter logFilter;
  private HashSet logFilters;

  // ==== < declaration ============================ constructors > ====
  // ==== < constructors =============================== abstarct > ====

  protected abstract void openInt() throws OpenException;

  protected abstract void closeInt() throws CloseException;

  // ==== < abstract ===================================== public > ====

  /**
   * @see com.sap.tc.logging.interfaces.IBaseLog#open()
   */
  public synchronized void open() throws OpenException {
    openInt();
  }

  /**
   * @see com.sap.tc.logging.interfaces.IBaseLog#close()
   */
  public synchronized void close() throws CloseException {
    closeInt();
  }

  /**
   * @see com.sap.tc.logging.interfaces.IBaseLog#status()
   */
  public synchronized int status() {
    return logStatus;
  }

  /**
   * @see com.sap.tc.logging.interfaces.IBaseLog#isClosed()
   */
  public synchronized boolean isClosed() {
    return logStatus == STATUS_CLOSED;
  }

  /**
   * @see com.sap.tc.logging.interfaces.IBaseLog#isOpened()
   */
  public synchronized boolean isOpened() {
    return logStatus == STATUS_OPENED;
  }

  /**
   * @see com.sap.tc.logging.interfaces.IBaseLog#setPattern(java.lang.String)
   */
  public void setPattern(String value) {
    this.logPattern = value;
  }

  /**
   * @see com.sap.tc.logging.interfaces.IBaseLog#getPattern()
   */
  public String getPattern() {
    if (logPattern != null) {
      return logPattern;
    }
    return HelperLib.EMPTY_STRING;
  }

  /**
   * @see com.sap.tc.logging.interfaces.IBaseLog#setSource(java.lang.String)
   */
  public void setSource(String value) {
    this.logSource = value;
  }

  /**
   * @see com.sap.tc.logging.interfaces.IBaseLog#getSource()
   */
  public String getSource() {
    if (logSource != null) {
      return logSource;
    }
    return HelperLib.EMPTY_STRING;
  }

  /**
   * @see com.sap.tc.logging.interfaces.IBaseLog#setEncoding(java.lang.String)
   */
  public synchronized void setEncoding(String encoding) {
    this.logEncoding = encoding;
  }

  /**
   * @see com.sap.tc.logging.interfaces.IBaseLog#getEncoding()
   */
  public synchronized String getEncoding() {
    return logEncoding;
  }

  /**
   * @see com.sap.tc.logging.interfaces.IBaseLog#setFormatter(com.sap.tc.logging.Formatter)
   */
  public synchronized void setFormatter(Formatter formatter) {

    if (status() == STATUS_OPENED) {
      throw new UnsupportedOperationException(
          MSGCollection.LOGGING_EXC_FORMAT_CHANGE);
    }

    if (formatter == null) {
      this.logFormatter = LoggingManager.DEFAULT_FORMATTER;
      APILogger.logIntByAPI(Severity.INFO, APILogger.APILocation, strLoc
          + "[setFormatter(Formatter formatter)]",
          MSGCollection.LOGGING_MSG_ID_OBJECT_IS_NULL_DEF,
          MSGCollection.LOGGING_MSG_STR_OBJECT_IS_NULL_DEF, new String[] {
              "Formatter", "BaseLog", this.getName(), "Formatter",
              LoggingManager.DEFAULT_FORMATTER.getClass().getName()});
    } else {
      this.logFormatter = formatter;
    }
  }

  /**
   * @see com.sap.tc.logging.interfaces.IBaseLog#getFormatter()
   */
  public synchronized Formatter getFormatter() {
    if (logFormatter == null) {
      logFormatter = LoggingManager.DEFAULT_FORMATTER;
    }
    return logFormatter;
  }

  /**
   * @see com.sap.tc.logging.interfaces.IBaseLog#getFooter()
   */
  public synchronized String getFooter() {
    if (logFooter != null) {
      return logFooter;
    }
    return HelperLib.EMPTY_STRING;
  }

  /**
   * @see com.sap.tc.logging.interfaces.IBaseLog#getHeader()
   */
  public synchronized String getHeader() {
    if (logHeader != null) {
      return logHeader;
    }
    return HelperLib.EMPTY_STRING;
  }

  /**
   * @see com.sap.tc.logging.interfaces.IBaseLog#getMode()
   */
  public synchronized int getMode() {
    return logMode;
  }

  /**
   * @see com.sap.tc.logging.interfaces.IBaseLog#setMode()
   */
  public synchronized void setMode(int mode) {
    this.logMode = mode;
  }

  // ******************************************************************
  // F I L T E R S
  // *****************************************************************

  /**
   * @see com.sap.tc.logging.interfaces.IBaseLog#addFilter(com.sap.tc.logging.interfaces.IFilter)
   */
  public void addFilter(IFilter filter) {
    if (filter != null) {
      if (logFilter != null && !logFilter.equals(filter)) {
        if (logFilters == null) {
          logFilters = new HashSet();
          logFilters.add(logFilter);
          logFilter = null;
        }
        synchronized (logFilters) {
          logFilters.add(filter);
        }
      } else {
        // In most cases, in usage is only one filter
        // so here we have some optimatisation to save
        // Collection browsing for just one item.
        logFilter = filter;
      }
    } else {
      APILogger.logIntByAPI(Severity.WARNING, APILogger.APILocation, strLoc
          + "[addFilter(Filter filter)]",
          MSGCollection.LOGGING_MSG_ID_OBJECT_IS_NULL,
          MSGCollection.LOGGING_MSG_STR_OBJECT_IS_NULL, new String[] {"Filter",
              "Log", this.getName()});
    }
  }

  /**
   * @see com.sap.tc.logging.interfaces.IBaseLog#getFilter()
   */
  public IFilter getFilter(int index) {
    if (logFilters != null && index < logFilters.size()) {
      return (IFilter) ((List) getFilters()).get(index);
    }
    return logFilter;
  }

  /**
   * @see com.sap.tc.logging.interfaces.IBaseLog#getFilters()
   */
  public Collection getFilters() {
    if (logFilters != null) {
      synchronized (logFilters) {
        return Collections.unmodifiableCollection(new ArrayList(logFilters));
      }
    }
    return Collections.EMPTY_LIST;
  }

  /**
   * @see com.sap.tc.logging.interfaces.IBaseLog#removeFilter(com.sap.tc.logging.interfaces.IFilter)
   */
  public void removeFilter(IFilter filter) {
    if (logFilters != null) {
      if (logFilters.contains(filter)) {
        synchronized (logFilters) {
          logFilters.remove(filter);
        }
      }
    }
    logFilter = null;
  }

  /**
   * @see com.sap.tc.logging.interfaces.IBaseLog#removeFilters()
   */
  public void removeFilters() {
    if (logFilters != null) {
      synchronized (logFilters) {
        logFilters.clear();
        logFilter = null;
      }
    }
  }

  // *******************************************************************
  // Implementation of the IObjectInfo interface
  // (IBaseLog extends IObjectInfo)
  // *******************************************************************

  /**
   * @see com.sap.tc.logging.interfaces.IObjectInfo#setName(java.lang.String)
   */
  public synchronized void setName(String value) {
    this.logName = value;
  }

  /**
   * @see com.sap.tc.logging.interfaces.IObjectInfo#getName()
   */
  public synchronized String getName() {
    if (logName != null) {
      return logName;
    }
    return HelperLib.EMPTY_STRING;
  }

  /**
   * @see com.sap.tc.logging.interfaces.IObjectInfo#setDescription(java.lang.String)
   */
  public synchronized void setDescription(String value) {
    this.logDescription = value;
  }

  /**
   * @see com.sap.tc.logging.interfaces.IObjectInfo#getDescription()
   */
  public synchronized String getDescription() {
    if (logDescription != null) {
      return logDescription;
    }
    return HelperLib.EMPTY_STRING;
  }

  /**
   * @see com.sap.tc.logging.interfaces.IObjectInfo#getVerInUse()
   */
  public synchronized String getVerInUse() {
    if (logVerInUse != null) {
      return logVerInUse;
    }
    return Version.getFullVersion();
  }

  // ==== < public ==================================== protected > ====

  protected synchronized void setStatus(int status) {
    if (status < STATUS_CLOSED || status > STATUS_OPENED) {
      this.logStatus = STATUS_INVALID;
    } else {
      this.logStatus = status;
    }
  }

  protected synchronized void setHeader(String value) {
    this.logHeader = value;
  }

  protected synchronized void setFooter(String value) {
    this.logFooter = value;
  }

  protected synchronized void setVerInUse(String value) {
    this.logVerInUse = value;
  }

  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  // ==== < protected =================================== default > ====
  // ==== < default ===================================== private > ====
  // ==== < private ================================== deprecated > ====

}
