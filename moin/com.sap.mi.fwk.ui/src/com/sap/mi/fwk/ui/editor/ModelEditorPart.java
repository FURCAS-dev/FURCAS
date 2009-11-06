package com.sap.mi.fwk.ui.editor;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.INullSelectionListener;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.tc.moin.repository.Connection;

/**
 * Convenience editor base class inheriting from {@link EditorPart}. It provides a default
 * implementation for <code>isDirty()</code> or <code>doSave</code> and contains connection related
 * functionality, like creating a connection or closing the connection on dispose.
 * 
 * @author d031150
 */
public abstract class ModelEditorPart extends EditorPart implements INullSelectionListener {

    private static final Logger sTracer = Logger.getLogger(MiLocations.MI_EDITORS);

    private final ModelEditor mEditor;

    // As this may be called quite often, reuse the same instance of the
    // runnable.
    private final Runnable mDirtyFlagUpdater = new DirtyFlagUpdater();

    // only set if within Model MultiPageEditor
    private ModelMultiPageEditorPart mMultiPageEditorParent = null;

    /**
     * The editor's main UI control. Need to store it for deferred access.
     */
    private Composite uiParent;

    /**
     * Creates a new ModelEditorPart
     */
    public ModelEditorPart() {
        mEditor = createModelEditor();
    }

    /**
     * Constructor to be used, if within MultiPageEditorPart (if parent instanceof
     * ModelMultiPageEditorPart connection is delegated to this one )
     * 
     * @param parent
     */
    public ModelEditorPart(MultiPageEditorPart parent) {
        if (parent instanceof ModelMultiPageEditorPart) {
            this.mMultiPageEditorParent = (ModelMultiPageEditorPart) parent;
            mEditor = this.mMultiPageEditorParent.getModelEditor();
        } else {
            // we treat this case as if this is a single editor
            mEditor = createModelEditor();
        }
    }

    /**
     * Only override if the editor initialization is not {@link #useDeferredInitialization()
     * deferred}.
     * 
     * @see #initDeferred(IEditorSite, IEditorInput)
     * @see #useDeferredInitialization()
     */
    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        if (useDeferredInitialization()) {
            Runnable deferred = new DeferredInitializer(site, input);
            getModelEditor().init(site, input, mDirtyFlagUpdater, deferred);
        } else {
            getModelEditor().init(site, input, mDirtyFlagUpdater);
            initDeferred(site, input);
        }

        // Call input and site setters not before here because they may be
        // overidden -
        // this code could already require a properly initialized connection.
        // The achieve this the code above must not call methods like
        // getInput().
        setSite(site);
        setInput(input);
    }

    /**
     * Only override if the editor initialization is not {@link #useDeferredInitialization()
     * deferred}. The default implementation creates a UI showing the pending state of the editor
     * initialzation.
     * 
     * @see #createPartControlDeferred(Composite)
     * @see #useDeferredInitialization()
     */
    @Override
    public void createPartControl(Composite parent) {
        if (useDeferredInitialization()) {
            this.uiParent = parent;
            getModelEditor().createPendingControl(parent);
        } else {
            createPartControlDeferred(parent);
        }
    }

    /**
     * Returns whether the editor can initialize itself in a deferred way, i.e. postpone any access
     * to the model (e.g. connection creation) to a later point in time. If <code>true</code> is
     * returned, {@link #initDeferred(IEditorSite, IEditorInput)} and
     * {@link #createPartControlDeferred(Composite)} methods must be used instead of the
     * corresponding {@link IEditorPart} methods. Note that if <code>false</code> is used, the
     * editor cannot be restored on workbench startup. </p> Subclasses may override. The default
     * implementation returns <code>false</code> for compatibility reasons.
     * 
     * @return whether the editor is a deferred one
     * 
     * @see #initDeferred(IEditorSite, IEditorInput)
     * @see #createPartControlDeferred(Composite)
     */
    protected boolean useDeferredInitialization() {
        return false;
    }

    /**
     * Initializes the editor at a later point in time. The model can be safely accessed. Subclasses
     * should do the same than they did on {@link #init(IEditorSite, IEditorInput)}.
     * 
     * @param site
     *            the editor's site
     * @param input
     *            the editor's input
     * 
     * @see #createPartControlDeferred(Composite)
     */
    protected void initDeferred(IEditorSite site, IEditorInput input) {
    }

    /**
     * Creates the editor UI at a later point in time. The model can be safely accessed. Subclasses
     * should do the same than they did on {@link #createPartControlDeferred(Composite)}.
     * 
     * @param parent
     *            the UI parent control
     * 
     * @see #initDeferred(IEditorSite, IEditorInput)
     */
    protected void createPartControlDeferred(Composite parent) {
    }

    @Override
    public boolean isDirty() {
        boolean isDirty = getModelEditor().isDirty();
        return isDirty;
    }

    @Override
    public void doSave(IProgressMonitor monitor) {
        getModelEditor().doSave(monitor);
    }

    /**
     * Model Editors commonly do not support isSaveAsAllowed. If your Editor supports this, override
     * this method and override doSaveAs();
     */
    @Override
    public boolean isSaveAsAllowed() {
        return false;
    }

    @Override
    public void doSaveAs() {
        throw new UnsupportedOperationException("isSaveAllowed is false"); //$NON-NLS-1$
    }

    @Override
    public void dispose() {
        // the order is important, in order to ensure that other dispose
        // handlers get a valid connection
        super.dispose();
        getModelEditor().dispose();
    }

    /**
     * Empty default implementation of
     * {@link ISelectionListener#selectionChanged(IWorkbenchPart, ISelection)}.
     */
    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
    }

    /**
     * Sets the editor's focus control. Any code here check for uninitialized state, e.g. not yet
     * created UI controls, since the method may be called at any time.
     */
    @Override
    public void setFocus() {
        mEditor.setFocus();
    }

    /**
     * @return the connection that this editor may work with
     */
    public Connection getWorkingConnection() {
        if (this.mMultiPageEditorParent != null) {
            return this.mMultiPageEditorParent.getWorkingConnection();
        }
        return getModelEditor().getWorkingConnection();
    }

    /**
     * Returns
     * 
     * <pre>
     * adapter
     * {@link IModelEditor} : current ModelEditor
     * {@link IPropertySheetPage} : newly created PropertySheetPage
     * </pre>
     * 
     * @return the result object as specified
     * @see IAdaptable#getAdapter(java.lang.Class)
     */
    @Override
    public Object getAdapter(Class adapter) {
        if (IModelEditor.class == adapter) {
            return getModelEditor();
        }

        // do not use mEditor.getAdapter since this adapter
        // should only react on IPropertySheet and delegate
        // other calls to super.getAdapter
        if (IPropertySheetPage.class == adapter) {
            // return new TabbedPropertySheetPage(getModelEditor());
            return mEditor.setupPropertyPage();
        }

        return super.getAdapter(adapter);
    }

    protected ModelEditor getModelEditor() {
        return mEditor;
    }

    protected ModelEditor createModelEditor() {
        return new ModelEditor(this);
    }

    /*
     * This method is called from ModelFormEditorPart and ModelMultiPageEditorPart in case a
     * PartitionChangeEvent is fired. <br> Clients may overwrite this method in order to update
     * every form that is stale.
     * 
     * NOTE: In this version we do not use the stale and refresh handling - the relevant methods are
     * either package protected or private, the listener in ModelEditor is deactivated - see
     * ModelMultiPageEditor for details.
     */
    void refresh() {
    }

    private final class DeferredInitializer implements Runnable {
        private final IEditorSite site;
        private final IEditorInput input;

        private DeferredInitializer(IEditorSite site, IEditorInput input) {
            this.site = site;
            this.input = input;
        }

        public void run() {
            initDeferred(site, input);

            getModelEditor().disposePendingControl();
            createPartControlDeferred(ModelEditorPart.this.uiParent);
            ModelEditorPart.this.uiParent.layout(true);

            refreshDependentViews();
        }

        // fix for bug reported by Galaxy, outline/prop sheet do not
        // refresh after editor restore
        // this does not take other views than outline and prop sheet
        // into account.
        private void refreshDependentViews() {
            try {
                IWorkbenchPage activePage = site.getWorkbenchWindow().getActivePage();
                IViewPart part = activePage.findView(IPageLayout.ID_OUTLINE);
                if (activePage.isPartVisible(part)) {
                    activePage.activate(part);
                }
                part = activePage.findView(IPageLayout.ID_PROP_SHEET);
                if (activePage.isPartVisible(part)) {
                    activePage.activate(part);
                }
            } catch (Exception e) {
                sTracer.log(Level.WARNING, "Dependent views could not be refreshed", e); //$NON-NLS-1$
            }
        }
    }

    /**
     * Updates the editor's dirty toggle
     */
    private final class DirtyFlagUpdater implements Runnable {
        public void run() {
            firePropertyChange(IEditorPart.PROP_DIRTY);
            mEditor.refreshPropertyPage();
        }
    }

}
