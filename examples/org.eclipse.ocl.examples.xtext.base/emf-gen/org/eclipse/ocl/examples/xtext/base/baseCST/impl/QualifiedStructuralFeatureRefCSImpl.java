/**
 * <copyright>
 * </copyright>
 *
 * $Id: QualifiedStructuralFeatureRefCSImpl.java,v 1.2 2010/05/16 19:18:03 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.baseCST.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedStructuralFeatureRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureRefCS;
import org.eclipse.ocl.examples.xtext.base.util.Signature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualified Structural Feature Ref CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedStructuralFeatureRefCSImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.QualifiedStructuralFeatureRefCSImpl#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QualifiedStructuralFeatureRefCSImpl extends StructuralFeatureRefCSImpl implements QualifiedStructuralFeatureRefCS {
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
	 * The cached value of the '{@link #getElement() <em>Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected StructuralFeatureRefCS element;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QualifiedStructuralFeatureRefCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaseCSTPackage.Literals.QUALIFIED_STRUCTURAL_FEATURE_REF_CS;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BaseCSTPackage.QUALIFIED_STRUCTURAL_FEATURE_REF_CS__NAMESPACE, oldNamespace, namespace));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.QUALIFIED_STRUCTURAL_FEATURE_REF_CS__NAMESPACE, oldNamespace, namespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuralFeatureRefCS getElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElement(StructuralFeatureRefCS newElement, NotificationChain msgs) {
		StructuralFeatureRefCS oldElement = element;
		element = newElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BaseCSTPackage.QUALIFIED_STRUCTURAL_FEATURE_REF_CS__ELEMENT, oldElement, newElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(StructuralFeatureRefCS newElement) {
		if (newElement != element) {
			NotificationChain msgs = null;
			if (element != null)
				msgs = ((InternalEObject)element).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BaseCSTPackage.QUALIFIED_STRUCTURAL_FEATURE_REF_CS__ELEMENT, null, msgs);
			if (newElement != null)
				msgs = ((InternalEObject)newElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BaseCSTPackage.QUALIFIED_STRUCTURAL_FEATURE_REF_CS__ELEMENT, null, msgs);
			msgs = basicSetElement(newElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BaseCSTPackage.QUALIFIED_STRUCTURAL_FEATURE_REF_CS__ELEMENT, newElement, newElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BaseCSTPackage.QUALIFIED_STRUCTURAL_FEATURE_REF_CS__ELEMENT:
				return basicSetElement(null, msgs);
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
			case BaseCSTPackage.QUALIFIED_STRUCTURAL_FEATURE_REF_CS__NAMESPACE:
				if (resolve) return getNamespace();
				return basicGetNamespace();
			case BaseCSTPackage.QUALIFIED_STRUCTURAL_FEATURE_REF_CS__ELEMENT:
				return getElement();
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
			case BaseCSTPackage.QUALIFIED_STRUCTURAL_FEATURE_REF_CS__NAMESPACE:
				setNamespace((NamespaceCS)newValue);
				return;
			case BaseCSTPackage.QUALIFIED_STRUCTURAL_FEATURE_REF_CS__ELEMENT:
				setElement((StructuralFeatureRefCS)newValue);
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
			case BaseCSTPackage.QUALIFIED_STRUCTURAL_FEATURE_REF_CS__NAMESPACE:
				setNamespace((NamespaceCS)null);
				return;
			case BaseCSTPackage.QUALIFIED_STRUCTURAL_FEATURE_REF_CS__ELEMENT:
				setElement((StructuralFeatureRefCS)null);
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
			case BaseCSTPackage.QUALIFIED_STRUCTURAL_FEATURE_REF_CS__NAMESPACE:
				return namespace != null;
			case BaseCSTPackage.QUALIFIED_STRUCTURAL_FEATURE_REF_CS__ELEMENT:
				return element != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == QualifiedRefCS.class) {
			switch (derivedFeatureID) {
				case BaseCSTPackage.QUALIFIED_STRUCTURAL_FEATURE_REF_CS__NAMESPACE: return BaseCSTPackage.QUALIFIED_REF_CS__NAMESPACE;
				case BaseCSTPackage.QUALIFIED_STRUCTURAL_FEATURE_REF_CS__ELEMENT: return BaseCSTPackage.QUALIFIED_REF_CS__ELEMENT;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == QualifiedRefCS.class) {
			switch (baseFeatureID) {
				case BaseCSTPackage.QUALIFIED_REF_CS__NAMESPACE: return BaseCSTPackage.QUALIFIED_STRUCTURAL_FEATURE_REF_CS__NAMESPACE;
				case BaseCSTPackage.QUALIFIED_REF_CS__ELEMENT: return BaseCSTPackage.QUALIFIED_STRUCTURAL_FEATURE_REF_CS__ELEMENT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	@Override
	public void getSignature(Signature signature) {
		signature.appendElement(getElement());
	}
} //QualifiedStructuralFeatureRefCSImpl
