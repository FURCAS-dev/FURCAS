/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.contexts;

import org.oslo.ocl20.semantics.OclVisitor;

import org.oslo.ocl20.semantics.bridge.Classifier;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Classifier Context Decl</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.contexts.ClassifierContextDecl#getReferredClassifier
 * <em>Referred Classifier</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.model.contexts.ContextsPackage#getClassifierContextDecl()
 * @model
 * @generated
 */
public interface ClassifierContextDecl extends ContextDeclaration {
	/**
	 * Returns the value of the '<em><b>Referred Classifier</b></em>' reference. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Referred Classifier</em>' reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Referred Classifier</em>' reference.
	 * @see #setReferredClassifier(Classifier)
	 * @see org.oslo.ocl20.semantics.model.contexts.ContextsPackage#getClassifierContextDecl_ReferredClassifier()
	 * @model required="true"
	 * @generated
	 */
	Classifier getReferredClassifier();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.contexts.ClassifierContextDecl#getReferredClassifier
	 * <em>Referred Classifier</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Referred Classifier</em>' reference.
	 * @see #getReferredClassifier()
	 * @generated
	 */
	void setReferredClassifier(Classifier value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object"
	 *        dataDataType="org.oslo.ocl20.semantics.Object" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // ClassifierContextDecl
