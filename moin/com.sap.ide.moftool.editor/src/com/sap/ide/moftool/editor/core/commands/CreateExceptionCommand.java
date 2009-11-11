package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofException;
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

public class CreateExceptionCommand extends Command {

	private String mName = null;
	private MofClass mClass = null;
	private MofException mException = null;
	private IProject mProject = null;

	public CreateExceptionCommand(String name, MofClass parentClass, Connection connection) {
		super(connection, LocalizationMessages.CreateExceptionCommand_0_XMIT);
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
		// Create a new exception
		mException = getConnection().createElement(MofException.class);
		mException.setName(mName);
		mException.setAnnotation(""); //$NON-NLS-1$
		mException.setVisibility(VisibilityKindEnum.PUBLIC_VIS);
		mException.setScope(ScopeKindEnum.INSTANCE_LEVEL);
		mException.setContainer(mClass);
		mClass.getContents().add(mException);

		// Add to correct partition
		ModelPartition partition = MofPartitionService.getOrCreateDefaultPartition(mException, mProject, getConnection());
		((Partitionable) mException).assign___PartitionIncludingChildren(partition);
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForSubObjectCreation(mClass, MofException.class, mName);
	}

	public MofException getMofException() {
		return mException;
	}
}
