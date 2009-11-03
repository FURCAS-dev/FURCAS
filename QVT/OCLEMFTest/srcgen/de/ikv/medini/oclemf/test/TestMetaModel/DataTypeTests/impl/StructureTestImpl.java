/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl;

import de.ikv.medini.kernel.impl.MediniObjectImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage;
import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTest;
import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structure Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.StructureTestImpl#getSequenceAttribute <em>Sequence Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.StructureTestImpl#getSetAttribute <em>Set Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.StructureTestImpl#getOrderedSetAttribute <em>Ordered Set Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.StructureTestImpl#getSimpleAttribute <em>Simple Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.StructureTestImpl#getOptionalSimpleAttribute <em>Optional Simple Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.StructureTestImpl#getBagAttribute <em>Bag Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StructureTestImpl extends MediniObjectImpl implements StructureTest {
	/**
	 * The cached value of the '{@link #getSequenceAttribute() <em>Sequence Attribute</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceAttribute()
	 * @generated
	 * @ordered
	 */
	protected EList sequenceAttribute = null;

	/**
	 * The cached value of the '{@link #getSetAttribute() <em>Set Attribute</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetAttribute()
	 * @generated
	 * @ordered
	 */
	protected EList setAttribute = null;

	/**
	 * The cached value of the '{@link #getOrderedSetAttribute() <em>Ordered Set Attribute</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderedSetAttribute()
	 * @generated
	 * @ordered
	 */
	protected EList orderedSetAttribute = null;

	/**
	 * The cached value of the '{@link #getSimpleAttribute() <em>Simple Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleAttribute()
	 * @generated
	 * @ordered
	 */
	protected StructureTestType simpleAttribute = null;

	/**
	 * The cached value of the '{@link #getOptionalSimpleAttribute() <em>Optional Simple Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionalSimpleAttribute()
	 * @generated
	 * @ordered
	 */
	protected StructureTestType optionalSimpleAttribute = null;

	/**
	 * The cached value of the '{@link #getBagAttribute() <em>Bag Attribute</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBagAttribute()
	 * @generated
	 * @ordered
	 */
	protected EList bagAttribute = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructureTestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return DataTypeTestsPackage.Literals.STRUCTURE_TEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSequenceAttribute() {
		if (sequenceAttribute == null) {
			sequenceAttribute = new EObjectResolvingEList(StructureTestType.class, this, DataTypeTestsPackage.STRUCTURE_TEST__SEQUENCE_ATTRIBUTE);
		}
		return sequenceAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSetAttribute() {
		if (setAttribute == null) {
			setAttribute = new EObjectResolvingEList(StructureTestType.class, this, DataTypeTestsPackage.STRUCTURE_TEST__SET_ATTRIBUTE);
		}
		return setAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getOrderedSetAttribute() {
		if (orderedSetAttribute == null) {
			orderedSetAttribute = new EObjectResolvingEList(StructureTestType.class, this, DataTypeTestsPackage.STRUCTURE_TEST__ORDERED_SET_ATTRIBUTE);
		}
		return orderedSetAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructureTestType getSimpleAttribute() {
		if (simpleAttribute != null && simpleAttribute.eIsProxy()) {
			InternalEObject oldSimpleAttribute = (InternalEObject)simpleAttribute;
			simpleAttribute = (StructureTestType)eResolveProxy(oldSimpleAttribute);
			if (simpleAttribute != oldSimpleAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataTypeTestsPackage.STRUCTURE_TEST__SIMPLE_ATTRIBUTE, oldSimpleAttribute, simpleAttribute));
			}
		}
		return simpleAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructureTestType basicGetSimpleAttribute() {
		return simpleAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleAttribute(StructureTestType newSimpleAttribute) {
		StructureTestType oldSimpleAttribute = simpleAttribute;
		simpleAttribute = newSimpleAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypeTestsPackage.STRUCTURE_TEST__SIMPLE_ATTRIBUTE, oldSimpleAttribute, simpleAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructureTestType getOptionalSimpleAttribute() {
		if (optionalSimpleAttribute != null && optionalSimpleAttribute.eIsProxy()) {
			InternalEObject oldOptionalSimpleAttribute = (InternalEObject)optionalSimpleAttribute;
			optionalSimpleAttribute = (StructureTestType)eResolveProxy(oldOptionalSimpleAttribute);
			if (optionalSimpleAttribute != oldOptionalSimpleAttribute) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataTypeTestsPackage.STRUCTURE_TEST__OPTIONAL_SIMPLE_ATTRIBUTE, oldOptionalSimpleAttribute, optionalSimpleAttribute));
			}
		}
		return optionalSimpleAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructureTestType basicGetOptionalSimpleAttribute() {
		return optionalSimpleAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptionalSimpleAttribute(StructureTestType newOptionalSimpleAttribute) {
		StructureTestType oldOptionalSimpleAttribute = optionalSimpleAttribute;
		optionalSimpleAttribute = newOptionalSimpleAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypeTestsPackage.STRUCTURE_TEST__OPTIONAL_SIMPLE_ATTRIBUTE, oldOptionalSimpleAttribute, optionalSimpleAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getBagAttribute() {
		if (bagAttribute == null) {
			bagAttribute = new EObjectResolvingEList(StructureTestType.class, this, DataTypeTestsPackage.STRUCTURE_TEST__BAG_ATTRIBUTE);
		}
		return bagAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataTypeTestsPackage.STRUCTURE_TEST__SEQUENCE_ATTRIBUTE:
				return getSequenceAttribute();
			case DataTypeTestsPackage.STRUCTURE_TEST__SET_ATTRIBUTE:
				return getSetAttribute();
			case DataTypeTestsPackage.STRUCTURE_TEST__ORDERED_SET_ATTRIBUTE:
				return getOrderedSetAttribute();
			case DataTypeTestsPackage.STRUCTURE_TEST__SIMPLE_ATTRIBUTE:
				if (resolve) return getSimpleAttribute();
				return basicGetSimpleAttribute();
			case DataTypeTestsPackage.STRUCTURE_TEST__OPTIONAL_SIMPLE_ATTRIBUTE:
				if (resolve) return getOptionalSimpleAttribute();
				return basicGetOptionalSimpleAttribute();
			case DataTypeTestsPackage.STRUCTURE_TEST__BAG_ATTRIBUTE:
				return getBagAttribute();
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
			case DataTypeTestsPackage.STRUCTURE_TEST__SEQUENCE_ATTRIBUTE:
				getSequenceAttribute().clear();
				getSequenceAttribute().addAll((Collection)newValue);
				return;
			case DataTypeTestsPackage.STRUCTURE_TEST__SET_ATTRIBUTE:
				getSetAttribute().clear();
				getSetAttribute().addAll((Collection)newValue);
				return;
			case DataTypeTestsPackage.STRUCTURE_TEST__ORDERED_SET_ATTRIBUTE:
				getOrderedSetAttribute().clear();
				getOrderedSetAttribute().addAll((Collection)newValue);
				return;
			case DataTypeTestsPackage.STRUCTURE_TEST__SIMPLE_ATTRIBUTE:
				setSimpleAttribute((StructureTestType)newValue);
				return;
			case DataTypeTestsPackage.STRUCTURE_TEST__OPTIONAL_SIMPLE_ATTRIBUTE:
				setOptionalSimpleAttribute((StructureTestType)newValue);
				return;
			case DataTypeTestsPackage.STRUCTURE_TEST__BAG_ATTRIBUTE:
				getBagAttribute().clear();
				getBagAttribute().addAll((Collection)newValue);
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
			case DataTypeTestsPackage.STRUCTURE_TEST__SEQUENCE_ATTRIBUTE:
				getSequenceAttribute().clear();
				return;
			case DataTypeTestsPackage.STRUCTURE_TEST__SET_ATTRIBUTE:
				getSetAttribute().clear();
				return;
			case DataTypeTestsPackage.STRUCTURE_TEST__ORDERED_SET_ATTRIBUTE:
				getOrderedSetAttribute().clear();
				return;
			case DataTypeTestsPackage.STRUCTURE_TEST__SIMPLE_ATTRIBUTE:
				setSimpleAttribute((StructureTestType)null);
				return;
			case DataTypeTestsPackage.STRUCTURE_TEST__OPTIONAL_SIMPLE_ATTRIBUTE:
				setOptionalSimpleAttribute((StructureTestType)null);
				return;
			case DataTypeTestsPackage.STRUCTURE_TEST__BAG_ATTRIBUTE:
				getBagAttribute().clear();
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
			case DataTypeTestsPackage.STRUCTURE_TEST__SEQUENCE_ATTRIBUTE:
				return sequenceAttribute != null && !sequenceAttribute.isEmpty();
			case DataTypeTestsPackage.STRUCTURE_TEST__SET_ATTRIBUTE:
				return setAttribute != null && !setAttribute.isEmpty();
			case DataTypeTestsPackage.STRUCTURE_TEST__ORDERED_SET_ATTRIBUTE:
				return orderedSetAttribute != null && !orderedSetAttribute.isEmpty();
			case DataTypeTestsPackage.STRUCTURE_TEST__SIMPLE_ATTRIBUTE:
				return simpleAttribute != null;
			case DataTypeTestsPackage.STRUCTURE_TEST__OPTIONAL_SIMPLE_ATTRIBUTE:
				return optionalSimpleAttribute != null;
			case DataTypeTestsPackage.STRUCTURE_TEST__BAG_ATTRIBUTE:
				return bagAttribute != null && !bagAttribute.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StructureTestImpl