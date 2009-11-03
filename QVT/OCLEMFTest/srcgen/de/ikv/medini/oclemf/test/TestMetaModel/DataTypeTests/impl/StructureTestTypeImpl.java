/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl;

import de.ikv.medini.kernel.impl.MediniObjectImpl;

import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.DataTypeTestsPackage;
import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.EnumerationTestType;
import de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.StructureTestType;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.StringTest;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structure Test Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.StructureTestTypeImpl#getIntegerStructField <em>Integer Struct Field</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.StructureTestTypeImpl#getEnumStructField <em>Enum Struct Field</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.StructureTestTypeImpl#getStringStructField <em>String Struct Field</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.StructureTestTypeImpl#isBooleanStructField <em>Boolean Struct Field</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.StructureTestTypeImpl#getFloatStructureField <em>Float Structure Field</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.StructureTestTypeImpl#getDoubleStructureField <em>Double Structure Field</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.StructureTestTypeImpl#getLongStructField <em>Long Struct Field</em>}</li>
 *   <li>{@link de.ikv.medini.oclemf.test.TestMetaModel.DataTypeTests.impl.StructureTestTypeImpl#getClassStructField <em>Class Struct Field</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StructureTestTypeImpl extends MediniObjectImpl implements StructureTestType {
	/**
	 * The default value of the '{@link #getIntegerStructField() <em>Integer Struct Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegerStructField()
	 * @generated
	 * @ordered
	 */
	protected static final int INTEGER_STRUCT_FIELD_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIntegerStructField() <em>Integer Struct Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegerStructField()
	 * @generated
	 * @ordered
	 */
	protected int integerStructField = INTEGER_STRUCT_FIELD_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnumStructField() <em>Enum Struct Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumStructField()
	 * @generated
	 * @ordered
	 */
	protected static final EnumerationTestType ENUM_STRUCT_FIELD_EDEFAULT = EnumerationTestType.LABEL3_LITERAL;

	/**
	 * The cached value of the '{@link #getEnumStructField() <em>Enum Struct Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumStructField()
	 * @generated
	 * @ordered
	 */
	protected EnumerationTestType enumStructField = ENUM_STRUCT_FIELD_EDEFAULT;

	/**
	 * The default value of the '{@link #getStringStructField() <em>String Struct Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringStructField()
	 * @generated
	 * @ordered
	 */
	protected static final String STRING_STRUCT_FIELD_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getStringStructField() <em>String Struct Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringStructField()
	 * @generated
	 * @ordered
	 */
	protected String stringStructField = STRING_STRUCT_FIELD_EDEFAULT;

	/**
	 * The default value of the '{@link #isBooleanStructField() <em>Boolean Struct Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBooleanStructField()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BOOLEAN_STRUCT_FIELD_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBooleanStructField() <em>Boolean Struct Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBooleanStructField()
	 * @generated
	 * @ordered
	 */
	protected boolean booleanStructField = BOOLEAN_STRUCT_FIELD_EDEFAULT;

	/**
	 * The default value of the '{@link #getFloatStructureField() <em>Float Structure Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFloatStructureField()
	 * @generated
	 * @ordered
	 */
	protected static final float FLOAT_STRUCTURE_FIELD_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getFloatStructureField() <em>Float Structure Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFloatStructureField()
	 * @generated
	 * @ordered
	 */
	protected float floatStructureField = FLOAT_STRUCTURE_FIELD_EDEFAULT;

	/**
	 * The default value of the '{@link #getDoubleStructureField() <em>Double Structure Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoubleStructureField()
	 * @generated
	 * @ordered
	 */
	protected static final double DOUBLE_STRUCTURE_FIELD_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getDoubleStructureField() <em>Double Structure Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoubleStructureField()
	 * @generated
	 * @ordered
	 */
	protected double doubleStructureField = DOUBLE_STRUCTURE_FIELD_EDEFAULT;

	/**
	 * The default value of the '{@link #getLongStructField() <em>Long Struct Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongStructField()
	 * @generated
	 * @ordered
	 */
	protected static final long LONG_STRUCT_FIELD_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getLongStructField() <em>Long Struct Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongStructField()
	 * @generated
	 * @ordered
	 */
	protected long longStructField = LONG_STRUCT_FIELD_EDEFAULT;

	/**
	 * The cached value of the '{@link #getClassStructField() <em>Class Struct Field</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassStructField()
	 * @generated
	 * @ordered
	 */
	protected StringTest classStructField = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructureTestTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return DataTypeTestsPackage.Literals.STRUCTURE_TEST_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIntegerStructField() {
		return integerStructField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntegerStructField(int newIntegerStructField) {
		int oldIntegerStructField = integerStructField;
		integerStructField = newIntegerStructField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypeTestsPackage.STRUCTURE_TEST_TYPE__INTEGER_STRUCT_FIELD, oldIntegerStructField, integerStructField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationTestType getEnumStructField() {
		return enumStructField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnumStructField(EnumerationTestType newEnumStructField) {
		EnumerationTestType oldEnumStructField = enumStructField;
		enumStructField = newEnumStructField == null ? ENUM_STRUCT_FIELD_EDEFAULT : newEnumStructField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypeTestsPackage.STRUCTURE_TEST_TYPE__ENUM_STRUCT_FIELD, oldEnumStructField, enumStructField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStringStructField() {
		return stringStructField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStringStructField(String newStringStructField) {
		String oldStringStructField = stringStructField;
		stringStructField = newStringStructField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypeTestsPackage.STRUCTURE_TEST_TYPE__STRING_STRUCT_FIELD, oldStringStructField, stringStructField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBooleanStructField() {
		return booleanStructField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBooleanStructField(boolean newBooleanStructField) {
		boolean oldBooleanStructField = booleanStructField;
		booleanStructField = newBooleanStructField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypeTestsPackage.STRUCTURE_TEST_TYPE__BOOLEAN_STRUCT_FIELD, oldBooleanStructField, booleanStructField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFloatStructureField() {
		return floatStructureField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFloatStructureField(float newFloatStructureField) {
		float oldFloatStructureField = floatStructureField;
		floatStructureField = newFloatStructureField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypeTestsPackage.STRUCTURE_TEST_TYPE__FLOAT_STRUCTURE_FIELD, oldFloatStructureField, floatStructureField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDoubleStructureField() {
		return doubleStructureField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDoubleStructureField(double newDoubleStructureField) {
		double oldDoubleStructureField = doubleStructureField;
		doubleStructureField = newDoubleStructureField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypeTestsPackage.STRUCTURE_TEST_TYPE__DOUBLE_STRUCTURE_FIELD, oldDoubleStructureField, doubleStructureField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getLongStructField() {
		return longStructField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongStructField(long newLongStructField) {
		long oldLongStructField = longStructField;
		longStructField = newLongStructField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypeTestsPackage.STRUCTURE_TEST_TYPE__LONG_STRUCT_FIELD, oldLongStructField, longStructField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringTest getClassStructField() {
		if (classStructField != null && classStructField.eIsProxy()) {
			InternalEObject oldClassStructField = (InternalEObject)classStructField;
			classStructField = (StringTest)eResolveProxy(oldClassStructField);
			if (classStructField != oldClassStructField) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DataTypeTestsPackage.STRUCTURE_TEST_TYPE__CLASS_STRUCT_FIELD, oldClassStructField, classStructField));
			}
		}
		return classStructField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringTest basicGetClassStructField() {
		return classStructField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassStructField(StringTest newClassStructField) {
		StringTest oldClassStructField = classStructField;
		classStructField = newClassStructField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DataTypeTestsPackage.STRUCTURE_TEST_TYPE__CLASS_STRUCT_FIELD, oldClassStructField, classStructField));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__INTEGER_STRUCT_FIELD:
				return new Integer(getIntegerStructField());
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__ENUM_STRUCT_FIELD:
				return getEnumStructField();
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__STRING_STRUCT_FIELD:
				return getStringStructField();
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__BOOLEAN_STRUCT_FIELD:
				return isBooleanStructField() ? Boolean.TRUE : Boolean.FALSE;
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__FLOAT_STRUCTURE_FIELD:
				return new Float(getFloatStructureField());
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__DOUBLE_STRUCTURE_FIELD:
				return new Double(getDoubleStructureField());
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__LONG_STRUCT_FIELD:
				return new Long(getLongStructField());
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__CLASS_STRUCT_FIELD:
				if (resolve) return getClassStructField();
				return basicGetClassStructField();
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
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__INTEGER_STRUCT_FIELD:
				setIntegerStructField(((Integer)newValue).intValue());
				return;
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__ENUM_STRUCT_FIELD:
				setEnumStructField((EnumerationTestType)newValue);
				return;
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__STRING_STRUCT_FIELD:
				setStringStructField((String)newValue);
				return;
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__BOOLEAN_STRUCT_FIELD:
				setBooleanStructField(((Boolean)newValue).booleanValue());
				return;
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__FLOAT_STRUCTURE_FIELD:
				setFloatStructureField(((Float)newValue).floatValue());
				return;
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__DOUBLE_STRUCTURE_FIELD:
				setDoubleStructureField(((Double)newValue).doubleValue());
				return;
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__LONG_STRUCT_FIELD:
				setLongStructField(((Long)newValue).longValue());
				return;
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__CLASS_STRUCT_FIELD:
				setClassStructField((StringTest)newValue);
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
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__INTEGER_STRUCT_FIELD:
				setIntegerStructField(INTEGER_STRUCT_FIELD_EDEFAULT);
				return;
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__ENUM_STRUCT_FIELD:
				setEnumStructField(ENUM_STRUCT_FIELD_EDEFAULT);
				return;
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__STRING_STRUCT_FIELD:
				setStringStructField(STRING_STRUCT_FIELD_EDEFAULT);
				return;
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__BOOLEAN_STRUCT_FIELD:
				setBooleanStructField(BOOLEAN_STRUCT_FIELD_EDEFAULT);
				return;
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__FLOAT_STRUCTURE_FIELD:
				setFloatStructureField(FLOAT_STRUCTURE_FIELD_EDEFAULT);
				return;
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__DOUBLE_STRUCTURE_FIELD:
				setDoubleStructureField(DOUBLE_STRUCTURE_FIELD_EDEFAULT);
				return;
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__LONG_STRUCT_FIELD:
				setLongStructField(LONG_STRUCT_FIELD_EDEFAULT);
				return;
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__CLASS_STRUCT_FIELD:
				setClassStructField((StringTest)null);
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
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__INTEGER_STRUCT_FIELD:
				return integerStructField != INTEGER_STRUCT_FIELD_EDEFAULT;
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__ENUM_STRUCT_FIELD:
				return enumStructField != ENUM_STRUCT_FIELD_EDEFAULT;
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__STRING_STRUCT_FIELD:
				return STRING_STRUCT_FIELD_EDEFAULT == null ? stringStructField != null : !STRING_STRUCT_FIELD_EDEFAULT.equals(stringStructField);
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__BOOLEAN_STRUCT_FIELD:
				return booleanStructField != BOOLEAN_STRUCT_FIELD_EDEFAULT;
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__FLOAT_STRUCTURE_FIELD:
				return floatStructureField != FLOAT_STRUCTURE_FIELD_EDEFAULT;
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__DOUBLE_STRUCTURE_FIELD:
				return doubleStructureField != DOUBLE_STRUCTURE_FIELD_EDEFAULT;
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__LONG_STRUCT_FIELD:
				return longStructField != LONG_STRUCT_FIELD_EDEFAULT;
			case DataTypeTestsPackage.STRUCTURE_TEST_TYPE__CLASS_STRUCT_FIELD:
				return classStructField != null;
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
		result.append(" (IntegerStructField: ");
		result.append(integerStructField);
		result.append(", EnumStructField: ");
		result.append(enumStructField);
		result.append(", StringStructField: ");
		result.append(stringStructField);
		result.append(", BooleanStructField: ");
		result.append(booleanStructField);
		result.append(", FloatStructureField: ");
		result.append(floatStructureField);
		result.append(", DoubleStructureField: ");
		result.append(doubleStructureField);
		result.append(", LongStructField: ");
		result.append(longStructField);
		result.append(')');
		return result.toString();
	}

} //StructureTestTypeImpl