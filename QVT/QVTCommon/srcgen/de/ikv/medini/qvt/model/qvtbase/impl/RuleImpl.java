/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvtbase.impl;

import de.ikv.medini.qvt.model.qvtbase.Domain;
import de.ikv.medini.qvt.model.qvtbase.QvtBasePackage;
import de.ikv.medini.qvt.model.qvtbase.Rule;
import de.ikv.medini.qvt.model.qvtbase.Transformation;

import de.ikv.medini.qvt.qvt.QvtVisitor;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.oslo.ocl20.semantics.bridge.impl.NamedElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.impl.RuleImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.impl.RuleImpl#getOverrides <em>Overrides</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.impl.RuleImpl#getOverriden <em>Overriden</em>}</li>
 *   <li>{@link de.ikv.medini.qvt.model.qvtbase.impl.RuleImpl#getTransformation <em>Transformation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleImpl extends NamedElementImpl implements Rule {
	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected EList domain;

	/**
	 * The cached value of the '{@link #getOverrides() <em>Overrides</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverrides()
	 * @generated
	 * @ordered
	 */
	protected Rule overrides;

	/**
	 * The cached value of the '{@link #getOverriden() <em>Overriden</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverriden()
	 * @generated
	 * @ordered
	 */
	protected EList overriden;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return QvtBasePackage.Literals.RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDomain() {
		if (domain == null) {
			domain = new EObjectContainmentEList(Domain.class, this, QvtBasePackage.RULE__DOMAIN);
		}
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule getOverrides() {
		if (overrides != null && overrides.eIsProxy()) {
			InternalEObject oldOverrides = (InternalEObject)overrides;
			overrides = (Rule)eResolveProxy(oldOverrides);
			if (overrides != oldOverrides) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QvtBasePackage.RULE__OVERRIDES, oldOverrides, overrides));
			}
		}
		return overrides;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule basicGetOverrides() {
		return overrides;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOverrides(Rule newOverrides, NotificationChain msgs) {
		Rule oldOverrides = overrides;
		overrides = newOverrides;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QvtBasePackage.RULE__OVERRIDES, oldOverrides, newOverrides);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverrides(Rule newOverrides) {
		if (newOverrides != overrides) {
			NotificationChain msgs = null;
			if (overrides != null)
				msgs = ((InternalEObject)overrides).eInverseRemove(this, QvtBasePackage.RULE__OVERRIDEN, Rule.class, msgs);
			if (newOverrides != null)
				msgs = ((InternalEObject)newOverrides).eInverseAdd(this, QvtBasePackage.RULE__OVERRIDEN, Rule.class, msgs);
			msgs = basicSetOverrides(newOverrides, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtBasePackage.RULE__OVERRIDES, newOverrides, newOverrides));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getOverriden() {
		if (overriden == null) {
			overriden = new EObjectWithInverseResolvingEList(Rule.class, this, QvtBasePackage.RULE__OVERRIDEN, QvtBasePackage.RULE__OVERRIDES);
		}
		return overriden;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transformation getTransformation() {
		if (eContainerFeatureID != QvtBasePackage.RULE__TRANSFORMATION) return null;
		return (Transformation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransformation(Transformation newTransformation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTransformation, QvtBasePackage.RULE__TRANSFORMATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransformation(Transformation newTransformation) {
		if (newTransformation != eInternalContainer() || (eContainerFeatureID != QvtBasePackage.RULE__TRANSFORMATION && newTransformation != null)) {
			if (EcoreUtil.isAncestor(this, newTransformation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTransformation != null)
				msgs = ((InternalEObject)newTransformation).eInverseAdd(this, QvtBasePackage.TRANSFORMATION__RULE, Transformation.class, msgs);
			msgs = basicSetTransformation(newTransformation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QvtBasePackage.RULE__TRANSFORMATION, newTransformation, newTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QvtBasePackage.RULE__OVERRIDES:
				if (overrides != null)
					msgs = ((InternalEObject)overrides).eInverseRemove(this, QvtBasePackage.RULE__OVERRIDEN, Rule.class, msgs);
				return basicSetOverrides((Rule)otherEnd, msgs);
			case QvtBasePackage.RULE__OVERRIDEN:
				return ((InternalEList)getOverriden()).basicAdd(otherEnd, msgs);
			case QvtBasePackage.RULE__TRANSFORMATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTransformation((Transformation)otherEnd, msgs);
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
			case QvtBasePackage.RULE__DOMAIN:
				return ((InternalEList)getDomain()).basicRemove(otherEnd, msgs);
			case QvtBasePackage.RULE__OVERRIDES:
				return basicSetOverrides(null, msgs);
			case QvtBasePackage.RULE__OVERRIDEN:
				return ((InternalEList)getOverriden()).basicRemove(otherEnd, msgs);
			case QvtBasePackage.RULE__TRANSFORMATION:
				return basicSetTransformation(null, msgs);
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
			case QvtBasePackage.RULE__TRANSFORMATION:
				return eInternalContainer().eInverseRemove(this, QvtBasePackage.TRANSFORMATION__RULE, Transformation.class, msgs);
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
			case QvtBasePackage.RULE__DOMAIN:
				return getDomain();
			case QvtBasePackage.RULE__OVERRIDES:
				if (resolve) return getOverrides();
				return basicGetOverrides();
			case QvtBasePackage.RULE__OVERRIDEN:
				return getOverriden();
			case QvtBasePackage.RULE__TRANSFORMATION:
				return getTransformation();
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
			case QvtBasePackage.RULE__DOMAIN:
				getDomain().clear();
				getDomain().addAll((Collection)newValue);
				return;
			case QvtBasePackage.RULE__OVERRIDES:
				setOverrides((Rule)newValue);
				return;
			case QvtBasePackage.RULE__OVERRIDEN:
				getOverriden().clear();
				getOverriden().addAll((Collection)newValue);
				return;
			case QvtBasePackage.RULE__TRANSFORMATION:
				setTransformation((Transformation)newValue);
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
			case QvtBasePackage.RULE__DOMAIN:
				getDomain().clear();
				return;
			case QvtBasePackage.RULE__OVERRIDES:
				setOverrides((Rule)null);
				return;
			case QvtBasePackage.RULE__OVERRIDEN:
				getOverriden().clear();
				return;
			case QvtBasePackage.RULE__TRANSFORMATION:
				setTransformation((Transformation)null);
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
			case QvtBasePackage.RULE__DOMAIN:
				return domain != null && !domain.isEmpty();
			case QvtBasePackage.RULE__OVERRIDES:
				return overrides != null;
			case QvtBasePackage.RULE__OVERRIDEN:
				return overriden != null && !overriden.isEmpty();
			case QvtBasePackage.RULE__TRANSFORMATION:
				return getTransformation() != null;
		}
		return super.eIsSet(featureID);
	}

} //RuleImpl
