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
 * $Id$
 */

package org.eclipse.emf.ocl.types.internal.impl;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ocl.expressions.VariableDeclaration;
import org.eclipse.emf.ocl.internal.OCLPlugin;
import org.eclipse.emf.ocl.internal.l10n.OCLMessages;
import org.eclipse.emf.ocl.internal.parser.OCLParser;
import org.eclipse.emf.ocl.types.TupleType;
import org.eclipse.emf.ocl.types.TypesFactory;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.osgi.util.NLS;

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

	static EPackage tuplePackage = EcoreFactory.eINSTANCE.createEPackage();

	private static final String TupleTypeMismatch_ERROR_ =
		OCLMessages.TupleTypeMismatch_ERROR_;

	private static final String TupleFieldNumMismatch_ERROR_ =
		OCLMessages.TupleFieldNumMismatch_ERROR_;

	private static final String TupleFieldNotFound_ERROR_ =
		OCLMessages.TupleFieldNotFound_ERROR_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TupleTypeImpl() {
		super();
	}

	/**
	 * vdlcs is a list of VariableDeclarations.
	 * Create a dynamic EMF class with attributes and types defined by the
	 * list of vdlcs.  Create a TupleType that references this dynamic object.
	 * @param vdcls
	 */
	protected TupleTypeImpl(EList vdcls) {

		EAttribute attr = null;
		EReference ref = null;

		this.setClassifierID(TypesPackage.TUPLE_TYPE);

		Iterator iter = vdcls.iterator();
		int i = 0;
		while (iter.hasNext()) {
			VariableDeclaration vdcl = (VariableDeclaration) iter.next();

			EClassifier type = vdcl.getType();
			if (vdcl.getVarName() == null || type == null)
				continue;
			i++;

			if (type instanceof EDataType) {
				attr = ecoreFactory.createEAttribute();
				attr.setName(vdcl.getVarName());
				// Convert the OCL type back to an EMF type, if primitive
				if (type == PrimitiveTypeImpl.OCL_BOOLEAN) {
					type = EcorePackage.eINSTANCE.getEBoolean();
				} else if (type == PrimitiveTypeImpl.OCL_INTEGER) {
					type = EcorePackage.eINSTANCE.getEIntegerObject();
				} else if (type == PrimitiveTypeImpl.OCL_STRING) {
					type = EcorePackage.eINSTANCE.getEString();
				} else if (type == PrimitiveTypeImpl.OCL_REAL) {
					type = EcorePackage.eINSTANCE.getEDoubleObject();
				}
				attr.setEType(type);
				getEStructuralFeatures().add(attr);
			} else if (type instanceof EClass) {
				ref = ecoreFactory.createEReference();
				ref.setName(vdcl.getVarName());
				ref.setEType(type);
				getEStructuralFeatures().add(ref);
			}
		}
	}

	/**
	 * See if the tuple type argument already has been generated in the tuplePackage.
	 * If so, return the existing tuple type.
	 * Otherwise, add the new type to the package, and return it.
	 * @param type
	 * @return the tuple type
	 */
	static protected TupleType addToTuplePackage(TupleType type) {
		// See if this is a new type, or an existing type
		EList classifiers = tuplePackage.getEClassifiers();
		Iterator citer = classifiers.iterator();
		while (citer.hasNext()) {
			TupleType c = (TupleType) citer.next();
			int result = -1;
			try {
				result = tupleCompare(type, c);
			} catch (IllegalArgumentException e) {
				continue;
			}
			if (result == 0) {
				return c;
			}
		}

		classifiers.add(type); // cannot find this type in the tuple package 
		return type;

	}

	/**
	 * For conformance, two tuples must have attributes with the same name,
	 * and all attribute types must conform. The common supertype is a tuple
	 * with the same attributes, with new attribute type equal to the common supertype
	 * of the corresponding attribute types.
	 * @param type
	 * @return the common tuple supertype
	 * @throws antlr.SemanticException
	 */
	public TupleType commonSuperType(EClassifier type)
		throws antlr.SemanticException {
		if (!(type instanceof TupleType)) {
			String message = NLS.bind(TupleTypeMismatch_ERROR_,
				new Object[] {this.getName(), type.getName() });
			OCLParser.ERR(message);
		}
		TupleType result = TypesFactory.eINSTANCE.createTupleType();
		TupleTypeImpl resultTuple = (TupleTypeImpl) result;
		resultTuple.setName("TupleType");//$NON-NLS-1$

		EList attrs1 = this.getEAttributes();
		EList attrs2 = ((EClass) type).getEAttributes();
		if (attrs1.size() != attrs2.size()) {
			String message = NLS.bind(TupleFieldNumMismatch_ERROR_,
				new Object[] {this.getName(), type.getName() });
			OCLParser.ERR(message);
		}

		Iterator iter1 = attrs1.iterator();
		while (iter1.hasNext()) {
			EAttribute attr1 = (EAttribute) iter1.next();
			boolean found = false;
			Iterator iter2 = attrs2.iterator();
			while (iter2.hasNext()) {
				EAttribute attr2 = (EAttribute) iter2.next();
				if (attr1.getName().equals(attr2.getName())) {
					EClassifier resultElementType = AnyTypeImpl
						.commonSuperType(attr1.getEType(), attr2.getEType());
					found = true;
					EAttribute attr = ecoreFactory.createEAttribute();
					attr.setName(attr1.getName());
					attr.setEType(resultElementType);
					resultTuple.getEStructuralFeatures().add(attr);
					break;
				}
			}
			if (!found) {
				String message = NLS.bind(
					TupleFieldNotFound_ERROR_, new Object[] {this.getName(),
						attr1.getName(), type.getName() });
				OCLParser.ERR(message);
			}
		}

		EList refs1 = this.getEReferences();
		EList refs2 = ((EClass) type).getEReferences();
		if (refs1.size() != refs2.size()) {
			String message = NLS.bind(TupleFieldNumMismatch_ERROR_,
				new Object[] {this.getName(), type.getName() });
			OCLParser.ERR(message);
		}

		iter1 = refs1.iterator();
		while (iter1.hasNext()) {
			EReference ref1 = (EReference) iter1.next();
			boolean found = false;
			Iterator iter2 = refs2.iterator();
			while (iter2.hasNext()) {
				EReference ref2 = (EReference) iter2.next();
				if (ref1.getName().equals(ref2.getName())) {
					EClassifier resultElementType = AnyTypeImpl
						.commonSuperType(ref1.getEType(), ref2.getEType());
					found = true;
					EReference ref = ecoreFactory.createEReference();
					ref.setName(ref1.getName());
					ref.setEType(resultElementType);
					resultTuple.getEStructuralFeatures().add(ref);
					break;
				}
			}
			if (!found) {
				String message = NLS.bind(
					TupleFieldNotFound_ERROR_, new Object[] {this.getName(),
						ref1.getName(), type.getName() });
				OCLParser.ERR(message);
			}
		}
		return addToTuplePackage(result);
	}

	/**
	 * Compare 2  tuple types.  Returns 0 if types are exactly equal,
	 * 	    -1 if type1 conforms to type2 (type1 is a subtype of type2)
	 * 		 1 if type2 conforms to type1  (type2 is a subtype of type1)
	 * Conformance is on element by element basis.
	 * @param type
	 * @return the ordering key
	 * @throws IllegalArgumentException if there is no type conformance.
	 */
	public int typeCompare(EClassifier type) {

		if (!(type instanceof TupleType)) {
			String message = NLS.bind(TupleTypeMismatch_ERROR_,
				new Object[] {this.getName(), type.getName() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(getClass(), "typeCompare", error);//$NON-NLS-1$
			throw error;
		}
		return tupleCompare(this, (EClass) type);
	}

	/**
	 * Compare 2  Tuple eclasses.  Returns 0 if types are exactly equal,
	 * 	    -1 if type1 conforms to type2 (type1 is a subtype of type2)
	 * 		 1 if type2 conforms to type1  (type2 is a subtype of type1)
	 * Conformance is on element by element basis.
	 * @param type
	 * @return the ordering key
	 * @throws IllegalArgumentException if there is no type conformance.
	 */
	private static int tupleCompare(EClass eclazz1, EClass eclazz2) {

		EList attrs1 = eclazz1.getEAttributes();
		EList attrs2 = eclazz2.getEAttributes();
		if (attrs1.size() != attrs2.size()) {
			String message = NLS.bind(TupleFieldNumMismatch_ERROR_,
				new Object[] {eclazz1.getName(), eclazz2.getName() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(TupleTypeImpl.class,
				"eclassCompare", error);//$NON-NLS-1$
			throw error;
		}

		Iterator iter1 = attrs1.iterator();

		int result = 0; // assume arguments are the same.
		while (iter1.hasNext()) {
			EAttribute attr1 = (EAttribute) iter1.next();
			boolean found = false;
			Iterator iter2 = attrs2.iterator();
			while (iter2.hasNext()) {
				EAttribute attr2 = (EAttribute) iter2.next();
				if (attr1.getName().equals(attr2.getName())) {
					/*
					 * The attribute types must conform in the same direction.
					 */
					int attrResult = AnyTypeImpl.typeCompare(attr1.getEType(),
						attr2.getEType());
					if (result == 0)
						result = attrResult;
					else if (result != attrResult) {
						String message = NLS.bind(
							TupleFieldNotFound_ERROR_, new Object[] {
								eclazz1.getName(), attr1.getName(),
								eclazz2.getName() });
						IllegalArgumentException error = new IllegalArgumentException(
							message);
						OCLPlugin.throwing(TupleTypeImpl.class,
							"eclassCompare", error);//$NON-NLS-1$
						throw error;
					}
					found = true;
					break;
				}
			}
			if (!found) {
				String message = NLS.bind(TupleTypeMismatch_ERROR_,
					new Object[] {eclazz1.getName(), eclazz2.getName() });
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(TupleTypeImpl.class,
					"eclassCompare", error);//$NON-NLS-1$
				throw error;
			}
		}

		EList refs1 = eclazz1.getEReferences();
		EList refs2 = eclazz2.getEReferences();
		if (refs1.size() != refs2.size()) {
			String message = NLS.bind(TupleFieldNumMismatch_ERROR_,
				new Object[] {eclazz1.getName(), eclazz2.getName() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OCLPlugin.throwing(TupleTypeImpl.class,
				"eclassCompare", error);//$NON-NLS-1$
			throw error;
		}

		iter1 = refs1.iterator();

		while (iter1.hasNext()) {
			EReference ref1 = (EReference) iter1.next();
			boolean found = false;
			Iterator iter2 = refs2.iterator();
			while (iter2.hasNext()) {
				EReference ref2 = (EReference) iter2.next();
				if (ref1.getName().equals(ref2.getName())) {
					int referenceResult = AnyTypeImpl.typeCompare(ref1
						.getEType(), ref2.getEType());
					if (result == 0)
						result = referenceResult;
					else if (result != referenceResult) {
						String message = NLS.bind(
							TupleFieldNotFound_ERROR_, new Object[] {
								eclazz1.getName(), ref1.getName(),
								eclazz2.getName() });
						IllegalArgumentException error = new IllegalArgumentException(
							message);
						OCLPlugin.throwing(TupleTypeImpl.class,
							"eclassCompare", error);//$NON-NLS-1$
						throw error;
					}
					found = true;

					break;
				}
			}
			if (!found) {
				String message = NLS.bind(TupleTypeMismatch_ERROR_,
					new Object[] {eclazz1.getName(), eclazz2.getName() });
				IllegalArgumentException error = new IllegalArgumentException(
					message);
				OCLPlugin.throwing(TupleTypeImpl.class,
					"eclassCompare", error);//$NON-NLS-1$
				throw error;
			}
		}
		return result;
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
