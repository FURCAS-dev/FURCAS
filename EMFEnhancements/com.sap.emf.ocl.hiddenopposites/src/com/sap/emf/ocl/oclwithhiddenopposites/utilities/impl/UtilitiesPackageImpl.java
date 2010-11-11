/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.emf.ocl.oclwithhiddenopposites.utilities.impl;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.ExpressionsPackage;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.impl.ExpressionsPackageImpl;

import com.sap.emf.ocl.oclwithhiddenopposites.utilities.UtilitiesFactory;
import com.sap.emf.ocl.oclwithhiddenopposites.utilities.UtilitiesPackage;
import com.sap.emf.ocl.oclwithhiddenopposites.utilities.VisitorWithHiddenOpposite;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.ocl.ecore.EcorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UtilitiesPackageImpl extends EPackageImpl implements UtilitiesPackage {
	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	private EClass visitorWithHiddenOppositeEClass = null;

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
         * @see com.sap.emf.ocl.oclwithhiddenopposites.utilities.UtilitiesPackage#eNS_URI
         * @see #init()
         * @generated
         */
	private UtilitiesPackageImpl() {
                super(eNS_URI, UtilitiesFactory.eINSTANCE);
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
         * <p>This method is used to initialize {@link UtilitiesPackage#eINSTANCE} when that field is accessed.
         * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #eNS_URI
         * @see #createPackageContents()
         * @see #initializePackageContents()
         * @generated
         */
	public static UtilitiesPackage init() {
                if (isInited) return (UtilitiesPackage)EPackage.Registry.INSTANCE.getEPackage(UtilitiesPackage.eNS_URI);

                // Obtain or create and register package
                UtilitiesPackageImpl theUtilitiesPackage = (UtilitiesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UtilitiesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UtilitiesPackageImpl());

                isInited = true;

                // Initialize simple dependencies
                EcorePackage.eINSTANCE.eClass();

                // Obtain or create and register interdependencies
                ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) : ExpressionsPackage.eINSTANCE);

                // Create package meta-data objects
                theUtilitiesPackage.createPackageContents();
                theExpressionsPackage.createPackageContents();

                // Initialize created meta-data
                theUtilitiesPackage.initializePackageContents();
                theExpressionsPackage.initializePackageContents();

                // Mark meta-data to indicate it can't be changed
                theUtilitiesPackage.freeze();

  
                // Update the registry and return the package
                EPackage.Registry.INSTANCE.put(UtilitiesPackage.eNS_URI, theUtilitiesPackage);
                return theUtilitiesPackage;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EClass getVisitorWithHiddenOpposite() {
                return visitorWithHiddenOppositeEClass;
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public UtilitiesFactory getUtilitiesFactory() {
                return (UtilitiesFactory)getEFactoryInstance();
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
                visitorWithHiddenOppositeEClass = createEClass(VISITOR_WITH_HIDDEN_OPPOSITE);
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
                org.eclipse.ocl.utilities.UtilitiesPackage theUtilitiesPackage_1 = (org.eclipse.ocl.utilities.UtilitiesPackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.ocl.utilities.UtilitiesPackage.eNS_URI);
                org.eclipse.emf.ecore.EcorePackage theEcorePackage_1 = (org.eclipse.emf.ecore.EcorePackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.emf.ecore.EcorePackage.eNS_URI);
                EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
                ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

                // Create type parameters
                ETypeParameter visitorWithHiddenOppositeEClass_T = addETypeParameter(visitorWithHiddenOppositeEClass, "T");

                // Set bounds for type parameters

                // Add supertypes to classes
                EGenericType g1 = createEGenericType(theUtilitiesPackage_1.getVisitor());
                EGenericType g2 = createEGenericType(theEcorePackage_1.getEJavaObject());
                g1.getETypeArguments().add(g2);
                g2 = createEGenericType(theEcorePackage_1.getEClassifier());
                g1.getETypeArguments().add(g2);
                g2 = createEGenericType(theEcorePackage_1.getEOperation());
                g1.getETypeArguments().add(g2);
                g2 = createEGenericType(theEcorePackage_1.getEStructuralFeature());
                g1.getETypeArguments().add(g2);
                g2 = createEGenericType(theEcorePackage_1.getEEnumLiteral());
                g1.getETypeArguments().add(g2);
                g2 = createEGenericType(theEcorePackage_1.getEParameter());
                g1.getETypeArguments().add(g2);
                g2 = createEGenericType(theEcorePackage_1.getEObject());
                g1.getETypeArguments().add(g2);
                g2 = createEGenericType(theEcorePackage.getCallOperationAction());
                g1.getETypeArguments().add(g2);
                g2 = createEGenericType(theEcorePackage.getSendSignalAction());
                g1.getETypeArguments().add(g2);
                g2 = createEGenericType(theEcorePackage.getConstraint());
                g1.getETypeArguments().add(g2);
                visitorWithHiddenOppositeEClass.getEGenericSuperTypes().add(g1);

                // Initialize classes and features; add operations and parameters
                initEClass(visitorWithHiddenOppositeEClass, VisitorWithHiddenOpposite.class, "VisitorWithHiddenOpposite", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

                EOperation op = addEOperation(visitorWithHiddenOppositeEClass, null, "visitOppositePropertyCallExp", 0, 1, IS_UNIQUE, IS_ORDERED);
                addEParameter(op, theExpressionsPackage.getOppositePropertyCallExp(), "callExp", 1, 1, IS_UNIQUE, IS_ORDERED);
                g1 = createEGenericType(visitorWithHiddenOppositeEClass_T);
                initEOperation(op, g1);

                // Create resource
                createResource(eNS_URI);
        }

} //UtilitiesPackageImpl
