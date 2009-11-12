package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.Constant;
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

public class CreateConstantCommand extends Command {

	private Namespace mParent = null;
	private String mName = null;
	private Constant mConstant = null;
	private IProject mProject = null;

	public CreateConstantCommand(Namespace parent, String name, Connection connection) {
		super(connection, LocalizationMessages.CreateConstantCommand_0_XMIT);
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
		// Create a new constant
		mConstant = getConnection().createElement(Constant.class);
		mConstant.setName(mName);
		mConstant.setAnnotation(""); //$NON-NLS-1$
		mConstant.setType(MofService.getClassifierForString(getConnection(), "String")); //$NON-NLS-1$
		mConstant.setValue(""); //$NON-NLS-1$
		mConstant.setContainer(mParent);
		mParent.getContents().add(mConstant);

		// Add to correct partition
		ModelPartition partition = MofPartitionService.getOrCreateDefaultPartition(mConstant, mProject, getConnection());
		((Partitionable) mConstant).assign___PartitionIncludingChildren(partition);
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForSubObjectCreation(mParent, Tag.class, mName);
	}

	public Constant getConstant() {
		return mConstant;
	}
}
