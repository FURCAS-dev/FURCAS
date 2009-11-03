package com.sap.mi.fwk.ui.internal.databinding.converters;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;

import org.eclipse.core.databinding.conversion.Converter;

/**
 * Converts an enumeration value to the corresponding String representation.
 * 
 * @author d022960
 * 
 */
public class StringToEnumerationTypeConverter extends Converter {

	/**
	 * Construction.
	 * 
	 * @param toType
	 *            A representation of the concrete <code>EnumerationType</code>.
	 * @see #getToType()
	 */
	public StringToEnumerationTypeConverter(EnumerationType toType) {
		super(String.class, toType);
	}

	/**
	 * Returns the result of the conversion for the given object as type
	 * {@link RefEnum}.
	 * 
	 * @param fromObject
	 *            the object to convert. The given object has to be of type
	 *            <code>String</code>, othewise a
	 *            <code>TypeMismatchException</code> is thrown.
	 * @return the converted object, of type {@link RefEnum}
	 * @exception TypeMismatchException
	 *                in case the given object is not a valid enum value of the
	 *                corresponding {@link EnumerationType}.
	 */
	public Object convert(Object fromObject) {
		EnumerationType enumerationType = (EnumerationType) getToType();
		if (!(fromObject instanceof String)) {
			throw new TypeMismatchException(String.class, fromObject, null,
					"The object to convert is not of type String, enumeration type to convert to <" + enumerationType.getName() + ">");//$NON-NLS-1$ //$NON-NLS-2$
		}
		List<RefEnum> values = enumerationType.get___Connection().getJmiHelper().getEnumerationConstants(enumerationType);
		for (RefEnum refEnum : values) {
			if (fromObject.equals(refEnum.toString())) {
				return refEnum;
			}
		}
		throw new TypeMismatchException(
				EnumerationType.class,
				fromObject,
				null,
				"The object to convert is not a valid string representation of the corresponding enumeration type <" + enumerationType.getName() + ">, valid enum values " + values);//$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Returns the concrete enumeration type which is a sub-class of
	 * {@link EnumerationType}. An enumeration value is represented as an
	 * instance of {@link RefEnum}.
	 */
	@Override
	public Object getToType() {
		return super.getToType();
	}

	/**
	 * Returns type <code>String</code>.
	 */
	@Override
	public Object getFromType() {
		return super.getFromType();
	}
}
