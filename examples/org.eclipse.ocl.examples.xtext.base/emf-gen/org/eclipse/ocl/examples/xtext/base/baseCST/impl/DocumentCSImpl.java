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
 * $Id: DocumentCSImpl.java,v 1.2 2010/05/16 19:18:03 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.xtext.base.baseCST.DocumentCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundOperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.LibraryCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.DocumentCSImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.DocumentCSImpl#getLibraries <em>Libraries</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.DocumentCSImpl#getBoundClassifiers <em>Bound Classifiers</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.impl.DocumentCSImpl#getBoundOperations <em>Bound Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DocumentCSImpl extends NamedElementCSImpl implements DocumentCS {
	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<ImportCS> imports;
	/**
	 * The cached value of the '{@link #getLibraries() <em>Libraries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibraries()
	 * @generated
	 * @ordered
	 */
	protected EList<LibraryCS> libraries;

	/**
	 * The cached value of the '{@link #getBoundClassifiers() <em>Bound Classifiers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundClassifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<BoundClassifierCS> boundClassifiers;
	/**
	 * The cached value of the '{@link #getBoundOperations() <em>Bound Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<BoundOperationCS> boundOperations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BaseCSTPackage.Literals.DOCUMENT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ImportCS> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<ImportCS>(ImportCS.class, this, BaseCSTPackage.DOCUMENT_CS__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LibraryCS> getLibraries() {
		if (libraries == null) {
			libraries = new EObjectContainmentEList<LibraryCS>(LibraryCS.class, this, BaseCSTPackage.DOCUMENT_CS__LIBRARIES);
		}
		return libraries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BoundClassifierCS> getBoundClassifiers() {
		if (boundClassifiers == null) {
			boundClassifiers = new EObjectContainmentEList<BoundClassifierCS>(BoundClassifierCS.class, this, BaseCSTPackage.DOCUMENT_CS__BOUND_CLASSIFIERS);
		}
		return boundClassifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BoundOperationCS> getBoundOperations() {
		if (boundOperations == null) {
			boundOperations = new EObjectContainmentEList<BoundOperationCS>(BoundOperationCS.class, this, BaseCSTPackage.DOCUMENT_CS__BOUND_OPERATIONS);
		}
		return boundOperations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BaseCSTPackage.DOCUMENT_CS__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
			case BaseCSTPackage.DOCUMENT_CS__LIBRARIES:
				return ((InternalEList<?>)getLibraries()).basicRemove(otherEnd, msgs);
			case BaseCSTPackage.DOCUMENT_CS__BOUND_CLASSIFIERS:
				return ((InternalEList<?>)getBoundClassifiers()).basicRemove(otherEnd, msgs);
			case BaseCSTPackage.DOCUMENT_CS__BOUND_OPERATIONS:
				return ((InternalEList<?>)getBoundOperations()).basicRemove(otherEnd, msgs);
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
			case BaseCSTPackage.DOCUMENT_CS__IMPORTS:
				return getImports();
			case BaseCSTPackage.DOCUMENT_CS__LIBRARIES:
				return getLibraries();
			case BaseCSTPackage.DOCUMENT_CS__BOUND_CLASSIFIERS:
				return getBoundClassifiers();
			case BaseCSTPackage.DOCUMENT_CS__BOUND_OPERATIONS:
				return getBoundOperations();
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
			case BaseCSTPackage.DOCUMENT_CS__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends ImportCS>)newValue);
				return;
			case BaseCSTPackage.DOCUMENT_CS__LIBRARIES:
				getLibraries().clear();
				getLibraries().addAll((Collection<? extends LibraryCS>)newValue);
				return;
			case BaseCSTPackage.DOCUMENT_CS__BOUND_CLASSIFIERS:
				getBoundClassifiers().clear();
				getBoundClassifiers().addAll((Collection<? extends BoundClassifierCS>)newValue);
				return;
			case BaseCSTPackage.DOCUMENT_CS__BOUND_OPERATIONS:
				getBoundOperations().clear();
				getBoundOperations().addAll((Collection<? extends BoundOperationCS>)newValue);
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
			case BaseCSTPackage.DOCUMENT_CS__IMPORTS:
				getImports().clear();
				return;
			case BaseCSTPackage.DOCUMENT_CS__LIBRARIES:
				getLibraries().clear();
				return;
			case BaseCSTPackage.DOCUMENT_CS__BOUND_CLASSIFIERS:
				getBoundClassifiers().clear();
				return;
			case BaseCSTPackage.DOCUMENT_CS__BOUND_OPERATIONS:
				getBoundOperations().clear();
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
			case BaseCSTPackage.DOCUMENT_CS__IMPORTS:
				return imports != null && !imports.isEmpty();
			case BaseCSTPackage.DOCUMENT_CS__LIBRARIES:
				return libraries != null && !libraries.isEmpty();
			case BaseCSTPackage.DOCUMENT_CS__BOUND_CLASSIFIERS:
				return boundClassifiers != null && !boundClassifiers.isEmpty();
			case BaseCSTPackage.DOCUMENT_CS__BOUND_OPERATIONS:
				return boundOperations != null && !boundOperations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DocumentCSImpl
