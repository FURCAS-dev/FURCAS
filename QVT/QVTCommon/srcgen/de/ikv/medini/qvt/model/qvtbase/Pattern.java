/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvtbase;

import de.ikv.medini.qvt.model.qvtrelation.Relation;

import de.ikv.medini.qvt.qvt.QvtVisitor;

import org.eclipse.emf.common.util.EList;

import org.oslo.ocl20.semantics.OclVisitor;
import org.oslo.ocl20.semantics.bridge.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.Pattern#getWhereOwner <em>Where Owner</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.Pattern#getWhenOwner <em>When Owner</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.Pattern#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.Pattern#getBindsTo <em>Binds To</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getPattern()
 * @model
 * @generated
 */
public interface Pattern extends Element {
	/**
	 * Returns the value of the '<em><b>Where Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.ikv.medini.qvt.model.qvtrelation.Relation#getWhere <em>Where</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Where Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Where Owner</em>' container reference.
	 * @see #setWhereOwner(Relation)
	 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getPattern_WhereOwner()
	 * @see de.ikv.medini.qvt.model.qvtrelation.Relation#getWhere
	 * @model opposite="where" required="true" transient="false"
	 * @generated
	 */
	Relation getWhereOwner();

	/**
	 * Sets the value of the '{@link de.ikv.medini.qvt.model.qvtbase.Pattern#getWhereOwner <em>Where Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Where Owner</em>' container reference.
	 * @see #getWhereOwner()
	 * @generated
	 */
	void setWhereOwner(Relation value);

	/**
	 * Returns the value of the '<em><b>When Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.ikv.medini.qvt.model.qvtrelation.Relation#getWhen <em>When</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>When Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>When Owner</em>' container reference.
	 * @see #setWhenOwner(Relation)
	 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getPattern_WhenOwner()
	 * @see de.ikv.medini.qvt.model.qvtrelation.Relation#getWhen
	 * @model opposite="when" transient="false"
	 * @generated
	 */
	Relation getWhenOwner();

	/**
	 * Sets the value of the '{@link de.ikv.medini.qvt.model.qvtbase.Pattern#getWhenOwner <em>When Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>When Owner</em>' container reference.
	 * @see #getWhenOwner()
	 * @generated
	 */
	void setWhenOwner(Relation value);

	/**
	 * Returns the value of the '<em><b>Predicate</b></em>' containment reference list.
	 * The list contents are of type {@link de.ikv.medini.qvt.model.qvtbase.Predicate}.
	 * It is bidirectional and its opposite is '{@link de.ikv.medini.qvt.model.qvtbase.Predicate#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicate</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicate</em>' containment reference list.
	 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getPattern_Predicate()
	 * @see de.ikv.medini.qvt.model.qvtbase.Predicate#getPattern
	 * @model type="de.ikv.medini.qvt.model.qvtbase.Predicate" opposite="pattern" containment="true"
	 * @generated
	 */
	EList getPredicate();

	/**
	 * Returns the value of the '<em><b>Binds To</b></em>' reference list.
	 * The list contents are of type {@link org.oslo.ocl20.semantics.model.expressions.VariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binds To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binds To</em>' reference list.
	 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#getPattern_BindsTo()
	 * @model type="org.oslo.ocl20.semantics.model.expressions.VariableDeclaration"
	 * @generated
	 */
	EList getBindsTo();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((QvtVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // Pattern
