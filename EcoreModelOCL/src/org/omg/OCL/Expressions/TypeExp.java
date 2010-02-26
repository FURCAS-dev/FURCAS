/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.Expressions;

import com.sap.tc.moin.repository.mmi.Model.Classifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.omg.OCL.Expressions.TypeExp#getReferredType <em>Referred Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.omg.OCL.Expressions.ExpressionsPackage#getTypeExp()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Expressions.TypeExp' metaObjectMofId='45ED2E2922E623058A24485C271EF62E09C2EDE1' isStructureType='false'"
 * @generated
 */
public interface TypeExp extends OclExpression {
	/**
	 * Returns the value of the '<em><b>Referred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Type</em>' reference.
	 * @see #setReferredType(Classifier)
	 * @see org.omg.OCL.Expressions.ExpressionsPackage#getTypeExp_ReferredType()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Expressions.A_referredType_typeExp' metaObjectMofId='45ED2E293259BA3FF2F44777241CCE59F79C33C0' storedEnd='1' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	Classifier getReferredType();

	/**
	 * Sets the value of the '{@link org.omg.OCL.Expressions.TypeExp#getReferredType <em>Referred Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Type</em>' reference.
	 * @see #getReferredType()
	 * @generated
	 */
	void setReferredType(Classifier value);

} // TypeExp
