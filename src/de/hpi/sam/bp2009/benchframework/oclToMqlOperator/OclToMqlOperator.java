/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclToMqlOperator;

import de.hpi.sam.bp2009.benchframework.Operator;

import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl To Mql Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperatorPackage#getOclToMqlOperator()
 * @model
 * @generated
 */
public interface OclToMqlOperator extends Operator {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void executeQueries(ResourceSet resourceSet, OclToMqlOptionObject option);

} // OclToMqlOperator
