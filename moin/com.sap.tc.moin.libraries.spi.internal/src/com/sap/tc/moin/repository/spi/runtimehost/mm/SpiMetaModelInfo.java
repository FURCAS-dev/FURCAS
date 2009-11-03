package com.sap.tc.moin.repository.spi.runtimehost.mm;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.metamodels.DeploymentExtension;
import com.sap.tc.moin.repository.metamodels.MetaModelInfo;


public interface SpiMetaModelInfo extends MetaModelInfo {

    /**
     * Returns the deployment extension class.
     * 
     * @return deployment extension class.
     */
    public DeploymentExtension getMmExtensionInstance( );

    /**
     * Returns the container resource identifier for the corresponding
     * meta-model.
     * 
     * @return the container resource identifier for the corresponding
     * meta-model
     */
    public CRI getContainer( );

    /**
     * Returns the resource bundle name for string localization.
     * 
     * @return the resource bundle name for string localization
     */
    public String getMetaModelResourceBundleName( );
}
