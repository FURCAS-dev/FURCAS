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
package org.eclipse.emf.query2.test.mm.testcases.case004.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.query2.test.mm.testcases.case004.A4;
import org.eclipse.emf.query2.test.mm.testcases.case004.B4;
import org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>A4</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4Impl#getOnePrimitive <em>One Primitive</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4Impl#getOnePrimitiveOptional <em>One Primitive Optional</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4Impl#getOnePrimitiveNotChangeable <em>One Primitive Not Changeable</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4Impl#getManyPrimitive <em>Many Primitive</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4Impl#getManyPrimitiveDouble <em>Many Primitive Double</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4Impl#getManyPrimitiveUnique <em>Many Primitive Unique</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4Impl#getManyPrimitiveOptional <em>Many Primitive Optional</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4Impl#getManyPrimitiveNotChangeable <em>Many Primitive Not Changeable</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4Impl#getManyPrimitiveOrdered <em>Many Primitive Ordered</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4Impl#getManyPrimitiveOrderedUnique <em>Many Primitive Ordered Unique</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4Impl#getManyPrimitiveOrderedNotChangeable <em>Many Primitive Ordered Not Changeable</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4Impl#getOneBChangeable <em>One BChangeable</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4Impl#getOneBNotChangeable <em>One BNot Changeable</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4Impl#getOneBOptional <em>One BOptional</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4Impl#getManyBs <em>Many Bs</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4Impl#getManyBsUnique <em>Many Bs Unique</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4Impl#getManyBsNotUnique <em>Many Bs Not Unique</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4Impl#getManyBsOrdered <em>Many Bs Ordered</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4Impl#getManyBsOrderedUnique <em>Many Bs Ordered Unique</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4Impl#getManyBsNotOrdered <em>Many Bs Not Ordered</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.A4Impl#getManyBsNotChangeable <em>Many Bs Not Changeable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class A4Impl extends EObjectImpl implements A4 {
	/**
	 * The default value of the '{@link #getOnePrimitive() <em>One Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnePrimitive()
	 * @generated
	 * @ordered
	 */
	protected static final String ONE_PRIMITIVE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOnePrimitive() <em>One Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnePrimitive()
	 * @generated
	 * @ordered
	 */
	protected String onePrimitive = ONE_PRIMITIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOnePrimitiveOptional() <em>One Primitive Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnePrimitiveOptional()
	 * @generated
	 * @ordered
	 */
	protected static final String ONE_PRIMITIVE_OPTIONAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOnePrimitiveOptional() <em>One Primitive Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnePrimitiveOptional()
	 * @generated
	 * @ordered
	 */
	protected String onePrimitiveOptional = ONE_PRIMITIVE_OPTIONAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getOnePrimitiveNotChangeable() <em>One Primitive Not Changeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnePrimitiveNotChangeable()
	 * @generated
	 * @ordered
	 */
	protected static final String ONE_PRIMITIVE_NOT_CHANGEABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOnePrimitiveNotChangeable() <em>One Primitive Not Changeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnePrimitiveNotChangeable()
	 * @generated
	 * @ordered
	 */
	protected String onePrimitiveNotChangeable = ONE_PRIMITIVE_NOT_CHANGEABLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getManyPrimitive() <em>Many Primitive</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManyPrimitive()
	 * @generated
	 * @ordered
	 */
	protected EList<String> manyPrimitive;

	/**
	 * The cached value of the '{@link #getManyPrimitiveDouble() <em>Many Primitive Double</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManyPrimitiveDouble()
	 * @generated
	 * @ordered
	 */
	protected EList<Double> manyPrimitiveDouble;

	/**
	 * The cached value of the '{@link #getManyPrimitiveUnique() <em>Many Primitive Unique</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManyPrimitiveUnique()
	 * @generated
	 * @ordered
	 */
	protected EList<String> manyPrimitiveUnique;

	/**
	 * The cached value of the '{@link #getManyPrimitiveOptional() <em>Many Primitive Optional</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManyPrimitiveOptional()
	 * @generated
	 * @ordered
	 */
	protected EList<String> manyPrimitiveOptional;

	/**
	 * The cached value of the '{@link #getManyPrimitiveNotChangeable() <em>Many Primitive Not Changeable</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManyPrimitiveNotChangeable()
	 * @generated
	 * @ordered
	 */
	protected EList<String> manyPrimitiveNotChangeable;

	/**
	 * The cached value of the '{@link #getManyPrimitiveOrdered() <em>Many Primitive Ordered</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManyPrimitiveOrdered()
	 * @generated
	 * @ordered
	 */
	protected EList<String> manyPrimitiveOrdered;

	/**
	 * The cached value of the '{@link #getManyPrimitiveOrderedUnique() <em>Many Primitive Ordered Unique</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManyPrimitiveOrderedUnique()
	 * @generated
	 * @ordered
	 */
	protected EList<String> manyPrimitiveOrderedUnique;

	/**
	 * The cached value of the '{@link #getManyPrimitiveOrderedNotChangeable() <em>Many Primitive Ordered Not Changeable</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManyPrimitiveOrderedNotChangeable()
	 * @generated
	 * @ordered
	 */
	protected EList<String> manyPrimitiveOrderedNotChangeable;

	/**
	 * The cached value of the '{@link #getOneBChangeable() <em>One BChangeable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOneBChangeable()
	 * @generated
	 * @ordered
	 */
	protected B4 oneBChangeable;

	/**
	 * The cached value of the '{@link #getOneBNotChangeable() <em>One BNot Changeable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOneBNotChangeable()
	 * @generated
	 * @ordered
	 */
	protected B4 oneBNotChangeable;

	/**
	 * The cached value of the '{@link #getOneBOptional() <em>One BOptional</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOneBOptional()
	 * @generated
	 * @ordered
	 */
	protected B4 oneBOptional;

	/**
	 * The cached value of the '{@link #getManyBs() <em>Many Bs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManyBs()
	 * @generated
	 * @ordered
	 */
	protected EList<B4> manyBs;

	/**
	 * The cached value of the '{@link #getManyBsUnique() <em>Many Bs Unique</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManyBsUnique()
	 * @generated
	 * @ordered
	 */
	protected EList<B4> manyBsUnique;

	/**
	 * The cached value of the '{@link #getManyBsNotUnique() <em>Many Bs Not Unique</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManyBsNotUnique()
	 * @generated
	 * @ordered
	 */
	protected EList<B4> manyBsNotUnique;

	/**
	 * The cached value of the '{@link #getManyBsOrdered() <em>Many Bs Ordered</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManyBsOrdered()
	 * @generated
	 * @ordered
	 */
	protected EList<B4> manyBsOrdered;

	/**
	 * The cached value of the '{@link #getManyBsOrderedUnique() <em>Many Bs Ordered Unique</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManyBsOrderedUnique()
	 * @generated
	 * @ordered
	 */
	protected EList<B4> manyBsOrderedUnique;

	/**
	 * The cached value of the '{@link #getManyBsNotOrdered() <em>Many Bs Not Ordered</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManyBsNotOrdered()
	 * @generated
	 * @ordered
	 */
	protected EList<B4> manyBsNotOrdered;

	/**
	 * The cached value of the '{@link #getManyBsNotChangeable() <em>Many Bs Not Changeable</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManyBsNotChangeable()
	 * @generated
	 * @ordered
	 */
	protected EList<B4> manyBsNotChangeable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A4Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case004Package.Literals.A4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOnePrimitive() {
		return onePrimitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnePrimitive(String newOnePrimitive) {
		String oldOnePrimitive = onePrimitive;
		onePrimitive = newOnePrimitive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.A4__ONE_PRIMITIVE, oldOnePrimitive, onePrimitive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOnePrimitiveOptional() {
		return onePrimitiveOptional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnePrimitiveOptional(String newOnePrimitiveOptional) {
		String oldOnePrimitiveOptional = onePrimitiveOptional;
		onePrimitiveOptional = newOnePrimitiveOptional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.A4__ONE_PRIMITIVE_OPTIONAL, oldOnePrimitiveOptional, onePrimitiveOptional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOnePrimitiveNotChangeable() {
		return onePrimitiveNotChangeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnePrimitiveNotChangeable(String newOnePrimitiveNotChangeable) {
		String oldOnePrimitiveNotChangeable = onePrimitiveNotChangeable;
		onePrimitiveNotChangeable = newOnePrimitiveNotChangeable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.A4__ONE_PRIMITIVE_NOT_CHANGEABLE, oldOnePrimitiveNotChangeable, onePrimitiveNotChangeable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getManyPrimitive() {
		if (manyPrimitive == null) {
			manyPrimitive = new EDataTypeEList<String>(String.class, this, Case004Package.A4__MANY_PRIMITIVE);
		}
		return manyPrimitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Double> getManyPrimitiveDouble() {
		if (manyPrimitiveDouble == null) {
			manyPrimitiveDouble = new EDataTypeEList<Double>(Double.class, this, Case004Package.A4__MANY_PRIMITIVE_DOUBLE);
		}
		return manyPrimitiveDouble;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getManyPrimitiveUnique() {
		if (manyPrimitiveUnique == null) {
			manyPrimitiveUnique = new EDataTypeUniqueEList<String>(String.class, this, Case004Package.A4__MANY_PRIMITIVE_UNIQUE);
		}
		return manyPrimitiveUnique;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getManyPrimitiveOptional() {
		if (manyPrimitiveOptional == null) {
			manyPrimitiveOptional = new EDataTypeEList<String>(String.class, this, Case004Package.A4__MANY_PRIMITIVE_OPTIONAL);
		}
		return manyPrimitiveOptional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getManyPrimitiveNotChangeable() {
		if (manyPrimitiveNotChangeable == null) {
			manyPrimitiveNotChangeable = new EDataTypeEList<String>(String.class, this, Case004Package.A4__MANY_PRIMITIVE_NOT_CHANGEABLE);
		}
		return manyPrimitiveNotChangeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getManyPrimitiveOrdered() {
		if (manyPrimitiveOrdered == null) {
			manyPrimitiveOrdered = new EDataTypeEList<String>(String.class, this, Case004Package.A4__MANY_PRIMITIVE_ORDERED);
		}
		return manyPrimitiveOrdered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getManyPrimitiveOrderedUnique() {
		if (manyPrimitiveOrderedUnique == null) {
			manyPrimitiveOrderedUnique = new EDataTypeUniqueEList<String>(String.class, this, Case004Package.A4__MANY_PRIMITIVE_ORDERED_UNIQUE);
		}
		return manyPrimitiveOrderedUnique;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getManyPrimitiveOrderedNotChangeable() {
		if (manyPrimitiveOrderedNotChangeable == null) {
			manyPrimitiveOrderedNotChangeable = new EDataTypeEList<String>(String.class, this, Case004Package.A4__MANY_PRIMITIVE_ORDERED_NOT_CHANGEABLE);
		}
		return manyPrimitiveOrderedNotChangeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B4 getOneBChangeable() {
		if (oneBChangeable != null && oneBChangeable.eIsProxy()) {
			InternalEObject oldOneBChangeable = (InternalEObject)oneBChangeable;
			oneBChangeable = (B4)eResolveProxy(oldOneBChangeable);
			if (oneBChangeable != oldOneBChangeable) {
				InternalEObject newOneBChangeable = (InternalEObject)oneBChangeable;
				NotificationChain msgs = oldOneBChangeable.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case004Package.A4__ONE_BCHANGEABLE, null, null);
				if (newOneBChangeable.eInternalContainer() == null) {
					msgs = newOneBChangeable.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case004Package.A4__ONE_BCHANGEABLE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case004Package.A4__ONE_BCHANGEABLE, oldOneBChangeable, oneBChangeable));
			}
		}
		return oneBChangeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B4 basicGetOneBChangeable() {
		return oneBChangeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOneBChangeable(B4 newOneBChangeable, NotificationChain msgs) {
		B4 oldOneBChangeable = oneBChangeable;
		oneBChangeable = newOneBChangeable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case004Package.A4__ONE_BCHANGEABLE, oldOneBChangeable, newOneBChangeable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOneBChangeable(B4 newOneBChangeable) {
		if (newOneBChangeable != oneBChangeable) {
			NotificationChain msgs = null;
			if (oneBChangeable != null)
				msgs = ((InternalEObject)oneBChangeable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case004Package.A4__ONE_BCHANGEABLE, null, msgs);
			if (newOneBChangeable != null)
				msgs = ((InternalEObject)newOneBChangeable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case004Package.A4__ONE_BCHANGEABLE, null, msgs);
			msgs = basicSetOneBChangeable(newOneBChangeable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.A4__ONE_BCHANGEABLE, newOneBChangeable, newOneBChangeable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B4 getOneBNotChangeable() {
		if (oneBNotChangeable != null && oneBNotChangeable.eIsProxy()) {
			InternalEObject oldOneBNotChangeable = (InternalEObject)oneBNotChangeable;
			oneBNotChangeable = (B4)eResolveProxy(oldOneBNotChangeable);
			if (oneBNotChangeable != oldOneBNotChangeable) {
				InternalEObject newOneBNotChangeable = (InternalEObject)oneBNotChangeable;
				NotificationChain msgs = oldOneBNotChangeable.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case004Package.A4__ONE_BNOT_CHANGEABLE, null, null);
				if (newOneBNotChangeable.eInternalContainer() == null) {
					msgs = newOneBNotChangeable.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case004Package.A4__ONE_BNOT_CHANGEABLE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case004Package.A4__ONE_BNOT_CHANGEABLE, oldOneBNotChangeable, oneBNotChangeable));
			}
		}
		return oneBNotChangeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B4 basicGetOneBNotChangeable() {
		return oneBNotChangeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOneBNotChangeable(B4 newOneBNotChangeable, NotificationChain msgs) {
		B4 oldOneBNotChangeable = oneBNotChangeable;
		oneBNotChangeable = newOneBNotChangeable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case004Package.A4__ONE_BNOT_CHANGEABLE, oldOneBNotChangeable, newOneBNotChangeable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOneBNotChangeable(B4 newOneBNotChangeable) {
		if (newOneBNotChangeable != oneBNotChangeable) {
			NotificationChain msgs = null;
			if (oneBNotChangeable != null)
				msgs = ((InternalEObject)oneBNotChangeable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case004Package.A4__ONE_BNOT_CHANGEABLE, null, msgs);
			if (newOneBNotChangeable != null)
				msgs = ((InternalEObject)newOneBNotChangeable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case004Package.A4__ONE_BNOT_CHANGEABLE, null, msgs);
			msgs = basicSetOneBNotChangeable(newOneBNotChangeable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.A4__ONE_BNOT_CHANGEABLE, newOneBNotChangeable, newOneBNotChangeable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B4 getOneBOptional() {
		if (oneBOptional != null && oneBOptional.eIsProxy()) {
			InternalEObject oldOneBOptional = (InternalEObject)oneBOptional;
			oneBOptional = (B4)eResolveProxy(oldOneBOptional);
			if (oneBOptional != oldOneBOptional) {
				InternalEObject newOneBOptional = (InternalEObject)oneBOptional;
				NotificationChain msgs = oldOneBOptional.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case004Package.A4__ONE_BOPTIONAL, null, null);
				if (newOneBOptional.eInternalContainer() == null) {
					msgs = newOneBOptional.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case004Package.A4__ONE_BOPTIONAL, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Case004Package.A4__ONE_BOPTIONAL, oldOneBOptional, oneBOptional));
			}
		}
		return oneBOptional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B4 basicGetOneBOptional() {
		return oneBOptional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOneBOptional(B4 newOneBOptional, NotificationChain msgs) {
		B4 oldOneBOptional = oneBOptional;
		oneBOptional = newOneBOptional;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Case004Package.A4__ONE_BOPTIONAL, oldOneBOptional, newOneBOptional);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOneBOptional(B4 newOneBOptional) {
		if (newOneBOptional != oneBOptional) {
			NotificationChain msgs = null;
			if (oneBOptional != null)
				msgs = ((InternalEObject)oneBOptional).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Case004Package.A4__ONE_BOPTIONAL, null, msgs);
			if (newOneBOptional != null)
				msgs = ((InternalEObject)newOneBOptional).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Case004Package.A4__ONE_BOPTIONAL, null, msgs);
			msgs = basicSetOneBOptional(newOneBOptional, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.A4__ONE_BOPTIONAL, newOneBOptional, newOneBOptional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<B4> getManyBs() {
		if (manyBs == null) {
			manyBs = new EObjectContainmentEList.Resolving<B4>(B4.class, this, Case004Package.A4__MANY_BS);
		}
		return manyBs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<B4> getManyBsUnique() {
		if (manyBsUnique == null) {
			manyBsUnique = new EObjectContainmentEList.Resolving<B4>(B4.class, this, Case004Package.A4__MANY_BS_UNIQUE);
		}
		return manyBsUnique;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<B4> getManyBsNotUnique() {
		if (manyBsNotUnique == null) {
			manyBsNotUnique = new EObjectContainmentEList.Resolving<B4>(B4.class, this, Case004Package.A4__MANY_BS_NOT_UNIQUE);
		}
		return manyBsNotUnique;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<B4> getManyBsOrdered() {
		if (manyBsOrdered == null) {
			manyBsOrdered = new EObjectContainmentEList.Resolving<B4>(B4.class, this, Case004Package.A4__MANY_BS_ORDERED);
		}
		return manyBsOrdered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<B4> getManyBsOrderedUnique() {
		if (manyBsOrderedUnique == null) {
			manyBsOrderedUnique = new EObjectContainmentEList.Resolving<B4>(B4.class, this, Case004Package.A4__MANY_BS_ORDERED_UNIQUE);
		}
		return manyBsOrderedUnique;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<B4> getManyBsNotOrdered() {
		if (manyBsNotOrdered == null) {
			manyBsNotOrdered = new EObjectContainmentEList.Resolving<B4>(B4.class, this, Case004Package.A4__MANY_BS_NOT_ORDERED);
		}
		return manyBsNotOrdered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<B4> getManyBsNotChangeable() {
		if (manyBsNotChangeable == null) {
			manyBsNotChangeable = new EObjectContainmentEList.Resolving<B4>(B4.class, this, Case004Package.A4__MANY_BS_NOT_CHANGEABLE);
		}
		return manyBsNotChangeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Case004Package.A4__ONE_BCHANGEABLE:
				return basicSetOneBChangeable(null, msgs);
			case Case004Package.A4__ONE_BNOT_CHANGEABLE:
				return basicSetOneBNotChangeable(null, msgs);
			case Case004Package.A4__ONE_BOPTIONAL:
				return basicSetOneBOptional(null, msgs);
			case Case004Package.A4__MANY_BS:
				return ((InternalEList<?>)getManyBs()).basicRemove(otherEnd, msgs);
			case Case004Package.A4__MANY_BS_UNIQUE:
				return ((InternalEList<?>)getManyBsUnique()).basicRemove(otherEnd, msgs);
			case Case004Package.A4__MANY_BS_NOT_UNIQUE:
				return ((InternalEList<?>)getManyBsNotUnique()).basicRemove(otherEnd, msgs);
			case Case004Package.A4__MANY_BS_ORDERED:
				return ((InternalEList<?>)getManyBsOrdered()).basicRemove(otherEnd, msgs);
			case Case004Package.A4__MANY_BS_ORDERED_UNIQUE:
				return ((InternalEList<?>)getManyBsOrderedUnique()).basicRemove(otherEnd, msgs);
			case Case004Package.A4__MANY_BS_NOT_ORDERED:
				return ((InternalEList<?>)getManyBsNotOrdered()).basicRemove(otherEnd, msgs);
			case Case004Package.A4__MANY_BS_NOT_CHANGEABLE:
				return ((InternalEList<?>)getManyBsNotChangeable()).basicRemove(otherEnd, msgs);
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
			case Case004Package.A4__ONE_PRIMITIVE:
				return getOnePrimitive();
			case Case004Package.A4__ONE_PRIMITIVE_OPTIONAL:
				return getOnePrimitiveOptional();
			case Case004Package.A4__ONE_PRIMITIVE_NOT_CHANGEABLE:
				return getOnePrimitiveNotChangeable();
			case Case004Package.A4__MANY_PRIMITIVE:
				return getManyPrimitive();
			case Case004Package.A4__MANY_PRIMITIVE_DOUBLE:
				return getManyPrimitiveDouble();
			case Case004Package.A4__MANY_PRIMITIVE_UNIQUE:
				return getManyPrimitiveUnique();
			case Case004Package.A4__MANY_PRIMITIVE_OPTIONAL:
				return getManyPrimitiveOptional();
			case Case004Package.A4__MANY_PRIMITIVE_NOT_CHANGEABLE:
				return getManyPrimitiveNotChangeable();
			case Case004Package.A4__MANY_PRIMITIVE_ORDERED:
				return getManyPrimitiveOrdered();
			case Case004Package.A4__MANY_PRIMITIVE_ORDERED_UNIQUE:
				return getManyPrimitiveOrderedUnique();
			case Case004Package.A4__MANY_PRIMITIVE_ORDERED_NOT_CHANGEABLE:
				return getManyPrimitiveOrderedNotChangeable();
			case Case004Package.A4__ONE_BCHANGEABLE:
				if (resolve) return getOneBChangeable();
				return basicGetOneBChangeable();
			case Case004Package.A4__ONE_BNOT_CHANGEABLE:
				if (resolve) return getOneBNotChangeable();
				return basicGetOneBNotChangeable();
			case Case004Package.A4__ONE_BOPTIONAL:
				if (resolve) return getOneBOptional();
				return basicGetOneBOptional();
			case Case004Package.A4__MANY_BS:
				return getManyBs();
			case Case004Package.A4__MANY_BS_UNIQUE:
				return getManyBsUnique();
			case Case004Package.A4__MANY_BS_NOT_UNIQUE:
				return getManyBsNotUnique();
			case Case004Package.A4__MANY_BS_ORDERED:
				return getManyBsOrdered();
			case Case004Package.A4__MANY_BS_ORDERED_UNIQUE:
				return getManyBsOrderedUnique();
			case Case004Package.A4__MANY_BS_NOT_ORDERED:
				return getManyBsNotOrdered();
			case Case004Package.A4__MANY_BS_NOT_CHANGEABLE:
				return getManyBsNotChangeable();
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
			case Case004Package.A4__ONE_PRIMITIVE:
				setOnePrimitive((String)newValue);
				return;
			case Case004Package.A4__ONE_PRIMITIVE_OPTIONAL:
				setOnePrimitiveOptional((String)newValue);
				return;
			case Case004Package.A4__ONE_PRIMITIVE_NOT_CHANGEABLE:
				setOnePrimitiveNotChangeable((String)newValue);
				return;
			case Case004Package.A4__MANY_PRIMITIVE:
				getManyPrimitive().clear();
				getManyPrimitive().addAll((Collection<? extends String>)newValue);
				return;
			case Case004Package.A4__MANY_PRIMITIVE_DOUBLE:
				getManyPrimitiveDouble().clear();
				getManyPrimitiveDouble().addAll((Collection<? extends Double>)newValue);
				return;
			case Case004Package.A4__MANY_PRIMITIVE_UNIQUE:
				getManyPrimitiveUnique().clear();
				getManyPrimitiveUnique().addAll((Collection<? extends String>)newValue);
				return;
			case Case004Package.A4__MANY_PRIMITIVE_OPTIONAL:
				getManyPrimitiveOptional().clear();
				getManyPrimitiveOptional().addAll((Collection<? extends String>)newValue);
				return;
			case Case004Package.A4__MANY_PRIMITIVE_NOT_CHANGEABLE:
				getManyPrimitiveNotChangeable().clear();
				getManyPrimitiveNotChangeable().addAll((Collection<? extends String>)newValue);
				return;
			case Case004Package.A4__MANY_PRIMITIVE_ORDERED:
				getManyPrimitiveOrdered().clear();
				getManyPrimitiveOrdered().addAll((Collection<? extends String>)newValue);
				return;
			case Case004Package.A4__MANY_PRIMITIVE_ORDERED_UNIQUE:
				getManyPrimitiveOrderedUnique().clear();
				getManyPrimitiveOrderedUnique().addAll((Collection<? extends String>)newValue);
				return;
			case Case004Package.A4__MANY_PRIMITIVE_ORDERED_NOT_CHANGEABLE:
				getManyPrimitiveOrderedNotChangeable().clear();
				getManyPrimitiveOrderedNotChangeable().addAll((Collection<? extends String>)newValue);
				return;
			case Case004Package.A4__ONE_BCHANGEABLE:
				setOneBChangeable((B4)newValue);
				return;
			case Case004Package.A4__ONE_BNOT_CHANGEABLE:
				setOneBNotChangeable((B4)newValue);
				return;
			case Case004Package.A4__ONE_BOPTIONAL:
				setOneBOptional((B4)newValue);
				return;
			case Case004Package.A4__MANY_BS:
				getManyBs().clear();
				getManyBs().addAll((Collection<? extends B4>)newValue);
				return;
			case Case004Package.A4__MANY_BS_UNIQUE:
				getManyBsUnique().clear();
				getManyBsUnique().addAll((Collection<? extends B4>)newValue);
				return;
			case Case004Package.A4__MANY_BS_NOT_UNIQUE:
				getManyBsNotUnique().clear();
				getManyBsNotUnique().addAll((Collection<? extends B4>)newValue);
				return;
			case Case004Package.A4__MANY_BS_ORDERED:
				getManyBsOrdered().clear();
				getManyBsOrdered().addAll((Collection<? extends B4>)newValue);
				return;
			case Case004Package.A4__MANY_BS_ORDERED_UNIQUE:
				getManyBsOrderedUnique().clear();
				getManyBsOrderedUnique().addAll((Collection<? extends B4>)newValue);
				return;
			case Case004Package.A4__MANY_BS_NOT_ORDERED:
				getManyBsNotOrdered().clear();
				getManyBsNotOrdered().addAll((Collection<? extends B4>)newValue);
				return;
			case Case004Package.A4__MANY_BS_NOT_CHANGEABLE:
				getManyBsNotChangeable().clear();
				getManyBsNotChangeable().addAll((Collection<? extends B4>)newValue);
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
			case Case004Package.A4__ONE_PRIMITIVE:
				setOnePrimitive(ONE_PRIMITIVE_EDEFAULT);
				return;
			case Case004Package.A4__ONE_PRIMITIVE_OPTIONAL:
				setOnePrimitiveOptional(ONE_PRIMITIVE_OPTIONAL_EDEFAULT);
				return;
			case Case004Package.A4__ONE_PRIMITIVE_NOT_CHANGEABLE:
				setOnePrimitiveNotChangeable(ONE_PRIMITIVE_NOT_CHANGEABLE_EDEFAULT);
				return;
			case Case004Package.A4__MANY_PRIMITIVE:
				getManyPrimitive().clear();
				return;
			case Case004Package.A4__MANY_PRIMITIVE_DOUBLE:
				getManyPrimitiveDouble().clear();
				return;
			case Case004Package.A4__MANY_PRIMITIVE_UNIQUE:
				getManyPrimitiveUnique().clear();
				return;
			case Case004Package.A4__MANY_PRIMITIVE_OPTIONAL:
				getManyPrimitiveOptional().clear();
				return;
			case Case004Package.A4__MANY_PRIMITIVE_NOT_CHANGEABLE:
				getManyPrimitiveNotChangeable().clear();
				return;
			case Case004Package.A4__MANY_PRIMITIVE_ORDERED:
				getManyPrimitiveOrdered().clear();
				return;
			case Case004Package.A4__MANY_PRIMITIVE_ORDERED_UNIQUE:
				getManyPrimitiveOrderedUnique().clear();
				return;
			case Case004Package.A4__MANY_PRIMITIVE_ORDERED_NOT_CHANGEABLE:
				getManyPrimitiveOrderedNotChangeable().clear();
				return;
			case Case004Package.A4__ONE_BCHANGEABLE:
				setOneBChangeable((B4)null);
				return;
			case Case004Package.A4__ONE_BNOT_CHANGEABLE:
				setOneBNotChangeable((B4)null);
				return;
			case Case004Package.A4__ONE_BOPTIONAL:
				setOneBOptional((B4)null);
				return;
			case Case004Package.A4__MANY_BS:
				getManyBs().clear();
				return;
			case Case004Package.A4__MANY_BS_UNIQUE:
				getManyBsUnique().clear();
				return;
			case Case004Package.A4__MANY_BS_NOT_UNIQUE:
				getManyBsNotUnique().clear();
				return;
			case Case004Package.A4__MANY_BS_ORDERED:
				getManyBsOrdered().clear();
				return;
			case Case004Package.A4__MANY_BS_ORDERED_UNIQUE:
				getManyBsOrderedUnique().clear();
				return;
			case Case004Package.A4__MANY_BS_NOT_ORDERED:
				getManyBsNotOrdered().clear();
				return;
			case Case004Package.A4__MANY_BS_NOT_CHANGEABLE:
				getManyBsNotChangeable().clear();
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
			case Case004Package.A4__ONE_PRIMITIVE:
				return ONE_PRIMITIVE_EDEFAULT == null ? onePrimitive != null : !ONE_PRIMITIVE_EDEFAULT.equals(onePrimitive);
			case Case004Package.A4__ONE_PRIMITIVE_OPTIONAL:
				return ONE_PRIMITIVE_OPTIONAL_EDEFAULT == null ? onePrimitiveOptional != null : !ONE_PRIMITIVE_OPTIONAL_EDEFAULT.equals(onePrimitiveOptional);
			case Case004Package.A4__ONE_PRIMITIVE_NOT_CHANGEABLE:
				return ONE_PRIMITIVE_NOT_CHANGEABLE_EDEFAULT == null ? onePrimitiveNotChangeable != null : !ONE_PRIMITIVE_NOT_CHANGEABLE_EDEFAULT.equals(onePrimitiveNotChangeable);
			case Case004Package.A4__MANY_PRIMITIVE:
				return manyPrimitive != null && !manyPrimitive.isEmpty();
			case Case004Package.A4__MANY_PRIMITIVE_DOUBLE:
				return manyPrimitiveDouble != null && !manyPrimitiveDouble.isEmpty();
			case Case004Package.A4__MANY_PRIMITIVE_UNIQUE:
				return manyPrimitiveUnique != null && !manyPrimitiveUnique.isEmpty();
			case Case004Package.A4__MANY_PRIMITIVE_OPTIONAL:
				return manyPrimitiveOptional != null && !manyPrimitiveOptional.isEmpty();
			case Case004Package.A4__MANY_PRIMITIVE_NOT_CHANGEABLE:
				return manyPrimitiveNotChangeable != null && !manyPrimitiveNotChangeable.isEmpty();
			case Case004Package.A4__MANY_PRIMITIVE_ORDERED:
				return manyPrimitiveOrdered != null && !manyPrimitiveOrdered.isEmpty();
			case Case004Package.A4__MANY_PRIMITIVE_ORDERED_UNIQUE:
				return manyPrimitiveOrderedUnique != null && !manyPrimitiveOrderedUnique.isEmpty();
			case Case004Package.A4__MANY_PRIMITIVE_ORDERED_NOT_CHANGEABLE:
				return manyPrimitiveOrderedNotChangeable != null && !manyPrimitiveOrderedNotChangeable.isEmpty();
			case Case004Package.A4__ONE_BCHANGEABLE:
				return oneBChangeable != null;
			case Case004Package.A4__ONE_BNOT_CHANGEABLE:
				return oneBNotChangeable != null;
			case Case004Package.A4__ONE_BOPTIONAL:
				return oneBOptional != null;
			case Case004Package.A4__MANY_BS:
				return manyBs != null && !manyBs.isEmpty();
			case Case004Package.A4__MANY_BS_UNIQUE:
				return manyBsUnique != null && !manyBsUnique.isEmpty();
			case Case004Package.A4__MANY_BS_NOT_UNIQUE:
				return manyBsNotUnique != null && !manyBsNotUnique.isEmpty();
			case Case004Package.A4__MANY_BS_ORDERED:
				return manyBsOrdered != null && !manyBsOrdered.isEmpty();
			case Case004Package.A4__MANY_BS_ORDERED_UNIQUE:
				return manyBsOrderedUnique != null && !manyBsOrderedUnique.isEmpty();
			case Case004Package.A4__MANY_BS_NOT_ORDERED:
				return manyBsNotOrdered != null && !manyBsNotOrdered.isEmpty();
			case Case004Package.A4__MANY_BS_NOT_CHANGEABLE:
				return manyBsNotChangeable != null && !manyBsNotChangeable.isEmpty();
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
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (onePrimitive: ");
		result.append(onePrimitive);
		result.append(", onePrimitiveOptional: ");
		result.append(onePrimitiveOptional);
		result.append(", onePrimitiveNotChangeable: ");
		result.append(onePrimitiveNotChangeable);
		result.append(", manyPrimitive: ");
		result.append(manyPrimitive);
		result.append(", manyPrimitiveDouble: ");
		result.append(manyPrimitiveDouble);
		result.append(", manyPrimitiveUnique: ");
		result.append(manyPrimitiveUnique);
		result.append(", manyPrimitiveOptional: ");
		result.append(manyPrimitiveOptional);
		result.append(", manyPrimitiveNotChangeable: ");
		result.append(manyPrimitiveNotChangeable);
		result.append(", manyPrimitiveOrdered: ");
		result.append(manyPrimitiveOrdered);
		result.append(", manyPrimitiveOrderedUnique: ");
		result.append(manyPrimitiveOrderedUnique);
		result.append(", manyPrimitiveOrderedNotChangeable: ");
		result.append(manyPrimitiveOrderedNotChangeable);
		result.append(')');
		return result.toString();
	}

} //A4Impl
