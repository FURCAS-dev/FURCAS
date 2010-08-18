package com.sap.runlet.testmetamodel.editor;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;

import com.sap.ide.treeprovider.ImageProvider;

public class RunletTreeImageProvider implements ImageProvider {

    @Override
    public ImageDescriptor getImageDescriptor(EClass clazz) {
	return Activator.getImageDescriptor(clazz);
    }

    @Override
    public ImageDescriptor getImageDescriptor(EObject element) {
	return null;
    }

}
