/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.Expressions.impl;

import com.sap.tc.moin.repository.mmi.Model.ModelPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.omg.OCL.Attaching.AttachingPackage;

import org.omg.OCL.Attaching.impl.AttachingPackageImpl;

import org.omg.OCL.Expressions.AssociationEndCallExp;
import org.omg.OCL.Expressions.AttributeCallExp;
import org.omg.OCL.Expressions.BooleanLiteralExp;
import org.omg.OCL.Expressions.CollectionItem;
import org.omg.OCL.Expressions.CollectionKind;
import org.omg.OCL.Expressions.CollectionLiteralExp;
import org.omg.OCL.Expressions.CollectionLiteralPart;
import org.omg.OCL.Expressions.CollectionRange;
import org.omg.OCL.Expressions.EnumLiteralExp;
import org.omg.OCL.Expressions.ExpressionsFactory;
import org.omg.OCL.Expressions.ExpressionsPackage;
import org.omg.OCL.Expressions.IfExp;
import org.omg.OCL.Expressions.IntegerLiteralExp;
import org.omg.OCL.Expressions.IterateExp;
import org.omg.OCL.Expressions.IteratorExp;
import org.omg.OCL.Expressions.LetExp;
import org.omg.OCL.Expressions.LiteralExp;
import org.omg.OCL.Expressions.LoopExp;
import org.omg.OCL.Expressions.ModelPropertyCallExp;
import org.omg.OCL.Expressions.NavigationCallExp;
import org.omg.OCL.Expressions.NumericLiteralExp;
import org.omg.OCL.Expressions.OclExpression;
import org.omg.OCL.Expressions.OclNamedElement;
import org.omg.OCL.Expressions.OperationCallExp;
import org.omg.OCL.Expressions.PrimitiveLiteralExp;
import org.omg.OCL.Expressions.PropertyCallExp;
import org.omg.OCL.Expressions.RealLiteralExp;
import org.omg.OCL.Expressions.StringLiteralExp;
import org.omg.OCL.Expressions.TupleLiteralExp;
import org.omg.OCL.Expressions.TypeExp;
import org.omg.OCL.Expressions.VariableDeclaration;
import org.omg.OCL.Expressions.VariableExp;

import org.omg.OCL.StdLibrary.StdLibraryPackage;

import org.omg.OCL.StdLibrary.impl.StdLibraryPackageImpl;

import org.omg.OCL.Types.TypesPackage;

import org.omg.OCL.Types.impl.TypesPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionsPackageImpl extends EPackageImpl implements ExpressionsPackage {
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
	private EClass propertyCallExpEClass = null;

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
	private EClass ifExpEClass = null;

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
	private EClass modelPropertyCallExpEClass = null;

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
	private EClass iterateExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeCallExpEClass = null;

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
	private EClass operationCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationEndCallExpEClass = null;

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
	private EClass stringLiteralExpEClass = null;

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
	private EClass booleanLiteralExpEClass = null;

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
	private EClass collectionLiteralExpEClass = null;

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
	private EClass integerLiteralExpEClass = null;

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
	private EClass collectionLiteralPartEClass = null;

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
	private EClass collectionItemEClass = null;

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
	private EClass typeExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclNamedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum collectionKindEEnum = null;

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
	 * @see org.omg.OCL.Expressions.ExpressionsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExpressionsPackageImpl() {
		super(eNS_URI, ExpressionsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ExpressionsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExpressionsPackage init() {
		if (isInited) return (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

		// Obtain or create and register package
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExpressionsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ModelPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);
		AttachingPackageImpl theAttachingPackage = (AttachingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AttachingPackage.eNS_URI) instanceof AttachingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AttachingPackage.eNS_URI) : AttachingPackage.eINSTANCE);
		StdLibraryPackageImpl theStdLibraryPackage = (StdLibraryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StdLibraryPackage.eNS_URI) instanceof StdLibraryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StdLibraryPackage.eNS_URI) : StdLibraryPackage.eINSTANCE);

		// Create package meta-data objects
		theExpressionsPackage.createPackageContents();
		theTypesPackage.createPackageContents();
		theAttachingPackage.createPackageContents();
		theStdLibraryPackage.createPackageContents();

		// Initialize created meta-data
		theExpressionsPackage.initializePackageContents();
		theTypesPackage.initializePackageContents();
		theAttachingPackage.initializePackageContents();
		theStdLibraryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExpressionsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExpressionsPackage.eNS_URI, theExpressionsPackage);
		return theExpressionsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOclExpression() {
		return oclExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclExpression_Type() {
		return (EReference)oclExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclExpression_AppliedProperty() {
		return (EReference)oclExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclExpression_ParentOperation() {
		return (EReference)oclExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclExpression_AttributeForInitialValue() {
		return (EReference)oclExpressionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclExpression_AssociationEndForInitialValue() {
		return (EReference)oclExpressionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclExpression_Defines() {
		return (EReference)oclExpressionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclExpression_AssociationEndForDerivationExpression() {
		return (EReference)oclExpressionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclExpression_AttributeForDerivationExpression() {
		return (EReference)oclExpressionEClass.getEStructuralFeatures().get(7);
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
	public EReference getPropertyCallExp_Source() {
		return (EReference)propertyCallExpEClass.getEStructuralFeatures().get(0);
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
	public EClass getIfExp() {
		return ifExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfExp_Condition() {
		return (EReference)ifExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfExp_ThenExpression() {
		return (EReference)ifExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfExp_ElseExpression() {
		return (EReference)ifExpEClass.getEStructuralFeatures().get(2);
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
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableExp_ReferredVariable() {
		return (EReference)variableExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelPropertyCallExp() {
		return modelPropertyCallExpEClass;
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
	public EReference getLoopExp_Iterators() {
		return (EReference)loopExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopExp_Body() {
		return (EReference)loopExpEClass.getEStructuralFeatures().get(1);
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
	public EClass getIterateExp() {
		return iterateExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIterateExp_Result() {
		return (EReference)iterateExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableDeclaration() {
		return variableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableDeclaration_VarName() {
		return (EAttribute)variableDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableDeclaration_Type() {
		return (EReference)variableDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableDeclaration_LoopExpr() {
		return (EReference)variableDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableDeclaration_BaseExp() {
		return (EReference)variableDeclarationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableDeclaration_InitExpression() {
		return (EReference)variableDeclarationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeCallExp() {
		return attributeCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeCallExp_ReferredAttribute() {
		return (EReference)attributeCallExpEClass.getEStructuralFeatures().get(0);
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
	public EReference getNavigationCallExp_NavigationSource() {
		return (EReference)navigationCallExpEClass.getEStructuralFeatures().get(0);
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
	public EReference getOperationCallExp_ReferredOperation() {
		return (EReference)operationCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationCallExp_Arguments() {
		return (EReference)operationCallExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociationEndCallExp() {
		return associationEndCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociationEndCallExp_ReferredAssociationEnd() {
		return (EReference)associationEndCallExpEClass.getEStructuralFeatures().get(0);
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
	public EClass getStringLiteralExp() {
		return stringLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringLiteralExp_StringSymbol() {
		return (EAttribute)stringLiteralExpEClass.getEStructuralFeatures().get(0);
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
	public EClass getBooleanLiteralExp() {
		return booleanLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanLiteralExp_BooleanSymbol() {
		return (EAttribute)booleanLiteralExpEClass.getEStructuralFeatures().get(0);
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
	public EReference getTupleLiteralExp_TuplePart() {
		return (EReference)tupleLiteralExpEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getCollectionLiteralExp_Kind() {
		return (EAttribute)collectionLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionLiteralExp_Parts() {
		return (EReference)collectionLiteralExpEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getEnumLiteralExp_Literal() {
		return (EAttribute)enumLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumLiteralExp_ReferredEnum() {
		return (EReference)enumLiteralExpEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getIntegerLiteralExp_IntegerSymbol() {
		return (EAttribute)integerLiteralExpEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getRealLiteralExp_RealSymbol() {
		return (EAttribute)realLiteralExpEClass.getEStructuralFeatures().get(0);
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
	public EReference getCollectionLiteralPart_Type() {
		return (EReference)collectionLiteralPartEClass.getEStructuralFeatures().get(0);
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
	public EReference getCollectionRange_Last() {
		return (EReference)collectionRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionRange_First() {
		return (EReference)collectionRangeEClass.getEStructuralFeatures().get(1);
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
	public EReference getCollectionItem_Item() {
		return (EReference)collectionItemEClass.getEStructuralFeatures().get(0);
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
	public EReference getLetExp_In() {
		return (EReference)letExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLetExp_Variable() {
		return (EReference)letExpEClass.getEStructuralFeatures().get(1);
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
	public EReference getTypeExp_ReferredType() {
		return (EReference)typeExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOclNamedElement() {
		return oclNamedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOclNamedElement_Name() {
		return (EAttribute)oclNamedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCollectionKind() {
		return collectionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionsFactory getExpressionsFactory() {
		return (ExpressionsFactory)getEFactoryInstance();
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
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		oclExpressionEClass = createEClass(OCL_EXPRESSION);
		createEReference(oclExpressionEClass, OCL_EXPRESSION__TYPE);
		createEReference(oclExpressionEClass, OCL_EXPRESSION__APPLIED_PROPERTY);
		createEReference(oclExpressionEClass, OCL_EXPRESSION__PARENT_OPERATION);
		createEReference(oclExpressionEClass, OCL_EXPRESSION__ATTRIBUTE_FOR_INITIAL_VALUE);
		createEReference(oclExpressionEClass, OCL_EXPRESSION__ASSOCIATION_END_FOR_INITIAL_VALUE);
		createEReference(oclExpressionEClass, OCL_EXPRESSION__DEFINES);
		createEReference(oclExpressionEClass, OCL_EXPRESSION__ASSOCIATION_END_FOR_DERIVATION_EXPRESSION);
		createEReference(oclExpressionEClass, OCL_EXPRESSION__ATTRIBUTE_FOR_DERIVATION_EXPRESSION);

		propertyCallExpEClass = createEClass(PROPERTY_CALL_EXP);
		createEReference(propertyCallExpEClass, PROPERTY_CALL_EXP__SOURCE);

		literalExpEClass = createEClass(LITERAL_EXP);

		ifExpEClass = createEClass(IF_EXP);
		createEReference(ifExpEClass, IF_EXP__CONDITION);
		createEReference(ifExpEClass, IF_EXP__THEN_EXPRESSION);
		createEReference(ifExpEClass, IF_EXP__ELSE_EXPRESSION);

		variableExpEClass = createEClass(VARIABLE_EXP);
		createEReference(variableExpEClass, VARIABLE_EXP__REFERRED_VARIABLE);

		modelPropertyCallExpEClass = createEClass(MODEL_PROPERTY_CALL_EXP);

		loopExpEClass = createEClass(LOOP_EXP);
		createEReference(loopExpEClass, LOOP_EXP__ITERATORS);
		createEReference(loopExpEClass, LOOP_EXP__BODY);

		iteratorExpEClass = createEClass(ITERATOR_EXP);

		iterateExpEClass = createEClass(ITERATE_EXP);
		createEReference(iterateExpEClass, ITERATE_EXP__RESULT);

		variableDeclarationEClass = createEClass(VARIABLE_DECLARATION);
		createEAttribute(variableDeclarationEClass, VARIABLE_DECLARATION__VAR_NAME);
		createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__TYPE);
		createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__LOOP_EXPR);
		createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__BASE_EXP);
		createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__INIT_EXPRESSION);

		attributeCallExpEClass = createEClass(ATTRIBUTE_CALL_EXP);
		createEReference(attributeCallExpEClass, ATTRIBUTE_CALL_EXP__REFERRED_ATTRIBUTE);

		navigationCallExpEClass = createEClass(NAVIGATION_CALL_EXP);
		createEReference(navigationCallExpEClass, NAVIGATION_CALL_EXP__NAVIGATION_SOURCE);

		operationCallExpEClass = createEClass(OPERATION_CALL_EXP);
		createEReference(operationCallExpEClass, OPERATION_CALL_EXP__REFERRED_OPERATION);
		createEReference(operationCallExpEClass, OPERATION_CALL_EXP__ARGUMENTS);

		associationEndCallExpEClass = createEClass(ASSOCIATION_END_CALL_EXP);
		createEReference(associationEndCallExpEClass, ASSOCIATION_END_CALL_EXP__REFERRED_ASSOCIATION_END);

		primitiveLiteralExpEClass = createEClass(PRIMITIVE_LITERAL_EXP);

		stringLiteralExpEClass = createEClass(STRING_LITERAL_EXP);
		createEAttribute(stringLiteralExpEClass, STRING_LITERAL_EXP__STRING_SYMBOL);

		numericLiteralExpEClass = createEClass(NUMERIC_LITERAL_EXP);

		booleanLiteralExpEClass = createEClass(BOOLEAN_LITERAL_EXP);
		createEAttribute(booleanLiteralExpEClass, BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL);

		tupleLiteralExpEClass = createEClass(TUPLE_LITERAL_EXP);
		createEReference(tupleLiteralExpEClass, TUPLE_LITERAL_EXP__TUPLE_PART);

		collectionLiteralExpEClass = createEClass(COLLECTION_LITERAL_EXP);
		createEAttribute(collectionLiteralExpEClass, COLLECTION_LITERAL_EXP__KIND);
		createEReference(collectionLiteralExpEClass, COLLECTION_LITERAL_EXP__PARTS);

		enumLiteralExpEClass = createEClass(ENUM_LITERAL_EXP);
		createEAttribute(enumLiteralExpEClass, ENUM_LITERAL_EXP__LITERAL);
		createEReference(enumLiteralExpEClass, ENUM_LITERAL_EXP__REFERRED_ENUM);

		integerLiteralExpEClass = createEClass(INTEGER_LITERAL_EXP);
		createEAttribute(integerLiteralExpEClass, INTEGER_LITERAL_EXP__INTEGER_SYMBOL);

		realLiteralExpEClass = createEClass(REAL_LITERAL_EXP);
		createEAttribute(realLiteralExpEClass, REAL_LITERAL_EXP__REAL_SYMBOL);

		collectionLiteralPartEClass = createEClass(COLLECTION_LITERAL_PART);
		createEReference(collectionLiteralPartEClass, COLLECTION_LITERAL_PART__TYPE);

		collectionRangeEClass = createEClass(COLLECTION_RANGE);
		createEReference(collectionRangeEClass, COLLECTION_RANGE__LAST);
		createEReference(collectionRangeEClass, COLLECTION_RANGE__FIRST);

		collectionItemEClass = createEClass(COLLECTION_ITEM);
		createEReference(collectionItemEClass, COLLECTION_ITEM__ITEM);

		letExpEClass = createEClass(LET_EXP);
		createEReference(letExpEClass, LET_EXP__IN);
		createEReference(letExpEClass, LET_EXP__VARIABLE);

		typeExpEClass = createEClass(TYPE_EXP);
		createEReference(typeExpEClass, TYPE_EXP__REFERRED_TYPE);

		oclNamedElementEClass = createEClass(OCL_NAMED_ELEMENT);
		createEAttribute(oclNamedElementEClass, OCL_NAMED_ELEMENT__NAME);

		// Create enums
		collectionKindEEnum = createEEnum(COLLECTION_KIND);
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		oclExpressionEClass.getESuperTypes().add(this.getOclNamedElement());
		propertyCallExpEClass.getESuperTypes().add(this.getOclExpression());
		literalExpEClass.getESuperTypes().add(this.getOclExpression());
		ifExpEClass.getESuperTypes().add(this.getOclExpression());
		variableExpEClass.getESuperTypes().add(this.getOclExpression());
		modelPropertyCallExpEClass.getESuperTypes().add(this.getPropertyCallExp());
		loopExpEClass.getESuperTypes().add(this.getPropertyCallExp());
		iteratorExpEClass.getESuperTypes().add(this.getLoopExp());
		iterateExpEClass.getESuperTypes().add(this.getLoopExp());
		variableDeclarationEClass.getESuperTypes().add(this.getOclNamedElement());
		attributeCallExpEClass.getESuperTypes().add(this.getModelPropertyCallExp());
		navigationCallExpEClass.getESuperTypes().add(this.getModelPropertyCallExp());
		operationCallExpEClass.getESuperTypes().add(this.getModelPropertyCallExp());
		associationEndCallExpEClass.getESuperTypes().add(this.getNavigationCallExp());
		primitiveLiteralExpEClass.getESuperTypes().add(this.getLiteralExp());
		stringLiteralExpEClass.getESuperTypes().add(this.getPrimitiveLiteralExp());
		numericLiteralExpEClass.getESuperTypes().add(this.getPrimitiveLiteralExp());
		booleanLiteralExpEClass.getESuperTypes().add(this.getPrimitiveLiteralExp());
		tupleLiteralExpEClass.getESuperTypes().add(this.getLiteralExp());
		collectionLiteralExpEClass.getESuperTypes().add(this.getLiteralExp());
		enumLiteralExpEClass.getESuperTypes().add(this.getLiteralExp());
		integerLiteralExpEClass.getESuperTypes().add(this.getNumericLiteralExp());
		realLiteralExpEClass.getESuperTypes().add(this.getNumericLiteralExp());
		collectionRangeEClass.getESuperTypes().add(this.getCollectionLiteralPart());
		collectionItemEClass.getESuperTypes().add(this.getCollectionLiteralPart());
		letExpEClass.getESuperTypes().add(this.getOclExpression());
		typeExpEClass.getESuperTypes().add(this.getOclExpression());

		// Initialize classes and features; add operations and parameters
		initEClass(oclExpressionEClass, OclExpression.class, "OclExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOclExpression_Type(), theModelPackage.getClassifier(), null, "type", null, 1, 1, OclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOclExpression_AppliedProperty(), this.getPropertyCallExp(), this.getPropertyCallExp_Source(), "appliedProperty", null, 0, 1, OclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOclExpression_ParentOperation(), this.getOperationCallExp(), this.getOperationCallExp_Arguments(), "parentOperation", null, 0, 1, OclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOclExpression_AttributeForInitialValue(), theModelPackage.getAttribute(), null, "attributeForInitialValue", null, 0, 1, OclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOclExpression_AssociationEndForInitialValue(), theModelPackage.getAssociationEnd(), null, "associationEndForInitialValue", null, 0, 1, OclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOclExpression_Defines(), theModelPackage.getOperation(), null, "defines", null, 0, -1, OclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOclExpression_AssociationEndForDerivationExpression(), theModelPackage.getAssociationEnd(), null, "associationEndForDerivationExpression", null, 0, 1, OclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOclExpression_AttributeForDerivationExpression(), theModelPackage.getAttribute(), null, "attributeForDerivationExpression", null, 0, 1, OclExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(propertyCallExpEClass, PropertyCallExp.class, "PropertyCallExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyCallExp_Source(), this.getOclExpression(), this.getOclExpression_AppliedProperty(), "source", null, 0, 1, PropertyCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(literalExpEClass, LiteralExp.class, "LiteralExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ifExpEClass, IfExp.class, "IfExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIfExp_Condition(), this.getOclExpression(), null, "condition", null, 1, 1, IfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getIfExp_ThenExpression(), this.getOclExpression(), null, "thenExpression", null, 1, 1, IfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getIfExp_ElseExpression(), this.getOclExpression(), null, "elseExpression", null, 1, 1, IfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(variableExpEClass, VariableExp.class, "VariableExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableExp_ReferredVariable(), this.getVariableDeclaration(), null, "referredVariable", null, 1, 1, VariableExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(modelPropertyCallExpEClass, ModelPropertyCallExp.class, "ModelPropertyCallExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(loopExpEClass, LoopExp.class, "LoopExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoopExp_Iterators(), this.getVariableDeclaration(), this.getVariableDeclaration_LoopExpr(), "iterators", null, 1, -1, LoopExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLoopExp_Body(), this.getOclExpression(), null, "body", null, 1, 1, LoopExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(iteratorExpEClass, IteratorExp.class, "IteratorExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iterateExpEClass, IterateExp.class, "IterateExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIterateExp_Result(), this.getVariableDeclaration(), this.getVariableDeclaration_BaseExp(), "result", null, 1, 1, IterateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(variableDeclarationEClass, VariableDeclaration.class, "VariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariableDeclaration_VarName(), ecorePackage.getEString(), "varName", null, 1, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariableDeclaration_Type(), theModelPackage.getClassifier(), null, "type", null, 1, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariableDeclaration_LoopExpr(), this.getLoopExp(), this.getLoopExp_Iterators(), "loopExpr", null, 0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariableDeclaration_BaseExp(), this.getIterateExp(), this.getIterateExp_Result(), "baseExp", null, 0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariableDeclaration_InitExpression(), this.getOclExpression(), null, "initExpression", null, 0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(attributeCallExpEClass, AttributeCallExp.class, "AttributeCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeCallExp_ReferredAttribute(), theModelPackage.getAttribute(), null, "referredAttribute", null, 1, 1, AttributeCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(navigationCallExpEClass, NavigationCallExp.class, "NavigationCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNavigationCallExp_NavigationSource(), theModelPackage.getAssociationEnd(), null, "navigationSource", null, 1, 1, NavigationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(operationCallExpEClass, OperationCallExp.class, "OperationCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationCallExp_ReferredOperation(), theModelPackage.getOperation(), null, "referredOperation", null, 1, 1, OperationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOperationCallExp_Arguments(), this.getOclExpression(), this.getOclExpression_ParentOperation(), "arguments", null, 0, -1, OperationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(associationEndCallExpEClass, AssociationEndCallExp.class, "AssociationEndCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssociationEndCallExp_ReferredAssociationEnd(), theModelPackage.getAssociationEnd(), null, "referredAssociationEnd", null, 1, 1, AssociationEndCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(primitiveLiteralExpEClass, PrimitiveLiteralExp.class, "PrimitiveLiteralExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringLiteralExpEClass, StringLiteralExp.class, "StringLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringLiteralExp_StringSymbol(), ecorePackage.getEString(), "stringSymbol", null, 1, 1, StringLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(numericLiteralExpEClass, NumericLiteralExp.class, "NumericLiteralExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(booleanLiteralExpEClass, BooleanLiteralExp.class, "BooleanLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanLiteralExp_BooleanSymbol(), ecorePackage.getEBoolean(), "booleanSymbol", null, 1, 1, BooleanLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(tupleLiteralExpEClass, TupleLiteralExp.class, "TupleLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTupleLiteralExp_TuplePart(), this.getVariableDeclaration(), null, "tuplePart", null, 0, -1, TupleLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(collectionLiteralExpEClass, CollectionLiteralExp.class, "CollectionLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCollectionLiteralExp_Kind(), this.getCollectionKind(), "kind", null, 1, 1, CollectionLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCollectionLiteralExp_Parts(), this.getCollectionLiteralPart(), null, "parts", null, 0, -1, CollectionLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumLiteralExpEClass, EnumLiteralExp.class, "EnumLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumLiteralExp_Literal(), ecorePackage.getEString(), "literal", null, 1, 1, EnumLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEnumLiteralExp_ReferredEnum(), theModelPackage.getEnumerationType(), null, "referredEnum", null, 1, 1, EnumLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(integerLiteralExpEClass, IntegerLiteralExp.class, "IntegerLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerLiteralExp_IntegerSymbol(), ecorePackage.getEInt(), "integerSymbol", null, 1, 1, IntegerLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(realLiteralExpEClass, RealLiteralExp.class, "RealLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRealLiteralExp_RealSymbol(), ecorePackage.getEDouble(), "realSymbol", null, 1, 1, RealLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(collectionLiteralPartEClass, CollectionLiteralPart.class, "CollectionLiteralPart", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionLiteralPart_Type(), theModelPackage.getClassifier(), null, "type", null, 1, 1, CollectionLiteralPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(collectionRangeEClass, CollectionRange.class, "CollectionRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionRange_Last(), this.getOclExpression(), null, "last", null, 1, 1, CollectionRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCollectionRange_First(), this.getOclExpression(), null, "first", null, 1, 1, CollectionRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(collectionItemEClass, CollectionItem.class, "CollectionItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionItem_Item(), this.getOclExpression(), null, "item", null, 1, 1, CollectionItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(letExpEClass, LetExp.class, "LetExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLetExp_In(), this.getOclExpression(), null, "in", null, 1, 1, LetExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLetExp_Variable(), this.getVariableDeclaration(), null, "variable", null, 1, 1, LetExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(typeExpEClass, TypeExp.class, "TypeExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeExp_ReferredType(), theModelPackage.getClassifier(), null, "referredType", null, 0, 1, TypeExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(oclNamedElementEClass, OclNamedElement.class, "OclNamedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOclNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, OclNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(collectionKindEEnum, CollectionKind.class, "CollectionKind");
		addEEnumLiteral(collectionKindEEnum, CollectionKind.COLLECTION);
		addEEnumLiteral(collectionKindEEnum, CollectionKind.SET);
		addEEnumLiteral(collectionKindEEnum, CollectionKind.BAG);
		addEEnumLiteral(collectionKindEEnum, CollectionKind.SEQUENCE);
		addEEnumLiteral(collectionKindEEnum, CollectionKind.ORDERED_SET);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://sap.com/MOIN
		createMOINAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://sap.com/MOIN</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createMOINAnnotations() {
		String source = "http://sap.com/MOIN";		
		addAnnotation
		  (getOclExpression_Type(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_type_oclExpression",
			 "metaObjectMofId", "45ED2E29A8976A898EAF47150D76C377A0EDBAC2",
			 "storedEnd", "1",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (getOclExpression_AppliedProperty(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_appliedProperty_source",
			 "metaObjectMofId", "45ED2E299BB9CF41F9C44C763865EFB27EADFA32",
			 "storedEnd", "0",
			 "compositeEnd", "0",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (getOclExpression_ParentOperation(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_parentOperation_arguments",
			 "metaObjectMofId", "45ED2E297046BE46EB524CAA1143F6FD9EE9162C",
			 "storedEnd", "0",
			 "compositeEnd", "0",
			 "orderedEnd", "1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (getOclExpression_AttributeForInitialValue(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Attaching.AttributeInitalValue",
			 "metaObjectMofId", "45ED2E29A286E6ED595D4D21383BDF80C5FFDA11",
			 "storedEnd", "1",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (getOclExpression_AssociationEndForInitialValue(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Attaching.AssociationEndInitialValue",
			 "metaObjectMofId", "45ED2E2900D7CC82F45E481F01A3CB414C39021A",
			 "storedEnd", "0",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "0"
		   });		
		addAnnotation
		  (getOclExpression_Defines(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Attaching.OperationBodyDefinition",
			 "metaObjectMofId", "45ED2E2931823687B9EA4F3B2FA8D1089389DA6A",
			 "storedEnd", "0",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "0"
		   });		
		addAnnotation
		  (getOclExpression_AssociationEndForDerivationExpression(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Attaching.AssociationEndDerivationExpression",
			 "metaObjectMofId", "45ED2E29DA068B3F43BC491E1A0DB705FE6FEF09",
			 "storedEnd", "0",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "0"
		   });		
		addAnnotation
		  (getOclExpression_AttributeForDerivationExpression(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Attaching.AttributeDerivationExpression",
			 "metaObjectMofId", "45ED2E29AD7CF6B69D7E479E0A67C662FE56B082",
			 "storedEnd", "0",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "0"
		   });		
		addAnnotation
		  (getPropertyCallExp_Source(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_appliedProperty_source",
			 "metaObjectMofId", "45ED2E299BB9CF41F9C44C763865EFB27EADFA32",
			 "storedEnd", "0",
			 "compositeEnd", "0",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "0"
		   });		
		addAnnotation
		  (ifExpEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.IfExp",
			 "metaObjectMofId", "45ED2E296713E8548CA0440612CEC754B8D9E97D",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getIfExp_Condition(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_condition_ifExp",
			 "metaObjectMofId", "45ED2E29CC01DA6D5C74404208109A267FE01F4F",
			 "storedEnd", "1",
			 "compositeEnd", "1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (getIfExp_ThenExpression(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_thenExpression_ifExp",
			 "metaObjectMofId", "45ED2E297FC22AF1C85C470F38138E009DBBF185",
			 "storedEnd", "1",
			 "compositeEnd", "1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (getIfExp_ElseExpression(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_elseExpression_ifExp",
			 "metaObjectMofId", "45ED2E29772E62E656B445AE302FC07252D70BBD",
			 "storedEnd", "1",
			 "compositeEnd", "1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (variableExpEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.VariableExp",
			 "metaObjectMofId", "45ED2E29CC82DA386CE549F12BDDC286838F7B40",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getVariableExp_ReferredVariable(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_referredVariable_variableExp",
			 "metaObjectMofId", "45ED2E29CFD391FEB1964F3529B1D77CD1D60A9E",
			 "storedEnd", "1",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (getLoopExp_Iterators(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_loopExpr_iterators",
			 "metaObjectMofId", "45ED2E29E362C10B4E2048E117CCE6FC0738D230",
			 "storedEnd", "0",
			 "compositeEnd", "0",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "0"
		   });		
		addAnnotation
		  (getLoopExp_Body(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_loopExp_body",
			 "metaObjectMofId", "45ED2E29AD18B58C80B648FF2B6BB8226FFE8ED5",
			 "storedEnd", "0",
			 "compositeEnd", "0",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "0"
		   });		
		addAnnotation
		  (iteratorExpEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.IteratorExp",
			 "metaObjectMofId", "45ED2E296F723EF00F0340CD16D4972BC685277B",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (iterateExpEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.IterateExp",
			 "metaObjectMofId", "45ED2E29EF4CCD17D5D649D02F0AE9877FA6D96B",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getIterateExp_Result(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_baseExp_result",
			 "metaObjectMofId", "45ED2E290A4BA5F7848749961A4BF84E47601746",
			 "storedEnd", "0",
			 "compositeEnd", "0",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "0"
		   });		
		addAnnotation
		  (variableDeclarationEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.VariableDeclaration",
			 "metaObjectMofId", "45ED2E29BC1A4730247040AC0E6BFC5D0207A4BC",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getVariableDeclaration_Type(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_type_variableDeclaration",
			 "metaObjectMofId", "45ED2E29EFCE7A95243B401D25B8DE9E2968A520",
			 "storedEnd", "1",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (getVariableDeclaration_LoopExpr(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_loopExpr_iterators",
			 "metaObjectMofId", "45ED2E29E362C10B4E2048E117CCE6FC0738D230",
			 "storedEnd", "0",
			 "compositeEnd", "0",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (getVariableDeclaration_BaseExp(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_baseExp_result",
			 "metaObjectMofId", "45ED2E290A4BA5F7848749961A4BF84E47601746",
			 "storedEnd", "0",
			 "compositeEnd", "0",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (getVariableDeclaration_InitExpression(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_initExpression_initializedVariable",
			 "metaObjectMofId", "45ED2E29305042DD1D714FE10210C36447281C01",
			 "storedEnd", "1",
			 "compositeEnd", "1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (attributeCallExpEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.AttributeCallExp",
			 "metaObjectMofId", "45ED2E29A08E98D7286846340041E0BCDA075FDB",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getAttributeCallExp_ReferredAttribute(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_referredAttribute_attributeCallExp",
			 "metaObjectMofId", "45ED2E29CAFD7D3C99E34EAA2F3EBDF07176CA55",
			 "storedEnd", "1",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (navigationCallExpEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.NavigationCallExp",
			 "metaObjectMofId", "45ED2E29EFE35FF1987D4F740DA9CAEF5A8133E7",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getNavigationCallExp_NavigationSource(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_navigationSource_navigationCallExp",
			 "metaObjectMofId", "45ED2E29C3F3694401514BBF08EFC44C72D73F4A",
			 "storedEnd", "1",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (operationCallExpEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.OperationCallExp",
			 "metaObjectMofId", "45ED2E2999F6EE43264341113E06E6B7B76AEBA3",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getOperationCallExp_ReferredOperation(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_referredOperation_operationCallExp",
			 "metaObjectMofId", "45ED2E292E44287A94754BA40DFCDAD59E374E24",
			 "storedEnd", "1",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (getOperationCallExp_Arguments(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_parentOperation_arguments",
			 "metaObjectMofId", "45ED2E297046BE46EB524CAA1143F6FD9EE9162C",
			 "storedEnd", "0",
			 "compositeEnd", "0",
			 "orderedEnd", "1",
			 "exposedEndNumber", "0"
		   });		
		addAnnotation
		  (associationEndCallExpEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.AssociationEndCallExp",
			 "metaObjectMofId", "45ED2E2900FC935917F3496F0460C878F0E27694",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getAssociationEndCallExp_ReferredAssociationEnd(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_referredAssociationEnd_associationEndCallExp",
			 "metaObjectMofId", "45ED2E2910D16B625EE4448200A697638E1ADA03",
			 "storedEnd", "1",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (stringLiteralExpEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.StringLiteralExp",
			 "metaObjectMofId", "45ED2E298FCDC4EFE56B4494349ED616A64ACF7C",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (booleanLiteralExpEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.BooleanLiteralExp",
			 "metaObjectMofId", "45ED2E297470678AA04A4C043A26F78357A0B795",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (tupleLiteralExpEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.TupleLiteralExp",
			 "metaObjectMofId", "45ED2E29625CCBD9F5794AD1313FDE30289D23D0",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getTupleLiteralExp_TuplePart(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_tuplePart_tupleLiteralExp",
			 "metaObjectMofId", "45ED2E2923015E6DE474466D075EE20F01D20408",
			 "storedEnd", "1",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (collectionLiteralExpEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.CollectionLiteralExp",
			 "metaObjectMofId", "45ED2E29472815739F3249CA2042CD5D538A0E30",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getCollectionLiteralExp_Parts(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_parts_collectionLiteralExp",
			 "metaObjectMofId", "45ED2E29D8D44430F78B40093A9FD47468E3F189",
			 "storedEnd", "1",
			 "compositeEnd", "-1",
			 "orderedEnd", "0",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (enumLiteralExpEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.EnumLiteralExp",
			 "metaObjectMofId", "45ED2E29135E0C46DCEC4E593E05A865ECFC172D",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getEnumLiteralExp_ReferredEnum(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_referredEnum_enumLiteralExp",
			 "metaObjectMofId", "45ED2E29490A740DE11C474C2F08A2C6A93F305C",
			 "storedEnd", "1",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (integerLiteralExpEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.IntegerLiteralExp",
			 "metaObjectMofId", "45ED2E29EEDA585F4AF44039203DAA3F135B8576",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (realLiteralExpEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.RealLiteralExp",
			 "metaObjectMofId", "45ED2E29DFE83AEDB03D4A643BFCA881D0543B35",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getCollectionLiteralPart_Type(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_type_collectionLiteralPart",
			 "metaObjectMofId", "45ED2E2946E538578ED24E180AF5C7116A08C357",
			 "storedEnd", "1",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (collectionRangeEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.CollectionRange",
			 "metaObjectMofId", "45ED2E293A277DE0D466471B0B1AF4115BE67D97",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getCollectionRange_Last(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_last_collectionRange",
			 "metaObjectMofId", "45ED2E29D107E14CFE0E40450846E2F623A1DF17",
			 "storedEnd", "1",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (getCollectionRange_First(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_first_collectionRange",
			 "metaObjectMofId", "45ED2E2902710881712F4F3811F7A4CD85971027",
			 "storedEnd", "1",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (collectionItemEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.CollectionItem",
			 "metaObjectMofId", "45ED2E29262986DC6D7041F22F80FB64160F7D83",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getCollectionItem_Item(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_item_collectionItem",
			 "metaObjectMofId", "45ED2E295B6AFDDE2D1446151E81FB73EB61D305",
			 "storedEnd", "1",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (letExpEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.LetExp",
			 "metaObjectMofId", "45ED2E2934FB0AA78C4F4AA71D66DA3A83F78CC6",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getLetExp_In(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_in_letExp",
			 "metaObjectMofId", "45ED2E290417D46F5F3349E73B2AEEAFC4471870",
			 "storedEnd", "1",
			 "compositeEnd", "1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (getLetExp_Variable(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_variable_letExp",
			 "metaObjectMofId", "45ED2E29ED141ECC1591429C2FB683D4E5789AEA",
			 "storedEnd", "1",
			 "compositeEnd", "1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (typeExpEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.TypeExp",
			 "metaObjectMofId", "45ED2E2922E623058A24485C271EF62E09C2EDE1",
			 "isStructureType", "false"
		   });		
		addAnnotation
		  (getTypeExp_ReferredType(), 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.A_referredType_typeExp",
			 "metaObjectMofId", "45ED2E293259BA3FF2F44777241CCE59F79C33C0",
			 "storedEnd", "1",
			 "compositeEnd", "-1",
			 "orderedEnd", "-1",
			 "exposedEndNumber", "1"
		   });		
		addAnnotation
		  (oclNamedElementEClass, 
		   source, 
		   new String[] {
			 "metamodels", "sap.com/tc/moin/mof_1.4[1.0]",
			 "metaObject", "OCL.Expressions.OclNamedElement",
			 "metaObjectMofId", "474BE1D8487DE7D19CCA11DC8BD500199904B925",
			 "isStructureType", "false"
		   });
	}

} //ExpressionsPackageImpl
