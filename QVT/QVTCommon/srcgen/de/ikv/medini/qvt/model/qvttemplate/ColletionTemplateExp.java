/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvttemplate;

import org.eclipse.emf.common.util.EList;

import org.oslo.ocl20.semantics.model.expressions.OclExpression;

import org.oslo.ocl20.semantics.model.types.CollectionType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Colletion Template Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvttemplate.ColletionTemplateExp#getMatch <em>Match</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvttemplate.ColletionTemplateExp#getPart <em>Part</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvttemplate.ColletionTemplateExp#getRefferedCollectionType <em>Reffered Collection Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.qvt.model.qvttemplate.QvtTemplatePackage#getColletionTemplateExp()
 * @model
 * @generated
 */
public interface ColletionTemplateExp extends TemplateExp {
	/**
	 * Returns the value of the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Match</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Match</em>' reference.
	 * @see #setMatch(OclExpression)
	 * @see de.ikv.medini.qvt.model.qvttemplate.QvtTemplatePackage#getColletionTemplateExp_Match()
	 * @model
	 * @generated
	 */
	OclExpression getMatch();

	/**
	 * Sets the value of the '{@link de.ikv.medini.qvt.model.qvttemplate.ColletionTemplateExp#getMatch <em>Match</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Match</em>' reference.
	 * @see #getMatch()
	 * @generated
	 */
	void setMatch(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Part</b></em>' containment reference list.
	 * The list contents are of type {@link org.oslo.ocl20.semantics.model.expressions.OclExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' containment reference list.
	 * @see de.ikv.medini.qvt.model.qvttemplate.QvtTemplatePackage#getColletionTemplateExp_Part()
	 * @model type="org.oslo.ocl20.semantics.model.expressions.OclExpression" containment="true"
	 * @generated
	 */
	EList getPart();

	/**
	 * Returns the value of the '<em><b>Reffered Collection Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reffered Collection Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reffered Collection Type</em>' reference.
	 * @see #setRefferedCollectionType(CollectionType)
	 * @see de.ikv.medini.qvt.model.qvttemplate.QvtTemplatePackage#getColletionTemplateExp_RefferedCollectionType()
	 * @model
	 * @generated
	 */
	CollectionType getRefferedCollectionType();

	/**
	 * Sets the value of the '{@link de.ikv.medini.qvt.model.qvttemplate.ColletionTemplateExp#getRefferedCollectionType <em>Reffered Collection Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reffered Collection Type</em>' reference.
	 * @see #getRefferedCollectionType()
	 * @generated
	 */
	void setRefferedCollectionType(CollectionType value);

} // ColletionTemplateExp
