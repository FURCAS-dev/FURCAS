/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.internal.logger;

import java.util.Properties;

import org.eclipse.emf.query2.internal.logger.impl.LoggerImpl;


/**
 * The MOIN Logger Factory used to create instances of MOIN Logger object.
 * <p>
 * The MOIN Logging and Tracing solution implements a factory MoinLoggerFactory
 * which automatically detects the current MOIN scenario and provides a
 * ready-to-use MOIN Logger.
 * <p>
 * The MOIN supports following scenarios:
 * <ol>
 * <li>MOIN application running standalone, outside of engine and IDE, e.g. to
 * run test cases, or as build-plugin (Japro or CBS) to build the JMI classes.
 * <li>MOIN application running as an Eclipse plug-in in the SAP IDE.
 * <li>MOIN application running as an engine-service in the SAP J2EE engine.
 * </ol>
 * <p>
 * If the SAP Logging and Tracing functionality is not usable, for example SAP
 * Logging API is not in ClassPath or the configuration does not exists the
 * factory during initialization throws an exception -
 * com.sap.tc.moin.repository.shared.logger.MoinLoggerException.
 * <p>
 * The MOIN Logging and Tracing solution defines the logical-organized
 * categories which are defined in the
 * com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum class. Additional,
 * the MOIN Logging and Tracing solution allows you the usage of package-related
 * and logical-defined location names. The logical-defined locations are defined
 * in the com.sap.tc.moin.repository.shared.logger.MoinLocationEnum class.
 * 
 * @author d029324
 */

public class LoggerFactory {

	/**
	 * The getLogger() factory method returns the ready-to-use MoinLogger object
	 * which allows you the usage of logging and tracing functionality.
	 * <p>
	 * The getLogger() factory method uses the logical-defined category
	 * parameter which is defined in the MoinCategoryEnum class (see
	 * com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum location
	 * parameter).
	 * <p>
	 * The getLogger() factory method allows you the usage of logical-defined
	 * location name which is defined by the location parameter (see
	 * com.sap.tc.moin.repository.shared.logger.MoinLocationEnum location
	 * parameter).
	 * <p>
	 * The sub-location parameter (see Class subLocation parameter) allows you
	 * to localize the message in a class and therefore the class name is also
	 * visible in the particular message.
	 * <p>
	 * The getLogger() factory method checks:
	 * <ol>
	 * <li>if the used Category (see
	 * com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum location
	 * parameter) is a sub-Category of the MOIN parent Category
	 * /Applications/Moin. Otherwise, the factory writes an error message into
	 * the /Applications/Moin/Administration Category and
	 * com.sap.tc.moin.repository.shared.logger Location.
	 * <li>if the used Location (see
	 * com.sap.tc.moin.repository.shared.logger.MoinLocationEnum location
	 * parameter) is a sub-Location of the MOIN parent Location com.sap.tc.moin.
	 * Otherwise, the factory writes an error message into the
	 * /Applications/Moin/Administration Category and
	 * com.sap.tc.moin.repository.shared.logger Location.
	 * </ol>
	 * @param subLocation
	 *            the sub-location which allows you the class-oriented message
	 *            localization
	 * 
	 * @return ready-to-use MoinLogger
	 */
	public static synchronized QueryLogger getLogger(Class subLocation) {

//		String categoryName = category.toString();
//		String locationName = location.toString();

		StringBuffer subLocationName = new StringBuffer(subLocation.getName());

//		Category log = getLogObject(categoryName);
//		Location trace = getTraceObject(locationName);

		return new LoggerImpl(subLocationName);
	}

	// The Log Controller list used in the IDE scenario
	private static Properties controllers = new Properties();

	// Throw a RuntimeException for each reported exception (Severity ERROR / FATAL)
	public static boolean throwRuntimeException = false;

	/**
	 * Whether translation of log entries into JMX notifications is currently
	 * enabled. This flag can be toggled via JMX.
	 */
	public static volatile boolean jmxNotificationsEnabled = false;

	public static void setJmxNotificationsEnabled(boolean enabled) {

		jmxNotificationsEnabled = enabled;
	}

	/**
	 * This method sets the severity of the Modeling Infrastructure Location
	 * (com.sap.moin) to DEBUG, and is used for MOIN internal test - see
	 * TestSuitePluginSlimIndexWithTrace test suite.
	 */
//	public static void setAllLocationsToDebug() {
//
//		// Set the DEBUG severity for MOIN Location.
//		Location locMoin = getTraceObject(LocationEnum.MOIN.getLocationName());
//		locMoin.setEffectiveSeverity(Severity.DEBUG);
//
//	}

//	private static Category getLogObject(String categoryName) {
//
//		Category log = logs.get(categoryName);
//		if (log == null) {
//			// the lenght of the Category.APPLICATIONS is 14.
//			log = Category.getCategory(Category.APPLICATIONS, categoryName.substring(14, categoryName.length()));
//			logs.put(categoryName, log);
//
//		}
//		return log;
//	}
//
//	private static Location getTraceObject(String locationName) {
//
//		Location trace = traces.get(locationName);
//		if (trace == null) {
//			trace = Location.getLocation(locationName);
//			traces.put(locationName, trace);
//
//		}
//		return trace;
//	}

	private LoggerFactory() {

	}

	static {

		// Activate the exception handling in trace
		throwRuntimeException = Boolean.valueOf(System.getProperty("org.eclipse.emf.query2.errorAsRuntimeException", "false")).booleanValue(); //$NON-NLS-1$ //$NON-NLS-2$

		//buildUpLoggerNames( );
		String categoryName = null;
		for (CategoryEnum categoryEnum : CategoryEnum.values()) {
			controllers.put(categoryEnum.toString(), categoryEnum.getCategoryDescription());
		}

		String locationName = null;
		for (LocationEnum locationEnum : LocationEnum.values()) {
			controllers.put(locationEnum.toString(), locationEnum.getLocationDescription());
		}

		//        if ( JMX_ENABLED ) {
		//            try {
		//                jmxAdapter = new JmxAdapter( new ObjectName( MOIN_DOMAIN + "type=Logging,id=" + System.identityHashCode( MoinLoggerFactory.class.getClassLoader( ) ) ) ); //$NON-NLS-1$
		//            } catch ( MalformedObjectNameException e ) {
		//                // $JL-EXC$ JLin Exception
		//            } catch ( NullPointerException e ) {
		//                // $JL-EXC$ JLin Exception
		//            }
		//        }
	}

	/**
	 * Returns the property object that contains the list of alredy registered
	 * Log Controllers.
	 * 
	 * @return property object containing the list of registered Log
	 *         Controllers.
	 */
	public static synchronized Properties getRegisteredLogControllers() {

		return controllers;
	}

	private static boolean _initializedSAPLogging = false;

//	private static PropertiesConfigurator _propConfigurator = null;
//
//	public static synchronized boolean configureSAPLogging(Properties loggingProperties) {
//
//		if (_initializedSAPLogging == false) {
//			if (loggingProperties.size() > 0) {
//				_propConfigurator = new PropertiesConfigurator(loggingProperties);
//				_propConfigurator.configure();
//				_initializedSAPLogging = true;
//				return true;
//			}
//			return false;
//		} else {
//			return true;
//		}
//	}

	/**
	 * The MBean instance that gets registered in the MBeanServer. We need it
	 * for the translation of log entries to JMX notifications.
	 */
	//    private static JmxAdapter jmxAdapter;
//	public static synchronized void logged(LogRecord record, StackTraceElement[] stackTrace) {

		//        jmxAdapter.sendNotification( record, stackTrace );
//	}

	//    private static final class JmxAdapter extends NotificationBroadcasterSupport implements MoinLoggerMBean {
	//
	//        private final ObjectName objectName;
	//
	//        /**
	//         * Sequence number if JMX notifications need to be emitted.
	//         */
	//        private AtomicLong seqNo = new AtomicLong( 0 );
	//
	//        private JmxAdapter( ObjectName objectName ) {
	//
	//            this.objectName = objectName;
	//            registerBroadcastingMBean( this, MoinLoggerMBean.class, objectName );
	//        }
	//
	//        @Override
	//        public MBeanNotificationInfo[] getNotificationInfo( ) {
	//
	//            MBeanNotificationInfo[] notifsInfo = { new MBeanNotificationInfo( MoinLoggerMBean.ALL_NOTIFICATION_TYPES, Notification.class.getName( ), "Notifications sent by the Logging MBean" ) }; //$NON-NLS-1$
	//            return notifsInfo;
	//        }
	//
	//        /**
	//         * Translates the given log entry into a JMX notification and emits it.
	//         * 
	//         * @param stackTrace
	//         */
	//        public void sendNotification( LogRecord record, StackTraceElement[] stackTrace ) {
	//
	//            String notifType = null;
	//            switch ( record.getSeverity( ) ) {
	//                case Severity.FATAL:
	//                    notifType = MoinLoggerMBean.LOG_ENTRY_FATAL;
	//                    break;
	//                case Severity.ERROR:
	//                    notifType = MoinLoggerMBean.LOG_ENTRY_ERROR;
	//                    break;
	//                case Severity.WARNING:
	//                    notifType = MoinLoggerMBean.LOG_ENTRY_WARNING;
	//                    break;
	//                case Severity.INFO:
	//                    notifType = MoinLoggerMBean.LOG_ENTRY_INFO;
	//                    break;
	//                case Severity.PATH:
	//                    notifType = MoinLoggerMBean.LOG_ENTRY_PATH;
	//                    break;
	//                case Severity.DEBUG:
	//                    notifType = MoinLoggerMBean.LOG_ENTRY_DEBUG;
	//                    break;
	//            }
	//            String categoryName = record.getSourceName( );
	//            String locationName = record.getLocationName( );
	//            StringBuilder message = new StringBuilder( );
	//            message.append( "Message=\"" ).append( record.getMessage( ) ).append( "\"" ); //$NON-NLS-1$ //$NON-NLS-2$
	//            if ( categoryName != null && !categoryName.equals( locationName ) ) {
	//                message.append( ",Category=" + categoryName + ",Location=" + record.getLocationName( ) ); //$NON-NLS-1$ //$NON-NLS-2$
	//            } else {
	//                message.append( ",Location=" + record.getLocationName( ) ); //$NON-NLS-1$
	//            }
	//            Notification notification = new Notification( notifType, objectName, seqNo.incrementAndGet( ), message.toString( ) );
	//            notification.setUserData( stackTrace );
	//            sendNotification( notification );
	//        }
	//
	//        public String[] getCategories( ) {
	//
	//            TreeSet<String> result = new TreeSet<String>( logs.keySet( ) );
	//            return result.toArray( new String[result.size( )] );
	//        }
	//
	//        public String[] getLocations( ) {
	//
	//            TreeSet<String> result = new TreeSet<String>( traces.keySet( ) );
	//            return result.toArray( new String[result.size( )] );
	//        }
	//
	//        public void startNotifications( ) throws IOException {
	//
	//            MoinLoggerFactory.setJmxNotificationsEnabled( true );
	//        }
	//
	//        public boolean notificationsStarted( ) throws IOException {
	//
	//            return MoinLoggerFactory.jmxNotificationsEnabled;
	//        }
	//
	//        public void stopNotifications( ) throws IOException {
	//
	//            MoinLoggerFactory.setJmxNotificationsEnabled( false );
	//        }
	//    }
}
