/**
 * 
 */
package com.sap.furcas.modeladaptation.emf;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;

/**
 * helper class to help with changing method signatures
 */
public class EMFModelAdapterTestAdapter extends EMFModelAdapter {



    public EMFModelAdapterTestAdapter(EPackage root, ResourceSet ResourceSet, Set<URI> referenceScope) {
        super(root, ResourceSet, referenceScope);
    }

    /**
     * @param string
     * @return
     */
    public Object createElement(String string) throws ModelAdapterException {
        
        List<String> typeName = Arrays.asList(string.split("::"));
        return super.createElement(typeName);
    }

    /**
     * @param string
     * @param string2
     * @return 
     * @throws ModelAdapterException 
     */
    public Object createEnumLiteral(String string, String string2) throws ModelAdapterException {
        List<String> typeName = Arrays.asList(string.split("::"));
        return super.createEnumLiteral(typeName, string2);
        
    }

}
