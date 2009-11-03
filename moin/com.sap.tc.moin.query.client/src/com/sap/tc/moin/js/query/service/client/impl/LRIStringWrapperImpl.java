/**
 * 
 */
package com.sap.tc.moin.js.query.service.client.impl;

import com.sap.tc.moin.js.query.service.client.QsResourceIdentifierConstants;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.LRI;


/**
 * @author D044522
 */
public class LRIStringWrapperImpl implements LRI {

    private final String lri;

    private DataAreaDescriptor dad = null;

    private String mofId = null;

    public LRIStringWrapperImpl( String lri2 ) {

        this.lri = lri2;
    }

    public LRIStringWrapperImpl( String facilityId, String dataAreaName, String mofId ) {

        this.dad = StringWrapperResourceIdentifierFactory.getInstance( ).createDataAreaDescriptor( facilityId, dataAreaName );
        this.mofId = mofId;
        StringBuilder sb = new StringBuilder( facilityId );
        sb.append( QsResourceIdentifierConstants.FACILITY_INSTANCE_SEPARATOR );
        sb.append( dataAreaName );
        sb.append( QsResourceIdentifierConstants.FACILITY_PART_SEPARATOR );
        sb.append( mofId );
        lri = sb.toString( );
    }

    @Override
    public boolean equals( Object obj ) {

        return ( obj != null ) && lri.equals( obj.toString( ) );
    }

    @Override
    public int hashCode( ) {

        return lri.hashCode( );
    }

    @Override
    public String toString( ) {

        return lri;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.LRI#getDataAreaDescriptor()
     */
    public DataAreaDescriptor getDataAreaDescriptor( ) {

        if ( dad == null ) {
            doParse( );
        }
        return dad;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.LRI#getMofId()
     */
    public String getMofId( ) {

        if ( mofId == null ) {
            doParse( );
        }
        return this.mofId;
    }

    private void doParse( ) {

        if ( lri != null ) {
            final int sepIdx = lri.lastIndexOf( QsResourceIdentifierConstants.FACILITY_PART_SEPARATOR );
            if ( sepIdx > 0 && sepIdx < lri.length( ) ) {
                dad = StringWrapperResourceIdentifierFactory.getInstance( ).createDataAreaDescriptor( lri.substring( 0, sepIdx ) );
                mofId = lri.substring( sepIdx + 1 );
            }
        }
    }

}
