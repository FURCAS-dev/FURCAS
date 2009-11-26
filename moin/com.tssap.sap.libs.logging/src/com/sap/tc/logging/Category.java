package com.sap.tc.logging;

/*
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
 */

import java.util.*;

/**
 * <p>
 *   Describes messages <em>specific to distinguished problem areas</em>
 *   and is above all used to emit <em>log</em> messages.
 *   Typical problem areas are databases, networking, security auditing and
 *   others. Messages related to problem areas are classical <em>log</em>
 *   messages, and hence messages emitted to categories are classical log
 *   messages. Therefore, if you are above all interested in writing logs,
 *   please read this introduction thoroughly.
 * </p>
 * <p>
 *   The class <code>Category</code> is a subclass of {@link LogController}, so
 *   you can, with the corresponding calls, emit log messages and have the
 *   output of those messages to attachable logs controlled via the severities
 *   of the categories and optional filters assigned to them. We recommend to
 *   use the constants provided in the class {@link Severity} to specify message
 *   severities.
 * </p>
 * <p>
 *   Categories are named according to the hierarchical structure known from
 *   file systems. This name structure is mirrored in the hierarchical order of
 *   the categories named. For example, you could decide to group together all
 *   the categories of log messages concerned with system issues, such as
 *   database or networking problems, and name them
 *   <code>/System/Database</code> and <code>/System/Network</code>,
 *   respectively. The category <code>/System</code> is then the parent of the
 *   former two and therefore passes on its settings and attached logs to both
 *   of them. This has the benefit that, for example, if you would like to have
 *   all system messages written to the same log, you do not have to attach it
 *   to both the database and networking categories but simply to the common
 *   parent. The hierarchical components of the name have to be compliant with
 *   Java identifier syntax, but you can use illegal characters bracketing a
 *   component with single quotes. For example, to use a name with a space,
 *   write <code>/System/'Other Database'</code>.
 * </p>
 * <p>
 *   Categories are accessed via the static method
 *   <code>Category.getCategory</code>. Although the lookup done in this method
 *   is quite efficient, it should not be called each time a message is to be
 *   generated. Instead, each class should define static fields to hold all
 *   the needed categories, and use these fields to call logging methods.
 * </p>
 * <p>
 *   Messages in a category are always written with respect to a source code
 *   area, or <em>location</em>, such as a component, a package, a class or a
 *   method. As a location is itself a log controller, the same method call can
 *   write a message simultaneously to, for example, the database log as well as
 *   to the location trace responsible for that part of the source code, save
 *   for the location having an appropriate severity setting. Both messages get
 *   the same identification in order to facilitate cross-referencing among
 *   location and category logs. At the same time, the location provides a
 *   location description, that is a string, to the log message written to the
 *   database log. This might get tedious when a class implements a large number
 *   of methods. Therefore, as described below in more detail, for each logging
 *   method there is a version which takes in an additional parameter called
 *   <code>subloc</code> a string that serves as suffix to the name of the used
 *   location, thus providing you with the option to give a complete location
 *   name whilst avoiding clutter.
 * </p>
 * <p>
 *   Before we take a closer look at an example, a few remarks on output methods
 *   and a short word of warning: do not let the sheer number of methods
 *   overwhelm you. There are two families of methods and the large number stems
 *   above all from the different parameters of these families, and the
 *   resulting combinations. There are methods for emitting clear text messages
 *   and methods for emitting language-independent messages via a message code,
 *   called  <code>logT</code> and <code>log</code>, respectively. The message
 *   code is a name looked up in a resource bundle at the time of viewing the
 *   log. Both methods come in flavors that take an array of object arguments.
 *   When using these flavors, the message is expected to take parameters
 *   specified as placeholders of the form
 *   <code>"{</code><i>&lt;number&gt;</i><code>}"</code> which are then replaced
 *   with the argument having the same number, or rather with the result of its
 *   method <code>toString</code>. This format is known from the class
 *   <code>java.text.MessageFormat</code>. If the result of
 *   <code>toString</code> is unsuitable for an argument, an arbitrary string
 *   can be passed instead. Note that to output <code>"{"</code> or
 *   <code>"}"</code> you have to put them into single quotes, that is write
 *   <code>"'{'"</code> or <code>"'}'"</code>. To print single quotes, double
 *   them in your message.
 * </p>
 * <p>
 *   All the above methods take a first argument that specifies the severities
 *   of the messages. It is recommended to use one of the constants defined in
 *   the class <code>Severity</code> here, for example
 *   <code>Severity.WARNING</code> or <code>Severity.ERROR</code>. However,
 *   there are also dedicated methods without that additional argument for all
 *   of the severities starting with <code>Severity.INFO</code>, with names of
 *   the form <i>&lt;severity&gt;</i><code>T</code> and <i>&lt;severity&gt;</i>,
 *   which are provided in the same flavors as <code>logT</code> and
 *   <code>log</code>.
 * </p>
 * <p>
 *   To sum up the above, including optional arguments an output call has the
 *   following general form:
 *   <blockquote>
 *     <table>
 *       <tr>
 *         <td><i>&lt;severity&gt;</i><code>T(</code></td><td><i>&lt;location&gt;</i><code>,</code></td>
 *       </tr>
 *       <tr>
 *                                               <td></td><td><i>[&lt;sublocation&gt;</i><code>,</code><i>]</i></td>
 *       </tr>
 *       <tr>
 *                                               <td></td><td><i>&lt;message&gt;</i></td>
 *       </tr>
 *       <tr>
 *                                               <td></td><td><i>[</i><code>,</code><i>&lt;arguments&gt;]</i><code>)</code></td>
 *       </tr>
 *     </table>
 *   </blockquote>
 *   or
 *   <blockquote>
 *     <table>
 *       <tr>
 *         <td><i>&lt;severity&gt;</i><code>(</code></td><td><i>&lt;location&gt;</i><code>,</code></td>
 *       </tr>
 *       <tr>
 *                                              <td></td><td><i>[&lt;sublocation&gt;</i><code>,</code><i>]</i></td>
 *       </tr>
 *       <tr>
 *                                              <td></td><td><i>&lt;message code&gt;</i></td>
 *       </tr>
 *       <tr>
 *                                              <td></td><td><i>[</i><code>,</code><i>&lt;arguments&gt;]</i></td>
 *       </tr>
 *       <tr>
 *                                              <td></td><td><i>[</i><code>,</code><i>&lt;clear message&gt;]</i><code>)</code>.</td>
 *       </tr>
 *     </table>
 *   </blockquote>
 * <p>
 *   The optional argument <i>&lt;sublocation&gt;</i> is for a parameter called
 *   <code>subloc</code> in the actual methods. This argument is appended to
 *   the name of the location itself. It is intended for completing the location
 *   name if a method is not represented via its own location because the
 *   corresponding fine control of output is not needed, as described above. The
 *   optional argument <i>&lt;clear message&gt;</i> of the second method version
 *   is for a parameter called <code>msgClear</code> in the actual methods. This
 *   argument is a fallback that is used to show the message if the code could
 *   not be found in the specified resource bundle. Of  course, all these
 *   optional arguments are also possible for the two basic calls
 *   <code>logT</code> and <code>log</code>.
 * </p>
 * <p>
 *   Let us take a closer look at an example. Due to the suffix option described
 *   above, the message uses the location name
 *   <code>com.sap.tc.monitoring.Node.store()</code>. Appropriate severity
 *   settings assumed, it would be written to both the logs associated with the
 *   category <code>cat</code> as well as those attached to the location
 *   <code>loc</code>.
 *   <blockquote>
 *     <pre>
 *package com.sap.tc.monitoring;
 *
 *import com.sap.tc.logging.*;
 *
 *public class Node {
 *
 *  private static final Location loc = Location.getLocation(Node.class);
 *  private static final Category cat = Category.getCategory("/System/Database");
 *
 *  public void store() {
 *    final String method = "store()";
 *
 *    try {
 *      // Write object data to database ...
 *    }
 *    catch (DatabaseException e) {
 *      cat.errorT(loc,
 *                 method,
 *                 "Error storing tree with root {0} in database.",
 *                 new Object[] {this});
 *    }
 *  }
 *}</pre>
 *   </blockquote>
 *   Note that for the message to be written to a log attached to the category,
 *   its severtiy must have been set at least with
 *   <blockquote>
 *     <pre>
 *cat.setEffectiveSevertiy(Severity.ERROR);</pre>
 *   </blockquote>
 *   or with
 *   <blockquote>
 *     <pre>
 *cat.setEffectiveSevertiy(loc,
 *                         Severity.ERROR);</pre>
 *   </blockquote>
 *   specifically for the location, for example during component initialization.
 *   Vice versa, for the message to be written to a log attached to the
 *   location, its severity must have been set with
 *   <blockquote>
 *     <pre>
 *loc.setEffectiveSevertiy(Severity.ERROR);</pre>
 *   </blockquote>
 *   or with
 *   <blockquote>
 *     <pre>
 *loc.setEffectiveSevertiy(cat,
 *                         Severity.ERROR);</pre>
 *   </blockquote>
 *   specifically for messages of the database problem category. For the example
 *   at hand, it would have been alright to format the message prior to the call
 *   using string concatenation, but in case of several arguments it is more
 *   efficient and for language-independent messages even necessary to use
 *   separate arguments.
 * </p>
 * <p>
 *   Above, we described how identifications are used to link the same message
 *   in traces and logs. You can also establish custom links among messages.
 *   Output methods return the corresponding log record if a message was written
 *   to at least one log. The identification can be obtained from the log record
 *   via the method {@link LogRecord#getId()} and then written as an argument to
 *   another message.
 * </p>
 * <p>
 *   Often, it is useful to put several related messages together into one
 *   context. A typical example are all trace messages stemming from one method
 *   call. In case of a database log, another example would be the messages
 *   representing the different database operations together forming one logical
 *   transaction. A formatter or log viewer can utilize this context information
 *   to visualize relations using indentation or tree controls. Correlator ID is
 *    the means to express such context information.
 * </p>
 * <p>
 *   Please find fundamental information about the principles of error handling
 *   in the package description. For this class, there are three cases where the
 *   methods {@link #getException()} and {@link #throwException()} are served.
 *   First, methods dealing with severities pass over a
 *   <code>java.lang.IllegalArgumentException</code> if a value is out of range.
 *   Second, the same exception with a different message is handed over if you
 *   forget to provide a location when needed, which is the case for the calls
 *   setting relative severities as well as for all methods emitting messages.
 *   However, all defective calls of the latter, for example when not providing
 *   a resource bundle or a clear text version in case of a language-independent
 *   message, still write the message in order to facilitate discovering the
 *   site of the call.
 * </p>
 * @see    Location
 * @see    Severity
 * @see    LogRecord
 * @see    Group
 */
public class Category extends LogController {

	//================================================ declaration > ====
	private static Location classLoc = Location.getLocation(Category.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");
	
  public static final String ROOT_NAME  = "/";
  public static final char   SEPARATOR  = '/';

  public static final Category SYSTEM 												
  									= Category.getCategoryInt	("/System");
  
  /**
	 * @deprecated Use APPLICATIONS 
	 */
	public static  Category APPLICATION 										
										= Category.getCategoryInt	("/Applications");
	  
  public final static  Category APPLICATIONS 									
  									= Category.getCategoryInt	("/Applications");
  public final static  Category APPS_COMMON                    
  									= Category.getCategory(APPLICATIONS, "Common");
  public final static  Category APPS_COMMON_SECURITY           
  									= Category.getCategory(APPS_COMMON, "Security");
  public final static  Category APPS_COMMON_BACKUP             
  									= Category.getCategory(APPS_COMMON, "Backup");
  public final static  Category APPS_COMMON_ARCHIVING          
  									= Category.getCategory(APPS_COMMON, "Archiving");
  public final static  Category APPS_COMMON_RESOURCES          
  									= Category.getCategory(APPS_COMMON, "Resources");
  public final static  Category APPS_COMMON_CONFIGURATION      
  									= Category.getCategory(APPS_COMMON, "Configuration");
  public final static  Category APPS_COMMON_FAILOVER           
  									= Category.getCategory(APPS_COMMON, "Failover");
  public final static  Category APPS_COMMON_INFRASTRUCTURE     
  									= Category.getCategory(APPS_COMMON, "Infrastructure");
	
	public final static  Category PERFORMANCE 				
										= Category.getCategoryInt	("/Performance");
	  
	public final static  Category SYS_DATABASE 			
										= Category.getCategory		(SYSTEM, "Database");
	public final static  Category SYS_NETWORK 				
										= Category.getCategory		(SYSTEM, "Network");
	public final static  Category SYS_SERVER 				
										= Category.getCategory		(SYSTEM, "Server");
	public final static  Category SYS_SECURITY 			
										= Category.getCategory		(SYSTEM, "Security");
	public final static  Category SYS_USER_INTERFACE	
										= Category.getCategory		(SYSTEM, "UserInterface");
	public final static  Category SYS_CONFIGURATION
										= Category.getCategory		(SYSTEM, "Configuration");
	public final static  Category SYS_LOGGING
										= Category.getCategory		(SYSTEM, "Logging");
	public final static  Category SYS_ENTERPRISE_SERVICES
										= Category.getCategory		(SYSTEM, "EnterpriseServices");
	protected final static  Category SYS_CONFIGURATION_LOGGING
										= Category.getCategory		(SYS_CONFIGURATION, "Logging");
    
    public final static Category SYS_CHANGES
                                        = Category.getCategory(SYSTEM, "Changes");

	public static HashMap PREDEF_CATEGORIES = new HashMap();
	
	static {
		PREDEF_CATEGORIES.put("/", 																		getRoot());
		PREDEF_CATEGORIES.put("/Performance", 												PERFORMANCE);
		PREDEF_CATEGORIES.put("/Applications", 												APPLICATIONS);
		PREDEF_CATEGORIES.put("/Applications/Common", 								APPS_COMMON);
		PREDEF_CATEGORIES.put("/Applications/Common/Security", 				APPS_COMMON_SECURITY);
		PREDEF_CATEGORIES.put("/Applications/Common/Backup", 					APPS_COMMON_BACKUP);
		PREDEF_CATEGORIES.put("/Applications/Common/Archiving", 			APPS_COMMON_ARCHIVING);
		PREDEF_CATEGORIES.put("/Applications/Common/Resources", 			APPS_COMMON_RESOURCES);
		PREDEF_CATEGORIES.put("/Applications/Common/Configuration",		APPS_COMMON_CONFIGURATION);
		PREDEF_CATEGORIES.put("/Applications/Common/Failover", 				APPS_COMMON_FAILOVER);
		PREDEF_CATEGORIES.put("/Applications/Common/Infrastructure", 	APPS_COMMON_INFRASTRUCTURE);
		PREDEF_CATEGORIES.put("/System", 															SYSTEM);
		PREDEF_CATEGORIES.put("/System/Database", 										SYS_DATABASE);
		PREDEF_CATEGORIES.put("/System/Network", 											SYS_NETWORK);
		PREDEF_CATEGORIES.put("/System/Server", 											SYS_SERVER);
		PREDEF_CATEGORIES.put("/System/Security", 										SYS_SECURITY);
		PREDEF_CATEGORIES.put("/System/UserInterface", 								SYS_USER_INTERFACE);
		PREDEF_CATEGORIES.put("/System/Configuration", 								SYS_CONFIGURATION);
		PREDEF_CATEGORIES.put("/System/Configuration/Logging",				SYS_CONFIGURATION_LOGGING);
		PREDEF_CATEGORIES.put("/System/Logging", 											SYS_LOGGING);
		PREDEF_CATEGORIES.put("/System/EnterpriseServices",						SYS_ENTERPRISE_SERVICES);
        PREDEF_CATEGORIES.put("/System/Changes",                     SYS_CHANGES);
	}  
		  
  static final String NO_LOCATION_EMSG  = "no location";
	
  //==== < declaration ============================ constructors > ====
  
  Category(String name) {
    super(name);
  }

  Category(String name, Category parent) {
    super(name, parent);
  }

  //==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====
	 
  /**
   * Gets the root category.
   * @return Root category
   */
  public static Category getRoot() {
  	return getCategoryInt (ROOT_NAME);
  }

  /**
   * Gets the parent category of this category.
   * @return Parent category
   */
  public Category getParent() {
    return (Category) getParentInt();
  }

  protected int typeOfMessage(Object args[]) {
    return ((args == null) ? MsgType.PLAIN : MsgType.JAVA);
  }
  
  /**
   * Corrects syntax of the category's name if it is not correct.
   * @return Correct category's name
   */
  private static String correctCategoryName(String categoryName) {
    int i;
    boolean lastNotSeparator = true;
    
	categoryName = categoryName.trim();
	if (categoryName.length() == 0) {
	  return "";	
	}
	
    StringBuffer correctName = new StringBuffer(categoryName.length());
	
    for (i = 0; i < categoryName.length(); i++) {
      char currentChar = categoryName.charAt(i);
      if (currentChar == Location.SEPARATOR) {
        continue;
      }
      if (currentChar == SEPARATOR) {
        if(lastNotSeparator) {
       	  correctName.append(currentChar);
        }
    	lastNotSeparator = false;
      } else {
   	    correctName.append(currentChar);
      	lastNotSeparator = true;
      }
	}
    
    String finalName = correctName.toString();
    int len = finalName.length();
    
    if ((len > 1) && (finalName.charAt(len-1) == SEPARATOR)) {
      finalName = finalName.substring(0, len-1);
    }
    
	return finalName;
  }
  
  /**
   * Gets the category with the specified name relative to another category.
   * Save for the root category, this method is a shorthand for the call
   * <code>Category.getCategory(category.getName() + "/" + name)</code>.
   * @param  category Parent category
   * @param  name     Structured name of category
   * @return Category identified by relative name
   * @throws IllegalArgumentException Wrong location name syntax
   */
  public static Category getCategory(Category category,
                                     String   name) {
	String categoryName;
	categoryName = correctCategoryName(category.getName() + SEPARATOR + name);
    return Category.getCategoryInt(categoryName);
  }
	
	
	//***************************************************************
	//     									LOG T METHODS
	//***************************************************************

  /**
   * Logs simple message from the given location into this category.
   * @param  severity Severity of message
   * @param  loc      Location message stems from
   * @param  msg      Message text
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord logT(int      severity,
						Location loc,
						String   msg) {
    
		LogRecord writtenRec = null;
		if (beLogged(severity, loc)) {
			writtenRec = 
		        logSeverityInt (severity, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                MsgType.PLAIN, 
		                null,
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msg,
		                MSG_ARGS);
		} 
		else if (loc != null && loc.beLogged(severity, this)) {
			loc.logTInt(severity, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
									msg, 
									MsgType.PLAIN, 
									MSG_ARGS,
                                    null,
                                    null,
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Location,
   *              java.lang.String)}
   * but appends a string denoting a sublocation to the name of the location.
   * @param  severity Severity of message
   * @param  loc      Location message stems from
   * @param  subloc   Name of sublocation
   * @param  msg      Message text
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord logT(int      severity,
						Location loc,
						String   subloc,
						String   msg) {
		LogRecord writtenRec = null;
	
		if (beLogged(severity, loc)) {
			writtenRec = 
		        logSeverityInt (severity, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                MsgType.PLAIN, 
		                null,
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msg,
		                MSG_ARGS);
		}
		else if (loc != null && loc.beLogged(severity, this)) {
			loc.logTInt(severity, 
									loc, 
									new LogController[] {this}, 
									subloc, 
									msg, 
									MsgType.PLAIN, 
									MSG_ARGS,
                                    null,
                                    null,
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName);
		} 
		return writtenRec;
  }

  /**
   * Logs message with parameters from the given location into this category.
   * The objects handed over as arguments are written using the method
   * <code>toString</code>.
   * @param  severity Severity of message
   * @param  loc      Location message stems from
   * @param  msg      Message template
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord logT(int      severity,
						Location loc,
						String   msg,
						Object[] args) {
    
		LogRecord writtenRec = null;
		if (beLogged(severity, loc)) {
			writtenRec = 
		        logSeverityInt (severity, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                typeOfMessage(args), 
		                null,
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msg,
		                args);
		} 
		else if (loc != null && loc.beLogged(severity, this)) {
			loc.logTInt(severity, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
									msg, 
									MsgType.JAVA, 
									args,
                                    null,
                                    null,
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Location,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but appends a string denoting a sublocation to the name of the location.
   * @param  severity Severity of message
   * @param  loc      Location message stems from
   * @param  subloc   Name of sublocation
   * @param  msg      Message template
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord logT(int      severity,
						Location loc,
						String   subloc,
						String   msg,
						Object[] args) {
		LogRecord writtenRec = null;
	
		if (beLogged(severity, loc)) {
			writtenRec = 
		        logSeverityInt (severity, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                typeOfMessage(args), 
		                null,
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msg,
		                args);
		} 
		else if (loc != null && loc.beLogged(severity, this)) {
			loc.logTInt(severity, 
									loc, 
									new LogController[] {this}, 
									subloc, 
									msg, 
									MsgType.JAVA, 
									args,
                                    null,
                                    null,
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName);
		} 
		return writtenRec;
  }

  /**
	 * Logs message, specified as a message object, from the given location into
	 * this category.
	 * If Location has defined resource name then that resorce name is taken, 
	 * otherwise Category resource name is taken.
	 * @param  severity 	Severity of message
	 * @param  loc      	Location message stems from
	 * @param  MsgObject  Message object of message
	 * @return Log record if written via a log of this log controller or null
	 */
	public LogRecord log(int       severity,
						 					 Location  loc,
						 					 MsgObject msgObject) {
		
		// Guardian
		if (msgObject == null) return null;
		
		LogRecord writtenRec = null;

		if (beLogged(severity, loc)) {
			writtenRec = 
			logSeverityInt (severity, 
											loc, 
											new LogController[] {loc}, 	
											MSG_SUB_LOC,
                                            null,
                                            MsgType.PLAIN,
											msgObject.getMsgKeyAndID(),
                                            (loc == null) ? null : loc.csnComponent,
                                            (loc == null) ? null : loc.dcName,
											msgObject.getMsgText(), 
											MSG_ARGS);
		} 
		else if (loc != null && loc.beLogged(severity, this)) {
			loc.logInt(severity, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
									msgObject.getMsgKeyAndID(),
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName,
									msgObject.getMsgText(),
									MsgType.PLAIN, 
									MSG_ARGS,
                                    null);
		}
		return writtenRec;
	}
	
	/**
	 * Logs message, specified as a message object, from the given location into
	 * this category.
	 * If Location has defined resource name then that resorce name is taken, 
	 * otherwise Category resource name is taken.
	 * @param  severity 	Severity of message
	 * @param  loc      	Location message stems from
	 * @param  subloc   	Name of sublocation
	 * @param  MsgObject  Message object of message
	 * @return Log record if written via a log of this log controller or null
	 */
	public LogRecord log(int       	severity,
											 Location  	loc,
											 String			subLoc,
											 MsgObject 	msgObject) {
	
		// Guardian
		if (msgObject == null) return null;
	
		LogRecord writtenRec = null;

		if (beLogged(severity, loc)) {
			writtenRec = 
			logSeverityInt (severity, 
											loc, 
											new LogController[] {loc}, 	
											subLoc,
                                            null,
                                            MsgType.PLAIN,
											msgObject.getMsgKeyAndID(),
                                            (loc == null) ? null : loc.csnComponent,
                                            (loc == null) ? null : loc.dcName,
											msgObject.getMsgText(), 
											MSG_ARGS);
		} 
		else if (loc != null && loc.beLogged(severity, this)) {
			loc.logInt(severity, 
									loc, 
									new LogController[] {this}, 
									subLoc,
									msgObject.getMsgKeyAndID(),
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName,                                    
									msgObject.getMsgText(),
									MsgType.PLAIN, 
									MSG_ARGS,
                                    null);
		}
		return writtenRec;
	}
	
	
	
	/**
	 * Logs message, specified as a message object, from the given location into
	 * this category.
	 * If Location has defined resource name then that resorce name is taken, 
	 * otherwise Category resource name is taken.
	 * @param  severity 	Severity of message
	 * @param  loc      	Location message stems from
	 * @param  msgObject  Message object of message
	 * @param  args     	Arguments as object references
	 * @return Log record if written via a log of this log controller or null
	 */
	public LogRecord log(int       	severity,
											 Location  	loc,
											 MsgObject 	msgObject,
											 Object[] 	args) {
	
		// Guardian
		if (msgObject == null) return null;
	
		LogRecord writtenRec = null;

		if (beLogged(severity, loc)) {
			writtenRec = 
			logSeverityInt (severity, 
											loc, 
											new LogController[] {loc}, 	
											MSG_SUB_LOC, 
                                            null,
                                            MsgType.JAVA,
											msgObject.getMsgKeyAndID(),
                                            (loc == null) ? null : loc.csnComponent,
                                            (loc == null) ? null : loc.dcName,
											msgObject.getMsgText(), 
											args);
		} 
		else if (loc != null && loc.beLogged(severity, this)) {
			loc.logInt(severity, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
									msgObject.getMsgKeyAndID(),
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName,                                    
									msgObject.getMsgText(),
									MsgType.JAVA, 
									args,
                                    null);
		}
		return writtenRec;
	}
	
	/**
	 * Logs message, specified as a message object, from the given location into
	 * this category.
	 * If Location has defined resource name then that resorce name is taken, 
	 * otherwise Category resource name is taken.
	 * @param  severity 	Severity of message
	 * @param  loc      	Location message stems from
	 * @param  subloc   	Name of sublocation
	 * @param  MsgObject  Message object of message
	 * @param  args     	Arguments as object references
	 * @return Log record if written via a log of this log controller or null
	 */
	public LogRecord log(int       	severity,
											 Location  	loc,
											 String			subLoc,
											 MsgObject 	msgObject,
											 Object[] 	args) {

		// Guardian
		if (msgObject == null) return null;

		LogRecord writtenRec = null;

		if (beLogged(severity, loc)) {
			writtenRec = 
			logSeverityInt (severity, 
											loc, 
											new LogController[] {loc}, 	
											subLoc,
                                            null,
                                            MsgType.JAVA,
											msgObject.getMsgKeyAndID(),
                                            (loc == null) ? null : loc.csnComponent,
                                            (loc == null) ? null : loc.dcName,
											msgObject.getMsgText(), 
											args);
		} 
		else if (loc != null && loc.beLogged(severity, this)) {
			loc.logInt(severity, 
									loc, 
									new LogController[] {this}, 
									subLoc, 
									msgObject.getMsgKeyAndID(),
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName,
									msgObject.getMsgText(),
									MsgType.JAVA, 
									args,
                                    null);
		}
		return writtenRec;
	}
	
  /**
   * Logs message, specified as a resource name, from the given location into
   * this category.
   * If Location has defined resource name then that resorce name is taken, 
   * otherwise Category resource name is taken.
   * This method also stores a clear text version of the message, taken from the
   * resource bundle for language code <em>en</em> and country code
   * <em>US</em>, which is displayed whenever a log viewer cannot resolve a
   * message code.
   * @param  severity Severity of message
   * @param  loc      Location message stems from
   * @param  msgCode  Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord log(int      severity,
					   Location loc,
					   Object   msgCode) {
		LogRecord writtenRec = null;
	
		if (beLogged(severity, loc)) {
			writtenRec = 
		        logSeverityInt (severity, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                MsgType.PLAIN, 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		            	msgCode == null ? null : msgCode.toString(),
		                MSG_ARGS);
		} 
		else if (loc != null && loc.beLogged(severity, this)) {
			loc.logInt(severity, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
                                    msgCode == null ? null : msgCode.toString(), 
									null,
									MsgType.PLAIN, 
								MSG_ARGS);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.Object)}
   * but appends a string denoting a sublocation to the name of the location.
   * @param  severity Severity of message
   * @param  loc      Location message stems from
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord log(int      severity,
					   Location loc,
					   String   subloc,
					   Object   msgCode) {
		LogRecord writtenRec = null;
	
		if (beLogged(severity, loc)) {
			writtenRec = 
		        logSeverityInt (severity, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                MsgType.PLAIN, 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		            	msgCode == null ? null : msgCode.toString(),
		                MSG_ARGS);
		} 
		else if (loc != null && loc.beLogged(severity, this)) {
			loc.logInt(severity, 
									loc, 
									new LogController[] {this}, 
									subloc, 
                                    msgCode == null ? null : msgCode.toString(), 
									null,
									MsgType.PLAIN, 
									MSG_ARGS);
		}
		return writtenRec;
  }

  /**
   * Logs message, specified as a resource name, with parameters from the given
   * location into this category.
   * If Location has defined resource name then that resorce name is taken, 
   * otherwise Category resource name is taken.
   * The objects handed over as arguments are written using the method
   * <code>toString</code>. This method also stores a clear text version of the
   * message, taken from the resource bundle for language code <em>en</em> and
   * country code <em>US</em>, which is displayed whenever a log viewer cannot
   * resolve a message code.
   * @param  severity Severity of message
   * @param  loc      Location message stems from
   * @param  msgCode  Resource name of message template
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord log(int      severity,
					   Location loc,
					   Object   msgCode,
					   Object[] args) {
		LogRecord writtenRec = null;
	
		if (beLogged(severity, loc)) {
			writtenRec = 
		        logSeverityInt (severity, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                typeOfMessage(args), 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		            	msgCode == null ? null : msgCode.toString(),
		                args);
		}
		else if (loc != null && loc.beLogged(severity, this)) {
			loc.logInt(severity, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
                                    msgCode == null ? null : msgCode.toString(), 
									null,
									MsgType.JAVA, 
									args);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but appends a string denoting a sublocation to the name of the location.
   * @param  severity Severity of message
   * @param  loc      Location message stems from
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message template
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord log(int      severity,
					   Location loc,
					   String   subloc,
					   Object   msgCode,
					   Object[] args) {
		LogRecord writtenRec = null;
	
		if (beLogged(severity, loc)) {
			writtenRec = 
		        logSeverityInt (severity, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                typeOfMessage(args), 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		            	msgCode == null ? null : msgCode.toString(),
		                args);
		} 
		else if (loc != null && loc.beLogged(severity, this)) {
			loc.logInt(severity, 
									loc, 
									new LogController[] {this}, 
									subloc, 
                                    msgCode == null ? null : msgCode.toString(), 
									null,
									MsgType.JAVA, 
									args);
		}
		return writtenRec;
  }

  /**
   * Logs message, specified as a resource name, from the given location into
   * this category.
   * If Location has defined resource name then that resorce name is taken, 
   * otherwise Category resource name is taken.
   * This method also stores a clear text version of the message which is
   * displayed whenever a log viewer cannot resolve a message code.
   * @param  severity Severity of message
   * @param  loc      Location message stems from
   * @param  msgCode  Resource name of message
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord log(int      severity,
					   Location loc,
					   Object   msgCode,
					   String   msgClear) {
		LogRecord writtenRec = null;
	
		if (beLogged(severity, loc)) {
			writtenRec = 
		        logSeverityInt (severity, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                MsgType.PLAIN, 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msgClear,
		                MSG_ARGS);
		} 
		else if (loc != null && loc.beLogged(severity, this)) {
			loc.logInt(severity, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
                                    msgCode == null ? null : msgCode.toString(), 
									msgClear,
									MsgType.PLAIN, 
									MSG_ARGS);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.Object,
   *             java.lang.String)}
   * but appends a string denoting a sublocation to the name of the location.
   * @param  severity Severity of message
   * @param  loc      Location message stems from
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord log(int      severity,
					   Location loc,
					   String   subloc,
					   Object   msgCode,
					   String   msgClear) {
		LogRecord writtenRec = null;
	
		if (beLogged(severity, loc)) {
			writtenRec = 
		        logSeverityInt (severity, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                MsgType.PLAIN, 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msgClear,
		                MSG_ARGS);
		} 
		else if (loc != null && loc.beLogged(severity, this)) {
			loc.logInt(severity, 
									loc, 
									new LogController[] {this}, 
									subloc, 
                                    msgCode == null ? null : msgCode.toString(), 
									msgClear,
									MsgType.JAVA, 
									MSG_ARGS);
		}
		return writtenRec;
  }

  /**
   * Logs message, specified as a resource name, with parameters from the given
   * location into this category.
   * If Location has defined resource name then that resorce name is taken, 
   * otherwise Category resource name is taken.
   * The objects handed over as arguments are written using the method
   * <code>toString</code>. This method also stores a clear text version of the
   * message which is displayed whenever a log viewer cannot resolve a message
   * code.
   * @param  severity Severity of message
   * @param  loc      Location message stems from
   * @param  msgCode  Resource name of message template
   * @param  args     Arguments as object references
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord log(int      severity,
					   Location loc,
					   Object   msgCode,
					   Object[] args,
					   String   msgClear) {
		LogRecord writtenRec = null;
	
		if (beLogged(severity, loc)) {
			writtenRec = 
		        logSeverityInt (severity, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                typeOfMessage(args), 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msgClear,
		                args);
		} 
		else if (loc != null && loc.beLogged(severity, this)) {
			loc.logInt(severity, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
                                    msgCode == null ? null : msgCode.toString(), 
									msgClear,
									MsgType.JAVA, 
									args);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but appends a string denoting a sublocation to the name of the location.
   * @param  severity Severity of message
   * @param  loc      Location message stems from
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message template
   * @param  args     Arguments as object references
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord log(int      severity,
					   Location loc,
					   String   subloc,
					   Object   msgCode,
					   Object[] args,
					   String   msgClear) {
		LogRecord writtenRec = null;
	
		if (beLogged(severity, loc)) {
			writtenRec = 
		        logSeverityInt (severity, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                typeOfMessage(args), 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msgClear,
		                args);
		} 
		else if (loc != null && loc.beLogged(severity, this)) {
			loc.logInt(severity, 
									loc, 
									new LogController[] {this}, 
									subloc, 
                                    msgCode == null ? null : msgCode.toString(), 
									msgClear,
									MsgType.JAVA, 
									args);
		}
		return writtenRec;
  }

	//***************************************************************
	//     									INFO METHODS
	//***************************************************************
  
  /**
   * Same as
   * {@link #logT(int,
   *              Location,
   *              java.lang.String)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  loc Location message stems from
   * @param  msg Message text
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord infoT(Location loc,
						 						 String   msg) {
		LogRecord writtenRec = null;

		if (beInfo(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.INFO, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                MsgType.PLAIN, 
		                null,
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msg,
		                MSG_ARGS);
		} 
		else if (loc != null && loc.beInfo(this)) {
			loc.logTInt(Severity.INFO, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
									msg, 
									MsgType.PLAIN, 
									MSG_ARGS,
                                    null,
                                    null,
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Location,
   *              java.lang.String,
   *              java.lang.String)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  loc    Location message stems from
   * @param  subloc Name of sublocation
   * @param  msg    Message text
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord infoT(Location loc,
												 String   subloc,
												 String   msg) {
		LogRecord writtenRec = null;

		if (beInfo(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.INFO, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                MsgType.PLAIN, 
		                null,
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msg,
		                MSG_ARGS);
		}
		else if (loc != null && loc.beInfo(this)) {
			loc.logTInt(Severity.INFO, 
									loc, 
									new LogController[] {this}, 
									subloc, 
									msg, 
									MsgType.PLAIN, 
									MSG_ARGS,
                                    null,
                                    null,
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Location,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  loc  Location message stems from
   * @param  msg  Message template
   * @param  args Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord infoT(Location loc,
												 String   msg,
												 Object[] args) {
		LogRecord writtenRec = null;

		if (beInfo(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.INFO, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                typeOfMessage(args), 
		                null,
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msg,
		                args);
		} 
		else if (loc != null && loc.beInfo(this)) {
			loc.logTInt(Severity.INFO, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
									msg, 
									MsgType.JAVA, 
									args,
                                    null,
                                    null,
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Location,
   *              java.lang.String,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  loc    Location message stems from
   * @param  subloc Name of sublocation
   * @param  msg    Message template
   * @param  args   Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord infoT(Location loc,
												 String   subloc,
												 String   msg,
												 Object[] args) {	
		LogRecord writtenRec = null;

		if (beInfo(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.INFO, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                typeOfMessage(args), 
		                null,
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msg,
		                args);
		} 
		else if (loc != null && loc.beInfo(this)) {
			loc.logTInt(Severity.INFO, 
									loc, 
									new LogController[] {this}, 
									subloc, 
									msg, 
									MsgType.JAVA, 
									args,
                                    null,
                                    null,
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             MsgObject)}
   * but always emits an info message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  loc     		Location message stems from
   * @param  MsgObject  Message object of message
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord info(Location 	loc,
										    MsgObject msgObject) {
	
	  // Guardian
	  if (msgObject == null) return null;
	
		LogRecord writtenRec = null;
	
		if (beInfo(loc)) {
			writtenRec = 
			logSeverityInt (Severity.INFO, 
											loc, 
											new LogController[] {loc}, 	
											MSG_SUB_LOC,
                                            null,
                                            MsgType.PLAIN,
											msgObject.getMsgKeyAndID(),
                                            (loc == null) ? null : loc.csnComponent,
                                            (loc == null) ? null : loc.dcName,
											msgObject.getMsgText(), 
											MSG_ARGS);
		} 
		else if (loc != null && loc.beInfo(this)) {
			loc.logInt(Severity.INFO, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
									msgObject.getMsgKeyAndID(),
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName,
									msgObject.getMsgText(),
									MsgType.PLAIN, 
									MSG_ARGS,
                                    null);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             MsgObject,
   * 						 java.lang.Object[])}
   * but always emits an info message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  loc     		Location message stems from
   * @param  MsgObject  Message object of message
   * @param  args    		Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord info(Location 	loc,
											  MsgObject msgObject,
											  Object[]	args) {

	  // Guardian
	  if (msgObject == null) return null;

		LogRecord writtenRec = null;

		if (beInfo(loc)) {
			writtenRec = 
			logSeverityInt (Severity.INFO, 
											loc, 
											new LogController[] {loc}, 	
											MSG_SUB_LOC, 
                                            null,
                                            MsgType.JAVA,
											msgObject.getMsgKeyAndID(),
                                            (loc == null) ? null : loc.csnComponent,
                                            (loc == null) ? null : loc.dcName,
											msgObject.getMsgText(), 
											args);
		} 
		else if (loc != null && loc.beInfo(this)) {
			loc.logInt(Severity.INFO, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
									msgObject.getMsgKeyAndID(),
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName,
									msgObject.getMsgText(),
									MsgType.JAVA, 
									args,
                                    null);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   * 						 java.lang.String,
   *             MsgObject)}
   * but always emits an info message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  loc     		Location message stems from
   * @param  subloc  		Name of sublocation
   * @param  MsgObject  Message object of message
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord info(Location 	loc,
											  String		subLoc,
											  MsgObject msgObject) {

	  // Guardian
	  if (msgObject == null) return null;

		LogRecord writtenRec = null;

		if (beInfo(loc)) {
			writtenRec = 
			logSeverityInt (Severity.INFO, 
											loc, 
											new LogController[] {loc}, 	
											subLoc, 
                                            null,
                                            MsgType.PLAIN,
											msgObject.getMsgKeyAndID(),
                                            (loc == null) ? null : loc.csnComponent,
                                            (loc == null) ? null : loc.dcName,
											msgObject.getMsgText(), 
											MSG_ARGS);
		} 
		else if (loc != null && loc.beInfo(this)) {
			loc.logInt(Severity.INFO, 
									loc, 
									new LogController[] {this}, 
									subLoc, 
									msgObject.getMsgKeyAndID(),
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName,
									msgObject.getMsgText(),
									MsgType.PLAIN, 
									MSG_ARGS,
                                    null);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   * 						 java.lang.String,
   *             MsgObject,
   * 						 java.lang.Object[])}
   * but always emits an info message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  loc     		Location message stems from
   * @param  subloc  		Name of sublocation
   * @param  MsgObject  Message object of message
   * @param  args    		Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord info(Location 	loc,
											  String		subLoc,
											  MsgObject msgObject,
											  Object[]	args) {

	  // Guardian
	  if (msgObject == null) return null;

		LogRecord writtenRec = null;
	
		if (beInfo(loc)) {
			writtenRec = 
			logSeverityInt (Severity.INFO, 
											loc, 
											new LogController[] {loc}, 	
											subLoc,
                                            null,
                                            MsgType.JAVA,
											msgObject.getMsgKeyAndID(),
                                            (loc == null) ? null : loc.csnComponent,
                                            (loc == null) ? null : loc.dcName,
											msgObject.getMsgText(), 
											args);
		} 
		else if (loc != null && loc.beInfo(this)) {
			loc.logInt(Severity.INFO, 
									loc, 
									new LogController[] {this}, 
									subLoc, 
									msgObject.getMsgKeyAndID(),
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName,
								  msgObject.getMsgText(),
									MsgType.JAVA, 
									args,
                                    null);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.Object)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  loc     Location message stems from
   * @param  msgCode Resource name of message
   * @see    #setResourceBundleName(java.lang.String)
   * @return Log record if written via a log of this log controller or null
   * @deprecated
   */
  public LogRecord info(Location loc,
						Object   msgCode) {
		LogRecord writtenRec = null;
		if (beInfo(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.INFO, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                MsgType.PLAIN, 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		            	msgCode == null ? null : msgCode.toString(),
		                MSG_ARGS);
		} 
		else if (loc != null && loc.beInfo(this)) {
			loc.logInt(Severity.INFO, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
                                    msgCode == null ? null : msgCode.toString(), 
									null,
									MsgType.PLAIN, 
									MSG_ARGS);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.String,
   *             java.lang.Object)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  loc     Location message stems from
   * @param  subloc  Name of sublocation
   * @param  msgCode Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord info(Location loc,
						String   subloc,
						Object   msgCode) {
		LogRecord writtenRec = null;

		if (beInfo(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.INFO, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                MsgType.PLAIN, 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		            	msgCode == null ? null : msgCode.toString(),
		                MSG_ARGS);
		} 
		else if (loc != null && loc.beInfo(this)) {
			loc.logInt(Severity.INFO, 
									loc, 
									new LogController[] {this}, 
									subloc, 
                                    msgCode == null ? null : msgCode.toString(), 
									null,
									MsgType.PLAIN, 
									MSG_ARGS);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  loc     Location message stems from
   * @param  msgCode Resource name of message template
   * @param  args    Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord info(Location loc,
						Object   msgCode,
						Object[] args) {
		LogRecord writtenRec = null;

		if (beInfo(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.INFO, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                typeOfMessage(args), 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		            	msgCode == null ? null : msgCode.toString(),
		                args);
		}
		else if (loc != null && loc.beInfo(this)) {
			loc.logInt(Severity.INFO, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
                                    msgCode == null ? null : msgCode.toString(), 
									null,
									MsgType.JAVA, 
									args);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  loc     Location message stems from
   * @param  subloc  Name of sublocation
   * @param  msgCode Resource name of message template
   * @param  args    Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord info(Location loc,
						String   subloc,
						Object   msgCode,
						Object[] args) {
		LogRecord writtenRec = null;
		
		if (beInfo(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.INFO, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                typeOfMessage(args), 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		            	msgCode == null ? null : msgCode.toString(),
		                args);
		} 
		else if (loc != null && loc.beInfo(this)) {
			loc.logInt(Severity.INFO, 
									loc, 
									new LogController[] {this}, 
									subloc, 
                                    msgCode == null ? null : msgCode.toString(), 
									null,
									MsgType.JAVA, 
									args);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  loc      Location message stems from
   * @param  msgCode  Resource name of message
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord info(Location loc,
						Object   msgCode,
						String   msgClear) {
                        	
		LogRecord writtenRec = null;
		if (beInfo(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.INFO, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                MsgType.PLAIN, 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msgClear,
		                MSG_ARGS);
		} 
		else if (loc != null && loc.beInfo(this)) {
			loc.logInt(Severity.INFO, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
                                    msgCode == null ? null : msgCode.toString(), 
									msgClear,
									MsgType.PLAIN, 
									MSG_ARGS);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  loc      Location message stems from
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord info(Location loc,
						String   subloc,
						Object   msgCode,
						String   msgClear) {
		LogRecord writtenRec = null;

		if (beInfo(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.INFO, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                MsgType.PLAIN, 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msgClear,
		                MSG_ARGS);
		} 
		else if (loc != null && loc.beInfo(this)) {
			loc.logInt(Severity.INFO, 
									loc, 
									new LogController[] {this}, 
									subloc, 
                                    msgCode == null ? null : msgCode.toString(), 
									msgClear,
									MsgType.JAVA, 
									MSG_ARGS);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  loc      Location message stems from
   * @param  msgCode  Resource name of message template
   * @param  args     Arguments as object references
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord info(Location loc,
						Object   msgCode,
						Object[] args,
						String   msgClear) {
		LogRecord writtenRec = null;

		if (beInfo(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.INFO, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                typeOfMessage(args), 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msgClear,
		                args);
		} 
		else if (loc != null && loc.beInfo(this)) {
			loc.logInt(Severity.INFO, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
                                    msgCode == null ? null : msgCode.toString(), 
									msgClear,
									MsgType.JAVA, 
									args);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  loc      Location message stems from
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message template
   * @param  args     Arguments as object references
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord info(Location loc,
						String   subloc,
						Object   msgCode,
						Object[] args,
						String   msgClear) {
		LogRecord writtenRec = null;

		if (beInfo(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.INFO, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                typeOfMessage(args), 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msgClear,
		                args);
		} 
		else if (loc != null && loc.beInfo(this)) {
			loc.logInt(Severity.INFO, 
									loc, 
									new LogController[] {this}, 
									subloc, 
                                    msgCode == null ? null : msgCode.toString(), 
									msgClear,
									MsgType.JAVA, 
									args);
		}
		return writtenRec;
  }

	//***************************************************************
	//     									WARNING METHODS
	//***************************************************************
	
  /**
   * Same as
   * {@link #logT(int,
   *             Location,
   *             java.lang.String)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  loc Location message stems from
   * @param  msg Message text
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord warningT(Location loc,
							String   msg) {
		LogRecord writtenRec = null;

		if (beWarning(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.WARNING, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                MsgType.PLAIN, 
		                null,
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msg,
		                MSG_ARGS);
		} 
		else if (loc != null && loc.beWarning(this)) {
			loc.logTInt(Severity.WARNING, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
									msg, 
									MsgType.PLAIN, 
									MSG_ARGS,
                                    null,
                                    null,
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Location,
   *              java.lang.String,
   *              java.lang.String)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  loc    Location message stems from
   * @param  subloc Name of sublocation
   * @param  msg    Message text
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord warningT(Location loc,
							String   subloc,
							String   msg) {
		LogRecord writtenRec = null;

		if (beWarning(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.WARNING, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                MsgType.PLAIN, 
		                null,
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msg,
		                MSG_ARGS);
		}
		else if (loc != null && loc.beWarning(this)) {
			loc.logTInt(Severity.WARNING, 
									loc, 
									new LogController[] {this}, 
									subloc, 
									msg, 
									MsgType.PLAIN, 
									MSG_ARGS,
                                    null,
                                    null,
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Location,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  loc  Location message stems from
   * @param  msg  Message template
   * @param  args Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord warningT(Location loc,
							String   msg,
							Object[] args) {
		LogRecord writtenRec = null;
		if (beWarning(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.WARNING, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                typeOfMessage(args), 
		                null,
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msg,
		                args);
		} 
		else if (loc != null && loc.beWarning(this)) {
			loc.logTInt(Severity.WARNING, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
									msg, 
									MsgType.JAVA, 
									args,
                                    null,
                                    null,
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *             Location,
   *             java.lang.String,
   *             java.lang.String,
   *             java.lang.Object[])}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  loc    Location message stems from
   * @param  subloc Name of sublocation
   * @param  msg    Message template
   * @param  args   Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord warningT(Location loc,
							String   subloc,
							String   msg,
							Object[] args) {
		LogRecord writtenRec = null;

		if (beWarning(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.WARNING, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                typeOfMessage(args), 
		                null,
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msg,
		                args);
		} 
		else if (loc != null && loc.beWarning(this)) {
			loc.logTInt(Severity.WARNING, 
									loc, 
									new LogController[] {this}, 
									subloc, 
									msg, 
									MsgType.JAVA, 
									args,
                                    null,
                                    null,
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             MsgObject)}
   * but always emits an warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  loc     		Location message stems from
   * @param  MsgObject  Message object of message
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord warning(Location 	loc,
										   		 MsgObject  msgObject) {
	
	  // Guardian
	  if (msgObject == null) return null;
	
		LogRecord writtenRec = null;
	
		if (beWarning(loc)) {
			writtenRec = 
			logSeverityInt (Severity.WARNING, 
											loc, 
											new LogController[] {loc}, 	
											MSG_SUB_LOC,
                                            null,
                                            MsgType.PLAIN,
											msgObject.getMsgKeyAndID(),
                                            (loc == null) ? null : loc.csnComponent,
                                            (loc == null) ? null : loc.dcName,
											msgObject.getMsgText(), 
											MSG_ARGS);
		} 
		else if (loc != null && loc.beWarning(this)) {
			loc.logInt(Severity.WARNING, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
									msgObject.getMsgKeyAndID(),
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName,
									msgObject.getMsgText(),
									MsgType.PLAIN, 
									MSG_ARGS,
                                    null);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             MsgObject,
   * 						 java.lang.Object[])}
   * but always emits an warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  loc     		Location message stems from
   * @param  MsgObject  Message object of message
   * @param  args    		Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord warning(Location 	loc,
											   	 MsgObject  msgObject,
											   	 Object[]		args) {

	  // Guardian
	  if (msgObject == null) return null;

		LogRecord writtenRec = null;
	
		if (beWarning(loc)) {
			writtenRec = 
			logSeverityInt (Severity.WARNING, 
											loc, 
											new LogController[] {loc}, 	
											MSG_SUB_LOC,
                                            null,
                                            MsgType.JAVA,
											msgObject.getMsgKeyAndID(),
                                            (loc == null) ? null : loc.csnComponent,
                                            (loc == null) ? null : loc.dcName,
											msgObject.getMsgText(), 
											args);
		} 
		else if (loc != null && loc.beWarning(this)) {
			loc.logInt(Severity.WARNING, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
									msgObject.getMsgKeyAndID(),
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName,
									msgObject.getMsgText(),
									MsgType.JAVA, 
									args,
                                    null);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   * 						 java.lang.String,
   *             MsgObject)}
   * but always emits an warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  loc     		Location message stems from
   * @param  subloc  		Name of sublocation
   * @param  MsgObject  Message object of message
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord warning(Location 	loc,
											   	 String			subLoc,
											   	 MsgObject  msgObject) {

	  // Guardian
	  if (msgObject == null) return null;

		LogRecord writtenRec = null;
	
		if (beWarning(loc)) {
			writtenRec = 
			logSeverityInt (Severity.WARNING, 
											loc, 
											new LogController[] {loc}, 	
											subLoc,
                                            null,
                                            MsgType.PLAIN,
											msgObject.getMsgKeyAndID(),
                                            (loc == null) ? null : loc.csnComponent,
                                            (loc == null) ? null : loc.dcName,
											msgObject.getMsgText(), 
											MSG_ARGS);
		} 
		else if (loc != null && loc.beWarning(this)) {
			loc.logInt(Severity.WARNING, 
									loc, 
									new LogController[] {this}, 
									subLoc, 
									msgObject.getMsgKeyAndID(),
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName,                                    
									msgObject.getMsgText(),
									MsgType.PLAIN, 
									MSG_ARGS,
                                    null);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   * 						 java.lang.String,
   *             MsgObject,
   * 						 java.lang.Object[])}
   * but always emits an warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  loc     		Location message stems from
   * @param  subloc  		Name of sublocation
   * @param  MsgObject  Message object of message
   * @param  args    		Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord warning(Location 	loc,
											   	 String			subLoc,
											   	 MsgObject  msgObject,
											   	 Object[]		args) {

	  // Guardian
	  if (msgObject == null) return null;

		LogRecord writtenRec = null;
	
		if (beWarning(loc)) {
			writtenRec = 
			logSeverityInt (Severity.WARNING, 
											loc, 
											new LogController[] {loc}, 	
											subLoc,
                                            null,
                                            MsgType.JAVA,
											msgObject.getMsgKeyAndID(),
                                            (loc == null) ? null : loc.csnComponent,
                                            (loc == null) ? null : loc.dcName,
											msgObject.getMsgText(), 
											args);
		} 
		else if (loc != null && loc.beWarning(this)) {
			loc.logInt(Severity.WARNING, 
									loc, 
									new LogController[] {this}, 
									subLoc, 
									msgObject.getMsgKeyAndID(),
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName,
									msgObject.getMsgText(),
									MsgType.JAVA, 
									args,
                                    null);
		}
		return writtenRec;
  }


  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.Object)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  loc     Location message stems from
   * @param  msgCode Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord warning(Location loc,
						   Object   msgCode) {
		LogRecord writtenRec = null;
		if (beWarning(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.WARNING, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                MsgType.PLAIN, 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		            	msgCode == null ? null : msgCode.toString(),
		                MSG_ARGS);
		} 
		else if (loc != null && loc.beWarning(this)) {
			loc.logInt(Severity.WARNING, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
                                    msgCode == null ? null : msgCode.toString(), 
									null,
									MsgType.PLAIN, 
									MSG_ARGS);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.String,
   *             java.lang.Object)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  loc     Location message stems from
   * @param  subloc  Name of sublocation
   * @param  msgCode Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord warning(Location loc,
						   String   subloc,
						   Object   msgCode) {
                           	
		LogRecord writtenRec = null;
		if (beWarning(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.WARNING, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                MsgType.PLAIN, 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		            	msgCode == null ? null : msgCode.toString(),
		                MSG_ARGS);
		} 
		else if (loc != null && loc.beWarning(this)) {
			loc.logInt(Severity.WARNING, 
									loc, 
									new LogController[] {this}, 
									subloc, 
                                    msgCode == null ? null : msgCode.toString(), 
									null,
									MsgType.PLAIN, 
									MSG_ARGS);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  loc     Location message stems from
   * @param  msgCode Resource name of message template
   * @param  args    Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord warning(Location loc,
						   Object   msgCode,
						   Object[] args) {
		LogRecord writtenRec = null;

		if (beWarning(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.WARNING, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                typeOfMessage(args), 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		            	msgCode == null ? null : msgCode.toString(),
		                args);
		}
		else if (loc != null && loc.beWarning(this)) {
			loc.logInt(Severity.WARNING, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
                                    msgCode == null ? null : msgCode.toString(), 
									null,
									MsgType.JAVA, 
									args);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  loc     Location message stems from
   * @param  subloc  Name of sublocation
   * @param  msgCode Resource name of message template
   * @param  args    Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord warning(Location loc,
						   String   subloc,
						   Object   msgCode,
						   Object[] args) {
  	LogRecord writtenRec = null;

		if (beWarning(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.WARNING, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                typeOfMessage(args), 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		            	msgCode == null ? null : msgCode.toString(),
		                args);
		} 
		else if (loc != null && loc.beWarning(this)) {
			loc.logInt(Severity.WARNING, 
									loc, 
									new LogController[] {this}, 
									subloc, 
                                    msgCode == null ? null : msgCode.toString(), 
									null,
									MsgType.JAVA, 
									args);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  loc      Location message stems from
   * @param  msgCode  Resource name of message
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord warning(Location loc,
						   Object   msgCode,
						   String   msgClear) {
		LogRecord writtenRec = null;
	
		if (beWarning(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.WARNING, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                MsgType.PLAIN, 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msgClear,
		                MSG_ARGS);
		} 
		else if (loc != null && loc.beWarning(this)) {
			loc.logInt(Severity.WARNING, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
                                    msgCode == null ? null : msgCode.toString(), 
									msgClear,
									MsgType.PLAIN, 
									MSG_ARGS);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  loc      Location message stems from
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord warning(Location loc,
						   String   subloc,
						   Object   msgCode,
						   String   msgClear) {
		LogRecord writtenRec = null;

		if (beWarning(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.WARNING, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                MsgType.PLAIN, 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msgClear,
		                MSG_ARGS);
		} 
		else if (loc != null && loc.beWarning(this)) {
			loc.logInt(Severity.WARNING, 
									loc, 
									new LogController[] {this}, 
									subloc, 
                                    msgCode == null ? null : msgCode.toString(), 
									msgClear,
									MsgType.JAVA, 
									MSG_ARGS);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  loc      Location message stems from
   * @param  msgCode  Resource name of message template
   * @param  args     Arguments as object references
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord warning(Location loc,
						   Object   msgCode,
						   Object[] args,
						   String   msgClear) {
		LogRecord writtenRec = null;

		if (beWarning(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.WARNING, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                typeOfMessage(args), 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msgClear,
		                args);
		} 
		else if (loc != null && loc.beWarning(this)) {
			loc.logInt(Severity.WARNING, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
                                    msgCode == null ? null : msgCode.toString(), 
									msgClear,
									MsgType.JAVA, 
									args);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  loc      Location message stems from
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message template
   * @param  args     Arguments as object references
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord warning(Location loc,
						   String   subloc,
						   Object   msgCode,
						   Object[] args,
						   String   msgClear) {
		LogRecord writtenRec = null;

		if (beWarning(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.WARNING, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                typeOfMessage(args), 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msgClear,
		                args);
		} 
		else if (loc != null && loc.beWarning(this)) {
			loc.logInt(Severity.WARNING, 
									loc, 
									new LogController[] {this}, 
									subloc, 
                                    msgCode == null ? null : msgCode.toString(), 
									msgClear,
									MsgType.JAVA, 
									args);
		}
		return writtenRec;
  }

	//***************************************************************
	//     									ERROR METHODS
	//***************************************************************
  
  /**
   * Same as
   * {@link #logT(int,
   *              Location,
   *              java.lang.String)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  loc Location message stems from
   * @param  msg Message text
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord errorT(Location loc,
						  String   msg) {           	
  	LogRecord writtenRec = null;
	
		if (beError(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.ERROR, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                MsgType.PLAIN, 
		                null,
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msg,
		                MSG_ARGS);
		} 
		else if (loc != null && loc.beError(this)) {
			loc.logTInt(Severity.ERROR, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
									msg, 
									MsgType.PLAIN, 
									MSG_ARGS,
                                    null,
                                    null,
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Location,
   *              java.lang.String,
   *              java.lang.String)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  loc    Location message stems from
   * @param  subloc Name of sublocation
   * @param  msg    Message text
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord errorT(Location loc,
						  String   subloc,
						  String   msg) {
		LogRecord writtenRec = null;

		if (beError(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.ERROR, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                MsgType.PLAIN, 
		                null,
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msg,
		                MSG_ARGS);
		}
		else if (loc != null && loc.beError(this)) {
			loc.logTInt(Severity.ERROR, 
									loc, 
									new LogController[] {this}, 
									subloc, 
									msg, 
									MsgType.PLAIN, 
									MSG_ARGS,
                                    null,
                                    null,
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Location,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  loc  Location message stems from
   * @param  msg  Message template
   * @param  args Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord errorT(Location loc,
						  String   msg,
						  Object[] args) {
  	LogRecord writtenRec = null;

		if (beError(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.ERROR, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                typeOfMessage(args), 
		                null,
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msg,
		                args);
		} 
		else if (loc != null && loc.beError(this)) {
			loc.logTInt(Severity.ERROR, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
									msg, 
									MsgType.JAVA, 
									args,
                                    null,
                                    null,
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Location,
   *              java.lang.String,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  loc    Location message stems from
   * @param  subloc Name of sublocation
   * @param  msg    Message template
   * @param  args   Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord errorT(Location loc,
						  String   subloc,
						  String   msg,
						  Object[] args) {
		LogRecord writtenRec = null;

		if (beError(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.ERROR, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                typeOfMessage(args), 
		                null,
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msg,
		                args);
		} 
		else if (loc != null && loc.beError(this)) {
			loc.logTInt(Severity.ERROR, 
									loc, 
									new LogController[] {this}, 
									subloc, 
									msg, 
									MsgType.JAVA, 
									args,
                                    null,
                                    null,
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName);
		} 
		return writtenRec;
  }

  /**
	 * Same as
	 * {@link #log(int,
	 *             Location,
	 *             MsgObject)}
	 * but always emits an error message, that is a message of severity
	 * {@link Severity#ERROR}.
	 * @param  loc     		Location message stems from
	 * @param  MsgObject  Message object of message
	 * @return Log record if written via a log of this log controller or null
	 */
	public LogRecord error(Location 	loc,
						   					 MsgObject  msgObject) {
		// Guardian
		if (msgObject == null) return null;
		
	  LogRecord writtenRec = null;

	  if (beError(loc)) {
		  writtenRec = 
		  logSeverityInt (Severity.ERROR, 
										  loc, 
										  new LogController[] {loc}, 	
										  MSG_SUB_LOC,
                                          null,
                                          MsgType.PLAIN,                                          
										  msgObject.getMsgKeyAndID(),
                                          (loc == null) ? null : loc.csnComponent,
                                          (loc == null) ? null : loc.dcName,
 										  msgObject.getMsgText(), 
										  MSG_ARGS);
	  } 
	  else if (loc != null && loc.beError(this)) {
		  loc.logInt(Severity.ERROR, 
								  loc, 
								  new LogController[] {this}, 
								  MSG_SUB_LOC, 
									msgObject.getMsgKeyAndID(),
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName,
									msgObject.getMsgText(),
								  MsgType.PLAIN, 
								  MSG_ARGS,
                                  null);
	  }
	  return writtenRec;
	}

	/**
	 * Same as
	 * {@link #log(int,
	 *             Location,
	 *             MsgObject,
	 * 						 java.lang.Object[])}
	 * but always emits an error message, that is a message of severity
	 * {@link Severity#ERROR}.
	 * @param  loc     		Location message stems from
	 * @param  MsgObject  Message object of message
	 * @param  args    		Arguments as object references
	 * @return Log record if written via a log of this log controller or null
	 */
	public LogRecord error(Location 	loc,
											 	 MsgObject  msgObject,
											 	 Object[]		args) {
	
		// Guardian
		if (msgObject == null) return null;
	
	  LogRecord writtenRec = null;

	  if (beError(loc)) {
		  writtenRec = 
		  logSeverityInt (Severity.ERROR, 
										  loc, 
										  new LogController[] {loc}, 	
										  MSG_SUB_LOC,
                                          null,
                                          MsgType.JAVA,
											msgObject.getMsgKeyAndID(),
                                            (loc == null) ? null : loc.csnComponent,
                                            (loc == null) ? null : loc.dcName,
											msgObject.getMsgText(), 
											args);
	  } 
	  else if (loc != null && loc.beError(this)) {
		  loc.logInt(Severity.ERROR, 
								  loc, 
								  new LogController[] {this}, 
								  MSG_SUB_LOC, 
									msgObject.getMsgKeyAndID(), 
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName,
									msgObject.getMsgText(),
								  MsgType.JAVA, 
									args,
                                    null);
	  }
	  return writtenRec;
	}

	/**
	 * Same as
	 * {@link #log(int,
	 *             Location,
	 * 						 java.lang.String,
	 *             MsgObject)}
	 * but always emits an error message, that is a message of severity
	 * {@link Severity#ERROR}.
	 * @param  loc     		Location message stems from
	 * @param  subloc  		Name of sublocation
	 * @param  MsgObject  Message object of message
	 * @return Log record if written via a log of this log controller or null
	 */
	public LogRecord error(Location 	loc,
												 String			subLoc,
											 	 MsgObject  msgObject) {
	
		// Guardian
		if (msgObject == null) return null;
	
	  LogRecord writtenRec = null;

	  if (beError(loc)) {
		  writtenRec = 
		  logSeverityInt (Severity.ERROR, 
										  loc, 
										  new LogController[] {loc}, 	
											subLoc,
                                            null,
                                            MsgType.PLAIN,
											msgObject.getMsgKeyAndID(),
                                            (loc == null) ? null : loc.csnComponent,
                                            (loc == null) ? null : loc.dcName,
											msgObject.getMsgText(), 
										  MSG_ARGS);
	  } 
	  else if (loc != null && loc.beError(this)) {
		  loc.logInt(Severity.ERROR, 
								  loc, 
								  new LogController[] {this}, 
									subLoc, 
									msgObject.getMsgKeyAndID(),
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName,
									msgObject.getMsgText(),
								  MsgType.PLAIN, 
								  MSG_ARGS,
                                  null);
	  }
	  return writtenRec;
	}

	/**
	 * Same as
	 * {@link #log(int,
	 *             Location,
	 * 						 java.lang.String,
	 *             MsgObject,
	 * 						 java.lang.Object[])}
	 * but always emits an error message, that is a message of severity
	 * {@link Severity#ERROR}.
	 * @param  loc     		Location message stems from
	 * @param  subloc  		Name of sublocation
	 * @param  MsgObject  Message object of message
	 * @param  args    		Arguments as object references
	 * @return Log record if written via a log of this log controller or null
	 */
	public LogRecord error(Location 	loc,
												 String			subLoc,
												 MsgObject  msgObject,
												 Object[]		args) {

		// Guardian
		if (msgObject == null) return null;

	  LogRecord writtenRec = null;

	  if (beError(loc)) {
		  writtenRec = 
		  logSeverityInt (Severity.ERROR, 
										  loc, 
										  new LogController[] {loc}, 	
											subLoc, 
                                            null,
                                            MsgType.JAVA,
											msgObject.getMsgKeyAndID(),
                                            (loc == null) ? null : loc.csnComponent,
                                            (loc == null) ? null : loc.dcName,
											msgObject.getMsgText(), 
											args);
	  } 
	  else if (loc != null && loc.beError(this)) {
		  loc.logInt(Severity.ERROR, 
								  loc, 
								  new LogController[] {this}, 
									subLoc, 
									msgObject.getMsgKeyAndID(),
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName,
									msgObject.getMsgText(),
								  MsgType.JAVA, 
									args,
                                    null);
	  }
	  return writtenRec;
	}

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.Object)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  loc     Location message stems from
   * @param  msgCode Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   */
	
	/**
	* @deprecated
	*/
  public LogRecord error(Location loc,
						 Object   msgCode) {
		LogRecord writtenRec = null;

		if (beError(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.ERROR, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                MsgType.PLAIN, 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		            	msgCode == null ? null : msgCode.toString(),
		                MSG_ARGS);
		} 
		else if (loc != null && loc.beError(this)) {
			loc.logInt(Severity.ERROR, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
                                    msgCode == null ? null : msgCode.toString(), 
									null,
									MsgType.PLAIN, 
									MSG_ARGS);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.String,
   *             java.lang.Object)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  loc     Location message stems from
   * @param  subloc  Name of sublocation
   * @param  msgCode Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord error(Location loc,
						 String   subloc,
						 Object   msgCode) {
		LogRecord writtenRec = null;

		if (beError(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.ERROR, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                MsgType.PLAIN, 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		            	msgCode == null ? null : msgCode.toString(),
		                MSG_ARGS);
		} 
		else if (loc != null && loc.beError(this)) {
			loc.logInt(Severity.ERROR, 
									loc, 
									new LogController[] {this}, 
									subloc, 
                                    msgCode == null ? null : msgCode.toString(), 
									null,
									MsgType.PLAIN, 
									MSG_ARGS);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  loc     Location message stems from
   * @param  msgCode Resource name of message template
   * @param  args    Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord error(Location loc,
						 Object   msgCode,
						 Object[] args) {
		LogRecord writtenRec = null;

		if (beError(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.ERROR, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                typeOfMessage(args), 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		            	msgCode == null ? null : msgCode.toString(),
		                args);
		}
		else if (loc != null && loc.beError(this)) {
			loc.logInt(Severity.ERROR, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
                                    msgCode == null ? null : msgCode.toString(), 
									null,
									MsgType.JAVA, 
									args);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  loc     Location message stems from
   * @param  subloc  Name of sublocation
   * @param  msgCode Resource name of message template
   * @param  args    Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord error(Location loc,
						 String   subloc,
						 Object   msgCode,
						 Object[] args) {
		LogRecord writtenRec = null;

		if (beError(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.ERROR, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                typeOfMessage(args), 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		            	msgCode == null ? null : msgCode.toString(),
		                args);
		} 
		else if (loc != null && loc.beError(this)) {
			loc.logInt(Severity.ERROR, 
									loc, 
									new LogController[] {this}, 
									subloc, 
                                    msgCode == null ? null : msgCode.toString(), 
									null,
									MsgType.JAVA, 
									args);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  loc      Location message stems from
   * @param  msgCode  Resource name of message
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord error(Location loc,
						 Object   msgCode,
						 String   msgClear) {
		LogRecord writtenRec = null;

		if (beError(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.ERROR, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                MsgType.PLAIN, 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msgClear,
		                MSG_ARGS);
		} 
		else if (loc != null && loc.beError(this)) {
			loc.logInt(Severity.ERROR, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
                                    msgCode == null ? null : msgCode.toString(), 
									msgClear,
									MsgType.PLAIN, 
									MSG_ARGS);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  loc      Location message stems from
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord error(Location loc,
						 String   subloc,
						 Object   msgCode,
						 String   msgClear) {
		LogRecord writtenRec = null;

		if (beError(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.ERROR, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                MsgType.PLAIN, 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msgClear,
		                MSG_ARGS);
		} 
		else if (loc != null && loc.beError(this)) {
			loc.logInt(Severity.ERROR, 
									loc, 
									new LogController[] {this}, 
									subloc, 
                                    msgCode == null ? null : msgCode.toString(), 
									msgClear,
									MsgType.JAVA, 
									MSG_ARGS);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  loc      Location message stems from
   * @param  msgCode  Resource name of message template
   * @param  args     Arguments as object references
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord error(Location loc,
						 Object   msgCode,
						 Object[] args,
						 String   msgClear) {
		LogRecord writtenRec = null;

		if (beError(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.ERROR, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                typeOfMessage(args), 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msgClear,
		                args);
		} 
		else if (loc != null && loc.beError(this)) {
			loc.logInt(Severity.ERROR, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
                                    msgCode == null ? null : msgCode.toString(), 
									msgClear,
									MsgType.JAVA, 
									args);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  loc      Location message stems from
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message template
   * @param  args     Arguments as object references
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord error(Location loc,
						 String   subloc,
						 Object   msgCode,
						 Object[] args,
						 String   msgClear) {
  	LogRecord writtenRec = null;

		if (beError(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.ERROR, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                typeOfMessage(args), 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msgClear,
		                args);
		} 
		else if (loc != null && loc.beError(this)) {
			loc.logInt(Severity.ERROR, 
									loc, 
									new LogController[] {this}, 
									subloc, 
                                    msgCode == null ? null : msgCode.toString(), 
									msgClear,
									MsgType.JAVA, 
									args);
		}
		return writtenRec;
  }

  //***************************************************************
  //     									FATAL METHODS
  //***************************************************************
  
  /**
   * Same as
   * {@link #logT(int,
   *             Location,
   *             java.lang.String)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  loc Location message stems from
   * @param  msg Message text
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord fatalT(Location loc,
						  String   msg) {
		
		LogRecord writtenRec = null;
		if (beFatal(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.FATAL, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                MsgType.PLAIN, 
		                null,
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msg,
		                MSG_ARGS);
		} 
		else if (loc != null && loc.beFatal(this)) {
			loc.logTInt(Severity.FATAL, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
									msg, 
									MsgType.PLAIN, 
									MSG_ARGS,
                                    null,
                                    null,
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Location,
   *              java.lang.String,
   *              java.lang.String)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  loc    Location message stems from
   * @param  subloc Name of sublocation
   * @param  msg    Message text
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord fatalT(Location loc,
						  String   subloc,
						  String   msg) {
                          	
		LogRecord writtenRec = null;
		if (beFatal(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.FATAL, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                MsgType.PLAIN, 
		                null,
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msg,
		                MSG_ARGS);
		}
		else if (loc != null && loc.beFatal(this)) {
			loc.logTInt(Severity.FATAL, 
									loc, 
									new LogController[] {this}, 
									subloc, 
									msg, 
									MsgType.PLAIN, 
									MSG_ARGS,
                                    null,
                                    null,
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *             Location,
   *             java.lang.String,
   *             java.lang.Object[])}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  loc  Location message stems from
   * @param  msg  Message template
   * @param  args Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord fatalT(Location loc,
						  String   msg,
						  Object[] args) {
		LogRecord writtenRec = null;

		if (beFatal(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.FATAL, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                typeOfMessage(args), 
		                null,
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msg,
		                args);
		} 
		else if (loc != null && loc.beFatal(this)) {
			loc.logTInt(Severity.FATAL, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
									msg, 
									MsgType.JAVA, 
									args,
                                    null,
                                    null,
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Location,
   *              java.lang.String,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  loc    Location message stems from
   * @param  subloc Name of sublocation
   * @param  msg    Message template
   * @param  args   Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord fatalT(Location loc,
						  String   subloc,
						  String   msg,
						  Object[] args) {
		
		LogRecord writtenRec = null;
		if (beFatal(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.FATAL, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                typeOfMessage(args), 
		                null,
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msg,
		                args);
		} 
		else if (loc != null && loc.beFatal(this)) {
			loc.logTInt(Severity.FATAL, 
									loc, 
									new LogController[] {this}, 
									subloc, 
									msg, 
									MsgType.JAVA, 
									args,
                                    null,
                                    null,
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName);
		} 
		return writtenRec;
  }

  
  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             MsgObject)}
   * but always emits an fatal message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  loc     		Location message stems from
   * @param  MsgObject  Message object of message
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord fatal(Location 	loc,
										   	 MsgObject  msgObject) {
	
	  // Guardian
	  if (msgObject == null) return null;
	
		LogRecord writtenRec = null;
	
		if (beFatal(loc)) {
			writtenRec = 
			logSeverityInt (Severity.FATAL, 
											loc, 
											new LogController[] {loc}, 	
											MSG_SUB_LOC,
                                            null,
                                            MsgType.PLAIN,
											msgObject.getMsgKeyAndID(),
                                            (loc == null) ? null : loc.csnComponent,
                                            (loc == null) ? null : loc.dcName,
											msgObject.getMsgText(), 
											MSG_ARGS);
		} 
		else if (loc != null && loc.beFatal(this)) {
			loc.logInt(Severity.FATAL, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
									msgObject.getMsgKeyAndID(),
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName,
									msgObject.getMsgText(),
									MsgType.PLAIN, 
									MSG_ARGS,
                                    null);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             MsgObject,
   * 						 java.lang.Object[])}
   * but always emits an fatal message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  loc     		Location message stems from
   * @param  MsgObject  Message object of message
   * @param  args    		Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord fatal(Location 	loc,
											   MsgObject  msgObject,
											   Object[]		args) {

	  // Guardian
	  if (msgObject == null) return null;

		LogRecord writtenRec = null;
	
		if (beFatal(loc)) {
			writtenRec = 
			logSeverityInt (Severity.FATAL, 
											loc, 
											new LogController[] {loc}, 	
											MSG_SUB_LOC,
                                            null,
                                            MsgType.JAVA,
											msgObject.getMsgKeyAndID(),
                                            (loc == null) ? null : loc.csnComponent,
                                            (loc == null) ? null : loc.dcName,
											msgObject.getMsgText(), 
											args);
		} 
		else if (loc != null && loc.beFatal(this)) {
			loc.logInt(Severity.FATAL, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
									msgObject.getMsgKeyAndID(),
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName,
									msgObject.getMsgText(),
									MsgType.JAVA, 
									args,
                                    null);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   * 						 java.lang.String,
   *             MsgObject)}
   * but always emits an fatal message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  loc     		Location message stems from
   * @param  subloc  		Name of sublocation
   * @param  MsgObject  Message object of message
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord fatal(Location 	loc,
											   String			subLoc,
											   MsgObject  msgObject) {

	  // Guardian
	  if (msgObject == null) return null;

		LogRecord writtenRec = null;
	
		if (beFatal(loc)) {
			writtenRec = 
			logSeverityInt (Severity.FATAL, 
											loc, 
											new LogController[] {loc}, 	
											subLoc, 
                                            null,
                                            MsgType.PLAIN,
											msgObject.getMsgKeyAndID(),
                                            (loc == null) ? null : loc.csnComponent,
                                            (loc == null) ? null : loc.dcName,
											msgObject.getMsgText(), 
											MSG_ARGS);
		} 
		else if (loc != null && loc.beFatal(this)) {
			loc.logInt(Severity.FATAL, 
									loc, 
									new LogController[] {this}, 
									subLoc, 
									msgObject.getMsgKeyAndID(), 
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName,
									msgObject.getMsgText(),
									MsgType.PLAIN, 
									MSG_ARGS,
                                    null);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   * 						 java.lang.String,
   *             MsgObject,
   * 						 java.lang.Object[])}
   * but always emits an fatal message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  loc     		Location message stems from
   * @param  subloc  		Name of sublocation
   * @param  MsgObject  Message object of message
   * @param  args    		Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord fatal(Location 	loc,
											   String			subLoc,
											   MsgObject  msgObject,
											   Object[]		args) {

	  // Guardian
	  if (msgObject == null) return null;

		LogRecord writtenRec = null;
	
		if (beFatal(loc)) {
			writtenRec = 
			logSeverityInt (Severity.FATAL, 
											loc, 
											new LogController[] {loc}, 	
											subLoc,
                                            null,
                                            MsgType.JAVA,
											msgObject.getMsgKeyAndID(),
                                            (loc == null) ? null : loc.csnComponent,
                                            (loc == null) ? null : loc.dcName,
											msgObject.getMsgText(), 
											args);
		} 
		else if (loc != null && loc.beFatal(this)) {
			loc.logInt(Severity.FATAL, 
									loc, 
									new LogController[] {this}, 
									subLoc, 
									msgObject.getMsgKeyAndID(),
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName,
									msgObject.getMsgText(),
									MsgType.JAVA, 
									args,
                                    null);
		}
		return writtenRec;
  }

  
  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.Object)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  loc     Location message stems from
   * @param  msgCode Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord fatal(Location loc,
						 Object   msgCode) {
		LogRecord writtenRec = null;
		if (beFatal(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.FATAL, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                MsgType.PLAIN, 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		            	msgCode == null ? null : msgCode.toString(),
		                MSG_ARGS);
		} 
		else if (loc != null && loc.beFatal(this)) {
			loc.logInt(Severity.FATAL, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
                                    msgCode == null ? null : msgCode.toString(), 
									null,
									MsgType.PLAIN, 
									MSG_ARGS);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.String,
   *             java.lang.Object)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  loc     Location message stems from
   * @param  subloc  Name of sublocation
   * @param  msgCode Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord fatal(Location loc,
						 String   subloc,
						 Object   msgCode) {
		LogRecord writtenRec = null;

		if (beFatal(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.FATAL, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                MsgType.PLAIN, 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		            	msgCode == null ? null : msgCode.toString(),
		                MSG_ARGS);
		} 
		else if (loc != null && loc.beFatal(this)) {
			loc.logInt(Severity.FATAL, 
									loc, 
									new LogController[] {this}, 
									subloc, 
                                    msgCode == null ? null : msgCode.toString(), 
									null,
									MsgType.PLAIN, 
									MSG_ARGS);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  loc     Location message stems from
   * @param  msgCode Resource name of message template
   * @param  args    Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord fatal(Location loc,
						 Object   msgCode,
						 Object[] args) {
		LogRecord writtenRec = null;
		if (beFatal(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.FATAL, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                typeOfMessage(args), 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		            	msgCode == null ? null : msgCode.toString(),
		                args);
		}
		else if (loc != null && loc.beFatal(this)) {
			loc.logInt(Severity.FATAL, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
                                    msgCode == null ? null : msgCode.toString(), 
									null,
									MsgType.JAVA, 
									args);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  loc     Location message stems from
   * @param  subloc  Name of sublocation
   * @param  msgCode Resource name of message template
   * @param  args    Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord fatal(Location loc,
						 String   subloc,
						 Object   msgCode,
						 Object[] args) {
		LogRecord writtenRec = null;

		if (beFatal(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.FATAL, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                typeOfMessage(args), 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		            	msgCode == null ? null : msgCode.toString(),
		                args);
		} 
		else if (loc != null && loc.beFatal(this)) {
			loc.logInt(Severity.FATAL, 
									loc, 
									new LogController[] {this}, 
									subloc, 
                                    msgCode == null ? null : msgCode.toString(), 
									null,
									MsgType.JAVA, 
									args);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  loc      Location message stems from
   * @param  msgCode  Resource name of message
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord fatal(Location loc,
						 Object   msgCode,
						 String   msgClear) {
		LogRecord writtenRec = null;

		if (beFatal(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.FATAL, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                MsgType.PLAIN, 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msgClear,
		                MSG_ARGS);
		} 
		else if (loc != null && loc.beFatal(this)) {
			loc.logInt(Severity.FATAL, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
                                    msgCode == null ? null : msgCode.toString(), 
									msgClear,
									MsgType.PLAIN, 
									MSG_ARGS);
		}
		return writtenRec;
  }


  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  loc      Location message stems from
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord fatal(Location loc,
						 String   subloc,
						 Object   msgCode,
						 String   msgClear) {
                         	
		LogRecord writtenRec = null;
		if (beFatal(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.FATAL, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                MsgType.PLAIN, 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msgClear,
		                MSG_ARGS);
		} 
		else if (loc != null && loc.beFatal(this)) {
			loc.logInt(Severity.FATAL, 
									loc, 
									new LogController[] {this}, 
									subloc, 
                                    msgCode == null ? null : msgCode.toString(), 
									msgClear,
									MsgType.JAVA, 
									MSG_ARGS);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  loc      Location message stems from
   * @param  msgCode  Resource name of message template
   * @param  args     Arguments as object references
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord fatal(Location loc,
						 Object   msgCode,
						 Object[] args,
						 String   msgClear) {
		LogRecord writtenRec = null;

		if (beFatal(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.FATAL, 
		                loc, 
		                new LogController[] {loc},  
		                MSG_SUB_LOC,
		                null,
		                typeOfMessage(args), 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msgClear,
		                args);
		} 
		else if (loc != null && loc.beFatal(this)) {
			loc.logInt(Severity.FATAL, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
                                    msgCode == null ? null : msgCode.toString(), 
									msgClear,
									MsgType.JAVA, 
									args);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Location,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  loc      Location message stems from
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message template
   * @param  args     Arguments as object references
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated
   */
  public LogRecord fatal(Location loc,
						 String   subloc,
						 Object   msgCode,
						 Object[] args,
						 String   msgClear) {
		LogRecord writtenRec = null;

		if (beFatal(loc)) {
			writtenRec = 
		        logSeverityInt (Severity.FATAL, 
		                loc, 
		                new LogController[] {loc},  
		                subloc,
		                null,
		                typeOfMessage(args), 
		                msgCode == null ? null : msgCode.toString(),
		               (loc == null) ? null : loc.csnComponent,
		               (loc == null) ? null : loc.dcName,
		                msgClear,
		                args);
		} 
		else if (loc != null && loc.beFatal(this)) {
			loc.logInt(Severity.FATAL, 
									loc, 
									new LogController[] {this}, 
									subloc, 
                                    msgCode == null ? null : msgCode.toString(), 
									msgClear,
									MsgType.JAVA, 
									args);
		}
		return writtenRec;
  }

	//***************************************************
  //  THROWING
  // ***************************************************
	
  /**
  * Logs message with stack trace of given exception,
  * from the given location into this category.
  * @param  severity Severity of message
  * @param  loc      Location message stems from
  * @param  msg    Message template
  * @param  exc 			Throwable, the superclass of all errors and exceptions 
  * @return Log record if written via a log of this log controller or null
  * @see    #setResourceBundleName(java.lang.String)
  */
 	public LogRecord logThrowableT(int 				severity,
																 Location 	loc,
																 String   	msg,
																 Throwable 	exc) {
		LogRecord writtenRec = null;

	  if (beLogged(severity)) {		  
			writtenRec = 
				logTInt(severity, 
								loc, 
								new LogController[] {this}, 
								MSG_SUB_LOC, 
								msg, 
								MsgType.PLAIN, 
								MSG_ARGS,
								exc,
                                null,
                                (loc == null) ? null : loc.csnComponent,
                                (loc == null) ? null : loc.dcName);
		} 
		
	  if (loc != null) {
			loc.logTInt(severity, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
									msg, 
									MsgType.JAVA, 
									MSG_ARGS,
									exc,
                                    null,
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName);
		}
		else {
			handleLCNull("logThrowableT()", msg, MSG_ARGS, exc);
		}
		return writtenRec;
 }

 /**
  * Logs message with stack trace of given exception,
  * from the given location into this category.
  * @param  severity Severity of message
  * @param  loc      Location message stems from
  * @param  subloc Name of sublocation
  * @param  msg    Message template
  * @param  exc 			Throwable, the superclass of all errors and exceptions 
  * @return Log record if written via a log of this log controller or null
  * @see    #setResourceBundleName(java.lang.String)
  */
 	public LogRecord logThrowableT(int 				severity,
																 Location 	loc,
																 String    	subloc,
																 String    	msg,
																 Throwable 	exc) {
		LogRecord writtenRec = null;
	
	  if (beLogged(severity)) {
			writtenRec = 
				logTInt(severity, 
								loc, 
								new LogController[] {this}, 
								subloc, 
								msg, 
								MsgType.PLAIN, 
								MSG_ARGS,
								exc,
                                null,
                                (loc == null) ? null : loc.csnComponent,
                                (loc == null) ? null : loc.dcName);
		} 

	  if (loc != null){
			loc.logTInt(severity, 
									loc, 
									new LogController[] {this}, 
									subloc, 
									msg, 
									MsgType.JAVA, 
									MSG_ARGS,
									exc,
                                    null,
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName);
		}
		else {
			handleLCNull("logThrowableT()", msg, MSG_ARGS, exc);
		}
	  return writtenRec;
	}

 	/**
  * Logs message with stack trace of given exception,
  * from the given location into this category.
  * @param  severity Severity of message
  * @param  loc      Location message stems from
  * @param  msg    Message template
  * @param  args   Arguments as object references
  * @param  exc 			Throwable, the superclass of all errors and exceptions 
  * @return Log record if written via a log of this log controller or null
  * @see    #setResourceBundleName(java.lang.String)
  */
 	public LogRecord logThrowableT(int 				severity, 
															   Location 	loc,
																 String   	msg,
																 Object[] 	args,
																 Throwable exc) {
		LogRecord writtenRec = null;
	
	  if (beLogged(severity)) {
			writtenRec = 
				logTInt(severity, 
								loc, 
								new LogController[] {this}, 
								MSG_SUB_LOC, 
								msg, 
								MsgType.JAVA, 
								args,
								exc,
                                null,
                                (loc == null) ? null : loc.csnComponent,
                                (loc == null) ? null : loc.dcName);
		} 
	  
	  if (loc != null) {		  	
			loc.logTInt(severity, 
									loc, 
									new LogController[] {this}, 
									MSG_SUB_LOC, 
									msg, 
									MsgType.JAVA, 
									args,
									exc,
                                    null,
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName);
		}
		else {
			handleLCNull("logThrowableT()", msg, args, exc);
		}
	  return writtenRec;
 	}

 	/**
  * Logs message with stack trace of given exception,
  * from the given location into this category.
  * @param  severity Severity of message
  * @param  loc      Location message stems from
  * @param  subloc Name of sublocation
  * @param  msg    Message template
  * @param  args   Arguments as object references
  * @param  exc 			Throwable, the superclass of all errors and exceptions 
  * @return Log record if written via a log of this log controller or null
  * @see    #setResourceBundleName(java.lang.String)
  */
 	public LogRecord logThrowableT(int 				severity,
															   Location 	loc,
																 String   	subloc,
																 String   	msg,
																 Object[] 	args,
																 Throwable exc) {
		LogRecord writtenRec = null;
	
	  if (beLogged(severity)) {
			writtenRec = 
				logTInt(severity, 
								loc, 
								new LogController[] {this}, 
								subloc, 
								msg, 
								MsgType.JAVA, 
								args,
								exc,
                                null,
                                (loc == null) ? null : loc.csnComponent,
                                (loc == null) ? null : loc.dcName);
		} 
		
	  if (loc != null){
			loc.logTInt(severity, 
									loc, 
									new LogController[] {this}, 
									subloc, 
									msg, 
									MsgType.JAVA, 
									args,
									exc,
                                    null,
                                    (loc == null) ? null : loc.csnComponent,
                                    (loc == null) ? null : loc.dcName);
		}
		else {
			handleLCNull("logThrowableT()",	msg, args, exc);
		}
	  return writtenRec;
 	}

	/**
	* Logs message with stack trace of given exception,
	* from the given location into this category.
	* @param  severity Severity of message
	* @param  loc      	Location message stems from
	* @param  msgObject Message object of message
	* @param  exc 			Throwable, the superclass of all errors and exceptions 
	* @return Log record if written via a log of this log controller or null
	*/
	public LogRecord logThrowable(int 			severity,
																Location 	loc,
															  MsgObject msgObject,
															  Throwable exc) {
   
		//Guardian
		if (msgObject == null) return null;
		
		LogRecord writtenRec = null;
		String 		msgClear   = msgObject.getMsgText();
		
	  if (beLogged(severity)) {
			writtenRec = 
				logInt (severity, 
								loc, 
								new LogController[] {loc}, 	
								MSG_SUB_LOC, 
								msgObject.getMsgKeyAndID(), 
                                (loc == null) ? null : loc.csnComponent,
                                (loc == null) ? null : loc.dcName,
								msgClear, 
								MsgType.PLAIN,
								MSG_ARGS,
								exc);
		} 
	
	  if (loc != null){
			loc.logInt(severity,
								 loc,
								 new LogController[] {this},
								 MSG_SUB_LOC,
								 msgObject.getMsgKeyAndID(),
                                 (loc == null) ? null : loc.csnComponent,
                                 (loc == null) ? null : loc.dcName,
								 msgClear,
								 MsgType.JAVA,								
								 MSG_ARGS,
								 exc);		  
	  }
	  else {
			handleLCNull("logThrowable(...)", msgClear, MSG_ARGS, exc);
		}
	  return writtenRec;
	}

	/**
	* Logs message with stack trace of given exception,
	* from the given location into this category.
	* @param  severity Severity of message
	* @param  loc      	Location message stems from
	* @param  msgObject Message object of message
	* @param  args     	Arguments as object references
	* @param  exc 			Throwable, the superclass of all errors and exceptions 
	* @return Log record if written via a log of this log controller or null
	*/
	public LogRecord logThrowable(int 				severity,
																	Location 	loc,
																  MsgObject msgObject,
																  Object[]	args,
																  Throwable exc) {
   
				//Guardian
		if (msgObject == null) return null;
	
		LogRecord writtenRec = null;
		String 		msgClear   = msgObject.getMsgText();
	
	  if (beLogged(severity)) {
			writtenRec = 
				logInt (severity, 
								loc, 
								new LogController[] {loc}, 	
								MSG_SUB_LOC, 
                                msgObject.getMsgKeyAndID(), 
                                (loc == null) ? null : loc.csnComponent,
                                (loc == null) ? null : loc.dcName,
								msgClear,
                                MsgType.JAVA,
								args,
                                exc);
		} 
	
	  if (loc != null){
			loc.logInt(severity,
								 loc,
								 new LogController[] {this},
								 MSG_SUB_LOC,
								 msgObject.getMsgKeyAndID(),
                                 (loc == null) ? null : loc.csnComponent,
                                 (loc == null) ? null : loc.dcName,
								 msgClear,
								 MsgType.JAVA,								
								 args,
								 exc);		  
	  }
	  else {
			handleLCNull("logThrowable(...)", msgClear, args, exc);
		}
	  return writtenRec;
	}

	/**
	* Logs message with stack trace of given exception,
	* from the given location into this category.
	* @param  severity Severity of message
	* @param  loc      	Location message stems from
	* @param  subloc   	Name of sublocation
	* @param  msgObject Message object of message
	* @param  exc 			Throwable, the superclass of all errors and exceptions 
	* @return Log record if written via a log of this log controller or null
	*/
		public LogRecord logThrowable(int 			severity,
																	Location 	loc,
																	String		subLoc,
																  MsgObject msgObject,
																  Throwable exc) {
   
			//Guardian
		if (msgObject == null) return null;
	
		LogRecord writtenRec = null;
		String 		msgClear   = msgObject.getMsgText();
	
	  if (beLogged(severity)) {
			writtenRec = 
				logInt (severity, 
								loc, 
								new LogController[] {loc}, 	
							  subLoc, 
								msgObject.getMsgKeyAndID(),
                                (loc == null) ? null : loc.csnComponent,
                                (loc == null) ? null : loc.dcName,
								msgClear, 
								MsgType.PLAIN,
								MSG_ARGS,
								exc);
		} 

	  if (loc != null){
			loc.logInt(severity,
								 loc,
								 new LogController[] {this},
								 subLoc,
								 msgObject.getMsgKeyAndID(),
                                 (loc == null) ? null : loc.csnComponent,
                                 (loc == null) ? null : loc.dcName,
								 msgClear,
								 MsgType.JAVA,								
								 MSG_ARGS,
								 exc);		  
	  }
	  else {
			handleLCNull("logThrowable(...)", msgClear, MSG_ARGS, exc);
		}
	  return writtenRec;
	}

	/**
	* Logs message with stack trace of given exception,
	* from the given location into this category.
	* @param  severity Severity of message
	* @param  loc      	Location message stems from
	* @param  subloc   	Name of sublocation
	* @param  msgObject Message object of message
	* @param  args     	Arguments as object references
	* @param  exc 			Throwable, the superclass of all errors and exceptions 
	* @return Log record if written via a log of this log controller or null
	*/
	public LogRecord logThrowable(int 			severity,
																Location 	loc,
																String		subLoc,
																MsgObject msgObject,
																Object[]	args,
																Throwable exc) {
   
					//Guardian
		if (msgObject == null) return null;

		LogRecord writtenRec = null;
		String 		msgClear   = msgObject.getMsgText();

	  if (beLogged(severity)) {
			writtenRec = 
				logInt (severity, 
								loc, 
								new LogController[] {loc}, 	
								subLoc, 
								msgObject.getMsgKeyAndID(),
                                (loc == null) ? null : loc.csnComponent,
                                (loc == null) ? null : loc.dcName,
								msgClear, 
								MsgType.JAVA,
								args,
								exc);
		} 

	  if (loc != null){
			loc.logInt(severity,
								 loc,
								 new LogController[] {this},
								 subLoc,
								 msgObject.getMsgKeyAndID(),
                                 (loc == null) ? null : loc.csnComponent,
                                 (loc == null) ? null : loc.dcName,
								 msgClear,
								 MsgType.JAVA,								
								 args,
								 exc);		  
	  }
	  else {
			handleLCNull("logThrowable(...)", msgClear, args, exc);
		}
	  return writtenRec;
	}

 	/**
	* Logs message with stack trace of given exception,
	* from the given location into this category.
	* @param  severity Severity of message
	* @param  loc      Location message stems from
	* @param  msgCode  Resource name of message template
	* @param  msgClear Clear text version of message
	* @param  exc 			Throwable, the superclass of all errors and exceptions 
	* @return Log record if written via a log of this log controller or null
	* @see    #setResourceBundleName(java.lang.String)
	* @deprecated
	*/
 	public LogRecord logThrowable(int 			severity,
														    Location 	loc,
															  Object   	msgCode,
															  String   	msgClear,
															  Throwable exc) {
		LogRecord writtenRec = null;
	
	  if (beLogged(severity)) {
			writtenRec = 
		        logTInt(severity, 
		                loc, 
		                new LogController[] {this}, 
		                MSG_SUB_LOC, 
		                msgClear, 
		                MsgType.PLAIN, 
		                MSG_ARGS,
		                exc,
		                msgCode == null ? null : msgCode.toString(),
		                                (loc == null) ? null : loc.csnComponent,
		                                (loc == null) ? null : loc.dcName);
		} 
		
	  if (loc != null){
			loc.logInt(severity,
								 loc,
								 new LogController[] {this},
								 MSG_SUB_LOC,
								 null,
								 msgClear,
								 MsgType.JAVA,								
								 MSG_ARGS,
								 exc);		  
	  }
	  else {
			handleLCNull("logThrowable()", msgClear, MSG_ARGS, exc);
		}
	  return writtenRec;
 	}

 	/**
  * Logs message with stack trace of given exception,
  * from the given location into this category.
  * @param  severity Severity of message
  * @param  loc      Location message stems from
  * @param  subloc   Name of sublocation
  * @param  msgCode  Resource name of message template
  * @param  msgClear Clear text version of message
  * @param  exc 			Throwable, the superclass of all errors and exceptions 
  * @return Log record if written via a log of this log controller or null
  * @see    #setResourceBundleName(java.lang.String)
  * @deprecated
  */
 	public LogRecord logThrowable(int 		 	severity,
														   	Location 	loc,
															 	String   	subloc,
															 	Object   	msgCode,
															 	String   	msgClear,
															  Throwable exc) {
		LogRecord writtenRec = null;
	
	  if (beLogged(severity)) {
			writtenRec = 
		        logTInt(severity, 
		                loc, 
		                new LogController[] {this}, 
		                subloc, 
		                msgClear, 
		                MsgType.PLAIN, 
		                MSG_ARGS,
		                exc,
		                msgCode == null ? null : msgCode.toString(),
		                                (loc == null) ? null : loc.csnComponent,
		                                (loc == null) ? null : loc.dcName);
		} 
	  
	  if (loc!= null){
			loc.logInt(severity,
								 loc,
								 new LogController[] {this},
								 subloc,
								 null,
								 msgClear,
								 MsgType.JAVA,								
								 MSG_ARGS,
								 exc);	
		}
		else {
			handleLCNull("logThrowable()", msgClear, MSG_ARGS, exc);
		}
	  return writtenRec;
 	}

 	/**
  * Logs message with stack trace of given exception,
  * from the given location into this category.
  * @param  severity Severity of message
  * @param  loc      Location message stems from
  * @param  msgCode  Resource name of message template
  * @param  args     Arguments as object references
  * @param  msgClear Clear text version of message
  * @param  exc 			Throwable, the superclass of all errors and exceptions 
  * @return Log record if written via a log of this log controller or null
  * @see    #setResourceBundleName(java.lang.String)
  * @deprecated
  */
 	public LogRecord logThrowable(int 		 	severity,
														    Location 	loc,
														    Object   	msgCode,
														    Object[] 	args,
														    String   	msgClear,
															  Throwable exc) {
		LogRecord writtenRec = null;
	
	  if (beLogged(severity)) {
			writtenRec = 
		        logTInt(severity, 
			            loc, 
			            new LogController[] {this}, 
			            MSG_SUB_LOC, 
			            msgClear, 
			            typeOfMessage(args), 
			            args,
			            exc,
			            msgCode == null ? null : msgCode.toString(),
			                            (loc == null) ? null : loc.csnComponent,
			                            (loc == null) ? null : loc.dcName);
	  } 
	
		if (loc != null) {
			loc.logInt(severity,
									loc,
									new LogController[] {this},
							    MSG_SUB_LOC,
							    null,
							    msgClear,
							    MsgType.JAVA,								
							    args,
									exc);	
		}
		else {
			handleLCNull("logThrowable()", msgClear, args, exc);
		}
	  return writtenRec;
	}

 	/**
	* Logs message with stack trace of given exception,
	* from the given location into this category.
	* @param  severity Severity of message
	* @param  loc      Location message stems from
	* @param  subloc   Name of sublocation
	* @param  msgCode  Resource name of message template
	* @param  args     Arguments as object references
	* @param  msgClear Clear text version of message
	* @param  exc 			Throwable, the superclass of all errors and exceptions 
	* @return Log record if written via a log of this log controller or null
	* @see    #setResourceBundleName(java.lang.String)
	* @deprecated
	*/
	 public LogRecord logThrowable(int 		 severity,
															   Location loc,
															   String   subloc,
															   Object   msgCode,
															   Object[] args,
															   String   msgClear,
																   Throwable exc) {
		LogRecord writtenRec = null;
	
		if (beLogged(severity)) {			  
			writtenRec = 
		        logTInt(severity, 
		                loc, 
		                new LogController[] {this}, 
		                subloc, 
		                msgClear, 
		                typeOfMessage(args), 
		                args,
		                exc,
		                msgCode == null ? null : msgCode.toString(),
		                                (loc == null) ? null : loc.csnComponent,
		                                (loc == null) ? null : loc.dcName);
		} 
	
		if (loc != null) {		  
			loc.logInt(severity,
								 loc,
								 new LogController[] {this},
								 subloc,
								 null,
								 msgClear,
								 MsgType.JAVA,								
								 args,
								 exc);	
		}
		else {
			handleLCNull("logThrowable()", msgClear, args, exc);
	  }
		return writtenRec;
	}
  
  //*******************************************************

   /**
     * @deprecated Groups are not used and implementation was removed for memory usage improvement,
     *             Instead use correlation id.
     */
	public void openGroup(int      severity,
						  Location loc) {
	}

   /**
     * @deprecated Groups are not used and implementation was removed for memory usage improvement,
     *             Instead use correlation id.
     */
	public void openGroup(int      severity,
						  Location loc,
						  String   subloc) {
	}
  
	//******************************************************

	/**
	 * Sets the minimum severity of this category with respect to a location.
	 * If its current maximum severity is lower than the argument, the former is
	 * set to the argument. If it is the root category, this method has the same
	 * effect as a call to
	 * {@link #setEffectiveSeverity(Location,
	 *                              int)}.
	 * @param  severity New minimum severity
	 */
	public void setMinimumSeverity(Location relative,
								   int      severity) {
	  super.setMinimumSeverity(relative,
							   severity);
	}

	/**
	 * Resets the minimum severity of this category with respect to a location.
	 * If it is the root category this method has no effect, otherwise it has the
	 * same effect as a call to
	 * {@link #setMinimumSeverity(Location,
	 *                            int)} with
	 * {@link Severity#ALL}.
	 */
	public void setMinimumSeverity(Location relative) {
	  super.setMinimumSeverity(relative);
	}

	/**
	 * Sets the effective severity of this category with respect to a location.
	 * If it is the root category, this method sets the effective severity to
	 * its argument, otherwise it has the same effect as calls with its argument
	 * to both
	 * {@link #setMinimumSeverity(Location,
	 *                            int)}
	 * and
	 * {@link #setMaximumSeverity(Location,
	 *                            int)}.
	 * @param  severity New effective severity
	 */
	public void setEffectiveSeverity(Location relative,
									 								 int      severity) {
	  super.setEffectiveSeverity(relative, severity);
	}

	/**
	 * Resets the effective severity of this category with respect to a location.
	 * If it is the root category this method has no effect, otherwise it has the
	 * same effect as two calls to {@link #setMinimumSeverity(Location)} and
	 * {@link #setMaximumSeverity(Location)}.
	 */
	public void setEffectiveSeverity(Location relative) {
	  super.setEffectiveSeverity(relative);
	}

	/**
	 * Sets the maximum severity of this category with respect to a location.
	 * If its current minimum severity is higher than the argument, the former is
	 * set to the argument. If it is the root category, this method has the same
	 * effect as a call to
	 * {@link #setEffectiveSeverity(Location,
	 *                              int)}.
	 * @param  severity New maximum severity
	 */
	public void setMaximumSeverity(Location relative,
								   int      severity) {
	  super.setMaximumSeverity(relative,
							   severity);
	}

	/**
	 * Resets the maximum severity of this category with respect to a location.
	 * If it is the root category this method has no effect, otherwise it has the
	 * same effect as a call to
	 * {@link #setMaximumSeverity(Location,
	 *                            int)} with
	 * {@link Severity#ALL}.
	 */
	public void setMaximumSeverity(Location relative) {
	  super.setMaximumSeverity(relative);
	}

	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	
	static Category getCategoryInt(String name) {
		return LoggingManager.getLoggingManager().getCategory(name.trim());
	}
	
	//==== < default ===================================== private > ====
	
	private void handleLCNull (String 					methodName,
													 	 String        		msgClear,
													 	 Object[]        	args,
														 Throwable				exc){
 
	  // Write info about null object
	  Category.SYS_LOGGING
		  .logIntByAPI(Severity.WARNING,
									  classLoc,
									  methodName,
									  MSGCollection.LOGGING_MSG_ID_OBJECT_IS_NULL,
									  MSGCollection.LOGGING_MSG_STR_OBJECT_IS_NULL,
									  new String[] {"Location", "Category", this.getName()});
  		
	  // Backup - Write message and stack trace 
		  Category.SYS_LOGGING
						  .logIntByAPI(Severity.WARNING,
													  classLoc,
													  methodName,
													  MSGCollection.LOGGING_MSG_ID_UNHANDLED,
													  MSGCollection.LOGGING_MSG_STR_UNHANDLED + msgClear,
													  args,
														exc);
														
			handleException(new NullPointerException(EX_NO_FILTER_EMSG), ExceptionManager.ERR_VALUE);	
	}
	
	
	//==== < private ================================== deprecated > ====
	
	/**
	   * Gets the category with the specified name.
	   * If the category with this name does not exist yet it is
	   * instantiated. Inheritance refers to the formal hierarchy given
	   * by the name structure and therefore even works when parent
	   * objects had not been instantiated up to now, either.
	   * @param  name Structured name of category
	   * @return Category identified by name
	   * @deprecated Parent (relative) category must be specified. 
	   * @throws IllegalArgumentException Wrong location name syntax
	   */
	public static Category getCategory(String name) {
		return getCategoryInt(correctCategoryName(name));
	}
		
}
