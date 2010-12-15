package com.sap.furcas.ide.editor;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.IAnnotationAccess;
import org.eclipse.jface.text.source.ISharedTextColors;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.IVerticalRulerColumn;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.INavigationLocationProvider;
import org.eclipse.ui.IPersistableEditor;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IReusableEditor;
import org.eclipse.ui.ISaveablesSource;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorExtension;
import org.eclipse.ui.texteditor.ITextEditorExtension2;
import org.eclipse.ui.texteditor.ITextEditorExtension3;
import org.eclipse.ui.texteditor.ITextEditorExtension4;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;

import com.sap.furcas.ide.editor.document.CtsHistoryDocumentProvider;

public class ModelBasedTextEditor extends TextEditor implements ITextEditor, IReusableEditor, ITextEditorExtension,
	ITextEditorExtension2, ITextEditorExtension3, ITextEditorExtension4, INavigationLocationProvider,
	ISaveablesSource, IPersistableEditor, ISelectionListener {
    
        private AdapterFactoryEditingDomain editingDomain;

//	protected TextEditorDelegate textEditorDelegate;
	private static Collection<IPropertyListener> deferredListenersToAdd = new ArrayList<IPropertyListener>();
	
	
	public ModelBasedTextEditor() {
		deferredListenersToAdd.clear();
	}


	/**
	 * Empty default implementation of
	 * {@link ISelectionListener#selectionChanged(IWorkbenchPart, ISelection)}.
	 */
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
	}

	/* 
	 * This is overridden because the Savable that is is used to perform the save action can only be created by the
	 * TextEditor. This way the delegator also gets informed about the save. 
	 * (non-Javadoc)
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		doSaveAboutToPerform(progressMonitor);
		super.doSave(progressMonitor);
	}
	
	/**
	 * Hook for subclasses that want to take actions before save is performed.
	 * @param monitor
	 */
	public void doSaveAboutToPerform(IProgressMonitor monitor) {
	}

	/**
	 * @return
	 * @see org.eclipse.ui.part.EditorPart#getEditorInput()
	 */
	@Override
	public IEditorInput getEditorInput() {
		return super.getEditorInput();
	}

//	/* (non-Javadoc)
//	 * @see org.eclipse.ui.texteditor.AbstractDecoratedTextEditor#createAnnotationRulerColumn(org.eclipse.jface.text.source.CompositeRuler)
//	 */
//	@Override
//	protected IVerticalRulerColumn createAnnotationRulerColumn(
//			CompositeRuler ruler) {
//		return this.createAnnotationRulerColumn(ruler);
//	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#setSourceViewerConfiguration(org.eclipse.jface.text.source.SourceViewerConfiguration)
	 */
	@Override
	public void setSourceViewerConfiguration(
			SourceViewerConfiguration configuration) {
		// TODO Auto-generated method stub
		super.setSourceViewerConfiguration(configuration);
	}
	
	@Override
        public ISourceViewer createSourceViewer(Composite parent,
    	    IVerticalRuler ruler, int styles) {
	    	fAnnotationAccess= getAnnotationAccess();
		fOverviewRuler= createOverviewRuler(getSharedColors());

		ISourceViewer viewer= new ProjectionViewer(parent, ruler, getOverviewRuler(), isOverviewRulerVisible(), styles);
		// ensure decoration support has been created and configured.
		getSourceViewerDecorationSupport(viewer);

		return viewer;  
        }
    
        @Override
		public void setPreferenceStore(IPreferenceStore store) {
    
    		super.setPreferenceStore(store);
        }
    
        public IPreferenceStore getPreferenceStor() {
    
            return super.getPreferenceStore();
        }
        
        @Override
		public ISharedTextColors getSharedColors() {
            return super.getSharedColors();
        }
        public ISourceViewer getSourceView() {
            return super.getSourceViewer();
        }
             
    
        @Override
        protected void configureSourceViewerDecorationSupport(
    	    SourceViewerDecorationSupport support) {
    		super.configureSourceViewerDecorationSupport(support);
        }
	
	public ISourceViewer getSourceViewerPublic() {
		return getSourceViewer();
	}

	@Override
	public IAnnotationAccess getAnnotationAccess() {
		return super.getAnnotationAccess(); 
	}

	@Override
	public void setPartName(String partName) {
		super.setPartName(partName);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.editors.text.TextEditor#doSetInput(org.eclipse.ui.IEditorInput)
	 */
	@Override
	protected void doSetInput(IEditorInput input) throws CoreException {
		if(input != null && input.equals(getEditorInput())) {
			//we're in the deferred init phase
			//input was already set, so return.
			return;
		}
		super.doSetInput(input);
//		doSetInputPublic(input);
	}
	
	@Override
	public IVerticalRulerColumn createAnnotationRulerColumn(CompositeRuler ruler) {
		return super.createAnnotationRulerColumn(ruler);
	}
	
	@Override
	public SourceViewerDecorationSupport getSourceViewerDecorationSupport(ISourceViewer viewer) {
		return super.getSourceViewerDecorationSupport(viewer);
	}


	/* (non-Javadoc)
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#setStatusLineErrorMessage(java.lang.String)
	 */
	@Override
	public void setStatusLineErrorMessage(String message) {
		// TODO Auto-generated method stub
		super.setStatusLineErrorMessage(message);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#setStatusLineMessage(java.lang.String)
	 */
	@Override
	public void setStatusLineMessage(String message) {
		// TODO Auto-generated method stub
		super.setStatusLineMessage(message);
	}
	
    /**
     * Sets the part site.
     * <p>
     * Subclasses must invoke this method from <code>IEditorPart.init</code>
     * and <code>IViewPart.init</code>.
     *
     * @param site the workbench part site
     */
    public void setSitePublic(IWorkbenchPartSite site) {
        setSite(site);
    }

    /**
	 * Overrides the hook method from {@link AbstractTextEditor} 
	 * for setting the document provider for the given input.
	 *
	 * @param input the input of this editor.
	 */
	@Override
	protected void setDocumentProvider(IEditorInput input) {
		//if(input instanceof ModelEditorInput) {
			setDocumentProvider(new CtsHistoryDocumentProvider(
				new FurcasDocumentSetupParticpant(), getEditingDomain()));
		//}
	}


    public void setEditingDomain(AdapterFactoryEditingDomain editingDomain) {
        this.editingDomain = editingDomain;
    }


    public AdapterFactoryEditingDomain getEditingDomain() {
        return editingDomain;
    }
	
//	public class ModelBasedTextEditorSavable extends TextEditorSavable {
//
//		private final ModelBasedTextEditorDelegator modelBasedTextEditorDelegator;
//
//		public ModelBasedTextEditorSavable(
//				ModelBasedTextEditorDelegator modelBasedTextEditorDelegator, Saveable[] saveables) {
//			super(modelBasedTextEditorDelegator.textEditorDelegate);
//			this.modelBasedTextEditorDelegator = modelBasedTextEditorDelegator;
//		}
//
//		/*
//		 * @see org.eclipse.ui.Saveable#doSave(org.eclipse.core.runtime.IProgressMonitor)
//		 * @since 3.3
//		 */
//		@Override
//		public void doSave(IProgressMonitor monitor) throws CoreException {
//			modelBasedTextEditorDelegator.getWorkingConnection().getCommandStack().openGroup(groupDescription)
//			this.doSave(monitor);
//			super.doSave(monitor);
//		}
//
//		@Override
//		public boolean isDirty() {
//			return this.isDirty();
//		}
//	}

}
