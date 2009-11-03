/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions;

import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.ModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Ocl Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.OclExpression#isIsMarkedPre <em>Is Marked
 * Pre</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.OclExpression#getLoopExp <em>Loop Exp</em>}
 * </li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.OclExpression#getOperationCallExp <em>
 * Operation Call Exp</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.OclExpression#getPropertyCallExp <em>
 * Property Call Exp</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.OclExpression#getType <em>Type</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.OclExpression#getAppliedProperty <em>
 * Applied Property</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.OclExpression#getInitialisedVariable <em>
 * Initialised Variable</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getOclExpression()
 * @model
 * @generated
 */
public interface OclExpression extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Is Marked Pre</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Marked Pre</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Is Marked Pre</em>' attribute.
	 * @see #setIsMarkedPre(boolean)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getOclExpression_IsMarkedPre()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsMarkedPre();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclExpression#isIsMarkedPre
	 * <em>Is Marked Pre</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Is Marked Pre</em>' attribute.
	 * @see #isIsMarkedPre()
	 * @generated
	 */
	void setIsMarkedPre(boolean value);

	/**
	 * Returns the value of the '<em><b>Loop Exp</b></em>' container reference. It is bidirectional
	 * and its opposite is '{@link org.oslo.ocl20.semantics.model.expressions.LoopExp#getBody
	 * <em>Body</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Exp</em>' container reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Loop Exp</em>' container reference.
	 * @see #setLoopExp(LoopExp)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getOclExpression_LoopExp()
	 * @see org.oslo.ocl20.semantics.model.expressions.LoopExp#getBody
	 * @model opposite="body" transient="false"
	 * @generated
	 */
	LoopExp getLoopExp();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclExpression#getLoopExp <em>Loop Exp</em>}
	 * ' container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Loop Exp</em>' container reference.
	 * @see #getLoopExp()
	 * @generated
	 */
	void setLoopExp(LoopExp value);

	/**
	 * Returns the value of the '<em><b>Operation Call Exp</b></em>' container reference. It is
	 * bidirectional and its opposite is '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OperationCallExp#getArguments
	 * <em>Arguments</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Call Exp</em>' container reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Operation Call Exp</em>' container reference.
	 * @see #setOperationCallExp(OperationCallExp)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getOclExpression_OperationCallExp()
	 * @see org.oslo.ocl20.semantics.model.expressions.OperationCallExp#getArguments
	 * @model opposite="arguments" required="true" transient="false"
	 * @generated
	 */
	OperationCallExp getOperationCallExp();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclExpression#getOperationCallExp
	 * <em>Operation Call Exp</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Operation Call Exp</em>' container reference.
	 * @see #getOperationCallExp()
	 * @generated
	 */
	void setOperationCallExp(OperationCallExp value);

	/**
	 * Returns the value of the '<em><b>Property Call Exp</b></em>' container reference. It is
	 * bidirectional and its opposite is '
	 * {@link org.oslo.ocl20.semantics.model.expressions.PropertyCallExp#getQualifiers
	 * <em>Qualifiers</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Call Exp</em>' container reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Property Call Exp</em>' container reference.
	 * @see #setPropertyCallExp(PropertyCallExp)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getOclExpression_PropertyCallExp()
	 * @see org.oslo.ocl20.semantics.model.expressions.PropertyCallExp#getQualifiers
	 * @model opposite="qualifiers" required="true" transient="false"
	 * @generated
	 */
	PropertyCallExp getPropertyCallExp();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclExpression#getPropertyCallExp
	 * <em>Property Call Exp</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Property Call Exp</em>' container reference.
	 * @see #getPropertyCallExp()
	 * @generated
	 */
	void setPropertyCallExp(PropertyCallExp value);

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
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getOclExpression_Type()
	 * @model required="true"
	 * @generated
	 */
	Classifier getType();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclExpression#getType <em>Type</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Classifier value);

	/**
	 * Returns the value of the '<em><b>Applied Property</b></em>' container reference. It is
	 * bidirectional and its opposite is '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CallExp#getSource <em>Source</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applied Property</em>' container reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Applied Property</em>' container reference.
	 * @see #setAppliedProperty(CallExp)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getOclExpression_AppliedProperty()
	 * @see org.oslo.ocl20.semantics.model.expressions.CallExp#getSource
	 * @model opposite="source" transient="false"
	 * @generated
	 */
	CallExp getAppliedProperty();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclExpression#getAppliedProperty
	 * <em>Applied Property</em>}' container reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Applied Property</em>' container reference.
	 * @see #getAppliedProperty()
	 * @generated
	 */
	void setAppliedProperty(CallExp value);

	/**
	 * Returns the value of the '<em><b>Initialised Variable</b></em>' container reference. It is
	 * bidirectional and its opposite is '
	 * {@link org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getInitExpression
	 * <em>Init Expression</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initialised Variable</em>' container reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Initialised Variable</em>' container reference.
	 * @see #setInitialisedVariable(VariableDeclaration)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getOclExpression_InitialisedVariable()
	 * @see org.oslo.ocl20.semantics.model.expressions.VariableDeclaration#getInitExpression
	 * @model opposite="initExpression" transient="false"
	 * @generated
	 */
	VariableDeclaration getInitialisedVariable();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclExpression#getInitialisedVariable
	 * <em>Initialised Variable</em>}' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Initialised Variable</em>' container reference.
	 * @see #getInitialisedVariable()
	 * @generated
	 */
	void setInitialisedVariable(VariableDeclaration value);

} // OclExpression
