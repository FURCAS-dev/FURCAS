/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvtbase.impl;

import de.ikv.medini.qvt.model.qvtbase.Pattern;
import de.ikv.medini.qvt.model.qvtbase.Predicate;
import de.ikv.medini.qvt.model.qvtbase.QvtBasePackage;

import de.ikv.medini.qvt.qvt.QvtVisitor;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.oslo.ocl20.semantics.OclVisitor;
import org.oslo.ocl20.semantics.bridge.impl.ElementImpl;

import org.oslo.ocl20.semantics.model.expressions.OclExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Predicate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.impl.PredicateImpl#getContitionExpression <em>Contition Expression</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.impl.PredicateImpl#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PredicateImpl extends ElementImpl implements Predicate {
	/**
	 * The cached value of the '{@link #getContitionExpression() <em>Contition Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContitionExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpression contitionExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PredicateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return QvtBasePackage.Literals.PREDICATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getContitionExpression() {
		return contitionExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContitionExpression(OclExpression newContitionExpression, NotificationChain msgs) {
		OclExpression oldContitionExpression = contitionExpression;
		contitionExpression = newContitionExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtBasePackage.PREDICATE__CONTITION_EXPRESSION, oldContitionExpression, newContitionExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContitionExpression(OclExpression newContitionExpression) {
		if (newContitionExpression != contitionExpression) {
			NotificationChain msgs = null;
			if (contitionExpression != null)
				msgs = ((InternalEObject)contitionExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QvtBasePackage.PREDICATE__CONTITION_EXPRESSION, null, msgs);
			if (newContitionExpression != null)
				msgs = ((InternalEObject)newContitionExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QvtBasePackage.PREDICATE__CONTITION_EXPRESSION, null, msgs);
			msgs = basicSetContitionExpression(newContitionExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtBasePackage.PREDICATE__CONTITION_EXPRESSION, newContitionExpression, newContitionExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern getPattern() {
		if (eContainerFeatureID != QvtBasePackage.PREDICATE__PATTERN) return null;
		return (Pattern)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPattern(Pattern newPattern, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPattern, QvtBasePackage.PREDICATE__PATTERN, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPattern(Pattern newPattern) {
		if (newPattern != eInternalContainer() || (eContainerFeatureID != QvtBasePackage.PREDICATE__PATTERN && newPattern != null)) {
			if (EcoreUtil.isAncestor(this, newPattern))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPattern != null)
				msgs = ((InternalEObject)newPattern).eInverseAdd(this, QvtBasePackage.PATTERN__PREDICATE, Pattern.class, msgs);
			msgs = basicSetPattern(newPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtBasePackage.PREDICATE__PATTERN, newPattern, newPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object accept(OclVisitor visitor, Object data) {
		return ((QvtVisitor)visitor).visit(this,data);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QvtBasePackage.PREDICATE__PATTERN:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPattern((Pattern)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QvtBasePackage.PREDICATE__CONTITION_EXPRESSION:
				return basicSetContitionExpression(null, msgs);
			case QvtBasePackage.PREDICATE__PATTERN:
				return basicSetPattern(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case QvtBasePackage.PREDICATE__PATTERN:
				return eInternalContainer().eInverseRemove(this, QvtBasePackage.PATTERN__PREDICATE, Pattern.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QvtBasePackage.PREDICATE__CONTITION_EXPRESSION:
				return getContitionExpression();
			case QvtBasePackage.PREDICATE__PATTERN:
				return getPattern();
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
			case QvtBasePackage.PREDICATE__CONTITION_EXPRESSION:
				setContitionExpression((OclExpression)newValue);
				return;
			case QvtBasePackage.PREDICATE__PATTERN:
				setPattern((Pattern)newValue);
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
			case QvtBasePackage.PREDICATE__CONTITION_EXPRESSION:
				setContitionExpression((OclExpression)null);
				return;
			case QvtBasePackage.PREDICATE__PATTERN:
				setPattern((Pattern)null);
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
			case QvtBasePackage.PREDICATE__CONTITION_EXPRESSION:
				return contitionExpression != null;
			case QvtBasePackage.PREDICATE__PATTERN:
				return getPattern() != null;
		}
		return super.eIsSet(featureID);
	}

} //PredicateImpl
