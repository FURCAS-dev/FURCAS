package com.sap.ide.cts.editor.folding;

import org.eclipse.jdt.core.IElementChangedListener;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.text.folding.IJavaFoldingStructureProvider;
import org.eclipse.jface.text.source.projection.IProjectionListener;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.ui.texteditor.ITextEditor;

import com.sap.furcas.ide.editor.AbstractGrammarBasedEditor;


public class CtsFoldingStructureProvider implements IJavaFoldingStructureProvider {
	
	private ITextEditor fEditor;
	private ProjectionViewer fViewer;
	private IElementChangedListener fElementListener;
	   
    @Override
	public void initialize() {
		if (!isInstalled()) return;
	}
	@Override
	public void install(ITextEditor editor, ProjectionViewer viewer) {
		if (editor instanceof AbstractGrammarBasedEditor) {
            fEditor = editor;
            fViewer = viewer;
            fViewer.addProjectionListener((IProjectionListener) this);
        }
	}
	@Override
	public void uninstall() {
		if (isInstalled()) {
            projectionDisabled();
            fViewer.removeProjectionListener((IProjectionListener) this);
            fViewer = null;
            fEditor = null;
        }
	}
	 public void projectionDisabled() {
	       
	        if (fElementListener != null) {
	            JavaCore.removeElementChangedListener(fElementListener);
	            fElementListener = null;
	        }
	    }
	protected boolean isInstalled() {
        return fEditor != null;
    }
}
