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
 * @version      $Id: //sapmarkets/Logging/dev/src/_Logging/java/com/sap/tc/logging/PropertiesConfigurator.java#21 $
 */

import java.util.*;
import java.text.*;
import java.io.*;

/**
 * <p>
 *   Configures the Logging API according to a set of properties. A single
 *   properties configurator is set to get its properties either from a specific
 *   properties object or read it from a specific properties file. The
 *   configuration call itself does not take arguments and can therefore be
 *   automatically repeated with a desired periodicity.
 * </p>
 * <p>
 *   The syntax of keys in the properties specification follows the general
 *   syntax <i>&lt;Name&gt;</i><code>.</code><i>&lt;Attribute&gt;</i>,
 *   where <i>&lt;Name&gt;</i> is the name of a location or category, and
 *   <i>&lt;Attribute&gt;</i> is one of its attributes, for example
 *   <code>severity</code>. If you want to set the severity for a location named
 *   <code>com.sap.tc.monitoring.Node</code> to {@link Severity#INFO} you would
 *   write:
 *   <blockquote>
 *     <pre>
 *com.sap.tc.monitoring.Node.severity = INFO</pre>
 *   </blockquote>
 *   If you would like to set a relative severity, for example for trace
 *   messages regarding object management, you use a kind of array element
 *   notation with the name of the corresponding category and write:
 *   <blockquote>
 *     <pre>
 *com.sap.tc.monitoring.Node.severity[/Objects/Management] = DEBUG</pre>
 *   </blockquote>
 * </p>
 * <p>
 *   If you want to define logs for controllers or formatters for logs you
 *   often have to set additional attributes. In order to do this, you refer to
 *   these objects using <em>variables</em>. A variable uses an array element
 *   notation with the array name specifying the kind of object and the index
 *   giving the name of the variable. For example, with
 *   <blockquote>
 *     <pre>
 *log[Trace] = FileLog</pre>
 *   </blockquote>
 *   you make a new {@link FileLog} object, and assign it to a log variable
 *   named <code>Trace</code>, which you then with
 *   <blockquote>
 *     <pre>
 *log[Trace].pattern = %t/std.trc</pre>
 *   </blockquote>
 *  set the file name pattern attribute for. When you want to attach the file
 *  log to a location called <code>com.sap.tc</code> you write:
 *   <blockquote>
 *     <pre>
 *com.sap.tc.logs = + log[Trace]</pre>
 *   </blockquote>
 *   The plus sign in front of the log variable tells the configurator to
 *   attach the log <em>in addition</em> to other logs already set for the
 *   controller. If you omit it, logs already present will be discarded. Care
 *   has to be taken for if a log with the same attributes is already present
 *   it will be kept and the new log not attached. This has the advantage that
 *   periodic evaluation of, at least in part, unchanged configuration files
 *   does not lead to loss of state of the attached objects. Removing all logs
 *   is also possible using an empty log list:
 *   <blockquote>
 *     <pre>
 *com.sap.tc.logs =</pre>
 *   </blockquote>
 *   Please note that it is not sufficient to just omit the logs attribute, as
 *   the configurator leaves alone all attributes not mentioned in the
 *   properties.
 * </p>
 * <p>
 *   To illustrate the use of formatter variables we want to configure a trace
 *   formatter with a custom pattern for the file log:
 *   <blockquote>
 *     <pre>
 *formatter[Trace]         = TraceFormatter
 *formatter[Trace].pattern = %24d: %m
 *log[Trace].formatter     = formatter[Trace]</pre>
 *   </blockquote>
 * </p>
 * <p>
 *   Another typical application of log and formatter variables is to attach
 *   the same object to several other objects. For example, you first define
 *   a log variable refering to a console log, and then attach the log to
 *   several different controllers using the variable.
 * </p>
 * <p>
 *   Sometimes you do not want to use a predefined class but one of your own to
 *   make an object. In rare cases, this might be your own log or formatter
 *   class but more often it is going to be a filter class for which there are
 *   no prefabricated implementations at all. You can do this by specifying the
 *   qualified name of this custom class:
 *   <blockquote>
 *     <pre>
 *log[Trace].filters = com.sap.tc.monitoring.Filter</pre>
 *   </blockquote>
 *   However, for this to work the custom class needs to provide a no-argument
 *   constructor and either has to be installed in the class path or be part of
 *   your application. If not, the class loader to be used has to be set via the
 *   corresponding constructor, or later the call:
 *   <blockquote>
 *     <pre>
 *propertiesConfigurator.setClassLoader(classLoader)</pre>
 *   </blockquote>
 *   You can set attributes of a custom class if inherited from a predefined
 *   class. For example, you can assign a value to the inherited attribute
 *   <code>pattern</code> of a custom log class derived from {@link FileLog}.
 * </p>
 * <p>
 *   The sequence in which all the above settings occur does not matter. What is
 *   left is to tell the properties configurator where to find the properties
 *   described above. Most often, a properties file is used, and you tell the
 *   configurator so when you make it, so the call reads something like:
 *   <blockquote>
 *     <pre>
 *propertiesConfigurator = new PropertiesConfigurator(new File("logging.properties"));
 *   </blockquote>
 * </p>
 * <p>
 *   The complete syntax in case of a properties specification in a file looks
 *   like this:
 *   <blockquote>
 *     <table>
 *       <tr>
 *         <td><i>&lt;Configuration&gt;</i>    </td><td> = </td><td> </td><td><i>&lt;Entry&gt;</i>*.</td>
 *       </tr>
 *       <tr>
 *         <td><i>&lt;Entry&gt;</i>            </td><td> = </td><td> </td><td><i>&lt;Key&gt;</i> <code>'='</code> <i>&lt;Value&gt;</i></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><i>&lt;Key&gt;</i> <code>':'</code> <i>&lt;Value&gt;</i></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><i>&lt;Key&gt;</i> <i>&lt;Value&gt;</i>.</td>.
 *       </tr>
 *       <tr><td><pre> </pre></td></tr>
 *       <tr>
 *         <td><i>&lt;Key&gt;</i>              </td><td> = </td><td> </td><td>[<i>&lt;LogController&gt;</i> <code>'.'</code>] <i>&lt;LogControllerAttr&gt;</i></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><i>&lt;Log&gt;</i> [<code>'.'</code> <i>&lt;LogAttr&gt;</i>]</td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><i>&lt;Formatter&gt;</i> [<code>'.'</code> <i>&lt;FormatterAttr&gt;</i>].</td>
 *       </tr>
 *       <tr>
 *         <td><i>&lt;LogController&gt;</i>    </td><td> = </td><td> </td><td><i>&lt;Location&gt;</td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><i>&lt;Category&gt;</i>.</td>
 *       </tr>
 *       <tr>
 *         <td><i>&lt;Location&gt;</i>         </td><td> = </td><td> </td><td>[<i>&lt;Identifier&gt;</i> (<code>'.'</code> <i>&lt;Identifier&gt;</i> [<code>'('</code> <i>&lt;Types&gt;</i> <code>')'</code>])*].</td>
 *       </tr>
 *       <tr>
 *         <td><i>&lt;Types&gt;</i>            </td><td> = </td><td> </td><td>[<i>&lt;Type&gt;</i> (<code>','</code> <i>&lt;Type&gt;</i>)*].</td>
 *       </tr>
 *       <tr>
 *         <td><i>&lt;Type&gt;</i>             </td><td> = </td><td> </td><td><i>&lt;Identifier&gt;</i> (<code>'.'</code> <i>&lt;Identifier&gt;</i>)* (<code>'['</code> <code>']'</code>)*.</td>
 *       </tr>
 *       <tr>
 *         <td><i>&lt;Category&gt;</i>         </td><td> = </td><td> </td><td><code>'/'</code> [<i>&lt;Identifier&gt;</i> (<code>'/'</code> <i>&lt;Identifier&gt;</i>)*].</td>
 *       </tr>
 *       <tr>
 *         <td><i>&lt;LogControllerAttr&gt;</i></td><td> = </td><td> </td><td><code>'severity'</code> [<i>&lt;Relative&gt;</i>]</td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><code>'effSeverity'</code> [<i>&lt;Relative&gt;</i>]</td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><code>'minSeverity'</code> [<i>&lt;Relative&gt;</i>]</td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><code>'maxSeverity'</code> [<i>&lt;Relative&gt;</i>]</td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><code>'logs'</code></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><code>'localLogs'</code></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><code>'privateLogs'</code></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><code>'filters'</code></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><code>'bundleName'</code>.</td>
 *       </tr>
 *       <tr>
 *         <td><i>&lt;Relative&gt;</i>         </td><td> = </td><td> </td><td><code>'['</code> <i>&lt;LogController&gt;</i> <code>']'</code>.</td>
 *       </tr>
 *       <tr>
 *         <td><i>&lt;Log&gt;</i>              </td><td> = </td><td> </td><td><code>'log'</code> <code>'['</code> <i>&lt;Identifier&gt;</i> <code>']'</code>.</td>
 *       </tr>
 *       <tr>
 *         <td><i>&lt;LogAttr&gt;</i>          </td><td> = </td><td> </td><td><code>'severity'</code></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><code>'effSeverity'</code></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><code>'encoding'</code></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><code>'filters'</code></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><code>'formatter'</code></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><code>'desc'</code></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><code>'autoFlush'</code></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><code>'append'</code></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><code>'pattern'</code></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><code>'limit'</code></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><code>'cnt'</code>.</td>
 *       </tr>
 *       <tr>
 *         <td><i>&lt;Formatter&gt;</i>        </td><td> = </td><td> </td><td><code>'formatter'</code> <code>'['</code> <i>&lt;Identifier&gt;</i> <code>']'</code>.</td>
 *       </tr>
 *       <tr>
 *         <td><i>&lt;FormatterAttr&gt;</i>    </td><td> = </td><td> </td><td><code>'pattern'</code>.</td>
 *       </tr>
 *       <tr><td><pre> </pre></td></tr>
 *       <tr>
 *         <td><i>&lt;Value&gt;</i>            </td><td> = </td><td> </td><td><i>&lt;Severity&gt;</i></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><i>&lt;Objects&gt;</i></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><i>&lt;String&gt;</i></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><i>&lt;Boolean&gt;</i></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><i>&lt;Identifier&gt;</i>.</td>
 *       </tr>
 *       <tr>
 *         <td><i>&lt;Severity&gt;</i>         </td><td> = </td><td> </td><td nowrap>[<code>'Severity'</code> <code>'.'</code>] (<code>'NONE'</code> | <code>'FATAL'</code> |<code>'ERROR'</code> | <code>'WARNING'</code> | <code>'INFO'</code> | <code>'PATH'</code> | <code>'DEBUG'</code>)</td>
 *       </tr>
 *       <tr>
 *         <td><i>&lt;Objects&gt;</i>          </td><td> = </td><td> </td><td>[[<code>'+'</code>] <i>&lt;Object&gt;</i> (<code>','</code> <i>&lt;Object&gt;</i>)*].</td>
 *       </tr>
 *         <td><i>&lt;Object&gt;</i>           </td><td> = </td><td> </td><td><i>&lt;Class&gt;</i></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><i>&lt;Log&gt;</i></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><i>&lt;Formatter&gt;</i>.</td>
 *       </tr>
 *       <tr>
 *         <td><i>&lt;Class&gt;</i>            </td><td> = </td><td> </td><td><code>'FileLog'</code></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><code>'ConsoleLog'</code></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><code>'TraceFormatter'</code></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><code>'ListFormatter'</code></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><code>'XMLFormatter'</code></td>
 *       </tr>
 *       <tr>
 *         <td>                                </td><td>   </td><td>|</td><td><i>&lt;Identifier&gt;</i> (<code>'.'</code> <i>&lt;Identifier&gt;</i>)*.</td>
 *       </tr>
 *     </table>
 *   </blockquote>
 *   In the above grammar, the words in quotes like <code>'logs'</code> or
 *   <code>'XMLFormatter'</code> are reserved. If you want to use such a word as
 *   an identifier, for example in a custom class name, escape it with
 *   single quotes, like in:
 *      <blockquote>
 *     <pre>
 *log[Trace] = com.sap.tc.'logs'.GreatLog
 *   </blockquote>
 *   In case of a properties object, use the syntax rules of <i>&lt;Key&gt;</i>
 *   and <i>&lt;Value&gt;</i> for defining keys and values of properties,
 *   respectively.
 * </p>
 * <p>
 *   Please find fundamental information about the principles of error handling
 *   in the package description. For this class, there are two cases where the
 *   methods {@link #getException()} and {@link #throwException} are served.
 *   First, if you forgot to provide a properties object or a properties file
 *   you specified could not be found, constructors and setters leave a
 *   <code>java.lang.IllegalArgumentException</code>. Second, the method
 *   {@link #configure()} hands over the same exception with different messages
 *   if syntactical or semantical errors are discovered in a properties
 *   specification. These errors are logged in even more detail to the category
 *   <code>/System/Logging</code> which in turn writes messages to the console.
 *   So if some properties do not quite work as you expected, have a look there
 *   to find out about misspelled attribute names and the like.
 * </p>
 */
public class PropertiesConfigurator extends Configurator {
	
	//$JL-CONSOLE_LOG$ $JL-LOG_CONFIG$
  static String version = "$Id: //sapmarkets/Logging/dev/src/_Logging/java/com/sap/tc/logging/PropertiesConfigurator.java#21 $";

  protected static final String NO_PROPERTIES_EMSG       = "No properties",
                                INVALID_PROPS_FILE       = "Invalid logging properties filename: {0}, but application should still run properly",
                                SYNTAX_ERR_EMSG          = "Invalid logging configuration: syntax error: see console for details",
                                SEMANTICS_ERR_EMSG       = "Invalid logging configuration: semantics error: see console for details",
                                SYNTAX_ERR_IN_KEY_MSG    = "Invalid logging configuration: key ''{0}'': not a valid key or wrong syntax. {1}",  //optional filename as 2nd param, if file not null
                                SYNTAX_ERR_IN_VAL_MSG    = "Invalid logging configuration: value of key ''{0}'': wrong syntax or type. {1}",  //optional filename
                                UNKNOWN_CLASS_MSG        = "Invalid logging configuration: unknown class ''{0}''. {1}",
                                NO_PATTERN_MSG           = "Invalid logging configuration: no pattern defined by log[{0}]. {1}",
                                NO_LIMIT_MSG             = "Invalid logging configuration: no limit for log[{0}]. {1}",
                                NO_CNT_MSG               = "Invalid logging configuration: no count for log[{0}]. {1}",
                                UNKNOWN_FORMATTER_MSG    = "Invalid logging configuration: unknown formatter[{0}] for log[{1}]. {2}",
                                UNKNOWN_LOG_MSG          = "Invalid logging configuration: unknown log[{0}] for controller {1}. {2}";

  /**
   * Configures this properties configurator with a properties object and the
   * class loader used for this class.
   * @param  properties Properties object
   * @see    #PropertiesConfigurator(java.util.Properties,
   *                                 java.lang.ClassLoader)
   */
  public PropertiesConfigurator(Properties properties) {
    super();
    final String method = "PropertiesConfigurator(java.util.Properties)";

    if (properties != null) {
      this.properties = properties;
      this.file       = null;
    } else {
      LoggingManager.getLog().errorT(classLoc,
                                     method,
                                     "Invalid logging configuration: no properties object");
      handleException(new IllegalArgumentException(NO_PROPERTIES_EMSG));
    }
  }

  /**
   * Configures this properties configurator with a properties object and a
   * custom class loader.
   * @param  properties  Properties object
   * @param  classLoader Custom class loader
   * @see    #PropertiesConfigurator(java.util.Properties)
   */
  public PropertiesConfigurator(Properties  properties,
                                ClassLoader classLoader) {
    super(classLoader);

    final String method = "PropertiesConfigurator(java.util.Properties,"
                                               + "java.lang.ClassLoader)";

    if (properties != null) {
      this.properties = properties;
      this.file       = null;
    } else {
      LoggingManager.getLog().errorT(classLoc,
                                     method,
                                     "Invalid logging configuration: no properties object");
      handleException(new IllegalArgumentException(NO_PROPERTIES_EMSG));
    }
  }

  /**
   * Configures this properties configurator with a properties file and the
   * class loader used for this class.
   * @param  file Properties file
   * @see    #PropertiesConfigurator(java.io.File,
   *                                 java.lang.ClassLoader)
   */
  public PropertiesConfigurator(File file) {
    super();

    final String method = "PropertiesConfigurator(java.io.File)";

    if (file != null) {
      this.properties  = null;
      this.file        = file;
    } else {
      LoggingManager.getLog().errorT(classLoc,
                                     method,
                                     "Invalid logging configuration: no properties file provided");
      handleException(new IllegalArgumentException(NO_PROPERTIES_EMSG));
    }
  }

  /**
   * Configures this properties configurator with a properties file and a custom
   * class loader.
   * @param  file        Properties file
   * @param  classLoader Custom class loader
   * @see    #PropertiesConfigurator(java.io.File)
   */
  public PropertiesConfigurator(File        file,
                                ClassLoader classLoader) {
    super(classLoader);

    final String method = "PropertiesConfigurator(java.io.File,"
                                               + "java.lang.ClassLoader)";

    if (file != null) {
      this.properties  = null;
      this.file        = file;
    } else {
      LoggingManager.getLog().errorT(classLoc,
                                     method,
                                     "Invalid logging configuration: no properties file provided");
      handleException(new IllegalArgumentException(NO_PROPERTIES_EMSG));
    }
  }

  /**
   * Gets the properties object used for this configurator.
   * @return Properties object, or <code>null</code> if there is none
   * @see    #setProperties(java.util.Properties)
   */
  public Properties getProperties() {
    return properties;
  }

  /**
   * Sets the properties object used for this configurator.
   * @param  properties Properties object
   * @see    #getProperties()
   */
  public void setProperties(Properties properties) {
    final String method = "setProperties(java.util.Properties)";

    if (properties != null) {
      this.properties = properties;
      this.file       = null;
    } else {
      LoggingManager.getLog().errorT(classLoc,
                                     method,
                                     "Invalid logging configuration: no properties object");
      handleException(new IllegalArgumentException(NO_PROPERTIES_EMSG));
    }
  }

  /**
   * Gets the file used for this configurator.
   * @return File, or <code>null</code> if there is none
   * @see    #setFile(java.io.File)
   */
  public File getFile() {
    return file;
  }

  /**
   * Sets the file used for this configurator.
   * @param  file File
   * @throws IllegalArgumentException No file
   * @see    #getProperties()
   */
  public void setFile(File file) {
    final String method = "setFile(java.io.File)";

    if (file != null) {
      this.properties = null;
      this.file       = file;
    } else {
      LoggingManager.getLog().errorT(classLoc,
                                     method,
                                     "Invalid logging configuration: no properties file provided");
      handleException(new IllegalArgumentException(NO_PROPERTIES_EMSG));
    }
  }

  public void configure() {
    final String method = "configure()";

    if (   properties != null
        || file != null) {
      Properties currProperties = null;
      Iterator   iter;

      if (properties != null) {
        currProperties = properties;
      } else if (file != null) {
        currProperties = new Properties();

        // Load properties from file if it has been touched since the last
        // read via this configurator.
        try {
          //YUE: check explicitly. See next comments about 'modification' comparison
          if(!file.exists()){
            classLoc.warningT(method,
                           INVALID_PROPS_FILE,
                           new Object[] {file.getAbsoluteFile()});
            handleException(new FileNotFoundException(file.getAbsolutePath()));
            return;    //nothing to be done
          }

          //YUE: this comparison masks the error of non-existing properties file
          if (file.lastModified() > lastConfigured) {
						FileInputStream propStream = new FileInputStream(file);
						currProperties.load(propStream);
						propStream.close();
						propStream = null;
						lastConfigured = file.lastModified();
          }
        }
        catch (Exception exc) {
          handleException(exc);
        }
      }

      // Iterate over properties to pick up data. The data is accumulated in
      // provisional objects. Real objects like formatters and controllers are
      // instantiated in the second phase if their specifications are complete.
      Map formatters  = new HashMap(),
          logs        = new HashMap(),
          controllers = new TreeMap();

      iter = currProperties.entrySet().iterator();
      while (iter.hasNext()) {
        Map.Entry entry = (Map.Entry) iter.next();
        Key       key   = parseKey((String) entry.getKey());
        String    value = (String) entry.getValue();

        if (key != null) {
          if (key instanceof LogControllerKey) {
            LogControllerKey   controllerKey = (LogControllerKey) key;
            LogController      controller    = controllerKey.getController();
            LogControllerEntry accEntry;

            accEntry = (LogControllerEntry) controllers.get(controller.getName());
            if (accEntry == null) {
              accEntry = new LogControllerEntry(controller);
              controllers.put(controller.getName(),
                              accEntry);
            }

            // Store attribute.
            Attr          attr     = controllerKey.getAttr();
            LogController relative;

            switch (attr.getAttr()) {
              case PCTokenType.EFF_SEVERITY: {
                relative = ((SeverityAttr) attr).getRelative();
                if (relative == null) {
                  accEntry.setEffectiveSeverity(parseSeverity(value,
                                                              (String) entry.getKey()));
                } else {
                  accEntry.setEffectiveRelationSeverity(relative,
                                                        parseSeverity(value,
                                                                      (String) entry.getKey()));
                }
                break;
              }
              case PCTokenType.MIN_SEVERITY: {
                relative = ((SeverityAttr) attr).getRelative();
                if (relative == null) {
                  accEntry.setMinimumSeverity(parseSeverity(value,
                                                            (String) entry.getKey()));
                } else {
                  accEntry.setMinimumRelationSeverity(relative,
                                                      parseSeverity(value,
                                                                    (String) entry.getKey()));
                }
                break;
              }
              case PCTokenType.MAX_SEVERITY: {
                relative = ((SeverityAttr) attr).getRelative();
                if (relative == null) {
                  accEntry.setMaximumSeverity(parseSeverity(value,
                                                            (String) entry.getKey()));
                } else {
                  accEntry.setMaximumRelationSeverity(relative,
                                                      parseSeverity(value,
                                                                    (String) entry.getKey()));
                }
                break;
              }
              case PCTokenType.LOGS: {
                accEntry.setLogs(parseObjects(value,
                                              (String) entry.getKey()));
                break;
              }
              case PCTokenType.LOCAL_LOGS: {
                accEntry.setLocalLogs(parseObjects(value,
                                                   (String) entry.getKey()));
                break;
              }
              case PCTokenType.PRIVATE_LOGS: {
                accEntry.setPrivateLogs(parseObjects(value,
                                                     (String) entry.getKey()));
                break;
              }
              case PCTokenType.FILTERS: {
                accEntry.setFilters(parseObjects(value,
                                                 (String) entry.getKey()));
                break;
              }
              case PCTokenType.BUNDLE_NAME: {
                accEntry.setResourceBundleName(value);
                break;
              }
            }
          } else if (key instanceof LogRefKey) {
            LogRefKey logRefKey = (LogRefKey) key;
            LogEntry  accEntry;

            accEntry = (LogEntry) logs.get(logRefKey.getName());
            if (accEntry == null) {
              accEntry = new LogEntry();
              logs.put(logRefKey.getName(),
                       accEntry);
            }

            // Check whether there is an attribute and store it.
            Attr attr = logRefKey.getAttr();

            if (attr != null) {
              switch (attr.getAttr()) {
                case PCTokenType.APPEND: {
                  accEntry.setAppend(parseBoolean(value,
                                                  (String) entry.getKey()));
                  break;
                }
                case PCTokenType.AUTO_FLUSH: {
                  accEntry.setAutoFlush(parseBoolean(value,
                                                     (String) entry.getKey()));
                  break;
                }
                case PCTokenType.EFF_SEVERITY: {
                  accEntry.setEffectiveSeverity(parseSeverity(value,
                                                              (String) entry.getKey()));
                  break;
                }
                case PCTokenType.ENCODING: {
                  accEntry.setEncoding(value);
                  break;
                }
                //YUE: additional attr 'desc' for Log
                case PCTokenType.DESCRIPTION: {
                  accEntry.setDesc(value);
                  break;
                }
                case PCTokenType.FILTERS: {
                  accEntry.setFilters(parseObjects(value,
                                                   (String) entry.getKey()));
                  break;
                }
                case PCTokenType.FORMATTER: {
                  accEntry.setFormatter(parseObjects(value,
                                                     (String) entry.getKey()));
                  break;
                }
                case PCTokenType.PATTERN: {
                  accEntry.setPattern(value);
                  break;
                }
                case PCTokenType.LIMIT: {
                  try {
                    accEntry.setLimit(Integer.parseInt(value));
                  }
                  catch (NumberFormatException e) {
                    // Syntax error: wrong number format
                    LoggingManager.getLog().errorT(classLoc,
                                                   method,
                                                   SYNTAX_ERR_IN_VAL_MSG,
                                                   new Object[] {(String) entry.getKey(),
                                                                  file==null?"":file.getAbsolutePath()});
                    handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
                  }
                  break;
                }
                case PCTokenType.CNT: {
                  try {
                    accEntry.setCnt(Integer.parseInt(value));
                  }
                  catch (NumberFormatException e) {
                    // Syntax error: wrong number format
                    LoggingManager.getLog().errorT(classLoc,
                                                   method,
                                                   SYNTAX_ERR_IN_VAL_MSG,
                                                   new Object[] {(String) entry.getKey(),
                                                                  file==null?"":file.getAbsolutePath()});
                    handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
                  }
                  break;
                }
              }
            } else {
              accEntry.setObject(parseObjects(value,
                                              (String) entry.getKey()));
            }
          } else if (key instanceof FormatterRefKey) {
            FormatterRefKey formatterRefKey = (FormatterRefKey) key;
            FormatterEntry  accEntry;

            accEntry = (FormatterEntry) formatters.get(formatterRefKey.getName());
            if (accEntry == null) {
              accEntry = new FormatterEntry();
              formatters.put(formatterRefKey.getName(),
                             accEntry);
            }

            // Check whether there is an attribute and store it.
            Attr attr = formatterRefKey.getAttr();

            if (attr != null) {
              switch (attr.getAttr()) {
                case PCTokenType.PATTERN: {
                  accEntry.setPattern(value);
                  break;
                }
              }
            } else {
              accEntry.setObject(parseObjects(value,
                                              (String) entry.getKey()));
            }
          }
        } else {
          // Ignore entry with incorrect key syntax: nothing to be done.
        }
      }

      // Instantiate objects to completed specifications, in the order of
      // possible referencing.

      // First handle formatters.
      iter = formatters.values().iterator();
      while (iter.hasNext()) {
        FormatterEntry entry  = (FormatterEntry) iter.next();

        if (entry.getObject() != null) {
          ObjectVal object = (ObjectVal) entry.getObject().getObjects().iterator().next();

          if (object instanceof ClassVal) {
            ClassVal cl = (ClassVal) object;

            switch (cl.getType()) {
              case PCTokenType.TRACE_FORMATTER: {
                if (entry.getPattern() != null) {
                  entry.setFormatter(new TraceFormatter(entry.getPattern()));
                } else {
                  entry.setFormatter(new TraceFormatter());
                }
                break;
              }
              case PCTokenType.LIST_FORMATTER: {
                entry.setFormatter(new ListFormatter());
                break;
              }
              case PCTokenType.XML_FORMATTER: {
                entry.setFormatter(new XMLFormatter());
                break;
              }
              case TokenType.IDENT: {
                try {
                  Formatter formatter = (Formatter) getClassLoader().loadClass(((CustomClassVal) cl).getIdent()).newInstance();

                  entry.setFormatter(formatter);
                  if (formatter instanceof TraceFormatter) {
                    ((TraceFormatter) formatter).setPattern(entry.getPattern());
                  }
                }
                catch (Exception e) {
                  // Semantics error: wrong class specification
                  LoggingManager.getLog().errorT(classLoc,
                                                 method,
                                                 UNKNOWN_CLASS_MSG,
                                                 new Object[] {((CustomClassVal) cl).getIdent(),
                                                               file==null?"":file.getAbsolutePath()});
                  handleException(new IllegalArgumentException(SEMANTICS_ERR_EMSG));
                }
                break;
              }
              default: {
                // Specification of formatter incorrect: drop it.
                iter.remove();
                break;
              }
            }
          } else {
            // Specification of formatter incorrect: drop it.
            iter.remove();
          }
        } else {
          // Specification of formatter incomplete: drop it.
          iter.remove();
        }
      }

      // Then handle logs which might refer to formatters.
      iter = logs.entrySet().iterator();
      while (iter.hasNext()) {
        Map.Entry mapEntry = (Map.Entry) iter.next();
        String    name     = (String) (mapEntry).getKey();
        LogEntry  entry    = (LogEntry) (mapEntry).getValue();
        Log       log      = null;

        if (entry.getObject() != null) {
          ObjectVal object  = (ObjectVal) entry.getObject().getObjects().iterator().next();

          if (object instanceof ClassVal) {
            ClassVal cl = (ClassVal) object;

            switch (cl.getType()) {
              case PCTokenType.FILE_LOG: {
                if (entry.getPattern() != null) {
                  int limit = FileLog.NO_LIMIT,
                      cnt   = FileLog.NO_CNT;

                  if (   entry.getLimit() > FileLog.NO_LIMIT
                      && entry.getCnt() > FileLog.NO_CNT) {
                    limit = entry.getLimit();
                    cnt = entry.getCnt();
                  } else {
                    if (entry.getLimit() > FileLog.NO_LIMIT) {
                      LoggingManager.getLog().errorT(classLoc,
                                                     method,
                                                     NO_CNT_MSG,
                                                     new Object[] {name,
                                                                   file==null?"":file.getAbsolutePath()});
                      handleException(new IllegalArgumentException(SEMANTICS_ERR_EMSG));
                    }
                    if (entry.getCnt() > FileLog.NO_CNT) {
                      LoggingManager.getLog().errorT(classLoc,
                                                     method,
                                                     NO_LIMIT_MSG,
                                                     new Object[] {name,
                                                                   file==null?"":file.getAbsolutePath()});
                      handleException(new IllegalArgumentException(SEMANTICS_ERR_EMSG));
                    }
                  }
                  log = new FileLog(entry.getPattern(),
                                    limit,
                                    cnt);

                  if (entry.getAppend() != null) {
                    ((FileLog) log).setAppend(entry.getAppend().getBoolean());
                  }
                } else {
                  // Semantics error: incomplete log specification
                  iter.remove();
                  LoggingManager.getLog().errorT(classLoc,
                                                 method,
                                                 NO_PATTERN_MSG,
                                                 new Object[] {name,
                                                               file==null?"":file.getAbsolutePath()});
                  handleException(new IllegalArgumentException(SEMANTICS_ERR_EMSG));
                }
                break;
              }
              case PCTokenType.CONSOLE_LOG: {
                log = new ConsoleLog();
                break;
              }
              case TokenType.IDENT: {
                try {
                  log = (Log) getClassLoader().loadClass(((CustomClassVal) cl).getIdent()).newInstance();

                  if (log instanceof FileLog) {
                    FileLog fileLog = (FileLog) log;

                    if (entry.getPattern() != null) {
                      fileLog.setPattern(entry.getPattern());
                    }

                    if (   entry.getLimit() > FileLog.NO_LIMIT
                        && entry.getCnt() > FileLog.NO_CNT) {
                      fileLog.setRotation(entry.getLimit(),
                                          entry.getCnt());
                    } else {
                      if (entry.getLimit() > FileLog.NO_LIMIT) {
                        LoggingManager.getLog().errorT(classLoc,
                                                       method,
                                                       NO_CNT_MSG,
                                                       new Object[] {name,
                                                                     file==null?"":file.getAbsolutePath()});
                        handleException(new IllegalArgumentException(SEMANTICS_ERR_EMSG));
                      }
                      if (entry.getCnt() > FileLog.NO_CNT) {
                        LoggingManager.getLog().errorT(classLoc,
                                                       method,
                                                       NO_LIMIT_MSG,
                                                       new Object[] {name,
                                                                     file==null?"":file.getAbsolutePath()});
                        handleException(new IllegalArgumentException(SEMANTICS_ERR_EMSG));
                      }
                    }

                    if (entry.getAppend() != null) {
                      fileLog.setAppend(entry.getAppend().getBoolean());
                    }
                  }
                }
                catch (Exception e) {
                  // Semantics error: wrong class specification
                  LoggingManager.getLog().errorT(classLoc,
                                                 method,
                                                 UNKNOWN_CLASS_MSG,
                                                 new Object[] {((CustomClassVal) cl).getIdent(),
                                                               file==null?"":file.getAbsolutePath()});
                  handleException(new IllegalArgumentException(SEMANTICS_ERR_EMSG));
                }
                break;
              }
              default: {
                // Specification of log incomplete: drop it.
                iter.remove();
                break;
              }
            }
          } else {
            // Specification of formatter incorrect: drop it.
            iter.remove();
          }

          if (log != null) {
            if (entry.getEffectiveSeverity() != null) {
              log.setEffectiveSeverity(entry.getEffectiveSeverity().getSeverity());
            }

            if (entry.getEncoding() != null) {
              log.setEncoding(entry.getEncoding());
            }

            //YUE: additional attr 'desc' for Log
            if (entry.getDesc() != null) {
              log.setName(entry.getDesc());
            }

            if (entry.getFilters() != null) {
              if (!entry.getFilters().isAdding()) {
                log.removeFilters();
              }

              Iterator filterIter = entry.getFilters().getObjects().iterator();

              while (filterIter.hasNext()) {
                object = (ObjectVal) filterIter.next();

                if (object instanceof ClassVal) {
                  ClassVal filter = (ClassVal) object;

                  if (filter.getType() == TokenType.IDENT) {
                    try {
                      log.addFilter((Filter) getClassLoader().loadClass(((CustomClassVal) filter).getIdent()).newInstance());
                    }
                    catch (Exception e) {
                      // Semantics error: wrong class specification
                      LoggingManager.getLog().errorT(classLoc,
                                                     method,
                                                     UNKNOWN_CLASS_MSG,
                                                     new Object[] {((CustomClassVal) filter).getIdent(),
                                                                   file==null?"":file.getAbsolutePath()});
                      handleException(new IllegalArgumentException(SEMANTICS_ERR_EMSG));
                    }
                  }
                }
              }
            }

            if (entry.getFormatter() != null) {
              Iterator formatterIter = entry.getFormatter().getObjects().iterator();

              if (formatterIter.hasNext()) {
                object = (ObjectVal) formatterIter.next();

                if (object instanceof ClassVal) {
                  ClassVal formatter = (ClassVal) object;

                  switch (formatter.getType()) {
                    case PCTokenType.TRACE_FORMATTER: {
                      log.setFormatter(new TraceFormatter());
                      break;
                    }
                    case PCTokenType.LIST_FORMATTER: {
                      log.setFormatter(new ListFormatter());
                      break;
                    }
                    case PCTokenType.XML_FORMATTER: {
                      log.setFormatter(new XMLFormatter());
                      break;
                    }
                    case TokenType.IDENT: {
                      try {
                        log.setFormatter((Formatter) getClassLoader().loadClass(((CustomClassVal) formatter).getIdent()).newInstance());
                      }
                      catch (Exception e) {
                        // Semantics error: wrong class specification
                        LoggingManager.getLog().errorT(classLoc,
                                                       method,
                                                       UNKNOWN_CLASS_MSG,
                                                       new Object[] {((CustomClassVal) formatter).getIdent(),
                                                                     file==null?"":file.getAbsolutePath()});
                        handleException(new IllegalArgumentException(SEMANTICS_ERR_EMSG));
                      }
                      break;
                    }
                  }
                } else if (object instanceof FormatterRefVal) {
                  FormatterRefVal ref = (FormatterRefVal) object;

                  try {
                    log.setFormatter(((FormatterEntry) formatters.get(ref.getName())).getFormatter());
                  }
                  catch (NullPointerException e) {
                    // Semantics error: unknown formatter reference
                    LoggingManager.getLog().errorT(classLoc,
                                                   method,
                                                   UNKNOWN_FORMATTER_MSG,
                                                   new Object[] {ref.getName(),
                                                                 name,
                                                                 file==null?"":file.getAbsolutePath()});
                    handleException(new IllegalArgumentException(SEMANTICS_ERR_EMSG));
                  }
                } else {
                  // Specification of formatter incorrect: nothing to be done.
                }
              }
            }

            if (entry.getAutoFlush() != null) {
              log.setAutoFlush(entry.getAutoFlush().getBoolean());
            }


            entry.setLog(log);
          }
        }
      }

      // Finally handle controllers which might refer to logs.
      iter = controllers.values().iterator();
      while (iter.hasNext()) {
        LogControllerEntry entry      = (LogControllerEntry) iter.next();
        LogController      controller = entry.getController();

        if (entry.getEffectiveSeverity() != null) {
          controller.setEffectiveSeverity(entry.getEffectiveSeverity().getSeverity());
        }
        if (entry.getMinimumSeverity() != null) {
          controller.setMinimumSeverity(entry.getMinimumSeverity().getSeverity());
        }

        if (entry.getMaximumSeverity() != null) {
          controller.setMaximumSeverity(entry.getMaximumSeverity().getSeverity());
        }

        Iterator severitiesIter;

        severitiesIter = entry.getEffectiveRelationSeverities().entrySet().iterator();
        while (severitiesIter.hasNext()) {
          Map.Entry severity = (Map.Entry) severitiesIter.next();

          controller.setEffectiveSeverity((LogController) severity.getKey(),
                                          ((SeverityVal) severity.getValue()).getSeverity());
        }

        severitiesIter = entry.getMinimumRelationSeverities().entrySet().iterator();
        while (severitiesIter.hasNext()) {
          Map.Entry severity = (Map.Entry) severitiesIter.next();

          controller.setMinimumSeverity((LogController) severity.getKey(),
                                        ((SeverityVal) severity.getValue()).getSeverity());
        }

        severitiesIter = entry.getMaximumRelationSeverities().entrySet().iterator();
        while (severitiesIter.hasNext()) {
          Map.Entry severity = (Map.Entry) severitiesIter.next();

          controller.setMaximumSeverity((LogController) severity.getKey(),
                                        ((SeverityVal) severity.getValue()).getSeverity());
        }

        ObjectsVal objects;

        objects = entry.getLogs();
        if (objects != null) {
          LinkedList newLogs = computeLogs(NORMAL_LOGS,
                                           objects,
                                           controller,
                                           logs);

          // Attach the logs from the new collection, swapped for existing logs,
          // to the controller.
          Iterator newLogsIter = newLogs.iterator();

          while (newLogsIter.hasNext()) {
            controller.addLog((Log) newLogsIter.next());
          }
        }

        objects = entry.getLocalLogs();
        if (objects != null) {
          LinkedList newLogs = computeLogs(LOCAL_LOGS,
                                           objects,
                                           controller,
                                           logs);

          // Attach the local logs from the new collection, swapped for existing
          // logs, to the controller.
          Iterator newLogsIter = newLogs.iterator();

          while (newLogsIter.hasNext()) {
            controller.addLocalLog((Log) newLogsIter.next());
          }
        }

        objects = entry.getPrivateLogs();
        if (objects != null) {
          LinkedList newLogs = computeLogs(PRIVATE_LOGS,
                                           objects,
                                           controller,
                                           logs);

          // Attach the private logs from the new collection, swapped for
          // existing logs, to the controller.
          Iterator newLogsIter = newLogs.iterator();

          while (newLogsIter.hasNext()) {
            controller.addPrivateLog((Log) newLogsIter.next());
          }
        }

        if (entry.getFilters() != null) {
          if (!entry.getFilters().isAdding()) {
            controller.removeFilters();
          }

          Iterator filterIter = entry.getFilters().getObjects().iterator();

          while (filterIter.hasNext()) {
            ObjectVal object = (ObjectVal) filterIter.next();

            if (object instanceof ClassVal) {
              ClassVal filter = (ClassVal) object;

              if (filter.getType() == TokenType.IDENT) {
                  try {
                    controller.addFilter((Filter) getClassLoader().loadClass(((CustomClassVal) filter).getIdent()).newInstance());
                  }
                  catch (Exception e) {
                    // Semantics error: wrong class specification
                    LoggingManager.getLog().errorT(classLoc,
                                                   method,
                                                   UNKNOWN_CLASS_MSG,
                                                   new Object[] {((CustomClassVal) filter).getIdent(),
                                                                 file==null?"":file.getAbsolutePath()});
                    handleException(new IllegalArgumentException(SEMANTICS_ERR_EMSG));
                  }
              }
            }
          }
        }

        if (entry.getResourceBundleName() != null) {
          controller.setResourceBundleName(entry.getResourceBundleName());
        }
        controller.setCopyToSubtree(true);
      }
    } else {
      // Nothing to be done.
    }
  }

  //YUE: initialize configuration setting, mainly for reader
  /**
   * To initialize configuration setting defined by user in the settings of the
   * configurator. This is called and executed once and this method throws
   * exception.
   * Corresponding events will be fired after the configuration.
   * For logging instrumentation, it is recommended to use {@link #configure()}
   * that is bundled with periodic feature.
   * @throws IllegalArgumentException Null properties content
   * @throws FileNotFoundException Properties file(if specified) cannot be located
   * @throws IOException Problems reading properties file content
   */
  public void initConfigure()
                    throws  IllegalArgumentException,
                            FileNotFoundException,
                            IOException,
                            Exception{
    if ((this.file == null) && (this.properties == null))
      throw (new IllegalArgumentException(NO_PROPERTIES_EMSG));

    Exception oldExc = getException(),
              exc;

    this.configure();
    exc = this.getException();
    if (   exc != null
        && exc != oldExc){
      if (exc instanceof FileNotFoundException)
        throw (FileNotFoundException)exc;
      if (exc instanceof IOException)
        throw (IOException)exc;
      else
        throw exc;
    }
  }

  private LinkedList computeLogs(int           type,
                                 ObjectsVal    objects,
                                 LogController controller,
                                 Map       logs) {
    final String method = "computeLogs(int,"
                                    + "ObjectsVal,"
                                    + "LogController,"
                                    + "java.util.HashMap)";

    // To avoid forgetting the current state of logs, for example the current
    // file of a rotating file set or whether a header has been written, logs
    // are kept if attached to the controller, according to the result of the
    // method equals. The procecure is as follows. First we make all the logs
    // described via the configuration properties and put them into a new
    // collection. Afterwards, we iterate through the logs attached to the
    // controller. If a log is not found in the new collection and the adding
    // flag is not set, it is removed. Otherwise, it is removed from the new
    // collection instead. The first time, the log attached to the controller is
    // added to the new collection. This is done in order to, for example,
    // switch normals logs to local logs.
    Iterator   logsIter = objects.getObjects().iterator();
    LinkedList newLogs  = new LinkedList();

    while (logsIter.hasNext()) {
      ObjectVal object = (ObjectVal) logsIter.next();

      if (object instanceof ClassVal) {
        ClassVal log = (ClassVal) object;

        switch (log.getType()) {
          case PCTokenType.CONSOLE_LOG: {
            newLogs.add(new ConsoleLog());
            break;
          }
          case TokenType.IDENT: {
            try {
              newLogs.add(getClassLoader().loadClass(((CustomClassVal) log).getIdent()).newInstance());
            }
            catch (Exception e) {
              // Semantics error: wrong class specification
              LoggingManager.getLog().errorT(classLoc,
                                             method,
                                             UNKNOWN_CLASS_MSG,
                                             new Object[] {((CustomClassVal) log).getIdent(),
                                                           file==null?"":file.getAbsolutePath()});
              handleException(new IllegalArgumentException(SEMANTICS_ERR_EMSG));
            }
            break;
          }
        }
      } else if (object instanceof LogRefVal) {
        LogRefVal ref = (LogRefVal) object;

        // Add complete log entry to keep explicit log attributes available
        // for copying to existing log.
        Object entry = logs.get(ref.getName());

        if (entry != null) {
          newLogs.add(entry);
        } else {
          // Semantics error: unknown log reference
          LoggingManager.getLog().errorT(classLoc,
                                         method,
                                         UNKNOWN_LOG_MSG,
                                         new Object[] {ref.getName(),
                                                       controller.getName(),
                                                       file==null?"":file.getAbsolutePath()});
          handleException(new IllegalArgumentException(SEMANTICS_ERR_EMSG));
        }
      } else {
        // Specification of log incorrect, nothing to be done.
      }
    }

    // Remove superfluous logs.
    for (int curr = NORMAL_LOGS;
             curr < NO_LOGS;
             ++curr) {
      Iterator prevLogsIter;

      switch (curr) {
        case NORMAL_LOGS: {
          prevLogsIter = controller.getLogs().iterator();
          break;
        }
        case LOCAL_LOGS: {
          prevLogsIter = controller.getLocalLogs().iterator();
          break;
        }
        case PRIVATE_LOGS: {
          prevLogsIter = controller.getPrivateLogs().iterator();
          break;
        }
        default: {
          prevLogsIter = null;
          break;
        }
      }

      while (prevLogsIter.hasNext()) {
        Log     log   = (Log) prevLogsIter.next();
        boolean found = false;

        // Look for identical log in new logs.
        ListIterator newLogsIter = newLogs.listIterator();

        while (newLogsIter.hasNext()) {
          Object nextLog = newLogsIter.next();

          if (nextLog instanceof Log) {
            if (log.equals((Log) nextLog)) {
              found = true;
              newLogsIter.remove();
            }
          } else { // if nextLog instanceof LogEntry
            LogEntry newLogEntry = (LogEntry) nextLog;
            Log      newLog      = newLogEntry.getLog();

            if (log.equals(newLog)) {
              found = true;
              newLogsIter.remove();

              // Copy attributes from new log.
              if (newLogEntry.getEffectiveSeverity() != null) {
                log.setEffectiveSeverity(newLogEntry.getEffectiveSeverity().getSeverity());
              }

              if (newLogEntry.getEncoding() != null) {
                log.setEncoding(newLog.getEncoding());
              }

              //YUE: additional attr 'desc' for Log
              if (newLogEntry.getDesc() != null) {
                log.setName(newLog.getName());
              }

              if (newLogEntry.getFilters() != null) {
                Iterator filterIter = newLog.getFilters().iterator();

                log.removeFilters();
                while (filterIter.hasNext()) {
                  log.addFilter((Filter) filterIter.next());
                }
              }

              if (newLogEntry.getFormatter() != null) {
                log.setFormatter(newLog.getFormatter());
              }

              // Copy log attributes from new log.
              if (newLogEntry.getAutoFlush() != null) {
                log.setAutoFlush(newLog.isAutoFlush());
              }

              // Copy file log attributes from new log if applicable.
              if (log instanceof FileLog) {
                if (   newLogEntry.isLimitSet()
                    || newLogEntry.isCntSet()) {
                  ((FileLog) log).setRotation(((FileLog) newLog).getLimit(),
                                              ((FileLog) newLog).getCnt());
                }

                if (newLogEntry.getAppend() != null) {
                  ((FileLog) log).setAppend(newLogEntry.getAppend().getBoolean());
                }
              }
            }
          }
        }
        if (found) {
          // Reattach log to move it from current to new visibility.
          newLogs.add(log);
        } else {
          // Forget log if it is of the type of the property, and the latter
          // does not specify adding.
          if (   curr == type
              && !objects.isAdding()) {
            controller.removeLog(log);
          }
        }
      }
    }

    // Cast new logs from LogEntry to Log.
    ListIterator newLogsIter = newLogs.listIterator();

    while (newLogsIter.hasNext()) {
      Object newLog = newLogsIter.next();

      if (newLog instanceof LogEntry) {
        newLogsIter.remove();
        newLogsIter.add(((LogEntry) newLog).getLog());
      }
    }

    return newLogs;
  }

  static class PCTokenType extends TokenType {

    public static final int APPEND          = TokenType.MAX + 1,
                            AUTO_FLUSH      = APPEND + 1,
                            BUNDLE_NAME     = AUTO_FLUSH + 1,
                            CNT             = BUNDLE_NAME + 1,
                            CONSOLE_LOG     = CNT + 1,
                            DESCRIPTION     = CONSOLE_LOG + 1,
                            EFF_SEVERITY    = DESCRIPTION + 1,
                            ENCODING        = EFF_SEVERITY + 1,
                            FALSE           = ENCODING + 1,
                            FILE_LOG        = FALSE + 1,
                            FILTERS         = FILE_LOG + 1,
                            FORMATTER       = FILTERS + 1,
                            LIMIT           = FORMATTER + 1,
                            LIST_FORMATTER  = LIMIT + 1,
                            LOCAL_LOGS      = LIST_FORMATTER + 1,
                            LOG             = LOCAL_LOGS + 1,
                            LOGS            = LOG + 1,
                            MAX_SEVERITY    = LOGS + 1,
                            MIN_SEVERITY    = MAX_SEVERITY + 1,
                            PATTERN         = MIN_SEVERITY + 1,
                            PLUS            = PATTERN + 1,
                            PRIVATE_LOGS    = PLUS + 1,
                            SEVERITY        = PRIVATE_LOGS + 1,
                            TRACE_FORMATTER = SEVERITY + 1,
                            TRUE            = TRACE_FORMATTER + 1,
                            XML_FORMATTER   = TRUE + 1;
    public static final int MAX             = XML_FORMATTER;

  }

  static class PCTokenizer extends Tokenizer {

    public PCTokenizer(String name) {
      super(name);
    }

    public Token nextTokenInt() {
      Token token   = super.nextTokenInt();
      int   type    = token.getType();

      if (type != PCTokenType.UNKNOWN) {
        if (type == PCTokenType.IDENT) {
          String val = token.getValue();

          if (val.equals("append")) {
            return new Token(PCTokenType.APPEND,
                             val);
          } else if (val.equals("autoFlush")) {
            return new Token(PCTokenType.AUTO_FLUSH,
                             val);
          } else if (val.equals("bundleName")) {
            return new Token(PCTokenType.BUNDLE_NAME,
                             val);
          } else if (val.equals("cnt")) {
            return new Token(PCTokenType.CNT,
                             val);
          } else if (val.equals("ConsoleLog")) {
            return new Token(PCTokenType.CONSOLE_LOG,
                             val);
          } else if (   val.equals("severity")
                     || val.equals("effSeverity")) {
            return new Token(PCTokenType.EFF_SEVERITY,
                             val);
          } else if (val.equals("encoding")) {
            return new Token(PCTokenType.ENCODING,
                             val);
          } else if (val.equals("desc")) {  //YUE: additional attr 'desc' for Log
            return new Token(PCTokenType.DESCRIPTION,
                             val);
          } else if (val.equals("false")) {
            return new Token(PCTokenType.FALSE,
                             val);
          } else if (val.equals("FileLog")) {
            return new Token(PCTokenType.FILE_LOG,
                             val);
          } else if (val.equals("filters")) {
            return new Token(PCTokenType.FILTERS,
                             val);
          } else if (val.equals("formatter")) {
            return new Token(PCTokenType.FORMATTER,
                             val);
          } else if (val.equals("limit")) {
            return new Token(PCTokenType.LIMIT,
                             val);
          } else if (val.equals("ListFormatter")) {
            return new Token(PCTokenType.LIST_FORMATTER,
                             val);
          } else if (val.equals("localLogs")) {
            return new Token(PCTokenType.LOCAL_LOGS,
                             val);
          } else if (val.equals("log")) {
            return new Token(PCTokenType.LOG,
                             val);
          } else if (val.equals("logs")) {
            return new Token(PCTokenType.LOGS,
                             val);
          } else if (val.equals("maxSeverity")) {
            return new Token(PCTokenType.MAX_SEVERITY,
                             val);
          } else if (val.equals("minSeverity")) {
            return new Token(PCTokenType.MIN_SEVERITY,
                             val);
          } else if (val.equals("pattern")) {
            return new Token(PCTokenType.PATTERN,
                             val);
          } else if (val.equals("privateLogs")) {
            return new Token(PCTokenType.PRIVATE_LOGS,
                             val);
          } else if (val.equals("Severity")) {
            return new Token(PCTokenType.SEVERITY,
                             val);
          } else if (val.equals("TraceFormatter")) {
            return new Token(PCTokenType.TRACE_FORMATTER,
                             val);
          } else if (val.equals("true")) {
            return new Token(PCTokenType.TRUE,
                             val);
          } else if (val.equals("XMLFormatter")) {
            return new Token(PCTokenType.XML_FORMATTER,
                             val);
          } else {
            return token;
          }
        } else {
          return token;
        }
      } else {
        char val = token.getValue().charAt(0);

        switch (val) {
          case ',': {
            return new Token(PCTokenType.COMMA,
                             ",");
          }
          case '+': {
            return new Token(PCTokenType.PLUS,
                             "+");
          }
          default: {
            return token;
          }
        }
      }
    }

  }

  protected Key parseKey(String key) {
    final String method = "parseKey(java.lang.String)";

		PCTokenizer tokenizer = new PCTokenizer(key);

    switch (tokenizer.getLookahead().getType()) {
      case TokenType.IDENT:
      case TokenType.UNPARSED:
      case TokenType.DOT:
      case TokenType.SLASH: {
        // Look for dot in front of attribute. This is done in order to not make
        // attribute names reserved but available for as package or category
        // names.
        ReverseTokenizer reverseTokenizer = new ReverseTokenizer(tokenizer);
        Token            token            = reverseTokenizer.nextToken();

        if (token.getType() == TokenType.RIGHT_BRACKET) {
          // Look for matching left bracket and nothing else in order to ignore
          // concrete log controller name syntax.
          int level = 1;

          while (level > 0) {
            token = reverseTokenizer.nextToken();
            if (token.getType() == TokenType.LEFT_BRACKET) {
              --level;
            } else if (token.getType() == TokenType.RIGHT_BRACKET) {
              ++level;
            } else if (token.getType() == TokenType.NONE) {
              // Syntax error: nothing to be done.
              LoggingManager.getLog().errorT(classLoc,
                                             method,
                                             SYNTAX_ERR_IN_KEY_MSG,
                                             new Object[] {tokenizer.getFullContent(),
                                                           file==null?"":file.getAbsolutePath()});
              handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
              return null;
            }
          }

          token = reverseTokenizer.nextToken();
          if (   token.getType() != PCTokenType.EFF_SEVERITY
              && token.getType() != PCTokenType.MIN_SEVERITY
              && token.getType() != PCTokenType.MAX_SEVERITY) {
            // Syntax error: nothing to be done.
            LoggingManager.getLog().errorT(classLoc,
                                           method,
                                           SYNTAX_ERR_IN_KEY_MSG,
                                           new Object[] {tokenizer.getFullContent(),
                                                          file==null?"":file.getAbsolutePath()});
            handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
            return null;
          }
        } else if (   token.getType() != PCTokenType.EFF_SEVERITY
                   && token.getType() != PCTokenType.MIN_SEVERITY
                   && token.getType() != PCTokenType.MAX_SEVERITY
                   && token.getType() != PCTokenType.LOGS
                   && token.getType() != PCTokenType.LOCAL_LOGS
                   && token.getType() != PCTokenType.PRIVATE_LOGS
                   && token.getType() != PCTokenType.FILTERS
                   && token.getType() != PCTokenType.BUNDLE_NAME) {
          // Syntax error: nothing to be done.
          LoggingManager.getLog().errorT(classLoc,
                                         method,
                                         SYNTAX_ERR_IN_KEY_MSG,
                                         new Object[] {tokenizer.getFullContent(),
                                                       file==null?"":file.getAbsolutePath()});
          handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
          return null;
        }

        if (reverseTokenizer.nextToken().getType() == TokenType.DOT) {
          LogController controller = parseLogController(reverseTokenizer.getContent(),
                                                        tokenizer.getFullContent());

          if (controller != null) {
            Attr attr;

            // Parse the remainder following the accepted controller name but
            // skip known dot.
            tokenizer = new PCTokenizer (reverseTokenizer.getAcceptedContent());
            tokenizer.nextToken();

            attr = parseLogControllerAttr(tokenizer);
            if (attr != null) {
              return new LogControllerKey(controller,
                                          attr);
            } else {
              // Syntax error: nothing to be done.
              return null;
            }
          } else {
            return null;
          }
        }
      }
      case PCTokenType.EFF_SEVERITY:
      case PCTokenType.MIN_SEVERITY:
      case PCTokenType.MAX_SEVERITY:
      case PCTokenType.LOGS:
      case PCTokenType.LOCAL_LOGS:
      case PCTokenType.PRIVATE_LOGS:
      case PCTokenType.FILTERS:
      case PCTokenType.BUNDLE_NAME: {
        // TODO: get location of current component.
        return new LogControllerKey(Location.getRoot(),
                                    parseLogControllerAttr(tokenizer));
      }
      case PCTokenType.LOG: {
        String name = parseLog(tokenizer,
                               null);

        if (name != null) {
          Token token = tokenizer.nextToken();

          if (token.getType() == TokenType.DOT) {
            Attr attr = parseLogAttr(tokenizer);

            if (attr != null) {
              if (tokenizer.nextToken().getType() == TokenType.NONE) {
                return new LogRefKey(name,
                                     attr);
              } else {
                // Syntax error: nothing to be done.
                LoggingManager.getLog().errorT(classLoc,
                                               method,
                                               SYNTAX_ERR_IN_KEY_MSG,
                                               new Object[] {tokenizer.getFullContent(),
                                                             file==null?"":file.getAbsolutePath()});
                handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
                return null;
              }
            } else {
              // Syntax error: nothing to be done.
              return null;
            }
          } else if (token.getType() == TokenType.NONE) {
            return new LogRefKey(name);
          } else {
            // Syntax error: nothing to be done.
            LoggingManager.getLog().errorT(classLoc,
                                           method,
                                           SYNTAX_ERR_IN_KEY_MSG,
                                           new Object[] {tokenizer.getFullContent(),
                                                         file==null?"":file.getAbsolutePath()});
            handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
            return null;
          }
        } else {
          // Syntax error: nothing to be done.
          return null;
        }
      }
      case PCTokenType.FORMATTER: {
        String name = parseFormatter(tokenizer,
                                     null);

        if (name != null) {
          Token token = tokenizer.nextToken();

          if (token.getType() == TokenType.DOT) {
            Attr attr = parseFormatterAttr(tokenizer);

            if (attr != null) {
              if (tokenizer.nextToken().getType() == TokenType.NONE) {
                return new FormatterRefKey(name,
                                           attr);
              } else {
                // Syntax error: nothing to be done.
                LoggingManager.getLog().errorT(classLoc,
                                               method,
                                               SYNTAX_ERR_IN_KEY_MSG,
                                               new Object[] {tokenizer.getFullContent(),
                                                             file==null?"":file.getAbsolutePath()});
                handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
                return null;
              }
            } else {
              // Syntax error: nothing to be done.
              return null;
            }
          } else if (token.getType() == TokenType.NONE) {
            return new FormatterRefKey(name);
          } else {
            // Syntax error: nothing to be done.
            LoggingManager.getLog().errorT(classLoc,
                                           method,
                                           SYNTAX_ERR_IN_KEY_MSG,
                                           new Object[] {tokenizer.getFullContent(),
                                                         file==null?"":file.getAbsolutePath()});
            handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
            return null;
          }
        } else {
          // Syntax error: nothing to be done.
          return null;
        }
      }
      default: {
        // Syntax error: nothing to be done.
        LoggingManager.getLog().errorT(classLoc,
                                       method,
                                       SYNTAX_ERR_IN_KEY_MSG,
                                       new Object[] {tokenizer.getFullContent(),
                                                     file==null?"":file.getAbsolutePath()});
        handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
        return null;
      }
    }
  }

  protected LogController parseLogController(String name,
                                             String forKey) {
    final String method = "parseLogController(java.lang.String)";

    try {
      if ((new PCTokenizer(name)).getLookahead().getType() != TokenType.SLASH) {
        return Location.getLocation(name);
      } else {
        return Category.getCategoryInt(name);
      }
    }
    catch (IllegalArgumentException e) {
      LoggingManager.getLog().errorT(classLoc,
                                     method,
                                     SYNTAX_ERR_IN_KEY_MSG,
                                     new Object[] {forKey,
                                                   file==null?"":file.getAbsolutePath()});
      handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
      return null;
    }
  }

  protected Attr parseLogControllerAttr(PCTokenizer tokenizer) {
    final String method = "parseLogControllerAttr(PCTokenizer)";

    Token token = tokenizer.nextToken();

    switch (token.getType()) {
      case PCTokenType.EFF_SEVERITY:
      case PCTokenType.MIN_SEVERITY:
      case PCTokenType.MAX_SEVERITY: {
        if (tokenizer.getLookahead().getType() == TokenType.LEFT_BRACKET) {
          ReverseTokenizer reverseTokenizer;

          tokenizer.nextToken();
          reverseTokenizer = new ReverseTokenizer(tokenizer);
          if (reverseTokenizer.nextToken().getType() == TokenType.RIGHT_BRACKET) {
            LogController controller = parseLogController(reverseTokenizer.getContent(),
                                                          tokenizer.getFullContent());

            if (controller != null) {
              return new SeverityAttr(token.getType(),
                                      controller);
            } else {
              // Syntax error: nothing to be done.
              return null;
            }
          } else {
            // Syntax error: nothing to be done.
            LoggingManager.getLog().errorT(classLoc,
                                           method,
                                           SYNTAX_ERR_IN_KEY_MSG,
                                           new Object[] {tokenizer.getFullContent(),
                                                         file==null?"":file.getAbsolutePath()});
            handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
            return null;
          }
        } else {
          return new SeverityAttr(token.getType());
        }
      }
      case PCTokenType.LOGS:
      case PCTokenType.LOCAL_LOGS:
      case PCTokenType.PRIVATE_LOGS:
      case PCTokenType.FILTERS:
      case PCTokenType.BUNDLE_NAME : {
        return new Attr(token.getType());
      }
      default: {
        // Syntax error: nothing to be done.
        LoggingManager.getLog().errorT(classLoc,
                                       method,
                                       SYNTAX_ERR_IN_KEY_MSG,
                                       new Object[] {tokenizer.getFullContent(),
                                                     file==null?"":file.getAbsolutePath()});
        handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
        return null;
      }
    }
  }

  protected String parseLog(PCTokenizer tokenizer,
                            String    forKey) {
    final String method = "parseLog(PCTokenizer,"
                                 + "java.lang.String)";

    if (   tokenizer.nextToken().getType() == PCTokenType.LOG
        && tokenizer.nextToken().getType() == TokenType.LEFT_BRACKET) {
      Token token;

      token = tokenizer.nextToken();
      if (   token.getType() == TokenType.IDENT
          || token.getType() == TokenType.UNPARSED) {
        String name = (String) token.getValue();

        if (tokenizer.nextToken().getType() == TokenType.RIGHT_BRACKET) {
          return name;
        } else {
          // Syntax error: nothing to be done.
          if (forKey == null) {
            LoggingManager.getLog().errorT(classLoc,
                                           method,
                                           SYNTAX_ERR_IN_KEY_MSG,
                                           new Object[] {tokenizer.getFullContent(),
                                                         file==null?"":file.getAbsolutePath()});
          } else {
            LoggingManager.getLog().errorT(classLoc,
                                           method,
                                           SYNTAX_ERR_IN_VAL_MSG,
                                           new Object[] {forKey,
                                                         file==null?"":file.getAbsolutePath()});
          }
          handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
          return null;
        }
      } else {
        // Syntax error: nothing to be done.
        if (forKey == null) {
          LoggingManager.getLog().errorT(classLoc,
                                         method,
                                         SYNTAX_ERR_IN_KEY_MSG,
                                         new Object[] {tokenizer.getFullContent(),
                                                       file==null?"":file.getAbsolutePath()});
        } else {
          LoggingManager.getLog().errorT(classLoc,
                                         method,
                                         SYNTAX_ERR_IN_VAL_MSG,
                                         new Object[] {forKey,
                                                        file==null?"":file.getAbsolutePath()});
        }
        handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
        return null;
      }
    } else {
      // Syntax error: nothing to be done.
      if (forKey == null) {
        LoggingManager.getLog().errorT(classLoc,
                                       method,
                                       SYNTAX_ERR_IN_KEY_MSG,
                                       new Object[] {tokenizer.getFullContent(),
                                                     file==null?"":file.getAbsolutePath()});
      } else {
        LoggingManager.getLog().errorT(classLoc,
                                       method,
                                       SYNTAX_ERR_IN_VAL_MSG,
                                       new Object[] {forKey,
                                                     file==null?"":file.getAbsolutePath()});
      }
      handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
      return null;
    }
  }

  protected Attr parseLogAttr(PCTokenizer tokenizer) {
    final String method = "parseLogAttr(PCTokenizer)";

    Token token = tokenizer.nextToken();

    switch (token.getType()) {
      case PCTokenType.APPEND:
      case PCTokenType.AUTO_FLUSH:
      case PCTokenType.EFF_SEVERITY:
      case PCTokenType.ENCODING:
      case PCTokenType.DESCRIPTION:  //YUE: additional attr 'desc'
      case PCTokenType.FILTERS:
      case PCTokenType.FORMATTER:
      case PCTokenType.PATTERN:
      case PCTokenType.LIMIT:
      case PCTokenType.CNT: {
        return new Attr(token.getType());
      }
      default: {
        // Syntax error: nothing to be done.
        LoggingManager.getLog().errorT(classLoc,
                                       method,
                                       SYNTAX_ERR_IN_KEY_MSG,
                                       new Object[] {tokenizer.getFullContent(),
                                                     file==null?"":file.getAbsolutePath()});
        handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
        return null;
      }
    }
  }

  protected String parseFormatter(PCTokenizer tokenizer,
                                  String    forKey) {
    final String method = "parseFormatter(PCTokenizer,"
                                       + "java.lang.String)";

    if (   tokenizer.nextToken().getType() == PCTokenType.FORMATTER
        && tokenizer.nextToken().getType() == TokenType.LEFT_BRACKET) {
      Token token = tokenizer.nextToken();

      if (   token.getType() == TokenType.IDENT
          || token.getType() == TokenType.UNPARSED) {
        String name = (String) token.getValue();

        if (tokenizer.nextToken().getType() == TokenType.RIGHT_BRACKET) {
          return name;
        } else {
          // Syntax error: nothing to be done.
          if (forKey == null) {
            LoggingManager.getLog().errorT(classLoc,
                                           method,
                                           SYNTAX_ERR_IN_KEY_MSG,
                                           new Object[] {tokenizer.getFullContent(),
                                                         file==null?"":file.getAbsolutePath()});
          } else {
            LoggingManager.getLog().errorT(classLoc,
                                           method,
                                           SYNTAX_ERR_IN_VAL_MSG,
                                           new Object[] {forKey,
                                                         file==null?"":file.getAbsolutePath()});
          }
          handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
          return null;
        }
      } else {
        // Syntax error: nothing to be done.
        if (forKey == null) {
          LoggingManager.getLog().errorT(classLoc,
                                         method,
                                         SYNTAX_ERR_IN_KEY_MSG,
                                         new Object[] {tokenizer.getFullContent(),
                                                       file==null?"":file.getAbsolutePath()});
        } else {
          LoggingManager.getLog().errorT(classLoc,
                                         method,
                                         SYNTAX_ERR_IN_VAL_MSG,
                                         new Object[] {forKey,
                                                       file==null?"":file.getAbsolutePath()});
        }
        handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
        return null;
      }
    } else {
      // Syntax error: nothing to be done.
      if (forKey == null) {
        LoggingManager.getLog().errorT(classLoc,
                                       method,
                                       SYNTAX_ERR_IN_KEY_MSG,
                                       new Object[] {tokenizer.getFullContent(),
                                                     file==null?"":file.getAbsolutePath()});
      } else {
        LoggingManager.getLog().errorT(classLoc,
                                       method,
                                       SYNTAX_ERR_IN_VAL_MSG,
                                       new Object[] {forKey,
                                                     file==null?"":file.getAbsolutePath()});
      }
      handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
      return null;
    }
  }

  protected Attr parseFormatterAttr(PCTokenizer tokenizer) {
    final String method = "parseFormatterAttr(PCTokenizer)";

    Token token = tokenizer.nextToken();

    switch (token.getType()) {
      case PCTokenType.PATTERN: {
        return new Attr(token.getType());
      }
      default: {
        // Syntax error: nothing to be done.
        LoggingManager.getLog().errorT(classLoc,
                                       method,
                                       SYNTAX_ERR_IN_KEY_MSG,
                                       new Object[] {tokenizer.getFullContent(),
                                                     file==null?"":file.getAbsolutePath()});
        handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
        return null;
      }
    }
  }

  protected SeverityVal parseSeverity(String value,
                                      String forKey) {
    final String method = "parseSeverity(java.lang.String,"
                                      + "java.lang.String)";

		PCTokenizer tokenizer = new PCTokenizer(value);
    Token     token     = tokenizer.nextToken();

    if (token.getType() == PCTokenType.SEVERITY) {
      if (tokenizer.nextToken().getType() == TokenType.DOT) {
        token = tokenizer.nextToken();
      } else {
        // Syntax error: nothing to be done.
        LoggingManager.getLog().errorT(classLoc,
                                       method,
                                       SYNTAX_ERR_IN_VAL_MSG,
                                       new Object[] {forKey,
                                                     file==null?"":file.getAbsolutePath()});
        handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
        return null;
      }
    }
    try {
      int severity = Severity.parse(token.getValue());

      if (tokenizer.nextToken().getType() == TokenType.NONE) {
        return new SeverityVal(severity);
      } else {
        // Syntax error: nothing to be done.
        LoggingManager.getLog().errorT(classLoc,
                                       method,
                                       SYNTAX_ERR_IN_VAL_MSG,
                                       new Object[] {forKey,
                                                     file==null?"":file.getAbsolutePath()});
        handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
        return null;
      }
    }
    catch (IllegalArgumentException e) {
      // Syntax error: nothing to be done.
      LoggingManager.getLog().errorT(classLoc,
                                     method,
                                     SYNTAX_ERR_IN_VAL_MSG,
                                     new Object[] {forKey,
                                                   file==null?"":file.getAbsolutePath()});
      handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
      return null;
    }
  }

  protected BooleanVal parseBoolean(String value,
                                    String forKey) {
    final String method = "parseBoolean(java.lang.String,"
                                     + "java.lang.String)";

		PCTokenizer tokenizer = new PCTokenizer(value);

    switch (tokenizer.nextToken().getType()) {
      case PCTokenType.FALSE: {
        return BooleanVal.FALSE;
      }
      case PCTokenType.TRUE: {
        return BooleanVal.TRUE;
      }
      default: {
        // Syntax error: nothing to be done.
        LoggingManager.getLog().errorT(classLoc,
                                       method,
                                       SYNTAX_ERR_IN_VAL_MSG,
                                       new Object[] {forKey,
                                                     file==null?"":file.getAbsolutePath()});
        handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
        return null;
      }
    }
  }

  protected ObjectsVal parseObjects(String value,
                                    String forKey) {
    final String method = "parseObjects(java.lang.String,"
                                     + "java.lang.String)";

		PCTokenizer  tokenizer = new PCTokenizer(value);
    boolean    isAdding  = false;
    ObjectsVal objects;

    if (tokenizer.getLookahead().getType() != TokenType.NONE) {
      if (tokenizer.getLookahead().getType() == PCTokenType.PLUS) {
        tokenizer.nextToken();
        isAdding = true;
      }
      objects = parseObjectList(tokenizer,
                                forKey);
      if (objects != null) {
        if (tokenizer.nextToken().getType() == TokenType.NONE) {
          objects.setAdding(isAdding);
          return objects;
        } else {
          // Syntax error: nothing to be done.
          LoggingManager.getLog().errorT(classLoc,
                                         method,
                                         SYNTAX_ERR_IN_VAL_MSG,
                                         new Object[] {forKey,
                                                       file==null?"":file.getAbsolutePath()});
          handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
          return null;
        }
      } else {
        // Syntax error: nothing to be done.
        return null;
      }
    } else {
      // Remove all attached objects.
      return new ObjectsVal();
    }
  }

  protected ObjectsVal parseObjectList(PCTokenizer tokenizer,
                                       String    forKey) {
    final String method = "parseObjectList(PCTokenizer,"
                                        + "java.lang.String)";

    ObjectsVal objects = null;
    ObjectVal  object  = parseObject(tokenizer,
                                     forKey);

    if (object != null) {
      objects = new ObjectsVal();
      objects.addObject(object);
      while (tokenizer.getLookahead().getType() == TokenType.COMMA) {
        tokenizer.nextToken();
        object = parseObject(tokenizer,
                             forKey);
        if (object != null) {
          objects.addObject(object);
        }
      }
    }
    return objects;
  }

  protected ObjectVal parseObject(PCTokenizer tokenizer,
                                  String    forKey) {
    final String method = "parseObject(PCTokenizer,"
                                    + "java.lang.String)";

    switch (tokenizer.getLookahead().getType()) {
      case PCTokenType.FILE_LOG:
      case PCTokenType.CONSOLE_LOG:
      case PCTokenType.TRACE_FORMATTER:
      case PCTokenType.LIST_FORMATTER:
      case PCTokenType.XML_FORMATTER:
      case TokenType.IDENT:
      case TokenType.UNPARSED: {
        return parseClass(tokenizer,
                          forKey);
      }
      case PCTokenType.LOG: {
        String name = parseLog(tokenizer,
                               forKey);

        if (name != null) {
          return new  LogRefVal(name);
        } else {
          return null;
        }
      }
      case PCTokenType.FORMATTER: {
        String name = parseFormatter(tokenizer,
                                     forKey);

        if (name != null) {
          return new FormatterRefVal(name);
        } else {
          return null;
        }
      }
      default: {
        // Syntax error: nothing to be done.
        LoggingManager.getLog().errorT(classLoc,
                                       method,
                                       SYNTAX_ERR_IN_VAL_MSG,
                                       new Object[] {forKey,
                                                     file==null?"":file.getAbsolutePath()});
        handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
        return null;
      }
    }
  }

  protected ClassVal parseClass(PCTokenizer tokenizer,
                                String    forKey) {
    final String method = "parseClass(PCTokenizer,"
                                   + "java.lang.String)";

    Token token = tokenizer.nextToken();

    switch (token.getType()) {
      case PCTokenType.FILE_LOG:
      case PCTokenType.CONSOLE_LOG:
      case PCTokenType.TRACE_FORMATTER:
      case PCTokenType.LIST_FORMATTER:
      case PCTokenType.XML_FORMATTER: {
        return new ClassVal(token.getType());
      }
      case TokenType.IDENT:
      case TokenType.UNPARSED: {
        String ident = token.getValue();

        while (tokenizer.getLookahead().getType() == TokenType.DOT) {
          tokenizer.nextToken();
          token = tokenizer.nextToken();
          if (   token.getType() == TokenType.IDENT
              || token.getType() == TokenType.UNPARSED) {
            ident +=   "."
                     + token.getValue();
          } else {
            // Syntax error: nothing to be done.
            LoggingManager.getLog().errorT(classLoc,
                                           method,
                                           SYNTAX_ERR_IN_VAL_MSG,
                                           new Object[] {forKey,
                                                         file==null?"":file.getAbsolutePath()});
            handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
            return null;
          }
        }
        return new CustomClassVal(ident);
      }
      default: {
        // Syntax error: nothing to be done.
        LoggingManager.getLog().errorT(classLoc,
                                       method,
                                       SYNTAX_ERR_IN_VAL_MSG,
                                       new Object[] {forKey,
                                                     file==null?"":file.getAbsolutePath()});
        handleException(new IllegalArgumentException(SYNTAX_ERR_EMSG));
        return null;
      }
    }
  }

  private static class Element {
  }

  private static class Key extends Element {

    public Key() {
      this.attr = null;
    }

    public Key(Attr attr) {
      this.attr = attr;
    }

    public Attr getAttr() {
      return attr;
    }

    public void setAttr(Attr attr) {
      this.attr = attr;
    }

    private Attr attr;

  }

  private static class LogControllerKey extends Key {

    public LogControllerKey(LogController controller,
                            Attr          attr) {
      super(attr);

      this.controller = controller;
    }

    public LogController getController() {
      return controller;
    }

    private LogController controller;

  }

  private static class RefKey extends Key {

    public RefKey(String name) {
      this.name = name;
    }

    public RefKey(String name,
                  Attr   attr) {
      super(attr);

      this.name = name;
    }

    public String getName() {
      return name;
    }

    private String name;

  }

  private static class LogRefKey extends RefKey {

    public LogRefKey(String name) {
      super(name);
    }

    public LogRefKey(String name,
                     Attr   attr) {
      super(name,
            attr);
    }

  }

  private static class FormatterRefKey extends RefKey {

    public FormatterRefKey(String name) {
      super(name);
    }

    public FormatterRefKey(String name,
                           Attr   attr) {
      super(name,
            attr);
    }

  }

  private static class Attr extends Element {

    public Attr(int attr) {
      this.attr = attr;
    }

    public int getAttr() {
      return attr;
    }

    private int attr;

  }

  private static class SeverityAttr extends Attr {

    public SeverityAttr(int attr) {
      super(attr);
    }

    public SeverityAttr(int           attr,
                        LogController relative) {
      super(attr);

      this.relative = relative;
    }

    public LogController getRelative() {
      return relative;
    }

    private LogController relative;

  }

  private static class Val extends Element {
  }

  private static class SeverityVal extends Val {

    public SeverityVal(int severity) {
      this.severity = severity;
    }

    public int getSeverity() {
      return severity;
    }

    private int severity;

  }

  private static class BooleanVal extends Val {

    public static BooleanVal FALSE = new BooleanVal(false),
                             TRUE  = new BooleanVal(true);

    public BooleanVal(boolean val) {
      this.val = val;
    }

    public boolean getBoolean() {
      return val;
    }

    private boolean val;

  }

  private static class ObjectsVal extends Val {

    public boolean isAdding() {
      return isAdding;
    }

    public void setAdding(boolean isAdding) {
      this.isAdding = isAdding;
    }

    public Collection getObjects() {
      return objects;
    }

    public void addObject(ObjectVal object) {
      objects.add(object);
    }

    private boolean    isAdding = false;
    private LinkedList objects  = new LinkedList();

  }

  private static class ObjectVal extends Val {
  }

  private static class RefVal extends ObjectVal {

    public RefVal(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    private String name;

  }

  private static class LogRefVal extends RefVal {

    public LogRefVal(String name) {
      super(name);
    }

  }

  private static class FormatterRefVal extends RefVal {

    public FormatterRefVal(String name) {
      super(name);
    }

  }

  private static class ClassVal extends ObjectVal {

    public ClassVal(int type) {
      this.type = type;
    }

    public int getType() {
      return type;
    }

    private int type;

  }

  private static class CustomClassVal extends ClassVal {

    public CustomClassVal(String ident) {
      super(TokenType.IDENT);

      this.ident = ident;
    }

    public String getIdent() {
      return ident;
    }

    private String ident;

  }

  private static class LogControllerEntry {

    public LogControllerEntry(LogController controller) {
      this.controller = controller;
    }

    public LogController getController() {
      return controller;
    }

    public SeverityVal getEffectiveSeverity() {
      return effSeverity;
    }

    public void setEffectiveSeverity(SeverityVal severity) {
      effSeverity = severity;
    }

    public Map getEffectiveRelationSeverities() {
      return effRelationSeverities;
    }

    public void setEffectiveRelationSeverity(LogController controller,
                                             SeverityVal   severity) {
      effRelationSeverities.put(controller,
                                severity);
    }

    public SeverityVal getMinimumSeverity() {
      return minSeverity;
    }

    public void setMinimumSeverity(SeverityVal severity) {
      minSeverity = severity;
    }

    public Map getMinimumRelationSeverities() {
      return minRelationSeverities;
    }

    public void setMinimumRelationSeverity(LogController controller,
                                           SeverityVal   severity) {
      minRelationSeverities.put(controller,
                                severity);
    }

    public SeverityVal getMaximumSeverity() {
      return maxSeverity;
    }

    public void setMaximumSeverity(SeverityVal severity) {
      maxSeverity = severity;
    }

    public Map getMaximumRelationSeverities() {
      return maxRelationSeverities;
    }

    public void setMaximumRelationSeverity(LogController controller,
                                           SeverityVal   severity) {
      maxRelationSeverities.put(controller,
                                severity);
    }

    public ObjectsVal getLogs() {
      return logs;
    }

    public void setLogs(ObjectsVal logs) {
      this.logs = logs;
    }

    public ObjectsVal getLocalLogs() {
      return localLogs;
    }

    public void setLocalLogs(ObjectsVal logs) {
      this.localLogs = logs;
    }

    public ObjectsVal getPrivateLogs() {
      return privateLogs;
    }

    public void setPrivateLogs(ObjectsVal logs) {
      this.privateLogs = logs;
    }

    public ObjectsVal getFilters() {
      return filters;
    }

    public void setFilters(ObjectsVal filters) {
      this.filters = filters;
    }

    public String getResourceBundleName() {
      return resourceBundleName;
    }

    public void setResourceBundleName(String resourceBundleName) {
      this.resourceBundleName = resourceBundleName;
    }

    private LogController controller;
    private SeverityVal   effSeverity,
                          minSeverity,
                          maxSeverity;
    private Map           effRelationSeverities = new HashMap(),
                          minRelationSeverities = new HashMap(),
                          maxRelationSeverities = new HashMap();
    private ObjectsVal    logs,
                          localLogs,
                          privateLogs,
                          filters;
    private String        resourceBundleName;

  }

  private static class LogEntry {

    public ObjectsVal getObject() {
      return object;
    }

    public void setObject(ObjectsVal object) {
      this.object = object;
    }

    public SeverityVal getEffectiveSeverity() {
      return effSeverity;
    }

    public void setEffectiveSeverity(SeverityVal severity) {
      effSeverity = severity;
    }

    public String getEncoding() {
      return enc;
    }

    public void setEncoding(String enc) {
      this.enc = enc;
    }

    //YUE: additional attr 'desc' for Log
    public String getDesc() {
      return desc;
    }

    public void setDesc(String desc) {
      this.desc = desc;
    }

    public ObjectsVal getFilters() {
      return filters;
    }

    public void setFilters(ObjectsVal objects) {
      filters = objects;
    }

    public ObjectsVal getFormatter() {
      return formatter;
    }

    public void setFormatter(ObjectsVal object) {
      formatter = object;
    }

    public BooleanVal getAppend() {
      return append;
    }

    public void setAppend(BooleanVal append) {
      this.append = append;
    }

    public BooleanVal getAutoFlush() {
      return autoFlush;
    }

    public void setAutoFlush(BooleanVal autoFlush) {
      this.autoFlush = autoFlush;
    }

    public String getPattern() {
      return pattern;
    }

    public void setPattern(String pattern) {
      this.pattern = pattern;
    }

    public int getLimit() {
      return limit;
    }

    public void setLimit(int limit) {
      if (limit > FileLog.NO_LIMIT) {
        this.limit = limit;
      }
      limitSet = true;
    }

    public boolean isLimitSet() {
      return limitSet;
    }

    public int getCnt() {
      return cnt;
    }

    public void setCnt(int cnt) {
      if (cnt > FileLog.NO_CNT) {
        this.cnt = cnt;
      }
      cntSet = true;
    }

    public boolean isCntSet() {
      return cntSet;
    }

    public Log getLog() {
      return log;
    }

    public void setLog(Log log) {
      this.log = log;
    }

    private ObjectsVal  object,
                        filters,
                        formatter;
    private SeverityVal effSeverity;
    private BooleanVal  append,
                        autoFlush;
    private String      enc,
                        pattern,
                        desc;   //YUE: short description about the Log
    private int         limit = FileLog.NO_LIMIT,
                        cnt   = FileLog.NO_CNT;
    private boolean     autoFlushSet = false,
                        limitSet = false,
                        cntSet   = false;
    private Log         log;

  }

  private static class FormatterEntry {

    public ObjectsVal getObject() {
      return object;
    }

    public void setObject(ObjectsVal object) {
      this.object = object;
    }

    public String getPattern() {
      return pattern;
    }

    public void setPattern(String pattern) {
      this.pattern = pattern;
    }

    public Formatter getFormatter() {
      return formatter;
    }

    public void setFormatter(Formatter formatter) {
      this.formatter = formatter;
    }

    private ObjectsVal object;
    private String     pattern;
    private Formatter  formatter;

  }
  static class TokenType extends com.sap.tc.logging.TokenType {

	 public static final int COMMA         = com.sap.tc.logging.TokenType.MAX + 1,
							 DOT           = COMMA + 1,
							 SLASH         = DOT + 1,
							 LEFT_PARAN    = SLASH + 1,
							 RIGHT_PARAN   = LEFT_PARAN + 1,
							 LEFT_BRACKET  = RIGHT_PARAN + 1,
							 RIGHT_BRACKET = LEFT_BRACKET + 1;
	 public static final int MAX           = RIGHT_BRACKET;

   }

   static class Tokenizer extends com.sap.tc.logging.Tokenizer {

	 public Tokenizer(String content) {
	   super(content);
	 }

	 public Token nextTokenInt() {
	   Token token = super.nextTokenInt();
	   int   type  = token.getType();

	   if (type != TokenType.UNKNOWN) {
		 return token;
	   } else {
		 char val = token.getValue().charAt(0);

		 switch (val) {
		   case ',': {
		 return new Token(TokenType.COMMA,
						  ",");
	   }
	   case '.': {
		 return new Token(TokenType.DOT,
						  ".");
	   }
	   case '/': {
		 return new Token(TokenType.SLASH,
						  "/");
	   }
	   case '(': {
		 return new Token(TokenType.LEFT_PARAN,
						  "(");
	   }
	   case ')': {
		 return new Token(TokenType.RIGHT_PARAN,
						  ")");
	   }
	   case '[': {
		 return new Token(TokenType.LEFT_BRACKET,
						  "[");
	   }
	   case ']': {
		 return new Token(TokenType.RIGHT_BRACKET,
						  "]");
		   }
		   default: {
			 return token;
		   }
		 }
	   }
	 }

   }

  private Properties properties;
  private File       file;
  private long       lastConfigured = 0;

  private static final int NORMAL_LOGS  = 0,
                           LOCAL_LOGS   = NORMAL_LOGS + 1,
                           PRIVATE_LOGS = LOCAL_LOGS + 1,
                           NO_LOGS      = PRIVATE_LOGS + 1;

  private static Location classLoc = Location.getLocation(PropertiesConfigurator.class.getName(), "tc~logging~java", "BC-JAS-ADM-LOG-API");

}
