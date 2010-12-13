package com.sap.furcas.test.testutils;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sap.furcas.metamodel.FURCAS.FURCASPackage;

public class ResourceTestHelper {
    
    public static Set<URI> createEcoreReferenceScope() {
        Set<URI> referenceScope = new HashSet<URI>();
        referenceScope.add(URI.createURI(FURCASPackage.eINSTANCE.eClass().getEPackage().getNsURI()));
        return referenceScope;
    }

    public static ResourceSet createResourceSet() {
        ResourceSet resourceSet = new ResourceSetImpl();
        return resourceSet;
    }

    public static Set<URI> createFURCASReferenceScope() {
        Set<URI> referenceScope = new HashSet<URI>();
        referenceScope.add(URI.createURI(FURCASPackage.eINSTANCE.getNsURI()));
        referenceScope.add(URI.createURI(FURCASPackage.eINSTANCE.eClass().getEPackage().getNsURI()));
        return referenceScope;
    }
    
    public static Resource createTransientResource(ResourceSet resourceSet) {
        return resourceSet.createResource(URI.createURI("TransientResourceForTests/" 
                + EcoreUtil.generateUUID()));
    }
}
