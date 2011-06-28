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
 * $Id: ContextCSImpl.java,v 1.2 2011/01/24 21:31:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.LibraryCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.NamedElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ContextCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.util.EssentialOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.ContextCSImpl#getOwnedImport <em>Owned Import</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.ContextCSImpl#getOwnedLibrary <em>Owned Library</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.ContextCSImpl#getOwnedExpression <em>Owned Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContextCSImpl extends NamedElementCSImpl implements ContextCS
{
	/**
	 * The cached value of the '{@link #getOwnedImport() <em>Owned Import</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedImport()
	 * @generated
	 * @ordered
	 */
	protected EList<ImportCS> ownedImport;
	/**
	 * The cached value of the '{@link #getOwnedLibrary() <em>Owned Library</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedLibrary()
	 * @generated
	 * @ordered
	 */
	protected EList<LibraryCS> ownedLibrary;
	/**
	 * The cached value of the '{@link #getOwnedExpression() <em>Owned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedExpression()
	 * @generated
	 * @ordered
	 */
	protected ExpCS ownedExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContextCSImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return EssentialOCLCSTPackage.Literals.CONTEXT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ImportCS> getOwnedImport()
	{
		if (ownedImport == null)
		{
			ownedImport = new EObjectContainmentEList<ImportCS>(ImportCS.class, this, EssentialOCLCSTPackage.CONTEXT_CS__OWNED_IMPORT);
		}
		return ownedImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LibraryCS> getOwnedLibrary()
	{
		if (ownedLibrary == null)
		{
			ownedLibrary = new EObjectContainmentEList<LibraryCS>(LibraryCS.class, this, EssentialOCLCSTPackage.CONTEXT_CS__OWNED_LIBRARY);
		}
		return ownedLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpCS getOwnedExpression()
	{
		return ownedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedExpression(ExpCS newOwnedExpression, NotificationChain msgs)
	{
		ExpCS oldOwnedExpression = ownedExpression;
		ownedExpression = newOwnedExpression;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSTPackage.CONTEXT_CS__OWNED_EXPRESSION, oldOwnedExpression, newOwnedExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnedExpression(ExpCS newOwnedExpression)
	{
		if (newOwnedExpression != ownedExpression)
		{
			NotificationChain msgs = null;
			if (ownedExpression != null)
				msgs = ((InternalEObject)ownedExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSTPackage.CONTEXT_CS__OWNED_EXPRESSION, null, msgs);
			if (newOwnedExpression != null)
				msgs = ((InternalEObject)newOwnedExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSTPackage.CONTEXT_CS__OWNED_EXPRESSION, null, msgs);
			msgs = basicSetOwnedExpression(newOwnedExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSTPackage.CONTEXT_CS__OWNED_EXPRESSION, newOwnedExpression, newOwnedExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case EssentialOCLCSTPackage.CONTEXT_CS__OWNED_IMPORT:
				return ((InternalEList<?>)getOwnedImport()).basicRemove(otherEnd, msgs);
			case EssentialOCLCSTPackage.CONTEXT_CS__OWNED_LIBRARY:
				return ((InternalEList<?>)getOwnedLibrary()).basicRemove(otherEnd, msgs);
			case EssentialOCLCSTPackage.CONTEXT_CS__OWNED_EXPRESSION:
				return basicSetOwnedExpression(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case EssentialOCLCSTPackage.CONTEXT_CS__OWNED_IMPORT:
				return getOwnedImport();
			case EssentialOCLCSTPackage.CONTEXT_CS__OWNED_LIBRARY:
				return getOwnedLibrary();
			case EssentialOCLCSTPackage.CONTEXT_CS__OWNED_EXPRESSION:
				return getOwnedExpression();
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
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case EssentialOCLCSTPackage.CONTEXT_CS__OWNED_IMPORT:
				getOwnedImport().clear();
				getOwnedImport().addAll((Collection<? extends ImportCS>)newValue);
				return;
			case EssentialOCLCSTPackage.CONTEXT_CS__OWNED_LIBRARY:
				getOwnedLibrary().clear();
				getOwnedLibrary().addAll((Collection<? extends LibraryCS>)newValue);
				return;
			case EssentialOCLCSTPackage.CONTEXT_CS__OWNED_EXPRESSION:
				setOwnedExpression((ExpCS)newValue);
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
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case EssentialOCLCSTPackage.CONTEXT_CS__OWNED_IMPORT:
				getOwnedImport().clear();
				return;
			case EssentialOCLCSTPackage.CONTEXT_CS__OWNED_LIBRARY:
				getOwnedLibrary().clear();
				return;
			case EssentialOCLCSTPackage.CONTEXT_CS__OWNED_EXPRESSION:
				setOwnedExpression((ExpCS)null);
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
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case EssentialOCLCSTPackage.CONTEXT_CS__OWNED_IMPORT:
				return ownedImport != null && !ownedImport.isEmpty();
			case EssentialOCLCSTPackage.CONTEXT_CS__OWNED_LIBRARY:
				return ownedLibrary != null && !ownedLibrary.isEmpty();
			case EssentialOCLCSTPackage.CONTEXT_CS__OWNED_EXPRESSION:
				return ownedExpression != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == RootCS.class)
		{
			switch (derivedFeatureID)
			{
				case EssentialOCLCSTPackage.CONTEXT_CS__OWNED_IMPORT: return BaseCSTPackage.ROOT_CS__OWNED_IMPORT;
				case EssentialOCLCSTPackage.CONTEXT_CS__OWNED_LIBRARY: return BaseCSTPackage.ROOT_CS__OWNED_LIBRARY;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == RootCS.class)
		{
			switch (baseFeatureID)
			{
				case BaseCSTPackage.ROOT_CS__OWNED_IMPORT: return EssentialOCLCSTPackage.CONTEXT_CS__OWNED_IMPORT;
				case BaseCSTPackage.ROOT_CS__OWNED_LIBRARY: return EssentialOCLCSTPackage.CONTEXT_CS__OWNED_LIBRARY;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <R, C> R accept(BaseCSVisitor<R, C> visitor) {
		return (R) visitor.getAdapter(EssentialOCLCSVisitor.class).visitContextCS(this);
	}
} //ContextCSImpl
