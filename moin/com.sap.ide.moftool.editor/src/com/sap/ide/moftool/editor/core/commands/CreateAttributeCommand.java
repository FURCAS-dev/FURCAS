package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
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

public class CreateAttributeCommand extends Command {

	private String mName = null;
	private MofClass mClass = null;
	private Attribute mAttribute = null;
	private IProject mProject = null;

	public CreateAttributeCommand(String name, MofClass parentClass, Connection connection) {
		super(connection, LocalizationMessages.CreateAttributeCommand_0_XMIT);
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
		// Create a new attribute
		ModelPackage modelPackage = MofService.getModelPackage(getConnection());
		mAttribute = getConnection().createElement(Attribute.class);
		mAttribute.setName(mName);
		mAttribute.setAnnotation(""); //$NON-NLS-1$
		mAttribute.setVisibility(VisibilityKindEnum.PUBLIC_VIS);
		mAttribute.setScope(ScopeKindEnum.INSTANCE_LEVEL);
		MultiplicityType multiplicityType = MofService.createMultiplicityType(modelPackage, 1, 1, false, false);
		mAttribute.setMultiplicity(multiplicityType);
		mAttribute.setType(MofService.getClassifierForString(getConnection(), "String")); //$NON-NLS-1$
		mAttribute.setChangeable(true);
		mAttribute.setContainer(mClass);
		mClass.getContents().add(mAttribute);

		// Add to correct partition
		ModelPartition partition = MofPartitionService.getOrCreateDefaultPartition(mAttribute, mProject, getConnection());
		((Partitionable) mAttribute).assign___PartitionIncludingChildren(partition);
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForSubObjectCreation(mClass, Attribute.class, mName);
	}

	public Attribute getAttribute() {
		return mAttribute;
	}
}
