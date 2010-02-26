/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.Attaching.impl;

import com.sap.tc.moin.repository.mmi.Model.Attribute;
import com.sap.tc.moin.repository.mmi.Model.Classifier;
import com.sap.tc.moin.repository.mmi.Model.Operation;
import com.sap.tc.moin.repository.mmi.Model.TypedElement;

import com.sap.tc.moin.repository.mmi.Model.impl.ConstraintImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.omg.OCL.Attaching.AttachingPackage;
import org.omg.OCL.Attaching.OclConstraint;

import org.omg.OCL.Expressions.OclExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.omg.OCL.Attaching.impl.OclConstraintImpl#getOclExpression <em>Ocl Expression</em>}</li>
 *   <li>{@link org.omg.OCL.Attaching.impl.OclConstraintImpl#getInvariantOf <em>Invariant Of</em>}</li>
 *   <li>{@link org.omg.OCL.Attaching.impl.OclConstraintImpl#getPreconditionFor <em>Precondition For</em>}</li>
 *   <li>{@link org.omg.OCL.Attaching.impl.OclConstraintImpl#getPostconditionFor <em>Postcondition For</em>}</li>
 *   <li>{@link org.omg.OCL.Attaching.impl.OclConstraintImpl#getViolationMessageExpression <em>Violation Message Expression</em>}</li>
 *   <li>{@link org.omg.OCL.Attaching.impl.OclConstraintImpl#getInitializedAttribute <em>Initialized Attribute</em>}</li>
 *   <li>{@link org.omg.OCL.Attaching.impl.OclConstraintImpl#getInitializedElement <em>Initialized Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OclConstraintImpl extends ConstraintImpl implements OclConstraint {
	/**
	 * The cached value of the '{@link #getOclExpression() <em>Ocl Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOclExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpression oclExpression;

	/**
	 * The cached value of the '{@link #getInvariantOf() <em>Invariant Of</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvariantOf()
	 * @generated
	 * @ordered
	 */
	protected EList<Classifier> invariantOf;

	/**
	 * The cached value of the '{@link #getPreconditionFor() <em>Precondition For</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreconditionFor()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> preconditionFor;

	/**
	 * The cached value of the '{@link #getPostconditionFor() <em>Postcondition For</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostconditionFor()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> postconditionFor;

	/**
	 * The cached value of the '{@link #getViolationMessageExpression() <em>Violation Message Expression</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViolationMessageExpression()
	 * @generated
	 * @ordered
	 */
	protected EList<OclExpression> violationMessageExpression;

	/**
	 * The cached value of the '{@link #getInitializedAttribute() <em>Initialized Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializedAttribute()
	 * @generated
	 * @ordered
	 */
	protected Attribute initializedAttribute;

	/**
	 * The cached value of the '{@link #getInitializedElement() <em>Initialized Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializedElement()
	 * @generated
	 * @ordered
	 */
	protected TypedElement initializedElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OclConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AttachingPackage.Literals.OCL_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getOclExpression() {
		return oclExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOclExpression(OclExpression newOclExpression, NotificationChain msgs) {
		OclExpression oldOclExpression = oclExpression;
		oclExpression = newOclExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AttachingPackage.OCL_CONSTRAINT__OCL_EXPRESSION, oldOclExpression, newOclExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOclExpression(OclExpression newOclExpression) {
		if (newOclExpression != oclExpression) {
			NotificationChain msgs = null;
			if (oclExpression != null)
				msgs = ((InternalEObject)oclExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AttachingPackage.OCL_CONSTRAINT__OCL_EXPRESSION, null, msgs);
			if (newOclExpression != null)
				msgs = ((InternalEObject)newOclExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AttachingPackage.OCL_CONSTRAINT__OCL_EXPRESSION, null, msgs);
			msgs = basicSetOclExpression(newOclExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AttachingPackage.OCL_CONSTRAINT__OCL_EXPRESSION, newOclExpression, newOclExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Classifier> getInvariantOf() {
		if (invariantOf == null) {
			invariantOf = new EObjectResolvingEList<Classifier>(Classifier.class, this, AttachingPackage.OCL_CONSTRAINT__INVARIANT_OF);
		}
		return invariantOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Operation> getPreconditionFor() {
		if (preconditionFor == null) {
			preconditionFor = new EObjectResolvingEList<Operation>(Operation.class, this, AttachingPackage.OCL_CONSTRAINT__PRECONDITION_FOR);
		}
		return preconditionFor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Operation> getPostconditionFor() {
		if (postconditionFor == null) {
			postconditionFor = new EObjectResolvingEList<Operation>(Operation.class, this, AttachingPackage.OCL_CONSTRAINT__POSTCONDITION_FOR);
		}
		return postconditionFor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OclExpression> getViolationMessageExpression() {
		if (violationMessageExpression == null) {
			violationMessageExpression = new EObjectResolvingEList<OclExpression>(OclExpression.class, this, AttachingPackage.OCL_CONSTRAINT__VIOLATION_MESSAGE_EXPRESSION);
		}
		return violationMessageExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute getInitializedAttribute() {
		if (initializedAttribute != null && initializedAttribute.eIsProxy()) {
			InternalEObject oldInitializedAttribute = (InternalEObject)initializedAttribute;
			initializedAttribute = (Attribute)eResolveProxy(oldInitializedAttribute);
			if (initializedAttribute != oldInitializedAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AttachingPackage.OCL_CONSTRAINT__INITIALIZED_ATTRIBUTE, oldInitializedAttribute, initializedAttribute));
			}
		}
		return initializedAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute basicGetInitializedAttribute() {
		return initializedAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitializedAttribute(Attribute newInitializedAttribute) {
		Attribute oldInitializedAttribute = initializedAttribute;
		initializedAttribute = newInitializedAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AttachingPackage.OCL_CONSTRAINT__INITIALIZED_ATTRIBUTE, oldInitializedAttribute, initializedAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedElement getInitializedElement() {
		if (initializedElement != null && initializedElement.eIsProxy()) {
			InternalEObject oldInitializedElement = (InternalEObject)initializedElement;
			initializedElement = (TypedElement)eResolveProxy(oldInitializedElement);
			if (initializedElement != oldInitializedElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AttachingPackage.OCL_CONSTRAINT__INITIALIZED_ELEMENT, oldInitializedElement, initializedElement));
			}
		}
		return initializedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedElement basicGetInitializedElement() {
		return initializedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitializedElement(TypedElement newInitializedElement) {
		TypedElement oldInitializedElement = initializedElement;
		initializedElement = newInitializedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AttachingPackage.OCL_CONSTRAINT__INITIALIZED_ELEMENT, oldInitializedElement, initializedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AttachingPackage.OCL_CONSTRAINT__OCL_EXPRESSION:
				return basicSetOclExpression(null, msgs);
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
			case AttachingPackage.OCL_CONSTRAINT__OCL_EXPRESSION:
				return getOclExpression();
			case AttachingPackage.OCL_CONSTRAINT__INVARIANT_OF:
				return getInvariantOf();
			case AttachingPackage.OCL_CONSTRAINT__PRECONDITION_FOR:
				return getPreconditionFor();
			case AttachingPackage.OCL_CONSTRAINT__POSTCONDITION_FOR:
				return getPostconditionFor();
			case AttachingPackage.OCL_CONSTRAINT__VIOLATION_MESSAGE_EXPRESSION:
				return getViolationMessageExpression();
			case AttachingPackage.OCL_CONSTRAINT__INITIALIZED_ATTRIBUTE:
				if (resolve) return getInitializedAttribute();
				return basicGetInitializedAttribute();
			case AttachingPackage.OCL_CONSTRAINT__INITIALIZED_ELEMENT:
				if (resolve) return getInitializedElement();
				return basicGetInitializedElement();
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
			case AttachingPackage.OCL_CONSTRAINT__OCL_EXPRESSION:
				setOclExpression((OclExpression)newValue);
				return;
			case AttachingPackage.OCL_CONSTRAINT__INVARIANT_OF:
				getInvariantOf().clear();
				getInvariantOf().addAll((Collection<? extends Classifier>)newValue);
				return;
			case AttachingPackage.OCL_CONSTRAINT__PRECONDITION_FOR:
				getPreconditionFor().clear();
				getPreconditionFor().addAll((Collection<? extends Operation>)newValue);
				return;
			case AttachingPackage.OCL_CONSTRAINT__POSTCONDITION_FOR:
				getPostconditionFor().clear();
				getPostconditionFor().addAll((Collection<? extends Operation>)newValue);
				return;
			case AttachingPackage.OCL_CONSTRAINT__VIOLATION_MESSAGE_EXPRESSION:
				getViolationMessageExpression().clear();
				getViolationMessageExpression().addAll((Collection<? extends OclExpression>)newValue);
				return;
			case AttachingPackage.OCL_CONSTRAINT__INITIALIZED_ATTRIBUTE:
				setInitializedAttribute((Attribute)newValue);
				return;
			case AttachingPackage.OCL_CONSTRAINT__INITIALIZED_ELEMENT:
				setInitializedElement((TypedElement)newValue);
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
			case AttachingPackage.OCL_CONSTRAINT__OCL_EXPRESSION:
				setOclExpression((OclExpression)null);
				return;
			case AttachingPackage.OCL_CONSTRAINT__INVARIANT_OF:
				getInvariantOf().clear();
				return;
			case AttachingPackage.OCL_CONSTRAINT__PRECONDITION_FOR:
				getPreconditionFor().clear();
				return;
			case AttachingPackage.OCL_CONSTRAINT__POSTCONDITION_FOR:
				getPostconditionFor().clear();
				return;
			case AttachingPackage.OCL_CONSTRAINT__VIOLATION_MESSAGE_EXPRESSION:
				getViolationMessageExpression().clear();
				return;
			case AttachingPackage.OCL_CONSTRAINT__INITIALIZED_ATTRIBUTE:
				setInitializedAttribute((Attribute)null);
				return;
			case AttachingPackage.OCL_CONSTRAINT__INITIALIZED_ELEMENT:
				setInitializedElement((TypedElement)null);
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
			case AttachingPackage.OCL_CONSTRAINT__OCL_EXPRESSION:
				return oclExpression != null;
			case AttachingPackage.OCL_CONSTRAINT__INVARIANT_OF:
				return invariantOf != null && !invariantOf.isEmpty();
			case AttachingPackage.OCL_CONSTRAINT__PRECONDITION_FOR:
				return preconditionFor != null && !preconditionFor.isEmpty();
			case AttachingPackage.OCL_CONSTRAINT__POSTCONDITION_FOR:
				return postconditionFor != null && !postconditionFor.isEmpty();
			case AttachingPackage.OCL_CONSTRAINT__VIOLATION_MESSAGE_EXPRESSION:
				return violationMessageExpression != null && !violationMessageExpression.isEmpty();
			case AttachingPackage.OCL_CONSTRAINT__INITIALIZED_ATTRIBUTE:
				return initializedAttribute != null;
			case AttachingPackage.OCL_CONSTRAINT__INITIALIZED_ELEMENT:
				return initializedElement != null;
		}
		return super.eIsSet(featureID);
	}

} //OclConstraintImpl
