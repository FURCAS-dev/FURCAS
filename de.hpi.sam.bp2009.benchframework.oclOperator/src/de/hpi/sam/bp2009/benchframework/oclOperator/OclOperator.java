/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclOperator;

import de.hpi.sam.bp2009.benchframework.Operator;
import org.eclipse.emf.ecore.resource.ResourceSet;
import de.hpi.sam.bp2009.benchframework.OptionObject;

import org.eclipse.emf.ecore.resource.Resource;

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

} // OclOperator
