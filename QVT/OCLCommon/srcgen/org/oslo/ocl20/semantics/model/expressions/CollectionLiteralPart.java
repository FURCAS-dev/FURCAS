/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions;

import org.oslo.ocl20.semantics.OclVisitor;
import org.oslo.ocl20.semantics.SemanticsVisitable;

import org.oslo.ocl20.semantics.bridge.Classifier;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Collection Literal Part</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link org.oslo.ocl20.semantics.model.expressions.CollectionLiteralPart#getCollectionLiteralExp
 * <em>Collection Literal Exp</em>}</li>
 * <li>{@link org.oslo.ocl20.semantics.model.expressions.CollectionLiteralPart#getType <em>Type
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getCollectionLiteralPart()
 * @model
 * @generated
 */
public interface CollectionLiteralPart extends SemanticsVisitable {
	/**
	 * Returns the value of the '<em><b>Collection Literal Exp</b></em>' container reference. It is
	 * bidirectional and its opposite is '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CollectionLiteralExp#getParts
	 * <em>Parts</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Literal Exp</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Collection Literal Exp</em>' container reference.
	 * @see #setCollectionLiteralExp(CollectionLiteralExp)
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getCollectionLiteralPart_CollectionLiteralExp()
	 * @see org.oslo.ocl20.semantics.model.expressions.CollectionLiteralExp#getParts
	 * @model opposite="parts" required="true" transient="false"
	 * @generated
	 */
	CollectionLiteralExp getCollectionLiteralExp();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CollectionLiteralPart#getCollectionLiteralExp
	 * <em>Collection Literal Exp</em>}' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Collection Literal Exp</em>' container reference.
	 * @see #getCollectionLiteralExp()
	 * @generated
	 */
	void setCollectionLiteralExp(CollectionLiteralExp value);

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
	 * @see org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage#getCollectionLiteralPart_Type()
	 * @model required="true"
	 * @generated
	 */
	Classifier getType();

	/**
	 * Sets the value of the '
	 * {@link org.oslo.ocl20.semantics.model.expressions.CollectionLiteralPart#getType
	 * <em>Type</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Classifier value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object"
	 *        dataDataType="org.oslo.ocl20.semantics.Object" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // CollectionLiteralPart
