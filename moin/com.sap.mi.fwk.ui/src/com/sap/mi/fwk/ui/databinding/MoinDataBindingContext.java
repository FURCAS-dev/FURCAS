package com.sap.mi.fwk.ui.databinding;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateListStrategy;
import org.eclipse.core.databinding.UpdateSetStrategy;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;

import com.sap.tc.moin.repository.mmi.model.StructuralFeature;

/**
 * The {@link MoinDataBindingContext} is the class to contact for managing data
 * bindings based on MOIN.
 * <p>
 * 
 * @see DataBindingContext
 * @author d027044, d022960
 */
public final class MoinDataBindingContext extends DataBindingContext {

	/**
	 * Creates a new {@link MoinDataBindingContext} with the default
	 * {@link Realm}.
	 */
	public MoinDataBindingContext() {
		this(Realm.getDefault());
	}

	/**
	 * Creates a new {@link MoinDataBindingContext} using the given
	 * {@link Realm}
	 * 
	 * @param validationRealm
	 *            The {@link Realm} to use.
	 */
	public MoinDataBindingContext(Realm validationRealm) {
		super(validationRealm);
	}

	/**
	 * Creates a MOIN specific implementation of an {@link UpdateValueStrategy}
	 * for the two given {@link IObservableValue} objects for the direction from
	 * the model to the UI.
	 * 
	 * @param fromValue
	 *            The {@link IObservableValue} that is the source object for the
	 *            value change (the object that was changed and triggered the
	 *            data flow). It is part of the model layer, and should
	 *            generally in the MOIN use case be an Observable wrapping a
	 *            MOIN {@link StructuralFeature}.
	 * @param toValue
	 *            The {@link IObservableValue} that is the target object for the
	 *            value change (the object that needs to be updated by the data
	 *            flow). It is part of the dependent layer (usually the UI
	 *            layer, 'target' in the Data Binding speak).
	 * @return A new {@link MoinUpdateValueStrategy} for the two given
	 *         {@link IObservableValue} objects.
	 */
	@Override
	protected MoinUpdateValueStrategy createModelToTargetUpdateValueStrategy(IObservableValue fromValue, IObservableValue toValue) {
		return new MoinUpdateValueStrategy();
	}

	/**
	 * Creates a MOIN specific implementation of an {@link UpdateValueStrategy}
	 * for the two given {@link IObservableValue} objects for the direction from
	 * the UI to the model.
	 * 
	 * @param fromValue
	 *            The {@link IObservableValue} that is the source object for the
	 *            value change (the object that was changed and triggered the
	 *            data flow). It is part of the dependent layer (usually the UI
	 *            layer, 'target' in the Data Binding speak).
	 * @param toValue
	 *            The {@link IObservableValue} that is the target object for the
	 *            value change (the object that needs to be updated by the data
	 *            flow). It is part of the model layer, and should generally in
	 *            the MOIN use case be an Observable wrapping a MOIN
	 *            {@link StructuralFeature}.
	 * @return A new {@link MoinUpdateValueStrategy} for the two given
	 *         {@link IObservableValue} objects.
	 */
	@Override
	protected MoinUpdateValueStrategy createTargetToModelUpdateValueStrategy(IObservableValue fromValue, IObservableValue toValue) {
		return new MoinUpdateValueStrategy();
	}

	/**
	 * Creates a MOIN specific implementation of an {@link UpdateSetStrategy}
	 * for the two given {@link IObservableSet} objects for the direction from
	 * the model to the UI. It can be used for MOIN {@link StructuralFeature}
	 * objects with a cardinality greater than one that are unique. Monitored
	 * are additions and removals to the set, whereas changes to objects
	 * contained in the set are not monitored.
	 * 
	 * @param modelObservableSet
	 *            The {@link IObservableSet} that is the source object for the
	 *            change (the object that was changed and triggered the data
	 *            flow). It is part of the model layer, and should generally in
	 *            the MOIN use case be an Observable wrapping a MOIN
	 *            {@link StructuralFeature}.
	 * @param targetObservableSet
	 *            The {@link IObservableSet} that is the target object for the
	 *            change (the object that needs to be updated by the data flow).
	 *            It is part of the dependent layer (usually the UI layer,
	 *            'target' in the Data Binding speak).
	 * @return A new {@link MoinUpdateSetStrategy} for the two given
	 *         {@link IObservableSet} objects.
	 */
	@Override
	protected UpdateSetStrategy createModelToTargetUpdateSetStrategy(IObservableSet modelObservableSet, IObservableSet targetObservableSet) {
		return new MoinUpdateSetStrategy();
	}

	/**
	 * Creates a MOIN specific implementation of an {@link UpdateSetStrategy}
	 * for the two given {@link IObservableSet} objects for the direction from
	 * the UI to the model. Monitored are additions and removals to the set,
	 * whereas changes to objects contained in the set are not monitored.
	 * 
	 * @param targetObservableSet
	 *            The {@link IObservableSet} that is the source object for the
	 *            change (the object that was changed and triggered the data
	 *            flow). It is part of the dependent layer (usually the UI
	 *            layer, 'target' in the Data Binding speak).
	 * @param modelObservableSet
	 *            The {@link IObservableSet} that is the target object for the
	 *            change (the object that needs to be updated by the data flow).
	 *            It is part of the model layer, and should generally in the
	 *            MOIN use case be an Observable wrapping a MOIN
	 *            {@link StructuralFeature}.
	 * @return A new {@link MoinUpdateSetStrategy} for the two given
	 *         {@link IObservableSet} objects.
	 */
	@Override
	protected UpdateSetStrategy createTargetToModelUpdateSetStrategy(IObservableSet targetObservableSet, IObservableSet modelObservableSet) {
		return new MoinUpdateSetStrategy();
	}

	/**
	 * Creates a MOIN specific implementation of an {@link UpdateListStrategy}
	 * for the two given {@link IObservableList} objects for the direction from
	 * the model to the UI. It can be used for MOIN {@link StructuralFeature}
	 * objects with a cardinality greater than one that are ordered. Monitored
	 * are additions and removals to the list and moving of objects inside the
	 * list, whereas changes to objects contained in the list are not monitored.
	 * 
	 * @param modelObservableList
	 *            The {@link IObservableList} that is the source object for the
	 *            change (the object that was changed and triggered the data
	 *            flow). It is part of the model layer, and should generally in
	 *            the MOIN use case be an Observable wrapping a MOIN
	 *            {@link StructuralFeature}.
	 * @param targetObservableList
	 *            The {@link IObservableList} that is the target object for the
	 *            change (the object that needs to be updated by the data flow).
	 *            It is part of the dependent layer (usually the UI layer,
	 *            'target' in the Data Binding speak).
	 * @return A new {@link MoinUpdateListStrategy} for the two given
	 *         {@link IObservableList} objects.
	 */
	@Override
	protected UpdateListStrategy createModelToTargetUpdateListStrategy(IObservableList modelObservableList,
			IObservableList targetObservableList) {
		return new MoinUpdateListStrategy();
	}

	/**
	 * Creates a MOIN specific implementation of an {@link UpdateListStrategy}
	 * for the two given {@link IObservableList} objects for the direction from
	 * the UI to the model. Monitored are additions and removals to the list and
	 * moving of objects inside the list, whereas changes to objects contained
	 * in the list are not monitored.
	 * 
	 * @param targetObservableList
	 *            The {@link IObservableList} that is the source object for the
	 *            change (the object that was changed and triggered the data
	 *            flow). It is part of the dependent layer (usually the UI
	 *            layer, 'target' in the Data Binding speak).
	 * @param modelObservableList
	 *            The {@link IObservableList} that is the target object for the
	 *            change (the object that needs to be updated by the data flow).
	 *            It is part of the model layer, and should generally in the
	 *            MOIN use case be an Observable wrapping a MOIN
	 *            {@link StructuralFeature}.
	 * @return A new {@link MoinUpdateListStrategy} for the two given
	 *         {@link IObservableList} objects.
	 */
	@Override
	protected UpdateListStrategy createTargetToModelUpdateListStrategy(IObservableList targetObservableList,
			IObservableList modelObservableList) {
		return new MoinUpdateListStrategy();
	}
}