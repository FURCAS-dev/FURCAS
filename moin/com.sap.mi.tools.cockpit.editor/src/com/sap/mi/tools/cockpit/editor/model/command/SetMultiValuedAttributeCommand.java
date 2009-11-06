package com.sap.mi.tools.cockpit.editor.model.command;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * @author d003456
 * 
 */
public class SetMultiValuedAttributeCommand extends Command {

	private final RefObject refObject;

	private final Attribute attribute;

	private final Object oldValue;

	private final Object newValue;

	private final int index;

	/**
	 * Constructor
	 * 
	 * @param connection
	 * @param refObject
	 * @param attribute
	 * @param oldValue
	 * @param newValue
	 * @param index
	 */
	public SetMultiValuedAttributeCommand(RefObject refObject, Attribute attribute, Object oldValue, Object newValue, int index) {

		super(ModelAdapterUI.getInstance().getConnection(refObject), "set  value of multivalued " + attribute.getName()); //$NON-NLS-1$
		this.refObject = refObject;
		this.attribute = attribute;
		this.oldValue = oldValue;
		this.newValue = newValue;
		this.index = index;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.commands.Command#canExecute()
	 */
	@Override
	public boolean canExecute() {

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.commands.Command#doExecute()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void doExecute() {

		final Object o = this.refObject.refGetValue(this.attribute.getName());

		if (o instanceof List) {
			((List) o).remove(this.oldValue);
			((List) o).add(this.index, this.newValue);

		} else if (o instanceof Collection) {
			((Collection) o).remove(this.oldValue);
			((Collection) o).add(this.newValue);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.commands.Command#getAffectedPartitions()
	 */
	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {

		final Partitionable partitionable = (Partitionable) this.refObject;
		final PRI pri = partitionable.get___Partition().getPri();
		final PartitionOperation editOperation = new PartitionOperation(PartitionOperation.Operation.EDIT, pri);
		return Collections.singleton(editOperation);

	}

}
