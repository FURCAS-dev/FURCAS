/**
 * 
 */
package com.sap.tc.moin.js.query.service.client.impl;

import com.sap.tc.moin.js.query.service.client.QsResourceIdentifierConstants;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;


/**
 * @author D044522
 */
public class CRIStringWrapperImpl implements CRI {

    private final String cri;

    private DataAreaDescriptor dad = null;

    private String containerName = null;

    public CRIStringWrapperImpl( String cri ) {

        this.cri = cri;
    }

    public CRIStringWrapperImpl( String facilityId, String dataAreaName, String containerName2 ) {

        this.dad = StringWrapperResourceIdentifierFactory.getInstance( ).createDataAreaDescriptor( facilityId, dataAreaName );
        this.containerName = containerName2;
        StringBuilder sb = new StringBuilder( dad.toString( ) );
        sb.append( QsResourceIdentifierConstants.FACILITY_PART_SEPARATOR );
        sb.append( QsResourceIdentifierConstants.DC_NAME_PART_PREFIX );
        sb.append( containerName );
        cri = sb.toString( );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.CRI#getContainerName()
     */
    public String getContainerName( ) {

        if ( containerName == null ) {
            doParse( );
        }
        return containerName;
    }

    private void doParse( ) {

        if ( cri != null ) {
            final int sepIdx = cri.lastIndexOf( QsResourceIdentifierConstants.FACILITY_PART_SEPARATOR );
            if ( sepIdx > 0 && sepIdx < cri.length( ) ) {
                dad = StringWrapperResourceIdentifierFactory.getInstance( ).createDataAreaDescriptor( cri.substring( 0, sepIdx ) );
                containerName = cri.substring( sepIdx + 1 + QsResourceIdentifierConstants.DC_NAME_PART_PREFIX.length( ) );
            }
        }

    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.CRI#getDataAreaDescriptor()
     */
    public DataAreaDescriptor getDataAreaDescriptor( ) {

        if ( dad == null ) {
            doParse( );
        }
        return dad;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.CRI#isTransientContainer()
     */
    public boolean isTransientContainer( ) {

        // TODO check if this makes sense at all for remote resource identifiers!
        return false;
    }

    public boolean isVolatileContainer( ) {

        // TODO check if this makes sense at all for remote resource identifiers!
        return false;
    }

    @Override
    public boolean equals( Object obj ) {

        return ( obj != null ) && cri.equals( obj.toString( ) );
    }

    @Override
    public int hashCode( ) {

        return cri.hashCode( );
    }

    @Override
    public String toString( ) {

        return cri;
    }

}
