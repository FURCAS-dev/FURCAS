package com.sap.mi.fwk.ui.databinding;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.internal.databinding.converters.MoinConverterFactory;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.model.StructureType;

/**
 * Customizes a MOIN {@link Binding} between two {@link IObservableValue
 * observable values}.
 * 
 * @see UpdateValueStrategy for details on standard data binding functionality.
 *      Beyond that this class offers the adaptation to MOIN.
 *      <ol>
 *      <li>Support for conversion from {@link StructuralFeature} to the
 *      corresponding Java types and vice versa</li>
 *      </ol>
 *      </p>
 * @author d027044, d022960
 */
public final class MoinUpdateValueStrategy extends UpdateValueStrategy {

	/**
	 * Creates a new MOIN update value strategy for automatically updating the
	 * destination observable value whenever the source observable value
	 * changes. Default validators and a default converter will be provided. The
	 * defaults can be changed by calling one of the setter methods.
	 */
	public MoinUpdateValueStrategy() {
		this(true, POLICY_UPDATE);
	}

	/**
	 * Creates a new MOIN update value strategy with a configurable update
	 * policy. Default validators and a default converter will be provided. The
	 * defaults can be changed by calling one of the setter methods.
	 * 
	 * @param updatePolicy
	 *            one of {@link #POLICY_NEVER}, {@link #POLICY_ON_REQUEST},
	 *            {@link #POLICY_CONVERT}, or {@link #POLICY_UPDATE}
	 */
	public MoinUpdateValueStrategy(int updatePolicy) {
		this(true, updatePolicy);
	}

	/**
	 * Creates a new MOIN update value strategy with a configurable update
	 * policy. Default validators and a default converter will be provided if
	 * <code>provideDefaults</code> is <code>true</code>. The defaults can be
	 * changed by calling one of the setter methods.
	 * 
	 * @param provideDefaults
	 *            if <code>true</code>, default validators and a default
	 *            converter will be provided based on the observable value's
	 *            type.
	 * @param updatePolicy
	 *            one of {@link #POLICY_NEVER}, {@link #POLICY_ON_REQUEST},
	 *            {@link #POLICY_CONVERT}, or {@link #POLICY_UPDATE}
	 */
	public MoinUpdateValueStrategy(boolean provideDefaults, int updatePolicy) {
		super(provideDefaults, updatePolicy);
	}

	/**
	 * Sets the current value of the given observable to the given value.
	 * 
	 * @param observableValue
	 *            The value to update
	 * @param value
	 *            The new value to set for the given observable value
	 * @return status The result of the operation wrapped in a {@link Status}
	 *         object.
	 */
	@Override
	protected IStatus doSet(IObservableValue observableValue, Object value) {
		/*
		 * This method delegates the doSet call to the respective observable.
		 * Since IVetoableValue does not have the ability to send back a status
		 * in case of a veto, this Strategy catches exceptions and returns them
		 * as IStatus.
		 */
		IStatus status = super.doSet(observableValue, value);
		Throwable e = status.getException();
		if (e != null) {
			return ValidationStatus.error(e.getMessage(), e);
		}
		return Status.OK_STATUS;
	}

	/**
	 * Tries to create a converter that can convert from values of type
	 * fromType. Returns <code>null</code> if no converter could be created.
	 * <p>
	 * Beyond the support provided by
	 * {@link UpdateStrategy#createConverter(Object fromType, Object toType)}
	 * this class offers default conversion for converting for {@link String} to
	 * MOIN {@link StructureType} and the MOIN adaptations for retrieving the
	 * underlying Java primitive types for {@link StructuralFeature}s.
	 * 
	 * @param fromType
	 *            The start (input) type for the conversion
	 * @param toType
	 *            The target type for the conversion
	 * @return an IConverter, or <code>null</code> if unsuccessful
	 */
	@Override
	protected IConverter createConverter(Object fromType, Object toType) {
		IConverter converter = MoinConverterFactory.createConverter(fromType, toType);

		if (converter == null) {
			// DEFAULT CONVERERSION

			Class<?> classFromType = null;
			Class<?> classToType = null;

			if (fromType instanceof Class) {
				// target to model conversion
				classFromType = (Class<?>) fromType;
			} else if (fromType instanceof StructuralFeature) {
				// model to target conversion
				StructuralFeature fromFeatureType = (StructuralFeature) fromType;
				JmiHelper jmiHelper = ModelAdapter.getInstance().getJmiHelper(fromFeatureType);
				classFromType = jmiHelper.getJavaPrimitiveOrWrapperType(fromFeatureType);
			}

			if (toType instanceof Class) {
				// model to target conversion
				classToType = (Class<?>) toType;
			} else if (toType instanceof StructuralFeature) {
				// target to model conversion
				StructuralFeature toFeatureType = (StructuralFeature) toType;
				JmiHelper jmiHelper = ModelAdapter.getInstance().getJmiHelper(toFeatureType);
				classToType = jmiHelper.getJavaPrimitiveOrWrapperType(toFeatureType);
			}

			if (classFromType != null && classToType != null) {
				converter = super.createConverter(classFromType, classToType);
			} else {
				converter = super.createConverter(fromType, toType);
			}
		}
		return converter;
	}
}
