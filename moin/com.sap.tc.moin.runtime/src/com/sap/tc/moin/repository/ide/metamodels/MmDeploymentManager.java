package com.sap.tc.moin.repository.ide.metamodels;

import java.util.Collection;

import com.sap.tc.moin.repository.metamodels.MetaModelCatalog;

/**
 * The MOIN Metamodel Deployment Manager supports the deployment of MOIN
 * metamodels and allows the access to currently deployed MOIN metamodels
 * (information about deployed metamodels).
 * 
 * @author d029324
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface MmDeploymentManager extends MetaModelCatalog {

    /**
     * Starts the deployment of particular metamodel in MOIN.
     * 
     * @param metaModel the deployed metamodel information.
     * @throws MoinDeploymentException the exception is thrown if the MOIN
     * metamodel can not be deployed in MOIN repository.
     * @deprecated
     */
    @Deprecated
    public void deployMetaModel( MmDeploymentInfo metaModel ) throws MoinDeploymentException;

    /**
     * Returns collection of known meta-models. The list contains all MOIN
     * metamodels (Eclipse plug-ins that contains MOIN metamodels) that are
     * known by the Eclipse runtime.
     * 
     * @return Collection of known MOIN metamodels.
     */
    public Collection<MmDeploymentInfo> getMetaModelPluginList( );
}
