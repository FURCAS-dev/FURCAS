/******************************************************************************
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
 * $Id: CSTRootEcoreEnvironment.java,v 1.2 2010/04/08 06:26:20 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.environment.ecore;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.TypeResolver;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.InvalidLiteralExp;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.examples.parser.environment.CSTRootEnvironment;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.utilities.OCLFactory;
import org.eclipse.ocl.utilities.UMLReflection;

public abstract class CSTRootEcoreEnvironment<V extends ICSTNodeEcoreEnvironment, CST extends CSTNode>
extends CSTRootEnvironment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter,
EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject, V, CST> implements ICSTRootEcoreEnvironment
{
	protected CSTRootEcoreEnvironment(ICSTFileEcoreEnvironment fileEnvironment, XMIResource astNode, CST cstNode) {
		super(fileEnvironment, astNode, cstNode);
	}
	
	public boolean checkFeatureCompatibility(CSTNode cstNode,
			EClassifier featureType, OCLExpression<EClassifier> oclExpression) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Implemented by subclasses to find all states in the specified owner type
	 * that match the given path name prefix and add them to the accumulator
	 * list.  The default implementation does nothing, as Ecore does not model
	 * states.
	 * <p>
	 * Implementors must only provide the states defined directly in the
	 * namespace indicated by the path prefix (i.e., only one level).
	 * </p>
	 * 
	 * @param owner the owner type
	 * @param pathPrefix partial qualified name, specifying the parent of the
     *     states to be collection
	 * @param states a list of states directly owned by the namespace indicated
	 *     by path prefix, within the owner type
     *     
     * @see #getStates(EClassifier, List)
	 */
	protected void collectStates(EClassifier owner, List<String> pathPrefix, List<EObject> states) {
		// do nothing
	}

	public InvalidLiteralExp createInvalidLiteralExp(CSTNode cstNode) {
		return org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createInvalidLiteralExp();
	}

    // implements the inherited specification
	public EStructuralFeature defineAttribute(
			EClassifier owner,
			org.eclipse.ocl.expressions.Variable<
				EClassifier, EParameter> variable,
			Constraint constraint) {
		
		EStructuralFeature result;
		
		String name = variable.getName();
		EClassifier type = variable.getType();
		
		if (type instanceof EClass) {
			result = EcoreFactory.eINSTANCE.createEReference();
		} else {
			result = EcoreFactory.eINSTANCE.createEAttribute();
		}
		
		result.setName(name);
		result.setEType(type);
		
		Constraint existing = getDefinition(result);
		if (existing != null) {
			// replace existing definition
			EcoreUtil.replace(existing, constraint);
		} else {
			EAnnotation ann = result.getEAnnotation(Environment.OCL_NAMESPACE_URI);
			if (ann == null) {
				ann = EcoreFactory.eINSTANCE.createEAnnotation();
				ann.setSource(Environment.OCL_NAMESPACE_URI);
				result.getEAnnotations().add(ann);
			}

			ann.getContents().add(constraint);
		}
		
		addHelperProperty(owner, result);
		
		return result;
	}
	
    // implements the inherited specification
	public EOperation defineOperation(EClassifier owner, String name,
			EClassifier type,
			List<org.eclipse.ocl.expressions.Variable<
				EClassifier, EParameter>> params,
			Constraint constraint) {
		EOperation result = EcoreFactory.eINSTANCE.createEOperation();
		
		result.setName(name);
		result.setEType((type == null) ? getOCLStandardLibrary().getOclVoid() :
            type);
		
		for (Variable<EClassifier, EParameter> next : params) {
			EParameter param = EcoreFactory.eINSTANCE.createEParameter();
			param.setName(next.getName());
			param.setEType((next.getType() == null)?
                getOCLStandardLibrary().getOclVoid() : next.getType());
			
			result.getEParameters().add(param);
		}
		
		Constraint existing = getDefinition(result);
		if (existing != null) {
			// replace existing definition
			EcoreUtil.replace(existing, constraint);
		} else {
			EAnnotation ann = result.getEAnnotation(Environment.OCL_NAMESPACE_URI);
			if (ann == null) {
				ann = EcoreFactory.eINSTANCE.createEAnnotation();
				ann.setSource(Environment.OCL_NAMESPACE_URI);
				result.getEAnnotations().add(ann);
			}

			ann.getContents().add(constraint);
		}
		
		addHelperOperation(owner, result);
		
		return result;
	}
	
	public Constraint getDefinition(Object feature) {
    	Constraint result = null;
		ETypedElement typedFeature = (ETypedElement) feature;
    	
    	EAnnotation ann = typedFeature.getEAnnotation(
    			Environment.OCL_NAMESPACE_URI);
    	
    	if ((ann != null) && !ann.getContents().isEmpty()) {
    		for (EObject o : ann.getContents()) {
    			if ((o instanceof Constraint)
    					&& UMLReflection.DEFINITION.equals(((Constraint) o).getStereotype())) {
    				
    				result = (Constraint) o;
    				break;
    			}
    		}
    	}
    	
    	return result;
	}

	public EnvironmentFactory<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> getFactory() {
		return fileEnvironment.getFactory();
	}

	public OCLFactory getOCLFactory() {
		return fileEnvironment.getOCLFactory();
	}

	public OCLStandardLibrary<EClassifier> getOCLStandardLibrary() {
		return fileEnvironment.getOCLStandardLibrary();
	}
	
	/**
	 * Obtains the states matching the specified path prefix in the owner type
	 * by trying the {@link #collectStates} method on it and, recursively, its
	 * supertypes to find all matches.  For implicit (<code>null</code>) owners,
	 * looks up the innermost-scoped variable as the implicit source and tries
	 * again on this variable's type.
	 * <p>
	 * To extend this implementation, override the
	 * {@link #collectStates} method.
	 * </p>
	 */
	public List<EObject> getStates(EClassifier owner, List<String> pathPrefix) {
		EList<EObject> result = new BasicEList<EObject>();
		
		collectStates(owner, pathPrefix, result);
		
		if (owner instanceof EClass) {
			// search supertypes
			for (EClass superclass : ((EClass) owner).getEAllSuperTypes()) {
				collectStates(superclass, pathPrefix, result);
			}
		}
		
		return result;
	}

	public TypeResolver<EClassifier, EOperation, EStructuralFeature> getTypeResolver() {
		return fileEnvironment.getTypeResolver();
	}

	public boolean isInPostcondition(OCLExpression<EClassifier> exp) {
		
		Constraint constraint = null;
		EObject parent = exp;
		while (parent != null) {
			if (parent instanceof Constraint) {
				constraint = (Constraint) parent;
				break;
			}
			
			parent = parent.eContainer();
		}
		
		return (constraint != null)
				&& UMLReflection.POSTCONDITION.equals(constraint.getStereotype());
	}
	
//	public EClassifier lookupClassifier(List<String> names) {
//		return fileEnvironment.lookupClassifier(names);
//	}

	public EPackage lookupPackage(List<String> path) {
		return fileEnvironment.lookupPackage(path);
	}

	public void setParent(Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		fileEnvironment.setParent(env);
	}

	public void undefine(Object feature) {
		Constraint definition = getDefinition(feature);
		
		if (definition == null) {
			throw new IllegalArgumentException(
                "not an additional feature: " + feature); //$NON-NLS-1$
		}
		
		EcoreUtil.remove((EObject) feature);
		EcoreUtil.remove(definition);
		
		definition.getConstrainedElements().clear();
	}
}
