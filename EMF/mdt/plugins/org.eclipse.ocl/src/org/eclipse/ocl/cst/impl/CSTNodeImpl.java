/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2009 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bugs 243976, 207365
 *
 * </copyright>
 *
 * $Id: CSTNodeImpl.java,v 1.6 2009/12/27 15:49:52 asanchez Exp $
 */
package org.eclipse.ocl.cst.impl;

import lpg.runtime.IToken;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CSTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.impl.CSTNodeImpl#getStartOffset <em>Start Offset</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.CSTNodeImpl#getEndOffset <em>End Offset</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.CSTNodeImpl#getStartToken <em>Start Token</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.CSTNodeImpl#getEndToken <em>End Token</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.impl.CSTNodeImpl#getAst <em>Ast</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class CSTNodeImpl
		extends EObjectImpl
		implements CSTNode {

	/**
	 * The default value of the '{@link #getStartOffset() <em>Start Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartOffset()
	 * @generated
	 * @ordered
	 */
	protected static final int START_OFFSET_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStartOffset() <em>Start Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartOffset()
	 * @generated
	 * @ordered
	 */
	protected int startOffset = START_OFFSET_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndOffset() <em>End Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndOffset()
	 * @generated
	 * @ordered
	 */
	protected static final int END_OFFSET_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEndOffset() <em>End Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndOffset()
	 * @generated
	 * @ordered
	 */
	protected int endOffset = END_OFFSET_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartToken() <em>Start Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @see #getStartToken()
	 * @generated
	 * @ordered
	 */
	protected static final IToken START_TOKEN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartToken() <em>Start Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @see #getStartToken()
	 * @generated
	 * @ordered
	 */
	protected IToken startToken = START_TOKEN_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndToken() <em>End Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @see #getEndToken()
	 * @generated
	 * @ordered
	 */
	protected static final IToken END_TOKEN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEndToken() <em>End Token</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @see #getEndToken()
	 * @generated
	 * @ordered
	 */
	protected IToken endToken = END_TOKEN_EDEFAULT;

	/**
	 * The default value of the '{@link #getAst() <em>Ast</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @see #getAst()
	 * @generated
	 * @ordered
	 */
	protected static final Object AST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAst() <em>Ast</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @see #getAst()
	 * @generated
	 * @ordered
	 */
	protected Object ast = AST_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CSTNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CSTPackage.Literals.CST_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartOffset() {
		return startOffset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartOffset(int newStartOffset) {
		int oldStartOffset = startOffset;
		startOffset = newStartOffset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				CSTPackage.CST_NODE__START_OFFSET, oldStartOffset, startOffset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEndOffset() {
		return endOffset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndOffset(int newEndOffset) {
		int oldEndOffset = endOffset;
		endOffset = newEndOffset;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				CSTPackage.CST_NODE__END_OFFSET, oldEndOffset, endOffset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IToken getStartToken() {
		return startToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartToken(IToken newStartToken) {
		IToken oldStartToken = startToken;
		startToken = newStartToken;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				CSTPackage.CST_NODE__START_TOKEN, oldStartToken, startToken));
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IToken getEndToken() {
		return endToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndToken(IToken newEndToken) {
		IToken oldEndToken = endToken;
		endToken = newEndToken;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				CSTPackage.CST_NODE__END_TOKEN, oldEndToken, endToken));
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getAst() {
		return ast;
	}

	/**
	 * <!-- begin-user-doc -->
	 * @since 1.3
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAst(Object newAst) {
		Object oldAst = ast;
		ast = newAst;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
				CSTPackage.CST_NODE__AST, oldAst, ast));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CSTPackage.CST_NODE__START_OFFSET :
				return getStartOffset();
			case CSTPackage.CST_NODE__END_OFFSET :
				return getEndOffset();
			case CSTPackage.CST_NODE__START_TOKEN :
				return getStartToken();
			case CSTPackage.CST_NODE__END_TOKEN :
				return getEndToken();
			case CSTPackage.CST_NODE__AST :
				return getAst();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CSTPackage.CST_NODE__START_OFFSET :
				setStartOffset((Integer) newValue);
				return;
			case CSTPackage.CST_NODE__END_OFFSET :
				setEndOffset((Integer) newValue);
				return;
			case CSTPackage.CST_NODE__START_TOKEN :
				setStartToken((IToken) newValue);
				return;
			case CSTPackage.CST_NODE__END_TOKEN :
				setEndToken((IToken) newValue);
				return;
			case CSTPackage.CST_NODE__AST :
				setAst(newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CSTPackage.CST_NODE__START_OFFSET :
				setStartOffset(START_OFFSET_EDEFAULT);
				return;
			case CSTPackage.CST_NODE__END_OFFSET :
				setEndOffset(END_OFFSET_EDEFAULT);
				return;
			case CSTPackage.CST_NODE__START_TOKEN :
				setStartToken(START_TOKEN_EDEFAULT);
				return;
			case CSTPackage.CST_NODE__END_TOKEN :
				setEndToken(END_TOKEN_EDEFAULT);
				return;
			case CSTPackage.CST_NODE__AST :
				setAst(AST_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CSTPackage.CST_NODE__START_OFFSET :
				return startOffset != START_OFFSET_EDEFAULT;
			case CSTPackage.CST_NODE__END_OFFSET :
				return endOffset != END_OFFSET_EDEFAULT;
			case CSTPackage.CST_NODE__START_TOKEN :
				return START_TOKEN_EDEFAULT == null
					? startToken != null
					: !START_TOKEN_EDEFAULT.equals(startToken);
			case CSTPackage.CST_NODE__END_TOKEN :
				return END_TOKEN_EDEFAULT == null
					? endToken != null
					: !END_TOKEN_EDEFAULT.equals(endToken);
			case CSTPackage.CST_NODE__AST :
				return AST_EDEFAULT == null
					? ast != null
					: !AST_EDEFAULT.equals(ast);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (startOffset: "); //$NON-NLS-1$
		result.append(startOffset);
		result.append(", endOffset: "); //$NON-NLS-1$
		result.append(endOffset);
		result.append(", startToken: "); //$NON-NLS-1$
		result.append(startToken);
		result.append(", endToken: "); //$NON-NLS-1$
		result.append(endToken);
		result.append(", ast: "); //$NON-NLS-1$
		result.append(ast);
		result.append(')');
		return result.toString();
	}

} //CSTNodeImpl
