package com.sap.furcas.modeladaptation.emf.lookup;

import java.io.File;

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
        super(FileResourceHelper.loadResourceSet(fileArr));
    }
    
}
