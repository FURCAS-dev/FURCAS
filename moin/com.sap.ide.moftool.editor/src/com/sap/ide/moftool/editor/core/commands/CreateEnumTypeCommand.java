package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Namespace;
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

public class CreateEnumTypeCommand extends Command {

	private String mName = null;
	private Namespace mContainer = null;
	private EnumerationType mEnumType = null;
	private IProject mProject = null;

	public CreateEnumTypeCommand(String name, Namespace parentContainer, Connection connection) {
		super(connection, LocalizationMessages.CreateEnumTypeCommand_0_XMIT);
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
		// Create a new class
		mEnumType = getConnection().createElement(EnumerationType.class);
		mEnumType.setName(mName);
		mEnumType.setAnnotation(""); //$NON-NLS-1$
		mEnumType.setContainer(mContainer);
		mEnumType.setVisibility(VisibilityKindEnum.PUBLIC_VIS);
		mEnumType.setLeaf(true);
		mEnumType.setRoot(true);
		mEnumType.getLabels().add(new String("label1")); //$NON-NLS-1$

		// Add to correct partition
		ModelPartition partition = MofPartitionService.getOrCreateDefaultPartition(mEnumType, mProject, getConnection());
		((Partitionable) mEnumType).assign___PartitionIncludingChildren(partition);

	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForSubObjectCreation(mContainer, MofClass.class, mName);
	}

	public EnumerationType getEnumType() {
		return mEnumType;
	}

}
