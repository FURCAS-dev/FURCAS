package com.sap.tc.moin.repository.core.impl;

import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.EndAndMetaObjectPool;
import com.sap.tc.moin.repository.core.EndStorageLinkFactory;
import com.sap.tc.moin.repository.core.ReferenceManager;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.links.EndStorageLinkFactoryImpl;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.spi.core.SpiStage;


public class MetamodelWorkspaceSetImpl extends AbstractWorkspaceSet {

    private EndAndMetaObjectPool endAndMetaobjectPool;

    private ReferenceManagerImpl referenceManager;

    private EndStorageLinkFactoryImpl linkFactory;

    public MetamodelWorkspaceSetImpl( CoreMoin moin ) {

        super( moin );

        this.endAndMetaobjectPool = new EndAndMetaObjectPoolImpl( );
        this.referenceManager = new ReferenceManagerImpl( moin );
        this.linkFactory = new EndStorageLinkFactoryImpl( moin.getJmiHelper( ), referenceManager );
    }

    public EndAndMetaObjectPool getEndAndMetaObjectPool( ) {

        return endAndMetaobjectPool;
    }


    public EndStorageLinkFactory getLinkFactory( ) {

        return linkFactory;
    }

    public ReferenceManager getReferenceManager( ) {

        return referenceManager;

    }

    public Workspace getWorkspace( SpiStage stage, Session session ) {

        if ( !stage.getDataAreaDescriptor( ).isMetamodelDataArea( ) ) {
            throw new MoinIllegalStateException( CoreImplMessages.METAMODELWSSETMUSTNOTBEASKEDFORNONMMWORKSPACES );
        }

        return getMoin( ).getMetamodelWorkspace( );
    }

}
