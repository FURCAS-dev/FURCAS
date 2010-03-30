/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.oclOperator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.expressions.OCLExpression;

import de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl Util</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.hpi.sam.bp2009.benchframework.oclOperator.OclOperatorPackage#getOclUtil()
 * @model
 * @generated
 */
public interface OclUtil extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean executeQueryOn(String completeConstraint, ResourceSet resource, QueryEvaluator evaluator);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	OCLExpression<?> getOCLExpression(String completeConstraint, ResourceSet resource) throws ParserException;

} // OclUtil
