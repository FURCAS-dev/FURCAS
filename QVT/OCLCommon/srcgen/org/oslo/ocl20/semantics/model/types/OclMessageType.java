/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.types;

import org.oslo.ocl20.semantics.OclVisitor;

import org.oslo.ocl20.semantics.bridge.Classifier;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Ocl Message Type</b></em>'.
 * <!-- end-user-doc -->
 * 
 * @see org.oslo.ocl20.semantics.model.types.TypesPackage#getOclMessageType()
 * @model
 * @generated
 */
public interface OclMessageType extends Classifier {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model dataType="org.oslo.ocl20.semantics.Object"
	 *        dataDataType="org.oslo.ocl20.semantics.Object" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='return ((OclVisitor)visitor).visit(this,data);'"
	 * @generated
	 */
	Object accept(OclVisitor visitor, Object data);

} // OclMessageType
