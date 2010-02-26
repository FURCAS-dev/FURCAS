/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.Expressions;

import com.sap.tc.moin.repository.mmi.Model.AssociationEnd;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association End Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.omg.OCL.Expressions.AssociationEndCallExp#getReferredAssociationEnd <em>Referred Association End</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.omg.OCL.Expressions.ExpressionsPackage#getAssociationEndCallExp()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Expressions.AssociationEndCallExp' metaObjectMofId='45ED2E2900FC935917F3496F0460C878F0E27694' isStructureType='false'"
 * @generated
 */
public interface AssociationEndCallExp extends NavigationCallExp {
	/**
	 * Returns the value of the '<em><b>Referred Association End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Association End</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Association End</em>' reference.
	 * @see #setReferredAssociationEnd(AssociationEnd)
	 * @see org.omg.OCL.Expressions.ExpressionsPackage#getAssociationEndCallExp_ReferredAssociationEnd()
	 * @model required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Expressions.A_referredAssociationEnd_associationEndCallExp' metaObjectMofId='45ED2E2910D16B625EE4448200A697638E1ADA03' storedEnd='1' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	AssociationEnd getReferredAssociationEnd();

	/**
	 * Sets the value of the '{@link org.omg.OCL.Expressions.AssociationEndCallExp#getReferredAssociationEnd <em>Referred Association End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Association End</em>' reference.
	 * @see #getReferredAssociationEnd()
	 * @generated
	 */
	void setReferredAssociationEnd(AssociationEnd value);

} // AssociationEndCallExp
