package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.ScopeKindEnum;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class CreateOperationCommand extends Command {

	private String mName = null;
	private MofClass mClass = null;
	private Operation mOperation = null;
	private IProject mProject = null;

	public CreateOperationCommand(String name, MofClass parentClass, Connection connection) {
		super(connection, LocalizationMessages.CreateOperationCommand_0_XMIT);
		mName = name;
		mClass = parentClass;
		mProject = ModelAdapter.getInstance().getProject(mClass);
	}

	@Override
	public boolean canExecute() {
		return NamespaceService.checkForNewSubobject(mClass, mName).getSeverity() != IStatus.ERROR;
	}

	@Override
	public void doExecute() {
		// Create a new operation
		mOperation = getConnection().createElement(Operation.class);
		mOperation.setName(mName);
		mOperation.setAnnotation(""); //$NON-NLS-1$
		mOperation.setVisibility(VisibilityKindEnum.PUBLIC_VIS);
		mOperation.setScope(ScopeKindEnum.INSTANCE_LEVEL);
		mOperation.setContainer(mClass);
		mClass.getContents().add(mOperation);

		// Add to correct partition
		ModelPartition partition = MofPartitionService.getOrCreateDefaultPartition(mOperation, mProject, getConnection());
		((Partitionable) mOperation).assign___PartitionIncludingChildren(partition);
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForSubObjectCreation(mClass, Operation.class, mName);
	}

	public Operation getOperation() {
		return mOperation;
	}
}
