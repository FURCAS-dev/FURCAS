/**
 * <copyright>
 * </copyright>
 *
 * $Id: ThisImpl.java,v 1.2 2011/03/05 21:52:04 auhl Exp $
 */
package dataaccess.expressions.impl;

import dataaccess.expressions.ExpressionsPackage;
import dataaccess.expressions.This;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>This</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ThisImpl extends ExpressionImpl implements This {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThisImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.THIS;
	}

} //ThisImpl
