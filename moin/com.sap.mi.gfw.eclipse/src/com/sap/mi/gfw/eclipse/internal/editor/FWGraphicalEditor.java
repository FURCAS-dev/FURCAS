package com.sap.mi.gfw.eclipse.internal.editor;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gef.ui.parts.GraphicalEditorWithFlyoutPalette;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IGotoMarker;

import com.sap.mi.fwk.ui.editor.IModelEditor;
import com.sap.mi.fwk.ui.editor.ModelEditor;
import com.sap.tc.moin.repository.Connection;

/**
 * Convenience editor base class inheriting from {@link GraphicalEditorWithFlyoutPalette}. It provides a default implementation for
 * <code>isDirty()</code> or <code>doSave</code> and contains connection related functionality, like creating a connection or closing the
 * connection on dispose.
 * 
 * @author d031150
 */
public abstract class FWGraphicalEditor extends GraphicalEditorWithFlyoutPalette {

	private final ModelEditor mEditor;
	// As this may be called quite often, reuse the same instance of the
	// runnable.
	private final Runnable mDirtyFlagUpdater = new DirtyFlagUpdater();

	/**
	 * The editor's main UI control. Need to store it for deferred access.
	 */
	private Composite uiParent;

	private boolean isCorrectInitialized = true;

	/**
	 * Instantiates a new fW graphical editor.
	 */
	public FWGraphicalEditor() {
		mEditor = createModelEditor();
	}

	/**
	 * Returns whether the editor can initialize itself in a deferred way, i.e. postpone any access to the model (e.g. connection creation)
	 * to a later point in time. This implementation returns <code>false</code> if a connection is supplied in the editor input, i.e. none
	 * needs to be created.
	 * 
	 * @return whether the editor is a deferred one
	 * 
	 * @see #initDeferred(IEditorSite, IEditorInput)
	 * @see #createPartControlDeferred(Composite)
	 */
	protected boolean useDeferredInitialization(IEditorInput input) {
		if (getConnectionFromInput(input) != null)
			return false;
		return true;
	}

	/**
	 * Only override if the editor initialization is not {@link #useDeferredInitialization() deferred}.
	 * 
	 * @see #initDeferred(IEditorSite, IEditorInput)
	 * @see #useDeferredInitialization()
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		try {
			Connection connection = getConnectionFromInput(input);
			if (useDeferredInitialization(input)) {
				Runnable deferred = new DeferredInitializer(site, input);
				getModelEditor().init(site, input, mDirtyFlagUpdater, deferred);

				// Cannot call super.init() here since this relies on editing
				// domain being available (which is deferred to
				// setInputDeferred()). However, setSite() and setInput() must
				// be called since Eclipse editor fwk. expects that.
				setSite(site);
				setInput(input);
			} else {
				getModelEditor().init(site, input, connection, mDirtyFlagUpdater);

				// In next line GEF calls setSite(), setInput(),
				// getEditingDomain(), ...
				super.init(site, input);
			}
		} catch (PartInitException e) {
			setCorrectInitialized(false);
			throw e;
		}
	}

	/**
	 * Called at {@link #init(IEditorSite, IEditorInput)} to extract a potential existing connection from the given input. Subclasses may
	 * only retriev an existing connection or return <code>null</code>, which is the default implemtation.
	 * 
	 * @param input
	 *            the editor input
	 * @return a connection or <code>null</code>.
	 */
	protected Connection getConnectionFromInput(IEditorInput input) {
		return null;
	}

	/**
	 * Default implementation calls {@link #doSetInput(IEditorInput)} only in non-deferred case, otherwise relies on
	 * {@link #setInputDeferred(IEditorInput)} being called.
	 */
	@Override
	protected void setInput(IEditorInput input) {
		super.setInput(input);

		// in deferred case setInputDeferred() is called instead
		if (!useDeferredInitialization(input)) {
			doSetInput(input);
		}
	}

	/**
	 * Subclasses may perform the actual initialization here, no matter whether we are in deferred or non-deferred mode. Default
	 * implementation is empty.
	 * 
	 * @param input
	 *            the editor input
	 */
	protected void doSetInput(IEditorInput input) {
	}

	/**
	 * Only override if the editor initialization is not {@link #useDeferredInitialization() deferred}. The default implementation creates a
	 * UI showing the pending state of the editor initialzation.
	 * 
	 * @see #createPartControlDeferred(Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		if (useDeferredInitialization(getEditorInput())) {
			this.uiParent = parent;
			getModelEditor().createPendingControl(parent);
		} else {
			createPartControlDeferred(parent);
			postInit();
		}
	}

	/**
	 * Initializes the editor at a later point in time. The model can be safely accessed. The default implementation calls
	 * {@link #setInputDeferred(IEditorInput)}.
	 * 
	 * @param site
	 *            the editor's site
	 * @param input
	 *            the editor's input
	 * 
	 * @see #createPartControlDeferred(Composite)
	 */
	protected void initDeferred(IEditorSite site, IEditorInput input) {
		setInputDeferred(input);
	}

	/**
	 * Deferred variant of {@link #setInput(IEditorInput)}. Subclasses may override but must call <code>super.setInputDeferred()</code>.
	 * 
	 * @param input
	 *            the editor input
	 */
	protected void setInputDeferred(IEditorInput input) {
		doSetInput(input);

		// Copied from GraphicalEditor#init(), but without the setInput() and
		// setSite() calls, which must be called already at init().
		getCommandStack().addCommandStackListener(this);
		getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(this);
		initializeActionRegistry();
	}

	/**
	 * Creates the editor UI at a later point in time. The model can be safely accessed. Subclasses should do the same than they did on
	 * {@link #createPartControl(Composite)}. The default implementation calls
	 * {@link GraphicalEditorWithFlyoutPalette#createPartControl(Composite)} to create the graphical editor UI.
	 * 
	 * @param parent
	 *            the UI parent control
	 * 
	 * @see #initDeferred(IEditorSite, IEditorInput)
	 */
	protected void createPartControlDeferred(Composite parent) {
		super.createPartControl(parent);
	}

	/**
	 * This method is called after part control creation to ensure the selection of objects after connection initialization. When a subclass
	 * of {@link #FWGraphicalEditor()} implements {@link IGotoMarker#gotoMarker(IMarker)} the connection might not be initialized by the
	 * time the method is called. Therefore subclasses can choose to implements {@link #postInit()}. By the time {@link #postInit()} is
	 * called a connection is available.
	 * 
	 * @see {@link IGotoMarker#gotoMarker(IMarker)}
	 * @see #createPartControlDeferred(Composite)
	 */
	protected void postInit() {
		// implementors may choose to select objects here, e.g. base on
		// markers
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#isDirty()
	 */
	@Override
	public boolean isDirty() {
		boolean isDirty = getModelEditor().isDirty();
		return isDirty;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.ui.part.EditorPart#doSave(org.eclipse.core.runtime. IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {
		getModelEditor().doSave(monitor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.ui.parts.GraphicalEditor#dispose()
	 */
	@Override
	public void dispose() {
		getModelEditor().dispose();

		// might throw an exception when disposed during deferred startup
		try {
			super.dispose();
		} catch (Throwable t) {
			// $JL-EXC$
		}
	}

	@Override
	public void setFocus() {
		super.setFocus();
		getModelEditor().setFocus();
	}

	/**
	 * Gets the model editor.
	 * 
	 * @return the model editor
	 */
	protected ModelEditor getModelEditor() {
		return mEditor;
	}

	/**
	 * Creates the model editor.
	 * 
	 * @return the model editor
	 */
	protected ModelEditor createModelEditor() {
		return new ModelEditor(this);
	}

	/**
	 * Gets the working connection.
	 * 
	 * @return the connection that this editor may work with
	 */
	public Connection getWorkingConnection() {
		return getModelEditor().getWorkingConnection();
	}

	/**
	 * Gets the adapter.
	 * 
	 * @param adapter
	 *            the adapter
	 * 
	 * @return an {@link IEditorService} object when queried for this class
	 * 
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	@Override
	public Object getAdapter(Class adapter) {
		if (IModelEditor.class == adapter)
			return getModelEditor();

		return super.getAdapter(adapter);
	}

	/**
	 * @return the isCorrectInitialized
	 */
	protected boolean isCorrectInitialized() {
		return isCorrectInitialized;
	}

	/**
	 * @param isCorrectInitialized
	 *            the isCorrectInitialized to set
	 */
	protected void setCorrectInitialized(boolean isCorrectInitialized) {
		this.isCorrectInitialized = isCorrectInitialized;
	}

	private final class DeferredInitializer implements Runnable {
		private final IEditorSite site;
		private final IEditorInput input;

		private DeferredInitializer(IEditorSite site, IEditorInput input) {
			this.site = site;
			this.input = input;
		}

		public void run() {
			FWGraphicalEditor.this.initDeferred(site, input);

			getModelEditor().disposePendingControl();
			createPartControlDeferred(FWGraphicalEditor.this.uiParent);
			FWGraphicalEditor.this.uiParent.layout(true);
			postInit();
		}
	}

	/**
	 * Updates the editor's dirty toggle.
	 */
	final class DirtyFlagUpdater implements Runnable {
		public void run() {
			firePropertyChange(IEditorPart.PROP_DIRTY);
		}
	}

}
