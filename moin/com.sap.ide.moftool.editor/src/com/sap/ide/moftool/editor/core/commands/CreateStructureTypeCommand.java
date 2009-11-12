package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.ide.moftool.editor.exec.ExecMOFToolDefaultImpl;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class CreateStructureTypeCommand extends Command {
	private String mName = null;
	private Namespace mContainer = null;
	private StructureType mStructureType = null;
	private IProject mProject = null;

	public CreateStructureTypeCommand(String name, Namespace parentContainer, Connection connection) {
		super(connection, LocalizationMessages.CreateStructureTypeCommand_0_XMIT);
		mName = name;
		mContainer = parentContainer;
		mProject = ModelAdapter.getInstance().getProject(mContainer);
	}

	@Override
	public boolean canExecute() {
		return NamespaceService.checkForNewSubobject(mContainer, mName).getSeverity() != IStatus.ERROR;
	}

	@Override
	public void doExecute() {
		// Create a new Structure Type
		mStructureType = getConnection().createElement(StructureType.class);
		mStructureType.setName(mName);
		mStructureType.setAnnotation(""); //$NON-NLS-1$
		mStructureType.setContainer(mContainer);
		mStructureType.setVisibility(VisibilityKindEnum.PUBLIC_VIS);
		mStructureType.setLeaf(false);
		mStructureType.setRoot(false);

		// [C-59] Add field to structure type
		CreateStructureFieldCommand command = new CreateStructureFieldCommand(ExecMOFToolDefaultImpl.NEW_STRUCTURE_FIELD_NAME,
				mStructureType, getConnection());
		command.doExecute();

		// Add to correct partition
		ModelPartition partition = MofPartitionService.getOrCreateDefaultPartition(mStructureType, mProject, getConnection());
		((Partitionable) mStructureType).assign___PartitionIncludingChildren(partition);

	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForSubObjectCreation(mContainer, StructureType.class, mName);
	}

	public StructureType getStructureType() {
		return mStructureType;
	}
}
