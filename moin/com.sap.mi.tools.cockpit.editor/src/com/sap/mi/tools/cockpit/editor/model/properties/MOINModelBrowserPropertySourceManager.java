package com.sap.mi.tools.cockpit.editor.model.properties;

import java.util.Collection;

import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;

import com.sap.mi.fwk.ui.editor.IModelEditor;
import com.sap.mi.fwk.ui.editor.ModelEditorManager;
import com.sap.mi.tools.cockpit.editor.model.RefObjectNode;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Property provider for {@link RefObject RefObjects}
 * 
 * @author d003456
 * 
 */
public final class MOINModelBrowserPropertySourceManager implements IPropertySourceProvider {
    /**
     * Creates a property manager. It is able to decide on its own, based on the
     * selection, whether the properties are read-only or not.
     */
    public MOINModelBrowserPropertySourceManager() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.views.properties.IPropertySourceProvider#getPropertySource
     * (java.lang.Object)
     */
    public IPropertySource getPropertySource(Object object) {

	if (object instanceof RefObjectNode) {
	    RefObject refObject = ((RefObjectNode) object).getValue();
	    if (refObject != null) {
		Collection<IModelEditor> editors = ModelEditorManager.getInstance().getAllActiveModelEditors(
			((Partitionable) refObject).get___Connection());
		boolean readOnly = !editors.isEmpty();
		return new RefObjectPropertySource(refObject, readOnly);
	    }
	} else if (object instanceof RefObject) {
	    RefObject refObject = (RefObject) object;
	    if (refObject != null) {
		Collection<IModelEditor> editors = ModelEditorManager.getInstance().getAllActiveModelEditors(
			((Partitionable) refObject).get___Connection());
		boolean readOnly = !editors.isEmpty();
		return new RefObjectPropertySource(refObject, readOnly);
	    }
	} else if (object instanceof MultiValuedAttributePropertySource) {
	    return (IPropertySource) object;
	}
	return null;
    }

}