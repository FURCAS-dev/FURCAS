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

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;

import com.sap.tc.logging.interfaces.IObjectInfo;
import com.sap.tc.logging.interfaces.ISATChecker;

/**
 * <p>
 *   Controls output to logs, which stand for destinations to write log messages
 *   to.
 *   Log controllers are the objects you call to write messages. To this end,
 *   log controllers provide you with methods for associating logs with them and
 *   for controlling the actual writing of messages. In practive, however, you
 *   deal with concrete subclasses of this abstract class, such as
 *   {@link Location} for trace messages or {@link Category} for log messages.
 *   As the signatures of the methods to emit messages depend on these concrete
 *   classes, we have furnished them rather than log controllers with these
 *   methods, so there are no abstract output methods.
 * </p>
 * <p>
 *   When you call an output method, the actual writing of the message to a log
 *   depends on the <em>severities</em> of the message at hand, the log
 *   controller and the logs attached to it, as well as optional
 *   <em>filters</em> associated with the latter two. Typical severities are
 *   <em>error</em> and <em>warning</em>, and you can find constants for all
 *   the possible severities in the class <code>Severity</code>. Messages which
 *   have at least the <em>effective</em> severity of the controller are
 *   candidates for output and are forwarded to the <em>logs</em> attached to
 *   the controller with the method {@link #addLog(Log)}. Beforehand, however,
 *   filters get the chance to veto the decision on basis of the internal
 *   message representation, the <code>LogRecord</code>.
 * </p>
 * <p>
 *   Log controllers are automatically ordered into hierarchies. Hierarchies of
 *   controllers are built up according to the hierarchical naming schemes of
 *   the concrete subclasses of <code>LogController</code>. A child log
 *   controller inherits some properties from its parent, for example its
 *   severity and its logs. The effective severity of a child log controller is
 *   calculated from its <em>minimum</em> and <em>maximum</em> severities, as
 *   well as the effective severity of its parent. Most of the time you will
 *   have no need for these two severities. Instead you will either use the
 *   setting inherited from the parent controller or override the parent setting
 *   with an explicit effective value for the child. To do the latter, call the
 *   method {@link #setEffectiveSeverity(int)} with the effective value you
 *   would like to have logged.
 * </p>
 * <p>
 *   Time and again, however, you will want to use a more elaborate scheme to
 *   control severities, and have different minimum and maximum severities set
 *   with calls to {@link #setMinimumSeverity(int)} and
 *   {@link #setMaximumSeverity(int)}, respectively. With the minimum severity
 *   you specify the severity that messages must have at the least to be output
 *   via the child log controller. That is, if the effective severity of the
 *   parent log controller is higher than the minimum severity of the child than
 *   the latter inherits the parent's effective severity, otherwise it is set to
 *   the minimum severity. On the other hand, you specify the severity that
 *   messages must have for output to be guaranteed, save intervention from
 *   filters, using the maximum severity. That is, if the effective severity of
 *   the parent log controller is lower than the maximum severity of the child
 *   than the latter inherits the parent's effective severity, otherwise it is
 *   set to the maximum severity. This implies that if both minimum and maximum
 *   severity are set to the same value the effective severity gets that value
 *   regardless of the effective severity of the parent. Such a setting is
 *   therefore called <em>dominant</em>. For root log controllers the setting
 *   must be dominant, as separate minimum and maximum values are meaningless
 *   without a parent to inherit from.
 * </p>
 * <p>
 *   Please find fundamental information about the principles of error handling
 *   in the package description. In the case of this class, if a value is out of
 *   range for one of the calls dealing with severities, the methods
 *   {@link #getException()} and {@link #throwException()} are served with a
 *   <code>java.lang.IllegalArgumentException</code>.
 * </p>
 * @see    Log
 * @see    LogRecord
 * @see    Severity
 * @see    Filter
 */
public abstract class LogController extends ExceptionHandling implements IObjectInfo {

  // $JL-LOG_CONFIG$ $JL-EXC$
  //================================================ declaration > ====
  private static String subLoc = "LogController";
  
  static final String MSG_GRP_NAME = null;
  static final String MSG_GRP_DESC = null;
  static final String MSG_SUB_LOC = null;
  static final Object[] MSG_ARGS = null;
  static final LogController[] MSG_RELATIVES = null;

  static final String NO_RELATIVE_EMSG = "No relative",
      NO_RELATIVES_EMSG = "No relatives";

  static final String MSG_ASSERT = "Assertion failed: {0}",
      MSG_THROWING = "Throwing {0}", MSG_CATCHING = "Caught {0}", NULL_STRING = "<null>";

  static {
    // ENABLING TRACE
    String flagAPI = null;
    try {
      flagAPI = System.getProperty("eventLog");
    } catch(Exception ex) {
      flagAPI = null;
    }

    if(flagAPI != null && flagAPI.length() > 0) {
      if(flagAPI.equalsIgnoreCase("all") || flagAPI.equalsIgnoreCase("log")) {
        Category.SYS_LOGGING.setEffectiveSeverity(Severity.ALL);
        Category.SYS_LOGGING.addLog(new FileLog("loggingAPI.log"));
        //Category.SYS_LOGGING.addLog(new ConsoleLog());
      }
      if(flagAPI.equalsIgnoreCase("all") || flagAPI.equalsIgnoreCase("trace")) {
        Location.getLocation("com.sap.tc.logging", "tc~logging~java", "BC-JAS-ADM-LOG-API").setEffectiveSeverity(Severity.ALL);
        Location.getLocation("com.sap.tc.logging", "tc~logging~java", "BC-JAS-ADM-LOG-API").addLog(new FileLog("loggingAPI.trc"));
        //Location.getLocation("com.sap.tc.logging").addLog(new ConsoleLog());
      }
    }
  }

  private String lcName;
  private String lcDescription;
  private String logVerInUse;

  private LogController parent;
  private LinkedList<LogController> children = new LinkedList<LogController>();

  private volatile boolean exceptionGuardian = false;
  private volatile String resourceBundleName = null;
  private volatile boolean resourceBundleSet = false;
  private volatile ClassLoader classLoader = null;
  private volatile boolean classLoaderSet = false;
  private volatile boolean isConfigChanged = false;

  private volatile Collection<Filter> filters = null;

  // Optimize propagation of messages to logs attached to parents of this
  // controller: newly attached logs are propagated to children and put into
  // the below hash map. If at the same time parents do not have local logs,
  // forwardMessage does not have to be called anymore.
  //  private volatile boolean      parentLocalLogs     = false;

  private volatile Collection<Log> logsRegistry = null;
  private volatile Collection<Log> logsNormal = null;
  private volatile Collection<Log> logsPrivate = null;
  private volatile Map<Log, LogController> logsLocal = null;

  private volatile int minSeverity = Severity.ALL, maxSeverity = Severity.NONE;

  // Previous severity values.
  // If values are unchanged, the propagation to children controllers is
  // skipped. Above all, this is important to avoid cost when reading mostly
  // unchanged configuration data.
  private volatile int prevMinSeverity = Severity.ALL, prevMaxSeverity = Severity.NONE;

  // Cache for effective severity.
  // The effective severity is computed from the minimum and maximum
  // severities of this controller and the effective one of its parent.
  // As modification of severities is rare compared to writing messages,
  // caching is advisable.
  volatile int effSeverity = Severity.NONE;

  // Collection of data such as severities in relation to other log controllers.
  private Relations relations = new Relations();

  // Collection of those log controllers that maintain a relation to this
  // controller, needed to update the relation caches of those controllers when
  // a child of this controller is made. The collection is kept in topological
  // order, that is if a controller is in the collection all its parents also in
  // the collection are inserted in front of it, to ease the task of updating
  // the relation caches where relations of a controller depend on the same
  // relations of its parent.
  // Regarders is also used to delete relative severities when releasing a
  // temporary controller.
  private Regarders regarders = new Regarders();

  // Caches for relation severities.
  // Relation severities are settings that are restricted to messages related
  // to both this and another log controller. The problem here is that there
  // might be a great number of relations between this controller and another
  // one, with a great number of severities. It would be expensive to search
  // for the right relation each time the logging component has to determine
  // whether a message is to be written, especially when most of the time
  // relation severities are set to Severity.NONE, anyway.
  // Therefore, logging caches the minimum effective relation severity found for
  // this controller with any other controller. If the severity is lower than
  // the minimum relation severity, logging can skip writing the message without
  // further. However, there is no maximum effective relation severity cache.
  // The reason is that most log controllers do not have explicit severities in
  // relation to all other controllers, so the maximum cache would be set to
  // Severity.NONE anyway. On the other hand, the maximum is complicated to
  // calculate because relations with standard severity are not kept in the
  // relations datastructure explicitly, and so controllers would have to be
  // iterated via traversing the children tree of the relative controller.
  private volatile int minEffRelationSeverity = Severity.NONE;

  // Flag for msg counter, which indicates how many calls since the last reset
  // would have written messages to any logs of this controller.
  private int loggedSumCnt = 0;

  // Flag for unit tests, which indicates how many calls since the last reset
  // would have written messages to normal logs of this controller.
  private int loggedCnt = 0;

  //Flag which shows is activity (request) tracking enabled
  private static boolean isActivityTrackingEnabled;
  private static ISATChecker isActivityTracking;

  private boolean inheritFromParent = true;
  private boolean copyToSubtree = true;
  
  private static int NUMBER_OF_SEVERITIES = 6;
  private static long[] SEVERITIES_USED = new long[NUMBER_OF_SEVERITIES];
  
  private final static Location mLoc = Location.getLocation(LogController.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");

  //==== < declaration ============================ constructors > ====

  LogController(String name) {
    this.lcName = name;
    this.parent = null;
  }


  LogController(String name, LogController parent) {
    this.lcName = name;
    this.parent = parent;
    parent.addChild(this);
    initializeSeverities();
    initializeLogs();
  }


  //==== < constructors =============================== abstarct > ====
  //==== < abstract ===================================== public > ====

  /**
   * Check whether configuration on this LogController was changed!
   */
  public synchronized boolean isConfigurationChanged() {
    return isConfigChanged;
  }


  /**
   * Drops all internal references to this log controller and its children.
   * Thus, these log controllers become eligible for garbage collection when all
   * external references have been eliminated. You should call this method on
   * temporary controllers as soon as you are finished using them. Note,
   * however, that after calling this method, requesting a log controller with
   * the same name yields a different instance. In effect, all configuration
   * data stored in this controller, for example severities, are lost. Also note
   * that the same holds true for relative severities regarding this controller.
   */
  public void release() {
    synchronized(getClass()) {

      // Release children.
      Object[] lcs = getChildrenInt().toArray();
      for(int i = 0; i < lcs.length; i++) {
        ((LogController) lcs[i]).release();
      }

      // Forget relative severities regarding this controller.
      Regarders regarders = getRegarders();

      synchronized(regarders) {
        while(!regarders.isEmpty()) {
          LogController lc = regarders.getFirst();
          lc.setEffectiveSeverity(this);
          regarders.remove(lc);
        }
      }

      // Remove logs.
      removeLogs();

      // Release me (this) from parent
      if(parent != null) {
        parent.getChildrenInt().remove(this);
      }

      // Reset config check flag
      isConfigChanged = false;
    }

    // Drop reference in Logging Manager.
    LoggingManager.getLoggingManager().release(this);

    APILogger.instrumentIntByAPI(subLoc + "[release()]", MSGCollection
      .CONFIGURATION_RESET(), new Object[] {this.getName()});

  }


  //********************************************************
  //                    R E S E T
  //********************************************************
  /**
   * Reset this LogController to the initail state.
   */
  public synchronized void reset() {
    resetInt();
    resetLogs();
    LoggingManager.getLoggingManager().notifyLogControllerReset(this, false);

    APILogger.instrumentIntByAPI(
      subLoc + "[reset()]", 
      MSGCollection.CONFIGURATION_RESET(), 
      new Object[] {this.getName()});
  }


  /**
   * Reset this LogController and his children to the initail state
   */
  public void resetAll() {
    synchronized (getClass()) {
      resetAllInt();
    }
    LoggingManager.getLoggingManager().notifyLogControllerReset(this, true);

    APILogger.instrumentIntByAPI(
      subLoc + "[resetAll()]", 
      MSGCollection.CONFIGURATION_RESET(), 
      new Object[] {this.getName()});

  }


  //*******************************************************
  // Implementation of the IObjectInfo interface
  //*******************************************************

  /**
   * Gets the name for this log. Can be null.
   */
  public synchronized String getName() {
    return lcName;
  }


  /**
   * Sets a name for this log. An optional courtesy feature for user
   * to easily refer to a log. Highly recommended if logviewer tool
   * will be used to browse the output messages.
   * If no name is specified, nothing will be set and the value is null.
   */
  public synchronized void setName(String name) {
    this.lcName = name;
  }


  /**
   * Gets the description for this log. Can be null.
   */
  public synchronized String getDescription() {
    return lcDescription;
  }


  /**
   * Sets a description for this log. An optional courtesy feature for user
   * to easily refer to a log. Highly recommended if logviewer tool
   * will be used to browse the output messages.
   * If no name is specified, nothing will be set and the value is null.
   */
  public synchronized void setDescription(String value) {
    this.lcDescription = value;
  }


  /**
   * Gets the version of API.
   */
  public synchronized String getVerInUse() {
    return logVerInUse;
  }


  //*******************************************************

  /**
   * Gets the collection of children of this log controller.
   * @return Unmodifiable collection of children
   */
  public Collection<LogController> getChildren() {
    Collection<LogController> children = getChildrenInt();

    synchronized(children) {
      return Collections.unmodifiableCollection(new ArrayList<LogController>(children));
    }
  }


  //*******************************************
  // CLOSE GROUP
  //*******************************************

  /**
   * @deprecated Groups are not used and implementation was removed for memory usage improvement,
   *             Instead use correlation id.
   */
  public void closeGroup() {
  }


  /**
   * @deprecated Groups are not used and implementation was removed for memory usage improvement,
   *             Instead use correlation id.
   */
  public int getGroupSize() {
      return 0;
  }


  /**
   * @deprecated Groups are not used and implementation was removed for memory usage improvement,
   *             Instead use correlation id.
   */
  public void setGroupSize(int size) {
  }


  //*******************************************
  // GROUP T METHODS
  //*******************************************

  /**
   * @deprecated Groups are not used and implementation was removed for memory usage improvement,
   *             Instead use correlation id.
   */
  public LogRecord groupT(String msg) {
    return null;
  }


  /**
   * @deprecated Groups are not used and implementation was removed for memory usage improvement,
   *             Instead use correlation id.
   */
  public LogRecord groupT(String subloc, String msg) {
    return null;
  }


  /**
   * @deprecated Groups are not used and implementation was removed for memory usage improvement,
   *             Instead use correlation id.
   */
  public LogRecord groupT(String msg, Object[] args) {
    return null;
  }


  /**
   * @deprecated Groups are not used and implementation was removed for memory usage improvement,
   *             Instead use correlation id.
   */
  public LogRecord groupT(String subloc, String msg, Object[] args) {
    return null;
  }


  //*******************************************
  // GROUP METHODS 
  //*******************************************

  /**
   * @deprecated Groups are not used and implementation was removed for memory usage improvement,
   *             Instead use correlation id.
   */
  public LogRecord group(Object msgCode) {
    return null;
  }


  /**
   * @deprecated Groups are not used and implementation was removed for memory usage improvement,
   *             Instead use correlation id.
   */
  public LogRecord group(String subloc, Object msgCode) {
    return null;
  }


  /**
   * @deprecated Groups are not used and implementation was removed for memory usage improvement,
   *             Instead use correlation id.
   */
  public LogRecord group(Object msgCode, Object[] args) {
    return null;
  }


  /**
   * @deprecated Groups are not used and implementation was removed for memory usage improvement,
   *             Instead use correlation id.
   */
  public LogRecord group(String subloc, Object msgCode, Object[] args) {
    return null;
  }


  /**
   * @deprecated Groups are not used and implementation was removed for memory usage improvement,
   *             Instead use correlation id.
   */
  public LogRecord group(Object msgCode, String msgClear) {
    return null;
  }


  /**
   * @deprecated Groups are not used and implementation was removed for memory usage improvement,
   *             Instead use correlation id.
   */
  public LogRecord group(String subloc, Object msgCode, String msgClear) {
    return null;
  }


  /**
   * @deprecated Groups are not used and implementation was removed for memory usage improvement,
   *             Instead use correlation id.
   */
  public LogRecord group(Object msgCode, Object[] args, String msgClear) {
    return null;
  }


  /**
   * @deprecated Groups are not used and implementation was removed for memory usage improvement,
   *             Instead use correlation id.
   */
  public LogRecord group(String subloc, Object msgCode, Object[] args, String msgClear) {
    return null;
  }

  /**
   * Gets the current minimum severity of this log controller.
   * @return Minimum severity if set or
   *         {@link Severity#ALL}.
   * @deprecated
   */
  public int getMinimumSeverity() {
    return minSeverity;
  }


  /**
   * Gets the current minimum severity of this log controller with respect to
   * another log controller.
   * @param  relative Related log controller
   * @return Minimum severity if set or
   *         {@link Severity#ALL}.
   * @deprecated
   */
  public int getMinimumSeverity(LogController relative) {
    if(check(relative)) {
      int minRelationSeverity = relations.get(relative).minSeverity;

      return (minSeverity < minRelationSeverity) ? minSeverity : minRelationSeverity;
    } else {
      return minSeverity;
    }
  }


  /**
   * Same as {@link #getMinimumSeverity(LogController)} but returns the minimum
   * of the values of the specified log controllers. This is the value that is
   * effective for a message directed to all of them at the same time, for
   * example a message belonging to several categories.
   * @param  relatives Related log controllers
   * @return Minimum severity if set or
   *         {@link Severity#ALL}.
   * @deprecated
   */
  public int getMinimumSeverity(LogController[] relatives) {
    check(relatives);
    if(relatives != null) {
      for(int i = 0; i < relatives.length; ++i) {
        int minRelationSeverity = relations.get(relatives[i]).minSeverity;

        minSeverity = (minSeverity < minRelationSeverity) ? minSeverity
          : minRelationSeverity;
      }
      return minSeverity;
    } else {
      return minSeverity;
    }
  }


  /**
   * Gets the current effective severity of this log controller.
   * @return Effective severity if set or
   *         {@link Severity#NONE}.
   */
  public int getEffectiveSeverity() {
    return effSeverity;
  }


  /**
   * Gets the current effective severity of this log controller with respect to
   * another log controller.
   * @param  relative Related log controller
   * @return Effective severity if set or
   *         {@link Severity#NONE}.
   * @deprecated
   */
  public int getEffectiveSeverity(LogController relative) {
    if(check(relative)) {
      int effRelationSeverity = relations.get(relative).effSeverity;

      return (effSeverity < effRelationSeverity) ? effSeverity : effRelationSeverity;
    } else {
      return effSeverity;
    }
  }


  /**
   * Same as {@link #getEffectiveSeverity(LogController)} but returns the
   * minimum of the values of the specified log controllers. This is the value
   * that is effective for a message directed to all of them at the same time,
   * for example a message belonging to several categories.
   * @param  relatives Related log controllers
   * @return Effective severity if set or
   *         {@link Severity#NONE}.
   * @deprecated
   */
  public int getEffectiveSeverity(LogController[] relatives) {
    if(relatives != null) {
      check(relatives);
      for(int i = 0; i < relatives.length; ++i) {
        int effRelationSeverity = relations.get(relatives[i]).effSeverity;

        effSeverity = (effSeverity < effRelationSeverity) ? effSeverity
          : effRelationSeverity;
      }
    }
    return effSeverity;
  }


  /**
   * Gets the current maximum severity of this log controller.
   * @return Maximum severity if set or
   *         {@link Severity#NONE}.
   * @deprecated
   */
  public int getMaximumSeverity() {
    return maxSeverity;
  }


  /**
   * Gets the current maximum severity of this log controller with respect to
   * another log controller.
   * @param  relative Related log controller
   * @return Maximum severity if set or
   *         {@link Severity#NONE}.
   * @deprecated
   */
  public int getMaximumSeverity(LogController relative) {
    if(check(relative)) {
      int maxRelationSeverity = relations.get(relative).maxSeverity;

      return (maxSeverity < maxRelationSeverity) ? maxSeverity : maxRelationSeverity;
    } else {
      return maxSeverity;
    }
  }


  /**
   * Same as {@link #getMaximumSeverity(LogController)} but returns the minimum
   * of the values of the specified log controllers. This is the value that is
   * effective for a message directed to all of them at the same time, for
   * example a message belonging to several categories.
   * @param  relatives Related log controllers
   * @return Maximum severity if set or
   *         {@link Severity#NONE}.
   * @deprecated
   */
  public int getMaximumSeverity(LogController[] relatives) {
    check(relatives);
    if(relatives != null) {
      for(int i = 0; i < relatives.length; ++i) {
        int maxRelationSeverity = relations.get(relatives[i]).maxSeverity;

        maxSeverity = (maxSeverity < maxRelationSeverity) ? maxSeverity
          : maxRelationSeverity;
      }
      return maxSeverity;
    } else {
      return maxSeverity;
    }
  }


  /**
   * Sets the minimum severity of this log controller.
   * If its current maximum severity is lower than the argument, the former is
   * set to the argument. If it is a root controller, this method has the same
   * effect as a call to
   * {@link #setEffectiveSeverity(int)}.
   * @param  severity New minimum severity
   * @deprecated
   */
  public void setMinimumSeverity(int severity) {
    int oldValue = -1, newValue = -1;
    synchronized(getClass()) {
      oldValue = getMinimumSeverity();
      severity = Severity.correct(severity);
      boolean inherit = oldValue != severity;
      setInheritFromParent(inherit);
      LogController parent = getParentInt();
      if(parent != null && inherit) {
        minSeverity = severity;
        if(maxSeverity < minSeverity) {
          maxSeverity = minSeverity;
        }
        calculateEffectiveSeverity();
      } else {
        setEffectiveSeverity(severity);
      }
      newValue = getMinimumSeverity();
      isConfigChanged = true;
    }
    if(oldValue != newValue) {
        if (mLoc.bePath()) {
          Exception ex = new Exception("This exception stacktrace is to help seeing who is calling LogController.setMinimumSeverity() method that changes controller severity during runtime.");
          mLoc.traceThrowableT(Severity.PATH,
                               "Severity of log controller " + this.getName() + 
                                 " changed from " + Severity.toString(oldValue) + 
                                 " to " + Severity.toString(newValue),
                               ex);
        }
    }
  }


  /**
   * Resets the minimum severity of this log controller.
   * If it is a root controller this method has no effect, otherwise it has the
   * same effect as a call to {@link #setMinimumSeverity(int)} with
   * {@link Severity#ALL}.
   * @deprecated
   */
  public void setMinimumSeverity() {
    int oldValue = -1, newValue = -1;
    synchronized(getClass()) {
      oldValue = getMinimumSeverity();
      setInheritFromParent(true);
      LogController parent = getParentInt();
      if(parent != null) {
        minSeverity = Severity.ALL;
        calculateEffectiveSeverity();
      }
      newValue = getMinimumSeverity();
      isConfigChanged = true;
    }
    if(oldValue != newValue) {
        if (mLoc.bePath()) {
              Exception ex = new Exception("This exception stacktrace is to help seeing who is calling LogController.setMinimumSeverity() method that changes controller severity during runtime.");
              mLoc.traceThrowableT(Severity.PATH,
                                   "Severity of log controller " + this.getName() + 
                                     " changed from " + Severity.toString(oldValue) + 
                                     " to " + Severity.toString(newValue),
                                   ex);
          }
    }
  }
  
  public void setEffectiveSeverity(int severity) {
      setEffectiveSeverity(severity, true);      
  }


  /**
   * Sets the effective severity of this log controller.
   * If it is a root controller, this method sets the effective severity to
   * its argument, otherwise it has the same effect as calls with its argument
   * to both {@link #setMinimumSeverity(int)} and
   * {@link #setMaximumSeverity(int)}.
   * @param  severity New effective severity
   */
  public void setEffectiveSeverity(int severity, boolean copyToSubtree) {
    int oldValue = -1, newValue = -1;
    synchronized(getClass()) {
      oldValue = getEffectiveSeverity();
      severity = Severity.correct(severity);
      LogController parent = getParentInt();
      if(parent != null) {
        boolean inherit = severity == parent.getEffectiveSeverity();
        if (!inherit) {
            setInheritFromParent(false);
        }
        if(!this.inheritFromParent) {
          effSeverity = severity;
        } 
      } else {
        effSeverity = severity;
      }
      minSeverity = severity;
      maxSeverity = severity;
      setCopyToSubtree(copyToSubtree);      
      calculateEffectiveSeverity();
      newValue = getEffectiveSeverity();
      isConfigChanged = true;
    }
    if(oldValue != newValue) {
      if (mLoc.bePath()) {
          Exception ex = new Exception("This exception stacktrace is to help seeing who is calling Logcontroller.setEffectiveSeverity() method that changes controller severity during runtime.");
          mLoc.traceThrowableT(Severity.PATH,
                               "Severity of log controller " + this.getName() + 
                                 " changed from " + Severity.toString(oldValue) + 
                                 " to " + Severity.toString(newValue),
                               ex);
      }
    }
  }


  /**
   * Resets the effective severity of this log controller.
   * If it is a root controller this method has no effect, otherwise it has the
   * same effect as two calls to {@link #setMinimumSeverity()} and
   * {@link #setMaximumSeverity()}.
   */
  public void setEffectiveSeverity() {
    int oldValue = -1, newValue = -1;
    synchronized(getClass()) {
      oldValue = getEffectiveSeverity();
      minSeverity = Severity.ALL;
      maxSeverity = Severity.NONE;
      setInheritFromParent(true);
      LogController parent = getParentInt();
      if(parent != null) {
        calculateEffectiveSeverity();
      } else {
        effSeverity = Severity.NONE;
      }
      newValue = getEffectiveSeverity();
      isConfigChanged = true;
    }
    if(oldValue != newValue) {
        if (mLoc.bePath()) {
          Exception ex = new Exception("This exception stacktrace is to help seeing who is calling Logcontroller.setEffectiveSeverity() method that changes controller severity during runtime.");
          mLoc.traceThrowableT(Severity.PATH,
                               "Severity of log controller " + this.getName() + 
                                 " changed from " + Severity.toString(oldValue) + 
                                 " to " + Severity.toString(newValue),
                               ex);
        }
    }
  }


  /**
   * Sets the maximum severity of this log controller.
   * If its current minimum severity is higher than the argument, the former is
   * set to the argument. If it is a root controller, the method has the same
   * effect as a call to
   * {@link #setEffectiveSeverity(int)}.
   * @param  severity New maximum severity
   * @deprecated
   */
  public void setMaximumSeverity(int severity) {
    int oldValue = -1, newValue = -1;
    synchronized(getClass()) {
      oldValue = getMaximumSeverity();
      severity = Severity.correct(severity);
      boolean inherit = oldValue != severity;
      setInheritFromParent(inherit);
      LogController parent = getParentInt();
      if(parent != null && inherit) {
        maxSeverity = severity;
        if(maxSeverity < minSeverity) {
          minSeverity = maxSeverity;
        }
        calculateEffectiveSeverity();
      } else {
        setEffectiveSeverity(severity);
      }
      newValue = getMaximumSeverity();
      isConfigChanged = true;
    }
    if(oldValue != newValue) {
        if (mLoc.bePath()) {
              Exception ex = new Exception("This exception stacktrace is to help seeing who is calling LogController.setMaximumSeverity() method that changes controller severity during runtime.");
              mLoc.traceThrowableT(Severity.PATH,
                                   "Severity of log controller " + this.getName() + 
                                     " changed from " + Severity.toString(oldValue) + 
                                     " to " + Severity.toString(newValue),
                                   ex);
          }
    }
  }


  /**
   * Resets the maximum severity of this log controller.
   * If it is a root controller this method has no effect, otherwise it has the
   * same effect as a call to {@link #setMinimumSeverity(int)} with
   * {@link Severity#NONE}.
   * @deprecated
   */
  public void setMaximumSeverity() {
    int oldValue = -1, newValue = -1;
    synchronized(getClass()) {
      oldValue = getMaximumSeverity();
      setInheritFromParent(true);
      LogController parent = getParentInt();
      if(parent != null) {
        maxSeverity = Severity.NONE;
        calculateEffectiveSeverity();
      }
      newValue = getMaximumSeverity();
      isConfigChanged = true;
    }
    if(oldValue != newValue) {
        if (mLoc.bePath()) {
          Exception ex = new Exception("This exception stacktrace is to help seeing who is calling LogController.setMaximumSeverity() method that changes controller severity during runtime.");
          mLoc.traceThrowableT(Severity.PATH,
                               "Severity of log controller " + this.getName() + 
                                 " changed from " + Severity.toString(oldValue) + 
                                 " to " + Severity.toString(newValue),
                               ex);
        }
    }
  }


  /**
   * Gets the normal logs this log controller writes messages to.
   * @return Unmodifiable collection of logs associated with this log controller
   */
  public Collection<Log> getLogs() {
    if (logsNormal == null) {
      return new HashSet<Log>();
    }
    synchronized(logsNormal) {
      if(!logsNormal.isEmpty()) {
        return Collections.unmodifiableCollection(logsNormal);
      }
    }
    return new HashSet<Log>();
  }


  /**
   * Gets the local logs this log controller writes messages to.
   * @return Unmodifiable collection of logs associated with this log controller
   * @deprecated
   */
  public Collection<Log> getLocalLogs() {
    if (logsLocal == null) {
      return new HashSet<Log>(); 
    }
    synchronized(logsLocal) {
      if(!logsLocal.isEmpty()) {
        return Collections.unmodifiableCollection(logsLocal.keySet());
      }
    }
    return new HashSet<Log>();
  }


  /**
   * Gets the private logs this log controller writes messages to.
   * @return Unmodifiable collection of logs associated with this log controller
   */
  public Collection<Log> getPrivateLogs() {
    if (logsPrivate == null) {
      return new HashSet<Log>();
    }
    synchronized(logsPrivate) {
      if(!logsPrivate.isEmpty()) {
        return Collections.unmodifiableCollection(logsPrivate);
      }
    }
    return new HashSet<Log>();
  }


  /**
   * Gets all logs (public, private, local and logs inherent from parent) 
   * this log controller writes messages to.
   * @return Unmodifiable collection of logs associated with this log controller
   */
  public Collection<Log> getAllLogs() {
    if (logsRegistry == null) {
        return new HashSet<Log>();
    }
    synchronized(logsRegistry) {
      if(!logsRegistry.isEmpty()) {
        return Collections.unmodifiableCollection(logsRegistry);
      }
    }
    return new HashSet<Log>();
  }


  /**
   * Adds another log for this log controller to write messages to.
   * @param  log New log object
   */
  public void addLog(Log log) {

    boolean result = false;

    if(log != null) {
      synchronized(getClass()) {
        // Add new log
        if(!isLogInRegistry(log)) {
          result = addLogNormalInt(log);
          isConfigChanged = true;
        }
      }
      if(result) {
        // Fire a NEWLOG event to registered listeners
        LoggingManager.getLoggingManager().notifyAddLog(log);

        // Instrument the change...
        APILogger.instrumentIntByAPI(subLoc + "[addLog()]", MSGCollection
          .CONFIGURATION_NEW_ITEM(), new Object[] {"Log", log.getName(), this.getName()});
      }
    } else {
        APILogger.instrumentIntByAPI(Severity.DEBUG,
                                     subLoc + "[addLog(Log log)] " + "ASJ.log_api.000024",
                                     new String[] {"Normal Log", "LogController", this.getName()});        
    }
  }


  /**
   * Adds another local log for this log controller to write messages to.
   * For writing a message into a local log, the severities and filters set for
   * <em>this</em> controller must agree, as opposed to the settings of a child
   * controller the message was possibly forwarded from.
   * @param  log New log object
   * @deprecated
   */
  public void addLocalLog(Log log) {

    boolean result = false;

    if(log != null) {
      synchronized(getClass()) {
        // Add new log
        if(!isLogInRegistry(log)) {
          result = addLogLocalInt(this, log);
          isConfigChanged = true;
        }
      }
      if(result) {
        // Fire a NEWLOG event to registered listeners
        LoggingManager.getLoggingManager().notifyAddLog(log);

        // Instrument the change...
        APILogger.instrumentIntByAPI(subLoc + "[addLocalLog()]", MSGCollection
          .CONFIGURATION_NEW_ITEM(), new Object[] {"Local log", log.getName(),
          this.getName()});
      }
    } else {
        APILogger.instrumentIntByAPI(Severity.DEBUG,
                                     subLoc + "[addLocalLog(Log log)] " + "ASJ.log_api.000025",
                                     new String[] {"Local Log", "LogController", this.getName()});
    }
  }


  /**
   * Adds another private log for this log controller to write messages to.
   * For writing a message into a private log, it must not have been forwarded
   * from a child controller but originally addressed to <em>this</em>
   * controller.
   * @param  log New log object
   */
  public void addPrivateLog(Log log) {

    boolean result = false;

    if(log != null) {
      synchronized(getClass()) {
        // Add new log
        if(!isLogInRegistry(log)) {
          result = addLogPrivateInt(log);
          isConfigChanged = true;
        }
      }
      if(result) {
        // Fire a NEWLOG event to registered listeners
        LoggingManager.getLoggingManager().notifyAddLog(log);

        // Instrument the change...
        APILogger.instrumentIntByAPI(subLoc + "[addPrivateLog()]", MSGCollection
          .CONFIGURATION_NEW_ITEM(), new Object[] {"Private log", log.getName(),
          this.getName()});
      }
    } else {
      APILogger.instrumentIntByAPI(Severity.DEBUG,
                                   subLoc + "[addPrivateLog(Log log)] " + "ASJ.log_api.000026",
                                   new String[] {"Private Log", "LogController", this.getName()});      
    }
  }


  /**
   * Removes a log associated with this log controller.
   * If the log was not associated with the controller nothing is done.
   * @param  log Log to be removed
   */
  public void removeLog(Log log) {
    if(log != null) {
      boolean result = false;
      synchronized(getClass()) {
        if(isLogInRegistry(log)) {
          if(logsNormal != null && !logsNormal.isEmpty())
            removeLogNormalInt(log);
          if(logsLocal != null && !logsLocal.isEmpty())
            removeLogLocalInt(log);
          if(logsPrivate != null && !logsPrivate.isEmpty())
            removeLogPrivateInt(log);
          result = true;
          isConfigChanged = true;
        }
      }
      if(result) {
        LoggingManager.getLoggingManager().notifyRemoveLog(log);

        APILogger.instrumentIntByAPI(subLoc + "[removeLog(Log log)]", MSGCollection
          .CONFIGURATION_REMOVE_ITEM(), new Object[] {"Log", log.getName(),
          this.getName()});
      }
    }
  }


  /**
   * Removes all logs associated with this log controller.
   */
  public void removeLogs() {
    synchronized(getClass()) {
      if(logsNormal != null && !logsNormal.isEmpty())
        removeLogsNormalInt();
      if(logsLocal != null && !logsLocal.isEmpty())
        removeLogsLocalInt();
      if(logsPrivate != null && !logsPrivate.isEmpty())
        removeLogsPrivateInt();
      isConfigChanged = true;
    }
    APILogger.instrumentIntByAPI(
      subLoc + "[removeLogs()]", 
      MSGCollection.CONFIGURATION_REMOVE_ITEM(), 
      new Object[] {"Log", "ALL", this.getName()});
  }


  /**
   * Checks whether all filters associated with this log controller agree with
   * writing a log record.
   * @param  rec Log record to be checked
   * @return No filter vetoes writing
   */
  public boolean isFiltersAgreeing(LogRecord rec) {
    if(rec.getSeverity() != Severity.GROUP) {

      Collection filters = getFiltersInt();

      if(!filters.isEmpty()) {
        Iterator iter = filters.iterator();
        try {
          while(iter.hasNext()) {
            if(!((Filter) iter.next()).beLogged(rec)) {
              return false;
            }
          }
        } catch(Exception ex) {
          APILogger.logIntByAPI(Severity.WARNING, subLoc
            + "[isFiltersAgreeing(LogRecord rec)]",
            "ASJ.log_api.000030",
            "Exception in custom filter for this {0} ({1})!", new String[] {
              "LogController", this.getName()});
          APILogger.catchingIntByAPI(ex);
        }
      }
    }
    return true;
  }


  /**
   * Gets the filters that, besides the effective severity, control output via
   * this log controller.
   * @return Unmodifiable collection of filters associated with this log
   */
  public Collection getFilters() {
    if (filters == null) {
      return Collections.EMPTY_LIST;
    }
    synchronized(filters) {
      if(!filters.isEmpty()) {
        return Collections.unmodifiableCollection(getFiltersInt());
      }
    }
    return Collections.EMPTY_LIST;
  }


  Collection<Filter> getFiltersInt() {
    if (filters == null) {
      return new HashSet<Filter>();
    }
    synchronized(filters) {
      if(!filters.isEmpty()) {
        return filters;
      }
    }
    return new HashSet<Filter>();
  }


  /**
   * Adds another filter that, besides the effective severity, controls output
   * via this log controller.
   * The results of all filters for a given message are logically <em>and</em>ed
   * to determine whether a message is to be written to the associated log
   * objects.
   * @param  filter New filter
   */
  public void addFilter(Filter filter) {
    boolean result = false;
    if (filters == null) {
        filters = new HashSet<Filter>();
    }
    if(filter != null) {
      synchronized(filters) {
        if(!filters.contains(filter)) {
          filters.add(filter);
          result = true;
          isConfigChanged = true;
        }
      }
      if(result) {
        APILogger.instrumentIntByAPI(
          subLoc + "[addFilter()]", 
          MSGCollection.CONFIGURATION_NEW_ITEM(), 
          new Object[] {"Filter", filter.getClass().getName(),
          this.getName()});
      }
    } else {
      APILogger.logIntByAPI(
        Severity.WARNING, 
        subLoc + "[addFilter(Filter filter)]",
        "ASJ.log_api.000027",
        "Excepted object is not specified ({0} == null) for {1}({2})!", 
        new String[] {"Filter", "LogController", this.getName()});
    }
  }


  /**
   * Removes a filter, so that it no longer controls output via this log
   * controller.
   * @param  filter Filter to be removed
   */
  public void removeFilter(Filter filter) {
    if (filters == null) {
        return;
    }
    synchronized(filters) {
      filters.remove(filter);
    }
    APILogger.instrumentIntByAPI(
      subLoc + "[removeFilter(Filter filter)]", 
      MSGCollection.CONFIGURATION_REMOVE_ITEM(), 
      new Object[] {"filter", filter.getClass().getName(),
      this.getName()});
  }


  /**
   * Removes all filters associated with this log controller.
   */
  public void removeFilters() {
    if (filters == null) {
      return;
    }
    synchronized(filters) {
      filters.clear();
    }
    APILogger.instrumentIntByAPI(
      subLoc + "[removeFilters()]", 
      MSGCollection.CONFIGURATION_REMOVE_ITEM(), 
      new Object[] {"Filter", "ALL", this.getName()});
  }


  /**
   * @return
   * @deprecated
   */
  public LogController[] getRelatives() {
    LogController[] logControlers = null;
    synchronized(getClass()) {
      if(relations == null)
        return null;
      if(!relations.relations.isEmpty()) {
        logControlers = 
          (LogController[]) relations.relations.keySet().toArray(new LogController[0]);
      }
    }
    return logControlers;
  }


  /**
   * Gets the name of the optional resource bundle assigned to this log
   * controller.
   * If a resource bundle is assigned, language-independent log messages can be
   * written.
   * @return Name of optional resource bundle or <code>null</code>
   * @see    #setResourceBundleName(java.lang.String)
   */
  public String getResourceBundleName() {
    if(resourceBundleSet) {
      return resourceBundleName;
    }

    LogController parent = getParentInt();
    if(parent != null) {
      return parent.getResourceBundleName();
    }
    return null;
  }


  /**
   * Assigns a resource bundle name to this log controller.
   * If a resource bundle is assigned, language-independent log messages can be
   * written.
   * @param  resourceBundle Name of resource bundle
   * @see    #getResourceBundleName()
   */
  public void setResourceBundleName(String resourceBundleName) {
    String oldValue = "", newValue = "";
    synchronized(getClass()) {
      oldValue = getResourceBundleName();
      this.resourceBundleName = resourceBundleName;
      this.resourceBundleSet = true;
      newValue = getResourceBundleName();
    }
    APILogger.instrumentIntByAPI(subLoc
      + "[setResourceBundleName(String resourceBundleName)]", MSGCollection
      .CONFIGURATION_IS_CHANGED(), new Object[] {"resource bundle name", "LogController",
      this.getName(), oldValue, newValue});
  }


  /**
   * Resets the resource bundle name of this log controller.
   * @see    #getResourceBundleName()
   */
  public void setResourceBundleName() {
    String oldValue = "", newValue = "";
    synchronized(getClass()) {
      oldValue = getResourceBundleName();
      resourceBundleName = null;
      resourceBundleSet = false;
      newValue = getResourceBundleName();
    }
    APILogger.instrumentIntByAPI(subLoc + "[setResourceBundleName()]", MSGCollection
      .CONFIGURATION_IS_CHANGED(), new Object[] {"resource bundle name", "LogController",
      this.getName(), oldValue, newValue});
  }


  /**
   * Gets the class loader assigned to this log controller for getting resource
   * bundles.
   * If you emit a language-independent message without giving an explicit clear
   * text version, the assigned class loader will be used to get the resource
   * bundle from which to retrieve it. If no class loader is assigned, the
   * bundle will be determined using the loader of this class or, if not
   * successful, the context class loader of this thread.
   * @return Assigned class loader
   * @see    #setClassLoader(java.lang.ClassLoader)
   */
  public synchronized ClassLoader getClassLoader() {
    if(classLoaderSet) {
      return classLoader;
    } else {
      LogController parent = getParentInt();

      if(parent != null) {
        return parent.getClassLoader();
      } else {
        return null;
      }
    }
  }


  /**
   * Assigns a class loader to this log controller for getting resource bundles.
   * If you emit a language-independent message without giving an explicit clear
   * text version, the assigned class loader will be used to get the resource
   * bundle from which to retrieve it.
   * @param  classLoader Class loader
   * @see    #getClassLoader()
   */
  public synchronized void setClassLoader(ClassLoader classLoader) {
    this.classLoader = classLoader;
    classLoaderSet = true;
  }


  /**
   * Resets the class loader assigned to this log controller for getting
   * resource bundles.
   * If you emit a language-independent message without giving an explicit clear
   * text version, the assigned class loader will be used to get the resource
   * bundle from which to retrieve it.
   * @see    #getClassLoader()
   */
  public synchronized void setClassLoader() {
    classLoader = null;
    classLoaderSet = false;
  }


  /**
   * Checks whether a message with the specified severity would be written via
   * this log controller.
   * The purpose of this method is to avoid evaluating the arguments of a
   * logging call, which is expensive and would be superfluous if a message is
   * not written because of its insufficient severity. The result returned is
   * necessary but not sufficient for writing log messages, that is if the
   * method returns <code>false</code> the message is not going to be written
   * but not vice versa. To this end, the method checks whether the specified
   * severity is equal to or higher than the effective severity of the
   * controller. It does neither take into account severities assigned to
   * relations with other log controllers nor filters associated with the log
   * controller or logs. This version of the method is more efficient than the
   * version also taking another log controller as argument, and therefore
   * better fits the purpose to avoid inefficiencies.
   * @param  severity Severity of message to be written
   * @see    #beLogged(int,
   *                   LogController)
   * @see    #beLogged(int,
   *                   LogController[])
   */
  public boolean beLogged(int severity) {
    return (isActivityTrackingEnabled && isActivityTracking(severity)) || severity >= effSeverity;
  }


  /**
   * Checks whether a message with the specified severity would be written via
   * this log controller with respect to another log controller.
   * The purpose of this method is to avoid evaluating the arguments of a
   * logging call, which is expensive and would be superfluous if a message is
   * not written because of its insufficient severity. The result returned is
   * necessary but not sufficient for writing log messages, that is if the
   * method returns <code>false</code> the message is not going to be written
   * but not vice versa. To this end, the method checks whether the specified
   * severity is equal to or higher than the effective severity of the
   * controller or a severity assigned to the relation of this controller to
   * the one handed over as argument. It does not take into account filters
   * associated with the log controller or logs. This version of the method is
   * less efficient than the version with one argument, and therefore does not
   * fit the purpose to avoid inefficiencies as well.
   * @param  severity Severity of message to be written
   * @param  relative Related log controller
   * @see    #beLogged(int)
   * @deprecated
   */
  public boolean beLogged(int severity, LogController relative) {
    if((isActivityTrackingEnabled && isActivityTracking(severity)) || severity >= effSeverity) {
      return true;
    } else {
      if(severity < minEffRelationSeverity) {
        return false;
      } else {
        return severity >= getEffectiveSeverity(relative);
      }
    }
  }


  /**
   * Same as
   * {@link #beLogged(int,
   *                  LogController)}
   * but returns true if one of the specified log controllers yields a positive
   * result.
   * @param  severity  Severity of message to be written
   * @param  relatives Related log controllers
   * @see    #beLogged(int)
   * @deprecated
   */
  public boolean beLogged(int severity, LogController[] relatives) {
    if((isActivityTrackingEnabled && isActivityTracking(severity)) || severity >= effSeverity) {
      return true;
    } else {
      if(severity < minEffRelationSeverity) {
        return false;
      } else {
        return severity >= getEffectiveSeverity(relatives);
      }
    }
  }


  /**
   * Same as
   * {@link #beLogged(int)}
   * but always checks for a debug message, that is a message with severity
   * {@link Severity#DEBUG}.
   */
  public boolean beDebug() {
    return (isActivityTrackingEnabled && isActivityTracking(Severity.DEBUG))
      || Severity.DEBUG >= effSeverity;
  }


  /**
   * Same as
   * {@link #beLogged(int,
   *                  LogController)}
   * but always checks for a debug message, that is a message with severity
   * {@link Severity#DEBUG}.
   * @param  relative Log controller that is related to this one
   * @deprecated
   */
  public boolean beDebug(LogController relative) {
    if((isActivityTrackingEnabled && isActivityTracking(Severity.DEBUG))
      || Severity.DEBUG >= effSeverity) {
      return true;
    } else {
      if(Severity.DEBUG < minEffRelationSeverity) {
        return false;
      } else {
        return Severity.DEBUG >= getEffectiveSeverity(relative);
      }
    }
  }


  /**
   * Same as
   * {@link #beLogged(int,
   *                  LogController[])}
   * but always checks for a debug message, that is a message with severity
   * {@link Severity#DEBUG}.
   * @param  relatives Log controllers that are related to this one
   * @deprecated
   */
  public boolean beDebug(LogController[] relatives) {
    if((isActivityTrackingEnabled && isActivityTracking(Severity.DEBUG))
      || Severity.DEBUG >= effSeverity) {
      return true;
    } else {
      if(Severity.DEBUG < minEffRelationSeverity) {
        return false;
      } else {
        return Severity.DEBUG >= getEffectiveSeverity(relatives);
      }
    }
  }


  /**
   * Same as
   * {@link #beLogged(int)}
   * but always checks for a path message, that is a message with severity
   * {@link Severity#PATH}.
   */
  public boolean bePath() {
    return (isActivityTrackingEnabled && isActivityTracking(Severity.PATH))
      || Severity.PATH >= effSeverity;
  }


  /**
   * Same as
   * {@link #beLogged(int,
   *                  LogController)}
   * but always checks for a path message, that is a message with severity
   * {@link Severity#PATH}.
   * @param  relative Log controller that is related to this one
   * @deprecated
   */
  public boolean bePath(LogController relative) {
    if((isActivityTrackingEnabled && isActivityTracking(Severity.PATH))
      || Severity.PATH >= effSeverity) {
      return true;
    } else {
      if(Severity.PATH < minEffRelationSeverity) {
        return false;
      } else {
        return Severity.PATH >= getEffectiveSeverity(relative);
      }
    }
  }


  /**
   * Same as
   * {@link #beLogged(int,
   *                  LogController[])}
   * but always checks for a path message, that is a message with severity
   * {@link Severity#PATH}.
   * @param  relatives Log controllers that are related to this one
   * @deprecated
   */
  public boolean bePath(LogController[] relatives) {
    if((isActivityTrackingEnabled && isActivityTracking(Severity.PATH))
      || Severity.PATH >= effSeverity) {
      return true;
    } else {
      if(Severity.PATH < minEffRelationSeverity) {
        return false;
      } else {
        return Severity.PATH >= getEffectiveSeverity(relatives);
      }
    }
  }


  /**
   * Same as
   * {@link #beLogged(int)}
   * but always checks for an informational message, that is a message with
   * severity
   * {@link Severity#INFO}.
   */
  public boolean beInfo() {
    return (isActivityTrackingEnabled && isActivityTracking(Severity.INFO))
      || Severity.INFO >= effSeverity;
  }


  /**
   * Same as
   * {@link #beLogged(int,
   *                  LogController)}
   * but always checks for an informational message, that is a message with
   * severity
   * {@link Severity#INFO}.
   * @param  relative Log controller that is related to this one
   * @deprecated
   */
  public boolean beInfo(LogController relative) {
    if((isActivityTrackingEnabled && isActivityTracking(Severity.INFO))
      || Severity.INFO >= effSeverity) {
      return true;
    } else {
      if(Severity.INFO < minEffRelationSeverity) {
        return false;
      } else {
        return Severity.INFO >= getEffectiveSeverity(relative);
      }
    }
  }


  /**
   * Same as
   * {@link #beLogged(int,
   *                  LogController[])}
   * but always checks for an informational message, that is a message with
   * severity
   * {@link Severity#INFO}.
   * @param  relatives Log controllers that are related to this one
   * @deprecated
   */
  public boolean beInfo(LogController[] relatives) {
    if((isActivityTrackingEnabled && isActivityTracking(Severity.INFO))
      || Severity.INFO >= effSeverity) {
      return true;
    } else {
      if(Severity.INFO < minEffRelationSeverity) {
        return false;
      } else {
        return Severity.INFO >= getEffectiveSeverity(relatives);
      }
    }
  }


  /**
   * Same as
   * {@link #beLogged(int)}
   * but always checks for a warning message, that is a message with severity
   * {@link Severity#WARNING}.
   */
  public boolean beWarning() {
    return (isActivityTrackingEnabled && isActivityTracking(Severity.WARNING))
      || Severity.WARNING >= effSeverity;
  }


  /**
   * Same as
   * {@link #beLogged(int,
   *                  LogController)}
   * but always checks for a warning message, that is a message with severity
   * {@link Severity#WARNING}.
   * @param  relative Log controller that is related to this one
   * @deprecated
   */
  public boolean beWarning(LogController relative) {
    if((isActivityTrackingEnabled && isActivityTracking(Severity.WARNING))
      || Severity.WARNING >= effSeverity) {
      return true;
    } else {
      if(Severity.WARNING < minEffRelationSeverity) {
        return false;
      } else {
        return Severity.WARNING >= getEffectiveSeverity(relative);
      }
    }
  }


  /**
   * Same as
   * {@link #beLogged(int,
   *                  LogController[])}
   * but always checks for a warning message, that is a message with severity
   * {@link Severity#WARNING}.
   * @param  relatives Log controllers that are related to this one
   * @deprecated
   */
  public boolean beWarning(LogController[] relatives) {
    if((isActivityTrackingEnabled && isActivityTracking(Severity.WARNING))
      || Severity.WARNING >= effSeverity) {
      return true;
    } else {
      if(Severity.WARNING < minEffRelationSeverity) {
        return false;
      } else {
        return Severity.WARNING >= getEffectiveSeverity(relatives);
      }
    }
  }


  /**
   * Same as
   * {@link #beLogged(int)}
   * but always checks for an error message, that is a message with severity
   * {@link Severity#ERROR}.
   */
  public boolean beError() {
    return (isActivityTrackingEnabled && isActivityTracking(Severity.ERROR))
      || Severity.ERROR >= effSeverity;
  }


  /**
   * Same as
   * {@link #beLogged(int,
   *                  LogController)}
   * but always checks for an error message, that is a message with severity
   * {@link Severity#ERROR}.
   * @param  relative Log controller that is related to this one
   * @deprecated
   */
  public boolean beError(LogController relative) {
    if((isActivityTrackingEnabled && isActivityTracking(Severity.ERROR))
      || Severity.ERROR >= effSeverity) {
      return true;
    } else {
      if(Severity.ERROR < minEffRelationSeverity) {
        return false;
      } else {
        return Severity.ERROR >= getEffectiveSeverity(relative);
      }
    }
  }


  /**
   * Same as
   * {@link #beLogged(int,
   *                  LogController[])}
   * but always checks for an error message, that is a message with severity
   * {@link Severity#ERROR}.
   * @param  relatives Log controllers that are related to this one
   * @deprecated
   */
  public boolean beError(LogController[] relatives) {
    if((isActivityTrackingEnabled && isActivityTracking(Severity.ERROR))
      || Severity.ERROR >= effSeverity) {
      return true;
    } else {
      if(Severity.ERROR < minEffRelationSeverity) {
        return false;
      } else {
        return Severity.ERROR >= getEffectiveSeverity(relatives);
      }
    }
  }


  /**
   * Same as
   * {@link #beLogged(int)}
   * but always checks for a fatal error message, that is a message with
   * severity
   * {@link Severity#FATAL}.
   */
  public boolean beFatal() {
    return (isActivityTrackingEnabled && isActivityTracking(Severity.FATAL))
      || Severity.FATAL >= effSeverity;
  }


  /**
   * Same as
   * {@link #beLogged(int,
   *                  LogController)}
   * but always checks for a fatal error message, that is a message with
   * severity
   * {@link Severity#FATAL}.
   * @param  relative Log controller that is related to this one
   * @deprecated
   */
  public boolean beFatal(LogController relative) {
    if((isActivityTrackingEnabled && isActivityTracking(Severity.FATAL))
      || Severity.FATAL >= effSeverity) {
      return true;
    } else {
      if(Severity.FATAL < minEffRelationSeverity) {
        return false;
      } else {
        return Severity.FATAL >= getEffectiveSeverity(relative);
      }
    }
  }


  /**
   * Same as
   * {@link #beLogged(int,
   *                  LogController[])}
   * but always checks for a fatal error message, that is a message with
   * severity
   * {@link Severity#FATAL}.
   * @param  relatives Log controllers that are related to this one
   * @deprecated
   */
  public boolean beFatal(LogController[] relatives) {
    if((isActivityTrackingEnabled && isActivityTracking(Severity.FATAL))
      || Severity.FATAL >= effSeverity) {
      return true;
    } else {
      if(Severity.FATAL < minEffRelationSeverity) {
        return false;
      } else {
        return Severity.FATAL >= getEffectiveSeverity(relatives);
      }
    }
  }


  /**
   * Checks whether a message with group severity would be written via this log
   * controller.
   * @see    #beLogged(int)
   * @deprecated Groups are not used and implementation was removed for memory usage improvement,
   *             Instead use correlation id.
   */
  public boolean beGroup() {
    return false;
  }


  public boolean isActivityTracking(int severity) {
    return (isActivityTrackingEnabled && isActivityTracking.isActivity(this.getName(), severity));
  }


  public static synchronized void setActivityTracking(ISATChecker value) {
    isActivityTracking = value;
    isActivityTrackingEnabled = (value != null);
  }


  public boolean getIsActivityTrackingEnabled() {
    return(isActivityTrackingEnabled);
  }
  
  public int getLoggedCount() {
    return loggedSumCnt;
  }


  public void resetLoggedCount() {
    loggedSumCnt = 0;
  }


  public int getLoggedCnt() {
    return loggedCnt;
  }


  //==== < public ==================================== protected > ====

  protected Map getLocalLogsMap() {
    if (logsLocal == null) {
      return Collections.EMPTY_MAP;        
    }
    if(logsLocal != null) {
      return logsLocal;
    }
    return Collections.EMPTY_MAP;
  }


  //Get names from relatives list 
  // and put them to the String array
  protected String[] convertRelatives(LogController[] relatives) {

    String[] tmpValues = null;

    if(relatives != null) {
      tmpValues = new String[relatives.length];

      for(int i = 0; i < relatives.length; ++i) {
        tmpValues[i] = relatives[i].getName();
      }
    }
    return tmpValues;
  }


  //***************************************************************
  // FOR INTERNAL USE - ONLY
  //***************************************************************
  protected LogRecord logIntByAPI(int severity, Location loc, String subloc,
    String msgCode, String msgClear, Object[] args) {

    return logInt(severity, loc, null, subloc, msgCode, msgClear, MsgType.JAVA, args);
  }


  protected LogRecord logIntByAPI(int severity, Location loc, String subloc,
    String msgCode, String msgClear, Object[] args, Throwable exc) {

    return logInt(severity, loc, null, subloc, msgCode, msgClear, MsgType.JAVA, args, exc);
  }


  protected LogRecord catchingIntByAPI(Throwable exc) {
    return logTInt(Severity.PATH, this, MSG_RELATIVES, MSG_SUB_LOC, MSG_CATCHING,
      MsgType.JAVA, new Object[] {ExceptionManager.getStackTrace(exc)});
  }


  //*************************************************************** 

  protected LogRecord messageInternal(LogRecord rec) throws Exception {
      
    LogRecord writtenRec = null;

    if(isFiltersAgreeing(rec)) {

      // Hand over log record to all logs of this log controller.
      if(logsNormal != null && !logsNormal.isEmpty()) {
        LogRecord tmpRec = writeToLogs(logsNormal, rec);
        if(tmpRec != null) {
          setSumLogged();
          writtenRec = tmpRec;
        }
      }

      if(logsLocal != null && !logsLocal.isEmpty()) {
        LogRecord tmpRec = writeToLocalLogs(logsLocal, rec);
        if(tmpRec != null) {
          setSumLogged();
          writtenRec = tmpRec;
        }
      }

      if(logsPrivate != null && !logsPrivate.isEmpty()) {
        LogRecord tmpRec = writeToLogs(logsPrivate, rec);
        if(tmpRec != null) {
          setSumLogged();
          writtenRec = tmpRec;
        }
      }

      //  Store log record if written.
      if(writtenRec != null) {
        setLogged();
        LoggingManager.getLoggingManager().notifyWriteMessage(rec);
      }
    }
    return writtenRec;
  }


  //==== < protected =================================== default > ====

  //******************************************************
  //              LOG T METHODS
  //******************************************************                

  private void increaseSeverityCounters(LogRecord result, int severity) {
    if (result != null) {
      int index = severity / 100 - 1;
      if ((index < NUMBER_OF_SEVERITIES) && (index > -1)) {
        SEVERITIES_USED[index]++;
      } else {
        if (mLoc.bePath()) {
          Exception ex = new Exception("This exception stacktrace is to help seeing who is calling LogController with wrong severity.");
          mLoc.traceThrowableT(Severity.ERROR, "Wrong severity of log controller " + this.getName(), ex);
        }
      }
    }
  }

  private String getLogControllerName(LogController loc, String subloc) {
    String locName = loc.getName();
    if(subloc != null) {
      locName = locName + Location.SEPARATOR + subloc;
    }
    return locName;
  }
  
  private LogRecord prepareLogRecord(LogRecord rec, String sourceName, String dcName, String csnComponent) throws Exception {
    if (sourceName != null) {
      rec.setSourceName(sourceName);
    }        
    if (dcName != null) {
      rec.dcName = dcName;
    }
    if (csnComponent != null) {
      rec.csnComponent = csnComponent;
    }        
    return messageInternal(rec);
  }
  
  private void logIntException(Exception ex, String subLocation, String msgID, boolean handleException) {
    exceptionGuardian = true;
    APILogger.logIntByAPI(Severity.WARNING, subLocation, msgID, "Unexcepted error occured on {0}!", new String[] {this.getName()});
    APILogger.catchingIntByAPI(ex);
    if (handleException) {
      handleException(ex, ExceptionManager.ERR_WRITE);
    }
    exceptionGuardian = false;
  }
  
  private void logIntSeverityWarning(Exception ex, String subLocation, String message) {
    exceptionGuardian = true;
    APILogger.traceThrowableIntByAPI(Severity.WARNING, subLocation, message, ex);
    exceptionGuardian = false;
  }

  LogRecord logTInt(int severity, LogController loc, LogController[] relatives,
    String subloc, String msg, int msgType, Object[] args) {
      
    LogRecord result = logTInt(severity, loc, relatives, subloc, msg, msgType, args, null);
    return result;
  }

  LogRecord logTInt(int severity, LogController loc, LogController[] relatives,
    String subloc, String msg, int msgType, Object[] args, Throwable msgExc) {
      return logTInt(severity, loc, relatives, subloc, msg, msgType, args, msgExc, null, null, null);
  }
      
  LogRecord logTInt(int severity, LogController loc, LogController[] relatives,
		    String subloc, String msg, int msgType, Object[] args, Throwable msgExc, String msgCode, String csnComponent, String dcName) {
	return logTInt(severity, loc, relatives, subloc, msg, msgType, args, msgExc, msgCode, csnComponent, dcName, null);      
  }

  LogRecord logTInt(int severity, LogController loc, LogController[] relatives,
    String subloc, String msg, int msgType, Object[] args, Throwable msgExc, String msgCode, String csnComponent, String dcName, String sourceName) {      

    LogRecord writtenRec = null;

    if (severity > Severity.FATAL) {
      severity = Severity.FATAL;
      logIntSeverityWarning(new Exception(), subLoc + "[logIntT(...)]", "Severity above FATAL is not allowed.");
    }

    if (severity < Severity.DEBUG) {
      severity = Severity.DEBUG;
      logIntSeverityWarning(new Exception(), subLoc + "[logIntT(...)]", "Severity below DEBUG is not allowed.");
    }

    try {
      String locName = getLogControllerName(loc, subloc); 
      LogRecord rec = 
        new LogRecord(
          this, locName, severity, convertRelatives(relatives), msgType, msg, 
          checkArguments(args), msgExc);      
      writtenRec = this.prepareLogRecord(rec, sourceName, dcName, csnComponent);
    } catch(Exception ex) {
      if(exceptionGuardian) {
        increaseSeverityCounters(writtenRec, severity);
        return writtenRec;
      }   
      logIntException(ex, subLoc + "[logIntT(...)]", "ASJ.log_api.000006", true);
    }                     
	  increaseSeverityCounters(writtenRec, severity);
    return writtenRec;
  }


  //******************************************************

  LogRecord logSeverityTInt(int severity, LogController loc, LogController[] relatives,
    String subloc, String msg, int msgType, Object[] args) {

    return logSeverityTInt(severity, loc, relatives, subloc, msg, msgType, args, null, null, null, null);
  }


  LogRecord logSeverityTInt(int severity, LogController loc, LogController[] relatives,
    String subloc, String msg, int msgType, Object[] args, Throwable msgExc, String msgCode, String csnComponent, String dcName) {

    LogRecord writtenRec = null;

    writtenRec = logTInt(severity, loc, relatives, subloc, msg, msgType, args, msgExc, msgCode, csnComponent, dcName);

    // Writte message to the relatives
    if(relatives != null) {
      for(int i = 0; i < relatives.length; ++i) {
        LogController[] newRelatives = copyRelatives(relatives[i], relatives);
        if(relatives[i].beLogged(severity, newRelatives)) {
          relatives[i].logTInt(severity, loc, newRelatives, subloc, msg, msgType, args,
            msgExc, msgCode, csnComponent, dcName, this.lcName);
        }
      }
    }
    return writtenRec;
  }


  //******************************************************
  //              LOG METHODS - RESOURCE BUNDLE
  //******************************************************

  LogRecord logInt(int severity, LogController logC, LogController[] relatives,
    String subloc, String msgCode, String msgClear, int msgType, Object... args) {
    return logInt(severity, logC, relatives, subloc, msgCode, msgClear, msgType, args,
      null);
  }
  
  LogRecord logInt(int severity, LogController logC, LogController[] relatives,
          String subloc, String msgCode, String msgClear, int msgType, Object[] args,
          Throwable msgExc) {
      return logInt(severity, logC, relatives, subloc, msgCode, null, null, msgClear, msgType, args, msgExc);
  }

  LogRecord logInt(int severity, LogController logC, LogController[] relatives,
          String subloc, String msgCode, String csnComponent, String dcName, String msg, int msgType, Object[] args,
          Throwable msgExc) {

    if (severity > Severity.FATAL) {
      severity = Severity.FATAL;
      logIntSeverityWarning(new Exception(), subLoc + "[logIntT(...)]", "Severity above FATAL is not allowed.");
    }

    if (severity < Severity.DEBUG) {
      severity = Severity.DEBUG;
      logIntSeverityWarning(new Exception(), subLoc + "[logIntT(...)]", "Severity below DEBUG is not allowed.");
    }
    
    //If Location have defined ResBundle then use it
    // otherwise take the Category ResBundle
    String resBundleName = logC.getResourceBundleName();
    if(resBundleName == null) {
      resBundleName = getResourceBundleName();
    }

    //following is taken out of the synchronization block [see CSN 1573667 - deadlock in ATS smokes with cross service enabled tracing]
    String msgLocalized = null;
    if (msgCode != null) {
      msgLocalized = resolveMessageAccordingResourceBundle(resBundleName, msgCode);
    }
    /* actually msgCode is no more used to resolve messages from a resource bundles, but is used in message ID Concept */

    LogRecord writtenRec = null;

    try {
      String locName = getLogControllerName(logC, subloc);
      LogRecord rec = new LogRecord(this, locName, severity, convertRelatives(relatives),
          msgType, msgCode, resBundleName, msg, checkArguments(args),
          msgExc, csnComponent);
      rec.resourceBundleName = resBundleName;
      if (msgLocalized != null) {
          rec.msgClear = msgLocalized;
      } 
      writtenRec = this.prepareLogRecord(rec, null, dcName, csnComponent);
    } catch(Exception ex) {
      if(exceptionGuardian) {
      	increaseSeverityCounters(writtenRec, severity);
        return writtenRec;
      }
      logIntException(ex, subLoc + "[logInt(...)]", "ASJ.log_api.000007", true);
    }
	  increaseSeverityCounters(writtenRec, severity);
    return writtenRec;
  }
  
  private String resolveMessageAccordingResourceBundle(String resBundleName, String msgID) {
      String thisMsgLocalized = null;
      
      if (resBundleName != null) {
          try {
              // First query correct resource bundle.
              ResourceBundle msgs;
              ClassLoader    classLoader = this.getClassLoader();

              if (classLoader != null) {
                msgs = ResourceBundle.getBundle(resBundleName,
                                                LogRecord.STANDARD_LOCALE,
                                                classLoader);
              } 
              else {
                  try {
                      msgs = ResourceBundle.getBundle(resBundleName, LogRecord.STANDARD_LOCALE);
                }
                catch (MissingResourceException exc) {
                      msgs = ResourceBundle.getBundle(resBundleName,
                                                      LogRecord.STANDARD_LOCALE,
                                                      Thread.currentThread().getContextClassLoader());
                }
              }

              // Then retrieve the fallback message text.
              thisMsgLocalized = msgs.getString(msgID);
          }
          catch (MissingResourceException exc) {
              this.handleException(exc);
          }
          catch (SecurityException exc) {
              this.handleException(exc);
          }
          catch (NullPointerException exc) {
              this.handleException(exc);
          }
      }
      return thisMsgLocalized;      
  }


  //******************************************************

  LogRecord logSeverityInt(int severity, LogController loc, LogController[] relatives,
    String subloc, String msgCode, String msgClear, int msgType, Object... args) {
      return logSeverityInt(severity, loc, relatives, subloc, msgCode, null, null, msgClear, msgType, args);
  }

  LogRecord logSeverityInt(int severity, LogController loc, LogController[] relatives,
    String subloc, String msgCode, String csnComponent, String dcName, String msgClear, int msgType, Object... args) {
    return logSeverityInt(severity, loc, relatives, subloc, null, msgType, msgCode, csnComponent, dcName, msgClear,
      args);
  }


  LogRecord logSeverityInt(int severity, LogController loc, LogController[] relatives,
    String subloc, Throwable msgExc, int msgType, String msgCode, String csnComponent, String dcName, String msgClear, Object... args) {

    LogRecord writtenRec = logInt(severity, loc, relatives,
                                  subloc, msgCode, csnComponent, dcName,
                                  msgClear, msgType, args, msgExc);     

    if(relatives != null) {
      for(int i = 0; i < relatives.length; ++i) {
        LogController[] newRelatives = copyRelatives(relatives[i], relatives);
        if(relatives[i].beLogged(severity, newRelatives)) {
          relatives[i].logInt(severity, loc, newRelatives,
                              subloc, msgCode, csnComponent, dcName,
                              msgClear, msgType, args, msgExc);
        }
      }
    }
    return writtenRec;
  }


  //******************************************************

  //*******************************************
  // GROUP
  //*******************************************
  
  /**
   * @deprecated Groups are not used and implementation was removed for memory usage improvement,
   *             Instead use correlation id.
   */
  void openGroupInt(String grpName, String grpDescription, int severity, String subloc) {
    //empty
  }

  /**
    * @deprecated Groups are not used and implementation was removed for memory usage improvement,
    *             Instead use correlation id.
    */
  void openGroupInt(String grpName, String grpDescription, int severity, String subloc,
    LogController logC) {
      // empty
  }

  /**
   * @deprecated Groups are not used and implementation was removed for memory usage improvement,
   *             Instead use correlation id.
   */
  void openGroupInt(String grpName, String grpDescription, int severity, String subloc,
    LogController[] logCs) {
      //empty
  }

  /**
   * @deprecated Groups are not used and implementation was removed for memory usage improvement,
   *             Instead use correlation id.
   */
  void closeGroupInt() {
    //empty
  }

  /**
   * @deprecated Groups are not used and implementation was removed for memory usage improvement,
   *             Instead use correlation id.
   */
  void closeGroupInt(Group group) {
    //empty
  }


  //*******************************************

  /**
   * Gets the parent location of this log controller.
   * @return Parent location
   */
  LogController getParentInt() {
    if(parent == null) {
      return parent;
    }
    if(parent.isCopyToSubtree()) {
      return parent;
    }
    return parent.getParentInt();
  }


  Collection<LogController> getChildrenInt() {
    return children;
  }


  /**
   * Adds a child to the collection of this log controller.
   * @param  child Log controller to be added
   */
  void addChild(LogController child) {
    synchronized(getClass()) {
      synchronized(children) {
        children.add(child);
      }
    }
  }


  Relations getRelations() {
    return relations;
  }


  Regarders getRegarders() {
    return regarders;
  }


  void resetAllInt() {
    resetInt();
    resetLogsInt();
    for(LogController lc: getChildrenInt()) {
      lc.resetAllInt();
      lc.resetLogsInt();
    }
  }
  
  
  void resetLogs() {
    resetLogsInt();
    for(LogController lc: getChildrenInt()) {
      lc.resetLogsInt();
    }
  }
  
  
  synchronized void resetLogsInt() {
    synchronized (getClass()) {
      if (logsNormal != null) {
        logsNormal.clear();
      }
      if (logsPrivate != null) {
        logsPrivate.clear();
      }
      if (logsLocal != null) {
        logsLocal.clear();          
      }
      if (logsRegistry != null) {
        logsRegistry.clear();
      }
    }
  }


  void resetInt() {
    synchronized (getClass()) {
      inheritFromParent = true;
      copyToSubtree = true;
      isConfigChanged = false;
      
      minSeverity = Severity.ALL; 
      maxSeverity = Severity.NONE;
      prevMinSeverity = Severity.ALL; 
      prevMaxSeverity = Severity.NONE;
      minEffRelationSeverity = Severity.NONE;
      effSeverity = Severity.NONE;
      
      if (filters != null) {
          filters.clear();
      }
      
      loggedCnt = 0;
      loggedSumCnt = 0;
    }
  }


  void setSumLogged() {
    ++loggedSumCnt;
  }


  boolean wasLogged() {
    return loggedCnt > 0;
  }


  void resetLogged() {
    loggedCnt = 0;
  }


  void setLogged() {
    ++loggedCnt;
  }


  /**
   * @param relative
   * @param severity
   * @deprecated
   */
  void setMinimumSeverity(LogController relative, int severity) {
    synchronized(getClass()) {
      LogController parent = getParentInt();
      if(isInheritFromParent() && parent != null) {
        severity = Severity.correct(severity);
        if(relative == null) {
          handleException(new IllegalArgumentException(NO_RELATIVE_EMSG));
        }
        Relations relations = getRelations();
        // Relation might have been shared so copy it to make update possible.
        Relation relation = (Relation) relations.get(relative).clone();
        relation.setLocalMinimumSeverity(severity);
        relations.put(relative, relation);
        calculateEffectiveSeverity(relative);
      } else {
        setEffectiveSeverity(relative, severity);
      }
    }
  }


  /**
   * @param relative
   * @deprecated
   */
  void setMinimumSeverity(LogController relative) {
    synchronized(getClass()) {
      LogController parent = getParentInt();
      if(isInheritFromParent() && parent != null) {
        if(relative == null) {
          handleException(new IllegalArgumentException(NO_RELATIVE_EMSG));
        }
        Relations relations = getRelations();
        // Relation might have been shared so copy it to make update possible.
        Relation relation = (Relation) relations.get(relative).clone();
        relation.setLocalMinimumSeverity();
        relations.put(relative, relation);
        calculateEffectiveSeverity(relative);
      }
    }
  }


  /**
   * @param relative
   * @param severity
   * @deprecated
   */
  void setEffectiveSeverity(LogController relative, int severity) {
    synchronized(getClass()) {
      severity = Severity.correct(severity);
      if(relative == null) {
        handleException(new IllegalArgumentException(NO_RELATIVE_EMSG));
      }
      Relations relations = getRelations();
      // Relation might have been shared so copy it to make update possible.
      Relation relation = (Relation) relations.get(relative).clone();
      relation.setLocalMinimumSeverity(severity);
      relation.setLocalMaximumSeverity(severity);
      relations.put(relative, relation);
      calculateEffectiveSeverity(relative);
    }
  }


  /**
   * @param relative
   * @deprecated
   */
  void setEffectiveSeverity(LogController relative) {
    synchronized(getClass()) {
      LogController parent = getParentInt();
      if(isInheritFromParent() && parent != null) {
        if(relative == null) {
          handleException(new IllegalArgumentException(NO_RELATIVE_EMSG));
        }
        Relations relations = getRelations();
        // Relation might have been shared so copy it to make update possible.
        Relation relation = (Relation) relations.get(relative).clone();
        relation.setEffectiveSeverity();
        relations.put(relative, relation);
        calculateEffectiveSeverity(relative);
      }
    }
  }


  /**
   * @param relative
   * @param severity
   * @deprecated
   */
  void setMaximumSeverity(LogController relative, int severity) {
    synchronized(getClass()) {
      LogController parent = getParentInt();
      if(isInheritFromParent() && parent != null) {
        severity = Severity.correct(severity);
        if(relative == null) {
          handleException(new IllegalArgumentException(NO_RELATIVE_EMSG));
        }
        Relations relations = getRelations();
        // Relation might have been shared so copy it to make update possible.
        Relation relation = (Relation) relations.get(relative).clone();
        relation.setLocalMaximumSeverity(severity);
        relations.put(relative, relation);
        calculateEffectiveSeverity(relative);
      } else {
        setEffectiveSeverity(relative, severity);
      }
    }
  }


  /**
   * @param relative
   * @deprecated
   */
  void setMaximumSeverity(LogController relative) {
    synchronized(getClass()) {
      LogController parent = getParentInt();
      if(isInheritFromParent() && parent != null) {
        if(relative == null) {
          handleException(new IllegalArgumentException(NO_RELATIVE_EMSG));
        }
        Relations relations = getRelations();
        // Relation might have been shared so copy it to make update possible.
        Relation relation = (Relation) relations.get(relative).clone();
        relation.setLocalMaximumSeverity();
        relations.put(relative, relation);
        calculateEffectiveSeverity(relative);
      }
    }
  }


  boolean beLogged(LogRecord rec) {
    int severity = rec.getSeverity();
    return beLogged(severity) && isFiltersAgreeing(rec);
  }


  //==== < default ===================================== private > ====


  private void initializeSeverities() {
    synchronized(getClass()) {
      // First propagate effective severity to this controller.
      calculateEffectiveSeverityInt();

      // Then propagate relational severities to this controller.
      LogController parent = getParentInt();

      if(parent != null && isInheritFromParent()) {
        // As this method works across several objects, first lock the class
        // object itself in order to avoid deadlocks.
        for(Iterator iter = parent.getRelations().entrySet().iterator(); iter.hasNext();) {
          Map.Entry entry = (Map.Entry) iter.next();

          Relation relation;
          Relation parentRelation = (Relation) entry.getValue();

          if(parentRelation.getMinimumSeverity() == Severity.ALL
            && parentRelation.getMaximumSeverity() == Severity.NONE) {
            // Share the parent relation if parent relation has standard
            // settings.
            relation = parentRelation;
          } else {
            relation = new Relation();
            relation.calculateEffectiveSeverity(parentRelation.getEffectiveSeverity());
          }

          getRelations().put((LogController) entry.getKey(), relation);
        }

        // Child inherited all relation severities from parent so the minimum
        // effective severity also stays the same.
        minEffRelationSeverity = parent.minEffRelationSeverity;

        // Then propagate severities of other controllers in relation to this
        // controller.
        for(Iterator iter = parent.getRegarders().iterator(); iter.hasNext();) {
          LogController regarder = (LogController) iter.next();
          Relations regarderRelations = regarder.getRelations();
          Relation regarderRelation = new Relation();

          // First calculate the minimum and maximum severities for the
          // relative log controller.
          Relation regarderParentRelation = regarderRelations.get(parent);

          regarderRelation.calculateMinimumSeverity(regarderParentRelation
            .getMinimumSeverity());
          regarderRelation.calculateMaximumSeverity(regarderParentRelation
            .getMaximumSeverity());

          // Then calculate the effective severity of the regarder in
          // relation to this log controller from the effective severity of
          // the parent controller in relation to the relative log
          // controller and the calculated minimum and maximum severities.
          LogController parentRegarder = regarder.getParentInt();

          if(parentRegarder != null) {
            // The topological sorting of the regarder collection
            // guarantees that the relation of the parent of the current
            // regarder in relation to this controller has already been
            // computed.
            Relation parentRegarderRelation = parentRegarder.getRelations().get(this);

            int parentRegarderMinSeverity = parentRegarderRelation.getMinimumSeverity(), parentRegarderMaxSeverity = parentRegarderRelation
              .getMaximumSeverity();

            if((parentRegarderMinSeverity == Severity.ALL && regarderRelation
              .getMinimumSeverity() == parentRegarderMinSeverity)
              && (parentRegarderMaxSeverity == Severity.NONE && regarderRelation
                .getMaximumSeverity() == parentRegarderMaxSeverity)) {
              // Share the parent relation if both relations have standard
              // settings.
              regarderRelation = parentRegarderRelation;
            } else {
              regarderRelation.calculateEffectiveSeverity(parentRegarderRelation
                .getEffectiveSeverity());
            }
          } else {
            // Take severity from parent
            regarderRelation.calculateEffectiveSeverity(regarderParentRelation
              .getEffectiveSeverity());
          }
          regarderRelations.put(this, regarderRelation);
        }
      }
    }
  }


  private void calculateEffectiveSeverity() {
    synchronized(getClass()) {
      if(isChanged()) {
        calculateEffectiveSeverityInt();
      }
    }
  }


  private void calculateEffectiveSeverityInt() {
    LogController parent = getParentInt();
    if(parent != null && isInheritFromParent()) {
      int parentSeverity = parent.getEffectiveSeverity();
      if(parentSeverity < minSeverity) {
        effSeverity = minSeverity;
      } else if(maxSeverity < parentSeverity) {
        effSeverity = maxSeverity;
      } else {
        effSeverity = parentSeverity;
      }
    }

    // Propagate changes to all children.
    if(isCopyToSubtree()) {
      for(LogController lc: getChildrenInt()) {
        lc.calculateEffectiveSeverityInt();
      }
    }
  }


  private void calculateEffectiveSeverity(LogController relative) {
    synchronized(getClass()) {
      if(getRelations().get(relative).isUnchanged()) {
        return;
      }
      calculateEffectiveSeverityInt(relative);
    }
  }


  private void calculateEffectiveSeverityInt(LogController relative) {
    Relations relations = getRelations();

    // Relation might have been shared so copy it to make update possible.
    Relation relation = (Relation) relations.get(relative).clone();
    int prevEffSeverity = relation.getEffectiveSeverity();

    // First calculate the minimum and maximum severities for the relative
    // log controller.
    LogController parentRelative = relative.getParentInt();
    Relation parentRelativeRelation = relations.get(parentRelative);

    if(parentRelative != null) {
      relation.calculateMinimumSeverity(parentRelativeRelation.getMinimumSeverity());
      relation.calculateMaximumSeverity(parentRelativeRelation.getMaximumSeverity());
    } else {
      relation.calculateMinimumSeverity(relation.getLocalMinimumSeverity());
      relation.calculateMaximumSeverity(relation.getLocalMaximumSeverity());
    }

    // Then calculate the effective severity of this log controller in
    // relation to the relative log controller from the effective severity
    // of the parent controller in relation to the relative log controller
    // and the calculated minimum and maximum severities.
    LogController parent = getParentInt();

    if(parent != null && isInheritFromParent()) {
      Relation parentRelation = parent.getRelations().get(relative);

      int parentMinSeverity = parentRelation.getMinimumSeverity(), parentMaxSeverity = parentRelation
        .getMaximumSeverity();

      if((parentMinSeverity == Severity.ALL && relation.getMinimumSeverity() == parentMinSeverity)
        && (parentMaxSeverity == Severity.NONE && relation.getMaximumSeverity() == parentMaxSeverity)) {
        // Share the parent relation if both relations have standard settings.
        relation = parentRelation;
      } else {
        relation.calculateEffectiveSeverity(parentRelation.getEffectiveSeverity());
      }
    } else {
      relation.calculateEffectiveSeverity(parentRelativeRelation.getEffectiveSeverity());
    }
    relations.put(relative, relation);

    // Update cache for minimum relation severity.
    int effSeverity = relation.getEffectiveSeverity();

    // Check whether minimum is calculatable immediately. This is the case if
    // either the new effective severity is smaller than the previous minimum,
    // or the minimum cannot change because the effective severity is either the
    // same as the minimum or it is higher and the previous effective severity
    // was not determining the previous minimum.
    if(effSeverity < minEffRelationSeverity) {
      minEffRelationSeverity = effSeverity;
    } else if(!(effSeverity == minEffRelationSeverity || minEffRelationSeverity < prevEffSeverity)) {
      // Otherwise iterate to calculate caches from scratch.
      Iterator iter = getRelations().values().iterator();

      minEffRelationSeverity = Severity.NONE;
      while(iter.hasNext()) {
        effSeverity = ((Relation) iter.next()).getEffectiveSeverity();
        if(effSeverity < minEffRelationSeverity) {
          minEffRelationSeverity = effSeverity;
        }
      }
    }

    // Propagate changes to all children.
    if(isCopyToSubtree()) {
      for(Iterator iter = getChildrenInt().iterator(); iter.hasNext();) {
        ((LogController) iter.next()).calculateEffectiveSeverityInt(relative);
      }
    }

    // Propagate changes to all children of the relative controller.
    if(relative.isCopyToSubtree()) {
      for(Iterator iter = relative.getChildrenInt().iterator(); iter.hasNext();) {
        calculateEffectiveSeverityInt((LogController) iter.next());
      }
    }
  }


  /**
   * Checks whether severity values have changed since last call to this method.
   * If values are unchanged, the propagation to children controllers is
   * skipped. Above all, this is important to avoid cost when reading mostly
   * unchanged configuration data.
   * @return Values unchanged since last call
   */
  private boolean isChanged() {
    if(!isCopyToSubtree()) {
      if(minSeverity == prevMinSeverity && maxSeverity == prevMaxSeverity) {
        return false;
      }
    }
    prevMinSeverity = minSeverity;
    prevMaxSeverity = maxSeverity;
    return true;
  }


  // Get values from argument Object list 
  // and put them to the String array
  private Object[] checkArguments(Object[] args) {

    Object[] argValues = args;

    if(argValues != null) {
      for(int i = 0; i < argValues.length; ++i) {
        if(argValues[i] == null) {
          argValues[i] = NULL_STRING;
        }
      }
    }
    return argValues;
  }

  public static String replaceArguments(String message, Object[] args) {
    if ((args == null) || (message == null)) {
      return message;
    }
    StringBuilder messageBuilder = new StringBuilder(message);
    int ind = 0;
    for (Object o : args) {
      int ii = messageBuilder.indexOf("{" + ind + "}");
      if (ii >= 0) {
        messageBuilder.replace(ii, ii + 3, (o==null)?"null":o.toString());
      }
      ind++;
    }
    return messageBuilder.toString();
  }
  
  public static String replaceException(LogRecord rec, String msg) {
		int exceptionIndex = rec.getArgObjs().size() - 1; 
  	Object exception = rec.getArgObjs().get(exceptionIndex);
  	
  	// replace last placeholder with the appropriate index with the actual exception
  	int replaceIndex = msg.lastIndexOf("{" + exceptionIndex + "}");
  	if (replaceIndex > 0) {
  		StringBuilder formatException = new StringBuilder(msg);
  		formatException.replace(replaceIndex, replaceIndex + 3, 
  				(exception == null) ? "null" : exception.toString());
  		msg = formatException.toString();
  	}
  	
  	return msg;
  }
  
  protected int typeOfMessage(Object args[]) {
    return ((args == null) ? MsgType.PLAIN : MsgType.JAVA);
  }

  //Copy relatives from source (this LC) to target (relatives[i])
  private LogController[] copyRelatives(LogController logLC, LogController[] relatives) {

    LogController[] tmpRelatives = new LogController[relatives.length];

    for(int i = 0; i < relatives.length; ++i) {
      if(relatives[i] != logLC) {
        tmpRelatives[i] = relatives[i];
      } else {
        tmpRelatives[i] = this;
      }
    }
    return tmpRelatives;
  }

  private LogRecord writeToLogs(Collection logs, LogRecord rec) throws Exception {

    LogRecord writtenRec = null;
    Iterator iter = logs.iterator();

    while(iter.hasNext()) {
      Log log = (Log) iter.next();
      if(log.beLogged(rec)) {
        writtenRec = log.writeInternalByAPI(rec);
      }
    }
    return writtenRec;
  }


  private LogRecord writeToLocalLogs(Map logs, LogRecord rec) throws Exception {

    LogRecord writtenRec = null;
    Iterator iter = logs.entrySet().iterator();

    while(iter.hasNext()) {

      Map.Entry entry = (Map.Entry) iter.next();
      Log log = (Log) entry.getKey();
      LogController lc = (LogController) entry.getValue();

      if(!lc.equals(this)) {
        if(lc.beLogged(rec)) {
          writtenRec = log.writeInternalByAPI(rec);
        }
      }
    }
    return writtenRec;
  }


  private void initializeLogs() {

    //Copy parent logs ... NORMAL, LOCAL

    LogController parent = getParentInt();

    // Normall logs
    if(parent != null) {
      Iterator iter = parent.getLogs().iterator();
      while(iter.hasNext()) {
        Log log = (Log) iter.next();
        addLogNormalInt(log);
      }
    }

    //  Local logs
    if(parent != null) {
      Iterator iter = parent.getLocalLogsMap().entrySet().iterator();
      while(iter.hasNext()) {
        Map.Entry entry = (Map.Entry) iter.next();
        Log log = (Log) entry.getKey();
        LogController lc = (LogController) entry.getValue();
        addLogLocalInt(lc, log);
      }
    }
  }


  private boolean isLogInRegistry(Log log) {
    if (logsRegistry == null) {
        return false;
    }
    return logsRegistry.contains(log);
  }


  private synchronized void addLogToRegistry(Log log) {
    if (logsRegistry == null) {
        logsRegistry = new HashSet<Log>();
    }
    if(!logsRegistry.contains(log)) {
      // Keep logs collection immutable to avoid reader synchronization.
      Collection<Log> newLogs = new HashSet<Log>(logsRegistry);
      newLogs.add(log);
      logsRegistry = newLogs;
    }
  }


  private synchronized void removeLogFromRegistry(Log log) {
    if (logsRegistry == null) {
        return;        
    }
    if(logsRegistry.contains(log)) {
      // First close the Log
      log.close();

      // Keep logs collection immutable to avoid reader synchronization.
      Collection<Log> newLogs = new HashSet<Log>(logsRegistry);
      newLogs.remove(log);
      logsRegistry = newLogs;

      // Remove LC from owner's list
      log.removeOwner(this.getName());
    }
  }


  private synchronized boolean addLogNormalInt(Log log) {
    if (logsNormal == null) {
      logsNormal = new HashSet<Log>();
    }
    if(!logsNormal.contains(log)) {
      // Keep logs collection immutable to avoid reader synchronization.
      Collection<Log> newLogs = new HashSet<Log>(logsNormal);
      newLogs.add(log);
      logsNormal = newLogs;

      // Registry 
      addLogToRegistry(log);
      // Save owner of Log
      log.addOwner(this.getName());

      // Propagate log to children to reduce cost of message writing.
//      if(isCopyToSubtree()) {
        for(LogController lc: getChildrenInt()) {
          lc.addLogNormalInt(log);
        }
//      }
      return true;
    }
    return false;
  }


  private synchronized boolean addLogLocalInt(LogController parent, Log log) {
    if (logsLocal == null) {
      logsLocal = new HashMap<Log, LogController>();
    }
    if(!logsLocal.containsValue(log)) {
      // Keep logs collection immutable to avoid reader synchronization.
      Map<Log, LogController> newLogs = new HashMap<Log, LogController>(logsLocal);
      newLogs.put(log, parent);
      logsLocal = newLogs;

      // Registry 
      addLogToRegistry(log);
      // Save owner of Log
      log.addOwner(this.getName());

      // Propagate log to children to reduce cost of message writing.
//      if(isCopyToSubtree()) {
        for(Iterator iter = getChildrenInt().iterator(); iter.hasNext();) {
          ((LogController) iter.next()).addLogLocalInt(parent, log);
        }
//      }
      return true;
    }
    return false;
  }


  private synchronized boolean addLogPrivateInt(Log log) {
    if (logsPrivate == null) {
      logsPrivate = new HashSet<Log>();
    }
    if(!logsPrivate.contains(log)) {
      // Keep logs collection immutable to avoid reader synchronization.
      Collection<Log> newLogs = new HashSet<Log>(logsPrivate);
      newLogs.add(log);
      logsPrivate = newLogs;

      // Registry 
      addLogToRegistry(log);
      // Save owner of Log
      log.addOwner(this.getName());

      return true;
    }
    return false;
  }


  private void removeLogsNormalInt() {
    if (logsNormal == null) {
      return;
    }
    Log[] aLogs;
    // Normal logs
    synchronized(this.logsNormal) {
      aLogs = (Log[]) this.logsNormal.toArray(new Log[this.logsNormal.size()]);
    }
    for(int i = 0; i < aLogs.length; ++i) {
      removeLogNormalInt(aLogs[i]);
      LoggingManager.getLoggingManager().notifyRemoveLog(aLogs[i]);
    }
  }


  private void removeLogsLocalInt() {
    if (logsLocal == null) {
      return;
    }
    Log[] aLogs;
    // Private logs
    synchronized(logsLocal) {
      aLogs = (Log[]) logsLocal.keySet().toArray(new Log[logsLocal.size()]);
    }
    for(int i = 0; i < aLogs.length; ++i) {
      removeLogLocalInt(aLogs[i]);
      LoggingManager.getLoggingManager().notifyRemoveLog(aLogs[i]);
    }
  }


  private void removeLogsPrivateInt() {
    if (logsPrivate == null) {
      return;
    }
    Log[] aLogs;
    // Private logs
    synchronized(logsPrivate) {
      aLogs = (Log[]) logsPrivate.toArray(new Log[logsPrivate.size()]);
    }
    for(int i = 0; i < aLogs.length; ++i) {
      removeLogPrivateInt(aLogs[i]);
      LoggingManager.getLoggingManager().notifyRemoveLog(aLogs[i]);
    }
  }


  private synchronized void removeLogNormalInt(Log log) {
    if (logsNormal == null) {
      return;
    }
    if(logsNormal.contains(log)) {
      // Keep logs collection immutable to avoid reader synchronization.
      Collection<Log> newLogs = new HashSet<Log>(logsNormal);
      newLogs.remove(log);
      logsNormal = newLogs;

      removeLogFromRegistry(log);

      Iterator iter = getChildrenInt().iterator();
      while(iter.hasNext()) {
        ((LogController) iter.next()).removeLogNormalInt(log);
      }
    }
  }


  private synchronized void removeLogLocalInt(Log log) {
    if (logsLocal == null) {
      return;
    }
    if(logsLocal.containsKey(log)) {
      // Keep logs collection immutable to avoid reader synchronization.
      Map<Log, LogController> newLogs = new HashMap<Log, LogController>(logsLocal);
      newLogs.remove(log);
      logsLocal = newLogs;

      removeLogFromRegistry(log);

      Iterator iter = getChildrenInt().iterator();
      while(iter.hasNext()) {
        ((LogController) iter.next()).removeLogLocalInt(log);
      }
    }
  }


  private synchronized void removeLogPrivateInt(Log log) {
    if (logsPrivate == null) {
      return;
    }
    if(logsPrivate.contains(log)) {
      // Keep logs collection immutable to avoid reader synchronization.
      Collection<Log> newLogs = new HashSet<Log>(logsPrivate);
      newLogs.remove(log);
      logsPrivate = newLogs;

      removeLogFromRegistry(log);
    }
  }


  private boolean check(LogController relative) {
    if(relative != null) {
      return true;
    } else {
      handleException(new IllegalArgumentException(NO_RELATIVE_EMSG));
      return false;
    }
  }


  private boolean check(LogController[] relatives) {
    if(relatives != null) {
      for(int i = 0; i < relatives.length; ++i) {
        if(relatives[i] == null) {
          handleException(new IllegalArgumentException(NO_RELATIVE_EMSG));
          return false;
        }
      }
      return true;
    } else {
      handleException(new IllegalArgumentException(NO_RELATIVES_EMSG));
      return false;
    }
  }

  //==== < private =============================== private class > ====

  private static class Relation implements Cloneable {

    public Object clone() {
      try {
        return super.clone();
      } catch(CloneNotSupportedException exc) {
        // Should never happen.
        return null;
      }
    }


    public int getLocalMinimumSeverity() {
      return localMinSeverity;
    }


    public int getMinimumSeverity() {
      return minSeverity;
    }


    public int getEffectiveSeverity() {
      return effSeverity;
    }


    public int getLocalMaximumSeverity() {
      return localMaxSeverity;
    }


    public int getMaximumSeverity() {
      return maxSeverity;
    }


    public synchronized void setLocalMinimumSeverity(int severity) {
      localMinSeverity = severity;
      if(localMinSeverity > localMaxSeverity) {
        localMaxSeverity = localMinSeverity;
      }
    }


    public void setLocalMinimumSeverity() {
      localMinSeverity = Severity.ALL;
    }


    public synchronized void calculateMinimumSeverity(int parentSeverity) {
      if(parentSeverity < localMinSeverity) {
        minSeverity = localMinSeverity;
      } else if(localMaxSeverity < parentSeverity) {
        minSeverity = localMaxSeverity;
      } else {
        minSeverity = parentSeverity;
      }
    }


    public void setEffectiveSeverity(int severity) {
      effSeverity = severity;
    }


    public void setEffectiveSeverity() {
      localMinSeverity = Severity.ALL;
      localMaxSeverity = Severity.NONE;
    }


    public synchronized void calculateEffectiveSeverity(int parentSeverity) {
      if(parentSeverity < minSeverity) {
        effSeverity = minSeverity;
      } else if(maxSeverity < parentSeverity) {
        effSeverity = maxSeverity;
      } else {
        effSeverity = parentSeverity;
      }
    }


    public synchronized void setLocalMaximumSeverity(int severity) {
      localMaxSeverity = severity;
      if(localMinSeverity > localMaxSeverity) {
        localMinSeverity = localMaxSeverity;
      }
    }


    public void setLocalMaximumSeverity() {
      localMaxSeverity = Severity.NONE;
    }


    public synchronized void calculateMaximumSeverity(int parentSeverity) {
      if(localMaxSeverity < parentSeverity) {
        maxSeverity = localMaxSeverity;
      } else if(parentSeverity < localMinSeverity) {
        maxSeverity = localMinSeverity;
      } else {
        maxSeverity = parentSeverity;
      }
    }


    /**
     * Checks whether severity values have changed since last call to this method.
     * If values are unchanged, the propagation to children controllers is
     * skipped. Above all, this is important to avoid cost when reading mostly
     * unchanged configuration data.
     * @return Values unchanged since last call
     */
    public synchronized boolean isUnchanged() {
      if(localMinSeverity == prevLocalMinSeverity
        && localMaxSeverity == prevLocalMaxSeverity) {
        return true;
      } else {
        prevLocalMinSeverity = localMinSeverity;
        prevLocalMaxSeverity = localMaxSeverity;
        return false;
      }
    }

    public volatile int localMinSeverity = Severity.ALL, minSeverity = Severity.ALL,
        localMaxSeverity = Severity.NONE, maxSeverity = Severity.NONE,
        effSeverity = Severity.NONE;

    // Previous severity values.
    // If values are unchanged, the propagation to children controllers is
    // skipped. Above all, this is important to avoid cost when reading mostly
    // unchanged configuration data.
    private volatile int prevLocalMinSeverity = Severity.ALL,
        prevLocalMaxSeverity = Severity.NONE;
  }

  private static final Relation standardRelation = new Relation();

  private class Relations {

    private HashMap<LogController, Relation> relations = new HashMap<LogController, Relation>();

    public Relations() {
    }

    public Relation get(LogController relative) {
      Relation relation;

      // Cache get would go here: relation = cache.get(relative);
      synchronized(relations) {
        relation = (Relation) relations.get(relative);
      }
      if(relation == null) {
        relation = standardRelation;
      }
      // Cache put would go here: cache.put(relative, relation);
      return relation;
    }

    public void put(LogController relative, Relation relation) {
      if(!relation.equals(standardRelation)) {
        synchronized(relations) {
          relations.put(relative, relation);
        }
        // Put this controller into the regarders collection of relative.
        relative.getRegarders().put(LogController.this);
      } else {
        // Forget duplicate relation with standard values
        // In case of cache: relation = standardRelation;
        synchronized(relations) {
          relations.remove(relative);
        }

        // Forget controller in regarders collection of relative. It need not
        // be taken into account when a log controller is made because the
        // latter is also going to get the standard relation, which is forgotten
        // afterwards.
        relative.getRegarders().remove(LogController.this);
      }
      // Cache put would go here: cache.put(relative, relation);
    }

    public Set entrySet() {
      return relations.entrySet();
    }

    public Collection values() {
      return relations.values();
    }
  }

  private static class Regarders {

    public void put(LogController regarder) {
      if(!contained.contains(regarder)) {
        LogController parent = regarder.getParentInt();

        // Because the standard relation is not present in the relations
        // collection the parent of the regarder need not be in the regarders
        // collection but any of its direct or indirect parents can. Therefore
        // the nearest parent of the regarder is looked up to find the correct
        // insertion point.
        while(parent != null && !contained.contains(parent)) {
          parent = parent.getParentInt();
        }

        if(parent != null) {
          for(ListIterator<LogController> iter = ordered.listIterator(); iter.hasNext();) {
            if(iter.next() == parent) {
              iter.add(regarder);
              break;
            }
          }
        } else {
          ordered.addFirst(regarder);
        }
        contained.add(regarder);
      }
    }


    public void remove(LogController regarder) {
      if(contained.contains(regarder)) {
        ordered.remove(regarder);
        contained.remove(regarder);
      }
    }


    public boolean isEmpty() {
      return ordered.isEmpty();
    }


    public LogController getFirst() {
      return (LogController) ordered.getFirst();
    }


    public Iterator iterator() {
      return ordered.iterator();
    }

    private LinkedList<LogController> ordered = new LinkedList<LogController>();
    private HashSet<LogController> contained = new HashSet<LogController>();
  }

  //==== < private class ============================ deprecated > ====

  /**
   * @deprecated Use messageInternal()
   */
  protected LogRecord messageInt(LogRecord rec) {
    LogRecord writtenRec = null;
    try {
      writtenRec = messageInternal(rec);
    } catch(Exception ex) {
    }
    return writtenRec;
  }


  /**
   * @return Returns the copyToSubtree.
   */
  public boolean isCopyToSubtree() {
    return copyToSubtree;
  }


  /**
   * @param copyToSubtree The copyToSubtree to set.
   */
  public void setCopyToSubtree(boolean copyToSubtree) {
    this.copyToSubtree = copyToSubtree;
    if(copyToSubtree) {
      synchronized(getClass()) {
        setInheritFromParent(getChildrenInt(), true);
        setCopyToSubtree(getChildrenInt(), true);
        for(LogController lc: getChildrenInt()) {
          lc.calculateEffectiveSeverityInt();
        }
      }
    } else {
      inheritFromParent = copyToSubtree;
      synchronized(getClass()) {
          setInheritFromParent(getChildrenInt(), false);
          for(LogController lc: getChildrenInt()) {
            lc.calculateEffectiveSeverityInt();
          }
        }      
    }
  }

  
  private void setInheritFromParent(Collection<LogController> children, boolean inherit) {
    for(LogController lc: children) {
      lc.setInheritFromParent(inherit);
      lc.maxSeverity = effSeverity;
      lc.minSeverity = effSeverity;
      setInheritFromParent(lc.getChildren(), inherit);
    }
  }
  

  private void setCopyToSubtree(Collection<LogController> children, boolean copyToSubtree) {
    for(LogController lc: children) {
      lc.setCopyToSubtreeProperty(copyToSubtree);
      setCopyToSubtree(lc.getChildren(), copyToSubtree);
    }
  }

  /**
   * @return Returns the inheritFromParent.
   */
  public boolean isInheritFromParent() {
    return inheritFromParent;
  }


  /**
   * @param inheritFromParent The inheritFromParent to set.
   */
  private void setInheritFromParent(boolean inheritFromParent) {
    this.inheritFromParent = inheritFromParent;
//    this.copyToSubtree = inheritFromParent;
  }
  
  private void setCopyToSubtreeProperty(boolean copyToSubtree) {
    this.copyToSubtree = copyToSubtree;
  }
  
  public static void resetSeverityCounters() {
      for (int i = 0; i < SEVERITIES_USED.length; i++) {
          SEVERITIES_USED[i] = 0;
      }
  }
  
  public static long getDebugCounter() {
      return SEVERITIES_USED[0];
  }

  public static long getPathCounter() {
      return SEVERITIES_USED[1];
  }
  
  public static long getInfoCounter() {
      return SEVERITIES_USED[2];
  }  
  
  public static long getWarningCounter() {
      return SEVERITIES_USED[3];
  }  
  
  public static long getErrorCounter() {
      return SEVERITIES_USED[4];
  }
  
  public static long getFatalCounter() {
      return SEVERITIES_USED[5];
  }
  
  /**
   * 
   * @return count of the logs/traces that have been issued
   *         since last reset with resetSeverityCounters() method 
   */
  public static long getTotalLogsCount() {
      return getDebugCounter() + getPathCounter()
             + getInfoCounter() + getWarningCounter()
             + getErrorCounter() + getFatalCounter();
  }
  
}
