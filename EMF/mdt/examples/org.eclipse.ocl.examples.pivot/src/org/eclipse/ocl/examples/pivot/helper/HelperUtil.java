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
 * $Id: HelperUtil.java,v 1.2 2011/01/24 20:47:53 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.helper;

import java.io.LineNumberReader;
import java.io.StringReader;

import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
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
	
/*	static OclExpression parseQuery(
			OCLHelperImpl helper,
			String expression,
			boolean validate,
            boolean trace) throws ParserException {
		
		Environment env = helper.getEnvironment();
		
		OCLAnalyzer analyzer =
			createAnalyzer(env, "inv:", expression, trace); //$NON-NLS-1$
		
		Constraint constraint = analyzer.parseInvOrDefCS();
		checkForErrors(helper);
		
		ExpressionInOcl spec = env.getUMLReflection().getSpecification(constraint);
		OclExpression result = spec.getBodyExpression();
		
		// this is not a constraint
		env.getUMLReflection().setSpecification(constraint, null);
		spec.setBodyExpression(null);
        
		if (validate) {
			validate(env, result);
		}
		
		finishAnalyzing(helper);
		
		// re-persist the "self" variable that we temporarily stole away from
		//    the environment, in the ExpressionInOCL.  In a query expression,
		//    there won't be other variables (result, parameters) to worry about
		persist(env, spec.getContextVariable());
		
		// persist the expression
		persist(env, result);
		
		// dispose the remainder of the constraint
		ObjectUtil.dispose(constraint);
		
		return result;
	} */

/*	static
	Constraint parseInvariant(
			OCLHelperImpl helper,
			String expression,
			boolean validate,
            boolean trace) throws ParserException {
		
		Environment env = helper.getEnvironment();
		
		OCLAnalyzer analyzer =
			createAnalyzer(env, "inv:", expression, trace); //$NON-NLS-1$
		
		Constraint result = analyzer.parseInvOrDefCS();
		checkForErrors(helper);
		
		if (validate) {
			validate(env, result);
		}
		
		finishAnalyzing(helper);
		
		persist(helper, result);
		
		return result;
	} */

/*	static
	Constraint parsePrecondition(
			OCLHelperImpl helper,
			String expression,
			boolean validate,
            boolean trace) throws ParserException {
		
		Environment env = helper.getEnvironment();
		
		OCLAnalyzer analyzer =
			createAnalyzer(env, "pre:", expression, trace); //$NON-NLS-1$
		
		Constraint result = analyzer.parsePrePostOrBodyDeclCS();
		checkForErrors(helper);
		
		if (validate) {
			validate(env, result);
		}
		
		finishAnalyzing(helper);
		
		persist(helper, result);
		
		return result;
	} */
	
/*	static
	Constraint parsePostcondition(
			OCLHelperImpl helper,
			String expression,
			boolean validate,
            boolean trace) throws ParserException {
		
		Environment env = helper.getEnvironment();
		
		OCLAnalyzer analyzer =
			createAnalyzer(env, "post:", expression, trace); //$NON-NLS-1$
		
		Constraint result = analyzer.parsePrePostOrBodyDeclCS();
		checkForErrors(helper);
		
		if (validate) {
			validate(env, result);
		}
		
		finishAnalyzing(helper);
		
		persist(helper, result);
		
		return result;
	} */
	
/*	static
	Constraint parseBodyCondition(
			OCLHelperImpl helper,
			String expression,
			boolean validate,
            boolean trace) throws ParserException {
		
		Environment env = helper.getEnvironment();
		
		OCLAnalyzer analyzer =
			createAnalyzer(env, "body:", expression, trace); //$NON-NLS-1$
		
		Constraint result = analyzer.parsePrePostOrBodyDeclCS();
		checkForErrors(helper);
		
		if (validate) {
			validate(env, result);
		}
		
		finishAnalyzing(helper);
		
		persist(helper, result);
		
		return result;
	} */
	
/*	static
	Constraint parseInitialValueExpression(
			OCLHelperImpl helper,
			String expression,
			boolean validate,
            boolean trace) throws ParserException {
		
		Environment env = helper.getEnvironment();
		
		OCLAnalyzer analyzer =
			createAnalyzer(env, "init:", expression, trace); //$NON-NLS-1$
		
		Constraint result = analyzer.parseInitOrDerValueCS();
		checkForErrors(helper);
		
		if (validate) {
			validate(env, result);
		}
		
		finishAnalyzing(helper);
		
		persist(helper, result);
		
		return result;
	} */
	
/*	static
	Constraint parseDerivedValueExpression(
			OCLHelperImpl helper,
			String expression,
			boolean validate,
            boolean trace) throws ParserException {
		
		Environment env = helper.getEnvironment();
		
		OCLAnalyzer analyzer =
			createAnalyzer(env, "derive:", expression, trace); //$NON-NLS-1$
		
		Constraint result = analyzer.parseInitOrDerValueCS();
		checkForErrors(helper);
		
		if (validate) {
			validate(env, result);
		}
		
		finishAnalyzing(helper);
		
		persist(helper, result);
		
		return result;
	} */
	
/*	static
	Constraint parseDefExpression(
			OCLHelperImpl helper,
			String defExpression,
			boolean validate,
            boolean trace) throws ParserException {
		
		Environment env = helper.getEnvironment();
		
		OCLAnalyzer analyzer =
			createAnalyzer(env, "def:", defExpression, trace); //$NON-NLS-1$
		
		// we want to make the defined feature available.  This is OK, since
		// the constraint will be discarded anyway
		analyzer.getEnvironment().setOption(
		    ParsingOptions.DEFINITION_CONSTRAINS_FEATURE, true);
		
		Constraint result = analyzer.parseInvOrDefCS();
		checkForErrors(helper);
		
		if (validate) {
			validate(env, result);
		}
		
		finishAnalyzing(helper);
		
		persist(helper, result);
		
		return result;
	} */

	/**
	 * Initializes an analyzer on the specified <code>text</code> and environment
	 * factory.
	 * 
	 * @param prefix the constraint prefix (e.g., <code>"inv:"</code> or
	 *     <code>"pre:"</code>).  The prefix must not contain newlines
	 * @param environmentFactory the analyzer's environment factory
	 * @param text the OCL constraint text
	 * @param trace whether to trace the parsing
     * 
	 * @return the analyzer
	 *
	private static
	OCLAnalyzer
	createAnalyzer(
			Environment env,
			String prefix,	String text,
            boolean trace) {
		
		// we prefix the constraint with "inv:", "pre:", "def:", etc. which the
		//    user cannot see, so we want error reporting to be relative
		//    to line 0, not line 1.  Also, clear any old diagnostics
		ProblemHandler ph = OCLUtil.getAdapter(env, ProblemHandler.class);
		if (ph != null) {
			ph.setErrorReportLineOffset(-1);
			ph.beginParse();
		}
		
		OCLAnalyzer
		result = new OCLAnalyzer(
				env, (prefix + '\n' + text));
		
		// offset the character position by the length of the extra text
		result.setCharacterOffset(-(prefix.length() + 1)); // one for the newline
		
		result.setTraceFlag(trace);
		
		return result;
	} */
	
	public static
	Object getConstraintContext(
			Environment env,
			Object element,
			OclExpression expr) {
		
		Object result = element;

		if (expr.eContainer() instanceof ExpressionInOcl) {
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
		}
		
		return result;
	}
	public static
	Object getConstraintContext(Environment env, Object element, ExpressionInOcl expr) {		
		Object result = element;
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
		return result;
	}
}