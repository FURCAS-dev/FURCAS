package com.sap.furcas.parsergenerator.emf.lookup;

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

public class FileBasedEcoreMetaModelLookUp extends QueryBasedEcoreMetaModelLookUp {

    /**
     * 
     * @param rootEcoreFile
     * @param dataTypeEcoreFile
     * @throws IOException
     */
    public FileBasedEcoreMetaModelLookUp(File... fileArr) throws MetaModelLookupException {
        super(loadResourceSet(fileArr));
    }

    private static ResourceSet loadResourceSet(File... fileArr) throws MetaModelLookupException {
        ResourceSet resourceSet = new ResourceSetImpl();
        
        // In this case DataTypes are usually in a separate file, need to load that one as well
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
        // Load Datatypes

        EList<EObject> list = resource.getContents();
        for (EObject object : list) {
            if (object instanceof EPackage) {
                EPackage new_package = (EPackage) object;
                EPackage.Registry.INSTANCE.put(uri, new_package);
            }
        }
    }
    
}
