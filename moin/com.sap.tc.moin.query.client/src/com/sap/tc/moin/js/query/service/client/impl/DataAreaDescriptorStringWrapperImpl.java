/**
 * 
 */
package com.sap.tc.moin.js.query.service.client.impl;

import com.sap.tc.moin.js.query.service.client.QsResourceIdentifierConstants;
import com.sap.tc.moin.repository.DataAreaDescriptor;


/**
 * @author D044522
 */
public class DataAreaDescriptorStringWrapperImpl implements DataAreaDescriptor {

    private final String dad;

    private String facilityId;

    private String dataAreaName;

    public DataAreaDescriptorStringWrapperImpl( String facilityId, String dataAreaName ) {

        this.facilityId = facilityId;
        this.dataAreaName = dataAreaName;
        StringBuilder sb = new StringBuilder( facilityId );
        sb.append( QsResourceIdentifierConstants.FACILITY_INSTANCE_SEPARATOR );
        sb.append( dataAreaName );
        this.dad = sb.toString( );
    }

    public DataAreaDescriptorStringWrapperImpl( String dad ) {

        this.dad = dad;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.DataAreaDescriptor#getDataAreaName()
     */
    public String getDataAreaName( ) {

        if ( dataAreaName == null ) {
            doParse( );
        }

        return this.dataAreaName;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.DataAreaDescriptor#getFacilityId()
     */
    public String getFacilityId( ) {

        if ( facilityId == null ) {
            doParse( );
        }
        return this.facilityId;
    }

    private void doParse( ) {

        if ( dad != null ) {
            final int sepIdx = dad.lastIndexOf( QsResourceIdentifierConstants.FACILITY_INSTANCE_SEPARATOR );
            if ( sepIdx > 0 && sepIdx < dad.length( ) ) {
                facilityId = dad.substring( 0, sepIdx );
                dataAreaName = dad.substring( sepIdx + 1 );
            }
        }

    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.DataAreaDescriptor#isMetamodelDataArea()
     */
    public boolean isMetamodelDataArea( ) {

        // TODO check if this makes sense at all for remote resource identifiers!
        return false;
    }

    @Override
    public boolean equals( Object obj ) {

        return ( obj != null ) && dad.equals( obj.toString( ) );
    }

    @Override
    public int hashCode( ) {

        return dad.hashCode( );
    }

    @Override
    public String toString( ) {

        return dad;
    }

}
