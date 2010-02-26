/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.Expressions;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.omg.OCL.Expressions.LoopExp#getIterators <em>Iterators</em>}</li>
 *   <li>{@link org.omg.OCL.Expressions.LoopExp#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.omg.OCL.Expressions.ExpressionsPackage#getLoopExp()
 * @model abstract="true"
 * @generated
 */
public interface LoopExp extends PropertyCallExp {
	/**
	 * Returns the value of the '<em><b>Iterators</b></em>' containment reference list.
	 * The list contents are of type {@link org.omg.OCL.Expressions.VariableDeclaration}.
	 * It is bidirectional and its opposite is '{@link org.omg.OCL.Expressions.VariableDeclaration#getLoopExpr <em>Loop Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterators</em>' containment reference list.
	 * @see org.omg.OCL.Expressions.ExpressionsPackage#getLoopExp_Iterators()
	 * @see org.omg.OCL.Expressions.VariableDeclaration#getLoopExpr
	 * @model opposite="loopExpr" containment="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Expressions.A_loopExpr_iterators' metaObjectMofId='45ED2E29E362C10B4E2048E117CCE6FC0738D230' storedEnd='0' compositeEnd='0' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	EList<VariableDeclaration> getIterators();

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(OclExpression)
	 * @see org.omg.OCL.Expressions.ExpressionsPackage#getLoopExp_Body()
	 * @model containment="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.Expressions.A_loopExp_body' metaObjectMofId='45ED2E29AD18B58C80B648FF2B6BB8226FFE8ED5' storedEnd='0' compositeEnd='0' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	OclExpression getBody();

	/**
	 * Sets the value of the '{@link org.omg.OCL.Expressions.LoopExp#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(OclExpression value);

} // LoopExp
