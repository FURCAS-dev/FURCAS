/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.qvt.impl;

import org.eclipse.emf.ecore.EClass;

import org.oslo.ocl20.syntax.ast.Visitor;

import org.oslo.ocl20.syntax.ast.impl.VisitableImpl;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.oslo.ocl20.syntax.ast.qvt.GeneralDomainAS;
import org.oslo.ocl20.syntax.ast.qvt.QvtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>General Domain AS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class GeneralDomainASImpl extends VisitableImpl implements GeneralDomainAS {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeneralDomainASImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return org.oslo.ocl20.syntax.ast.qvt.Package.Literals.GENERAL_DOMAIN_AS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object accept(Visitor visitor, Object data) {
		return ((org.oslo.ocl20.semantics.analyser.OclSemanticAnalyserVisitorImpl)visitor).visit(this,data);
	}

} //GeneralDomainASImpl
