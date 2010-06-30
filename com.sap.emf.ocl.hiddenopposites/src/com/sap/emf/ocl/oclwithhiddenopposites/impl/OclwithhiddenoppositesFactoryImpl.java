/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.emf.ocl.oclwithhiddenopposites.impl;

import com.sap.emf.ocl.oclwithhiddenopposites.*;

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
public class OclwithhiddenoppositesFactoryImpl extends EFactoryImpl implements OclwithhiddenoppositesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OclwithhiddenoppositesFactory init() {
		try {
			OclwithhiddenoppositesFactory theOclwithhiddenoppositesFactory = (OclwithhiddenoppositesFactory)EPackage.Registry.INSTANCE.getEFactory("http://oclwithhiddenopposites/1.0"); 
			if (theOclwithhiddenoppositesFactory != null) {
				return theOclwithhiddenoppositesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OclwithhiddenoppositesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclwithhiddenoppositesFactoryImpl() {
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
			case OclwithhiddenoppositesPackage.OPPOSITE_PROPERTY_CALL_EXP: return createOppositePropertyCallExp();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OppositePropertyCallExp createOppositePropertyCallExp() {
		OppositePropertyCallExpImpl oppositePropertyCallExp = new OppositePropertyCallExpImpl();
		return oppositePropertyCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclwithhiddenoppositesPackage getOclwithhiddenoppositesPackage() {
		return (OclwithhiddenoppositesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OclwithhiddenoppositesPackage getPackage() {
		return OclwithhiddenoppositesPackage.eINSTANCE;
	}

} //OclwithhiddenoppositesFactoryImpl
