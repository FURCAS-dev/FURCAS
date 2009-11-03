package com.sap.ide.treeprovider;

import org.eclipse.jface.resource.ImageDescriptor;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public interface ImageProvider {
    
    /**
     * Return <tt>null</tt> if you don't know this type of node or the type of element
     * contained in the node. The caller then will keep looking for extensions that do
     * know how to handle this.
     */
    ImageDescriptor getImageDescriptor(MofClass clazz);
    
    /**
     * Return <tt>null</tt> no special image is supported for this element. Otherwise,
     * return an image descriptor.
     */
    ImageDescriptor getImageDescriptor(RefObject element);
}
