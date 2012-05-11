/**
 * 
 */
package com.sap.furcas.modeladaptation.emf;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;

import com.sap.furcas.modeladaptation.emf.adaptation.EMFModelAdapter;
import com.sap.furcas.modeladaptation.emf.lookup.QueryBasedEcoreMetaModelLookUp;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.util.TCSSpecificOCLEvaluator;
import com.sap.furcas.runtime.parser.PartitionAssignmentHandlerBaseImpl;

/**
 * Helper class. Makes it easier to call several model adapter methods.
 */
public class TestableEMFModelAdapter extends EMFModelAdapter {

    public TestableEMFModelAdapter(ResourceSet resourceSet, Resource transientResource, EPackage metamodelPackage) {
        super(resourceSet, new PartitionAssignmentHandlerBaseImpl(transientResource),
                new QueryBasedEcoreMetaModelLookUp(resourceSet, Collections.singleton(URI.createURI(metamodelPackage.getNsURI()))),
                new HashSet<URI>(), new TCSSpecificOCLEvaluator(), DefaultOppositeEndFinder.getInstance());
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

}
