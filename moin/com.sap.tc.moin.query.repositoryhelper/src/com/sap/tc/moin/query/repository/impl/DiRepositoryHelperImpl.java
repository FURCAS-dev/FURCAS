package com.sap.tc.moin.query.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sap.ide.dii05.lib.api.util.DiiModelService;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.model.api.IDevelopmentConfiguration;
import com.sap.ide.dii05.model.api.ISoftwareComponent;
import com.sap.tc.moin.js.query.service.client.QsResourceIdentifierConstants;
import com.sap.tc.moin.js.query.service.client.RemoteMqlProcessor;
import com.sap.tc.moin.query.repository.LocalMoinTranslater;
import com.sap.tc.moin.query.repository.RepositoryHelper;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.Moin;


/**
 * @author D044522
 */
public class DiRepositoryHelperImpl implements RepositoryHelper {

    private final RemoteMqlProcessor rmp;

    /**
     * Instead of resolving DataAreas to DevConfs (and vice-versa) remotely,
     * this step can be performed locally if <tt>optimized</tt> is set to
     * <tt>true</tt>.
     */
    private final boolean optimized;

    private final Map<String, IDevelopmentConfiguration> devConfCache = new HashMap<String, IDevelopmentConfiguration>( );

    private List<DataAreaDescriptor> rdads;

    private LocalMoinTranslater lmt;

    private final static char VENDOR_DELIMITER = '/';

    /**
     * @param rmp
     * @param optimized handle mapping of DataAreas to DCs locally
     * @see #optimized;
     */
    public DiRepositoryHelperImpl( RemoteMqlProcessor rmp, boolean optimized ) {

        this.optimized = optimized;
        this.rmp = rmp;
    }

    public DiRepositoryHelperImpl( RemoteMqlProcessor rmp ) {

        this( rmp, true );

    }

    public CRI getContainerForDevelopmentComponent( IDevelopmentComponent dc ) {

        assert ( dc != null );

        final String dataAreaName = dc.getContainingSoftwareComponent( ).getContainingDevelopmentConfiguration( ).getName( );
        final String containerName = dc.getVendor( ) + VENDOR_DELIMITER + dc.getName( );
        return rmp.getResourceIdentifierFactory( ).createCri( dataAreaName, containerName );
    }

    public IDevelopmentComponent getDevelopmentComponentForContainer( CRI cri ) {

        assert ( cri != null );

        final DataAreaDescriptor dad = cri.getDataAreaDescriptor( );
        final IDevelopmentConfiguration devConf = this.getDevelopmentConfigurationForDataArea( dad );
        final String containerName = cri.getContainerName( );
        final int idx = containerName.indexOf( VENDOR_DELIMITER );
        final String dcVendor = containerName.substring( 0, idx );
        final String dcName = containerName.substring( idx + 1 );

        IDevelopmentComponent dc = DiiModelService.getDcByNameAndVendor( devConf, dcName, dcVendor );
        if ( dc == null ) {
            // DC not yet synced locally --> refresh DII component model!
            final ISoftwareComponent[] scs = DiiModelService.getSoftwareComponents( devConf );
            if ( scs != null && scs.length > 0 ) {
                for ( int i = 0; i < scs.length; i++ ) {
                    final ISoftwareComponent sc = scs[i];
                    // Performance: consider only modifyable (source) SCs since we do not (yet) index DC archives from CBS   
                    if ( sc.isModificationAllowed( ) ) {
                        DiiModelService.getDevelopmentComponents( sc, DiiModelService.FORCED_REFRESH );
                        //faster than iterating over array and search by dcs[i].getName().equals():
                        dc = DiiModelService.getDcByNameAndVendor( devConf, dcName, dcVendor );
                        if ( dc != null ) {
                            break;
                        }
                    }
                }
            }
        }
        return dc;
    }

    public DataAreaDescriptor getDataAreaForDevelopmentConfiguration( IDevelopmentConfiguration devconf ) {

        if ( !optimized ) {
            final Map<String, String> dataAreaConfig = new HashMap<String, String>( 1 );
            dataAreaConfig.put( QsResourceIdentifierConstants.DEV_CONF_NAME, devconf.getName( ) );
            return rmp.getDataArea( dataAreaConfig );
        }
        final String dataAreaName = devconf.getName( );
        return rmp.getResourceIdentifierFactory( ).createDataAreaDescriptor( QsResourceIdentifierConstants.PRIMARY_FACILITY_ID, dataAreaName );
    }

    public IDevelopmentConfiguration getDevelopmentConfigurationForDataArea( DataAreaDescriptor dad ) {

        String devconfname = null;
        if ( !optimized ) {
            final Map<String, String> dacfg = rmp.getDataAreaConfig( dad );
            devconfname = dacfg.get( QsResourceIdentifierConstants.DEV_CONF_NAME );
        }
        if ( devconfname == null )
            devconfname = dad.getDataAreaName( );
        IDevelopmentConfiguration devConf = getDevelopmentConfigurationByName( devconfname );
        // nothing found? --> return null (user has to import devConf first!)
//        if ( devConf == null ) {
//            devConf = DevConfImportUtil.importDevConfiguration( internalName, displayName, user, password, keyStore )
//        }
        return devConf;
    }

    public List<IDevelopmentConfiguration> filterDevelopmentConfigurations( List<IDevelopmentConfiguration> localDevConfs ) {

        if ( localDevConfs == null || localDevConfs.size( ) <= 0 )
            return null;
        List<DataAreaDescriptor> rdads = getRemoteDataAreaDescriptors( );
        if ( rdads == null || rdads.size( ) <= 0 )
            return null;
        List<IDevelopmentConfiguration> fDevConfs = new ArrayList<IDevelopmentConfiguration>( localDevConfs.size( ) );
        for ( IDevelopmentConfiguration devConf : localDevConfs ) {
            for ( DataAreaDescriptor dad : rdads ) {
                if ( devConf.getName( ).equals( dad.getDataAreaName( ) ) ) {
                    fDevConfs.add( devConf );
                    break;
                }
            }
        }
        return fDevConfs;
    }

    private List<DataAreaDescriptor> getRemoteDataAreaDescriptors( ) {

        if ( rdads == null ) {
            rdads = rmp.getDataAreas( QsResourceIdentifierConstants.PRIMARY_FACILITY_ID );
        }
        return rdads;
    }

    /**
     * @param devConfName
     * @return DevConf matching <tt>devConfName</tt> or null if no match was
     * found in DII ComponentModel
     */
    @SuppressWarnings( "unchecked" )
    IDevelopmentConfiguration getDevelopmentConfigurationByName( String devConfName ) {

        final IDevelopmentConfiguration devConfiguration = devConfCache.get( devConfName );
        if ( devConfiguration == null ) {

            List<IDevelopmentConfiguration> devConfList = DiiModelService.getComponentModel( ).getDevelopmentConfigurations( );
            for ( IDevelopmentConfiguration developmentConfiguration : devConfList ) {
                if ( developmentConfiguration.getName( ).equals( devConfName ) ) {
                    devConfCache.put( devConfName, developmentConfiguration );
                    return developmentConfiguration;
                }
            }
        }
        return devConfiguration;
    }

    public LocalMoinTranslater getLocalMoinTranslater( Moin localMoin ) {

        if ( lmt == null ) {
            lmt = new LocalMoinTranslaterImpl( localMoin, this, rmp.getResourceIdentifierFactory( ) );
        }
        return lmt;
    }

}
