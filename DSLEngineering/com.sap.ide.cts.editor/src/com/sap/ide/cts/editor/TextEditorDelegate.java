package com.sap.ide.cts.editor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.IAnnotationAccess;
import org.eclipse.jface.text.source.ISharedTextColors;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.IVerticalRulerColumn;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.ui.texteditor.SourceViewerDecorationSupport;

import com.sap.ide.cts.editor.document.CtsHistoryDocumentProvider;

public class TextEditorDelegate extends TextEditor {
	
	public TextEditorDelegate(ModelBasedTextEditor delegator) {
		this.delegtor = delegator;
	}
	/**
	 * Used for callback methods;
	 */
	private ModelBasedTextEditor delegtor;

//	/* (non-Javadoc)
//	 * @see org.eclipse.ui.texteditor.AbstractDecoratedTextEditor#createAnnotationRulerColumn(org.eclipse.jface.text.source.CompositeRuler)
//	 */
//	@Override
//	protected IVerticalRulerColumn createAnnotationRulerColumn(
//			CompositeRuler ruler) {
//		return delegtor.createAnnotationRulerColumn(ruler);
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
    
        public void setPreferenceStore(IPreferenceStore store) {
    
    		super.setPreferenceStore(store);
        }
    
        public IPreferenceStore getPreferenceStor() {
    
            return super.getPreferenceStore();
        }
        
        public ISharedTextColors getSharedColors() {
            return super.getSharedColors();
        }
        public ISourceViewer getSourceView() {
            return super.getSourceViewer();
        }
             
    
        @Override
        protected void configureSourceViewerDecorationSupport(
    	    SourceViewerDecorationSupport support) {
    		delegtor.configureSourceViewerDecorationSupport(support);
    		super.configureSourceViewerDecorationSupport(support);
        }
	
	public ISourceViewer getSourceViewerPublic() {
		return getSourceViewer();
	}

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
		delegtor.doSetInputPublic(input);
	}
	
	public IVerticalRulerColumn createAnnotationRulerColumn(CompositeRuler ruler) {
		return super.createAnnotationRulerColumn(ruler);
	}
	
	public SourceViewerDecorationSupport getSourceViewerDecorationSupport(ISourceViewer viewer) {
		return super.getSourceViewerDecorationSupport(viewer);
	}
	
	/* 
	 * This is overridden because the Savable that is is used to perform the save action can only be created by the
	 * TextEditor. This way the delegator also gets informed about the save. 
	 * (non-Javadoc)
	 * @see org.eclipse.ui.texteditor.AbstractTextEditor#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		delegtor.doSave(progressMonitor);
		super.doSave(progressMonitor);
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
	protected void setDocumentProvider(IEditorInput input) {
		//if(input instanceof ModelEditorInput) {
			setDocumentProvider(new CtsHistoryDocumentProvider(
				new FurcasDocumentSetupParticpant()));
		//}
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
//			delegtor.doSave(monitor);
//			super.doSave(monitor);
//		}
//
//		@Override
//		public boolean isDirty() {
//			return delegtor.isDirty();
//		}
//	}
}
