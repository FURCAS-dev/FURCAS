package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Import;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
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

public class CreateImportCommand extends Command {

	private MofPackage mImporter = null;
	private Namespace mImported = null;
	private String mName = null;
	private Import mImport = null;
	private IProject mProject = null;

	public CreateImportCommand(MofPackage importer, Namespace imported, Connection connection) {
		super(connection, LocalizationMessages.CreateImportCommand_0_XMIT);
		mImporter = importer;
		mImported = imported;
		mProject = ModelAdapter.getInstance().getProject(mImporter);
		mName = NamespaceService.getValidNameForNewSubobject(mImporter, mImported.getName());
	}

	@Override
	public boolean canExecute() {
		return NamespaceService.checkForNewSubobject(mImporter, mName).getSeverity() != IStatus.ERROR;
	}

	@Override
	public void doExecute() {
		// Create a new import
		mImport = getConnection().createElement(Import.class);
		mImport.setName(mName);
		mImport.setAnnotation(""); //$NON-NLS-1$
		mImport.setVisibility(VisibilityKindEnum.PUBLIC_VIS);
		// MOIN decision: only clustered imports are allowed
		mImport.setClustered(true);
		mImport.setImportedNamespace(mImported);
		mImport.setContainer(mImporter);
		mImporter.getContents().add(mImport);

		// Add to correct partition
		ModelPartition partition = MofPartitionService.getOrCreateDefaultPartition(mImport, mProject, getConnection());
		((Partitionable) mImport).assign___PartitionIncludingChildren(partition);
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForSubObjectCreation(mImporter, Attribute.class, mName);
	}

	public Import getImport() {
		return mImport;
	}
}
