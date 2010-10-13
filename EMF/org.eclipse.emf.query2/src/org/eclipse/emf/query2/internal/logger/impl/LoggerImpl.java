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
package org.eclipse.emf.query2.internal.logger.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.LogRecord;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Logger;
import org.eclipse.emf.query2.exception.ExternalizedString;
import org.eclipse.emf.query2.exception.LocalizedBaseException;
import org.eclipse.emf.query2.exception.LocalizedBaseRuntimeException;
import org.eclipse.emf.query2.internal.logger.LogSeverity;
import org.eclipse.emf.query2.internal.logger.LoggerFactory;
import org.eclipse.emf.query2.internal.logger.QueryLogger;
import org.eclipse.emf.query2.internal.logger.TraceContext;
import org.eclipse.emf.query2.internal.plugin.QueryPlugin;


/**
 * The Logger implementation
 */
public class LoggerImpl implements QueryLogger {

	private static final boolean DEBUG;

	private static final boolean ERROR;

	private static final boolean FATAL;

	private static final boolean INFO;

	private static final boolean PATH;

	private static final boolean WARNING;

	static {
		DEBUG = Boolean.parseBoolean(Platform
				.getDebugOption("org.eclipse.emf.query2/trace/severity/debug"));
		ERROR = Boolean.parseBoolean(Platform
				.getDebugOption("org.eclipse.emf.query2/trace/severity/error"));
		FATAL = Boolean.parseBoolean(Platform
				.getDebugOption("org.eclipse.emf.query2/trace/severity/fatal"));
		INFO = Boolean.parseBoolean(Platform
				.getDebugOption("org.eclipse.emf.query2/trace/severity/info"));
		PATH = Boolean.parseBoolean(Platform
				.getDebugOption("org.eclipse.emf.query2/trace/severity/path"));
		WARNING = Boolean
				.parseBoolean(Platform
						.getDebugOption("org.eclipse.emf.query2/trace/severity/warning"));
	}

	private static final String LINEBREAK = "\n"; //$NON-NLS-1$

	private final static String ASSERT_NUMPARS = "Number of message parameters doesn't match number of arguments"; //$NON-NLS-1$

	private final static String ASSERT_NOEX = "Exceptions can not be used as message parameter"; //$NON-NLS-1$

	private StringBuffer subLocationName;

	private StringBuffer msgPrefix;

	private Logger logger;
	
	/**
	 * @param category
	 * @param location
	 * @param subLocation
	 */
	public LoggerImpl(StringBuffer subLocation) {
		this.subLocationName = subLocation;
		this.msgPrefix = new StringBuffer(
				"[EMF Query: " + this.subLocationName + "]"); //$NON-NLS-1$//$NON-NLS-2$
		this.logger = QueryPlugin.getPlugin();
	}

	private boolean beTraced(LogSeverity severity) {
		switch (severity) {
		case DEBUG:
			return DEBUG;
		case ERROR:
			return ERROR;
		case FATAL:
			return FATAL;
		case INFO:
			return INFO;
		case PATH:
			return PATH;
		case WARNING:
			return WARNING;
		default:
			throw new IllegalArgumentException(severity.toString());
		}
	}

	private synchronized StringBuffer getObjectContext(Object currObject) {

		Class<? extends Object> currClass = currObject.getClass();

		return inspectDeclaredFields(currClass, currObject);
	}

	private StringBuffer inspectDeclaredFields(
			Class<? extends Object> currClass, Object origObject) {

		Field[] declaredFields = currClass.getDeclaredFields();
		StringBuffer msg = new StringBuffer();

		for (int i = 0; i < declaredFields.length; i++) {
			if ((Modifier.STATIC & declaredFields[i].getModifiers()) != 0) {
				msg.append(inspectStrings(declaredFields[i], origObject));
			}

			if (declaredFields[i].getName().startsWith("this$")) { //$NON-NLS-1$
				// ignore this pointer for inner classes - check this
				// functionality
				continue;
			}

			if (!declaredFields[i].getType().isPrimitive()) {
				msg.append(inspectStrings(declaredFields[i], origObject));
			}
		}
		return msg;
	}

	private StringBuffer inspectStrings(Object currObject, Object origObject) {

		if (currObject != null) {
			Class<? extends Object> currClass = currObject.getClass();

			if (currObject instanceof Field) {
				try {
					if (((Field) currObject).isAccessible()) {
						this.inspectStrings(((Field) currObject)
								.get(origObject), origObject);
					} else {
						// JLin does not allow us to use setAccessible
					}
				} catch (Exception e) {
					e.printStackTrace(System.out);
				}

			} else if (currObject instanceof String) {
				return new StringBuffer(currClass.getName()
						+ ": " + currObject.toString() + LINEBREAK); //$NON-NLS-1$
			}
		}
		return null;
	}

	public void trace(LogSeverity severity, ExternalizedString message,
			Object... args) {

		this.trace(severity, message.format(), args);
	}

	public void trace(Throwable exception, LogSeverity severity,
			ExternalizedString message, Object... args) {

		this.traceInternal(severity, message.format(), args, null, exception);
	}

	public void trace(LocalizedBaseException exception, LogSeverity severity) {

		this.traceInternal(severity, exception.getMessage(), null, null,
				exception);
	}

	public void trace(LocalizedBaseRuntimeException exception,
			LogSeverity severity) {

		this.traceInternal(severity, exception.getMessage(), null, null,
				exception);
	}

	public void trace(Throwable throwable, LogSeverity severity,
			String message, Object... args) {

		if (this.beTraced(severity)) {
			traceInternal(severity, message, args, null, throwable);
		}
	}

	public void trace(Throwable throwable, TraceContext context,
			LogSeverity severity, ExternalizedString message, Object... args) {

		if (this.beTraced(severity)) {
			traceInternal(severity, message.format(), args, new StringBuffer(
					context.getMessage()), throwable);
		}
	}

	public void trace(Throwable throwable, Object context,
			LogSeverity severity, ExternalizedString message, Object... args) {

		if (this.beTraced(severity)) {
			traceInternal(severity, message.format(), args,
					getObjectContext(context), throwable);
		}
	}

	public void trace(LogSeverity severity, String message, Object... args) {

		if (this.beTraced(severity)) {
			traceInternal(severity, message, args, null, null);
		}
	}

	private int convertSeverity(LogSeverity severity) {
		switch (severity) {
		case DEBUG: return IStatus.INFO;
		case ERROR: return IStatus.ERROR;
		case FATAL: return IStatus.ERROR;
		case INFO: return IStatus.INFO;
		case PATH: return IStatus.INFO;
		case WARNING: return IStatus.WARNING;
			default: throw new IllegalArgumentException(String.valueOf(severity));
		}
	}
	
	private void traceInternal(LogSeverity severity, String message,
			Object[] args, StringBuffer msgContext, Throwable throwable) {

//		LogRecord record = null;

		assert (parameterCountOk(message, args)) : ASSERT_NUMPARS;
		assert (parameterNoExceptions(args)) : ASSERT_NOEX;
		
		StringBuilder msg = new StringBuilder(this.msgPrefix).append(MessageFormat.format(message, args));
		if (msgContext != null) {
			msg.append(LINEBREAK).append(msgContext);
		}
		
		IStatus status = new Status(this.convertSeverity(severity),QueryPlugin.ID,msg.toString(), throwable);
		
		this.logger.log(status);
		
//		if (throwable == null) {
//			if (msgContext == null) {
//				record = this.trace.logT(severity, this.msgPrefix + message,
//						args);
//			} else {
//				record = this.trace.logT(severity, this.msgPrefix + message
//						+ LINEBREAK + msgContext, args);
//			}
//		} else {
//			if (msgContext == null) {
//				record = this.trace.traceThrowableT(severity, this.msgPrefix
//						+ message, args, throwable);
//				if (LoggerFactory.throwRuntimeException) {
//					if (throwable instanceof RuntimeException) {
//						throw (RuntimeException) throwable;
//					}
//					if (severity == LogSeverity.FATAL
//							|| severity == LogSeverity.ERROR) {
//						throw new RuntimeException(this.msgPrefix + message,
//								throwable);
//					}
//				}
//			} else {
//				record = this.trace.traceThrowableT(severity, this.msgPrefix
//						+ message + LINEBREAK + msgContext, args, throwable);
//				if (LoggerFactory.throwRuntimeException) {
//					if (throwable instanceof RuntimeException) {
//						throw (RuntimeException) throwable;
//					}
//					if (severity == LogSeverity.FATAL
//							|| severity == LogSeverity.ERROR) {
//						throw new RuntimeException(this.msgPrefix + message
//								+ LINEBREAK + msgContext, throwable);
//					}
//				}
//			}
//		}
	}

	public boolean isTraced(LogSeverity severity) {

		return this.beTraced(severity);
	}

	public void traceWithStack(LogSeverity severity, String message,
			Object... args) {

		if (this.beTraced(severity)) {
			StackTraceElement[] actStack = Thread.currentThread()
					.getStackTrace();
			StringBuilder extMsg = new StringBuilder(message);
			extMsg.append("\nStack Dump of current Thread:"); //$NON-NLS-1$
			for (int i = 0; i < actStack.length; i++) {
				extMsg.append("\n\tat " + actStack[i]); //$NON-NLS-1$
			}
			this.trace(severity, extMsg.toString(), args);
		}
	}

	public void traceWithStack(LogSeverity severity,
			ExternalizedString message, Object... args) {

		traceWithStack(severity, message.toString(), args);
	}

	private boolean parameterCountOk(String pattern, Object... args) {

		int count = 0;
		int lastIndex = 0;
		int lastLeftIndex = 0;
		int index = pattern.indexOf('{', lastLeftIndex);
		int arglength = 0;
		if (args != null) {
			arglength = args.length;
		}

		Set<Integer> intSet = new HashSet<Integer>();
		// there might be {} that are not intended for parameter replacement (do
		// not have an Integer in between)

		while (index >= 0) {
			int rightIndex = pattern.indexOf('}', index);
			String inbetween;
			try {
				inbetween = pattern.substring(index + 1, rightIndex);
				Integer parIndex = new Integer(inbetween);
				if (intSet.add(parIndex)) {
					count++;
				}
			} catch (Exception e) {
				// $JL-EXC$ we just want to check the inbetween
			}
			lastLeftIndex = index + 1;
			index = pattern.indexOf('{', lastLeftIndex);
		}

		return count == arglength;
	}

	private boolean parameterNoExceptions(Object... args) {

		if (args != null) {

			for (Object arg : args) {
				if (arg instanceof Throwable) {
					return false;
				}
			}
		}
		return true;
	}

	public void trace(LogSeverity sev, String message, Throwable e) {

		traceInternal(sev, message, new Object[0], null, e);

	}
}
