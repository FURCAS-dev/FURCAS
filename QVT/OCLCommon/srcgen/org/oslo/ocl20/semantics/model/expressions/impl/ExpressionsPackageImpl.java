/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.oslo.ocl20.semantics.SemanticsPackage;

import org.oslo.ocl20.semantics.bridge.BridgePackage;

import org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl;

import org.oslo.ocl20.semantics.impl.SemanticsPackageImpl;

import org.oslo.ocl20.semantics.model.contexts.ContextsPackage;

import org.oslo.ocl20.semantics.model.contexts.impl.ContextsPackageImpl;

import org.oslo.ocl20.semantics.model.expressions.BooleanLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.CallExp;
import org.oslo.ocl20.semantics.model.expressions.CollectionItem;
import org.oslo.ocl20.semantics.model.expressions.CollectionKind;
import org.oslo.ocl20.semantics.model.expressions.CollectionLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.CollectionLiteralPart;
import org.oslo.ocl20.semantics.model.expressions.CollectionRange;
import org.oslo.ocl20.semantics.model.expressions.EnumLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.ExpressionsFactory;
import org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage;
import org.oslo.ocl20.semantics.model.expressions.IfExp;
import org.oslo.ocl20.semantics.model.expressions.IntegerLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.IterateExp;
import org.oslo.ocl20.semantics.model.expressions.IteratorExp;
import org.oslo.ocl20.semantics.model.expressions.LetExp;
import org.oslo.ocl20.semantics.model.expressions.LiteralExp;
import org.oslo.ocl20.semantics.model.expressions.LoopExp;
import org.oslo.ocl20.semantics.model.expressions.ModelPropertyCallExp;
import org.oslo.ocl20.semantics.model.expressions.NumericalLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.OclExpression;
import org.oslo.ocl20.semantics.model.expressions.OclMessageArg;
import org.oslo.ocl20.semantics.model.expressions.OclMessageExp;
import org.oslo.ocl20.semantics.model.expressions.OperationCallExp;
import org.oslo.ocl20.semantics.model.expressions.PropertyCallExp;
import org.oslo.ocl20.semantics.model.expressions.RealLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.StringLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.TupleLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.TypeLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.UndefinedLiteralExp;
import org.oslo.ocl20.semantics.model.expressions.UnspecifiedValueExp;
import org.oslo.ocl20.semantics.model.expressions.VariableDeclaration;
import org.oslo.ocl20.semantics.model.expressions.VariableExp;

import org.oslo.ocl20.semantics.model.types.TypesPackage;

import org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ExpressionsPackageImpl extends EPackageImpl implements ExpressionsPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass booleanLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass callExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass collectionItemEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass collectionLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass collectionLiteralPartEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass collectionRangeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass enumLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass ifExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass integerLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass iterateExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass iteratorExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass letExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass literalExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass loopExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass modelPropertyCallExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass numericalLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass oclExpressionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass oclMessageArgEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass oclMessageExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass operationCallExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass propertyCallExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass realLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass stringLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass tupleLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass typeLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass undefinedLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass unspecifiedValueExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass variableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass variableExpEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum collectionKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI
	 * value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init
	 * init()}, which also performs initialization of the package, or returns the registered
	 * package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExpressionsPackageImpl() {
		super(eNS_URI, ExpressionsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others
	 * upon which it depends. Simple dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else. This method drives initialization for
	 * interdependent packages directly, in parallel with this package, itself.
	 * <p>
	 * Of this package and its interdependencies, all packages which have not yet been registered by
	 * their URI values are first created and registered. The packages are then initialized in two
	 * steps: meta-model objects for all of the packages are created before any are initialized,
	 * since one package's meta-model objects may refer to those of another.
	 * <p>
	 * Invocation of this method will not affect any packages that have already been initialized.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExpressionsPackage init() {
		if (isInited)
			return (ExpressionsPackage) EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

		// Obtain or create and register package
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl) (EPackage.Registry.INSTANCE
		        .getEPackage(eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE
		        .getEPackage(eNS_URI) : new ExpressionsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		SemanticsPackageImpl theSemanticsPackage = (SemanticsPackageImpl) (EPackage.Registry.INSTANCE
		        .getEPackage(SemanticsPackage.eNS_URI) instanceof SemanticsPackageImpl ? EPackage.Registry.INSTANCE
		        .getEPackage(SemanticsPackage.eNS_URI) : SemanticsPackage.eINSTANCE);
		BridgePackageImpl theBridgePackage = (BridgePackageImpl) (EPackage.Registry.INSTANCE
		        .getEPackage(BridgePackage.eNS_URI) instanceof BridgePackageImpl ? EPackage.Registry.INSTANCE
		        .getEPackage(BridgePackage.eNS_URI) : BridgePackage.eINSTANCE);
		ContextsPackageImpl theContextsPackage = (ContextsPackageImpl) (EPackage.Registry.INSTANCE
		        .getEPackage(ContextsPackage.eNS_URI) instanceof ContextsPackageImpl ? EPackage.Registry.INSTANCE
		        .getEPackage(ContextsPackage.eNS_URI) : ContextsPackage.eINSTANCE);
		TypesPackageImpl theTypesPackage = (TypesPackageImpl) (EPackage.Registry.INSTANCE
		        .getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE
		        .getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);

		// Create package meta-data objects
		theExpressionsPackage.createPackageContents();
		theSemanticsPackage.createPackageContents();
		theBridgePackage.createPackageContents();
		theContextsPackage.createPackageContents();
		theTypesPackage.createPackageContents();

		// Initialize created meta-data
		theExpressionsPackage.initializePackageContents();
		theSemanticsPackage.initializePackageContents();
		theBridgePackage.initializePackageContents();
		theContextsPackage.initializePackageContents();
		theTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExpressionsPackage.freeze();

		return theExpressionsPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getBooleanLiteralExp() {
		return booleanLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getBooleanLiteralExp_BooleanSymbol() {
		return (EAttribute) booleanLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCallExp() {
		return callExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCallExp_Source() {
		return (EReference) callExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCollectionItem() {
		return collectionItemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCollectionItem_Item() {
		return (EReference) collectionItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCollectionLiteralExp() {
		return collectionLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getCollectionLiteralExp_Kind() {
		return (EAttribute) collectionLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCollectionLiteralExp_Parts() {
		return (EReference) collectionLiteralExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCollectionLiteralPart() {
		return collectionLiteralPartEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCollectionLiteralPart_CollectionLiteralExp() {
		return (EReference) collectionLiteralPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCollectionLiteralPart_Type() {
		return (EReference) collectionLiteralPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCollectionRange() {
		return collectionRangeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCollectionRange_Last() {
		return (EReference) collectionRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCollectionRange_First() {
		return (EReference) collectionRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getEnumLiteralExp() {
		return enumLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEnumLiteralExp_ReferredEnumLiteral() {
		return (EReference) enumLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getIfExp() {
		return ifExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIfExp_ElseExpression() {
		return (EReference) ifExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIfExp_ThenExpression() {
		return (EReference) ifExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIfExp_Condition() {
		return (EReference) ifExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getIntegerLiteralExp() {
		return integerLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getIntegerLiteralExp_IntegerSymbol() {
		return (EAttribute) integerLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getIterateExp() {
		return iterateExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIterateExp_Result() {
		return (EReference) iterateExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getIteratorExp() {
		return iteratorExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getLetExp() {
		return letExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getLetExp_In() {
		return (EReference) letExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getLetExp_Variable() {
		return (EReference) letExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getLiteralExp() {
		return literalExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getLoopExp() {
		return loopExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getLoopExp_Body() {
		return (EReference) loopExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getLoopExp_Iterators() {
		return (EReference) loopExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getModelPropertyCallExp() {
		return modelPropertyCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getNumericalLiteralExp() {
		return numericalLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getOclExpression() {
		return oclExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getOclExpression_IsMarkedPre() {
		return (EAttribute) oclExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOclExpression_LoopExp() {
		return (EReference) oclExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOclExpression_OperationCallExp() {
		return (EReference) oclExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOclExpression_PropertyCallExp() {
		return (EReference) oclExpressionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOclExpression_Type() {
		return (EReference) oclExpressionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOclExpression_AppliedProperty() {
		return (EReference) oclExpressionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOclExpression_InitialisedVariable() {
		return (EReference) oclExpressionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getOclMessageArg() {
		return oclMessageArgEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOclMessageArg_Expression() {
		return (EReference) oclMessageArgEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOclMessageArg_Unspecified() {
		return (EReference) oclMessageArgEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getOclMessageExp() {
		return oclMessageExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOclMessageExp_Arguments() {
		return (EReference) oclMessageExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOclMessageExp_Target() {
		return (EReference) oclMessageExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getOperationCallExp() {
		return operationCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOperationCallExp_ReferredOperation() {
		return (EReference) operationCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOperationCallExp_Arguments() {
		return (EReference) operationCallExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPropertyCallExp() {
		return propertyCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPropertyCallExp_Qualifiers() {
		return (EReference) propertyCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPropertyCallExp_ReferredProperty() {
		return (EReference) propertyCallExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getRealLiteralExp() {
		return realLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getRealLiteralExp_RealSymbol() {
		return (EAttribute) realLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getStringLiteralExp() {
		return stringLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getStringLiteralExp_StringSymbol() {
		return (EAttribute) stringLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTupleLiteralExp() {
		return tupleLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTupleLiteralExp_TuplePart() {
		return (EReference) tupleLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTypeLiteralExp() {
		return typeLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTypeLiteralExp_LiteralType() {
		return (EReference) typeLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getUndefinedLiteralExp() {
		return undefinedLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getUnspecifiedValueExp() {
		return unspecifiedValueExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getVariableDeclaration() {
		return variableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getVariableDeclaration_VariableExps() {
		return (EReference) variableDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getVariableDeclaration_TupleLiteralExp() {
		return (EReference) variableDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getVariableDeclaration_LoopExpr() {
		return (EReference) variableDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getVariableDeclaration_Type() {
		return (EReference) variableDeclarationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getVariableDeclaration_BaseExp() {
		return (EReference) variableDeclarationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getVariableDeclaration_InitExpression() {
		return (EReference) variableDeclarationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getVariableExp() {
		return variableExpEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getVariableExp_ReferredVariable() {
		return (EReference) variableExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getCollectionKind() {
		return collectionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ExpressionsFactory getExpressionsFactory() {
		return (ExpressionsFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is guarded to have no affect on
	 * any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		booleanLiteralExpEClass = createEClass(BOOLEAN_LITERAL_EXP);
		createEAttribute(booleanLiteralExpEClass, BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL);

		callExpEClass = createEClass(CALL_EXP);
		createEReference(callExpEClass, CALL_EXP__SOURCE);

		collectionItemEClass = createEClass(COLLECTION_ITEM);
		createEReference(collectionItemEClass, COLLECTION_ITEM__ITEM);

		collectionLiteralExpEClass = createEClass(COLLECTION_LITERAL_EXP);
		createEAttribute(collectionLiteralExpEClass, COLLECTION_LITERAL_EXP__KIND);
		createEReference(collectionLiteralExpEClass, COLLECTION_LITERAL_EXP__PARTS);

		collectionLiteralPartEClass = createEClass(COLLECTION_LITERAL_PART);
		createEReference(collectionLiteralPartEClass, COLLECTION_LITERAL_PART__COLLECTION_LITERAL_EXP);
		createEReference(collectionLiteralPartEClass, COLLECTION_LITERAL_PART__TYPE);

		collectionRangeEClass = createEClass(COLLECTION_RANGE);
		createEReference(collectionRangeEClass, COLLECTION_RANGE__LAST);
		createEReference(collectionRangeEClass, COLLECTION_RANGE__FIRST);

		enumLiteralExpEClass = createEClass(ENUM_LITERAL_EXP);
		createEReference(enumLiteralExpEClass, ENUM_LITERAL_EXP__REFERRED_ENUM_LITERAL);

		ifExpEClass = createEClass(IF_EXP);
		createEReference(ifExpEClass, IF_EXP__ELSE_EXPRESSION);
		createEReference(ifExpEClass, IF_EXP__THEN_EXPRESSION);
		createEReference(ifExpEClass, IF_EXP__CONDITION);

		integerLiteralExpEClass = createEClass(INTEGER_LITERAL_EXP);
		createEAttribute(integerLiteralExpEClass, INTEGER_LITERAL_EXP__INTEGER_SYMBOL);

		iterateExpEClass = createEClass(ITERATE_EXP);
		createEReference(iterateExpEClass, ITERATE_EXP__RESULT);

		iteratorExpEClass = createEClass(ITERATOR_EXP);

		letExpEClass = createEClass(LET_EXP);
		createEReference(letExpEClass, LET_EXP__IN);
		createEReference(letExpEClass, LET_EXP__VARIABLE);

		literalExpEClass = createEClass(LITERAL_EXP);

		loopExpEClass = createEClass(LOOP_EXP);
		createEReference(loopExpEClass, LOOP_EXP__BODY);
		createEReference(loopExpEClass, LOOP_EXP__ITERATORS);

		modelPropertyCallExpEClass = createEClass(MODEL_PROPERTY_CALL_EXP);

		numericalLiteralExpEClass = createEClass(NUMERICAL_LITERAL_EXP);

		oclExpressionEClass = createEClass(OCL_EXPRESSION);
		createEAttribute(oclExpressionEClass, OCL_EXPRESSION__IS_MARKED_PRE);
		createEReference(oclExpressionEClass, OCL_EXPRESSION__LOOP_EXP);
		createEReference(oclExpressionEClass, OCL_EXPRESSION__OPERATION_CALL_EXP);
		createEReference(oclExpressionEClass, OCL_EXPRESSION__PROPERTY_CALL_EXP);
		createEReference(oclExpressionEClass, OCL_EXPRESSION__TYPE);
		createEReference(oclExpressionEClass, OCL_EXPRESSION__APPLIED_PROPERTY);
		createEReference(oclExpressionEClass, OCL_EXPRESSION__INITIALISED_VARIABLE);

		oclMessageArgEClass = createEClass(OCL_MESSAGE_ARG);
		createEReference(oclMessageArgEClass, OCL_MESSAGE_ARG__EXPRESSION);
		createEReference(oclMessageArgEClass, OCL_MESSAGE_ARG__UNSPECIFIED);

		oclMessageExpEClass = createEClass(OCL_MESSAGE_EXP);
		createEReference(oclMessageExpEClass, OCL_MESSAGE_EXP__ARGUMENTS);
		createEReference(oclMessageExpEClass, OCL_MESSAGE_EXP__TARGET);

		operationCallExpEClass = createEClass(OPERATION_CALL_EXP);
		createEReference(operationCallExpEClass, OPERATION_CALL_EXP__REFERRED_OPERATION);
		createEReference(operationCallExpEClass, OPERATION_CALL_EXP__ARGUMENTS);

		propertyCallExpEClass = createEClass(PROPERTY_CALL_EXP);
		createEReference(propertyCallExpEClass, PROPERTY_CALL_EXP__QUALIFIERS);
		createEReference(propertyCallExpEClass, PROPERTY_CALL_EXP__REFERRED_PROPERTY);

		realLiteralExpEClass = createEClass(REAL_LITERAL_EXP);
		createEAttribute(realLiteralExpEClass, REAL_LITERAL_EXP__REAL_SYMBOL);

		stringLiteralExpEClass = createEClass(STRING_LITERAL_EXP);
		createEAttribute(stringLiteralExpEClass, STRING_LITERAL_EXP__STRING_SYMBOL);

		tupleLiteralExpEClass = createEClass(TUPLE_LITERAL_EXP);
		createEReference(tupleLiteralExpEClass, TUPLE_LITERAL_EXP__TUPLE_PART);

		typeLiteralExpEClass = createEClass(TYPE_LITERAL_EXP);
		createEReference(typeLiteralExpEClass, TYPE_LITERAL_EXP__LITERAL_TYPE);

		undefinedLiteralExpEClass = createEClass(UNDEFINED_LITERAL_EXP);

		unspecifiedValueExpEClass = createEClass(UNSPECIFIED_VALUE_EXP);

		variableDeclarationEClass = createEClass(VARIABLE_DECLARATION);
		createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__VARIABLE_EXPS);
		createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__TUPLE_LITERAL_EXP);
		createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__LOOP_EXPR);
		createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__TYPE);
		createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__BASE_EXP);
		createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__INIT_EXPRESSION);

		variableExpEClass = createEClass(VARIABLE_EXP);
		createEReference(variableExpEClass, VARIABLE_EXP__REFERRED_VARIABLE);

		// Create enums
		collectionKindEEnum = createEEnum(COLLECTION_KIND);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This method is guarded to have
	 * no affect on any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		SemanticsPackage theSemanticsPackage = (SemanticsPackage) EPackage.Registry.INSTANCE
		        .getEPackage(SemanticsPackage.eNS_URI);
		BridgePackage theBridgePackage = (BridgePackage) EPackage.Registry.INSTANCE.getEPackage(BridgePackage.eNS_URI);

		// Add supertypes to classes
		booleanLiteralExpEClass.getESuperTypes().add(this.getLiteralExp());
		callExpEClass.getESuperTypes().add(this.getOclExpression());
		collectionItemEClass.getESuperTypes().add(this.getCollectionLiteralPart());
		collectionLiteralExpEClass.getESuperTypes().add(this.getLiteralExp());
		collectionLiteralPartEClass.getESuperTypes().add(theSemanticsPackage.getSemanticsVisitable());
		collectionRangeEClass.getESuperTypes().add(this.getCollectionLiteralPart());
		enumLiteralExpEClass.getESuperTypes().add(this.getLiteralExp());
		ifExpEClass.getESuperTypes().add(this.getOclExpression());
		integerLiteralExpEClass.getESuperTypes().add(this.getNumericalLiteralExp());
		iterateExpEClass.getESuperTypes().add(this.getLoopExp());
		iteratorExpEClass.getESuperTypes().add(this.getLoopExp());
		letExpEClass.getESuperTypes().add(this.getOclExpression());
		literalExpEClass.getESuperTypes().add(this.getOclExpression());
		loopExpEClass.getESuperTypes().add(this.getCallExp());
		modelPropertyCallExpEClass.getESuperTypes().add(this.getCallExp());
		numericalLiteralExpEClass.getESuperTypes().add(this.getLiteralExp());
		oclExpressionEClass.getESuperTypes().add(theBridgePackage.getModelElement());
		oclMessageExpEClass.getESuperTypes().add(this.getOclExpression());
		operationCallExpEClass.getESuperTypes().add(this.getModelPropertyCallExp());
		propertyCallExpEClass.getESuperTypes().add(this.getModelPropertyCallExp());
		realLiteralExpEClass.getESuperTypes().add(this.getNumericalLiteralExp());
		stringLiteralExpEClass.getESuperTypes().add(this.getLiteralExp());
		tupleLiteralExpEClass.getESuperTypes().add(this.getLiteralExp());
		typeLiteralExpEClass.getESuperTypes().add(this.getLiteralExp());
		undefinedLiteralExpEClass.getESuperTypes().add(this.getLiteralExp());
		unspecifiedValueExpEClass.getESuperTypes().add(this.getOclExpression());
		variableDeclarationEClass.getESuperTypes().add(theBridgePackage.getModelElement());
		variableExpEClass.getESuperTypes().add(this.getOclExpression());

		// Initialize classes and features; add operations and parameters
		initEClass(booleanLiteralExpEClass, BooleanLiteralExp.class, "BooleanLiteralExp", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanLiteralExp_BooleanSymbol(), ecorePackage.getEBoolean(), "booleanSymbol", "false", 1,
		    1, BooleanLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(booleanLiteralExpEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(callExpEClass, CallExp.class, "CallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallExp_Source(), this.getOclExpression(), this.getOclExpression_AppliedProperty(), "source",
		    null, 0, 1, CallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
		    !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(collectionItemEClass, CollectionItem.class, "CollectionItem", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionItem_Item(), this.getOclExpression(), null, "item", null, 1, 1,
		    CollectionItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
		    !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(collectionItemEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(collectionLiteralExpEClass, CollectionLiteralExp.class, "CollectionLiteralExp", !IS_ABSTRACT,
		    !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCollectionLiteralExp_Kind(), this.getCollectionKind(), "kind", null, 1, 1,
		    CollectionLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionLiteralExp_Parts(), this.getCollectionLiteralPart(), this
		        .getCollectionLiteralPart_CollectionLiteralExp(), "parts", null, 0, -1, CollectionLiteralExp.class,
		    !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);

		op = addEOperation(collectionLiteralExpEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(collectionLiteralPartEClass, CollectionLiteralPart.class, "CollectionLiteralPart", !IS_ABSTRACT,
		    !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionLiteralPart_CollectionLiteralExp(), this.getCollectionLiteralExp(), this
		        .getCollectionLiteralExp_Parts(), "collectionLiteralExp", null, 1, 1, CollectionLiteralPart.class,
		    !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionLiteralPart_Type(), theBridgePackage.getClassifier(), null, "type", null, 1, 1,
		    CollectionLiteralPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
		    !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(collectionLiteralPartEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(collectionRangeEClass, CollectionRange.class, "CollectionRange", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionRange_Last(), this.getOclExpression(), null, "last", null, 1, 1,
		    CollectionRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
		    !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionRange_First(), this.getOclExpression(), null, "first", null, 1, 1,
		    CollectionRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
		    !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(collectionRangeEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(enumLiteralExpEClass, EnumLiteralExp.class, "EnumLiteralExp", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumLiteralExp_ReferredEnumLiteral(), theBridgePackage.getEnumLiteral(), null,
		    "referredEnumLiteral", null, 1, 1, EnumLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
		    !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(enumLiteralExpEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(ifExpEClass, IfExp.class, "IfExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIfExp_ElseExpression(), this.getOclExpression(), null, "elseExpression", null, 1, 1,
		    IfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
		    IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfExp_ThenExpression(), this.getOclExpression(), null, "thenExpression", null, 1, 1,
		    IfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
		    IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfExp_Condition(), this.getOclExpression(), null, "condition", null, 1, 1, IfExp.class,
		    !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);

		op = addEOperation(ifExpEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(integerLiteralExpEClass, IntegerLiteralExp.class, "IntegerLiteralExp", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerLiteralExp_IntegerSymbol(), ecorePackage.getEInt(), "integerSymbol", null, 1, 1,
		    IntegerLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);

		op = addEOperation(integerLiteralExpEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(iterateExpEClass, IterateExp.class, "IterateExp", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIterateExp_Result(), this.getVariableDeclaration(), this.getVariableDeclaration_BaseExp(),
		    "result", null, 1, 1, IterateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		    !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(iterateExpEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(iteratorExpEClass, IteratorExp.class, "IteratorExp", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(iteratorExpEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(letExpEClass, LetExp.class, "LetExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLetExp_In(), this.getOclExpression(), null, "in", null, 1, 1, LetExp.class, !IS_TRANSIENT,
		    !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
		    IS_ORDERED);
		initEReference(getLetExp_Variable(), this.getVariableDeclaration(), null, "variable", null, 1, 1, LetExp.class,
		    !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);

		op = addEOperation(letExpEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(literalExpEClass, LiteralExp.class, "LiteralExp", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);

		initEClass(loopExpEClass, LoopExp.class, "LoopExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoopExp_Body(), this.getOclExpression(), this.getOclExpression_LoopExp(), "body", null, 1, 1,
		    LoopExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
		    !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoopExp_Iterators(), this.getVariableDeclaration(), this.getVariableDeclaration_LoopExpr(),
		    "iterators", null, 1, -1, LoopExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		    !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelPropertyCallExpEClass, ModelPropertyCallExp.class, "ModelPropertyCallExp", !IS_ABSTRACT,
		    !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(numericalLiteralExpEClass, NumericalLiteralExp.class, "NumericalLiteralExp", !IS_ABSTRACT,
		    !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(oclExpressionEClass, OclExpression.class, "OclExpression", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOclExpression_IsMarkedPre(), ecorePackage.getEBoolean(), "isMarkedPre", null, 1, 1,
		    OclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);
		initEReference(getOclExpression_LoopExp(), this.getLoopExp(), this.getLoopExp_Body(), "loopExp", null, 0, 1,
		    OclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
		    !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOclExpression_OperationCallExp(), this.getOperationCallExp(), this
		        .getOperationCallExp_Arguments(), "operationCallExp", null, 1, 1, OclExpression.class, !IS_TRANSIENT,
		    !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
		    IS_ORDERED);
		initEReference(getOclExpression_PropertyCallExp(), this.getPropertyCallExp(), this
		        .getPropertyCallExp_Qualifiers(), "propertyCallExp", null, 1, 1, OclExpression.class, !IS_TRANSIENT,
		    !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
		    IS_ORDERED);
		initEReference(getOclExpression_Type(), theBridgePackage.getClassifier(), null, "type", null, 1, 1,
		    OclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
		    !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOclExpression_AppliedProperty(), this.getCallExp(), this.getCallExp_Source(),
		    "appliedProperty", null, 0, 1, OclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
		    !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOclExpression_InitialisedVariable(), this.getVariableDeclaration(), this
		        .getVariableDeclaration_InitExpression(), "initialisedVariable", null, 0, 1, OclExpression.class,
		    !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);

		initEClass(oclMessageArgEClass, OclMessageArg.class, "OclMessageArg", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOclMessageArg_Expression(), this.getOclExpression(), null, "expression", null, 0, 1,
		    OclMessageArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
		    !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOclMessageArg_Unspecified(), this.getUnspecifiedValueExp(), null, "unspecified", null, 0, 1,
		    OclMessageArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
		    !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oclMessageExpEClass, OclMessageExp.class, "OclMessageExp", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOclMessageExp_Arguments(), this.getOclMessageArg(), null, "arguments", null, 0, -1,
		    OclMessageExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
		    !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOclMessageExp_Target(), this.getOclExpression(), null, "target", null, 1, 1,
		    OclMessageExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
		    !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(oclMessageExpEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(operationCallExpEClass, OperationCallExp.class, "OperationCallExp", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationCallExp_ReferredOperation(), theBridgePackage.getOperation(), null,
		    "referredOperation", null, 1, 1, OperationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
		    !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationCallExp_Arguments(), this.getOclExpression(), this
		        .getOclExpression_OperationCallExp(), "arguments", null, 0, -1, OperationCallExp.class, !IS_TRANSIENT,
		    !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
		    IS_ORDERED);

		op = addEOperation(operationCallExpEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(propertyCallExpEClass, PropertyCallExp.class, "PropertyCallExp", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyCallExp_Qualifiers(), this.getOclExpression(), this
		        .getOclExpression_PropertyCallExp(), "qualifiers", null, 0, -1, PropertyCallExp.class, !IS_TRANSIENT,
		    !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
		    IS_ORDERED);
		initEReference(getPropertyCallExp_ReferredProperty(), theBridgePackage.getProperty(), null, "referredProperty",
		    null, 1, 1, PropertyCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
		    IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(propertyCallExpEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(realLiteralExpEClass, RealLiteralExp.class, "RealLiteralExp", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRealLiteralExp_RealSymbol(), ecorePackage.getEDouble(), "realSymbol", "0", 1, 1,
		    RealLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);

		op = addEOperation(realLiteralExpEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(stringLiteralExpEClass, StringLiteralExp.class, "StringLiteralExp", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringLiteralExp_StringSymbol(), ecorePackage.getEString(), "stringSymbol", null, 1, 1,
		    StringLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);

		op = addEOperation(stringLiteralExpEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(tupleLiteralExpEClass, TupleLiteralExp.class, "TupleLiteralExp", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTupleLiteralExp_TuplePart(), this.getVariableDeclaration(), this
		        .getVariableDeclaration_TupleLiteralExp(), "tuplePart", null, 0, -1, TupleLiteralExp.class,
		    !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);

		op = addEOperation(tupleLiteralExpEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(typeLiteralExpEClass, TypeLiteralExp.class, "TypeLiteralExp", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeLiteralExp_LiteralType(), theBridgePackage.getClassifier(), null, "literalType", null, 1,
		    1, TypeLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
		    !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(typeLiteralExpEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(undefinedLiteralExpEClass, UndefinedLiteralExp.class, "UndefinedLiteralExp", !IS_ABSTRACT,
		    !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(undefinedLiteralExpEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(unspecifiedValueExpEClass, UnspecifiedValueExp.class, "UnspecifiedValueExp", !IS_ABSTRACT,
		    !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(unspecifiedValueExpEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(variableDeclarationEClass, VariableDeclaration.class, "VariableDeclaration", !IS_ABSTRACT,
		    !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableDeclaration_VariableExps(), this.getVariableExp(), this
		        .getVariableExp_ReferredVariable(), "variableExps", null, 0, -1, VariableDeclaration.class,
		    !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableDeclaration_TupleLiteralExp(), this.getTupleLiteralExp(), this
		        .getTupleLiteralExp_TuplePart(), "tupleLiteralExp", null, 1, 1, VariableDeclaration.class,
		    !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableDeclaration_LoopExpr(), this.getLoopExp(), this.getLoopExp_Iterators(), "loopExpr",
		    null, 0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
		    !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableDeclaration_Type(), theBridgePackage.getClassifier(), null, "type", null, 1, 1,
		    VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
		    !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableDeclaration_BaseExp(), this.getIterateExp(), this.getIterateExp_Result(), "baseExp",
		    null, 0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
		    !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableDeclaration_InitExpression(), this.getOclExpression(), this
		        .getOclExpression_InitialisedVariable(), "initExpression", null, 0, 1, VariableDeclaration.class,
		    !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);

		op = addEOperation(variableDeclarationEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(variableExpEClass, VariableExp.class, "VariableExp", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableExp_ReferredVariable(), this.getVariableDeclaration(), this
		        .getVariableDeclaration_VariableExps(), "referredVariable", null, 1, 1, VariableExp.class,
		    !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);

		op = addEOperation(variableExpEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		// Initialize enums and add enum literals
		initEEnum(collectionKindEEnum, CollectionKind.class, "CollectionKind");
		addEEnumLiteral(collectionKindEEnum, CollectionKind.COLLECTION_LITERAL);
		addEEnumLiteral(collectionKindEEnum, CollectionKind.SET_LITERAL);
		addEEnumLiteral(collectionKindEEnum, CollectionKind.SEQUENCE_LITERAL);
		addEEnumLiteral(collectionKindEEnum, CollectionKind.BAG_LITERAL);
		addEEnumLiteral(collectionKindEEnum, CollectionKind.ORDERED_SET_LITERAL);
	}

} // ExpressionsPackageImpl
