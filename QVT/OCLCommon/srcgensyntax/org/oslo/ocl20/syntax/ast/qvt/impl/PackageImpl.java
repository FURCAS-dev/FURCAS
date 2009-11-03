/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.qvt.impl;

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

import org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage;

import org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl;

import org.oslo.ocl20.syntax.ast.impl.AstPackageImpl;

import org.oslo.ocl20.syntax.ast.qvt.CollectionTemplateAS;
import org.oslo.ocl20.syntax.ast.qvt.DomainAS;
import org.oslo.ocl20.syntax.ast.qvt.ExecutionKindAS;
import org.oslo.ocl20.syntax.ast.qvt.Factory;
import org.oslo.ocl20.syntax.ast.qvt.GeneralDomainAS;
import org.oslo.ocl20.syntax.ast.qvt.KeyDeclarationAS;
import org.oslo.ocl20.syntax.ast.qvt.MemberSelectionExpressionAS;
import org.oslo.ocl20.syntax.ast.qvt.ModelDeclarationAS;
import org.oslo.ocl20.syntax.ast.qvt.ObjectTemplateAS;
import org.oslo.ocl20.syntax.ast.qvt.ParameterDeclarationAS;
import org.oslo.ocl20.syntax.ast.qvt.PrimitiveDomainAS;
import org.oslo.ocl20.syntax.ast.qvt.PropertyTemplateAS;
import org.oslo.ocl20.syntax.ast.qvt.QueryAS;
import org.oslo.ocl20.syntax.ast.qvt.RelationAS;
import org.oslo.ocl20.syntax.ast.qvt.SetComprehensionExpressionAS;
import org.oslo.ocl20.syntax.ast.qvt.TemplateAS;
import org.oslo.ocl20.syntax.ast.qvt.TopLevelAS;
import org.oslo.ocl20.syntax.ast.qvt.TransformationAS;
import org.oslo.ocl20.syntax.ast.qvt.VariableDeclarationAS;

import org.oslo.ocl20.syntax.ast.types.TypesPackage;

import org.oslo.ocl20.syntax.ast.types.impl.TypesPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PackageImpl extends EPackageImpl implements org.oslo.ocl20.syntax.ast.qvt.Package {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionTemplateASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generalDomainASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass keyDeclarationASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memberSelectionExpressionASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelDeclarationASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectTemplateASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterDeclarationASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveDomainASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyTemplateASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass queryASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setComprehensionExpressionASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topLevelASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformationASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableDeclarationASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum executionKindASEEnum = null;

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
	 * @see org.oslo.ocl20.syntax.ast.qvt.Package#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PackageImpl() {
		super(eNS_URI, Factory.eINSTANCE);
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
	public static org.oslo.ocl20.syntax.ast.qvt.Package init() {
		if (isInited) return (org.oslo.ocl20.syntax.ast.qvt.Package)EPackage.Registry.INSTANCE.getEPackage(org.oslo.ocl20.syntax.ast.qvt.Package.eNS_URI);

		// Obtain or create and register package
		PackageImpl thePackage = (PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new PackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		AstPackageImpl theAstPackage = (AstPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI) instanceof AstPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI) : AstPackage.eINSTANCE);
		ContextsPackageImpl theContextsPackage = (ContextsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ContextsPackage.eNS_URI) instanceof ContextsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ContextsPackage.eNS_URI) : ContextsPackage.eINSTANCE);
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) : ExpressionsPackage.eINSTANCE);
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);

		// Create package meta-data objects
		thePackage.createPackageContents();
		theAstPackage.createPackageContents();
		theContextsPackage.createPackageContents();
		theExpressionsPackage.createPackageContents();
		theTypesPackage.createPackageContents();

		// Initialize created meta-data
		thePackage.initializePackageContents();
		theAstPackage.initializePackageContents();
		theContextsPackage.initializePackageContents();
		theExpressionsPackage.initializePackageContents();
		theTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePackage.freeze();

		return thePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionTemplateAS() {
		return collectionTemplateASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionTemplateAS_CollectionKind() {
		return (EAttribute)collectionTemplateASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionTemplateAS_MemberSelectionExpressions() {
		return (EReference)collectionTemplateASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionTemplateAS_OclExpressions() {
		return (EReference)collectionTemplateASEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionTemplateAS_SetComprehensionExpression() {
		return (EReference)collectionTemplateASEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomainAS() {
		return domainASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDomainAS_ExecutionKind() {
		return (EAttribute)domainASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDomainAS_ModelId() {
		return (EAttribute)domainASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDomainAS_Name() {
		return (EAttribute)domainASEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainAS_ImplementedBy() {
		return (EReference)domainASEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainAS_PropertyTemplates() {
		return (EReference)domainASEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainAS_Type() {
		return (EReference)domainASEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainAS_Body() {
		return (EReference)domainASEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeneralDomainAS() {
		return generalDomainASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKeyDeclarationAS() {
		return keyDeclarationASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKeyDeclarationAS_ClassId() {
		return (EAttribute)keyDeclarationASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getKeyDeclarationAS_PropertyIds() {
		return (EAttribute)keyDeclarationASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemberSelectionExpressionAS() {
		return memberSelectionExpressionASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemberSelectionExpressionAS_FirstName() {
		return (EAttribute)memberSelectionExpressionASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMemberSelectionExpressionAS_SecondName() {
		return (EAttribute)memberSelectionExpressionASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMemberSelectionExpressionAS_ObjectTemplate() {
		return (EReference)memberSelectionExpressionASEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelDeclarationAS() {
		return modelDeclarationASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelDeclarationAS_ModelId() {
		return (EAttribute)modelDeclarationASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelDeclarationAS_MetaModelIds() {
		return (EAttribute)modelDeclarationASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectTemplateAS() {
		return objectTemplateASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectTemplateAS_PropertyTemplates() {
		return (EReference)objectTemplateASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterDeclarationAS() {
		return parameterDeclarationASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterDeclarationAS_Name() {
		return (EAttribute)parameterDeclarationASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterDeclarationAS_Type() {
		return (EReference)parameterDeclarationASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveDomainAS() {
		return primitiveDomainASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveDomainAS_Name() {
		return (EAttribute)primitiveDomainASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrimitiveDomainAS_Type() {
		return (EReference)primitiveDomainASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyTemplateAS() {
		return propertyTemplateASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyTemplateAS_Name() {
		return (EAttribute)propertyTemplateASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyTemplateAS_Body() {
		return (EReference)propertyTemplateASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQueryAS() {
		return queryASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQueryAS_PathName() {
		return (EAttribute)queryASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQueryAS_Parameters() {
		return (EReference)queryASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQueryAS_Type() {
		return (EReference)queryASEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQueryAS_Body() {
		return (EReference)queryASEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationAS() {
		return relationASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationAS_IsTopLevel() {
		return (EAttribute)relationASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationAS_Name() {
		return (EAttribute)relationASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationAS_Overrides() {
		return (EAttribute)relationASEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationAS_Where() {
		return (EReference)relationASEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationAS_VariableDeclarations() {
		return (EReference)relationASEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationAS_Domains() {
		return (EReference)relationASEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationAS_When() {
		return (EReference)relationASEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetComprehensionExpressionAS() {
		return setComprehensionExpressionASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSetComprehensionExpressionAS_Name() {
		return (EAttribute)setComprehensionExpressionASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetComprehensionExpressionAS_ObjectTemplate() {
		return (EReference)setComprehensionExpressionASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetComprehensionExpressionAS_OclExpression() {
		return (EReference)setComprehensionExpressionASEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateAS() {
		return templateASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplateAS_Name() {
		return (EAttribute)templateASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateAS_Type() {
		return (EReference)templateASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopLevelAS() {
		return topLevelASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTopLevelAS_Imports() {
		return (EAttribute)topLevelASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopLevelAS_Transformations() {
		return (EReference)topLevelASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransformationAS() {
		return transformationASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformationAS_Name() {
		return (EAttribute)transformationASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformationAS_Extends() {
		return (EAttribute)transformationASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationAS_KeyDeclarations() {
		return (EReference)transformationASEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationAS_Relations() {
		return (EReference)transformationASEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationAS_ModelDeclarations() {
		return (EReference)transformationASEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationAS_Query() {
		return (EReference)transformationASEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableDeclarationAS() {
		return variableDeclarationASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableDeclarationAS_Names() {
		return (EAttribute)variableDeclarationASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableDeclarationAS_Type() {
		return (EReference)variableDeclarationASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getExecutionKindAS() {
		return executionKindASEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Factory getFactory() {
		return (Factory)getEFactoryInstance();
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
		collectionTemplateASEClass = createEClass(COLLECTION_TEMPLATE_AS);
		createEAttribute(collectionTemplateASEClass, COLLECTION_TEMPLATE_AS__COLLECTION_KIND);
		createEReference(collectionTemplateASEClass, COLLECTION_TEMPLATE_AS__MEMBER_SELECTION_EXPRESSIONS);
		createEReference(collectionTemplateASEClass, COLLECTION_TEMPLATE_AS__OCL_EXPRESSIONS);
		createEReference(collectionTemplateASEClass, COLLECTION_TEMPLATE_AS__SET_COMPREHENSION_EXPRESSION);

		domainASEClass = createEClass(DOMAIN_AS);
		createEAttribute(domainASEClass, DOMAIN_AS__EXECUTION_KIND);
		createEAttribute(domainASEClass, DOMAIN_AS__MODEL_ID);
		createEAttribute(domainASEClass, DOMAIN_AS__NAME);
		createEReference(domainASEClass, DOMAIN_AS__IMPLEMENTED_BY);
		createEReference(domainASEClass, DOMAIN_AS__PROPERTY_TEMPLATES);
		createEReference(domainASEClass, DOMAIN_AS__TYPE);
		createEReference(domainASEClass, DOMAIN_AS__BODY);

		generalDomainASEClass = createEClass(GENERAL_DOMAIN_AS);

		keyDeclarationASEClass = createEClass(KEY_DECLARATION_AS);
		createEAttribute(keyDeclarationASEClass, KEY_DECLARATION_AS__CLASS_ID);
		createEAttribute(keyDeclarationASEClass, KEY_DECLARATION_AS__PROPERTY_IDS);

		memberSelectionExpressionASEClass = createEClass(MEMBER_SELECTION_EXPRESSION_AS);
		createEAttribute(memberSelectionExpressionASEClass, MEMBER_SELECTION_EXPRESSION_AS__FIRST_NAME);
		createEAttribute(memberSelectionExpressionASEClass, MEMBER_SELECTION_EXPRESSION_AS__SECOND_NAME);
		createEReference(memberSelectionExpressionASEClass, MEMBER_SELECTION_EXPRESSION_AS__OBJECT_TEMPLATE);

		modelDeclarationASEClass = createEClass(MODEL_DECLARATION_AS);
		createEAttribute(modelDeclarationASEClass, MODEL_DECLARATION_AS__MODEL_ID);
		createEAttribute(modelDeclarationASEClass, MODEL_DECLARATION_AS__META_MODEL_IDS);

		objectTemplateASEClass = createEClass(OBJECT_TEMPLATE_AS);
		createEReference(objectTemplateASEClass, OBJECT_TEMPLATE_AS__PROPERTY_TEMPLATES);

		parameterDeclarationASEClass = createEClass(PARAMETER_DECLARATION_AS);
		createEAttribute(parameterDeclarationASEClass, PARAMETER_DECLARATION_AS__NAME);
		createEReference(parameterDeclarationASEClass, PARAMETER_DECLARATION_AS__TYPE);

		primitiveDomainASEClass = createEClass(PRIMITIVE_DOMAIN_AS);
		createEAttribute(primitiveDomainASEClass, PRIMITIVE_DOMAIN_AS__NAME);
		createEReference(primitiveDomainASEClass, PRIMITIVE_DOMAIN_AS__TYPE);

		propertyTemplateASEClass = createEClass(PROPERTY_TEMPLATE_AS);
		createEAttribute(propertyTemplateASEClass, PROPERTY_TEMPLATE_AS__NAME);
		createEReference(propertyTemplateASEClass, PROPERTY_TEMPLATE_AS__BODY);

		queryASEClass = createEClass(QUERY_AS);
		createEAttribute(queryASEClass, QUERY_AS__PATH_NAME);
		createEReference(queryASEClass, QUERY_AS__PARAMETERS);
		createEReference(queryASEClass, QUERY_AS__TYPE);
		createEReference(queryASEClass, QUERY_AS__BODY);

		relationASEClass = createEClass(RELATION_AS);
		createEAttribute(relationASEClass, RELATION_AS__IS_TOP_LEVEL);
		createEAttribute(relationASEClass, RELATION_AS__NAME);
		createEAttribute(relationASEClass, RELATION_AS__OVERRIDES);
		createEReference(relationASEClass, RELATION_AS__WHERE);
		createEReference(relationASEClass, RELATION_AS__VARIABLE_DECLARATIONS);
		createEReference(relationASEClass, RELATION_AS__DOMAINS);
		createEReference(relationASEClass, RELATION_AS__WHEN);

		setComprehensionExpressionASEClass = createEClass(SET_COMPREHENSION_EXPRESSION_AS);
		createEAttribute(setComprehensionExpressionASEClass, SET_COMPREHENSION_EXPRESSION_AS__NAME);
		createEReference(setComprehensionExpressionASEClass, SET_COMPREHENSION_EXPRESSION_AS__OBJECT_TEMPLATE);
		createEReference(setComprehensionExpressionASEClass, SET_COMPREHENSION_EXPRESSION_AS__OCL_EXPRESSION);

		templateASEClass = createEClass(TEMPLATE_AS);
		createEAttribute(templateASEClass, TEMPLATE_AS__NAME);
		createEReference(templateASEClass, TEMPLATE_AS__TYPE);

		topLevelASEClass = createEClass(TOP_LEVEL_AS);
		createEAttribute(topLevelASEClass, TOP_LEVEL_AS__IMPORTS);
		createEReference(topLevelASEClass, TOP_LEVEL_AS__TRANSFORMATIONS);

		transformationASEClass = createEClass(TRANSFORMATION_AS);
		createEAttribute(transformationASEClass, TRANSFORMATION_AS__NAME);
		createEAttribute(transformationASEClass, TRANSFORMATION_AS__EXTENDS);
		createEReference(transformationASEClass, TRANSFORMATION_AS__KEY_DECLARATIONS);
		createEReference(transformationASEClass, TRANSFORMATION_AS__RELATIONS);
		createEReference(transformationASEClass, TRANSFORMATION_AS__MODEL_DECLARATIONS);
		createEReference(transformationASEClass, TRANSFORMATION_AS__QUERY);

		variableDeclarationASEClass = createEClass(VARIABLE_DECLARATION_AS);
		createEAttribute(variableDeclarationASEClass, VARIABLE_DECLARATION_AS__NAMES);
		createEReference(variableDeclarationASEClass, VARIABLE_DECLARATION_AS__TYPE);

		// Create enums
		executionKindASEEnum = createEEnum(EXECUTION_KIND_AS);
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
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);
		AstPackage theAstPackage = (AstPackage)EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Add supertypes to classes
		collectionTemplateASEClass.getESuperTypes().add(this.getTemplateAS());
		domainASEClass.getESuperTypes().add(this.getGeneralDomainAS());
		generalDomainASEClass.getESuperTypes().add(theAstPackage.getVisitable());
		keyDeclarationASEClass.getESuperTypes().add(theAstPackage.getVisitable());
		memberSelectionExpressionASEClass.getESuperTypes().add(theAstPackage.getVisitable());
		modelDeclarationASEClass.getESuperTypes().add(theAstPackage.getVisitable());
		objectTemplateASEClass.getESuperTypes().add(this.getTemplateAS());
		parameterDeclarationASEClass.getESuperTypes().add(theAstPackage.getVisitable());
		primitiveDomainASEClass.getESuperTypes().add(this.getGeneralDomainAS());
		propertyTemplateASEClass.getESuperTypes().add(theAstPackage.getVisitable());
		queryASEClass.getESuperTypes().add(theAstPackage.getVisitable());
		relationASEClass.getESuperTypes().add(theAstPackage.getVisitable());
		setComprehensionExpressionASEClass.getESuperTypes().add(theAstPackage.getVisitable());
		templateASEClass.getESuperTypes().add(theExpressionsPackage.getOclExpressionAS());
		topLevelASEClass.getESuperTypes().add(theAstPackage.getVisitable());
		transformationASEClass.getESuperTypes().add(theAstPackage.getVisitable());
		variableDeclarationASEClass.getESuperTypes().add(theAstPackage.getVisitable());

		// Initialize classes and features; add operations and parameters
		initEClass(collectionTemplateASEClass, CollectionTemplateAS.class, "CollectionTemplateAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCollectionTemplateAS_CollectionKind(), theExpressionsPackage.getCollectionKindAS(), "collectionKind", null, 1, 1, CollectionTemplateAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionTemplateAS_MemberSelectionExpressions(), this.getMemberSelectionExpressionAS(), null, "memberSelectionExpressions", null, 1, 1, CollectionTemplateAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionTemplateAS_OclExpressions(), theExpressionsPackage.getOclExpressionAS(), null, "oclExpressions", null, 0, -1, CollectionTemplateAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionTemplateAS_SetComprehensionExpression(), this.getSetComprehensionExpressionAS(), null, "setComprehensionExpression", null, 1, 1, CollectionTemplateAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(collectionTemplateASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(domainASEClass, DomainAS.class, "DomainAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDomainAS_ExecutionKind(), this.getExecutionKindAS(), "executionKind", null, 1, 1, DomainAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainAS_ModelId(), ecorePackage.getEString(), "modelId", null, 1, 1, DomainAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainAS_Name(), ecorePackage.getEString(), "name", null, 1, 1, DomainAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainAS_ImplementedBy(), theExpressionsPackage.getDotSelectionExpAS(), null, "implementedBy", null, 1, 1, DomainAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainAS_PropertyTemplates(), this.getPropertyTemplateAS(), null, "propertyTemplates", null, 0, -1, DomainAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainAS_Type(), theTypesPackage.getTypeAS(), null, "type", null, 1, 1, DomainAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainAS_Body(), theExpressionsPackage.getOclExpressionAS(), null, "body", null, 1, 1, DomainAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(domainASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(generalDomainASEClass, GeneralDomainAS.class, "GeneralDomainAS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(generalDomainASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(keyDeclarationASEClass, KeyDeclarationAS.class, "KeyDeclarationAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getKeyDeclarationAS_ClassId(), theAstPackage.getList(), "classId", null, 1, 1, KeyDeclarationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getKeyDeclarationAS_PropertyIds(), theAstPackage.getList(), "propertyIds", null, 1, 1, KeyDeclarationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(keyDeclarationASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(memberSelectionExpressionASEClass, MemberSelectionExpressionAS.class, "MemberSelectionExpressionAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMemberSelectionExpressionAS_FirstName(), ecorePackage.getEString(), "firstName", null, 1, 1, MemberSelectionExpressionAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMemberSelectionExpressionAS_SecondName(), ecorePackage.getEString(), "secondName", null, 1, 1, MemberSelectionExpressionAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMemberSelectionExpressionAS_ObjectTemplate(), this.getObjectTemplateAS(), null, "objectTemplate", null, 1, 1, MemberSelectionExpressionAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(memberSelectionExpressionASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(modelDeclarationASEClass, ModelDeclarationAS.class, "ModelDeclarationAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelDeclarationAS_ModelId(), ecorePackage.getEString(), "modelId", null, 1, 1, ModelDeclarationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelDeclarationAS_MetaModelIds(), theAstPackage.getList(), "metaModelIds", null, 1, 1, ModelDeclarationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(modelDeclarationASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(objectTemplateASEClass, ObjectTemplateAS.class, "ObjectTemplateAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectTemplateAS_PropertyTemplates(), this.getPropertyTemplateAS(), null, "propertyTemplates", null, 0, -1, ObjectTemplateAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(objectTemplateASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(parameterDeclarationASEClass, ParameterDeclarationAS.class, "ParameterDeclarationAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameterDeclarationAS_Name(), ecorePackage.getEString(), "name", null, 1, 1, ParameterDeclarationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameterDeclarationAS_Type(), theTypesPackage.getTypeAS(), null, "type", null, 1, 1, ParameterDeclarationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(parameterDeclarationASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(primitiveDomainASEClass, PrimitiveDomainAS.class, "PrimitiveDomainAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitiveDomainAS_Name(), ecorePackage.getEString(), "name", null, 1, 1, PrimitiveDomainAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimitiveDomainAS_Type(), theTypesPackage.getTypeAS(), null, "type", null, 1, 1, PrimitiveDomainAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(primitiveDomainASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(propertyTemplateASEClass, PropertyTemplateAS.class, "PropertyTemplateAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertyTemplateAS_Name(), ecorePackage.getEString(), "name", null, 1, 1, PropertyTemplateAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyTemplateAS_Body(), theExpressionsPackage.getOclExpressionAS(), null, "body", null, 1, 1, PropertyTemplateAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(propertyTemplateASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(queryASEClass, QueryAS.class, "QueryAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQueryAS_PathName(), theAstPackage.getList(), "pathName", null, 1, 1, QueryAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQueryAS_Parameters(), this.getParameterDeclarationAS(), null, "parameters", null, 0, -1, QueryAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQueryAS_Type(), theTypesPackage.getTypeAS(), null, "type", null, 1, 1, QueryAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQueryAS_Body(), theExpressionsPackage.getOclExpressionAS(), null, "body", null, 1, 1, QueryAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(queryASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(relationASEClass, RelationAS.class, "RelationAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelationAS_IsTopLevel(), theAstPackage.getBoolean(), "isTopLevel", null, 1, 1, RelationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationAS_Name(), ecorePackage.getEString(), "name", null, 1, 1, RelationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationAS_Overrides(), ecorePackage.getEString(), "overrides", null, 1, 1, RelationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationAS_Where(), theExpressionsPackage.getOclExpressionAS(), null, "where", null, 0, -1, RelationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationAS_VariableDeclarations(), this.getVariableDeclarationAS(), null, "variableDeclarations", null, 0, -1, RelationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationAS_Domains(), this.getGeneralDomainAS(), null, "domains", null, 0, -1, RelationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationAS_When(), theExpressionsPackage.getOclExpressionAS(), null, "when", null, 0, -1, RelationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(relationASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(setComprehensionExpressionASEClass, SetComprehensionExpressionAS.class, "SetComprehensionExpressionAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetComprehensionExpressionAS_Name(), ecorePackage.getEString(), "name", null, 1, 1, SetComprehensionExpressionAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetComprehensionExpressionAS_ObjectTemplate(), this.getObjectTemplateAS(), null, "objectTemplate", null, 1, 1, SetComprehensionExpressionAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetComprehensionExpressionAS_OclExpression(), theExpressionsPackage.getOclExpressionAS(), null, "oclExpression", null, 1, 1, SetComprehensionExpressionAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(setComprehensionExpressionASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(templateASEClass, TemplateAS.class, "TemplateAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTemplateAS_Name(), ecorePackage.getEString(), "name", null, 1, 1, TemplateAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTemplateAS_Type(), theTypesPackage.getTypeAS(), null, "type", null, 1, 1, TemplateAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(templateASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(topLevelASEClass, TopLevelAS.class, "TopLevelAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTopLevelAS_Imports(), theAstPackage.getList(), "imports", null, 1, 1, TopLevelAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTopLevelAS_Transformations(), this.getTransformationAS(), null, "transformations", null, 0, -1, TopLevelAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(topLevelASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(transformationASEClass, TransformationAS.class, "TransformationAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTransformationAS_Name(), ecorePackage.getEString(), "name", null, 1, 1, TransformationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransformationAS_Extends(), theAstPackage.getList(), "extends", null, 1, 1, TransformationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationAS_KeyDeclarations(), this.getKeyDeclarationAS(), null, "keyDeclarations", null, 0, -1, TransformationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationAS_Relations(), this.getRelationAS(), null, "relations", null, 0, -1, TransformationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationAS_ModelDeclarations(), this.getModelDeclarationAS(), null, "modelDeclarations", null, 0, -1, TransformationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationAS_Query(), this.getQueryAS(), null, "query", null, 0, -1, TransformationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(transformationASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(variableDeclarationASEClass, VariableDeclarationAS.class, "VariableDeclarationAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariableDeclarationAS_Names(), theAstPackage.getList(), "names", null, 1, 1, VariableDeclarationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableDeclarationAS_Type(), theTypesPackage.getTypeAS(), null, "type", null, 1, 1, VariableDeclarationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(variableDeclarationASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		// Initialize enums and add enum literals
		initEEnum(executionKindASEEnum, ExecutionKindAS.class, "ExecutionKindAS");
		addEEnumLiteral(executionKindASEEnum, ExecutionKindAS.CHECK_ONLY_LITERAL);
		addEEnumLiteral(executionKindASEEnum, ExecutionKindAS.ENFORCE_LITERAL);
	}

} //PackageImpl
