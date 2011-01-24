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
 * $Id: TestReflection.java,v 1.2 2011/01/24 23:31:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.generic;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.OclExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.UMLReflection;

/**
 * Extended reflection capabilities for generic tests.
 */
public interface TestReflection extends UMLReflection {

	/**
	 * Extended environment-independent reflection capabilities for generic tests.
	 * This is used during test startup when no environment is ready preventing
	 * creation of the UML reflection which is environment-specific. (Why is it?).
	 */
	public static interface Static {
		OCL createOCL(ResourceSet resourceSet);
		TestReflection createReflection(Environment environment);
		ResourceSet createResourceSet();
		String getTestPlugInId();
	}
	
	void addSupertype(org.eclipse.ocl.examples.pivot.Class aClass, org.eclipse.ocl.examples.pivot.Class superType);

	org.eclipse.ocl.examples.pivot.Class createClass();

	EObject createComment();

	/**
	 * Creates a new {@link org.eclipse.uml2.uml.Generalization}, with the specified '<em><b>General</b></em>', and appends it to the '<em><b>Generalization</b></em>' containment reference list.
	 */
	void createGeneralization(Type special, Type general);

	org.eclipse.ocl.examples.pivot.Package createNestedPackage(org.eclipse.ocl.examples.pivot.Package aPackage, String name);

	Property createOwnedAttribute(org.eclipse.ocl.examples.pivot.Class aClass, String name, Type type);

	org.eclipse.ocl.examples.pivot.Class createOwnedClass(org.eclipse.ocl.examples.pivot.Package aPackage, String name, boolean isAbstract);

	Enumeration createOwnedEnumeration(org.eclipse.ocl.examples.pivot.Package aPackage, String name);

	EnumerationLiteral createOwnedLiteral(Enumeration anEnumeration, String name);
	
	Operation createOwnedOperation(org.eclipse.ocl.examples.pivot.Class aClass, String name, List<String> paramNames, List<Type> paramTypes, Type type, boolean isQuery);

	Operation createOwnedPrimitiveOperation(Type aPrimitiveType, String name, List<String> paramNames, List<Type> paramTypes, Type type, boolean isQuery);

	Type createOwnedPrimitiveType(org.eclipse.ocl.examples.pivot.Package aPackage, String name);

	Property createOwnedReference(org.eclipse.ocl.examples.pivot.Class aClass, String name, org.eclipse.ocl.examples.pivot.Class type);

	org.eclipse.ocl.examples.pivot.Package createPackage(String name);

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
	Property getAttribute(Type classifier, String name, Type type);

//	Type getBigDecimal();

//	Type getBigInteger();

	OclExpression getBodyExpression(Constraint constraint);

//	Type getClassTypeContext();

//	Type getClassifierTypeContext();

//	Type getCollectionKindTypeContext();

//	Type getCommentTypeContext();
	
	Class<Constraint> getConstraintClass();

//	Type getDefaultSetType(Environment environment);

	EPackage getEPackage(org.eclipse.ocl.examples.pivot.Package pkg);
	
//	Type getEcoreBigDecimal();
	
//	Type getEcoreBigInteger();
	
//	Type getEcoreLong();

	org.eclipse.ocl.examples.pivot.Package getEcorePrimitiveTypes();

	String getFruitModelPath();
    
	Type getMetaclass(String name);
	
	String getNsURI(org.eclipse.ocl.examples.pivot.Package aPackage);

	Type getOwner(Operation context);
	
	org.eclipse.ocl.examples.pivot.Package getResourcePackage(ResourceSet resourceSet, URI uri);

//	Type getStringTypeContext();
	
	Type getUMLBoolean();

	Type getUMLInteger();

//	Type getUMLLong();

	org.eclipse.ocl.examples.pivot.Package getUMLMetamodel();

	org.eclipse.ocl.examples.pivot.Package getUMLPrimitiveTypes();

	Type getUMLString();

	Type getUMLUnlimitedNatural();

	int getUnlimitedValue();

	/**
	 * Return true if key denotes an ordered multiplicity.
	 */
    boolean isOrdered(String key);

	/**
	 * Return true if key denotes a unique multiplicity.
	 */
    boolean isUnique(String key);

	void setAbstract(org.eclipse.ocl.examples.pivot.Class aClass, boolean isAbstract);

	void setIsOrdered(Property aProperty, boolean isOrdered);

	void setIsQuery(Operation anOperation, boolean isQuery);

	void setIsUnique(Property aProperty, boolean isUnique);

	void setName(org.eclipse.ocl.examples.pivot.Class aClass, String name);
	
	void setNsPrefix(org.eclipse.ocl.examples.pivot.Package aPackage, String name);
	
	void setNsURI(org.eclipse.ocl.examples.pivot.Package aPackage, String name);

	void setOperationUpper(Operation anOperation, int value);

	void setUpper(Property aProperty, int value);

	boolean usesCompareTo();
}