package com.sap.mi.tcs.editor.tree;

import org.eclipse.jface.resource.ImageDescriptor;

import com.sap.ide.treeprovider.ImageProvider;
import com.sap.mi.tcs.editor.Activator;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class TcsTreeImageProvider implements ImageProvider {

    @Override
    public ImageDescriptor getImageDescriptor(MofClass clazz) {
	return Activator.getImageDescriptor(clazz);
    }

    @Override
    public ImageDescriptor getImageDescriptor(RefObject element) {
	return Activator.getImageDescriptor(element);
    }
}
