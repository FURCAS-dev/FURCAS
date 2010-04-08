/**
 * <copyright>
 *
 * Copyright (c) 2007,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: CSTChildEnvironment.java,v 1.2 2010/04/08 06:26:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.environment;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.TypeResolver;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.examples.modelregistry.environment.AbstractModelResolver;
import org.eclipse.ocl.examples.parser.utils.CSTFormattingHelper;
import org.eclipse.ocl.expressions.InvalidLiteralExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.lpg.AbstractParser;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.types.TypeType;
import org.eclipse.ocl.utilities.OCLFactory;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;

public abstract class CSTChildEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E, V extends ICSTNodeEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>, PV extends ICSTNodeEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>, AST extends Notifier, CST extends CSTNode>
extends CSTNodeEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E, V, AST, CST>
{
	protected final ICSTRootEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> rootEnvironment;
	protected int errorStart = 0;
	protected int errorEnd = 0;
	
	protected CSTChildEnvironment(PV parent, AST astNode, CST cstNode) {
		super(parent, astNode, cstNode);
		rootEnvironment = parent.getRootEnvironment();
		assert (rootEnvironment != null);
		initASTMapping(astNode, cstNode);
	}

	public boolean checkFeatureCompatibility(CSTNode cstNode, C featureType, OCLExpression<C> oclExpression) {
		return rootEnvironment.checkFeatureCompatibility(cstNode, featureType, oclExpression);
	}

	public InvalidLiteralExp<C> createInvalidLiteralExp(CSTNode cstNode) {
		return rootEnvironment.createInvalidLiteralExp(cstNode);
	}
	
	public P defineAttribute(C owner, Variable<C, PM> variable, CT constraint) {
		return rootEnvironment.defineAttribute(owner, variable, constraint);
	}
	
	public O defineOperation(C owner, String name, C type, List<Variable<C, PM>> params, CT constraint) {
		return rootEnvironment.defineOperation(owner, name, type, params, constraint);
	}

	@Override
	public CSTNode getASTMapping(Object object) {
		return rootEnvironment.getASTMapping(object);
	}

	@Override
	public Map<Object, CSTNode> getASTNodeToCSTNodeMap() {
		return rootEnvironment.getASTNodeToCSTNodeMap();
	}

	public CT getDefinition(Object feature) {
		return rootEnvironment.getDefinition(feature);
	}

	public EnvironmentFactory<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> getFactory() {
		return rootEnvironment.getFactory();
	}

	public ICSTFileEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> getFileEnvironment() {
		return rootEnvironment.getFileEnvironment();
	}

	@Override
	public CSTFormattingHelper getFormatter() {
		return rootEnvironment.getFormatter();
	}

	public OCLFactory getOCLFactory() {
		return rootEnvironment.getOCLFactory();
	}	

	public OCLStandardLibrary<C> getOCLStandardLibrary() {
		return rootEnvironment.getOCLStandardLibrary();
	}

	@SuppressWarnings("unchecked")
	public PV getParentEnvironment() {
		return (PV) getInternalParent();
	}

	@Override
	public AbstractParser getParser() {
		return rootEnvironment.getParser();
	}

	@Override
	public ProblemHandler getProblemHandler() {
		return rootEnvironment.getProblemHandler();
	}

	public AbstractModelResolver getResolver() {
		return rootEnvironment.getResolver();
	}
	
	public ICSTRootEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> getRootEnvironment() {
		return rootEnvironment;
	}

	public List<S> getStates(C owner, List<String> pathPrefix) {
		return rootEnvironment.getStates(owner, pathPrefix);
	}

	public TypeResolver<C, O, P> getTypeResolver() {
		return rootEnvironment.getTypeResolver();
	}

	public UMLReflection<PK, C, O, P, EL, PM, S, COA, SSA, CT> getUMLReflection() {
		return rootEnvironment.getUMLReflection();
	}

	public UnresolvedEnvironment getUnresolvedEnvironment() {
		return rootEnvironment.getUnresolvedEnvironment();
	}

	@Override
	public void initASTMapping(Object astNode, CSTNode cstNode) {
		rootEnvironment.initASTMapping(astNode, cstNode);
	}

	@Override
	public void initASTMapping(Object fromAstNode, CSTNode cstNode, Object toAstNode) {
		rootEnvironment.initASTMapping(fromAstNode, cstNode, toAstNode);
	}

	public boolean isInPostcondition(OCLExpression<C> exp) {
		return rootEnvironment.isInPostcondition(exp);
	}

	public boolean isResolved(EObject eObject) {
		return rootEnvironment.isResolved(eObject);
	}

/*	@Override @Deprecated
	public final EClassifier lookupAssociationClassReference(EClassifier owner, String name) {
		try {
			return tryLookupAssociationClassReference(owner, name);
		} catch (LookupException e) {
			OCLExamplesEcorePlugin.logError("Deprecated lookupAssociationClassReference cannot resolve ambiguity", e);
			List<?> matches = e.getAmbiguousMatches();
			if ((matches != null) && !matches.isEmpty()) {
				Object firstMatch = matches.get(0);
				if (firstMatch instanceof EClassifier)
					return (EClassifier) firstMatch;
			}
			return null;
		}
	} */


/*	@Override @Deprecated
	public final EClassifier lookupClassifier(List<String> names) {
		try {
			return tryLookupClassifier(names);
		} catch (LookupException e) {
			OCLExamplesEcorePlugin.logError("Deprecated lookupClassifier cannot resolve ambiguity", e);
			List<?> matches = e.getAmbiguousMatches();
			if ((matches != null) && !matches.isEmpty()) {
				Object firstMatch = matches.get(0);
				if (firstMatch instanceof EClassifier)
					return (EClassifier) firstMatch;
			}
			return null;
		}
	} */

//	protected C lookupOCLAssociationClassReference(C owner, String name) {
//		return super.lookupAssociationClassReference(owner, name);
//	}

//	protected EClassifier lookupOCLClassifier(List<String> names) {
//		return super.lookupClassifier(names);
//	}

	/**
	 * Return the implicit source for an operation by performing the inherited OCL lookup.
	 */
//	protected Variable lookupOCLImplicitSourceForOperation(String name, List<? extends TypedElement<EClassifier>> params) {
//		return (Variable) super.lookupImplicitSourceForOperation(name, params);
//	}

	/**
	 * Return the implicit source for a property by performing the inherited OCL lookup.
	 */
//	protected Variable lookupOCLImplicitSourceForProperty(String name) {
//		return (Variable) super.lookupImplicitSourceForProperty(name);
//	}

//	protected EOperation lookupOCLOperation(EClassifier owner, String name,
//			List<? extends TypedElement<EClassifier>> args) {
//		return super.lookupOperation(owner, name, args);
//	}

//	protected PK lookupOCLPackage(List<String> path) {
//		return super.lookupPackage(path);
//	}

//	protected EStructuralFeature lookupOCLProperty(EClassifier owner, String name) {
//		return super.lookupProperty(owner, name);
//	}

//	protected EClassifier lookupOCLSignal(EClassifier owner, String name,
//			List<? extends TypedElement<EClassifier>> args) {
//		return super.lookupSignal(owner, name, args);
//	}

/*	@Override @Deprecated
	public final EOperation lookupOperation(EClassifier owner, String name,
			List<? extends TypedElement<EClassifier>> args) {
		try {
			return tryLookupOperation(owner, name, args);
		} catch (LookupException e) {
			OCLExamplesEcorePlugin.logError("Deprecated lookupOperation cannot resolve ambiguity", e);
			List<?> matches = e.getAmbiguousMatches();
			if ((matches != null) && !matches.isEmpty()) {
				Object firstMatch = matches.get(0);
				if (firstMatch instanceof EOperation)
					return (EOperation) firstMatch;
			}
			return null;
		}
	} */

	public PK lookupPackage(List<String> names) {
		return rootEnvironment.lookupPackage(names);
	}

/*	@Override @Deprecated
	public final EPackage lookupPackage(List<String> path) {
		try {
			return tryLookupPackage(path);
		} catch (LookupException e) {
			OCLExamplesEcorePlugin.logError("Deprecated lookupPackage cannot resolve ambiguity", e);
			List<?> matches = e.getAmbiguousMatches();
			if ((matches != null) && !matches.isEmpty()) {
				Object firstMatch = matches.get(0);
				if (firstMatch instanceof EPackage)
					return (EPackage) firstMatch;
			}
			return null;
		}
	}

	@Override @Deprecated
	public final EStructuralFeature lookupProperty(EClassifier owner, String name) {
		try {
			return tryLookupProperty(owner, name);
		} catch (LookupException e) {
			OCLExamplesEcorePlugin.logError("Deprecated lookupProperty cannot resolve ambiguity", e);
			List<?> matches = e.getAmbiguousMatches();
			if ((matches != null) && !matches.isEmpty()) {
				Object firstMatch = matches.get(0);
				if (firstMatch instanceof EStructuralFeature)
					return (EStructuralFeature) firstMatch;
			}
			return null;
		}
	}

	@Override @Deprecated
	public final EClassifier lookupSignal(EClassifier owner, String name,
			List<? extends TypedElement<EClassifier>> args) {
		try {
			return tryLookupSignal(owner, name, args);
		} catch (LookupException e) {
			OCLExamplesEcorePlugin.logError("Deprecated lookupSignal cannot resolve ambiguity", e);
			List<?> matches = e.getAmbiguousMatches();
			if ((matches != null) && !matches.isEmpty()) {
				Object firstMatch = matches.get(0);
				if (firstMatch instanceof EClassifier)
					return (EClassifier) firstMatch;
			}
			return null;
		}
	} */

//	@Override protected void removedVariable(String name, org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> variable, boolean isExplicit) {
//	}

	public void setParent(Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> env) {
		rootEnvironment.setParent(env);
	}

	@Override
	public C tryLookupAssociationClassReference(C owner, String name) throws LookupException {
		C result = super.lookupAssociationClassReference(owner, name);
		if (result != null)
			return result;
		PV parent = getParentEnvironment();
		if (parent != null)
			return parent.tryLookupAssociationClassReference(owner, name);
		return null;
	}

	@Override
	public C tryLookupClassifier(List<String> names) throws LookupException {
		C result = lookupClassifier(names);
		if (result != null)
			return result;
		PV parent = getParentEnvironment();
		if (parent != null)
			return parent.tryLookupClassifier(names);
		return null;
	}

	@Override
	public O tryLookupOperation(C owner, String name, List<? extends TypedElement<C>> args) throws LookupException {
		O result = super.lookupOperation(owner, name, args);
		if (result != null)
			return result;
		PV parent = getParentEnvironment();
		if (parent != null)
			return parent.tryLookupOperation(owner, name, args);
		return null;
	}

	@Override
	public PK tryLookupPackage(List<String> names) throws LookupException {
		PK result = lookupPackage(names);
		if (result != null)
			return result;
		PV parent = getParentEnvironment();
		if (parent != null)
			return parent.tryLookupPackage(names);
		return null;
	}

	@Override
	public P tryLookupProperty(C owner, String name) throws LookupException {
		if (name == null)
			return null;
		P result = super.lookupProperty(owner, name);
		if (result != null)
			return result;       
        // looks up non-navigable named ends as well as unnamed ends.  Hence
        // the possibility of ambiguity
//        result = lookupNonNavigableEnd(owner, name);
        
//        if ((result == null) && AbstractOCLAnalyzer.isEscaped(name)) {
//            result = lookupNonNavigableEnd(owner, AbstractOCLAnalyzer.unescape(name));
//        }	
		PV parent = getParentEnvironment();
		if (parent != null)
			return parent.tryLookupProperty(owner, name);
		return null;
	}

	@Override
	public C tryLookupSignal(C owner, String name,
			List<? extends TypedElement<C>> args) throws LookupException {
		C result = super.lookupSignal(owner, name, args);
		if (result != null)
			return result;
		PV parent = getParentEnvironment();
		if (parent != null)
			return parent.tryLookupSignal(owner, name, args);
		return null;
	}
	
	public void undefine(Object feature) {
		rootEnvironment.undefine(feature);
	}

	public void validateASTMappings(List<EPackage> ePackages) {
		for (EPackage ePackage : ePackages) {
			for (TreeIterator<EObject> i = ePackage.eAllContents(); i.hasNext(); ) {
				EObject eObject = i.next();
				if (getASTMapping(eObject) != null)
					;
				else if (eObject instanceof EGenericType)
					;
				else if (eObject instanceof CollectionType<?, ?>)
					;
				else if (eObject instanceof TypeType<?, ?>)
					;
				else if (eObject instanceof InvalidLiteralExp<?>)	// FIXME Workaround bug 237126
					;
				else
					System.out.println(formatName(eObject.eClass()) + " : " + formatQualifiedName(eObject) + " has no mapping to a CST node");
			}
		}
	}
}
