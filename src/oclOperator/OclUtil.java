/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package oclOperator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.query.statements.IQueryResult;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl Util</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see oclOperator.OclOperatorPackage#getOclUtil()
 * @model
 * @generated
 */
public interface OclUtil extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="oclOperator.IQueryResult"
	 * @generated
	 */
	IQueryResult executeQueryOn(String completeConstraint, Resource resource);

} // OclUtil
