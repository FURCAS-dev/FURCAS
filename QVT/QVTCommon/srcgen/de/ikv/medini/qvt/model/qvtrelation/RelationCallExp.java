/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvtrelation;

import de.ikv.medini.qvt.qvt.QvtVisitor;

import org.eclipse.emf.common.util.EList;

import org.oslo.ocl20.semantics.OclVisitor;
import org.oslo.ocl20.semantics.model.expressions.OclExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvtrelation.RelationCallExp#getReferredRelation <em>Referred Relation</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtrelation.RelationCallExp#getArgument <em>Argument</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.qvt.model.qvtrelation.QvtRelationPackage#getRelationCallExp()
 * @model
 * @generated
 */
public interface RelationCallExp extends OclExpression {
	/**
	 * Returns the value of the '<em><b>Referred Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Relation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Relation</em>' reference.
	 * @see #setReferredRelation(Relation)
	 * @see de.ikv.medini.qvt.model.qvtrelation.QvtRelationPackage#getRelationCallExp_ReferredRelation()
	 * @model
	 * @generated
	 */
	Relation getReferredRelation();

	/**
	 * Sets the value of the '{@link de.ikv.medini.qvt.model.qvtrelation.RelationCallExp#getReferredRelation <em>Referred Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Relation</em>' reference.
	 * @see #getReferredRelation()
	 * @generated
	 */
	void setReferredRelation(Relation value);

	/**
	 * Returns the value of the '<em><b>Argument</b></em>' containment reference list.
	 * The list contents are of type {@link org.oslo.ocl20.semantics.model.expressions.OclExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument</em>' containment reference list.
	 * @see de.ikv.medini.qvt.model.qvtrelation.QvtRelationPackage#getRelationCallExp_Argument()
	 * @model type="org.oslo.ocl20.semantics.model.expressions.OclExpression" containment="true"
	 * @generated
	 */
	EList getArgument();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((QvtVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // RelationCallExp
