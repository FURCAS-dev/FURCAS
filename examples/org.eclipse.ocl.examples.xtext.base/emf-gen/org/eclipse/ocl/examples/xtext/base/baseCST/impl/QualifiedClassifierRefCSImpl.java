/**
 * <copyright>
 * </copyright>
 *
 * $Id: QualifiedClassifierRefCSImpl.java,v 1.1 2010/05/03 05:25:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.baseCST.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedClassifierRefCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified Classifier Ref CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedClassifierRefCSImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedClassifierRefCSImpl#getClassifier <em>Classifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QualifiedClassifierRefCSImpl extends ClassifierRefCSImpl implements QualifiedClassifierRefCS {
	/**
	 * The cached value of the '{@link #getNamespace() <em>Namespace</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected NamespaceCS namespace;

	/**
	 * The cached value of the '{@link #getClassifier() <em>Classifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifier()
	 * @generated
	 * @ordered
	 */
	protected ClassifierRefCS classifier;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QualifiedClassifierRefCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaseCSTPackage.Literals.QUALIFIED_CLASSIFIER_REF_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespaceCS getNamespace() {
		if (namespace != null && namespace.eIsProxy()) {
			InternalEObject oldNamespace = (InternalEObject)namespace;
			namespace = (NamespaceCS)eResolveProxy(oldNamespace);
			if (namespace != oldNamespace) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BaseCSTPackage.QUALIFIED_CLASSIFIER_REF_CS__NAMESPACE, oldNamespace, namespace));
			}
		}
		return namespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespaceCS basicGetNamespace() {
		return namespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespace(NamespaceCS newNamespace) {
		NamespaceCS oldNamespace = namespace;
		namespace = newNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.QUALIFIED_CLASSIFIER_REF_CS__NAMESPACE, oldNamespace, namespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierRefCS getClassifier() {
		return classifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClassifier(ClassifierRefCS newClassifier, NotificationChain msgs) {
		ClassifierRefCS oldClassifier = classifier;
		classifier = newClassifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BaseCSTPackage.QUALIFIED_CLASSIFIER_REF_CS__CLASSIFIER, oldClassifier, newClassifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassifier(ClassifierRefCS newClassifier) {
		if (newClassifier != classifier) {
			NotificationChain msgs = null;
			if (classifier != null)
				msgs = ((InternalEObject)classifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BaseCSTPackage.QUALIFIED_CLASSIFIER_REF_CS__CLASSIFIER, null, msgs);
			if (newClassifier != null)
				msgs = ((InternalEObject)newClassifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BaseCSTPackage.QUALIFIED_CLASSIFIER_REF_CS__CLASSIFIER, null, msgs);
			msgs = basicSetClassifier(newClassifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.QUALIFIED_CLASSIFIER_REF_CS__CLASSIFIER, newClassifier, newClassifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BaseCSTPackage.QUALIFIED_CLASSIFIER_REF_CS__CLASSIFIER:
				return basicSetClassifier(null, msgs);
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
			case BaseCSTPackage.QUALIFIED_CLASSIFIER_REF_CS__NAMESPACE:
				if (resolve) return getNamespace();
				return basicGetNamespace();
			case BaseCSTPackage.QUALIFIED_CLASSIFIER_REF_CS__CLASSIFIER:
				return getClassifier();
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
			case BaseCSTPackage.QUALIFIED_CLASSIFIER_REF_CS__NAMESPACE:
				setNamespace((NamespaceCS)newValue);
				return;
			case BaseCSTPackage.QUALIFIED_CLASSIFIER_REF_CS__CLASSIFIER:
				setClassifier((ClassifierRefCS)newValue);
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
			case BaseCSTPackage.QUALIFIED_CLASSIFIER_REF_CS__NAMESPACE:
				setNamespace((NamespaceCS)null);
				return;
			case BaseCSTPackage.QUALIFIED_CLASSIFIER_REF_CS__CLASSIFIER:
				setClassifier((ClassifierRefCS)null);
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
			case BaseCSTPackage.QUALIFIED_CLASSIFIER_REF_CS__NAMESPACE:
				return namespace != null;
			case BaseCSTPackage.QUALIFIED_CLASSIFIER_REF_CS__CLASSIFIER:
				return classifier != null;
		}
		return super.eIsSet(featureID);
	}

} //QualifiedClassifierRefCSImpl
