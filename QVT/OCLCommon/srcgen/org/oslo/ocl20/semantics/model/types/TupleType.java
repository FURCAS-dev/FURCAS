/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.types;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;

import org.oslo.ocl20.semantics.OclVisitor;

import org.oslo.ocl20.semantics.bridge.DataType;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Tuple Type</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.oslo.ocl20.semantics.model.types.TupleType#getPartType <em>Part Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.oslo.ocl20.semantics.model.types.TypesPackage#getTupleType()
 * @model
 * @generated
 */
public interface TupleType extends DataType {
	/**
	 * Returns the value of the '<em><b>Part Type</b></em>' reference list. The list contents are of
	 * type {@link org.oslo.ocl20.semantics.model.expressions.VariableDeclaration}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Type</em>' reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Part Type</em>' reference list.
	 * @see org.oslo.ocl20.semantics.model.types.TypesPackage#getTupleType_PartType()
	 * @model type="org.oslo.ocl20.semantics.model.expressions.VariableDeclaration"
	 * @generated
	 */
	EList getPartType();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" dataType="org.oslo.ocl20.semantics.List" many="false"
	 * @generated
	 */
	List getNames();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" dataType="org.oslo.ocl20.semantics.List" many="false"
	 * @generated
	 */
	List getTypes();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model namesDataType="org.oslo.ocl20.semantics.Set"
	 * @generated
	 */
	TupleType project(Set names);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model
	 * @generated
	 */
	TupleType join(TupleType tupletype);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object"
	 *        dataDataType="org.oslo.ocl20.semantics.Object" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // TupleType
