package com.sap.furcas.ide.editor.document;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

public class ModelEditorInput implements IEditorInput {

    
    private final EObject eObject;
    private IProject project;


    public ModelEditorInput(EObject eObject) {
        super();
        this.eObject = eObject;
    }

    @Override
    public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
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
        if(nameFeat != null && eObject.eGet(nameFeat) != null) {
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
        String uri = EcoreUtil.getURI(eObject).toString();
        return uri != null ? uri : getName();
    }

    public EObject getEObject() {
        return eObject;
    }

    public void setProject(IProject proj) {
        this.project = proj;
    }


    public IProject getProject() {
        return project;
    }
}
