/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.impactAnalyzer;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerPackage
 * @generated
 */
public interface ImpactAnalyzerFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImpactAnalyzerFactory eINSTANCE = de.hpi.sam.bp2009.solution.impactAnalyzer.impl.ImpactAnalyzerFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Impact Analyzer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Impact Analyzer</em>'.
	 * @generated
	 */
	ImpactAnalyzer createImpactAnalyzer();

	/**
	 * Returns a new object of class '<em>Query Reevaluate Notification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Query Reevaluate Notification</em>'.
	 * @generated
	 */
	QueryReevaluateNotification createQueryReevaluateNotification();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ImpactAnalyzerPackage getImpactAnalyzerPackage();

} //ImpactAnalyzerFactory
