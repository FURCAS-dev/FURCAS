package com.sap.mi.fwk.ui.internal.databinding.converters;

import org.eclipse.core.databinding.conversion.Converter;

import com.sap.mi.fwk.ui.databinding.MoinObservables;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.reflect.RefEnum;

/**
 * Converts an enumeration value to the corresponding String representation.
 * 
 * @author d022960
 * 
 */
public class EnumerationTypeToStringConverter extends Converter {

	/**
	 * Construction.
	 * 
	 * @param fromType
	 *            The underlying enumeration type.
	 * @see #getFromType()
	 */
	public EnumerationTypeToStringConverter(EnumerationType fromType) {
		super(fromType, String.class);
	}

	/**
	 * Returns the result of type <code>String</code> of the conversion for the
	 * given object.
	 * 
	 * @param fromObject
	 *            the object to convert.<br>
	 *            The object is a sub-class of {@link RefEnum} which represents
	 *            the type of the enumeration values while
	 *            {@link #getFromType()} returns a sub-class of
	 *            {@link EnumerationType} which represents the enumeration type
	 *            itself.
	 * @return the converted object, of type {@link #getToType()}
	 * @see MoinObservables#unmodifiableObservableEnumerationList(com.sap.tc.moin.repository.mmi.reflect.RefObject,
	 *      com.sap.tc.moin.repository.mmi.descriptors.StructuralFeatureDescriptor)
	 */
	public Object convert(Object fromObject) {
		return fromObject.toString();
	}
	
	/**
	 * Returns type <code>String</code>. 
	 */
	@Override
	public Object getToType() {
		return super.getToType();
	}
	
	/**
	 * Returns the concrete enumeration type which is a sub-class of
	 * {@link EnumerationType}. An enumeration value is represented as an
	 * instance of {@link RefEnum}.
	 */
	@Override
	public Object getFromType() {
		return super.getFromType();
	}
}
