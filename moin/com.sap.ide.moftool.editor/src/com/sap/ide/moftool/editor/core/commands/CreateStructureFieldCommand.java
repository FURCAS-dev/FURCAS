package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;

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

public class CreateStructureFieldCommand extends Command {

	private String mName = null;
	private StructureType mStructureType = null;
	private StructureField mStructureField = null;
	private IProject mProject = null;

	public CreateStructureFieldCommand(String name, StructureType parentStructureType, Connection connection) {
		super(connection, LocalizationMessages.CreateStructureFieldCommand_0_XMIT);
		mName = name;
		mStructureType = parentStructureType;
		mProject = ModelAdapter.getInstance().getProject(parentStructureType);
	}

	@Override
	public boolean canExecute() {
		return NamespaceService.checkForNewSubobject(mStructureType, mName).getSeverity() != IStatus.ERROR;
	}

	@Override
	public void doExecute() {
		// Create a new Structure Field
		mStructureField = getConnection().createElement(StructureField.class);
		mStructureField.setName(mName);
		mStructureField.setAnnotation(""); //$NON-NLS-1$
		mStructureField.setContainer(mStructureType);
		mStructureField.setType(MofService.getClassifierForString(getConnection(), "String")); //$NON-NLS-1$
		mStructureType.getContents().add(mStructureField);

		// Add to correct partition
		ModelPartition partition = MofPartitionService.getOrCreateDefaultPartition(mStructureField, mProject, getConnection());
		((Partitionable) mStructureField).assign___PartitionIncludingChildren(partition);

	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForSubObjectCreation(mStructureType, StructureField.class, mName);
	}

	public StructureField getStructureField() {
		return mStructureField;
	}
}
