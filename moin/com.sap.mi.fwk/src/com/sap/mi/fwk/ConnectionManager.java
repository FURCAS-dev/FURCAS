package com.sap.mi.fwk;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.UndoContext;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import com.sap.mi.fwk.ModelManager.IMoinOpRunnable;
import com.sap.mi.fwk.internal.DefaultCommandStackObserver;
import com.sap.mi.fwk.internal.MiFwkPlugin;
import com.sap.mi.fwk.internal.consistency.DefaultConsistencyListener;
import com.sap.mi.fwk.internal.messages.MiFwkMessages;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.internal.uihook.IMiFwkOperationExecutor;
import com.sap.tc.moin.friends.ConnectionUtil;
import com.sap.tc.moin.friends.factory.UtilitiesFactory;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LockManager;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.commands.PartitionOperation.Operation;
import com.sap.tc.moin.repository.consistency.ConsistencyListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.type.PartitionContentChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionDeleteEvent;
import com.sap.tc.moin.repository.events.type.PartitionSaveEvent;
import com.sap.tc.moin.repository.spi.facility.ide.ContainerInitializationState;

/**
 * Facility to access MOIN connections. The methods for <b>creating</b>
 * connections must be called from a <b>NON-UI thread</b>. These methods will
 * throw an {@link IllegalStateException} if accessed from the wrong thread.<br>
 * <ul>
 * <li>Creating connections from the <b>UI thread</b> have to be performed using
 * <code>com.sap.mi.fwk.ui.ConnectionManagerUI</code>.</li>
 * <li>Carefully read the Javadoc on method level - specific constraints in
 * respect to the calling thread are described in detail.</li>
 * </ul>
 * <p/>
 * The current assumption is that connections always have a project scope, so an
 * {@link IProject} is required to created them. This allows for a resolution of
 * a tool's current project context out of any given connection.
 * <p/>
 * By now for each new connection a new {@link Session} is created, limiting the
 * visibility of transient changes in the connection to this session.
 * 
 * @author d031150, d024127, d022960
 */
public final class ConnectionManager {

    private static final Logger sTracer = Logger.getLogger(
            MiLocations.MI_CONNECTIONS);
    /*
     * To support testing. Keep value in sync with ConnectionManagerTest.
     */
    private static final String JOB_FAMILY_CLOSE_CONNECTION = "com.sap.mi.fwk.jobs.CloseConnection"; //$NON-NLS-1$

    private static ConnectionManager sInstance;

    private final Map<IProject, Connection> mProjectToDefaultConnection = new HashMap<IProject, Connection>();
    private final Map<IProject, Set<Connection>> mProjectToConnections = new HashMap<IProject, Set<Connection>>();
    private final Map<Connection, IProject> mConnectionToProject = new HashMap<Connection, IProject>();
    private final Map<Connection, IUndoContext> mConnectionToUndoContext = new HashMap<Connection, IUndoContext>();

    private final DefaultCommandStackObserver cmdStackObserver = new DefaultCommandStackObserver();
    private final ConsistencyListener consistencyListener = new DefaultConsistencyListener();
    private final ProjectListener mProjectListener = new ProjectListener();

    /**
     * @return the instance of this class
     */
    public static synchronized ConnectionManager getInstance() {
        if (ConnectionManager.sInstance == null) {
            ConnectionManager.sInstance = new ConnectionManager();
        }
        return ConnectionManager.sInstance;
    }

    /**
     * Returns a common (default) connection for the given project, which is
     * useful for sharing among different MOIN clients, e.g. editors. This
     * connection <b>must not be closed by clients</b>, instead it is closed on
     * shutdown of this plug-in.
     * 
     * @param project
     *            a project or <code>null</code> indicating the MOIN default
     *            project
     * @return the default connection for the given project or <code>null</code>
     *         if the creation failed or the user canceled
     * @see #createConnection(IProject)
     * @see #getExistingDefaultConnection(IProject)
     * @see #getOrCreateDefaultConnection(IProject)
     * @deprecated <ul>
     *             <li>Use {@link #getExistingDefaultConnection(IProject)} in
     *             order to retrieve an existing default connection. The calling
     *             thread might be a <b>UI thread</b> or a <b>NON-UI thread</b>.
     *             This method will return <code>null</code> in case the default
     *             connection has not been created at this point in time.</li>
     *             <li>Use {@link #getOrCreateDefaultConnection(IProject)} in
     *             order to retrieve an existing default connection or create a
     *             new instance if it does not exist. This method will throw an
     *             {@link IllegalStateException} if called from <b>UI
     *             thread</b>.</li>
     *             </ul>
     */
    @Deprecated
    public Connection getDefaultConnection(final IProject project) {
        final Connection connection = getDefaultConnection(project, true);
        return connection;
    }

    /**
     * Returns an existing common (default) connection for the given project or
     * <code>null</code> in case it has not been created at this point in time.
     * This connection may be used in order to share data among different MOIN
     * clients, e.g. editors.<br>
     * This connection <b>must not be closed by clients</b>, instead it is
     * closed on shutdown of this plug-in.
     * 
     * @param project
     *            a project or <code>null</code> indicating the MOIN default
     *            project
     * @return the default connection for the given project or <code>null</code>
     *         if the creation failed or the user canceled
     * @see #createConnection(IProject)
     * 
     */
    public Connection getExistingDefaultConnection(final IProject project) {
        return getDefaultConnection(project, false);
    }

    /**
     * Returns a common (default) connection for the given project, which is
     * useful for sharing data among different MOIN clients, e.g. editors. This
     * connection <b>must not be closed by clients</b>, instead it is closed on
     * shutdown of this plug-in.
     * <p/>
     * <b>Note:</b><br>
     * This method must be called from a <b>NON-UI thread</b>, otherwise an
     * <code>InvalidStateException</code> will be thrown.
     * 
     * @param project
     *            a project or <code>null</code> indicating the Moin default
     *            project
     * @return the default connection for the given project or <code>null</code>
     *         if the creation failed or the user canceled
     * @exception IllegalStateException
     *                if this method is called from <b>UI thread</b>
     * @see #createConnection(IProject)
     */
    public Connection getOrCreateDefaultConnection(final IProject project) {
        final IMiFwkOperationExecutor operationExecutor = ModelManager
                .getOperationExecutor();

        if (operationExecutor.isInUiThread()) {
            throw new IllegalStateException(
                    "Must be called from non-UI thread."); //$NON-NLS-1$ 
        }
        return getDefaultConnection(project, true);
    }

    /**
     * Returns a common connection for the given project, which is useful for
     * sharing among different MOIN clients, e.g. editors. This connection
     * <b>must not be closed by clients</b>, instead it is closed on shutdown of
     * this plug-in.
     * 
     * @param project
     *            a project or <code>null</code> indicating the Moin default
     *            project
     * @param createIfNecessary
     *            if <code>false</code>, no lazy creation takes place
     * @return the default connection for the given project
     * @see #createConnection(IProject)
     * @see #getExistingDefaultConnection(IProject)
     * @see #getOrCreateDefaultConnection(IProject)
     * @deprecated <ul>
     *             <li>Use {@link #getExistingDefaultConnection(IProject)} if
     *             passing <code>false</code> as value of parameter
     *             <code>createIfNecessary</code> meaning, you want to retrieve
     *             an existing default connection. This method may be called
     *             from <b>UI thread</b> or <b>NON-UI thread</b>. The method
     *             will return <code>null</code> in case the default connection
     *             has not been created at this point in time.</li>
     *             <li>Use {@link #getOrCreateDefaultConnection(IProject)} if
     *             calling from <b>NON-UI thread</b> and passing
     *             <code>true</code> as value of parameter
     *             <code>createIfNecessary</code>. This will definitely return a
     *             valid default connection. This method will throw an
     *             {@link IllegalStateException} if called from <b>UI
     *             thread</b>.</li>
     */
    // define private once all stakeholders have migrated to the new methods
    @Deprecated
    public Connection getDefaultConnection(final IProject project,
            final boolean createIfNecessary) {
        /*
         * Quick-check in our map if connection is present and alive. If yes, we
         * don't need the big workspace lock below. Also is more efficient if
         * createIfNecessary==false. However, this includes a certain risk of
         * stale data accessed by the following block (see comment on lock
         * ordering).
         */
        synchronized (this) {
            final Connection connection = this.mProjectToDefaultConnection
                    .get(project);
            if (connection != null && connection.isAlive()) {
                return connection;
            }
            if (!createIfNecessary) {
                return null;
            }
        }

        final IMoinOpRunnable<Connection> op = new IMoinOpRunnable<Connection>() {
            public Connection run(final ContainerInitializationState initState)
                    throws InvocationTargetException, InterruptedException {
                Connection connection = null;
                synchronized (ConnectionManager.this) {
                    // Do not check for the project being alive here, since we
                    // must allow connection lookup even for closed projects in
                    // order to close them afterwards
                    // (see #DefaultConnectionCloser).
                    connection = ConnectionManager.this.mProjectToDefaultConnection
                            .get(project);
                    if (connection != null && !connection.isAlive()) {
                        connection = null;
                        if (ConnectionManager.sTracer.isLoggable(Level.INFO)) {
                            final String msg = "Default connection for project " + project.getName() //$NON-NLS-1$
                                    + " was closed. Creating a new one."; //$NON-NLS-1$
                            ConnectionManager.sTracer.info(msg);
                        }
                    }
                    if (connection != null) {
                        return connection;
                    }
                }
                if (!createIfNecessary) {
                    return null;
                }
                // we can not create a Connection when holding a lock on
                // ConnectionManager
                // reason: MOIN calls the DII and the DII goes in the UI thread.
                // the UI thread might wait for a lock on ConnectionManager
                // Result: dead lock
                // workaround: createConnectionInternal is called outside the
                // synchronized block
                connection = createConnectionInternal(project, initState, true);
                synchronized (ConnectionManager.this) {
                    final Connection projectConnection = ConnectionManager.this.mProjectToDefaultConnection
                            .get(project);
                    if (projectConnection != null
                            && projectConnection.isAlive()) {
                        // connection for the project was created in the time
                        // between
                        connection.close();
                        return projectConnection;
                    }
                    // projectConnection is null or not alive
                    ConnectionManager.this.mProjectToDefaultConnection.put(
                            project, connection);
                    return connection;
                }
            }

            @Override
            public String toString() {
                return "Get default connection for project " + project.getName(); //$NON-NLS-1$
            }
        };

        /*
         * Must aquire a resource lock before our lock to align us with Moin
         * lock order (first resource, then Moin). Otherwise deadlocks can
         * occur, e.g. a builder runs with the resource lock trying to get a
         * ConnectionManager lock, which is held by a connection-creating thread
         * calling to Moin, which is waiting for the resource lock. Also we have
         * to aquire the resource lock here and not delay it to
         * createConnectionInternal (which does the same), as this would lead to
         * a wrong order as well (see below).
         */
        final Connection connection = ModelManager.runMoinOpWithResourceLock(
                project, null, op, null);
        return connection;
    }

    /**
     * @param connection
     *            The connection to be tested
     * 
     * @return whether the given connection is a default one, i.e. one of the
     *         connections maintained by this class
     * @see #getExistingDefaultConnection(IProject)
     * @see #getOrCreateDefaultConnection(IProject)
     */
    public synchronized boolean isDefaultConnection(final Connection connection) {
        final boolean isDefault = this.mProjectToDefaultConnection
                .containsValue(connection);
        return isDefault;
    }

    /**
     * Returns the project for the given connection, which must be one of the
     * default connection maintained by this class.
     * 
     * @param connection
     *            the connection to query the project for
     * @return the project or <code>null</code>
     */
    public synchronized IProject getProjectForDefaultConnection(
            final Connection connection) {
        final Set<Entry<IProject, Connection>> entries = this.mProjectToDefaultConnection
                .entrySet();
        for (final Entry<IProject, Connection> entry : entries) {
            if (entry.getValue().equals(connection)) {
                return entry.getKey();
            }
        }
        return null;
    }

    /**
     * Returns a new connection that can be used to access MOIN model content
     * for the given project. This method has to be called from <b>NON-UI
     * thread</b>, otherwise an {@link IllegalStateException} will be thrown.
     * <p/>
     * <b>Note:</b><br>
     * This method must be called from the <b>NON-UI thread</b>, otherwise an
     * <code>InvalidStateException</code> will be thrown.
     * 
     * @param project
     *            the project context
     * @return a new connection or <code>null</code> if the creation failed or
     *         the user canceled
     * @exception IllegalStateException
     *                if this method is called from <b>UI thread</b>
     */
    // ATTENTION WITH API CHANGES!!! - Called via reflection from
    // com.sap.mi.fwk.test.service.internal.InvocationHelper
    public Connection createConnection(final IProject project) {
        return createConnectionInternal(project, null, false);
    }

    /**
     * Creates a transient connection. In opposition to connections
     * {@link #createConnection(IProject) created by this class} the connection
     * does not refer to any project.
     * 
     * @return the connection
     * 
     * @see #isTransient(Connection)
     */
    public Connection createTransientConnection() {
        final ModelManager modelManager = ModelManager.getInstance();
        final CompoundClientSpec ccs = modelManager.getTransientClientSpec();
        final Session session = modelManager.createSession(ccs);
        final Connection connection = session.createConnection("[transient]"); //$NON-NLS-1$
        return connection;
    }

    /**
     * Tells if there are unsaved changes for this connection which means
     * partitions were made dirty by this connection which haven't been saved
     * yet.
     * 
     * @param connection
     *            The connection to be tested
     * 
     * @return <code>true</code> if there are unsaved changes for this
     *         connection, <code>false</code> otherwise
     */
    public boolean isDirty(final Connection connection) {
        if (connection == null) {
            throw new IllegalArgumentException("Connection must not be null"); //$NON-NLS-1$
        }
        if (!connection.isAlive()) {
            return false;
        }

        final boolean isDirty = connection.isDirty();
        return isDirty;
    }

    /**
     * Tells whether the given connection is a transient one
     * 
     * @param connection
     *            the connection
     * @return <code>true</code> iff it's a transient connection
     * 
     * @see #createTransientConnection()
     */
    public boolean isTransient(final Connection connection) {
        MiFwkPlugin.assertConnectionAlive(connection);

        final CompoundClientSpec clientSpecTransient = ModelManager
                .getInstance().getMoinInstance().getCompoundDataAreaManager()
                .getCompoundClientSpecTransientOnly();
        final CompoundClientSpec clientSpec = connection.getSession()
                .getCompoundClientSpec();
        if (clientSpec.equals(clientSpecTransient)) {
            return true;
        }
        return false;
    }

    /**
     * @return all connections that lock partitions from the given set
     */
    private Collection<Connection> getConnectionsWithLocks(
            final Collection<PRI> pris, final Session session) {
        final Collection<Connection> connectionWithLocks = new HashSet<Connection>();
        final LockManager lockManager = session.getLockManager();

        for (final PRI pri : pris) {
            final Connection owner = lockManager.getLockOwner(pri);
            if (owner != null) {
                connectionWithLocks.add(owner);
            }
        }

        return Collections.unmodifiableCollection(connectionWithLocks);
    }

    /**
     * Returns the Eclipse undo context associated with a given connection. If
     * no context exists a new one will be created and returned
     * 
     * @param con
     *            The MOIN connection
     * @return The corresponding undo context
     */
    public IUndoContext getUndoContext(final Connection con) {
        return this.mConnectionToUndoContext.get(con);
    }

    /**
     * Creates an Eclipse undo context for the given connection and returns it.
     * 
     * @param connection
     *            The connection which requires an undo context
     * @return The newly created undo context
     */
    public synchronized IUndoContext addUndoContext(final Connection connection) {
        IUndoContext ctx = this.mConnectionToUndoContext.get(connection);
        if (ctx == null) {
            ctx = new UndoContext();
            this.mConnectionToUndoContext.put(connection, ctx);
        }
        return ctx;
    }

    /**
     * Removes the undo context for this connection
     * 
     * @param connection
     *            The connection for which the undo context should be removed
     */
    public synchronized void removeUndoContext(final Connection connection) {
        this.mConnectionToUndoContext.remove(connection);
    }

    /**
     * Internal save routine which wraps the workspace.run call. This is just a
     * workaround until MOIN supports thread safe partition writing which is
     * encapsulation of multiple partition writes into a workspace runnable to
     * prevent in-between resource change events.
     * 
     * @param connection
     *            The connection to save
     * @exception NullPartitionNotEmptyException
     * @exception PartitionsNotSavedException
     * @exception ReferencedTransientElementsException
     * 
     */
    public void save(final Connection connection)
            throws NullPartitionNotEmptyException, PartitionsNotSavedException,
            ReferencedTransientElementsException {
        if (!connection.isAlive()) {
            return;
        }
        final IMiFwkOperationExecutor operationExecutor = ModelManager
                .getOperationExecutor();
        if (operationExecutor.isInUiThread()) {
            operationExecutor.saveConnectionInModalContext(connection);
        } else {
            saveInWorkspaceRunnable(connection);
        }
    }

    /**
     * FOR INTERNAL USE ONLY. NOT TO BE USED BY CLIENTS
     */
    public void saveInWorkspaceRunnable(final Connection connection)
            throws NullPartitionNotEmptyException, PartitionsNotSavedException,
            ReferencedTransientElementsException {
        final IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
            public void run(final IProgressMonitor monitor)
                    throws CoreException {
                try {
                    connection.save();
                } catch (final PartitionsNotSavedException e) {
                    throw new CoreException(MiFwkPlugin.createStatus(
                            IStatus.ERROR, e.getMessage(), e));
                } catch (final RuntimeException e) {
                    throw new CoreException(MiFwkPlugin.createStatus(
                            IStatus.ERROR, e.getMessage(), e));
                }
            }
        };
        try {
            ResourcesPlugin.getWorkspace().run(runnable, null);
        } catch (final CoreException e) {
            final Throwable cause = e.getStatus().getException();
            if (cause instanceof PartitionsNotSavedException) {
                throw (PartitionsNotSavedException) cause;
            }
            if (cause instanceof RuntimeException) {
                throw (RuntimeException) cause;
            }
            throw new RuntimeException(e);
        }
    }

    /**
     * Saves the given connections.
     * 
     * @param connections
     *            the connections to save
     * @param monitor
     *            a monitor to report progress or <code>null</code>
     * @return a result status
     * @see #save(Connection) for further details regarding possible error
     *      messages
     */
    public IStatus save(final Collection<Connection> connections,
            final IProgressMonitor monitor) {
        MultiStatus result = null;
        for (final Connection connection : connections) {
            try {
                save(connection);
            } catch (final Exception e) {
                final IStatus error = MiFwkPlugin.createStatus(IStatus.ERROR, e
                        .getMessage(), e);
                if (result == null) {
                    result = new MultiStatus(
                            MiFwkPlugin.PLUGIN_ID,
                            0,
                            MiFwkMessages.ConnectionManager_StatusErrorDuringSave,
                            null);
                }
                result.add(error);
            }
        }

        return result != null ? result : Status.OK_STATUS;
    }

    /**
     * Closes the given connection
     * 
     * @param connection
     *            the connection to close
     */
    public void closeConnection(final Connection connection) {
        connection.close();
        this.mConnectionToUndoContext.remove(connection);
    }

    /**
     * Returns all connections for a given project.
     * 
     * @param project
     *            The current project
     * @return all open connections created for the given project. <b>The result
     *         should be used with care - other tools may depend on these
     *         connections.</b>
     */
    public synchronized Collection<Connection> getConnections(
            final IProject project) {
        MiFwkPlugin.assertMoinProjectOpen(project);

        final Set<Connection> connections = this.mProjectToConnections
                .get(project);
        if (connections != null) {
            // Do not modify the original connection set as we also need the
            // already closed connections.
            final Set<Connection> connectionsCopy = new HashSet<Connection>(
                    connections);
            removeClosedConnections(connectionsCopy);
            return Collections.unmodifiableCollection(connectionsCopy);
        }
        return Collections.emptyList();
    }

    /**
     * Returns all dirty connections for a given project.
     * 
     * @param project
     *            The current project
     * @return all dirty connections for the given project, i.e. all that have
     *         modified partitions
     */
    public Collection<Connection> getDirtyConnections(final IProject project) {
        final Collection<Connection> allConnections = getConnections(project);
        final Collection<Connection> result = new HashSet<Connection>(
                allConnections);
        for (final Iterator<Connection> iter = result.iterator(); iter
                .hasNext();) {
            final Connection connection = iter.next();
            if (!isDirty(connection)) {
                iter.remove();
            }
        }

        return Collections.unmodifiableCollection(result);
    }

    /**
     * Returns all connections that have been created up to now. <b>The result
     * should be used with care - other tools may depend on these
     * connections.</b>
     * 
     * @param includeClosed
     *            if <code>true</code> also closed connections are returned
     * @return the connections
     */
    public synchronized Collection<Connection> getAllConnections(
            final boolean includeClosed) {
        final Collection<Set<Connection>> connectionSets = this.mProjectToConnections
                .values();
        final Collection<Connection> result = new HashSet<Connection>(
                connectionSets.size());
        for (final Set<Connection> connections : connectionSets) {
            if (connections != null) {
                result.addAll(connections);
            }
        }
        // Do not modify the original connection set as we also need the
        // already closed connections.
        if (!includeClosed) {
            removeClosedConnections(result);
        }

        return Collections.unmodifiableCollection(result);
    }

    synchronized IProject getProject(final Connection connection) {
        return this.mConnectionToProject.get(connection);
    }

    /**
     * For internal use only
     */
    synchronized void dispose() {
        final Collection<Connection> connections = this.mProjectToDefaultConnection
                .values();
        // mClosingConnections = true;
        try {
            for (final Connection connection : connections) {
                try {
                    if (!connection.isAlive()) {
                        continue;
                    }
                    connection.close();
                } catch (final Exception e) { // $JL-EXC$
                    MiFwkPlugin.logError(e, ConnectionManager.sTracer);
                    // and continue as there is nothing we could do here
                }
            }
            this.mConnectionToProject.clear();
            this.mProjectToConnections.clear();
            this.mProjectToDefaultConnection.clear();
            this.mConnectionToUndoContext.clear();

            ResourcesPlugin.getWorkspace().removeResourceChangeListener(
                    this.mProjectListener);
        } finally {
            // mClosingConnections = false;
        }
    }

    /**
     * Performs the actual connection creation. Any caller must NOT hold any
     * locks to guarantee proper lock ordering (see
     * {@link #getDefaultConnection(IProject, boolean)}.
     * 
     * @exception IllegalStateException
     *                if this method is called from the <b>UI thread</b>
     */
    @SuppressWarnings("unchecked")
    private Connection createConnectionInternal(final IProject project,
            final ContainerInitializationState initState,
            final boolean isDefault) {
        final IMoinOpRunnable<Connection> createOp = new IMoinOpRunnable<Connection>() {
            public Connection run(final ContainerInitializationState initState)
                    throws InvocationTargetException, InterruptedException {
                final Session session = ModelManager.getInstance()
                        .createSession(project, initState);
                String label = project.getName();
                if (isDefault) {
                    label += " [default]"; //$NON-NLS-1$
                }
                final Connection connection = session.createConnection(label);
                if (ConnectionManager.sTracer.isLoggable(Level.FINE)) {
                    // trace connection creation
                    final Exception exception = new Exception("Call Stack"); //$NON-NLS-1$
                    final String message = "Creating connection: " + connection.getId() //$NON-NLS-1$
                            + " - " + connection.getLabel(); //$NON-NLS-1$
                    ConnectionManager.sTracer.log(Level.FINE, message,
                            exception);
                }

                synchronized (ConnectionManager.this) {
                    ConnectionManager.this.mConnectionToProject.put(connection,
                            project);
                    Set<Connection> connections = ConnectionManager.this.mProjectToConnections
                            .get(project);
                    if (connections == null) {
                        connections = new HashSet<Connection>();
                        ConnectionManager.this.mProjectToConnections.put(
                                project, connections);
                    }
                    connections.add(connection);
                }

                return connection;
            }

            @Override
            public String toString() {
                return "Create connection for project " + project.getName(); //$NON-NLS-1$
            }
        };

        /*
         * Must aquire a resource lock before our lock to align us with Moin
         * lock order (first resource, then Moin). Otherwise deadlock can occur,
         * e.g. a builder runs with the resource lock trying to get a
         * ConnectionManager lock, which is held by a connection-creating thread
         * calling to Moin, which is waiting for the resource lock.
         */
        final Connection connection = ModelManager.runMoinOpWithResourceLock(
                project, initState, createOp, null);

        final ConnectionUtil connectionUtil = UtilitiesFactory
                .getConnectionUtil();
        connectionUtil.setCommandStackObserver(connection,
                this.cmdStackObserver);

        connection.getConsistencyViolationListenerRegistry().addListener(
                this.consistencyListener);

        final EventFilter filterElement = new EventTypeFilter(
                PartitionSaveEvent.class, PartitionDeleteEvent.class,
                PartitionContentChangeEvent.class);

        // Open a command group to avoid direct JMI call, when
        // registering event listener
        final CommandStack cStack = connection.getCommandStack();
        cStack
                .openGroup(MiFwkMessages.ConnectionManager_CommandGroupNameListenerRegistration);

        connection.getEventRegistry().registerUpdateListener(
                MarkerManager.getInstance().partitionListener, filterElement);
        cStack.closeGroup();
        cStack.clear();

        return connection;
    }

    /**
     * Removes all closed connections from the given collection (which must be
     * modifiable).
     */
    private void removeClosedConnections(
            final Collection<Connection> connections) {
        for (final Iterator<Connection> iter = connections.iterator(); iter
                .hasNext();) {
            final Connection connection = iter.next();
            if (!connection.isAlive()) {
                iter.remove();
            }
        }
    }

    ConnectionManager() {

        ResourcesPlugin.getWorkspace().addResourceChangeListener(
                this.mProjectListener, IResourceChangeEvent.POST_CHANGE);
    }

    /**
     * Returns all dirty connections in the project that is determined by the
     * given connection. <b>The result should be used with care - other tools
     * may depend on these connections.</b>
     * 
     * @param excluded
     *            one connection to exclude
     * @return the dirty connections
     */
    private Collection<Connection> getOtherDirtyConnectionsInProject(
            final Connection excluded) {
        MiFwkPlugin.assertConnectionAlive(excluded);

        IProject project = getProject(excluded);
        Collection<Connection> connectionsInProject = getConnections(project);
        final Collection<Connection> result = new HashSet<Connection>(
                connectionsInProject.size());
        for (Connection connection : connectionsInProject) {
            if (!excluded.equals(connection) && isDirty(connection)) {
                result.add(connection);
            }
        }

        return result;
    }

    /**
     * @return all connections that lock partitions from the given set. The
     *         given connection is excluded
     */
    private Collection<Connection> getOtherConnectionsWithLocks(
            final Collection<PartitionOperation> affectedPartitions,
            final Connection currentConnection) {
        if (affectedPartitions == null) {
            throw new IllegalStateException(
                    "affectedPartitons must not be null"); //$NON-NLS-1$
        }

        final Collection<PRI> pris = new HashSet<PRI>(affectedPartitions.size());
        for (final PartitionOperation partOp : affectedPartitions) {
            final Operation kind = partOp.getOperation();
            // Operation.NEW is not relevant here as locks cannot be held for
            // partitions yet to create.
            if (Operation.EDIT == kind || Operation.DELETE == kind) {
                final PRI pri = partOp.getPartitionPri();
                pris.add(pri);
            }
        }

        final Collection<Connection> connectionWithLocks = new HashSet<Connection>(
                getConnectionsWithLocks(pris, currentConnection.getSession()));
        connectionWithLocks.remove(currentConnection);

        return connectionWithLocks;
    }

    /**
     * Returns all connections which must be saved in order to execute the
     * command without locking exceptions.
     * 
     * @param cmd
     *            The current command
     * @param affectedPartitions
     *            The affected partitions
     * @return All connections which must be saved
     */
    public Collection<Connection> getSaveConnections(final Command cmd,
            final Collection<PartitionOperation> affectedPartitions) {
        MiFwkPlugin.assertObjectNotNull(cmd);
        final Connection connection = cmd.getConnection();
        return getSaveConnections(connection, affectedPartitions);
    }

    /**
     * Returns all connections which must be saved in order to avoid locking
     * exceptions.
     * 
     * @param connection
     * @param affectedPartitions
     * @return the connections
     */
    public Collection<Connection> getSaveConnections(
            final Connection connection,
            final Collection<PartitionOperation> affectedPartitions) {

        Collection<Connection> connectionsToSave;
        // in both cases pay attention to exclude the command's/editor's
        // connection
        if (affectedPartitions != null) {
            connectionsToSave = getOtherConnectionsWithLocks(
                    affectedPartitions, connection);
        } else {
            connectionsToSave = getOtherDirtyConnectionsInProject(connection);
        }

        return connectionsToSave;
    }

    /**
     * Closes the default connection on project closing or deletion. Editor
     * connections are handled by the editors themselves. Other connections are
     * currently in the responsibility of the tools that created them.
     */
    private final class ProjectListener implements IResourceChangeListener {
        public void resourceChanged(final IResourceChangeEvent event) {
            final int eventType = event.getType();
            // use post change events here to give tools the chance to do
            // their disposal with a connection still alive
            if (IResourceChangeEvent.POST_CHANGE == eventType) {
                try {
                    final IResourceDelta delta = event.getDelta();
                    if (delta == null) {
                        return;
                    }
                    delta.accept(new IResourceDeltaVisitor() {
                        public boolean visit(final IResourceDelta delta)
                                throws CoreException {
                            final IResource resource = delta.getResource();
                            if (!(resource instanceof IProject)) {
                                return true;
                            }
                            final IProject project = ((IProject) resource);
                            final int kind = delta.getKind();
                            final int flags = delta.getFlags();
                            final boolean deleted = (kind & IResourceDelta.REMOVED) != 0;
                            final boolean closed = (flags & IResourceDelta.OPEN) != 0
                                    && !project.isAccessible();
                            if (deleted || closed) {
                                /*
                                 * A synchronous call to getDefaultConnection()
                                 * in this resource listener could produce a
                                 * deadlock if another thread is in the middle
                                 * of creating this connection, which currently
                                 * requires the workspace lock (Moin refreshes
                                 * resources on session creation). This lock
                                 * cannot be obtained since this thread holds it
                                 * while notifying our listener. Fix is to
                                 * decouple things with an asychronous
                                 * submission of the connection closing.
                                 */
                                new DefaultConnectionCloser(resource
                                        .getProject()).schedule();
                                return false;
                            }
                            return true;
                        }
                    });
                } catch (final CoreException e) {
                    MiFwkPlugin.logError(e, ConnectionManager.sTracer);
                }
            }
        }
    }

    private final class DefaultConnectionCloser extends Job {
        private final IProject mProject;

        private DefaultConnectionCloser(final IProject currentProject) {
            super("Close default connection for " + currentProject); //$NON-NLS-1$
            setSystem(true);
            this.mProject = currentProject;
        }

        @Override
        protected IStatus run(final IProgressMonitor monitor) {
            // It's ok if the project already is deleted/closed here,
            // next call returns the connection anyway.
            final Connection defConnection = getDefaultConnection(
                    this.mProject, false);
            if (defConnection != null) {
                closeConnection(defConnection);
            }
            return Status.OK_STATUS;
        }

        /**
         * To support testing
         */
        @Override
        public boolean belongsTo(final Object family) {
            return ConnectionManager.JOB_FAMILY_CLOSE_CONNECTION.equals(family);
        }
    }

    /**
     * <b>MUST NOT BE CALLED BY CLIENTS<b/>. Returns a list of
     * PartitionOperations. For each model partition that will be saved when
     * Connection.save is invoked a PartitionOperation describing what will
     * happen is returned.
     * 
     * @param connection
     * @param excludeCreations
     * @return the partition operations
     */
    public Collection<PartitionOperation> getPartitionsToBeSaved(
            final Connection connection, final boolean excludeCreations) {
        final List<PartitionOperation> result = new ArrayList<PartitionOperation>();
        final Collection<ModelPartition> partitionsToBeSaved = connection
                .getPartitionsToBeSaved();
        for (final ModelPartition modelPartition : partitionsToBeSaved) {
            final PRI pri = modelPartition.getPri();
            final PartitionOperation.Operation operation = getPartitionOperation(modelPartition);
            if (excludeCreations
                    && (operation == PartitionOperation.Operation.CREATE)) {
                // partition is newly created => ignore it
            } else {
                result.add(new PartitionOperation(operation, pri));
            }
        }
        return result;
    }

    private PartitionOperation.Operation getPartitionOperation(
            final ModelPartition modelPartition) {
        PartitionOperation.Operation operation;
        if (!modelPartition.isAlive()) {
            // model partition is dirty deleted
            operation = PartitionOperation.Operation.DELETE;
        } else {
            final IFile file = ModelAdapter.getInstance().getFile(
                    modelPartition.getPri());
            if (file != null) {
                operation = PartitionOperation.Operation.EDIT;
            } else {
                operation = PartitionOperation.Operation.CREATE;
            }
        }
        return operation;
    }
}
