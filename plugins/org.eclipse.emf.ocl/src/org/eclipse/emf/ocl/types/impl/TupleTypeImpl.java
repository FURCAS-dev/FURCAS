/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: TupleTypeImpl.java,v 1.5 2006/04/28 14:46:28 cdamus Exp $
 */

package org.eclipse.emf.ocl.types.impl;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ocl.internal.l10n.OCLMessages;
import org.eclipse.emf.ocl.internal.parser.OCLParser;
import org.eclipse.emf.ocl.parser.SemanticException;
import org.eclipse.emf.ocl.types.TupleType;
import org.eclipse.emf.ocl.types.TypesFactory;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.uml.TypedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tuple Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TupleTypeImpl
	extends EClassImpl
	implements TupleType {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = ""; //$NON-NLS-1$

	static EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;

	static EcorePackage ecorePackage = EcorePackage.eINSTANCE;

	static TypesPackage typesPackage = TypesPackage.eINSTANCE;

	static TypesFactory typesFactory = TypesFactory.eINSTANCE;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TupleTypeImpl() {
		super();
	}

	/**
	 * Create a dynamic EMF class with attributes and types defined by the
	 * set of tuple parts.
	 * 
	 * @param parts a list of {@link TypedElement}s
	 */
	protected TupleTypeImpl(List tupleParts) {

		this.setClassifierID(TypesPackage.TUPLE_TYPE);

		Iterator iter = tupleParts.iterator();
		while (iter.hasNext()) {
			TypedElement next = (TypedElement) iter.next();
			
			if (next.getName() == null || next.getType() == null)
				continue;

			getEStructuralFeatures().add(TypeUtil.createProperty(next));
		}
	}

	/**
	 * @generated NOT
	 */
	public String getName() {
		if (name == null) {
			StringBuffer buf = new StringBuffer();
			buf.append("Tuple("); //$NON-NLS-1$
			
			for (Iterator iter = getEStructuralFeatures().iterator(); iter.hasNext();) {
				EStructuralFeature part = (EStructuralFeature) iter.next();
				buf.append(part.getName());
				buf.append(": "); //$NON-NLS-1$
				buf.append(TypeUtil.getName(part.getEType()));
				
				if (iter.hasNext()) {
					buf.append(", "); //$NON-NLS-1$
				}
			}
			
			buf.append(')');
			
			name = buf.toString();
		}
		
		return super.getName();
	}

	/**
	 * For conformance, two tuples must have attributes with the same name,
	 * and all attribute types must conform. The common supertype is a tuple
	 * with the same attributes, with new attribute type equal to the common supertype
	 * of the corresponding attribute types.
	 * @param type
	 * @return the common tuple supertype
	 * @throws SemanticException
	 * 
	 * @generated NOT
	 */
	public EClassifier getCommonSupertype(EClassifier type)
		throws SemanticException {
		if (!(type instanceof TupleType)) {
			String message = OCLMessages.bind(
					OCLMessages.TupleTypeMismatch_ERROR_,
					this.getName(),
					TypeUtil.getName(type));
			OCLParser.ERR(message);
		}
		
		EList props1 = this.getEStructuralFeatures();
		EList props2 = ((TupleType) type).getEStructuralFeatures();
		if (props1.size() != props2.size()) {
			String message = OCLMessages.bind(
					OCLMessages.TupleFieldNumMismatch_ERROR_,
					this.getName(),
					TypeUtil.getName(type));
			OCLParser.ERR(message);
		}

		TupleType result = TypesFactory.eINSTANCE.createTupleType();
		TupleTypeImpl resultTuple = (TupleTypeImpl) result;
		resultTuple.setName("TupleType");//$NON-NLS-1$

		Iterator iter1 = props1.iterator();
		while (iter1.hasNext()) {
			EStructuralFeature prop1 = (EStructuralFeature) iter1.next();
			boolean found = false;
			Iterator iter2 = props2.iterator();
			while (iter2.hasNext()) {
				EStructuralFeature prop2 = (EStructuralFeature) iter2.next();
				if (prop1.getName().equals(prop2.getName())) {
					EClassifier resultElementType = TypeUtil
						.commonSuperType(prop1.getEType(), prop2.getEType());
					found = true;
					EAttribute attr = ecoreFactory.createEAttribute();
					attr.setName(prop1.getName());
					attr.setEType(resultElementType);
					resultTuple.getEStructuralFeatures().add(attr);
					break;
				}
			}
			if (!found) {
				String message = OCLMessages.bind(
						OCLMessages.TupleFieldNotFound_ERROR_,
						new Object[] {
								this.getName(),
								prop1.getName(),
								type.getName()});
				OCLParser.ERR(message);
			}
		}
		
		return result;
	}

	/**
	 * @generated NOT
	 */
	public int getRelationshipTo(EClassifier type) {

		if (!(type instanceof TupleType)) {
			return UNRELATED_TYPE;
		}

		EList myProperties = getEStructuralFeatures();
		EList otherProperties = ((TupleType) type).getEStructuralFeatures();
		
		if (myProperties.size() != otherProperties.size()) {
			return UNRELATED_TYPE;
		}

		int result = SAME_TYPE; // assume properties are the same.

		Iterator iter1 = myProperties.iterator();
		while (iter1.hasNext()) {
			EStructuralFeature prop1 = (EStructuralFeature) iter1.next();
			boolean found = false;
			
			Iterator iter2 = otherProperties.iterator();
			while (iter2.hasNext()) {
				EStructuralFeature prop2 = (EStructuralFeature) iter2.next();
				if (prop1.getName().equals(prop2.getName())) {
					/*
					 * The feature types must conform in the same direction.
					 */
					int propResult = TypeUtil.getRelationship(
							prop1.getEType(),
							prop2.getEType());
					
					if (result == SAME_TYPE)
						result = propResult;
					else if (result != propResult) {
						return UNRELATED_TYPE;
					}
					found = true;
					break;
				}
			}
			if (!found) {
				return UNRELATED_TYPE;
			}
		}
		
		return result;
	}
	
	/**
	 * @generated NOT
	 */
	public EList getOperations() {
		return AnyTypeImpl.createAnyOperations();
	}
	
	/**
	 * @generated NOT
	 */
	public int getOperationCodeFor(String operName) {
		return AnyTypeImpl.getOperationCode(operName);
	}

	/**
	 * @generated NOT
	 */
	public String getOperationNameFor(int opcode) {
		return AnyTypeImpl.getOperationName(opcode);
	}
	
	/**
	 * @generated NOT
	 */
	public EClassifier getResultTypeFor(EClassifier ownerType, int opcode, EList args) throws SemanticException {
		return AnyTypeImpl.getResultType(ownerType, opcode, args);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TypesPackage.Literals.TUPLE_TYPE;
	}

} //TupleTypeImpl
