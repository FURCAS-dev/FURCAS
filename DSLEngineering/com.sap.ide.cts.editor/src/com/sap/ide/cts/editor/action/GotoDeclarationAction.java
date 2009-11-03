package com.sap.ide.cts.editor.action;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.PartInitException;

import textblocks.AbstractToken;

import com.sap.ide.cts.editor.document.CtsDocument;
import com.sap.mi.fwk.ui.ModelManagerUI;

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
        	    Collection<RefObject> referencedElement = token
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
        	    } else if (token.getParentBlock().getReferencedElements().size() > 0) {
        		try {
        		    ModelManagerUI.getEditorManager().openEditor(
        			    token.getParentBlock().getReferencedElements()
        				    .iterator().next());
        		} catch (PartInitException e) {
        		    // TODO Auto-generated catch block
        		    e.printStackTrace();
        		}
        	    } else if (token.getParentBlock().getCorrespondingModelElements().size() > 0) {
        		try {
        		    ModelManagerUI.getEditorManager().openEditor(
        			    token.getParentBlock().getCorrespondingModelElements()
        				    .iterator().next());
        		} catch (PartInitException e) {
        		    // TODO Auto-generated catch block
        		    e.printStackTrace();
        		}
        	    }
        
        	}
	}

}
