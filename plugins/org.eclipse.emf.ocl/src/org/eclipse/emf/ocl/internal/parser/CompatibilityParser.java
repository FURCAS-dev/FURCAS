/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: CompatibilityParser.java,v 1.3 2007/10/11 23:05:17 cdamus Exp $
 */
package org.eclipse.emf.ocl.internal.parser;

import java.util.List;

import lpg.lpgjavaruntime.IToken;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.emf.ocl.parser.EcoreEnvironment;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.EnvironmentFactory;
import org.eclipse.emf.ocl.parser.ParserException;
import org.eclipse.emf.ocl.parser.SemanticException;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.parser.AbstractOCLAnalyzer;
import org.eclipse.ocl.parser.OCLAnalyzer;
import org.eclipse.ocl.parser.OCLProblemHandler;

/**
 * 
 *
 * @author Christian W. Damus (cdamus)
 */
public class CompatibilityParser {
	private final org.eclipse.ocl.EnvironmentFactory<
		EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
		EClass, EObject> environmentFactory;
	
	private final org.eclipse.ocl.Environment<
		EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
		EClass, EObject> root;

	private OCLAnalyzer<EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
		EClass, EObject> parser;
	
	private String text;
	
	private int lineOff, characterOff;
	private boolean trace;
	
	public CompatibilityParser(String text) {
		this(text, EnvironmentFactory.ECORE_INSTANCE);
	}
	
	public CompatibilityParser(String text, EnvironmentFactory factory) {
		this.text = text;
		environmentFactory = CompatibilityUtil.getCompatibilityFactory(factory);
		root = environmentFactory.createEnvironment();
	}
	
	/**
	 * Hub for all semantic parsing messages -- 
	 * Should be changed if want to continue parsing, and not terminate
	 * on first exception.
	 */
	public static void ERR(String message) throws SemanticException {
		throw new SemanticException(message);
	}
	
	public final EList parsePackageDeclarationCS(EList constraints) throws ParserException {
		OCLAnalyzer<EPackage, EClassifier, EOperation, EStructuralFeature,
				EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
				EClass, EObject>
		parser = new OCLAnalyzer<
			EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject>(root, text);
		
		List<Constraint> parsed = parser.parsePackageDeclarationCS(constraints);
		checkForErrors(parser);
		
		EList result = CompatibilityUtil.getOldAS(
				new EcoreEnvironment(EcorePackage.eINSTANCE),
				parsed);
		ECollections.setEList(constraints, result);
		return constraints;
	}
	
	public org.eclipse.emf.ocl.uml.Constraint parseInvOrDefCS(Environment env)
			throws ParserException {
		
		Constraint result = getParser(env).parseInvOrDefCS();
		checkForErrors(getParser(env));
		
		return (org.eclipse.emf.ocl.uml.Constraint) CompatibilityUtil.getOldAS(
			env, result);
	}
	
	public org.eclipse.emf.ocl.uml.Constraint parsePrePostOrBodyDeclCS(Environment env, EOperation operation)
			throws ParserException {
		
		Constraint result = getParser(env).parsePrePostOrBodyDeclCS();
		checkForErrors(getParser(env));
		
		return (org.eclipse.emf.ocl.uml.Constraint) CompatibilityUtil.getOldAS(
			env, result);
	}
	
	public org.eclipse.emf.ocl.uml.Constraint parseInitOrDerValueCS(Environment env, EStructuralFeature property)
			throws ParserException {
		Constraint result = getParser(env).parseInitOrDerValueCS();
		checkForErrors(getParser(env));
		
		return (org.eclipse.emf.ocl.uml.Constraint) CompatibilityUtil.getOldAS(
			env, result);
	}
	
	public Variable parseVariableDeclarationCS(Environment env, boolean addToEnvironment)
			throws ParserException {
		
		org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> result =
			getParser(env).parseVariableDeclarationCS(addToEnvironment);
		checkForErrors(getParser(env));
		
		return (Variable) CompatibilityUtil.getOldAS(
			env, result);
	}
	
	public void setErrorReportLineOffset(int offset) {
		lineOff = offset;
	}
	
	public void setCharacterOffset(int offset) {
		characterOff = offset;
	}
	
	public void setTraceFlag(boolean trace) {
		this.trace = trace;
	}

	public void reset() {
		parser.getParser().reset();
	}
	
	public int getToken() {
		return parser.getParser().getToken();
	}
	
	public IToken getIToken(int token) {
		return parser.getParser().getIToken(token);
	}
	
	public String getTokenText(int tokenIndex) {
		return parser.getParser().getTokenText(tokenIndex);
	}
	
	public static boolean isIdentifierOrKeyword(int tokenKind) {
		return AbstractOCLAnalyzer.isIdentifierOrKeyword(tokenKind);
	}
	
	private OCLAnalyzer<
			EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject>
	getParser(Environment env) {
		if (parser == null) {
			if (env != null) {
				parser = new OCLAnalyzer<
					EPackage, EClassifier, EOperation, EStructuralFeature,
					EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
					EClass, EObject>(
							CompatibilityUtil.getCompatibilityEnvironment(
									root, env, environmentFactory),
							text);
			} else {
				parser = new OCLAnalyzer<
				EPackage, EClassifier, EOperation, EStructuralFeature,
				EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
				EClass, EObject>(root, text);
			}
			parser.getEnvironment().getProblemHandler().setErrorReportLineOffset(lineOff);
			parser.setCharacterOffset(characterOff);
			parser.setTraceFlag(trace);
		}
		
		return parser;
	}
	
	/**
	 * Checks whether the specified environment's problem handler has any
	 * diagnostics of error severity or worse and, if so, throws a semantic
	 * exception encapsulating these diagnostics.
	 * 
	 * @param anayzer an OCL analyzer with which we have parsed some OCL
	 * 
	 * @throws ParserException if there are any errors to report
	 */
	private static <PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	void checkForErrors(
			OCLAnalyzer<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> analyzer)
			throws ParserException {
		
		ProblemHandler problemHandler = (analyzer.getEnvironment().getAdapter(
			ProblemHandler.class));
		
		if (problemHandler instanceof OCLProblemHandler) {
			Diagnostic problems = ((OCLProblemHandler) problemHandler).getDiagnostic();
			
			if ((problems != null) && (problems.getSeverity() >= Diagnostic.ERROR)) {
				throw new ParserException(problems.getMessage());
			}
		}
	}
}
