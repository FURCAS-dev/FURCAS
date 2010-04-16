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
 * $Id: PackageCSImpl.java,v 1.2 2010/04/16 18:05:31 ewillink Exp $
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
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationElementCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PackageCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.PackageCSImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.PackageCSImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.PackageCSImpl#getClassifiers <em>Classifiers</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.PackageCSImpl#getSubpackages <em>Subpackages</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.PackageCSImpl#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.PackageCSImpl#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageCSImpl extends MinimalEObjectImpl.Container implements PackageCS {
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
	 * The cached value of the '{@link #getClassifiers() <em>Classifiers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassifierCS> classifiers;

	/**
	 * The cached value of the '{@link #getSubpackages() <em>Subpackages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubpackages()
	 * @generated
	 * @ordered
	 */
	protected EList<PackageCS> subpackages;

	/**
	 * The default value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrefix()
	 * @generated
	 * @ordered
	 */
	protected String prefix = PREFIX_EDEFAULT;

	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected String uri = URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCLinEcoreCSTPackage.Literals.PACKAGE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnnotationElementCS> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList<AnnotationElementCS>(AnnotationElementCS.class, this, OCLinEcoreCSTPackage.PACKAGE_CS__ANNOTATIONS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, OCLinEcoreCSTPackage.PACKAGE_CS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassifierCS> getClassifiers() {
		if (classifiers == null) {
			classifiers = new EObjectContainmentEList<ClassifierCS>(ClassifierCS.class, this, OCLinEcoreCSTPackage.PACKAGE_CS__CLASSIFIERS);
		}
		return classifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PackageCS> getSubpackages() {
		if (subpackages == null) {
			subpackages = new EObjectContainmentEList<PackageCS>(PackageCS.class, this, OCLinEcoreCSTPackage.PACKAGE_CS__SUBPACKAGES);
		}
		return subpackages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrefix(String newPrefix) {
		String oldPrefix = prefix;
		prefix = newPrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLinEcoreCSTPackage.PACKAGE_CS__PREFIX, oldPrefix, prefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUri(String newUri) {
		String oldUri = uri;
		uri = newUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLinEcoreCSTPackage.PACKAGE_CS__URI, oldUri, uri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OCLinEcoreCSTPackage.PACKAGE_CS__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
			case OCLinEcoreCSTPackage.PACKAGE_CS__CLASSIFIERS:
				return ((InternalEList<?>)getClassifiers()).basicRemove(otherEnd, msgs);
			case OCLinEcoreCSTPackage.PACKAGE_CS__SUBPACKAGES:
				return ((InternalEList<?>)getSubpackages()).basicRemove(otherEnd, msgs);
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
			case OCLinEcoreCSTPackage.PACKAGE_CS__ANNOTATIONS:
				return getAnnotations();
			case OCLinEcoreCSTPackage.PACKAGE_CS__NAME:
				return getName();
			case OCLinEcoreCSTPackage.PACKAGE_CS__CLASSIFIERS:
				return getClassifiers();
			case OCLinEcoreCSTPackage.PACKAGE_CS__SUBPACKAGES:
				return getSubpackages();
			case OCLinEcoreCSTPackage.PACKAGE_CS__PREFIX:
				return getPrefix();
			case OCLinEcoreCSTPackage.PACKAGE_CS__URI:
				return getUri();
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
			case OCLinEcoreCSTPackage.PACKAGE_CS__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends AnnotationElementCS>)newValue);
				return;
			case OCLinEcoreCSTPackage.PACKAGE_CS__NAME:
				setName((String)newValue);
				return;
			case OCLinEcoreCSTPackage.PACKAGE_CS__CLASSIFIERS:
				getClassifiers().clear();
				getClassifiers().addAll((Collection<? extends ClassifierCS>)newValue);
				return;
			case OCLinEcoreCSTPackage.PACKAGE_CS__SUBPACKAGES:
				getSubpackages().clear();
				getSubpackages().addAll((Collection<? extends PackageCS>)newValue);
				return;
			case OCLinEcoreCSTPackage.PACKAGE_CS__PREFIX:
				setPrefix((String)newValue);
				return;
			case OCLinEcoreCSTPackage.PACKAGE_CS__URI:
				setUri((String)newValue);
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
			case OCLinEcoreCSTPackage.PACKAGE_CS__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case OCLinEcoreCSTPackage.PACKAGE_CS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case OCLinEcoreCSTPackage.PACKAGE_CS__CLASSIFIERS:
				getClassifiers().clear();
				return;
			case OCLinEcoreCSTPackage.PACKAGE_CS__SUBPACKAGES:
				getSubpackages().clear();
				return;
			case OCLinEcoreCSTPackage.PACKAGE_CS__PREFIX:
				setPrefix(PREFIX_EDEFAULT);
				return;
			case OCLinEcoreCSTPackage.PACKAGE_CS__URI:
				setUri(URI_EDEFAULT);
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
			case OCLinEcoreCSTPackage.PACKAGE_CS__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case OCLinEcoreCSTPackage.PACKAGE_CS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case OCLinEcoreCSTPackage.PACKAGE_CS__CLASSIFIERS:
				return classifiers != null && !classifiers.isEmpty();
			case OCLinEcoreCSTPackage.PACKAGE_CS__SUBPACKAGES:
				return subpackages != null && !subpackages.isEmpty();
			case OCLinEcoreCSTPackage.PACKAGE_CS__PREFIX:
				return PREFIX_EDEFAULT == null ? prefix != null : !PREFIX_EDEFAULT.equals(prefix);
			case OCLinEcoreCSTPackage.PACKAGE_CS__URI:
				return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals(uri);
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
		result.append(", prefix: ");
		result.append(prefix);
		result.append(", uri: ");
		result.append(uri);
		result.append(')');
		return result.toString();
	}

} //PackageCSImpl
