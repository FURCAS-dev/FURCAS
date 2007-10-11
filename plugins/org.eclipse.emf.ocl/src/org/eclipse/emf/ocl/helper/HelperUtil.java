/**
 * <copyright>
 *
 * Copyright (c) 2002, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */

package org.eclipse.emf.ocl.helper;

import java.io.LineNumberReader;
import java.io.StringReader;

import org.eclipse.emf.ocl.internal.OCLPlugin;
import org.eclipse.emf.ocl.parser.EnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;

/**
 * Factory class for the creation of {@link IOCLHelper}s.  Clients should use
 * the {@link #createOCLHelper()} or {@link #createOCLHelper(EnvironmentFactory)}
 * method to obtain OCL helpers.
 * 
 * @deprecated Use the {@link OCL} class, instead, to create
 * {@link org.eclipse.ocl.helper.OCLHelper}s.
 * 
 * @author Yasser Lulu 
 * @author Christian W. Damus (cdamus)
 */
@Deprecated
public class HelperUtil {

	private HelperUtil() {
		//private;
	}

	/**
	 * Creates an {@link IOCLHelper} for the Ecore metamodel.
	 *  
	 * @return a new Ecore OCL helper
	 */
	public static IOCLHelper createOCLHelper() {
		return createOCLHelper(EnvironmentFactory.ECORE_INSTANCE);
	}
	
	/**
	 * Creates an {@link IOCLHelper} for the specified EMF metamodel.  The
	 * factory creates OCL environments (with the packages, classifiers, states,
	 * etc.) from the instances of the metaclasses that mimic OCL/UML
	 * classifiers.
	 * 
	 * @return the new OCL helper
	 * 
	 * @param factory the metamodel-specific OCL environment factory	
	 */
	public static IOCLHelper createOCLHelper(EnvironmentFactory factory) {
		return new OCLHelper(factory);
	}

	static final int NONE = -1;

	static final String OCL_COMMENT = "--"; //$NON-NLS-1$

	static final String PATH_DELIMETER = "(=> "; //$NON-NLS-1$

	static final String PACKAGE = "package"; //$NON-NLS-1$

	static final String COLON = ":"; //$NON-NLS-1$

	static final String DOUBLE_COLON = "::"; //$NON-NLS-1$    

	static final String DOT = "."; //$NON-NLS-1$    

	static final String ARROW = "->"; //$NON-NLS-1$
	
	static final String CARET = "^"; //$NON-NLS-1$
	
	static final String DOUBLE_CARET = "^^"; //$NON-NLS-1$

	static final String EMPTY = ""; //$NON-NLS-1$

	static final String HTTP = "http://"; //$NON-NLS-1$	

	/**
	 * convenience method for serviceability support tracing exceptions thrown
	 * @param exception the exception to be thrown
	 * @param clazz the metaclass of the java object that owns the method
	 * @param methodName the method that threw the exception
	 */
	static void throwException(RuntimeException exception, Class clazz,
		String methodName) {
		OCLPlugin.throwing(clazz, methodName, exception);
		throw exception;
	}

	/**
	 * convenience method for serviceability support tracing exceptions caught
	 * @param exception the exception to be caught
	 * @param clazz the metaclass of the java object that owns the method
	 * @param methodName the method that caught the exception
	 */
	static void catchException(Exception exception, Class clazz,
		String methodName) {
		OCLPlugin.catching(clazz, methodName, exception);
	}

	/**
	 * combines several physical non-commented lines into one logical line by
	 * removing white spaces and embedded comments 
	 * @param txt the string we got from client that contains the ocl expression
	 * @return String the non-commented lines of the input concatenated as one 
	 * @throws Exception if while traversing the string something went wrong 
	 * mainly to account for (IOException)
	 */
	static String getLogicalLine(String txt) throws Exception {
		LineNumberReader reader = new LineNumberReader(new StringReader(txt
			.trim()));
		String logicalLine = EMPTY;
		int embeddedCommnetIndex = HelperUtil.NONE;
		String line = reader.readLine();
		while (line != null) {
			line = line.trim();
			if (line.startsWith(HelperUtil.OCL_COMMENT) == false) {
				// safe to search for index of "--" which consists of BMP code points
				embeddedCommnetIndex = line.indexOf(HelperUtil.OCL_COMMENT);
				if (embeddedCommnetIndex != HelperUtil.NONE) {
					line = line.substring(0, embeddedCommnetIndex);
					line = line.trim();
				}
				logicalLine = logicalLine + line + ' ';
			}
			line = reader.readLine();
		}
		return logicalLine;
	}
}