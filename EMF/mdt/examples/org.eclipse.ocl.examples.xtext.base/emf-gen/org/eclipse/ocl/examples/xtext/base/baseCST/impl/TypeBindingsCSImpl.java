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
 * $Id: TypeBindingsCSImpl.java,v 1.2 2010/05/24 08:59:31 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST.impl;

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
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundDocumentCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.util.Signature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Bindings CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypeBindingsCSImpl#getBoundDocument <em>Bound Document</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypeBindingsCSImpl#getBindings <em>Bindings</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.TypeBindingsCSImpl#getNested <em>Nested</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeBindingsCSImpl extends ElementCSImpl implements TypeBindingsCS {
	/**
	 * The cached value of the '{@link #getBoundDocument() <em>Bound Document</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundDocument()
	 * @generated
	 * @ordered
	 */
	protected BoundDocumentCS boundDocument;

	/**
	 * The cached value of the '{@link #getBindings() <em>Bindings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeBindingCS> bindings;

	/**
	 * The cached value of the '{@link #getNested() <em>Nested</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNested()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeBindingsCS> nested;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeBindingsCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaseCSTPackage.Literals.TYPE_BINDINGS_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoundDocumentCS getBoundDocument() {
		return boundDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundDocument(BoundDocumentCS newBoundDocument) {
		BoundDocumentCS oldBoundDocument = boundDocument;
		boundDocument = newBoundDocument;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.TYPE_BINDINGS_CS__BOUND_DOCUMENT, oldBoundDocument, boundDocument));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeBindingCS> getBindings() {
		if (bindings == null) {
			bindings = new EObjectContainmentEList<TypeBindingCS>(TypeBindingCS.class, this, BaseCSTPackage.TYPE_BINDINGS_CS__BINDINGS);
		}
		return bindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeBindingsCS> getNested() {
		if (nested == null) {
			nested = new EObjectContainmentEList<TypeBindingsCS>(TypeBindingsCS.class, this, BaseCSTPackage.TYPE_BINDINGS_CS__NESTED);
		}
		return nested;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BaseCSTPackage.TYPE_BINDINGS_CS__BINDINGS:
				return ((InternalEList<?>)getBindings()).basicRemove(otherEnd, msgs);
			case BaseCSTPackage.TYPE_BINDINGS_CS__NESTED:
				return ((InternalEList<?>)getNested()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BaseCSTPackage.TYPE_BINDINGS_CS__BOUND_DOCUMENT:
				return getBoundDocument();
			case BaseCSTPackage.TYPE_BINDINGS_CS__BINDINGS:
				return getBindings();
			case BaseCSTPackage.TYPE_BINDINGS_CS__NESTED:
				return getNested();
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
			case BaseCSTPackage.TYPE_BINDINGS_CS__BOUND_DOCUMENT:
				setBoundDocument((BoundDocumentCS)newValue);
				return;
			case BaseCSTPackage.TYPE_BINDINGS_CS__BINDINGS:
				getBindings().clear();
				getBindings().addAll((Collection<? extends TypeBindingCS>)newValue);
				return;
			case BaseCSTPackage.TYPE_BINDINGS_CS__NESTED:
				getNested().clear();
				getNested().addAll((Collection<? extends TypeBindingsCS>)newValue);
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
			case BaseCSTPackage.TYPE_BINDINGS_CS__BOUND_DOCUMENT:
				setBoundDocument((BoundDocumentCS)null);
				return;
			case BaseCSTPackage.TYPE_BINDINGS_CS__BINDINGS:
				getBindings().clear();
				return;
			case BaseCSTPackage.TYPE_BINDINGS_CS__NESTED:
				getNested().clear();
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
			case BaseCSTPackage.TYPE_BINDINGS_CS__BOUND_DOCUMENT:
				return boundDocument != null;
			case BaseCSTPackage.TYPE_BINDINGS_CS__BINDINGS:
				return bindings != null && !bindings.isEmpty();
			case BaseCSTPackage.TYPE_BINDINGS_CS__NESTED:
				return nested != null && !nested.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append('<');
		String prefix = ""; //$NON-NLS-1$
		for (TypeBindingCS csTypeBinding : getBindings()) {
			s.append(prefix);
			s.append(csTypeBinding.toString());
			prefix = ","; //$NON-NLS-1$
		}
		s.append(">"); //$NON-NLS-1$
		return s.toString();
	}

	@Override
	public void getSignature(Signature signature, TypeBindingsCS typeBindings) {
		signature.append('<');
		String prefix = ""; //$NON-NLS-1$
		for (TypeBindingCS csTypeBinding : getBindings()) {
			signature.append(prefix);
			signature.appendElement(csTypeBinding, typeBindings);
			prefix = ","; //$NON-NLS-1$
		}
		signature.append("> "); //$NON-NLS-1$
	}
} //TypeBindingsCSImpl
