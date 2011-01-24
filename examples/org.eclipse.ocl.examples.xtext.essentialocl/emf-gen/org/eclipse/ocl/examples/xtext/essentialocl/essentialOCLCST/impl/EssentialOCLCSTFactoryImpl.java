/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: EssentialOCLCSTFactoryImpl.java,v 1.6 2011/01/24 21:31:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BinaryOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BooleanLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ContextCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTFactory;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpConstraintCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.IndexExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvalidLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetVariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingArgCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigatingExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NavigationRole;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NestedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NullLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NumberLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrimitiveLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SelfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralPartCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TypeNameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnaryOperatorCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EssentialOCLCSTFactoryImpl extends EFactoryImpl implements EssentialOCLCSTFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EssentialOCLCSTFactory init() {
		try
		{
			EssentialOCLCSTFactory theEssentialOCLCSTFactory = (EssentialOCLCSTFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/ocl/3.1.0/EssentialOCLCST"); //$NON-NLS-1$ 
			if (theEssentialOCLCSTFactory != null)
			{
				return theEssentialOCLCSTFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EssentialOCLCSTFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EssentialOCLCSTFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID())
		{
			case EssentialOCLCSTPackage.BINARY_OPERATOR_CS: return createBinaryOperatorCS();
			case EssentialOCLCSTPackage.BOOLEAN_LITERAL_EXP_CS: return createBooleanLiteralExpCS();
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_EXP_CS: return createCollectionLiteralExpCS();
			case EssentialOCLCSTPackage.COLLECTION_LITERAL_PART_CS: return createCollectionLiteralPartCS();
			case EssentialOCLCSTPackage.COLLECTION_TYPE_CS: return createCollectionTypeCS();
			case EssentialOCLCSTPackage.CONTEXT_CS: return createContextCS();
			case EssentialOCLCSTPackage.EXP_CS: return createExpCS();
			case EssentialOCLCSTPackage.EXP_CONSTRAINT_CS: return createExpConstraintCS();
			case EssentialOCLCSTPackage.IF_EXP_CS: return createIfExpCS();
			case EssentialOCLCSTPackage.INDEX_EXP_CS: return createIndexExpCS();
			case EssentialOCLCSTPackage.INFIX_EXP_CS: return createInfixExpCS();
			case EssentialOCLCSTPackage.INVALID_LITERAL_EXP_CS: return createInvalidLiteralExpCS();
			case EssentialOCLCSTPackage.LET_EXP_CS: return createLetExpCS();
			case EssentialOCLCSTPackage.LET_VARIABLE_CS: return createLetVariableCS();
			case EssentialOCLCSTPackage.LITERAL_EXP_CS: return createLiteralExpCS();
			case EssentialOCLCSTPackage.NAME_EXP_CS: return createNameExpCS();
			case EssentialOCLCSTPackage.NAVIGATING_ARG_CS: return createNavigatingArgCS();
			case EssentialOCLCSTPackage.NAVIGATING_EXP_CS: return createNavigatingExpCS();
			case EssentialOCLCSTPackage.NAVIGATION_OPERATOR_CS: return createNavigationOperatorCS();
			case EssentialOCLCSTPackage.NESTED_EXP_CS: return createNestedExpCS();
			case EssentialOCLCSTPackage.NULL_LITERAL_EXP_CS: return createNullLiteralExpCS();
			case EssentialOCLCSTPackage.NUMBER_LITERAL_EXP_CS: return createNumberLiteralExpCS();
			case EssentialOCLCSTPackage.PREFIX_EXP_CS: return createPrefixExpCS();
			case EssentialOCLCSTPackage.PRIMITIVE_LITERAL_EXP_CS: return createPrimitiveLiteralExpCS();
			case EssentialOCLCSTPackage.SELF_EXP_CS: return createSelfExpCS();
			case EssentialOCLCSTPackage.STRING_LITERAL_EXP_CS: return createStringLiteralExpCS();
			case EssentialOCLCSTPackage.TUPLE_LITERAL_EXP_CS: return createTupleLiteralExpCS();
			case EssentialOCLCSTPackage.TUPLE_LITERAL_PART_CS: return createTupleLiteralPartCS();
			case EssentialOCLCSTPackage.TYPE_LITERAL_EXP_CS: return createTypeLiteralExpCS();
			case EssentialOCLCSTPackage.TYPE_NAME_EXP_CS: return createTypeNameExpCS();
			case EssentialOCLCSTPackage.UNARY_OPERATOR_CS: return createUnaryOperatorCS();
			case EssentialOCLCSTPackage.UNLIMITED_NATURAL_LITERAL_EXP_CS: return createUnlimitedNaturalLiteralExpCS();
			case EssentialOCLCSTPackage.VARIABLE_CS: return createVariableCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID())
		{
			case EssentialOCLCSTPackage.NAVIGATION_ROLE:
				return createNavigationRoleFromString(eDataType, initialValue);
			case EssentialOCLCSTPackage.BIG_NUMBER:
				return createBigNumberFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID())
		{
			case EssentialOCLCSTPackage.NAVIGATION_ROLE:
				return convertNavigationRoleToString(eDataType, instanceValue);
			case EssentialOCLCSTPackage.BIG_NUMBER:
				return convertBigNumberToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryOperatorCS createBinaryOperatorCS()
	{
		BinaryOperatorCSImpl binaryOperatorCS = new BinaryOperatorCSImpl();
		return binaryOperatorCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrefixExpCS createPrefixExpCS() {
		PrefixExpCSImpl prefixExpCS = new PrefixExpCSImpl();
		return prefixExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionTypeCS createCollectionTypeCS() {
		CollectionTypeCSImpl collectionTypeCS = new CollectionTypeCSImpl();
		return collectionTypeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextCS createContextCS()
	{
		ContextCSImpl contextCS = new ContextCSImpl();
		return contextCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpCS createExpCS() {
		ExpCSImpl expCS = new ExpCSImpl();
		return expCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpConstraintCS createExpConstraintCS()
	{
		ExpConstraintCSImpl expConstraintCS = new ExpConstraintCSImpl();
		return expConstraintCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeLiteralExpCS createTypeLiteralExpCS()
	{
		TypeLiteralExpCSImpl typeLiteralExpCS = new TypeLiteralExpCSImpl();
		return typeLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeNameExpCS createTypeNameExpCS()
	{
		TypeNameExpCSImpl typeNameExpCS = new TypeNameExpCSImpl();
		return typeNameExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryOperatorCS createUnaryOperatorCS()
	{
		UnaryOperatorCSImpl unaryOperatorCS = new UnaryOperatorCSImpl();
		return unaryOperatorCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnlimitedNaturalLiteralExpCS createUnlimitedNaturalLiteralExpCS()
	{
		UnlimitedNaturalLiteralExpCSImpl unlimitedNaturalLiteralExpCS = new UnlimitedNaturalLiteralExpCSImpl();
		return unlimitedNaturalLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableCS createVariableCS()
	{
		VariableCSImpl variableCS = new VariableCSImpl();
		return variableCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavigationRole createNavigationRoleFromString(EDataType eDataType, String initialValue)
	{
		NavigationRole result = NavigationRole.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNavigationRoleToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralExpCS createLiteralExpCS() {
		LiteralExpCSImpl literalExpCS = new LiteralExpCSImpl();
		return literalExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameExpCS createNameExpCS()
	{
		NameExpCSImpl nameExpCS = new NameExpCSImpl();
		return nameExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavigatingArgCS createNavigatingArgCS()
	{
		NavigatingArgCSImpl navigatingArgCS = new NavigatingArgCSImpl();
		return navigatingArgCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavigatingExpCS createNavigatingExpCS()
	{
		NavigatingExpCSImpl navigatingExpCS = new NavigatingExpCSImpl();
		return navigatingExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NavigationOperatorCS createNavigationOperatorCS()
	{
		NavigationOperatorCSImpl navigationOperatorCS = new NavigationOperatorCSImpl();
		return navigationOperatorCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NestedExpCS createNestedExpCS() {
		NestedExpCSImpl nestedExpCS = new NestedExpCSImpl();
		return nestedExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionLiteralExpCS createCollectionLiteralExpCS() {
		CollectionLiteralExpCSImpl collectionLiteralExpCS = new CollectionLiteralExpCSImpl();
		return collectionLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionLiteralPartCS createCollectionLiteralPartCS() {
		CollectionLiteralPartCSImpl collectionLiteralPartCS = new CollectionLiteralPartCSImpl();
		return collectionLiteralPartCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveLiteralExpCS createPrimitiveLiteralExpCS() {
		PrimitiveLiteralExpCSImpl primitiveLiteralExpCS = new PrimitiveLiteralExpCSImpl();
		return primitiveLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelfExpCS createSelfExpCS() {
		SelfExpCSImpl selfExpCS = new SelfExpCSImpl();
		return selfExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TupleLiteralExpCS createTupleLiteralExpCS() {
		TupleLiteralExpCSImpl tupleLiteralExpCS = new TupleLiteralExpCSImpl();
		return tupleLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TupleLiteralPartCS createTupleLiteralPartCS()
	{
		TupleLiteralPartCSImpl tupleLiteralPartCS = new TupleLiteralPartCSImpl();
		return tupleLiteralPartCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringLiteralExpCS createStringLiteralExpCS() {
		StringLiteralExpCSImpl stringLiteralExpCS = new StringLiteralExpCSImpl();
		return stringLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanLiteralExpCS createBooleanLiteralExpCS() {
		BooleanLiteralExpCSImpl booleanLiteralExpCS = new BooleanLiteralExpCSImpl();
		return booleanLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvalidLiteralExpCS createInvalidLiteralExpCS() {
		InvalidLiteralExpCSImpl invalidLiteralExpCS = new InvalidLiteralExpCSImpl();
		return invalidLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NullLiteralExpCS createNullLiteralExpCS() {
		NullLiteralExpCSImpl nullLiteralExpCS = new NullLiteralExpCSImpl();
		return nullLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberLiteralExpCS createNumberLiteralExpCS() {
		NumberLiteralExpCSImpl numberLiteralExpCS = new NumberLiteralExpCSImpl();
		return numberLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Number createBigNumberFromString(EDataType eDataType, String initialValue) {
		return (Number)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBigNumberToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfExpCS createIfExpCS() {
		IfExpCSImpl ifExpCS = new IfExpCSImpl();
		return ifExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexExpCS createIndexExpCS()
	{
		IndexExpCSImpl indexExpCS = new IndexExpCSImpl();
		return indexExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InfixExpCS createInfixExpCS() {
		InfixExpCSImpl infixExpCS = new InfixExpCSImpl();
		return infixExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LetExpCS createLetExpCS() {
		LetExpCSImpl letExpCS = new LetExpCSImpl();
		return letExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LetVariableCS createLetVariableCS()
	{
		LetVariableCSImpl letVariableCS = new LetVariableCSImpl();
		return letVariableCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EssentialOCLCSTPackage getEssentialOCLCSTPackage() {
		return (EssentialOCLCSTPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EssentialOCLCSTPackage getPackage() {
		return EssentialOCLCSTPackage.eINSTANCE;
	}

} //EssentialOCLCSTFactoryImpl
