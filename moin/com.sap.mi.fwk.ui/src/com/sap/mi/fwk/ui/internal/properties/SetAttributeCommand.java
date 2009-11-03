package com.sap.mi.fwk.ui.internal.properties;

import java.util.Collection;
import java.util.Collections;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

/**
 * Sets the given attribute in the given object to the given value
 * 
 * @author d024127
 */
public final class SetAttributeCommand extends Command {

	private RefObject refObj;
	private Attribute attr;
	private Object value;

	/**
	 * Constructs a moin command for setting an attribute. The command works on
	 * the object's connection.
	 * 
	 * @param refObj
	 *            The object for which the attribute is to be set
	 * @param attr
	 *            The attribute
	 * @param value
	 *            The attribute value
	 */
	public SetAttributeCommand(RefObject refObj, Attribute attr, Object value) {
		super(ModelAdapter.getInstance().getConnection(refObj), MiFwkUiMessages.bind(
				MiFwkUiMessages.RefObjectPropertySource_setAttributeCommand_name, attr.getName()));
		this.refObj = refObj;
		this.attr = attr;
		this.value = value;
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		PRI pri = refObj.get___Partition().getPri();
		PartitionOperation editOperation = new PartitionOperation(PartitionOperation.Operation.EDIT, pri);
		return Collections.singleton(editOperation);
	}

	@Override
	public void doExecute() {
		refObj.refSetValue(attr, value);
	}

	@Override
	public boolean canExecute() {
		return true;
	}
}