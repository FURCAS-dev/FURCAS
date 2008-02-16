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
 * $Id: HelperUtil.java,v 1.6 2008/02/16 00:07:22 cdamus Exp $
 */

package org.eclipse.ocl.internal.helper;

import java.io.LineNumberReader;
import java.io.StringReader;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.internal.OCLPlugin;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.options.ParsingOptions;
import org.eclipse.ocl.parser.OCLAnalyzer;
import org.eclipse.ocl.parser.ValidationVisitor;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.ObjectUtil;
import org.eclipse.ocl.utilities.ASTNode;
import org.eclipse.ocl.utilities.ExpressionInOCL;

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
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	OCLHelper<C, O, P, CT>
	createOCLHelper(OCL<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> ocl) {
		
		return new OCLHelperImpl<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(ocl);
	}

	/**
	 * convenience method for serviceability support tracing exceptions thrown
	 * @param exception the exception to be thrown
	 * @param clazz the metaclass of the java object that owns the method
	 * @param methodName the method that threw the exception
	 */
	static void throwException(RuntimeException exception, Class<?> clazz,
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
	static void catchException(Exception exception, Class<?> clazz,
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
	
	static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	OCLExpression<C> parseQuery(
			OCLHelperImpl<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> helper,
			String expression,
			boolean validate,
            boolean trace) throws ParserException {
		
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env = helper.getEnvironment();
		
		OCLAnalyzer<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> analyzer =
			createAnalyzer(env, "inv:", expression, trace); //$NON-NLS-1$
		
		CT constraint = analyzer.parseInvOrDefCS();
		checkForErrors(helper);
		
		ExpressionInOCL<C, PM> spec = env.getUMLReflection().getSpecification(constraint);
		OCLExpression<C> result = spec.getBodyExpression();
		
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
	}

	static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	CT parseInvariant(
			OCLHelperImpl<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> helper,
			String expression,
			boolean validate,
            boolean trace) throws ParserException {
		
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env = helper.getEnvironment();
		
		OCLAnalyzer<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> analyzer =
			createAnalyzer(env, "inv:", expression, trace); //$NON-NLS-1$
		
		CT result = analyzer.parseInvOrDefCS();
		checkForErrors(helper);
		
		if (validate) {
			validate(env, result);
		}
		
		finishAnalyzing(helper);
		
		persist(helper, result);
		
		return result;
	}

	static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	CT parsePrecondition(
			OCLHelperImpl<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> helper,
			String expression,
			boolean validate,
            boolean trace) throws ParserException {
		
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env = helper.getEnvironment();
		
		OCLAnalyzer<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> analyzer =
			createAnalyzer(env, "pre:", expression, trace); //$NON-NLS-1$
		
		CT result = analyzer.parsePrePostOrBodyDeclCS();
		checkForErrors(helper);
		
		if (validate) {
			validate(env, result);
		}
		
		finishAnalyzing(helper);
		
		persist(helper, result);
		
		return result;
	}
	
	static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	CT parsePostcondition(
			OCLHelperImpl<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> helper,
			String expression,
			boolean validate,
            boolean trace) throws ParserException {
		
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env = helper.getEnvironment();
		
		OCLAnalyzer<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> analyzer =
			createAnalyzer(env, "post:", expression, trace); //$NON-NLS-1$
		
		CT result = analyzer.parsePrePostOrBodyDeclCS();
		checkForErrors(helper);
		
		if (validate) {
			validate(env, result);
		}
		
		finishAnalyzing(helper);
		
		persist(helper, result);
		
		return result;
	}
	
	static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	CT parseBodyCondition(
			OCLHelperImpl<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> helper,
			String expression,
			boolean validate,
            boolean trace) throws ParserException {
		
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env = helper.getEnvironment();
		
		OCLAnalyzer<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> analyzer =
			createAnalyzer(env, "body:", expression, trace); //$NON-NLS-1$
		
		CT result = analyzer.parsePrePostOrBodyDeclCS();
		checkForErrors(helper);
		
		if (validate) {
			validate(env, result);
		}
		
		finishAnalyzing(helper);
		
		persist(helper, result);
		
		return result;
	}
	
	static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	CT parseInitialValueExpression(
			OCLHelperImpl<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> helper,
			String expression,
			boolean validate,
            boolean trace) throws ParserException {
		
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env = helper.getEnvironment();
		
		OCLAnalyzer<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> analyzer =
			createAnalyzer(env, "init:", expression, trace); //$NON-NLS-1$
		
		CT result = analyzer.parseInitOrDerValueCS();
		checkForErrors(helper);
		
		if (validate) {
			validate(env, result);
		}
		
		finishAnalyzing(helper);
		
		persist(helper, result);
		
		return result;
	}
	
	static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	CT parseDerivedValueExpression(
			OCLHelperImpl<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> helper,
			String expression,
			boolean validate,
            boolean trace) throws ParserException {
		
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env = helper.getEnvironment();
		
		OCLAnalyzer<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> analyzer =
			createAnalyzer(env, "derive:", expression, trace); //$NON-NLS-1$
		
		CT result = analyzer.parseInitOrDerValueCS();
		checkForErrors(helper);
		
		if (validate) {
			validate(env, result);
		}
		
		finishAnalyzing(helper);
		
		persist(helper, result);
		
		return result;
	}
	
	static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	CT parseDefExpression(
			OCLHelperImpl<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> helper,
			String defExpression,
			boolean validate,
            boolean trace) throws ParserException {
		
		Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env = helper.getEnvironment();
		
		OCLAnalyzer<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> analyzer =
			createAnalyzer(env, "def:", defExpression, trace); //$NON-NLS-1$
		
		// we want to make the defined feature available.  This is OK, since
		// the constraint will be discarded anyway
		analyzer.getEnvironment().setOption(
		    ParsingOptions.DEFINITION_CONSTRAINS_FEATURE, true);
		
		CT result = analyzer.parseInvOrDefCS();
		checkForErrors(helper);
		
		if (validate) {
			validate(env, result);
		}
		
		finishAnalyzing(helper);
		
		persist(helper, result);
		
		return result;
	}

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
	 */
	private static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	OCLAnalyzer<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	createAnalyzer(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			String prefix,	String text,
            boolean trace) {
		
		OCLAnalyzer<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
		result = new OCLAnalyzer<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>(
				env, (prefix + '\n' + text));
		
		// we prefix the constraint with "inv:", "pre:", "def:", etc. which the
		//    user cannot see, so we want error reporting to be relative
		//    to line 0, not line 1.  Also, clear any old diagnostics
		ProblemHandler ph = OCLUtil.getAdapter(env, ProblemHandler.class);
		if (ph != null) {
			ph.setErrorReportLineOffset(-1);
			ph.beginParse();
		}
		
		// offset the character position by the length of the extra text
		result.setCharacterOffset(-(prefix.length() + 1)); // one for the newline
		
		result.setTraceFlag(trace);
		
		return result;
	}

	/**
	 * Completes an environment's parsing session.
	 * 
	 * @param helper the helper implementation
	 */
	private static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	void finishAnalyzing(OCLHelperImpl<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> helper)
	throws ParserException {
		
		ProblemHandler ph = OCLUtil.getAdapter(helper.getEnvironment(),
			ProblemHandler.class);
		if (ph != null) {
			ph.endParse();
		}
		
		checkForErrors(helper);
	}
	
	private static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	void validate(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			OCLExpression<C> expression) throws ParserException {
		
		expression.accept(ValidationVisitor.getInstance(env));
	}
	
	private static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	void validate(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			CT constraint) throws ParserException {
		
		ValidationVisitor.getInstance(env).visitConstraint(constraint);
	}
	
	private static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	void persist(
	        OCLHelperImpl<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> helper,
			CT constraint) {
		
		EObject constraintEObject = (EObject) constraint;
		
		if (constraintEObject.eResource() == null) {
			helper.getEnvironment().getTypeResolver().getResource().getContents().add(
			    constraintEObject);
		}
		
		helper.getOCL().getConstraints().add(constraint);
	}
	
	private static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	void persist(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			ASTNode astNode) {
		
		if (astNode.eResource() == null) {
			env.getTypeResolver().getResource().getContents().add(astNode);
		}
	}
	
	public static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	Object getConstraintContext(
			Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env,
			Object element,
			OCLExpression<C> expr) {
		
		Object result = element;

		if (expr.eContainer() instanceof ExpressionInOCL) {
			@SuppressWarnings("unchecked")
			ExpressionInOCL<C, PM> specification =
				(ExpressionInOCL<C, PM>) expr.eContainer();
			
			Variable<C, PM> contextVariable = specification.getContextVariable();
			if (contextVariable != null) {
				C contextClassifier = contextVariable.getType();
				
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
	
	private static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	void checkForErrors(
			OCLHelperImpl<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> helper)
		throws ParserException {
		
		try {
			helper.setProblems(OCLUtil.checkForErrors(helper.getEnvironment()));
		} catch (ParserException e) {
			helper.setProblems(e.getDiagnostic());
			throw e;
		}
	}
}