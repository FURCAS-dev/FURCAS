/**
 * 
 */
package com.sap.furcas.modeladaptation.emf;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.modeladaptation.emf.adaptation.EMFModelAdapter;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;

/**
 * Helper class. Makes it easier to call several model adapter methods.
 */
public class TestableEMFModelAdapter extends EMFModelAdapter {

    public TestableEMFModelAdapter(EPackage root, ResourceSet ResourceSet, Set<URI> referenceScope) {
        super(root, ResourceSet, referenceScope);
    }

    public Object createElement(String string) throws ModelAdapterException {
        List<String> typeName = Arrays.asList(string.split("::"));
        return super.createElement(typeName);
    }
    
    public Object getMetaType(String typeString) throws ModelAdapterException {
        List<String> typeName = Arrays.asList(typeString.split("::"));
        return super.getMetaType(typeName);
    }
    
    public Object createEnumLiteral(String string, String string2) throws ModelAdapterException {
        List<String> typeName = Arrays.asList(string.split("::"));
        return super.createEnumLiteral(typeName, string2);
    }

    public Collection<?> getElementsOfType(String string) throws ModelAdapterException {
        List<String> typeName = Arrays.asList(string.split("::"));
        return super.getElementsOfType(typeName);
    }

}
