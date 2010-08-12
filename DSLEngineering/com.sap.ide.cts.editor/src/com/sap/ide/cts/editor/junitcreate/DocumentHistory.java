package com.sap.ide.cts.editor.junitcreate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.AssertionFailedException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import textblocks.TextBlock;

import com.sap.ide.cts.editor.CtsActivator;
import com.sap.ide.cts.editor.deepcopy.DeepCopyHelper;
import com.sap.ide.cts.editor.deepcopy.GenericModelCopyStrategy;
import com.sap.ide.cts.editor.document.CtsDocument;
import com.sap.ide.cts.editor.document.CtsHistoryDocument;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.ui.dnd.IModelTransferTarget;
import com.sap.tc.moin.globalmodellistener.GlobalEventListenerRegistry;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DeepCopyPolicyHandler;
import com.sap.tc.moin.repository.DeepCopyResultSet;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.commands.PartitionOperation.Operation;
import com.sap.tc.moin.repository.consistency.ConsistencyViolation;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Document history used by {@link CtsHistoryDocument} to manage and record
 * snapshots and DocumentEvents.
 *
 * @author D049157
 *
 */
public class DocumentHistory implements IDocumentListener {

    /**
     * Set this to false to disable snapshotting.
     *
     * Automatically set to false once an internal error occurs
     */
    private Boolean isActive = true;

    private static final String PRI_ENDING = ".types";
    private static final String PRI_FOLDER = "src/";

    private static class Session {
	Boolean isPersisted = false;
	final String snapshotIdentifier = UUID.randomUUID().toString().replace("-", "");
	/** the copy of the rootObject of CtsHistoryDocument */
	RefObject newDocumentRootObject;
	/** all copied elements without a composite parent: HashMap<Original, Copy> */
	Map<RefObject, RefObject> rootElements;
	/** all DocumentEvents on the CtsHistoryDocument under observation */
	final Collection<DocumentEvent> eventHistory = new LinkedList<DocumentEvent>();
	/** the transient model partitions which are used as model cache: <PartitionName, Partition> */
	Map<String, ModelPartition> transientPartitions;
	/** Pre-existing constraints errors of the model */
	public Collection<JmiException> knownConstraintErrors;

	Boolean isCompleted() {
	    return newDocumentRootObject != null;
	}
    }

    /**
     * Editor session we use for test creation (Session between the last two
     * save points.)
     */
    private Session completedSession;
    /** Currently active and still modified session */
    private Session currentSession;

    private final Connection targetConnection;
    private final CtsDocument document;

    public DocumentHistory(CtsDocument document, IProject project) {
	this.document = document;

	// A new connection is required in order to persist snapshots without
	// flushing a dirty editor connection.
	targetConnection = createTargetConnection(project, document.getRootObject().get___Connection());

	// initialize with Null-Objects
	completedSession = new Session();
	currentSession = new Session();
    }

    /**
     * Get the DocumentEvent history of the given snapshot version.
     *
     * @return
     */
    public Collection<DocumentEvent> getHistory(SnapshotVersion version) {
	Session session = getSessionOfVersion(version);
	return session.eventHistory;

    }

    private Session getSessionOfVersion(SnapshotVersion version) {
	if (version.equals(SnapshotVersion.CURRENT)) {
	    return currentSession;
	} else {
	    assert version.equals(SnapshotVersion.COMPLETED);
	    return completedSession;
    	}
    }

    /**
     * Create a new snapshot of the actual document model. The previous
     * snapshot can now be persisted.
     * @param monitor
     *
     * @return
     */
    public Boolean createNewSnapshot(IProgressMonitor monitor) {
	if (!isActive) {
	    return false;
	}
	CommandStack cmdStk = targetConnection.getCommandStack();
	try {
	    cmdStk.openGroup("Document History: Create Snapshot");
	    monitor.worked(100);
	    // drop outdated (still transient) partitions
	    dropTransientPartitions(completedSession.transientPartitions);
	    monitor.worked(100);
	    completedSession = currentSession;
	    currentSession = new Session();

	    assert targetConnection.getNullPartition().getElements().size() == 0 : "Copy PreCond: Nullpartiton not empty.";
	    DeepCopyResultSet result = createNewModelSnapshot((RefObject) document.getRootObject(), document.getRootBlock());
	    monitor.worked(100);
	    // extract result information before moving them into a transient
	    // partition (MRI based lookup wouldn't work any longer)
	    currentSession.newDocumentRootObject = getNewRootObject(result, (RefObject) document.getRootObject());
	    currentSession.rootElements = getRootElements(result, targetConnection.getNullPartition());
	    currentSession.knownConstraintErrors = getOriginalConstraintErrors(currentSession.rootElements);
	    currentSession.transientPartitions = repartitionModelCopy(result, currentSession.snapshotIdentifier);
	    assert targetConnection.getNullPartition().getElements().size() == 0 : "Copy PostCond: Nullpartiton not empty.";

	    cmdStk.closeGroup();
	    assertSideEffectFreeness();
	    monitor.worked(100);
	    return true;
	} catch (Throwable e) {
	    handle_error(e);
	    return false;
	}
    }

    /**
     * Write the snapshot of the given version to disk. The copy will be renamed
     * and placed next to the original version.
     *
     * <b>Warning: </b> If the persisted result seems invalid or does not show
     * up (e.g. link from composite parent to this new copy is broken), then you
     * may have encountered a MOIN bug. Please delete
     * .metadata\.plugins\com.sap.tc.moin.facility.primary and then check again
     *
     * @param testCaseName, the prefix of the created partitions
     * @return the MRI of the copied document root. Will be null if persisting
     *         was not successful
     */
    public MRI persistSnapshot(String testCaseName, SnapshotVersion version) {
	if (!isActive) {
	    return null;
	}
	Session toBePersisted = getSessionOfVersion(version);
	if (!toBePersisted.isCompleted() || toBePersisted.isPersisted) {
	    throw new NoSuchSnapshotException("Your desired snapshot is not available.");
	}
	CommandStack cmdStk = targetConnection.getCommandStack();
	try {
	    cmdStk.openGroup("Document History: Persist Snapshot");
	    RefObject root = toBePersisted.newDocumentRootObject;
	    linkRootElementsToCompositeParent(toBePersisted.rootElements, toBePersisted.snapshotIdentifier);

	    assert targetConnection.getElement(root.get___Mri()) != null : "Unable to resolve copied (transient) root element";
	    Collection<ModelPartition> partitions = persistTransientPartitions(testCaseName, toBePersisted.transientPartitions);
	    assertConstraintsValid(partitions, toBePersisted.knownConstraintErrors);
	    assert targetConnection.getElement(root.get___Mri()) != null : "Unable to resolve copied (moved) root element";

	    targetConnection.getConsistencyViolationListenerRegistry().performConsistencyCheck(root.get___Partition().getPri());
	    for (ConsistencyViolation ic : targetConnection.getConsistencyViolationListenerRegistry()
		    .getAllConsistencyViolations()) {
		System.err.println("IC " + ic.getDescription(targetConnection));
	    }

	    announceNewPartitions(partitions);
	    cmdStk.closeGroup();

	    ModelManager.getConnectionManager().save(targetConnection);
	    assert targetConnection.getElement(root.get___Mri()) != null : "Unable to resolve copied (persisted) root element";

	    toBePersisted.isPersisted = true; // we moved the model, this can only be done once

	    return root.get___Mri();
	} catch (Throwable e) {
	    handle_error(e);
	    return null;
	}
    }

    /**
     * Returns true if this DocumentHistory is still actively creating snapshots
     * and no internal error has occurred, yet.
     */
    public Boolean isActive() {
	return isActive;
    }

    /**
     * Copy the document's rootObject including its composition and dependent
     * model elements, as well as all textblocks. The copy result is placed into
     * the null partition.
     *
     * @param rootObject
     * @param rootBlock
     * @return
     */
    private DeepCopyResultSet createNewModelSnapshot(RefObject _rootObject, RefObject _rootBlock) {
	MRI rootObjectMRI = _rootObject.get___Mri();
	MRI rootBlockMRI = _rootBlock.get___Mri();

	// Resolve via our own connection
	RefObject rootObject = (RefObject) targetConnection.getElement(rootObjectMRI);
	RefObject rootBlock = (RefObject) targetConnection.getElement(rootBlockMRI);
	assert rootObject != null : "Could not resolve document root object";

	ArrayList<RefObject> toBeCopied = new ArrayList<RefObject>(2);
	toBeCopied.add(rootObject);
	if (rootBlock != null) { // Could be null if it was not saved yet
	    toBeCopied.add(rootBlock);
	}

	disableEventListeners(targetConnection);

	// Copy composite of the rootObject
	IModelTransferTarget target = DeepCopyHelper.getTransferTarget(rootObject);
	DeepCopyResultSet resultSet = targetConnection.deepCopy(toBeCopied, target.getDeepCopyPolicyHandler(), target
		.includeExternalCompositeParents());

	enableEventListeners(targetConnection);

	// Report errors
	if (!resultSet.getCopyErrors().isEmpty()) {
	    System.err.println("Model copy finished with errors. See Error Log.");
	    // just disable; errors are already logged within deep copy
	    targetConnection.close();
	    isActive = false;
	}
	return resultSet;
    }

    /**
     * Repartition the copied model elements and move them from the null
     * partition to a transient partition structure resembling the source
     * structure.
     *
     * @param resultSet
     * @param snapshotIdentifier
     * @return the created transient partitions
     */
    private Map<String, ModelPartition> repartitionModelCopy(DeepCopyResultSet copyResultSet, String snapshotIdentifier) {
	HashMap<String, ModelPartition> result = new HashMap<String, ModelPartition>();

	for (RefObject target : copyResultSet.getCopiedElements()) {
	    MRI sourceMRI = copyResultSet.getInverseMriMappingTable().get(target.get___Mri());
	    RefObject source = (RefObject) targetConnection.getElement(sourceMRI);

	    String partitionIdentifier = source.get___Partition().getPri().hashCode() + snapshotIdentifier;
	    ModelPartition transientPartition = targetConnection.getOrCreateTransientPartition(partitionIdentifier);

	    target.assign___Partition(transientPartition);
	    result.put(partitionIdentifier, transientPartition);
	}
	return result;
    }

    private RefObject getNewRootObject(DeepCopyResultSet copyResultSet, RefObject oldRoot) {
	RefObject newRoot = copyResultSet.getMappingTable().get(oldRoot).getMappingTarget();
	return newRoot;
    }

    private Map<RefObject, RefObject> getRootElements(DeepCopyResultSet copyResultSet, ModelPartition partition) {
	Map<RefObject, RefObject> elements = new HashMap<RefObject, RefObject>();
	PartitionService service = ModelManager.getPartitionService();

	for (Partitionable rootCopy : service.getRootElements(partition)) {
	    MRI copyMRI = rootCopy.get___Mri();
	    MRI sourceMRI = copyResultSet.getInverseMriMappingTable().get(copyMRI);

	    RefObject rootSource = (RefObject) targetConnection.getElement(sourceMRI);
	    elements.put(rootSource, (RefObject) rootCopy);
	}
	return elements;
    }

    private void linkRootElementsToCompositeParent(Map<RefObject, RefObject> rootElements, String identifier) {
	for (Entry<RefObject, RefObject> entry : rootElements.entrySet()) {
	    RefObject source = entry.getKey();
	    RefObject copy = entry.getValue();

	    if (copy instanceof TextBlock) {
		continue;
	    }

	    IModelTransferTarget transfer = DeepCopyHelper.getTransferTarget(copy);
	    DeepCopyPolicyHandler handler = transfer.getDeepCopyPolicyHandler();
	    if (handler instanceof GenericModelCopyStrategy) {
		GenericModelCopyStrategy strategy = (GenericModelCopyStrategy) handler;
		Boolean shouldBeLinked = strategy.prepareLinkingToCompositeParent(identifier, source, copy);
		if (shouldBeLinked) {
		    DeepCopyHelper.linkToCompositeParent(targetConnection, source, copy);
		}
	    } else {
		RefObject parent = DeepCopyHelper.getCompositeParent(targetConnection, source);
		transfer.handleTransfer(parent, new RefObject[] { copy }, null);
	    }
	}
    }

    private void assertSideEffectFreeness() {
	PartitionService service = ModelManager.getPartitionService();
	Collection<ModelPartition> dirtyPartitions = service.getDirtyPartitions(targetConnection);
	Collection<ModelPartition> transientPartitions = targetConnection.getTransientPartitions();

	for (ModelPartition dirty : dirtyPartitions) {
	    if (!transientPartitions.contains(dirty)) {
		throw new AssertionFailedException("Non transient partiton dirty: " + dirty);
	    }
	}
	if (targetConnection.isDirty()) {
	    throw new AssertionFailedException("Dirty target connection");
	}
    }

    private void assertConstraintsValid(Collection<ModelPartition> partitions, Collection<JmiException> knownErrors) {
	for (ModelPartition partition : partitions) {
	    for (Partitionable element : partition.getElements()) {
		if (element instanceof RefObject) {
		    RefObject refObj = (RefObject) element;
		    Collection<JmiException> errors = refObj.refVerifyConstraints(false);
		    // This check is only fuzzy: It is very unlikely that we
		    // have the same amount of errors but with totally different reasons
		    if (errors != null && (errors.size() > knownErrors.size())) {
			for (JmiException err : errors) {
			    CtsActivator.logError(err, /* don't show popup */true);
			}
			throw new AssertionFailedException("Copy violates constraints. Errors have been logged.");
		    }
		}
	    }
	}
    }

    private Collection<JmiException> getOriginalConstraintErrors(Map<RefObject, RefObject> rootElements) {
	HashSet<JmiException> allErrors = new HashSet<JmiException>();
	for (RefObject original : rootElements.keySet()) {
	    Collection<JmiException> errors = original.refVerifyConstraints(true);
	    if (errors != null) {
		allErrors.addAll(errors);
	    }
	}
	return allErrors;
    }

    private void handle_error(Throwable cause) {
	Exception e = new RuntimeException("Disabling DocumentHistory Instance. See cause.", cause);
	CtsActivator.logError(e, /* don't show popup */true);
	System.err.println("Error in DocumentHistory, please consult error log!");
	isActive = false;
	if (targetConnection != null) {
	    targetConnection.close(); // undo all our (potential) changes
	}
    }

    /**
     * Materialize the given TransientPartitions.
     *
     * @return all newly created partitions
     */
    private Collection<ModelPartition> persistTransientPartitions(String testCaseName,
	    Map<String, ModelPartition> transientPartitions) {

	Collection<ModelPartition> result = new ArrayList<ModelPartition>();
	for (Entry<String, ModelPartition> entry : transientPartitions.entrySet()) {
	    ModelPartition transientPartition = entry.getValue();
	    String partitionIdentifier = entry.getKey();

	    PRI targetPRI = targetConnection.getSession().getMoin().createPri(getFacilityId(), getDataAreaName(),
		    getContainerName(), PRI_FOLDER + testCaseName + partitionIdentifier + PRI_ENDING);

	    ModelPartition targetPartition = targetConnection.createPartition(targetPRI);

	    result.add(targetPartition);
	    PartitionService.getInstance().moveElements(transientPartition, targetPartition);
	}
	return result;
    }

    private void dropTransientPartitions(Map<String, ModelPartition> partitions) {
	if (partitions == null) {
	    return;
	}
	for (ModelPartition partition : partitions.values()) {
	    assert targetConnection.getTransientPartitions().contains(partition);
	    partition.delete();
	}
    }

    /**
     * Create a new connection for the given project.
     *
     * @param project
     * @param connection
     * @return
     */
    private Connection createTargetConnection(final IProject project, final Connection editorCo) {
	final Connection[] con = new Connection[1];
	IRunnableWithProgress operation = new IRunnableWithProgress() {
	    public void run(IProgressMonitor monitor) {
		// non UI thread
		con[0] = ConnectionManager.getInstance().createConnection(project);
		con[0].setLabel("DocumentHistory target connection of " + editorCo.getLabel());
	    }
	};
	IProgressService ps = PlatformUI.getWorkbench().getProgressService();
	try {
	    ps.busyCursorWhile(operation);
	} catch (Throwable e) {
	    handle_error(e);
	}
	return con[0];
    }

    /**
     * Deactivate event listeners on the given connection for save,
     * uninterrupted copying
     *
     * @param co
     */
    private void disableEventListeners(Connection co) {
	BundleContext context = CtsActivator.getDefault().getBundle().getBundleContext();
	ServiceReference ref = context.getServiceReference(GlobalEventListenerRegistry.class.getName());
	GlobalEventListenerRegistry registry = (GlobalEventListenerRegistry) context.getService(ref);
	registry.deregisterFilters(co.getSession());
    }

    /**
     * Restore deactivated event listeners on the given connection
     *
     * @param co
     */
    private void enableEventListeners(Connection co) {
	BundleContext context = CtsActivator.getDefault().getBundle().getBundleContext();
	ServiceReference ref = context.getServiceReference(GlobalEventListenerRegistry.class.getName());
	GlobalEventListenerRegistry registry = (GlobalEventListenerRegistry) context.getService(ref);
	registry.registerFilters(co.getSession());
    }

    protected String getDataAreaName() {
	// e.g. "IDE";
	return document.getRootObject().get___Partition().getPri().getDataAreaDescriptor().getDataAreaName();
    }

    protected String getContainerName() {
	// e.g. "ngpm.stdlib";
	return document.getRootObject().get___Partition().getPri().getContainerName();
    }

    protected String getFacilityId() {
	// e.g. "PF";
	return document.getRootObject().get___Partition().getPri().getDataAreaDescriptor().getFacilityId();
    }

    @Override
    public void documentAboutToBeChanged(DocumentEvent event) {
	// do nothing, we use documentChanged
    }

    @Override
    public void documentChanged(DocumentEvent event) {
	currentSession.eventHistory.add(event);
    }

    @Override
    protected void finalize() {
	targetConnection.close();
    }

    /**
     * Propagates the new partitions to the versioning system
     */
    private void announceNewPartitions(Collection<ModelPartition> partitions) {
	if (partitions.size() > 0) {
	    // use a dummy command that returns the given partitions
	    Command cmd = new AnnounceNewPartitionsCommand(targetConnection, partitions);
	    cmd.execute();
	}
    }

    private static final class AnnounceNewPartitionsCommand extends Command {
	private final List<PartitionOperation> mPartitions;

	private AnnounceNewPartitionsCommand(Connection connection, Collection<ModelPartition> partitions) {
	    super(connection, "Persist Testcase Partition Announcment");
	    mPartitions = new ArrayList<PartitionOperation>(partitions.size());
	    for (ModelPartition partition : partitions) {
		mPartitions.add(new PartitionOperation(Operation.CREATE, partition.getPri()));
	    }
	}

	@Override
	public synchronized Collection<PartitionOperation> getAffectedPartitions() {
	    return mPartitions;
	}

	@Override
	public boolean canExecute() {
	    return true;
	}

	@Override
	public void doExecute() {
	}
    }

}
