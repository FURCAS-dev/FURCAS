package com.sap.furcas.ide.editor.document;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;

import com.sap.furcas.ide.editor.imp.AbstractFurcasEditor;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;

/**
 * {@link IEditorInput} as used by the {@link AbstractFurcasEditor}.
 * It inherits from {@link FileEditorInput} to be compatible with the
 * IMP editor base class. 
 * 
 * @author Stephan Erb
 *
 */
public class ModelEditorInput extends FileEditorInput {

    private final EObject rootObject;
    private final TextBlock rootBlock;
    
    public ModelEditorInput(IFile file, EObject rootObject, TextBlock rootBlock) {
        super(file);
        this.rootObject = rootObject;
        this.rootBlock = rootBlock;
    }

    @Override
    public String getName() {
        EStructuralFeature nameFeat = rootObject.eClass().getEStructuralFeature("name");
        if(nameFeat != null && rootObject.eGet(nameFeat) != null) {
            return (String) rootObject.eGet(nameFeat);
        } else if(EcoreUtil.getID(rootObject) != null) {
            return EcoreUtil.getID(rootObject);
        } else {
            return rootObject.toString();
        }
    }

    @Override
    public String getToolTipText() {
        String uri = EcoreUtil.getURI(rootObject).toString();
        return uri != null ? uri : getName();
    }

    public EObject getRootObject() {
        return rootObject;
    }
    
    public TextBlock getRootBlock() {
        return rootBlock;
    }

}
