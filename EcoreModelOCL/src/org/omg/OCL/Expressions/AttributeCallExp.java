/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.Expressions;

import com.sap.tc.moin.repository.mmi.Model.Attribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.omg.OCL.Expressions.AttributeCallExp#getReferredAttribute <em>Referred Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.omg.OCL.Expressions.ExpressionsPackage#getAttributeCallExp()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Expressions.AttributeCallExp' metaObjectMofId='45ED2E29A08E98D7286846340041E0BCDA075FDB' isStructureType='false'"
 * @generated
 */
public interface AttributeCallExp extends ModelPropertyCallExp {
	/**
	 * Returns the value of the '<em><b>Referred Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Attribute</em>' reference.
	 * @see #setReferredAttribute(Attribute)
	 * @see org.omg.OCL.Expressions.ExpressionsPackage#getAttributeCallExp_ReferredAttribute()
	 * @model required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Expressions.A_referredAttribute_attributeCallExp' metaObjectMofId='45ED2E29CAFD7D3C99E34EAA2F3EBDF07176CA55' storedEnd='1' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	Attribute getReferredAttribute();

	/**
	 * Sets the value of the '{@link org.omg.OCL.Expressions.AttributeCallExp#getReferredAttribute <em>Referred Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Attribute</em>' reference.
	 * @see #getReferredAttribute()
	 * @generated
	 */
	void setReferredAttribute(Attribute value);

} // AttributeCallExp
