package com.sap.ide.refactoring.model;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;

import com.sap.ide.refactoring.model.rename.NamedElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class RefactoringModelUtil {

    @SuppressWarnings("unchecked")
    public static <T> T adaptObject(Object object, Class<T> targetType) {
	//FIXME: Change the implementation back to use {@link ModelAdapterUI} once we have found
	// a solution to properly enforce loading of the bundles we need.
	if (object == null) {
		return null;
	} else if (targetType.isInstance(object)) {
		return (T) object; // runtime-checked cast
	}

	Object adapter;
	if (object instanceof IAdaptable) {
		adapter = ((IAdaptable) object).getAdapter(targetType);
	} else {
	    	// forces bundle load
		adapter = Platform.getAdapterManager().loadAdapter(object, targetType.getCanonicalName());
	}
	return adaptObject(adapter, targetType);
    }

    public static String getModelElementName(RefObject modelElement) {
	if (modelElement == null) {
	    return "null";
	}
	if (!modelElement.is___Alive()) {
	    return "<deleted>";
	}
	try {
	    NamedElement element = RefactoringModelUtil.adaptObject(modelElement, NamedElement.class);
	    if (element == null) {
		return (String) modelElement.refGetValue("name");
	    } else {
		return element.getName();
	    }
	} catch (Exception e) {
	    // has no human readable name; atleast none we know
	    return modelElement.get___Mri().toString();
	}
    }

    public static String getModelElementType(RefObject modelElement) {
	if (modelElement == null) {
	    return "null";
	}
	if (!modelElement.is___Alive()) {
	    return "<deleted>";
	}
	return ((MofClass) modelElement.refMetaObject()).getName();
    }
    
    public static String getModelElementNameAndType(RefObject modelelement) {
	return getModelElementName(modelelement) + " (" + RefactoringModelUtil.getModelElementType(modelelement)+ ")";
    }

}
