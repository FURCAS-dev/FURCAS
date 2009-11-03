package com.sap.tc.moin.repository.spi.runtimehost.mm;

import java.util.Locale;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.metamodels.DeploymentExtension;
import com.sap.tc.moin.repository.metamodels.MetaModelVersion;


public interface SpiMetamodelRegistry {

    /**
     * Gets the deployment extension of the metamodel defined by the specified
     * container identifier.
     * 
     * @param cri the id of the metamodel container
     * @return the deployment extension of the metamodel
     */
    public DeploymentExtension getDeploymentExtension( CRI cri );

    /**
     * Gets the version of the metamodel defined by the specified container
     * identifier.
     * 
     * @param cri the id of the metamodel container
     * @return the version of the metamodel
     */
    public MetaModelVersion getMetaModelVersion( CRI cri );

    /**
     * Gets a localized string from the metamodel's resource bundle.
     * <p>
     * If the request can not be resolved (either no metamodel found for the
     * CRI, or no resource bundle found for the metamodel or no resource found
     * for the resource key), the implementation will trace a warning message
     * and return <code>null</code>.
     * 
     * @param locale the locale for which the string is resolved
     * @param resourceKey the key of the resource
     * @return a localized string from the metamodel's resource bundle or
     * <code>null</code>, if no localized string can be found
     */
    public String getLocalizedString( CRI cri, Locale locale, String resourceKey );

    /**
     * Returns whether the metamodel with the specified {@link CRI} is deployed
     * or not.
     * 
     * @param cri the CRI of the metamodel in question
     * @return whether the metamodel with the specified CRI is deployed or not
     */
    public boolean isDeployed( CRI cri );
}