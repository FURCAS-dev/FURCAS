package com.sap.mi.fwk.ui.databinding;

import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.model.StructureType;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.UpdateListStrategy;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.list.IObservableList;

import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.internal.databinding.converters.MoinConverterFactory;
import com.sap.tc.moin.repository.JmiHelper;

/**
 * Customizes a {@link Binding} between two MOIN {@link IObservableList
 * observable lists}. The following behaviors can be customized via the
 * strategy:
 * <ul>
 * <li>Conversion</li>
 * <li>Automatic processing</li>
 * </ul>
 * <p>
 * Conversion:<br/>
 * When elements are added they can be {@link #convert(Object) converted} to the
 * destination element type.
 * </p>
 * <p>
 * Automatic processing:<br/>
 * The processing to perform when the source observable changes. This behavior
 * is configured via policies provided on construction of the strategy (e.g.
 * {@link #POLICY_NEVER}, {@link #POLICY_ON_REQUEST}, {@link #POLICY_UPDATE}).
 * </p>
 * 
 * 
 * @see MoinDataBindingContext#bindList(IObservableList, IObservableList,
 *      UpdateListStrategy, UpdateListStrategy)
 * @see IConverter
 * @author d027044
 */
public final class MoinUpdateListStrategy extends UpdateListStrategy {

	/**
	 * Creates a new MOIN update list strategy for automatically updating the
	 * destination observable list whenever the source observable list changes.
	 * A default converter will be provided. The defaults can be changed by
	 * calling one of the setter methods.
	 */
	public MoinUpdateListStrategy() {
		this(true, POLICY_UPDATE);
	}

	/**
	 * Creates a new MOIN update list strategy with a configurable update
	 * policy. A default converter will be provided. The defaults can be changed
	 * by calling one of the setter methods.
	 * 
	 * @param updatePolicy
	 *            one of {@link #POLICY_NEVER}, {@link #POLICY_ON_REQUEST}, or
	 *            {@link #POLICY_UPDATE}
	 */
	public MoinUpdateListStrategy(int updatePolicy) {
		this(true, updatePolicy);
	}

	/**
	 * Creates a new MOIN update list strategy with a configurable update
	 * policy. A default converter will be provided if
	 * <code>provideDefaults</code> is <code>true</code>. The defaults can be
	 * changed by calling one of the setter methods.
	 * 
	 * @param provideDefaults
	 *            if <code>true</code>, default validators and a default
	 *            converter will be provided based on the observable list's
	 *            type.
	 * @param updatePolicy
	 *            one of {@link #POLICY_NEVER}, {@link #POLICY_ON_REQUEST}, or
	 *            {@link #POLICY_UPDATE}
	 */
	public MoinUpdateListStrategy(boolean provideDefaults, int updatePolicy) {
		super(provideDefaults, updatePolicy);
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

	/**
	 * @see UpdateValueStrategy#setConverter(IConverter)
	 */
	@Override
	public MoinUpdateListStrategy setConverter(IConverter converter) {
		return (MoinUpdateListStrategy) super.setConverter(converter);
	}
}
