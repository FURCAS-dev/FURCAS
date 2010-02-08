/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modified Impact Analyzer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Modified version of the Impact Analyzer to make it "benchmarker enabled".
 * It provides an extension point for Adapters to register for getting a notification once it communicates with another component of the system.
 * To do so, it overrides methods of the Impact Analyzer and includes a call to sendBenchmarNotification().
 * <!-- end-model-doc -->
 *
 *
 * @see de.hpi.sam.bp2009.benchframework.modifiedImpactAnalyzer.ModifiedImpactAnalyzerPackage#getModifiedImpactAnalyzer()
 * @model
 * @generated
 */
public interface ModifiedImpactAnalyzer extends ImpactAnalyzer {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Build and send a notification to all registered benchmarkers.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void sendBenchmarkNotification(Object communicationPartner, boolean incoming);
} // ModifiedImpactAnalyzer
