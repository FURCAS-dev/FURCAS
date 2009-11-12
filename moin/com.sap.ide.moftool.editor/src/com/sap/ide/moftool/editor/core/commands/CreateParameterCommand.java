package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.BehavioralFeature;
import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.Parameter;

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

public class CreateParameterCommand extends Command {

	private String mName = null;
	private DirectionKindEnum mDirection = null;
	private BehavioralFeature mParent = null;
	private Parameter mParameter = null;
	private IProject mProject = null;

	public CreateParameterCommand(String name, DirectionKindEnum direction, BehavioralFeature parent, Connection connection) {
		super(connection, LocalizationMessages.CreateParameterCommand_0_XMIT);
		mName = name;
		mDirection = direction;
		mParent = parent;
		mProject = ModelAdapter.getInstance().getProject(mParent);
	}

	@Override
	public boolean canExecute() {
		return NamespaceService.checkForNewSubobject(mParent, mName).getSeverity() != IStatus.ERROR;
	}

	@Override
	public void doExecute() {
		// Create a new attribute
		ModelPackage modelPackage = MofService.getModelPackage(getConnection());
		mParameter = getConnection().createElement(Parameter.class);
		mParameter.setName(mName);
		mParameter.setAnnotation(""); //$NON-NLS-1$
		mParameter.setDirection(mDirection);
		MultiplicityType multiplicityType = MofService.createMultiplicityType(modelPackage, 1, 1, false, false);
		mParameter.setMultiplicity(multiplicityType);
		mParameter.setType(MofService.getClassifierForString(getConnection(), "String")); //$NON-NLS-1$
		mParameter.setContainer(mParent);
		mParent.getContents().add(mParameter);

		// Add to correct partition
		ModelPartition partition = MofPartitionService.getOrCreateDefaultPartition(mParameter, mProject, getConnection());
		((Partitionable) mParameter).assign___PartitionIncludingChildren(partition);
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForSubObjectCreation(mParent, Parameter.class, mName);
	}

	public Parameter getParameter() {
		return mParameter;
	}
}
