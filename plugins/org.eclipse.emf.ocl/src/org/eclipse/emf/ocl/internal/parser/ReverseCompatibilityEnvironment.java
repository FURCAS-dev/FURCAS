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
 * $Id: ReverseCompatibilityEnvironment.java,v 1.3 2007/10/11 23:05:17 cdamus Exp $
 */
package org.eclipse.emf.ocl.internal.parser;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.emf.ocl.parser.EcoreEnvironment;
import org.eclipse.emf.ocl.parser.SemanticException;
import org.eclipse.emf.ocl.uml.CallOperationAction;
import org.eclipse.emf.ocl.uml.Constraint;
import org.eclipse.emf.ocl.uml.SendSignalAction;
import org.eclipse.emf.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * 
 *
 * @author Christian W. Damus (cdamus)
 */
public class ReverseCompatibilityEnvironment extends EcoreEnvironment {
	private final org.eclipse.ocl.Environment<
				EPackage, EClassifier, EOperation, EStructuralFeature,
				EEnumLiteral, EParameter,
				EObject, CallOperationAction, SendSignalAction, Constraint,
				EClass, EObject> newStyle;
	
    private final UMLReflection<
                EPackage, EClassifier, EOperation, EStructuralFeature,
                EEnumLiteral, EParameter,
                EObject, CallOperationAction, SendSignalAction, Constraint> uml;
    
	ReverseCompatibilityEnvironment(org.eclipse.ocl.Environment newStyle) {
		super(EcorePackage.eINSTANCE);  // any old package will do
		
		this.newStyle = newStyle;
        this.uml = newStyle.getUMLReflection();
	}
	

	// Documentation copied from the inherited specification
	@Override
    public boolean addElement(String name, Variable elem, boolean imp) {
		return newStyle.addElement(
				name,
				(org.eclipse.ocl.expressions.Variable<EClassifier, EParameter>)
					CompatibilityUtil.getNewAS(this, elem),
				imp);
	}

	// Documentation copied from the inherited specification
	@Override
    public void deleteElement(String name) {
		newStyle.deleteElement(name);
	}

	// Documentation copied from the inherited specification
	@Override
    public EClass getAssociationClass(EReference reference) {
		return (EClass) uml.getAssociationClass(reference);
	}

	// Documentation copied from the inherited specification
	@Override
    public EClassifier getContextClassifier() {
		return newStyle.getContextClassifier();
	}

	// Documentation copied from the inherited specification
	@Override
    public EOperation getContextOperation() {
		return newStyle.getContextOperation();
	}

	// Documentation copied from the inherited specification
	@Override
    public EStructuralFeature getContextProperty() {
		return newStyle.getContextProperty();
	}

	// Documentation copied from the inherited specification
	@Override
    public String getDescription(ENamedElement namedElement) {
		return uml.getDescription(namedElement);
	}

	// Documentation copied from the inherited specification
	@Override
    public EList getMemberEnds(EClass associationClass) {
		return new BasicEList(uml.getMemberEnds(associationClass));
	}

	// Documentation copied from the inherited specification
	@Override
    public EList getQualifiers(EStructuralFeature property) {
		return new BasicEList(uml.getQualifiers(property));
	}

	// Documentation copied from the inherited specification
	@Override
    public Variable getSelfVariable() {
		return (Variable) CompatibilityUtil.getOldAS(
				this, newStyle.getSelfVariable());
	}

	// Documentation copied from the inherited specification
	@Override
    public EList getSignals(EClassifier owner) {
		return new BasicEList(uml.getSignals(owner));
	}

	// Documentation copied from the inherited specification
	@Override
    public String getStateName(EObject state) {
		return uml.getName(state);
	}

	// Documentation copied from the inherited specification
	@Override
    public EList getStates(EClassifier owner, List pathPrefix) {
		return new BasicEList(newStyle.getStates(owner, pathPrefix));
	}

	// Documentation copied from the inherited specification
	@Override
    public Collection getVariables() {
		EList result = CompatibilityUtil.getOldAS(
				this,
				(List<org.eclipse.ocl.expressions.Variable<EClassifier, EParameter>>)
					newStyle.getVariables());
		return result;
	}

	// Documentation copied from the inherited specification
	@Override
    public boolean isAssociationClass(EClass eclass) {
		return uml.isAssociationClass(eclass);
	}

	// Documentation copied from the inherited specification
	@Override
    public boolean isEmpty() {
		return newStyle.isEmpty();
	}

	// Documentation copied from the inherited specification
	@Override
    public boolean isQuery(EOperation operation) {
		return uml.isQuery(operation);
	}

	// Documentation copied from the inherited specification
	@Override
    public Variable lookup(String name) {
		return (Variable) newStyle.lookup(name);
	}

	// Documentation copied from the inherited specification
	@Override
    public EClass lookupAssociationClassReference(EClassifier parent,
			String name) {
		return (EClass) newStyle.lookupAssociationClassReference(parent, name);
	}

	// Documentation copied from the inherited specification
	@Override
    public Variable lookupImplicitSourceForAssociationClass(String name) {
		return (Variable) CompatibilityUtil.getOldAS(
				this, newStyle.lookupImplicitSourceForAssociationClass(name));
	}

	// Documentation copied from the inherited specification
	@Override
    public Variable lookupImplicitSourceForOperation(String name, EList params)
			throws SemanticException {
		return (Variable) CompatibilityUtil.getOldAS(
				this, newStyle.lookupImplicitSourceForOperation(name, params));
	}

	// Documentation copied from the inherited specification
	@Override
    public Variable lookupImplicitSourceForProperty(String name) {
		return (Variable) CompatibilityUtil.getOldAS(
				this, newStyle.lookupImplicitSourceForProperty(name));
	}

	// Documentation copied from the inherited specification
	@Override
    public Variable lookupLocal(String name) {
		return (Variable) CompatibilityUtil.getOldAS(
				this, newStyle.lookupLocal(name));
	}

	// Documentation copied from the inherited specification
	@Override
    public EOperation lookupOperation(EClassifier owner, String name, EList args) {
		if (owner instanceof PredefinedType) {
			return super.lookupOperation(owner, name, args);
		}
		
		List newArgs = CompatibilityUtil.getNewAS(this, args);
		return newStyle.lookupOperation(owner, name,
				newArgs);
	}

	// Documentation copied from the inherited specification
	@Override
    public EPackage lookupPackage(List names) {
        return newStyle.lookupPackage(names);
	}

	// Documentation copied from the inherited specification
	@Override
    public EClassifier lookupPathName(List names) {
		return newStyle.lookupClassifier(names);
	}

	// Documentation copied from the inherited specification
	@Override
    public EStructuralFeature lookupProperty(EClassifier parent, String name) {
		if (parent instanceof PredefinedType) {
			return super.lookupProperty(parent, name);
		}
		
		return newStyle.lookupProperty(parent, name);
	}

	// Documentation copied from the inherited specification
	@Override
    public EClass lookupSignal(EClassifier owner, String name, EList args) {
		List newArgs = CompatibilityUtil.getNewAS(this, args);
		return (EClass) newStyle.lookupSignal(owner, name,
				newArgs);
	}

	// Documentation copied from the inherited specification
	@Override
    public void setSelfVariable(Variable var) {
		newStyle.setSelfVariable(
				(org.eclipse.ocl.expressions.Variable<EClassifier, EParameter>)
					CompatibilityUtil.getNewAS(this, var));
	}
}
