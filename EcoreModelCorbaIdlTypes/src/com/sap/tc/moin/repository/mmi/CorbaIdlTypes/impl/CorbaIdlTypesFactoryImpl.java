/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.tc.moin.repository.mmi.CorbaIdlTypes.impl;

import com.sap.tc.moin.repository.mmi.CorbaIdlTypes.*;

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
public class CorbaIdlTypesFactoryImpl extends EFactoryImpl implements CorbaIdlTypesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CorbaIdlTypesFactory init() {
		try {
			CorbaIdlTypesFactory theCorbaIdlTypesFactory = (CorbaIdlTypesFactory)EPackage.Registry.INSTANCE.getEFactory("http://sap.com/moin/CorbaIdlTypes"); 
			if (theCorbaIdlTypesFactory != null) {
				return theCorbaIdlTypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CorbaIdlTypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorbaIdlTypesFactoryImpl() {
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
			case CorbaIdlTypesPackage.CORBA_OCTET: return createCorbaOctet();
			case CorbaIdlTypesPackage.CORBA_SHORT: return createCorbaShort();
			case CorbaIdlTypesPackage.CORBA_UNSIGNED_SHORT: return createCorbaUnsignedShort();
			case CorbaIdlTypesPackage.CORBA_UNSIGNED_LONG: return createCorbaUnsignedLong();
			case CorbaIdlTypesPackage.CORBA_UNSIGNED_LONG_LONG: return createCorbaUnsignedLongLong();
			case CorbaIdlTypesPackage.CORBA_LONG_DOUBLE: return createCorbaLongDouble();
			case CorbaIdlTypesPackage.CORBA_STRING: return createCorbaString();
			case CorbaIdlTypesPackage.CORBA_CHAR: return createCorbaChar();
			case CorbaIdlTypesPackage.CORBA_WCHAR: return createCorbaWChar();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorbaOctet createCorbaOctet() {
		CorbaOctetImpl corbaOctet = new CorbaOctetImpl();
		return corbaOctet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorbaShort createCorbaShort() {
		CorbaShortImpl corbaShort = new CorbaShortImpl();
		return corbaShort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorbaUnsignedShort createCorbaUnsignedShort() {
		CorbaUnsignedShortImpl corbaUnsignedShort = new CorbaUnsignedShortImpl();
		return corbaUnsignedShort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorbaUnsignedLong createCorbaUnsignedLong() {
		CorbaUnsignedLongImpl corbaUnsignedLong = new CorbaUnsignedLongImpl();
		return corbaUnsignedLong;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorbaUnsignedLongLong createCorbaUnsignedLongLong() {
		CorbaUnsignedLongLongImpl corbaUnsignedLongLong = new CorbaUnsignedLongLongImpl();
		return corbaUnsignedLongLong;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorbaLongDouble createCorbaLongDouble() {
		CorbaLongDoubleImpl corbaLongDouble = new CorbaLongDoubleImpl();
		return corbaLongDouble;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorbaString createCorbaString() {
		CorbaStringImpl corbaString = new CorbaStringImpl();
		return corbaString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorbaChar createCorbaChar() {
		CorbaCharImpl corbaChar = new CorbaCharImpl();
		return corbaChar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorbaWChar createCorbaWChar() {
		CorbaWCharImpl corbaWChar = new CorbaWCharImpl();
		return corbaWChar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorbaIdlTypesPackage getCorbaIdlTypesPackage() {
		return (CorbaIdlTypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CorbaIdlTypesPackage getPackage() {
		return CorbaIdlTypesPackage.eINSTANCE;
	}

} //CorbaIdlTypesFactoryImpl
