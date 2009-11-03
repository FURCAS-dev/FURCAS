/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.bridge;

import org.oslo.ocl20.semantics.OclVisitor;

import org.oslo.ocl20.semantics.model.types.OclAnyType;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Primitive</b></em>'. <!--
 * end-user-doc -->
 * 
 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#getPrimitive()
 * @model
 * @generated
 */
public interface Primitive extends OclAnyType {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object"
	 *        dataDataType="org.oslo.ocl20.semantics.Object" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // Primitive
