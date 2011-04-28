package com.sap.furcas.test.testutils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.sap.furcas.metamodel.FURCAS.FURCASPackage;

public class ResourceTestHelper {
    
    public static Set<URI> createEcoreReferenceScope() {
        Set<URI> referenceScope = new HashSet<URI>();
        referenceScope.add(URI.createURI(EcorePackage.eINSTANCE.getNsURI()));
        return referenceScope;
    }

    public static ResourceSet createResourceSet() {
        ResourceSet resourceSet = new ResourceSetImpl();
        return resourceSet;
    }

    public static Set<URI> createFURCASReferenceScope() {
        Set<URI> referenceScope = new HashSet<URI>();
        referenceScope.add(URI.createURI(FURCASPackage.eINSTANCE.getNsURI()));
        return referenceScope;
    }
    
    public static Resource createTransientResource(ResourceSet resourceSet) {
        File tempFile = null;
        try {
            tempFile = File.createTempFile("temporaryTestResource", "xmi");
            tempFile.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Unable to create transient resource");
        }
        return resourceSet.createResource(URI.createFileURI(tempFile.getAbsolutePath())); 
    }
}
