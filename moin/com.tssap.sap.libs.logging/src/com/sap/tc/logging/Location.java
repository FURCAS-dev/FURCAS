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

import java.io.Writer;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * <p>
 *   Describes messages that <em>originate from delimited source code areas</em>
 *   and is above all used to emit <em>trace</em> messages.
 *   Typical source code areas are components, packages, classes and methods.
 *   Messages related to source code areas are classical <em>trace</em>
 *   messages, so if you are above all interested in writing traces, please read
 *   this introduction thoroughly.
 * </p>
 * <p>
 *   The class <code>Location</code> is a subclass of {@link LogController}, so
 *   you can, with the corresponding calls, emit trace messages and have the
 *   output of those messages to attachable logs controlled via the severities
 *   of the locations and optional filters assigned to them. We recommend to use
 *   the constants provided in the class {@link Severity} to specify message
 *   severities.
 * </p>
 * <p>
 *   Locations are named according to the hierarchical structure known from Java
 *   packages. This name structure is mirrored in the hierarchical order of
 *   the locations named. For example, if you would like to write all the
 *   messages from monitoring classes into a single log, you would call the
 *   location named <code>com.sap.tc.monitoring</code>. You could then command
 *   to collect all the messages from technology components in a common log by
 *   simply assigning that log to the parent location <code>com.sap.tc</code>.
 *   The log is then passed on to all child locations, in particular to
 *   <code>com.sap.tc.monitoring</code>. In addition, it is possible to include
 *   method signatures in location names. For example,
 *   <code>com.sap.tc.monitoring.Node.announce(java.lang.Object)</code> is a
 *   location for a method named <code>announce</code> with an argument
 *   of the class <code>Object</code>. In this way, you can distinguish
 *   overloaded methods and, by adding yet another suffix to such a name, even
 *   classes local to them. The hierarchical components of the name have to be
 *   compliant with Java identifier syntax, but you can use illegal characters
 *   bracketing a component with single quotes. For example, to use a component
 *   with a dot, the separator character of location names, write
 *   <code>com.sap.'great.technology'</code>.
 * </p>
 * <p>
 *   Locations are accessed via the static method
 *   <code>Location.getLocation</code>. Although the lookup done in this method
 *   is quite efficient, it should not be called each time a message is to be
 *   generated. Instead, each class should define static fields to hold all
 *   the needed locations, and use these fields to call logging methods. This
 *   might get tedious when a class implements a large number of methods while
 *   at the same time there is no need for separate controlling of output.
 *   Therefore, as described below in more detail, for each logging method there
 *   is a version which takes in an additional parameter called
 *   <code>subloc</code> a  string that serves as suffix to the name of the used
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
 *   <code>Severity.INFO</code> or <code>Severity.ERROR</code>. However, there
 *   are also dedicated methods without that additional argument for all of the
 *   severities, with names of the form <i>&lt;severity&gt;</i><code>T</code>
 *   and <i>&lt;severity&gt;</i>, which are provided in the same flavors as
 *   <code>logT</code> and <code>log</code>. In addition, there are special
 *   methods for tracing method entries, exits and throwing exceptions, called
 *   <code>entering</code>, <code>exiting</code> and <code>throwing</code>,
 *   respectively, which emit prefabricated <code>Severity.PATH</code> messages.
 *   There is also a method for checking assertions, <code>assertion</code>,
 *   which in case of failure emits a <code>Severity.ERROR</code> message.
 * </p>
 * <p>
 *   To sum up the above, including optional arguments an output call has the
 *   following general form:
 *   <blockquote>
 *     <table>
 *       <tr>
 *         <td><i>&lt;severity&gt;</i><code>T(</code></td><td><i>[&lt;categories&gt;</i><code>,</code><i>]</i></td>
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
 *         <td><i>&lt;severity&gt;</i><code>(</code></td><td><i>&lt;categories&gt;</i><code>,</code><i></i></td>
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
 *   The (optional) argument <i>&lt;categories&gt;</i> is for a parameter called
 *   <code>category</code> or <code>categories</code> in the actual methods,
 *   depending on whether you pass over a single category or an array of
 *   categories. It is intended to make possible the individual control of
 *   messages falling into the specified categories. You can then set a severity
 *   for this location with respect to each of the categories and thus enable or
 *   disable output of specifically those messages from the location that have
 *   been assigned to one or several of the categories. As a category is itself
 *   a log controller, the same method call can write a message simultaneously
 *   to the trace responsible for the location as well as to a log attached to
 *   the category, save for the necessary severity settings. Both messages get
 *   the same identification in order to facilitate cross-referencing among
 *   location and category logs. Please observe that the argument is not
 *   optional for the second method version emitting language-independent
 *   messages. The reason is that for tracing alone, these messages do not make
 *   sense when you take into account the effort for translation, as opposed to
 *   when one of the category has a log attached. However, in practice most
 *   categories used like this do not have logs.
 * </p>
 * <p>
 *   The optional argument <i>&lt;sublocation&gt;</i> is for a parameter called
 *   <code>subloc</code> in the actual methods. This argument is appended to
 *   the name of the location itself. It is intended for completing the location
 *   name if a method is not represented via its own location because the
 *   corresponding fine control of output is not needed, as described above. The
 *   optional argument <i>&lt;clear message&gt;</i> of the second method version
 *   is for a parameter called <code>msgClear</code> in the actual methods. This
 *   argument is a fallback that is used to show the message if the code could
 *   not be found in the specified resource bundle. Of  course, where applicable
 *   these optional arguments are also possible for the two basic calls
 *   <code>logT</code> and <code>log</code> as well as <code>entering</code>,
 *   <code>throwing</code> and <code>assertion</code>.
 * </p>
 * <p>
 *   Let us take a closer look at an example. Due to the suffix option described
 *   above, both messages use the location name
 *   <code>com.sap.tc.monitoring.Node.announce(java.lang.Object)</code>.
 *   <blockquote>
 *     <pre>
 *package com.sap.tc.monitoring;
 *
 *import com.sap.tc.logging.*;
 *
 *public class Node {
 *
 *  private static final Location loc     = Location.getLocation(Node.class);
 *  private static final Category objMgmt = Category.getCategory("/Objects/Management");
 *
 *  public void announce(Object o) {
 *    final String method = "announce(java.lang.Object)";
 *
 *    loc.entering(method,
 *                 new Object[] {o});
 *    try {
 *      // Preparation
 *      ...
 *      loc.errorT(objMgmt,
 *                 method,
 *                 "Registering object {0}.",
 *                 new Object[] {o});
 *      // Register object
 *      ...
 *    }
 *    finally {
 *      loc.exiting();
 *    }
 *  }
 *}</pre>
 *   </blockquote>
 *   Note that the call to <code>exiting</code> is placed inside a
 *   <code>finally</code> clause. This is because a call to
 *   <code>entering</code> <em>must</em> always be balanced with one to
 *   <code>exiting</code>, even in the face of exceptions. Note also that for
 *   the messages to be written to a log attached to the location, its severtiy
 *   must have been set at least with
 *   <blockquote>
 *     <pre>
 *loc.setEffectiveSevertiy(Severity.PATH);</pre>
 *   </blockquote>
 *   for the calls of <code>entering</code> and <code>exiting</code>, and with
 *   <blockquote>
 *     <pre>
 *loc.setEffectiveSevertiy(objMgmt,
 *                         Severity.ERROR);</pre>
 *   </blockquote>
 *   for the call to <code>errorT</code>, for example during component
 *   initialization. For the example at hand, it would have been alright to
 *   format the messages prior to the call using string concatenation, but in
 *   case of several arguments it is more efficient to use separate arguments.
 * </p>
 * <p>
 *   You can establish custom links among messages. Output methods return the
 *   corresponding log record if a message was written to at least one log. The
 *   identification can be obtained from the log record via the method
 *   {@link LogRecord#getId()} and then written as an argument to another
 *   message.
 * </p>
 * <p>
 *   Often, it is useful to put several related messages together into one
 *   context. A typical example are all trace messages stemming from one method
 *   call. In case of a database log, another example would be the messages
 *   representing the different database operations together forming one logical
 *   transaction. A formatter or log viewer can utilize this context information
 *   to visualize relations using indentation or tree controls.
 * </p>
 * <p>
 *   Please find fundamental information about the principles of error handling
 *   in the package description. For this class, there are three cases where the
 *   methods {@link #getException()} and {@link #throwException()} are served.
 *   First, methods dealing with severities pass over a
 *   <code>java.lang.IllegalArgumentException</code> if a value is out of range.
 *   Second, the same exception with a different message is handed over if you
 *   forget to provide categories when needed, which is the case for the calls
 *   setting relative severities as well as for some methods emitting messages.
 *   However, all defective calls of the latter, for example when not providing
 *   a resource bundle or a clear text version in case of a language-independent
 *   message, still write the message in order to facilitate discovering the
 *   site of the call.
 * </p>
 * @see    Category
 * @see    Severity
 */

public class Location extends LogController {
	//$JL-EXC$
	//================================================ declaration > ====
	private static Location LOC = Location.getLocation("com.sap.tc.logging.Location", "tc~logging~java", "BC-JAS-ADM-LOG-API");

	
  static final String MSG_ENTERING           = "Entering method",
											MSG_ENTERING_WITH_PARS = MSG_ENTERING + " with ({0})",
											MSG_EXITING            = "Exiting method",
											MSG_EXITING_WITH_RES   = MSG_EXITING + " with {0}";
											  	
  public static final String ROOT_NAME  = "";
  public static final char   SEPARATOR  = '.';
  public static final char   SPACE  = ' ';
  public static final char   SINGLE_QUOTE  = '\'';
  
  
  protected String vendor = "com.sap.";
  
  protected String dcName;
  protected String csnComponent;

	//==== < declaration ============================ constructors > ====
	
  protected Location(String name) {
    super(name);
  }

  protected Location(String   name, Location parent) {
    super(name, parent);
  }

	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====
	
  /**
   * Gets the root location.
   * @return Root location
   */
  public static Location getRoot() {
    return getLocation (ROOT_NAME);
  }

  /**
   * Gets the parent location of this location.
   * @return Parent location
   */
  public Location getParent() {
    return (Location) getParentInt();
  }
  
  /**
   * Corrects syntax of the location's name if it is not correct.
   * @return Correct category's name
   */
  private static String correctLocationName(String locationName) {
    int i;
    boolean lastNotSeparator = true;
    
    locationName = locationName.trim();
	if (locationName.length() == 0) {
	  return "";	
	}
	
    StringBuffer correctName = new StringBuffer(locationName.length());
	
    for (i = 0; i < locationName.length(); i++) {
      char currentChar = locationName.charAt(i);
      if ((currentChar == Category.SEPARATOR) || (currentChar <= SPACE) || (currentChar == SINGLE_QUOTE)) {
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
    
    if ((len > 1) && (finalName.charAt(0) == SEPARATOR)) {
      finalName = finalName.substring(1);
    }
    
	return finalName;
  }
  

  /**
   * Gets the location with the specified name.
   * If the location does not exist it is instantiated. Inheritance refers
   * to the formal hierarchy given via the name structure and therefore even
   * works when parent objects had not been instantiated up to now, either.
   * There are also versions of this method which take an object and a class,
   * respectively, and return the location describing the class (of the object).
   * @param  name Name of location
   * @return Location identified by name
   * @throws IllegalArgumentException Wrong location name syntax
   * @see    #getLocation(java.lang.Object)
   * @see    #getLocation(java.lang.Class)
   */
  public static Location getLocation(String name) {
    return getLocation(correctLocationName(name), null);
  }
  
  public static Location getLocation(String name, String vendor) {
      String callerClassloaderName = null;
      if (LoggingManager.classLoadInfoProvider != null) {
          callerClassloaderName = LoggingManager.classLoadInfoProvider.getCallerClassLoaderName();
      }
      
      Location result = LoggingManager.getLoggingManager().getLocation(name.trim());
      if((result.csnComponent == null || result.csnComponent.equals("")) && (result.dcName == null || result.dcName.equals(""))){  
	      if (LoggingManager.classLoadInfoProvider != null && callerClassloaderName != null) {
	          result.csnComponent = LoggingManager.classLoadInfoProvider.getCsnComponent(callerClassloaderName);
	          result.dcName = LoggingManager.classLoadInfoProvider.getDcName(callerClassloaderName);
	          if (result.dcName != null && result.csnComponent == null) {
	              if (LoggingManager.deployInfoProvider != null) {
	                  result.csnComponent = LoggingManager.deployInfoProvider.getCsnComponentByDcName(result.dcName);                  
	              }
	          }
	      }
      }
      if (vendor != null) {
          result.setVendor(vendor);
      }
              
      return result;      
  }
  
  public static Location getLocation(String name, String dcName, String csnComponent) {
      Location result = LoggingManager.getLoggingManager().getLocation(name.trim());
      result.dcName = dcName;
      result.csnComponent = csnComponent;
      if (result.dcName != null && result.csnComponent == null) {
          if (LoggingManager.deployInfoProvider != null) {
              result.csnComponent = LoggingManager.deployInfoProvider.getCsnComponentByDcName(result.dcName);                  
          }
      }      
      return result;
  }

  /**
   * Gets the location for the class of the specified instance.
   * If the location does not exist it is instantiated. Inheritance refers
   * to the formal hierarchy given via the name structure and therefore even
   * works when parent objects had not been instantiated up to now, either. The
   * version of this method taking a string should be used for inner classes
   * which bear generated names for use in the virtual machine.
   * @param  instance Instance of class
   * @return Location that describes instance class
   * @see    #getLocation(java.lang.String)
   * @see    #getLocation(java.lang.Class)
   */
  public static Location getLocation(Object instance) {
  	if (instance != null) {
    	return getLocation(instance.getClass());
  	}
  	else {
			LOC.logIntByAPI(Severity.WARNING,
											LOC,
											"[getLocation(Object instance)]",
											MSGCollection.LOGGING_MSG_ID_OBJECT_IS_NULL,
											MSGCollection.LOGGING_MSG_STR_OBJECT_IS_NULL,
											new String[] {"Object", "Location", ""});
  	}
  	return null;
  }

  /**
   * Gets the location for the specified class.
   * If the location does not exist it is instantiated. Inheritance refers
   * to the formal hierarchy given via the name structure and therefore even
   * works when parent objects had not been instantiated up to now, either. The
   * version of this method taking a string should be used for inner classes
   * which bear generated names for use in the virtual machine.
   * @param  forClass Class
   * @return Location that describes class
   * @see    #getLocation(java.lang.String)
   * @see    #getLocation(java.lang.Object)
   */
  public static Location getLocation(Class forClass) {

		if (forClass != null) {
			return getLocation(forClass.getName());
		}
		else {
				LOC.logIntByAPI(Severity.WARNING,
												LOC,
												"[getLocation(Class forClass)]",
												MSGCollection.LOGGING_MSG_ID_OBJECT_IS_NULL,
												MSGCollection.LOGGING_MSG_STR_OBJECT_IS_NULL,
												new String[] {"Class", "Location", ""});
		}
		return null;
  }

  /**
   * Gets the location with the specified name relative to another location.
   * Save for the root location, this method is a shorthand for the call
   * <code>Location.getLocation(loc.getName() + "." + name)</code>.
   * @param  loc  Parent location
   * @param  name Name of location
   * @return Location identified by relative name
   * @throws IllegalArgumentException Wrong location name syntax
   */
  public static Location getLocation(Location loc,
                                     String   name) {
    if (loc != getRoot()) {
      return Location.getLocation(  loc.getName()
                                  + SEPARATOR
                                  + name.trim());
    } 
    else {
      return Location.getLocation(name);
    }
  }
	
	//********************************************** 
  // 		LOG MSG OBJECT METHODS
	//********************************************** 
	
  /**
   * Logs simple message from this location.
   * @param  severity 	Severity of message
   * @param  msgObject  Message object of message
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord log(int    		severity,
                       MsgObject 	msgObject) {
		
		LogRecord writtenRec = null;

		if (beLogged(severity)) {
			writtenRec = 
				logTInt (severity, 
								 this, 
								 MSG_RELATIVES, 
								 MSG_SUB_LOC, 
								 msgObject.getMsgText(), 
								 MsgType.PLAIN, 
								 MSG_ARGS,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Logs simple message of the specified category from this location.
   * @param  severity Severity of message
   * @param  category 	Category of message
   * @param  msgObject  Message object of message
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter
   *             or issue separate calls to a Location and a Category parameter
   */
  public LogRecord log(int      	severity,
                        Category 	category,
												MsgObject msgObject) {
  	
  	LogRecord writtenRec = null;

		if (beLogged(severity, category)) {
			writtenRec = 
			logSeverityTInt (severity, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Logs simple message of the specified categories from this location.
   * @param  severity   Severity of message
   * @param  categories Categories of message
   * @param  msgObject        Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord log(int        	severity,
                        Category[] 	categories,
												MsgObject 	msgObject) {
                        	
		LogRecord writtenRec = null;
		
		if (beLogged(severity, categories)) {
			writtenRec = 
			logSeverityTInt (severity, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String)}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  severity 	Severity of message
   * @param  subloc   	Name of sublocation
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord log(int    			severity,
                       String 			subloc,
											 MsgObject 		msgObject) {
                        	
		LogRecord writtenRec = null;
		
		if (beLogged(severity)) {
			writtenRec = 
				logTInt (severity, 
								 this, 
								 MSG_RELATIVES, 
								 subloc, 
								 msgObject.getMsgText(), 
								 MsgType.PLAIN, 
								 MSG_ARGS,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String)}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  severity 	Severity of message
   * @param  category 	Category of message
   * @param  subloc   	Name of sublocation
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord log(int      		severity,
                        Category 		category,
                        String   		subloc,
												MsgObject 	msgObject) {
                        	
		LogRecord writtenRec = null;
		
		if (beLogged(severity, category)) {
			writtenRec = 
			logSeverityTInt (severity, 
												this, 
												new LogController[] {category}, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String)}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  severity   Severity of message
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord log(int         severity,
                        Category[]  categories,
                        String      subloc,
												MsgObject 	msgObject) {
                        	
		LogRecord writtenRec = null;
		
		if (beLogged(severity, categories)) {
			writtenRec = 
			logSeverityTInt (severity, 
												this, 
												categories, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Logs message with parameters from this location.
   * The objects handed over as arguments are written using the method
   * <code>toString</code>.
   * @param  severity 	Severity of message
   * @param  msgObject  Message object
   * @param  args     	Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord log(int      	severity,
  											MsgObject msgObject,
                        Object[] 	args) {
                        	
		LogRecord writtenRec = null;
		
		if (beLogged(severity)) {
			writtenRec = 
				logTInt (severity, 
				 				 this, 
								 MSG_RELATIVES, 
								 MSG_SUB_LOC, 
								 msgObject.getMsgText(), 
								 MsgType.JAVA, 
								 args,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Logs message of the specified category with parameters from this location.
   * The objects handed over as arguments are written using the method
   * <code>toString</code>.
   * @param  severity 	Severity of message
   * @param  category 	Category of message
   * @param  msgObject  Message object
   * @param  args     	Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord log(int       severity,
                        Category  category,
                        MsgObject msgObject,
                        Object[]  args) {
                        	
		LogRecord writtenRec = null;
		
		if (beLogged(severity, category)) {
			writtenRec = 
			logSeverityTInt (severity, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Logs message of the specified categories with parameters from this
   * location.
   * The objects handed over as arguments are written using the method
   * <code>toString</code>.
   * @param  severity   Severity of message
   * @param  Categories Categories of message
   * @param  msgObject  Message object
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord log(int        severity,
                        Category[] categories,
                        MsgObject  msgObject,
                        Object[]   args) {
                        	
		LogRecord writtenRec = null;
		
		if (beLogged(severity, categories)) {
			writtenRec = 
			logSeverityTInt (severity, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  severity 	Severity of message
   * @param  subloc   	Name of sublocation
   * @param  msgObject  Message object
   * @param  args     	Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord log(int      	severity,
                        String   	subloc,
                        MsgObject msgObject,
                        Object[] 	args) {
                        	
		LogRecord writtenRec = null;
		
		if (beLogged(severity)) {
			writtenRec = 
				logTInt (severity, 
								 this, 
								 MSG_RELATIVES, 
								 subloc, 
								 msgObject.getMsgText(), 
								 MsgType.JAVA, 
								 args,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  severity 	Severity of message
   * @param  category 	Category of message
   * @param  subloc   	Name of sublocation
   * @param  msgObject  Message object
   * @param  args     	Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter
   */
  public LogRecord log(int      	severity,
                        Category 	category,
                        String   	subloc,
                        MsgObject msgObject,
                        Object[] 	args) {
                        	
		LogRecord writtenRec = null;
		
		if (beLogged(severity, category)) {
			writtenRec = 
			logSeverityTInt (severity, 
												this, 
												new LogController[] {category}, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String,
   *              java.lang.Object[])}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  severity   Severity of message
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgObject  Message object
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord log(int        	severity,
                        Category[] 	categories,
                        String     	subloc,
                        MsgObject 	msgObject,
                        Object[]   	args) {
                        	
		LogRecord writtenRec = null;
		
		if (beLogged(severity, categories)) {
			writtenRec = 
			logSeverityTInt (severity, 
												this, 
												categories, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }
  
	//********************************************** 
  // 		LOG T METHODS
	//********************************************** 
	
  /**
   * Logs simple message from this location.
   * @param  severity Severity of message
   * @param  msg      Message text
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord logT(int    severity,
                        String msg) {
  	LogRecord writtenRec = null;

		if (beLogged(severity)) {
			writtenRec = 
				logTInt (severity, 
								 this, 
								 MSG_RELATIVES, 
								 MSG_SUB_LOC, 
								 msg, 
								 MsgType.PLAIN, 
								 MSG_ARGS,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Logs simple message of the specified category from this location.
   * @param  severity Severity of message
   * @param  category Category of message
   * @param  msg      Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord logT(int      severity,
                        Category category,
                        String   msg) {
  	LogRecord writtenRec = null;

		if (beLogged(severity, category)) {
			writtenRec = 
			logSeverityTInt (severity, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Logs simple message of the specified categories from this location.
   * @param  severity   Severity of message
   * @param  categories Categories of message
   * @param  msg        Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord logT(int        severity,
                        Category[] categories,
                        String     msg) {
  	LogRecord writtenRec = null;
		
		if (beLogged(severity, categories)) {
			writtenRec = 
			logSeverityTInt (severity, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String)}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  severity Severity of message
   * @param  subloc   Name of sublocation
   * @param  msg      Message text
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord logT(int    severity,
                        String subloc,
                        String msg) {
  	LogRecord writtenRec = null;
		
		if (beLogged(severity)) {
			writtenRec = 
				logTInt (severity, 
								 this, 
								 MSG_RELATIVES, 
								 subloc, 
								 msg, 
								 MsgType.PLAIN, 
								 MSG_ARGS,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String)}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  severity Severity of message
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msg      Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord logT(int      severity,
                        Category category,
                        String   subloc,
                        String   msg) {
  	LogRecord writtenRec = null;
		
		if (beLogged(severity, category)) {
			writtenRec = 
			logSeverityTInt (severity, 
												this, 
												new LogController[] {category}, 
												subloc, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String)}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  severity   Severity of message
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msg        Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter
   *             or issue separate calls to a Location and a Category parameter              
   */
  public LogRecord logT(int        severity,
                        Category[] categories,
                        String     subloc,
                        String     msg) {
		LogRecord writtenRec = null;
		
		if (beLogged(severity, categories)) {
			writtenRec = 
			logSeverityTInt (severity, 
												this, 
												categories, 
												subloc, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Logs message with parameters from this location.
   * The objects handed over as arguments are written using the method
   * <code>toString</code>.
   * @param  severity Severity of message
   * @param  msg      Message template
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord logT(int      severity,
                        String   msg,
                        Object[] args) {
  	LogRecord writtenRec = null;
		
		if (beLogged(severity)) {
			writtenRec = 
				logTInt (severity, 
				 				 this, 
								 MSG_RELATIVES, 
								 MSG_SUB_LOC, 
								 msg, 
								 MsgType.JAVA, 
								 args,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Logs message of the specified category with parameters from this location.
   * The objects handed over as arguments are written using the method
   * <code>toString</code>.
   * @param  severity Severity of message
   * @param  category Category of message
   * @param  msg      Message template
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord logT(int      severity,
                        Category category,
                        String   msg,
                        Object[] args) {
  	LogRecord writtenRec = null;
		
		if (beLogged(severity, category)) {
			writtenRec = 
			logSeverityTInt (severity, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Logs message of the specified categories with parameters from this
   * location.
   * The objects handed over as arguments are written using the method
   * <code>toString</code>.
   * @param  severity   Severity of message
   * @param  Categories Categories of message
   * @param  msg        Message template
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord logT(int        severity,
                        Category[] categories,
                        String     msg,
                        Object[]   args) {
  	LogRecord writtenRec = null;
		
		if (beLogged(severity, categories)) {
			writtenRec = 
			logSeverityTInt (severity, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  severity Severity of message
   * @param  subloc   Name of sublocation
   * @param  msg      Message text
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord logT(int      severity,
                        String   subloc,
                        String   msg,
                        Object[] args) {
  	LogRecord writtenRec = null;
		
		if (beLogged(severity)) {
			writtenRec = 
				logTInt (severity, 
								 this, 
								 MSG_RELATIVES, 
								 subloc, 
								 msg, 
								 MsgType.JAVA, 
								 args,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  severity Severity of message
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msg      Message text
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord logT(int      severity,
                        Category category,
                        String   subloc,
                        String   msg,
                        Object[] args) {
  	LogRecord writtenRec = null;
		
		if (beLogged(severity, category)) {
			writtenRec = 
			logSeverityTInt (severity, 
												this, 
												new LogController[] {category}, 
												subloc, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String,
   *              java.lang.Object[])}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  severity   Severity of message
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msg        Message text
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord logT(int        severity,
                        Category[] categories,
                        String     subloc,
                        String     msg,
                        Object[]   args) {
  	LogRecord writtenRec = null;
		
		if (beLogged(severity, categories)) {
			writtenRec = 
			logSeverityTInt (severity, 
												this, 
												categories, 
												subloc, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }
  
	//********************************************** 
  // 		LOG METHODS - RESOURCE BUNDLE
	//********************************************** 
  /**
   * Logs message, specified as a resource name, of the specified category from
   * this location.
   * This method also stores a clear text version of the message, taken from the
   * resource bundle for language code <em>en</em> and country code
   * <em>US</em>, which is displayed whenever a log viewer cannot resolve a
   * message code.
   * @param  severity Severity of message
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @deprecated Message Code must be used together with Message Text.  
   * @see    #setResourceBundleName(java.lang.String)
   */
  public LogRecord log(int      severity,
                       Category category,
                       Object   msgCode) {
  	LogRecord writtenRec = null;
	
		if (beLogged(severity, category)) {
			writtenRec = 
			logSeverityInt (severity, 
											this, 
											new LogController[] {category}, 	
											MSG_SUB_LOC, 
											null, 
											null, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
    return writtenRec;
  }

  /**
   * Logs message, specified as a resource name, of the specified categories
   * from this location.
   * This method also stores a clear text version of the message, taken from the
   * resource bundle for language code <em>en</em> and country code
   * <em>US</em>, which is displayed whenever a log viewer cannot resolve a
   * message code.
   * @param  severity   Severity of message
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @deprecated Message Code must be used together with Message Text.  
   * @see    #setResourceBundleName(java.lang.String)
   */
  public LogRecord log(int        severity,
                       Category[] categories,
                       Object     msgCode) {
  	LogRecord writtenRec = null;
	
		if (beLogged(severity, categories)) {
			writtenRec = 
			logSeverityInt (severity, 
											this, categories, 	
											MSG_SUB_LOC, 
											null, 
											null, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object)}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  severity Severity of message
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord log(int      severity,
                       Category category,
                       String   subloc,
                       Object   msgCode) {
  	LogRecord writtenRec = null;
	
		if (beLogged(severity, category)) {
			writtenRec = 
			logSeverityInt (severity, 
											this, 
											new LogController[] {category}, 	
											subloc, 
											null, 
											null, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object)}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  severity   Severity of message
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord log(int        severity,
                       Category[] categories,
                       String     subloc,
                       Object     msgCode) {
  	LogRecord writtenRec = null;
	
		if (beLogged(severity, categories)) {
			writtenRec = 
			logSeverityInt (severity, 
											this, 
											categories, 	
											subloc, 
											null, 
											null, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Logs message, specified as resource name, of the specified category with
   * parameters from this location.
   * The objects handed over as arguments are written using the method
   * <code>toString</code>. This method also stores a clear text version of the
   * message, taken from the resource bundle for language code <em>en</em> and
   * country code <em>US</em>, which is displayed whenever a log viewer cannot
   * resolve a message code.
   * @param  severity Severity of message
   * @param  category Category of message
   * @param  msgCode  Resource name of message template
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord log(int      severity,
                       Category category,
                       Object   msgCode,
                       Object[] args) {
  	LogRecord writtenRec = null;
	
		if (beLogged(severity, category)) {
			writtenRec = 
			logSeverityInt (severity, 
											this, 
											new LogController[] {category}, 	
											MSG_SUB_LOC, 
											null, 
											null, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Logs message, specified as resource name, of the specified categories with
   * parameters from this location.
   * The objects handed over as arguments are written using the method
   * <code>toString</code>. This method also stores a clear text version of the
   * message, taken from the resource bundle for language code <em>en</em> and
   * country code <em>US</em>, which is displayed whenever a log viewer cannot
   * resolve a message code.
   * @param  severity   Severity of message
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message template
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord log(int        severity,
                       Category[] categories,
                       Object     msgCode,
                       Object[]   args) {
  	LogRecord writtenRec = null;
	
		if (beLogged(severity, categories)) {
			writtenRec = 
			logSeverityInt (severity, 
											this, 
											categories, 	
											MSG_SUB_LOC, 
											null, 
											null, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  severity Severity of message
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message template
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord log(int      severity,
                       Category category,
                       String   subloc,
                       Object   msgCode,
                       Object[] args) {
  	LogRecord writtenRec = null;
	
		if (beLogged(severity, category)) {
			writtenRec = 
			logSeverityInt (severity, 
											this, 
											new LogController[] {category}, 	
											subloc, 
											null, 
											null, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  severity   Severity of message
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message template
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord log(int        severity,
                       Category[] categories,
                       String     subloc,
                       Object     msgCode,
                       Object[]   args) {
  	LogRecord writtenRec = null;
	
		if (beLogged(severity, categories)) {
			writtenRec = 
			logSeverityInt (severity, 
											this, 
											categories, 	
											subloc, 
											null, 
											null, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Logs message, specified as a resource name, of the specified category from
   * this location.
   * This method also stores a clear text version of the message which is
   * displayed whenever a log viewer cannot resolve a message code.
   * @param  severity Severity of message
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord log(int      severity,
                       Category category,
                       Object   msgCode,
                       String   msgClear) {
  	LogRecord writtenRec = null;
	
		if (beLogged(severity, category)) {
			writtenRec = 
			logSeverityInt (severity, 
											this, 
											new LogController[] {category}, 	
											MSG_SUB_LOC, 
											null, 
											msgClear, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Logs message, specified as a resource name, of the specified categories
   * from this location.
   * This method also stores a clear text version of the message which is
   * displayed whenever a log viewer cannot resolve a message code.
   * @param  severity   Severity of message
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord log(int        severity,
                       Category[] categories,
                       Object     msgCode,
                       String     msgClear) {
  	LogRecord writtenRec = null;
	
		if (beLogged(severity, categories)) {
			writtenRec = 
			logSeverityInt (severity, 
											this, 
											categories, 	
											MSG_SUB_LOC, 
											null, 
											msgClear, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object,
   *             java.lang.String)}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  severity Severity of message
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter
   *             or issue separate calls to a Location and a Category parameter              
   */
  public LogRecord log(int      severity,
                       Category category,
                       String   subloc,
                       Object   msgCode,
                       String   msgClear) {
  	LogRecord writtenRec = null;
	
		if (beLogged(severity, category)) {
			writtenRec = 
			logSeverityInt (severity, 
											this, 
											new LogController[] {category}, 	
											subloc, 
											null, 
											msgClear, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object,
   *             java.lang.String)}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  severity   Severity of message
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord log(int        severity,
                       Category[] categories,
                       String     subloc,
                       Object     msgCode,
                       String     msgClear) {
  	LogRecord writtenRec = null;
	
		if (beLogged(severity, categories)) {
			writtenRec = 
			logSeverityInt (severity, 
											this, 
											categories, 	
											subloc, 
											null, 
											msgClear, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Logs message, specified as a resource name, of the specified category with
   * parameters from this location.
   * The objects handed over as arguments are written using the method
   * <code>toString</code>. This method also stores a clear text version of the
   * message which is displayed whenever a log viewer cannot resolve a message
   * code.
   * @param  severity Severity of message
   * @param  category Category of message
   * @param  msgCode  Resource name of message template
   * @param  args     Arguments as object references
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord log(int      severity,
                       Category category,
                       Object   msgCode,
                       Object[] args,
                       String   msgClear) {
  	LogRecord writtenRec = null;
	
		if (beLogged(severity, category)) {
			writtenRec = 
			logSeverityInt (severity, 
											this, 
											new LogController[] {category}, 	
											MSG_SUB_LOC, 
											null, 
											msgClear, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Logs message, specified as a resource name, of the specified categories
   * with parameters from this location.
   * The objects handed over as arguments are written using the method
   * <code>toString</code>. This method also stores a clear text version of the
   * message which is displayed whenever a log viewer cannot resolve a message
   * code.
   * @param  severity   Severity of message
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message template
   * @param  args       Arguments as object references
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord log(int        severity,
                       Category[] categories,
                       Object     msgCode,
                       Object[]   args,
                       String     msgClear) {
  	LogRecord writtenRec = null;
	
		if (beLogged(severity, categories)) {
			writtenRec = 
			logSeverityInt (severity, 
											this, 
											categories, 	
											null, 
											null, 
											msgClear, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  severity Severity of message
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message template
   * @param  args     Arguments as object references
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord log(int      severity,
                       Category category,
                       String   subloc,
                       Object   msgCode,
                       Object[] args,
                       String   msgClear) {
  	LogRecord writtenRec = null;
	
		if (beLogged(severity, category)) {
			writtenRec = 
			logSeverityInt (severity, 
											this, 
											new LogController[] {category}, 	
											subloc, 
											null, 
											msgClear, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  severity   Severity of message
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message template
   * @param  args       Arguments as object references
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord log(int        severity,
                       Category[] categories,
                       String     subloc,
                       Object     msgCode,
                       Object[]   args,
                       String     msgClear) {
  	LogRecord writtenRec = null;
	
		if (beLogged(severity, categories)) {
			writtenRec = 
			logSeverityInt (severity, 
											this, 
											categories, 	
											subloc, 
											null, 
											msgClear, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

	//********************************************** 
  // 		DEBUG MSG OBJECT METHODS
	//********************************************** 
  
  /**
   * Same as
   * {@link #log(int,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord debug(MsgObject msgObject) {
  	
		LogRecord writtenRec = null;
		
		if (beDebug()) {
			writtenRec = 
				logTInt(Severity.DEBUG, 
								this, 
								MSG_RELATIVES, 
								MSG_SUB_LOC, 
								msgObject.getMsgText(), 
								MsgType.PLAIN, 
								MSG_ARGS,
                                null,
                                null,
                                this.csnComponent,
                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  category 	Category of message
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debug(Category category,
  												MsgObject msgObject) {
                          	
		LogRecord writtenRec = null;
		
		if (beDebug(category)) {
			writtenRec = 
			logSeverityTInt (Severity.DEBUG, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category[],
   *              com.sap.tc.logging.MsgObject)}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  categories Categories of message
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debug(Category[] categories,
  												MsgObject msgObject) {
    
		LogRecord writtenRec = null;
		
		if (beDebug(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.DEBUG, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  subloc 		Name of sublocation
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord debug(String subloc,
  												MsgObject msgObject) {
                          	
		LogRecord writtenRec = null;
		
		if (beDebug()) {
			writtenRec = 
				logTInt(Severity.DEBUG, 
								this, 
								MSG_RELATIVES, 
								subloc, 
								msgObject.getMsgText(), 
								MsgType.PLAIN, 
								MSG_ARGS,
                                null,
                                null,
                                this.csnComponent,
                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category,
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  category 	Category of message
   * @param  subloc   	Name of sublocation
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter
   */
  public LogRecord debug(Category category,
                          String   subloc,
													MsgObject msgObject) {
      	  	
		LogRecord writtenRec = null;
		
		if (beDebug(category)) {
			writtenRec = 
			logSeverityTInt (Severity.DEBUG, 
												this, 
												new LogController[] {category}, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category[],
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debug(Category[] categories,
                          String     subloc,
													MsgObject msgObject) {
      	 	
		LogRecord writtenRec = null;
		
		if (beDebug(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.DEBUG, 
												this, 
												categories, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  msgObject  Message object
   * @param  args 			Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord debug(MsgObject msgObject,
                          Object[] args) {
                          	
		LogRecord writtenRec = null;
		
		if (beDebug()) {
			writtenRec = 
				logTInt(Severity.DEBUG, 
								this, 
								MSG_RELATIVES, 
								MSG_SUB_LOC, 
								msgObject.getMsgText(), 
								MsgType.JAVA, 
								args,
                                null,
                                null,
                                this.csnComponent,
                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  category 	Category of message
   * @param  msgObject  Message object
   * @param  args     	Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debug(Category category,
  												MsgObject msgObject,
                          Object[] args) {
                          	
		LogRecord writtenRec = null;
		
		if (beDebug(category)) {
			writtenRec = 
			logSeverityTInt (Severity.DEBUG, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category[],
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  categories Categories of message
   * @param  msgObject  Message object
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debug(Category[] categories,
  												MsgObject msgObject,
                          Object[]   args) {
                          	
		LogRecord writtenRec = null;
		
		if (beDebug(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.DEBUG, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  subloc 		Name of sublocation
   * @param  msgObject  Message object
   * @param  args   		Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord debug(String   subloc,
  												MsgObject msgObject,
                          Object[] args) {
                          	
		LogRecord writtenRec = null;
		
		if (beDebug()) {
			writtenRec = 
				logTInt(Severity.DEBUG, 
								this, 
								MSG_RELATIVES, 
								subloc, 
								msgObject.getMsgText(), 
								MsgType.JAVA, 
								args,
                                null,
                                null,
                                this.csnComponent,
                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category,
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  category 	Category of message
   * @param  subloc   	Name of sublocation
   * @param  msgObject  Message object
   * @param  args     	Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debug(Category category,
                          String   subloc,
                          MsgObject msgObject,
                          Object[] args) {
                          	
		LogRecord writtenRec = null;
		
		if (beDebug(category)) {
			writtenRec = 
			logSeverityTInt (Severity.DEBUG, 
												this, 
												new LogController[] {category}, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category[],
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgObject  Message object
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter
   */
  public LogRecord debug(Category[] categories,
                          String     subloc,
                          MsgObject msgObject,
                          Object[]   args) {
                          	
		LogRecord writtenRec = null;
		
		if (beDebug(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.DEBUG, 
												this, 
												categories, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

	//********************************************** 
  // 		DEBUG T METHODS
	//********************************************** 
  
  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String)}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  msg Message text
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord debugT(String msg) {
		LogRecord writtenRec = null;
		
		if (beDebug()) {
			writtenRec = 
				logTInt(Severity.DEBUG, 
								this, 
								MSG_RELATIVES, 
								MSG_SUB_LOC, 
								msg, 
								MsgType.PLAIN, 
								MSG_ARGS,
                                null,
                                null,
                                this.csnComponent,
                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String)}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  category Category of message
   * @param  msg      Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debugT(Category category,
                          String   msg) {
		LogRecord writtenRec = null;
		
		if (beDebug(category)) {
			writtenRec = 
			logSeverityTInt (Severity.DEBUG, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String)}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  categories Categories of message
   * @param  msg        Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debugT(Category[] categories,
                          String     msg) {
		LogRecord writtenRec = null;
		
		if (beDebug(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.DEBUG, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String,
   *              java.lang.String)}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  subloc Name of sublocation
   * @param  msg    Message text
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord debugT(String subloc,
                          String msg) {
		LogRecord writtenRec = null;
		
		if (beDebug()) {
			writtenRec = 
				logTInt(Severity.DEBUG, 
								this, 
								MSG_RELATIVES, 
								subloc, 
								msg, 
								MsgType.PLAIN, 
								MSG_ARGS,
                                null,
                                null,
                                this.csnComponent,
                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String,
   *              java.lang.String)}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msg      Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debugT(Category category,
                          String   subloc,
                          String   msg) {
		LogRecord writtenRec = null;
		
		if (beDebug(category)) {
			writtenRec = 
			logSeverityTInt (Severity.DEBUG, 
												this, 
												new LogController[] {category}, 
												subloc, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String,
   *              java.lang.String)}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msg        Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debugT(Category[] categories,
                          String     subloc,
                          String     msg) {
		LogRecord writtenRec = null;
		
		if (beDebug(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.DEBUG, 
												this, 
												categories, 
												subloc, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  msg  Message template
   * @param  args Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord debugT(String   msg,
                          Object[] args) {
		LogRecord writtenRec = null;
		
		if (beDebug()) {
			writtenRec = 
				logTInt(Severity.DEBUG, 
								this, 
								MSG_RELATIVES, 
								MSG_SUB_LOC, 
								msg, 
								MsgType.JAVA, 
								args,
                                null,
                                null,
                                this.csnComponent,
                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  category Category of message
   * @param  msg      Message template
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debugT(Category category,
                          String   msg,
                          Object[] args) {
		LogRecord writtenRec = null;
		
		if (beDebug(category)) {
			writtenRec = 
			logSeverityTInt (Severity.DEBUG, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  categories Categories of message
   * @param  msg        Message template
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter
   *             or issue separate calls to a Location and a Category parameter              
   */
  public LogRecord debugT(Category[] categories,
                          String     msg,
                          Object[]   args) {
		LogRecord writtenRec = null;
		
		if (beDebug(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.DEBUG, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  subloc Name of sublocation
   * @param  msg    Message template
   * @param  args   Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord debugT(String   subloc,
                          String   msg,
                          Object[] args) {
		LogRecord writtenRec = null;
		
		if (beDebug()) {
			writtenRec = 
				logTInt(Severity.DEBUG, 
								this, 
								MSG_RELATIVES, 
								subloc, 
								msg, 
								MsgType.JAVA, 
								args,
                                null,
                                null,
                                this.csnComponent,
                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msg      Message template
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debugT(Category category,
                          String   subloc,
                          String   msg,
                          Object[] args) {
		LogRecord writtenRec = null;
		
		if (beDebug(category)) {
			writtenRec = 
			logSeverityTInt (Severity.DEBUG, 
												this, 
												new LogController[] {category}, 
												subloc, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msg        Message template
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debugT(Category[] categories,
                          String     subloc,
                          String     msg,
                          Object[]   args) {
		LogRecord writtenRec = null;
		
		if (beDebug(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.DEBUG, 
												this, 
												categories, 
												subloc, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  //********************************************** 
  // 		DEBUG METHODS
	//********************************************** 
  
  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object)}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @return Log record if written via a log of this log controller or null 
   * @deprecated Message Code must be used together with Message Text.  
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debug(Category category,
                         Object   msgCode) {
		LogRecord writtenRec = null;

		if (beDebug(category)) {
			writtenRec = 
			logSeverityInt (Severity.DEBUG, 
											this, 
											new LogController[] {category}, 	
											MSG_SUB_LOC, 
											null, 
											null, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object)}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @deprecated Message Code must be used together with Message Text.  
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debug(Category[] categories,
                         Object     msgCode) {
		LogRecord writtenRec = null;

		if (beDebug(categories)) {
			writtenRec = 
			logSeverityInt (Severity.DEBUG, 
											this, 
											categories,
											MSG_SUB_LOC, 
											null, 
											null, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.String,
   *             java.lang.Object)}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debug(Category category,
                         String   subloc,
                         Object   msgCode) {
		LogRecord writtenRec = null;

		if (beDebug(category)) {
			writtenRec = 
			logSeverityInt (Severity.DEBUG, 
											this, 
											new LogController[] {category},
											subloc, 
											null, 
											null, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.String,
   *             java.lang.Object)}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debug(Category[] categories,
                         String     subloc,
                         Object     msgCode) {
		LogRecord writtenRec = null;

		if (beDebug(categories)) {
			writtenRec = 
			logSeverityInt (Severity.DEBUG, 
											this, 
											categories,
											subloc, 
											null, 
											null, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debug(Category category,
                         Object   msgCode,
                         Object[] args) {
		LogRecord writtenRec = null;

		if (beDebug(category)) {
			writtenRec = 
			logSeverityInt (Severity.DEBUG, 
											this, 
											new LogController[] {category}, 	
											MSG_SUB_LOC, 
											null, 
											null, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debug(Category[] categories,
                         Object     msgCode,
                         Object[]   args) {
		LogRecord writtenRec = null;

		if (beDebug(categories)) {
			writtenRec = 
			logSeverityInt (Severity.DEBUG, 
											this, 
											categories,
											MSG_SUB_LOC, 
											null, 
											null, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debug(Category category,
                         String   subloc,
                         Object   msgCode,
                         Object[] args) {
		LogRecord writtenRec = null;
	
		if (beDebug(category)) {
			writtenRec = 
			logSeverityInt (Severity.DEBUG, 
											this, 
											new LogController[] {category},
											subloc, 
											null, 
											null, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debug(Category[] categories,
                         String     subloc,
                         Object     msgCode,
                         Object[]   args) {
		LogRecord writtenRec = null;

		if (beDebug(categories)) {
			writtenRec = 
			logSeverityInt (Severity.DEBUG, 
											this, 
											categories,
											subloc, 
											null, 
											null, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debug(Category category,
                         Object   msgCode,
                         String   msgClear) {
		LogRecord writtenRec = null;

		if (beDebug(category)) {
			writtenRec = 
			logSeverityInt (Severity.DEBUG, 
											this, 
											new LogController[] {category}, 	
											MSG_SUB_LOC, 
											null, 
											msgClear, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debug(Category[] categories,
                         Object     msgCode,
                         String     msgClear) {
		LogRecord writtenRec = null;

		if (beDebug(categories)) {
			writtenRec = 
			logSeverityInt (Severity.DEBUG, 
											this, 
											categories, 	
											MSG_SUB_LOC, 
											null, 
											msgClear, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debug(Category category,
                         String   subloc,
                         Object   msgCode,
                         String   msgClear) {
		LogRecord writtenRec = null;

		if (beDebug(category)) {
			writtenRec = 
			logSeverityInt (Severity.DEBUG, 
											this, 
											new LogController[] {category},
											subloc, 
											null, 
											msgClear, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debug(Category[] categories,
                         String     subloc,
                         Object     msgCode,
                         String     msgClear) {
		LogRecord writtenRec = null;

		if (beDebug(categories)) {
			writtenRec = 
			logSeverityInt (Severity.DEBUG, 
											this, 
											categories,
											subloc, 
											null, 
											msgClear, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @param  args     Arguments as object references
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debug(Category category,
                         Object   msgCode,
                         Object[] args,
                         String   msgClear) {
		LogRecord writtenRec = null;

		if (beDebug(category)) {
			writtenRec = 
			logSeverityInt (Severity.DEBUG, 
											this, 
											new LogController[] {category}, 	
											MSG_SUB_LOC, 
											null, 
											msgClear, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @param  args       Arguments as object references
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debug(Category[] categories,
                         Object     msgCode,
                         Object[]   args,
                         String     msgClear) {
		LogRecord writtenRec = null;

		if (beDebug(categories)) {
			writtenRec = 
			logSeverityInt (Severity.DEBUG, 
											this, 
											categories, 	
											MSG_SUB_LOC, 
											null, 
											msgClear, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @param  args     Arguments as object references
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debug(Category category,
                         String   subloc,
                         Object   msgCode,
                         Object[] args,
                         String   msgClear) {
		LogRecord writtenRec = null;

		if (beDebug(category)) {
			writtenRec = 
			logSeverityInt (Severity.DEBUG, 
											this, 
											new LogController[] {category},
											subloc, 
											null, 
											msgClear, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits a debug message, that is a message of severity
   * {@link Severity#DEBUG}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @param  args       Arguments as object references
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord debug(Category[] categories,
                         String     subloc,
                         Object     msgCode,
                         Object[]   args,
                         String     msgClear) {
		LogRecord writtenRec = null;

		if (beDebug(categories)) {
			writtenRec = 
			logSeverityInt (Severity.DEBUG, 
											this, 
											categories,
											subloc, 
											null, 
											msgClear, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  //********************************************** 
  // 		PATH MSG OBJECT METHODS
	//********************************************** 

  /**
   * Same as
   * {@link #log(int,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  msgObject Message object
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord path(MsgObject msgObject) {
		LogRecord writtenRec = null;
		if (bePath()) {
			writtenRec = 
				logTInt (Severity.PATH, 
								 this, 
								 MSG_RELATIVES, 
								 MSG_SUB_LOC, 
								 msgObject.getMsgText(), 
								 MsgType.PLAIN, 
								 MSG_ARGS,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  category 	Category of message
   * @param  msgObject 	Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord path(Category category,
  											MsgObject msgObject) {
		
  	LogRecord writtenRec = null;
		if (bePath(category)) {
			writtenRec = 
			logSeverityTInt (Severity.PATH, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category[],
   *              com.sap.tc.logging.MsgObject)}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  categories 	Categories of message
   * @param  msgObject    Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord path(Category[] categories,
                        MsgObject msgObject) {
		LogRecord writtenRec = null;
		if (bePath(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.PATH, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  subloc 		Name of sublocation
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord path(String subloc,
                    		MsgObject msgObject) {
  	LogRecord writtenRec = null;
		if (bePath()) {
			writtenRec = 
				logTInt (Severity.PATH, 
								 this, 
								 MSG_RELATIVES, 
								 subloc, 
								 msgObject.getMsgText(), 
								 MsgType.PLAIN, 
								 MSG_ARGS,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category,
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  category 	Category of message
   * @param  subloc   	Name of sublocation
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord path(Category 	category,
                         String   	subloc,
                         MsgObject  msgObject) {
		LogRecord writtenRec = null;
		if (bePath(category)) {
			writtenRec = 
			logSeverityTInt (Severity.PATH, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category[],
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord path(Category[] categories,
                         String     subloc,
                         MsgObject  msgObject) {
		LogRecord writtenRec = null;
		if (bePath(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.PATH, 
												this, 
												categories, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  msgObject  Message object
   * @param  args 			Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord path(MsgObject msgObject,
                         Object[] args) {
		LogRecord writtenRec = null;
		if (bePath()) {
			writtenRec = 
				logTInt (Severity.PATH, 
								 this, 
								 MSG_RELATIVES, 
								 MSG_SUB_LOC, 
								 msgObject.getMsgText(), 
								 MsgType.JAVA, 
								 args,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  category 	Category of message
   * @param  msgObject  Message object
   * @param  args     	Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter
   */
  public LogRecord path(Category 	category,
                         MsgObject  msgObject,
                         Object[] 	args) {
		LogRecord writtenRec = null;
		if (bePath(category)) {
			writtenRec = 
			logSeverityTInt (Severity.PATH, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category[],
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  categories Categories of message
   * @param  msgObject  Message object
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord path(Category[] categories,
                         MsgObject  msgObject,
                         Object[]   args) {
		LogRecord writtenRec = null;
		if (bePath(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.PATH, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  subloc 		Name of sublocation
   * @param  msgObject  Message object
   * @param  args   		Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord path(String   	subloc,
                         MsgObject  msgObject,
                         Object[] 	args) {
		LogRecord writtenRec = null;
		if (bePath()) {
			writtenRec = 
				logTInt (Severity.PATH, 
								 this, 
								 MSG_RELATIVES, 
								 subloc, 
								 msgObject.getMsgText(), 
								 MsgType.JAVA, 
								 args,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category,
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  category 	Category of message
   * @param  subloc   	Name of sublocation
   * @param  msgObject  Message object
   * @param  args     	Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord path(Category 	category,
                         String   	subloc,
                         MsgObject  msgObject,
                         Object[] 	args) {
		LogRecord writtenRec = null;
		if (bePath(category)) {
			writtenRec = 
			logSeverityTInt (Severity.PATH, 
												this, 
												new LogController[] {category}, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category[],
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgObject  Message object
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord path(Category[] categories,
                         String     subloc,
                         MsgObject  msgObject,
                         Object[]   args) {
		LogRecord writtenRec = null;
		if (bePath(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.PATH, 
												this, 
												categories, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  //********************************************** 
  // 		PATH T METHODS
	//********************************************** 
    
  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String)}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  msg Message text
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord pathT(String msg) {
  	LogRecord writtenRec = null;
		if (bePath()) {
			writtenRec = 
				logTInt (Severity.PATH, 
								 this, 
								 MSG_RELATIVES, 
								 MSG_SUB_LOC, 
								 msg, 
								 MsgType.PLAIN, 
								 MSG_ARGS,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String)}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  category Category of message
   * @param  msg      Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord pathT(Category category,
                         String   msg) {
  	LogRecord writtenRec = null;
		if (bePath(category)) {
			writtenRec = 
			logSeverityTInt (Severity.PATH, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String)}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  categories Categories of message
   * @param  msg        Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord pathT(Category[] categories,
                         String     msg) {
  	LogRecord writtenRec = null;
		if (bePath(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.PATH, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String,
   *              java.lang.String)}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  subloc Name of sublocation
   * @param  msg    Message text
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord pathT(String subloc,
                    		 String msg) {
  	LogRecord writtenRec = null;
		if (bePath()) {
			writtenRec = 
				logTInt (Severity.PATH, 
								 this, 
								 MSG_RELATIVES, 
								 subloc, 
								 msg, 
								 MsgType.PLAIN, 
								 MSG_ARGS,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String,
   *              java.lang.String)}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msg      Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord pathT(Category category,
                         String   subloc,
                         String   msg) {
  	LogRecord writtenRec = null;
		if (bePath(category)) {
			writtenRec = 
			logSeverityTInt (Severity.PATH, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String,
   *              java.lang.String)}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msg        Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord pathT(Category[] categories,
                         String     subloc,
                         String     msg) {
  	LogRecord writtenRec = null;
		if (bePath(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.PATH, 
												this, 
												categories, 
												subloc, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  msg  Message template
   * @param  args Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord pathT(String   msg,
                         Object[] args) {
  	LogRecord writtenRec = null;
		if (bePath()) {
			writtenRec = 
				logTInt (Severity.PATH, 
								 this, 
								 MSG_RELATIVES, 
								 MSG_SUB_LOC, 
								 msg, 
								 MsgType.JAVA, 
								 args,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  category Category of message
   * @param  msg      Message template
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter
   */
  public LogRecord pathT(Category category,
                         String   msg,
                         Object[] args) {
  	LogRecord writtenRec = null;
		if (bePath(category)) {
			writtenRec = 
			logSeverityTInt (Severity.PATH, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  categories Categories of message
   * @param  msg        Message template
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord pathT(Category[] categories,
                         String     msg,
                         Object[]   args) {
  	LogRecord writtenRec = null;
		if (bePath(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.PATH, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  subloc Name of sublocation
   * @param  msg    Message template
   * @param  args   Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord pathT(String   subloc,
                         String   msg,
                         Object[] args) {
  	LogRecord writtenRec = null;
		if (bePath()) {
			writtenRec = 
				logTInt (Severity.PATH, 
								 this, 
								 MSG_RELATIVES, 
								 subloc, 
								 msg, 
								 MsgType.JAVA, 
								 args,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msg      Message template
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord pathT(Category category,
                         String   subloc,
                         String   msg,
                         Object[] args) {
  	LogRecord writtenRec = null;
		if (bePath(category)) {
			writtenRec = 
			logSeverityTInt (Severity.PATH, 
												this, 
												new LogController[] {category}, 
												subloc, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msg        Message template
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord pathT(Category[] categories,
                         String     subloc,
                         String     msg,
                         Object[]   args) {
  	LogRecord writtenRec = null;
		if (bePath(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.PATH, 
												this, 
												categories, 
												subloc, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  //********************************************** 
  // 		PATH METHODS
	//********************************************** 

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object)}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @deprecated Message Code must be used together with Message Text.  
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord path(Category category,
                        Object   msgCode) {
  	LogRecord writtenRec = null;

		if (bePath(category)) {
			writtenRec = 
			logSeverityInt (Severity.PATH, 
											this, 
											new LogController[] {category}, 	
											MSG_SUB_LOC, 
											null, 
											null, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object)}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @deprecated Message Code must be used together with Message Text.  
   * @see    #setResourceBundleName(java.lang.String)
   */
  public LogRecord path(Category[] categories,
                        Object     msgCode) {
  	LogRecord writtenRec = null;

		if (bePath(categories)) {
			writtenRec = 
			logSeverityInt (Severity.PATH, 
											this, categories, 	
											MSG_SUB_LOC, 
											null, 
											null, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.String,
   *             java.lang.Object)}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter
   */
  public LogRecord path(Category category,
                        String   subloc,
                        Object   msgCode) {
  	LogRecord writtenRec = null;

		if (bePath(category)) {
			writtenRec = 
			logSeverityInt (Severity.PATH, 
											this, 
											new LogController[] {category}, 	
											subloc, 
											null, 
											null, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.String,
   *             java.lang.Object)}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord path(Category[] categories,
                        String     subloc,
                        Object     msgCode) {
  	LogRecord writtenRec = null;

		if (bePath(categories)) {
			writtenRec = 
			logSeverityInt (Severity.PATH, 
											this, 
											categories, 	
											subloc, 
											null, 
											null, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord path(Category category,
                        Object   msgCode,
                        Object[] args) {
  	LogRecord writtenRec = null;

		if (bePath(category)) {
			writtenRec = 
			logSeverityInt (Severity.PATH, 
											this, 
											new LogController[] {category}, 	
											MSG_SUB_LOC, 
											null, 
											null, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord path(Category[] categories,
                        Object     msgCode,
                        Object[]   args) {
  	LogRecord writtenRec = null;

		if (bePath(categories)) {
			writtenRec = 
			logSeverityInt (Severity.PATH, 
											this, 
											categories, 	
											MSG_SUB_LOC, 
											null, 
											null, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord path(Category category,
                        String   subloc,
                        Object   msgCode,
                        Object[] args) {
  	LogRecord writtenRec = null;

		if (bePath(category)) {
			writtenRec = 
			logSeverityInt (Severity.PATH, 
											this, 
											new LogController[] {category}, 	
											subloc, 
											null, 
											null, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord path(Category[] categories,
                        String     subloc,
                        Object     msgCode,
                        Object[]   args) {
  	LogRecord writtenRec = null;

		if (bePath(categories)) {
			writtenRec = 
			logSeverityInt (Severity.PATH, 
											this, 
											categories, 	
											subloc, 
											null, 
											null, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord path(Category category,
                        Object   msgCode,
                        String   msgClear) {
  	LogRecord writtenRec = null;

		if (bePath(category)) {
			writtenRec = 
			logSeverityInt (Severity.PATH, 
											this, 
											new LogController[] {category}, 	
											MSG_SUB_LOC, 
											null, 
											msgClear, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord path(Category[] categories,
                        Object     msgCode,
                        String     msgClear) {
  	LogRecord writtenRec = null;

		if (bePath(categories)) {
			writtenRec = 
			logSeverityInt (Severity.PATH, 
											this, 
											categories, 	
											MSG_SUB_LOC, 
											null, 
											msgClear, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord path(Category category,
                        String   subloc,
                        Object   msgCode,
                        String   msgClear) {
  	LogRecord writtenRec = null;

		if (bePath(category)) {
			writtenRec = 
			logSeverityInt (Severity.PATH, 
											this, 
											new LogController[] {category}, 	
											subloc, 
											null, 
											msgClear, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord path(Category[] categories,
                        String     subloc,
                        Object     msgCode,
                        String     msgClear) {
  	LogRecord writtenRec = null;

		if (bePath(categories)) {
			writtenRec = 
			logSeverityInt (Severity.PATH, 
											this, 
											categories, 	
											subloc, 
											null, 
											msgClear, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @param  args     Arguments as object references
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord path(Category category,
                        Object   msgCode,
                        Object[] args,
                        String   msgClear) {
  	LogRecord writtenRec = null;

		if (bePath(category)) {
			writtenRec = 
			logSeverityInt (Severity.PATH, 
											this, 
											new LogController[] {category}, 	
											MSG_SUB_LOC, 
											null, 
											msgClear, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @param  args       Arguments as object references
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord path(Category[] categories,
                        Object     msgCode,
                        Object[]   args,
                        String     msgClear) {
  	LogRecord writtenRec = null;

		if (bePath(categories)) {
			writtenRec = 
			logSeverityInt (Severity.PATH, 
											this, 
											categories, 	
											null, 
											null, 
											msgClear, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @param  args     Arguments as object references
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter   *             
   *             
   */
  public LogRecord path(Category category,
                        String   subloc,
                        Object   msgCode,
                        Object[] args,
                        String   msgClear) {
  	LogRecord writtenRec = null;

		if (bePath(category)) {
			writtenRec = 
			logSeverityInt (Severity.PATH, 
											this, 
											new LogController[] {category}, 	
											subloc, 
											null, 
											msgClear, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits a path message, that is a message of severity
   * {@link Severity#PATH}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @param  args       Arguments as object references
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord path(Category[] categories,
                        String     subloc,
                        Object     msgCode,
                        Object[]   args,
                        String     msgClear) {
  	LogRecord writtenRec = null;

		if (bePath(categories)) {
			writtenRec = 
			logSeverityInt (Severity.PATH, 
											this, 
											categories, 	
											subloc, 
											null, 
											msgClear, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  //********************************************** 
  // 		INFO MSG OBJECT METHODS
	//********************************************** 

  /**
   * Same as
   * {@link #log(int,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  msgObject Message object
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord info(MsgObject msgObject) {
		LogRecord writtenRec = null;
		if (beInfo()) {
			writtenRec = 
				logTInt (Severity.INFO, 
								 this, 
								 MSG_RELATIVES, 
								 MSG_SUB_LOC, 
								 msgObject.getMsgText(), 
								 MsgType.PLAIN, 
								 MSG_ARGS,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  category 	Category of message
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord info(Category 		category,
                         MsgObject  msgObject) {
		
  	LogRecord writtenRec = null;
		if (beInfo(category)) {
		  writtenRec = 
		  logSeverityTInt (Severity.INFO, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category[],
   *              com.sap.tc.logging.MsgObject)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  categories Categories of message
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord info(Category[] categories,
                         MsgObject msgObject) {
		LogRecord writtenRec = null;
		if (beInfo(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.INFO, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits an informational message, that is a message of severity
   * {@link com.sap.tc.logging.Severity#INFO}.
   * @param  subloc 		Name of sublocation
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord info(String subloc,
                         MsgObject msgObject) {
		LogRecord writtenRec = null;
		if (beInfo()) {
			writtenRec = 
				logTInt (Severity.INFO, 
								 this, 
								 MSG_RELATIVES, 
								 subloc, 
								 msgObject.getMsgText(), 
								 MsgType.PLAIN, 
								 MSG_ARGS,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category,
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  category 	Category of message
   * @param  subloc   	Name of sublocation
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord info(Category 	category,
                    		String   	subloc,
												MsgObject msgObject) {
		LogRecord writtenRec = null;
		if (beInfo(category)) {
			writtenRec = 
			logSeverityTInt (Severity.INFO, 
												this, 
												new LogController[] {category}, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category[],
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord info(Category[] categories,
                         String     subloc,
                         MsgObject  msgObject) {
		LogRecord writtenRec = null;
		if (beInfo(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.INFO, 
												this, 
												categories, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  msgObject  Message object
   * @param  args 			Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord info(MsgObject   msgObject,
                    		 Object[] 	args) {
		LogRecord writtenRec = null;
		if (beInfo()) {
			writtenRec = 
				logTInt (Severity.INFO, 
								 this, 
								 MSG_RELATIVES, 
								 MSG_SUB_LOC, 
								 msgObject.getMsgText(), 
								 MsgType.JAVA, 
								 args,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  category 	Category of message
   * @param  msgObject  Message object
   * @param  args     	Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord info(Category 	category,
                        MsgObject msgObject,
                        Object[] 	args) {
		LogRecord writtenRec = null;
		if (beInfo(category)) {
			writtenRec = 
			logSeverityTInt (Severity.INFO, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(),
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category[],
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  categories Categories of message
   * @param  msgObject  Message object
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord info(Category[] categories,
                    		 MsgObject  msgObject,
                    		 Object[]   args) {
		LogRecord writtenRec = null;
		if (beInfo(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.INFO, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits an informational message, that is a message of severity
   * {@link com.sap.tc.logging.Severity#INFO}.
   * @param  subloc 		Name of sublocation
   * @param  msgObject  Message object
   * @param  args   		Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord info(String   		subloc,
                         MsgObject  msgObject,
                         Object[] 	args) {
		LogRecord writtenRec = null;
		if (beInfo()) {
			writtenRec = 
				logTInt (Severity.INFO, 
								 this, 
								 MSG_RELATIVES, 
								 subloc, 
								 msgObject.getMsgText(), 
								 MsgType.JAVA, 
								 args,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category,
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  category 	Category of message
   * @param  subloc   	Name of sublocation
   * @param  msgObject  Message object
   * @param  args     	Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord info(Category 	category,
                         String   	subloc,
                         MsgObject  msgObject,
                         Object[] 	args) {
		LogRecord writtenRec = null;
		if (beInfo(category)) {
			writtenRec = 
			logSeverityTInt (Severity.INFO, 
												this, 
												new LogController[] {category}, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category[],
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgObject  Message object
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter
   *             or issue separate calls to a Location and a Category parameter              
   */
  public LogRecord info(Category[] categories,
                         String     subloc,
                         MsgObject  msgObject,
                         Object[]   args) {
		LogRecord writtenRec = null;
		if (beInfo(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.INFO, 
												this, 
												categories, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  //********************************************** 
  // 		INFO T METHODS
	//********************************************** 
  
  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  msg Message text
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord infoT(String msg) {
  	LogRecord writtenRec = null;
		if (beInfo()) {
			writtenRec = 
				logTInt (Severity.INFO, 
								 this, 
								 MSG_RELATIVES, 
								 MSG_SUB_LOC, 
								 msg, 
								 MsgType.PLAIN, 
								 MSG_ARGS,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  category Category of message
   * @param  msg      Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord infoT(Category category,
                         String   msg) {
  	LogRecord writtenRec = null;
		if (beInfo(category)) {
		  writtenRec = 
		  logSeverityTInt (Severity.INFO, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  categories Categories of message
   * @param  msg        Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord infoT(Category[] categories,
                         String     msg) {
  	LogRecord writtenRec = null;
		if (beInfo(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.INFO, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String,
   *              java.lang.String)}
   * but always emits an informational message, that is a message of severity
   * {@link com.sap.tc.logging.Severity#INFO}.
   * @param  subloc Name of sublocation
   * @param  msg    Message text
   */
  public LogRecord infoT(String subloc,
                         String msg) {
  	LogRecord writtenRec = null;
		if (beInfo()) {
			writtenRec = 
				logTInt (Severity.INFO, 
								 this, 
								 MSG_RELATIVES, 
								 subloc, 
								 msg, 
								 MsgType.PLAIN, 
								 MSG_ARGS,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String,
   *              java.lang.String)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msg      Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord infoT(Category category,
                    String   subloc,
                    String   msg) {
  	LogRecord writtenRec = null;
		if (beInfo(category)) {
			writtenRec = 
			logSeverityTInt (Severity.INFO, 
												this, 
												new LogController[] {category}, 
												subloc, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String,
   *              java.lang.String)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msg        Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord infoT(Category[] categories,
                         String     subloc,
                         String     msg) {
  	LogRecord writtenRec = null;
		if (beInfo(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.INFO, 
												this, 
												categories, 
												subloc, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  msg  Message template
   * @param  args Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord infoT(String   msg,
                    		 Object[] args) {
  	LogRecord writtenRec = null;
		if (beInfo()) {
			writtenRec = 
				logTInt (Severity.INFO, 
								 this, 
								 MSG_RELATIVES, 
								 MSG_SUB_LOC, 
								 msg, 
								 MsgType.JAVA, 
								 args,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  category Category of message
   * @param  msg      Message template
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord infoT(Category category,
                         String   msg,
                         Object[] args) {
  	LogRecord writtenRec = null;
		if (beInfo(category)) {
			writtenRec = 
			logSeverityTInt (Severity.INFO, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msg,
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  categories Categories of message
   * @param  msg        Message template
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord infoT(Category[] categories,
                    		 String     msg,
                    		 Object[]   args) {
  	LogRecord writtenRec = null;
		if (beInfo(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.INFO, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits an informational message, that is a message of severity
   * {@link com.sap.tc.logging.Severity#INFO}.
   * @param  subloc Name of sublocation
   * @param  msg    Message template
   * @param  args   Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord infoT(String   subloc,
                         String   msg,
                         Object[] args) {
  	LogRecord writtenRec = null;
		if (beInfo()) {
			writtenRec = 
				logTInt (Severity.INFO, 
								 this, 
								 MSG_RELATIVES, 
								 subloc, 
								 msg, 
								 MsgType.JAVA, 
								 args,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msg      Message template
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord infoT(Category category,
                         String   subloc,
                         String   msg,
                         Object[] args) {
  	LogRecord writtenRec = null;
		if (beInfo(category)) {
			writtenRec = 
			logSeverityTInt (Severity.INFO, 
												this, 
												new LogController[] {category}, 
												subloc, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msg        Message template
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord infoT(Category[] categories,
                         String     subloc,
                         String     msg,
                         Object[]   args) {
  	LogRecord writtenRec = null;
		if (beInfo(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.INFO, 
												this, 
												categories, 
												subloc, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  //********************************************** 
  // 		INFO METHODS
	//********************************************** 
  
  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @deprecated Message Code must be used together with Message Text.  
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord info(Category category,
                        Object   msgCode) {
  	LogRecord writtenRec = null;

		if (beInfo(category)) {
			writtenRec = 
			logSeverityInt (Severity.INFO, 
											this, 
											new LogController[] {category}, 	
											MSG_SUB_LOC, 
											null, 
											null, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @deprecated Message Code must be used together with Message Text.  
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord info(Category[] categories,
                        Object     msgCode) {
  	LogRecord writtenRec = null;

		if (beInfo(categories)) {
			writtenRec = 
			logSeverityInt (Severity.INFO, 
											this, categories, 	
											MSG_SUB_LOC, 
											null, 
											null, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.String,
   *             java.lang.Object)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord info(Category category,
                        String   subloc,
                        Object   msgCode) {
  	LogRecord writtenRec = null;

		if (beInfo(category)) {
			writtenRec = 
			logSeverityInt (Severity.INFO, 
											this, 
											new LogController[] {category}, 	
											subloc, 
											null, 
											null, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.String,
   *             java.lang.Object)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord info(Category[] categories,
                        String     subloc,
                        Object     msgCode) {
  	LogRecord writtenRec = null;

		if (beInfo(categories)) {
			writtenRec = 
			logSeverityInt (Severity.INFO, 
											this, 
											categories, 	
											subloc, 
											null, 
											null, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord info(Category category,
                        Object   msgCode,
                        Object[] args) {
  	LogRecord writtenRec = null;

		if (beInfo(category)) {
			writtenRec = 
			logSeverityInt (Severity.INFO, 
											this, 
											new LogController[] {category}, 	
											MSG_SUB_LOC, 
											null, 
											null, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord info(Category[] categories,
                        Object     msgCode,
                        Object[]   args) {
  	LogRecord writtenRec = null;

		if (beInfo(categories)) {
			writtenRec = 
			logSeverityInt (Severity.INFO, 
											this, 
											categories, 	
											MSG_SUB_LOC, 
											null, 
											null, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord info(Category category,
                        String   subloc,
                        Object   msgCode,
                        Object[] args) {
  	LogRecord writtenRec = null;

		if (beInfo(category)) {
			writtenRec = 
			logSeverityInt (Severity.INFO, 
											this, 
											new LogController[] {category}, 	
											subloc, 
											null, 
											null, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord info(Category[] categories,
                        String     subloc,
                        Object     msgCode,
                        Object[]   args) {
  	LogRecord writtenRec = null;

		if (beInfo(categories)) {
			writtenRec = 
			logSeverityInt (Severity.INFO, 
											this, 
											categories, 	
											subloc, 
											null, 
											null, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord info(Category category,
                        Object   msgCode,
                        String   msgClear) {
  	LogRecord writtenRec = null;

		if (beInfo(category)) {
			writtenRec = 
			logSeverityInt (Severity.INFO, 
											this, 
											new LogController[] {category}, 	
											MSG_SUB_LOC, 
											null, 
											msgClear, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord info(Category[] categories,
                        Object     msgCode,
                        String     msgClear) {
  	LogRecord writtenRec = null;
	
		if (beInfo(categories)) {
			writtenRec = 
			logSeverityInt (Severity.INFO, 
											this, 
											categories, 	
											MSG_SUB_LOC, 
											null, 
											msgClear, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord info(Category category,
                        String   subloc,
                        Object   msgCode,
                        String   msgClear) {
  	LogRecord writtenRec = null;

		if (beInfo(category)) {
			writtenRec = 
			logSeverityInt (Severity.INFO, 
											this, 
											new LogController[] {category}, 	
											subloc, 
											null, 
											msgClear, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord info(Category[] categories,
                         String     subloc,
                         Object     msgCode,
                         String     msgClear) {
  	LogRecord writtenRec = null;

		if (beInfo(categories)) {
			writtenRec = 
			logSeverityInt (Severity.INFO, 
											this, 
											categories, 	
											subloc, 
											null, 
											msgClear, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @param  args     Arguments as object references
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter
   */
  public LogRecord info(Category category,
                        Object   msgCode,
                        Object[] args,
                        String   msgClear) {
  	LogRecord writtenRec = null;

		if (beInfo(category)) {
			writtenRec = 
			logSeverityInt (Severity.INFO, 
											this, 
											new LogController[] {category}, 	
											MSG_SUB_LOC, 
											null, 
											msgClear, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @param  args       Arguments as object references
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord info(Category[] categories,
                        Object     msgCode,
                        Object[]   args,
                        String     msgClear) {
  	LogRecord writtenRec = null;

		if (beInfo(categories)) {
			writtenRec = 
			logSeverityInt (Severity.INFO, 
											this, 
											categories, 	
											null, 
											null, 
											msgClear, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @param  args     Arguments as object references
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord info(Category category,
                        String   subloc,
                        Object   msgCode,
                        Object[] args,
                        String   msgClear) {
  	LogRecord writtenRec = null;

		if (beInfo(category)) {
			writtenRec = 
			logSeverityInt (Severity.INFO, 
											this, 
											new LogController[] {category}, 	
											subloc, 
											null, 
											msgClear, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits an informational message, that is a message of severity
   * {@link Severity#INFO}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @param  args       Arguments as object references
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord info(Category[] categories,
                        String     subloc,
                        Object     msgCode,
                        Object[]   args,
                        String     msgClear) {
  	LogRecord writtenRec = null;

		if (beInfo(categories)) {
			writtenRec = 
			logSeverityInt (Severity.INFO, 
											this, 
											categories, 	
											subloc, 
											null, 
											msgClear, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  //********************************************** 
  // 		WARNING MSG OBJECT METHODS
	//********************************************** 

  /**
   * Same as
   * {@link #log(int,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  msgObject Message object
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord warning(MsgObject msgObject) {
		LogRecord writtenRec = null;
		if (beWarning()) {
			writtenRec = 
				logTInt (Severity.WARNING, 
								 this, 
								 MSG_RELATIVES, 
								 MSG_SUB_LOC, 
								 msgObject.getMsgText(), 
								 MsgType.PLAIN, 
								 MSG_ARGS,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  category 	Category of message
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter  
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warning(Category 	category,
                            MsgObject msgObject) {
		LogRecord writtenRec = null;
		if (beWarning(category)) {
			writtenRec = 
			logSeverityTInt (Severity.WARNING, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category[],
   *              com.sap.tc.logging.MsgObject)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  categories Categories of message
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter  
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warning(Category[] categories,
                           MsgObject  msgObject) {
		LogRecord writtenRec = null;
		if (beWarning(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.WARNING, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  subloc 		Name of sublocation
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord warning(String 		subloc,
                            MsgObject msgObject) {
		LogRecord writtenRec = null;
		if (beWarning()) {
			writtenRec = 
				logTInt (Severity.WARNING, 
								 this, 
								 MSG_RELATIVES, 
								 subloc, 
								 msgObject.getMsgText(), 
								 MsgType.PLAIN, 
								 MSG_ARGS,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category,
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  category 	Category of message
   * @param  subloc   	Name of sublocation
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter  
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warning(Category 	category,
                            String   	subloc,
                            MsgObject msgObject) {
		LogRecord writtenRec = null;
		if (beWarning(category)) {
			writtenRec = 
			logSeverityTInt (Severity.WARNING, 
												this, 
												new LogController[] {category}, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category[],
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter  
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warning(Category[] categories,
                            String     subloc,
                            MsgObject  msgObject) {
		LogRecord writtenRec = null;
		if (beWarning(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.WARNING, 
												this, 
												categories, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  msgObject  Message object
   * @param  args 			Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord warning(MsgObject msgObject,
                            Object[] 	args) {
		LogRecord writtenRec = null;
		if (beWarning()) {
			writtenRec = 
				logTInt (Severity.WARNING, 
								 this, 
								 MSG_RELATIVES, 
								 MSG_SUB_LOC, 
								 msgObject.getMsgText(), 
								 MsgType.JAVA, 
								 args,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  category 	Category of message
   * @param  msgObject  Message object
   * @param  args     	Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter  
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warning(Category 	category,
                            MsgObject msgObject,
                            Object[] 	args) {
		LogRecord writtenRec = null;
		if (beWarning(category)) {
			writtenRec = 
			logSeverityTInt (Severity.WARNING, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category[],
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  categories Categories of message
   * @param  msgObject  Message object
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter  
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warning(Category[] categories,
                            MsgObject  msgObject,
                            Object[]   args) {
		LogRecord writtenRec = null;
		if (beWarning(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.WARNING, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  subloc 		Name of sublocation
   * @param  msgObject  Message object
   * @param  args   		Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord warning(String   	subloc,
                            MsgObject msgObject,
                            Object[] 	args) {
		LogRecord writtenRec = null;
		if (beWarning()) {
			writtenRec = 
				logTInt (Severity.WARNING, 
								 this, 
								 MSG_RELATIVES, 
								 subloc, 
								 msgObject.getMsgText(), 
								 MsgType.JAVA, 
								 args,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category,
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  category 	Category of message
   * @param  subloc   	Name of sublocation
   * @param  msgObject  Message object
   * @param  args     	Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter  
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warning(Category 	category,
                            String   	subloc,
                            MsgObject msgObject,
                            Object[] 	args) {
		LogRecord writtenRec = null;
		if (beWarning(category)) {
			writtenRec = 
			logSeverityTInt (Severity.WARNING, 
												this, 
												new LogController[] {category}, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category[],
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  MsgObject  Message object
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter  
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warning(Category[] categories,
                            String     subloc,
                            MsgObject  msgObject,
                            Object[]   args) {
		LogRecord writtenRec = null;
		if (beWarning(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.WARNING, 
												this, 
												categories, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  //********************************************** 
  // 		WARNING T METHODS
	//********************************************** 

  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  msg Message text
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord warningT(String msg) {
  	LogRecord writtenRec = null;
		if (beWarning()) {
			writtenRec = 
				logTInt (Severity.WARNING, 
								 this, 
								 MSG_RELATIVES, 
								 MSG_SUB_LOC, 
								 msg, 
								 MsgType.PLAIN, 
								 MSG_ARGS,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  category Category of message
   * @param  msg      Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter  
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warningT(Category category,
                            String   msg) {
  	LogRecord writtenRec = null;
		if (beWarning(category)) {
			writtenRec = 
			logSeverityTInt (Severity.WARNING, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  categories Categories of message
   * @param  msg        Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter  
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warningT(Category[] categories,
                            String     msg) {
  	LogRecord writtenRec = null;
		if (beWarning(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.WARNING, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String,
   *              java.lang.String)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  subloc Name of sublocation
   * @param  msg    Message text
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord warningT(String subloc,
                            String msg) {
  	LogRecord writtenRec = null;
		if (beWarning()) {
			writtenRec = 
				logTInt (Severity.WARNING, 
								 this, 
								 MSG_RELATIVES, 
								 subloc, 
								 msg, 
								 MsgType.PLAIN, 
								 MSG_ARGS,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String,
   *              java.lang.String)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msg      Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter  
   *             or issue separate calls to a Location and a Category parameter
   */
  public LogRecord warningT(Category category,
                            String   subloc,
                            String   msg) {
  	LogRecord writtenRec = null;
		if (beWarning(category)) {
			writtenRec = 
			logSeverityTInt (Severity.WARNING, 
												this, 
												new LogController[] {category}, 
												subloc, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String,
   *              java.lang.String)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msg        Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter  
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warningT(Category[] categories,
                            String     subloc,
                            String     msg) {
  	LogRecord writtenRec = null;
		if (beWarning(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.WARNING, 
												this, 
												categories, 
												subloc, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  msg  Message template
   * @param  args Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord warningT(String   msg,
                            Object[] args) {
  	LogRecord writtenRec = null;
		if (beWarning()) {
			writtenRec = 
				logTInt (Severity.WARNING, 
								 this, 
								 MSG_RELATIVES, 
								 MSG_SUB_LOC, 
								 msg, 
								 MsgType.JAVA, 
								 args,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  category Category of message
   * @param  msg      Message template
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warningT(Category category,
                            String   msg,
                            Object[] args) {
  	LogRecord writtenRec = null;
		if (beWarning(category)) {
			writtenRec = 
			logSeverityTInt (Severity.WARNING, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  categories Categories of message
   * @param  msg        Message template
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter
   */
  public LogRecord warningT(Category[] categories,
                            String     msg,
                            Object[]   args) {
  	LogRecord writtenRec = null;
		if (beWarning(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.WARNING, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  subloc Name of sublocation
   * @param  msg    Message template
   * @param  args   Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord warningT(String   subloc,
                            String   msg,
                            Object[] args) {
  	LogRecord writtenRec = null;
		if (beWarning()) {
			writtenRec = 
				logTInt (Severity.WARNING, 
								 this, 
								 MSG_RELATIVES, 
								 subloc, 
								 msg, 
								 MsgType.JAVA, 
								 args,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msg      Message template
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warningT(Category category,
                            String   subloc,
                            String   msg,
                            Object[] args) {
  	LogRecord writtenRec = null;
		if (beWarning(category)) {
			writtenRec = 
			logSeverityTInt (Severity.WARNING, 
												this, 
												new LogController[] {category}, 
												subloc, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msg        Message template
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warningT(Category[] categories,
                            String     subloc,
                            String     msg,
                            Object[]   args) {
  	LogRecord writtenRec = null;
		if (beWarning(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.WARNING, 
												this, 
												categories, 
												subloc, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  //********************************************** 
  // 		WARNING METHODS
	//********************************************** 
  
  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @deprecated Message Code must be used together with Message Text.  
   * @see    #setResourceBundleName(java.lang.String) 
   */
  public LogRecord warning(Category category,
                           Object   msgCode) {
  	LogRecord writtenRec = null;

		if (beWarning(category)) {
			writtenRec = 
			logSeverityInt (Severity.WARNING, 
											this, 
											new LogController[] {category}, 	
											MSG_SUB_LOC, 
											null, 
											null, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warning(Category[] categories,
                           Object     msgCode) {
  	LogRecord writtenRec = null;

		if (beWarning(categories)) {
			writtenRec = 
			logSeverityInt (Severity.WARNING, 
											this, categories, 	
											MSG_SUB_LOC, 
											null, 
											null, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.String,
   *             java.lang.Object)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warning(Category category,
                           String   subloc,
                           Object   msgCode) {
  	LogRecord writtenRec = null;

		if (beWarning(category)) {
			writtenRec = 
			logSeverityInt (Severity.WARNING, 
											this, 
											new LogController[] {category}, 	
											subloc, 
											null, 
											null, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.String,
   *             java.lang.Object)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warning(Category[] categories,
                           String     subloc,
                           Object     msgCode) {
  	LogRecord writtenRec = null;

		if (beWarning(categories)) {
			writtenRec = 
			logSeverityInt (Severity.WARNING, 
											this, 
											categories, 	
											subloc, 
											null, 
											null, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warning(Category category,
                           Object   msgCode,
                           Object[] args) {
  	LogRecord writtenRec = null;

		if (beWarning(category)) {
			writtenRec = 
			logSeverityInt (Severity.WARNING, 
											this, 
											new LogController[] {category}, 	
											MSG_SUB_LOC, 
											null, 
											null, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warning(Category[] categories,
                           Object     msgCode,
                           Object[]   args) {
  	LogRecord writtenRec = null;

		if (beWarning(categories)) {
			writtenRec = 
			logSeverityInt (Severity.WARNING, 
											this, 
											categories, 	
											MSG_SUB_LOC, 
											null, 
											null, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warning(Category category,
                           String   subloc,
                           Object   msgCode,
                           Object[] args) {
  	LogRecord writtenRec = null;

		if (beWarning(category)) {
			writtenRec = 
			logSeverityInt (Severity.WARNING, 
											this, 
											new LogController[] {category}, 	
											subloc, 
											null, 
											null, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warning(Category[] categories,
                           String     subloc,
                           Object     msgCode,
                           Object[]   args) {
  	LogRecord writtenRec = null;

		if (beWarning(categories)) {
			writtenRec = 
			logSeverityInt (Severity.WARNING, 
											this, 
											categories, 	
											subloc, 
											null, 
											null, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warning(Category category,
                           Object   msgCode,
                           String   msgClear) {
  	LogRecord writtenRec = null;

		if (beWarning(category)) {
			writtenRec = 
			logSeverityInt (Severity.WARNING, 
											this, 
											new LogController[] {category}, 	
											MSG_SUB_LOC, 
											null, 
											msgClear, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warning(Category[] categories,
                           Object     msgCode,
                           String     msgClear) {
  	LogRecord writtenRec = null;

		if (beWarning(categories)) {
			writtenRec = 
			logSeverityInt (Severity.WARNING, 
											this, 
											categories, 	
											MSG_SUB_LOC, 
											null, 
											msgClear, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warning(Category category,
                           String   subloc,
                           Object   msgCode,
                           String   msgClear) {
  	LogRecord writtenRec = null;

		if (beWarning(category)) {
			writtenRec = 
			logSeverityInt (Severity.WARNING, 
											this, 
											new LogController[] {category}, 	
											subloc, 
											null, 
											msgClear, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warning(Category[] categories,
                           String     subloc,
                           Object     msgCode,
                           String     msgClear) {
  	LogRecord writtenRec = null;

		if (beWarning(categories)) {
			writtenRec = 
			logSeverityInt (Severity.WARNING, 
											this, 
											categories, 	
											subloc, 
											null, 
											msgClear, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @param  args     Arguments as object references
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warning(Category category,
                           Object   msgCode,
                           Object[] args,
                           String   msgClear) {
  	LogRecord writtenRec = null;

		if (beWarning(category)) {
			writtenRec = 
			logSeverityInt (Severity.WARNING, 
											this, 
											new LogController[] {category}, 	
											MSG_SUB_LOC, 
											null, 
											msgClear, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @param  args       Arguments as object references
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter
   *             or issue separate calls to a Location and a Category parameter
   */
  public LogRecord warning(Category[] categories,
                           Object     msgCode,
                           Object[]   args,
                           String     msgClear) {
  	LogRecord writtenRec = null;

		if (beWarning(categories)) {
			writtenRec = 
			logSeverityInt (Severity.WARNING, 
											this, 
											categories, 	
											null, 
											null, 
											msgClear, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @param  args     Arguments as object references
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warning(Category category,
                           String   subloc,
                           Object   msgCode,
                           Object[] args,
                           String   msgClear) {
  	LogRecord writtenRec = null;

		if (beWarning(category)) {
			writtenRec = 
			logSeverityInt (Severity.WARNING, 
											this, 
											new LogController[] {category}, 	
											subloc, 
											null, 
											msgClear, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits a warning message, that is a message of severity
   * {@link Severity#WARNING}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @param  args       Arguments as object references
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord warning(Category[] categories,
                           String     subloc,
                           Object     msgCode,
                           Object[]   args,
                           String     msgClear) {
  	LogRecord writtenRec = null;

		if (beWarning(categories)) {
			writtenRec = 
			logSeverityInt (Severity.WARNING, 
											this, 
											categories, 	
											subloc, 
											null, 
											msgClear, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  //********************************************** 
  // 		ERROR MSG OBJECT METHODS
	//********************************************** 

  /**
   * Same as
   * {@link #logT(int,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  msgObject Message object
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord error(MsgObject msgObject) {
		LogRecord writtenRec = null;
		if (beError()) {
			writtenRec = 
				logTInt (Severity.ERROR, 
									this, 
									MSG_RELATIVES,
									MSG_SUB_LOC, 
									msgObject.getMsgText(), 
									MsgType.PLAIN, 
									MSG_ARGS);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  category 	Category of message
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter
   *             or issue separate calls to a Location and a Category parameter                
   */
  public LogRecord error(Category 	category,
                          MsgObject msgObject) {
		LogRecord writtenRec = null;
		if (beError(category)) {
			writtenRec = 
			logSeverityTInt (Severity.ERROR, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category[],
   *              com.sap.tc.logging.MsgObject)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  categories Categories of message
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord error(Category[] categories,
                         MsgObject  msgObject) {
		LogRecord writtenRec = null;
		if (beError(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.ERROR, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  subloc 		Name of sublocation
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord error(String 		subloc,
                         MsgObject 	msgObject) {
		LogRecord writtenRec = null;
		if (beError()) {
			writtenRec = 
				logTInt (Severity.ERROR, 
								 this, 
								 MSG_RELATIVES, 
								 subloc, 
								 msgObject.getMsgText(), 
								 MsgType.PLAIN, 
								 MSG_ARGS);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category,
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  category 	Category of message
   * @param  subloc   	Name of sublocation
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord error(Category 	category,
                          String   	subloc,
                          MsgObject msgObject) {
		LogRecord writtenRec = null;
		if (beError(category)) {
			writtenRec = 
			logSeverityTInt (Severity.ERROR, 
												this, 
												new LogController[] {category}, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category[],
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord error(Category[] categories,
                          String     subloc,
                          MsgObject  msgObject) {
		LogRecord writtenRec = null;
		if (beError(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.ERROR, 
												this, 
												categories, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  msgObject  Message object
   * @param  args 			Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord error(MsgObject msgObject,
                          Object[] 	args) {
		LogRecord writtenRec = null;
		if (beError()) {
			writtenRec = 
				logTInt (Severity.ERROR, 
								 this, 
								 MSG_RELATIVES, 
								 MSG_SUB_LOC, 
								 msgObject.getMsgText(), 
								 MsgType.JAVA, 
								 args);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  category 	Category of message
   * @param  msgObject  Message object
   * @param  args     	Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord error(Category 	category,
                          MsgObject msgObject,
                          Object[] 	args) {
		LogRecord writtenRec = null;
		if (beError(category)) {
			writtenRec = 
			logSeverityTInt (Severity.ERROR, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category[],
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  categories Categories of message
   * @param  msgObject  Message object
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord error(Category[] categories,
                          MsgObject msgObject,
                          Object[]  args) {
		LogRecord writtenRec = null;
		if (beError(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.ERROR, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  subloc 		Name of sublocation
   * @param  msgObject  Message object
   * @param  args   		Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord error(String   	subloc,
                          MsgObject msgObject,
                          Object[] 	args) {
		LogRecord writtenRec = null;
		if (beError()) {
			writtenRec = 
				logTInt (Severity.ERROR, 
								 this, 
								 MSG_RELATIVES, 
								 subloc, 
								 msgObject.getMsgText(), 
								 MsgType.JAVA, 
								 args);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category,
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  category 	Category of message
   * @param  subloc   	Name of sublocation
   * @param  msgObject  Message object
   * @param  args     	Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord error(Category 	category,
                          String   	subloc,
                          MsgObject msgObject,
                          Object[] 	args) {
		LogRecord writtenRec = null;
		if (beError(category)) {
			writtenRec = 
			logSeverityTInt (Severity.ERROR, 
												this, 
												new LogController[] {category}, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category[],
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgObject  Message object
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord error(Category[]  categories,
                          String     subloc,
                          MsgObject  msgObject,
                          Object[]   args) {
		LogRecord writtenRec = null;
		if (beError(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.ERROR, 
												this, 
												categories, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  //********************************************** 
  // 		ERROR T METHODS
	//********************************************** 
  
  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  msg Message text
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord errorT(String msg) {
  	LogRecord writtenRec = null;
		if (beError()) {
			writtenRec = 
				logTInt (Severity.ERROR, 
									this, 
									MSG_RELATIVES,
									MSG_SUB_LOC, 
									msg, 
									MsgType.PLAIN, 
									MSG_ARGS,
                                    null,
                                    null,
                                    this.csnComponent,
                                    this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  category Category of message
   * @param  msg      Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord errorT(Category category,
                          String   msg) {
  	LogRecord writtenRec = null;
		if (beError(category)) {
			writtenRec = 
			logSeverityTInt (Severity.ERROR, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  categories Categories of message
   * @param  msg        Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter
   *             or issue separate calls to a Location and a Category parameter                
   */
  public LogRecord errorT(Category[] categories,
                          String     msg) {
  	LogRecord writtenRec = null;
		if (beError(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.ERROR, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String,
   *              java.lang.String)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  subloc Name of sublocation
   * @param  msg    Message text
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord errorT(String subloc,
                          String msg) {
  	LogRecord writtenRec = null;
		if (beError()) {
			writtenRec = 
				logTInt (Severity.ERROR, 
								 this, 
								 MSG_RELATIVES, 
								 subloc, 
								 msg, 
								 MsgType.PLAIN, 
								 MSG_ARGS,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String,
   *              java.lang.String)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msg      Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord errorT(Category category,
                          String   subloc,
                          String   msg) {
  	LogRecord writtenRec = null;
		if (beError(category)) {
			writtenRec = 
			logSeverityTInt (Severity.ERROR, 
												this, 
												new LogController[] {category}, 
												subloc, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String,
   *              java.lang.String)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msg        Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord errorT(Category[] categories,
                          String     subloc,
                          String     msg) {
  	LogRecord writtenRec = null;
		if (beError(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.ERROR, 
												this, 
												categories, 
												subloc, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  msg  Message template
   * @param  args Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord errorT(String   msg,
                          Object[] args) {
  	LogRecord writtenRec = null;
		if (beError()) {
			writtenRec = 
				logTInt (Severity.ERROR, 
								 this, 
								 MSG_RELATIVES, 
								 MSG_SUB_LOC, 
								 msg, 
								 MsgType.JAVA, 
								 args,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  category Category of message
   * @param  msg      Message template
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter
   *             or issue separate calls to a Location and a Category parameter                
   */
  public LogRecord errorT(Category category,
                          String   msg,
                          Object[] args) {
  	LogRecord writtenRec = null;
		if (beError(category)) {
			writtenRec = 
			logSeverityTInt (Severity.ERROR, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  categories Categories of message
   * @param  msg        Message template
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord errorT(Category[] categories,
                          String     msg,
                          Object[]   args) {
  	LogRecord writtenRec = null;
		if (beError(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.ERROR, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  subloc Name of sublocation
   * @param  msg    Message template
   * @param  args   Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord errorT(String   subloc,
                          String   msg,
                          Object[] args) {
  	LogRecord writtenRec = null;
		if (beError()) {
			writtenRec = 
				logTInt (Severity.ERROR, 
								 this, 
								 MSG_RELATIVES, 
								 subloc, 
								 msg, 
								 MsgType.JAVA, 
								 args,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msg      Message template
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter   
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord errorT(Category category,
                          String   subloc,
                          String   msg,
                          Object[] args) {
  	LogRecord writtenRec = null;
		if (beError(category)) {
			writtenRec = 
			logSeverityTInt (Severity.ERROR, 
												this, 
												new LogController[] {category}, 
												subloc, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msg        Message template
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord errorT(Category[] categories,
                          String     subloc,
                          String     msg,
                          Object[]   args) {
  	LogRecord writtenRec = null;
		if (beError(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.ERROR, 
												this, 
												categories, 
												subloc, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  //********************************************** 
  // 		ERROR METHODS
	//********************************************** 
  
  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @deprecated Message Code must be used together with Message Text.  
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter
   */
  public LogRecord error(Category category,
                         Object   msgCode) {
    LogRecord writtenRec = null;

    if (beError(category)) {
			writtenRec = 
			logSeverityInt (Severity.ERROR, 
											this, 
											new LogController[] {category}, 	
											MSG_SUB_LOC, 
											null, 
											null, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
    }
    return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @deprecated Message Code must be used together with Message Text.  
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord error(Category[] categories,
                         Object     msgCode) {
		LogRecord writtenRec = null;
	
		if (beError(categories)) {
			writtenRec = 
			logSeverityInt (Severity.ERROR, 
											this, 
											categories, 	
											MSG_SUB_LOC,
											null, 
											null,
											MsgType.PLAIN,
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		}
    return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.String,
   *             java.lang.Object)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord error(Category category,
                         String   subloc,
                         Object   msgCode) {
		LogRecord writtenRec = null;

		if (beError(category)) {
				writtenRec = 
				logSeverityInt (Severity.ERROR, 
												this, 
												new LogController[] {category}, 	
												subloc, 
												null, 
												null, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.String,
   *             java.lang.Object)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord error(Category[] categories,
                         String     subloc,
                         Object     msgCode) {
		LogRecord writtenRec = null;

 		if (beError(categories)) {
		 	writtenRec = 
		 	logSeverityInt (Severity.ERROR, 
										 	this, 
											categories, 	
										 	subloc, 
										 	null, 
										 	null, 
										 	MsgType.PLAIN, 
										 	MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
 		}
    return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord error(Category category,
                         Object   msgCode,
                         Object[] args) {
		LogRecord writtenRec = null;

		if (beError(category)) {
				writtenRec = 
				logSeverityInt (Severity.ERROR, 
												this, 
												new LogController[] {category}, 	
												MSG_SUB_LOC, 
												null, 
												null, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord error(Category[] categories,
                         Object     msgCode,
                         Object[]   args) {
		LogRecord writtenRec = null;

		if (beError(categories)) {
				writtenRec = 
				logSeverityInt (Severity.ERROR, 
												this, 
												categories, 	
												MSG_SUB_LOC, 
												null, 
												null, 
												MsgType.JAVA,
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
    return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord error(Category category,
                         String   subloc,
                         Object   msgCode,
                         Object[] args) {
		LogRecord writtenRec = null;

		if (beError(category)) {
			writtenRec = 
			logSeverityInt (Severity.ERROR, 
											this, 
											new LogController[] {category}, 	
											subloc, 
											null, 
											null, 
											MsgType.JAVA,
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		}
    return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter
   */
  public LogRecord error(Category[] categories,
                         String     subloc,
                         Object     msgCode,
                         Object[]   args) {
		LogRecord writtenRec = null;

		if (beError(categories)) {
				writtenRec = 
				logSeverityInt (Severity.ERROR, 
												this, 
												categories, 	
												subloc, 
												null, 
												null, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord error(Category category,
                         Object   msgCode,
                         String   msgClear) {
		LogRecord writtenRec = null;
	
		if (beError(category)) {
				writtenRec = 
				logSeverityInt (Severity.ERROR, 
												this, 
												new LogController[] {category}, 	
												MSG_SUB_LOC, 
												null, 
												msgClear, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord error(Category[] categories,
                         Object     msgCode,
                         String     msgClear) {
		LogRecord writtenRec = null;

		if (beError(categories)) {
				writtenRec = 
				logSeverityInt (Severity.ERROR, 
												this, 
												categories, 	
												MSG_SUB_LOC, 
												null, 
												msgClear, 
												MsgType.PLAIN,
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord error(Category category,
                         String   subloc,
                         Object   msgCode,
                         String   msgClear) {
		LogRecord writtenRec = null;

		if (beError(category)) {
			writtenRec = 
			logSeverityInt (Severity.ERROR, 
											this, 
											new LogController[] {category}, 	
											subloc, 
											null, 
											msgClear, 
											MsgType.PLAIN,
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		}
    return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord error(Category[] categories,
                          String    subloc,
                          Object    msgCode,
                          String    msgClear) {
		LogRecord writtenRec = null;

		if (beError(categories)) {
			writtenRec = 
			logSeverityInt (Severity.ERROR, 
											this, 
											categories, 	
											subloc, 
											null, 
											msgClear, 
											MsgType.PLAIN,
											MSG_ARGS);
		}
    return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @param  args     Arguments as object references
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord error(Category category,
                         Object   msgCode,
                         Object[] args,
                         String   msgClear) {
		LogRecord writtenRec = null;

		if (beError(category)) {
				writtenRec = 
				logSeverityInt (Severity.ERROR, 
												this, 
												new LogController[] {category}, 	
												MSG_SUB_LOC, 
												null, 
												msgClear, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @param  args       Arguments as object references
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord error(Category[] categories,
                         Object     msgCode,
                         Object[]   args,
                         String     msgClear) {
		LogRecord writtenRec = null;

		if (beError(categories)) {
				writtenRec = 
				logSeverityInt (Severity.ERROR, 
												this, 
												categories, 	
												MSG_SUB_LOC, 
												null, 
												msgClear, 
												MsgType.JAVA,
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
    return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @param  args     Arguments as object references
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord error(Category category,
                         String   subloc,
                         Object   msgCode,
                         Object[] args,
                         String   msgClear) {
		LogRecord writtenRec = null;

		if (beError(category)) {
			writtenRec = 
			logSeverityInt (Severity.ERROR, 
											this, 
											new LogController[] {category}, 	
											subloc, 
											null, 
											msgClear, 
											MsgType.JAVA,
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		}
    return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits an error message, that is a message of severity
   * {@link Severity#ERROR}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @param  args       Arguments as object references
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord error(Category[] categories,
                         String     subloc,
                         Object     msgCode,
                         Object[]   args,
                         String     msgClear) {
		LogRecord writtenRec = null;

	 	if (beError(categories)) {
			writtenRec = 
		 	logSeverityInt (Severity.ERROR, 
										 	this, 
											categories, 	
										 	subloc, 
										 	null, 
										 	msgClear, 
										 	MsgType.JAVA,
										 	args);
	 	}
	 	return writtenRec;
  }

  //********************************************** 
  // 		FATAL MSG OBJECT METHODS
	//********************************************** 

  /**
   * Same as
   * {@link #log(int,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  msgObject Message object
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord fatal(MsgObject msgObject) {
		LogRecord writtenRec = null;
		if (beFatal()) {
			writtenRec = 
				logTInt (Severity.FATAL, 
								 this, 
								 MSG_RELATIVES, 
								 MSG_SUB_LOC, 
								 msgObject.getMsgText(), 
								 MsgType.PLAIN, 
								 MSG_ARGS,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  category 	Category of message
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatal(Category 	category,
                          MsgObject msgObject) {
    LogRecord writtenRec = null;
    if (beFatal(category)) {
      writtenRec = 
	  	logSeverityTInt (Severity.FATAL, 
			      						this, 
			      						new LogController[] {category}, 
			      						MSG_SUB_LOC, 
			      						msgObject.getMsgText(), 
			      						MsgType.PLAIN, 
			      						MSG_ARGS,
                                        null,
                                        null,
                                        this.csnComponent,
                                        this.dcName);
    }
    return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category[],
   *              com.sap.tc.logging.MsgObject)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  categories Categories of message
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter
   */
  public LogRecord fatal(Category[] categories,
                         MsgObject  msgObject) {
		LogRecord writtenRec = null;
		if (beFatal(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.FATAL, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  subloc 		Name of sublocation
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord fatal(String 		subloc,
                         MsgObject msgObject) {
		LogRecord writtenRec = null;
		if (beFatal()) {
			writtenRec = 
				logTInt (Severity.FATAL, 
								 this, 
								 MSG_RELATIVES, 
								 subloc, 
								 msgObject.getMsgText(), 
								 MsgType.PLAIN, 
								 MSG_ARGS,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category,
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  category 	Category of message
   * @param  subloc   	Name of sublocation
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatal(Category 	category,
                          String   	subloc,
                          MsgObject msgObject) {
		LogRecord writtenRec = null;
		if (beFatal(category)) {
			writtenRec = 
			logSeverityTInt (Severity.FATAL, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category[],
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgObject  Message object
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatal(Category[] categories,
                          String     subloc,
                          MsgObject  msgObject) {
		LogRecord writtenRec = null;
		if (beFatal(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.FATAL, 
												this, 
												categories, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  msgObject  Message object
   * @param  args 			Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord fatal(MsgObject  msgObject,
                          Object[] 	args) {
		LogRecord writtenRec = null;
		if (beFatal()) {
			writtenRec = 
				logTInt (Severity.FATAL, 
				 				 this, 
								 MSG_RELATIVES, 
								 MSG_SUB_LOC, 
								 msgObject.getMsgText(), 
								 MsgType.JAVA, 
								 args,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  category 	Category of message
   * @param  msgObject  Message object
   * @param  args     	Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatal(Category 	category,
                          MsgObject msgObject,
                          Object[] 	args) {
		LogRecord writtenRec = null;
		if (beFatal(category)) {
			writtenRec = 
			logSeverityTInt (Severity.FATAL, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category[],
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  categories Categories of message
   * @param  msgObject  Message object
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatal(Category[] categories,
                          MsgObject  msgObject,
                          Object[]   args) {
		LogRecord writtenRec = null;
		if (beFatal(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.FATAL, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link Location#log(int,
   *                      java.lang.String,
   *                      com.sap.tc.logging.MsgObject,
   *                      java.lang.Object[])}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  subloc 		Name of sublocation
   * @param  msgObject  Message object
   * @param  args   		Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord fatal(String   	subloc,
                          MsgObject msgObject,
                          Object[] 	args) {
		LogRecord writtenRec = null;
		if (beFatal()) {
			writtenRec = 
				logTInt (Severity.FATAL, 
								 this, 
								 MSG_RELATIVES, 
								 subloc, 
								 msgObject.getMsgText(), 
								 MsgType.JAVA, 
								 args,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category,
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  category 	Category of message
   * @param  subloc   	Name of sublocation
   * @param  msgObject  Message object
   * @param  args     	Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatal(Category 	category,
                          String   	subloc,
                          MsgObject msgObject,
                          Object[] 	args) {
		LogRecord writtenRec = null;
		if (beFatal(category)) {
			writtenRec = 
			logSeverityTInt (Severity.FATAL, 
												this, 
												new LogController[] {category}, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *              Category[],
   *              java.lang.String,
   *              com.sap.tc.logging.MsgObject,
   *              java.lang.Object[])}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgObject  Message object
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatal(Category[] categories,
                          String     subloc,
                          MsgObject  msgObject,
                          Object[]   args) {
		LogRecord writtenRec = null;
		if (beFatal(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.FATAL, 
												this, 
												categories, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  //********************************************** 
  // 		FATAL T METHODS
	//********************************************** 

  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  msg Message text
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord fatalT(String msg) {
  	LogRecord writtenRec = null;
		if (beFatal()) {
			writtenRec = 
				logTInt (Severity.FATAL, 
								 this, 
								 MSG_RELATIVES, 
								 MSG_SUB_LOC, 
								 msg, 
								 MsgType.PLAIN, 
								 MSG_ARGS,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  category Category of message
   * @param  msg      Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatalT(Category category,
                          String   msg) {
  	LogRecord writtenRec = null;
    if (beFatal(category)) {
      writtenRec = 
	  	logSeverityTInt (Severity.FATAL, 
			      						this, 
			      						new LogController[] {category}, 
			      						MSG_SUB_LOC, 
			      						msg, 
			      						MsgType.PLAIN, 
			      						MSG_ARGS,
                                        null,
                                        null,
                                        this.csnComponent,
                                        this.dcName);
    }
    return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  categories Categories of message
   * @param  msg        Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatalT(Category[] categories,
                          String     msg) {
  	LogRecord writtenRec = null;
		if (beFatal(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.FATAL, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String,
   *              java.lang.String)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  subloc Name of sublocation
   * @param  msg    Message text
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord fatalT(String subloc,
                          String msg) {
  	LogRecord writtenRec = null;
		if (beFatal()) {
			writtenRec = 
				logTInt (Severity.FATAL, 
								 this, 
								 MSG_RELATIVES, 
								 subloc, 
								 msg, 
								 MsgType.PLAIN, 
								 MSG_ARGS,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String,
   *              java.lang.String)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msg      Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatalT(Category category,
                          String   subloc,
                          String   msg) {
  	LogRecord writtenRec = null;
		if (beFatal(category)) {
			writtenRec = 
			logSeverityTInt (Severity.FATAL, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String,
   *              java.lang.String)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msg        Message text
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatalT(Category[] categories,
                          String     subloc,
                          String     msg) {
  	LogRecord writtenRec = null;
		if (beFatal(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.FATAL, 
												this, 
												categories, 
												subloc, 
												msg, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  msg  Message template
   * @param  args Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord fatalT(String   msg,
                          Object[] args) {
  	LogRecord writtenRec = null;
		if (beFatal()) {
			writtenRec = 
				logTInt (Severity.FATAL, 
				 				 this, 
								 MSG_RELATIVES, 
								 MSG_SUB_LOC, 
								 msg, 
								 MsgType.JAVA, 
								 args,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  category Category of message
   * @param  msg      Message template
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatalT(Category category,
                          String   msg,
                          Object[] args) {
  	LogRecord writtenRec = null;
		if (beFatal(category)) {
			writtenRec = 
			logSeverityTInt (Severity.FATAL, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  categories Categories of message
   * @param  msg        Message template
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatalT(Category[] categories,
                          String     msg,
                          Object[]   args) {
  	LogRecord writtenRec = null;
		if (beFatal(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.FATAL, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link Location#logT(int,
   *                      java.lang.String,
   *                      java.lang.String,
   *                      java.lang.Object[])}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  subloc Name of sublocation
   * @param  msg    Message template
   * @param  args   Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord fatalT(String   subloc,
                          String   msg,
                          Object[] args) {
  	LogRecord writtenRec = null;
		if (beFatal()) {
			writtenRec = 
				logTInt (Severity.FATAL, 
								 this, 
								 MSG_RELATIVES, 
								 subloc, 
								 msg, 
								 MsgType.JAVA, 
								 args,
                                 null,
                                 null,
                                 this.csnComponent,
                                 this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category,
   *              java.lang.String,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msg      Message template
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatalT(Category category,
                          String   subloc,
                          String   msg,
                          Object[] args) {
  	LogRecord writtenRec = null;
		if (beFatal(category)) {
			writtenRec = 
			logSeverityTInt (Severity.FATAL, 
												this, 
												new LogController[] {category}, 
												subloc, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #logT(int,
   *              Category[],
   *              java.lang.String,
   *              java.lang.String,
   *              java.lang.Object[])}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msg        Message template
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatalT(Category[] categories,
                          String     subloc,
                          String     msg,
                          Object[]   args) {
  	LogRecord writtenRec = null;
		if (beFatal(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.FATAL, 
												this, 
												categories, 
												subloc, 
												msg, 
												MsgType.JAVA, 
												args,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  //********************************************** 
  // 		FATAL METHODS
	//********************************************** 
  
  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @deprecated Message Code must be used together with Message Text.  
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatal(Category category,
                         Object   msgCode) {
  	LogRecord writtenRec = null;
	
		if (beFatal(category)) {
			writtenRec = 
			logSeverityInt (Severity.FATAL, 
											this, 
											new LogController[] {category}, 	
											MSG_SUB_LOC, 
											null, 
											null, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @deprecated Message Code must be used together with Message Text.  
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatal(Category[] categories,
                         Object     msgCode) {
  	LogRecord writtenRec = null;

		if (beFatal(categories)) {
			writtenRec = 
			logSeverityInt (Severity.FATAL, 
											this, categories, 	
											MSG_SUB_LOC, 
											null, 
											null, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.String,
   *             java.lang.Object)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter
   *             or issue separate calls to a Location and a Category parameter              
   */
  public LogRecord fatal(Category category,
                         String   subloc,
                         Object   msgCode) {
  	LogRecord writtenRec = null;

		if (beFatal(category)) {
			writtenRec = 
			logSeverityInt (Severity.FATAL, 
											this, 
											new LogController[] {category}, 	
											subloc, 
											null, 
											null, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.String,
   *             java.lang.Object)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatal(Category[] categories,
                         String     subloc,
                         Object     msgCode) {
  	LogRecord writtenRec = null;

		if (beFatal(categories)) {
			writtenRec = 
			logSeverityInt (Severity.FATAL, 
											this, 
											categories, 	
											subloc, 
											null, 
											null, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatal(Category category,
                         Object   msgCode,
                         Object[] args) {
		LogRecord writtenRec = null;

		if (beFatal(category)) {
			writtenRec = 
			logSeverityInt (Severity.FATAL, 
											this, 
											new LogController[] {category}, 	
											MSG_SUB_LOC, 
											null, 
											null, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
    return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatal(Category[] categories,
                         Object     msgCode,
                         Object[]   args) {
  	LogRecord writtenRec = null;

		if (beFatal(categories)) {
			writtenRec = 
			logSeverityInt (Severity.FATAL, 
											this, 
											categories, 	
											MSG_SUB_LOC, 
											null, 
											null, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatal(Category category,
                         String   subloc,
                         Object   msgCode,
                         Object[] args) {
  	LogRecord writtenRec = null;

		if (beFatal(category)) {
			writtenRec = 
			logSeverityInt (Severity.FATAL, 
											this, 
											new LogController[] {category}, 	
											subloc, 
											null, 
											null, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[])}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter
   *             or issue separate calls to a Location and a Category parameter              
   */
  public LogRecord fatal(Category[] categories,
                         String     subloc,
                         Object     msgCode,
                         Object[]   args) {
  	LogRecord writtenRec = null;

		if (beFatal(categories)) {
			writtenRec = 
			logSeverityInt (Severity.FATAL, 
											this, 
											categories, 	
											subloc, 
											null, 
											null, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatal(Category category,
                         Object   msgCode,
                         String   msgClear) {
  	LogRecord writtenRec = null;

		if (beFatal(category)) {
			writtenRec = 
			logSeverityInt (Severity.FATAL, 
											this, 
											new LogController[] {category}, 	
											MSG_SUB_LOC, 
											null, 
											msgClear, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatal(Category[] categories,
                         Object     msgCode,
                         String     msgClear) {
  	LogRecord writtenRec = null;

		if (beFatal(categories)) {
			writtenRec = 
			logSeverityInt (Severity.FATAL, 
											this, 
											categories, 	
											MSG_SUB_LOC, 
											null, 
											msgClear, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatal(Category category,
                         String   subloc,
                         Object   msgCode,
                         String   msgClear) {
  	LogRecord writtenRec = null;

		if (beFatal(category)) {
			writtenRec = 
			logSeverityInt (Severity.FATAL, 
											this, 
											new LogController[] {category}, 	
											subloc, 
											null, 
											msgClear, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.String)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatal(Category[] categories,
                         String     subloc,
                         Object     msgCode,
                         String     msgClear) {
  	LogRecord writtenRec = null;

		if (beFatal(categories)) {
			writtenRec = 
			logSeverityInt (Severity.FATAL, 
											this, 
											categories, 	
											subloc, 
											null, 
											msgClear, 
											MsgType.PLAIN, 
											MSG_ARGS,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  category Category of message
   * @param  msgCode  Resource name of message
   * @param  args     Arguments as object references
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatal(Category category,
                         Object   msgCode,
                         Object[] args,
                         String   msgClear) {
  	LogRecord writtenRec = null;

		if (beFatal(category)) {
			writtenRec = 
			logSeverityInt (Severity.FATAL, 
											this, 
											new LogController[] {category}, 	
											MSG_SUB_LOC, 
											null, 
											msgClear, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  categories Categories of message
   * @param  msgCode    Resource name of message
   * @param  args       Arguments as object references
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatal(Category[] categories,
                         Object     msgCode,
                         Object[]   args,
                         String     msgClear) {
  	LogRecord writtenRec = null;

		if (beFatal(categories)) {
			writtenRec = 
			logSeverityInt (Severity.FATAL, 
											this, 
											categories, 	
											null, 
											null, 
											msgClear, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category,
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  msgCode  Resource name of message
   * @param  args     Arguments as object references
   * @param  msgClear Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter
   */
  public LogRecord fatal(Category category,
                         String   subloc,
                         Object   msgCode,
                         Object[] args,
                         String   msgClear) {
  	LogRecord writtenRec = null;

		if (beFatal(category)) {
			writtenRec = 
			logSeverityInt (Severity.FATAL, 
											this, 
											new LogController[] {category}, 	
											subloc, 
											null, 
											msgClear, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }

  /**
   * Same as
   * {@link #log(int,
   *             Category[],
   *             java.lang.String,
   *             java.lang.Object,
   *             java.lang.Object[],
   *             java.lang.String)}
   * but always emits a fatal error message, that is a message of severity
   * {@link Severity#FATAL}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  msgCode    Resource name of message
   * @param  args       Arguments as object references
   * @param  msgClear   Clear text version of message
   * @return Log record if written via a log of this log controller or null
   * @see    #setResourceBundleName(java.lang.String)
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord fatal(Category[] categories,
                         String     subloc,
                         Object     msgCode,
                         Object[]   args,
                         String     msgClear) {
  	LogRecord writtenRec = null;

		if (beFatal(categories)) {
			writtenRec = 
			logSeverityInt (Severity.FATAL, 
											this, 
											categories, 	
											subloc, 
											null, 
											msgClear, 
											MsgType.JAVA, 
											args,
                                            null,
                                            null,
                                            this.csnComponent,
                                            this.dcName);
		} 
		return writtenRec;
  }
  
  //********************************************** 
  // ENTERING METHODS
  //**********************************************
   
  /**
   * Logs message of severity
   * {@link Severity#PATH}
   * which indicates that execution had entered this method location. This
   * method is restricted to locations standing for methods and <em>must</em> be
   * balanced with a call to the method <code>exiting</code> when leaving, for
   * example {@link #exiting(java.lang.Object)}.
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord entering() {
		LogRecord writtenRec = null;
		if (bePath()) {
			writtenRec = 
				logTInt(Severity.PATH, 
								this, 
								MSG_RELATIVES, 
								MSG_SUB_LOC, 
								MSG_ENTERING, 
								MsgType.PLAIN, 
								MSG_ARGS,
                                null,
                                null,
                                this.csnComponent,
                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Logs message of the specified category and severity
   * {@link Severity#PATH}
   * which indicates that execution had entered this method location. This
   * method is restricted to locations standing for methods and <em>must</em> be
   * balanced with a call to the method <code>exiting</code> when leaving, for
   * example {@link #exiting(java.lang.Object)}.
   * @param  category Category of message
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord entering(Category category) {
  	LogRecord writtenRec = null;
		if (bePath(category)) {
			writtenRec = 
			logSeverityTInt (Severity.PATH, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												MSG_ENTERING, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Logs message of the specified categories and severity
   * {@link Severity#PATH}
   * which indicates that execution had entered this method location. This
   * method is restricted to locations standing for methods and <em>must</em> be
   * balanced with a call to the method <code>exiting</code> when leaving, for
   * example {@link #exiting(java.lang.Object)}.
   * @param  categories Categories of message
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord entering(Category[] categories) {
  	LogRecord writtenRec = null;
		if (bePath(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.PATH, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												MSG_ENTERING, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #entering()}
   * but appends a string denoting a sublocation to the name of this location.
   * This method <em>must</em> be balanced with a call to
   * <code>exiting</code> when leaving the traced method, for example
   * {@link #exiting(java.lang.Object)}.
   * @param  subloc Name of sublocation
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord entering(String subloc) {
  	LogRecord writtenRec = null;
		if (bePath()) {
			writtenRec = 
				logTInt(Severity.PATH, 
								this, 
								MSG_RELATIVES, 
								subloc, 
								MSG_ENTERING, 
								MsgType.PLAIN, 
								MSG_ARGS,
                                null,
                                null,
                                this.csnComponent,
                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #entering(Category)}
   * but appends a string denoting a sublocation to the name of this location.
   * This method <em>must</em> be balanced with a call to
   * <code>exiting</code> when leaving the traced method, for example
   * {@link #exiting(java.lang.Object)}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord entering(Category category,
                            String   subloc) {
  	LogRecord writtenRec = null;
			if (bePath(category)) {
				writtenRec = 
				logSeverityTInt (Severity.PATH, 
													this, 
													new LogController[] {category}, 
													subloc, 
													MSG_ENTERING, 
													MsgType.PLAIN, 
													MSG_ARGS,
                                                    null,
                                                    null,
                                                    this.csnComponent,
                                                    this.dcName);
			}
			return writtenRec;
  }

  /**
   * Same as
   * {@link #entering(Category[])}
   * but appends a string denoting a sublocation to the name of this location.
   * This method <em>must</em> be balanced with a call to
   * <code>exiting</code> when leaving the traced method, for example
   * {@link #exiting(java.lang.Object)}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord entering(Category[] categories,
                            String     subloc) {
  	LogRecord writtenRec = null;
		if (bePath(categories)) {
			writtenRec = 
			logSeverityTInt (Severity.PATH, 
												this, 
												categories, 
												subloc, 
												MSG_ENTERING, 
												MsgType.PLAIN, 
												MSG_ARGS,
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  //********************************************** 
  // ENTERING METHODS WITH args
  //**********************************************
   
  private String argumentsPack (Object[] args) {
	  //Pack arguments into one message argument.
	  String argList = null;
	  if (args != null) {
		  argList = "";
		  for (int i = 0; i < args.length; ++i) {
			  if (i >= 1) {
				  argList += ", ";
			  }
			  if (args[i] != null) {
				  try {
				  	argList += args[i].toString();
				  }
				  catch(Exception ex) {
					argList += LogRecord.NULL_STRING;
				  }
			  } 
			  else {
				  argList += LogRecord.NULL_STRING;
			  }
		  }
	  }
	  return argList;	
  }
  
  /**
	 * Logs message of severity
	 * {@link Severity#PATH}
	 * which indicates that execution had entered this method location. This
	 * method is restricted to locations standing for methods and <em>must</em> be
	 * balanced with a call to the method <code>exiting</code> when leaving, for
	 * example {@link #exiting(java.lang.Object)}. The objects handed over are the
	 * (possibly wrapped) arguments to the method and are written using the method
	 * <code>toString</code>.
	 * @param  args Arguments as object references
	 * @return Log record if written via a log of this log controller or null
	 */
  
  public LogRecord entering(Object[] args) {
  	LogRecord writtenRec = null;
		if (bePath()) {
			String argList = argumentsPack(args);
			writtenRec = 
				logTInt(Severity.PATH, 
								this, 
								MSG_RELATIVES, 
								MSG_SUB_LOC, 
								MSG_ENTERING_WITH_PARS, 
								MsgType.JAVA, 
								new Object[] {argList},
                                null,
                                null,
                                this.csnComponent,
                                this.dcName);
		}	
		return writtenRec;
  }

  /**
   * Logs message of the specified category and severity
   * {@link Severity#PATH}
   * which indicates that execution had entered this method location. This
   * method is restricted to locations standing for methods and <em>must</em> be
   * balanced with a call to the method <code>exiting</code> when leaving, for
   * example {@link #exiting(java.lang.Object)}. The objects handed over are the
   * (possibly wrapped) arguments to the method and are written using the method
   * <code>toString</code>.
   * @param  category Category of message
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord entering(Category category,
                            Object[] args) {
  	LogRecord writtenRec = null;
		if (bePath(category)) {
			String argList = argumentsPack(args);
			writtenRec = 
			logSeverityTInt (Severity.PATH, 
												this, 
												new LogController[] {category}, 
												MSG_SUB_LOC, 
												MSG_ENTERING_WITH_PARS, 
												MsgType.JAVA,  
												new Object[] {argList},
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Logs message of the specified categories and severity
   * {@link Severity#PATH}
   * which indicates that execution had entered this method location. This
   * method is restricted to locations standing for methods and <em>must</em> be
   * balanced with a call to the method <code>exiting</code> when leaving, for
   * example {@link #exiting(java.lang.Object)}. The objects handed over are the
   * (possibly wrapped) arguments to the method and are written using the method
   * <code>toString</code>.
   * @param  categories Categories of message
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord entering(Category[] categories,
                            Object[]   args) {
  	LogRecord writtenRec = null;
		if (bePath(categories)) {
			String argList = argumentsPack(args);
			writtenRec = 
			logSeverityTInt (Severity.PATH, 
												this, 
												categories, 
												MSG_SUB_LOC, 
												MSG_ENTERING_WITH_PARS, 
												MsgType.JAVA,  
												new Object[] {argList},
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		} 
		return writtenRec;               
  }

  /**
   * Same as
   * {@link #entering(java.lang.Object[])}
   * but appends a string denoting a sublocation to the name of this location.
   * This method <em>must</em> be balanced with a call to
   * <code>exiting</code> when leaving the traced method, for example
   * {@link #exiting(java.lang.Object)}.
   * @param  subloc Name of sublocation
   * @param  args   Arguments as object references
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord entering(String   subloc,
                            Object[] args) {
  	LogRecord writtenRec = null;
		if (bePath()) {
			String argList = argumentsPack(args); 
			writtenRec = 
				logTInt(Severity.PATH, 
								this, 
								MSG_RELATIVES, 
								subloc, 
								MSG_ENTERING_WITH_PARS, 
								MsgType.JAVA, 
								new Object[] {argList},
                                null,
                                null,
                                this.csnComponent,
                                this.dcName);
		}
		return writtenRec;   
  }

  /**
   * Same as
   * {@link #entering(Category,
   *                  java.lang.Object[])}
   * but appends a string denoting a sublocation to the name of this location.
   * This method <em>must</em> be balanced with a call to
   * <code>exiting</code> when leaving the traced method, for example
   * {@link #exiting(java.lang.Object)}.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  args     Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord entering(Category category,
                            String   subloc,
                            Object[] args) {
  	LogRecord writtenRec = null;
		if (bePath(category)) {
			String argList = argumentsPack(args);
			writtenRec = 
			logSeverityTInt (Severity.PATH, 
												this, 
												new LogController[] {category}, 
												subloc, 
												MSG_ENTERING_WITH_PARS, 
												MsgType.JAVA, 
												new Object[] {argList},
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}
		return writtenRec;	    
  }

  /**
   * Same as
   * {@link #entering(Category[],
   *                  java.lang.Object[])}
   * but appends a string denoting a sublocation to the name of this location.
   * This method <em>must</em> be balanced with a call to
   * <code>exiting</code> when leaving the traced method, for example
   * {@link #exiting(java.lang.Object)}.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  args       Arguments as object references
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord entering(Category[] categories,
                            String     subloc,
                            Object[]   args) {                   	
  	LogRecord writtenRec = null;
		if (bePath(categories)) {
			String argList = argumentsPack(args);
			writtenRec = 
			logSeverityTInt (Severity.PATH, 
												this, 
												categories, 
												subloc, 
												MSG_ENTERING_WITH_PARS, 
												MsgType.JAVA, 
												new Object[] {argList},
                                                null,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		}  
		return writtenRec;	    
  }

	//********************************************** 
  // EXITING
  //**********************************************

  /**
   * Logs message of group severity which indicates that execution is about to
   * leave this method location. This method is to be balanced with a call to
   * the method <code>entering</code>, for example
   * {@link #entering(java.lang.String,
   *                  java.lang.Object[])}.
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord exiting() {
		LogRecord writtenRec = null;
		if (bePath()) {
			writtenRec = 
				logTInt(Severity.PATH, 
								this, 
								MSG_RELATIVES, 
								MSG_SUB_LOC, 
								MSG_EXITING, 
								MsgType.PLAIN, 
								MSG_ARGS,
                                null,
                                null,
                                this.csnComponent,
                                this.dcName);		
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #exiting()}
   * but appends a string denoting a sublocation to the name of this location.
   * @param      subloc Name of sublocation
   */
  public void exiting(String subloc) {
  	if (bePath()) {
			logTInt(Severity.PATH, 
							this, 
							MSG_RELATIVES, 
							subloc, 
							MSG_EXITING, 
							MsgType.PLAIN, 
							MSG_ARGS,
                            null,
                            null,
                            this.csnComponent,
                            this.dcName);
		}
  }

  /**
   * Logs message of group severity which indicates that execution is about to
   * leave this method location. This method is to be balanced with a call to
   * the method <code>entering</code>, for example
   * {@link #entering(java.lang.String,
   *                  java.lang.Object[])}.
   * The object handed over is the (possibly wrapped) result of the method and
   * is written using its method <code>toString</code>.
   * @param  res Result as object reference
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord exiting(Object res) {
  	LogRecord writtenRec = null;
		if (bePath()) {
			writtenRec = 
				logTInt(Severity.PATH, 
								this, 
								MSG_RELATIVES, 
								MSG_SUB_LOC, 
								MSG_EXITING_WITH_RES, 
								MsgType.JAVA, 
								new Object[] {res},
                                null,
                                null,
                                this.csnComponent,
                                this.dcName);
		}
		return writtenRec;
  }

  /**
   * Same as
   * {@link #exiting(java.lang.Object)}
   * but appends a string denoting a sublocation to the name of this location.
   * @param      subloc Name of sublocation
   * @param      res    Result as object reference
   */
  public void exiting(String subloc,
                      Object res) {
  	if (bePath()) {
			logTInt(Severity.PATH, 
							this, 
							MSG_RELATIVES, 
							subloc, 
							MSG_EXITING_WITH_RES, 
							MsgType.JAVA, 
							new Object[] {res},
                            null,
                            null,
                            this.csnComponent,
                            this.dcName);
		}
  }

	//********************************************** 
  // ASSERTION
  //********************************************** 

  /**
   * Logs message of severity
   * {@link Severity#ERROR}
   * which indicates that an assertion has failed. This method is restricted to
   * locations standing for methods.
   * @param  assertion Condition that is asserted
   * @param  desc      Text describing the assertion, often the text of the
   *                   boolean expression specified as first argument
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord assertion(boolean assertion,
                             String  desc) {
  	LogRecord writtenRec = null;
    
    if (!assertion && beError()) {
			writtenRec = logTInt(Severity.ERROR,
													 	this,
													 	MSG_RELATIVES,
													 	MSG_SUB_LOC,
														MSG_ASSERT,
														MsgType.JAVA,
														new Object[] {desc},
                                                        null,
                                                        null,
                                                        this.csnComponent,
                                                        this.dcName);
    }
    return writtenRec;
  }

  /**
   * Logs message of the specified category and severity
   * {@link Severity#ERROR}
   * which indicates that an assertion has failed. This method is restricted to
   * locations standing for methods.
   * @param  category  Category of message
   * @param  assertion Condition that is asserted
   * @param  desc      Text describing the assertion, often the text of the
   *                   boolean expression specified as first argument
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord assertion(Category category,
                             boolean  assertion,
                             String   desc) {
  	LogRecord writtenRec = null;

    if (!assertion && beError(category)) {
			writtenRec = logTInt(Severity.ERROR,
														this,
														new LogController[] {category},
														MSG_SUB_LOC,
														MSG_ASSERT,
														MsgType.JAVA,
														new Object[] {desc},
                                                        null,
                                                        null,
                                                        this.csnComponent,
                                                        this.dcName);
    }
    return writtenRec;
  }

  /**
   * Logs message of the specified categories and severity
   * {@link Severity#ERROR}
   * which indicates that an assertion has failed. This method is restricted to
   * locations standing for methods.
   * @param  categories  Categories of message
   * @param  assertion Condition that is asserted
   * @param  desc      Text describing the assertion, often the text of the
   *                   boolean expression specified as first argument
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord assertion(Category[] categories,
                             boolean    assertion,
                             String     desc) {
  	LogRecord writtenRec = null;

    if (!assertion && beError(categories)) {
			writtenRec = logTInt(Severity.ERROR,
														this,
														categories,
														MSG_SUB_LOC,
														MSG_ASSERT,
														MsgType.JAVA,
														new Object[] {desc},
                                                        null,
                                                        null,
                                                        this.csnComponent,
                                                        this.dcName);
    }
    return writtenRec;
  }

  /**
   * Same as
   * {@link #assertion(boolean,
   *                   java.lang.String)}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  subloc    Name of sublocation
   * @param  assertion Condition that is asserted
   * @param  desc      Text describing the assertion, often the text of the
   *                   boolean expression specified as second argument
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord assertion(String  subloc,
                             boolean assertion,
                             String  desc) {
  	LogRecord writtenRec = null;

    if (!assertion && beError()) {
			writtenRec = logTInt(Severity.ERROR,
														this,
														MSG_RELATIVES,
														subloc,
														MSG_ASSERT,
														MsgType.JAVA,
														new Object[] {desc},
                                                        null,
                                                        null,
                                                        this.csnComponent,
                                                        this.dcName);
    }
    return writtenRec;
  }

  /**
   * Same as
   * {@link #assertion(Category,
   *                   boolean,
   *                   java.lang.String)}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  category  Category of message
   * @param  subloc    Name of sublocation
   * @param  assertion Condition that is asserted
   * @param  desc      Text describing the assertion, often the text of the
   *                   boolean expression specified as second argument
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord assertion(Category category,
                             String   subloc,
                             boolean  assertion,
                             String   desc) {
  	LogRecord writtenRec = null;

    if (!assertion && beError(category)) {
			writtenRec = logTInt(Severity.ERROR,
														this,
														new LogController[] {category},
														subloc,
														MSG_ASSERT,
														MsgType.JAVA,
														new Object[] {desc},
                                                        null,
                                                        null,
                                                        this.csnComponent,
                                                        this.dcName);
    }
    return writtenRec;
  }

  /**
   * Same as
   * {@link #assertion(Category[],
   *                   boolean,
   *                   java.lang.String)}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  assertion  Condition that is asserted
   * @param  desc       Text describing the assertion, often the text of the
   *                    boolean expression specified as second argument
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord assertion(Category[] categories,
                             String     subloc,
                             boolean    assertion,
                             String     desc) {
  	LogRecord writtenRec = null;

    if (!assertion && beError(categories)) {
			writtenRec = logTInt(Severity.ERROR,
														this,
														categories,
														subloc,
														MSG_ASSERT,
														MsgType.JAVA,
														new Object[] {desc},
                                                        null,
                                                        null,
                                                        this.csnComponent,
                                                        this.dcName);
    }
    return writtenRec;
  }

  /**
   * Logs message of severity
   * {@link Severity#PATH}
   * which indicates that this method location is about to throw an exception.
   * This method is restricted to locations standing for methods. The exception
   * is written using its method <code>toString</code>.
   * @param  exc Exception about to be thrown
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord throwing(Throwable exc) {
  	LogRecord writtenRec = null;

    if (bePath()) {
			writtenRec = logTInt(Severity.PATH,
														this,
														MSG_RELATIVES,
														MSG_SUB_LOC,
														MSG_THROWING,
														MsgType.JAVA,
														new Object[] {exc},
                                                        null,
                                                        null,
                                                        this.csnComponent,
                                                        this.dcName);
    }
    return writtenRec;
  }

  /**
   * Logs message of the specified category and severity
   * {@link Severity#PATH}
   * which indicates that this method location is about to throw an exception.
   * This method is restricted to locations standing for methods. The exception
   * is written using its method <code>toString</code>.
   * @param  category Category of message
   * @param  exc      Exception about to be thrown
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter
   */
  public LogRecord throwing(Category category,
                            Throwable exc) {
  	LogRecord writtenRec = null;

    if (bePath(category)) {
			writtenRec = logTInt(Severity.PATH,
														this,
														new LogController[] {category},
														MSG_SUB_LOC,
														MSG_THROWING,
														MsgType.JAVA,
														new Object[] {exc},
                                                        null,
                                                        null,
                                                        this.csnComponent,
                                                        this.dcName);
    }
    return writtenRec;
  }

  /**
   * Logs message of the specified categories and severity
   * {@link Severity#PATH}
   * which indicates that this method location is about to throw an exception.
   * This method is restricted to locations standing for methods. The exception
   * is written using its method <code>toString</code>.
   * @param  categories Categories of message
   * @param  exc        Exception about to be thrown
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord throwing(Category[] categories,
                            Throwable  exc) {
  	LogRecord writtenRec = null;

    if (bePath(categories)) {
			writtenRec = logTInt(Severity.PATH,
														this,
														categories,
														MSG_SUB_LOC,
														MSG_THROWING,
														MsgType.JAVA,
														new Object[] {exc},
                                                        null,
                                                        null,
                                                        this.csnComponent,
                                                        this.dcName);
    }
    return writtenRec;
  }

  /**
   * Same as
   * {@link #throwing(java.lang.Throwable)}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  subloc Name of sublocation
   * @param  exc    Exception about to be thrown
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord throwing(String    subloc,
                            Throwable exc) {
  	LogRecord writtenRec = null;

    if (bePath()) {
			writtenRec = logTInt(Severity.PATH,
														this,
														MSG_RELATIVES,
														subloc,
														MSG_THROWING,
														MsgType.JAVA,
														new Object[] {exc},
                                                        null,
                                                        null,
                                                        this.csnComponent,
                                                        this.dcName);
    }
    return writtenRec;
  }

  /**
   * Same as
   * {@link #throwing(Category,
   *                  java.lang.Throwable)}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  exc      Exception about to be thrown
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord throwing(Category  category,
                            String    subloc,
                            Throwable exc) {
  	LogRecord writtenRec = null;

    if (bePath(category)) {
			writtenRec = logTInt(Severity.PATH,
														this,
														new LogController[] {category},
														subloc,
														MSG_THROWING,
														MsgType.JAVA,
														new Object[] {exc},
                                                        null,
                                                        null,
                                                        this.csnComponent,
                                                        this.dcName);
    }
    return writtenRec;
  }

  /**
   * Same as
   * {@link #throwing(Category[],
   *                  java.lang.Throwable)}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  exc        Exception about to be thrown
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord throwing(Category[] categories,
                            String     subloc,
                            Throwable  exc) {
  	LogRecord writtenRec = null;

    if (bePath(categories)) {
			writtenRec = logTInt(Severity.PATH,
																this,
																categories,
																subloc,
																MSG_THROWING,
																MsgType.JAVA,
																new Object[] {exc},
                                                                null,
                                                                null,
                                                                this.csnComponent,
                                                                this.dcName);
    }
    return writtenRec;
  }

  /**
   * Fills a string with the stack trace of a given exception.
   * @param  exc Exception to get trace from
   * @return Stack trace
   */
  private String getStackTrace(Throwable exc) {
    Writer      stack  = new StringWriter();
    PrintWriter writer = new PrintWriter(stack);

    exc.printStackTrace(writer);
    return stack.toString();
  }

  //********************************************** 
  // CATCHING
  //********************************************** 

  /**
   * Logs message of severity
   * {@link Severity#PATH}
   * which indicates that this method location has caught an exception.
   * This method is restricted to locations standing for methods. The exception
   * is written using its method <code>printStackTrace</code>.
   * @param  exc Exception caught
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord catching(Throwable exc) {
  	LogRecord writtenRec = null;

    if (bePath()) {
			writtenRec = logTInt(Severity.PATH,
														this,
														MSG_RELATIVES,
														MSG_SUB_LOC,
														MSG_CATCHING,
														MsgType.JAVA,
														new Object[] {getStackTrace(exc)},
                                                        null,
                                                        null,
                                                        this.csnComponent,
                                                        this.dcName);
    }
    return writtenRec;
  }

  /**
   * Logs message of the specified category and severity
   * {@link Severity#PATH}
   * which indicates that this method location has caught an exception.
   * This method is restricted to locations standing for methods. The exception
   * is written using its method <code>printStackTrace</code>.
   * @param  category Category of message
   * @param  exc      Exception caught
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord catching(Category category,
                            Throwable exc) {
  	LogRecord writtenRec = null;

    if (bePath(category)) {
			writtenRec = logTInt(Severity.PATH,
														this,
														new LogController[] {category},
														MSG_SUB_LOC,
														MSG_CATCHING,
														MsgType.JAVA,
														new Object[] {getStackTrace(exc)},
                                                        null,
                                                        null,
                                                        this.csnComponent,
                                                        this.dcName);
    }
    return writtenRec;
  }

  /**
   * Logs message of the specified categories and severity
   * {@link Severity#PATH}
   * which indicates that this method location has caught an exception.
   * This method is restricted to locations standing for methods. The exception
   * is written using its method <code>printStackTrace</code>.
   * @param  categories Categories of message
   * @param  exc        Exception caught
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord catching(Category[] categories,
                            Throwable  exc) {
  	LogRecord writtenRec = null;

    if (bePath(categories)) {
			writtenRec = logTInt(Severity.PATH,
														this,
														categories,
														MSG_SUB_LOC,
														MSG_CATCHING,
														MsgType.JAVA,
														new Object[] {getStackTrace(exc)},
                                                        null,
                                                        null,
                                                        this.csnComponent,
                                                        this.dcName);
    }
    return writtenRec;
  }

  /**
   * Same as
   * {@link #catching(java.lang.Throwable)}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  subloc Name of sublocation
   * @param  exc    Exception caught
   * @return Log record if written via a log of this log controller or null
   */
  public LogRecord catching(String    subloc,
                            Throwable exc) {
  	LogRecord writtenRec = null;

    if (bePath()) {
			writtenRec = logTInt(Severity.PATH,
														this,
														MSG_RELATIVES,
														subloc,
														MSG_CATCHING,
														MsgType.JAVA,
														new Object[] {getStackTrace(exc)},
                                                        null,
                                                        null,
                                                        this.csnComponent,
                                                        this.dcName);
    }
    return writtenRec;
  }

  /**
   * Same as
   * {@link #catching(Category,
   *                  java.lang.Throwable)}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  category Category of message
   * @param  subloc   Name of sublocation
   * @param  exc      Exception caught
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord catching(Category  category,
                            String    subloc,
                            Throwable exc) {
  	LogRecord writtenRec = null;

    if (bePath(category)) {
			writtenRec = logTInt(Severity.PATH,
														this,
														new LogController[] {category},
														subloc,
														MSG_CATCHING,
														MsgType.JAVA,
														new Object[] {getStackTrace(exc)},
                                                        null,
                                                        null,
                                                        this.csnComponent,
                                                        this.dcName);
    }
    return writtenRec;
  }

  /**
   * Same as
   * {@link #catching(Category[],
   *                  java.lang.Throwable)}
   * but appends a string denoting a sublocation to the name of this location.
   * @param  categories Categories of message
   * @param  subloc     Name of sublocation
   * @param  exc        Exception caught
   * @return Log record if written via a log of this log controller or null
   * @deprecated Logging to a Category from Location context is not proper.
   *             If you want the message to appear both in traces and logs,
   *             use Category and pass a Location parameter 
   *             or issue separate calls to a Location and a Category parameter             
   */
  public LogRecord catching(Category[] categories,
                            String     subloc,
                            Throwable  exc) {
  	LogRecord writtenRec = null;

    if (bePath(categories)) {
			writtenRec = logTInt(Severity.PATH,
														this,
														categories,
														subloc,
														MSG_CATCHING,
														MsgType.JAVA,
														new Object[] {getStackTrace(exc)},
                                                        null,
                                                        null,
                                                        this.csnComponent,
                                                        this.dcName);
    }
    return writtenRec;
  }

	//***************************************************
  //  THROWING LOG MESSAGE OBJECT
  // ***************************************************
  
  /**
	* Trace message with stack trace of given exception,
	* into this location.
	* @param  severity 	Severity of message
	* @param  msgObject	Message object
	* @param  exc 			Throwable, the superclass of all errors and exceptions 
	* @return Log record if written via a log of this log controller or null
	* @see    #setResourceBundleName(java.lang.String)
	*/
  public LogRecord traceThrowable(int 			 severity,
																	 MsgObject msgObject,
																	 Throwable exc) {

		LogRecord writtenRec = null;
	
	  if (beLogged(severity)) {		  
			writtenRec = 
				logSeverityTInt(severity, 
												this, 
												MSG_RELATIVES, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												MSG_ARGS,
												exc,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
	  } 
	  return writtenRec;
	}

  /**
	* Trace message with stack trace of given exception,
	* into this location.
	* @param  severity 	Severity of message
	* @param  subloc 		Name of sublocation
	* @param  msgObject	Message object
	* @param  exc 	 		Throwable, the superclass of all errors and exceptions 
	* @return Log record if written via a log of this log controller or null
	* @see    #setResourceBundleName(java.lang.String)
	*/
	public LogRecord traceThrowable(int 				severity,
																   String    	subloc,
																   MsgObject 	msgObject,
																   Throwable 	exc) {
	  LogRecord writtenRec = null;

	  if (beLogged(severity)) {
			writtenRec =
				logSeverityTInt(severity, 
												this, 
												MSG_RELATIVES, 
												subloc, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												MSG_ARGS,
												exc,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
	  } 
	  return writtenRec;
	}

  /**
	* Trace message with stack trace of given exception,
	* into this loaction.
	* @param  severity 	Severity of message
	* @param  msgObject	Message object
	* @param  args   		Arguments as object references
	* @param  exc 			Throwable, the superclass of all errors and exceptions 
	* @return Log record if written via a log of this log controller or null
	* @see    #setResourceBundleName(java.lang.String)
	*/
	public LogRecord traceThrowable(int 			 severity, 
																	 MsgObject msgObject,
																	 Object[]  args,
																	 Throwable exc) {
		LogRecord writtenRec = null;

	  if (beLogged(severity)) {
			writtenRec = 
				logSeverityTInt(severity, 
												this, 
												MSG_RELATIVES, 
												MSG_SUB_LOC, 
												msgObject.getMsgText(), 
												MsgType.JAVA, 
												args,
												exc,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
	  } 
	  return writtenRec;
	}

  /**
  * Trace message with stack trace of given exception,
	* into this location.
	* @param  severity 	Severity of message
	* @param  subloc 		Name of sublocation
	* @param  msgObject	Message object
	* @param  args   		Arguments as object references
	* @param  exc 			Throwable, the superclass of all errors and exceptions 
	* @return Log record if written via a log of this log controller or null
	* @see    #setResourceBundleName(java.lang.String)
	*/
	public LogRecord traceThrowable(int 			 severity,
																	 String    subloc,
																	 MsgObject msgObject,
																	 Object[]  args,
																	 Throwable exc) {
	
		LogRecord writtenRec = null;
	
		 if (beLogged(severity)) {
				writtenRec = 
					logSeverityTInt(severity, 
													this, 
													MSG_RELATIVES, 
													subloc, 
													msgObject.getMsgText(), 
													MsgType.JAVA, 
													args,
													exc,
                                                    null,
                                                    this.csnComponent,
                                                    this.dcName);
		 } 
		 return writtenRec;
	}
	  
	//***************************************************
  //  THROWING T
  // ***************************************************
	
  /**
	* Trace message with stack trace of given exception,
	* into this location.
	* @param  severity 	Severity of message
	* @param  msg    		Message template
	* @param  exc 			Throwable, the superclass of all errors and exceptions 
	* @return Log record if written via a log of this log controller or null
	* @see    #setResourceBundleName(java.lang.String)
	*/
  public LogRecord traceThrowableT(int 			 severity,
																	 String    msg,
																	 Throwable exc) {
  	LogRecord writtenRec = null;
	
	  if (beLogged(severity)) {		  
			writtenRec = 
				logSeverityTInt(severity, 
												this, 
												MSG_RELATIVES, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.JAVA, 
												MSG_ARGS,
												exc,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
	  } 
	  return writtenRec;
	}

  /**
	* Trace message with stack trace of given exception,
	* into this location.
	* @param  severity 	Severity of message
	* @param  subloc 		Name of sublocation
	* @param  msg    		Message template
	* @param  exc 	 		Throwable, the superclass of all errors and exceptions 
	* @return Log record if written via a log of this log controller or null
	* @see    #setResourceBundleName(java.lang.String)
	*/
	public LogRecord traceThrowableT(int 				severity,
																   String    	subloc,
																   String    	msg,
																   Throwable 	exc) {
		LogRecord writtenRec = null;

	  if (beLogged(severity)) {
			writtenRec =
				logSeverityTInt(severity, 
												this, 
												MSG_RELATIVES, 
												subloc, 
												msg, 
												MsgType.JAVA, 
												MSG_ARGS,
												exc,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
	  } 
	  return writtenRec;
	}

  /**
	* Trace message with stack trace of given exception,
	* into this loaction.
	* @param  severity 	Severity of message
	* @param  msg    		Message template
	* @param  args   		Arguments as object references
	* @param  exc 			Throwable, the superclass of all errors and exceptions 
	* @return Log record if written via a log of this log controller or null
	* @see    #setResourceBundleName(java.lang.String)
	*/
	public LogRecord traceThrowableT(int 			 severity, 
																	 String    msg,
																	 Object[]  args,
																	 Throwable exc) {
		LogRecord writtenRec = null;

	  if (beLogged(severity)) {
			writtenRec = 
				logSeverityTInt(severity, 
												this, 
												MSG_RELATIVES, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.JAVA, 
												args,
												exc,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
	  } 
	  return writtenRec;
	}

  /**
  * Trace message with stack trace of given exception,
	* into this location.
	* @param  severity 	Severity of message
	* @param  subloc 		Name of sublocation
	* @param  msg    		Message template
	* @param  args   		Arguments as object references
	* @param  exc 			Throwable, the superclass of all errors and exceptions 
	* @return Log record if written via a log of this log controller or null
	* @see    #setResourceBundleName(java.lang.String)
	*/
	public LogRecord traceThrowableT(int 			 severity,
																	 String    subloc,
																	 String    msg,
																	 Object[]  args,
																	 Throwable exc) {
		LogRecord writtenRec = null;
	
		 if (beLogged(severity)) {
				writtenRec = 
					logSeverityTInt(severity, 
													this, 
													MSG_RELATIVES, 
													subloc, 
													msg, 
													MsgType.JAVA, 
													args,
													exc,
                                                    null,
                                                    this.csnComponent,
                                                    this.dcName);
		 } 
		 return writtenRec;
	}
	  
	/**
	  * Trace message with stack trace of given exception,
	  * from the given category into this location.
	  * @param  severity 	Severity of message
	  * @param  cat      	Category message stems from
	  * @param  msg    		Message template
	  * @param  exc 			Throwable, the superclass of all errors and exceptions 
	  * @return Log record if written via a log of this log controller or null
	  * @see    #setResourceBundleName(java.lang.String)
	  * @deprecated Not supported. 
	  */
	public LogRecord traceThrowableT(int 			 severity,
																	 Category  cat,
																	 String    msg,
																	 Throwable exc) {
		LogRecord writtenRec = null;

		if (beLogged(severity, cat)) {		  
			writtenRec = 
				logSeverityTInt(severity, 
												this, 
												new LogController[] {cat}, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.JAVA, 
												MSG_ARGS,
												exc,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		} 
		return writtenRec;
	}

	/**
	  * Trace message with stack trace of given exception,
	  * from the given category into this location.
	  * @param  severity 	Severity of message
	  * @param  cat    		Category message stems from
	  * @param  subloc 		Name of sublocation
	  * @param  msg    		Message template
	  * @param  exc 	 		Throwable, the superclass of all errors and exceptions 
	  * @return Log record if written via a log of this log controller or null
	  * @see    #setResourceBundleName(java.lang.String)
	  * @deprecated Not supported. 
	  */
	public LogRecord traceThrowableT(int 				severity,
																	 Category 	cat,
																	 String    	subloc,
																	 String    	msg,
																	 Throwable 	exc) {
		LogRecord writtenRec = null;

		if (beLogged(severity, cat)) {
			writtenRec = 
				logSeverityTInt(severity, 
												this, 
												new LogController[] {cat}, 
												subloc, 
												msg, 
												MsgType.JAVA, 
												MSG_ARGS,
												exc,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		} 
		return writtenRec;
	}

	/**
	  * Trace message with stack trace of given exception,
	  * from the given category into this loaction.
	  * @param  severity 	Severity of message
	  * @param  cat      	Category message stems from
	  * @param  msg    		Message template
	  * @param  args   		Arguments as object references
	  * @param  exc 			Throwable, the superclass of all errors and exceptions 
	  * @return Log record if written via a log of this log controller or null
	  * @see    #setResourceBundleName(java.lang.String)
	  * @deprecated Not supported. 
	  */
	public LogRecord traceThrowableT(int 			 severity, 
																	 Category  cat,
																   String    msg,
																   Object[]  args,
																   Throwable exc) {
		LogRecord writtenRec = null;
	
		if (beLogged(severity, cat)) {
			writtenRec = 
				logSeverityTInt(severity, 
												this, 
												new LogController[] {cat}, 
												MSG_SUB_LOC, 
												msg, 
												MsgType.JAVA, 
												args,
												exc,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
		} 
		return writtenRec;
	}

	/**
	* Trace message with stack trace of given exception,
	  * from the given category into this location.
	  * @param  severity 	Severity of message
	  * @param  cat      	Category message stems from
	  * @param  subloc 		Name of sublocation
	  * @param  msg    		Message template
	  * @param  args   		Arguments as object references
	  * @param  exc 			Throwable, the superclass of all errors and exceptions 
	  * @return Log record if written via a log of this log controller or null
	  * @see    #setResourceBundleName(java.lang.String)
	  * @deprecated Not supported. 
	  */
	public LogRecord traceThrowableT(int 			 severity,
																	 Category  cat,
																	 String    subloc,
																	 String    msg,
																	 Object[]  args,
																	 Throwable exc) {
		LogRecord writtenRec = null;
	
	  if (beLogged(severity, cat)) {
			writtenRec = 
				logSeverityTInt(severity, 
												this, 
												new LogController[] {cat}, 
												subloc, 
												msg, 
												MsgType.JAVA, 
												args,
												exc,
                                                null,
                                                this.csnComponent,
                                                this.dcName);
	  } 
	  return writtenRec;
	}

  // *******************************************************

  /**
    * @deprecated Groups are not used and implementation was removed for memory usage improvement,
	*             Instead use correlation id. 
    */
  public void openGroup(int severity) {;
  }

  /**
   * @deprecated Groups are not used and implementation was removed for memory usage improvement,
   *             Instead use correlation id.
   */
  public void openGroup(int    severity,
                        String subloc) {
  }
  
  
  /**
   * @deprecated Groups are not used and implementation was removed for memory usage improvement,
   *             Instead use correlation id.
   */
  public void openGroup(int      severity,
                        Category category) {
  }

  /**
   * @deprecated Groups are not used and implementation was removed for memory usage improvement,
   *             Instead use correlation id.
   */
  public void openGroup(int       severity,
                         Category category,
                         String   subloc) {
  }
  
  /**
   * @deprecated Groups are not used and implementation was removed for memory usage improvement,
   *             Instead use correlation id.
   */
  public void openGroup(int        severity,
                        Category[] categories) {
  }

  /**
   * @deprecated Groups are not used and implementation was removed for memory usage improvement,
   *             Instead use correlation id.
   */
  public void openGroup(int   	 severity,
                     	Category[] categories,
                     	String     subloc) {
  }
	
  /**
   * Sets the minimum severity of this location with respect to a category.
   * If its current maximum severity is lower than the argument, the former is
   * set to the argument. If it is the root location, this method has the same
   * effect as a call to
   * {@link #setEffectiveSeverity(Category,
   *                              int)}.
   * @param  severity New minimum severity
   * @deprecated Relative controllers are obsolete functionality
   */
  public void setMinimumSeverity(Category relative,
                                 int      severity) {
    super.setMinimumSeverity(relative,
                             severity);
  }

  /**
   * Resets the minimum severity of this location with respect to a category.
   * If it is the root location this method has no effect, otherwise it has the
   * same effect as a call to
   * {@link #setMinimumSeverity(Category,
   *                            int)} with
   * {@link Severity#ALL}.
   * @deprecated Relative controllers are obsolete functionality 
   */
  public void setMinimumSeverity(Category relative) {
    super.setMinimumSeverity(relative);
  }

  /**
   * Sets the effective severity of this location with respect to a category.
   * If it is the root location, this method sets the effective severity to
   * its argument, otherwise it has the same effect as calls with its argument
   * to both
   * {@link #setMinimumSeverity(Category,
   *                            int)}
   * and
   * {@link #setMaximumSeverity(Category,
   *                            int)}.
   * @param  severity New effective severity
   * @deprecated Relative controllers are obsolete functionality 
   */
  public void setEffectiveSeverity(Category relative,
                                   int      severity) {
    super.setEffectiveSeverity(relative, severity);
  }

  /**
   * Resets the effective severity of this location with respect to a category.
   * If it is the root location this method has no effect, otherwise it has the
   * same effect as two calls to {@link #setMinimumSeverity(Category)} and
   * {@link #setMaximumSeverity(Category)}.
   * @deprecated Relative controllers are obsolete functionality 
   */
  public void setEffectiveSeverity(Category relative) {
    super.setEffectiveSeverity(relative);
  }

  /**
   * Sets the maximum severity of this location with respect to a category.
   * If its current minimum severity is higher than the argument, the former is
   * set to the argument. If it is the root location, this method has the same
   * effect as a call to
   * {@link #setEffectiveSeverity(Category,
   *                              int)}.
   * @param  severity New maximum severity
   * @deprecated Relative controllers are obsolete functionality 
   */
  public void setMaximumSeverity(Category relative,
                                 int      severity) {
    super.setMaximumSeverity(relative,
                             severity);
  }

  /**
   * Resets the maximum severity of this location with respect to a category.
   * If it is the root location this method has no effect, otherwise it has the
   * same effect as a call to
   * {@link #setMaximumSeverity(Category,
   *                            int)} with
   * {@link Severity#ALL}.
   * @deprecated Relative controllers are obsolete functionality 
   */
  public void setMaximumSeverity(Category relative) {
    super.setMaximumSeverity(relative);
  }
	
  protected String[] convertRelatives (LogController[] relatives) {
  	return super.convertRelatives(relatives);
  }
  
  public void setVendor(String aVendor) {
      this.vendor = aVendor + ".";
  }
  
  public String getVendor() {
      return this.vendor.substring(0, vendor.length() - 1);
  }
  
  public void setDCName(String aDCName) {
      this.dcName = aDCName;
  }
  
  public String getDCName() {
      return this.dcName;
  }
  
  public void setCSNComponent(String aCSNComponent) {
      this.csnComponent = aCSNComponent;
  }
  
  public String getCSNComponent() {
      return this.csnComponent;
  }
	
	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	//==== < private ================================== deprecated > ====
	
}
