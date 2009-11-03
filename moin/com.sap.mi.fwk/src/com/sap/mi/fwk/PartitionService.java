package com.sap.mi.fwk;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;

import com.sap.mi.fwk.IPartitionScopeProvider.PartitionScope;
import com.sap.mi.fwk.internal.MiFwkPlugin;
import com.sap.mi.fwk.internal.messages.MiFwkMessages;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.commands.PartitionOperation.Operation;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.moin.repository.metamodels.MetaModelCatalog;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * Utilities for partition handling
 * 
 * @author d031150
 * @author D020964
 */
public class PartitionService {
	private static final TracerI sTracer = TracingManager.getTracer(MiLocations.MI_MODELHANDLING);
	private static final String LINE_SEP = System.getProperty("line.separator"); //$NON-NLS-1$
	private static PartitionService sInstance;

	/**
	 * @return the singleton instance of this service
	 */
	public static synchronized PartitionService getInstance() {
		if (sInstance == null) {
			sInstance = new PartitionService();
		}
		return sInstance;
	}

	/**
	 * Creates a partition with the given path in the specified project.
	 * Optionally assignes a model element to the created partition.
	 * 
	 * @param connection
	 *            the connection to create the partition for
	 * @param project
	 *            the project the partition should be stored in
	 * @param partitionPath
	 *            the partition path including its name
	 * @param rootElement
	 *            the model element to assign or <code>null</code>
	 * @return the created partition
	 * 
	 * @throws RuntimeException
	 *             if the creation fails
	 */
	public ModelPartition createPartition(Connection connection, IProject project, IPath partitionPath, RefBaseObject rootElement) {
		MiFwkPlugin.assertConnectionAlive(connection);
		MiFwkPlugin.assertMoinProjectOpen(project);

		// create the partition
		PRI pri = getPRI(project, partitionPath);
		ModelPartition partition = connection.createPartition(pri);
		// assign refobject to the partition
		if (rootElement != null) {
			partition.assignElementIncludingChildren(rootElement);
		}
		return partition;
	}

	/**
	 * The method "renames" the given model partition <code>partition</code>.
	 * The path of <code>partition</code> is changed to
	 * <code>newPartitionPath</code>. The renaming is performed by creating a
	 * new model partion with path <code>newPartitionPath</code> and moving all
	 * model elements contained in <code>partition</code> to the new partition.
	 * Afterwards the model partition <code>partition</code> is deleted.
	 * 
	 * @param connection
	 *            the connection to be used
	 * @param newPartitionPath
	 *            the new path of the model partition including the name (e.g.
	 *            c1/V1)
	 * @return the new model partition
	 * @throws RuntimeException
	 *             if there already exists a model partition with path
	 *             <code>newPartitionPath</code>
	 */
	public ModelPartition renamePartition(Connection connection, ModelPartition partition, IPath newPartitionPath) {
		MiFwkPlugin.assertConnectionAlive(connection);

		// TODO [Partitions] When is a partition writable? Api required from
		// Moin.
		// ModelPartition.isReadonly() not sufficient.

		// check for null partition
		if (partition.getPri().isNullPartition()) {
			throw new IllegalArgumentException("Null partition cannot be renamed: " + partition.getPri()); //$NON-NLS-1$
		}

		IProject project = ModelAdapter.getInstance().getProject(partition.getPri().getCri());
		// check if the new partiton already exists
		ModelPartition existingPartition = getPartition(connection, project, newPartitionPath);
		if (existingPartition != null) {
			String message = "partition " + existingPartition.getPri() + " already exists"; //$NON-NLS-1$ //$NON-NLS-2$
			throw new IllegalStateException(message);
		}
		// create the new partition
		ModelPartition newPartition = createPartition(connection, project, newPartitionPath, null);
		// move all Model Elements to new partition
		moveElements(partition, newPartition);
		// delete the old partition
		partition.delete();
		return newPartition;
	}

	/**
	 * Moves all Model elements contained in <code>oldPartition</code> to
	 * <code>newPartition</code>.
	 * 
	 * @param oldPartition
	 *            the partition to move the elements from
	 * @param newPartition
	 *            the partition to move the elements into
	 */
	public void moveElements(ModelPartition oldPartition, ModelPartition newPartition) {
		if (oldPartition == null) {
			throw new IllegalArgumentException("oldPartition must not be null"); //$NON-NLS-1$
		}
		if (newPartition == null) {
			throw new IllegalArgumentException("newPartition must not be null"); //$NON-NLS-1$
		}
		Collection<Partitionable> elements = oldPartition.getElements();
		for (Partitionable element : elements) {
			element.assign___Partition(newPartition);
		}

		// check if oldPartition is really empty
		elements = oldPartition.getElements();
		if (elements.size() > 0) {
			throw new IllegalStateException("Internal Error: oldPartition is not empty"); //$NON-NLS-1$
		}
	}

	/**
	 * Returns the partition with the given path in the specified project, or
	 * <code>null</code> if no such partition exists.
	 * 
	 * @param connection
	 *            the connection to create the partition for
	 * @param project
	 *            the project the partition should be stored in
	 * @param partitionPath
	 *            the partition path including its name and extension
	 * @return whether the partition exists
	 */
	public ModelPartition getPartition(Connection connection, IProject project, IPath partitionPath) {
		MiFwkPlugin.assertConnectionAlive(connection);
		MiFwkPlugin.assertMoinProjectOpen(project);

		PRI pri = getPRI(project, partitionPath);
		ModelPartition partition = connection.getPartition(pri);
		return partition;
	}

	/**
	 * Returns the identifiers of the partitions in the given project
	 * 
	 * @param connection
	 *            the connection to find the partitions with
	 * @param project
	 *            the project to find the partitions in
	 * @return the partitions in the project
	 */
	public Collection<PRI> getPartitions(Connection connection, IProject project) {
		MiFwkPlugin.assertConnectionAlive(connection);
		MiFwkPlugin.assertMoinProjectOpen(project);

		CRI container = ModelAdapter.getInstance().getContainer(project);
		if (container == null) {
			return Collections.emptyList();
		}
		Collection<PRI> partitions = connection.getSession().getInnerPartitions(container);
		return partitions;
	}

	/**
	 * Clears the given connection's null partition by either assigning all its
	 * elements to the given partition, or deleting the contents of the null
	 * partition.
	 * 
	 * @param connection
	 *            the connection whose null partition is to be cleared
	 * @param partitionToAssign
	 *            a partition to assign the null partitions contents to. <b>If
	 *            <code>null</code> is supplied, the null partition's contents
	 *            is deleted.</b>
	 * 
	 * @see Connection#getNullPartition()
	 */
	public void clearNullPartition(Connection connection, ModelPartition partitionToAssign) {
		MiFwkPlugin.assertConnectionAlive(connection);

		ModelPartition nullPartition = connection.getNullPartition();
		Collection<Partitionable> elementsInNull = nullPartition.getElements();
		if (elementsInNull.isEmpty()) {
			return;
		}

		if (partitionToAssign != null) {
			new AssignElementsCommand(connection, elementsInNull, partitionToAssign).execute();
		} else {
			new DeleteElementsCommand(connection, elementsInNull).execute();
		}
	}

	/**
	 * Clears any {@link Connection#getReferencedTransientElements() referenced
	 * transient elements} of the given connection by either assigning them to
	 * the given partition, or deleting them. Referenced transient elements are
	 * elements in some of the connection's
	 * {@link Connection#getOrCreateTransientPartition(String) transient
	 * partitions} that are still linked from any normal partition.
	 * 
	 * @param connection
	 *            the connection having referenced transient elements
	 * @param partitionToAssign
	 *            a partition to assign the null partitions contents to. <b>If
	 *            <code>null</code> is supplied, the referenced transient
	 *            elements are deleted.</b>
	 * 
	 * @see Connection#getReferencedTransientElements()
	 */
	public void clearReferencedTransientElements(Connection connection, ModelPartition partitionToAssign) {
		Collection<MRI> transientElements = connection.getReferencedTransientElements();
		if (transientElements.isEmpty()) {
			return;
		}

		Collection<Partitionable> elements = new HashSet<Partitionable>(transientElements.size());
		for (MRI mri : transientElements) {
			RefBaseObject element = connection.getElement(mri);
			if (element instanceof RefObject) {
				elements.add(element);
			}
		}

		if (partitionToAssign != null) {
			new AssignElementsCommand(connection, elements, partitionToAssign).execute();
		} else {
			new DeleteElementsCommand(connection, elements).execute();
		}
	}

	/**
	 * Returns the top-most model elements in the given partition
	 * 
	 * @param partition
	 *            a model partition
	 * @return the root elements
	 */
	public Collection<Partitionable> getRootElements(ModelPartition partition) {
		if (partition == null) {
			throw new IllegalArgumentException("Partition must not be null"); //$NON-NLS-1$
		}
		if (!partition.isAlive()) {
			return Collections.emptyList();
		}

		Collection<Partitionable> elements = partition.getElements();
		Collection<Partitionable> result = new ArrayList<Partitionable>(elements);
		for (Partitionable element : elements) {
			Partitionable parent = ((RefObject) element).refImmediateComposite();
			if (parent == null || !partition.equals(parent.get___Partition())) {
				continue;
			}
			result.remove(element);
		}
		return result;
	}

	/**
	 * Creates a {@link PRI partition resource identifier} for a
	 * {@link ModelPartition} in the given project with the given path
	 * 
	 * @param project
	 *            the project where the partition resides. Must not be
	 *            <code>null</code> nor empty. The project must be open, and
	 *            must be a Moin DC project.
	 * @param relativePath
	 *            the project relative path to the partition, e.g.
	 *            <code>src/com/sap/foo/bar/PartitionName.xmi</code>. Must not
	 *            be <code>null</code> nor empty.
	 * @return the created {@link PRI}
	 * 
	 * @see Connection#createPartition(PRI)
	 */
	// ATTENTION WITH API CHANGES!!! - Called via reflection from
	// com.sap.tc.webdynpro.metamodel.test.InvocationHelper
	public PRI getPRI(IProject project, IPath relativePath) {
		MiFwkPlugin.assertMoinProjectOpen(project);
		if (relativePath == null || relativePath.isEmpty()) {
			throw new IllegalArgumentException("relativePath must not be null nor empty: " + relativePath); //$NON-NLS-1$
		}

		PRI pri = ModelManager.getInstance().getCompoundDataAreaManager().createPri(project, relativePath.toString());
		return pri;
	}

	/**
	 * Determines whether or not the given {@link IResource} is a MOIN
	 * partition. A resource is considered to be a Moin partition, if it is
	 * either
	 * 
	 * <pre>
	 * a) an {@link IFile} and the file extension is moinmm or
	 * b) it must be possible to generate a valid PRI
	 * </pre>
	 * 
	 * @param resource
	 *            The resource in question
	 * @return True, if resource is a MOIN partition
	 */
	public boolean isMoinPartition(IResource resource) {
		if (!(resource instanceof IFile)) {
			return false;
		}
		String fileExt = resource.getFileExtension();
		if (MetaModelCatalog.META_MODEL_EXTENSION.equalsIgnoreCase(fileExt)) {
			return true;
		}
		try {
			return (getPRI(resource.getProject(), resource.getProjectRelativePath()) != null);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Returns the partitions which were made dirty by this connection,
	 * including the null partition. Hint: use {@link Connection#isDirty()} if
	 * you just want to know if there are unsaved changes.
	 * 
	 * @return partitions which were made dirty by this connection
	 */
	public Collection<ModelPartition> getDirtyPartitions(Connection connection) {
		MiFwkPlugin.assertConnectionAlive(connection);

		Collection<ModelPartition> toBeSaved = connection.getPartitionsToBeSaved();
		ModelPartition nullPartition = connection.getNullPartition();
		Collection<ModelPartition> partitions = new HashSet<ModelPartition>(toBeSaved.size() + 1);
		partitions.addAll(toBeSaved);
		if (nullPartition.isDirty()) {
			partitions.add(nullPartition);
		}
		return partitions;
	}

	/**
	 * Deletes all partitions in the given project. <br>
	 * IMPORTANT NOTE: This method must not be called from the UI thread since
	 * it directly creates a connection!
	 * 
	 * @param project
	 *            the project whose partitions are to be deleted
	 * @param monitor
	 *            a monitor
	 * @return a result status
	 */
	// ATTENTION WITH API CHANGES!!! - Called via reflection from
	// com.sap.mi.fwk.test.service.internal.InvocationHelper
	public IStatus deletePartitions(IProject project, IProgressMonitor monitor) {
		IStatus result = deletePartitions(Collections.singleton(project), null, monitor);
		return result;
	}

	/**
	 * Deletes all partitions in the given projects. <br>
	 * IMPORTANT NOTE: This method must not be called from the UI thread since
	 * it directly creates a connection!
	 * 
	 * @param projects
	 *            the projects whose partitions are to be deleted
	 * @param deletedPartitions
	 *            result object that is filled with the ids of the partitions
	 *            that have been deleted. Must be a modifiable collection or
	 *            <code>null</code>.
	 * @param monitor
	 *            a monitor
	 * @return a result status
	 */
	public IStatus deletePartitions(Collection<IProject> projects, Collection<PRI> deletedPartitions, IProgressMonitor monitor) {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		monitor.beginTask(MiFwkMessages.PartitionService_ProgressMessageDeleting, projects.size());
		MultiStatus result = null;

		for (IProject project : projects) {
			if (monitor.isCanceled()) {
				return Status.CANCEL_STATUS;
			}
			monitor.subTask(project.getName());

			Connection connection = ConnectionManager.getInstance().createConnection(project);
			if (connection == null) {
				return MiFwkPlugin.createStatus(IStatus.ERROR, MiFwkMessages.PartitionService_StatusConnectionCreationFailed, null);
			}
			connection.setLabel(MiFwkMessages.PartitionService_ConnectionNameDeletePartitions + connection.getLabel());

			try {
				Collection<PRI> pris = PartitionService.getInstance().getPartitions(connection, project);
				Command cmd = new PartitionDeleteCommand(pris, connection);
				CommandStack cmdStack = cmd.getConnection().getCommandStack();
				try {
					cmdStack.execute(cmd);
					if (deletedPartitions != null) {
						deletedPartitions.addAll(pris);
					}
					ConnectionManager.getInstance().save(connection);
				} catch (ExecutionCancelledException e) { // $JL-EXC$
					return Status.CANCEL_STATUS;
				} catch (Exception e) { // $JL-EXC$
					if (result == null) {
						result = new MultiStatus(MiFwkPlugin.PLUGIN_ID, 0, MiFwkMessages.PartitionService_StatusDeletingDataFailed, e);
					}
					result.add(MiFwkPlugin.createStatus(IStatus.ERROR, e.getMessage(), e));
				}
			} finally {
				monitor.worked(1);
				connection.close();
			}
		}

		if (result == null) {
			return Status.OK_STATUS;
		} else if (result.getChildren().length == 1) {
			return result.getChildren()[0];
		}
		return result;
	}

	/**
	 * Returns textual information about the dirty partitions of the given
	 * connections
	 */
	void getDirtyPartitionInfo(Collection<Connection> connections, Writer writer) {
		try {
			for (Connection connection : connections) {
				Collection<ModelPartition> dirtyPartitions = getDirtyPartitions(connection);
				if (!dirtyPartitions.isEmpty()) {
					writer.write(LINE_SEP);
					writer.write("Connection:"); //$NON-NLS-1$
					writer.write(connection.toString());
					writer.write(LINE_SEP);
				}
				for (Iterator<ModelPartition> iter = dirtyPartitions.iterator(); iter.hasNext();) {
					ModelPartition partition = iter.next();
					writer.write("\tPartition:"); //$NON-NLS-1$
					writer.write(partition.getPri().toString());
					writer.write(LINE_SEP);
					writer.write("\t\t"); //$NON-NLS-1$
					getPartitionInfo(partition, writer, "\t\t\t"); //$NON-NLS-1$
					if (iter.hasNext()) {
						writer.write(LINE_SEP);
					}
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void getPartitionInfo(ModelPartition partition, Writer writer, String indent) throws IOException {
		if (!partition.isAlive()) {
			writer.write("<deleted>"); //$NON-NLS-1$
		}

		Collection<Partitionable> rootElements = getRootElements(partition);
		// sort all entries alphabetically
		Set<StringBuilder> infos = new TreeSet<StringBuilder>(new Comparator<StringBuilder>() {
			public int compare(StringBuilder o1, StringBuilder o2) {
				return o1.toString().compareToIgnoreCase(o2.toString());
			}
		});
		for (Iterator<Partitionable> iter = rootElements.iterator(); iter.hasNext();) {
			StringBuilder info = new StringBuilder();
			RefBaseObject refObject = (RefBaseObject) iter.next();

			String type = ((ModelElement) refObject.refMetaObject()).getName();
			info.append(type);
			info.append(": "); //$NON-NLS-1$
			String name = ModelManager.getInstance().getObjectName(refObject);
			info.append(name);

			infos.add(info);
		}

		for (Iterator<StringBuilder> iter = infos.iterator(); iter.hasNext();) {
			StringBuilder info = iter.next();
			if (indent != null) {
				info.append(indent);
			}
			writer.write(info.toString());
			if (iter.hasNext()) {
				writer.write(LINE_SEP);
			}
		}
	}

	private static Set<PRI> getInnerPartitions(Connection connection, CRI container) {
		Set<PRI> pris = new HashSet<PRI>(connection.getSession().getInnerPartitions(container));
		pris.add(connection.getNullPartition().getPri());
		if (sTracer.debug()) {
			sTracer.debug("inner partitions of " + container); //$NON-NLS-1$
			String rs = dumpArray(pris);
			sTracer.debug(rs);
		}
		return pris;
	}

	private static Set<PRI> getOuterPartitions(Connection connection, CRI container) {
		Collection<PRI> pris = connection.getSession().getOuterPartitions(container);
		if (sTracer.debug()) {
			sTracer.debug("outer partitions of " + container); //$NON-NLS-1$
			String rs = dumpArray(pris);
			sTracer.debug(rs);
		}
		return pris instanceof Set ? (Set<PRI>) pris : new HashSet<PRI>(pris);
	}

	private static Set<PRI> getVisiblePartitions(Connection connection, CRI container) {
		Set<PRI> inner = getInnerPartitions(connection, container);
		Set<PRI> outer = getOuterPartitions(connection, container);
		Set<PRI> pris = new HashSet<PRI>(inner.size() + outer.size() * 4 / 3);
		pris.addAll(inner);
		pris.addAll(outer);
		if (sTracer.debug()) {
			sTracer.debug("visible partitions of " + container); //$NON-NLS-1$
			String rs = dumpArray(pris);
			sTracer.debug(rs);
		}
		return pris;
	}

	/**
	 * @return a scopes provider for partitions
	 */
	public IPartitionScopes getPartitionScopes() {
		return new Scopes();
	}

	/**
	 * Returns a scope provider for partitions related to the project of the
	 * given connection
	 * 
	 * @param connection
	 *            a project-based connection, i.e. one created by
	 *            {@link ConnectionManager#createConnection(IProject)}. Also
	 *            defined the dirty state to consider in the scope.
	 * @param scope
	 *            the scope for the provider
	 * @return a partition scope provider
	 */
	public IPartitionScopeProvider getPartitionScopeProvider(Connection connection, PartitionScope scope) {
		return new ScopeProvider(null, connection, scope);
	}

	/**
	 * Returns a scope provider for partitions related to the project of the
	 * given connection
	 * 
	 * @param project
	 *            the project defining the scope. If <code>null</code>, the
	 *            given connection is used.
	 * @param connection
	 *            the connection to define the dirty state to consider in the
	 *            scope
	 * @param scope
	 *            the scope for the provider
	 * @return a partition scope provider
	 */
	public IPartitionScopeProvider getPartitionScopeProvider(IProject project, Connection connection, PartitionScope scope) {
		return new ScopeProvider(project, connection, scope);
	}

	private PartitionService() {
	}

	/**
	 * A {@link IPartitionScopes} implementation
	 */
	private static class Scopes implements IPartitionScopes {
		private Set<PRI> prisFixed = null;

		public void setFixedVisiblePartitions(Set<PRI> prisfixed) {
			this.prisFixed = prisfixed;
		}

		public Set<PRI> getInnerPartitions(Connection connection) {
			Set<PRI> pris = PartitionService.getInnerPartitions(connection, getContainer(connection));
			return Collections.unmodifiableSet(pris);
		}

		public Set<PRI> getVisiblePartitions(Connection connection) {
			Set<PRI> pris = PartitionService.getVisiblePartitions(connection, getContainer(connection));
			if (prisFixed != null) {
				pris.addAll(prisFixed);
			}
			return Collections.unmodifiableSet(pris);
		}

		public Set<PRI> getOuterPartitions(Connection connection) {
			Set<PRI> pris = PartitionService.getOuterPartitions(connection, getContainer(connection));
			return Collections.unmodifiableSet(pris);
		}

		protected CRI getContainer(Connection connection) {
			CRI cri = ModelAdapter.getInstance().getContainer(connection);
			if (cri == null) {
				throw new IllegalArgumentException("No Moin container found for connection " + connection); //$NON-NLS-1$
			}
			return cri;
		}

		@Override
		public String toString() {
			if (prisFixed != null) {
				return "Fixed PRIs: " + prisFixed; //$NON-NLS-1$
			}
			return super.toString();
		}
	}

	private static final class ScopeProvider extends Scopes implements IPartitionScopeProvider {

		private final CRI mCri;
		private final Connection mConnection;
		private final PartitionScope mScope;

		ScopeProvider(IProject project, Connection connection, PartitionScope scope) {
			if (connection == null) {
				throw new IllegalArgumentException("Connection must not be null"); //$NON-NLS-1$
			}
			mConnection = connection;
			mScope = scope;
			if (project != null) {
				mCri = ModelAdapter.getInstance().getContainer(project);
				if (mCri == null) {
					throw new IllegalArgumentException("No Moin container found for project " + project.getName()); //$NON-NLS-1$
				}
			} else {
				mCri = ModelAdapter.getInstance().getContainer(connection);
				if (mCri == null) {
					throw new IllegalArgumentException("No Moin container found for connection " + connection); //$NON-NLS-1$
				}
			}
		}

		public Set<PRI> getPartitions() {
			switch (mScope) {
				case INNER:
					return getInnerPartitions(mConnection);
				case OUTER:
					return getOuterPartitions(mConnection);
				case VISIBLE:
					return getVisiblePartitions(mConnection);
				default:
					throw new IllegalArgumentException("Unknown scope: " + mScope); //$NON-NLS-1$
			}
		}

		@Override
		protected CRI getContainer(Connection connection) {
			return mCri;
		}

		@Override
		public String toString() {
			StringBuilder b = new StringBuilder();
			b.append("Container: ").append(mCri); //$NON-NLS-1$
			b.append("\nScope: ").append(mScope); //$NON-NLS-1$
			b.append("\nConnection: ").append(mConnection); //$NON-NLS-1$
			return b.toString();
		}
	}

	private static final class PartitionDeleteCommand extends Command {
		private final Collection<PRI> mPris;

		PartitionDeleteCommand(Collection<PRI> pris, Connection connection) {
			super(connection, MiFwkMessages.PartitionService_CommandNameDeletePartition);
			mPris = pris;
		}

		@Override
		public boolean canExecute() {
			return true;
		}

		@Override
		public void doExecute() {
			Connection connection = getConnection();
			for (PRI pri : mPris) {
				ModelPartition partition = connection.getPartition(pri);
				if (partition != null) {
					partition.delete();
				}
			}
		}

		@Override
		public Collection<PartitionOperation> getAffectedPartitions() {
			Collection<PartitionOperation> ops = new HashSet<PartitionOperation>(mPris.size());
			for (PRI pri : mPris) {
				PartitionOperation op = new PartitionOperation(Operation.DELETE, pri);
				ops.add(op);
			}
			return ops;
		}
	}

	private static final class DeleteElementsCommand extends Command {
		private final Collection<Partitionable> elements;

		DeleteElementsCommand(Connection connection, Collection<Partitionable> elements) {
			super(connection, MiFwkMessages.PartitionService_CommandNameDeleteElements);
			this.elements = elements;
		}

		@Override
		public boolean canExecute() {
			return true;
		}

		@Override
		public void doExecute() {
			for (Partitionable element : elements) {
				((RefObject) element).refDelete();
			}
		}

		@Override
		public Collection<PartitionOperation> getAffectedPartitions() {
			Collection<PartitionOperation> ops = new HashSet<PartitionOperation>();
			JmiHelper jmiHelper = getConnection().getJmiHelper();
			for (Partitionable element : elements) {
				Collection<PRI> partitions = jmiHelper.getAffectedPartitionsForRefDelete((RefObject) element);
				for (PRI p : partitions) {
					ops.add(new PartitionOperation(Operation.DELETE, p));
				}
			}
			return ops;
		}
	}

	private static final class AssignElementsCommand extends Command {
		private final Collection<Partitionable> elements;
		private final ModelPartition partition;

		AssignElementsCommand(Connection connection, Collection<Partitionable> elements, ModelPartition partition) {
			super(connection, MiFwkMessages.PartitionService_CommandNameAssignElements);
			this.elements = elements;
			this.partition = partition;
		}

		@Override
		public boolean canExecute() {
			return true;
		}

		@Override
		public void doExecute() {
			for (Partitionable element : elements) {
				partition.assignElementIncludingChildren(element);
			}
		}

		@Override
		public Collection<PartitionOperation> getAffectedPartitions() {
			return Collections.singleton(new PartitionOperation(Operation.EDIT, partition.getPri()));
		}
	}

	private static String dumpArray(Object array) {
		String result = arrayToSortedStringInternal(array, false);
		return result;
	}

	private static String arrayToSortedStringInternal(Object array, boolean deep) {
		if (array == null) {
			return null;
		}
		if (array.getClass().isArray()) {
			Iterator it = Arrays.asList((Object[]) array).iterator();
			return arrayToSortedStringInternal(it, deep);
		} else if (array instanceof Iterator) {
			StringBuffer sb = new StringBuffer();
			Iterator it = (Iterator) array;
			ArrayList<String> ad = new ArrayList<String>();
			while (it.hasNext()) {
				Object obj = it.next();
				ad.add(String.valueOf(obj));
			}
			String[] as = ad.toArray(new String[ad.size()]);
			Arrays.sort(as);
			for (int i = 0; i < as.length; ++i) {
				sb.append(as[i]);
			}
			return sb.toString();
		} else if (array instanceof Collection) {
			Iterator it = ((Collection) array).iterator();
			StringBuffer sb = new StringBuffer();
			if (deep) {
				while (it.hasNext()) {
					Object o = it.next();
					sb.append(arrayToSortedStringInternal(o, deep));
				}
			} else {
				sb.append(arrayToSortedStringInternal(((Collection) array).iterator(), false));
			}
			return sb.toString();
		} else {
			return String.valueOf(array);
		}
	}
}
