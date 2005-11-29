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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EDataTypeImpl;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.internal.OclEnginePlugin;
import org.eclipse.emf.ocl.internal.l10n.OclMessages;
import org.eclipse.emf.ocl.internal.parser.OclParser;
import org.eclipse.emf.ocl.parser.EcoreEnvironment;
import org.eclipse.emf.ocl.types.AnyType;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.PrimitiveType;
import org.eclipse.emf.ocl.types.TupleType;
import org.eclipse.emf.ocl.types.TypesFactory;
import org.eclipse.emf.ocl.types.TypesPackage;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.osgi.util.NLS;

/**
 * @author Edith Schonberg (edith)
 * @generated
 */
public class AnyTypeImpl
	extends EDataTypeImpl
	implements AnyType {

	private static final String TypeMismatch_ERROR_ =
		OclMessages.TypeMismatch_ERROR_;

	private static final String CompareTypeMismatch_ERROR_ =
		OclMessages.CompareTypeMismatch_ERROR_;

	private static final String Noncomforming_ERROR_ =
		OclMessages.Noncomforming_ERROR_;

	private static final String EqualityTupleUnsupported_ERROR_ =
		OclMessages.EqualityTupleUnsupported_ERROR_;

	private static final String SourceEClass_ERROR_ =
		OclMessages.SourceEClass_ERROR_;

	private static final String SourceOperationCompareTo_ERROR_ =
		OclMessages.SourceOperationCompareTo_ERROR_;

	private static final String ResultCompareToInt_ERROR_ =
		OclMessages.ResultCompareToInt_ERROR_;

	public static AnyType OCL_ANY_TYPE = new AnyTypeImpl("OclAny");//$NON-NLS-1$

	public static EClassifier OCL_ECLASSIFIER = EcoreFactory.eINSTANCE
		.createEClass();

	/*
	 * Operations for AnyType
	 */
	private static EList operations = new BasicEList();

	/**
	 * Initialiaze Operations defined on AnyType
	 */
	protected EList initOperations() {
		if (operations.size() == 0) {
			operations.add(createBinaryOperation(PrimitiveTypeImpl.OCL_BOOLEAN,
				"oclEquals", OCL_ANY_TYPE)); //$NON-NLS-1$
			operations.add(createBinaryOperation(PrimitiveTypeImpl.OCL_BOOLEAN,
				"oclNotEquals", OCL_ANY_TYPE)); //$NON-NLS-1$
			operations.add(createUnaryOperation(CollectionTypeImpl.OCL_SET,
				"allInstances"));//$NON-NLS-1$
			operations.add(createBinaryOperation(OCL_ECLASSIFIER,
				"oclAsType", OCL_ECLASSIFIER)); //$NON-NLS-1$
			operations.add(createBinaryOperation(PrimitiveTypeImpl.OCL_BOOLEAN,
				"oclIsKindOf", OCL_ECLASSIFIER));//$NON-NLS-1$
			operations.add(createBinaryOperation(PrimitiveTypeImpl.OCL_BOOLEAN,
				"oclIsTypeOf", OCL_ECLASSIFIER));//$NON-NLS-1$
			operations.add(createUnaryOperation(PrimitiveTypeImpl.OCL_BOOLEAN,
				"oclIsUndefined"));//$NON-NLS-1$
			operations.add(createUnaryOperation(PrimitiveTypeImpl.OCL_BOOLEAN,
				"oclIsNew"));//$NON-NLS-1$
			operations.add(createBinaryOperation(OCL_ANY_TYPE,
				"closure", OCL_ANY_TYPE));//$NON-NLS-1$
			operations.add(createBinaryOperation(PrimitiveTypeImpl.OCL_BOOLEAN,
				"lessThan", OCL_ECLASSIFIER));//$NON-NLS-1$
			operations.add(createBinaryOperation(PrimitiveTypeImpl.OCL_BOOLEAN,
				"greaterThan", OCL_ECLASSIFIER));//$NON-NLS-1$
			operations.add(createBinaryOperation(PrimitiveTypeImpl.OCL_BOOLEAN,
				"lessThanEqual", OCL_ECLASSIFIER));//$NON-NLS-1$
			operations.add(createBinaryOperation(PrimitiveTypeImpl.OCL_BOOLEAN,
				"greaterThanEqual", OCL_ECLASSIFIER));//$NON-NLS-1$
		}
		return operations;
	}

	public final static int EQUAL = 60;

	public final static int NOT_EQUAL = 61;

	public final static int OCL_AS_TYPE = 62;

	public final static int OCL_IS_KIND_OF = 63;

	public final static int OCL_IS_TYPE_OF = 64;

	public final static int OCL_IS_UNDEFINED = 65;

	public final static int ALL_INSTANCES = 66;

	public final static int CLOSURE = 67;

	public final static int CLOSURE_ALL = 68;

	public final static int ANYTYPE_LESS_THAN = 69;

	public final static int ANYTYPE_GREATER_THAN = 70;

	public final static int ANYTYPE_LESS_THAN_EQUAL = 71;

	public final static int ANYTYPE_GREATER_THAN_EQUAL = 72;
	
	public final static int OCL_IS_NEW = 73;

	/**
	 * Returns type operation for the specified collection operation name. Used
	 * for efficient interpretation of OCL expressions.
	 * 
	 * @param operName
	 * @return the operation code
	 */
	public int getOperationCode(String operName) {

		if (operName.equals("oclEquals"))return EQUAL;//$NON-NLS-1$
		if (operName.equals("oclNotEquals"))return NOT_EQUAL;//$NON-NLS-1$
		if (operName.equals("oclAsType"))return OCL_AS_TYPE;//$NON-NLS-1$
		if (operName.equals("oclIsKindOf"))return OCL_IS_KIND_OF;//$NON-NLS-1$
		if (operName.equals("oclIsTypeOf"))return OCL_IS_TYPE_OF;//$NON-NLS-1$
		if (operName.equals("oclIsUndefined"))return OCL_IS_UNDEFINED;//$NON-NLS-1$
		if (operName.equals("allInstances"))return ALL_INSTANCES;//$NON-NLS-1$
		if (operName.equals("closure"))return CLOSURE;//$NON-NLS-1$
		if (operName.equals("closureAll"))return CLOSURE_ALL;//$NON-NLS-1$
		if (operName.equals("lessThan"))return ANYTYPE_LESS_THAN;//$NON-NLS-1$
		if (operName.equals("greaterThan"))return ANYTYPE_GREATER_THAN;//$NON-NLS-1$
		if (operName.equals("lessThanEqual"))return ANYTYPE_LESS_THAN_EQUAL;//$NON-NLS-1$
		if (operName.equals("greaterThanEqual"))return ANYTYPE_GREATER_THAN_EQUAL;//$NON-NLS-1$
		if (operName.equals("oclIsNew"))return OCL_IS_NEW;//$NON-NLS-1$

		return 0;
	}

	/**
	 * Returns the operation name corresponding to the opcode
	 * 
	 * @param opcode
	 * @return the name corresponding to the opcode
	 */
	public static String getOperationNameFor(int opcode) {

		switch (opcode) {

			case EQUAL:
				return "oclEquals";//$NON-NLS-1$
			case NOT_EQUAL:
				return "oclNotEquals";//$NON-NLS-1$
			case OCL_AS_TYPE:
				return "oclAsType";//$NON-NLS-1$
			case OCL_IS_KIND_OF:
				return "oclIsKindOf";//$NON-NLS-1$
			case OCL_IS_TYPE_OF:
				return "oclIsTypeOf";//$NON-NLS-1$
			case OCL_IS_UNDEFINED:
				return "oclIsUndefined";//$NON-NLS-1$
			case ALL_INSTANCES:
				return "allInstances";//$NON-NLS-1$
			case CLOSURE:
				return "closure";//$NON-NLS-1$
			case CLOSURE_ALL:
				return "closureAll";//$NON-NLS-1$
			case ANYTYPE_LESS_THAN:
				return "lessThan";//$NON-NLS-1$
			case ANYTYPE_GREATER_THAN:
				return "greaterThan";//$NON-NLS-1$
			case ANYTYPE_LESS_THAN_EQUAL:
				return "lessThanEqual";//$NON-NLS-1$
			case ANYTYPE_GREATER_THAN_EQUAL:
				return "greaterThanEqual";//$NON-NLS-1$
			case OCL_IS_NEW:
				return "oclIsNew"; //$NON-NLS-1$
		}

		return "";//$NON-NLS-1$
	}

	/**
	 * Obtain the result type on an AnyType type operation. Note: This type is
	 * static since EClass and EEnum are not items of AnyType in EMF.
	 * 
	 * @param type source type
	 * @param opcode the operation code
	 * @param args the operation arguments
	 * @return the result type
	 */
	public static EClassifier getResultType(EClassifier type, int opcode,
		EList args) throws antlr.SemanticException {

		switch (opcode) {
			case NOT_EQUAL:
			case EQUAL:
				/*
				 * Performs a conformance test for primitives, EClass, EEnum,
				 * TupleType
				 */
				OclExpression arg = (OclExpression) args.get(0);
				EClassifier argType = arg.getType();
				if (type instanceof EEnum) {
					if (type != argType && argType != OCL_ANY_TYPE) {
						String message = NLS.bind(
							Noncomforming_ERROR_, new Object[] {type.getName(),
								getOperationNameFor(opcode) });
						OclParser.ERR(message);
					}
				} else if (type instanceof TupleType) {
					//((TupleTypeImpl) type).commonSuperType(argType);
					OclParser.ERR(EqualityTupleUnsupported_ERROR_);
				} else if (type instanceof PrimitiveType) {
					arg = (OclExpression) args.get(0);
					argType = arg.getType();
					if (!(argType instanceof PrimitiveType)
						&& !(argType == OCL_ANY_TYPE)) {
						String message = NLS.bind(
							Noncomforming_ERROR_, new Object[] {type.getName(),
								getOperationNameFor(opcode) });
						OclParser.ERR(message);
					} /*
					 * else if (argType instanceof PrimitiveType) { // Do
					 * conformance test commonSuperType(type, argType); }
					 */
				}
				return PrimitiveTypeImpl.OCL_BOOLEAN;
			case ANYTYPE_LESS_THAN:
			case ANYTYPE_GREATER_THAN:
			case ANYTYPE_LESS_THAN_EQUAL:
			case ANYTYPE_GREATER_THAN_EQUAL:
				// source must be an EClass, with a method: int compareTo(object)
				if (!(type instanceof EClass)) {
					String message = NLS.bind(SourceEClass_ERROR_,
						new Object[] {getOperationNameFor(opcode) });
					OclParser.ERR(message);
				}
				// Check that the type has a method named "compareTo"
				EOperation oper = null;
				try {
					oper = EcoreEnvironment.lookupOperation(type,
						"compareTo", args);//$NON-NLS-1$
				} catch (Exception e) {
					String message = NLS.bind(
						SourceOperationCompareTo_ERROR_,
						new Object[] {getOperationNameFor(opcode) });
					OclParser.ERR(message);
				}
				if (EcoreEnvironment.getOclType(oper) != PrimitiveTypeImpl.OCL_INTEGER) {
					OclParser.ERR(ResultCompareToInt_ERROR_);
				}
			// NEED TO CHECK CONFORMANCE OF ARGS if ECLASS...

			case OCL_IS_KIND_OF:
			case OCL_IS_TYPE_OF:
			case OCL_IS_NEW:
				return PrimitiveTypeImpl.OCL_BOOLEAN;
			case OCL_AS_TYPE:
				arg = (OclExpression) args.get(0);
				EClassifier argEType = arg.getType();
				if (type instanceof CollectionType) {
					String message = NLS.bind(Noncomforming_ERROR_,
						new Object[] {type.getName(),
							getOperationNameFor(opcode) });
					OclParser.ERR(message);
				}
				// we can require neither a common supertype nor that type2
				// and type1 have any conformance relationship whatsoever
				// because the run-time 'type' may conform to 'arg'
				//				commonSuperType(argEType, type);
				//type1AsType2(type, argEType);
				return argEType;
			case OCL_IS_UNDEFINED:
				return PrimitiveTypeImpl.OCL_BOOLEAN;
			case ALL_INSTANCES:
				return TypesFactory.eINSTANCE.createSetType(type);
			case CLOSURE:
			case CLOSURE_ALL:
				// Perform conformance test.
				arg = (OclExpression) args.get(0);
				argType = arg.getType();
				// The argument of Closure may be either a class, which must match
				// the sourceType, or a collection.
				// If a collection, the element type must match the sourceType.
				if (argType instanceof CollectionType)
					argType = ((CollectionType) argType).getElementType();
				if (!(argType instanceof EClass) || argType != type) {
					String message = NLS.bind(Noncomforming_ERROR_,
						new Object[] {type.getName(),
							getOperationNameFor(opcode) });
					OclParser.ERR(message);
				}

		}
		return null;
	}

	public static boolean type1AsType2(EClassifier type1, EClassifier type2)
		throws antlr.SemanticException {
		if (typeCompare(type1, type2) != -1) {
			return true;
		}
		String message = NLS.bind(CompareTypeMismatch_ERROR_,
			new Object[] {type1.getName(), type2.getName() });
		OclParser.ERR(message);
		return false;
	}

	/**
	 * Get the common supertype of two types.
	 * 
	 * @param type1
	 * @param type2
	 * @return the common supertype
	 */
	public static EClassifier commonSuperType(EClassifier type1,
		EClassifier type2) throws antlr.SemanticException {

		if (type1 == type2) {
			return type2;
		}

		// common super type for all primitive types
		if (type1 == Types.OCL_VOID)
			return type2;
		if (type2 == Types.OCL_VOID)
			return type1;

		if (type1 == OCL_ANY_TYPE && !(type2 instanceof CollectionType))
			return OCL_ANY_TYPE;

		if (type2 == OCL_ANY_TYPE && !(type1 instanceof CollectionType))
			return OCL_ANY_TYPE;

		if (type1 == PrimitiveTypeImpl.OCL_REAL
			&& (type2 == PrimitiveTypeImpl.OCL_REAL || type2 == PrimitiveTypeImpl.OCL_INTEGER)) {
			return PrimitiveTypeImpl.OCL_REAL;
		}
		if (type1 == PrimitiveTypeImpl.OCL_INTEGER) {
			if (type2 == PrimitiveTypeImpl.OCL_REAL)
				return PrimitiveTypeImpl.OCL_REAL;
		}

		if (type1 instanceof CollectionType) {
			return ((CollectionTypeImpl) type1).commonSuperType(type2);
		}

		if (type1 instanceof TupleType) {
			return ((TupleTypeImpl) type1).commonSuperType(type2);
		}

		if (type1 instanceof EClass && type2 instanceof EClass) {
			EClass eClass1 = (EClass) type1;
			EClass eClass2 = (EClass) type2;
			if (eClass1.isSuperTypeOf(eClass2)) {
				return eClass1;
			}
			if (eClass2.isSuperTypeOf(eClass1)) {
				return eClass2;
			}
			List allSuperAndSelf1 = new ArrayList(eClass1.getEAllSuperTypes());
			allSuperAndSelf1.add(eClass1);
			List allSuperAndSelf2 = new ArrayList(eClass2.getEAllSuperTypes());
			allSuperAndSelf2.add(eClass2);
			allSuperAndSelf1.retainAll(allSuperAndSelf2);
			if (!allSuperAndSelf1.isEmpty()) {
				return (EClassifier) allSuperAndSelf1.get(allSuperAndSelf1
					.size() - 1);
			}
		}

		String message = NLS.bind(TypeMismatch_ERROR_,
			new Object[] {type1.getName(), type2.getName() });
		OclParser.ERR(message);
		return null;
	}

	/**
	 * Compare 2 types. Returns 0 if types are exactly equal, -1 if type1
	 * conforms to type2 (type1 is a subtype of type2) 1 if type2 conforms to
	 * type1 (type2 is a subtype of type1) Throws an IllegalArgumentException if
	 * there is no type conformance.
	 * 
	 * @param type1 -
	 *            EClassifier
	 * @param type2 -
	 *            EClassifier
	 * @return the ordering key
	 */
	public static int typeCompare(EClassifier type1, EClassifier type2) {

		// common super type for all primitive types
		if (type1 == type2)
			return 0;
		if (type1 == Types.OCL_VOID)
			return -1;
		if (type2 == Types.OCL_VOID)
			return 1;
		if (type1 == OCL_ANY_TYPE && !(type2 instanceof CollectionType))
			return 1;

		if (type1 instanceof PrimitiveTypeImpl) {

			if (type2 == OCL_ANY_TYPE && !(type1 instanceof CollectionType))
				return -1;
			if (type1 == PrimitiveTypeImpl.OCL_INTEGER
				&& type2 == PrimitiveTypeImpl.OCL_REAL)
				return -1;
			if (type2 == PrimitiveTypeImpl.OCL_INTEGER
				&& type1 == PrimitiveTypeImpl.OCL_INTEGER)
				return 1;
			String message = NLS.bind(TypeMismatch_ERROR_,
				new Object[] {type1.getName(), type2.getName() });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin.throwing(AnyTypeImpl.class, "typeCompare", error);//$NON-NLS-1$
			throw error;
		}

		if (type1 instanceof CollectionType) {
			return ((CollectionTypeImpl) type1).typeCompare(type2);
		}

		if (type1 instanceof TupleType) {
			return ((TupleTypeImpl) type1).typeCompare(type2);
		}

		if (type1 instanceof EClass && type2 instanceof EClass) {
			if (type1 == type2)
				return 0;
			if (((EClass) type1).isSuperTypeOf((EClass) type2))
				return 1;
			if (((EClass) type2).isSuperTypeOf((EClass) type1))
				return -1;
		}

		if (type1 == type2) {
			return 0;
		}
		String message = NLS.bind(TypeMismatch_ERROR_,
			new Object[] {type1.getName(), type2.getName() });
		IllegalArgumentException error = new IllegalArgumentException(message);
		OclEnginePlugin.throwing(AnyTypeImpl.class, "typeCompare", error);//$NON-NLS-1$
		throw error;
	}

	static protected EOperation createBinaryOperation(EClassifier resultType,
		String name, EClassifier param) {
		EOperation result = EcorePackage.eINSTANCE.getEcoreFactory()
			.createEOperation();
		result.setEType(resultType);
		result.setName(name);
		EParameter parameter = EcorePackage.eINSTANCE.getEcoreFactory()
			.createEParameter();
		parameter.setEType(param);
		result.getEParameters().add(parameter);

		return result;
	}

	static protected EOperation createUnaryOperation(EClassifier resultType,
		String name) {
		EOperation result = EcorePackage.eINSTANCE.getEcoreFactory()
			.createEOperation();
		result.setEType(resultType);
		result.setName(name);
		return result;
	}

	static protected EOperation createTernaryOperation(EClassifier resultType,
		String name, EClassifier param1, EClassifier param2) {
		EOperation result = EcorePackage.eINSTANCE.getEcoreFactory()
			.createEOperation();
		result.setEType(resultType);
		result.setName(name);
		EParameter parameter = EcorePackage.eINSTANCE.getEcoreFactory()
			.createEParameter();
		parameter.setEType(param1);
		result.getEParameters().add(parameter);
		parameter = EcorePackage.eINSTANCE.getEcoreFactory().createEParameter();
		parameter.setEType(param2);
		result.getEParameters().add(parameter);

		return result;
	}

	public EList getOperations() {
		if (operations == null || operations.size() == 0)
			return initOperations();
		return operations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	protected AnyTypeImpl() {
		super();
		setInstanceClass(Object.class);
	}

	protected AnyTypeImpl(String name) {
		this();
		setName(name);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TypesPackage.eINSTANCE.getAnyType();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case TypesPackage.ANY_TYPE__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				case TypesPackage.ANY_TYPE__EPACKAGE:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, TypesPackage.ANY_TYPE__EPACKAGE, msgs);
				default:
					return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
			}
		}
		if (eContainer != null)
			msgs = eBasicRemoveFromContainer(msgs);
		return eBasicSetContainer(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case TypesPackage.ANY_TYPE__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case TypesPackage.ANY_TYPE__EPACKAGE:
					return eBasicSetContainer(null, TypesPackage.ANY_TYPE__EPACKAGE, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
		if (eContainerFeatureID >= 0) {
			switch (eContainerFeatureID) {
				case TypesPackage.ANY_TYPE__EPACKAGE:
					return eContainer.eInverseRemove(this, EcorePackage.EPACKAGE__ECLASSIFIERS, EPackage.class, msgs);
				default:
					return eDynamicBasicRemoveFromContainer(msgs);
			}
		}
		return eContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - eContainerFeatureID, null, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TypesPackage.ANY_TYPE__EANNOTATIONS:
				return getEAnnotations();
			case TypesPackage.ANY_TYPE__NAME:
				return getName();
			case TypesPackage.ANY_TYPE__INSTANCE_CLASS_NAME:
				return getInstanceClassName();
			case TypesPackage.ANY_TYPE__INSTANCE_CLASS:
				return getInstanceClass();
			case TypesPackage.ANY_TYPE__DEFAULT_VALUE:
				return getDefaultValue();
			case TypesPackage.ANY_TYPE__EPACKAGE:
				return getEPackage();
			case TypesPackage.ANY_TYPE__SERIALIZABLE:
				return isSerializable() ? Boolean.TRUE : Boolean.FALSE;
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TypesPackage.ANY_TYPE__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case TypesPackage.ANY_TYPE__NAME:
				setName((String)newValue);
				return;
			case TypesPackage.ANY_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName((String)newValue);
				return;
			case TypesPackage.ANY_TYPE__SERIALIZABLE:
				setSerializable(((Boolean)newValue).booleanValue());
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TypesPackage.ANY_TYPE__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case TypesPackage.ANY_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TypesPackage.ANY_TYPE__INSTANCE_CLASS_NAME:
				setInstanceClassName(INSTANCE_CLASS_NAME_EDEFAULT);
				return;
			case TypesPackage.ANY_TYPE__SERIALIZABLE:
				setSerializable(SERIALIZABLE_EDEFAULT);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case TypesPackage.ANY_TYPE__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case TypesPackage.ANY_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TypesPackage.ANY_TYPE__INSTANCE_CLASS_NAME:
				return INSTANCE_CLASS_NAME_EDEFAULT == null ? instanceClassName != null : !INSTANCE_CLASS_NAME_EDEFAULT.equals(instanceClassName);
			case TypesPackage.ANY_TYPE__INSTANCE_CLASS:
				return INSTANCE_CLASS_EDEFAULT == null ? getInstanceClass() != null : !INSTANCE_CLASS_EDEFAULT.equals(getInstanceClass());
			case TypesPackage.ANY_TYPE__DEFAULT_VALUE:
				return DEFAULT_VALUE_EDEFAULT == null ? getDefaultValue() != null : !DEFAULT_VALUE_EDEFAULT.equals(getDefaultValue());
			case TypesPackage.ANY_TYPE__EPACKAGE:
				return getEPackage() != null;
			case TypesPackage.ANY_TYPE__SERIALIZABLE:
				return ((eFlags & SERIALIZABLE_EFLAG) != 0) != SERIALIZABLE_EDEFAULT;
		}
		return eDynamicIsSet(eFeature);
	}

}