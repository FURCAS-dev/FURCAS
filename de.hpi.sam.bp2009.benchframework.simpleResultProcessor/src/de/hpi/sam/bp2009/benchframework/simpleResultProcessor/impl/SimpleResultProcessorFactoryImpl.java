/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.simpleResultProcessor.impl;

import de.hpi.sam.bp2009.benchframework.simpleResultProcessor.*;

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
public class SimpleResultProcessorFactoryImpl extends EFactoryImpl implements SimpleResultProcessorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SimpleResultProcessorFactory init() {
		try {
			SimpleResultProcessorFactory theSimpleResultProcessorFactory = (SimpleResultProcessorFactory)EPackage.Registry.INSTANCE.getEFactory("http://de.hpi.sam.bp2009.benchframework.simpleResultProcessor"); 
			if (theSimpleResultProcessorFactory != null) {
				return theSimpleResultProcessorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SimpleResultProcessorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleResultProcessorFactoryImpl() {
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
			case SimpleResultProcessorPackage.SIMPLE_RESULT_PROCESSOR: return createSimpleResultProcessor();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleResultProcessor createSimpleResultProcessor() {
		SimpleResultProcessorImpl simpleResultProcessor = new SimpleResultProcessorImpl();
		return simpleResultProcessor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleResultProcessorPackage getSimpleResultProcessorPackage() {
		return (SimpleResultProcessorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SimpleResultProcessorPackage getPackage() {
		return SimpleResultProcessorPackage.eINSTANCE;
	}

} //SimpleResultProcessorFactoryImpl
