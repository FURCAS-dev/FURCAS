package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
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

public class CreateClassCommand extends Command {

	private String mName = null;
	private MofPackage mPackage = null;
	private MofClass mClass = null;
	private IProject mProject = null;

	public CreateClassCommand(String name, MofPackage parentPackage, Connection connection) {
		super(connection, LocalizationMessages.CreateClassCommand_0_XMIT);
		mName = name;
		mPackage = parentPackage;
		mProject = ModelAdapter.getInstance().getProject(mPackage);
	}

	@Override
	public boolean canExecute() {
		return NamespaceService.checkForNewSubobject(mPackage, mName).getSeverity() != IStatus.ERROR;
	}

	@Override
	public void doExecute() {
		// Create a new class
		mClass = getConnection().createElement(MofClass.class);
		mClass.setName(mName);
		mClass.setAnnotation(""); //$NON-NLS-1$
		mClass.setContainer(mPackage);
		mClass.setVisibility(VisibilityKindEnum.PUBLIC_VIS);
		mClass.setSingleton(false);

		// Add to correct partition
		ModelPartition partition = MofPartitionService.getOrCreateDefaultPartition(mClass, mProject, getConnection());
		((Partitionable) mClass).assign___PartitionIncludingChildren(partition);
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForSubObjectCreation(mPackage, MofClass.class, mName);
	}

	public MofClass getMofClass() {
		return mClass;
	}
}
