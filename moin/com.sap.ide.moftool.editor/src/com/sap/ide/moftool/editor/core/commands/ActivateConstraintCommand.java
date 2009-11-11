package com.sap.ide.moftool.editor.core.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Path;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.mi.fwk.PartitionService;
import com.sap.tc.moin.friends.ConnectionUtil;
import com.sap.tc.moin.friends.factory.UtilitiesFactory;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class ActivateConstraintCommand extends Command {

	private IProject mProject = null;
	private Connection mConnection = null;
	private Set<ModelPartition> mPartitionSet = new HashSet<ModelPartition>(1);
	
	private Map<ProcessReport, MRI> mResults = null;
	
	public ActivateConstraintCommand(IProject project, Connection connection) {
		super(connection, LocalizationMessages.ActivateConstraintCommand_0_XMIT);
		mProject = project;
		mConnection = connection;
		
		// Retrieve partition list
		Iterator<PRI> it = PartitionService.getInstance().getPartitions(connection, mProject).iterator();
		while (it.hasNext()) {
			PRI pri = it.next();
			if (!pri.isNullPartition()) {
				ModelPartition partition = PartitionService.getInstance().getPartition(connection,
						mProject, new Path(pri.getPartitionName()));
				mPartitionSet.add(partition);
			}
		}
	}

	@Override
	public boolean canExecute() {
		return mProject != null && mConnection != null;
	}

	@Override
	public void doExecute() {

		// Do the parsing
		try {
//			mResults = mConnection.getOclRegistryService().parseOclConstraintsInPartitions(mPartitionSet);
            ConnectionUtil util = UtilitiesFactory.getConnectionUtil( );
            mResults = util.getOclActivator( mConnection ).parseOclConstraintsInPartitions( mPartitionSet );

		}
		catch (RuntimeException e) {
			throw new InternalErrorException(e);
		}
		
		// Move all new objects into standard partition
		ModelPartition standardPartition = MofPartitionService.getStandardOclPartition(mProject, mConnection, false);
		Collection<Partitionable> newObjects = mConnection.getNullPartition().getElements();
		for (Iterator<Partitionable> iterator = newObjects.iterator(); iterator.hasNext();) {
			Partitionable partitionable = iterator.next();
			standardPartition.assignElement(partitionable);
		}
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		ArrayList<PartitionOperation> list = new ArrayList<PartitionOperation>(mPartitionSet.size());
		Iterator<ModelPartition> it = mPartitionSet.iterator();
		while (it.hasNext()) {
			ModelPartition partition = it.next();
			PartitionOperation operation = new PartitionOperation(PartitionOperation.Operation.EDIT,
					partition.getPri());
			list.add(operation);
		}
		return list;
	}
	
	public Map<ProcessReport, MRI> getResult() {
		return mResults;
	}
}
