package com.sap.furcas.test.testutils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.sap.furcas.metamodel.FURCAS.FURCASPackage;

public class ScopeHelper {
    
    public static Set<URI> createReferenceScope() {
        Set<URI> referenceScope = Collections.emptySet();
        return referenceScope;
    }

    public static ResourceSet createResourceSet() {
        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getPackageRegistry().put(FURCASPackage.eNS_URI, FURCASPackage.eINSTANCE);
        resourceSet.getPackageRegistry().put(FURCASPackage.eNAME, FURCASPackage.eINSTANCE);
        return resourceSet;
    }

    public static Set<URI> createFURCASReferenceScope() {
        Set<URI> referenceScope = new HashSet<URI>();
        
        EPackage rootPackage = FURCASPackage.eINSTANCE;
        
        referenceScope.add(URI.createURI(rootPackage.eClass().getEPackage().getNsURI()));
        referenceScope.add(URI.createURI(rootPackage.getNsURI()));
        return referenceScope;
    }
}
