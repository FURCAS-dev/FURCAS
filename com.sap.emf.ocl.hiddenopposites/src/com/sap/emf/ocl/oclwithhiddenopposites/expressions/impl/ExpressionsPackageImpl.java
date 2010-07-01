/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.emf.ocl.oclwithhiddenopposites.expressions.impl;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.ExpressionsFactory;
import com.sap.emf.ocl.oclwithhiddenopposites.expressions.ExpressionsPackage;
import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.util.ExpressionsValidator;

import com.sap.emf.ocl.oclwithhiddenopposites.utilities.UtilitiesPackage;

import com.sap.emf.ocl.oclwithhiddenopposites.utilities.impl.UtilitiesPackageImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.ocl.ecore.EcorePackage;

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
	private EClass oppositePropertyCallExpEClass = null;

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
         * @see com.sap.emf.ocl.oclwithhiddenopposites.expressions.ExpressionsPackage#eNS_URI
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
                EcorePackage.eINSTANCE.eClass();

                // Obtain or create and register interdependencies
                UtilitiesPackageImpl theUtilitiesPackage = (UtilitiesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UtilitiesPackage.eNS_URI) instanceof UtilitiesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UtilitiesPackage.eNS_URI) : UtilitiesPackage.eINSTANCE);

                // Create package meta-data objects
                theExpressionsPackage.createPackageContents();
                theUtilitiesPackage.createPackageContents();

                // Initialize created meta-data
                theExpressionsPackage.initializePackageContents();
                theUtilitiesPackage.initializePackageContents();

                // Register package validator
                EValidator.Registry.INSTANCE.put
                        (theExpressionsPackage, 
                         new EValidator.Descriptor() {
                                 public EValidator getEValidator() {
                                         return ExpressionsValidator.INSTANCE;
                                 }
                         });

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
	public EClass getOppositePropertyCallExp() {
                return oppositePropertyCallExpEClass;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EReference getOppositePropertyCallExp_ReferredOppositeProperty() {
                return (EReference)oppositePropertyCallExpEClass.getEStructuralFeatures().get(0);
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
                oppositePropertyCallExpEClass = createEClass(OPPOSITE_PROPERTY_CALL_EXP);
                createEReference(oppositePropertyCallExpEClass, OPPOSITE_PROPERTY_CALL_EXP__REFERRED_OPPOSITE_PROPERTY);
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
                EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
                org.eclipse.emf.ecore.EcorePackage theEcorePackage_1 = (org.eclipse.emf.ecore.EcorePackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.emf.ecore.EcorePackage.eNS_URI);

                // Create type parameters

                // Set bounds for type parameters

                // Add supertypes to classes
                oppositePropertyCallExpEClass.getESuperTypes().add(theEcorePackage.getNavigationCallExp());

                // Initialize classes and features; add operations and parameters
                initEClass(oppositePropertyCallExpEClass, OppositePropertyCallExp.class, "OppositePropertyCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
                initEReference(getOppositePropertyCallExp_ReferredOppositeProperty(), theEcorePackage_1.getEReference(), null, "referredOppositeProperty", null, 0, 1, OppositePropertyCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

                EOperation op = addEOperation(oppositePropertyCallExpEClass, ecorePackage.getEBoolean(), "property_type", 0, 1, IS_UNIQUE, IS_ORDERED);
                addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
                EGenericType g1 = createEGenericType(ecorePackage.getEMap());
                EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
                g1.getETypeArguments().add(g2);
                g2 = createEGenericType(ecorePackage.getEJavaObject());
                g1.getETypeArguments().add(g2);
                addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

                // Create resource
                createResource(eNS_URI);
        }

} //ExpressionsPackageImpl
