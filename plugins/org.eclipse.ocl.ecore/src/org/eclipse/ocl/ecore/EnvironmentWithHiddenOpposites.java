/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.ecore;

import java.util.Map;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;
import org.eclipse.ocl.AbstractEnvironment;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.expressions.Variable;


/**
 * Adds methods regarding lookup and navigation of "hidden" opposite properties
 * to {@link Environment} and is implemented by {@link AbstractEnvironment}.
 * 
 * @author Axel Uhl
 * @since 3.1
 */
public interface EnvironmentWithHiddenOpposites
extends Environment<
EPackage, EClassifier, EOperation, EStructuralFeature,
EEnumLiteral, EParameter, EObject,
CallOperationAction, SendSignalAction, Constraint,
EClass, EObject>{
	/**
	 * Finds a property defined or inherited by the specified classifier, based
	 * on a hidden opposite's name which is specified in an annotation on the property.
	 * 
	 * @param owner the owner of the "hidden" (non-existing) property that we are looking for, or
	 *     <code>null</code> to find an implicit owner type (in iteration
     *     expressions)
	 * @param name the property name
	 * 
	 * @return the opposite property, or <code>null</code> if it could not be found
	 */ 	
	EStructuralFeature lookupOppositeProperty(EClassifier owner, String name) throws LookupException;
	
	/**
	 * Return the most appropriate matching variable to use as the implicit
	 * source of a call to the specified property.  Variables are returned based
	 * on inner-most scope first.
	 * 
	 * @param name the property name
	 * 
	 * @return the matching variable, or <code>null</code> if no appropriate
     *     variable can be found whose type defines a property of this name
	 */
	public Variable<EClassifier, EParameter> lookupImplicitSourceForOppositeProperty(String name);

	/**
	 * Determines a property's (hidden) opposite's type, assuming that there is not real opposite
	 * but that the opposite's type implicitly defaults to the property's owning class.
	 */
	EClassifier getOppositePropertyType(EClassifier owner, EStructuralFeature property);
	
	/**
	 * Finds all {@link EReference}s whose {@link ETypedElement#getEType() type}
	 * is <code>classifier</code> or any of <code>classifier</code>'s super
	 * types and that own an {@link EAnnotation annotation} with source
	 * {@link EMOFExtendedMetaData#EMOF_PACKAGE_NS_URI_2_0} containing a detail
	 * entry with key {@link EcoreEnvironment#PROPERTY_OPPOSITE_ROLE_NAME_KEY}.
	 * The value of the annotation detail is entered into the resulting map as a
	 * key, the {@link EReference} on which the annotation was found is entered
	 * into the result map as the corresponding value.
	 * <p>
	 * 
	 * @return a non-<code>null</code> map of all "hidden references" accessible from
	 *         <code>classifier</code> together with their corresponding forward
	 *         references
	 */
	Map<String, EStructuralFeature> getHiddenOppositeProperties(EClassifier classifier);
	
}
