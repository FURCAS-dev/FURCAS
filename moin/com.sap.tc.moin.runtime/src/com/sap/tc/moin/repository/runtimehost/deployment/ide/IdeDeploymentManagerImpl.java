package com.sap.tc.moin.repository.runtimehost.deployment.ide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentManager;
import com.sap.tc.moin.repository.ide.metamodels.MoinDeploymentException;
import com.sap.tc.moin.repository.metamodels.MetaModelCatalog;
import com.sap.tc.moin.repository.metamodels.MetaModelInfo;

/**
 * Deployment manager implementation. Used for the deployment overview.
 * 
 * @author D026715
 */
public class IdeDeploymentManagerImpl implements MmDeploymentManager {

    private List<IdeDeploymentInfoImpl> allMetamodelPlugins = new ArrayList<IdeDeploymentInfoImpl>( );

    private MetaModelCatalog metaModelCatalog;


    public IdeDeploymentManagerImpl( MetaModelCatalog catalog ) {

        this.metaModelCatalog = catalog;
    }

    public synchronized Collection<MmDeploymentInfo> getMetaModelPluginList( ) {

        return Collections.unmodifiableList( (List) this.allMetamodelPlugins );
    }

    public void deployMetaModel( MmDeploymentInfo metaModel ) throws MoinDeploymentException {

        // dummy for deployment view plugin - functionality should be removed
    }

    public void add( IdeDeploymentInfoImpl deploymentInfo ) {

        this.allMetamodelPlugins.add( deploymentInfo );
    }

    public Collection<MetaModelInfo> getMetaModelList( ) {

        return this.metaModelCatalog.getMetaModelList( );
    }

}