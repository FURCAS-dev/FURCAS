/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvtbase;

import org.oslo.ocl20.semantics.OclVisitor;
import de.ikv.medini.qvt.qvt.QvtVisitor;

import org.oslo.ocl20.semantics.bridge.Element;

import org.oslo.ocl20.semantics.model.expressions.OclExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.Predicate#getContitionExpression <em>Contition Expression</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.Predicate#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getPredicate()
 * @model
 * @generated
 */
public interface Predicate extends Element {
	/**
	 * Returns the value of the '<em><b>Contition Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contition Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contition Expression</em>' containment reference.
	 * @see #setContitionExpression(OclExpression)
	 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getPredicate_ContitionExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OclExpression getContitionExpression();

	/**
	 * Sets the value of the '{@link de.ikv.medini.qvt.model.qvtbase.Predicate#getContitionExpression <em>Contition Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contition Expression</em>' containment reference.
	 * @see #getContitionExpression()
	 * @generated
	 */
	void setContitionExpression(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.ikv.medini.qvt.model.qvtbase.Pattern#getPredicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' container reference.
	 * @see #setPattern(Pattern)
	 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getPredicate_Pattern()
	 * @see de.ikv.medini.qvt.model.qvtbase.Pattern#getPredicate
	 * @model opposite="predicate" required="true" transient="false"
	 * @generated
	 */
	Pattern getPattern();

	/**
	 * Sets the value of the '{@link de.ikv.medini.qvt.model.qvtbase.Predicate#getPattern <em>Pattern</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' container reference.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(Pattern value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((QvtVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // Predicate
