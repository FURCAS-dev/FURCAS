/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.csvResultProcessor;

import java.util.HashMap;
import java.util.LinkedList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.ResourceSet;

import de.hpi.sam.bp2009.benchframework.Operator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorPackage#getOclOperator()
 * @model
 * @generated
 */
public interface OclOperator extends Operator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void executeQueries(ResourceSet resource, OclOptionObject option);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void registerQueriesIA(ResourceSet resource, OclOptionObject option);

	HashMap<Notification, LinkedList<String>> getAffectedExprs();

} // OclOperator
