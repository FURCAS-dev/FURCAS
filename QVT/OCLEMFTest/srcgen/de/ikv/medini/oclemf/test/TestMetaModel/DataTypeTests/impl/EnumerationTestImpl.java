/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl;

import de.ikv.medini.kernel.impl.MediniObjectImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage;
import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTest;
import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumeration Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.EnumerationTestImpl#getSequenceAttribute <em>Sequence Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.EnumerationTestImpl#getSetAttribute <em>Set Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.EnumerationTestImpl#getOrderedSetAttribute <em>Ordered Set Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.EnumerationTestImpl#getSimpleAttribute <em>Simple Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.EnumerationTestImpl#getOptionalSimpleAttribute <em>Optional Simple Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.EnumerationTestImpl#getBagAttribute <em>Bag Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumerationTestImpl extends MediniObjectImpl implements EnumerationTest {
	/**
	 * The cached value of the '{@link #getSequenceAttribute() <em>Sequence Attribute</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceAttribute()
	 * @generated
	 * @ordered
	 */
	protected EList sequenceAttribute = null;

	/**
	 * The cached value of the '{@link #getSetAttribute() <em>Set Attribute</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSetAttribute()
	 * @generated
	 * @ordered
	 */
	protected EList setAttribute = null;

	/**
	 * The cached value of the '{@link #getOrderedSetAttribute() <em>Ordered Set Attribute</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderedSetAttribute()
	 * @generated
	 * @ordered
	 */
	protected EList orderedSetAttribute = null;

	/**
	 * The default value of the '{@link #getSimpleAttribute() <em>Simple Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final EnumerationTestType SIMPLE_ATTRIBUTE_EDEFAULT = EnumerationTestType.LABEL3_LITERAL;

	/**
	 * The cached value of the '{@link #getSimpleAttribute() <em>Simple Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleAttribute()
	 * @generated
	 * @ordered
	 */
	protected EnumerationTestType simpleAttribute = SIMPLE_ATTRIBUTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOptionalSimpleAttribute() <em>Optional Simple Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionalSimpleAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final EnumerationTestType OPTIONAL_SIMPLE_ATTRIBUTE_EDEFAULT = EnumerationTestType.LABEL3_LITERAL;

	/**
	 * The cached value of the '{@link #getOptionalSimpleAttribute() <em>Optional Simple Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionalSimpleAttribute()
	 * @generated
	 * @ordered
	 */
	protected EnumerationTestType optionalSimpleAttribute = OPTIONAL_SIMPLE_ATTRIBUTE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBagAttribute() <em>Bag Attribute</em>}' attribute list.
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
	protected EnumerationTestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return DataTypeTestsPackage.Literals.ENUMERATION_TEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSequenceAttribute() {
		if (sequenceAttribute == null) {
			sequenceAttribute = new EDataTypeEList(EnumerationTestType.class, this, DataTypeTestsPackage.ENUMERATION_TEST__SEQUENCE_ATTRIBUTE);
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
			setAttribute = new EDataTypeUniqueEList(EnumerationTestType.class, this, DataTypeTestsPackage.ENUMERATION_TEST__SET_ATTRIBUTE);
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
			orderedSetAttribute = new EDataTypeUniqueEList(EnumerationTestType.class, this, DataTypeTestsPackage.ENUMERATION_TEST__ORDERED_SET_ATTRIBUTE);
		}
		return orderedSetAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationTestType getSimpleAttribute() {
		return simpleAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleAttribute(EnumerationTestType newSimpleAttribute) {
		EnumerationTestType oldSimpleAttribute = simpleAttribute;
		simpleAttribute = newSimpleAttribute == null ? SIMPLE_ATTRIBUTE_EDEFAULT : newSimpleAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypeTestsPackage.ENUMERATION_TEST__SIMPLE_ATTRIBUTE, oldSimpleAttribute, simpleAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationTestType getOptionalSimpleAttribute() {
		return optionalSimpleAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptionalSimpleAttribute(EnumerationTestType newOptionalSimpleAttribute) {
		EnumerationTestType oldOptionalSimpleAttribute = optionalSimpleAttribute;
		optionalSimpleAttribute = newOptionalSimpleAttribute == null ? OPTIONAL_SIMPLE_ATTRIBUTE_EDEFAULT : newOptionalSimpleAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypeTestsPackage.ENUMERATION_TEST__OPTIONAL_SIMPLE_ATTRIBUTE, oldOptionalSimpleAttribute, optionalSimpleAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getBagAttribute() {
		if (bagAttribute == null) {
			bagAttribute = new EDataTypeEList(EnumerationTestType.class, this, DataTypeTestsPackage.ENUMERATION_TEST__BAG_ATTRIBUTE);
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
			case DataTypeTestsPackage.ENUMERATION_TEST__SEQUENCE_ATTRIBUTE:
				return getSequenceAttribute();
			case DataTypeTestsPackage.ENUMERATION_TEST__SET_ATTRIBUTE:
				return getSetAttribute();
			case DataTypeTestsPackage.ENUMERATION_TEST__ORDERED_SET_ATTRIBUTE:
				return getOrderedSetAttribute();
			case DataTypeTestsPackage.ENUMERATION_TEST__SIMPLE_ATTRIBUTE:
				return getSimpleAttribute();
			case DataTypeTestsPackage.ENUMERATION_TEST__OPTIONAL_SIMPLE_ATTRIBUTE:
				return getOptionalSimpleAttribute();
			case DataTypeTestsPackage.ENUMERATION_TEST__BAG_ATTRIBUTE:
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
			case DataTypeTestsPackage.ENUMERATION_TEST__SEQUENCE_ATTRIBUTE:
				getSequenceAttribute().clear();
				getSequenceAttribute().addAll((Collection)newValue);
				return;
			case DataTypeTestsPackage.ENUMERATION_TEST__SET_ATTRIBUTE:
				getSetAttribute().clear();
				getSetAttribute().addAll((Collection)newValue);
				return;
			case DataTypeTestsPackage.ENUMERATION_TEST__ORDERED_SET_ATTRIBUTE:
				getOrderedSetAttribute().clear();
				getOrderedSetAttribute().addAll((Collection)newValue);
				return;
			case DataTypeTestsPackage.ENUMERATION_TEST__SIMPLE_ATTRIBUTE:
				setSimpleAttribute((EnumerationTestType)newValue);
				return;
			case DataTypeTestsPackage.ENUMERATION_TEST__OPTIONAL_SIMPLE_ATTRIBUTE:
				setOptionalSimpleAttribute((EnumerationTestType)newValue);
				return;
			case DataTypeTestsPackage.ENUMERATION_TEST__BAG_ATTRIBUTE:
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
			case DataTypeTestsPackage.ENUMERATION_TEST__SEQUENCE_ATTRIBUTE:
				getSequenceAttribute().clear();
				return;
			case DataTypeTestsPackage.ENUMERATION_TEST__SET_ATTRIBUTE:
				getSetAttribute().clear();
				return;
			case DataTypeTestsPackage.ENUMERATION_TEST__ORDERED_SET_ATTRIBUTE:
				getOrderedSetAttribute().clear();
				return;
			case DataTypeTestsPackage.ENUMERATION_TEST__SIMPLE_ATTRIBUTE:
				setSimpleAttribute(SIMPLE_ATTRIBUTE_EDEFAULT);
				return;
			case DataTypeTestsPackage.ENUMERATION_TEST__OPTIONAL_SIMPLE_ATTRIBUTE:
				setOptionalSimpleAttribute(OPTIONAL_SIMPLE_ATTRIBUTE_EDEFAULT);
				return;
			case DataTypeTestsPackage.ENUMERATION_TEST__BAG_ATTRIBUTE:
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
			case DataTypeTestsPackage.ENUMERATION_TEST__SEQUENCE_ATTRIBUTE:
				return sequenceAttribute != null && !sequenceAttribute.isEmpty();
			case DataTypeTestsPackage.ENUMERATION_TEST__SET_ATTRIBUTE:
				return setAttribute != null && !setAttribute.isEmpty();
			case DataTypeTestsPackage.ENUMERATION_TEST__ORDERED_SET_ATTRIBUTE:
				return orderedSetAttribute != null && !orderedSetAttribute.isEmpty();
			case DataTypeTestsPackage.ENUMERATION_TEST__SIMPLE_ATTRIBUTE:
				return simpleAttribute != SIMPLE_ATTRIBUTE_EDEFAULT;
			case DataTypeTestsPackage.ENUMERATION_TEST__OPTIONAL_SIMPLE_ATTRIBUTE:
				return optionalSimpleAttribute != OPTIONAL_SIMPLE_ATTRIBUTE_EDEFAULT;
			case DataTypeTestsPackage.ENUMERATION_TEST__BAG_ATTRIBUTE:
				return bagAttribute != null && !bagAttribute.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (SequenceAttribute: ");
		result.append(sequenceAttribute);
		result.append(", SetAttribute: ");
		result.append(setAttribute);
		result.append(", OrderedSetAttribute: ");
		result.append(orderedSetAttribute);
		result.append(", SimpleAttribute: ");
		result.append(simpleAttribute);
		result.append(", OptionalSimpleAttribute: ");
		result.append(optionalSimpleAttribute);
		result.append(", BagAttribute: ");
		result.append(bagAttribute);
		result.append(')');
		return result.toString();
	}

} //EnumerationTestImpl