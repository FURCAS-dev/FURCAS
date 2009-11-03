/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvtrelation;

import de.ikv.medini.qvt.model.qvtbase.Pattern;
import de.ikv.medini.qvt.model.qvtbase.Rule;

import de.ikv.medini.qvt.qvt.QvtVisitor;

import org.eclipse.emf.common.util.EList;
import org.oslo.ocl20.semantics.OclVisitor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvtrelation.Relation#isIsTopLevel <em>Is Top Level</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtrelation.Relation#getWhere <em>Where</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtrelation.Relation#getVariable <em>Variable</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtrelation.Relation#getOperationalImpl <em>Operational Impl</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtrelation.Relation#getWhen <em>When</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.qvt.model.qvtrelation.QvtRelationPackage#getRelation()
 * @model
 * @generated
 */
public interface Relation extends Rule {
	/**
	 * Returns the value of the '<em><b>Is Top Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Top Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Top Level</em>' attribute.
	 * @see #setIsTopLevel(boolean)
	 * @see de.ikv.medini.qvt.model.qvtrelation.QvtRelationPackage#getRelation_IsTopLevel()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsTopLevel();

	/**
	 * Sets the value of the '{@link de.ikv.medini.qvt.model.qvtrelation.Relation#isIsTopLevel <em>Is Top Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Top Level</em>' attribute.
	 * @see #isIsTopLevel()
	 * @generated
	 */
	void setIsTopLevel(boolean value);

	/**
	 * Returns the value of the '<em><b>Where</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.ikv.medini.qvt.model.qvtbase.Pattern#getWhereOwner <em>Where Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Where</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Where</em>' containment reference.
	 * @see #setWhere(Pattern)
	 * @see de.ikv.medini.qvt.model.qvtrelation.QvtRelationPackage#getRelation_Where()
	 * @see de.ikv.medini.qvt.model.qvtbase.Pattern#getWhereOwner
	 * @model opposite="whereOwner" containment="true"
	 * @generated
	 */
	Pattern getWhere();

	/**
	 * Sets the value of the '{@link de.ikv.medini.qvt.model.qvtrelation.Relation#getWhere <em>Where</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Where</em>' containment reference.
	 * @see #getWhere()
	 * @generated
	 */
	void setWhere(Pattern value);

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference list.
	 * The list contents are of type {@link org.oslo.ocl20.semantics.model.expressions.VariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference list.
	 * @see de.ikv.medini.qvt.model.qvtrelation.QvtRelationPackage#getRelation_Variable()
	 * @model type="org.oslo.ocl20.semantics.model.expressions.VariableDeclaration" containment="true"
	 * @generated
	 */
	EList getVariable();

	/**
	 * Returns the value of the '<em><b>Operational Impl</b></em>' reference list.
	 * The list contents are of type {@link de.ikv.medini.qvt.model.qvtrelation.RelationImplementation}.
	 * It is bidirectional and its opposite is '{@link de.ikv.medini.qvt.model.qvtrelation.RelationImplementation#getRelation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operational Impl</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operational Impl</em>' reference list.
	 * @see de.ikv.medini.qvt.model.qvtrelation.QvtRelationPackage#getRelation_OperationalImpl()
	 * @see de.ikv.medini.qvt.model.qvtrelation.RelationImplementation#getRelation
	 * @model type="de.ikv.medini.qvt.model.qvtrelation.RelationImplementation" opposite="relation"
	 * @generated
	 */
	EList getOperationalImpl();

	/**
	 * Returns the value of the '<em><b>When</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.ikv.medini.qvt.model.qvtbase.Pattern#getWhenOwner <em>When Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>When</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>When</em>' containment reference.
	 * @see #setWhen(Pattern)
	 * @see de.ikv.medini.qvt.model.qvtrelation.QvtRelationPackage#getRelation_When()
	 * @see de.ikv.medini.qvt.model.qvtbase.Pattern#getWhenOwner
	 * @model opposite="whenOwner" containment="true"
	 * @generated
	 */
	Pattern getWhen();

	/**
	 * Sets the value of the '{@link de.ikv.medini.qvt.model.qvtrelation.Relation#getWhen <em>When</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>When</em>' containment reference.
	 * @see #getWhen()
	 * @generated
	 */
	void setWhen(Pattern value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((QvtVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // Relation
