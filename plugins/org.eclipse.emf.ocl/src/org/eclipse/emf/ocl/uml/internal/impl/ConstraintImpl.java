/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.ocl.uml.internal.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENamedElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.expressions.Visitor;
import org.eclipse.emf.ocl.expressions.internal.impl.ToStringVisitorImpl;
import org.eclipse.emf.ocl.uml.Constraint;
import org.eclipse.emf.ocl.uml.UmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.uml.internal.impl.ConstraintImpl#getInstanceVarName <em>Instance Var Name</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.uml.internal.impl.ConstraintImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.uml.internal.impl.ConstraintImpl#getConstrainedElement <em>Constrained Element</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.uml.internal.impl.ConstraintImpl#getStereotype <em>Stereotype</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintImpl extends ENamedElementImpl implements Constraint {
	/**
	 * The default value of the '{@link #getInstanceVarName() <em>Instance Var Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceVarName()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTANCE_VAR_NAME_EDEFAULT = null;

	/**
	 * Records the name of the variable used as "self" in the body of the constraint
	 */
	private String instanceVarName = null;
	
	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected OclExpression body = null;

	/**
	 * The cached value of the '{@link #getConstrainedElement() <em>Constrained Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstrainedElement()
	 * @generated
	 * @ordered
	 */
	protected EList constrainedElement = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UmlPackage.eINSTANCE.getConstraint();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(OclExpression newBody, NotificationChain msgs) {
		OclExpression oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlPackage.CONSTRAINT__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * @return the variable name for "self" in the body of the expression
	 */
	public String getInstanceVarName() {
		return instanceVarName;
	}
	
	/**
	 * Sets the instance var name
	 */
	public void setInstanceVarName(String instanceVarName) {
		this.instanceVarName = instanceVarName;
	}
	
	public Object accept(Visitor v) {
		return v.visitConstraint(this);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(OclExpression newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmlPackage.CONSTRAINT__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmlPackage.CONSTRAINT__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlPackage.CONSTRAINT__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getConstrainedElement() {
		if (constrainedElement == null) {
			constrainedElement = new EObjectResolvingEList(ENamedElement.class, this, UmlPackage.CONSTRAINT__CONSTRAINED_ELEMENT);
		}
		return constrainedElement;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UmlPackage.CONSTRAINT__STEREOTYPE, oldStereotype, stereotype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case UmlPackage.CONSTRAINT__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicAdd(otherEnd, msgs);
				default:
					return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
			}
		}
		if (eContainer != null)
			msgs = eBasicRemoveFromContainer(msgs);
		return eBasicSetContainer(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case UmlPackage.CONSTRAINT__EANNOTATIONS:
					return ((InternalEList)getEAnnotations()).basicRemove(otherEnd, msgs);
				case UmlPackage.CONSTRAINT__BODY:
					return basicSetBody(null, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case UmlPackage.CONSTRAINT__EANNOTATIONS:
				return getEAnnotations();
			case UmlPackage.CONSTRAINT__NAME:
				return getName();
			case UmlPackage.CONSTRAINT__INSTANCE_VAR_NAME:
				return getInstanceVarName();
			case UmlPackage.CONSTRAINT__BODY:
				return getBody();
			case UmlPackage.CONSTRAINT__CONSTRAINED_ELEMENT:
				return getConstrainedElement();
			case UmlPackage.CONSTRAINT__STEREOTYPE:
				return getStereotype();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case UmlPackage.CONSTRAINT__EANNOTATIONS:
				getEAnnotations().clear();
				getEAnnotations().addAll((Collection)newValue);
				return;
			case UmlPackage.CONSTRAINT__NAME:
				setName((String)newValue);
				return;
			case UmlPackage.CONSTRAINT__INSTANCE_VAR_NAME:
				setInstanceVarName((String)newValue);
				return;
			case UmlPackage.CONSTRAINT__BODY:
				setBody((OclExpression)newValue);
				return;
			case UmlPackage.CONSTRAINT__CONSTRAINED_ELEMENT:
				getConstrainedElement().clear();
				getConstrainedElement().addAll((Collection)newValue);
				return;
			case UmlPackage.CONSTRAINT__STEREOTYPE:
				setStereotype((String)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case UmlPackage.CONSTRAINT__EANNOTATIONS:
				getEAnnotations().clear();
				return;
			case UmlPackage.CONSTRAINT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UmlPackage.CONSTRAINT__INSTANCE_VAR_NAME:
				setInstanceVarName(INSTANCE_VAR_NAME_EDEFAULT);
				return;
			case UmlPackage.CONSTRAINT__BODY:
				setBody((OclExpression)null);
				return;
			case UmlPackage.CONSTRAINT__CONSTRAINED_ELEMENT:
				getConstrainedElement().clear();
				return;
			case UmlPackage.CONSTRAINT__STEREOTYPE:
				setStereotype(STEREOTYPE_EDEFAULT);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case UmlPackage.CONSTRAINT__EANNOTATIONS:
				return eAnnotations != null && !eAnnotations.isEmpty();
			case UmlPackage.CONSTRAINT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UmlPackage.CONSTRAINT__INSTANCE_VAR_NAME:
				return INSTANCE_VAR_NAME_EDEFAULT == null ? instanceVarName != null : !INSTANCE_VAR_NAME_EDEFAULT.equals(instanceVarName);
			case UmlPackage.CONSTRAINT__BODY:
				return body != null;
			case UmlPackage.CONSTRAINT__CONSTRAINED_ELEMENT:
				return constrainedElement != null && !constrainedElement.isEmpty();
			case UmlPackage.CONSTRAINT__STEREOTYPE:
				return STEREOTYPE_EDEFAULT == null ? stereotype != null : !STEREOTYPE_EDEFAULT.equals(stereotype);
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String toString() {
		return (String) accept(ToStringVisitorImpl.getInstance());
	}

} //ConstraintImpl
