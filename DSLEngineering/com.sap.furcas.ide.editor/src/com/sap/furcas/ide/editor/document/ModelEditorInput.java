package com.sap.furcas.ide.editor.document;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

public class ModelEditorInput implements IEditorInput {

    
    private final EObject eObject;

    public ModelEditorInput(EObject eObject) {
        super();
        this.eObject = eObject;
    }

    @Override
    public Object getAdapter(Class adapter) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean exists() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getName() {
        EStructuralFeature nameFeat = eObject.eClass().getEStructuralFeature("name");
        if(nameFeat != null) {
            return (String) eObject.eGet(nameFeat);
        } else if(EcoreUtil.getID(eObject) != null) {
            return EcoreUtil.getID(eObject);
        } else {
            return eObject.toString();
        }
    }

    @Override
    public IPersistableElement getPersistable() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getToolTipText() {
        // TODO Auto-generated method stub
        return eObject.toString();
    }

    public EObject getEObject() {
        return eObject;
    }

}
