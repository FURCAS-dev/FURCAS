package com.sap.furcas.modeladaptation.emf.lookup;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;

/**
 * Implementation of {@link IMetaModelLookup} allowing clients to inspect ecore metamodel
 * files. 
 * 
 * @author Stephan Erb (d049157)
 */
public class FileBasedEcoreMetaModelLookUp extends QueryBasedEcoreMetaModelLookUp {

    public FileBasedEcoreMetaModelLookUp(File... fileArr) throws MetaModelLookupException {
        super(loadResourceSet(fileArr));
    }

    private static ResourceSet loadResourceSet(File... fileArr) throws MetaModelLookupException {
        ResourceSet resourceSet = new ResourceSetImpl();
        
        for (File file : fileArr) {
            java.net.URI uri = file.toURI();
            java.net.URI normUri = uri.normalize();

            loadResourceFromUri(resourceSet, normUri.toString());
        }
        return resourceSet;
    }

    private static void loadResourceFromUri(ResourceSet resourceSet, String uri) throws MetaModelLookupException {
        Resource resource = resourceSet.createResource(URI.createURI(uri));

        try {
            resource.load(null);
        } catch (IOException e) {
            throw new MetaModelLookupException("Unable to parse ecore xmi for file uri " + uri + " : " + e.getMessage(), e);
        }
        EList<EObject> list = resource.getContents();
        for (EObject object : list) {
            if (object instanceof EPackage) {
                EPackage new_package = (EPackage) object;
                EPackage.Registry.INSTANCE.put(uri, new_package);
            }
        }
    }
    
}
