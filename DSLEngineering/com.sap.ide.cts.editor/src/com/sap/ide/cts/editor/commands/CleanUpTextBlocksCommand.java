package com.sap.ide.cts.editor.commands;

import java.util.Collection;
import java.util.Collections;

import textblocks.TextBlock;

import com.sap.furcas.textual.textblocks.TbChangeUtil;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class CleanUpTextBlocksCommand extends Command {

	private final TextBlock rootBlock;
	private TextBlock newRootBlock;

	public CleanUpTextBlocksCommand(TextBlock rootBlock) {
		super(ModelAdapterUI.getInstance().getConnection(rootBlock), "Cleanup Textblocks");
		this.rootBlock = rootBlock;
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public void doExecute() {
		newRootBlock = (TextBlock) TbChangeUtil.cleanUp(rootBlock);
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		Partitionable partitionable = rootBlock;
	    PRI pri = partitionable.get___Partition().getPri();
	    PartitionOperation editOperation = new PartitionOperation(PartitionOperation.Operation.EDIT, pri);
	    return Collections.singleton(editOperation);
	}

	public TextBlock getNewRootBlock() {
		return newRootBlock;
	}

}
