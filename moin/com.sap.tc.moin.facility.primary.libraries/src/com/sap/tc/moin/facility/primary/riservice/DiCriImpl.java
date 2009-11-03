package com.sap.tc.moin.facility.primary.riservice;

import com.sap.tc.moin.facility.primary.ipi.IpiDiCri;
import com.sap.tc.moin.repository.DataAreaDescriptor;

public final class DiCriImpl implements IpiDiCri {

    private static final char SEPARATION_CHAR = '/';

    private static final String SEPARATION_CHAR_STRING = new String( new char[] { SEPARATION_CHAR } );

    private final DataAreaDescriptor dataArea;

    private final String container;

    private String cachedString = null;

    /**
     * @param dataAreaDescriptor
     * @param containerName must be INTERNED!!!
     */
    protected DiCriImpl( DataAreaDescriptor dataAreaDescriptor, String containerName ) {

        this.dataArea = dataAreaDescriptor;
        this.container = containerName;
    }

    public String getContainerName( ) {

        return this.container;
    }

    public DataAreaDescriptor getDataAreaDescriptor( ) {

        return this.dataArea;
    }

    public boolean isTransientContainer( ) {

        return isVolatileContainer( );
    }

    public boolean isVolatileContainer( ) {

        return this.container == DiResourceIdentifierConstants.DC_INTERNAL;
    }

    public String getDevComponentName( ) {

        String[] vendorAndName = this.getContainerName( ).split( SEPARATION_CHAR_STRING, 2 );
        if ( vendorAndName.length == 2 ) {
            return vendorAndName[1];
        }
        return vendorAndName[0];
    }

    public String getDevComponentVendor( ) {

        String[] vendorAndName = this.getContainerName( ).split( SEPARATION_CHAR_STRING, 2 );
        if ( vendorAndName.length == 2 ) {
            return vendorAndName[0];
        }
        return ""; //$NON-NLS-1$
    }

    @Override
    public String toString( ) {

        if ( this.cachedString == null ) {
            StringBuilder result = new StringBuilder( );
            result.append( this.dataArea.getFacilityId( ) );
            result.append( DiResourceIdentifierConstants.FACILITY_INSTANCE_SEPARATOR );
            result.append( this.dataArea.getDataAreaName( ) );
            result.append( DiResourceIdentifierConstants.FACILITY_PART_SEPARATOR );
            // DC
            result.append( DiResourceIdentifierConstants.DC_NAME_PART_PREFIX );
            result.append( this.container );
            this.cachedString = result.toString( );
        }
        return this.cachedString;
    }
}