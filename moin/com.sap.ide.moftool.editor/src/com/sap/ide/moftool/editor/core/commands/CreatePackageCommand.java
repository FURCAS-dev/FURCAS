package com.sap.ide.moftool.editor.core.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;

import org.eclipse.core.resources.IProject;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class CreatePackageCommand extends Command {

	private static final String PACKAGE_PREFIX_TAG_NAME = "packagePrefix"; //$NON-NLS-1$
	public static final String PACKAGE_PREFIX = "javax.jmi.packagePrefix"; //$NON-NLS-1$
	public static final String OLD_PACKAGE_PREFIX = "org.omg.mof.idl_prefix"; //$NON-NLS-1$

	private String mName = null;
	private MofPackage mParentPackage = null;
	private IProject mProject = null;
	private MofPackage mNewPackage = null;
	private String mPrefix = null;
	private String mPartitionName = null;

	public CreatePackageCommand(String name, MofPackage parentPackage, Connection connection) {
		super(connection, LocalizationMessages.CreatePackageCommand_0_XMIT);
		mName = name;
		mParentPackage = parentPackage;
		mProject = ModelAdapter.getInstance().getProject(mParentPackage);
	}

	public CreatePackageCommand(String name, String partitionName, IProject project, Connection connection) {
		this(name, project, connection);
		mPartitionName = partitionName;
	}

	public CreatePackageCommand(String name, IProject project, Connection connection) {
		super(connection, LocalizationMessages.CreatePackageCommand_1_XMIT);
		mName = name;
		mProject = project;
	}

	public void setPackagePrefix(String prefix) {
		if (mParentPackage != null) {
			throw new InternalErrorException("A package prefix can only be provided for root packages"); //$NON-NLS-1$
		}
		mPrefix = prefix;
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public void doExecute() {
		// Create a new package
		mNewPackage = getConnection().createElement(MofPackage.class);
		mNewPackage.setName(mName);
		mNewPackage.setAnnotation(""); //$NON-NLS-1$
		mNewPackage.setVisibility(VisibilityKindEnum.PUBLIC_VIS);
		mNewPackage.setLeaf(true);
		mNewPackage.setRoot(true);
		if (mParentPackage != null) {
			mNewPackage.setContainer(mParentPackage);
		}
		// Set package prefix and storage tags for root package
		if (mPrefix != null) {
			String name = PACKAGE_PREFIX_TAG_NAME;
			String annotation = LocalizationMessages.CreatePackageCommand_2_XMSG;
			String tagId = PACKAGE_PREFIX;
			Tag tag = getConnection().createElement(Tag.class);
			tag.setName(name);
			tag.setAnnotation(annotation);
			tag.setTagId(tagId);
			tag.getValues().add(mPrefix);
			// Tag has to reference the object it tags (containment is not enough
			tag.getElements().add(mNewPackage);
			mNewPackage.getContents().add(tag);

		}
		// [C-44]: Packages cannot be declared as abstract
		mNewPackage.setAbstract(false);

		// Add to correct partition
		ModelPartition partition = null;
		if (mPartitionName != null) {
			partition = MofPartitionService.getMetamodelPartition(mProject, mPartitionName, getConnection(), true);
		} else {
			partition = MofPartitionService.getOrCreateDefaultPartition(mNewPackage, mProject, getConnection());
		}
		((Partitionable) mNewPackage).assign___PartitionIncludingChildren(partition);
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		List<PartitionOperation> affectedPartitions = new ArrayList<PartitionOperation>();

		// Get the partition of the parent package or for the new package
		ModelPartition partition = null;
		if (mParentPackage != null) {
			Partitionable partitionable = mParentPackage;
			partition = partitionable.get___Partition();
		}

		// If it exists add it to the list of affected partitions
		if (partition != null) {
			PRI mri = partition.getPri();
			PartitionOperation editOperation = new PartitionOperation(PartitionOperation.Operation.EDIT, mri);
			affectedPartitions.add(editOperation);
		}
		return affectedPartitions;
	}

	public MofPackage getPackage() {
		return mNewPackage;
	}
}
