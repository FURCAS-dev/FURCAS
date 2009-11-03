/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl;

import de.ikv.medini.kernel.impl.MediniObjectImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticBooleanTest;
import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StringTest;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.IntegerTest;

import de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.ClassTest;
import de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.RelationshipTestsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl.ClassTestImpl#getMultiClassReference <em>Multi Class Reference</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl.ClassTestImpl#getSingleClassReference <em>Single Class Reference</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl.ClassTestImpl#getSingleClassAttribute <em>Single Class Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl.ClassTestImpl#getMultiUniqueClassAttribute <em>Multi Unique Class Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.RelationshipTests.impl.ClassTestImpl#getMultiNonUniqueClassAttribute <em>Multi Non Unique Class Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassTestImpl extends MediniObjectImpl implements ClassTest {
	/**
	 * The cached value of the '{@link #getMultiClassReference() <em>Multi Class Reference</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiClassReference()
	 * @generated
	 * @ordered
	 */
	protected EList multiClassReference = null;

	/**
	 * The cached value of the '{@link #getSingleClassReference() <em>Single Class Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingleClassReference()
	 * @generated
	 * @ordered
	 */
	protected StringTest singleClassReference = null;

	/**
	 * The cached value of the '{@link #getSingleClassAttribute() <em>Single Class Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingleClassAttribute()
	 * @generated
	 * @ordered
	 */
	protected de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.StringTest singleClassAttribute = null;

	/**
	 * The cached value of the '{@link #getMultiUniqueClassAttribute() <em>Multi Unique Class Attribute</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiUniqueClassAttribute()
	 * @generated
	 * @ordered
	 */
	protected EList multiUniqueClassAttribute = null;

	/**
	 * The cached value of the '{@link #getMultiNonUniqueClassAttribute() <em>Multi Non Unique Class Attribute</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiNonUniqueClassAttribute()
	 * @generated
	 * @ordered
	 */
	protected EList multiNonUniqueClassAttribute = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassTestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return RelationshipTestsPackage.Literals.CLASS_TEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getMultiClassReference() {
		if (multiClassReference == null) {
			multiClassReference = new EObjectResolvingEList(StaticBooleanTest.class, this, RelationshipTestsPackage.CLASS_TEST__MULTI_CLASS_REFERENCE);
		}
		return multiClassReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringTest getSingleClassReference() {
		if (singleClassReference != null && singleClassReference.eIsProxy()) {
			InternalEObject oldSingleClassReference = (InternalEObject)singleClassReference;
			singleClassReference = (StringTest)eResolveProxy(oldSingleClassReference);
			if (singleClassReference != oldSingleClassReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationshipTestsPackage.CLASS_TEST__SINGLE_CLASS_REFERENCE, oldSingleClassReference, singleClassReference));
			}
		}
		return singleClassReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringTest basicGetSingleClassReference() {
		return singleClassReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSingleClassReference(StringTest newSingleClassReference) {
		StringTest oldSingleClassReference = singleClassReference;
		singleClassReference = newSingleClassReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationshipTestsPackage.CLASS_TEST__SINGLE_CLASS_REFERENCE, oldSingleClassReference, singleClassReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.StringTest getSingleClassAttribute() {
		if (singleClassAttribute != null && singleClassAttribute.eIsProxy()) {
			InternalEObject oldSingleClassAttribute = (InternalEObject)singleClassAttribute;
			singleClassAttribute = (de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.StringTest)eResolveProxy(oldSingleClassAttribute);
			if (singleClassAttribute != oldSingleClassAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationshipTestsPackage.CLASS_TEST__SINGLE_CLASS_ATTRIBUTE, oldSingleClassAttribute, singleClassAttribute));
			}
		}
		return singleClassAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.StringTest basicGetSingleClassAttribute() {
		return singleClassAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSingleClassAttribute(de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.StringTest newSingleClassAttribute) {
		de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.StringTest oldSingleClassAttribute = singleClassAttribute;
		singleClassAttribute = newSingleClassAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationshipTestsPackage.CLASS_TEST__SINGLE_CLASS_ATTRIBUTE, oldSingleClassAttribute, singleClassAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getMultiUniqueClassAttribute() {
		if (multiUniqueClassAttribute == null) {
			multiUniqueClassAttribute = new EObjectResolvingEList(IntegerTest.class, this, RelationshipTestsPackage.CLASS_TEST__MULTI_UNIQUE_CLASS_ATTRIBUTE);
		}
		return multiUniqueClassAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getMultiNonUniqueClassAttribute() {
		if (multiNonUniqueClassAttribute == null) {
			multiNonUniqueClassAttribute = new EObjectResolvingEList(de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.StringTest.class, this, RelationshipTestsPackage.CLASS_TEST__MULTI_NON_UNIQUE_CLASS_ATTRIBUTE);
		}
		return multiNonUniqueClassAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RelationshipTestsPackage.CLASS_TEST__MULTI_CLASS_REFERENCE:
				return getMultiClassReference();
			case RelationshipTestsPackage.CLASS_TEST__SINGLE_CLASS_REFERENCE:
				if (resolve) return getSingleClassReference();
				return basicGetSingleClassReference();
			case RelationshipTestsPackage.CLASS_TEST__SINGLE_CLASS_ATTRIBUTE:
				if (resolve) return getSingleClassAttribute();
				return basicGetSingleClassAttribute();
			case RelationshipTestsPackage.CLASS_TEST__MULTI_UNIQUE_CLASS_ATTRIBUTE:
				return getMultiUniqueClassAttribute();
			case RelationshipTestsPackage.CLASS_TEST__MULTI_NON_UNIQUE_CLASS_ATTRIBUTE:
				return getMultiNonUniqueClassAttribute();
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
			case RelationshipTestsPackage.CLASS_TEST__MULTI_CLASS_REFERENCE:
				getMultiClassReference().clear();
				getMultiClassReference().addAll((Collection)newValue);
				return;
			case RelationshipTestsPackage.CLASS_TEST__SINGLE_CLASS_REFERENCE:
				setSingleClassReference((StringTest)newValue);
				return;
			case RelationshipTestsPackage.CLASS_TEST__SINGLE_CLASS_ATTRIBUTE:
				setSingleClassAttribute((de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.StringTest)newValue);
				return;
			case RelationshipTestsPackage.CLASS_TEST__MULTI_UNIQUE_CLASS_ATTRIBUTE:
				getMultiUniqueClassAttribute().clear();
				getMultiUniqueClassAttribute().addAll((Collection)newValue);
				return;
			case RelationshipTestsPackage.CLASS_TEST__MULTI_NON_UNIQUE_CLASS_ATTRIBUTE:
				getMultiNonUniqueClassAttribute().clear();
				getMultiNonUniqueClassAttribute().addAll((Collection)newValue);
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
			case RelationshipTestsPackage.CLASS_TEST__MULTI_CLASS_REFERENCE:
				getMultiClassReference().clear();
				return;
			case RelationshipTestsPackage.CLASS_TEST__SINGLE_CLASS_REFERENCE:
				setSingleClassReference((StringTest)null);
				return;
			case RelationshipTestsPackage.CLASS_TEST__SINGLE_CLASS_ATTRIBUTE:
				setSingleClassAttribute((de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.StringTest)null);
				return;
			case RelationshipTestsPackage.CLASS_TEST__MULTI_UNIQUE_CLASS_ATTRIBUTE:
				getMultiUniqueClassAttribute().clear();
				return;
			case RelationshipTestsPackage.CLASS_TEST__MULTI_NON_UNIQUE_CLASS_ATTRIBUTE:
				getMultiNonUniqueClassAttribute().clear();
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
			case RelationshipTestsPackage.CLASS_TEST__MULTI_CLASS_REFERENCE:
				return multiClassReference != null && !multiClassReference.isEmpty();
			case RelationshipTestsPackage.CLASS_TEST__SINGLE_CLASS_REFERENCE:
				return singleClassReference != null;
			case RelationshipTestsPackage.CLASS_TEST__SINGLE_CLASS_ATTRIBUTE:
				return singleClassAttribute != null;
			case RelationshipTestsPackage.CLASS_TEST__MULTI_UNIQUE_CLASS_ATTRIBUTE:
				return multiUniqueClassAttribute != null && !multiUniqueClassAttribute.isEmpty();
			case RelationshipTestsPackage.CLASS_TEST__MULTI_NON_UNIQUE_CLASS_ATTRIBUTE:
				return multiNonUniqueClassAttribute != null && !multiNonUniqueClassAttribute.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ClassTestImpl