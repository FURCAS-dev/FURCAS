package com.sap.ide.cts.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.revisions.RevisionInformation;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.IAnnotationAccess;
import org.eclipse.jface.text.source.ISharedTextColors;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.IVerticalRulerColumn;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.INavigationLocation;
import org.eclipse.ui.INavigationLocationProvider;
import org.eclipse.ui.IPersistableEditor;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IReusableEditor;
import org.eclipse.ui.ISaveablesSource;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.Saveable;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.IStatusField;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorExtension;
import org.eclipse.ui.texteditor.ITextEditorExtension2;
import org.eclipse.ui.texteditor.ITextEditorExtension3;
import org.eclipse.ui.texteditor.ITextEditorExtension4;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;
import org.eclipse.ui.views.properties.IPropertySheetPage;

public class ModelBasedTextEditorDelegator extends ModelEditorPart implements ITextEditor, IReusableEditor, ITextEditorExtension, ITextEditorExtension2, ITextEditorExtension3, ITextEditorExtension4, INavigationLocationProvider, ISaveablesSource, IPersistableEditor {
	

	protected TextEditorDelegate textEditorDelegate;
	private static Collection<IPropertyListener> deferredListenersToAdd = new ArrayList<IPropertyListener>();
	
	
	public ModelBasedTextEditorDelegator() {
		textEditorDelegate = new TextEditorDelegate(this);
		//during the super constructor call property listeners might have been added
		// as textEditordelegate was not initialized back then add those listeners now:
		for (IPropertyListener l : deferredListenersToAdd) {
			textEditorDelegate.addPropertyListener(l);
		}
		deferredListenersToAdd.clear();
	}

	@Override
	public void dispose() {
		// the order is important, in order to ensure that other dispose
		// handlers get a valid connection
		textEditorDelegate.dispose();
		super.dispose();
	}

	/**
	 * Empty default implementation of
	 * {@link ISelectionListener#selectionChanged(IWorkbenchPart, ISelection)}.
	 */
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
	}
	
	
	/* (non-Javadoc)
	 * @see com.sap.mi.fwk.ui.editor.ModelEditorPart#initDeferred(org.eclipse.ui.IEditorSite, org.eclipse.ui.IEditorInput)
	 */
	@Override
	protected void initDeferred(IEditorSite site, IEditorInput input) {
		try {
			textEditorDelegate.init(site, input);
		} catch (PartInitException e) {
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.sap.mi.fwk.ui.editor.ModelEditorPart#createPartControlDeferred(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createPartControlDeferred(Composite parent) {
		textEditorDelegate.createPartControl(parent);
	}
	
	
	protected void configureSourceViewerDecorationSupport(SourceViewerDecorationSupport support) {
		
	}
	
	protected ISourceViewer createSourceViewer(Composite parent,IVerticalRuler ruler, int styles) {
		return textEditorDelegate.createSourceViewer(parent, ruler, styles);
	}
	protected ISharedTextColors getSharedColors() {
		return textEditorDelegate.getSharedColors();
	}
	public ISourceViewer getSourceViewer() {
		return textEditorDelegate.getSourceView();
	}
	public void setPreferenceStore(IPreferenceStore store){
		
	    textEditorDelegate.setPreferenceStore(store);
	}
	public IPreferenceStore getPreferenceStore(){
		
	    return textEditorDelegate.getPreferenceStor();
	}
	

	/* (non-Javadoc)
	 * @see com.sap.mi.fwk.ui.editor.ModelEditorPart#useDeferredInitialization()
	 */
	@Override
	protected boolean useDeferredInitialization() {
		return true;
	}


	/**
	 * @return
	 * @see com.sap.ide.cts.editor.TextEditorDelegate#getAnnotationAccess()
	 */
	public IAnnotationAccess getAnnotationAccess() {
		return textEditorDelegate.getAnnotationAccess();
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
	 * @return an {@link IEditorService} object when queried for this class
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	@SuppressWarnings("unchecked") // superclass doesn't use type parameters
	@Override
	public Object getAdapter(Class adapter) {
		if (IModelEditor.class == adapter || IPropertySheetPage.class == adapter) {
			return super.getAdapter(adapter);
		}

		return textEditorDelegate.getAdapter(adapter);
	}
	
	/**
	 * @param ruler
	 * @return
	 * @see com.sap.ide.cts.editor.TextEditorDelegate#createAnnotationRulerColumn(org.eclipse.jface.text.source.CompositeRuler)
	 */
	public IVerticalRulerColumn createAnnotationRulerColumn(CompositeRuler ruler) {
		return textEditorDelegate.createAnnotationRulerColumn(ruler);
	}

	/**
	 * @param configuration
	 * @see com.sap.ide.cts.editor.TextEditorDelegate#setSourceViewerConfiguration(org.eclipse.jface.text.source.SourceViewerConfiguration)
	 */
	public void setSourceViewerConfiguration(
			SourceViewerConfiguration configuration) {
		textEditorDelegate.setSourceViewerConfiguration(configuration);
	}

	/**
	 * @param listener
	 * @see org.eclipse.ui.part.WorkbenchPart#addPartPropertyListener(org.eclipse.jface.util.IPropertyChangeListener)
	 */
	@Override
	public void addPartPropertyListener(IPropertyChangeListener listener) {
		super.addPartPropertyListener(listener);
		textEditorDelegate.addPartPropertyListener(listener);
	}


	/**
	 * @param l
	 * @see org.eclipse.ui.part.WorkbenchPart#addPropertyListener(org.eclipse.ui.IPropertyListener)
	 */
	@Override
	public void addPropertyListener(IPropertyListener l) {
		super.addPropertyListener(l);
		//this can happen during constructor call
		//so textEditorDelegate may still be null
		if(textEditorDelegate != null) {
			textEditorDelegate.addPropertyListener(l);
		} else {
			//so add listener to deferred list
			//which will be processed later
			deferredListenersToAdd.add(l);
		}
	}

    /**
     * Sets the part site. Also to the text editor.
     *
     * @param site the workbench part site
     */
    @Override
    protected void setSite(IWorkbenchPartSite site) {
        super.setSite(site);
        textEditorDelegate.setSitePublic(site);
    }
	
	
	/**
	 * @param listener
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#addRulerContextMenuListener(org.eclipse.jface.action.IMenuListener)
	 */
	public void addRulerContextMenuListener(IMenuListener listener) {
		textEditorDelegate.addRulerContextMenuListener(listener);
	}


	/**
	 * @param save
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#close(boolean)
	 */
	public void close(boolean save) {
		textEditorDelegate.close(save);
	}


	/**
	 * @return
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#createEmptyNavigationLocation()
	 */
	public INavigationLocation createEmptyNavigationLocation() {
		return textEditorDelegate.createEmptyNavigationLocation();
	}


	/**
	 * @return
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#createNavigationLocation()
	 */
	public INavigationLocation createNavigationLocation() {
		return textEditorDelegate.createNavigationLocation();
	}


	/**
	 * 
	 * @see org.eclipse.ui.texteditor.StatusTextEditor#doRevertToSaved()
	 */
	public void doRevertToSaved() {
		textEditorDelegate.doRevertToSaved();
	}


	/**
	 * @param progressMonitor
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		doSaveAboutToPerform(progressMonitor);
		//TODO check why an exception occurs on save when this is not commented
		//super.doSave(progressMonitor);
	}
	
	/**
	 * Hook for subclasses that want to take actions before save is performed.
	 * @param monitor
	 */
	public void doSaveAboutToPerform(IProgressMonitor monitor) {
	}


	/**
	 * 
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#doSaveAs()
	 */
	@Override
	public void doSaveAs() {
		textEditorDelegate.doSaveAs();
	}


	/**
	 * @param actionID
	 * @return
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#getAction(java.lang.String)
	 */
	public IAction getAction(String actionID) {
		return textEditorDelegate.getAction(actionID);
	}


	/**
	 * @return
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#getActiveSaveables()
	 */
	public Saveable[] getActiveSaveables() {
		return textEditorDelegate.getActiveSaveables();
	}



	/**
	 * @return
	 * @see org.eclipse.ui.part.WorkbenchPart#getContentDescription()
	 */
	@Override
	public String getContentDescription() {
		return textEditorDelegate.getContentDescription();
	}


	/**
	 * @return
	 * @see org.eclipse.ui.texteditor.AbstractDecoratedTextEditor#getDocumentProvider()
	 */
	public IDocumentProvider getDocumentProvider() {
		return textEditorDelegate.getDocumentProvider();
	}


	/**
	 * @return
	 * @see org.eclipse.ui.part.EditorPart#getEditorInput()
	 */
	@Override
	public IEditorInput getEditorInput() {
		return super.getEditorInput();
	}


	/**
	 * @return
	 * @see org.eclipse.ui.part.EditorPart#getEditorSite()
	 */
	@Override
	public IEditorSite getEditorSite() {
		return textEditorDelegate.getEditorSite();
	}


	/**
	 * @return
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#getHighlightRange()
	 */
	public IRegion getHighlightRange() {
		return textEditorDelegate.getHighlightRange();
	}


	/**
	 * @return
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#getInsertMode()
	 */
	public InsertMode getInsertMode() {
		return textEditorDelegate.getInsertMode();
	}


	/**
	 * @return
	 * @see org.eclipse.ui.part.WorkbenchPart#getOrientation()
	 */
	@Override
	public int getOrientation() {
		return textEditorDelegate.getOrientation();
	}


	/**
	 * @return
	 * @see org.eclipse.ui.part.WorkbenchPart#getPartName()
	 */
	@Override
	public String getPartName() {
		return textEditorDelegate.getPartName();
	}


	/**
	 * @return
	 * @see org.eclipse.ui.part.WorkbenchPart#getPartProperties()
	 */
	@Override
	@SuppressWarnings("unchecked") // superclass doesn't use type parameters
	public Map getPartProperties() {
		return textEditorDelegate.getPartProperties();
	}


	/**
	 * @param key
	 * @return
	 * @see org.eclipse.ui.part.WorkbenchPart#getPartProperty(java.lang.String)
	 */
	@Override
	public String getPartProperty(String key) {
		return textEditorDelegate.getPartProperty(key);
	}


	/**
	 * @return
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#getSaveables()
	 */
	public Saveable[] getSaveables() {
		return textEditorDelegate.getSaveables();
//		if (fSavable == null)
//			fSavable= textEditorDelegate.new ModelBasedTextEditorSavable(this, textEditorDelegate.getSaveables());
//
//		return new Saveable[] { fSavable };
	}


	/**
	 * @return
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#getSelectionProvider()
	 */
	public ISelectionProvider getSelectionProvider() {
		return textEditorDelegate.getSelectionProvider();
	}


	/**
	 * @return
	 * @see org.eclipse.ui.part.WorkbenchPart#getSite()
	 */
	@Override
	public IWorkbenchPartSite getSite() {
		return textEditorDelegate.getSite();
	}


	/**
	 * @return
	 * @see org.eclipse.ui.part.WorkbenchPart#getTitle()
	 */
	@Override
	public String getTitle() {
		return textEditorDelegate.getTitle();
	}


	/**
	 * @return
	 * @see org.eclipse.ui.part.WorkbenchPart#getTitleImage()
	 */
	@Override
	public Image getTitleImage() {
		return textEditorDelegate.getTitleImage();
	}


	/**
	 * @return
	 * @see org.eclipse.ui.part.EditorPart#getTitleToolTip()
	 */
	@Override
	public String getTitleToolTip() {
		return textEditorDelegate.getTitleToolTip();
	}


	/**
	 * @param forward
	 * @return
	 * @see org.eclipse.ui.texteditor.AbstractDecoratedTextEditor#gotoAnnotation(boolean)
	 */
	public Annotation gotoAnnotation(boolean forward) {
		return textEditorDelegate.gotoAnnotation(forward);
	}


	/**
	 * @param marker
	 * @deprecated
	 * @see org.eclipse.ui.texteditor.AbstractDecoratedTextEditor#gotoMarker(org.eclipse.core.resources.IMarker)
	 */
	@Deprecated
	public void gotoMarker(IMarker marker) {
		textEditorDelegate.gotoMarker(marker);
	}

	/**
	 * @return
	 * @see org.eclipse.ui.texteditor.AbstractDecoratedTextEditor#isChangeInformationShowing()
	 */
	public boolean isChangeInformationShowing() {
		return textEditorDelegate.isChangeInformationShowing();
	}


	/**
	 * @return
	 * @see org.eclipse.ui.texteditor.AbstractDecoratedTextEditor#isEditable()
	 */
	public boolean isEditable() {
		return textEditorDelegate.isEditable();
	}


	/**
	 * @return
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#isEditorInputModifiable()
	 */
	public boolean isEditorInputModifiable() {
		return textEditorDelegate.isEditorInputModifiable();
	}


	/**
	 * @return
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#isEditorInputReadOnly()
	 */
	public boolean isEditorInputReadOnly() {
		return textEditorDelegate.isEditorInputReadOnly();
	}


	/**
	 * @return
	 * @see org.eclipse.ui.part.EditorPart#isSaveOnCloseNeeded()
	 */
	@Override
	public boolean isSaveOnCloseNeeded() {
		return textEditorDelegate.isSaveOnCloseNeeded();
	}


	/**
	 * @param actionId
	 * @param mark
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#markAsContentDependentAction(java.lang.String, boolean)
	 */
	public void markAsContentDependentAction(String actionId, boolean mark) {
		textEditorDelegate.markAsContentDependentAction(actionId, mark);
	}


	/**
	 * @param actionId
	 * @param mark
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#markAsPropertyDependentAction(java.lang.String, boolean)
	 */
	public void markAsPropertyDependentAction(String actionId, boolean mark) {
		textEditorDelegate.markAsPropertyDependentAction(actionId, mark);
	}


	/**
	 * @param actionId
	 * @param mark
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#markAsSelectionDependentAction(java.lang.String, boolean)
	 */
	public void markAsSelectionDependentAction(String actionId, boolean mark) {
		textEditorDelegate.markAsSelectionDependentAction(actionId, mark);
	}


	/**
	 * @param actionId
	 * @param mark
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#markAsStateDependentAction(java.lang.String, boolean)
	 */
	public void markAsStateDependentAction(String actionId, boolean mark) {
		textEditorDelegate.markAsStateDependentAction(actionId, mark);
	}


	/**
	 * @param actionID
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#removeActionActivationCode(java.lang.String)
	 */
	public void removeActionActivationCode(String actionID) {
		textEditorDelegate.removeActionActivationCode(actionID);
	}


	/**
	 * @param listener
	 * @see org.eclipse.ui.part.WorkbenchPart#removePartPropertyListener(org.eclipse.jface.util.IPropertyChangeListener)
	 */
	@Override
	public void removePartPropertyListener(IPropertyChangeListener listener) {
		super.removePartPropertyListener(listener);
		textEditorDelegate.removePartPropertyListener(listener);
	}


	/**
	 * @param l
	 * @see org.eclipse.ui.part.WorkbenchPart#removePropertyListener(org.eclipse.ui.IPropertyListener)
	 */
	@Override
	public void removePropertyListener(IPropertyListener l) {
		super.removePropertyListener(l);
		textEditorDelegate.removePropertyListener(l);
	}


	/**
	 * @param listener
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#removeRulerContextMenuListener(org.eclipse.jface.action.IMenuListener)
	 */
	public void removeRulerContextMenuListener(IMenuListener listener) {
		textEditorDelegate.removeRulerContextMenuListener(listener);
	}


	/**
	 * 
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#resetHighlightRange()
	 */
	public void resetHighlightRange() {
		textEditorDelegate.resetHighlightRange();
	}


	/**
	 * @param memento
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#restoreState(org.eclipse.ui.IMemento)
	 */
	public void restoreState(IMemento memento) {
		textEditorDelegate.restoreState(memento);
	}


	/**
	 * @param memento
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#saveState(org.eclipse.ui.IMemento)
	 */
	public void saveState(IMemento memento) {
		textEditorDelegate.saveState(memento);
	}


	/**
	 * @param start
	 * @param length
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#selectAndReveal(int, int)
	 */
	public void selectAndReveal(int start, int length) {
		textEditorDelegate.selectAndReveal(start, length);
	}


	/**
	 * @param actionID
	 * @param action
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#setAction(java.lang.String, org.eclipse.jface.action.IAction)
	 */
	public void setAction(String actionID, IAction action) {
		textEditorDelegate.setAction(actionID, action);
	}


	/**
	 * @param actionID
	 * @param activationCharacter
	 * @param activationKeyCode
	 * @param activationStateMask
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#setActionActivationCode(java.lang.String, char, int, int)
	 */
	public void setActionActivationCode(String actionID,
			char activationCharacter, int activationKeyCode,
			int activationStateMask) {
		textEditorDelegate.setActionActivationCode(actionID,
				activationCharacter, activationKeyCode, activationStateMask);
	}


	/**
	 * 
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#setFocus()
	 */
	@Override
	public void setFocus() {
		if(getModelEditor().isInitialized()) {
			super.setFocus();
		}
		//TODO check if both calles are necessary
		textEditorDelegate.setFocus();
	}


	/**
	 * @param offset
	 * @param length
	 * @param moveCursor
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#setHighlightRange(int, int, boolean)
	 */
	public void setHighlightRange(int offset, int length, boolean moveCursor) {
		textEditorDelegate.setHighlightRange(offset, length, moveCursor);
	}


	/**
	 * @param cfig
	 * @param propertyName
	 * @param data
	 * @see org.eclipse.ui.part.EditorPart#setInitializationData(org.eclipse.core.runtime.IConfigurationElement, java.lang.String, java.lang.Object)
	 */
	@Override
	public void setInitializationData(IConfigurationElement cfig,
			String propertyName, Object data) {
		textEditorDelegate.setInitializationData(cfig, propertyName, data);
	}


	/**
	 * @param input
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#setInput(org.eclipse.ui.IEditorInput)
	 */
	@Override
	public final void setInput(IEditorInput input) {
		super.setInput(input);
		textEditorDelegate.setInput(input);
	}


	/**
	 * @param newMode
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#setInsertMode(org.eclipse.ui.texteditor.ITextEditorExtension3.InsertMode)
	 */
	public void setInsertMode(InsertMode newMode) {
		textEditorDelegate.setInsertMode(newMode);
	}


	/**
	 * @param key
	 * @param value
	 * @see org.eclipse.ui.part.WorkbenchPart#setPartProperty(java.lang.String, java.lang.String)
	 */
	@Override
	public void setPartProperty(String key, String value) {
		textEditorDelegate.setPartProperty(key, value);
	}


	/**
	 * @param field
	 * @param category
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#setStatusField(org.eclipse.ui.texteditor.IStatusField, java.lang.String)
	 */
	public void setStatusField(IStatusField field, String category) {
		textEditorDelegate.setStatusField(field, category);
	}


	@Override
	protected void setPartName(String partName) {
		textEditorDelegate.setPartName(partName);
	}

	/**
	 * @param busy
	 * @see org.eclipse.ui.part.WorkbenchPart#showBusy(boolean)
	 */
	@Override
	public void showBusy(boolean busy) {
		textEditorDelegate.showBusy(busy);
	}


	/**
	 * @param show
	 * @see org.eclipse.ui.texteditor.AbstractDecoratedTextEditor#showChangeInformation(boolean)
	 */
	public void showChangeInformation(boolean show) {
		textEditorDelegate.showChangeInformation(show);
	}


	/**
	 * @param showHighlightRangeOnly
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#showHighlightRangeOnly(boolean)
	 */
	public void showHighlightRangeOnly(boolean showHighlightRangeOnly) {
		textEditorDelegate.showHighlightRangeOnly(showHighlightRangeOnly);
	}


	/**
	 * @param info
	 * @param quickDiffProviderId
	 * @see org.eclipse.ui.texteditor.AbstractDecoratedTextEditor#showRevisionInformation(org.eclipse.jface.text.revisions.RevisionInformation, java.lang.String)
	 */
	public void showRevisionInformation(RevisionInformation info,
			String quickDiffProviderId) {
		textEditorDelegate.showRevisionInformation(info, quickDiffProviderId);
	}


	/**
	 * @return
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#showsHighlightRangeOnly()
	 */
	public boolean showsHighlightRangeOnly() {
		return textEditorDelegate.showsHighlightRangeOnly();
	}


	/**
	 * @param input
	 * @see org.eclipse.ui.texteditor.StatusTextEditor#updatePartControl(org.eclipse.ui.IEditorInput)
	 */
	public void updatePartControl(IEditorInput input) {
		textEditorDelegate.updatePartControl(input);
	}


	/**
	 * @return
	 * @see org.eclipse.ui.texteditor.AbstractDecoratedTextEditor#validateEditorInputState()
	 */
	public boolean validateEditorInputState() {
		return textEditorDelegate.validateEditorInputState();
	}

	/**
	 * @return
	 * @see com.sap.ide.cts.editor.TextEditorDelegate#getSourceViewerPublic()
	 */
	public ISourceViewer getSourceViewerPublic() {
		return textEditorDelegate.getSourceViewerPublic();
	}

	/**
	 * empty default implementation.
	 * 
	 * @param input
	 * @throws CoreException
	 * @see com.sap.ide.cts.editor.TextEditorDelegate#doSetInputPublic(org.eclipse.ui.IEditorInput)
	 */
	public void doSetInputPublic(IEditorInput input) throws CoreException {
	}

	/**
	 * @param message
	 * @see com.sap.ide.cts.editor.TextEditorDelegate#setStatusLineErrorMessage(java.lang.String)
	 */
	public void setStatusLineErrorMessage(String message) {
		textEditorDelegate.setStatusLineErrorMessage(message);
	}

	/**
	 * @param message
	 * @see com.sap.ide.cts.editor.TextEditorDelegate#setStatusLineMessage(java.lang.String)
	 */
	public void setStatusLineMessage(String message) {
		textEditorDelegate.setStatusLineMessage(message);
	}

}
