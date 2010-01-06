/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.impactAnalyzer;

import de.hpi.sam.bp2009.solution.eventListener.EventListenerPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerFactory
 * @model kind="package"
 * @generated
 */
public interface ImpactAnalyzerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "impactAnalyzer";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.bp2009.solution.impactAnalyzer";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "solution.impactAnalyzer";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImpactAnalyzerPackage eINSTANCE = de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl <em>Impact Analyzer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl
	 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerPackageImpl#getImpactAnalyzer()
	 * @generated
	 */
	int IMPACT_ANALYZER = 0;

	/**
	 * The number of structural features of the '<em>Impact Analyzer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ANALYZER_FEATURE_COUNT = EventListenerPackage.EVENT_LISTENER_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '<em>Ocl Query</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.query.ocl.conditions.AbstractOCLCondition
	 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerPackageImpl#getOclQuery()
	 * @generated
	 */
	int OCL_QUERY = 1;


	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer <em>Impact Analyzer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Impact Analyzer</em>'.
	 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer
	 * @generated
	 */
	EClass getImpactAnalyzer();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.query.ocl.conditions.AbstractOCLCondition <em>Ocl Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Ocl Query</em>'.
	 * @see org.eclipse.emf.query.ocl.conditions.AbstractOCLCondition
	 * @model instanceClass="org.eclipse.emf.query.ocl.conditions.AbstractOCLCondition<java.lang.Object, java.lang.Object, java.lang.Object>"
	 * @generated
	 */
	EDataType getOclQuery();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ImpactAnalyzerFactory getImpactAnalyzerFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl <em>Impact Analyzer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerImpl
		 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerPackageImpl#getImpactAnalyzer()
		 * @generated
		 */
		EClass IMPACT_ANALYZER = eINSTANCE.getImpactAnalyzer();
		/**
		 * The meta object literal for the '<em>Ocl Query</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.query.ocl.conditions.AbstractOCLCondition
		 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerPackageImpl#getOclQuery()
		 * @generated
		 */
		EDataType OCL_QUERY = eINSTANCE.getOclQuery();

	}

} //ImpactAnalyzerPackage
