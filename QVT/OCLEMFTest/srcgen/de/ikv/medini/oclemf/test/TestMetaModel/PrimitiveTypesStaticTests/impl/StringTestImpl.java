/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl;

import de.ikv.medini.kernel.impl.MediniObjectImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage;
import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StringTest;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>String Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl.StringTestImpl#getSimpleAttribute <em>Simple Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl.StringTestImpl#getOptionalSimpleAttribute <em>Optional Simple Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl.StringTestImpl#getSequenceAttribute <em>Sequence Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl.StringTestImpl#getSetAttribute <em>Set Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl.StringTestImpl#getOrderedSetAttribute <em>Ordered Set Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl.StringTestImpl#getDummy <em>Dummy</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl.StringTestImpl#getBagAttribute <em>Bag Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StringTestImpl extends MediniObjectImpl implements StringTest {
	/**
	 * The default value of the '{@link #getSimpleAttribute() <em>Simple Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final String SIMPLE_ATTRIBUTE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getSimpleAttribute() <em>Simple Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleAttribute()
	 * @generated
	 * @ordered
	 */
	protected String simpleAttribute = SIMPLE_ATTRIBUTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOptionalSimpleAttribute() <em>Optional Simple Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionalSimpleAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final String OPTIONAL_SIMPLE_ATTRIBUTE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getOptionalSimpleAttribute() <em>Optional Simple Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionalSimpleAttribute()
	 * @generated
	 * @ordered
	 */
	protected String optionalSimpleAttribute = OPTIONAL_SIMPLE_ATTRIBUTE_EDEFAULT;

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
	protected StringTestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return PrimitiveTypesStaticTestsPackage.Literals.STRING_TEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSimpleAttribute() {
		return simpleAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleAttribute(String newSimpleAttribute) {
		String oldSimpleAttribute = simpleAttribute;
		simpleAttribute = newSimpleAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PrimitiveTypesStaticTestsPackage.STRING_TEST__SIMPLE_ATTRIBUTE, oldSimpleAttribute, simpleAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOptionalSimpleAttribute() {
		return optionalSimpleAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptionalSimpleAttribute(String newOptionalSimpleAttribute) {
		String oldOptionalSimpleAttribute = optionalSimpleAttribute;
		optionalSimpleAttribute = newOptionalSimpleAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PrimitiveTypesStaticTestsPackage.STRING_TEST__OPTIONAL_SIMPLE_ATTRIBUTE, oldOptionalSimpleAttribute, optionalSimpleAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSequenceAttribute() {
		if (sequenceAttribute == null) {
			sequenceAttribute = new EDataTypeEList(String.class, this, PrimitiveTypesStaticTestsPackage.STRING_TEST__SEQUENCE_ATTRIBUTE);
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
			setAttribute = new EDataTypeUniqueEList(String.class, this, PrimitiveTypesStaticTestsPackage.STRING_TEST__SET_ATTRIBUTE);
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
			orderedSetAttribute = new EDataTypeUniqueEList(String.class, this, PrimitiveTypesStaticTestsPackage.STRING_TEST__ORDERED_SET_ATTRIBUTE);
		}
		return orderedSetAttribute;
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
			eNotify(new ENotificationImpl(this, Notification.SET, PrimitiveTypesStaticTestsPackage.STRING_TEST__DUMMY, oldDummy, dummy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getBagAttribute() {
		if (bagAttribute == null) {
			bagAttribute = new EDataTypeEList(String.class, this, PrimitiveTypesStaticTestsPackage.STRING_TEST__BAG_ATTRIBUTE);
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
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__SIMPLE_ATTRIBUTE:
				return getSimpleAttribute();
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__OPTIONAL_SIMPLE_ATTRIBUTE:
				return getOptionalSimpleAttribute();
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__SEQUENCE_ATTRIBUTE:
				return getSequenceAttribute();
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__SET_ATTRIBUTE:
				return getSetAttribute();
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__ORDERED_SET_ATTRIBUTE:
				return getOrderedSetAttribute();
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__DUMMY:
				return new Integer(getDummy());
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__BAG_ATTRIBUTE:
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
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__SIMPLE_ATTRIBUTE:
				setSimpleAttribute((String)newValue);
				return;
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__OPTIONAL_SIMPLE_ATTRIBUTE:
				setOptionalSimpleAttribute((String)newValue);
				return;
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__SEQUENCE_ATTRIBUTE:
				getSequenceAttribute().clear();
				getSequenceAttribute().addAll((Collection)newValue);
				return;
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__SET_ATTRIBUTE:
				getSetAttribute().clear();
				getSetAttribute().addAll((Collection)newValue);
				return;
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__ORDERED_SET_ATTRIBUTE:
				getOrderedSetAttribute().clear();
				getOrderedSetAttribute().addAll((Collection)newValue);
				return;
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__DUMMY:
				setDummy(((Integer)newValue).intValue());
				return;
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__BAG_ATTRIBUTE:
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
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__SIMPLE_ATTRIBUTE:
				setSimpleAttribute(SIMPLE_ATTRIBUTE_EDEFAULT);
				return;
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__OPTIONAL_SIMPLE_ATTRIBUTE:
				setOptionalSimpleAttribute(OPTIONAL_SIMPLE_ATTRIBUTE_EDEFAULT);
				return;
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__SEQUENCE_ATTRIBUTE:
				getSequenceAttribute().clear();
				return;
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__SET_ATTRIBUTE:
				getSetAttribute().clear();
				return;
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__ORDERED_SET_ATTRIBUTE:
				getOrderedSetAttribute().clear();
				return;
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__DUMMY:
				setDummy(DUMMY_EDEFAULT);
				return;
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__BAG_ATTRIBUTE:
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
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__SIMPLE_ATTRIBUTE:
				return SIMPLE_ATTRIBUTE_EDEFAULT == null ? simpleAttribute != null : !SIMPLE_ATTRIBUTE_EDEFAULT.equals(simpleAttribute);
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__OPTIONAL_SIMPLE_ATTRIBUTE:
				return OPTIONAL_SIMPLE_ATTRIBUTE_EDEFAULT == null ? optionalSimpleAttribute != null : !OPTIONAL_SIMPLE_ATTRIBUTE_EDEFAULT.equals(optionalSimpleAttribute);
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__SEQUENCE_ATTRIBUTE:
				return sequenceAttribute != null && !sequenceAttribute.isEmpty();
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__SET_ATTRIBUTE:
				return setAttribute != null && !setAttribute.isEmpty();
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__ORDERED_SET_ATTRIBUTE:
				return orderedSetAttribute != null && !orderedSetAttribute.isEmpty();
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__DUMMY:
				return dummy != DUMMY_EDEFAULT;
			case PrimitiveTypesStaticTestsPackage.STRING_TEST__BAG_ATTRIBUTE:
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
		result.append(" (SimpleAttribute: ");
		result.append(simpleAttribute);
		result.append(", OptionalSimpleAttribute: ");
		result.append(optionalSimpleAttribute);
		result.append(", SequenceAttribute: ");
		result.append(sequenceAttribute);
		result.append(", SetAttribute: ");
		result.append(setAttribute);
		result.append(", OrderedSetAttribute: ");
		result.append(orderedSetAttribute);
		result.append(", Dummy: ");
		result.append(dummy);
		result.append(", BagAttribute: ");
		result.append(bagAttribute);
		result.append(')');
		return result.toString();
	}

} //StringTestImpl