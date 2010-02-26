/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.Expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterate Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.omg.OCL.Expressions.IterateExp#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.omg.OCL.Expressions.ExpressionsPackage#getIterateExp()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Expressions.IterateExp' metaObjectMofId='45ED2E29EF4CCD17D5D649D02F0AE9877FA6D96B' isStructureType='false'"
 * @generated
 */
public interface IterateExp extends LoopExp {
	/**
	 * Returns the value of the '<em><b>Result</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.omg.OCL.Expressions.VariableDeclaration#getBaseExp <em>Base Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' containment reference.
	 * @see #setResult(VariableDeclaration)
	 * @see org.omg.OCL.Expressions.ExpressionsPackage#getIterateExp_Result()
	 * @see org.omg.OCL.Expressions.VariableDeclaration#getBaseExp
	 * @model opposite="baseExp" containment="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Expressions.A_baseExp_result' metaObjectMofId='45ED2E290A4BA5F7848749961A4BF84E47601746' storedEnd='0' compositeEnd='0' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	VariableDeclaration getResult();

	/**
	 * Sets the value of the '{@link org.omg.OCL.Expressions.IterateExp#getResult <em>Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' containment reference.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(VariableDeclaration value);

} // IterateExp
