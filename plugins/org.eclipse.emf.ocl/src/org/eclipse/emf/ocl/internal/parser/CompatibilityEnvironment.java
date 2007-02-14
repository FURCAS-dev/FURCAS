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
 * $Id: CompatibilityEnvironment.java,v 1.2 2007/02/14 14:45:41 cdamus Exp $
 */
package org.eclipse.emf.ocl.internal.parser;

import java.util.Collection;
import java.util.List;

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
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.PersistentEnvironment;
import org.eclipse.emf.ocl.types.impl.TypeUtil;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.TypeResolver;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.internal.UMLReflectionImpl;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * 
 *
 * @author Christian W. Damus (cdamus)
 */
public class CompatibilityEnvironment extends EcoreEnvironment {
	private Environment oldStyle;
	private final EnvironmentFactory<
			EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> factory;
	private final TypeResolver<EClassifier, EOperation, EStructuralFeature> typeResolver;
	
    private final CompatibilityUMLReflection uml;
    
	CompatibilityEnvironment(
			org.eclipse.ocl.Environment<
					EPackage, EClassifier, EOperation, EStructuralFeature,
					EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
					EClass, EObject> parent,
			Environment oldStyle,
			EnvironmentFactory<
			EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> factory) {
		super(parent);
		
		this.oldStyle = oldStyle;
        this.uml = new CompatibilityUMLReflection(oldStyle);
		this.factory = factory;
		
		this.typeResolver = (oldStyle instanceof PersistentEnvironment)?
				new CompatibilityTypeResolver(
						oldStyle,
						((PersistentEnvironment) oldStyle).getTypeResolver())
					: null;
		
		if ((oldStyle.getParent() != null)
				&& (parent instanceof CompatibilityEnvironment)) {

			// ensure that my parent's delegate is my delegate's parent
			((CompatibilityEnvironment) parent).oldStyle = oldStyle.getParent();
		}
	}
	
    @Override
	public EnvironmentFactory<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> getFactory() {
		return factory;
	}
	
	org.eclipse.emf.ocl.parser.Environment getOldStyle() {
		return oldStyle;
	}
	
	// Documentation copied from the inherited specification
    @Override
	public boolean addElement(String name, Variable<EClassifier, EParameter> elem, boolean explicit) {
		return oldStyle.addElement(
				name,
				(org.eclipse.emf.ocl.expressions.Variable)
					CompatibilityUtil.getOldAS(oldStyle, elem),
				explicit);
	}

	// Documentation copied from the inherited specification
    @Override
	public void deleteElement(String name) {
		oldStyle.deleteElement(name);
	}

    @Override
	public EOperation getContextOperation() {
		return oldStyle.getContextOperation();
	}

    @Override
	public EStructuralFeature getContextProperty() {
		return oldStyle.getContextProperty();
	}

    @Override
	public Variable<EClassifier, EParameter> getSelfVariable() {
		return (Variable<EClassifier, EParameter>) CompatibilityUtil.getNewAS(
				oldStyle, oldStyle.getSelfVariable());
	}

    @Override
	public List<EObject> getStates(EClassifier owner, List<String> pathPrefix) {
		return oldStyle.getStates(owner, pathPrefix);
	}

    @Override
	public Collection<Variable<EClassifier, EParameter>> getVariables() {
		EList result = CompatibilityUtil.getNewAS(
				oldStyle, (List<EObject>) oldStyle.getVariables());
		return (EList<Variable<EClassifier, EParameter>>) result;
			
	}

    @Override
    public boolean isEmpty() {
        return oldStyle.isEmpty();
    }

    @Override
	public Variable<EClassifier, EParameter> lookup(String name) {
		return (Variable<EClassifier, EParameter>) CompatibilityUtil.getNewAS(
				oldStyle, oldStyle.lookup(name));
	}

    @Override
	public EClass lookupAssociationClassReference(EClassifier parentClassifier, String name) {
		return oldStyle.lookupAssociationClassReference(parentClassifier, name);
	}

    @Override
	public Variable<EClassifier, EParameter> lookupImplicitSourceForAssociationClass(String name) {
		return (Variable<EClassifier, EParameter>) CompatibilityUtil.getNewAS(
				oldStyle, oldStyle.lookupImplicitSourceForAssociationClass(name));
	}

    @Override
	public Variable<EClassifier, EParameter> lookupImplicitSourceForOperation(String name, List<? extends TypedElement<EClassifier>> args) {
		try {
			return (Variable<EClassifier, EParameter>) CompatibilityUtil.getNewAS(
					oldStyle, oldStyle.lookupImplicitSourceForOperation(
							name,
							CompatibilityUtil.getOldAS(oldStyle, args)));
		} catch (Exception e) {
			return null;
		}
	}

    @Override
	public Variable<EClassifier, EParameter> lookupImplicitSourceForProperty(String name) {
		return (Variable<EClassifier, EParameter>) CompatibilityUtil.getNewAS(
				oldStyle, oldStyle.lookupImplicitSourceForProperty(name));
	}

    @Override
	public Variable<EClassifier, EParameter> lookupLocal(String name) {
		return (Variable<EClassifier, EParameter>) CompatibilityUtil.getNewAS(
				oldStyle, oldStyle.lookupLocal(name));
	}

    @Override
	public EOperation lookupOperation(EClassifier owner, String name, List<? extends TypedElement<EClassifier>> args) {
        EClassifier oldStyleOwner = owner;
        
		if (owner instanceof PredefinedType) {
			oldStyleOwner = (EClassifier) CompatibilityUtil.getOldAS(oldStyle, owner);
		}
		
		EOperation result = oldStyle.lookupOperation(oldStyleOwner, name,
				CompatibilityUtil.getOldAS(oldStyle, args));
		
		if (UMLReflectionImpl.isAncestor(Types.init(), result)) {
            // get the corresponding new-style OCL Standard Library operation
			result = CompatibilityUtil.getNewOperation(
					result,
					owner,
					oldStyleOwner);
		}
		
		return result;
	}

    @Override
	public EPackage lookupPackage(List<String> path) {
		return oldStyle.lookupPackage(path);
	}

    @Override
	public EClassifier lookupClassifier(List<String> names) {
		return oldStyle.lookupPathName(names);
	}

    @Override
	public EStructuralFeature lookupProperty(EClassifier owner, String name) {
		if (owner instanceof PredefinedType) {
			return super.lookupProperty(owner, name);
		}
		
		return oldStyle.lookupProperty(owner, name);
	}
	
	@Override
	public EObject lookupState(EClassifier owner, List<String> path) {
		int lastIndex = path.size() - 1;
		String lastName = path.get(lastIndex);
		List<String> pathPrefix = path.subList(0, lastIndex);
		
		EList<EObject> states =  oldStyle.getStates(owner, pathPrefix);
		
		for (EObject s : states) {
			if (lastName.equals(oldStyle.getStateName(s))) {
				return s;
			}
		}
		
		return null;
	}

    @Override
	public void setSelfVariable(Variable<EClassifier, EParameter> var) {
		oldStyle.setSelfVariable(
				(org.eclipse.emf.ocl.expressions.Variable)
					CompatibilityUtil.getOldAS(oldStyle, var));
	}
	
    @Override
	public EOperation defineOperation(EClassifier owner, String name,
			EClassifier type, List<Variable<EClassifier, EParameter>> params,
			Constraint constraint) {
		EOperation result = TypeUtil.defineOperation(
				owner, name,
				CompatibilityUtil.getOldAS(oldStyle, params),
				(EClassifier) CompatibilityUtil.getOldAS(oldStyle, type));
		
		setDefinition(result, constraint);
		
		return result;
	}
	
    @Override
	public EStructuralFeature defineAttribute(EClassifier owner,
			Variable<EClassifier, EParameter> variable, Constraint constraint) {
		EStructuralFeature result = TypeUtil.defineProperty(
				owner,
				(org.eclipse.emf.ocl.expressions.Variable)
					CompatibilityUtil.getOldAS(oldStyle, variable));
		
		setDefinition(result, constraint);
		
		return result;
	}

	private void setDefinition(ETypedElement feature, Constraint constraint) {
		annotate(feature, constraint, Environment.ANNOTATION_URI_DEFINE);
	}
	
	private void annotate(ETypedElement feature, Constraint constraint, String annotation) {
		EAnnotation ann = feature.getEAnnotation(annotation);
		if (ann == null) {
			ann = EcoreFactory.eINSTANCE.createEAnnotation();
			ann.setSource(annotation);
			feature.getEAnnotations().add(ann);
		}
		
		org.eclipse.emf.ocl.uml.Constraint ct = (org.eclipse.emf.ocl.uml.Constraint)
			CompatibilityUtil.getOldAS(oldStyle, constraint);
		
		if (ann.getContents().isEmpty()) {
			ann.getContents().add(ct);
		} else {
			// replace existing initial or derived value expression
			ann.getContents().set(0, ct);
		}
	}
	
	private Constraint getAnnotation(ETypedElement feature, String annotation) {
		Constraint result = null;
		
		EAnnotation ann = feature.getEAnnotation(annotation);
		if ((ann != null) && !ann.getContents().isEmpty()) {
			result = (Constraint) CompatibilityUtil.getNewAS(
					oldStyle, ann.getContents().get(0));
		}
		
		return result;
	}
	
    @Override
	public void setBodyCondition(EOperation operation, Constraint constraint) {
		annotate(operation, constraint, Environment.ANNOTATION_URI_BODY);
	}
	
    @Override
	public Constraint getBodyCondition(EOperation operation) {
		return getAnnotation(operation, Environment.ANNOTATION_URI_BODY);
	}
	
    @Override
	public void setInitConstraint(EStructuralFeature property,
			Constraint constraint) {
		annotate(property, constraint, Environment.ANNOTATION_URI_INIT);
	}
	
    @Override
	public Constraint getInitConstraint(EStructuralFeature property) {
		return getAnnotation(property, Environment.ANNOTATION_URI_INIT);
	}
	
    @Override
	public void setDeriveConstraint(EStructuralFeature property,
			Constraint constraint) {
		annotate(property, constraint, Environment.ANNOTATION_URI_DERIVE);
	}
	
    @Override
	public Constraint getDeriveConstraint(EStructuralFeature property) {
		return getAnnotation(property, Environment.ANNOTATION_URI_DERIVE);
	}
	
    @Override
	public TypeResolver<EClassifier, EOperation, EStructuralFeature> getTypeResolver() {
		return (typeResolver != null)? typeResolver : super.getTypeResolver();
	}
    
    @Override
    public UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> getUMLReflection() {
        return uml;
    }
}
