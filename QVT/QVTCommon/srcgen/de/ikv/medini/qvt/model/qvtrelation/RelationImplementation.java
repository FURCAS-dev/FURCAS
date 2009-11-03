/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvtrelation;

import de.ikv.medini.qvt.model.qvtbase.TypedModel;

import org.oslo.ocl20.semantics.OclVisitor;
import de.ikv.medini.qvt.qvt.QvtVisitor;

import org.oslo.ocl20.semantics.bridge.Element;
import org.oslo.ocl20.semantics.bridge.Operation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation Implementation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvtrelation.RelationImplementation#getRelation <em>Relation</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtrelation.RelationImplementation#getImpl <em>Impl</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtrelation.RelationImplementation#getInDirectionOf <em>In Direction Of</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.ikv.medini.qvt.model.qvtrelation.QvtRelationPackage#getRelationImplementation()
 * @model
 * @generated
 */
public interface RelationImplementation extends Element {
	/**
	 * Returns the value of the '<em><b>Relation</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.ikv.medini.qvt.model.qvtrelation.Relation#getOperationalImpl <em>Operational Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation</em>' reference.
	 * @see #setRelation(Relation)
	 * @see de.ikv.medini.qvt.model.qvtrelation.QvtRelationPackage#getRelationImplementation_Relation()
	 * @see de.ikv.medini.qvt.model.qvtrelation.Relation#getOperationalImpl
	 * @model opposite="operationalImpl"
	 * @generated
	 */
	Relation getRelation();

	/**
	 * Sets the value of the '{@link de.ikv.medini.qvt.model.qvtrelation.RelationImplementation#getRelation <em>Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relation</em>' reference.
	 * @see #getRelation()
	 * @generated
	 */
	void setRelation(Relation value);

	/**
	 * Returns the value of the '<em><b>Impl</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Impl</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Impl</em>' reference.
	 * @see #setImpl(Operation)
	 * @see de.ikv.medini.qvt.model.qvtrelation.QvtRelationPackage#getRelationImplementation_Impl()
	 * @model required="true"
	 * @generated
	 */
	Operation getImpl();

	/**
	 * Sets the value of the '{@link de.ikv.medini.qvt.model.qvtrelation.RelationImplementation#getImpl <em>Impl</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Impl</em>' reference.
	 * @see #getImpl()
	 * @generated
	 */
	void setImpl(Operation value);

	/**
	 * Returns the value of the '<em><b>In Direction Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Direction Of</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Direction Of</em>' reference.
	 * @see #setInDirectionOf(TypedModel)
	 * @see de.ikv.medini.qvt.model.qvtrelation.QvtRelationPackage#getRelationImplementation_InDirectionOf()
	 * @model required="true"
	 * @generated
	 */
	TypedModel getInDirectionOf();

	/**
	 * Sets the value of the '{@link de.ikv.medini.qvt.model.qvtrelation.RelationImplementation#getInDirectionOf <em>In Direction Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Direction Of</em>' reference.
	 * @see #getInDirectionOf()
	 * @generated
	 */
	void setInDirectionOf(TypedModel value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.oslo.ocl20.semantics.Object" dataDataType="org.oslo.ocl20.semantics.Object"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return ((QvtVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // RelationImplementation
