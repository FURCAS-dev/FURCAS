package com.sap.mi.fwk.ui.internal.databinding.observables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.map.ComputedObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;

import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.ClassFilter;
import com.sap.tc.moin.repository.events.type.AttributeValueChangeEvent;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.LinkAddEvent;
import com.sap.tc.moin.repository.events.type.LinkChangeEvent;
import com.sap.tc.moin.repository.events.type.LinkRemoveEvent;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.mmi.descriptors.AttributeDescriptor;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Maps instances of type {@link RefObject} to one of their attributes. Tracks
 * changes to the underlying observable set of objects (keys), as well as
 * changes to attribute values.<br>
 * The implementation is optimized in the way that it registers only one
 * {@link UpdateListener} for all elements contained in the <code>Set</code>. It
 * internally filters the events in order to determine whether the event has to
 * be handled by this instance or not.
 * 
 * @author d027044
 * 
 */
public class RefObjectObservableMap extends ComputedObservableMap {

	private SetValueCommand mSetValueCommand = null;

	private RefObject refObject = null;
	private StructuralFeature feature = null;
	private Attribute property = null;

	private ArrayList<RefObject> mRelevantObjects = new ArrayList<RefObject>();

	public RefObjectObservableMap(IObservableSet domain, RefObject refObject, StructuralFeature feature,
			AttributeDescriptor<Attribute, ? extends RefObject, ? extends Object> propertyDescriptor) {
		super(domain);
		this.refObject = refObject;
		this.feature = feature;
		Connection connection = ModelAdapter.getInstance().getConnection(feature);
		property = connection.getMetamodelElement(propertyDescriptor);

		init();

		Classifier classifier = feature.getType();
		if (classifier instanceof MofClass) {
			ElementUpdateListener listener = new ElementUpdateListener();
			ClassFilter filter = new ClassFilter((MofClass) feature.getType(), true);
			connection.getSession().getEventRegistry().registerUpdateListener(listener, filter);
		}
	}

	@Override
	protected Object doGet(Object key) {
		Object value = null;

		if (key instanceof RefObject) {
			RefObject object = (RefObject) key;
			if (object.is___Alive()) {
				value = object.refGetValue(property);
			}
		}
		return value;
	}

	@Override
	protected Object doPut(Object key, Object value) {
		Connection connection = ModelAdapter.getInstance().getConnection(refObject);

		Object oldValue = doGet(key);
		if (oldValue == value || (oldValue != null && oldValue.equals(value)) || (value != null && value.equals(oldValue))) {
			// No change --> do not propagate events
			return oldValue;
		}

		try {
			if (key instanceof RefObject) {
				if (mSetValueCommand == null) {
					mSetValueCommand = new SetValueCommand(connection);
				}
				RefObject object = (RefObject) key;
				oldValue = object.refGetValue(property);
				mSetValueCommand.setObject(object);
				mSetValueCommand.setValue(value);
				mSetValueCommand.execute();
			}
		} catch (ExecutionCancelledException e) {
			// Not an Error: the user has canceled the execution (e.g. on LM or
			// conflicting editor) and the command was successfully rolled-back.
			// Revert the change in the UI as well
			rollbackUI(key, oldValue, value);
		} catch (UnrecoverableExecutionException ex) {
			// Serious Error: the command could not be rolled-back, and the
			// repository is in a potentially inconsistent state!
			throw ex;
		} catch (RuntimeException ex) {
			// Some Error occurred, but the command was successfully
			// rolled-back.
			// Revert the change in the UI as well
			rollbackUI(key, oldValue, value);
			throw ex;
		}
		return oldValue;
	}

	@Override
	protected void hookListener(Object domainElement) {
		if (domainElement instanceof RefObject && !mRelevantObjects.contains(domainElement)) {
			RefObject object = (RefObject) domainElement;
			mRelevantObjects.add(object);
		}
	}

	@Override
	protected void unhookListener(Object domainElement) {
		if (domainElement instanceof RefObject && mRelevantObjects.contains(domainElement)) {
			RefObject object = (RefObject) domainElement;
			mRelevantObjects.remove(object);
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(getClass().getName());
		result.append('@');
		result.append(Integer.toHexString(hashCode()));

		result.append(" (RefObject:"); //$NON-NLS-1$
		result.append(refObject);
		result.append(")"); //$NON-NLS-1$

		result.append(" (structuralFeature: "); //$NON-NLS-1$
		result.append(feature);
		result.append(")"); //$NON-NLS-1$

		result.append(" (property: "); //$NON-NLS-1$
		result.append(property);
		result.append(")"); //$NON-NLS-1$

		return result.toString();
	}

	/**
	 * Revert the change in the UI as well by asynchronously scheduling a change
	 * notification in the reverse order of the original change event (old and
	 * new value swapped). This does not happen automatically in the data
	 * binding when throwing an error or cancellation exception.
	 * 
	 * @param value
	 */
	private void rollbackUI(final Object key, final Object oldValue, final Object newValue) {
		getRealm().asyncExec(new Runnable() {
			public void run() {
				fireSingleChange(key, oldValue, newValue);
			}
		});
	}

	private class ElementUpdateListener implements UpdateListener {

		public ElementUpdateListener(/* RefObject object */) {
			super();
		}

		public void notifyUpdate(EventChain eventChain) {
			List<ChangeEvent> events = eventChain.getEvents();
			for (Iterator<ChangeEvent> it = events.iterator(); it.hasNext();) {
				ChangeEvent changeEvent = it.next();
				if (changeEvent instanceof AttributeValueChangeEvent) {
					AttributeValueChangeEvent event = (AttributeValueChangeEvent) changeEvent;
					RefObject object = event.getAffectedElement(event.getEventTriggerConnection());
					if (mRelevantObjects.contains(object)) {
						fireMapChange(Diffs.createMapDiffSingleChange(object, event.getOldValue(), event.getNewValue()));
					}
				} else if (changeEvent instanceof LinkChangeEvent) {
					LinkChangeEvent event = (LinkChangeEvent) changeEvent;
					Connection connection = event.getEventTriggerConnection();
					// Find the object at the other end of the link
					// (starting point here is the RefObject this list is
					// created for. Here we search the target link end which
					// is the change the link event was created for
					RefBaseObject object = connection.getElement(event.getStoredLinkEndMri());
					if (object == null || object.equals(refObject)) {
						LRI lri = event.getNonStoredLinkEndLri();
						if (lri != null) {
							object = connection.getElement(lri);
						}
					}
					if (object instanceof RefObject) {
						Object value = ((RefObject) object).refGetValue(property);
						if (event instanceof LinkAddEvent) {
							fireMapChange(Diffs.createMapDiffSingleAdd(object, value));

						} else if (event instanceof LinkRemoveEvent) {
							fireMapChange(Diffs.createMapDiffSingleRemove(object, value));
						} else {
							// TODO: get(object) already returns the new value
							// since there is no buffer list; seems not to harm.
							// Should be replaced be real old value
							fireMapChange(Diffs.createMapDiffSingleChange(object, get(object), value));
						}
					}
				}
			}
		}
	}

	private class SetValueCommand extends Command {

		private RefObject mObject = null;
		private Object mNewValue = null;

		public SetValueCommand(Connection connection) {
			super(connection, MiFwkUiMessages.RefObjectObservableValue_CommandNameValueChange);
		}

		public void setObject(RefObject object) {
			mObject = object;
		}

		public void setValue(Object value) {
			mNewValue = value;
		}

		public boolean canExecute() {
			return true;
		}

		public Collection<PartitionOperation> getAffectedPartitions() {
			ArrayList<PartitionOperation> affectedPartitions = new ArrayList<PartitionOperation>(1);
			PRI pri = ((Partitionable) refObject).get___Partition().getPri();
			affectedPartitions.add(new PartitionOperation(PartitionOperation.Operation.EDIT, pri));
			return affectedPartitions;
		}

		public void doExecute() {
			mObject.refSetValue(property, mNewValue);
		}
	}
}
