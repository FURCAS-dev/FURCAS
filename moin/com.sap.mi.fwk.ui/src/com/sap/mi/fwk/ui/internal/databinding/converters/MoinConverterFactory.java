package com.sap.mi.fwk.ui.internal.databinding.converters;

import org.eclipse.core.databinding.conversion.IConverter;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;

public class MoinConverterFactory {
	private MoinConverterFactory() {
	}
	
	/**
	 * Creates the appropriate MOIN converter or <code>null</code> in case a specific converter is not required.  
	 * @param fromType the type to convert from 
	 * @param toType the type to convert to
	 * @return a specific MOIN converter or <code>null</code> in case the default conversion should be used 
	 */
	public static IConverter createConverter(Object fromType, Object toType) {
		if (fromType instanceof StructuralFeature) {
			//model to target conversion

			// Enumeration type to String
			if (toType == String.class) {
				Classifier fromClassifierType = ((StructuralFeature)fromType).getType();
				if (fromClassifierType instanceof EnumerationType) {
					return new EnumerationTypeToStringConverter((EnumerationType) fromClassifierType);
				}
			}
		}
		
		if (toType instanceof StructuralFeature) {
			//target to model conversion

			if (fromType == String.class) {
				Classifier toClassifierType = ((StructuralFeature)toType).getType();
		
				// String to EnumerationType
				if (toClassifierType instanceof EnumerationType) {
					return new StringToEnumerationTypeConverter((EnumerationType) toClassifierType);
				}
			}
		}
		return null;
	}
}
