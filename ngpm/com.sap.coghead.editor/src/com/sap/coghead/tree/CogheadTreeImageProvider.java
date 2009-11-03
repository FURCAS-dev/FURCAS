package com.sap.coghead.tree;

import org.eclipse.jface.resource.ImageDescriptor;

import com.sap.coghead.editor.Activator;
import com.sap.ide.treeprovider.ImageProvider;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class CogheadTreeImageProvider implements ImageProvider {

    @Override
    public ImageDescriptor getImageDescriptor(MofClass clazz) {
	return Activator.getImageDescriptor(clazz);
    }
    
    @Override
    public ImageDescriptor getImageDescriptor(RefObject element) {
	return null;
    }

}
