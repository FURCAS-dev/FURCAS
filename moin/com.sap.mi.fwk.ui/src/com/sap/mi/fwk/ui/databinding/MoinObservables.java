package com.sap.mi.fwk.ui.databinding;

import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.masterdetail.MasterDetailObservables;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.Assert;

import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.internal.databinding.Utilities;
import com.sap.mi.fwk.ui.internal.databinding.observables.RefObjectObservableList;
import com.sap.mi.fwk.ui.internal.databinding.observables.RefObjectObservableMap;
import com.sap.mi.fwk.ui.internal.databinding.observables.RefObjectObservableSet;
import com.sap.mi.fwk.ui.internal.databinding.observables.RefObjectObservableValue;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.mmi.descriptors.AttributeDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.MetamodelElementDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.StructuralFeatureDescriptor;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * A factory for creating a MOIN observable.
 * 
 * @author d027044, d022960
 */
public final class MoinObservables {

	/**
	 * This class must not be instantiated - defines only static access methods.
	 */
	private MoinObservables() {
		super();
	}

	/**
	 * Returns an {@link IObservableValue} in the default {@link Realm} for the
	 * given {@link StructuralFeature} of the given MOIN {@link RefObject}. The
	 * {@link StructuralFeature} is identified by its
	 * {@link StructuralFeatureDescriptor}.
	 * 
	 * @param refObject
	 *            the MOIN {@link RefObject} to observe.
	 * @param featureDescriptor
	 *            the {@link MetamodelElementDescriptor} for the
	 *            {@link StructuralFeature} of the object to observe.
	 * @return An {@link IObservableValue} for the given
	 *         {@link StructuralFeature} of the {@link RefObject}.
	 */
	public static IObservableValue observeValue(RefObject refObject,
			StructuralFeatureDescriptor<? extends StructuralFeature, ? extends RefObject, ? extends Object> featureDescriptor) {
		return observeValue(Realm.getDefault(), refObject, featureDescriptor);
	}

	/**
	 * Returns an {@link IObservableValue} value for the given
	 * {@link StructuralFeature} of the given MOIN {@link RefObject}. The
	 * {@link StructuralFeature} is identified by its
	 * {@link StructuralFeatureDescriptor}.
	 * 
	 * @param realm
	 *            the {@link Realm} in which to observe.
	 * @param refObject
	 *            the MOIN {@link RefObject} to observe.
	 * @param featureDescriptor
	 *            the {@link MetamodelElementDescriptor} for the
	 *            {@link StructuralFeature} of the object to observe.
	 * @return An {@link IObservableValue} for the given
	 *         {@link StructuralFeature} of the {@link RefObject}.
	 */
	public static IObservableValue observeValue(Realm realm, RefObject refObject,
			StructuralFeatureDescriptor<? extends StructuralFeature, ? extends RefObject, ? extends Object> featureDescriptor) {
		return observeValue(realm, refObject, Utilities.getStructuralFeature((MofClass) refObject.refMetaObject(), featureDescriptor));
	}

	/**
	 * Returns an {@link IObservableValue} value for the given
	 * {@link StructuralFeature} of the given MOIN {@link RefObject}.
	 * 
	 * @param realm
	 *            the {@link Realm} in which to observe.
	 * @param refObject
	 *            the MOIN {@link RefObject} to observe.
	 * @param feature
	 *            the {@link StructuralFeature} of the object to observe.
	 * @return An {@link IObservableValue} for the given
	 *         {@link StructuralFeature} of the {@link RefObject}.
	 */
	public static IObservableValue observeValue(Realm realm, RefObject refObject, StructuralFeature feature) {
		return new RefObjectObservableValue(realm, refObject, feature);
	}

	/**
	 * Returns an {@link IObservableValue} in the default {@link Realm} that
	 * tracks the current value of the given {@link StructuralFeature} of the
	 * object the master {@link IObservableValue} points to. Using this method
	 * you get an {@link IObservableValue} that can be used to track changes to
	 * e.g. an {@link Attribute} of a referenced object.
	 * <p>
	 * The most prominent use case is an text field in the UI displaying the
	 * name of a referenced object, e.g. the name of the parent component in our
	 * SimpleComponent example. The returned {@link IObservableValue} is
	 * triggered whenever the name of the parent component changes whereas the
	 * passed master {@link IObservableValue} 'value' is triggered whenever the
	 * reference changes (e.g. another component is set as parent).
	 * 
	 * @param value
	 *            the master {@link IObservableValue}.
	 * @param featureDescriptor
	 *            the {@link MetamodelElementDescriptor} of the
	 *            {@link StructuralFeature} of the master object to observe.
	 * @return an {@link IObservableValue} that tracks the current value of the
	 *         {@link StructuralFeature} that the master
	 *         {@link IObservableValue} currently points to.
	 * @see MasterDetailObservables#detailValue(IObservableValue,
	 *      IObservableFactory, Object)
	 */
	public static IObservableValue observeDetailValue(IObservableValue value,
			StructuralFeatureDescriptor<? extends StructuralFeature, ? extends RefObject, ? extends Object> featureDescriptor) {
		return observeDetailValue(Realm.getDefault(), value, featureDescriptor);
	}

	/**
	 * Returns an {@link IObservableValue} that tracks the current value of the
	 * given {@link StructuralFeature} of the object the master
	 * {@link IObservableValue} points to. Using this method you get an
	 * {@link IObservableValue} that can be used to track changes to e.g. an
	 * {@link Attribute} of a referenced object.
	 * <p>
	 * The most prominent use case is an text field in the UI displaying the
	 * name of a referenced object, e.g. the name of the parent component in our
	 * SimpleComponent example. The returned {@link IObservableValue} is
	 * triggered whenever the name of the parent component changes whereas the
	 * passed master {@link IObservableValue} 'value' is triggered whenever the
	 * reference changes (e.g. another component is set as parent).
	 * 
	 * @param realm
	 *            the {@link Realm} to use.
	 * @param value
	 *            the master {@link IObservableValue}.
	 * @param featureDescriptor
	 *            the {@link MetamodelElementDescriptor} of the
	 *            {@link StructuralFeature} of the master object to observe.
	 * @return an {@link IObservableValue} that tracks the current value of the
	 *         {@link StructuralFeature} that the master
	 *         {@link IObservableValue} currently points to.
	 * @see MasterDetailObservables#detailValue(IObservableValue,
	 *      IObservableFactory, Object)
	 */
	public static IObservableValue observeDetailValue(Realm realm, IObservableValue value,
			StructuralFeatureDescriptor<? extends StructuralFeature, ? extends RefObject, ? extends Object> featureDescriptor) {
		StructuralFeature feature = (StructuralFeature) value.getValueType();
		Assert.isLegal(feature != null, "The given observable type is null"); //$NON-NLS-1$
		MofClass detailMofClass = (MofClass) ((Reference) feature).getReferencedEnd().getType();
		StructuralFeature detailFeature = Utilities.getStructuralFeature(detailMofClass, featureDescriptor);

		if (detailFeature == null) {
			// performance optimization
			Assert.isLegal(false, "The given observable does not have a feature with name '" //$NON-NLS-1$
					+ featureDescriptor.getQualifiedName() + "'"); //$NON-NLS-1$
		}
		return MasterDetailObservables.detailValue(value, valueFactory(realm, featureDescriptor), detailFeature);
	}

	/**
	 * Returns an {@link IObservableList} value for the given multi-valued
	 * {@link StructuralFeature} of the given MOIN {@link RefObject} in the
	 * default {@link Realm}.
	 * 
	 * @param refObject
	 *            the MOIN {@link RefObject} to observe.
	 * @param featureDescriptor
	 *            the {@link StructuralFeature} of the object to observe.
	 * @return An {@link IObservableList} for the given
	 *         {@link StructuralFeature} of the {@link RefObject}.
	 */
	public static IObservableList observeList(RefObject refObject,
			StructuralFeatureDescriptor<? extends StructuralFeature, ? extends RefObject, ? extends Object> featureDescriptor) {
		return observeList(Realm.getDefault(), refObject, featureDescriptor);
	}

	/**
	 * Returns an {@link IObservableList} value for the given multi-valued
	 * {@link StructuralFeature} of the given MOIN {@link RefObject}.
	 * 
	 * @param realm
	 *            the {@link Realm} in which to observe.
	 * @param refObject
	 *            the MOIN {@link RefObject} to observe.
	 * @param featureDescriptor
	 *            the {@link StructuralFeature} of the object to observe.
	 * @return An {@link IObservableList} for the given
	 *         {@link StructuralFeature} of the {@link RefObject}.
	 */
	public static IObservableList observeList(Realm realm, RefObject refObject,
			StructuralFeatureDescriptor<? extends StructuralFeature, ? extends RefObject, ? extends Object> featureDescriptor) {
		StructuralFeature structuralFeature = Utilities.getStructuralFeature((MofClass) refObject.refMetaObject(), featureDescriptor);
		if (structuralFeature.getMultiplicity().getUpper() == 1) {
			// Is not of type Collection
			throw new IllegalArgumentException("The feature '" + structuralFeature.getName() //$NON-NLS-1$
					+ "' is not multi-valued (upper bound for cardinality is 1) and cannot be used as a base for an IObservableList"); //$NON-NLS-1$
		}
		if (!structuralFeature.getMultiplicity().isOrdered()) {
			// Only ordered multiple values are supported
			throw new IllegalArgumentException("The feature '" + structuralFeature.getName() //$NON-NLS-1$
					+ "' is not ordered and cannot be used as a base for an IObservableList"); //$NON-NLS-1$
		}
		return new RefObjectObservableList(realm, refObject, structuralFeature);
	}

	/**
	 * Returns an {@link IObservableSet} value for the given multi-valued
	 * {@link StructuralFeature} of the given MOIN {@link RefObject}.
	 * 
	 * @param refObject
	 *            the MOIN {@link RefObject} to observe.
	 * @param featureDescriptor
	 *            the {@link StructuralFeature} of the object to observe.
	 * @return An {@link IObservableSet} for the given {@link StructuralFeature}
	 *         of the {@link RefObject}.
	 */
	public static IObservableSet observeSet(RefObject refObject,
			StructuralFeatureDescriptor<? extends StructuralFeature, ? extends RefObject, ? extends Object> featureDescriptor) {
		return observeSet(Realm.getDefault(), refObject, featureDescriptor);
	}

	/**
	 * Returns an {@link IObservableSet} value for the given multi-valued
	 * {@link StructuralFeature} of the given MOIN {@link RefObject}.
	 * 
	 * @param realm
	 *            the {@link Realm} in which to observe.
	 * @param refObject
	 *            the MOIN {@link RefObject} to observe.
	 * @param featureDescriptor
	 *            the {@link StructuralFeature} of the object to observe.
	 * @return An {@link IObservableSet} for the given {@link StructuralFeature}
	 *         of the {@link RefObject}.
	 */
	public static IObservableSet observeSet(Realm realm, RefObject refObject,
			StructuralFeatureDescriptor<? extends StructuralFeature, ? extends RefObject, ? extends Object> featureDescriptor) {
		StructuralFeature structuralFeature = Utilities.getStructuralFeature((MofClass) refObject.refMetaObject(), featureDescriptor);
		if (structuralFeature.getMultiplicity().getUpper() == 1) {
			// Is not of type Collection
			throw new IllegalArgumentException("The feature '" + structuralFeature.getName() //$NON-NLS-1$
					+ "' is not multi-valued (upper bound for cardinality is 1) and cannot be used as a base for IObservableSet"); //$NON-NLS-1$
		}
		if (!structuralFeature.getMultiplicity().isUnique()) {
			// Only unique multiple values are supported
			throw new IllegalArgumentException("The feature '" + structuralFeature.getName() //$NON-NLS-1$
					+ "' is not unique and cannot be used as a base for IObservableSet - check the corresponding metamodel definition"); //$NON-NLS-1$
		}
		return new RefObjectObservableSet(realm, refObject, structuralFeature);
	}

	/**
	 * Returns an {@link IObservableMap} for the given domain
	 * {@link IObservableSet} described by the given
	 * {@link StructuralFeatureDescriptor} on the given {@link RefObject} that
	 * is capable of supervising and promoting changes to the given
	 * {@link AttributeDescriptor} describing the mapped attribute of the
	 * supervised reference.
	 * 
	 * @param domain
	 *            The {@link IObservableSet} containing the objects for which
	 *            the details need to be mapped; the value of the multi-valued
	 *            {@link StructuralFeature} or a {@link Set} wrapping it.
	 * @param refObject
	 *            The {@link RefObject} instance holding the multi-valued
	 *            {@link StructuralFeature}.
	 * @param featureDescriptor
	 *            The descriptor for the {@link StructuralFeature} of the domain
	 *            set.
	 * @param propertyDescriptor
	 *            The descriptor of the {@link Attribute} of the referenced
	 *            feature.
	 * @return An {@link IObservableMap} that maps instances of the domain set
	 *         to concrete instances of the {@link Attribute} described by the
	 *         property descriptor.
	 */
	public static IObservableMap observeMap(IObservableSet domain, RefObject refObject,
			StructuralFeatureDescriptor<? extends StructuralFeature, ? extends RefObject, ? extends Object> featureDescriptor,
			AttributeDescriptor<Attribute, ? extends RefObject, ? extends Object> propertyDescriptor) {

		StructuralFeature structuralFeature = Utilities.getStructuralFeature((MofClass) refObject.refMetaObject(), featureDescriptor);
		return new RefObjectObservableMap(domain, refObject, structuralFeature, propertyDescriptor);
	}

	/**
	 * Returns an array of {@link IObservableMap} for the given domain
	 * {@link IObservableSet} described by the given
	 * {@link StructuralFeatureDescriptor} on the given {@link RefObject} that
	 * is capable of supervising and promoting changes to the given array of
	 * {@link AttributeDescriptor} describing the mapped attribute of the
	 * supervised reference.
	 * 
	 * @param domain
	 *            The {@link IObservableSet} containing the objects for which
	 *            the details need to be mapped; the value of the multi-valued
	 *            {@link StructuralFeature} or a {@link Set} wrapping it.
	 * @param refObject
	 *            The {@link RefObject} instance holding the multi-valued
	 *            {@link StructuralFeature}.
	 * @param featureDescriptor
	 *            The descriptor for the {@link StructuralFeature} of the domain
	 *            set.
	 * @param propertyDescriptors
	 *            The descriptors of the {@link Attribute}s of the referenced
	 *            feature.
	 * @return An array of {@link IObservableMap}s that map instances of the
	 *         domain set to concrete instances of the {@link Attribute}s
	 *         described by the property descriptors.
	 */
	public static IObservableMap[] observeMaps(IObservableSet domain, RefObject refObject,
			StructuralFeatureDescriptor<? extends StructuralFeature, ? extends RefObject, ? extends Object> featureDescriptor,
			AttributeDescriptor<Attribute, ? extends RefObject, ? extends Object>[] propertyDescriptors) {
		IObservableMap[] result = new IObservableMap[propertyDescriptors.length];
		String[] columnNames = new String[propertyDescriptors.length];
		for (int i = 0; i < propertyDescriptors.length; i++) {
			String[] qualifiedColumnName = propertyDescriptors[i].getQualifiedName();
			columnNames[i] = qualifiedColumnName[qualifiedColumnName.length - 1];
			result[i] = observeMap(domain, refObject, featureDescriptor, propertyDescriptors[i]);
		}
		return result;
	}

	/**
	 * Returns an unmodifiable observable list containing a fixed set of
	 * enumeration values for the given {@link StructuralFeatureDescriptor} and
	 * the given {@link RefObject}.
	 * 
	 * @param refObject
	 *            The object to observe.
	 * @param featureDescriptor
	 *            The descriptor of the {@link StructuralFeature} of the object
	 *            to observe - has to be an {@link EnumerationType}.
	 * @return An unmodifiable {@link IObservableList} containing a fixed set of
	 *         enumeration values.
	 * @exception IllegalArgumentException
	 *                In case the feature defined by
	 *                <code>featureDescriptor</code> is not an enumeration type.
	 */
	public static IObservableList unmodifiableObservableEnumerationList(RefObject refObject,
			StructuralFeatureDescriptor<? extends StructuralFeature, ? extends RefObject, ? extends Object> featureDescriptor) {

		return unmodifiableObservableEnumerationList(Realm.getDefault(), refObject, featureDescriptor);
	}

	/**
	 * Returns an unmodifiable observable list containing a fixed set of
	 * enumeration values for the given {@link StructuralFeatureDescriptor} and
	 * the given {@link RefObject}.
	 * 
	 * @param realm
	 *            the {@link Realm} to use.
	 * @param refObject
	 *            The object to observe.
	 * @param featureDescriptor
	 *            The descriptor of the {@link StructuralFeature} of the object
	 *            to observe - has to be an {@link EnumerationType}.
	 * @return An unmodifiable {@link IObservableList} containing a fixed set of
	 *         enumeration values.
	 * @exception IllegalArgumentException
	 *                In case the feature defined by
	 *                <code>featureDescriptor</code> is not an enumeration type.
	 */
	public static IObservableList unmodifiableObservableEnumerationList(Realm realm, RefObject refObject,
			StructuralFeatureDescriptor<? extends StructuralFeature, ? extends RefObject, ? extends Object> featureDescriptor) {
		StructuralFeature structuralFeature = Utilities.getStructuralFeature((MofClass) refObject.refMetaObject(), featureDescriptor);
		JmiHelper jmiHelper = ModelAdapter.getInstance().getConnection(refObject).getJmiHelper();
		Classifier classifier = jmiHelper.getNonAliasType(structuralFeature);
		if (classifier instanceof EnumerationType) {
			EnumerationType enumerationType = (EnumerationType) classifier;
			List<?> enumerationLabelList = jmiHelper.getEnumerationConstants(enumerationType);
			return Observables.unmodifiableObservableList(Observables.staticObservableList(realm, enumerationLabelList, structuralFeature));
		}
		throw new IllegalArgumentException("The feature '" + structuralFeature.getName() //$NON-NLS-1$
				+ "' is not an enumeration type - check the corresponding metamodel definition"); //$NON-NLS-1$
	}

	/**
	 * Returns a factory for creating observable values tracking the value of
	 * the given feature of a particular {@link RefObject object}.
	 * 
	 * @param realm
	 *            the realm in which to observe.
	 * @param featureDescriptor
	 *            the feature name for which to track the value.
	 * @return an observable factory.
	 */
	public static IObservableFactory valueFactory(final Realm realm,
			final StructuralFeatureDescriptor<? extends StructuralFeature, ? extends RefObject, ? extends Object> featureDescriptor) {
		return new IObservableFactory() {
			public IObservable createObservable(Object target) {
				return observeValue(realm, (RefObject) target, featureDescriptor);
			}
		};
	}

	/**
	 * Returns a factory for creating observable lists tracking the value of the
	 * given feature of a particular {@link RefObject object}.
	 * 
	 * @param realm
	 *            the realm in which to observe.
	 * @param featureDescriptor
	 *            the feature name for which to track the value.
	 * @return an observable factory.
	 */
	public static IObservableFactory listFactory(final Realm realm,
			final StructuralFeatureDescriptor<? extends StructuralFeature, ? extends RefObject, ? extends Object> featureDescriptor) {
		return new IObservableFactory() {
			public IObservable createObservable(Object target) {
				return observeList(realm, (RefObject) target, featureDescriptor);
			}
		};
	}

	/**
	 * Returns a factory for creating observable sets tracking the value of the
	 * given feature of a particular {@link RefObject object}.
	 * 
	 * @param realm
	 *            the realm in which to observe.
	 * @param featureDescriptor
	 *            the feature name for which to track the value.
	 * @return an observable factory.
	 */
	public static IObservableFactory setFactory(final Realm realm,
			final StructuralFeatureDescriptor<? extends StructuralFeature, ? extends RefObject, ? extends Object> featureDescriptor) {
		return new IObservableFactory() {
			public IObservable createObservable(Object target) {
				return observeSet(realm, (RefObject) target, featureDescriptor);
			}
		};
	}
}
