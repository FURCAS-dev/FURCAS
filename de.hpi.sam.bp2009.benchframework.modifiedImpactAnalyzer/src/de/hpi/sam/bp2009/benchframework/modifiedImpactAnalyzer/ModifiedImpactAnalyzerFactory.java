/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.ModifiedImpactAnalyzerPackage
 * @generated
 */
public interface ModifiedImpactAnalyzerFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModifiedImpactAnalyzerFactory eINSTANCE = de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.impl.ModifiedImpactAnalyzerFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Modified Impact Analyzer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Modified Impact Analyzer</em>'.
	 * @generated
	 */
	ModifiedImpactAnalyzer createModifiedImpactAnalyzer();

	/**
	 * Returns a new object of class '<em>Incoming Event Notification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Incoming Event Notification</em>'.
	 * @generated
	 */
	IncomingEventNotification createIncomingEventNotification();

	/**
	 * Returns a new object of class '<em>Outgoing Result Notification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Outgoing Result Notification</em>'.
	 * @generated
	 */
	OutgoingResultNotification createOutgoingResultNotification();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModifiedImpactAnalyzerPackage getModifiedImpactAnalyzerPackage();

} //ModifiedImpactAnalyzerFactory
