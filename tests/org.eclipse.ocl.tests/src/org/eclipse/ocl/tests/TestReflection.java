/**
 * <copyright>
 * 
 * Copyright (c) 2009 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Ed Willink - Bug 254919; Initial API and implementation
 *
 * </copyright>
 *
 * $Id: TestReflection.java,v 1.1 2009/11/26 20:44:38 ewillink Exp $
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

	String getAbstractOperationName();

	String getAttributeParentTypeName();

	String getAttributeTypeName();

	String getAttributesFeatureName();

	C getBigDecimal();

	C getBigInteger();

	OCLExpression<C> getBodyExpression(CT constraint);

	C getClassTypeContext();

	String getClassTypeName();

	C getClassifierTypeContext();

	C getCollectionKindTypeContext();

	String getCommentElementName();

	C getCommentTypeContext();

	String getCommentTypeName();

	String getConformsToOperationName();
	
	Class<CT> getConstraintClass();

//	String getDataTypeTypeName();

//	C getDefaultSetType(Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> environment);

	String getDerivedOperationName();

	EPackage getEPackage(PK pkg);
	
	PT getEcoreBigDecimal();
	
	PT getEcoreBigInteger();
	
	PT getEcoreLong();

	PK getEcorePrimitiveTypes();

	String getEnumerationTypeName();

	String getFruitModelPath();
    
	C getMetaclass(String name);

	String getModelPackageName();

	String getMultiplicityElementTypeName();
	
	String getNsURI(PK aPackage);

	C getOwner(O context);
	
	PK getResourcePackage(ResourceSet resourceSet, URI uri);

	C getStringTypeContext();

	String getStringTypeName();

	String getTypesPackageName();
	
	PT getUMLBoolean();

	PT getUMLInteger();

	PT getUMLLong();

	PK getUMLMetamodel();

	PK getUMLPrimitiveTypes();

	PT getUMLString();

	PT getUMLUnlimitedNatural();

	int getUnlimitedValue();

	String getUpperOperationName();

	void setAbstract(CLS aClass, boolean isAbstract);

	void setIsOrdered(P aProperty, boolean isOrdered);

	void setIsQuery(O anOperation, boolean isQuery);

	void setIsUnique(P aProperty, boolean isUnique);

	void setName(CLS aClass, String name);
	
	void setNsPrefix(PK aPackage, String name);
	
	void setNsURI(PK aPackage, String name);

	void setUpper(P aProperty, int value);

	boolean usesCompareTo();
}