/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclOperator.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.hpi.sam.bp2009.benchframework.csvResultProcessor.OclOperator;
import de.hpi.sam.bp2009.benchframework.csvResultProcessor.OclOptionObject;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorFactory;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorPackage;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclResult;
import de.hpi.sam.bp2009.benchframework.oclOperator.OclUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OclOperatorFactoryImpl extends EFactoryImpl implements OclOperatorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OclOperatorFactory init() {
		try {
			OclOperatorFactory theOclOperatorFactory = (OclOperatorFactory)EPackage.Registry.INSTANCE.getEFactory("http://de.hpi.sam.bp2009.benchframework.oclOperator"); 
			if (theOclOperatorFactory != null) {
				return theOclOperatorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OclOperatorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclOperatorFactoryImpl() {
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
			case OclOperatorPackage.OCL_OPERATOR: return createOclOperator();
			case OclOperatorPackage.OCL_OPTION_OBJECT: return createOclOptionObject();
			case OclOperatorPackage.OCL_UTIL: return createOclUtil();
			case OclOperatorPackage.OCL_RESULT: return createOclResult();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclOperator createOclOperator() {
		OclOperatorImpl oclOperator = new OclOperatorImpl();
		return oclOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclOptionObject createOclOptionObject() {
		OclOptionObjectImpl oclOptionObject = new OclOptionObjectImpl();
		return oclOptionObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclUtil createOclUtil() {
		OclUtilImpl oclUtil = new OclUtilImpl();
		return oclUtil;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclResult createOclResult() {
		OclResultImpl oclResult = new OclResultImpl();
		return oclResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclOperatorPackage getOclOperatorPackage() {
		return (OclOperatorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OclOperatorPackage getPackage() {
		return OclOperatorPackage.eINSTANCE;
	}

} //OclOperatorFactoryImpl
