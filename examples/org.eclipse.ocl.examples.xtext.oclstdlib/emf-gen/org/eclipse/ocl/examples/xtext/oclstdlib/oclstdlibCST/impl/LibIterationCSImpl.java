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
 * $Id: LibIterationCSImpl.java,v 1.1 2010/05/03 05:30:18 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.NamedElementCSImpl;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lib Iteration CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIterationCSImpl#getLower <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIterationCSImpl#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIterationCSImpl#getQualifiers <em>Qualifiers</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIterationCSImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIterationCSImpl#getUpper <em>Upper</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIterationCSImpl#isIsStatic <em>Is Static</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIterationCSImpl#isIsDefinition <em>Is Definition</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIterationCSImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIterationCSImpl#getTypeParameters <em>Type Parameters</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIterationCSImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.impl.LibIterationCSImpl#getIterators <em>Iterators</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LibIterationCSImpl extends NamedElementCSImpl implements LibIterationCS {
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
	protected TypedRefCS type;

	/**
	 * The default value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected static final int UPPER_EDEFAULT = 1;

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
	 * The default value of the '{@link #isIsStatic() <em>Is Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsStatic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_STATIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsStatic() <em>Is Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsStatic()
	 * @generated
	 * @ordered
	 */
	protected boolean isStatic = IS_STATIC_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsDefinition() <em>Is Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDefinition()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DEFINITION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsDefinition() <em>Is Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDefinition()
	 * @generated
	 * @ordered
	 */
	protected boolean isDefinition = IS_DEFINITION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterCS> parameters;

	/**
	 * The cached value of the '{@link #getTypeParameters() <em>Type Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeParameterCS> typeParameters;

	/**
	 * The default value of the '{@link #getClass_() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected String class_ = CLASS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIterators() <em>Iterators</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterators()
	 * @generated
	 * @ordered
	 */
	protected EList<String> iterators;

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
			eNotify(new ENotificationImpl(this, Notification.SET, OCLstdlibCSTPackage.LIB_ITERATION_CS__LOWER, oldLower, lower));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OCLstdlibCSTPackage.LIB_ITERATION_CS__MULTIPLICITY, oldMultiplicity, multiplicity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getQualifiers() {
		if (qualifiers == null) {
			qualifiers = new EDataTypeUniqueEList<String>(String.class, this, OCLstdlibCSTPackage.LIB_ITERATION_CS__QUALIFIERS);
		}
		return qualifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedRefCS getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(TypedRefCS newType, NotificationChain msgs) {
		TypedRefCS oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OCLstdlibCSTPackage.LIB_ITERATION_CS__TYPE, oldType, newType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(TypedRefCS newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OCLstdlibCSTPackage.LIB_ITERATION_CS__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OCLstdlibCSTPackage.LIB_ITERATION_CS__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLstdlibCSTPackage.LIB_ITERATION_CS__TYPE, newType, newType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OCLstdlibCSTPackage.LIB_ITERATION_CS__UPPER, oldUpper, upper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsStatic() {
		return isStatic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsStatic(boolean newIsStatic) {
		boolean oldIsStatic = isStatic;
		isStatic = newIsStatic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLstdlibCSTPackage.LIB_ITERATION_CS__IS_STATIC, oldIsStatic, isStatic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsDefinition() {
		return isDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDefinition(boolean newIsDefinition) {
		boolean oldIsDefinition = isDefinition;
		isDefinition = newIsDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLstdlibCSTPackage.LIB_ITERATION_CS__IS_DEFINITION, oldIsDefinition, isDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterCS> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<ParameterCS>(ParameterCS.class, this, OCLstdlibCSTPackage.LIB_ITERATION_CS__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeParameterCS> getTypeParameters() {
		if (typeParameters == null) {
			typeParameters = new EObjectContainmentEList<TypeParameterCS>(TypeParameterCS.class, this, OCLstdlibCSTPackage.LIB_ITERATION_CS__TYPE_PARAMETERS);
		}
		return typeParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClass_() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(String newClass) {
		String oldClass = class_;
		class_ = newClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLstdlibCSTPackage.LIB_ITERATION_CS__CLASS, oldClass, class_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getIterators() {
		if (iterators == null) {
			iterators = new EDataTypeUniqueEList<String>(String.class, this, OCLstdlibCSTPackage.LIB_ITERATION_CS__ITERATORS);
		}
		return iterators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__TYPE:
				return basicSetType(null, msgs);
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__TYPE_PARAMETERS:
				return ((InternalEList<?>)getTypeParameters()).basicRemove(otherEnd, msgs);
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
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__LOWER:
				return getLower();
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__MULTIPLICITY:
				return getMultiplicity();
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__QUALIFIERS:
				return getQualifiers();
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__TYPE:
				return getType();
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__UPPER:
				return getUpper();
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__IS_STATIC:
				return isIsStatic();
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__IS_DEFINITION:
				return isIsDefinition();
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__PARAMETERS:
				return getParameters();
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__TYPE_PARAMETERS:
				return getTypeParameters();
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__CLASS:
				return getClass_();
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__ITERATORS:
				return getIterators();
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
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__LOWER:
				setLower((Integer)newValue);
				return;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__MULTIPLICITY:
				setMultiplicity((String)newValue);
				return;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__QUALIFIERS:
				getQualifiers().clear();
				getQualifiers().addAll((Collection<? extends String>)newValue);
				return;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__TYPE:
				setType((TypedRefCS)newValue);
				return;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__UPPER:
				setUpper((Integer)newValue);
				return;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__IS_STATIC:
				setIsStatic((Boolean)newValue);
				return;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__IS_DEFINITION:
				setIsDefinition((Boolean)newValue);
				return;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends ParameterCS>)newValue);
				return;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__TYPE_PARAMETERS:
				getTypeParameters().clear();
				getTypeParameters().addAll((Collection<? extends TypeParameterCS>)newValue);
				return;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__CLASS:
				setClass((String)newValue);
				return;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__ITERATORS:
				getIterators().clear();
				getIterators().addAll((Collection<? extends String>)newValue);
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
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__LOWER:
				setLower(LOWER_EDEFAULT);
				return;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__MULTIPLICITY:
				setMultiplicity(MULTIPLICITY_EDEFAULT);
				return;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__QUALIFIERS:
				getQualifiers().clear();
				return;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__TYPE:
				setType((TypedRefCS)null);
				return;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__UPPER:
				setUpper(UPPER_EDEFAULT);
				return;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__IS_STATIC:
				setIsStatic(IS_STATIC_EDEFAULT);
				return;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__IS_DEFINITION:
				setIsDefinition(IS_DEFINITION_EDEFAULT);
				return;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__PARAMETERS:
				getParameters().clear();
				return;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__TYPE_PARAMETERS:
				getTypeParameters().clear();
				return;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__CLASS:
				setClass(CLASS_EDEFAULT);
				return;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__ITERATORS:
				getIterators().clear();
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
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__LOWER:
				return lower != LOWER_EDEFAULT;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__MULTIPLICITY:
				return MULTIPLICITY_EDEFAULT == null ? multiplicity != null : !MULTIPLICITY_EDEFAULT.equals(multiplicity);
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__QUALIFIERS:
				return qualifiers != null && !qualifiers.isEmpty();
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__TYPE:
				return type != null;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__UPPER:
				return upper != UPPER_EDEFAULT;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__IS_STATIC:
				return isStatic != IS_STATIC_EDEFAULT;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__IS_DEFINITION:
				return isDefinition != IS_DEFINITION_EDEFAULT;
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__TYPE_PARAMETERS:
				return typeParameters != null && !typeParameters.isEmpty();
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__CLASS:
				return CLASS_EDEFAULT == null ? class_ != null : !CLASS_EDEFAULT.equals(class_);
			case OCLstdlibCSTPackage.LIB_ITERATION_CS__ITERATORS:
				return iterators != null && !iterators.isEmpty();
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

} //LibIterationCSImpl
