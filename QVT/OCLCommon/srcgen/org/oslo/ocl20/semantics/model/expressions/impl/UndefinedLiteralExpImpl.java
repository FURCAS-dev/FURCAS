/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.expressions.impl;

import org.eclipse.emf.ecore.EClass;

import org.oslo.ocl20.semantics.OclVisitor;

import org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage;
import org.oslo.ocl20.semantics.model.expressions.UndefinedLiteralExp;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Undefined Literal Exp</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class UndefinedLiteralExpImpl extends LiteralExpImpl implements UndefinedLiteralExp {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected UndefinedLiteralExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.UNDEFINED_LITERAL_EXP;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object accept(OclVisitor visitor, Object data) {
		return ((OclVisitor) visitor).visit(this, data);
	}

} // UndefinedLiteralExpImpl
