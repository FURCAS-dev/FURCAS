/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.Expressions;

import com.sap.tc.moin.repository.mmi.Model.EnumerationType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.omg.OCL.Expressions.EnumLiteralExp#getLiteral <em>Literal</em>}</li>
 *   <li>{@link org.omg.OCL.Expressions.EnumLiteralExp#getReferredEnum <em>Referred Enum</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.omg.OCL.Expressions.ExpressionsPackage#getEnumLiteralExp()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Expressions.EnumLiteralExp' metaObjectMofId='45ED2E29135E0C46DCEC4E593E05A865ECFC172D' isStructureType='false'"
 * @generated
 */
public interface EnumLiteralExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal</em>' attribute.
	 * @see #setLiteral(String)
	 * @see org.omg.OCL.Expressions.ExpressionsPackage#getEnumLiteralExp_Literal()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getLiteral();

	/**
	 * Sets the value of the '{@link org.omg.OCL.Expressions.EnumLiteralExp#getLiteral <em>Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal</em>' attribute.
	 * @see #getLiteral()
	 * @generated
	 */
	void setLiteral(String value);

	/**
	 * Returns the value of the '<em><b>Referred Enum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Enum</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Enum</em>' reference.
	 * @see #setReferredEnum(EnumerationType)
	 * @see org.omg.OCL.Expressions.ExpressionsPackage#getEnumLiteralExp_ReferredEnum()
	 * @model required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Expressions.A_referredEnum_enumLiteralExp' metaObjectMofId='45ED2E29490A740DE11C474C2F08A2C6A93F305C' storedEnd='1' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	EnumerationType getReferredEnum();

	/**
	 * Sets the value of the '{@link org.omg.OCL.Expressions.EnumLiteralExp#getReferredEnum <em>Referred Enum</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Enum</em>' reference.
	 * @see #getReferredEnum()
	 * @generated
	 */
	void setReferredEnum(EnumerationType value);

} // EnumLiteralExp
