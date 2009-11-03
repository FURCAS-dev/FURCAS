package com.sap.mi.tools.cockpit.editor.model.command;

import java.util.Collection;
import java.util.Collections;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

/**
 * Sets the given attribute in the given object to the given value
 * 
 * @author d024127
 */
public final class SetAttributeCommand extends Command {

	private final RefObject refObj;

	private final Attribute attr;

	private final Object value;

	/**
	 * Constructs a moin command for setting an attribute. The command works on the object's connection.
	 * 
	 * @param refObj
	 *            The object for which the attribute is to be set
	 * @param attr
	 *            The attribute
	 * @param value
	 *            The attribute value
	 */
	public SetAttributeCommand(RefObject refObj, Attribute attr, Object value) {

		super(ModelAdapterUI.getInstance().getConnection(refObj), "Set " + attr.getName()); //$NON-NLS-1$
		this.refObj = refObj;
		this.attr = attr;
		this.value = value;
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {

		final Partitionable partitionable = (Partitionable) this.refObj;
		final PRI pri = partitionable.get___Partition().getPri();
		final PartitionOperation editOperation = new PartitionOperation(PartitionOperation.Operation.EDIT, pri);
		return Collections.singleton(editOperation);
	}

	@Override
	public void doExecute() {

		this.refObj.refSetValue(this.attr, this.value);
	}

	@Override
	public boolean canExecute() {

		return true;
	}
}