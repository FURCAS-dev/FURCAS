package org.eclipse.emf.query2.syntax;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.util.Strings;

public class QueryTypeConverter extends DefaultTerminalConverters {

	@ValueConverter(rule = "SINGED_LONG")
	public IValueConverter<Long> SINGED_LONG() {
		return new IValueConverter<Long>() {

			public Long toValue(String string, AbstractNode node) {
				if (Strings.isEmpty(string))
					throw new ValueConverterException(Messages.Query2StringSyntax_QueryTypeConverter_CouldNotConvertStringToInt, node, null);
				try {
					return Long.valueOf(string);
				} catch (NumberFormatException e) {
					throw new ValueConverterException(Messages.getString(Messages.Query2StringSyntax_QueryTypeConverter_CouldNotConvertStringToNumber, new String[] { string }),
							node, e);
				}
			}

			public String toString(Long value) {
				return value.toString();
			}

		};
	}

	@ValueConverter(rule = "SIGNED_DOUBLE")
	public IValueConverter<Double> SIGNED_DOUBLE() {
		return new IValueConverter<Double>() {

			public Double toValue(String string, AbstractNode node) {
				if (Strings.isEmpty(string))
					throw new ValueConverterException(Messages.Query2StringSyntax_QueryTypeConverter_CouldNotConvertStringToInt, node, null);
				try {
					return Double.valueOf(string);
				} catch (NumberFormatException e) {
					throw new ValueConverterException(Messages.getString(Messages.Query2StringSyntax_QueryTypeConverter_CouldNotConvertStringToNumber, new String[] { string }),
							node, e);
				}
			}

			public String toString(Double value) {
				return value.toString();
			}

		};
	}
}
