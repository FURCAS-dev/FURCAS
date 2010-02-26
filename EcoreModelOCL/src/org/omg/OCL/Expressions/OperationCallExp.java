/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.Expressions;

import com.sap.tc.moin.repository.mmi.Model.Operation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.omg.OCL.Expressions.OperationCallExp#getReferredOperation <em>Referred Operation</em>}</li>
 *   <li>{@link org.omg.OCL.Expressions.OperationCallExp#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.omg.OCL.Expressions.ExpressionsPackage#getOperationCallExp()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Expressions.OperationCallExp' metaObjectMofId='45ED2E2999F6EE43264341113E06E6B7B76AEBA3' isStructureType='false'"
 * @generated
 */
public interface OperationCallExp extends ModelPropertyCallExp {
	/**
	 * Returns the value of the '<em><b>Referred Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Operation</em>' reference.
	 * @see #setReferredOperation(Operation)
	 * @see org.omg.OCL.Expressions.ExpressionsPackage#getOperationCallExp_ReferredOperation()
	 * @model required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Expressions.A_referredOperation_operationCallExp' metaObjectMofId='45ED2E292E44287A94754BA40DFCDAD59E374E24' storedEnd='1' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	Operation getReferredOperation();

	/**
	 * Sets the value of the '{@link org.omg.OCL.Expressions.OperationCallExp#getReferredOperation <em>Referred Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Operation</em>' reference.
	 * @see #getReferredOperation()
	 * @generated
	 */
	void setReferredOperation(Operation value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.omg.OCL.Expressions.OclExpression}.
	 * It is bidirectional and its opposite is '{@link org.omg.OCL.Expressions.OclExpression#getParentOperation <em>Parent Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see org.omg.OCL.Expressions.ExpressionsPackage#getOperationCallExp_Arguments()
	 * @see org.omg.OCL.Expressions.OclExpression#getParentOperation
	 * @model opposite="parentOperation" containment="true"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Expressions.A_parentOperation_arguments' metaObjectMofId='45ED2E297046BE46EB524CAA1143F6FD9EE9162C' storedEnd='0' compositeEnd='0' orderedEnd='1' exposedEndNumber='0'"
	 * @generated
	 */
	EList<OclExpression> getArguments();

} // OperationCallExp
