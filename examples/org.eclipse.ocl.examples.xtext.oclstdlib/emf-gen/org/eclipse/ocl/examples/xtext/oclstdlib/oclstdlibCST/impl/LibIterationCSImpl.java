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
 * $Id: LibIterationCSImpl.java,v 1.5 2011/02/15 10:37:09 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.OperationCSImpl;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.JavaImplementationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTPackage;
import org.eclipse.ocl.examples.xtext.oclstdlib.util.OCLstdlibCSVisitor;
import org.eclipse.xtext.common.types.JvmType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lib Iteration CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIterationCSImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIterationCSImpl#getOwnedIterator <em>Owned Iterator</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIterationCSImpl#getOwnedAccumulator <em>Owned Accumulator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LibIterationCSImpl
		extends OperationCSImpl
		implements LibIterationCS {

	/**
	 * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementation()
	 * @generated
	 * @ordered
	 */
	protected JvmType implementation;

	/**
	 * The cached value of the '{@link #getOwnedIterator() <em>Owned Iterator</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedIterator()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterCS> ownedIterator;

	/**
	 * The cached value of the '{@link #getOwnedAccumulator() <em>Owned Accumulator</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAccumulator()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterCS> ownedAccumulator;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibIterationCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCLstdlibCSTPackage.Literals.LIB_ITERATION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmType getImplementation() {
		if (implementation != null && implementation.eIsProxy())
		{
			InternalEObject oldImplementation = (InternalEObject)implementation;
			implementation = (JvmType)eResolveProxy(oldImplementation);
			if (implementation != oldImplementation)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OCLstdlibCSTPackage.LIB_ITERATION_CS__IMPLEMENTATION, oldImplementation, implementation));
			}
		}
		return implementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JvmType basicGetImplementation() {
		return implementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementation(JvmType newImplementation) {
		JvmType oldImplementation = implementation;
		implementation = newImplementation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLstdlibCSTPackage.LIB_ITERATION_CS__IMPLEMENTATION, oldImplementation, implementation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterCS> getOwnedIterator() {
		if (ownedIterator == null)
		{
			ownedIterator = new EObjectContainmentEList<ParameterCS>(ParameterCS.class, this, OCLstdlibCSTPackage.LIB_ITERATION_CS__OWNED_ITERATOR);
		}
		return ownedIterator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterCS> getOwnedAccumulator() {
		if (ownedAccumulator == null)
		{
			ownedAccumulator = new EObjectContainmentEList<ParameterCS>(ParameterCS.class, this, OCLstdlibCSTPackage.LIB_ITERATION_CS__OWNED_ACCUMULATOR);
		}
		return ownedAccumulator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID)
		{
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__OWNED_ITERATOR:
				return ((InternalEList<?>)getOwnedIterator()).basicRemove(otherEnd, msgs);
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__OWNED_ACCUMULATOR:
				return ((InternalEList<?>)getOwnedAccumulator()).basicRemove(otherEnd, msgs);
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
		switch (featureID)
		{
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__IMPLEMENTATION:
				if (resolve) return getImplementation();
				return basicGetImplementation();
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__OWNED_ITERATOR:
				return getOwnedIterator();
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__OWNED_ACCUMULATOR:
				return getOwnedAccumulator();
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
		switch (featureID)
		{
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__IMPLEMENTATION:
				setImplementation((JvmType)newValue);
				return;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__OWNED_ITERATOR:
				getOwnedIterator().clear();
				getOwnedIterator().addAll((Collection<? extends ParameterCS>)newValue);
				return;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__OWNED_ACCUMULATOR:
				getOwnedAccumulator().clear();
				getOwnedAccumulator().addAll((Collection<? extends ParameterCS>)newValue);
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
		switch (featureID)
		{
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__IMPLEMENTATION:
				setImplementation((JvmType)null);
				return;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__OWNED_ITERATOR:
				getOwnedIterator().clear();
				return;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__OWNED_ACCUMULATOR:
				getOwnedAccumulator().clear();
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
		switch (featureID)
		{
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__IMPLEMENTATION:
				return implementation != null;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__OWNED_ITERATOR:
				return ownedIterator != null && !ownedIterator.isEmpty();
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__OWNED_ACCUMULATOR:
				return ownedAccumulator != null && !ownedAccumulator.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == JavaImplementationCS.class)
		{
			switch (derivedFeatureID)
			{
				case OCLstdlibCSTPackage.LIB_ITERATION_CS__IMPLEMENTATION: return OCLstdlibCSTPackage.JAVA_IMPLEMENTATION_CS__IMPLEMENTATION;
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
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == JavaImplementationCS.class)
		{
			switch (baseFeatureID)
			{
				case OCLstdlibCSTPackage.JAVA_IMPLEMENTATION_CS__IMPLEMENTATION: return OCLstdlibCSTPackage.LIB_ITERATION_CS__IMPLEMENTATION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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

	@SuppressWarnings("unchecked")
	@Override
	public <R, C> R accept(BaseCSVisitor<R, C> visitor) {
		return (R) visitor.getAdapter(OCLstdlibCSVisitor.class)
			.visitLibIterationCS(this);
	}
} //LibIterationCSImpl
