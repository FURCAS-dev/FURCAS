package com.sap.tc.moin.facility.primary.riservice;

import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.LRI;

/**
 * Nwdi implementation of the link resource identifier.
 * 
 * @author d026715
 */

public final class DiLriImpl implements LRI {

    private final DataAreaDescriptor dataAreaDescriptor;

    private final String mofId;

    /**
     * Cache for toString().
     */
    private String cachedString = null;

    /**
     * @param dataArea
     * @param mofId INTERNED!!! MOF-Id
     */
    protected DiLriImpl( DataAreaDescriptor dataArea, String mofId ) {

        this.dataAreaDescriptor = dataArea;
        this.mofId = mofId;
    }

    public DataAreaDescriptor getDataAreaDescriptor( ) {

        return dataAreaDescriptor;
    }

    public String getMofId( ) {

        return mofId;
    }

    @Override
    public String toString( ) {

        if ( this.cachedString == null ) {
            StringBuilder result = new StringBuilder( this.getDataAreaDescriptor( ).getFacilityId( ).length( ) + 1 + this.getDataAreaDescriptor( ).getDataAreaName( ).length( ) + 1 + this.mofId.length( ) );
            result.append( this.getDataAreaDescriptor( ).getFacilityId( ) + DiResourceIdentifierConstants.FACILITY_INSTANCE_SEPARATOR + this.getDataAreaDescriptor( ).getDataAreaName( ) + DiResourceIdentifierConstants.FACILITY_PART_SEPARATOR + this.mofId );

            this.cachedString = result.toString( );
        }
        return this.cachedString;
    }
}