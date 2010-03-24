/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.csvResultProcessor.impl;

import de.hpi.sam.bp2009.benchframework.csvResultProcessor.*;

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
public class CsvResultProcessorFactoryImpl extends EFactoryImpl implements CsvResultProcessorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CsvResultProcessorFactory init() {
		try {
			CsvResultProcessorFactory theCsvResultProcessorFactory = (CsvResultProcessorFactory)EPackage.Registry.INSTANCE.getEFactory("http://de.hpi.sam.bp2009.benchframework.csvResultProcessor"); 
			if (theCsvResultProcessorFactory != null) {
				return theCsvResultProcessorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CsvResultProcessorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CsvResultProcessorFactoryImpl() {
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
			case CsvResultProcessorPackage.CSV_RESULT_PROCESSOR: return createCsvResultProcessor();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CsvResultProcessor createCsvResultProcessor() {
		CsvResultProcessorImpl csvResultProcessor = new CsvResultProcessorImpl();
		return csvResultProcessor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CsvResultProcessorPackage getCsvResultProcessorPackage() {
		return (CsvResultProcessorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CsvResultProcessorPackage getPackage() {
		return CsvResultProcessorPackage.eINSTANCE;
	}

} //CsvResultProcessorFactoryImpl
