/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 207365
 * 
 * </copyright>
 *
 * $Id: UMLPackageImpl.java,v 1.13 2010/01/14 12:44:14 ewillink Exp $
 */
package org.eclipse.ocl.uml.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.uml.AnyType;
import org.eclipse.ocl.uml.AssociationClassCallExp;
import org.eclipse.ocl.uml.BagType;
import org.eclipse.ocl.uml.BooleanLiteralExp;
import org.eclipse.ocl.uml.CallExp;
import org.eclipse.ocl.uml.CollectionItem;
import org.eclipse.ocl.uml.CollectionLiteralExp;
import org.eclipse.ocl.uml.CollectionLiteralPart;
import org.eclipse.ocl.uml.CollectionRange;
import org.eclipse.ocl.uml.CollectionType;
import org.eclipse.ocl.uml.ElementType;
import org.eclipse.ocl.uml.EnumLiteralExp;
import org.eclipse.ocl.uml.ExpressionInOCL;
import org.eclipse.ocl.uml.FeatureCallExp;
import org.eclipse.ocl.uml.IfExp;
import org.eclipse.ocl.uml.IntegerLiteralExp;
import org.eclipse.ocl.uml.InvalidLiteralExp;
import org.eclipse.ocl.uml.InvalidType;
import org.eclipse.ocl.uml.IterateExp;
import org.eclipse.ocl.uml.IteratorExp;
import org.eclipse.ocl.uml.LetExp;
import org.eclipse.ocl.uml.LiteralExp;
import org.eclipse.ocl.uml.LoopExp;
import org.eclipse.ocl.uml.MessageExp;
import org.eclipse.ocl.uml.MessageType;
import org.eclipse.ocl.uml.NavigationCallExp;
import org.eclipse.ocl.uml.NullLiteralExp;
import org.eclipse.ocl.uml.NumericLiteralExp;
import org.eclipse.ocl.uml.OCLExpression;
import org.eclipse.ocl.uml.OperationCallExp;
import org.eclipse.ocl.uml.OrderedSetType;
import org.eclipse.ocl.uml.PrimitiveLiteralExp;
import org.eclipse.ocl.uml.PrimitiveType;
import org.eclipse.ocl.uml.PropertyCallExp;
import org.eclipse.ocl.uml.RealLiteralExp;
import org.eclipse.ocl.uml.SequenceType;
import org.eclipse.ocl.uml.SetType;
import org.eclipse.ocl.uml.StateExp;
import org.eclipse.ocl.uml.StringLiteralExp;
import org.eclipse.ocl.uml.TemplateParameterType;
import org.eclipse.ocl.uml.TupleLiteralExp;
import org.eclipse.ocl.uml.TupleLiteralPart;
import org.eclipse.ocl.uml.TupleType;
import org.eclipse.ocl.uml.TypeExp;
import org.eclipse.ocl.uml.TypeType;
import org.eclipse.ocl.uml.UMLFactory;
import org.eclipse.ocl.uml.UMLPackage;
import org.eclipse.ocl.uml.UnlimitedNaturalLiteralExp;
import org.eclipse.ocl.uml.UnspecifiedValueExp;
import org.eclipse.ocl.uml.Variable;
import org.eclipse.ocl.uml.VariableExp;
import org.eclipse.ocl.uml.VoidType;
import org.eclipse.ocl.uml.util.UMLValidator;
import org.eclipse.ocl.utilities.UtilitiesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UMLPackageImpl
		extends EPackageImpl
		implements UMLPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass anyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass voidTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invalidTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tupleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bagTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orderedSetTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionInOCLEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationClassCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass navigationCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionLiteralPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numericLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unlimitedNaturalLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invalidLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iterateExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iteratorExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass letExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nullLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tupleLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tupleLiteralPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unspecifiedValueExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateParameterTypeEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.ocl.uml.UMLPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UMLPackageImpl() {
		super(eNS_URI, UMLFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link UMLPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UMLPackage init() {
		if (isInited)
			return (UMLPackage) EPackage.Registry.INSTANCE
				.getEPackage(UMLPackage.eNS_URI);

		// Obtain or create and register package
		UMLPackageImpl theUMLPackage = (UMLPackageImpl) (EPackage.Registry.INSTANCE
			.get(eNS_URI) instanceof UMLPackageImpl
			? EPackage.Registry.INSTANCE.get(eNS_URI)
			: new UMLPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		TypesPackage.eINSTANCE.eClass();
		UtilitiesPackage.eINSTANCE.eClass();
		ExpressionsPackage.eINSTANCE.eClass();
		org.eclipse.uml2.uml.UMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theUMLPackage.createPackageContents();

		// Initialize created meta-data
		theUMLPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put(theUMLPackage,
			new EValidator.Descriptor() {

				public EValidator getEValidator() {
					return UMLValidator.INSTANCE;
				}
			});

		// Mark meta-data to indicate it can't be changed
		theUMLPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UMLPackage.eNS_URI, theUMLPackage);
		return theUMLPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnyType() {
		return anyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnyType_OwnedOperation() {
		return (EReference) anyTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVoidType() {
		return voidTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVoidType_OwnedOperation() {
		return (EReference) voidTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvalidType() {
		return invalidTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInvalidType_OwnedOperation() {
		return (EReference) invalidTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementType() {
		return elementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeType() {
		return typeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeType_OwnedOperation() {
		return (EReference) typeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessageType() {
		return messageTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageType_OwnedOperation() {
		return (EReference) messageTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageType_OwnedAttribute() {
		return (EReference) messageTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveType() {
		return primitiveTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionType() {
		return collectionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTupleType() {
		return tupleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBagType() {
		return bagTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetType() {
		return setTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrderedSetType() {
		return orderedSetTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceType() {
		return sequenceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpressionInOCL() {
		return expressionInOCLEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociationClassCallExp() {
		return associationClassCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNavigationCallExp() {
		return navigationCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureCallExp() {
		return featureCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallExp() {
		return callExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOCLExpression() {
		return oclExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanLiteralExp() {
		return booleanLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveLiteralExp() {
		return primitiveLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLiteralExp() {
		return literalExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionItem() {
		return collectionItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionLiteralPart() {
		return collectionLiteralPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionLiteralExp() {
		return collectionLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionRange() {
		return collectionRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumLiteralExp() {
		return enumLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfExp() {
		return ifExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerLiteralExp() {
		return integerLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumericLiteralExp() {
		return numericLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnlimitedNaturalLiteralExp() {
		return unlimitedNaturalLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvalidLiteralExp() {
		return invalidLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIterateExp() {
		return iterateExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopExp() {
		return loopExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIteratorExp() {
		return iteratorExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLetExp() {
		return letExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessageExp() {
		return messageExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNullLiteralExp() {
		return nullLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationCallExp() {
		return operationCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyCallExp() {
		return propertyCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRealLiteralExp() {
		return realLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateExp() {
		return stateExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringLiteralExp() {
		return stringLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTupleLiteralExp() {
		return tupleLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTupleLiteralPart() {
		return tupleLiteralPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeExp() {
		return typeExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnspecifiedValueExp() {
		return unspecifiedValueExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariable() {
		return variableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableExp() {
		return variableExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateParameterType() {
		return templateParameterTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 3.0
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateParameterType_OwnedOperation() {
		return (EReference) templateParameterTypeEClass
			.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLFactory getUMLFactory() {
		return (UMLFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		anyTypeEClass = createEClass(ANY_TYPE);
		createEReference(anyTypeEClass, ANY_TYPE__OWNED_OPERATION);

		voidTypeEClass = createEClass(VOID_TYPE);
		createEReference(voidTypeEClass, VOID_TYPE__OWNED_OPERATION);

		invalidTypeEClass = createEClass(INVALID_TYPE);
		createEReference(invalidTypeEClass, INVALID_TYPE__OWNED_OPERATION);

		elementTypeEClass = createEClass(ELEMENT_TYPE);

		typeTypeEClass = createEClass(TYPE_TYPE);
		createEReference(typeTypeEClass, TYPE_TYPE__OWNED_OPERATION);

		messageTypeEClass = createEClass(MESSAGE_TYPE);
		createEReference(messageTypeEClass, MESSAGE_TYPE__OWNED_OPERATION);
		createEReference(messageTypeEClass, MESSAGE_TYPE__OWNED_ATTRIBUTE);

		primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);

		collectionTypeEClass = createEClass(COLLECTION_TYPE);

		tupleTypeEClass = createEClass(TUPLE_TYPE);

		bagTypeEClass = createEClass(BAG_TYPE);

		setTypeEClass = createEClass(SET_TYPE);

		orderedSetTypeEClass = createEClass(ORDERED_SET_TYPE);

		sequenceTypeEClass = createEClass(SEQUENCE_TYPE);

		expressionInOCLEClass = createEClass(EXPRESSION_IN_OCL);

		associationClassCallExpEClass = createEClass(ASSOCIATION_CLASS_CALL_EXP);

		navigationCallExpEClass = createEClass(NAVIGATION_CALL_EXP);

		featureCallExpEClass = createEClass(FEATURE_CALL_EXP);

		callExpEClass = createEClass(CALL_EXP);

		oclExpressionEClass = createEClass(OCL_EXPRESSION);

		booleanLiteralExpEClass = createEClass(BOOLEAN_LITERAL_EXP);

		primitiveLiteralExpEClass = createEClass(PRIMITIVE_LITERAL_EXP);

		literalExpEClass = createEClass(LITERAL_EXP);

		collectionItemEClass = createEClass(COLLECTION_ITEM);

		collectionLiteralPartEClass = createEClass(COLLECTION_LITERAL_PART);

		collectionLiteralExpEClass = createEClass(COLLECTION_LITERAL_EXP);

		collectionRangeEClass = createEClass(COLLECTION_RANGE);

		enumLiteralExpEClass = createEClass(ENUM_LITERAL_EXP);

		ifExpEClass = createEClass(IF_EXP);

		integerLiteralExpEClass = createEClass(INTEGER_LITERAL_EXP);

		numericLiteralExpEClass = createEClass(NUMERIC_LITERAL_EXP);

		unlimitedNaturalLiteralExpEClass = createEClass(UNLIMITED_NATURAL_LITERAL_EXP);

		invalidLiteralExpEClass = createEClass(INVALID_LITERAL_EXP);

		iterateExpEClass = createEClass(ITERATE_EXP);

		loopExpEClass = createEClass(LOOP_EXP);

		iteratorExpEClass = createEClass(ITERATOR_EXP);

		letExpEClass = createEClass(LET_EXP);

		messageExpEClass = createEClass(MESSAGE_EXP);

		nullLiteralExpEClass = createEClass(NULL_LITERAL_EXP);

		operationCallExpEClass = createEClass(OPERATION_CALL_EXP);

		propertyCallExpEClass = createEClass(PROPERTY_CALL_EXP);

		realLiteralExpEClass = createEClass(REAL_LITERAL_EXP);

		stateExpEClass = createEClass(STATE_EXP);

		stringLiteralExpEClass = createEClass(STRING_LITERAL_EXP);

		tupleLiteralExpEClass = createEClass(TUPLE_LITERAL_EXP);

		tupleLiteralPartEClass = createEClass(TUPLE_LITERAL_PART);

		typeExpEClass = createEClass(TYPE_EXP);

		unspecifiedValueExpEClass = createEClass(UNSPECIFIED_VALUE_EXP);

		variableEClass = createEClass(VARIABLE);

		variableExpEClass = createEClass(VARIABLE_EXP);

		templateParameterTypeEClass = createEClass(TEMPLATE_PARAMETER_TYPE);
		createEReference(templateParameterTypeEClass,
			TEMPLATE_PARAMETER_TYPE__OWNED_OPERATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <p>
	 * The generated implementation is extended by adding me as a child of
	 * the empty root <tt>OCL</tt> package.
	 * </p>
	 */
	public void initializePackageContents() {
		if (!isInitialized) {
			// create my own resource first, before adding me to my parent
			// package.  Otherwise, I will already be in a resource when
			// createResource() is called, and it will not create a new one
			initializePackageContentsGen();

			ExpressionsPackageImpl.OCL_ROOT_PACKAGE.getESubpackages().add(this);
		}
	}

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContentsGen() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		org.eclipse.uml2.uml.UMLPackage theUMLPackage_1 = (org.eclipse.uml2.uml.UMLPackage) EPackage.Registry.INSTANCE
			.getEPackage(org.eclipse.uml2.uml.UMLPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage) EPackage.Registry.INSTANCE
			.getEPackage(TypesPackage.eNS_URI);
		UtilitiesPackage theUtilitiesPackage = (UtilitiesPackage) EPackage.Registry.INSTANCE
			.getEPackage(UtilitiesPackage.eNS_URI);
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage) EPackage.Registry.INSTANCE
			.getEPackage(ExpressionsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		EGenericType g1 = createEGenericType(theUMLPackage_1.getClassifier());
		anyTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theTypesPackage.getAnyType());
		EGenericType g2 = createEGenericType(theUMLPackage_1.getOperation());
		g1.getETypeArguments().add(g2);
		anyTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theUMLPackage_1.getClassifier());
		voidTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theTypesPackage.getVoidType());
		g2 = createEGenericType(theUMLPackage_1.getOperation());
		g1.getETypeArguments().add(g2);
		voidTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theUMLPackage_1.getClassifier());
		invalidTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theTypesPackage.getInvalidType());
		g2 = createEGenericType(theUMLPackage_1.getOperation());
		g1.getETypeArguments().add(g2);
		invalidTypeEClass.getEGenericSuperTypes().add(g1);
		elementTypeEClass.getESuperTypes().add(theUMLPackage_1.getClassifier());
		elementTypeEClass.getESuperTypes()
			.add(theTypesPackage.getElementType());
		g1 = createEGenericType(theUMLPackage_1.getClassifier());
		typeTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theTypesPackage.getTypeType());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getOperation());
		g1.getETypeArguments().add(g2);
		typeTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theUMLPackage_1.getClassifier());
		messageTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theTypesPackage.getMessageType());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getOperation());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getProperty());
		g1.getETypeArguments().add(g2);
		messageTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theUMLPackage_1.getPrimitiveType());
		primitiveTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theTypesPackage.getPrimitiveType());
		g2 = createEGenericType(theUMLPackage_1.getOperation());
		g1.getETypeArguments().add(g2);
		primitiveTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theUMLPackage_1.getDataType());
		collectionTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theTypesPackage.getCollectionType());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getOperation());
		g1.getETypeArguments().add(g2);
		collectionTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theUMLPackage_1.getDataType());
		tupleTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theTypesPackage.getTupleType());
		g2 = createEGenericType(theUMLPackage_1.getOperation());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getProperty());
		g1.getETypeArguments().add(g2);
		tupleTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCollectionType());
		bagTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theTypesPackage.getBagType());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getOperation());
		g1.getETypeArguments().add(g2);
		bagTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCollectionType());
		setTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theTypesPackage.getSetType());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getOperation());
		g1.getETypeArguments().add(g2);
		setTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCollectionType());
		orderedSetTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theTypesPackage.getOrderedSetType());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getOperation());
		g1.getETypeArguments().add(g2);
		orderedSetTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCollectionType());
		sequenceTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theTypesPackage.getSequenceType());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getOperation());
		g1.getETypeArguments().add(g2);
		sequenceTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theUMLPackage_1.getOpaqueExpression());
		expressionInOCLEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theUtilitiesPackage.getExpressionInOCL());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getParameter());
		g1.getETypeArguments().add(g2);
		expressionInOCLEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getNavigationCallExp());
		associationClassCallExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage
			.getAssociationClassCallExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getProperty());
		g1.getETypeArguments().add(g2);
		associationClassCallExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getFeatureCallExp());
		navigationCallExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getNavigationCallExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getProperty());
		g1.getETypeArguments().add(g2);
		navigationCallExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCallExp());
		featureCallExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getFeatureCallExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		featureCallExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getOCLExpression());
		callExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getCallExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		callExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theUMLPackage_1.getTypedElement());
		oclExpressionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getOCLExpression());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		oclExpressionEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPrimitiveLiteralExp());
		booleanLiteralExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getBooleanLiteralExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		booleanLiteralExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getLiteralExp());
		primitiveLiteralExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getPrimitiveLiteralExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		primitiveLiteralExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getOCLExpression());
		literalExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getLiteralExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		literalExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCollectionLiteralPart());
		collectionItemEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getCollectionItem());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		collectionItemEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theUMLPackage_1.getTypedElement());
		collectionLiteralPartEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage
			.getCollectionLiteralPart());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		collectionLiteralPartEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getLiteralExp());
		collectionLiteralExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getCollectionLiteralExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		collectionLiteralExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCollectionLiteralPart());
		collectionRangeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getCollectionRange());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		collectionRangeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getLiteralExp());
		enumLiteralExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getEnumLiteralExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getEnumerationLiteral());
		g1.getETypeArguments().add(g2);
		enumLiteralExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getOCLExpression());
		ifExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getIfExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		ifExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getNumericLiteralExp());
		integerLiteralExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getIntegerLiteralExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		integerLiteralExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPrimitiveLiteralExp());
		numericLiteralExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getNumericLiteralExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		numericLiteralExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getNumericLiteralExp());
		unlimitedNaturalLiteralExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage
			.getUnlimitedNaturalLiteralExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		unlimitedNaturalLiteralExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getLiteralExp());
		invalidLiteralExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getInvalidLiteralExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		invalidLiteralExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getLoopExp());
		iterateExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getIterateExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getParameter());
		g1.getETypeArguments().add(g2);
		iterateExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getCallExp());
		loopExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getLoopExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getParameter());
		g1.getETypeArguments().add(g2);
		loopExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getLoopExp());
		iteratorExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getIteratorExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getParameter());
		g1.getETypeArguments().add(g2);
		iteratorExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getOCLExpression());
		letExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getLetExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getParameter());
		g1.getETypeArguments().add(g2);
		letExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getOCLExpression());
		messageExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getMessageExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getCallOperationAction());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getSendSignalAction());
		g1.getETypeArguments().add(g2);
		messageExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getLiteralExp());
		nullLiteralExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getNullLiteralExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		nullLiteralExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getFeatureCallExp());
		operationCallExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getOperationCallExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getOperation());
		g1.getETypeArguments().add(g2);
		operationCallExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getNavigationCallExp());
		propertyCallExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getPropertyCallExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getProperty());
		g1.getETypeArguments().add(g2);
		propertyCallExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getNumericLiteralExp());
		realLiteralExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getRealLiteralExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		realLiteralExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getOCLExpression());
		stateExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getStateExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getState());
		g1.getETypeArguments().add(g2);
		stateExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPrimitiveLiteralExp());
		stringLiteralExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getStringLiteralExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		stringLiteralExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getLiteralExp());
		tupleLiteralExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getTupleLiteralExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getProperty());
		g1.getETypeArguments().add(g2);
		tupleLiteralExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theUMLPackage_1.getTypedElement());
		tupleLiteralPartEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getTupleLiteralPart());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getProperty());
		g1.getETypeArguments().add(g2);
		tupleLiteralPartEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getOCLExpression());
		typeExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getTypeExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		typeExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getOCLExpression());
		unspecifiedValueExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getUnspecifiedValueExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		unspecifiedValueExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theUMLPackage_1.getTypedElement());
		variableEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getVariable());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getParameter());
		g1.getETypeArguments().add(g2);
		variableEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getOCLExpression());
		variableExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theExpressionsPackage.getVariableExp());
		g2 = createEGenericType(theUMLPackage_1.getClassifier());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theUMLPackage_1.getParameter());
		g1.getETypeArguments().add(g2);
		variableExpEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theUMLPackage_1.getClassifier());
		templateParameterTypeEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theTypesPackage.getTemplateParameterType());
		g2 = createEGenericType(theUMLPackage_1.getOperation());
		g1.getETypeArguments().add(g2);
		templateParameterTypeEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes and features; add operations and parameters
		initEClass(anyTypeEClass, AnyType.class,
			"AnyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
			getAnyType_OwnedOperation(),
			theUMLPackage_1.getOperation(),
			null,
			"ownedOperation", null, 0, -1, AnyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
			voidTypeEClass,
			VoidType.class,
			"VoidType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
			getVoidType_OwnedOperation(),
			theUMLPackage_1.getOperation(),
			null,
			"ownedOperation", null, 0, -1, VoidType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
			invalidTypeEClass,
			InvalidType.class,
			"InvalidType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
			getInvalidType_OwnedOperation(),
			theUMLPackage_1.getOperation(),
			null,
			"ownedOperation", null, 0, -1, InvalidType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
			elementTypeEClass,
			ElementType.class,
			"ElementType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			typeTypeEClass,
			TypeType.class,
			"TypeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
			getTypeType_OwnedOperation(),
			theUMLPackage_1.getOperation(),
			null,
			"ownedOperation", null, 0, -1, TypeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
			messageTypeEClass,
			MessageType.class,
			"MessageType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
			getMessageType_OwnedOperation(),
			theUMLPackage_1.getOperation(),
			null,
			"ownedOperation", null, 0, -1, MessageType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
			getMessageType_OwnedAttribute(),
			theUMLPackage_1.getProperty(),
			null,
			"ownedAttribute", null, 0, -1, MessageType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
			primitiveTypeEClass,
			PrimitiveType.class,
			"PrimitiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			collectionTypeEClass,
			CollectionType.class,
			"CollectionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			tupleTypeEClass,
			TupleType.class,
			"TupleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(bagTypeEClass, BagType.class,
			"BagType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(setTypeEClass, SetType.class,
			"SetType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			orderedSetTypeEClass,
			OrderedSetType.class,
			"OrderedSetType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			sequenceTypeEClass,
			SequenceType.class,
			"SequenceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			expressionInOCLEClass,
			ExpressionInOCL.class,
			"ExpressionInOCL", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			associationClassCallExpEClass,
			AssociationClassCallExp.class,
			"AssociationClassCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			navigationCallExpEClass,
			NavigationCallExp.class,
			"NavigationCallExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			featureCallExpEClass,
			FeatureCallExp.class,
			"FeatureCallExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(callExpEClass, CallExp.class,
			"CallExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			oclExpressionEClass,
			OCLExpression.class,
			"OCLExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			booleanLiteralExpEClass,
			BooleanLiteralExp.class,
			"BooleanLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			primitiveLiteralExpEClass,
			PrimitiveLiteralExp.class,
			"PrimitiveLiteralExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			literalExpEClass,
			LiteralExp.class,
			"LiteralExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			collectionItemEClass,
			CollectionItem.class,
			"CollectionItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			collectionLiteralPartEClass,
			CollectionLiteralPart.class,
			"CollectionLiteralPart", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			collectionLiteralExpEClass,
			CollectionLiteralExp.class,
			"CollectionLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			collectionRangeEClass,
			CollectionRange.class,
			"CollectionRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			enumLiteralExpEClass,
			EnumLiteralExp.class,
			"EnumLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(ifExpEClass, IfExp.class,
			"IfExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			integerLiteralExpEClass,
			IntegerLiteralExp.class,
			"IntegerLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			numericLiteralExpEClass,
			NumericLiteralExp.class,
			"NumericLiteralExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			unlimitedNaturalLiteralExpEClass,
			UnlimitedNaturalLiteralExp.class,
			"UnlimitedNaturalLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			invalidLiteralExpEClass,
			InvalidLiteralExp.class,
			"InvalidLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			iterateExpEClass,
			IterateExp.class,
			"IterateExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(loopExpEClass, LoopExp.class,
			"LoopExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			iteratorExpEClass,
			IteratorExp.class,
			"IteratorExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(letExpEClass, LetExp.class,
			"LetExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			messageExpEClass,
			MessageExp.class,
			"MessageExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			nullLiteralExpEClass,
			NullLiteralExp.class,
			"NullLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			operationCallExpEClass,
			OperationCallExp.class,
			"OperationCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			propertyCallExpEClass,
			PropertyCallExp.class,
			"PropertyCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			realLiteralExpEClass,
			RealLiteralExp.class,
			"RealLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			stateExpEClass,
			StateExp.class,
			"StateExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			stringLiteralExpEClass,
			StringLiteralExp.class,
			"StringLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			tupleLiteralExpEClass,
			TupleLiteralExp.class,
			"TupleLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			tupleLiteralPartEClass,
			TupleLiteralPart.class,
			"TupleLiteralPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(typeExpEClass, TypeExp.class,
			"TypeExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			unspecifiedValueExpEClass,
			UnspecifiedValueExp.class,
			"UnspecifiedValueExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			variableEClass,
			Variable.class,
			"Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			variableExpEClass,
			VariableExp.class,
			"VariableExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(
			templateParameterTypeEClass,
			TemplateParameterType.class,
			"TemplateParameterType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
			getTemplateParameterType_OwnedOperation(),
			theUMLPackage_1.getOperation(),
			null,
			"ownedOperation", null, 0, -1, TemplateParameterType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// subsets
		createSubsetsAnnotations();
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
	}

	/**
	 * Initializes the annotations for <b>subsets</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createSubsetsAnnotations() {
		String source = "subsets"; //$NON-NLS-1$		
		addAnnotation(getAnyType_OwnedOperation(), source, new String[]{},
			new URI[]{URI.createURI(org.eclipse.uml2.uml.UMLPackage.eNS_URI)
				.appendFragment("//Classifier/feature") //$NON-NLS-1$
			});
		addAnnotation(getVoidType_OwnedOperation(), source, new String[]{},
			new URI[]{URI.createURI(org.eclipse.uml2.uml.UMLPackage.eNS_URI)
				.appendFragment("//Classifier/feature") //$NON-NLS-1$
			});
		addAnnotation(getInvalidType_OwnedOperation(), source, new String[]{},
			new URI[]{URI.createURI(org.eclipse.uml2.uml.UMLPackage.eNS_URI)
				.appendFragment("//Classifier/feature") //$NON-NLS-1$
			});
		addAnnotation(getTypeType_OwnedOperation(), source, new String[]{},
			new URI[]{URI.createURI(org.eclipse.uml2.uml.UMLPackage.eNS_URI)
				.appendFragment("//Classifier/feature") //$NON-NLS-1$
			});
		addAnnotation(getMessageType_OwnedOperation(), source, new String[]{},
			new URI[]{URI.createURI(org.eclipse.uml2.uml.UMLPackage.eNS_URI)
				.appendFragment("//Classifier/feature") //$NON-NLS-1$
			});
		addAnnotation(getMessageType_OwnedAttribute(), source, new String[]{},
			new URI[]{URI.createURI(org.eclipse.uml2.uml.UMLPackage.eNS_URI)
				.appendFragment("//Classifier/attribute") //$NON-NLS-1$
			});
		addAnnotation(getTemplateParameterType_OwnedOperation(), source,
			new String[]{}, new URI[]{URI.createURI(
				org.eclipse.uml2.uml.UMLPackage.eNS_URI).appendFragment(
				"//Classifier/feature") //$NON-NLS-1$
			});
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$								
		addAnnotation(expressionInOCLEClass, source, new String[]{
			"name", "ExpressionInOcl" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(oclExpressionEClass, source, new String[]{
			"name", "OclExpression" //$NON-NLS-1$ //$NON-NLS-2$
		});
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore"; //$NON-NLS-1$										
		addAnnotation(oclExpressionEClass, source, new String[]{
			"constraints", "has_type" //$NON-NLS-1$ //$NON-NLS-2$
		});
	}

} //UMLPackageImpl
