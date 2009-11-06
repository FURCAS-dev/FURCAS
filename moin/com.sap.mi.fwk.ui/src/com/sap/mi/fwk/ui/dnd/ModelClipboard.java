package com.sap.mi.fwk.ui.dnd;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.part.ResourceTransfer;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ModelElementNameComparator;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.CommandManager;
import com.sap.mi.fwk.ui.ConnectionManagerUI;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.internal.MiFwkUIPlugin;
import com.sap.mi.fwk.ui.internal.dnd.PartitionHelper;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DeepCopyError;
import com.sap.tc.moin.repository.DeepCopyPolicyHandler;
import com.sap.tc.moin.repository.DeepCopyResultSet;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.DeepCopyError.DeepCopyErrorType;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.commands.PartitionOperation.Operation;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Provides a clipboard-like storage of Moin-related data. For a complete
 * user-driven copy and paste flow, use {@link CopyPasteActionGroup}.
 * <p>
 * Direct usage is as follows:
 * 
 * <pre>
 *   RefObject o1 = ...
 *   RefObject o2 = ...   
 *   ModelClipboard cb = ModelClipboard.getDefault();
 *   cb.setContent(new RefObject[] { o1, o2 });
 *   // retrieving content again
 *   RefObject[] objects = cb.getContentAsRefObjects(targetConnection);
 *   // actual copy and adding to target object
 *   if (cb.isTransferAllowed(targetObject, targetConnection)
 *   	cb.duplicateAndPaste(targetObject, targetConnection);
 * </pre>
 * 
 * @author d031150
 */
public final class ModelClipboard {

	private static final Logger sTracer = Logger.getLogger(MiLocations.MI_MODELHANDLING);
	private static final String EMPTY_TOSTRING_PLACEHOLDER = "<empty>"; //$NON-NLS-1$
	private static final RefBaseObject[] NO_REFBASE_OBJECTS = new RefBaseObject[0];
	private static final RefObject[] NO_REF_OBJECTS = new RefObject[0];
	// Attached to controls that are referenced by UI test
	private static final String WIDGET_DATA_NAME = "name"; //$NON-NLS-1$

	private static final ModelClipboard sDefault = new ModelClipboard(true);

	private final boolean mUseNative;
	private List<String> mMriStrings;
	// weak ref. to avoid leaks (due to static default clipboard)
	private WeakReference<Connection> mSourceConnection;

	private TransferLog mLog;
	private Class<? extends TransferLog> mLogClass;

	/**
	 * @return the default clipboard instance to represent a global clipboard to
	 *         the user. This instance is also connected to the
	 *         {@link Clipboard SWT clipboard}.
	 */
	public static ModelClipboard getDefault() {
		return sDefault;
	}

	/**
	 * Creates a new clipboard instance for internal tool usage. To put content
	 * in the global clipboard, use {@link #getDefault()}.
	 */
	public ModelClipboard() {
		mUseNative = false;
	}

	/**
	 * Sets the content of the clipboard and deletes all previous data. Note
	 * that only if called in the UI thread, the content is set in the native
	 * clipboard.
	 * 
	 * @param selection
	 *            a selection with the data to store
	 * 
	 * @see #setContent(RefBaseObject[])
	 */
	public void setContent(IStructuredSelection selection) {
		List<RefBaseObject> objects = toRefObjects(selection, RefBaseObject.class);
		setContent(objects.toArray(new RefBaseObject[objects.size()]));
	}

	/**
	 * Sets the content of the clipboard and deletes all previous data. Note
	 * that only if called in the UI thread, the content is set in the native
	 * clipboard.
	 * 
	 * @param objects
	 *            the data to store
	 * 
	 * @see #setContent(IStructuredSelection)
	 */
	public synchronized void setContent(RefBaseObject[] objects) {
		if (objects.length == 0) {
			return;
		}
		List<RefBaseObject> extendedObjects = extendObjects(Arrays.asList(objects));
		List<String> mriStrings = new ArrayList<String>(extendedObjects.size());
		for (RefBaseObject object : extendedObjects) {
			mriStrings.add(((Partitionable) object).get___Mri().toString());
		}

		RefBaseObject firstObject = extendedObjects.get(0);
		mSourceConnection = new WeakReference<Connection>(ModelAdapterUI.getInstance().getConnection(firstObject));

		if (canUseNative()) {
			// must run in UI thread
			setNativeContentObjects(extendedObjects);
		} else {
			mMriStrings = mriStrings;
		}
	}

	/**
	 * @return the clipboard content in form of plain {@link MRI}s
	 * 
	 * @see #getContentAsRefBaseObjects(Connection)
	 * @see #hasContent()
	 */
	public MRI[] getContent() {
		Moin moin = ModelManager.getInstance().getMoinInstance();
		String[] strings = getContentAsStrings();

		List<MRI> result = new ArrayList<MRI>(strings.length);
		for (String mriString : strings) {
			try {
				result.add(moin.createMri(mriString));
			} catch (InvalidResourceIdentifierException e) {
				MiFwkUIPlugin.logError(e, sTracer);
			}
		}
		return result.toArray(new MRI[result.size()]);
	}

	/**
	 * @return the clipboard content in form of plain {@link MRI} strings
	 * 
	 * @see #getContentAsRefBaseObjects(Connection)
	 * @see #hasContent()
	 */
	public synchronized String[] getContentAsStrings() {
		List<String> strings = Collections.emptyList();
		if (canUseNative()) {
			// must run in UI thread
			strings = getNativeContent();
		} else if (mMriStrings != null) {
			strings = mMriStrings;
		}
		return strings.toArray(new String[strings.size()]);
	}

	/**
	 * Returns the clipboard content in form of {@link RefObject}s. Depending on
	 * which connection is given the result may differ from a call to
	 * {@link #getContentAsStrings()}.
	 * 
	 * @param connectionHint
	 *            the connection to resolve the stored MRI information with if
	 *            this clipboard's information on the source context is not
	 *            valid anymore. May be <code>null</code>.
	 * @return the content as live objects
	 * 
	 * @see #getContentAsRefBaseObjects(Connection)
	 * @see #hasContent()
	 */
	public synchronized RefObject[] getContentAsRefObjects(Connection connectionHint) {
		final List<String> strings;
		if (canUseNative()) {
			strings = getNativeContent();
		} else {
			strings = mMriStrings;
		}
		if (strings == null || strings.isEmpty()) {
			return NO_REF_OBJECTS;
		}
		return new ConnectionRunnable<RefObject[]>(connectionHint, strings.get(0), NO_REF_OBJECTS) {
			@Override
			public RefObject[] run(Connection connection) {
				List<RefObject> result = getObjectsFromMri(strings, connection, RefObject.class);
				return result.toArray(new RefObject[result.size()]);

			}
		}.call();
	}

	/**
	 * Returns the clipboard content in form of {@link RefBaseObject}s.
	 * Depending on which connection is given the result may differ from a call
	 * to {@link #getContentAsStrings()}.
	 * 
	 * @param connectionHint
	 *            the connection to resolve the stored MRI information with if
	 *            this clipboard's information on the source context is not
	 *            valid anymore. May be <code>null</code>.
	 * @return the content as live objects
	 * 
	 * @see #getContentAsRefObjects(Connection)
	 * @see #hasContent()
	 */
	public synchronized RefBaseObject[] getContentAsRefBaseObjects(Connection connectionHint) {
		final List<String> strings;
		if (canUseNative()) {
			strings = getNativeContent();
		} else {
			strings = mMriStrings;
		}
		if (strings == null || strings.isEmpty()) {
			return NO_REFBASE_OBJECTS;
		}
		return new ConnectionRunnable<RefBaseObject[]>(connectionHint, strings.get(0), NO_REFBASE_OBJECTS) {
			@Override
			public RefBaseObject[] run(Connection connection) {
				List<RefBaseObject> result = getObjectsFromMri(strings, connection, RefBaseObject.class);
				return result.toArray(new RefBaseObject[result.size()]);

			}
		}.call();
	}

	/**
	 * Clears the clipboard. Note that a successful clearing of the SWT
	 * clipboard is not guaranteed since other applications may hold locks on
	 * it.
	 * 
	 * @see Clipboard#clearContents()
	 */
	public synchronized void clear() {
		copyStateReset();
		mSourceConnection = null;
		mMriStrings = null;

		if (canUseNative()) {
			doClearClipboard();
		} else if (mUseNative) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					doClearClipboard();
				}
			});
		}
		// else: do not try to clear the native clipboard for
		// internal ModelClipboards
	}

	/**
	 * Answers whether the clipboard's content can be transferred to the given
	 * target. Delegates to a {@link IModelTransferTarget} found on the target.
	 * Called typically by paste actions and drop validators to provide feedback
	 * to the user.
	 * 
	 * @param target
	 *            an object acting as target. Must not be <code>null</code>.
	 * @param targetConnection
	 *            the connection on the target. May be <code>null</code> if it
	 *            can be inferred from the given target object.
	 * @return <code>true</code> iff the transfer is allowed
	 * 
	 * @see IModelTransferTarget#isTransferAllowed(Object, RefBaseObject[])
	 */
	public boolean isTransferAllowed(Object target, Connection targetConnection) {
		// if no target connection is given, infer it from parent object
		if (targetConnection == null) {
			RefBaseObject parentAsRefObject = ModelAdapterUI.getInstance().getRefBaseObject(target);
			if (parentAsRefObject != null) {
				targetConnection = ModelAdapterUI.getInstance().getConnection(parentAsRefObject);
			}
		}
		// no RefObject, but maybe connection is availble if the target adapts
		// to it
		if (targetConnection == null) {
			targetConnection = ModelAdapterUI.getInstance().adaptObject(target, Connection.class);
		}
		// finally a target connection must exist
		if (targetConnection == null) {
			return false;
		}
		if (!targetConnection.isAlive()) {
			throw new IllegalStateException("No connection available, neither explicitly nor from new parent: " + target); //$NON-NLS-1$
		}
		// Any clipboard objects resolvable in the target (connection)?
		RefBaseObject[] content = getContentAsRefBaseObjects(targetConnection);
		if (content.length == 0) {
			return false;
		}

		IModelTransferTarget targetHandler = getTransferTarget(target, null);
		boolean allowed = targetHandler.isTransferAllowed(target, content);
		return allowed;
	}

	/**
	 * Duplicates the clipboard's content using Moin's
	 * {@link Connection#deepCopy(Collection, DeepCopyPolicyHandler, boolean)
	 * deep copy} service. Note that only elements from the content that are
	 * {@link RefObject}s are considered, pure {@link RefBaseObject}s like
	 * packages cannot be duplicated.
	 * 
	 * @param target
	 *            an object acting as composite parent for the copies.
	 *            <code>null</code> if the copied elements should be top-level
	 *            elements.
	 * @param targetConnection
	 *            the connection to write the copies into. May be
	 *            <code>null</code>
	 * 
	 * @return the copy result or <code>null</code> in case of an empty
	 *         clipboard
	 * 
	 * @see #duplicateAndPaste(Object, Connection, IModelTransferTarget)
	 * @see Connection#deepCopy(Collection, DeepCopyPolicyHandler, boolean)
	 */
	public DeepCopyResultSet duplicateAndPaste(Object target, Connection targetConnection) {
		DeepCopyResultSet result = duplicateAndPaste(target, targetConnection, null);
		return result;
	}

	/**
	 * Duplicates the clipboard's content using Moin's
	 * {@link Connection#deepCopy(Collection, DeepCopyPolicyHandler, boolean)
	 * deep copy} service. Note that only elements from the content that are
	 * {@link RefObject}s are considered, pure {@link RefBaseObject}s like
	 * packages cannot be duplicated.
	 * 
	 * @param target
	 *            an object acting as composite parent for the copies.
	 *            <code>null</code> if the copied elements should be top-level
	 *            elements.
	 * @param targetConnection
	 *            the connection to write the copies into. Must not be
	 *            <code>null</code> nor dead.
	 * @param customTarget
	 *            a target handler or <code>null</code>
	 * @return the copy result or <code>null</code> in case of an empty
	 *         clipboard
	 * 
	 * @see #duplicateAndPaste(Object, Connection)
	 * @see Connection#deepCopy(Collection, DeepCopyPolicyHandler, boolean)
	 */
	public DeepCopyResultSet duplicateAndPaste(Object target, Connection targetConnection, IModelTransferTarget customTarget) {
		copyStateReset();
		ModelAdapterUI modelAdapter = ModelAdapterUI.getInstance();

		// some checks and operation before copy
		RefBaseObject parent = modelAdapter.getRefBaseObject(target);
		// if parent is available as RefObject, it must be alive
		if (parent != null && !((Partitionable) parent).is___Alive()) {
			return null;
		}
		if (targetConnection == null && parent != null) {
			targetConnection = modelAdapter.getConnection(parent);
		}
		// no RefObject, but maybe connection is availble if the target adapts
		// to it
		if (targetConnection == null && target != null) {
			targetConnection = modelAdapter.adaptObject(target, Connection.class);
		}
		if (targetConnection != null && parent != null) {
			// detect connection mismatch to prevent
			// modification of wrong object
			if (targetConnection.isAlive() && !targetConnection.equals(modelAdapter.getConnection(parent))) {
				throw new IllegalStateException("Ambiguous connections: targetConnection: " + targetConnection //$NON-NLS-1$
						+ " <-> connection of target object: " + modelAdapter.getConnection(parent) //$NON-NLS-1$
						+ ". Not clear which one to use for copy."); //$NON-NLS-1$
			}
		}
		// if no target connection is given, infer it from parent object
		else if (targetConnection == null && parent != null) {
			targetConnection = modelAdapter.getConnection(parent);
		}
		// finally a target connection must exist
		if (targetConnection == null || !targetConnection.isAlive()) {
			throw new IllegalStateException("No connection available, neither explicitly nor from new parent: " + toObjectString(target)); //$NON-NLS-1$
		}

		customTarget = getTransferTarget(target, customTarget);

		RefObject[] srcObjects;
		try {
			// target connection is only a hint, source connection must
			// be used if available
			srcObjects = getContentAsRefObjects(targetConnection);
			if (srcObjects.length == 0) {
				return null; // no or no resolvable objects in clipboard
			}

			// at least partition of new parent needs to be writable
			IStatus status = unlockTargetPartition(targetConnection, parent);
			if (!status.isOK()) {
				mLog.add(status);
				return null;
			}
		} catch (OperationCanceledException e) { // $JL-EXC$
			return null;
		} catch (Exception e) { // $JL-EXC$
			mLog.add(e);
			return null;
		} finally {
			mLog.flush();
		}

		// subsequent operations run in a command group and are rolled back in
		// case of errros
		CommandStack commandStack = targetConnection.getCommandStack();
		try {
			commandStack.openGroup(MiFwkUiMessages.Clipboard_pasteCommand_label);

			DeepCopyPolicyHandler policy = customTarget.getDeepCopyPolicyHandler();
			boolean includeExternalCompositeParents = customTarget.includeExternalCompositeParents();

			IModelTransferPreparer preparer = ModelAdapterUI.getInstance().adaptObject(target, IModelTransferPreparer.class);
			if (preparer != null) {
				preparer.handlePreCopy(targetConnection, srcObjects);
			}
			
			// actual copy
			DeepCopyResultSet copyResult = deepCopy(targetConnection, policy, includeExternalCompositeParents, srcObjects);
			// handling of deep copy errors
			copyResult = handleCopyErrors(copyResult, srcObjects, targetConnection, policy, includeExternalCompositeParents);
			
			if (preparer != null) {
				preparer.handlePostCopy(targetConnection, srcObjects, copyResult);
			}
			
			if (copyResult.getCopiedElements().isEmpty()) {
				return copyResult;
			}

			// Process along the root elements only, avoid the effect of a child
			// element to appear before its parent could be handled.
			Map<RefObject, RefObject> targetRootElements = getTargetRootElements(targetConnection, copyResult, srcObjects);
			Set<RefObject> targetElements = targetRootElements.keySet();
			Collection<ModelPartition> newPartitions = new HashSet<ModelPartition>();

			RefBaseObject[] elements = targetElements.toArray(new RefBaseObject[targetElements.size()]);
			Collection<ModelPartition> partitions = customTarget.handleTransfer(target, elements, mLog);
			if (partitions != null) {
				newPartitions.addAll(partitions);
			}

			// assign them to partitions, eventually creating new partitions
			newPartitions.addAll(doPartitionAssignment(parent, targetRootElements).values());
			// add new partitions to versioning
			announceNewPartitions(newPartitions, targetConnection);

			// commit
			commandStack.closeGroup();
			return copyResult;
		} catch (OperationCanceledException e) { // $JL-EXC$
			// user cancelled
			rollback(targetConnection);
			return null;
		} catch (ExecutionCancelledException e) { // $JL-EXC$
			// user cancelled
			rollback(targetConnection);
			return null;
		} catch (UnrecoverableExecutionException e) {
			mLog.add(e);
			// not able to rollback
			return null;
		} catch (Exception e) { // $JL-EXC$
			// unspecific error
			mLog.add(e);
			rollback(targetConnection);
			return null;
		} finally {
			// save in case of non-editor paste

			if (canUseUI()) {
				ConnectionManagerUI.getInstance().saveIfNecessary(targetConnection, null);
			} else {
				try {
					ConnectionManager.getInstance().save(targetConnection);
				} catch (Exception e) {// $JL-EXC$
					sTracer.log(Level.SEVERE, "Exception while saving connection: " + e); //$NON-NLS-1$
				}
			}

			// present collected errors to user
			mLog.flush();
		}
	}

	private static IModelTransferTarget getTransferTarget(Object newParent, IModelTransferTarget target) {
		if (target == null && newParent != null) {
			target = ModelAdapterUI.getInstance().adaptObject(newParent, IModelTransferTarget.class);
		}
		if (target == null) {
			target = new DefaultModelTransferTarget();
		}
		return target;
	}

	private DeepCopyResultSet deepCopy(final Connection targetConnection, final DeepCopyPolicyHandler copyPolicy,
			final boolean includeExternalCompositeParents, final RefObject[] srcObjects) {
		if (targetConnection == null || !targetConnection.isAlive()) {
			throw new IllegalArgumentException("Connection must be alive: " + targetConnection); //$NON-NLS-1$
		}

		if (canUseUI()) {
			final DeepCopyResultSet[] result = new DeepCopyResultSet[1];
			BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
				public void run() {
					result[0] = targetConnection.deepCopy(Arrays.asList(srcObjects), copyPolicy, includeExternalCompositeParents);
				}
			});
			return result[0];
		}
		return targetConnection.deepCopy(Arrays.asList(srcObjects), copyPolicy, includeExternalCompositeParents);
	}

	/**
	 * Processes the errors of the current result. If the errors indicate a
	 * partition lock problem, the partitions are tried to unlock (editor save,
	 * versioning), and the copy step is performed once again. If this fails as
	 * well, the errors are logged.
	 * 
	 * @param policy
	 * @param includeExternalCompositeParents
	 */
	private DeepCopyResultSet handleCopyErrors(DeepCopyResultSet result, RefObject[] srcObjects, Connection targetConnection,
			DeepCopyPolicyHandler policy, boolean includeExternalCompositeParents) throws OperationCanceledException {
		Collection<DeepCopyError> errors = result.getCopyErrors();
		if (errors.size() > 0) {
			Collection<PartitionOperation> lockedPartitions = addToPasteLog(errors, true);
			if (lockedPartitions.size() > 0) {
				rollback(targetConnection);
				return handleLockProblems(lockedPartitions, srcObjects, targetConnection, policy, includeExternalCompositeParents);
			}
		}
		return result;
	}

	/**
	 * Tries to unlock the given partitions, incl. editor save and versioning.
	 * Performs the copy again.
	 * 
	 * @param policy
	 * @param includeExternalCompositeParents
	 * 
	 * @return the new copy result
	 */
	private DeepCopyResultSet handleLockProblems(Collection<PartitionOperation> lockedPartitions, final RefObject[] srcObjects,
			Connection targetConnection, DeepCopyPolicyHandler policy, boolean includeExternalCompositeParents)
			throws OperationCanceledException {
		IStatus status = CommandManager.getInstance().prepareExecution(targetConnection, lockedPartitions);
		if (!status.isOK()) {
			if (IStatus.CANCEL == status.getSeverity()) {
				throw new OperationCanceledException();
			}
			mLog.add(status);
			return null;
		}
		DeepCopyResultSet result = deepCopy(targetConnection, policy, includeExternalCompositeParents, srcObjects);
		Collection<DeepCopyError> errors = result.getCopyErrors();
		if (errors.size() > 0) {
			addToPasteLog(errors, false);
		}
		return result;
	}

	/**
	 * Adds the given elements to <code>newParent</code> as composite children
	 * 
	 * @param parent
	 *            parent to add the objects to. Must not be <code>null</code>.
	 * @param objects
	 *            the objects to add
	 * @param association
	 *            an explict association or <code>null</code>
	 * @param log
	 *            to collect status information. Any errors will be presented to
	 *            the user at the end of the operation.
	 * @throws OperationCanceledException
	 *             if the user aborted the operation
	 */
	public static void addToCompositeParent(RefObject parent, RefBaseObject[] objects, Association association, IModelTransferLog log)
			throws OperationCanceledException {
		if (parent == null) {
			throw new IllegalStateException("Parent must not be null"); //$NON-NLS-1$
		}

		if (association != null) {
			association = ModelAdapterUI.getInstance().resolveInConnection(association, parent);
		}

		for (RefBaseObject object : objects) {
			if (!(object instanceof RefObject)) {
				if (sTracer.isLoggable(Level.FINE)) {
					sTracer.fine("Ignoring " + toObjectString(object) //$NON-NLS-1$
							+ " for parent assignment. Is not a RefObject."); //$NON-NLS-1$
				}
				continue;
			}
			RefFeatured objectParent = ((RefObject) object).refImmediateComposite();
			if (objectParent != null) {
				if (sTracer.isLoggable(Level.FINE)) {
					String msg = "Ignoring " + toObjectString(object) //$NON-NLS-1$
							+ " for parent assignment. Already assigned to " + toObjectString(objectParent); //$NON-NLS-1$
					sTracer.fine(msg);
				}
				continue;
			}

			// Find the composition relationships to use between
			// parent and child
			List<Association> assocs = findUsableTargetAssociations(parent, (MofClass) ((RefObject) object).refMetaObject());
			Association assoc;
			switch (assocs.size()) {
				case 0:
					String msg = "No composite associations found for " //$NON-NLS-1$
							+ toObjectString(parent.refMetaObject()) + " -> " //$NON-NLS-1$
							+ toObjectString(object.refMetaObject());
					// CSN I-603447 2008: Don't issue an error here. The client
					// might already have composed the objects.
					sTracer.fine(msg);
					continue;
				case 1:
					assoc = assocs.get(0);
					break;
				default: // multiple associations
					if (association != null) {
						if (!assocs.contains(association)) {
							throw new IllegalStateException("Given association " + association.getName() //$NON-NLS-1$
									+ " not valid among " + toAssociationNames(assocs)); //$NON-NLS-1$
						}
						assoc = association;
						break;
					} else {
						if (!canUseUI()) {
							throw new IllegalStateException("Multiple associations available " //$NON-NLS-1$
									+ toAssociationNames(assocs) + ", " //$NON-NLS-1$
									+ "but not able to raise a UI since not running in UI thread " //$NON-NLS-1$
									+ "(current thread: " + Thread.currentThread().getName() + "). " //$NON-NLS-1$ //$NON-NLS-2$
									+ "Fork to UI thread or specify an explicit association."); //$NON-NLS-1$
						}
						assoc = selectTargetAssociation(assocs);
						if (assoc == null) {
							throw new OperationCanceledException();
						}
					}
			}

			// Use the obtained association to compose the child into the parent
			compose(parent, (RefObject) object, assoc);
		}
	}

	private static List<String> toAssociationNames(List<Association> assocs) {
		List<String> names = new ArrayList<String>(assocs.size());
		for (Association assoc : assocs) {
			names.add(assoc.getName());
		}
		return names;
	}

	private static String toObjectString(Object o) {
		if (o instanceof Collection) {
			return toObjectsString((Collection<?>) o);
		}
		return toObjectsString(Collections.singleton(o));
	}

	private static String toObjectsString(Collection<?> objects) {
		StringBuilder b = new StringBuilder();
		for (Object o : objects) {
			if (o instanceof RefBaseObject) {
				RefBaseObject object = (RefBaseObject) o;
				String name = ModelManager.getInstance().getObjectName(object);
				String type = ((ModelElement) object.refMetaObject()).getName();
				b.append(type).append(" '").append(name).append("'"); //$NON-NLS-1$ //$NON-NLS-2$
			} else {
				b.append(o);
			}
		}
		return b.toString();
	}

	/**
	 * Raises a UI to select a association among the given ones. The result is
	 * used to add the copied elements to the new parent.
	 */
	private static Association selectTargetAssociation(List<Association> assocs) {
		final JmiHelper jmiHelper = ModelAdapterUI.getInstance().getJmiHelper(assocs.get(0));
		ILabelProvider labelProv = new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof Association) {
					Association assoc = (Association) element;
					AssociationEnd ae = jmiHelper.getCompositeAssociationEnd(assoc);
					return ae.otherEnd().getName();
				}
				return super.getText(element);
			}
		};
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				labelProv) {
			@Override
			protected void configureShell(Shell shell) {
				super.configureShell(shell);
				shell.setData(WIDGET_DATA_NAME, "AssociationInputDialog"); //$NON-NLS-1$
			}
		};
		Association[] elements = assocs.toArray(new Association[assocs.size()]);
		Arrays.sort(elements, ModelElementNameComparator.INSTANCE_IGNORING_CASE);
		dialog.setElements(elements);
		dialog.setInitialSelections(new Association[] { elements[0] });
		dialog.setMessage(MiFwkUiMessages.Clipboard_selectAssocDialog_msg);
		dialog.setTitle(MiFwkUiMessages.Clipboard_selectAssocDialog_title);
		if (dialog.open() != Window.OK) {
			return null;
		}
		return (Association) dialog.getFirstResult();
	}

	/**
	 * Adds the given child to the given parent in the given assoication
	 */
	private static void compose(RefObject parent, RefObject child, Association assoc) {
		JmiHelper jmiHelper = ModelAdapterUI.getInstance().getJmiHelper(parent);
		AssociationEnd ae = jmiHelper.getCompositeAssociationEnd(assoc);
		// Note that the composition is done using the connection of actualAssoc
		// (myConn)
		RefAssociation actualAssoc = jmiHelper.getRefAssociationForAssociation(assoc);
		if (jmiHelper.isFirstAssociationEnd(assoc, ae)) {
			actualAssoc.refAddLink(parent, child);
		} else {
			actualAssoc.refAddLink(child, parent);
		}
	}

	/**
	 * This methods needs to make some assumptions on the used DeepCopyPolicyHandler.
	 * By default those CopyHandlers do not walk up composite parent associations
	 * but only copy composite children.
	 * 
	 * But if an external composite parent is copied too, it seems desirable to
	 * automatically assign this parent to a partition. It should therefore
	 * be included in the result set of this method.
	 * @param targetConnection 
	 * 
	 * @return all copied elements from <code>result</code> that originate from
	 *         root elements in the source
	 */
	private Map<RefObject, RefObject> getTargetRootElements(Connection targetConnection, DeepCopyResultSet result, RefObject[] srcElements) {
		Map<MRI, MRI> inverseMRITable = result.getInverseMriMappingTable();
		
		// DeepCopy places elements in the Null-Partition
		PartitionService service = PartitionService.getInstance();
		Collection<Partitionable> unfilteredRootElements = service.getRootElements(targetConnection.getNullPartition());
		
		HashSet<RefObject> copiedElements = new HashSet<RefObject>(result.getCopiedElements());
		
		// Filter  elements (null partition might not have been empty before...)
		Map<RefObject, RefObject> elements = new HashMap<RefObject, RefObject>(srcElements.length);
		for (Partitionable copiedElement : unfilteredRootElements) {
		    if (!copiedElements.contains(copiedElement)) {
			continue;
		    }
		    MRI copyMRI = copiedElement.get___Mri();
		    MRI sourceMRI = inverseMRITable.get(copyMRI);
		    if (sourceMRI == null) {
			mLog.add("No source MRI found for copy " + toObjectString(copiedElement), IStatus.ERROR); //$NON-NLS-1$
			continue;
		    }
		
		    RefObject srcElement = (RefObject) targetConnection.getElement(sourceMRI);
		    if (srcElement == null) {
			mLog.add("No source element found for copy " + toObjectString(copiedElement), IStatus.ERROR); //$NON-NLS-1$
			continue;
		    }
		    elements.put((RefObject) copiedElement, srcElement);
		}
		return elements;
	}

	/**
	 * Performs a partition assignment of the given copied elements
	 */
	private Map<PRI, ModelPartition> doPartitionAssignment(RefBaseObject newParent, Map<RefObject, RefObject> targetRootElements)
			throws OperationCanceledException {
		ModelPartition partNewParent = null;
		if (newParent != null) {
			partNewParent = newParent.get___Partition();
			// don't accept metamodel partitions
			if (partNewParent.getPri().isMetaModelPartition()) {
				partNewParent = null;
			}
		}

		Map<PRI, ModelPartition> sourceToNewTargetPartitions = new HashMap<PRI, ModelPartition>();
		Set<Entry<RefObject, RefObject>> entries = targetRootElements.entrySet();
		for (Entry<RefObject, RefObject> entry : entries) {
			RefObject targetElement = entry.getKey();
			RefObject srcElement = entry.getValue();

			final ModelPartition targetPart = ((Partitionable) targetElement).get___Partition();
			final PRI targetPri = targetPart.getPri();
			if (!targetPri.isVolatilePartition()) {
				if (sTracer.isLoggable(Level.FINE)) {
					sTracer.fine("No assignment needed for element " + toObjectString(targetElement) //$NON-NLS-1$
							+ ".  Assigned to " + targetPri); //$NON-NLS-1$
				}
				continue;
			}

			// use new parent's partition, no matter whether it's a null or
			// transient partition
			if (partNewParent != null) {
				partNewParent.assignElementIncludingChildren(targetElement);
				if (sTracer.isLoggable(Level.FINE)) {
					sTracer.fine("No assignment needed for element " + toObjectString(targetElement) //$NON-NLS-1$
							+ ".  Assigned to " + targetPri); //$NON-NLS-1$
				}
				continue;
			}

			final ModelPartition srcPart = ((Partitionable) srcElement).get___Partition();
			final PRI srcPri = srcPart.getPri();
			if (srcPri.isVolatilePartition()) {
				mLog.add("No assigment possible for " + toObjectString(targetElement) //$NON-NLS-1$
						+ ". Source element is in volatile partition: " + toObjectString(srcElement), //$NON-NLS-1$
						IStatus.ERROR);
				continue;
			}

			ModelPartition targetPartNew = sourceToNewTargetPartitions.get(srcPri);
			if (targetPartNew == null) {
				Shell shell = null;
				if (canUseUI()) {
					shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				}
				targetPartNew = PartitionHelper.findOrCreatePartitionFor(targetElement, srcElement, shell);
				if (targetPartNew == null) { // user cancelled
					if (sTracer.isLoggable(Level.FINE)) {
						sTracer.fine("No assignment requested for element " + toObjectString(targetElement)); //$NON-NLS-1$
					}
					throw new OperationCanceledException();
				} else if (!targetPartNew.getPri().equals(targetPri)) {
					sourceToNewTargetPartitions.put(srcPri, targetPartNew);
				}
			}

			targetPartNew.assignElementIncludingChildren(targetElement);
			if (sTracer.isLoggable(Level.FINE)) {
				sTracer.fine("Created partition " + targetPartNew.getPri() + " for element " //$NON-NLS-1$ //$NON-NLS-2$
						+ toObjectString(targetElement));
			}
		}
		return sourceToNewTargetPartitions;
	}

	/**
	 * Propagates the new partitions to the versioning system
	 */
	private void announceNewPartitions(Collection<ModelPartition> partitions, Connection targetConnection) {
		if (partitions.size() > 0) {
			// use a dummy command that returns the given partitions
			Command cmd = new AnnounceNewPartitionsCommand(targetConnection, partitions);
			cmd.execute();
		}
	}

	/**
	 * Tries to unlock the partition of <code>newParent</code>, which needs to
	 * be writable in almost any case (due to composition assignments).
	 */
	private IStatus unlockTargetPartition(Connection targetConnection, RefBaseObject newParent) {
		if (newParent != null) {
			PRI parentPri = ((Partitionable) newParent).get___Partition().getPri();
			if (!parentPri.isVolatilePartition()) {
				Collection<PartitionOperation> affectedPartitions = Collections
						.singleton(new PartitionOperation(Operation.EDIT, parentPri));
				IStatus status = CommandManager.getInstance().prepareExecution(targetConnection, affectedPartitions);
				return status;
			}
		}
		return Status.OK_STATUS;
	}

	/**
	 * Finds all composite associations for the given <code>parent</code> object
	 * that reference a child of type <code>childMofClass</code>. Associations
	 * that have a upper cardinality of '1' are not contained in the returned
	 * <code>List</code>.
	 * 
	 * @param parent
	 *            the composite parent element.
	 * @param childClass
	 *            the <code>MofClass</code> defining the type of the composite
	 *            children.
	 * @return the list containing all composite associations that fulfill the
	 *         selection criteria described above.
	 */
	static List<Association> findUsableTargetAssociations(RefObject parent, MofClass childClass) {
		JmiHelper jmiHelper = ModelAdapterUI.getInstance().getJmiHelper(parent);
		List<Association> compositeAssociations = new ArrayList<Association>(jmiHelper.getCompositeAssociations((MofClass) parent
				.refMetaObject(), childClass));
		for (Iterator<Association> iterator = compositeAssociations.iterator(); iterator.hasNext();) {
			Association compositeAssociation = iterator.next();
			AssociationEnd compositeEnd = jmiHelper.getCompositeAssociationEnd(compositeAssociation);

			if (compositeEnd == null) {
				IllegalStateException e = new IllegalStateException(
						"The composite association <" + compositeAssociation.getName() + "> has to have one composite association end"); //$NON-NLS-1$ //$NON-NLS-2$
				MiFwkUIPlugin.logError(e, sTracer);
				throw e;
			}
			MultiplicityType multiplicity = compositeEnd.otherEnd().getMultiplicity();
			boolean isSingle = (multiplicity != null ? multiplicity.getUpper() == 1 : false);
			if (isSingle) {
				RefAssociation refassoc = jmiHelper.getRefAssociationForAssociation(compositeAssociation);
				if (refassoc != null) {
					Collection<RefObject> children = refassoc.refQuery(compositeEnd, parent);
					if (children.size() > 0) {
						iterator.remove();
					}
				}
			}
		}
		return compositeAssociations;
	}

	/**
	 * Out of a selection element computes a target connection and an optional
	 * object as new parent
	 */
	static void determineConnectionAndNewParent(Object element, Connection[] connection, RefBaseObject[] newParent,
			IWorkbenchPart targetPart) {
		newParent[0] = ModelAdapterUI.getInstance().getRefObject(element);
		if (newParent[0] != null && connection[0] == null) {
			connection[0] = ((Partitionable) newParent[0]).get___Connection();
		}

		if (newParent[0] == null && targetPart instanceof CommonNavigator) {
			// try to climb up a tree hierarchy and find a parent
			CommonViewer cv = ((CommonNavigator) targetPart).getCommonViewer();
			if (cv != null) {
				IContentProvider cp = cv.getContentProvider();
				if (cp instanceof ITreeContentProvider) {
					ITreeContentProvider tcp = (ITreeContentProvider) cp;
					Object parent = tcp.getParent(element);
					if (parent != null) {
						determineConnectionAndNewParent(parent, connection, newParent, targetPart);
					}
				}
			}
		}

		// try with targetPart's input as element
		if (newParent[0] == null && targetPart instanceof IEditorPart) {
			determineConnectionAndNewParent(((IEditorPart) targetPart).getEditorInput(), connection, newParent, targetPart);
		}
	}

	static boolean isTransferAllowed(RefObject target, List<? extends RefBaseObject> objects) {
		IModelTransferTarget targetHandler = getTransferTarget(target, null);
		boolean allowed = targetHandler.isTransferAllowed(target, objects.toArray(new RefBaseObject[objects.size()]));
		return allowed;
	}

	/**
	 * Answers whether at least one of the given objects can be aggregated below
	 * the given parent as composite children. This generic implementation
	 * considers type compatibility and cardinalities but no additional domain
	 * specific constraints.
	 * 
	 * @param parent
	 *            the composite parent
	 * @param objects
	 *            the objects to check
	 * @return <code>true</code> if at least one object may be a composite child
	 *         of <code>parent</code>
	 */
	public static boolean isCompositionAllowed(RefObject parent, RefBaseObject[] objects) {
		for (RefBaseObject object : objects) {
			if (object instanceof RefObject) {
				// optimistic approach: if one association can aggregate one
				// element, we are ok
				List<Association> assocs = findUsableTargetAssociations(parent, (MofClass) ((RefObject) object).refMetaObject());
				if (assocs.size() > 0) {
					return true;
				}
			}
		}
		return false;
	}

	static <T extends RefBaseObject> List<T> toRefObjects(IStructuredSelection selection, Class<T> type) {
		if (selection == null || selection.isEmpty()) {
			return Collections.emptyList();
		}
		Object[] elements = selection.toArray();
		List<T> objects = new ArrayList<T>(elements.length);
		for (Object element : elements) {
			T o = ModelAdapterUI.getInstance().adaptObject(element, type);
			if (o != null && ((Partitionable) o).is___Alive()) {
				objects.add(o);
			}
		}
		return objects;
	}

	/**
	 * Saves the connection if there is no editor open to carry the dirty state
	 */
	// private void saveIfNecessary(Connection connection) {
	// Collection<IModelEditor> editors =
	// ModelEditorManager.getInstance().getAllActiveModelEditors(Collections.singleton(connection));
	// if (editors.isEmpty()) {
	// if (canUseUI()) {
	// ConnectionManagerUI.getInstance().save(connection,
	// ModelAdapterUI.getInstance().getProject(connection), null);
	// } else {
	// try {
	// ConnectionManager.getInstance().save(connection);
	// } catch (Exception e) {
	// // $JL-EXC$
	// mLog.add(e);
	// }
	// }
	// }
	// }
	/**
	 * Reverts the active command group
	 */
	private void rollback(Connection targetConnection) {
		CommandStack commandStack = targetConnection.getCommandStack();
		if (commandStack.isGroupOpen()) {
			commandStack.cancelGroup();
		}
	}

	/**
	 * Resets the action's state
	 */
	private synchronized void copyStateReset() {
		// use the special log implementation if requested
		if (mLogClass != null) {
			try {
				mLog = mLogClass.newInstance();
			} catch (Exception e) { // $JL-EXC$
				// fail as this is only used in test code
				throw new RuntimeException(e);
			}
		} else {
			// normal mode
			mLog = new TransferLog();
		}
	}

	/**
	 * Adds the given copy errors to the paste log
	 * 
	 * @param returnLockProblems
	 *            if <code>true</code>, partition problems are not logged but
	 *            returned as {@link PartitionOperation}
	 */
	private Collection<PartitionOperation> addToPasteLog(Collection<DeepCopyError> errors, boolean returnLockProblems) {
		Collection<PartitionOperation> lockedPartitions = null;
		if (returnLockProblems) {
			lockedPartitions = new HashSet<PartitionOperation>();
		}
		for (DeepCopyError error : errors) {
			DeepCopyErrorType errorType = error.getErrorType();
			switch (errorType) {
				case ERR_007: // wrong cardinalities in links
					mLog.add(error.toString(), IStatus.WARNING);
					break;
				case ERR_008: // locked partition
					PRI pri = error.getPriOfElementInError();
					if (returnLockProblems) {
						lockedPartitions.add(new PartitionOperation(Operation.EDIT, pri));
					} else {
						mLog.add(MiFwkUIPlugin.createStatus(IStatus.ERROR, error.toString(), null));
					}
					break;
				default:
					mLog.add(MiFwkUIPlugin.createStatus(IStatus.ERROR, error.toString(), null));
					break;
			}
		}
		return lockedPartitions;
	}

	/**
	 * @return <code>true</code> iff the clipboard contains any content
	 */
	public boolean hasContent() {
		return getContent().length > 0;
	}

	private synchronized List<String> getContentAsStringList() {
		List<String> strings = Collections.emptyList();
		if (canUseNative()) {
			// must run in UI thread
			strings = getNativeContent();
		} else if (mMriStrings != null) {
			strings = mMriStrings;
		}
		return strings;
	}

	private void doClearClipboard() {
		// must run in UI thread
		Clipboard cb = new Clipboard(Display.getCurrent());
		try {
			cb.clearContents();
		} finally {
			cb.dispose();
		}
	}

	void setContent(MriTransferData data) {
		List<String> mriStrings = data.getMriStrings();
		setContent(mriStrings.toArray(new String[mriStrings.size()]), null);
	}

	/**
	 * Sets the content of the clipboard and deletes all previous data. Note
	 * that only if called in the UI thread, the content is set in the native
	 * clipboard.
	 * 
	 * @param content
	 *            the data to store
	 * 
	 * @see #setContent(RefBaseObject[])
	 */
	private synchronized void setContent(String[] mriStrings, Connection connectionHint) {
		if (mriStrings.length == 0) {
			return;
		}

		if (connectionHint != null) {
			mSourceConnection = new WeakReference<Connection>(connectionHint);
		}

		if (canUseNative()) {
			// must run in UI thread
			setNativeContent(Arrays.asList(mriStrings));
		} else {
			mMriStrings = Arrays.asList(mriStrings);
		}
	}

	/**
	 * Sets the content of the SWT clipboard with the given objects
	 */
	private void setNativeContentObjects(List<RefBaseObject> objects) {
		Map<Transfer, Object> nativeFormat = toTransferObjects(objects);
		int size = nativeFormat.size();
		if (size > 0) {
			Object[] data = nativeFormat.values().toArray(new Object[size]);
			Transfer[] dataTypes = nativeFormat.keySet().toArray(new Transfer[size]);

			Clipboard cb = new Clipboard(Display.getCurrent());
			try {
				cb.setContents(data, dataTypes);
			} finally {
				cb.dispose();
			}
		}
	}

	/**
	 * Sets the content of the SWT clipboard with the given strings
	 */
	private void setNativeContent(List<String> mriStrings) {
		Map<Transfer, Object> nativeFormat = toTransfer(mriStrings);
		int size = nativeFormat.size();
		if (size > 0) {
			Object[] data = nativeFormat.values().toArray(new Object[size]);
			Transfer[] dataTypes = nativeFormat.keySet().toArray(new Transfer[size]);

			Clipboard cb = new Clipboard(Display.getCurrent());
			try {
				cb.setContents(data, dataTypes);
			} finally {
				cb.dispose();
			}
		}
	}

	static Transfer[] getAllTransfers() {
		Transfer[] transfers = new Transfer[] { FileTransfer.getInstance(), LocalSelectionTransfer.getTransfer(),
				MriTransfer.getInstance(), ResourceTransfer.getInstance(), TextTransfer.getInstance() };
		return transfers;
	}

	static Transfer[] getTargetTransfers() {
		Transfer[] transfers = new Transfer[] { LocalSelectionTransfer.getTransfer(), MriTransfer.getInstance() };
		return transfers;
	}

	Object getData(Transfer transfer) {
		Map<Transfer, Object> transfers = toTransfer();
		return transfers.get(transfer);
	}

	/**
	 * @returns currently the {@link MRI} content as {@link MriTransfer},
	 *          {@link TextTransfer}, {@link FileTransfer}, and Eclipse
	 *          {@link ResourceTransfer}.
	 */
	private synchronized Map<Transfer, Object> toTransferObjects(List<RefBaseObject> objects) {
		final Map<Transfer, Object> empty = Collections.emptyMap();
		int size = objects.size();
		if (size == 0) {
			return empty;
		}

		List<String> mriStrings = new ArrayList<String>(size);
		List<IResource> files = new ArrayList<IResource>(size);
		List<String> filePaths = new ArrayList<String>(size);
		for (int i = 0; i < size; i++) {
			RefBaseObject o = objects.get(i);
			mriStrings.add(((Partitionable) o).get___Mri().toString());
			IFile file = ModelAdapterUI.getInstance().getFile(o);
			if (file != null && file.exists() && !files.contains(file)) {
				files.add(file);
				filePaths.add(file.getLocation().toOSString());
			}
		}
		Map<Transfer, Object> result = new HashMap<Transfer, Object>(7);
		MriTransferData data = new MriTransferData(mriStrings);
		result.put(LocalSelectionTransfer.getTransfer(), new StructuredSelection(objects));
		result.put(MriTransfer.getInstance(), data);
		result.put(FileTransfer.getInstance(), filePaths.toArray(new String[filePaths.size()]));
		result.put(ResourceTransfer.getInstance(), files.toArray(new IResource[files.size()]));
		result.put(TextTransfer.getInstance(), toExtendedString(objects));
		return result;
	}

	Map<Transfer, Object> toTransfer() {
		List<String> mriStrings = getContentAsStringList();
		return toTransfer(mriStrings);
	}

	private Map<Transfer, Object> toTransfer(final List<String> mriStrings) {
		final Map<Transfer, Object> empty = Collections.emptyMap();
		if (mriStrings.isEmpty()) {
			return empty;
		}
		return new ConnectionRunnable<Map<Transfer, Object>>(null, mriStrings.get(0), empty) {
			@Override
			public Map<Transfer, Object> run(Connection connection) {
				List<RefBaseObject> objects = getObjectsFromMri(mriStrings, connection, RefBaseObject.class);
				return toTransferObjects(objects);
			}
		}.call();
	}

	private static List<String> getNativeContent() {
		Clipboard cb = new Clipboard(Display.getCurrent());
		try {
			MriTransferData contents = (MriTransferData) cb.getContents(MriTransfer.getInstance());
			if (contents != null) {
				return contents.getMriStrings();
			}
			return Collections.emptyList();
		} finally {
			cb.dispose();
		}
	}

	@SuppressWarnings("unchecked")
	private static <T extends RefBaseObject> List<T> getObjectsFromMri(List<String> mriStrings, Connection connection, Class<T> type) {
		Moin moin = ModelManager.getInstance().getMoinInstance();
		List<T> result = new ArrayList<T>(mriStrings.size());
		for (String mriString : mriStrings) {
			try {
				RefBaseObject element = connection.getElement(moin.createMri(mriString));
				if (element != null && type.isInstance(element)) {
					result.add((T) element);
				}
			} catch (InvalidResourceIdentifierException e) {
				MiFwkUIPlugin.logError(e, sTracer);
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	private static List<RefBaseObject> extendObjects(List<RefBaseObject> originalObjects) {
		RefBaseObject[] original = originalObjects.toArray(new RefBaseObject[originalObjects.size()]);
		Set<RefBaseObject> result = new LinkedHashSet<RefBaseObject>(originalObjects.size());

		for (RefBaseObject o : originalObjects) {
			result.add(o);
			IModelTransferExtender<RefBaseObject> extender = ModelAdapterUI.getInstance().adaptObject(o, IModelTransferExtender.class);
			if (extender == null) {
				continue;
			}
			try {
				RefBaseObject[] additional = extender.getAdditionalObjects(o, original);
				if (additional != null && additional.length > 0) {
					result.addAll(Arrays.asList(additional));
				}
			} catch (Exception e) { // $JL-EXC$
				MiFwkUIPlugin.logError("Error in " + extender + " when called with " + toObjectsString(originalObjects), e, sTracer); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

		return new ArrayList<RefBaseObject>(result);
	}

	private String toExtendedString(List<RefBaseObject> objects) {
		ModelManager modelMgr = ModelManager.getInstance();
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < objects.size(); i++) {
			RefBaseObject o = objects.get(i);
			modelMgr.toString(o, result);
			if (i < objects.size() - 1) {
				result.append(MriTransferData.LINE_SEP);
			}
		}
		return result.toString();
	}

	@Override
	public String toString() {
		if (!hasContent()) {
			return EMPTY_TOSTRING_PLACEHOLDER;
		}
		String[] strings = getContentAsStrings();
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < strings.length; i++) {
			String s = strings[i];
			b.append(s);
			if (i < strings.length - 1) {
				b.append(MriTransferData.LINE_SEP);
			}
		}
		return b.toString();
	}

	private synchronized Connection getSourceConnection() {
		if (mSourceConnection != null) {
			return mSourceConnection.get();
		}
		return null;
	}

	/**
	 * @return whether the SWT {@link Clipboard} can be accessed at all and in
	 *         the current thread
	 */
	private synchronized boolean canUseNative() {
		return mUseNative && canUseUI();
	}

	/**
	 * @return whether Ui may be raised
	 */
	private static boolean canUseUI() {
		return Display.getCurrent() != null;
	}

	private ModelClipboard(boolean useNativeClipboard) {
		mUseNative = useNativeClipboard;
	}

	/**
	 * To be used by test code only. Sets a special log implementation.
	 */
	synchronized void setLogClass(Class<? extends TransferLog> clazz) {
		mLogClass = clazz;
	}

	/**
	 * Encapsulates the strategy how operations in this class find a connection
	 * to work with. A connection is found as follows:
	 * <ul>
	 * <li>A valid {@link ModelClipboard#mSourceConnection source connection}</li>
	 * <li>A valid connection hint supplied in the constructor</li>
	 * <li>A new connection created in the scope of the supplied MRI string.
	 * This connection is closed immediately after this runnable has finished.</li>
	 * </ul>
	 */
	private abstract class ConnectionRunnable<T> implements Callable<T> {
		private final T mResultOnError;
		private final Connection mHint;
		private final String mMriString;
		private Connection mNewConnection;

		/**
		 * Creates a runnable
		 * 
		 * @param hint
		 *            a connection as hint or <code>null</code>
		 * @param mriString
		 *            a MRI string to resolve a project with
		 * @param resultOnError
		 *            the object to return in case no connection is available
		 */
		ConnectionRunnable(Connection hint, String mriString, T resultOnError) {
			mHint = hint;
			mResultOnError = resultOnError;
			mMriString = mriString;
		}

		public synchronized final T call() {
			Connection connection = getWorkingConnection();
			if (connection == null) {
				return mResultOnError;
			}
			try {
				return run(connection);
			} finally {
				if (mNewConnection != null) {
					mNewConnection.close();
					mNewConnection = null;
				}
			}
		}

		/**
		 * The actual run with the given connection
		 */
		public abstract T run(Connection connection);

		private synchronized Connection getWorkingConnection() {
			Connection srcConnection = getSourceConnection();
			if (srcConnection != null && srcConnection.isAlive()) {
				return srcConnection;
			}
			if (mHint != null && mHint.isAlive()) {
				return mHint;
			}
			if (mMriString != null) {
				try {
					MRI mri = ModelManager.getInstance().getMoinInstance().createMri(mMriString);
					String containerName = mri.getPri().getContainerName();
					IProject project = findProjectForContainerName(containerName);
					if (project != null) {
						mNewConnection = ConnectionManager.getInstance().createConnection(project);
						if (mNewConnection != null) {
							mNewConnection.setLabel("Clipboard - " + mNewConnection.getLabel()); //$NON-NLS-1$
						}
						return mNewConnection;
					}
				} catch (InvalidResourceIdentifierException e) {
					MiFwkUIPlugin.logError(e, sTracer);
				}
			}
			return null;
		}

		private IProject findProjectForContainerName(String containerName) {
			IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
			for (IProject project : projects) {
				if (project.isAccessible() && ModelManager.getInstance().isMoinProject(project)) {
					CRI cri = ModelAdapterUI.getInstance().getContainer(project);
					if (cri != null) {
						String projContainerName = cri.getContainerName();
						if (containerName.equals(projContainerName)) {
							return project;
						}
					}
				}
			}
			return null;
		}
	}

	private static final class AnnounceNewPartitionsCommand extends Command {
		private final List<PartitionOperation> mPartitions;

		private AnnounceNewPartitionsCommand(Connection connection, Collection<ModelPartition> partitions) {
			super(connection, MiFwkUiMessages.Clipboard_newPartitionCmd_label);
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

	static class TransferLog implements IModelTransferLog {
		private IStatus mStatus;
		private boolean mErrorsExist;

		void add(String message, int severity) {
			IStatus status = MiFwkUIPlugin.createStatus(severity, message, null);
			add(status);
		}

		public void add(Throwable e) {
			IStatus status = MiFwkUIPlugin.createStatus(IStatus.ERROR, e.getMessage(), e);
			add(status);
		}

		public synchronized void add(IStatus status) {
			if (IStatus.CANCEL == status.getSeverity()) {
				return;
			}
			mErrorsExist |= (IStatus.ERROR == status.getSeverity());
			if (mStatus == null) {
				mStatus = status;
			} else {
				// promote mStatus to a multi status if necessary
				if (!mStatus.isMultiStatus()) {
					IStatus oldStatus = mStatus;
					mStatus = new MultiStatus(MiFwkUIPlugin.PLUGIN_ID, 0, "Errors during paste", null); //$NON-NLS-1$
					((MultiStatus) mStatus).add(oldStatus);
				}
				((MultiStatus) mStatus).add(status);
			}
		}

		/**
		 * Dumps this log, either to the user as error dialog or to the standard
		 * logging
		 */
		synchronized final void flush() {
			if (mStatus != null) {
				if (mErrorsExist && canUseUI()) {
					flushToUi(mStatus);
				} else {
					flushToLog(mStatus);
				}
			}
			mStatus = null;
			mErrorsExist = false;
		}

		protected void flushToUi(IStatus status) {
			MiFwkUIPlugin.showErrorDialog(status, null, sTracer);
		}

		protected void flushToLog(IStatus status) {
			MiFwkUIPlugin.logStatus(status, sTracer);
		}
	}

}