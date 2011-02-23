/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.test.mm.testcases.case025.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.query2.test.mm.testcases.case008.A8;
import org.eclipse.emf.query2.test.mm.testcases.case008.Case008Package;
import org.eclipse.emf.query2.test.mm.testcases.case008.E8;
import org.eclipse.emf.query2.test.mm.testcases.case008.S8;
import org.eclipse.emf.query2.test.mm.testcases.case008.T8;
import org.eclipse.emf.query2.test.mm.testcases.case008.V8;

import org.eclipse.emf.query2.test.mm.testcases.case025.Case025Package;
import org.eclipse.emf.query2.test.mm.testcases.case025.D25;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>D25</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case025.impl.D25Impl#getOneEnumerationE <em>One Enumeration E</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case025.impl.D25Impl#getOneStructureS <em>One Structure S</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case025.impl.D25Impl#getOneStructureT <em>One Structure T</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case025.impl.D25Impl#getOneStructureV <em>One Structure V</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case025.impl.D25Impl#getManyEnumerationE <em>Many Enumeration E</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case025.impl.D25Impl#getManyStructureS <em>Many Structure S</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class D25Impl extends A25Impl implements D25 {
	/**
	 * The default value of the '{@link #getOneEnumerationE() <em>One Enumeration E</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOneEnumerationE()
	 * @generated
	 * @ordered
	 */
	protected static final E8 ONE_ENUMERATION_E_EDEFAULT = E8.LABEL1;

	/**
	 * The cached value of the '{@link #getOneEnumerationE() <em>One Enumeration E</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOneEnumerationE()
	 * @generated
	 * @ordered
	 */
	protected E8 oneEnumerationE = ONE_ENUMERATION_E_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOneStructureS() <em>One Structure S</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOneStructureS()
	 * @generated
	 * @ordered
	 */
	protected S8 oneStructureS;

	/**
	 * The cached value of the '{@link #getOneStructureT() <em>One Structure T</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOneStructureT()
	 * @generated
	 * @ordered
	 */
	protected T8 oneStructureT;

	/**
	 * The cached value of the '{@link #getOneStructureV() <em>One Structure V</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOneStructureV()
	 * @generated
	 * @ordered
	 */
	protected V8 oneStructureV;

	/**
	 * The cached value of the '{@link #getManyEnumerationE() <em>Many Enumeration E</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManyEnumerationE()
	 * @generated
	 * @ordered
	 */
	protected EList<E8> manyEnumerationE;

	/**
	 * The cached value of the '{@link #getManyStructureS() <em>Many Structure S</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManyStructureS()
	 * @generated
	 * @ordered
	 */
	protected EList<S8> manyStructureS;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected D25Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case025Package.Literals.D25;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public E8 getOneEnumerationE() {
		return oneEnumerationE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOneEnumerationE(E8 newOneEnumerationE) {
		E8 oldOneEnumerationE = oneEnumerationE;
		oneEnumerationE = newOneEnumerationE == null ? ONE_ENUMERATION_E_EDEFAULT : newOneEnumerationE;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case025Package.D25__ONE_ENUMERATION_E, oldOneEnumerationE, oneEnumerationE));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public S8 getOneStructureS() {
		if (oneStructureS != null && oneStructureS.eIsProxy()) {
			InternalEObject oldOneStructureS = (InternalEObject)oneStructureS;
			oneStructureS = (S8)eResolveProxy(oldOneStructureS);
			if (oneStructureS != oldOneStructureS) {
				InternalEObject newOneStructureS = (InternalEObject)oneStructureS;
				NotificationChain msgs = oldOneStructureS.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case025Package.D25__ONE_STRUCTURE_S, null, null);
				if (newOneStructureS.eInternalContainer() == null) {
					msgs = newOneStructureS.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case025Package.D25__ONE_STRUCTURE_S, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case025Package.D25__ONE_STRUCTURE_S, oldOneStructureS, oneStructureS));
			}
		}
		return oneStructureS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public S8 basicGetOneStructureS() {
		return oneStructureS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOneStructureS(S8 newOneStructureS, NotificationChain msgs) {
		S8 oldOneStructureS = oneStructureS;
		oneStructureS = newOneStructureS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case025Package.D25__ONE_STRUCTURE_S, oldOneStructureS, newOneStructureS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOneStructureS(S8 newOneStructureS) {
		if (newOneStructureS != oneStructureS) {
			NotificationChain msgs = null;
			if (oneStructureS != null)
				msgs = ((InternalEObject)oneStructureS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case025Package.D25__ONE_STRUCTURE_S, null, msgs);
			if (newOneStructureS != null)
				msgs = ((InternalEObject)newOneStructureS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case025Package.D25__ONE_STRUCTURE_S, null, msgs);
			msgs = basicSetOneStructureS(newOneStructureS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case025Package.D25__ONE_STRUCTURE_S, newOneStructureS, newOneStructureS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public T8 getOneStructureT() {
		if (oneStructureT != null && oneStructureT.eIsProxy()) {
			InternalEObject oldOneStructureT = (InternalEObject)oneStructureT;
			oneStructureT = (T8)eResolveProxy(oldOneStructureT);
			if (oneStructureT != oldOneStructureT) {
				InternalEObject newOneStructureT = (InternalEObject)oneStructureT;
				NotificationChain msgs = oldOneStructureT.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case025Package.D25__ONE_STRUCTURE_T, null, null);
				if (newOneStructureT.eInternalContainer() == null) {
					msgs = newOneStructureT.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case025Package.D25__ONE_STRUCTURE_T, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case025Package.D25__ONE_STRUCTURE_T, oldOneStructureT, oneStructureT));
			}
		}
		return oneStructureT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public T8 basicGetOneStructureT() {
		return oneStructureT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOneStructureT(T8 newOneStructureT, NotificationChain msgs) {
		T8 oldOneStructureT = oneStructureT;
		oneStructureT = newOneStructureT;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case025Package.D25__ONE_STRUCTURE_T, oldOneStructureT, newOneStructureT);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOneStructureT(T8 newOneStructureT) {
		if (newOneStructureT != oneStructureT) {
			NotificationChain msgs = null;
			if (oneStructureT != null)
				msgs = ((InternalEObject)oneStructureT).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case025Package.D25__ONE_STRUCTURE_T, null, msgs);
			if (newOneStructureT != null)
				msgs = ((InternalEObject)newOneStructureT).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case025Package.D25__ONE_STRUCTURE_T, null, msgs);
			msgs = basicSetOneStructureT(newOneStructureT, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case025Package.D25__ONE_STRUCTURE_T, newOneStructureT, newOneStructureT));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public V8 getOneStructureV() {
		if (oneStructureV != null && oneStructureV.eIsProxy()) {
			InternalEObject oldOneStructureV = (InternalEObject)oneStructureV;
			oneStructureV = (V8)eResolveProxy(oldOneStructureV);
			if (oneStructureV != oldOneStructureV) {
				InternalEObject newOneStructureV = (InternalEObject)oneStructureV;
				NotificationChain msgs = oldOneStructureV.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case025Package.D25__ONE_STRUCTURE_V, null, null);
				if (newOneStructureV.eInternalContainer() == null) {
					msgs = newOneStructureV.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case025Package.D25__ONE_STRUCTURE_V, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case025Package.D25__ONE_STRUCTURE_V, oldOneStructureV, oneStructureV));
			}
		}
		return oneStructureV;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public V8 basicGetOneStructureV() {
		return oneStructureV;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOneStructureV(V8 newOneStructureV, NotificationChain msgs) {
		V8 oldOneStructureV = oneStructureV;
		oneStructureV = newOneStructureV;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case025Package.D25__ONE_STRUCTURE_V, oldOneStructureV, newOneStructureV);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOneStructureV(V8 newOneStructureV) {
		if (newOneStructureV != oneStructureV) {
			NotificationChain msgs = null;
			if (oneStructureV != null)
				msgs = ((InternalEObject)oneStructureV).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case025Package.D25__ONE_STRUCTURE_V, null, msgs);
			if (newOneStructureV != null)
				msgs = ((InternalEObject)newOneStructureV).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case025Package.D25__ONE_STRUCTURE_V, null, msgs);
			msgs = basicSetOneStructureV(newOneStructureV, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case025Package.D25__ONE_STRUCTURE_V, newOneStructureV, newOneStructureV));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<E8> getManyEnumerationE() {
		if (manyEnumerationE == null) {
			manyEnumerationE = new EDataTypeEList<E8>(E8.class, this, Case025Package.D25__MANY_ENUMERATION_E);
		}
		return manyEnumerationE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<S8> getManyStructureS() {
		if (manyStructureS == null) {
			manyStructureS = new EObjectContainmentEList.Resolving<S8>(S8.class, this, Case025Package.D25__MANY_STRUCTURE_S);
		}
		return manyStructureS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Case025Package.D25__ONE_STRUCTURE_S:
				return basicSetOneStructureS(null, msgs);
			case Case025Package.D25__ONE_STRUCTURE_T:
				return basicSetOneStructureT(null, msgs);
			case Case025Package.D25__ONE_STRUCTURE_V:
				return basicSetOneStructureV(null, msgs);
			case Case025Package.D25__MANY_STRUCTURE_S:
				return ((InternalEList<?>)getManyStructureS()).basicRemove(otherEnd, msgs);
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
			case Case025Package.D25__ONE_ENUMERATION_E:
				return getOneEnumerationE();
			case Case025Package.D25__ONE_STRUCTURE_S:
				if (resolve) return getOneStructureS();
				return basicGetOneStructureS();
			case Case025Package.D25__ONE_STRUCTURE_T:
				if (resolve) return getOneStructureT();
				return basicGetOneStructureT();
			case Case025Package.D25__ONE_STRUCTURE_V:
				if (resolve) return getOneStructureV();
				return basicGetOneStructureV();
			case Case025Package.D25__MANY_ENUMERATION_E:
				return getManyEnumerationE();
			case Case025Package.D25__MANY_STRUCTURE_S:
				return getManyStructureS();
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
			case Case025Package.D25__ONE_ENUMERATION_E:
				setOneEnumerationE((E8)newValue);
				return;
			case Case025Package.D25__ONE_STRUCTURE_S:
				setOneStructureS((S8)newValue);
				return;
			case Case025Package.D25__ONE_STRUCTURE_T:
				setOneStructureT((T8)newValue);
				return;
			case Case025Package.D25__ONE_STRUCTURE_V:
				setOneStructureV((V8)newValue);
				return;
			case Case025Package.D25__MANY_ENUMERATION_E:
				getManyEnumerationE().clear();
				getManyEnumerationE().addAll((Collection<? extends E8>)newValue);
				return;
			case Case025Package.D25__MANY_STRUCTURE_S:
				getManyStructureS().clear();
				getManyStructureS().addAll((Collection<? extends S8>)newValue);
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
			case Case025Package.D25__ONE_ENUMERATION_E:
				setOneEnumerationE(ONE_ENUMERATION_E_EDEFAULT);
				return;
			case Case025Package.D25__ONE_STRUCTURE_S:
				setOneStructureS((S8)null);
				return;
			case Case025Package.D25__ONE_STRUCTURE_T:
				setOneStructureT((T8)null);
				return;
			case Case025Package.D25__ONE_STRUCTURE_V:
				setOneStructureV((V8)null);
				return;
			case Case025Package.D25__MANY_ENUMERATION_E:
				getManyEnumerationE().clear();
				return;
			case Case025Package.D25__MANY_STRUCTURE_S:
				getManyStructureS().clear();
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
			case Case025Package.D25__ONE_ENUMERATION_E:
				return oneEnumerationE != ONE_ENUMERATION_E_EDEFAULT;
			case Case025Package.D25__ONE_STRUCTURE_S:
				return oneStructureS != null;
			case Case025Package.D25__ONE_STRUCTURE_T:
				return oneStructureT != null;
			case Case025Package.D25__ONE_STRUCTURE_V:
				return oneStructureV != null;
			case Case025Package.D25__MANY_ENUMERATION_E:
				return manyEnumerationE != null && !manyEnumerationE.isEmpty();
			case Case025Package.D25__MANY_STRUCTURE_S:
				return manyStructureS != null && !manyStructureS.isEmpty();
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
		if (baseClass == A8.class) {
			switch (derivedFeatureID) {
				case Case025Package.D25__ONE_ENUMERATION_E: return Case008Package.A8__ONE_ENUMERATION_E;
				case Case025Package.D25__ONE_STRUCTURE_S: return Case008Package.A8__ONE_STRUCTURE_S;
				case Case025Package.D25__ONE_STRUCTURE_T: return Case008Package.A8__ONE_STRUCTURE_T;
				case Case025Package.D25__ONE_STRUCTURE_V: return Case008Package.A8__ONE_STRUCTURE_V;
				case Case025Package.D25__MANY_ENUMERATION_E: return Case008Package.A8__MANY_ENUMERATION_E;
				case Case025Package.D25__MANY_STRUCTURE_S: return Case008Package.A8__MANY_STRUCTURE_S;
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
		if (baseClass == A8.class) {
			switch (baseFeatureID) {
				case Case008Package.A8__ONE_ENUMERATION_E: return Case025Package.D25__ONE_ENUMERATION_E;
				case Case008Package.A8__ONE_STRUCTURE_S: return Case025Package.D25__ONE_STRUCTURE_S;
				case Case008Package.A8__ONE_STRUCTURE_T: return Case025Package.D25__ONE_STRUCTURE_T;
				case Case008Package.A8__ONE_STRUCTURE_V: return Case025Package.D25__ONE_STRUCTURE_V;
				case Case008Package.A8__MANY_ENUMERATION_E: return Case025Package.D25__MANY_ENUMERATION_E;
				case Case008Package.A8__MANY_STRUCTURE_S: return Case025Package.D25__MANY_STRUCTURE_S;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (oneEnumerationE: "); //$NON-NLS-1$
		result.append(oneEnumerationE);
		result.append(", manyEnumerationE: "); //$NON-NLS-1$
		result.append(manyEnumerationE);
		result.append(')');
		return result.toString();
	}

} //D25Impl
