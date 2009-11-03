package com.sap.tc.moin.query.repository.impl;

import com.sap.ide.dii05.model.api.IDevelopmentConfiguration;
import com.sap.tc.moin.js.query.service.client.GenericResourceIdentifierFactory;
import com.sap.tc.moin.js.query.service.client.QsResourceIdentifierConstants;
import com.sap.tc.moin.query.repository.LocalMoinTranslater;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Moin;

/**
 * @author D044522
 */
class LocalMoinTranslaterImpl implements LocalMoinTranslater {

    private Moin moin;

    private DiRepositoryHelperImpl dirhi;

    private GenericResourceIdentifierFactory rif;

    LocalMoinTranslaterImpl( Moin moin, DiRepositoryHelperImpl dirhi, GenericResourceIdentifierFactory rif ) {

        assert ( moin != null );
        assert ( dirhi != null );
        assert ( rif != null );

        this.moin = moin;
        this.dirhi = dirhi;
        this.rif = rif;
    }

    public MRI getLocalMri( MRI remote ) {

        if ( remote == null )
            return null;

        final String remoteDataAreaName = remote.getDataAreaDescriptor( ).getDataAreaName( );
        final IDevelopmentConfiguration devConf = dirhi.getDevelopmentConfigurationByName( remoteDataAreaName );
        if ( devConf == null )
            return null;
        final String localDataAreaName = remoteDataAreaName + '[' + devConf.getImportId( ) + ']';
        return moin.createMri( QsResourceIdentifierConstants.PRIMARY_FACILITY_ID, localDataAreaName, remote.getContainerName( ), remote.getPartitionName( ), remote.getMofId( ) );
    }

    public MRI getRemoteMri( MRI local ) {

        if ( local == null )
            return null;

        final String localDataAreaName = local.getDataAreaDescriptor( ).getDataAreaName( );
        final int idx = localDataAreaName.indexOf( '[' );
        if ( idx <= 0 )
            return null;
        final String remoteDataAreaName = localDataAreaName.substring( 0, idx );
        return rif.createMri( local.getDataAreaDescriptor( ).getFacilityId( ), remoteDataAreaName, local.getContainerName( ), local.getPartitionName( ), local.getMofId( ) );
    }

}
