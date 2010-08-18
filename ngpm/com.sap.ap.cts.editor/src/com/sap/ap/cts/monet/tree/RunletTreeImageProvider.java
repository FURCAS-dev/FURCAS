package com.sap.ap.cts.monet.tree;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;

import com.sap.ap.cts.editor.Activator;
import com.sap.ide.treeprovider.ImageProvider;

public class RunletTreeImageProvider implements ImageProvider {

    @Override
    public ImageDescriptor getImageDescriptor(EClass clazz) {
	return Activator.getImageDescriptor(clazz);
    }

    @Override
    public ImageDescriptor getImageDescriptor(EObject element) {
	return Activator.getImageDescriptor(element);
    }
}
