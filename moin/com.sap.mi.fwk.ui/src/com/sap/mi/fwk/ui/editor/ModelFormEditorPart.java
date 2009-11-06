package com.sap.mi.fwk.ui.editor;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.INullSelectionListener;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.IFormPage;
import org.eclipse.ui.views.properties.IPropertySheetPage;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.ModelManagerUI;
import com.sap.mi.fwk.ui.internal.MiFwkUIPlugin;
import com.sap.mi.fwk.ui.internal.editor.IRunnableWithError;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.sap.tc.moin.repository.Connection;

/**
 * Convenience editor base class inheriting from {@link FormEditor}. It provides
 * a default implementation for <code>isDirty()</code> or <code>doSave</code>
 * and contains connection related functionality, like creating a connection or
 * closing the connection on dispose.
 * 
 * @author d031150
 */
public abstract class ModelFormEditorPart extends FormEditor implements INullSelectionListener {

    // In this version we do not use the stale and refresh handling - the
    // relevant methods are either package protected or private, the listener in
    // ModelEditor is deactivated. The initial idea was to have one
    // PartitionChangeListener per editor (registered in corresponding
    // ModelEditor delegate) that drags changes on partition level.
    // <br>
    // In case of a change the corresponding editor part has been marked as
    // stale. In case the editor part was the active part refresh has been
    // called immediately in order to update all nested pages. Otherwise refresh
    // performed at the point in time this editor gets the focus.
    // <br>
    // One problem we faced with this solution was, that we do not have full
    // control of all parts that need to be updated, e.g. detail parts of
    // master-detail pages and tabbed property pages. Therefore we have choosen
    // a different solution - we register PartitionChangeListeners on
    // DataBoundSectionComposite level.

    private static final Logger sTracer = Logger.getLogger(MiLocations.MI_EDITORS);

    private final ModelEditor mEditor;

    private final Runnable mDirtyFlagUpdater = new DirtyFlagUpdater();

    /**
     * Distinguishes whether a PartitionChangeEvent has been fired and needs to
     * be handled or not.
     */
    private boolean isStale = false;

    /**
     * Creates a new ModelFormEditorPart
     */
    public ModelFormEditorPart() {
	mEditor = createModelEditor();
    }

    public void selectionChanged(IWorkbenchPart part, ISelection selection) {
    }

    /**
     * Only override if the editor initialization is not
     * {@link #useDeferredInitialization() deferred}.
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

	// Call super impl. not before here because it calls setInit() and
	// setInput(), which
	// may be overidden - this code could already require a properly
	// initialized connection.
	// The achieve this the code above must not call methods like
	// getInput().
	super.init(site, input);
    }

    /**
     * Only override if the editor initialization is not
     * {@link #useDeferredInitialization() deferred}. The default implementation
     * creates a UI showing the pending state of the editor initialzation.
     * 
     * @see #addPagesDeferred()
     * @see #useDeferredInitialization()
     */
    @Override
    protected void addPages() {
	if (useDeferredInitialization()) {
	    Control pendingControl = getModelEditor().createPendingControl(getContainer());
	    int pageIdx = addPage(pendingControl);
	    setPageText(pageIdx, MiFwkUiMessages.ModeEditor_pending_pageText);
	} else {
	    addPagesDeferred();
	}
    }

    /**
     * Returns whether the editor can initialize itself in a deferred way, i.e.
     * postpone any access to the model (e.g. connection creation) to a later
     * point in time. If <code>true</code> is returned,
     * {@link #initDeferred(IEditorSite, IEditorInput)} and
     * {@link #createPartControlDeferred(Composite)} methods must be used
     * instead of the corresponding {@link IEditorPart} methods. Note that if
     * <code>false</code> is used, the editor cannot be restored on workbench
     * startup. </p> Subclasses may override. The default implementation returns
     * <code>false</code> for compatibility reasons.
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
     * Initializes the editor at a later point in time. The model can be safely
     * accessed. Subclasses should do the same than they did on
     * {@link #init(IEditorSite, IEditorInput)}.
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
     * Creates the editor UI at a later point in time. The model can be safely
     * accessed. Subclasses should do the same than they did on
     * {@link #addPages()}.
     * 
     * @see #initDeferred(IEditorSite, IEditorInput)
     */
    protected void addPagesDeferred() {
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
     * Model Editors commonly do not support isSaveAsAllowed. If your Editor
     * supports this, override this method and override doSaveAs();
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
     * In order to set the focus on a dedicated control within the page, this
     * method calls <code>setFocus()</code> on the corresponding
     * <code>FormPage</code>instance. Form based page implementations have to
     * overwrite <code>setFocus()</code> in order to propagate the focus to the
     * specific control contained on the page.
     * <p>
     * S Note: The default implementation would call <code>setFocus()</code> on
     * the ScrolledFormControl that is hosted by the <code>FormPage</code>. This
     * does not set the focus to the right control if only sections are placed
     * onto the form.
     */
    @Override
    public void setFocus() {
	if (isStale) {
	    doRefresh();
	}
	mEditor.setFocus();

	IFormPage page = getActivePageInstance();
	if (page != null) {
	    page.setFocus();
	} else {
	    super.setFocus();
	}
    }

    /**
     * Returns the page ids for all registered in order to activate the pages
     * during a JUnit test.
     * 
     * @return the page ids of all registered editor pages
     */
    public String[] getPageIds() {
	List<String> res = new ArrayList<String>(this.pages.size());
	for (Object pg : this.pages) {
	    if (pg instanceof IFormPage) {
		res.add(((IFormPage) pg).getId());
	    }
	}
	return res.toArray(new String[res.size()]);
    }

    void markStale() {
	if (sTracer.isLoggable(Level.FINE)) {
	    sTracer.logp(Level.FINE, "ModelFromEditorPart", "markStale", " called for editor <" + getEditorInput().getName() + ">"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$);
	}
	isStale = true;
	IModelEditor activeModelEditor = ModelManagerUI.getEditorManager().getActiveModelEditor();

	if (getModelEditor() == activeModelEditor) {
	    // update nested pages immediately
	    doRefresh();
	}
    }

    protected ModelEditor getModelEditor() {
	return mEditor;
    }

    protected ModelEditor createModelEditor() {
	return new ModelEditor(this);
    }

    /**
     * @return whether a default connection should be used by this editor. Such
     *         a connection is not exclusively in the scope of this editor, but
     *         may be used in other Moin clients as well. The default
     *         implementation returns <code>false</code>.
     */
    protected boolean useDefaultConnection() {
	return false;
    }

    /**
     * @return the connection that this editor may work with
     */
    public Connection getWorkingConnection() {
	return getModelEditor().getWorkingConnection();
    }

    /**
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
	if (adapter == IPropertySheetPage.class) {
	    return mEditor.setupPropertyPage();
	}

	return super.getAdapter(adapter);
    }

    private void doRefresh() {
	if (sTracer.isLoggable(Level.FINE)) {
	    sTracer.logp(Level.FINE, "ModelFromEditorPart", "refresh", " called for editor <" + getEditorInput().getName() + ">"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	getSite().getShell().getDisplay().asyncExec(new Runnable() {
	    public void run() {
		if (pages != null) {
		    // set new Input for nested editor pages
		    for (Object page : pages) {
			try {
			    if (page instanceof ModelFormPage) {
				((ModelFormPage) page).refresh();
			    } else if (page instanceof ModelEditorPart) {
				((ModelEditorPart) page).refresh();
			    }
			} catch (Exception e) {
			    // log error, but proceed
			    MiFwkUIPlugin
				    .logError(
					    "Exception caught while refreshing input of pages from editor <" + getEditorInput() != null ? getEditorInput().getName() : "editor input null", e, sTracer); //$NON-NLS-1$ //$NON-NLS-2$
			}
		    }
		}
		isStale = false;
	    }
	});
    }

    private final class DeferredInitializer implements IRunnableWithError {
	private final IEditorSite site;
	private final IEditorInput input;

	private DeferredInitializer(IEditorSite site, IEditorInput input) {
	    this.site = site;
	    this.input = input;
	}

	public void run() {
	    initDeferred(site, input);

	    getModelEditor().disposePendingControl();
	    removePage(0);

	    addPagesDeferred();
	    ModelFormEditorPart.this.getContainer().layout(true);

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

	public void initWithError(Control errorUI, IStatus reason) {
	    // embed the error UI as page
	    int pageIdx = addPage(errorUI);
	    setPageText(pageIdx, "Error"); //$NON-NLS-1$

	    // Remove the previous page with the progress monitor.
	    // Note that this must be done after inserting the error page
	    // since otherwise the latter does not show up correctly (for some
	    // strange reasons, potentially SWT bug).
	    if (pageIdx > 0) {
		removePage(0);
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