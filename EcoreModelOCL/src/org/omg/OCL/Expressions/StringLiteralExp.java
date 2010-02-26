/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.Expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.omg.OCL.Expressions.StringLiteralExp#getStringSymbol <em>String Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.omg.OCL.Expressions.ExpressionsPackage#getStringLiteralExp()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Expressions.StringLiteralExp' metaObjectMofId='45ED2E298FCDC4EFE56B4494349ED616A64ACF7C' isStructureType='false'"
 * @generated
 */
public interface StringLiteralExp extends PrimitiveLiteralExp {
	/**
	 * Returns the value of the '<em><b>String Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Symbol</em>' attribute.
	 * @see #setStringSymbol(String)
	 * @see org.omg.OCL.Expressions.ExpressionsPackage#getStringLiteralExp_StringSymbol()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getStringSymbol();

	/**
	 * Sets the value of the '{@link org.omg.OCL.Expressions.StringLiteralExp#getStringSymbol <em>String Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String Symbol</em>' attribute.
	 * @see #getStringSymbol()
	 * @generated
	 */
	void setStringSymbol(String value);

} // StringLiteralExp
