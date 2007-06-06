/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: ConstraintImpl.java,v 1.4 2007/06/06 18:56:37 cdamus Exp $
 */

package org.eclipse.emf.ocl.uml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENamedElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.Visitor;
import org.eclipse.emf.ocl.expressions.impl.ToStringVisitorImpl;
import org.eclipse.emf.ocl.uml.Constraint;
import org.eclipse.emf.ocl.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.uml.impl.ConstraintImpl#getInstanceVarName <em>Instance Var Name</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.uml.impl.ConstraintImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.uml.impl.ConstraintImpl#getConstrainedElement <em>Constrained Element</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.uml.impl.ConstraintImpl#getStereotype <em>Stereotype</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintImpl extends ENamedElementImpl implements Constraint {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static final String copyright = ""; //$NON-NLS-1$

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
	protected OCLExpression body;

	/**
     * The cached value of the '{@link #getConstrainedElement() <em>Constrained Element</em>}' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getConstrainedElement()
     * @generated
     * @ordered
     */
	protected EList constrainedElement;

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
        return UMLPackage.Literals.CONSTRAINT;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OCLExpression getBody() {
        return body;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetBody(OCLExpression newBody, NotificationChain msgs) {
        OCLExpression oldBody = body;
        body = newBody;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UMLPackage.CONSTRAINT__BODY, oldBody, newBody);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setBody(OCLExpression newBody) {
        if (newBody != body) {
            NotificationChain msgs = null;
            if (body != null)
                msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UMLPackage.CONSTRAINT__BODY, null, msgs);
            if (newBody != null)
                msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UMLPackage.CONSTRAINT__BODY, null, msgs);
            msgs = basicSetBody(newBody, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, UMLPackage.CONSTRAINT__BODY, newBody, newBody));
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case UMLPackage.CONSTRAINT__BODY:
                return basicSetBody(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case UMLPackage.CONSTRAINT__INSTANCE_VAR_NAME:
                return getInstanceVarName();
            case UMLPackage.CONSTRAINT__BODY:
                return getBody();
            case UMLPackage.CONSTRAINT__CONSTRAINED_ELEMENT:
                return getConstrainedElement();
            case UMLPackage.CONSTRAINT__STEREOTYPE:
                return getStereotype();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case UMLPackage.CONSTRAINT__INSTANCE_VAR_NAME:
                setInstanceVarName((String)newValue);
                return;
            case UMLPackage.CONSTRAINT__BODY:
                setBody((OCLExpression)newValue);
                return;
            case UMLPackage.CONSTRAINT__CONSTRAINED_ELEMENT:
                getConstrainedElement().clear();
                getConstrainedElement().addAll((Collection)newValue);
                return;
            case UMLPackage.CONSTRAINT__STEREOTYPE:
                setStereotype((String)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void eUnset(int featureID) {
        switch (featureID) {
            case UMLPackage.CONSTRAINT__INSTANCE_VAR_NAME:
                setInstanceVarName(INSTANCE_VAR_NAME_EDEFAULT);
                return;
            case UMLPackage.CONSTRAINT__BODY:
                setBody((OCLExpression)null);
                return;
            case UMLPackage.CONSTRAINT__CONSTRAINED_ELEMENT:
                getConstrainedElement().clear();
                return;
            case UMLPackage.CONSTRAINT__STEREOTYPE:
                setStereotype(STEREOTYPE_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public boolean eIsSet(int featureID) {
        switch (featureID) {
            case UMLPackage.CONSTRAINT__INSTANCE_VAR_NAME:
                return INSTANCE_VAR_NAME_EDEFAULT == null ? instanceVarName != null : !INSTANCE_VAR_NAME_EDEFAULT.equals(instanceVarName);
            case UMLPackage.CONSTRAINT__BODY:
                return body != null;
            case UMLPackage.CONSTRAINT__CONSTRAINED_ELEMENT:
                return constrainedElement != null && !constrainedElement.isEmpty();
            case UMLPackage.CONSTRAINT__STEREOTYPE:
                return STEREOTYPE_EDEFAULT == null ? stereotype != null : !STEREOTYPE_EDEFAULT.equals(stereotype);
        }
        return super.eIsSet(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList getConstrainedElement() {
        if (constrainedElement == null) {
            constrainedElement = new EObjectResolvingEList(ENamedElement.class, this, UMLPackage.CONSTRAINT__CONSTRAINED_ELEMENT);
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
            eNotify(new ENotificationImpl(this, Notification.SET, UMLPackage.CONSTRAINT__STEREOTYPE, oldStereotype, stereotype));
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
