package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.EvaluationKindEnum;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.omg.ocl.attaching.OclConstraint;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class CreateConstraintCommand extends Command {

	private Namespace mParent = null;
	private String mName = null;
	private OclConstraint mConstraint = null;
	private IProject mProject = null;

	public CreateConstraintCommand(Namespace parent, String name, Connection connection) {
		super(connection, LocalizationMessages.CreateConstraintCommand_0_XMIT);
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
		// Create a new constraint
		mConstraint = getConnection().createElement(OclConstraint.class);
		mConstraint.setName(mName);
		mConstraint.setAnnotation(""); //$NON-NLS-1$
		mConstraint.setContainer(mParent);
		mConstraint.setEvaluationPolicy(EvaluationKindEnum.DEFERRED);
		mConstraint.setLanguage("OCL"); //$NON-NLS-1$
		if (!(mParent instanceof MofPackage)) {
			mConstraint.setExpression("context " + mParent.getName() + " inv: true"); //$NON-NLS-1$ //$NON-NLS-2$
			mConstraint.getConstrainedElements().add(mParent);
		} else {
			mConstraint.setExpression("context OclUndefined inv: true"); //$NON-NLS-1$ 
		}
		mParent.getContents().add(mConstraint);

		// Add to correct partition
		ModelPartition partition = MofPartitionService.getOrCreateDefaultPartition(mConstraint, mProject, getConnection());
		((Partitionable) mConstraint).assign___PartitionIncludingChildren(partition);
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForSubObjectCreation(mParent, Constraint.class, mName);
	}

	public Constraint getConstraint() {
		return mConstraint;
	}

}
