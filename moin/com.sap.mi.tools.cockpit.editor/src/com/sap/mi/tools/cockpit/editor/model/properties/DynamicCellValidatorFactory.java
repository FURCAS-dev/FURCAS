package com.sap.mi.tools.cockpit.editor.model.properties;

import org.eclipse.jface.viewers.ICellEditorValidator;

/**
 * This class is used to generate {@link ICellEditorValidator}s for the default generic property sheet. Currently, the standard cell types
 * Integer, Long, Double, and Float are supported. The individual validators are modeled as singleton members and access exclusively via
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
	 * Returns a singleton instance of the {@link ICellEditorValidator} for the given class or null if no such validator exists
	 * 
	 * @param type
	 *            The class to get a validator for
	 * @return The validator
	 */
	public static final ICellEditorValidator getInstance(Class<?> type) {

		if (type.equals(Integer.class) || type.equals(Integer.TYPE)) {
			return DynamicCellValidatorFactory.IntValidator;
		}
		if (type.equals(Long.class) || type.equals(Long.TYPE)) {
			return DynamicCellValidatorFactory.longValidator;
		}
		if (type.equals(Float.class) || type.equals(Float.TYPE)) {
			return DynamicCellValidatorFactory.floatValidator;
		}
		if (type.equals(Double.class) || type.equals(Double.TYPE)) {
			return DynamicCellValidatorFactory.doubleValidator;
		}
		return null;
	}

	static final class IntCellValidator implements ICellEditorValidator {
		public String isValid(Object value) {

			try {
				Integer.valueOf(value.toString());
				return null;
			}
			catch (final NumberFormatException e) { // $JL-EXC$
				return "Invalid format. Expected integer value: " + value; //$NON-NLS-1$
			}
		}
	}

	static final class FloatCellValidator implements ICellEditorValidator {
		public String isValid(Object value) {

			try {
				Float.valueOf(value.toString());
				return null;
			}
			catch (final NumberFormatException e) { // $JL-EXC$
				return "Invalid format. Expected float value: " + value; //$NON-NLS-1$
			}
		}
	}

	static final class DoubleCellValidator implements ICellEditorValidator {
		public String isValid(Object value) {

			try {
				Double.valueOf(value.toString());
				return null;
			}
			catch (final NumberFormatException e) { // $JL-EXC$
				return "Invalid format. Expected double value: " + value; //$NON-NLS-1$
			}
		}
	}

	static final class LongCellValidator implements ICellEditorValidator {
		public String isValid(Object value) {

			try {
				Long.valueOf(value.toString());
				return null;
			}
			catch (final NumberFormatException e) { // $JL-EXC$
				return "Invalid format. Expected long value: " + value; //$NON-NLS-1$
			}
		}
	}

}
