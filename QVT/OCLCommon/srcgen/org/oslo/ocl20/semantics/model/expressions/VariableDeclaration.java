/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions;

import org.eclipse.emf.common.util.EList;

import org.oslo.ocl20.semantics.OclVisitor;

import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.ModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Variable Declaration</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getVariableExps <em>
 * Variable Exps</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getTupleLiteralExp <em>
 * Tuple Literal Exp</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getLoopExpr <em>Loop
 * Expr</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getType <em>Type</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getBaseExp <em>Base Exp
 * </em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getInitExpression <em>
 * Init Expression</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getVariableDeclaration()
 * @model
 * @generated
 */
public interface VariableDeclaration extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Variable Exps</b></em>' reference list. The list contents
	 * are of type {@link org.oslo.ocl20.semantics.model.expressions.VariableExp}. It is
	 * bidirectional and its opposite is '
	 * {@link org.oslo.ocl20.semantics.model.expressions.VariableExp#getReferredVariable
	 * <em>Referred Variable</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Exps</em>' reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Variable Exps</em>' reference list.
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getVariableDeclaration_VariableExps()
	 * @see org.oslo.ocl20.semantics.model.expressions.VariableExp#getReferredVariable
	 * @model type="org.oslo.ocl20.semantics.model.expressions.VariableExp"
	 *        opposite="referredVariable"
	 * @generated
	 */
	EList getVariableExps();

	/**
	 * Returns the value of the '<em><b>Tuple Literal Exp</b></em>' reference. It is bidirectional
	 * and its opposite is '
	 * {@link org.oslo.ocl20.semantics.model.expressions.TupleLiteralExp#getTuplePart
	 * <em>Tuple Part</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tuple Literal Exp</em>' reference isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Tuple Literal Exp</em>' reference.
	 * @see #setTupleLiteralExp(TupleLiteralExp)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getVariableDeclaration_TupleLiteralExp()
	 * @see org.oslo.ocl20.semantics.model.expressions.TupleLiteralExp#getTuplePart
	 * @model opposite="tuplePart" required="true"
	 * @generated
	 */
	TupleLiteralExp getTupleLiteralExp();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getTupleLiteralExp
	 * <em>Tuple Literal Exp</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Tuple Literal Exp</em>' reference.
	 * @see #getTupleLiteralExp()
	 * @generated
	 */
	void setTupleLiteralExp(TupleLiteralExp value);

	/**
	 * Returns the value of the '<em><b>Loop Expr</b></em>' container reference. It is bidirectional
	 * and its opposite is '{@link org.oslo.ocl20.semantics.model.expressions.LoopExp#getIterators
	 * <em>Iterators</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Expr</em>' container reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Loop Expr</em>' container reference.
	 * @see #setLoopExpr(LoopExp)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getVariableDeclaration_LoopExpr()
	 * @see org.oslo.ocl20.semantics.model.expressions.LoopExp#getIterators
	 * @model opposite="iterators" transient="false"
	 * @generated
	 */
	LoopExp getLoopExpr();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getLoopExpr
	 * <em>Loop Expr</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Loop Expr</em>' container reference.
	 * @see #getLoopExpr()
	 * @generated
	 */
	void setLoopExpr(LoopExp value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Classifier)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getVariableDeclaration_Type()
	 * @model required="true"
	 * @generated
	 */
	Classifier getType();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getType <em>Type</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Classifier value);

	/**
	 * Returns the value of the '<em><b>Base Exp</b></em>' container reference. It is bidirectional
	 * and its opposite is '{@link org.oslo.ocl20.semantics.model.expressions.IterateExp#getResult
	 * <em>Result</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Exp</em>' container reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Exp</em>' container reference.
	 * @see #setBaseExp(IterateExp)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getVariableDeclaration_BaseExp()
	 * @see org.oslo.ocl20.semantics.model.expressions.IterateExp#getResult
	 * @model opposite="result" transient="false"
	 * @generated
	 */
	IterateExp getBaseExp();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getBaseExp
	 * <em>Base Exp</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Base Exp</em>' container reference.
	 * @see #getBaseExp()
	 * @generated
	 */
	void setBaseExp(IterateExp value);

	/**
	 * Returns the value of the '<em><b>Init Expression</b></em>' containment reference. It is
	 * bidirectional and its opposite is '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclExpression#getInitialisedVariable
	 * <em>Initialised Variable</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Expression</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Init Expression</em>' containment reference.
	 * @see #setInitExpression(OclExpression)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getVariableDeclaration_InitExpression()
	 * @see org.oslo.ocl20.semantics.model.expressions.OclExpression#getInitialisedVariable
	 * @model opposite="initialisedVariable" containment="true"
	 * @generated
	 */
	OclExpression getInitExpression();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getInitExpression
	 * <em>Init Expression</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Init Expression</em>' containment reference.
	 * @see #getInitExpression()
	 * @generated
	 */
	void setInitExpression(OclExpression value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object"
	 *        dataDataType="org.oslo.ocl20.semantics.Object" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // VariableDeclaration
