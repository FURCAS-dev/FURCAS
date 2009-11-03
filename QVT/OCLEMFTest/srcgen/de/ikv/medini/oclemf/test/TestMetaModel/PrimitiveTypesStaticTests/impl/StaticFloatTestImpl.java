/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl;

import de.ikv.medini.kernel.impl.MediniObjectImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage;
import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.StaticFloatTest;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Static Float Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl.StaticFloatTestImpl#getSequenceAttribute <em>Sequence Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl.StaticFloatTestImpl#getSetAttribute <em>Set Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl.StaticFloatTestImpl#getOrderedSetAttribute <em>Ordered Set Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl.StaticFloatTestImpl#getSimpleAttribute <em>Simple Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl.StaticFloatTestImpl#getOptionalSimpleAttribute <em>Optional Simple Attribute</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl.StaticFloatTestImpl#getDummy <em>Dummy</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.impl.StaticFloatTestImpl#getBagAttribute <em>Bag Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StaticFloatTestImpl extends MediniObjectImpl implements StaticFloatTest {
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
	protected static final float SIMPLE_ATTRIBUTE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getSimpleAttribute() <em>Simple Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleAttribute()
	 * @generated
	 * @ordered
	 */
	protected float simpleAttribute = SIMPLE_ATTRIBUTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOptionalSimpleAttribute() <em>Optional Simple Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionalSimpleAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final float OPTIONAL_SIMPLE_ATTRIBUTE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getOptionalSimpleAttribute() <em>Optional Simple Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionalSimpleAttribute()
	 * @generated
	 * @ordered
	 */
	protected float optionalSimpleAttribute = OPTIONAL_SIMPLE_ATTRIBUTE_EDEFAULT;

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
	protected StaticFloatTestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return PrimitiveTypesStaticTestsPackage.Literals.STATIC_FLOAT_TEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSequenceAttribute() {
		if (sequenceAttribute == null) {
			sequenceAttribute = new EDataTypeEList(Float.class, this, PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__SEQUENCE_ATTRIBUTE);
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
			setAttribute = new EDataTypeUniqueEList(Float.class, this, PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__SET_ATTRIBUTE);
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
			orderedSetAttribute = new EDataTypeUniqueEList(Float.class, this, PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__ORDERED_SET_ATTRIBUTE);
		}
		return orderedSetAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSimpleAttribute() {
		return simpleAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleAttribute(float newSimpleAttribute) {
		float oldSimpleAttribute = simpleAttribute;
		simpleAttribute = newSimpleAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__SIMPLE_ATTRIBUTE, oldSimpleAttribute, simpleAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getOptionalSimpleAttribute() {
		return optionalSimpleAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptionalSimpleAttribute(float newOptionalSimpleAttribute) {
		float oldOptionalSimpleAttribute = optionalSimpleAttribute;
		optionalSimpleAttribute = newOptionalSimpleAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__OPTIONAL_SIMPLE_ATTRIBUTE, oldOptionalSimpleAttribute, optionalSimpleAttribute));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__DUMMY, oldDummy, dummy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getBagAttribute() {
		if (bagAttribute == null) {
			bagAttribute = new EDataTypeEList(Float.class, this, PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__BAG_ATTRIBUTE);
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
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__SEQUENCE_ATTRIBUTE:
				return getSequenceAttribute();
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__SET_ATTRIBUTE:
				return getSetAttribute();
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__ORDERED_SET_ATTRIBUTE:
				return getOrderedSetAttribute();
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__SIMPLE_ATTRIBUTE:
				return new Float(getSimpleAttribute());
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__OPTIONAL_SIMPLE_ATTRIBUTE:
				return new Float(getOptionalSimpleAttribute());
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__DUMMY:
				return new Integer(getDummy());
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__BAG_ATTRIBUTE:
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
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__SEQUENCE_ATTRIBUTE:
				getSequenceAttribute().clear();
				getSequenceAttribute().addAll((Collection)newValue);
				return;
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__SET_ATTRIBUTE:
				getSetAttribute().clear();
				getSetAttribute().addAll((Collection)newValue);
				return;
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__ORDERED_SET_ATTRIBUTE:
				getOrderedSetAttribute().clear();
				getOrderedSetAttribute().addAll((Collection)newValue);
				return;
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__SIMPLE_ATTRIBUTE:
				setSimpleAttribute(((Float)newValue).floatValue());
				return;
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__OPTIONAL_SIMPLE_ATTRIBUTE:
				setOptionalSimpleAttribute(((Float)newValue).floatValue());
				return;
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__DUMMY:
				setDummy(((Integer)newValue).intValue());
				return;
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__BAG_ATTRIBUTE:
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
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__SEQUENCE_ATTRIBUTE:
				getSequenceAttribute().clear();
				return;
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__SET_ATTRIBUTE:
				getSetAttribute().clear();
				return;
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__ORDERED_SET_ATTRIBUTE:
				getOrderedSetAttribute().clear();
				return;
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__SIMPLE_ATTRIBUTE:
				setSimpleAttribute(SIMPLE_ATTRIBUTE_EDEFAULT);
				return;
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__OPTIONAL_SIMPLE_ATTRIBUTE:
				setOptionalSimpleAttribute(OPTIONAL_SIMPLE_ATTRIBUTE_EDEFAULT);
				return;
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__DUMMY:
				setDummy(DUMMY_EDEFAULT);
				return;
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__BAG_ATTRIBUTE:
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
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__SEQUENCE_ATTRIBUTE:
				return sequenceAttribute != null && !sequenceAttribute.isEmpty();
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__SET_ATTRIBUTE:
				return setAttribute != null && !setAttribute.isEmpty();
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__ORDERED_SET_ATTRIBUTE:
				return orderedSetAttribute != null && !orderedSetAttribute.isEmpty();
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__SIMPLE_ATTRIBUTE:
				return simpleAttribute != SIMPLE_ATTRIBUTE_EDEFAULT;
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__OPTIONAL_SIMPLE_ATTRIBUTE:
				return optionalSimpleAttribute != OPTIONAL_SIMPLE_ATTRIBUTE_EDEFAULT;
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__DUMMY:
				return dummy != DUMMY_EDEFAULT;
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST__BAG_ATTRIBUTE:
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
		result.append(", Dummy: ");
		result.append(dummy);
		result.append(", BagAttribute: ");
		result.append(bagAttribute);
		result.append(')');
		return result.toString();
	}

} //StaticFloatTestImpl