/******************************************************************************
 * Copyright (c) 2002, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.ocl.helper;

import java.io.LineNumberReader;
import java.io.StringReader;

import org.eclipse.emf.ocl.internal.OclEnginePlugin;
import org.eclipse.emf.ocl.parser.EnvironmentFactory;

/**
 * Factory class for the creation of {@link IOclHelper}s.  Clients should use
 * the {@link #createOclHelper(ModelingLevel)} method to obtain OCL helpers.
 * 
 * @author Yasser Lulu 
 * @author Christian W. Damus (cdamus)
 */
public class HelperUtil {

	private HelperUtil() {
		//private;
	}

	/**
	 * Creates an {@link IOclHelper} for the Ecore metamodel.
	 *  
	 * @return a new Ecore OCL helper
	 */
	public static IOclHelper createOclHelper() {
		return createOclHelper(EnvironmentFactory.ECORE_INSTANCE);
	}
	
	/**
	 * Creates an {@link IOclHelper} for the specified EMF metamodel.  The
	 * factory creates OCL environments (with the packages, classifiers, states,
	 * etc.) from the instances of the metaclasses that mimic OCL/UML
	 * classifiers.
	 * 
	 * @return the new OCL helper
	 * 
	 * @param factory the metamodel-specific OCL environment factory	
	 */
	public static IOclHelper createOclHelper(EnvironmentFactory factory) {
		return new OclHelper(factory);
	}

	static final int NONE = -1;

	static final String OCL_COMMENT = "--"; //$NON-NLS-1$

	static final String PATH_DELIMETER = "(=> "; //$NON-NLS-1$

	static final String PACKAGE = "package"; //$NON-NLS-1$

	static final String COLON = ":"; //$NON-NLS-1$

	static final String DOUBLE_COLON = "::"; //$NON-NLS-1$    

	static final String DOT = "."; //$NON-NLS-1$    

	static final String ARROW = "->"; //$NON-NLS-1$

	static final String VOID = " : void"; //$NON-NLS-1$

	static final String OPEN_PARENTHESE = "("; //$NON-NLS-1$

	static final String CLOSE_PARENTHESE = ")"; //$NON-NLS-1$    

	static final String SEPARATOR = " : "; //$NON-NLS-1$

	static final String COMMA = ", "; //$NON-NLS-1$

	static final String SPACE = " "; //$NON-NLS-1$

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
		OclEnginePlugin.throwing(clazz, methodName, exception);
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
		OclEnginePlugin.catching(clazz, methodName, exception);
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