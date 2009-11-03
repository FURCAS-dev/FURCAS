package com.sap.tc.moin.repository.metamodels;

import java.util.Collection;

/**
 * The MetaModelCatalog interface provides the access to the metamodels that are
 * currently deployed in MOIN repository (see {@link #getMetaModelList()}
 * method).
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface MetaModelCatalog {

    /**
     * The metamodel partition's extension used in MOIN metamodels to define
     * files that contains metamodel partitions.
     */
    public static final String META_MODEL_EXTENSION = ".moinmm"; //$NON-NLS-1$

    /**
     * Returns a collection of MOIN metamodels which are deployed in MOIN
     * repository.
     * 
     * @return Collection of MetaModelInfo, each describing one deployed
     * metamodel.
     */
    public Collection<MetaModelInfo> getMetaModelList( );
}
