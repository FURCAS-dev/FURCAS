package com.sap.ide.cts.editor.action;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.PartInitException;

import com.sap.furcas.metamodel.textblocks.AbstractToken;
import com.sap.ide.cts.editor.document.CtsDocument;

public class GotoDeclarationAction implements Listener {
	

	private static final int F3_KEY_CODE = 16777228;
	private SourceViewer textViewer;
	
	

	public GotoDeclarationAction(SourceViewer textViewer) {
		super();
		this.textViewer = textViewer;
	}



	public void handleEvent(Event event) {
        	if (event.keyCode == F3_KEY_CODE) {
        	    AbstractToken token = ((CtsDocument) textViewer.getDocument())
        		    .getTextBlocksModelStore().getFloorToken(
        			    textViewer.getSelectedRange().x);
        	    Collection<EObject> referencedElement = token
        		    .getReferencedElements();
        	    //TODO: Currently there are 4 different possibilities to navigate to,
        	    //which have the following priorities:
        	    //1) referenced element of token
        	    //2) corresponding element of token
        	    //3) referenced element of block
        	    //4) corresponding element of block
        	    //These priorities might be discussable
        	    if (referencedElement.size() > 0) {
        		try {
        		    ModelManagerUI.getEditorManager().openEditor(
        			    referencedElement.iterator().next());
        		} catch (PartInitException e) {
        		    // TODO Auto-generated catch block
        		    e.printStackTrace();
        		}
        	    } else if (token.getCorrespondingModelElements().size() > 0) {
        		if (referencedElement.size() > 0) {
        		    try {
        			ModelManagerUI.getEditorManager().openEditor(
        				token.getCorrespondingModelElements()
        					.iterator().next());
        		    } catch (PartInitException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		    }
        		}
        	    } else if (token.getParent().getReferencedElements().size() > 0) {
        		try {
        		    ModelManagerUI.getEditorManager().openEditor(
        			    token.getParent().getReferencedElements()
        				    .iterator().next());
        		} catch (PartInitException e) {
        		    // TODO Auto-generated catch block
        		    e.printStackTrace();
        		}
        	    } else if (token.getParent().getCorrespondingModelElements().size() > 0) {
        		try {
        		    ModelManagerUI.getEditorManager().openEditor(
        			    token.getParent().getCorrespondingModelElements()
        				    .iterator().next());
        		} catch (PartInitException e) {
        		    // TODO Auto-generated catch block
        		    e.printStackTrace();
        		}
        	    }
        
        	}
	}

}
