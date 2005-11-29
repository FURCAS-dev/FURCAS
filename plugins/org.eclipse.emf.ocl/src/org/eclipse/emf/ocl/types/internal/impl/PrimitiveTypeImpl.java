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

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.types.PrimitiveType;
import org.eclipse.emf.ocl.types.TypesPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PrimitiveTypeImpl extends AnyTypeImpl implements PrimitiveType {
	
	/*
	 * Define Primitive type instances for each of the stdlib primitive types
	 */
	public static PrimitiveType OCL_INTEGER = new PrimitiveIntegerImpl("Integer");//$NON-NLS-1$
	public static PrimitiveType OCL_BOOLEAN = new PrimitiveBooleanImpl("Boolean");//$NON-NLS-1$
	public static PrimitiveType OCL_REAL = new PrimitiveRealImpl("Real");//$NON-NLS-1$
	public static PrimitiveType OCL_STRING = new PrimitiveStringImpl("String");	//$NON-NLS-1$
	
	/*
	 * Primitive type operation codes
	 */
	public final static int PLUS = 1;
	public final static int MINUS = 2;
	public final static int TIMES = 3;
	public final static int DIVIDE = 4;
	public final static int GREATER_THAN = 6;
	public final static int GREATER_THAN_EQUAL = 5;
	public final static int LESS_THAN = 7;
	public final static int LESS_THAN_EQUAL = 8;
	public final static int AND = 10;
	public final static int NOT = 11;
	public final static int OR = 12;
	public final static int IMPLIES = 13;
	public final static int ABS = 15;
	public final static int DIV = 16;
	public final static int MOD = 17;
	public final static int MAX = 18;
	public final static int MIN = 19;
	public final static int SIZE = 20;
	public final static int CONCAT = 21;
	public final static int SUBSTRING = 22;
	public final static int TO_INTEGER = 23;
	public final static int TO_REAL = 24;
	public final static int XOR = 25;
	public final static int FLOOR = 26;
	public final static int ROUND = 27;
	public final static int TO_LOWER = 28;
	public final static int TO_UPPER = 29;

	/**
	 * Obtain the result type on a collection type operation. A conformance
	 * test is performed, and the result type may be the common supertype of 
	 * the source and argument types, depending on the operation.
	 * @param opcode
	 * @param args
	 * @return the result type
	 */
	public EClassifier getResultType(int opcode, EList args)
					throws antlr.SemanticException {
		
		switch (opcode) {
			
		case PLUS:
		case TIMES:
			OclExpression arg = (OclExpression)args.get(0);
			EClassifier argType = arg.getType();
			return commonSuperType(argType, this);
		case DIVIDE:
			arg = (OclExpression)args.get(0);
			argType = arg.getType();
			commonSuperType(argType, this);
			return PrimitiveTypeImpl.OCL_REAL;
		case MINUS:
			if (args == null || args.size() == 0) return this;
			arg = (OclExpression)args.get(0);
			argType = arg.getType();
			return commonSuperType(argType, this);
		case GREATER_THAN:
		case LESS_THAN:
		case GREATER_THAN_EQUAL:
		case LESS_THAN_EQUAL:
		case IMPLIES:
		case XOR:
		case NOT:
		case AND:
		case OR:
			return PrimitiveTypeImpl.OCL_BOOLEAN;			
		case MIN:
		case MAX:
		case ABS:
		case DIV:
		case MOD:
		case SUBSTRING:
		case CONCAT:
			return this;
		case FLOOR:
		case TO_INTEGER:
		case SIZE:
		case ROUND:
			return PrimitiveTypeImpl.OCL_INTEGER; 
		case TO_REAL:
			return PrimitiveTypeImpl.OCL_REAL;
		case TO_LOWER:
		case TO_UPPER:
			return PrimitiveTypeImpl.OCL_STRING;
		}
		return AnyTypeImpl.getResultType(this, opcode, args);
	}
	
	


	
	/**
	 * Returns primitive type operation for the specified primitive operation
	 * name.  Used for efficient interpretation of OCL expressions.
	 * @param operName
	 * @return the opcode
	 */
	public int getOperationCode(String operName) {
		
		if (operName.equals("plus")) return PLUS;//$NON-NLS-1$
		if (operName.equals("minus")) return MINUS;//$NON-NLS-1$
		if (operName.equals("times")) return TIMES;//$NON-NLS-1$
		if (operName.equals("divide")) return DIVIDE;//$NON-NLS-1$
		if (operName.equals("greaterThan")) return GREATER_THAN;//$NON-NLS-1$
		if (operName.equals("greaterThanEqual")) return GREATER_THAN_EQUAL;//$NON-NLS-1$
		if (operName.equals("lessThan")) return LESS_THAN;//$NON-NLS-1$
		if (operName.equals("lessThanEqual")) return LESS_THAN_EQUAL;//$NON-NLS-1$
		if (operName.equals("and")) return AND;//$NON-NLS-1$
		if (operName.equals("not")) return NOT;//$NON-NLS-1$
		if (operName.equals("or")) return OR;//$NON-NLS-1$
		if (operName.equals("implies")) return IMPLIES;//$NON-NLS-1$
		if (operName.equals("div")) return DIV;//$NON-NLS-1$
		if (operName.equals("abs")) return ABS;//$NON-NLS-1$
		if (operName.equals("floor")) return FLOOR;//$NON-NLS-1$
		if (operName.equals("round")) return ROUND;//$NON-NLS-1$
		if (operName.equals("max")) return MAX;//$NON-NLS-1$
		if (operName.equals("min")) return MIN;//$NON-NLS-1$
		if (operName.equals("mod")) return MOD;//$NON-NLS-1$
		if (operName.equals("substring")) return SUBSTRING;//$NON-NLS-1$
		if (operName.equals("size")) return SIZE;//$NON-NLS-1$
		if (operName.equals("concat")) return CONCAT;//$NON-NLS-1$
		if (operName.equals("xor")) return XOR;//$NON-NLS-1$
		if (operName.equals("toInteger")) return TO_INTEGER;//$NON-NLS-1$
		if (operName.equals("toReal")) return TO_REAL;//$NON-NLS-1$
		if (operName.equals("toLower")) return TO_LOWER;//$NON-NLS-1$
		if (operName.equals("toUpper")) return TO_UPPER;//$NON-NLS-1$

		return super.getOperationCode(operName);
	}
	
	
	/**
	 * converts an opcode to a string
	 * @param opcode
	 * @return the corresponding name
	 */
	public static String getOperationNameFor(int opcode) {
	
		switch (opcode) {
		
			case PLUS: return "plus";//$NON-NLS-1$
			case MINUS: return "minus";//$NON-NLS-1$
			case TIMES: return "times";//$NON-NLS-1$
			case DIVIDE: return "divide";//$NON-NLS-1$
			case GREATER_THAN:  return "greaterThan";//$NON-NLS-1$
			case GREATER_THAN_EQUAL: return "greaterThanEqual";//$NON-NLS-1$
			case LESS_THAN: return "lessThan";//$NON-NLS-1$
			case LESS_THAN_EQUAL: return "lessThanEqual";//$NON-NLS-1$
			case AND: return "and";//$NON-NLS-1$
			case OR: return "or";//$NON-NLS-1$
			case IMPLIES: return "implies";//$NON-NLS-1$
			case DIV: return "div";//$NON-NLS-1$
			case ABS: return "abs";//$NON-NLS-1$
			case FLOOR: return "floor";//$NON-NLS-1$
			case ROUND: return "round";//$NON-NLS-1$
			case MAX: return "max";//$NON-NLS-1$
			case MIN: return "min";//$NON-NLS-1$
			case MOD: return "mod";//$NON-NLS-1$
			case SUBSTRING: return "substring";//$NON-NLS-1$
			case SIZE: return "size";//$NON-NLS-1$
			case CONCAT: return "concat";//$NON-NLS-1$
			case XOR: return "xor";//$NON-NLS-1$
			case TO_INTEGER: return "toInteger";//$NON-NLS-1$
			case TO_REAL: return "toReal";//$NON-NLS-1$
			case TO_LOWER: return "toLower";//$NON-NLS-1$
			case TO_UPPER: return "toUpper";//$NON-NLS-1$
			
		}
		return AnyTypeImpl.getOperationNameFor(opcode);
	}

	 
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveTypeImpl() {
		super();
	}

	protected PrimitiveTypeImpl(String name) {
		super();
		setName(name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TypesPackage.eINSTANCE.getPrimitiveType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case TypesPackage.PRIMITIVE_TYPE__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case TypesPackage.PRIMITIVE_TYPE__EPACKAGE:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, TypesPackage.PRIMITIVE_TYPE__EPACKAGE, msgs);
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
				case TypesPackage.PRIMITIVE_TYPE__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case TypesPackage.PRIMITIVE_TYPE__EPACKAGE:
					return eBasicSetContainer(null, TypesPackage.PRIMITIVE_TYPE__EPACKAGE, msgs);
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
				case TypesPackage.PRIMITIVE_TYPE__EPACKAGE:
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
			case TypesPackage.PRIMITIVE_TYPE__EANNOTATIONS:
				return getEAnnotations();
			case TypesPackage.PRIMITIVE_TYPE__NAME:
				return getName();
			case TypesPackage.PRIMITIVE_TYPE__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case TypesPackage.PRIMITIVE_TYPE__INSTANCE_CLASS:
				return getInstanceClass();
			case TypesPackage.PRIMITIVE_TYPE__DEFAULT_VALUE:
				return getDefaultValue();
			case TypesPackage.PRIMITIVE_TYPE__EPACKAGE:
				return getEPackage();
			case TypesPackage.PRIMITIVE_TYPE__SERIALIZABLE:
				return isSerializable() ? Boolean.TRUE : Boolean.FALSE;
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
			case TypesPackage.PRIMITIVE_TYPE__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case TypesPackage.PRIMITIVE_TYPE__NAME:
				setName((String)newValue);
				return;
			case TypesPackage.PRIMITIVE_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case TypesPackage.PRIMITIVE_TYPE__SERIALIZABLE:
				setSerializable(((Boolean)newValue).booleanValue());
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
			case TypesPackage.PRIMITIVE_TYPE__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case TypesPackage.PRIMITIVE_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TypesPackage.PRIMITIVE_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case TypesPackage.PRIMITIVE_TYPE__SERIALIZABLE:
				setSerializable(SERIALIZABLE_EDEFAULT);
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
			case TypesPackage.PRIMITIVE_TYPE__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case TypesPackage.PRIMITIVE_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TypesPackage.PRIMITIVE_TYPE__INSTANCE_CLASS_NAME:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case TypesPackage.PRIMITIVE_TYPE__INSTANCE_CLASS:
				return INSTANCE_CLASS_EDEFAULT == null ? getInstanceClass() != null : !INSTANCE_CLASS_EDEFAULT.equals(getInstanceClass());
			case TypesPackage.PRIMITIVE_TYPE__DEFAULT_VALUE:
				return DEFAULT_VALUE_EDEFAULT == null ? getDefaultValue() != null : !DEFAULT_VALUE_EDEFAULT.equals(getDefaultValue());
			case TypesPackage.PRIMITIVE_TYPE__EPACKAGE:
				return getEPackage() != null;
			case TypesPackage.PRIMITIVE_TYPE__SERIALIZABLE:
				return ((eFlags & SERIALIZABLE_EFLAG) != 0) != SERIALIZABLE_EDEFAULT;
		}
		return eDynamicIsSet(eFeature);
	}

}	


	
