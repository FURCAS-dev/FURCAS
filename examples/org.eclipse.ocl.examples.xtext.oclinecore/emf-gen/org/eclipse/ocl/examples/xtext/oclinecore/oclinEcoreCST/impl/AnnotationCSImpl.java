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
 * $Id: AnnotationCSImpl.java,v 1.5 2010/05/24 08:55:13 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.AnnotationElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.util.Signature;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Annotation CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.AnnotationCSImpl#getIdSource <em>Id Source</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.AnnotationCSImpl#getStringSource <em>String Source</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.AnnotationCSImpl#getContents <em>Contents</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl.AnnotationCSImpl#getReferences <em>References</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnnotationCSImpl extends AnnotationElementCSImpl implements AnnotationCS {
	/**
	 * The default value of the '{@link #getIdSource() <em>Id Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdSource()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_SOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdSource() <em>Id Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdSource()
	 * @generated
	 * @ordered
	 */
	protected String idSource = ID_SOURCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStringSource() <em>String Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringSource()
	 * @generated
	 * @ordered
	 */
	protected static final String STRING_SOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStringSource() <em>String Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringSource()
	 * @generated
	 * @ordered
	 */
	protected String stringSource = STRING_SOURCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContents() <em>Contents</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContents()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementCS> contents;

	/**
	 * The cached value of the '{@link #getReferences() <em>References</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementCSRef> references;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnnotationCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OCLinEcoreCSTPackage.Literals.ANNOTATION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdSource() {
		return idSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdSource(String newIdSource) {
		String oldIdSource = idSource;
		idSource = newIdSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLinEcoreCSTPackage.ANNOTATION_CS__ID_SOURCE, oldIdSource, idSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStringSource() {
		return stringSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStringSource(String newStringSource) {
		String oldStringSource = stringSource;
		stringSource = newStringSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OCLinEcoreCSTPackage.ANNOTATION_CS__STRING_SOURCE, oldStringSource, stringSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementCS> getContents() {
		if (contents == null) {
			contents = new EObjectContainmentEList<ModelElementCS>(ModelElementCS.class, this, OCLinEcoreCSTPackage.ANNOTATION_CS__CONTENTS);
		}
		return contents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementCSRef> getReferences() {
		if (references == null) {
			references = new EObjectContainmentEList<ModelElementCSRef>(ModelElementCSRef.class, this, OCLinEcoreCSTPackage.ANNOTATION_CS__REFERENCES);
		}
		return references;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OCLinEcoreCSTPackage.ANNOTATION_CS__CONTENTS:
				return ((InternalEList<?>)getContents()).basicRemove(otherEnd, msgs);
			case OCLinEcoreCSTPackage.ANNOTATION_CS__REFERENCES:
				return ((InternalEList<?>)getReferences()).basicRemove(otherEnd, msgs);
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
			case OCLinEcoreCSTPackage.ANNOTATION_CS__ID_SOURCE:
				return getIdSource();
			case OCLinEcoreCSTPackage.ANNOTATION_CS__STRING_SOURCE:
				return getStringSource();
			case OCLinEcoreCSTPackage.ANNOTATION_CS__CONTENTS:
				return getContents();
			case OCLinEcoreCSTPackage.ANNOTATION_CS__REFERENCES:
				return getReferences();
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
			case OCLinEcoreCSTPackage.ANNOTATION_CS__ID_SOURCE:
				setIdSource((String)newValue);
				return;
			case OCLinEcoreCSTPackage.ANNOTATION_CS__STRING_SOURCE:
				setStringSource((String)newValue);
				return;
			case OCLinEcoreCSTPackage.ANNOTATION_CS__CONTENTS:
				getContents().clear();
				getContents().addAll((Collection<? extends ModelElementCS>)newValue);
				return;
			case OCLinEcoreCSTPackage.ANNOTATION_CS__REFERENCES:
				getReferences().clear();
				getReferences().addAll((Collection<? extends ModelElementCSRef>)newValue);
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
			case OCLinEcoreCSTPackage.ANNOTATION_CS__ID_SOURCE:
				setIdSource(ID_SOURCE_EDEFAULT);
				return;
			case OCLinEcoreCSTPackage.ANNOTATION_CS__STRING_SOURCE:
				setStringSource(STRING_SOURCE_EDEFAULT);
				return;
			case OCLinEcoreCSTPackage.ANNOTATION_CS__CONTENTS:
				getContents().clear();
				return;
			case OCLinEcoreCSTPackage.ANNOTATION_CS__REFERENCES:
				getReferences().clear();
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
			case OCLinEcoreCSTPackage.ANNOTATION_CS__ID_SOURCE:
				return ID_SOURCE_EDEFAULT == null ? idSource != null : !ID_SOURCE_EDEFAULT.equals(idSource);
			case OCLinEcoreCSTPackage.ANNOTATION_CS__STRING_SOURCE:
				return STRING_SOURCE_EDEFAULT == null ? stringSource != null : !STRING_SOURCE_EDEFAULT.equals(stringSource);
			case OCLinEcoreCSTPackage.ANNOTATION_CS__CONTENTS:
				return contents != null && !contents.isEmpty();
			case OCLinEcoreCSTPackage.ANNOTATION_CS__REFERENCES:
				return references != null && !references.isEmpty();
		}
		return super.eIsSet(featureID);
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
	public void getSignature(Signature signature, TypeBindingsCS typeBindings) {
		signature.appendParent(this, "::", typeBindings);
		signature.append('"');
		signature.append(String.valueOf(getIdSource()));
		signature.append('"');
	}

} //AnnotationCSImpl
