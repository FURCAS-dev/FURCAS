package com.sap.mi.fwk.ui.internal.properties;

import org.eclipse.jface.viewers.ICellEditorValidator;

import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;

/**
 * This class is used to generate {@link ICellEditorValidator}s for the default
 * generic propertysheet. Currently, the standard cell types Integer, Long,
 * Double, and Float are supported. The individual validators are modeled as
 * singleton members and access exclusively via
 * {@link DynamicCellValidatorFactory#getInstance(Class)}
 * 
 * @author d024127
 */
public final class DynamicCellValidatorFactory {

	private static final ICellEditorValidator IntValidator = new IntCellValidator();
	private static final ICellEditorValidator longValidator = new LongCellValidator();
	private static final ICellEditorValidator floatValidator = new FloatCellValidator();
	private static final ICellEditorValidator doubleValidator = new DoubleCellValidator();

	/**
	 * Returns a singleton instance of the {@link ICellEditorValidator} for the
	 * given class or null if no such validator exists
	 * 
	 * @param type
	 *            The class to get a validator for
	 * @return The validator
	 */
	public static final ICellEditorValidator getInstance(Class type) {
		if (type.equals(Integer.class) || type.equals(Integer.TYPE)) {
			return IntValidator;
		}
		if (type.equals(Long.class) || type.equals(Long.TYPE)) {
			return longValidator;
		}
		if (type.equals(Float.class) || type.equals(Float.TYPE)) {
			return floatValidator;
		}
		if (type.equals(Double.class) || type.equals(Double.TYPE)) {
			return doubleValidator;
		}
		return null;
	}

	static final class IntCellValidator implements ICellEditorValidator {
		public String isValid(Object value) {
			try {
				Integer.valueOf(value.toString());
				return null;
			} catch (NumberFormatException e) { // $JL-EXC$
				return MiFwkUiMessages.bind(MiFwkUiMessages.RefObjectPropertySource_invalidInt_error, value);
			}
		}
	}

	static final class FloatCellValidator implements ICellEditorValidator {
		public String isValid(Object value) {
			try {
				Float.valueOf(value.toString());
				return null;
			} catch (NumberFormatException e) { // $JL-EXC$
				return MiFwkUiMessages.bind(MiFwkUiMessages.RefObjectPropertySource_invalidFloat_error, value);
			}
		}
	}

	static final class DoubleCellValidator implements ICellEditorValidator {
		public String isValid(Object value) {
			try {
				Double.valueOf(value.toString());
				return null;
			} catch (NumberFormatException e) { // $JL-EXC$
				return MiFwkUiMessages.bind(MiFwkUiMessages.RefObjectPropertySource_invalidDouble_error, value);
			}
		}
	}

	static final class LongCellValidator implements ICellEditorValidator {
		public String isValid(Object value) {
			try {
				Long.valueOf(value.toString());
				return null;
			} catch (NumberFormatException e) { // $JL-EXC$
				return MiFwkUiMessages.bind(MiFwkUiMessages.RefObjectPropertySource_invalidLong_error, value);
			}
		}
	}

}
