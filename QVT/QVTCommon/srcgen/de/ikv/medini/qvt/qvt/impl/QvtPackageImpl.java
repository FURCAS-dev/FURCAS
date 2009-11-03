/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.qvt.impl;

import de.ikv.medini.qvt.model.qvtbase.QvtBasePackage;

import de.ikv.medini.qvt.model.qvtbase.impl.QvtBasePackageImpl;

import de.ikv.medini.qvt.model.qvtrelation.QvtRelationPackage;

import de.ikv.medini.qvt.model.qvtrelation.impl.QvtRelationPackageImpl;

import de.ikv.medini.qvt.model.qvttemplate.QvtTemplatePackage;

import de.ikv.medini.qvt.model.qvttemplate.impl.QvtTemplatePackageImpl;

import de.ikv.medini.qvt.qvt.QvtFactory;
import de.ikv.medini.qvt.qvt.QvtPackage;
import de.ikv.medini.qvt.qvt.QvtVisitor;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.oslo.ocl20.semantics.SemanticsPackage;

import org.oslo.ocl20.semantics.bridge.BridgePackage;

import org.oslo.ocl20.semantics.impl.SemanticsPackageImpl;

import org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QvtPackageImpl extends EPackageImpl implements QvtPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qvtVisitorEClass = null;

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
	 * @see de.ikv.medini.qvt.qvt.QvtPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QvtPackageImpl() {
		super(eNS_URI, QvtFactory.eINSTANCE);
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
	public static QvtPackage init() {
		if (isInited) return (QvtPackage)EPackage.Registry.INSTANCE.getEPackage(QvtPackage.eNS_URI);

		// Obtain or create and register package
		QvtPackageImpl theQvtPackage = (QvtPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof QvtPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new QvtPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		SemanticsPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		SemanticsPackageImpl theSemanticsPackage_1 = (SemanticsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SemanticsPackage.eNS_URI) instanceof SemanticsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SemanticsPackage.eNS_URI) : SemanticsPackage.eINSTANCE);
		QvtBasePackageImpl theQvtBasePackage = (QvtBasePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QvtBasePackage.eNS_URI) instanceof QvtBasePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QvtBasePackage.eNS_URI) : QvtBasePackage.eINSTANCE);
		QvtRelationPackageImpl theQvtRelationPackage = (QvtRelationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QvtRelationPackage.eNS_URI) instanceof QvtRelationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QvtRelationPackage.eNS_URI) : QvtRelationPackage.eINSTANCE);
		QvtTemplatePackageImpl theQvtTemplatePackage = (QvtTemplatePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QvtTemplatePackage.eNS_URI) instanceof QvtTemplatePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QvtTemplatePackage.eNS_URI) : QvtTemplatePackage.eINSTANCE);

		// Create package meta-data objects
		theQvtPackage.createPackageContents();
		theSemanticsPackage_1.createPackageContents();
		theQvtBasePackage.createPackageContents();
		theQvtRelationPackage.createPackageContents();
		theQvtTemplatePackage.createPackageContents();

		// Initialize created meta-data
		theQvtPackage.initializePackageContents();
		theSemanticsPackage_1.initializePackageContents();
		theQvtBasePackage.initializePackageContents();
		theQvtRelationPackage.initializePackageContents();
		theQvtTemplatePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQvtPackage.freeze();

		return theQvtPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQvtVisitor() {
		return qvtVisitorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QvtFactory getQvtFactory() {
		return (QvtFactory)getEFactoryInstance();
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
		qvtVisitorEClass = createEClass(QVT_VISITOR);
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
		SemanticsPackage theSemanticsPackage = (SemanticsPackage)EPackage.Registry.INSTANCE.getEPackage(SemanticsPackage.eNS_URI);
		SemanticsPackage theSemanticsPackage_1 = (SemanticsPackage)EPackage.Registry.INSTANCE.getEPackage(SemanticsPackage.eNS_URI);
		QvtRelationPackage theQvtRelationPackage = (QvtRelationPackage)EPackage.Registry.INSTANCE.getEPackage(QvtRelationPackage.eNS_URI);
		QvtTemplatePackage theQvtTemplatePackage = (QvtTemplatePackage)EPackage.Registry.INSTANCE.getEPackage(QvtTemplatePackage.eNS_URI);
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);
		QvtBasePackage theQvtBasePackage = (QvtBasePackage)EPackage.Registry.INSTANCE.getEPackage(QvtBasePackage.eNS_URI);
		BridgePackage theBridgePackage = (BridgePackage)EPackage.Registry.INSTANCE.getEPackage(BridgePackage.eNS_URI);

		// Add supertypes to classes
		qvtVisitorEClass.getESuperTypes().add(theSemanticsPackage.getOclVisitor());

		// Initialize classes and features; add operations and parameters
		initEClass(qvtVisitorEClass, QvtVisitor.class, "QvtVisitor", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(qvtVisitorEClass, theSemanticsPackage_1.getObject(), "visit", 0, 1);
		addEParameter(op, theQvtRelationPackage.getRelationDomain(), "host", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(qvtVisitorEClass, theSemanticsPackage_1.getObject(), "visit", 0, 1);
		addEParameter(op, theQvtRelationPackage.getRelationalTransformation(), "host", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(qvtVisitorEClass, theSemanticsPackage_1.getObject(), "visit", 0, 1);
		addEParameter(op, theQvtRelationPackage.getRelation(), "host", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(qvtVisitorEClass, theSemanticsPackage_1.getObject(), "visit", 0, 1);
		addEParameter(op, theQvtRelationPackage.getRelationCallExp(), "host", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(qvtVisitorEClass, theSemanticsPackage_1.getObject(), "visit", 0, 1);
		addEParameter(op, theQvtTemplatePackage.getObjectTemplateExp(), "host", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(qvtVisitorEClass, theSemanticsPackage_1.getObject(), "visit", 0, 1);
		addEParameter(op, theQvtTemplatePackage.getPropertyTemplateItem(), "host", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(qvtVisitorEClass, theSemanticsPackage_1.getObject(), "visit", 0, 1);
		addEParameter(op, theExpressionsPackage.getOperationCallExp(), "host", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(qvtVisitorEClass, theSemanticsPackage_1.getObject(), "visit", 0, 1);
		addEParameter(op, theQvtRelationPackage.getDomainPattern(), "host", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(qvtVisitorEClass, theSemanticsPackage_1.getObject(), "visit", 0, 1);
		addEParameter(op, theQvtRelationPackage.getKey(), "host", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(qvtVisitorEClass, theSemanticsPackage_1.getObject(), "visit", 0, 1);
		addEParameter(op, theQvtBasePackage.getPredicate(), "host", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(qvtVisitorEClass, theSemanticsPackage_1.getObject(), "visit", 0, 1);
		addEParameter(op, theQvtBasePackage.getPattern(), "host", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(qvtVisitorEClass, theSemanticsPackage_1.getObject(), "visit", 0, 1);
		addEParameter(op, theQvtRelationPackage.getRelationImplementation(), "host", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(qvtVisitorEClass, theSemanticsPackage_1.getObject(), "visit", 0, 1);
		addEParameter(op, theBridgePackage.getTag(), "host", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(qvtVisitorEClass, theSemanticsPackage_1.getObject(), "visit", 0, 1);
		addEParameter(op, theQvtBasePackage.getTypedModel(), "host", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(qvtVisitorEClass, theSemanticsPackage_1.getObject(), "visit", 0, 1);
		addEParameter(op, theQvtBasePackage.getFunction(), "host", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EParameter addEParameter(EOperation owner, EClassifier type, String name, int lowerBound, int upperBound, boolean isUnique, boolean isOrdered) {
		EParameter p = ecoreFactory.createEParameter();
		p.setEType(type);
		p.setName(name);
		p.setLowerBound(lowerBound);
		p.setUpperBound(upperBound);
		p.setUnique(isUnique);
		p.setOrdered(isOrdered);
		owner.getEParameters().add(p);
		return p;
	}
	
} //QvtPackageImpl
