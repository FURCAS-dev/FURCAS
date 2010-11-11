package com.sap.ap.cts.refactoring.adaptation;

import org.eclipse.core.runtime.IAdapterFactory;

import com.sap.ap.cts.refactoring.model.AssociationEndMovableElementAdapter;
import com.sap.ap.cts.refactoring.model.MovableElementAdapter;
import com.sap.ap.cts.refactoring.model.NamedElementAdapter;
import com.sap.ide.refactoring.model.move.MovableElement;
import com.sap.ide.refactoring.model.rename.NamedElement;

import data.classes.AssociationEnd;

/**
 * Adapter factory used to adapt runlet classes to the refactoring model
 * ({@link com.sap.ide.refactoring.model.RefactoringModelElement}.
 * 
 * This allows to re-use the existing, generic refactorings for runlet.
 * 
 * @author Stephan Erb (d049157)
 *
 */
@SuppressWarnings("rawtypes")
public class RefactoringModelAdapterFactory implements IAdapterFactory {

    public RefactoringModelAdapterFactory() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object getAdapter(Object adaptableObject, Class adapterType) {
	Object result;
	
	result = handleMove(adaptableObject, adapterType);
	if (result != null) {
	    return result;
	}
	
	result = handleRename(adaptableObject, adapterType);
	if (result != null) {
	    return result;
	}
	
	return null;
    }

    private Object handleRename(Object adaptableObject, Class adapterType) {
	if (adapterType.equals(NamedElement.class) && adaptableObject instanceof modelmanagement.NamedElement) {
	    return new NamedElementAdapter((modelmanagement.NamedElement) adaptableObject);
	}
	return null;
    }

    private Object handleMove(Object adaptableObject, Class adapterType) {	
	// special handling for associationEnds
	if (adapterType.equals(MovableElement.class) && adaptableObject instanceof AssociationEnd) {
	    return new AssociationEndMovableElementAdapter((AssociationEnd) adaptableObject);
	}
	// handle everything that has a composite parent
	if (adapterType.equals(MovableElement.class) && adaptableObject instanceof RefObject && 
		((RefObject) adaptableObject).refImmediateComposite() != null) {
	    return new MovableElementAdapter((RefObject) adaptableObject);
	}
	return null;
    }

    @Override
    public Class[] getAdapterList() {
	return new Class[] { MovableElement.class, NamedElement.class };
    }


}
