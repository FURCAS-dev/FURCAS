package com.sap.furcas.tcs.editor.editor;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.part.FileEditorInput;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;

public class TCSEditorMatchingStrategy implements IEditorMatchingStrategy {

    /**
     * Only match *.tcs files which are EMF resources and have a {@link ConcreteSyntax}
     * element inside.
     */
    @Override
    public boolean matches(IEditorReference editorRef, IEditorInput input) {
        boolean hasModelContents = false;
        if(input instanceof FileEditorInput) {
            FileEditorInput fileInput = (FileEditorInput) input;
            
            URI modelFileURI = URI.createPlatformResourceURI(fileInput.getFile().getFullPath().toString(), true);
            Resource mappingResource = null;
            try {
                mappingResource = new ResourceSetImpl().getResource(modelFileURI, false);
                for (EObject element : mappingResource.getContents()) {
                    if(element instanceof ConcreteSyntax) {
                        hasModelContents = true;
                    }
                }
            } catch (Exception ex) {
                //load failed, so it seems to be a plain text file
            }
        }
        return hasModelContents;
    }

}
