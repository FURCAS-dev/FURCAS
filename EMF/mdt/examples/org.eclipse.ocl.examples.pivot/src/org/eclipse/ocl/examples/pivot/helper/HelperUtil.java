/**
 * <copyright>
 *
 * Copyright (c) 2002, 2008 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Refactoring to support extensibility and flexible error handling 
 *
 * </copyright>
 *
 * $Id: HelperUtil.java,v 1.3 2011/02/11 20:00:29 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.helper;

import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.util.PivotPlugin;

/**
 * Utility class in support of the implementation of the {@link OCLHelper}
 * API, also responsible for the creation of {@link OCLHelper}s.
 * 
 * @author Yasser Lulu 
 * @author Christian W. Damus (cdamus)
 */
public class HelperUtil {

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

	/** Not instantiable by clients. */
	private HelperUtil() {
		super();
	}

	/**
	 * Creates an {@link OCLHelper} for the specified EMF metamodel.  The
	 * factory creates OCL environments (with the packages, classifiers, states,
	 * etc.) from the instances of the metaclasses that mimic OCL/UML
	 * classifiers.
	 * <p>
	 * The new helper validates the OCL expressions that it parses.
	 * </p>
	 * 
	 * @param ocl the metamodel-specific OCL environment	
	 * 
	 * @return the new OCL helper
	 */
//	public static OCLHelper createOCLHelper(OCLBase ocl) {
//		return new OCLBaseHelperImpl(ocl);
//	}

	/**
	 * convenience method for serviceability support tracing exceptions thrown
	 * @param exception the exception to be thrown
	 * @param clazz the metaclass of the java object that owns the method
	 * @param methodName the method that threw the exception
	 */
	static void throwException(RuntimeException exception, Class<?> clazz,
		String methodName) {
		PivotPlugin.throwing(clazz, methodName, exception);
		throw exception;
	}

	/**
	 * convenience method for serviceability support tracing exceptions caught
	 * @param exception the exception to be caught
	 * @param clazz the metaclass of the java object that owns the method
	 * @param methodName the method that caught the exception
	 */
	static void catchException(Exception exception, Class<?> clazz,
		String methodName) {
		PivotPlugin.catching(clazz, methodName, exception);
	}
	
	public static
	Object getConstraintContext(
			Environment env,
			Object element,
			OclExpression expr) {
		
		Object result = element;

/*		if (expr.eContainer() instanceof ExpressionInOcl) {
			ExpressionInOcl specification = (ExpressionInOcl) expr.eContainer();
			
			Variable contextVariable = specification.getContextVariable();
			if (contextVariable != null) {
				Type contextClassifier = contextVariable.getType();
				
				if ((contextClassifier != null) && env.getUMLReflection().isStereotype(
						contextClassifier)) {
					
					Object application = env.getUMLReflection().getStereotypeApplication(
							element, contextClassifier);
					
					if (application != null) {
						result = application;
					}
				}
			}
		} */
		
		return result;
	}
	public static
	Object getConstraintContext(Environment env, Object element, ExpressionInOcl expr) {		
		throw new UnsupportedOperationException();
/*		Object result = element;
		Variable contextVariable = expr.getContextVariable();
		if (contextVariable != null) {
			Type contextClassifier = contextVariable.getType();			
			if ((contextClassifier != null) && env.getUMLReflection().isStereotype(
					contextClassifier)) {				
				Object application = env.getUMLReflection().getStereotypeApplication(
						element, contextClassifier);				
				if (application != null) {
					result = application;
				}
			}
		}
		return result; */
	}
}