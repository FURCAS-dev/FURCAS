package com.sap.furcas.modeladaptation.emf.lookup;

import java.io.File;

import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.util.FileResourceHelper;

/**
 * Implementation of {@link IMetaModelLookup} allowing clients to inspect ecore metamodel
 * files. 
 * 
 * @author Stephan Erb (d049157)
 */
public class FileBasedEcoreMetaModelLookUp extends QueryBasedEcoreMetaModelLookUp {

    public FileBasedEcoreMetaModelLookUp(File... fileArr) throws MetaModelLookupException {
        this(FileResourceHelper.loadResourceSet(fileArr));
    }
    
    public FileBasedEcoreMetaModelLookUp(ResourceSet resourceSet) {
        super(resourceSet, FileResourceHelper.getResourceSetAsScope(resourceSet));
    }
    
}
