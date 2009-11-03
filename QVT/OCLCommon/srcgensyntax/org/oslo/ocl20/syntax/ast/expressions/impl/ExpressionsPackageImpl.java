/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.expressions.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.oslo.ocl20.syntax.ast.AstPackage;

import org.oslo.ocl20.syntax.ast.contexts.ContextsPackage;

import org.oslo.ocl20.syntax.ast.contexts.impl.ContextsPackageImpl;

import org.oslo.ocl20.syntax.ast.expressions.AndExpAS;
import org.oslo.ocl20.syntax.ast.expressions.ArrowSelectionExpAS;
import org.oslo.ocl20.syntax.ast.expressions.AssociationCallExpAS;
import org.oslo.ocl20.syntax.ast.expressions.BooleanLiteralExpAS;
import org.oslo.ocl20.syntax.ast.expressions.CallExpAS;
import org.oslo.ocl20.syntax.ast.expressions.CollectionItemAS;
import org.oslo.ocl20.syntax.ast.expressions.CollectionKindAS;
import org.oslo.ocl20.syntax.ast.expressions.CollectionLiteralExpAS;
import org.oslo.ocl20.syntax.ast.expressions.CollectionLiteralPartAS;
import org.oslo.ocl20.syntax.ast.expressions.CollectionRangeAS;
import org.oslo.ocl20.syntax.ast.expressions.DotSelectionExpAS;
import org.oslo.ocl20.syntax.ast.expressions.EnumLiteralExpAS;
import org.oslo.ocl20.syntax.ast.expressions.ExpressionsFactory;
import org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage;
import org.oslo.ocl20.syntax.ast.expressions.IfExpAS;
import org.oslo.ocl20.syntax.ast.expressions.ImpliesExpAS;
import org.oslo.ocl20.syntax.ast.expressions.IntegerLiteralExpAS;
import org.oslo.ocl20.syntax.ast.expressions.IterateExpAS;
import org.oslo.ocl20.syntax.ast.expressions.IteratorExpAS;
import org.oslo.ocl20.syntax.ast.expressions.LetExpAS;
import org.oslo.ocl20.syntax.ast.expressions.LiteralExpAS;
import org.oslo.ocl20.syntax.ast.expressions.LogicalExpAS;
import org.oslo.ocl20.syntax.ast.expressions.LoopExpAS;
import org.oslo.ocl20.syntax.ast.expressions.NotExpAS;
import org.oslo.ocl20.syntax.ast.expressions.OclExpressionAS;
import org.oslo.ocl20.syntax.ast.expressions.OclMessageArgAS;
import org.oslo.ocl20.syntax.ast.expressions.OclMessageExpAS;
import org.oslo.ocl20.syntax.ast.expressions.OclMessageKindAS;
import org.oslo.ocl20.syntax.ast.expressions.OperationCallExpAS;
import org.oslo.ocl20.syntax.ast.expressions.OrExpAS;
import org.oslo.ocl20.syntax.ast.expressions.PathNameExpAS;
import org.oslo.ocl20.syntax.ast.expressions.PrimaryExpAS;
import org.oslo.ocl20.syntax.ast.expressions.PrimitiveLiteralExpAS;
import org.oslo.ocl20.syntax.ast.expressions.RealLiteralExpAS;
import org.oslo.ocl20.syntax.ast.expressions.SelectionExpAS;
import org.oslo.ocl20.syntax.ast.expressions.StringLiteralExpAS;
import org.oslo.ocl20.syntax.ast.expressions.TupleLiteralExpAS;
import org.oslo.ocl20.syntax.ast.expressions.XorExpAS;

import org.oslo.ocl20.syntax.ast.impl.AstPackageImpl;

import org.oslo.ocl20.syntax.ast.qvt.impl.PackageImpl;
import org.oslo.ocl20.syntax.ast.qvt.QvtPackage;

import org.oslo.ocl20.syntax.ast.qvt.impl.QvtPackageImpl;

import org.oslo.ocl20.syntax.ast.types.TypesPackage;

import org.oslo.ocl20.syntax.ast.types.impl.TypesPackageImpl;

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
	private EClass andExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrowSelectionExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationCallExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanLiteralExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionItemASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionLiteralExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionLiteralPartASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionRangeASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dotSelectionExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumLiteralExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass impliesExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerLiteralExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iterateExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iteratorExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass letExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logicalExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclExpressionASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclMessageArgASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclMessageExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationCallExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathNameExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primaryExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveLiteralExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realLiteralExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectionExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringLiteralExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tupleLiteralExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xorExpASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum collectionKindASEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum oclMessageKindASEEnum = null;

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
	 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#eNS_URI
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
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
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
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ExpressionsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		AstPackageImpl theAstPackage = (AstPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI) instanceof AstPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI) : AstPackage.eINSTANCE);
		ContextsPackageImpl theContextsPackage = (ContextsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ContextsPackage.eNS_URI) instanceof ContextsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ContextsPackage.eNS_URI) : ContextsPackage.eINSTANCE);
		PackageImpl thePackage = (PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(org.oslo.ocl20.syntax.ast.qvt.Package.eNS_URI) instanceof PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(org.oslo.ocl20.syntax.ast.qvt.Package.eNS_URI) : org.oslo.ocl20.syntax.ast.qvt.Package.eINSTANCE);
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);

		// Create package meta-data objects
		theExpressionsPackage.createPackageContents();
		theAstPackage.createPackageContents();
		theContextsPackage.createPackageContents();
		thePackage.createPackageContents();
		theTypesPackage.createPackageContents();

		// Initialize created meta-data
		theExpressionsPackage.initializePackageContents();
		theAstPackage.initializePackageContents();
		theContextsPackage.initializePackageContents();
		thePackage.initializePackageContents();
		theTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExpressionsPackage.freeze();

		return theExpressionsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAndExpAS() {
		return andExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArrowSelectionExpAS() {
		return arrowSelectionExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociationCallExpAS() {
		return associationCallExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanLiteralExpAS() {
		return booleanLiteralExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanLiteralExpAS_Value() {
		return (EAttribute)booleanLiteralExpASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallExpAS() {
		return callExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallExpAS_Source() {
		return (EReference)callExpASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallExpAS_Arguments() {
		return (EReference)callExpASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionItemAS() {
		return collectionItemASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionItemAS_Item() {
		return (EReference)collectionItemASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionLiteralExpAS() {
		return collectionLiteralExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionLiteralExpAS_Kind() {
		return (EAttribute)collectionLiteralExpASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionLiteralExpAS_CollectionParts() {
		return (EReference)collectionLiteralExpASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionLiteralPartAS() {
		return collectionLiteralPartASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionRangeAS() {
		return collectionRangeASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionRangeAS_First() {
		return (EReference)collectionRangeASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionRangeAS_Last() {
		return (EReference)collectionRangeASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDotSelectionExpAS() {
		return dotSelectionExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumLiteralExpAS() {
		return enumLiteralExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumLiteralExpAS_PathName() {
		return (EAttribute)enumLiteralExpASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfExpAS() {
		return ifExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfExpAS_ThenExpression() {
		return (EReference)ifExpASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfExpAS_Condition() {
		return (EReference)ifExpASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfExpAS_ElseExpression() {
		return (EReference)ifExpASEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImpliesExpAS() {
		return impliesExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerLiteralExpAS() {
		return integerLiteralExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerLiteralExpAS_Value() {
		return (EAttribute)integerLiteralExpASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIterateExpAS() {
		return iterateExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIteratorExpAS() {
		return iteratorExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLetExpAS() {
		return letExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLetExpAS_Variables() {
		return (EReference)letExpASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLetExpAS_In() {
		return (EReference)letExpASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLiteralExpAS() {
		return literalExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogicalExpAS() {
		return logicalExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLogicalExpAS_RightOperand() {
		return (EReference)logicalExpASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLogicalExpAS_LeftOperand() {
		return (EReference)logicalExpASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopExpAS() {
		return loopExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoopExpAS_Name() {
		return (EAttribute)loopExpASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopExpAS_Result() {
		return (EReference)loopExpASEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopExpAS_Body() {
		return (EReference)loopExpASEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopExpAS_Source() {
		return (EReference)loopExpASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopExpAS_Iterator() {
		return (EReference)loopExpASEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNotExpAS() {
		return notExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOclExpressionAS() {
		return oclExpressionASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOclExpressionAS_IsMarkedPre() {
		return (EAttribute)oclExpressionASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclExpressionAS_Parent() {
		return (EReference)oclExpressionASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclExpressionAS_IfExpAS() {
		return (EReference)oclExpressionASEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOclMessageArgAS() {
		return oclMessageArgASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclMessageArgAS_Type() {
		return (EReference)oclMessageArgASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclMessageArgAS_Expression() {
		return (EReference)oclMessageArgASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOclMessageExpAS() {
		return oclMessageExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOclMessageExpAS_Name() {
		return (EAttribute)oclMessageExpASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOclMessageExpAS_Kind() {
		return (EAttribute)oclMessageExpASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclMessageExpAS_Arguments() {
		return (EReference)oclMessageExpASEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclMessageExpAS_Target() {
		return (EReference)oclMessageExpASEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationCallExpAS() {
		return operationCallExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrExpAS() {
		return orExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPathNameExpAS() {
		return pathNameExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPathNameExpAS_PathName() {
		return (EAttribute)pathNameExpASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimaryExpAS() {
		return primaryExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveLiteralExpAS() {
		return primitiveLiteralExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRealLiteralExpAS() {
		return realLiteralExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRealLiteralExpAS_Value() {
		return (EAttribute)realLiteralExpASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelectionExpAS() {
		return selectionExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSelectionExpAS_Name() {
		return (EAttribute)selectionExpASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectionExpAS_Source() {
		return (EReference)selectionExpASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringLiteralExpAS() {
		return stringLiteralExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringLiteralExpAS_Value() {
		return (EAttribute)stringLiteralExpASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTupleLiteralExpAS() {
		return tupleLiteralExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTupleLiteralExpAS_TupleParts() {
		return (EReference)tupleLiteralExpASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXorExpAS() {
		return xorExpASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCollectionKindAS() {
		return collectionKindASEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOclMessageKindAS() {
		return oclMessageKindASEEnum;
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
		andExpASEClass = createEClass(AND_EXP_AS);

		arrowSelectionExpASEClass = createEClass(ARROW_SELECTION_EXP_AS);

		associationCallExpASEClass = createEClass(ASSOCIATION_CALL_EXP_AS);

		booleanLiteralExpASEClass = createEClass(BOOLEAN_LITERAL_EXP_AS);
		createEAttribute(booleanLiteralExpASEClass, BOOLEAN_LITERAL_EXP_AS__VALUE);

		callExpASEClass = createEClass(CALL_EXP_AS);
		createEReference(callExpASEClass, CALL_EXP_AS__ARGUMENTS);
		createEReference(callExpASEClass, CALL_EXP_AS__SOURCE);

		collectionItemASEClass = createEClass(COLLECTION_ITEM_AS);
		createEReference(collectionItemASEClass, COLLECTION_ITEM_AS__ITEM);

		collectionLiteralExpASEClass = createEClass(COLLECTION_LITERAL_EXP_AS);
		createEAttribute(collectionLiteralExpASEClass, COLLECTION_LITERAL_EXP_AS__KIND);
		createEReference(collectionLiteralExpASEClass, COLLECTION_LITERAL_EXP_AS__COLLECTION_PARTS);

		collectionLiteralPartASEClass = createEClass(COLLECTION_LITERAL_PART_AS);

		collectionRangeASEClass = createEClass(COLLECTION_RANGE_AS);
		createEReference(collectionRangeASEClass, COLLECTION_RANGE_AS__LAST);
		createEReference(collectionRangeASEClass, COLLECTION_RANGE_AS__FIRST);

		dotSelectionExpASEClass = createEClass(DOT_SELECTION_EXP_AS);

		enumLiteralExpASEClass = createEClass(ENUM_LITERAL_EXP_AS);
		createEAttribute(enumLiteralExpASEClass, ENUM_LITERAL_EXP_AS__PATH_NAME);

		ifExpASEClass = createEClass(IF_EXP_AS);
		createEReference(ifExpASEClass, IF_EXP_AS__CONDITION);
		createEReference(ifExpASEClass, IF_EXP_AS__THEN_EXPRESSION);
		createEReference(ifExpASEClass, IF_EXP_AS__ELSE_EXPRESSION);

		impliesExpASEClass = createEClass(IMPLIES_EXP_AS);

		integerLiteralExpASEClass = createEClass(INTEGER_LITERAL_EXP_AS);
		createEAttribute(integerLiteralExpASEClass, INTEGER_LITERAL_EXP_AS__VALUE);

		iterateExpASEClass = createEClass(ITERATE_EXP_AS);

		iteratorExpASEClass = createEClass(ITERATOR_EXP_AS);

		letExpASEClass = createEClass(LET_EXP_AS);
		createEReference(letExpASEClass, LET_EXP_AS__VARIABLES);
		createEReference(letExpASEClass, LET_EXP_AS__IN);

		literalExpASEClass = createEClass(LITERAL_EXP_AS);

		logicalExpASEClass = createEClass(LOGICAL_EXP_AS);
		createEReference(logicalExpASEClass, LOGICAL_EXP_AS__RIGHT_OPERAND);
		createEReference(logicalExpASEClass, LOGICAL_EXP_AS__LEFT_OPERAND);

		loopExpASEClass = createEClass(LOOP_EXP_AS);
		createEAttribute(loopExpASEClass, LOOP_EXP_AS__NAME);
		createEReference(loopExpASEClass, LOOP_EXP_AS__SOURCE);
		createEReference(loopExpASEClass, LOOP_EXP_AS__BODY);
		createEReference(loopExpASEClass, LOOP_EXP_AS__ITERATOR);
		createEReference(loopExpASEClass, LOOP_EXP_AS__RESULT);

		notExpASEClass = createEClass(NOT_EXP_AS);

		oclExpressionASEClass = createEClass(OCL_EXPRESSION_AS);
		createEAttribute(oclExpressionASEClass, OCL_EXPRESSION_AS__IS_MARKED_PRE);
		createEReference(oclExpressionASEClass, OCL_EXPRESSION_AS__PARENT);
		createEReference(oclExpressionASEClass, OCL_EXPRESSION_AS__IF_EXP_AS);

		oclMessageArgASEClass = createEClass(OCL_MESSAGE_ARG_AS);
		createEReference(oclMessageArgASEClass, OCL_MESSAGE_ARG_AS__EXPRESSION);
		createEReference(oclMessageArgASEClass, OCL_MESSAGE_ARG_AS__TYPE);

		oclMessageExpASEClass = createEClass(OCL_MESSAGE_EXP_AS);
		createEAttribute(oclMessageExpASEClass, OCL_MESSAGE_EXP_AS__NAME);
		createEAttribute(oclMessageExpASEClass, OCL_MESSAGE_EXP_AS__KIND);
		createEReference(oclMessageExpASEClass, OCL_MESSAGE_EXP_AS__ARGUMENTS);
		createEReference(oclMessageExpASEClass, OCL_MESSAGE_EXP_AS__TARGET);

		operationCallExpASEClass = createEClass(OPERATION_CALL_EXP_AS);

		orExpASEClass = createEClass(OR_EXP_AS);

		pathNameExpASEClass = createEClass(PATH_NAME_EXP_AS);
		createEAttribute(pathNameExpASEClass, PATH_NAME_EXP_AS__PATH_NAME);

		primaryExpASEClass = createEClass(PRIMARY_EXP_AS);

		primitiveLiteralExpASEClass = createEClass(PRIMITIVE_LITERAL_EXP_AS);

		realLiteralExpASEClass = createEClass(REAL_LITERAL_EXP_AS);
		createEAttribute(realLiteralExpASEClass, REAL_LITERAL_EXP_AS__VALUE);

		selectionExpASEClass = createEClass(SELECTION_EXP_AS);
		createEAttribute(selectionExpASEClass, SELECTION_EXP_AS__NAME);
		createEReference(selectionExpASEClass, SELECTION_EXP_AS__SOURCE);

		stringLiteralExpASEClass = createEClass(STRING_LITERAL_EXP_AS);
		createEAttribute(stringLiteralExpASEClass, STRING_LITERAL_EXP_AS__VALUE);

		tupleLiteralExpASEClass = createEClass(TUPLE_LITERAL_EXP_AS);
		createEReference(tupleLiteralExpASEClass, TUPLE_LITERAL_EXP_AS__TUPLE_PARTS);

		xorExpASEClass = createEClass(XOR_EXP_AS);

		// Create enums
		collectionKindASEEnum = createEEnum(COLLECTION_KIND_AS);
		oclMessageKindASEEnum = createEEnum(OCL_MESSAGE_KIND_AS);
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
		AstPackage theAstPackage = (AstPackage)EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI);
		ContextsPackage theContextsPackage = (ContextsPackage)EPackage.Registry.INSTANCE.getEPackage(ContextsPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Add supertypes to classes
		andExpASEClass.getESuperTypes().add(this.getLogicalExpAS());
		arrowSelectionExpASEClass.getESuperTypes().add(this.getSelectionExpAS());
		associationCallExpASEClass.getESuperTypes().add(this.getCallExpAS());
		booleanLiteralExpASEClass.getESuperTypes().add(this.getPrimitiveLiteralExpAS());
		callExpASEClass.getESuperTypes().add(this.getOclExpressionAS());
		collectionItemASEClass.getESuperTypes().add(this.getCollectionLiteralPartAS());
		collectionLiteralExpASEClass.getESuperTypes().add(this.getLiteralExpAS());
		collectionLiteralPartASEClass.getESuperTypes().add(theAstPackage.getVisitable());
		collectionRangeASEClass.getESuperTypes().add(this.getCollectionLiteralPartAS());
		dotSelectionExpASEClass.getESuperTypes().add(this.getSelectionExpAS());
		enumLiteralExpASEClass.getESuperTypes().add(this.getLiteralExpAS());
		ifExpASEClass.getESuperTypes().add(this.getOclExpressionAS());
		impliesExpASEClass.getESuperTypes().add(this.getLogicalExpAS());
		integerLiteralExpASEClass.getESuperTypes().add(this.getPrimitiveLiteralExpAS());
		iterateExpASEClass.getESuperTypes().add(this.getLoopExpAS());
		iteratorExpASEClass.getESuperTypes().add(this.getLoopExpAS());
		letExpASEClass.getESuperTypes().add(this.getOclExpressionAS());
		literalExpASEClass.getESuperTypes().add(this.getPrimaryExpAS());
		logicalExpASEClass.getESuperTypes().add(this.getOclExpressionAS());
		loopExpASEClass.getESuperTypes().add(this.getOclExpressionAS());
		notExpASEClass.getESuperTypes().add(this.getLogicalExpAS());
		oclExpressionASEClass.getESuperTypes().add(theAstPackage.getVisitable());
		oclMessageArgASEClass.getESuperTypes().add(theAstPackage.getVisitable());
		oclMessageExpASEClass.getESuperTypes().add(this.getOclExpressionAS());
		operationCallExpASEClass.getESuperTypes().add(this.getCallExpAS());
		orExpASEClass.getESuperTypes().add(this.getLogicalExpAS());
		pathNameExpASEClass.getESuperTypes().add(this.getPrimaryExpAS());
		primaryExpASEClass.getESuperTypes().add(this.getOclExpressionAS());
		primitiveLiteralExpASEClass.getESuperTypes().add(this.getLiteralExpAS());
		realLiteralExpASEClass.getESuperTypes().add(this.getPrimitiveLiteralExpAS());
		selectionExpASEClass.getESuperTypes().add(this.getOclExpressionAS());
		stringLiteralExpASEClass.getESuperTypes().add(this.getPrimitiveLiteralExpAS());
		tupleLiteralExpASEClass.getESuperTypes().add(this.getLiteralExpAS());
		xorExpASEClass.getESuperTypes().add(this.getLogicalExpAS());

		// Initialize classes and features; add operations and parameters
		initEClass(andExpASEClass, AndExpAS.class, "AndExpAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(andExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(arrowSelectionExpASEClass, ArrowSelectionExpAS.class, "ArrowSelectionExpAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(arrowSelectionExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(associationCallExpASEClass, AssociationCallExpAS.class, "AssociationCallExpAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(associationCallExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(booleanLiteralExpASEClass, BooleanLiteralExpAS.class, "BooleanLiteralExpAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanLiteralExpAS_Value(), theAstPackage.getBoolean(), "value", null, 1, 1, BooleanLiteralExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(booleanLiteralExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(callExpASEClass, CallExpAS.class, "CallExpAS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallExpAS_Arguments(), this.getOclExpressionAS(), null, "arguments", null, 0, -1, CallExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCallExpAS_Source(), this.getOclExpressionAS(), null, "source", null, 1, 1, CallExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(callExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(collectionItemASEClass, CollectionItemAS.class, "CollectionItemAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionItemAS_Item(), this.getOclExpressionAS(), null, "item", null, 0, 1, CollectionItemAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(collectionItemASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(collectionLiteralExpASEClass, CollectionLiteralExpAS.class, "CollectionLiteralExpAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCollectionLiteralExpAS_Kind(), this.getCollectionKindAS(), "kind", null, 1, 1, CollectionLiteralExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionLiteralExpAS_CollectionParts(), this.getCollectionLiteralPartAS(), null, "collectionParts", null, 0, -1, CollectionLiteralExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(collectionLiteralExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(collectionLiteralPartASEClass, CollectionLiteralPartAS.class, "CollectionLiteralPartAS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(collectionLiteralPartASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(collectionRangeASEClass, CollectionRangeAS.class, "CollectionRangeAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionRangeAS_Last(), this.getOclExpressionAS(), null, "last", null, 0, 1, CollectionRangeAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionRangeAS_First(), this.getOclExpressionAS(), null, "first", null, 0, 1, CollectionRangeAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(collectionRangeASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(dotSelectionExpASEClass, DotSelectionExpAS.class, "DotSelectionExpAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(dotSelectionExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(enumLiteralExpASEClass, EnumLiteralExpAS.class, "EnumLiteralExpAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumLiteralExpAS_PathName(), ecorePackage.getEString(), "pathName", null, 0, -1, EnumLiteralExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(enumLiteralExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(ifExpASEClass, IfExpAS.class, "IfExpAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIfExpAS_Condition(), this.getOclExpressionAS(), null, "condition", null, 1, 1, IfExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfExpAS_ThenExpression(), this.getOclExpressionAS(), null, "thenExpression", null, 1, 1, IfExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfExpAS_ElseExpression(), this.getOclExpressionAS(), this.getOclExpressionAS_IfExpAS(), "elseExpression", null, 1, 1, IfExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(ifExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(impliesExpASEClass, ImpliesExpAS.class, "ImpliesExpAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(impliesExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(integerLiteralExpASEClass, IntegerLiteralExpAS.class, "IntegerLiteralExpAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerLiteralExpAS_Value(), theAstPackage.getInteger(), "value", null, 1, 1, IntegerLiteralExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(integerLiteralExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(iterateExpASEClass, IterateExpAS.class, "IterateExpAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(iterateExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(iteratorExpASEClass, IteratorExpAS.class, "IteratorExpAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(iteratorExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(letExpASEClass, LetExpAS.class, "LetExpAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLetExpAS_Variables(), theContextsPackage.getVariableDeclarationAS(), null, "variables", null, 1, -1, LetExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLetExpAS_In(), this.getOclExpressionAS(), null, "in", null, 1, 1, LetExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(letExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(literalExpASEClass, LiteralExpAS.class, "LiteralExpAS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(literalExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(logicalExpASEClass, LogicalExpAS.class, "LogicalExpAS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLogicalExpAS_RightOperand(), this.getOclExpressionAS(), null, "rightOperand", null, 1, 1, LogicalExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLogicalExpAS_LeftOperand(), this.getOclExpressionAS(), null, "leftOperand", null, 1, 1, LogicalExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(logicalExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(loopExpASEClass, LoopExpAS.class, "LoopExpAS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLoopExpAS_Name(), ecorePackage.getEString(), "name", null, 1, 1, LoopExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoopExpAS_Source(), this.getOclExpressionAS(), null, "source", null, 1, 1, LoopExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoopExpAS_Body(), this.getOclExpressionAS(), null, "body", null, 1, 1, LoopExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoopExpAS_Iterator(), theContextsPackage.getVariableDeclarationAS(), null, "iterator", null, 0, -1, LoopExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoopExpAS_Result(), theContextsPackage.getVariableDeclarationAS(), null, "result", null, 1, 1, LoopExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(loopExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(notExpASEClass, NotExpAS.class, "NotExpAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(notExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(oclExpressionASEClass, OclExpressionAS.class, "OclExpressionAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOclExpressionAS_IsMarkedPre(), theAstPackage.getBoolean(), "isMarkedPre", null, 1, 1, OclExpressionAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOclExpressionAS_Parent(), this.getOclExpressionAS(), null, "parent", null, 1, 1, OclExpressionAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOclExpressionAS_IfExpAS(), this.getIfExpAS(), this.getIfExpAS_ElseExpression(), "ifExpAS", null, 1, 1, OclExpressionAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(oclExpressionASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(oclMessageArgASEClass, OclMessageArgAS.class, "OclMessageArgAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOclMessageArgAS_Expression(), this.getOclExpressionAS(), null, "expression", null, 0, 1, OclMessageArgAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOclMessageArgAS_Type(), theTypesPackage.getTypeAS(), null, "type", null, 0, 1, OclMessageArgAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(oclMessageArgASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(oclMessageExpASEClass, OclMessageExpAS.class, "OclMessageExpAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOclMessageExpAS_Name(), ecorePackage.getEString(), "name", null, 1, 1, OclMessageExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOclMessageExpAS_Kind(), this.getOclMessageKindAS(), "kind", null, 1, 1, OclMessageExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOclMessageExpAS_Arguments(), this.getOclMessageArgAS(), null, "arguments", null, 0, -1, OclMessageExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOclMessageExpAS_Target(), this.getOclExpressionAS(), null, "target", null, 1, 1, OclMessageExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(oclMessageExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(operationCallExpASEClass, OperationCallExpAS.class, "OperationCallExpAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(operationCallExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(orExpASEClass, OrExpAS.class, "OrExpAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(orExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(pathNameExpASEClass, PathNameExpAS.class, "PathNameExpAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPathNameExpAS_PathName(), ecorePackage.getEString(), "pathName", null, 0, -1, PathNameExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(pathNameExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(primaryExpASEClass, PrimaryExpAS.class, "PrimaryExpAS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(primaryExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(primitiveLiteralExpASEClass, PrimitiveLiteralExpAS.class, "PrimitiveLiteralExpAS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(primitiveLiteralExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(realLiteralExpASEClass, RealLiteralExpAS.class, "RealLiteralExpAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRealLiteralExpAS_Value(), theAstPackage.getDouble(), "value", null, 1, 1, RealLiteralExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(realLiteralExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(selectionExpASEClass, SelectionExpAS.class, "SelectionExpAS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSelectionExpAS_Name(), ecorePackage.getEString(), "name", null, 1, 1, SelectionExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSelectionExpAS_Source(), this.getOclExpressionAS(), null, "source", null, 1, 1, SelectionExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(selectionExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(stringLiteralExpASEClass, StringLiteralExpAS.class, "StringLiteralExpAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringLiteralExpAS_Value(), ecorePackage.getEString(), "value", null, 1, 1, StringLiteralExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(stringLiteralExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(tupleLiteralExpASEClass, TupleLiteralExpAS.class, "TupleLiteralExpAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTupleLiteralExpAS_TupleParts(), theContextsPackage.getVariableDeclarationAS(), null, "tupleParts", null, 0, -1, TupleLiteralExpAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(tupleLiteralExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(xorExpASEClass, XorExpAS.class, "XorExpAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(xorExpASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		// Initialize enums and add enum literals
		initEEnum(collectionKindASEEnum, CollectionKindAS.class, "CollectionKindAS");
		addEEnumLiteral(collectionKindASEEnum, CollectionKindAS.SET_LITERAL);
		addEEnumLiteral(collectionKindASEEnum, CollectionKindAS.BAG_LITERAL);
		addEEnumLiteral(collectionKindASEEnum, CollectionKindAS.SEQUENCE_LITERAL);
		addEEnumLiteral(collectionKindASEEnum, CollectionKindAS.COLLECTION_LITERAL);
		addEEnumLiteral(collectionKindASEEnum, CollectionKindAS.ORDERED_SET_LITERAL);

		initEEnum(oclMessageKindASEEnum, OclMessageKindAS.class, "OclMessageKindAS");
		addEEnumLiteral(oclMessageKindASEEnum, OclMessageKindAS.UP_LITERAL);
		addEEnumLiteral(oclMessageKindASEEnum, OclMessageKindAS.UP_UP_LITERAL);
	}

} //ExpressionsPackageImpl
