package com.sap.ide.treeprovider;

import org.eclipse.swt.graphics.Image;

import com.sap.ide.treeprovider.internal.Activator;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class ModelElementImageFacade {

    public static Image getImage(RefObject element) {
	return Activator.getImage(element);
    }
    
    public static Image getImage(MofClass clazz) {
	return Activator.getImage(clazz);
    }
}
