/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.impl;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.oslo.ocl20.syntax.ast.AstFactory;
import org.oslo.ocl20.syntax.ast.AstPackage;
import org.oslo.ocl20.syntax.ast.Visitable;
import org.oslo.ocl20.syntax.ast.Visitor;

import org.oslo.ocl20.syntax.ast.contexts.ContextsPackage;

import org.oslo.ocl20.syntax.ast.contexts.impl.ContextsPackageImpl;

import org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage;

import org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl;

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
public class AstPackageImpl extends EPackageImpl implements AstPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visitableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visitorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType booleanEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType doubleEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType integerEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType listEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType objectEDataType = null;

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
	 * @see org.oslo.ocl20.syntax.ast.AstPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AstPackageImpl() {
		super(eNS_URI, AstFactory.eINSTANCE);
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
	public static AstPackage init() {
		if (isInited) return (AstPackage)EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI);

		// Obtain or create and register package
		AstPackageImpl theAstPackage = (AstPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof AstPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new AstPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		ContextsPackageImpl theContextsPackage = (ContextsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ContextsPackage.eNS_URI) instanceof ContextsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ContextsPackage.eNS_URI) : ContextsPackage.eINSTANCE);
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) : ExpressionsPackage.eINSTANCE);
		PackageImpl thePackage = (PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(org.oslo.ocl20.syntax.ast.qvt.Package.eNS_URI) instanceof PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(org.oslo.ocl20.syntax.ast.qvt.Package.eNS_URI) : org.oslo.ocl20.syntax.ast.qvt.Package.eINSTANCE);
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);

		// Create package meta-data objects
		theAstPackage.createPackageContents();
		theContextsPackage.createPackageContents();
		theExpressionsPackage.createPackageContents();
		thePackage.createPackageContents();
		theTypesPackage.createPackageContents();

		// Initialize created meta-data
		theAstPackage.initializePackageContents();
		theContextsPackage.initializePackageContents();
		theExpressionsPackage.initializePackageContents();
		thePackage.initializePackageContents();
		theTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAstPackage.freeze();

		return theAstPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisitable() {
		return visitableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisitor() {
		return visitorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getBoolean() {
		return booleanEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDouble() {
		return doubleEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getInteger() {
		return integerEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getList() {
		return listEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getObject() {
		return objectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AstFactory getAstFactory() {
		return (AstFactory)getEFactoryInstance();
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
		visitableEClass = createEClass(VISITABLE);

		visitorEClass = createEClass(VISITOR);

		// Create data types
		booleanEDataType = createEDataType(BOOLEAN);
		doubleEDataType = createEDataType(DOUBLE);
		integerEDataType = createEDataType(INTEGER);
		listEDataType = createEDataType(LIST);
		objectEDataType = createEDataType(OBJECT);
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
		ContextsPackage theContextsPackage = (ContextsPackage)EPackage.Registry.INSTANCE.getEPackage(ContextsPackage.eNS_URI);
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);
		org.oslo.ocl20.syntax.ast.qvt.Package thePackage = (org.oslo.ocl20.syntax.ast.qvt.Package)EPackage.Registry.INSTANCE.getEPackage(org.oslo.ocl20.syntax.ast.qvt.Package.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theContextsPackage);
		getESubpackages().add(theExpressionsPackage);
		getESubpackages().add(thePackage);
		getESubpackages().add(theTypesPackage);

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(visitableEClass, Visitable.class, "Visitable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(visitableEClass, this.getObject(), "accept", 0, 1);
		addEParameter(op, this.getVisitor(), "visitor", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1);

		initEClass(visitorEClass, Visitor.class, "Visitor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(visitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, this.getVisitable(), "visitable", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1);

		// Initialize data types
		initEDataType(booleanEDataType, Boolean.class, "Boolean", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(doubleEDataType, Double.class, "Double", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(integerEDataType, Integer.class, "Integer", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(listEDataType, List.class, "List", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(objectEDataType, Object.class, "Object", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// instance
		createInstanceAnnotations();
		// body
		createBodyAnnotations();
	}

	/**
	 * Initializes the annotations for <b>instance</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createInstanceAnnotations() {
		String source = "instance";		
		addAnnotation
		  (booleanEDataType, 
		   source, 
		   new String[] {
			 "instance", "java.lang.Boolean"
		   });		
		addAnnotation
		  (doubleEDataType, 
		   source, 
		   new String[] {
			 "instance", "java.lang.Double"
		   });		
		addAnnotation
		  (integerEDataType, 
		   source, 
		   new String[] {
			 "instance", "java.lang.Integer"
		   });		
		addAnnotation
		  (listEDataType, 
		   source, 
		   new String[] {
			 "instance", "java.util.List"
		   });	
	}

	/**
	 * Initializes the annotations for <b>body</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createBodyAnnotations() {
		String source = "body";						
		addAnnotation
		  ((EOperation)visitableEClass.getEOperations().get(0), 
		   source, 
		   new String[] {
			 "body", "return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);"
		   });
	}

} //AstPackageImpl
