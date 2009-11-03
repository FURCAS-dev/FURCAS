/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl;

import de.ikv.medini.kernel.impl.MediniObjectImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage;
import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticIntegerTest;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Static Integer Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl.StaticIntegerTestImpl#getSequenceAttribute <em>Sequence Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl.StaticIntegerTestImpl#getSetAttribute <em>Set Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl.StaticIntegerTestImpl#getOrderedSetAttribute <em>Ordered Set Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl.StaticIntegerTestImpl#getSimpleAttribute <em>Simple Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl.StaticIntegerTestImpl#getOptionalSimpleAttribute <em>Optional Simple Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl.StaticIntegerTestImpl#getBagAttribute <em>Bag Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl.StaticIntegerTestImpl#getDummy <em>Dummy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StaticIntegerTestImpl extends MediniObjectImpl implements StaticIntegerTest {
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
	protected static final int SIMPLE_ATTRIBUTE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSimpleAttribute() <em>Simple Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleAttribute()
	 * @generated
	 * @ordered
	 */
	protected int simpleAttribute = SIMPLE_ATTRIBUTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOptionalSimpleAttribute() <em>Optional Simple Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionalSimpleAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final int OPTIONAL_SIMPLE_ATTRIBUTE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOptionalSimpleAttribute() <em>Optional Simple Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionalSimpleAttribute()
	 * @generated
	 * @ordered
	 */
	protected int optionalSimpleAttribute = OPTIONAL_SIMPLE_ATTRIBUTE_EDEFAULT;

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
	 * The default value of the '{@link #getDummy() <em>Dummy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDummy()
	 * @generated
	 * @ordered
	 */
	protected static final int DUMMY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDummy() <em>Dummy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDummy()
	 * @generated
	 * @ordered
	 */
	protected int dummy = DUMMY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StaticIntegerTestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return PrimitiveTypesStaticTestsPackage.Literals.STATIC_INTEGER_TEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSequenceAttribute() {
		if (sequenceAttribute == null) {
			sequenceAttribute = new EDataTypeEList(Integer.class, this, PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__SEQUENCE_ATTRIBUTE);
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
			setAttribute = new EDataTypeUniqueEList(Integer.class, this, PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__SET_ATTRIBUTE);
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
			orderedSetAttribute = new EDataTypeUniqueEList(Integer.class, this, PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__ORDERED_SET_ATTRIBUTE);
		}
		return orderedSetAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSimpleAttribute() {
		return simpleAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleAttribute(int newSimpleAttribute) {
		int oldSimpleAttribute = simpleAttribute;
		simpleAttribute = newSimpleAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__SIMPLE_ATTRIBUTE, oldSimpleAttribute, simpleAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOptionalSimpleAttribute() {
		return optionalSimpleAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptionalSimpleAttribute(int newOptionalSimpleAttribute) {
		int oldOptionalSimpleAttribute = optionalSimpleAttribute;
		optionalSimpleAttribute = newOptionalSimpleAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__OPTIONAL_SIMPLE_ATTRIBUTE, oldOptionalSimpleAttribute, optionalSimpleAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getBagAttribute() {
		if (bagAttribute == null) {
			bagAttribute = new EDataTypeEList(Integer.class, this, PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__BAG_ATTRIBUTE);
		}
		return bagAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDummy() {
		return dummy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDummy(int newDummy) {
		int oldDummy = dummy;
		dummy = newDummy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__DUMMY, oldDummy, dummy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__SEQUENCE_ATTRIBUTE:
				return getSequenceAttribute();
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__SET_ATTRIBUTE:
				return getSetAttribute();
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__ORDERED_SET_ATTRIBUTE:
				return getOrderedSetAttribute();
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__SIMPLE_ATTRIBUTE:
				return new Integer(getSimpleAttribute());
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__OPTIONAL_SIMPLE_ATTRIBUTE:
				return new Integer(getOptionalSimpleAttribute());
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__BAG_ATTRIBUTE:
				return getBagAttribute();
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__DUMMY:
				return new Integer(getDummy());
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
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__SEQUENCE_ATTRIBUTE:
				getSequenceAttribute().clear();
				getSequenceAttribute().addAll((Collection)newValue);
				return;
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__SET_ATTRIBUTE:
				getSetAttribute().clear();
				getSetAttribute().addAll((Collection)newValue);
				return;
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__ORDERED_SET_ATTRIBUTE:
				getOrderedSetAttribute().clear();
				getOrderedSetAttribute().addAll((Collection)newValue);
				return;
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__SIMPLE_ATTRIBUTE:
				setSimpleAttribute(((Integer)newValue).intValue());
				return;
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__OPTIONAL_SIMPLE_ATTRIBUTE:
				setOptionalSimpleAttribute(((Integer)newValue).intValue());
				return;
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__BAG_ATTRIBUTE:
				getBagAttribute().clear();
				getBagAttribute().addAll((Collection)newValue);
				return;
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__DUMMY:
				setDummy(((Integer)newValue).intValue());
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
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__SEQUENCE_ATTRIBUTE:
				getSequenceAttribute().clear();
				return;
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__SET_ATTRIBUTE:
				getSetAttribute().clear();
				return;
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__ORDERED_SET_ATTRIBUTE:
				getOrderedSetAttribute().clear();
				return;
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__SIMPLE_ATTRIBUTE:
				setSimpleAttribute(SIMPLE_ATTRIBUTE_EDEFAULT);
				return;
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__OPTIONAL_SIMPLE_ATTRIBUTE:
				setOptionalSimpleAttribute(OPTIONAL_SIMPLE_ATTRIBUTE_EDEFAULT);
				return;
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__BAG_ATTRIBUTE:
				getBagAttribute().clear();
				return;
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__DUMMY:
				setDummy(DUMMY_EDEFAULT);
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
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__SEQUENCE_ATTRIBUTE:
				return sequenceAttribute != null && !sequenceAttribute.isEmpty();
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__SET_ATTRIBUTE:
				return setAttribute != null && !setAttribute.isEmpty();
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__ORDERED_SET_ATTRIBUTE:
				return orderedSetAttribute != null && !orderedSetAttribute.isEmpty();
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__SIMPLE_ATTRIBUTE:
				return simpleAttribute != SIMPLE_ATTRIBUTE_EDEFAULT;
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__OPTIONAL_SIMPLE_ATTRIBUTE:
				return optionalSimpleAttribute != OPTIONAL_SIMPLE_ATTRIBUTE_EDEFAULT;
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__BAG_ATTRIBUTE:
				return bagAttribute != null && !bagAttribute.isEmpty();
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST__DUMMY:
				return dummy != DUMMY_EDEFAULT;
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
		result.append(", Dummy: ");
		result.append(dummy);
		result.append(')');
		return result.toString();
	}

} //StaticIntegerTestImpl