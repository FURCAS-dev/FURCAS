package com.sap.ap.cts.refactoring.adaptation;

import org.eclipse.core.runtime.IAdapterFactory;

import com.sap.ap.cts.refactoring.model.NamedElementAdapter;
import com.sap.ide.refactoring.core.model.rename.NamedElement;

public class RefactoringModelAdapterFactory implements IAdapterFactory {

    public RefactoringModelAdapterFactory() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object getAdapter(Object adaptableObject, Class adapterType) {
	if (adaptableObject instanceof modelmanagement.NamedElement) {
	    return new NamedElementAdapter((modelmanagement.NamedElement) adaptableObject);
	}

	return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class[] getAdapterList() {
	return new Class[] { NamedElement.class };
    }


}
