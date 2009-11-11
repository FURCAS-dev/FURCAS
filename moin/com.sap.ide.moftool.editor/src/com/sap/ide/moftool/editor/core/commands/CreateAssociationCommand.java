package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;
import java.util.Locale;

import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;

import org.eclipse.core.resources.IProject;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.ide.moftool.editor.core.service.StorageService;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.ModelManagerUI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

/**
 * MOIN command to create associations. Creates a new association and adds it to its default partition.
 * 
 * @author d027044
 */
public class CreateAssociationCommand extends Command {

	private String mName = null;
	private MofPackage mPackage = null;
	private MofClass mSource = null;
	private MofClass mTarget = null;
	private MofClass mClassForReference = null;
	private AggregationKindEnum mAggregationKind = null;
	private Association mAssociation = null;

	/**
	 * Creates a command to create a MOF {@link Association}. At least one of the involved {@link MofClass} objects (parameters source and
	 * target) has to be locally defined within this project; if both objects are defined in used metamodel projects an internal error will
	 * be thrown when exexuting this command.
	 * 
	 * @param name
	 *            The name for the new association
	 * @param parentPackage
	 *            The package that should contain the new {@link Association}. Must not be <code>null</code>.
	 * @param source
	 *            The source end {@link MofClass} of the {@link Association}. Must not be <code>null</code>.
	 * @param target
	 *            The target end {@link MofClass} of the {@link Association}. Must not be <code>null</code>.
	 * @param aggregationKind
	 *            The kind of the new {@link Association}. May be none, shared or composite. Must not be <code>null</code>.
	 * @param connection
	 *            The MOIN {@link Connection} to use to perform the operation. Must not be <code>null</code>.
	 */
	public CreateAssociationCommand(String name, MofPackage parentPackage, MofClass source, MofClass target,
			AggregationKindEnum aggregationKind, Connection connection) {
		this(name, parentPackage, source, target, source, aggregationKind, connection);
	}

	/**
	 * Creates a command to create a MOF {@link Association}
	 * 
	 * @param name
	 *            The name for the new association
	 * @param parentPackage
	 *            The package that should contain the new {@link Association}. Must not be <code>null</code>.
	 * @param source
	 *            The source end {@link MofClass} of the {@link Association}. Must not be <code>null</code>.
	 * @param target
	 *            The target end {@link MofClass} of the {@link Association}. Must not be <code>null</code>.
	 * @param aggregationKind
	 *            The kind of the new {@link Association}. May be none, shared or composite. Must not be <code>null</code>.
	 * @param connection
	 *            The MOIN {@link Connection} to use to perform the operation. Must not be <code>null</code>.
	 */
	public CreateAssociationCommand(String name, MofPackage parentPackage, MofClass source, MofClass target, MofClass classForReference,
			AggregationKindEnum aggregationKind, Connection connection) {
		super(connection, LocalizationMessages.CreateAssociationCommand_0_XMIT);
		mName = name;
		mPackage = parentPackage;
		mSource = source;
		mTarget = target;
		mClassForReference = classForReference;
		mAggregationKind = aggregationKind;
	}

	@Override
	/*
	 * Checks that all pre-requisites are fullfilled: - None of the requiered parameters are missing
	 */
	public boolean canExecute() {
		if (mPackage == null) {
			return false;
		}
		if (mSource == null) {
			return false;
		}
		if (mTarget == null) {
			return false;
		}
		if (mAggregationKind == null) {
			return false;
		}
		if (getConnection() == null) {
			return false;
		}
		return true;
	}

	/**
	 * Create the new association. Should not be called directly; commands should be started via {@link ModelManagerUI#getCommandManager()
	 * #doExecute()}.
	 */
	@Override
	public void doExecute() {
		// Create association
		ModelPackage modelPackage = MofService.getModelPackage(getConnection());
		mAssociation = getConnection().createElement(Association.class);
		mAssociation.setName(mName);
		mAssociation.setAnnotation(""); //$NON-NLS-1$
		mAssociation.setContainer(mPackage);
		// [C-37]: Associations must have visibility of "public"
		mAssociation.setVisibility(VisibilityKindEnum.PUBLIC_VIS);
		// [C-35]: The values for "isLeaf" and "isRoot" on an Association must be true
		mAssociation.setLeaf(true);
		mAssociation.setRoot(true);
		// [C-36]: An Association cannot be abstract
		mAssociation.setAbstract(false);

		// Create source association end
		AssociationEnd sourceEnd = getConnection().createElement(AssociationEnd.class);

		sourceEnd.setAggregation(mAggregationKind);
		sourceEnd.setType(mSource);
		sourceEnd.setContainer(mAssociation);
		sourceEnd.setName(mSource.getName().toLowerCase(Locale.ENGLISH));
		sourceEnd.setAnnotation(""); //$NON-NLS-1$
		// [c-57] if a MultiplicityType specifies bounds of [0..1] or [1..1], the is_ordered and is_unique values must be false
		MultiplicityType multiplicityType = MofService.createMultiplicityType(modelPackage, 1, 1, false, false);
		sourceEnd.setMultiplicity(multiplicityType);
		sourceEnd.setChangeable(true);

		// Create target association end
		AssociationEnd targetEnd = getConnection().createElement(AssociationEnd.class);
		targetEnd.setAggregation(AggregationKindEnum.NONE);
		targetEnd.setType(mTarget);
		targetEnd.setContainer(mAssociation);
		String name = NamespaceService.getValidNameForNewSubobject(mAssociation, mTarget.getName().toLowerCase(Locale.ENGLISH));
		targetEnd.setName(name);
		targetEnd.setAnnotation(""); //$NON-NLS-1$
		// [C-40]: The "isUnique" flag in an AssociationEnd's multiplicity must be true
		multiplicityType = MofService.createMultiplicityType(modelPackage, 0, -1, false, true);
		targetEnd.setMultiplicity(multiplicityType);
		targetEnd.setChangeable(true);

		boolean sourceEndStorage = false;
		boolean targetEndStorage = false;
		if (!ModelElementService.isForeignObject(mAssociation, mSource)) {
			// Class at source end of association is part of this project
			// -> Set storage to true for first association end
			sourceEndStorage = true;
			// -> Set storage to false for second association end (at most one end
			// can have storage)
			targetEndStorage = false;
		} else if (!ModelElementService.isForeignObject(mAssociation, mTarget)) {
			// Class at target end of association is part of this project
			// -> Set storage to false for first association end (setting storage would
			// need to change the generated JMI class for the MOFClass at this end which
			// would be a not allowed modification
			sourceEndStorage = false;
			// -> Set storage to true for second association end (at least one end
			// must have storage)
			targetEndStorage = true;
		} else {
			// Both ends are not local to this project. Storage cannot be set for any end
			// would mean a modification of the generated JMI classes for the MOFClass at
			// the end. Since storage needs to be set for at one end this means that creating
			// the association is not allowed and should not be allowed by the tool either
			throw new InternalErrorException("Creating an association between two foreign classes is not allowed"); //$NON-NLS-1$
		}
		// Set storage tags
		StorageService.getOrCreateRelevantStorageTag(sourceEnd, sourceEndStorage, getConnection()).getElements().add(sourceEnd);
		StorageService.getOrCreateRelevantStorageTag(targetEnd, targetEndStorage, getConnection()).getElements().add(targetEnd);

		// The navigability flag for association ends is not evaluated by MOIN. In fact
		// it would be an artificial restriction since the internal implementation in MOIN
		// always supports navigability on association level. Therefore MOIN always assumes
		// that the flag is set and ignores if it is not set. To be consistent we always set it.
		sourceEnd.setNavigable(true);
		targetEnd.setNavigable(true);

		// Add to correct partition
		IProject project = ModelAdapter.getInstance().getProject(mPackage);
		ModelPartition partition = MofPartitionService.getOrCreateDefaultPartition(mAssociation, project, getConnection());
		((Partitionable) mAssociation).assign___PartitionIncludingChildren(partition);

		// Create related reference in classes if the class belongs to the currently edited project
		if (mClassForReference != null) {
			Reference newReference = null;
			// Check that reference will not be created in foreign object (object from other project)
			if (mAggregationKind.equals(AggregationKindEnum.NONE)) {
				if (!ModelElementService.isForeignObject(mPackage, mClassForReference)) {
					CreateReferenceCommand command = new CreateReferenceCommand(sourceEnd, targetEnd, mClassForReference, getConnection());
					command.doExecute();
					newReference = command.getReference();
				}
			} else if (mAggregationKind.equals(AggregationKindEnum.COMPOSITE)) {
				// Check that reference will not be created in foreign object (object from other project)
				if (!ModelElementService.isForeignObject(mPackage, targetEnd.getType())) {
					CreateReferenceCommand command = new CreateReferenceCommand(sourceEnd, targetEnd, getConnection());
					command.doExecute();
					newReference = command.getReference();
				}
			}
			if (newReference != null) {
				// Add to correct partition
				partition = MofPartitionService.getOrCreateDefaultPartition(newReference, project, getConnection());
				((Partitionable) mAssociation).assign___PartitionIncludingChildren(partition);
			}
		}
	}

	@Override
	/*
	 * Returns those partitions that will be affected by creating a new association.
	 */
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForSubObjectCreation(mPackage, Association.class, mName);
	}

	/**
	 * Returns the newly created {@link Association}.
	 * 
	 * @return The new object in case the command performed correctly, <code>null</code> otherwise.
	 */
	public Association getAssociation() {
		return mAssociation;
	}
}
