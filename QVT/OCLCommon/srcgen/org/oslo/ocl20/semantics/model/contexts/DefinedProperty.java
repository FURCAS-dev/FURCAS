/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.contexts;

import org.oslo.ocl20.semantics.OclVisitor;

import org.oslo.ocl20.semantics.bridge.Property;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Defined Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.contexts.DefinedProperty#getDefinition <em>Definition
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.model.contexts.ContextsPackage#getDefinedProperty()
 * @model
 * @generated
 */
public interface DefinedProperty extends Property {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(Constraint)
	 * @see org.oslo.ocl20.semantics.model.contexts.ContextsPackage#getDefinedProperty_Definition()
	 * @model required="true"
	 * @generated
	 */
	Constraint getDefinition();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.contexts.DefinedProperty#getDefinition
	 * <em>Definition</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(Constraint value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object"
	 *        dataDataType="org.oslo.ocl20.semantics.Object" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // DefinedProperty
