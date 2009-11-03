package com.sap.mi.fwk.ui.internal.databinding.observables;

import java.util.ArrayList;
import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.ValueDiff;

import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;

/**
 * {@inheritDoc} This implementation performs the actual model modification
 * within a {@link Command}. Any changes are rolled back in case of a exception.
 * 
 * @author d027044, d022960
 * 
 */
public class RefObjectObservableValue extends AbstractRefObjectObservableValue {

	private SetValueCommand mSetValueCommand = null;

	public RefObjectObservableValue(Realm realm, RefObject refObject, StructuralFeature feature) {
		super(realm, refObject, feature);
	}

	@Override
	protected final void doSetValue(Object value) {
		Object oldValue = doGetValue();
		if (oldValue == value || (oldValue != null && oldValue.equals(value)) || (value != null && value.equals(oldValue))) {
			// No change --> do not propagate events
			return;
		}

		Connection connection = ModelAdapter.getInstance().getConnection(refObject);

		try {
			if (mSetValueCommand == null) {
				mSetValueCommand = new SetValueCommand(connection);
			}
			mSetValueCommand.setValue(value);
			mSetValueCommand.execute();
		} catch (ExecutionCancelledException e) {
			// Not an Error: the user has canceled the execution (e.g. on LM or
			// conflicting editor) and the command was successfully rolled-back.
			// Revert the change in the UI as well
			rollbackUI(value);
		} catch (UnrecoverableExecutionException ex) {
			// Serious Error: the command could not be rolled-back, and the
			// repository is in a potentially inconsistent state!
			throw ex;
		} catch (RuntimeException ex) {
			// Some Error occurred, but the command was successfully
			// rolled-back.
			// Revert the change in the UI as well
			rollbackUI(value);
			throw ex;
		}
	}

	/**
	 * Revert the change in the UI as well by asynchronously scheduling a change
	 * notification in the reverse order of the original change event (old and
	 * new value swapped). This does not happen automatically in the data
	 * binding when throwing an error or cancellation exception.
	 * 
	 * @param value
	 */
	private void rollbackUI(final Object value) {
		getRealm().asyncExec(new Runnable() {
			public void run() {
				fireValueChange(new ValueDiff() {
					@Override
					public Object getNewValue() {
						return oldValue;
					}

					@Override
					public Object getOldValue() {
						return value;
					}
				});
			}
		});
	}

	private class SetValueCommand extends Command {

		private Object mNewValue = null;

		public SetValueCommand(Connection connection) {
			super(connection, MiFwkUiMessages.RefObjectObservableValue_CommandNameValueChange);
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
			RefObjectObservableValue.super.doSetValue(mNewValue);
		}
	}
}
