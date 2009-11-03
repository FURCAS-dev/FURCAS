/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.contexts.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.oslo.ocl20.semantics.OclVisitor;

import org.oslo.ocl20.semantics.bridge.Classifier;

import org.oslo.ocl20.semantics.model.contexts.ClassifierContextDecl;
import org.oslo.ocl20.semantics.model.contexts.ContextsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Classifier Context Decl</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.oslo.ocl20.semantics.model.contexts.impl.ClassifierContextDeclImpl#getReferredClassifier
 * <em>Referred Classifier</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ClassifierContextDeclImpl extends ContextDeclarationImpl implements ClassifierContextDecl {
	/**
	 * The cached value of the '{@link #getReferredClassifier() <em>Referred Classifier</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReferredClassifier()
	 * @generated
	 * @ordered
	 */
	protected Classifier referredClassifier;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ClassifierContextDeclImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ContextsPackage.Literals.CLASSIFIER_CONTEXT_DECL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Classifier getReferredClassifier() {
		if (referredClassifier != null && referredClassifier.eIsProxy()) {
			InternalEObject oldReferredClassifier = (InternalEObject) referredClassifier;
			referredClassifier = (Classifier) eResolveProxy(oldReferredClassifier);
			if (referredClassifier != oldReferredClassifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
					    ContextsPackage.CLASSIFIER_CONTEXT_DECL__REFERRED_CLASSIFIER, oldReferredClassifier,
					    referredClassifier));
			}
		}
		return referredClassifier;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Classifier basicGetReferredClassifier() {
		return referredClassifier;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setReferredClassifier(Classifier newReferredClassifier) {
		Classifier oldReferredClassifier = referredClassifier;
		referredClassifier = newReferredClassifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
			    ContextsPackage.CLASSIFIER_CONTEXT_DECL__REFERRED_CLASSIFIER, oldReferredClassifier, referredClassifier));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object accept(OclVisitor visitor, Object data) {
		return ((OclVisitor) visitor).visit(this, data);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ContextsPackage.CLASSIFIER_CONTEXT_DECL__REFERRED_CLASSIFIER:
				if (resolve)
					return getReferredClassifier();
				return basicGetReferredClassifier();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ContextsPackage.CLASSIFIER_CONTEXT_DECL__REFERRED_CLASSIFIER:
				setReferredClassifier((Classifier) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ContextsPackage.CLASSIFIER_CONTEXT_DECL__REFERRED_CLASSIFIER:
				setReferredClassifier((Classifier) null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ContextsPackage.CLASSIFIER_CONTEXT_DECL__REFERRED_CLASSIFIER:
				return referredClassifier != null;
		}
		return super.eIsSet(featureID);
	}

} // ClassifierContextDeclImpl
