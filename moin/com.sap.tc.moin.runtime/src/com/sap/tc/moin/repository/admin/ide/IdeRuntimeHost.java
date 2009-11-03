package com.sap.tc.moin.repository.admin.ide;

import com.sap.tc.moin.repository.admin.RuntimeHost;
import com.sap.tc.moin.repository.ide.IdeMoin;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentManager;
import com.sap.tc.moin.repository.ide.metamodels.MmGenerator;
import com.sap.tc.moin.repository.metamodels.MetaModelCatalog;

/**
 * Implements the MOIN life-cycle - start, stop and restart of MOIN in the IDE
 * environment. The MoinFrame implementation class is the IDE plug-in
 * implementation class - implements the AbstractUIPlugin interface.
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author d029324
 */
public interface IdeRuntimeHost extends RuntimeHost {

    /**
     * Runtime Host plug-in ID. The plug-in ID is used to access the Runtime
     * Host implementation class.
     */
    public static final String PLUGIN_ID = "com.sap.tc.moin.runtime"; //$NON-NLS-1$

    /**
     * Returns the meta-model deployment manager.
     * 
     * @return meta-model deployment manager.
     */
    public MmDeploymentManager getMmDeploymentManager( );

    /**
     * Returns the metamodel catalog.
     * 
     * @return
     */
    public MetaModelCatalog getMetaModelCatalog( );

    /**
     * Returns the metamodel generator. This generator is able to generate
     * artifacts that are necessary for a metamodel to be run from a development
     * platform as plug-in project.
     * 
     * @return the metamodel generator
     * @deprecated not officially supported! Might be removed without further
     * notice!!
     */
    @Deprecated
    public MmGenerator getMmGenerator( );

    /**
     * Returns the valid MOIN instance. If the MOIN is not running, the Runtime
     * Host starts the MOIN.
     * 
     * @return running MOIN instance.
     */
    public IdeMoin getMoinInstance( );
}
