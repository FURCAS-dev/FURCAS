package com.sap.furcas.ide.editor.document;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.part.FileEditorInput;

public class ModelEditorInput extends FileEditorInput {

    private final EObject eObject;

    public ModelEditorInput(IFile file, EObject eObject) {
        super(file);
        this.eObject = eObject;
    }

    @Override
    public String getName() {
        EStructuralFeature nameFeat = eObject.eClass().getEStructuralFeature("name");
        if(nameFeat != null && eObject.eGet(nameFeat) != null) {
            return (String) eObject.eGet(nameFeat);
        } else if(EcoreUtil.getID(eObject) != null) {
            return EcoreUtil.getID(eObject);
        } else {
            return eObject.toString();
        }
    }

    @Override
    public String getToolTipText() {
        String uri = EcoreUtil.getURI(eObject).toString();
        return uri != null ? uri : getName();
    }

    public EObject getEObject() {
        return eObject;
    }

}
