package com.sap.tc.logging;

/**
 * Title: Logging Description: Logging API Copyright: Copyright (c) 2003 Company: SAP AG.
 * Walldorf, Germany All rights reserved. This software is the confidential and
 * proprietary information of SAP AG. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP AG.
 * 
 * @version $Id: $
 */

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import com.sap.tc.logging.interfaces.IClassLoadRuntimeInfoProvider;
import com.sap.tc.logging.interfaces.IDeployRuntimeInfoProvider;
import com.sap.tc.logging.interfaces.IRPPublisher;
import com.sap.tc.logging.interfaces.IThreadRuntimeInfoProvider;

public class LoggingManager extends ExceptionHandling implements EventDispatcher {

  // ================================================ declaration > ====
  private static final String INVALID_LISTENER_TYPE = "Invalid listener type";

  private static LoggingManager manager = null;
  private static IRPPublisher runPropPub = null;
  private static MessageEventListener msgListener = null;
  private static Location classLoc = null;

  private List<EventListener> newLogListeners = new Vector<EventListener>();
  private List<EventListener> removeLogListeners = new Vector<EventListener>();
  private List<EventListener> overwriteLogfileListeners = new Vector<EventListener>(); 
  private List<EventListener> createLogfileListeners = new Vector<EventListener>();
  private List<EventListener> resetLogControllerListener = new Vector<EventListener>(); 
  private List<EventListener> releaseLogListener = new Vector<EventListener>();

  private HashMap<String, Location> locations = new HashMap<String, Location>();
  private HashMap<String, Category> categories = new HashMap<String, Category>();

  public static final Formatter DEFAULT_FORMATTER = new TraceFormatter();
  
  private boolean includeStackTraceForEachRecord = false;

  protected static IClassLoadRuntimeInfoProvider classLoadInfoProvider;
  protected static IThreadRuntimeInfoProvider threadInfoProvider;  
  protected static IDeployRuntimeInfoProvider deployInfoProvider;

  // ==== < declaration ============================ constructors > ====

  private LoggingManager() {
  }


  // ==== < constructors =============================== abstarct > ====
  // ==== < abstract ===================================== public > ====

  public synchronized static LoggingManager getLoggingManager() {
    if(manager == null) { // singleton
      manager = new LoggingManager();

      // Get internal log categories and trace locations in order to avoid
      // lock amplification from reader to writer lock because of sudden new
      // controller. Lock amplification causes a sort of deadlock of the
      // current thread with itself.
      init();
    }
    return manager;
  }


  /**
   * To add a publisher of the runtime properies
   * 
   * @param IRPPublisher Instance of Runtime properties publisher
   */
  public static void registerRuntimePropertiesPublisher(IRPPublisher runPropPublisher) {
    runPropPub = runPropPublisher;
  }


  /**
   * To add a listener to the logging tool
   * 
   * @param listener The event listener to be added
   * @throws IllegalArgumentException Invalid listener type. Current valid types:
   *           NewLogListener, RemoveLogListener, OverwriteLogfileListener,
   *           CreateLogfileListener, ResetLogControllerListener.
   */
  public void addListener(EventListener listener) throws IllegalArgumentException {
    boolean isFounded = false;
    if(listener instanceof NewLogListener) {
      synchronized(newLogListeners) {
        this.newLogListeners.add(listener);
      }
      isFounded = true;
      // this new listener should be aware of the already existing logs
      Collection existingLogs = getAllLogs();
      if(existingLogs != null) {
        Iterator logIter = existingLogs.iterator();
        while(logIter.hasNext()) {
          try {
            Log _log = (Log) logIter.next();
            if(!(_log instanceof ConsoleLog)) {
              ((NewLogListener) listener).handleEvent(new NewLogEvent(_log));
            }
          } catch(Exception ex) {
            Category.SYS_LOGGING.logIntByAPI(Severity.WARNING, classLoc,
              "[addListener(EventListener listener)]",
              MSGCollection.LOGGING_MSG_ID_UNEXPECTED,
              MSGCollection.LOGGING_MSG_STR_UNEXPECTED,
              new String[] {"Implementation of the NewLogListener"});
            Category.SYS_LOGGING.catchingIntByAPI(ex);
            handleException(ex, ExceptionManager.ERR_UNKNOWN);
          }
        }
      }
    }
    if(listener instanceof RemoveLogListener) {
      synchronized(removeLogListeners) {
        this.removeLogListeners.add(listener);
      }
      isFounded = true;
    }
    if(listener instanceof OverwriteLogfileListener) {
      synchronized(overwriteLogfileListeners) {
        this.overwriteLogfileListeners.add(listener);
      }
      isFounded = true;
    }
    if(listener instanceof CreateLogfileListener) {
      synchronized(createLogfileListeners) {
        this.createLogfileListeners.add(listener);
      }
      isFounded = true;
    }
    if(listener instanceof ResetLogControllerListener) {
      synchronized(resetLogControllerListener) {
        this.resetLogControllerListener.add(listener);
      }
      isFounded = true;
    }
    if(listener instanceof ReleaseLogListener) {
      synchronized(releaseLogListener) {
        this.releaseLogListener.add(listener);
      }
      isFounded = true;
    }
    if(listener instanceof MessageEventListener) {
      synchronized(this) {
        msgListener = (MessageEventListener) listener;
      }
      isFounded = true;
    }
    if(!isFounded) {
      throw new IllegalArgumentException(INVALID_LISTENER_TYPE + " : "
        + listener.getClass());
    }
  }


  /**
   * To remove a listener from the logging tool. If the listener does not exist at all, do
   * nothing.
   * 
   * @param listener The event listener to be removed
   * @throws IllegalArgumentException Invalid listener type Current valid types:
   *           NewLogListener, RemoveLogListener, OverwriteLogfileListener,
   *           CreateLogfileListener, ResetLogControllerListener.
   */
  public void removeListener(EventListener listener) throws IllegalArgumentException {
    boolean isFounded = false;
    if(listener instanceof NewLogListener) {
      synchronized(newLogListeners) {
        this.newLogListeners.remove(listener);
      }
      isFounded = true;
    }
    if(listener instanceof RemoveLogListener) {
      synchronized(removeLogListeners) {
        this.removeLogListeners.remove(listener);
      }
      isFounded = true;
    }
    if(listener instanceof OverwriteLogfileListener) {
      synchronized(overwriteLogfileListeners) {
        this.overwriteLogfileListeners.remove(listener);
      }
      isFounded = true;
    }
    if(listener instanceof CreateLogfileListener) {
      synchronized(createLogfileListeners) {
        this.createLogfileListeners.remove(listener);
      }
      isFounded = true;
    }
    if(listener instanceof ResetLogControllerListener) {
      synchronized(resetLogControllerListener) {
        this.resetLogControllerListener.remove(listener);
      }
      isFounded = true;
    }
    if(listener instanceof ReleaseLogListener) {
      synchronized(releaseLogListener) {
        this.releaseLogListener.remove(listener);
      }
      isFounded = true;
    }
    if(listener instanceof MessageEventListener) {
      synchronized(this) {
        msgListener = null;
      }
      isFounded = true;
    }
    if(!isFounded) {
      throw new IllegalArgumentException(INVALID_LISTENER_TYPE + " : "
        + listener.getClass());
    }
  }


  public Collection getAllLogs() {
    Collection<Log> existingLogs = new HashSet<Log>();
    // Location source
    if(locations != null) {
      Object[] lcs = null;
      synchronized(locations) {
        lcs = locations.values().toArray();
      }
      for(int i = 0; i < lcs.length; i++) {
        existingLogs.addAll(((LogController) lcs[i]).getAllLogs());
      }
    }
    // Categories source
    if(locations != null) {
      Object[] lcs = null;
      synchronized(categories) {
        lcs = categories.values().toArray();
      }
      for(int i = 0; i < lcs.length; i++) {
        existingLogs.addAll(((LogController) lcs[i]).getAllLogs());
      }
    }
    return existingLogs;
  }


  public synchronized void reset() {
    Object[] tmpLC;
    // Locations
    synchronized(locations) {
      locations.clear();
    }
    tmpLC = (Object[]) categories.values().toArray();
    // Categories
    for(int i = 0; i < tmpLC.length; i++) {
      release((LogController) tmpLC[i]);
    }
    init();
  }


  // ==== < public ==================================== protected > ====

  // Notify correspondong listener for message write event
  protected void notifyWriteMessage(LogRecord record) {
    if(msgListener == null) {
      return;
    }
    try {
      if(msgListener.beRead(record)) {
        msgListener.handleEvent(new MessageEvent(record));
      }
    } catch(Exception ex) {
      APILogger.logIntByAPI(Severity.WARNING, classLoc,
        "[notifyWriteMessage(LogRecord record)]",
        MSGCollection.LOGGING_MSG_ID_UNEXPECTED,
        MSGCollection.LOGGING_MSG_STR_UNEXPECTED,
        new String[] {"Implementation of the MessageEventListener"});
      APILogger.catchingIntByAPI(ex);
      handleException(ex, ExceptionManager.ERR_UNKNOWN);
    }
  }


  // Notify correspondong listeners for NEWLOG(readable) event
  protected void notifyAddLog(Log newLog) {
    if(this.newLogListeners.isEmpty()) {
      return;
    }
    if(newLog instanceof ConsoleLog) {
      return;
    }
    Object lsnArray[] = null;
    NewLogEvent evt = new NewLogEvent(newLog);
    synchronized(newLogListeners) {
      lsnArray = this.newLogListeners.toArray();
    }
    for(int i = 0; i < lsnArray.length; i++) {
      try {
        ((NewLogListener) lsnArray[i]).handleEvent(evt);
      } catch(Exception ex) {
        Category.SYS_LOGGING.logIntByAPI(Severity.WARNING, classLoc,
          "[notifyAddLog(Log newLog)]", MSGCollection.LOGGING_MSG_ID_UNEXPECTED,
          MSGCollection.LOGGING_MSG_STR_UNEXPECTED,
          new String[] {"Implementation of the NewLogListener"});
        Category.SYS_LOGGING.catchingIntByAPI(ex);
        handleException(ex, ExceptionManager.ERR_UNKNOWN);
      }
    }
  }


  // Notify correspondong listeners for REMOVELOG event
  protected void notifyRemoveLog(Log removeLog) {
    if(this.removeLogListeners.isEmpty()) {
      return;
    }
    if(removeLog instanceof ConsoleLog) {
      return;
    }
    if(isBeingAttached(removeLog)) {
      return;
    }
    Object lsnArray[] = null;
    RemoveLogEvent evt = new RemoveLogEvent(removeLog);
    synchronized(removeLogListeners) {
      lsnArray = this.removeLogListeners.toArray();
    }
    for(int i = 0; i < lsnArray.length; i++) {
      try {
        ((RemoveLogListener) lsnArray[i]).handleEvent(evt);
      } catch(Exception ex) {
        Category.SYS_LOGGING.logIntByAPI(Severity.WARNING, classLoc,
          "[notifyRemoveLog(Log removeLog)]", MSGCollection.LOGGING_MSG_ID_UNEXPECTED,
          MSGCollection.LOGGING_MSG_STR_UNEXPECTED,
          new String[] {"Implementation of the RemoveLogListener"});
        Category.SYS_LOGGING.catchingIntByAPI(ex);
        handleException(ex, ExceptionManager.ERR_UNKNOWN);
      }
    }
  }


  // Notify correspondong listeners for logfile being overwritten event
  protected void notifyOverwriteLogfile(FileLog fileLog) {
    if(this.overwriteLogfileListeners.isEmpty()) {
      return;
    }
    Object lsnArray[] = null;
    OverwriteLogfileEvent evt = new OverwriteLogfileEvent(fileLog);
    synchronized(overwriteLogfileListeners) {
      lsnArray = this.overwriteLogfileListeners.toArray();
    }
    for(int i = 0; i < lsnArray.length; i++) {
      try {
        ((OverwriteLogfileListener) lsnArray[i]).handleEvent(evt);
      } catch(Exception ex) {
        Category.SYS_LOGGING.logIntByAPI(Severity.WARNING, classLoc,
          "[notifyOverwriteLogfile(String filename, int limit, int cnt)]",
          MSGCollection.LOGGING_MSG_ID_UNEXPECTED,
          MSGCollection.LOGGING_MSG_STR_UNEXPECTED,
          new String[] {"Implementation of the OverwriteLogfileListener"});
        Category.SYS_LOGGING.catchingIntByAPI(ex);
        handleException(ex, ExceptionManager.ERR_UNKNOWN);
      }
    }
  }


  // Notify correspondong listeners for logfile being overwritten event
  protected void notifyReleaseLogfile(FileLog fileLog) {
    if(this.releaseLogListener.isEmpty()) {
      return;
    }
    Object lsnArray[] = null;
    ReleaseLogEvent evt = new ReleaseLogEvent(fileLog);
    synchronized(releaseLogListener) {
      lsnArray = this.releaseLogListener.toArray();
    }
    for(int i = 0; i < lsnArray.length; i++) {
      try {
        ((ReleaseLogListener) lsnArray[i]).handleEvent(evt);
      } catch(Exception ex) {
        Category.SYS_LOGGING.logIntByAPI(Severity.WARNING, classLoc,
          "[notifyReleaseLogfile(String filename, int limit, int cnt)]",
          MSGCollection.LOGGING_MSG_ID_UNEXPECTED,
          MSGCollection.LOGGING_MSG_STR_UNEXPECTED,
          new String[] {"Implementation of the ReleaseLogListener"});
        Category.SYS_LOGGING.catchingIntByAPI(ex);
        handleException(ex, ExceptionManager.ERR_UNKNOWN);
      }
    }
  }


  // Notify correspondong listeners for logfile created event
  protected void notifyCreateLogfile(String filename, int limit, int cnt) {
    if(this.createLogfileListeners.isEmpty()) {
      return;
    }
    Object lsnArray[] = null;
    CreateLogfileEvent evt = new CreateLogfileEvent(filename, limit, cnt);
    synchronized(createLogfileListeners) {
      lsnArray = this.createLogfileListeners.toArray();
    }
    for(int i = 0; i < lsnArray.length; i++) {
      try {
        ((CreateLogfileListener) lsnArray[i]).handleEvent(evt);
      } catch(Exception ex) {
        Category.SYS_LOGGING.logIntByAPI(Severity.WARNING, classLoc,
          "[notifyCreateLogfile(String filename, int limit, int cnt)]",
          MSGCollection.LOGGING_MSG_ID_UNEXPECTED,
          MSGCollection.LOGGING_MSG_STR_UNEXPECTED,
          new String[] {"Implementation of the CreateLogfileListener"});
        Category.SYS_LOGGING.catchingIntByAPI(ex);
        handleException(ex, ExceptionManager.ERR_UNKNOWN);
      }
    }
  }


  // Notify correspondong listeners for LogController reset event
  protected void notifyLogControllerReset(LogController logController, boolean isResetTree) {
    if(this.resetLogControllerListener.isEmpty()) {
      return;
    }
    Object lsnArray[] = null;
    synchronized(resetLogControllerListener) {
      lsnArray = this.resetLogControllerListener.toArray();
    }
    for(int i = 0; i < lsnArray.length; i++) {
      try {
        ((ResetLogControllerListener) lsnArray[i])
          .handleEvent(logController, isResetTree);
      } catch(Exception ex) {
        Category.SYS_LOGGING.logIntByAPI(Severity.WARNING, classLoc,
          "[notifyLogControllerReset(LogController logController, boolean isResetTree)]",
          MSGCollection.LOGGING_MSG_ID_UNEXPECTED,
          MSGCollection.LOGGING_MSG_STR_UNEXPECTED,
          new String[] {"Implementation of the ResetLogControllerListener"});
        Category.SYS_LOGGING.catchingIntByAPI(ex);
        handleException(ex, ExceptionManager.ERR_UNKNOWN);
      }
    }
  }

  // ==== < protected =================================== default > ====

  static IRPPublisher getRuntimePropertiesPublisher() {
    return runPropPub;
  }


  static MessageEventListener getMessageEventListener() {
    return msgListener;
  }


  Location getLocation(String name) {
    return getLocation(name, name);
  }


  Category getCategory(String name) {
    return getCategory(name, name);
  }


  void release(LogController controller) {
    if(controller instanceof Location) {
      synchronized(locations) {
        locations.remove(controller.getName());
      }
    } else { // if (controller instanceof Category)
      if(!isPredefCategory(controller.getName())) {
        synchronized(categories) {
          categories.remove(controller.getName());
        }
      }
    }
  }

  // ==== < default ===================================== private > ====

  private boolean isPredefCategory(String name) {
    return Category.PREDEF_CATEGORIES.containsKey(name);
  }


  private static void init() {
    classLoc = Location.getLocation(LoggingManager.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
    Location.getLocation("com.sap.tc.logging.Category", "tc~logging~java", "BC-JAS-ADM-LOG-API");
    Location.getLocation(Configurator.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
    Location.getLocation(ConsoleLog.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
    Location.getLocation(FileLog.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
    Location.getLocation(Formatter.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
    Location.getLocation(GUId.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
    Location.getLocation(ListFormatter.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
    Location.getLocation(Location.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
    Location.getLocation(Log.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
    Location.getLocation(LogController.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
    Location.getLocation(LogRecord.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
    Location.getLocation(MsgType.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
    Location.getLocation(PropertiesConfigurator.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
    Location.getLocation(Severity.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
    Location.getLocation(StreamLog.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
    Location.getLocation(TraceFormatter.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
    Location.getLocation(XMLFormatter.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
  }


  private Location getLocation(String locFullName, String nameTokens) {
	    try {
	      String name = nameTokens;
	      Location loc = (Location) locations.get(name);

	      if(loc == null) {
	        if(nameTokens.indexOf(Location.SEPARATOR) == -1) {
	          if (nameTokens.length() == 0) {
	        	  loc = new Location(name);
	          } else {
		          nameTokens = "";
		          Location parent = getLocation(name, nameTokens);
		          loc = new Location(name, parent);
	          }
	        } else {
	          nameTokens = nameTokens.substring(0, nameTokens.lastIndexOf(Location.SEPARATOR));
	          Location parent = getLocation(name, nameTokens);
	          loc = new Location(name, parent);
	        }
	        synchronized(locations) {
	          locations.put(name, loc);
	        }
	      }
	      return loc;
	    } catch(Exception ex) {
	      throw new IllegalArgumentException("Location : " + locFullName);
	    }
  }

  private Category getCategory(String catFullName, String nameTokens) {
	    try {
	      String name = nameTokens;
	      Category category = (Category) categories.get(name);
	      if(category == null) {
            int lastIndex = nameTokens.lastIndexOf(Category.SEPARATOR);
	        if(nameTokens.indexOf(Category.SEPARATOR) == lastIndex) {
	        	if (nameTokens.length() == 1 && nameTokens.charAt(0) == Category.SEPARATOR) {
	        		category = new Category(name);	
	        	} else {
	        		nameTokens = Category.ROOT_NAME;
	        		category = new Category(name, getCategory(name, nameTokens));
	        	}
	        } else {
	        	nameTokens = nameTokens.substring(0, lastIndex);
	            category = new Category(name, getCategory(name, nameTokens));
	        }
	        synchronized(categories) {
	          categories.put(name, category);
	        }
	      }
	      return category;
	    } catch(Exception ex) {
	    	throw new IllegalArgumentException("Category : " + catFullName);
	    }
  }  

  protected boolean isBeingAttached(Log aLog) {
    return getAllLogs().contains(aLog);
  }


  // ==== < private ================================== deprecated > ====

  static Category getLog() {
    return Category.SYS_LOGGING;
  }
  
  public void setIncludeStackTraceForEachRecord(boolean aIncludeStackTraceForEachRecord) {
      this.includeStackTraceForEachRecord = aIncludeStackTraceForEachRecord;
  }
  
  public boolean getIncludeStackTraceForEachRecord() {
      return this.includeStackTraceForEachRecord;
  }
  
  public static void registerClassLoadRuntimeInfoProvider(IClassLoadRuntimeInfoProvider aClassLoadRuntimeInfoProvider) {
      if (LoggingManager.classLoadInfoProvider != null) {
          throw new IllegalStateException("ClassLoadRuntimeInfoProvider is already registered.");
      }
      LoggingManager.classLoadInfoProvider = aClassLoadRuntimeInfoProvider;
  }
  
  public static void registerThreadRuntimeInfoProvider(IThreadRuntimeInfoProvider aThreadRuntimeInfoProvider) {
      if (LoggingManager.threadInfoProvider != null) {
          throw new IllegalStateException("ThreadRuntimeInfoProvider is already registered.");
      }
      LoggingManager.threadInfoProvider = aThreadRuntimeInfoProvider;
  }

  public static void registerDeployRuntimeInfoProvider(IDeployRuntimeInfoProvider aDeployRuntimeInfoProvider) {
      if (LoggingManager.deployInfoProvider != null) {
          throw new IllegalStateException("DeployRuntimeInfoProvider is already registered.");
      }
      LoggingManager.deployInfoProvider = aDeployRuntimeInfoProvider;
  }
  
  public static IClassLoadRuntimeInfoProvider getClassLoadRuntimeInfoProvider() {
      return classLoadInfoProvider;
  }
  
  public static IThreadRuntimeInfoProvider getThreadRuntimeInfoProvider() {
      return threadInfoProvider;
  }
  
  public static IDeployRuntimeInfoProvider getDeployRuntimeInfoProvider() {
      return deployInfoProvider;
  }
  
  // ==== < deprecated ============================ private class > ====
}