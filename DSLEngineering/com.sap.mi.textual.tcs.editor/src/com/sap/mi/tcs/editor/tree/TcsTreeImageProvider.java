package com.sap.mi.tcs.editor.tree;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;

import com.sap.ide.treeprovider.ImageProvider;


public class TcsTreeImageProvider implements ImageProvider {

    @Override
    public ImageDescriptor getImageDescriptor(EClass clazz) {
	return Activator.getImageDescriptor(clazz);
    }

    @Override
    public ImageDescriptor getImageDescriptor(EObject element) {
	return Activator.getImageDescriptor(element);
    }
}
