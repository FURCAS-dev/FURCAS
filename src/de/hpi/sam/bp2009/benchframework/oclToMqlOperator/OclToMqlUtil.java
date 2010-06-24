/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclToMqlOperator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.expressions.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl To Mql Util</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOperatorPackage#getOclToMqlUtil()
 * @model
 * @generated
 */
public interface OclToMqlUtil extends EObject {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    Object evaluateMQL(String completeConstraint, ResourceSet resourceSet);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return 
     * @model
     * @generated
     */
    Object evaluateOCL(String completeConstraint, ResourceSet resourceSet);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    OCLExpression<?> getOCLExpressionForOCL(String completeConstraint, ResourceSet resourceSet);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    OCLExpression<?> getOCLExpressionForMQL(String completeConstraint, ResourceSet resourceSet);

} // OclToMqlUtil
