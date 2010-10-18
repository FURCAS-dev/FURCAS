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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package;
import org.eclipse.emf.query2.test.mm.testcases.case004.D4;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>D4</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.D4Impl#isAttributeBoolean <em>Attribute Boolean</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.D4Impl#getAttributeBooleanOptional <em>Attribute Boolean Optional</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.D4Impl#getAttributeDouble <em>Attribute Double</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.D4Impl#getAttributeDoubleOptional <em>Attribute Double Optional</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.D4Impl#getAttributeFloat <em>Attribute Float</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.D4Impl#getAttributeFloatOptional <em>Attribute Float Optional</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.D4Impl#getAttributeInteger <em>Attribute Integer</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.D4Impl#getAttributeIntegerOptional <em>Attribute Integer Optional</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.D4Impl#getAttributeLong <em>Attribute Long</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.D4Impl#getAttributeLongOptional <em>Attribute Long Optional</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.D4Impl#getAttributeString <em>Attribute String</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.impl.D4Impl#getAttributeStringOptional <em>Attribute String Optional</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class D4Impl extends EObjectImpl implements D4 {
	/**
	 * The default value of the '{@link #isAttributeBoolean() <em>Attribute Boolean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAttributeBoolean()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ATTRIBUTE_BOOLEAN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAttributeBoolean() <em>Attribute Boolean</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAttributeBoolean()
	 * @generated
	 * @ordered
	 */
	protected boolean attributeBoolean = ATTRIBUTE_BOOLEAN_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttributeBooleanOptional() <em>Attribute Boolean Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeBooleanOptional()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean ATTRIBUTE_BOOLEAN_OPTIONAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttributeBooleanOptional() <em>Attribute Boolean Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeBooleanOptional()
	 * @generated
	 * @ordered
	 */
	protected Boolean attributeBooleanOptional = ATTRIBUTE_BOOLEAN_OPTIONAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttributeDouble() <em>Attribute Double</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeDouble()
	 * @generated
	 * @ordered
	 */
	protected static final double ATTRIBUTE_DOUBLE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getAttributeDouble() <em>Attribute Double</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeDouble()
	 * @generated
	 * @ordered
	 */
	protected double attributeDouble = ATTRIBUTE_DOUBLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttributeDoubleOptional() <em>Attribute Double Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeDoubleOptional()
	 * @generated
	 * @ordered
	 */
	protected static final Double ATTRIBUTE_DOUBLE_OPTIONAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttributeDoubleOptional() <em>Attribute Double Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeDoubleOptional()
	 * @generated
	 * @ordered
	 */
	protected Double attributeDoubleOptional = ATTRIBUTE_DOUBLE_OPTIONAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttributeFloat() <em>Attribute Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeFloat()
	 * @generated
	 * @ordered
	 */
	protected static final float ATTRIBUTE_FLOAT_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getAttributeFloat() <em>Attribute Float</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeFloat()
	 * @generated
	 * @ordered
	 */
	protected float attributeFloat = ATTRIBUTE_FLOAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttributeFloatOptional() <em>Attribute Float Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeFloatOptional()
	 * @generated
	 * @ordered
	 */
	protected static final Float ATTRIBUTE_FLOAT_OPTIONAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttributeFloatOptional() <em>Attribute Float Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeFloatOptional()
	 * @generated
	 * @ordered
	 */
	protected Float attributeFloatOptional = ATTRIBUTE_FLOAT_OPTIONAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttributeInteger() <em>Attribute Integer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeInteger()
	 * @generated
	 * @ordered
	 */
	protected static final int ATTRIBUTE_INTEGER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getAttributeInteger() <em>Attribute Integer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeInteger()
	 * @generated
	 * @ordered
	 */
	protected int attributeInteger = ATTRIBUTE_INTEGER_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttributeIntegerOptional() <em>Attribute Integer Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeIntegerOptional()
	 * @generated
	 * @ordered
	 */
	protected static final Integer ATTRIBUTE_INTEGER_OPTIONAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttributeIntegerOptional() <em>Attribute Integer Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeIntegerOptional()
	 * @generated
	 * @ordered
	 */
	protected Integer attributeIntegerOptional = ATTRIBUTE_INTEGER_OPTIONAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttributeLong() <em>Attribute Long</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeLong()
	 * @generated
	 * @ordered
	 */
	protected static final long ATTRIBUTE_LONG_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getAttributeLong() <em>Attribute Long</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeLong()
	 * @generated
	 * @ordered
	 */
	protected long attributeLong = ATTRIBUTE_LONG_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttributeLongOptional() <em>Attribute Long Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeLongOptional()
	 * @generated
	 * @ordered
	 */
	protected static final Long ATTRIBUTE_LONG_OPTIONAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttributeLongOptional() <em>Attribute Long Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeLongOptional()
	 * @generated
	 * @ordered
	 */
	protected Long attributeLongOptional = ATTRIBUTE_LONG_OPTIONAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttributeString() <em>Attribute String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeString()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE_STRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttributeString() <em>Attribute String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeString()
	 * @generated
	 * @ordered
	 */
	protected String attributeString = ATTRIBUTE_STRING_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttributeStringOptional() <em>Attribute String Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeStringOptional()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE_STRING_OPTIONAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttributeStringOptional() <em>Attribute String Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeStringOptional()
	 * @generated
	 * @ordered
	 */
	protected String attributeStringOptional = ATTRIBUTE_STRING_OPTIONAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected D4Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Case004Package.Literals.D4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAttributeBoolean() {
		return attributeBoolean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeBoolean(boolean newAttributeBoolean) {
		boolean oldAttributeBoolean = attributeBoolean;
		attributeBoolean = newAttributeBoolean;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.D4__ATTRIBUTE_BOOLEAN, oldAttributeBoolean, attributeBoolean));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getAttributeBooleanOptional() {
		return attributeBooleanOptional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeBooleanOptional(Boolean newAttributeBooleanOptional) {
		Boolean oldAttributeBooleanOptional = attributeBooleanOptional;
		attributeBooleanOptional = newAttributeBooleanOptional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.D4__ATTRIBUTE_BOOLEAN_OPTIONAL, oldAttributeBooleanOptional, attributeBooleanOptional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAttributeDouble() {
		return attributeDouble;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeDouble(double newAttributeDouble) {
		double oldAttributeDouble = attributeDouble;
		attributeDouble = newAttributeDouble;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.D4__ATTRIBUTE_DOUBLE, oldAttributeDouble, attributeDouble));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Double getAttributeDoubleOptional() {
		return attributeDoubleOptional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeDoubleOptional(Double newAttributeDoubleOptional) {
		Double oldAttributeDoubleOptional = attributeDoubleOptional;
		attributeDoubleOptional = newAttributeDoubleOptional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.D4__ATTRIBUTE_DOUBLE_OPTIONAL, oldAttributeDoubleOptional, attributeDoubleOptional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getAttributeFloat() {
		return attributeFloat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeFloat(float newAttributeFloat) {
		float oldAttributeFloat = attributeFloat;
		attributeFloat = newAttributeFloat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.D4__ATTRIBUTE_FLOAT, oldAttributeFloat, attributeFloat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getAttributeFloatOptional() {
		return attributeFloatOptional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeFloatOptional(Float newAttributeFloatOptional) {
		Float oldAttributeFloatOptional = attributeFloatOptional;
		attributeFloatOptional = newAttributeFloatOptional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.D4__ATTRIBUTE_FLOAT_OPTIONAL, oldAttributeFloatOptional, attributeFloatOptional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAttributeInteger() {
		return attributeInteger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeInteger(int newAttributeInteger) {
		int oldAttributeInteger = attributeInteger;
		attributeInteger = newAttributeInteger;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.D4__ATTRIBUTE_INTEGER, oldAttributeInteger, attributeInteger));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getAttributeIntegerOptional() {
		return attributeIntegerOptional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeIntegerOptional(Integer newAttributeIntegerOptional) {
		Integer oldAttributeIntegerOptional = attributeIntegerOptional;
		attributeIntegerOptional = newAttributeIntegerOptional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.D4__ATTRIBUTE_INTEGER_OPTIONAL, oldAttributeIntegerOptional, attributeIntegerOptional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getAttributeLong() {
		return attributeLong;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeLong(long newAttributeLong) {
		long oldAttributeLong = attributeLong;
		attributeLong = newAttributeLong;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.D4__ATTRIBUTE_LONG, oldAttributeLong, attributeLong));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Long getAttributeLongOptional() {
		return attributeLongOptional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeLongOptional(Long newAttributeLongOptional) {
		Long oldAttributeLongOptional = attributeLongOptional;
		attributeLongOptional = newAttributeLongOptional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.D4__ATTRIBUTE_LONG_OPTIONAL, oldAttributeLongOptional, attributeLongOptional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttributeString() {
		return attributeString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeString(String newAttributeString) {
		String oldAttributeString = attributeString;
		attributeString = newAttributeString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.D4__ATTRIBUTE_STRING, oldAttributeString, attributeString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttributeStringOptional() {
		return attributeStringOptional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeStringOptional(String newAttributeStringOptional) {
		String oldAttributeStringOptional = attributeStringOptional;
		attributeStringOptional = newAttributeStringOptional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Case004Package.D4__ATTRIBUTE_STRING_OPTIONAL, oldAttributeStringOptional, attributeStringOptional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Case004Package.D4__ATTRIBUTE_BOOLEAN:
				return isAttributeBoolean();
			case Case004Package.D4__ATTRIBUTE_BOOLEAN_OPTIONAL:
				return getAttributeBooleanOptional();
			case Case004Package.D4__ATTRIBUTE_DOUBLE:
				return getAttributeDouble();
			case Case004Package.D4__ATTRIBUTE_DOUBLE_OPTIONAL:
				return getAttributeDoubleOptional();
			case Case004Package.D4__ATTRIBUTE_FLOAT:
				return getAttributeFloat();
			case Case004Package.D4__ATTRIBUTE_FLOAT_OPTIONAL:
				return getAttributeFloatOptional();
			case Case004Package.D4__ATTRIBUTE_INTEGER:
				return getAttributeInteger();
			case Case004Package.D4__ATTRIBUTE_INTEGER_OPTIONAL:
				return getAttributeIntegerOptional();
			case Case004Package.D4__ATTRIBUTE_LONG:
				return getAttributeLong();
			case Case004Package.D4__ATTRIBUTE_LONG_OPTIONAL:
				return getAttributeLongOptional();
			case Case004Package.D4__ATTRIBUTE_STRING:
				return getAttributeString();
			case Case004Package.D4__ATTRIBUTE_STRING_OPTIONAL:
				return getAttributeStringOptional();
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
			case Case004Package.D4__ATTRIBUTE_BOOLEAN:
				setAttributeBoolean((Boolean)newValue);
				return;
			case Case004Package.D4__ATTRIBUTE_BOOLEAN_OPTIONAL:
				setAttributeBooleanOptional((Boolean)newValue);
				return;
			case Case004Package.D4__ATTRIBUTE_DOUBLE:
				setAttributeDouble((Double)newValue);
				return;
			case Case004Package.D4__ATTRIBUTE_DOUBLE_OPTIONAL:
				setAttributeDoubleOptional((Double)newValue);
				return;
			case Case004Package.D4__ATTRIBUTE_FLOAT:
				setAttributeFloat((Float)newValue);
				return;
			case Case004Package.D4__ATTRIBUTE_FLOAT_OPTIONAL:
				setAttributeFloatOptional((Float)newValue);
				return;
			case Case004Package.D4__ATTRIBUTE_INTEGER:
				setAttributeInteger((Integer)newValue);
				return;
			case Case004Package.D4__ATTRIBUTE_INTEGER_OPTIONAL:
				setAttributeIntegerOptional((Integer)newValue);
				return;
			case Case004Package.D4__ATTRIBUTE_LONG:
				setAttributeLong((Long)newValue);
				return;
			case Case004Package.D4__ATTRIBUTE_LONG_OPTIONAL:
				setAttributeLongOptional((Long)newValue);
				return;
			case Case004Package.D4__ATTRIBUTE_STRING:
				setAttributeString((String)newValue);
				return;
			case Case004Package.D4__ATTRIBUTE_STRING_OPTIONAL:
				setAttributeStringOptional((String)newValue);
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
			case Case004Package.D4__ATTRIBUTE_BOOLEAN:
				setAttributeBoolean(ATTRIBUTE_BOOLEAN_EDEFAULT);
				return;
			case Case004Package.D4__ATTRIBUTE_BOOLEAN_OPTIONAL:
				setAttributeBooleanOptional(ATTRIBUTE_BOOLEAN_OPTIONAL_EDEFAULT);
				return;
			case Case004Package.D4__ATTRIBUTE_DOUBLE:
				setAttributeDouble(ATTRIBUTE_DOUBLE_EDEFAULT);
				return;
			case Case004Package.D4__ATTRIBUTE_DOUBLE_OPTIONAL:
				setAttributeDoubleOptional(ATTRIBUTE_DOUBLE_OPTIONAL_EDEFAULT);
				return;
			case Case004Package.D4__ATTRIBUTE_FLOAT:
				setAttributeFloat(ATTRIBUTE_FLOAT_EDEFAULT);
				return;
			case Case004Package.D4__ATTRIBUTE_FLOAT_OPTIONAL:
				setAttributeFloatOptional(ATTRIBUTE_FLOAT_OPTIONAL_EDEFAULT);
				return;
			case Case004Package.D4__ATTRIBUTE_INTEGER:
				setAttributeInteger(ATTRIBUTE_INTEGER_EDEFAULT);
				return;
			case Case004Package.D4__ATTRIBUTE_INTEGER_OPTIONAL:
				setAttributeIntegerOptional(ATTRIBUTE_INTEGER_OPTIONAL_EDEFAULT);
				return;
			case Case004Package.D4__ATTRIBUTE_LONG:
				setAttributeLong(ATTRIBUTE_LONG_EDEFAULT);
				return;
			case Case004Package.D4__ATTRIBUTE_LONG_OPTIONAL:
				setAttributeLongOptional(ATTRIBUTE_LONG_OPTIONAL_EDEFAULT);
				return;
			case Case004Package.D4__ATTRIBUTE_STRING:
				setAttributeString(ATTRIBUTE_STRING_EDEFAULT);
				return;
			case Case004Package.D4__ATTRIBUTE_STRING_OPTIONAL:
				setAttributeStringOptional(ATTRIBUTE_STRING_OPTIONAL_EDEFAULT);
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
			case Case004Package.D4__ATTRIBUTE_BOOLEAN:
				return attributeBoolean != ATTRIBUTE_BOOLEAN_EDEFAULT;
			case Case004Package.D4__ATTRIBUTE_BOOLEAN_OPTIONAL:
				return ATTRIBUTE_BOOLEAN_OPTIONAL_EDEFAULT == null ? attributeBooleanOptional != null : !ATTRIBUTE_BOOLEAN_OPTIONAL_EDEFAULT.equals(attributeBooleanOptional);
			case Case004Package.D4__ATTRIBUTE_DOUBLE:
				return attributeDouble != ATTRIBUTE_DOUBLE_EDEFAULT;
			case Case004Package.D4__ATTRIBUTE_DOUBLE_OPTIONAL:
				return ATTRIBUTE_DOUBLE_OPTIONAL_EDEFAULT == null ? attributeDoubleOptional != null : !ATTRIBUTE_DOUBLE_OPTIONAL_EDEFAULT.equals(attributeDoubleOptional);
			case Case004Package.D4__ATTRIBUTE_FLOAT:
				return attributeFloat != ATTRIBUTE_FLOAT_EDEFAULT;
			case Case004Package.D4__ATTRIBUTE_FLOAT_OPTIONAL:
				return ATTRIBUTE_FLOAT_OPTIONAL_EDEFAULT == null ? attributeFloatOptional != null : !ATTRIBUTE_FLOAT_OPTIONAL_EDEFAULT.equals(attributeFloatOptional);
			case Case004Package.D4__ATTRIBUTE_INTEGER:
				return attributeInteger != ATTRIBUTE_INTEGER_EDEFAULT;
			case Case004Package.D4__ATTRIBUTE_INTEGER_OPTIONAL:
				return ATTRIBUTE_INTEGER_OPTIONAL_EDEFAULT == null ? attributeIntegerOptional != null : !ATTRIBUTE_INTEGER_OPTIONAL_EDEFAULT.equals(attributeIntegerOptional);
			case Case004Package.D4__ATTRIBUTE_LONG:
				return attributeLong != ATTRIBUTE_LONG_EDEFAULT;
			case Case004Package.D4__ATTRIBUTE_LONG_OPTIONAL:
				return ATTRIBUTE_LONG_OPTIONAL_EDEFAULT == null ? attributeLongOptional != null : !ATTRIBUTE_LONG_OPTIONAL_EDEFAULT.equals(attributeLongOptional);
			case Case004Package.D4__ATTRIBUTE_STRING:
				return ATTRIBUTE_STRING_EDEFAULT == null ? attributeString != null : !ATTRIBUTE_STRING_EDEFAULT.equals(attributeString);
			case Case004Package.D4__ATTRIBUTE_STRING_OPTIONAL:
				return ATTRIBUTE_STRING_OPTIONAL_EDEFAULT == null ? attributeStringOptional != null : !ATTRIBUTE_STRING_OPTIONAL_EDEFAULT.equals(attributeStringOptional);
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
		result.append(" (attributeBoolean: ");
		result.append(attributeBoolean);
		result.append(", attributeBooleanOptional: ");
		result.append(attributeBooleanOptional);
		result.append(", attributeDouble: ");
		result.append(attributeDouble);
		result.append(", attributeDoubleOptional: ");
		result.append(attributeDoubleOptional);
		result.append(", attributeFloat: ");
		result.append(attributeFloat);
		result.append(", attributeFloatOptional: ");
		result.append(attributeFloatOptional);
		result.append(", attributeInteger: ");
		result.append(attributeInteger);
		result.append(", attributeIntegerOptional: ");
		result.append(attributeIntegerOptional);
		result.append(", attributeLong: ");
		result.append(attributeLong);
		result.append(", attributeLongOptional: ");
		result.append(attributeLongOptional);
		result.append(", attributeString: ");
		result.append(attributeString);
		result.append(", attributeStringOptional: ");
		result.append(attributeStringOptional);
		result.append(')');
		return result.toString();
	}

} //D4Impl
