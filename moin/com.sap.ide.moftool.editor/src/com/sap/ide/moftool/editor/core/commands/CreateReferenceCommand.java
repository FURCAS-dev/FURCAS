package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;
import java.util.Locale;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.Reference;
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

public class CreateReferenceCommand extends Command {

	private MofClass mClass = null;
	private String mName = null;
	private AssociationEnd mExposedEnd = null;
	private AssociationEnd mReferencedEnd = null;
	private Reference mReference = null;
	private IProject mProject = null;

	/**
	 * Can be used to create a reference for the given association ends. The reference will be created in the exposed ends class.
	 * 
	 * @param exposedEnd
	 *            The exposed end for the reference
	 * @param referencedEnd
	 *            The target class for the reference
	 * @param connection
	 *            The MOIN connection to use
	 */
	public CreateReferenceCommand(AssociationEnd exposedEnd, AssociationEnd referencedEnd, Connection connection) {
		this(exposedEnd, referencedEnd, (MofClass) exposedEnd.getType(), connection);
	}

	/**
	 * Can be used to create a reference for the given association ends. The reference will be created in the given class.
	 * 
	 * @param exposedEnd
	 *            The exposed end for the reference
	 * @param referencedEnd
	 *            The target class for the reference
	 * @param containingClass
	 *            The class that shall contain the new reference
	 * @param connection
	 *            The MOIN connection to use
	 */
	public CreateReferenceCommand(AssociationEnd exposedEnd, AssociationEnd referencedEnd, MofClass containingClass, Connection connection) {
		super(connection, LocalizationMessages.CreateReferenceCommand_0_XMIT);
		mExposedEnd = exposedEnd;
		mReferencedEnd = referencedEnd;
		mClass = containingClass;
		mName = NamespaceService.getValidNameForNewSubobject(mClass, mReferencedEnd.getName().toLowerCase(Locale.ENGLISH));
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
		mReference = getConnection().createElement(Reference.class);
		mReference.setReferencedEnd(mReferencedEnd);
		mReference.setExposedEnd(mExposedEnd);
		mReference.setName(mName);
		mReference.setAnnotation(""); //$NON-NLS-1$
		mReference.setType(mReferencedEnd.getType());
		mReference.setVisibility(VisibilityKindEnum.PUBLIC_VIS);
		mReference.setScope(ScopeKindEnum.INSTANCE_LEVEL);
		// Set multiplicity to the multiplicity of the foreign association end
		MultiplicityType multiplicityType = MofService.createMultiplicityType(modelPackage, mReferencedEnd.getMultiplicity().getLower(),
				mReferencedEnd.getMultiplicity().getUpper(), mReferencedEnd.getMultiplicity().isOrdered(), mReferencedEnd.getMultiplicity()
						.isUnique());
		mReference.setMultiplicity(multiplicityType);
		mReference.setChangeable(mReferencedEnd.isChangeable());
		mClass.getContents().add(mReference);

		// Add to correct partition
		ModelPartition partition = MofPartitionService.getOrCreateDefaultPartition(mReference, mProject, getConnection());
		((Partitionable) mReference).assign___PartitionIncludingChildren(partition);
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForSubObjectCreation(mClass, Reference.class, mName);
	}

	public Reference getReference() {
		return mReference;
	}
}
