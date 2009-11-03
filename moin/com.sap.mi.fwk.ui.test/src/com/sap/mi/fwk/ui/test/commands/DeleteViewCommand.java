package com.sap.mi.fwk.ui.test.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class DeleteViewCommand extends Command {

    //private static final TracerI sTracer = TracingManager.getTracer(DeleteViewCommand.class);

    private final static String DESCRIPTION = "Delete View";

    private View[] views;

    public DeleteViewCommand(Connection connection, View[] views) {
        super(connection, DESCRIPTION);
        this.views = views;
    }

    @Override
    public Collection<PartitionOperation> getAffectedPartitions() {
        List<PartitionOperation> affectedPartitions = new ArrayList<PartitionOperation>();
        Set<ModelPartition> partitions = new HashSet<ModelPartition>();
        for (View view : views) {
            Partitionable part = (Partitionable) view;
            ModelPartition partition = part.get___Partition();
            if (!partitions.contains(partition)) {
                partitions.add(partition);
                PRI mri = part.get___Partition().getPri();
                PartitionOperation editOperation = new PartitionOperation(PartitionOperation.Operation.EDIT, mri);
                affectedPartitions.add(editOperation);
            }
        }
        return affectedPartitions;
    }

    @Override
    public void doExecute() {
        for (View view : views) {
            view.refDelete();
        }
    }
    
	@Override
	public boolean canExecute() {
		return true;
	}

}
