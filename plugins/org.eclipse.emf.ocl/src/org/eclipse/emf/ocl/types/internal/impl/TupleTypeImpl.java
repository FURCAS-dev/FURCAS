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

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ocl.expressions.VariableDeclaration;
import org.eclipse.emf.ocl.internal.OclEnginePlugin;
import org.eclipse.emf.ocl.internal.l10n.OclMessages;
import org.eclipse.emf.ocl.internal.parser.OclParser;
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

	static EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;

	static EcorePackage ecorePackage = EcorePackage.eINSTANCE;

	static TypesPackage typesPackage = TypesPackage.eINSTANCE;

	static TypesFactory typesFactory = TypesFactory.eINSTANCE;

	static EPackage tuplePackage = EcoreFactory.eINSTANCE.createEPackage();

	private static final String TupleTypeMismatch_ERROR_ =
		OclMessages.TupleTypeMismatch_ERROR_;

	private static final String TupleFieldNumMismatch_ERROR_ =
		OclMessages.TupleFieldNumMismatch_ERROR_;

	private static final String TupleFieldNotFound_ERROR_ =
		OclMessages.TupleFieldNotFound_ERROR_;

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
				getEAttributes().add(attr);
			} else if (type instanceof EClass) {
				ref = ecoreFactory.createEReference();
				ref.setName(vdcl.getVarName());
				ref.setEType(type);
				getEReferences().add(ref);
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
			OclParser.ERR(message);
		}
		TupleType result = TypesFactory.eINSTANCE.createTupleType();
		TupleTypeImpl resultTuple = (TupleTypeImpl) result;
		resultTuple.setName("TupleType");//$NON-NLS-1$

		EList attrs1 = this.getEAttributes();
		EList attrs2 = ((EClass) type).getEAttributes();
		if (attrs1.size() != attrs2.size()) {
			String message = NLS.bind(TupleFieldNumMismatch_ERROR_,
				new Object[] {this.getName(), type.getName() });
			OclParser.ERR(message);
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
					resultTuple.getEAttributes().add(attr);
					break;
				}
			}
			if (!found) {
				String message = NLS.bind(
					TupleFieldNotFound_ERROR_, new Object[] {this.getName(),
						attr1.getName(), type.getName() });
				OclParser.ERR(message);
			}
		}

		EList refs1 = this.getEReferences();
		EList refs2 = ((EClass) type).getEReferences();
		if (refs1.size() != refs2.size()) {
			String message = NLS.bind(TupleFieldNumMismatch_ERROR_,
				new Object[] {this.getName(), type.getName() });
			OclParser.ERR(message);
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
					resultTuple.getEReferences().add(ref);
					break;
				}
			}
			if (!found) {
				String message = NLS.bind(
					TupleFieldNotFound_ERROR_, new Object[] {this.getName(),
						ref1.getName(), type.getName() });
				OclParser.ERR(message);
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
			OclEnginePlugin.throwing(getClass(), "typeCompare", error);//$NON-NLS-1$
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
			OclEnginePlugin.throwing(TupleTypeImpl.class,
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
						OclEnginePlugin.throwing(TupleTypeImpl.class,
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
				OclEnginePlugin.throwing(TupleTypeImpl.class,
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
			OclEnginePlugin.throwing(TupleTypeImpl.class,
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
						OclEnginePlugin.throwing(TupleTypeImpl.class,
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
				OclEnginePlugin.throwing(TupleTypeImpl.class,
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
		return TypesPackage.eINSTANCE.getTupleType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case TypesPackage.TUPLE_TYPE__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case TypesPackage.TUPLE_TYPE__EPACKAGE:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, TypesPackage.TUPLE_TYPE__EPACKAGE, msgs);
				case TypesPackage.TUPLE_TYPE__EOPERATIONS:
					return ((InternalEList)getEOperations()).basicAdd(otherEnd, msgs);
				case TypesPackage.TUPLE_TYPE__ESTRUCTURAL_FEATURES:
					return ((InternalEList)getEStructuralFeatures()).basicAdd(otherEnd, msgs);
				default:
					return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
			}
		}
		if (eContainer != null)
			msgs = eBasicRemoveFromContainer(msgs);
		return eBasicSetContainer(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case TypesPackage.TUPLE_TYPE__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case TypesPackage.TUPLE_TYPE__EPACKAGE:
					return eBasicSetContainer(null, TypesPackage.TUPLE_TYPE__EPACKAGE, msgs);
				case TypesPackage.TUPLE_TYPE__EOPERATIONS:
					return ((InternalEList)getEOperations()).basicRemove(otherEnd, msgs);
				case TypesPackage.TUPLE_TYPE__ESTRUCTURAL_FEATURES:
					return ((InternalEList)getEStructuralFeatures()).basicRemove(otherEnd, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
		if (eContainerFeatureID >= 0) {
			switch (eContainerFeatureID) {
				case TypesPackage.TUPLE_TYPE__EPACKAGE:
					return eContainer.eInverseRemove(this, EcorePackage.EPACKAGE__ECLASSIFIERS, EPackage.class, msgs);
				default:
					return eDynamicBasicRemoveFromContainer(msgs);
			}
		}
		return eContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - eContainerFeatureID, null, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TypesPackage.TUPLE_TYPE__EANNOTATIONS:
				return getEAnnotations();
			case TypesPackage.TUPLE_TYPE__NAME:
				return getName();
			case TypesPackage.TUPLE_TYPE__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case TypesPackage.TUPLE_TYPE__INSTANCE_CLASS:
				return getInstanceClass();
			case TypesPackage.TUPLE_TYPE__DEFAULT_VALUE:
				return getDefaultValue();
			case TypesPackage.TUPLE_TYPE__EPACKAGE:
				return getEPackage();
			case TypesPackage.TUPLE_TYPE__ABSTRACT:
				return isAbstract() ? Boolean.TRUE : Boolean.FALSE;
			case TypesPackage.TUPLE_TYPE__INTERFACE:
				return isInterface() ? Boolean.TRUE : Boolean.FALSE;
			case TypesPackage.TUPLE_TYPE__ESUPER_TYPES:
				return getESuperTypes();
			case TypesPackage.TUPLE_TYPE__EOPERATIONS:
				return getEOperations();
			case TypesPackage.TUPLE_TYPE__EALL_ATTRIBUTES:
				return getEAllAttributes();
			case TypesPackage.TUPLE_TYPE__EALL_REFERENCES:
				return getEAllReferences();
			case TypesPackage.TUPLE_TYPE__EREFERENCES:
				return getEReferences();
			case TypesPackage.TUPLE_TYPE__EATTRIBUTES:
				return getEAttributes();
			case TypesPackage.TUPLE_TYPE__EALL_CONTAINMENTS:
				return getEAllContainments();
			case TypesPackage.TUPLE_TYPE__EALL_OPERATIONS:
				return getEAllOperations();
			case TypesPackage.TUPLE_TYPE__EALL_STRUCTURAL_FEATURES:
				return getEAllStructuralFeatures();
			case TypesPackage.TUPLE_TYPE__EALL_SUPER_TYPES:
				return getEAllSuperTypes();
			case TypesPackage.TUPLE_TYPE__EID_ATTRIBUTE:
				return getEIDAttribute();
			case TypesPackage.TUPLE_TYPE__ESTRUCTURAL_FEATURES:
				return getEStructuralFeatures();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TypesPackage.TUPLE_TYPE__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case TypesPackage.TUPLE_TYPE__NAME:
				setName((String)newValue);
				return;
			case TypesPackage.TUPLE_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case TypesPackage.TUPLE_TYPE__ABSTRACT:
				setAbstract(((Boolean)newValue).booleanValue());
				return;
			case TypesPackage.TUPLE_TYPE__INTERFACE:
				setInterface(((Boolean)newValue).booleanValue());
				return;
			case TypesPackage.TUPLE_TYPE__ESUPER_TYPES:
				getESuperTypes().clear();
				getESuperTypes().addAll((Collection)newValue);
				return;
			case TypesPackage.TUPLE_TYPE__EOPERATIONS:
				getEOperations().clear();
				getEOperations().addAll((Collection)newValue);
				return;
			case TypesPackage.TUPLE_TYPE__ESTRUCTURAL_FEATURES:
				getEStructuralFeatures().clear();
				getEStructuralFeatures().addAll((Collection)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TypesPackage.TUPLE_TYPE__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case TypesPackage.TUPLE_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TypesPackage.TUPLE_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case TypesPackage.TUPLE_TYPE__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case TypesPackage.TUPLE_TYPE__INTERFACE:
				setInterface(INTERFACE_EDEFAULT);
				return;
			case TypesPackage.TUPLE_TYPE__ESUPER_TYPES:
				getESuperTypes().clear();
				return;
			case TypesPackage.TUPLE_TYPE__EOPERATIONS:
				getEOperations().clear();
				return;
			case TypesPackage.TUPLE_TYPE__ESTRUCTURAL_FEATURES:
				getEStructuralFeatures().clear();
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TypesPackage.TUPLE_TYPE__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case TypesPackage.TUPLE_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TypesPackage.TUPLE_TYPE__INSTANCE_CLASS_NAME:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case TypesPackage.TUPLE_TYPE__INSTANCE_CLASS:
				return INSTANCE_CLASS_EDEFAULT == null ? getInstanceClass() != null : !INSTANCE_CLASS_EDEFAULT.equals(getInstanceClass());
			case TypesPackage.TUPLE_TYPE__DEFAULT_VALUE:
				return DEFAULT_VALUE_EDEFAULT == null ? getDefaultValue() != null : !DEFAULT_VALUE_EDEFAULT.equals(getDefaultValue());
			case TypesPackage.TUPLE_TYPE__EPACKAGE:
				return getEPackage() != null;
			case TypesPackage.TUPLE_TYPE__ABSTRACT:
				return ((eFlags & ABSTRACT_EFLAG) != 0) != ABSTRACT_EDEFAULT;
			case TypesPackage.TUPLE_TYPE__INTERFACE:
				return ((eFlags & INTERFACE_EFLAG) != 0) != INTERFACE_EDEFAULT;
			case TypesPackage.TUPLE_TYPE__ESUPER_TYPES:
				return eSuperTypes != null && !eSuperTypes.isEmpty();
			case TypesPackage.TUPLE_TYPE__EOPERATIONS:
				return eOperations != null && !eOperations.isEmpty();
			case TypesPackage.TUPLE_TYPE__EALL_ATTRIBUTES:
				return !getEAllAttributes().isEmpty();
			case TypesPackage.TUPLE_TYPE__EALL_REFERENCES:
				return !getEAllReferences().isEmpty();
			case TypesPackage.TUPLE_TYPE__EREFERENCES:
				return !getEReferences().isEmpty();
			case TypesPackage.TUPLE_TYPE__EATTRIBUTES:
				return !getEAttributes().isEmpty();
			case TypesPackage.TUPLE_TYPE__EALL_CONTAINMENTS:
				return !getEAllContainments().isEmpty();
			case TypesPackage.TUPLE_TYPE__EALL_OPERATIONS:
				return !getEAllOperations().isEmpty();
			case TypesPackage.TUPLE_TYPE__EALL_STRUCTURAL_FEATURES:
				return !getEAllStructuralFeatures().isEmpty();
			case TypesPackage.TUPLE_TYPE__EALL_SUPER_TYPES:
				return !getEAllSuperTypes().isEmpty();
			case TypesPackage.TUPLE_TYPE__EID_ATTRIBUTE:
				return getEIDAttribute() != null;
			case TypesPackage.TUPLE_TYPE__ESTRUCTURAL_FEATURES:
				return eStructuralFeatures != null && !eStructuralFeatures.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

} //TupleTypeImpl
