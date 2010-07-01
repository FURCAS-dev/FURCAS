/**
 * <copyright>
 * 
 * Copyright (c) 2009 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   E.D.Willink - Bug 254919, 296409
 *
 * </copyright>
 *
 * $Id: TestReflection.java,v 1.3 2010/04/25 06:50:19 ewillink Exp $
 */
package org.eclipse.ocl.tests;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * Extended reflection capabilities for generic tests.
 */
public interface TestReflection<E, PK extends E, T extends E, C extends T, CLS extends C, DT extends C, PT extends C, ET extends DT, O extends E, PM extends E, P extends E, PA extends P, PR extends P, EL, S, COA, SSA, CT>
	extends UMLReflection<PK, C, O, P, EL, PM, S, COA, SSA, CT> {

	/**
	 * Extended environment-independent reflection capabilities for generic tests.
	 * This is used during test startup when no environment is ready preventing
	 * creation of the UML reflection which is environment-specific. (Why is it?).
	 */
	public static interface Static<E, PK extends E, T extends E, C extends T, CLS extends C, DT extends C, PT extends C, ET extends DT, O extends E, PM extends E, P extends E, PA extends P, PR extends P, EL, S, COA, SSA, CT> {
		OCL<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> createOCL(ResourceSet resourceSet);
		TestReflection<E, PK, T, C, CLS, DT, PT, ET, O, PM, P, PA, PR, EL, S, COA, SSA, CT> createReflection(Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> environment);
		ResourceSet createResourceSet();
		String getTestPlugInId();
	}
	
	void addSupertype(CLS aClass, CLS superType);

	CLS createClass();

	EObject createComment();

	/**
	 * Creates a new {@link org.eclipse.uml2.uml.Generalization}, with the specified '<em><b>General</b></em>', and appends it to the '<em><b>Generalization</b></em>' containment reference list.
	 */
	void createGeneralization(C special, C general);

	PK createNestedPackage(PK aPackage, String name);

	PA createOwnedAttribute(CLS aClass, String name, C type);

	CLS createOwnedClass(PK aPackage, String name, boolean isAbstract);

	ET createOwnedEnumeration(PK aPackage, String name);

	EL createOwnedLiteral(ET anEnumeration, String name);
	
	O createOwnedOperation(CLS aClass, String name, EList<String> paramNames, EList<T> paramTypes, T type, boolean isQuery);

	O createOwnedPrimitiveOperation(PT aPrimitiveType, String name, EList<String> paramNames, EList<T> paramTypes, T type, boolean isQuery);

	PT createOwnedPrimitiveType(PK aPackage, String name);

	PR createOwnedReference(CLS aClass, String name, CLS type);

	PK createPackage(String name);

	/**
	 * Return the denormalized key for use in an OCL test expressions.
	 * For instance map Reference to Property for UML and to EReference for Ecore.
	 * 
	 * @return denormalized key if defined or null if undefined.
	 */
	String denormalize(String key);

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Property} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>' from the '<em><b>Attribute</b></em>' reference list.
	 * @param name The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Property} to retrieve, or <code>null</code>.
	 * @param type The '<em><b>Type</b></em>' of the {@link org.eclipse.uml2.uml.Property} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.Property} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>', or <code>null</code>.
	 */
	P getAttribute(C classifier, String name, T type);

	C getBigDecimal();

	C getBigInteger();

	OCLExpression<C> getBodyExpression(CT constraint);

	C getClassTypeContext();

	C getClassifierTypeContext();

	C getCollectionKindTypeContext();

	C getCommentTypeContext();
	
	Class<CT> getConstraintClass();

//	C getDefaultSetType(Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> environment);

	EPackage getEPackage(PK pkg);
	
	PT getEcoreBigDecimal();
	
	PT getEcoreBigInteger();
	
	PT getEcoreLong();

	PK getEcorePrimitiveTypes();

	String getFruitModelPath();
    
	C getMetaclass(String name);
	
	String getNsURI(PK aPackage);

	C getOwner(O context);
	
	PK getResourcePackage(ResourceSet resourceSet, URI uri);

	C getStringTypeContext();
	
	PT getUMLBoolean();

	PT getUMLInteger();

	PT getUMLLong();

	PK getUMLMetamodel();

	PK getUMLPrimitiveTypes();

	PT getUMLString();

	PT getUMLUnlimitedNatural();

	int getUnlimitedValue();

	/**
	 * Return true if key denotes an ordered multiplicity.
	 */
    boolean isOrdered(String key);

	/**
	 * Return true if key denotes a unique multiplicity.
	 */
    boolean isUnique(String key);

	void setAbstract(CLS aClass, boolean isAbstract);

	void setIsOrdered(P aProperty, boolean isOrdered);

	void setIsQuery(O anOperation, boolean isQuery);

	void setIsUnique(P aProperty, boolean isUnique);

	void setName(CLS aClass, String name);
	
	void setNsPrefix(PK aPackage, String name);
	
	void setNsURI(PK aPackage, String name);

	void setOperationUpper(O anOperation, int value);

	void setUpper(P aProperty, int value);

	boolean usesCompareTo();
}