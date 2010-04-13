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
 * $Id: ConstraintCSImpl.java,v 1.1 2010/04/13 06:44:11 ewillink Exp $
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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.OclExpressionCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ConstraintCSImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ConstraintCSImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ConstraintCSImpl#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ConstraintCSImpl#getExprString <em>Expr String</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.ConstraintCSImpl#getExprValue <em>Expr Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintCSImpl extends MinimalEObjectImpl.Container implements ConstraintCS {
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
	 * The default value of the '{@link #getStereotype() <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotype()
	 * @generated
	 * @ordered
	 */
	protected static final String STEREOTYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStereotype() <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotype()
	 * @generated
	 * @ordered
	 */
	protected String stereotype = STEREOTYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExprString() <em>Expr String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExprString()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPR_STRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExprString() <em>Expr String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExprString()
	 * @generated
	 * @ordered
	 */
	protected String exprString = EXPR_STRING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExprValue() <em>Expr Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExprValue()
	 * @generated
	 * @ordered
	 */
	protected OclExpressionCS exprValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCLinEcoreCSTPackage.Literals.CONSTRAINT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnnotationCS> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList<AnnotationCS>(AnnotationCS.class, this, OCLinEcoreCSTPackage.CONSTRAINT_CS__ANNOTATIONS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, OCLinEcoreCSTPackage.CONSTRAINT_CS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStereotype() {
		return stereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotype(String newStereotype) {
		String oldStereotype = stereotype;
		stereotype = newStereotype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLinEcoreCSTPackage.CONSTRAINT_CS__STEREOTYPE, oldStereotype, stereotype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExprString() {
		return exprString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExprString(String newExprString) {
		String oldExprString = exprString;
		exprString = newExprString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLinEcoreCSTPackage.CONSTRAINT_CS__EXPR_STRING, oldExprString, exprString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpressionCS getExprValue() {
		return exprValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExprValue(OclExpressionCS newExprValue, NotificationChain msgs) {
		OclExpressionCS oldExprValue = exprValue;
		exprValue = newExprValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OCLinEcoreCSTPackage.CONSTRAINT_CS__EXPR_VALUE, oldExprValue, newExprValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExprValue(OclExpressionCS newExprValue) {
		if (newExprValue != exprValue) {
			NotificationChain msgs = null;
			if (exprValue != null)
				msgs = ((InternalEObject)exprValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OCLinEcoreCSTPackage.CONSTRAINT_CS__EXPR_VALUE, null, msgs);
			if (newExprValue != null)
				msgs = ((InternalEObject)newExprValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OCLinEcoreCSTPackage.CONSTRAINT_CS__EXPR_VALUE, null, msgs);
			msgs = basicSetExprValue(newExprValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLinEcoreCSTPackage.CONSTRAINT_CS__EXPR_VALUE, newExprValue, newExprValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OCLinEcoreCSTPackage.CONSTRAINT_CS__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
			case OCLinEcoreCSTPackage.CONSTRAINT_CS__EXPR_VALUE:
				return basicSetExprValue(null, msgs);
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
			case OCLinEcoreCSTPackage.CONSTRAINT_CS__ANNOTATIONS:
				return getAnnotations();
			case OCLinEcoreCSTPackage.CONSTRAINT_CS__NAME:
				return getName();
			case OCLinEcoreCSTPackage.CONSTRAINT_CS__STEREOTYPE:
				return getStereotype();
			case OCLinEcoreCSTPackage.CONSTRAINT_CS__EXPR_STRING:
				return getExprString();
			case OCLinEcoreCSTPackage.CONSTRAINT_CS__EXPR_VALUE:
				return getExprValue();
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
			case OCLinEcoreCSTPackage.CONSTRAINT_CS__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends AnnotationCS>)newValue);
				return;
			case OCLinEcoreCSTPackage.CONSTRAINT_CS__NAME:
				setName((String)newValue);
				return;
			case OCLinEcoreCSTPackage.CONSTRAINT_CS__STEREOTYPE:
				setStereotype((String)newValue);
				return;
			case OCLinEcoreCSTPackage.CONSTRAINT_CS__EXPR_STRING:
				setExprString((String)newValue);
				return;
			case OCLinEcoreCSTPackage.CONSTRAINT_CS__EXPR_VALUE:
				setExprValue((OclExpressionCS)newValue);
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
			case OCLinEcoreCSTPackage.CONSTRAINT_CS__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case OCLinEcoreCSTPackage.CONSTRAINT_CS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case OCLinEcoreCSTPackage.CONSTRAINT_CS__STEREOTYPE:
				setStereotype(STEREOTYPE_EDEFAULT);
				return;
			case OCLinEcoreCSTPackage.CONSTRAINT_CS__EXPR_STRING:
				setExprString(EXPR_STRING_EDEFAULT);
				return;
			case OCLinEcoreCSTPackage.CONSTRAINT_CS__EXPR_VALUE:
				setExprValue((OclExpressionCS)null);
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
			case OCLinEcoreCSTPackage.CONSTRAINT_CS__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case OCLinEcoreCSTPackage.CONSTRAINT_CS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case OCLinEcoreCSTPackage.CONSTRAINT_CS__STEREOTYPE:
				return STEREOTYPE_EDEFAULT == null ? stereotype != null : !STEREOTYPE_EDEFAULT.equals(stereotype);
			case OCLinEcoreCSTPackage.CONSTRAINT_CS__EXPR_STRING:
				return EXPR_STRING_EDEFAULT == null ? exprString != null : !EXPR_STRING_EDEFAULT.equals(exprString);
			case OCLinEcoreCSTPackage.CONSTRAINT_CS__EXPR_VALUE:
				return exprValue != null;
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
		result.append(", stereotype: ");
		result.append(stereotype);
		result.append(", exprString: ");
		result.append(exprString);
		result.append(')');
		return result.toString();
	}

} //ConstraintCSImpl
