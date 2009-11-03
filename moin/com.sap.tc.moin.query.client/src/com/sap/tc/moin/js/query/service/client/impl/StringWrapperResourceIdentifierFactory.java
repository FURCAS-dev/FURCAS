package com.sap.tc.moin.js.query.service.client.impl;

import com.sap.tc.moin.js.query.service.client.GenericResourceIdentifierFactory;
import com.sap.tc.moin.js.query.service.client.QsResourceIdentifierConstants;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;


/**
 * MOIN internal ResourceIdentifierFactory for potentially non-resolvable
 * references. This is useful for strongly typed treatment of non-local
 * references, e.g., from the Team Server. There are 2 major reasons why to use
 * this Factory instead of
 * {@link com.sap.tc.moin.facility.primary.riservice.DiResourceIdentifierFactoryImpl}
 * :
 * <ul>
 * <li><b>Performance</b>: In some use cases (like model browser) created
 * Resource Identifiers (MRI, CRI, LRI...) do not need to be parsed upon
 * creation. Most of the time, only their <tt>toString()</tt> method is actually
 * used, which is directly delegated to the wrapped String.</li>
 * <li><b>Type Safety</b>: Strongly typed identifiers are safer to program with
 * than Strings with arbitrary contents and semantics. This feature is offered
 * by other RIFactories as well, however at a greater performance penalty.</li>
 * </ul>
 * 
 * @author D044522
 */
public final class StringWrapperResourceIdentifierFactory implements GenericResourceIdentifierFactory {

    private static StringWrapperResourceIdentifierFactory singleton = null;

    public static StringWrapperResourceIdentifierFactory getInstance( ) {

        if ( singleton == null ) {
            singleton = new StringWrapperResourceIdentifierFactory( );
        }
        return singleton;
    }

    public CRI createCri( String cri ) throws InvalidResourceIdentifierException {

        assert ( cri != null );
        return new CRIStringWrapperImpl( cri );
    }

    public CRI createCri( String dataAreaName, String containerName ) {

        return this.createCri( QsResourceIdentifierConstants.PRIMARY_FACILITY_ID, dataAreaName, containerName );
    }

    public CRI createCri( String facilityId, String dataAreaName, String containerName ) {

        assert ( facilityId != null && dataAreaName != null && containerName != null );
        return new CRIStringWrapperImpl( facilityId, dataAreaName, containerName );
    }

    public LRI createLri( String lri ) throws InvalidResourceIdentifierException {

        assert ( lri != null );
        return new LRIStringWrapperImpl( lri );
    }

    public LRI createLri( String dataAreaName, String mofId ) {

        return this.createLri( QsResourceIdentifierConstants.PRIMARY_FACILITY_ID, dataAreaName, mofId );
    }

    public LRI createLri( String facilityId, String dataAreaName, String mofId ) {

        assert ( facilityId != null && dataAreaName != null && mofId != null );
        return new LRIStringWrapperImpl( facilityId, dataAreaName, mofId );
    }

    public MRI createMri( String uri ) throws InvalidResourceIdentifierException {

        assert ( uri != null );
        return new MRIStringWrapperImpl( uri );
    }

    public MRI createMri( String dataAreaName, String containerName, String partitionName, String mofId ) {

        return this.createMri( QsResourceIdentifierConstants.PRIMARY_FACILITY_ID, dataAreaName, containerName, partitionName, mofId );
    }

    public MRI createMri( String facilityId, String dataAreaName, String containerName, String partitionName, String mofId ) {

        assert ( facilityId != null && dataAreaName != null && containerName != null && partitionName != null && mofId != null );
        return new MRIStringWrapperImpl( facilityId, dataAreaName, containerName, partitionName, mofId );
    }

    public PRI createPri( String pri ) throws InvalidResourceIdentifierException {

        assert ( pri != null );
        return new PRIStringWrapperImpl( pri );
    }

    public PRI createPri( String dataAreaName, String containerName, String partitionName ) {

        return this.createPri( QsResourceIdentifierConstants.PRIMARY_FACILITY_ID, dataAreaName, containerName, partitionName );
    }

    public PRI createPri( String facilityId, String dataAreaName, String containerName, String partitionName ) {

        assert ( facilityId != null && dataAreaName != null && containerName != null && partitionName != null );
        return new PRIStringWrapperImpl( facilityId, dataAreaName, containerName, partitionName );
    }


    public DataAreaDescriptor createDataAreaDescriptor( String facilityId, String dataAreaName ) {

        assert ( facilityId != null && dataAreaName != null );
        return new DataAreaDescriptorStringWrapperImpl( facilityId, dataAreaName );
    }

    public DataAreaDescriptor createDataAreaDescriptor( String dad ) throws InvalidResourceIdentifierException {

        assert ( dad != null );
        return new DataAreaDescriptorStringWrapperImpl( dad );
    }
}
