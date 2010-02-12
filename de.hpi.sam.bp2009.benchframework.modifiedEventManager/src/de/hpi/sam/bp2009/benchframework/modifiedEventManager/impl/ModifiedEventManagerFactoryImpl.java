/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl;

import de.hpi.sam.bp2009.benchframework.modifiedEventManager.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class ModifiedEventManagerFactoryImpl extends EFactoryImpl implements ModifiedEventManagerFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModifiedEventManagerFactory init() {
		try {
			ModifiedEventManagerFactory theModifiedEventManagerFactory = (ModifiedEventManagerFactory)EPackage.Registry.INSTANCE.getEFactory("http://de.hpi.sam.bp2009.benchframework.modifiedEventManager"); 
			if (theModifiedEventManagerFactory != null) {
				return theModifiedEventManagerFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModifiedEventManagerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifiedEventManagerFactoryImpl() {
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
			case ModifiedEventManagerPackage.MODIFIED_EVENT_MANAGER: return createModifiedEventManager();
			case ModifiedEventManagerPackage.EMBED_MODIFIED_EM_OPERATOR: return createEmbedModifiedEMOperator();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ModifiedEventManagerPackage.NOTIFY_LITERALS:
				return createNotifyLiteralsFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ModifiedEventManagerPackage.NOTIFY_LITERALS:
				return convertNotifyLiteralsToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifiedEventManager createModifiedEventManager() {
		ModifiedEventManagerImpl modifiedEventManager = new ModifiedEventManagerImpl();
		return modifiedEventManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmbedModifiedEMOperator createEmbedModifiedEMOperator() {
		EmbedModifiedEMOperatorImpl embedModifiedEMOperator = new EmbedModifiedEMOperatorImpl();
		return embedModifiedEMOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotifyLiterals createNotifyLiteralsFromString(EDataType eDataType, String initialValue) {
		NotifyLiterals result = NotifyLiterals.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNotifyLiteralsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifiedEventManagerPackage getModifiedEventManagerPackage() {
		return (ModifiedEventManagerPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModifiedEventManagerPackage getPackage() {
		return ModifiedEventManagerPackage.eINSTANCE;
	}

} //ModifiedEventManagerFactoryImpl
