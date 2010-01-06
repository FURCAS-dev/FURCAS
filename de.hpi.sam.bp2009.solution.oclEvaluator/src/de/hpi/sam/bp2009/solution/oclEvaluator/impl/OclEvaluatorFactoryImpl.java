/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclEvaluator.impl;

import de.hpi.sam.bp2009.solution.oclEvaluator.*;

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
public class OclEvaluatorFactoryImpl extends EFactoryImpl implements OclEvaluatorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OclEvaluatorFactory init() {
		try {
			OclEvaluatorFactory theOclEvaluatorFactory = (OclEvaluatorFactory)EPackage.Registry.INSTANCE.getEFactory("http://de.hpi.sam.bp2009.solution.oclEvaluator"); 
			if (theOclEvaluatorFactory != null) {
				return theOclEvaluatorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OclEvaluatorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclEvaluatorFactoryImpl() {
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
			case OclEvaluatorPackage.OCL_EVALUATOR: return createOCLEvaluator();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLEvaluator createOCLEvaluator() {
		OCLEvaluatorImpl oclEvaluator = new OCLEvaluatorImpl();
		return oclEvaluator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclEvaluatorPackage getOclEvaluatorPackage() {
		return (OclEvaluatorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OclEvaluatorPackage getPackage() {
		return OclEvaluatorPackage.eINSTANCE;
	}

} //OclEvaluatorFactoryImpl
