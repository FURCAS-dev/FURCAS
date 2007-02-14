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
 * $Id: CompatibilityParser.java,v 1.2 2007/02/14 14:45:41 cdamus Exp $
 */
package org.eclipse.emf.ocl.internal.parser;

import lpg.lpgjavaruntime.IToken;

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
import org.eclipse.ocl.internal.parser.OCLLexer;
import org.eclipse.ocl.internal.parser.OCLParser;

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
	
	private final OCLLexer lexStream;
	private final org.eclipse.ocl.Environment<
		EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
		EClass, EObject> root;

	private OCLParser<EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
		EClass, EObject> parser;
	
	private int lineOff, characterOff;
	private boolean trace;
	
	public CompatibilityParser(OCLLexer lexStream) {
		this(lexStream, EnvironmentFactory.ECORE_INSTANCE);
	}
	
	public CompatibilityParser(OCLLexer lexStream, EnvironmentFactory factory) {
		this.lexStream = lexStream;
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
		try {
			OCLParser<EPackage, EClassifier, EOperation, EStructuralFeature,
					EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
					EClass, EObject>
			parser = new OCLParser<
				EPackage, EClassifier, EOperation, EStructuralFeature,
				EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
				EClass, EObject>(lexStream, root);
			
			EList result = CompatibilityUtil.getOldAS(
					new EcoreEnvironment(EcorePackage.eINSTANCE),
					parser.parsePackageDeclarationCS(constraints));
			ECollections.setEList(constraints, result);
			return constraints;
		} catch (org.eclipse.ocl.ParserException e) {
			throw new ParserException(e.getLocalizedMessage());
		}
	}
	
	public org.eclipse.emf.ocl.uml.Constraint parseInvOrDefCS(Environment env)
			throws ParserException {
		try {
			return (org.eclipse.emf.ocl.uml.Constraint)
				CompatibilityUtil.getOldAS(env, getParser(env).parseInvOrDefCS());
		} catch (org.eclipse.ocl.ParserException e) {
			throw new ParserException(e.getLocalizedMessage());
		}
	}
	
	public org.eclipse.emf.ocl.uml.Constraint parsePrePostOrBodyDeclCS(Environment env, EOperation operation)
			throws ParserException {
		
		try {
			return (org.eclipse.emf.ocl.uml.Constraint)
				CompatibilityUtil.getOldAS(
						env,
						getParser(env).parsePrePostOrBodyDeclCS());
		} catch (org.eclipse.ocl.ParserException e) {
			throw new ParserException(e.getLocalizedMessage());
		}
	}
	
	public org.eclipse.emf.ocl.uml.Constraint parseInitOrDerValueCS(Environment env, EStructuralFeature property)
			throws ParserException {
		
		try {
			return (org.eclipse.emf.ocl.uml.Constraint)
				CompatibilityUtil.getOldAS(
						env,
						getParser(env).parseInitOrDerValueCS());
		} catch (org.eclipse.ocl.ParserException e) {
			throw new ParserException(e.getLocalizedMessage());
		}
	}
	
	public Variable parseVariableDeclarationCS(Environment env, boolean addToEnvironment)
			throws ParserException {
		
		try {
			return (Variable) CompatibilityUtil.getOldAS(
					env,
					getParser(env).parseVariableDeclarationCS(
					addToEnvironment));
		} catch (org.eclipse.ocl.ParserException e) {
			throw new ParserException(e.getLocalizedMessage());
		}
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
		parser.reset();
	}
	
	public int getToken() {
		return parser.getToken();
	}
	
	public IToken getIToken(int token) {
		return parser.getIToken(token);
	}
	
	public String getTokenText(int tokenIndex) {
		return parser.getTokenText(tokenIndex);
	}
	
	public static boolean isIdentifierOrKeyword(int tokenKind) {
		return OCLParser.isIdentifierOrKeyword(tokenKind);
	}
	
	private OCLParser<
			EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject>
	getParser(Environment env) {
		if (parser == null) {
			if (env != null) {
				parser = new OCLParser<
					EPackage, EClassifier, EOperation, EStructuralFeature,
					EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
					EClass, EObject>(
							lexStream,
							CompatibilityUtil.getCompatibilityEnvironment(
									root, env, environmentFactory));
			} else {
				parser = new OCLParser<
				EPackage, EClassifier, EOperation, EStructuralFeature,
				EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
				EClass, EObject>(lexStream, root);
			}
			parser.setErrorReportLineOffset(lineOff);
			parser.setCharacterOffset(characterOff);
			parser.setTraceFlag(trace);
		}
		
		return parser;
	}
}
