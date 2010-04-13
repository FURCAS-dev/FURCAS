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
 * $Id: ReferenceCSImpl.java,v 1.1 2010/04/13 06:44:11 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeRefCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ReferenceCSImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ReferenceCSImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ReferenceCSImpl#getLower <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ReferenceCSImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ReferenceCSImpl#getQualifiers <em>Qualifiers</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ReferenceCSImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ReferenceCSImpl#getUpper <em>Upper</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ReferenceCSImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ReferenceCSImpl#getDefaultValueLiteral <em>Default Value Literal</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ReferenceCSImpl#isContainment <em>Containment</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ReferenceCSImpl#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ReferenceCSImpl#getKeys <em>Keys</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceCSImpl extends MinimalEObjectImpl.Container implements ReferenceCS {
	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<AnnotationCS> annotations;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected static final int LOWER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected int lower = LOWER_EDEFAULT;

	/**
	 * The default value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected static final String MULTIPLICITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiplicity()
	 * @generated
	 * @ordered
	 */
	protected String multiplicity = MULTIPLICITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getQualifiers() <em>Qualifiers</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<String> qualifiers;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected TypeRefCS type;

	/**
	 * The default value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected static final int UPPER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected int upper = UPPER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<ConstraintCS> constraints;

	/**
	 * The default value of the '{@link #getDefaultValueLiteral() <em>Default Value Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValueLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_VALUE_LITERAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultValueLiteral() <em>Default Value Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValueLiteral()
	 * @generated
	 * @ordered
	 */
	protected String defaultValueLiteral = DEFAULT_VALUE_LITERAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isContainment() <em>Containment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContainment()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONTAINMENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isContainment() <em>Containment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isContainment()
	 * @generated
	 * @ordered
	 */
	protected boolean containment = CONTAINMENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOpposite() <em>Opposite</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpposite()
	 * @generated
	 * @ordered
	 */
	protected ReferenceRef opposite;

	/**
	 * The cached value of the '{@link #getKeys() <em>Keys</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeys()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeRef> keys;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCLinEcoreCSTPackage.Literals.REFERENCE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnnotationCS> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList<AnnotationCS>(AnnotationCS.class, this, OCLinEcoreCSTPackage.REFERENCE_CS__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLinEcoreCSTPackage.REFERENCE_CS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLower() {
		return lower;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLower(int newLower) {
		int oldLower = lower;
		lower = newLower;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLinEcoreCSTPackage.REFERENCE_CS__LOWER, oldLower, lower));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMultiplicity() {
		return multiplicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiplicity(String newMultiplicity) {
		String oldMultiplicity = multiplicity;
		multiplicity = newMultiplicity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLinEcoreCSTPackage.REFERENCE_CS__MULTIPLICITY, oldMultiplicity, multiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getQualifiers() {
		if (qualifiers == null) {
			qualifiers = new EDataTypeUniqueEList<String>(String.class, this, OCLinEcoreCSTPackage.REFERENCE_CS__QUALIFIERS);
		}
		return qualifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeRefCS getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(TypeRefCS newType, NotificationChain msgs) {
		TypeRefCS oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OCLinEcoreCSTPackage.REFERENCE_CS__TYPE, oldType, newType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(TypeRefCS newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OCLinEcoreCSTPackage.REFERENCE_CS__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OCLinEcoreCSTPackage.REFERENCE_CS__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLinEcoreCSTPackage.REFERENCE_CS__TYPE, newType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getUpper() {
		return upper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpper(int newUpper) {
		int oldUpper = upper;
		upper = newUpper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLinEcoreCSTPackage.REFERENCE_CS__UPPER, oldUpper, upper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConstraintCS> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentEList<ConstraintCS>(ConstraintCS.class, this, OCLinEcoreCSTPackage.REFERENCE_CS__CONSTRAINTS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultValueLiteral() {
		return defaultValueLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultValueLiteral(String newDefaultValueLiteral) {
		String oldDefaultValueLiteral = defaultValueLiteral;
		defaultValueLiteral = newDefaultValueLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLinEcoreCSTPackage.REFERENCE_CS__DEFAULT_VALUE_LITERAL, oldDefaultValueLiteral, defaultValueLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isContainment() {
		return containment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainment(boolean newContainment) {
		boolean oldContainment = containment;
		containment = newContainment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLinEcoreCSTPackage.REFERENCE_CS__CONTAINMENT, oldContainment, containment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceRef getOpposite() {
		return opposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOpposite(ReferenceRef newOpposite, NotificationChain msgs) {
		ReferenceRef oldOpposite = opposite;
		opposite = newOpposite;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OCLinEcoreCSTPackage.REFERENCE_CS__OPPOSITE, oldOpposite, newOpposite);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpposite(ReferenceRef newOpposite) {
		if (newOpposite != opposite) {
			NotificationChain msgs = null;
			if (opposite != null)
				msgs = ((InternalEObject)opposite).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OCLinEcoreCSTPackage.REFERENCE_CS__OPPOSITE, null, msgs);
			if (newOpposite != null)
				msgs = ((InternalEObject)newOpposite).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OCLinEcoreCSTPackage.REFERENCE_CS__OPPOSITE, null, msgs);
			msgs = basicSetOpposite(newOpposite, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLinEcoreCSTPackage.REFERENCE_CS__OPPOSITE, newOpposite, newOpposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeRef> getKeys() {
		if (keys == null) {
			keys = new EObjectContainmentEList<AttributeRef>(AttributeRef.class, this, OCLinEcoreCSTPackage.REFERENCE_CS__KEYS);
		}
		return keys;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OCLinEcoreCSTPackage.REFERENCE_CS__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
			case OCLinEcoreCSTPackage.REFERENCE_CS__TYPE:
				return basicSetType(null, msgs);
			case OCLinEcoreCSTPackage.REFERENCE_CS__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
			case OCLinEcoreCSTPackage.REFERENCE_CS__OPPOSITE:
				return basicSetOpposite(null, msgs);
			case OCLinEcoreCSTPackage.REFERENCE_CS__KEYS:
				return ((InternalEList<?>)getKeys()).basicRemove(otherEnd, msgs);
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
			case OCLinEcoreCSTPackage.REFERENCE_CS__ANNOTATIONS:
				return getAnnotations();
			case OCLinEcoreCSTPackage.REFERENCE_CS__NAME:
				return getName();
			case OCLinEcoreCSTPackage.REFERENCE_CS__LOWER:
				return getLower();
			case OCLinEcoreCSTPackage.REFERENCE_CS__MULTIPLICITY:
				return getMultiplicity();
			case OCLinEcoreCSTPackage.REFERENCE_CS__QUALIFIERS:
				return getQualifiers();
			case OCLinEcoreCSTPackage.REFERENCE_CS__TYPE:
				return getType();
			case OCLinEcoreCSTPackage.REFERENCE_CS__UPPER:
				return getUpper();
			case OCLinEcoreCSTPackage.REFERENCE_CS__CONSTRAINTS:
				return getConstraints();
			case OCLinEcoreCSTPackage.REFERENCE_CS__DEFAULT_VALUE_LITERAL:
				return getDefaultValueLiteral();
			case OCLinEcoreCSTPackage.REFERENCE_CS__CONTAINMENT:
				return isContainment();
			case OCLinEcoreCSTPackage.REFERENCE_CS__OPPOSITE:
				return getOpposite();
			case OCLinEcoreCSTPackage.REFERENCE_CS__KEYS:
				return getKeys();
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
			case OCLinEcoreCSTPackage.REFERENCE_CS__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends AnnotationCS>)newValue);
				return;
			case OCLinEcoreCSTPackage.REFERENCE_CS__NAME:
				setName((String)newValue);
				return;
			case OCLinEcoreCSTPackage.REFERENCE_CS__LOWER:
				setLower((Integer)newValue);
				return;
			case OCLinEcoreCSTPackage.REFERENCE_CS__MULTIPLICITY:
				setMultiplicity((String)newValue);
				return;
			case OCLinEcoreCSTPackage.REFERENCE_CS__QUALIFIERS:
				getQualifiers().clear();
				getQualifiers().addAll((Collection<? extends String>)newValue);
				return;
			case OCLinEcoreCSTPackage.REFERENCE_CS__TYPE:
				setType((TypeRefCS)newValue);
				return;
			case OCLinEcoreCSTPackage.REFERENCE_CS__UPPER:
				setUpper((Integer)newValue);
				return;
			case OCLinEcoreCSTPackage.REFERENCE_CS__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends ConstraintCS>)newValue);
				return;
			case OCLinEcoreCSTPackage.REFERENCE_CS__DEFAULT_VALUE_LITERAL:
				setDefaultValueLiteral((String)newValue);
				return;
			case OCLinEcoreCSTPackage.REFERENCE_CS__CONTAINMENT:
				setContainment((Boolean)newValue);
				return;
			case OCLinEcoreCSTPackage.REFERENCE_CS__OPPOSITE:
				setOpposite((ReferenceRef)newValue);
				return;
			case OCLinEcoreCSTPackage.REFERENCE_CS__KEYS:
				getKeys().clear();
				getKeys().addAll((Collection<? extends AttributeRef>)newValue);
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
			case OCLinEcoreCSTPackage.REFERENCE_CS__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case OCLinEcoreCSTPackage.REFERENCE_CS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case OCLinEcoreCSTPackage.REFERENCE_CS__LOWER:
				setLower(LOWER_EDEFAULT);
				return;
			case OCLinEcoreCSTPackage.REFERENCE_CS__MULTIPLICITY:
				setMultiplicity(MULTIPLICITY_EDEFAULT);
				return;
			case OCLinEcoreCSTPackage.REFERENCE_CS__QUALIFIERS:
				getQualifiers().clear();
				return;
			case OCLinEcoreCSTPackage.REFERENCE_CS__TYPE:
				setType((TypeRefCS)null);
				return;
			case OCLinEcoreCSTPackage.REFERENCE_CS__UPPER:
				setUpper(UPPER_EDEFAULT);
				return;
			case OCLinEcoreCSTPackage.REFERENCE_CS__CONSTRAINTS:
				getConstraints().clear();
				return;
			case OCLinEcoreCSTPackage.REFERENCE_CS__DEFAULT_VALUE_LITERAL:
				setDefaultValueLiteral(DEFAULT_VALUE_LITERAL_EDEFAULT);
				return;
			case OCLinEcoreCSTPackage.REFERENCE_CS__CONTAINMENT:
				setContainment(CONTAINMENT_EDEFAULT);
				return;
			case OCLinEcoreCSTPackage.REFERENCE_CS__OPPOSITE:
				setOpposite((ReferenceRef)null);
				return;
			case OCLinEcoreCSTPackage.REFERENCE_CS__KEYS:
				getKeys().clear();
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
			case OCLinEcoreCSTPackage.REFERENCE_CS__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case OCLinEcoreCSTPackage.REFERENCE_CS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case OCLinEcoreCSTPackage.REFERENCE_CS__LOWER:
				return lower != LOWER_EDEFAULT;
			case OCLinEcoreCSTPackage.REFERENCE_CS__MULTIPLICITY:
				return MULTIPLICITY_EDEFAULT == null ? multiplicity != null : !MULTIPLICITY_EDEFAULT.equals(multiplicity);
			case OCLinEcoreCSTPackage.REFERENCE_CS__QUALIFIERS:
				return qualifiers != null && !qualifiers.isEmpty();
			case OCLinEcoreCSTPackage.REFERENCE_CS__TYPE:
				return type != null;
			case OCLinEcoreCSTPackage.REFERENCE_CS__UPPER:
				return upper != UPPER_EDEFAULT;
			case OCLinEcoreCSTPackage.REFERENCE_CS__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
			case OCLinEcoreCSTPackage.REFERENCE_CS__DEFAULT_VALUE_LITERAL:
				return DEFAULT_VALUE_LITERAL_EDEFAULT == null ? defaultValueLiteral != null : !DEFAULT_VALUE_LITERAL_EDEFAULT.equals(defaultValueLiteral);
			case OCLinEcoreCSTPackage.REFERENCE_CS__CONTAINMENT:
				return containment != CONTAINMENT_EDEFAULT;
			case OCLinEcoreCSTPackage.REFERENCE_CS__OPPOSITE:
				return opposite != null;
			case OCLinEcoreCSTPackage.REFERENCE_CS__KEYS:
				return keys != null && !keys.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", lower: ");
		result.append(lower);
		result.append(", multiplicity: ");
		result.append(multiplicity);
		result.append(", qualifiers: ");
		result.append(qualifiers);
		result.append(", upper: ");
		result.append(upper);
		result.append(", defaultValueLiteral: ");
		result.append(defaultValueLiteral);
		result.append(", containment: ");
		result.append(containment);
		result.append(')');
		return result.toString();
	}

} //ReferenceCSImpl
