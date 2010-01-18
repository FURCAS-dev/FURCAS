/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.impl;

import de.hpi.sam.bp2009.benchframework.*;

import java.io.OutputStream;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.jface.wizard.WizardPage;

import org.eclipse.swt.widgets.Composite;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BenchframeworkFactoryImpl extends EFactoryImpl implements BenchframeworkFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static BenchframeworkFactory init() {
		try {
			BenchframeworkFactory theBenchframeworkFactory = (BenchframeworkFactory)EPackage.Registry.INSTANCE.getEFactory("http://de.hpi.sam.bp2009.benchframework"); 
			if (theBenchframeworkFactory != null) {
				return theBenchframeworkFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BenchframeworkFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BenchframeworkFactoryImpl() {
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
			case BenchframeworkPackage.ENGINE: return createEngine();
			case BenchframeworkPackage.OPTION_OBJECT: return createOptionObject();
			case BenchframeworkPackage.RESULT_OBJECT: return createResultObject();
			case BenchframeworkPackage.TEST_RUN: return createTestRun();
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
			case BenchframeworkPackage.OUTPUT_STREAM:
				return createOutputStreamFromString(eDataType, initialValue);
			case BenchframeworkPackage.WIZARD_PAGE:
				return createWizardPageFromString(eDataType, initialValue);
			case BenchframeworkPackage.UI_COMPONENT:
				return createUIComponentFromString(eDataType, initialValue);
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
			case BenchframeworkPackage.OUTPUT_STREAM:
				return convertOutputStreamToString(eDataType, instanceValue);
			case BenchframeworkPackage.WIZARD_PAGE:
				return convertWizardPageToString(eDataType, instanceValue);
			case BenchframeworkPackage.UI_COMPONENT:
				return convertUIComponentToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Engine createEngine() {
		EngineImpl engine = new EngineImpl();
		return engine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptionObject createOptionObject() {
		OptionObjectImpl optionObject = new OptionObjectImpl();
		return optionObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultObject createResultObject() {
		ResultObjectImpl resultObject = new ResultObjectImpl();
		return resultObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TestRun createTestRun() {
		TestRunImpl testRun = new TestRunImpl();
		return testRun;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputStream createOutputStreamFromString(EDataType eDataType, String initialValue) {
		return (OutputStream)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOutputStreamToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WizardPage createWizardPageFromString(EDataType eDataType, String initialValue) {
		return (WizardPage)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWizardPageToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Composite createUIComponentFromString(EDataType eDataType, String initialValue) {
		return (Composite)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUIComponentToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BenchframeworkPackage getBenchframeworkPackage() {
		return (BenchframeworkPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static BenchframeworkPackage getPackage() {
		return BenchframeworkPackage.eINSTANCE;
	}

} //BenchframeworkFactoryImpl
