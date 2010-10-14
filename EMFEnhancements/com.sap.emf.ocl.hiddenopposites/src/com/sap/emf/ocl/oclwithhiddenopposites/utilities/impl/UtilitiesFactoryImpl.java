/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.emf.ocl.oclwithhiddenopposites.utilities.impl;

import com.sap.emf.ocl.oclwithhiddenopposites.utilities.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UtilitiesFactoryImpl extends EFactoryImpl implements UtilitiesFactory {
	/**
         * Creates the default factory implementation.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public static UtilitiesFactory init() {
                try {
                        UtilitiesFactory theUtilitiesFactory = (UtilitiesFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.sap.com/emf/oppositepropertycallexputil"); 
                        if (theUtilitiesFactory != null) {
                                return theUtilitiesFactory;
                        }
                }
                catch (Exception exception) {
                        EcorePlugin.INSTANCE.log(exception);
                }
                return new UtilitiesFactoryImpl();
        }

	/**
         * Creates an instance of the factory.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public UtilitiesFactoryImpl() {
                super();
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@Override
	public EObject create(EClass eClass) {
                switch (eClass.getClassifierID()) {
                        default:
                                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
                }
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public UtilitiesPackage getUtilitiesPackage() {
                return (UtilitiesPackage)getEPackage();
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @deprecated
         * @generated
         */
	@Deprecated
	public static UtilitiesPackage getPackage() {
                return UtilitiesPackage.eINSTANCE;
        }

} //UtilitiesFactoryImpl
