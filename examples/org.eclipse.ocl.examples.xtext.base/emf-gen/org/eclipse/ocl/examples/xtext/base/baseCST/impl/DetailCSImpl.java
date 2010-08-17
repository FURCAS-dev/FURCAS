/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: DetailCSImpl.java,v 1.4 2010/08/17 18:53:39 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.util.Signature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Detail CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.DetailCSImpl#getIdName <em>Id Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.DetailCSImpl#getStringName <em>String Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.DetailCSImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DetailCSImpl extends ElementCSImpl implements DetailCS {
	/**
	 * The default value of the '{@link #getIdName() <em>Id Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdName()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdName() <em>Id Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdName()
	 * @generated
	 * @ordered
	 */
	protected String idName = ID_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getStringName() <em>String Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringName()
	 * @generated
	 * @ordered
	 */
	protected static final String STRING_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStringName() <em>String Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringName()
	 * @generated
	 * @ordered
	 */
	protected String stringName = STRING_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected EList<String> value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DetailCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaseCSTPackage.Literals.DETAIL_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdName() {
		return idName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdName(String newIdName) {
		String oldIdName = idName;
		idName = newIdName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.DETAIL_CS__ID_NAME, oldIdName, idName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStringName() {
		return stringName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStringName(String newStringName) {
		String oldStringName = stringName;
		stringName = newStringName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.DETAIL_CS__STRING_NAME, oldStringName, stringName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getValue() {
		if (value == null) {
			value = new EDataTypeUniqueEList<String>(String.class, this, BaseCSTPackage.DETAIL_CS__VALUE);
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BaseCSTPackage.DETAIL_CS__ID_NAME:
				return getIdName();
			case BaseCSTPackage.DETAIL_CS__STRING_NAME:
				return getStringName();
			case BaseCSTPackage.DETAIL_CS__VALUE:
				return getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BaseCSTPackage.DETAIL_CS__ID_NAME:
				setIdName((String)newValue);
				return;
			case BaseCSTPackage.DETAIL_CS__STRING_NAME:
				setStringName((String)newValue);
				return;
			case BaseCSTPackage.DETAIL_CS__VALUE:
				getValue().clear();
				getValue().addAll((Collection<? extends String>)newValue);
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
			case BaseCSTPackage.DETAIL_CS__ID_NAME:
				setIdName(ID_NAME_EDEFAULT);
				return;
			case BaseCSTPackage.DETAIL_CS__STRING_NAME:
				setStringName(STRING_NAME_EDEFAULT);
				return;
			case BaseCSTPackage.DETAIL_CS__VALUE:
				getValue().clear();
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
			case BaseCSTPackage.DETAIL_CS__ID_NAME:
				return ID_NAME_EDEFAULT == null ? idName != null : !ID_NAME_EDEFAULT.equals(idName);
			case BaseCSTPackage.DETAIL_CS__STRING_NAME:
				return STRING_NAME_EDEFAULT == null ? stringName != null : !STRING_NAME_EDEFAULT.equals(stringName);
			case BaseCSTPackage.DETAIL_CS__VALUE:
				return value != null && !value.isEmpty();
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
		return super.toString();
	}

	@Override
	public void getSignature(Signature signature, TypeBindingsCS typeBindings) {
		signature.appendParent(this, "/", typeBindings); //$NON-NLS-1$
		signature.append(getIdName());
	}
} //DetailCSImpl
