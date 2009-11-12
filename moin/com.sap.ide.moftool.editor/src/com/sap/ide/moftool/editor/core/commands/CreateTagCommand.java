package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Tag;

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

public class CreateTagCommand extends Command {

	private Namespace mParent = null;
	private String mName = null;
	private Tag mTag = null;
	private IProject mProject = null;

	public CreateTagCommand(Namespace parent, String name, Connection connection) {
		super(connection, LocalizationMessages.CreateTagCommand_0_XMIT);
		mParent = parent;
		mName = name;
		mProject = ModelAdapter.getInstance().getProject(mParent);
	}

	@Override
	public boolean canExecute() {
		return NamespaceService.checkForNewSubobject(mParent, mName).getSeverity() != IStatus.ERROR;
	}

	@Override
	public void doExecute() {
		// Create a new import
		mTag = getConnection().createElement(Tag.class);
		mTag.setName(mName);
		mTag.setAnnotation(""); //$NON-NLS-1$
		mTag.setTagId(mName);
		mTag.setContainer(mParent);
		mTag.getElements().add(mParent);
		mParent.getContents().add(mTag);

		// Add to correct partition
		ModelPartition partition = MofPartitionService.getOrCreateDefaultPartition(mTag, mProject, getConnection());
		((Partitionable) mTag).assign___PartitionIncludingChildren(partition);
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForSubObjectCreation(mParent, Tag.class, mName);
	}

	public Tag getTag() {
		return mTag;
	}
}
