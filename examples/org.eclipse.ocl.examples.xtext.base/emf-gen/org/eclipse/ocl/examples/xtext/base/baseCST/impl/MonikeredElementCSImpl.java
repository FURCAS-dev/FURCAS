/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: MonikeredElementCSImpl.java,v 1.2 2011/01/24 20:59:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.baseCST.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2Moniker;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Monikered Element CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.MonikeredElementCSImpl#getMoniker <em>Moniker</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MonikeredElementCSImpl extends ModelElementCSImpl implements MonikeredElementCS {
	/**
	 * The default value of the '{@link #getMoniker() <em>Moniker</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMoniker()
	 * @generated
	 * @ordered
	 */
	protected static final String MONIKER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMoniker() <em>Moniker</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMoniker()
	 * @generated
	 * @ordered
	 */
	protected String moniker = MONIKER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MonikeredElementCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaseCSTPackage.Literals.MONIKERED_ELEMENT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getDescription()
	{
		return eClass().getName() + " : " + getMoniker(); //$NON-NLS-1$
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getMoniker() {
		if (moniker == null) {
			moniker = CS2Moniker.toString(this);
		}
		return moniker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean hasMoniker() {
		return moniker != MONIKER_EDEFAULT;
	}

	/**
	 * The moniker may be reset for test purposes. It should always recompute the
	 * same value.
	 * @generated NOT
	 */
	public void resetMoniker() {
		moniker = MONIKER_EDEFAULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
			case BaseCSTPackage.MONIKERED_ELEMENT_CS__MONIKER:
				return getMoniker();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
			case BaseCSTPackage.MONIKERED_ELEMENT_CS__MONIKER:
				return MONIKER_EDEFAULT == null ? moniker != null : !MONIKER_EDEFAULT.equals(moniker);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		ICompositeNode parserNode = NodeModelUtils.getNode(this);
		if (parserNode != null) {
			return parserNode.getText().trim();
		}
		return CS2Moniker.toString(this);
	}

	@Override
	public <R, C> R accept(BaseCSVisitor<R, C> visitor) {
		return visitor.visitMonikeredElementCS(this);
	}
} //NameableElementCSImpl
