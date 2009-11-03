/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.bridge.impl;

import org.eclipse.emf.ecore.EClass;

import org.oslo.ocl20.semantics.OclVisitor;

import org.oslo.ocl20.semantics.bridge.BridgePackage;
import org.oslo.ocl20.semantics.bridge.Primitive;

import org.oslo.ocl20.semantics.model.types.impl.OclAnyTypeImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Primitive</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class PrimitiveImpl extends OclAnyTypeImpl implements Primitive {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PrimitiveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return BridgePackage.Literals.PRIMITIVE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object accept(OclVisitor visitor, Object data) {
		return ((OclVisitor) visitor).visit(this, data);
	}

} // PrimitiveImpl
