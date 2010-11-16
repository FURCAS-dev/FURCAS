package com.sap.furcas.parser.tcs.bootstrap;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.sap.furcas.metamodel.FURCAS.FURCASPackage;

public class BootstrapHelper {
    
    public static Set<URI> createReferenceScope() {
        Set<URI> referenceScope = new HashSet<URI>();
        EPackage rootPackage = FURCASPackage.eINSTANCE;
        referenceScope.add(URI.createURI(rootPackage.getNsURI()));
        referenceScope.add(URI.createURI(rootPackage.eClass().getEPackage().getNsURI()));
        return referenceScope;
    }

    public static ResourceSet createResourceSet() {
        ResourceSet resourceSet = new ResourceSetImpl();
        return resourceSet;
    }
}
