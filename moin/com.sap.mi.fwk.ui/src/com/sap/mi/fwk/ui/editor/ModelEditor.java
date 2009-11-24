package com.sap.mi.fwk.ui.editor;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.commands.operations.IOperationApprover;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.wizard.ProgressMonitorPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.ISaveablePart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.operations.LinearUndoViolationUserApprover;
import org.eclipse.ui.operations.RedoActionHandler;
import org.eclipse.ui.operations.UndoActionHandler;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetEntry;
import org.eclipse.ui.views.properties.PropertySheetPage;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.IRunnableWithConnection;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.ConnectionManagerUI;
import com.sap.mi.fwk.ui.ModelManagerUI;
import com.sap.mi.fwk.ui.internal.MiFwkUIPlugin;
import com.sap.mi.fwk.ui.internal.editor.IRunnableWithEditor;
import com.sap.mi.fwk.ui.internal.editor.IRunnableWithError;
import com.sap.mi.fwk.ui.internal.editor.StatusPart;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.sap.mi.fwk.ui.properties.RefObjectPropertySourceManager;
import com.sap.mi.fwk.ui.tree.TreeNodeDecorator;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionDeleteEvent;
import com.sap.tc.moin.repository.events.type.PartitionSaveEvent;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

/**
 * Implementation of {@link IModelEditor}. Additionally contains public methods with standard
 * functionality like <code>isDirty()</code> or <code>doSave</code> which {@link ModelEditorPart}s
 * delegate to.
 * 
 * @author d031150
 */
public class ModelEditor extends PlatformObject implements IModelEditor {

    private static final String DECORATOR_ID = TreeNodeDecorator.DECORATOR_ID;
    private static final String JOB_FAMILY_CLOSE_CONNECTION = "com.sap.mi.fwk.ui.jobs.CloseConnection"; //$NON-NLS-1$

    private static final Logger sTracer = Logger.getLogger(MiLocations.MI_EDITORS);

    private Connection mConnection;
    private boolean mUseExternalConnection;
    private IEditorPart mEditorPart;

    private PropertySheetPage mPropertyPage;

    private DirtyStateListener mDirtyChangeListener;
    private UpdateListener mElementDeleteListener;
    private IOperationHistoryListener mHistoryListener;
    private UndoActionHandler mUndoAction;
    private RedoActionHandler mRedoAction;

    /**
     * The operation approver used to warn of linear undo violations.
     */
    private IOperationApprover mLinearUndoViolationApprover;

    /**
     * The editor's pending control. Need to store it for deferred access.
     */
    private Control pendingControl;
    private FormToolkit formToolkit;
    private SubMonitor pendingMonitor;

    private boolean isCompleted = false;
    private Composite editorParent;

    /**
     * Creates a model editor responsible for the given {@link IEditorPart}
     * 
     * @param editorPart
     *            the part the model editor works on
     */
    public ModelEditor(IEditorPart editorPart) {
        mEditorPart = editorPart;

        if (editorPart instanceof IDecoratingModelEditor) {
            decoEnablingListener = new DecoratorStateListener();
        }

        // instantiate ModelEditorManager and install resource listeners
        ModelManagerUI.getEditorManager();
    }

    /**
     * Initializes this editor with the given editor site and input. If a dirtyStateUpdater is
     * provided, it will be registered such that it toggles the editor's dirty state.
     * 
     * @param site
     *            the editor site
     * @param input
     *            the editor's input, preferably a {@link ModelEditorInput}
     * @param dirtyStateUpdater
     *            an optional operation for toggling the dirty state, which is called at the
     *            appropriate time. Its implementation should contain a call
     *            <code>firePropertyChange(IEditorPart.PROP_DIRTY)</code>.
     * @throws PartInitException
     *             if the initialization fails
     */
    public void init(IEditorSite site, IEditorInput input, Runnable dirtyStateUpdater)
        throws PartInitException {
        init(site, input, null, dirtyStateUpdater, null);
    }

    /**
     * Initializes this editor with the given editor site and input. If a dirtyStateUpdater is
     * provided, it will be registered such that it toggles the editor's dirty state.
     * 
     * @param site
     *            the editor site
     * @param input
     *            the editor's input, preferably a {@link ModelEditorInput}
     * @param dirtyStateUpdater
     *            an optional operation for toggling the dirty state, which is called at the
     *            appropriate time. Its implementation should contain a call
     *            <code>firePropertyChange(IEditorPart.PROP_DIRTY)</code>.
     * @param deferredInit
     *            if provided, the editor will be initialized in a deferred way. See e.g.
     *            {@link ModelEditorPart#useDeferredInitialization()} for details.
     * @throws PartInitException
     *             if the initialization fails
     */
    public void init(IEditorSite site, IEditorInput input, Runnable dirtyStateUpdater,
        Runnable deferredInit) throws PartInitException {
        init(site, input, null, dirtyStateUpdater, deferredInit);
    }

    /**
     * Initializes this editor with the given editor site and input. If a dirtyStateUpdater is
     * provided, it will be registered such that it toggles the editor's dirty state.
     * 
     * @param site
     *            the editor site
     * @param input
     *            the editor's input, preferably a {@link ModelEditorInput}
     * @param externalConnection
     *            an optional existing connection that the editor should use as its own. This
     *            connection will not be closed on editor disposal.
     * @param dirtyStateUpdater
     *            an optional operation for toggling the dirty state, which is called at the
     *            appropriate time. Its implementation should contain a call
     *            <code>firePropertyChange(IEditorPart.PROP_DIRTY)</code>.
     * @throws PartInitException
     *             if the initialization fails
     */
    public void init(IEditorSite site, IEditorInput input, Connection externalConnection,
        Runnable dirtyStateUpdater) throws PartInitException {
        init(site, input, externalConnection, dirtyStateUpdater, null);
    }

    private void init(IEditorSite site, IEditorInput input, Connection externalConnection,
        Runnable dirtyStateUpdater, Runnable deferredInit) throws PartInitException {
        boolean isDeferred = deferredInit != null;
        ModelEditorInput modelInput = (ModelEditorInput) input;
        modelInput.setRestoreEnabled(isDeferred);

        if (isDeferred) {
            initDeferred(modelInput, site, dirtyStateUpdater, deferredInit);
        } else {
            try {
                if (externalConnection != null) {
                    mConnection = externalConnection;
                    mUseExternalConnection = true;
                } else {
                    createConnection(input, dirtyStateUpdater);
                }
                completeConnection(mConnection, (ModelEditorInput) input, dirtyStateUpdater);
            } finally {
                isCompleted = true;
            }
        }
    }

    public final Connection getWorkingConnection() {
        return mConnection;
    }

    public final Connection getConnection() {
        return mConnection;
    }

    /**
     * @return the {@link IEditorPart} this model editor is responsible for
     */
    protected IEditorPart getEditorPart() {
        return mEditorPart;
    }

    /**
     * Creates a control showing the pending state of the editor's initialization. To be called in
     * the editor's <code>createPartControl()</code> method. Must be removed using
     * {@link #disposePendingControl()}.
     * 
     * @param parent
     *            the parent composite
     * @return the pending control
     */
    public Control createPendingControl(Composite parent) {
        editorParent = parent;
        formToolkit = new FormToolkit(parent.getDisplay());
        pendingControl = new ProgressMonitorPart(parent, null);
        formToolkit.adapt((Composite) pendingControl);
        pendingMonitor = SubMonitor.convert((IProgressMonitor) pendingControl);
        pendingMonitor.beginTask(MiFwkUiMessages.ModelEditor_pending_label,
            IProgressMonitor.UNKNOWN);
        pendingMonitor.setWorkRemaining(100);
        pendingMonitor.newChild(20);
        return pendingControl;
    }

    /**
     * Releases the pending control created by {@link #createPendingControl(Composite)}. To be
     * called right before the actual editor is t be painted in order to remove the pending
     * visualization.
     */
    public void disposePendingControl() {
        if (pendingMonitor != null) {
            pendingMonitor.done();
            pendingMonitor = null;
        }
        if (pendingControl != null) {
            pendingControl.dispose();
            pendingControl = null;
        }
        if (formToolkit != null) {
            formToolkit.dispose();
            formToolkit = null;
        }
    }

    /**
     * Saves this editor by saving its connection
     * 
     * @param monitor
     *            the monitor to use. Typically the one passed to
     *            {@link ISaveablePart#doSave(IProgressMonitor)}
     * @see ISaveablePart#doSave(IProgressMonitor)
     */
    public void doSave(IProgressMonitor monitor) {
        // Prevent a connection from being created just to save it afterwards.
        // That's why we test with getConnection() whether a connection is there
        // at all.
        Connection connection = getConnection();
        if (connection == null) {
            return; // nothing to save
        }

        // Now use getWorkingConnection() to ensure it is attached to the
        // current thread.
        Connection co = getWorkingConnection();
        IProject project = (IProject) getEditorPart().getEditorInput().getAdapter(IProject.class);
        ModelManagerUI.getConnectionManagerUI().save(co, project, monitor);
    }

    /**
     * Answers whether this editor is dirty by querying its connection for partitions that have been
     * modified
     * 
     * @return the editor's dirty state
     * @see ISaveablePart#isDirty()
     */
    public boolean isDirty() {
        Connection connection = getConnection();
        if (connection == null) {
            return false;
        }
        boolean isDirty = ModelManager.getConnectionManager().isDirty(connection);
        return isDirty;
    }

    /**
     * Disposes this editor. If this editor is the only one working on the connection, this
     * connection is closed.
     * 
     * @see IWorkbenchPart#dispose()
     */
    public void dispose() {

        if (mPropertyPage != null) {
            mPropertyPage.dispose();
            mPropertyPage = null;
        }

        if (mHistoryListener != null) {
            OperationHistoryFactory.getOperationHistory().removeOperationHistoryListener(
                mHistoryListener);
            mHistoryListener = null;
            mUndoAction = null;
            mRedoAction = null;
        }

        if (mLinearUndoViolationApprover != null) {
            OperationHistoryFactory.getOperationHistory().removeOperationApprover(
                mLinearUndoViolationApprover);
            mLinearUndoViolationApprover = null;
        }

        // Prevent a connection from being created just to close it afterwards.
        // That's why we test with getConnection() whether a connection is there
        // at all.
        Connection connection = getConnection();
        if (connection != null && connection.isAlive()) {
            Session session = connection.getSession();
            if (mDirtyChangeListener != null) {
                session.getEventRegistry().deregister(mDirtyChangeListener);
            }

            if (mElementDeleteListener != null) {
                session.getEventRegistry().deregister(mElementDeleteListener);
            }

            // Only proceed with connection closing if we're not working on a
            // shared or external connection.
            if (!mUseExternalConnection) {
                // Check whether there are other editors open working on the
                // same connection.
                // If yes, don't close. This means that for a specific
                // connection only the last editor
                // will close it.
                // Note that in this late phase getAllActiveModelEditors() does
                // not return this editor
                // anymore, which is actually what we want (just the others).
                boolean sharedConnection = false;
                Set<IModelEditor> modelEditors = ModelManagerUI.getEditorManager()
                    .getAllActiveModelEditors();
                for (IModelEditor editor : modelEditors) {
                    if (connection.equals(editor.getConnection())) {
                        sharedConnection = true;
                        break;
                    }
                }
                if (!sharedConnection) {
                    EditorConnectionCloser ecc = new EditorConnectionCloser();
                    ecc.schedule();
                }
            }

        }
        // mConnection = null;
        mElementDeleteListener = null;
        mDirtyChangeListener = null;

        if (decoEnablingListener != null) {
            PlatformUI.getWorkbench().getDecoratorManager().removeListener(decoEnablingListener);
            decoEnablingListener = null;
        }
        // we use dereferencing this field also to signal that part has been
        // disposed
        mEditorPart = null;
    }

    @Override
    public Object getAdapter(Class adapter) {
        if (IEditorPart.class.isAssignableFrom(adapter)) {
            return getEditorPart();
        }

        return super.getAdapter(adapter);
    }

    /**
     * Called by editor parts when focus is set by Eclipse. It is necessary to update the action
     * bars (undo menu) accordingly if editor recevies focus
     */
    public void setFocus() {
        updateActionBars();
    }

    /**
     * Returns whether this editor is completely initialized. For deferred editors this may be some
     * time after <code>init</code> has been called. Use with care, it is <b>discouraged to use this
     * method to wait for editors</b>.
     * 
     * @return whether the editor is initialized
     */
    public boolean isInitialized() {
        return this.isCompleted;
    }

    /**
     * Creates a new connection in the scope of this editor's input object. If it e.g. works on an
     * object located in a distinct project, a connection will be created that is able to work in
     * the scope of this project. The current assumption is that the editor uses a
     * {@link ModelEditorInput}.
     * 
     * @param input
     *            The editor input
     * @param dirtyStateUpdater
     *            deprecated
     */
    protected void createConnection(IEditorInput input, Runnable dirtyStateUpdater) {
        String projectName = getProjectName(input);

        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
        mConnection = ModelManager.getConnectionManager().createConnection(project);
        mConnection.setLabel(input.getName());
    }

    protected void initDeferred(final ModelEditorInput input, IEditorSite site,
        final Runnable dirtyStateUpdater, final Runnable deferredEditorInit) {

        final IWorkbenchPage page = site.getPage();
        final IWorkbenchPart previousPart = page.getActivePart();

        // Important to get followUp already here (and not in runnable below)
        // since otherwise it could be executed too early by
        // ModelEditorManager#open().
        final IRunnableWithEditor followUp = input.clearFollowUp();

        IRunnableWithConnection deferredInit = new IRunnableWithConnection() {
            public void run(Connection connection, IProgressMonitor monitor) {
                ModelEditor.this.mConnection = connection;
                IEditorPart editor = getEditorPart();

                if (pendingControl == null || pendingControl.isDisposed()) {
                    // Editor was closed in between --> cancel deferred
                    // initialization
                    return;
                }

                if (pendingMonitor != null) {
                    pendingMonitor.setWorkRemaining(100);
                    pendingMonitor.newChild(20);
                }

                try {
                    completeConnection(connection, input, dirtyStateUpdater);

                    if (pendingMonitor != null) {
                        pendingMonitor.setWorkRemaining(100);
                        pendingMonitor.newChild(20);
                    }
                    deferredEditorInit.run();

                    // It's not sufficient to just call setFocus() for the
                    // editor since this does not issue the part activation
                    // events that e.g. the property sheet relies upon. Simulate
                    // a real activation by first deactivating the part
                    // (switching to another part) and then activating our part
                    // again.
                    IWorkbenchPart otherPart = null;
                    if (previousPart != null) {
                        // Use the previously opened part for switching
                        otherPart = previousPart;
                    } else {
                        // No currently active part available (can happen e.g.
                        // during Eclipse startup); since we need another active
                        // part search for any view that is available on the
                        // page.
                        IViewReference[] views = page.getViewReferences();
                        if (views != null && views.length > 0) {
                            otherPart = views[0].getView(false);
                        }
                    }

                    if (otherPart != null) {
                        page.activate(otherPart);
                    }
                    page.activate(editor);
                    if (otherPart == null) {
                        // At least set focus
                        editor.setFocus();
                    }

                    // call follup stored in input (usually sets a selection)
                    if (followUp != null) {
                        followUp.run(editor);
                    }
                } catch (Exception e) {
                    MiFwkUIPlugin.logError(e, sTracer);

                    IStatus reason;
                    if (e instanceof CoreException) {
                        reason = ((CoreException) e).getStatus();
                    } else {
                        String msg = e.getMessage();
                        if (msg == null) {
                            msg = e.getClass().getName();
                        }
                        reason = MiFwkUIPlugin.createStatus(IStatus.ERROR, msg, e);
                    }

                    disposePendingControl();

                    Composite errorUI = new Composite(editorParent, SWT.NO_FOCUS);
                    StatusPart statusPart = new StatusPart(errorUI, reason);
                    editorParent.layout(true, true);

                    // Allow special editors to embed the error UI in an own
                    // way, e.g. ModelFormEditorPart adds it as separate page.
                    if (deferredEditorInit instanceof IRunnableWithError) {
                        IRunnableWithError errorRunnable = (IRunnableWithError) deferredEditorInit;
                        errorRunnable.initWithError(errorUI, reason);
                    }
                    statusPart.setFocus();
                } finally {
                    isCompleted = true;
                }
            }

            @Override
            public String toString() {
                return MiFwkUiMessages.ModelEditor_initEditor_jobLabel;
            }
        };

        String projectName = getProjectName(input);
        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
        ConnectionManagerUI.getInstance().createConnectionAsync(project, deferredInit);
    }

    @SuppressWarnings("unchecked")
    private void completeConnection(Connection connection, ModelEditorInput modelInput,
        Runnable dirtyStateUpdater) {
        modelInput.setEditorConnection(connection);
        connection.setLabel(modelInput.getName());

        RefBaseObject obj = (RefBaseObject) modelInput.getAdapter(RefBaseObject.class);
        if (obj == null) {
            // object from input not found fill exception with previous object
            // name and project info.
            // This might happen when the object was deleted while eclipse was
            // not running.
            throw new IllegalStateException(modelInput.getExceptionText());
        }

        EventRegistry eventRegistry = connection.getSession().getEventRegistry();

        // register dirty state listener
        if (dirtyStateUpdater != null) {
            mDirtyChangeListener = new DirtyStateListener(dirtyStateUpdater);
            EventFilter filter = new EventTypeFilter(ModelChangeEvent.class,
                PartitionSaveEvent.class, PartitionChangeEvent.class);
            eventRegistry.registerUpdateListener(mDirtyChangeListener, filter);
        }

        // register delete listener
        mElementDeleteListener = new ElementDeleteListener();
        EventFilter filterDeleteElement = new EventTypeFilter(PartitionChangeEvent.class,
            PartitionDeleteEvent.class);
        eventRegistry.registerUpdateListener(mElementDeleteListener, filterDeleteElement);

        // register history listener
        mHistoryListener = new HistoryListener();
        IOperationHistory operationHistory = OperationHistoryFactory.getOperationHistory();
        operationHistory.addOperationHistoryListener(mHistoryListener);

        if (decoEnablingListener != null) {
            PlatformUI.getWorkbench().getDecoratorManager().addListener(decoEnablingListener);
        }

        // fix 2007/12/06 for injecting external connections and still use
        // undo/redo
        ConnectionManager.getInstance().addUndoContext(connection);

    }

    protected void updateActionBars() {
        IEditorPart part = getEditorPart();
        if (part == null) {
            return; // disposed
        }
        final Connection connection = getConnection();
        if (connection == null) {
            return; // not yet available
        }
        final IEditorSite site = part.getEditorSite();
        site.getShell().getDisplay().asyncExec(new Runnable() {
            public void run() {
                if (mEditorPart == null) {
                    return; // disposed in the meantime
                }

                IUndoContext undoContext = ModelManager.getConnectionManager().getUndoContext(
                    connection);
                if (mUndoAction == null) {
                    // create context and undo/redo actions
                    mUndoAction = new UndoActionHandler(site, undoContext);
                    mRedoAction = new RedoActionHandler(site, undoContext);

                    IOperationHistory operationHistory = OperationHistoryFactory
                        .getOperationHistory();
                    if (mLinearUndoViolationApprover != null) {
                        operationHistory.removeOperationApprover(mLinearUndoViolationApprover);
                    }
                    mLinearUndoViolationApprover = new LinearUndoViolationUserApprover(undoContext,
                        getEditorPart());
                    operationHistory.addOperationApprover(mLinearUndoViolationApprover);
                }

                // clear context if editor is not dirty (after save)
                if (!isDirty()) {
                    // flush only undo context. This is neccessary in case moin
                    // commands are executed during initialization
                    // e.g. by ocl registry. after editor is started the undo
                    // stack will by
                    OperationHistoryFactory.getOperationHistory().dispose(undoContext, true, false,
                        false);
                }

                // setting null action bars clears
                IActionBars actionBars = site.getActionBars();
                actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), mUndoAction);
                actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), mRedoAction);
                actionBars.updateActionBars();
            }
        });
    }

    protected void refreshPropertyPage() {
        if (mPropertyPage != null) {
            mPropertyPage.refresh();
        }
    }

    protected IPropertySheetPage setupPropertyPage() {
        // clean up old page ...
        // this is necessary if prop view has been closed and reopened
        if (mPropertyPage != null) {
            mPropertyPage.dispose();
        }
        mPropertyPage = new PropertySheetPage();
        PropertySheetEntry p = new PropertySheetEntry();
        // this page is assoicated with this editor so pass editor reference
        // this reference is used when conflicting editors are asked to save
        // to avoid saving the current editor
        p.setPropertySourceProvider(new RefObjectPropertySourceManager());
        mPropertyPage.setRootEntry(p);
        return mPropertyPage;
    }

    private String getProjectName(IEditorInput input) {
        String projectName = null;
        if (input instanceof ModelEditorInput) {
            projectName = ((ModelEditorInput) input).getProjectName();
            if (projectName == null || projectName.length() == 0) {
                throw new IllegalStateException(
                    "Editor input didn't return a project name: " + input); //$NON-NLS-1$
            }
        } else {
            throw new IllegalArgumentException("ModelEditorInput expected as input: " + input); //$NON-NLS-1$
        }
        return projectName;
    }

    private final class HistoryListener implements IOperationHistoryListener {
        public void historyNotification(OperationHistoryEvent event) {
            IUndoContext undoContext = ConnectionManager.getInstance().getUndoContext(
                getWorkingConnection());
            IUndoContext[] contexts = event.getOperation().getContexts();
            for (IUndoContext undoContext2 : contexts) {
                if (undoContext.equals(undoContext2)) {
                    updateActionBars();
                    return;
                }
            }
        }
    }

    /**
     * Closes editor if model element was deleted
     * 
     * @author d024127
     * 
     */
    private final class ElementDeleteListener implements UpdateListener {

        public void notifyUpdate(EventChain eventChain) {
            final IEditorPart part = ModelEditor.this.getEditorPart();
            if (sTracer.isLoggable(Level.FINE)) {
                String editorName = part.getTitle();
                sTracer.fine("Delete listener called of editor " //$NON-NLS-1$
                    + editorName + " with events " + eventChain.getEvents());//$NON-NLS-1$
            }

            final ModelEditorInput in = (ModelEditorInput) part.getEditorInput();
            if (in != null) {
                final IEditorSite site = part.getEditorSite();
                if (site == null) {
                    return;
                }
                final Shell shell = site.getShell();
                // Do the real work, e.g. object retrieval from input and
                // closing,
                // async to not block this listener longer than necessary,
                // which may provoke deadlocks.
                shell.getDisplay().asyncExec(new Runnable() {
                    public void run() {
                        if (mEditorPart == null) {
                            return; // disposed
                        }
                        if (shell.isDisposed()) {
                            return; // disposed
                        }
                        RefBaseObject obj = in.getRefObject();
                        if (obj == null || !((Partitionable) obj).is___Alive()) {
                            // object is gone so try to close
                            final IWorkbenchPage page = site.getPage();
                            if (sTracer.isLoggable(Level.FINE)) {
                                String editorName = part.getTitle();
                                sTracer.fine("Closing editor " + editorName); //$NON-NLS-1$
                            }
                            page.closeEditor(part, false);
                        }
                    }
                });
            }
        }
    }

    private final class DirtyStateListener implements UpdateListener {
        private final Runnable mOperation;

        DirtyStateListener(Runnable code) {
            mOperation = code;
        }

        public void notifyUpdate(EventChain events) {
            doUpdate();
            if (sTracer.isLoggable(Level.FINE)) {
                String editorName = mEditorPart != null ? mEditorPart.getTitle() : "<disposed>"; //$NON-NLS-1$
                sTracer.fine("Update listener called of editor " //$NON-NLS-1$
                    + editorName + " with events " + events.getEvents()); //$NON-NLS-1$
            }
        }

        private void doUpdate() {
            if (mEditorPart == null) {
                return; // disposed
            }
            // Switching the dirty state can only be done in the UI thread.
            Display display = mEditorPart.getSite().getShell().getDisplay();
            if (!display.isDisposed()) {
                display.asyncExec(mOperation);
            }
        }
    }

    private ILabelProviderListener decoEnablingListener;

    private final class DecoratorStateListener implements ILabelProviderListener {
        private boolean decoratorStateEnabled = PlatformUI.getWorkbench().getDecoratorManager()
            .getEnabled(DECORATOR_ID);

        public void labelProviderChanged(LabelProviderChangedEvent event) {
            if (event.getElements() == null && event.getSource() instanceof IDecoratorManager) {
                IDecoratorManager mgr = (IDecoratorManager) event.getSource();
                if (mgr.getEnabled(DECORATOR_ID) != decoratorStateEnabled) {
                    decoratorStateEnabled = !decoratorStateEnabled;
                    try {
                        ((IDecoratingModelEditor) mEditorPart)
                            .decoratorStateChanged(decoratorStateEnabled);
                    } catch (Exception ex) {
                        MiFwkUIPlugin.logError(
                            "Exception while calling decorationStateChanged. ", ex, sTracer); //$NON-NLS-1$
                    }
                }
            }
        }
    }

    private final class EditorConnectionCloser extends Job {

        private EditorConnectionCloser() {
            super("Close default connection for editor:" + ModelEditor.this); //$NON-NLS-1$
            // hide job from user
            setSystem(true);
        }

        @Override
        protected IStatus run(IProgressMonitor monitor) {

            // close connection and reset variable
            if (mConnection != null && mConnection.isAlive()) {
                ConnectionManager.getInstance().closeConnection(mConnection);
            }
            mConnection = null;
            return Status.OK_STATUS;
        }

        /**
         * To support testing
         */
        @Override
        public boolean belongsTo(Object family) {
            return JOB_FAMILY_CLOSE_CONNECTION.equals(family);
        }
    }

    /**
     * Closes editor if model element was deleted.
     * <p>
     * NOTE: This functionality is currently not used - see ModelFormEditorPart or
     * ModelMultiPageEditor for details. <br>
     * 
     * @author d022960
     * 
     */
    @SuppressWarnings("unused")
    private final class PartitionContentChangeListener implements UpdateListener {

        public void notifyUpdate(EventChain eventChain) {
            final IEditorPart part = ModelEditor.this.getEditorPart();
            if (sTracer.isLoggable(Level.FINE)) {
                String editorName = part.getTitle();
                sTracer.fine("PartitionContentChange listener called of editor " //$NON-NLS-1$
                    + editorName + " with events " + eventChain.getEvents());//$NON-NLS-1$
            }

            final ModelEditorInput editorInput = (ModelEditorInput) part.getEditorInput();
            if (editorInput != null) {
                final IEditorSite site = part.getEditorSite();
                if (site == null) {
                    return;
                }
                final Shell shell = site.getShell();
                // async to not block this listener longer than necessary,
                // which may provoke deadlocks.
                shell.getDisplay().asyncExec(new Runnable() {
                    public void run() {
                        if (mEditorPart == null) {
                            return; // disposed
                        }
                        if (shell.isDisposed()) {
                            return; // disposed
                        }
                        if (sTracer.isLoggable(Level.FINE)) {
                            String editorName = part.getTitle();
                            sTracer.fine("Refreshing editor " + editorName); //$NON-NLS-1$
                        }
                        // We only propagate the new input for editors of type
                        // ModelFormEditorPart as Moin Databinding adapter does
                        // not refresh its RefObjectObservable<xxx> instances
                        // TODO handle PartitionChange events for editors of
                        // type ModelEditorPart and ModelMultiPageEditorPart
                        if (mEditorPart instanceof ModelFormEditorPart) {
                            ((ModelFormEditorPart) mEditorPart).markStale();
                        } else if (mEditorPart instanceof ModelMultiPageEditorPart) {
                            ((ModelMultiPageEditorPart) mEditorPart).markStale();
                        }
                    }
                });
            }
        }
    }

    public IProgressMonitor getPendingMonitor() {
        return pendingMonitor;
    }
}