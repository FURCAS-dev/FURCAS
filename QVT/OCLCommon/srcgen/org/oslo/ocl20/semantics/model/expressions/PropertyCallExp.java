/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions;

import org.eclipse.emf.common.util.EList;

import org.oslo.ocl20.semantics.OclVisitor;

import org.oslo.ocl20.semantics.bridge.Property;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Property Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.PropertyCallExp#getQualifiers <em>
 * Qualifiers</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.PropertyCallExp#getReferredProperty <em>
 * Referred Property</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getPropertyCallExp()
 * @model
 * @generated
 */
public interface PropertyCallExp extends ModelPropertyCallExp {
	/**
	 * Returns the value of the '<em><b>Qualifiers</b></em>' containment reference list. The list
	 * contents are of type {@link org.oslo.ocl20.semantics.model.expressions.OclExpression}. It is
	 * bidirectional and its opposite is '
	 * {@link org.oslo.ocl20.semantics.model.expressions.OclExpression#getPropertyCallExp
	 * <em>Property Call Exp</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualifiers</em>' containment reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Qualifiers</em>' containment reference list.
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getPropertyCallExp_Qualifiers()
	 * @see org.oslo.ocl20.semantics.model.expressions.OclExpression#getPropertyCallExp
	 * @model type="org.oslo.ocl20.semantics.model.expressions.OclExpression"
	 *        opposite="propertyCallExp" containment="true"
	 * @generated
	 */
	EList getQualifiers();

	/**
	 * Returns the value of the '<em><b>Referred Property</b></em>' reference. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Referred Property</em>' reference isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Referred Property</em>' reference.
	 * @see #setReferredProperty(Property)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getPropertyCallExp_ReferredProperty()
	 * @model required="true"
	 * @generated
	 */
	Property getReferredProperty();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.PropertyCallExp#getReferredProperty
	 * <em>Referred Property</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Referred Property</em>' reference.
	 * @see #getReferredProperty()
	 * @generated
	 */
	void setReferredProperty(Property value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object"
	 *        dataDataType="org.oslo.ocl20.semantics.Object" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // PropertyCallExp
