package com.sap.furcas.ide.editor.document;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.imp.editor.UniversalEditor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPathEditorInput;

import com.sap.furcas.ide.editor.imp.AbstractFurcasEditor;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;

/**
 * Provider for an {@link IEditorInput} which represents the currently 
 * edited document. It used by the {@link AbstractFurcasEditor}.<p>
 * 
 * Mind that the {@link UniversalEditor} does only work on the light
 * weight representation of the editor input.
 * 
 * @author Stephan Erb
 *
 */
public class ModelEditorInput {
    
    /**
     * A light-weight editor input which does only store an URI but
     * no full blown objects. For the reasons behind this decissions
     * see {@link IEditorInput}
     */
    public static class ModelURIEditorInput extends URIEditorInput implements IPathEditorInput {

        public ModelURIEditorInput(URI uri) {
            super(uri);
        }

        public ModelURIEditorInput(URI uri, String name) {
            super(uri, name);
        }

        public ModelURIEditorInput(IMemento memento) {
            super(memento);
        }
        
        @Override
        public IPath getPath() {
           return new Path(getURI().trimFragment().toPlatformString(true));
        }
        
    }

    /**
     * Set empty after first usage. Prevents memory leak when the root elements are replaced through
     * editing actions..
     */
    private boolean consumed = false;
    private final EObject rootObject;
    private TextBlock rootBlock;
    private final ModelURIEditorInput editorInput;
    
    public ModelEditorInput(EObject rootObject, TextBlock rootBlock) {
        this.rootObject = rootObject;
        this.rootBlock = rootBlock;
        
        // only depend on the rootObject here. The rootBlock is not stable
        // and will be recreated all the time during parsing
        editorInput = new ModelURIEditorInput(EcoreUtil.getURI(rootObject), getName());
    }
    
    public void consume() {
        consumed  = true;
    }

    /**
     * Will never be null
     */
    public EObject getRootObject() {
        Assert.isLegal(!consumed, "Editor input no longer valid");
        return rootObject;
    }
    
    /**
     * May be null
     */
    public TextBlock getRootBlock() {
        Assert.isLegal(!consumed, "Editor input no longer valid");
        return rootBlock;
    }
    
    public void setRootBlock(TextBlock rootBlock) {
        this.rootBlock = rootBlock;
    }
    
    public IPathEditorInput asLightWeightEditorInput() {
        return editorInput;
    }
    
    private String getName() {
        EStructuralFeature nameFeat = rootObject.eClass().getEStructuralFeature("name");
        if (nameFeat != null && rootObject.eGet(nameFeat) != null) {
            return (String) rootObject.eGet(nameFeat);
        } else if (EcoreUtil.getID(rootObject) != null) {
            return EcoreUtil.getID(rootObject);
        } else {
            return rootObject.toString();
        }
    }
    
}
