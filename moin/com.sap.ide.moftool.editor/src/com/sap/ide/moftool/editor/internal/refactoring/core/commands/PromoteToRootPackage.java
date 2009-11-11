package com.sap.ide.moftool.editor.internal.refactoring.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Tag;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.ide.moftool.editor.core.commands.MofPartitionService;
import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class PromoteToRootPackage extends Command {

	private static final String PACKAGE_PREFIX_TAG_NAME = "packagePrefix"; //$NON-NLS-1$
	public static final String PACKAGE_PREFIX = "javax.jmi.packagePrefix"; //$NON-NLS-1$

	private final MofPackage pack;
	private final String partitionName;
	private final String prefix;

	public PromoteToRootPackage(MofPackage pack, String partitionName, String prefix) {
		super(pack.get___Connection(), com.sap.ide.moftool.editor.internal.LocalizationMessages.PromoteToRootPackage_0_XMSG);
		this.pack = pack;
		this.partitionName = partitionName;
		this.prefix = prefix;
	}

	@Override
	public boolean canExecute() {
		return NamespaceService.checkForNewToplevelPackage(pack.get___Connection(), pack.getName(), prefix).getSeverity() != IStatus.ERROR;
	}

	@Override
	public void doExecute() {
		pack.setLeaf(true);
		pack.setRoot(true);

		// Set package prefix and storage tags for root package
		if (prefix != null) {
			String name = PACKAGE_PREFIX_TAG_NAME;
			String annotation = LocalizationMessages.CreatePackageCommand_2_XMSG;
			String tagId = PACKAGE_PREFIX;
			Tag tag = getConnection().createElement(Tag.class);
			tag.setName(name);
			tag.setAnnotation(annotation);
			tag.setTagId(tagId);
			tag.getValues().add(prefix);
			// Tag has to reference the object it tags (containment is not enough
			tag.getElements().add(pack);
			pack.getContents().add(tag);

		}
		// [C-44]: Packages cannot be declared as abstract
		pack.setAbstract(false);
		pack.setContainer(null);

		// Add to correct partition
		ModelPartition partition = null;
		if (partitionName != null) {
			partition = MofPartitionService.getMetamodelPartition(getProjectForPackage(), partitionName, getConnection(), true);
		} else {
			partition = MofPartitionService.getOrCreateDefaultPartition(pack, getProjectForPackage(), getConnection());
		}
		((Partitionable) pack).assign___PartitionIncludingChildren(partition);
	}

	private IProject getProjectForPackage() {
		return ModelAdapter.getInstance().getProject(pack);
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return null;
	}

}
