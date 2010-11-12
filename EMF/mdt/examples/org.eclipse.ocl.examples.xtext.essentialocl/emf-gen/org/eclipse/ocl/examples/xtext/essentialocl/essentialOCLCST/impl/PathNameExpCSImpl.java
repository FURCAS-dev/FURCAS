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
 * $Id: PathNameExpCSImpl.java,v 1.5 2010/05/29 15:31:44 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.util.Signature;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PathNameExpCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Path Named Element Ref CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PathNameExpCSImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PathNameExpCSImpl#getOriginalObject <em>Original Object</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PathNameExpCSImpl#getOriginalXmiId <em>Original Xmi Id</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PathNameExpCSImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.impl.PathNameExpCSImpl#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PathNameExpCSImpl extends NameExpCSImpl implements PathNameExpCS {
	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<AnnotationElementCS> annotations;

	/**
	 * The cached value of the '{@link #getOriginalObject() <em>Original Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalObject()
	 * @generated
	 * @ordered
	 */
	protected EObject originalObject;

	/**
	 * The default value of the '{@link #getOriginalXmiId() <em>Original Xmi Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalXmiId()
	 * @generated
	 * @ordered
	 */
	protected static final String ORIGINAL_XMI_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOriginalXmiId() <em>Original Xmi Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalXmiId()
	 * @generated
	 * @ordered
	 */
	protected String originalXmiId = ORIGINAL_XMI_ID_EDEFAULT;

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
	protected NameExpCS element;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PathNameExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EssentialOCLCSTPackage.Literals.PATH_NAME_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnnotationElementCS> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList<AnnotationElementCS>(AnnotationElementCS.class, this, EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getOriginalObject() {
		if (originalObject != null && originalObject.eIsProxy()) {
			InternalEObject oldOriginalObject = (InternalEObject)originalObject;
			originalObject = eResolveProxy(oldOriginalObject);
			if (originalObject != oldOriginalObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ORIGINAL_OBJECT, oldOriginalObject, originalObject));
			}
		}
		return originalObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetOriginalObject() {
		return originalObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalObject(EObject newOriginalObject) {
		EObject oldOriginalObject = originalObject;
		originalObject = newOriginalObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ORIGINAL_OBJECT, oldOriginalObject, originalObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOriginalXmiId() {
		return originalXmiId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalXmiId(String newOriginalXmiId) {
		String oldOriginalXmiId = originalXmiId;
		originalXmiId = newOriginalXmiId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ORIGINAL_XMI_ID, oldOriginalXmiId, originalXmiId));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EssentialOCLCSTPackage.PATH_NAME_EXP_CS__NAMESPACE, oldNamespace, namespace));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSTPackage.PATH_NAME_EXP_CS__NAMESPACE, oldNamespace, namespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NameExpCS getElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElement(NameExpCS newElement, NotificationChain msgs) {
		NameExpCS oldElement = element;
		element = newElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ELEMENT, oldElement, newElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(NameExpCS newElement) {
		if (newElement != element) {
			NotificationChain msgs = null;
			if (element != null)
				msgs = ((InternalEObject)element).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ELEMENT, null, msgs);
			if (newElement != null)
				msgs = ((InternalEObject)newElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ELEMENT, null, msgs);
			msgs = basicSetElement(newElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ELEMENT, newElement, newElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
			case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ELEMENT:
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
			case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ANNOTATIONS:
				return getAnnotations();
			case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ORIGINAL_OBJECT:
				if (resolve) return getOriginalObject();
				return basicGetOriginalObject();
			case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ORIGINAL_XMI_ID:
				return getOriginalXmiId();
			case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__NAMESPACE:
				if (resolve) return getNamespace();
				return basicGetNamespace();
			case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ELEMENT:
				return getElement();
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
			case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends AnnotationElementCS>)newValue);
				return;
			case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ORIGINAL_OBJECT:
				setOriginalObject((EObject)newValue);
				return;
			case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ORIGINAL_XMI_ID:
				setOriginalXmiId((String)newValue);
				return;
			case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__NAMESPACE:
				setNamespace((NamespaceCS)newValue);
				return;
			case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ELEMENT:
				setElement((NameExpCS)newValue);
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
			case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ORIGINAL_OBJECT:
				setOriginalObject((EObject)null);
				return;
			case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ORIGINAL_XMI_ID:
				setOriginalXmiId(ORIGINAL_XMI_ID_EDEFAULT);
				return;
			case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__NAMESPACE:
				setNamespace((NamespaceCS)null);
				return;
			case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ELEMENT:
				setElement((NameExpCS)null);
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
			case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ORIGINAL_OBJECT:
				return originalObject != null;
			case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ORIGINAL_XMI_ID:
				return ORIGINAL_XMI_ID_EDEFAULT == null ? originalXmiId != null : !ORIGINAL_XMI_ID_EDEFAULT.equals(originalXmiId);
			case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__NAMESPACE:
				return namespace != null;
			case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ELEMENT:
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
		if (baseClass == ModelElementCS.class) {
			switch (derivedFeatureID) {
				case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ANNOTATIONS: return BaseCSTPackage.MODEL_ELEMENT_CS__ANNOTATIONS;
				case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ORIGINAL_OBJECT: return BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_OBJECT;
				case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ORIGINAL_XMI_ID: return BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID;
				default: return -1;
			}
		}
		if (baseClass == QualifiedRefCS.class) {
			switch (derivedFeatureID) {
				case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__NAMESPACE: return BaseCSTPackage.QUALIFIED_REF_CS__NAMESPACE;
				case EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ELEMENT: return BaseCSTPackage.QUALIFIED_REF_CS__ELEMENT;
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
		if (baseClass == ModelElementCS.class) {
			switch (baseFeatureID) {
				case BaseCSTPackage.MODEL_ELEMENT_CS__ANNOTATIONS: return EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ANNOTATIONS;
				case BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_OBJECT: return EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ORIGINAL_OBJECT;
				case BaseCSTPackage.MODEL_ELEMENT_CS__ORIGINAL_XMI_ID: return EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ORIGINAL_XMI_ID;
				default: return -1;
			}
		}
		if (baseClass == QualifiedRefCS.class) {
			switch (baseFeatureID) {
				case BaseCSTPackage.QUALIFIED_REF_CS__NAMESPACE: return EssentialOCLCSTPackage.PATH_NAME_EXP_CS__NAMESPACE;
				case BaseCSTPackage.QUALIFIED_REF_CS__ELEMENT: return EssentialOCLCSTPackage.PATH_NAME_EXP_CS__ELEMENT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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

	@Override
	public NamedElementCS getNamedElement() {
//		NamespaceCS namespace = getNamespace();			// Resolve on the way down rather than wait for recursion
//		if (namespace == null) {
//			return null;
//		}
		NameExpCS element = getElement();
		if (element == null) {
			return null;
		}
		return element.getNamedElement();
	}


	@Override
	public void getSignature(Signature signature, TypeBindingsCS typeBindings) {
		signature.appendElement(getNamedElement(), typeBindings);
	}
} //PathNamedElementRefCSImpl
