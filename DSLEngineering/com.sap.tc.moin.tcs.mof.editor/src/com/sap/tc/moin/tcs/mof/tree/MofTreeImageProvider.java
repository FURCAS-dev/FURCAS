package com.sap.tc.moin.tcs.mof.tree;

import org.eclipse.jface.resource.ImageDescriptor;

import com.sap.ide.treeprovider.ImageProvider;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.tcs.mof.editor.Activator;

public class MofTreeImageProvider implements ImageProvider {

    @Override
    public ImageDescriptor getImageDescriptor(MofClass clazz) {
	return Activator.getImageDescriptor(clazz);
    }

    @Override
    public ImageDescriptor getImageDescriptor(RefObject element) {
	return Activator.getImageDescriptor(element);
    }
}
