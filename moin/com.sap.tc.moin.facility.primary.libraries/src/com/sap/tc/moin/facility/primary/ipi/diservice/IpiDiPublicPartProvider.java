package com.sap.tc.moin.facility.primary.ipi.diservice;

import java.io.File;

public interface IpiDiPublicPartProvider {

    enum Purpose {
        COMPILATION, ASSEMBLY, INFRASTRUCTURE
    };

    // Entity types which are supported by MOIN:
    // todo: later the set of entity types is extended (e.g. Model Folder, ...)
    final String MOIN_FOLDER_TREE_ENTITY_TYPE = "Model Folder Tree"; //$NON-NLS-1$

    final String META_MODEL_FOLDER_TREE_ENTITY_TYPE = "Metamodel Folder Tree"; //$NON-NLS-1$

    // Path convention: 
    // Sub-folder of the archive-folder of a MOIN-relevant public part which contains the public part zips 
    final String MOIN_PP_ARCHIVE_SUB_FOLDER_PATH = "lib" + File.separator + "moin"; //$NON-NLS-1$ //$NON-NLS-2$


    String getName( );

    IpiDiDcDefinitionProvider getDevelopmentComponent( );

    boolean hasPurpose( IpiDiPublicPartProvider.Purpose purpose );
}
