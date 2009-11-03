package com.sap.tc.moin.facility.primary.riservice;

import com.sap.tc.moin.facility.primary.PrimaryFacility;
import com.sap.tc.moin.repository.DataAreaDescriptor;

/**
 * NWDI facility implementation of the data area descriptor.
 * 
 * @author d026715
 */
public final class DiDataAreaDescriptorImpl implements DataAreaDescriptor {

    private final String dataArea;

    private final int hashCode;

    private String toString;

    private boolean metamodelDataArea;

    /**
     * Must only be called by the RIFactory since dataAreaName must already be
     * interned!
     * 
     * @param dataAreaName INTERNED! data area name
     * @param metamodelDataArea
     */
    DiDataAreaDescriptorImpl( String dataAreaName, boolean metamodelDataArea ) {

        this.dataArea = dataAreaName;
        this.hashCode = computeHashCode( );
        this.metamodelDataArea = metamodelDataArea;
    }

    public String getFacilityId( ) {

        return PrimaryFacility.FACILITY_ID;
    }

    public String getDataAreaName( ) {

        return dataArea;
    }

    @Override
    public boolean equals( Object obj ) {

        if ( obj == this ) {
            return true;
        }
        if ( obj instanceof DiDataAreaDescriptorImpl ) {
            final DiDataAreaDescriptorImpl otherDa = (DiDataAreaDescriptorImpl) obj;
            return this.dataArea == otherDa.dataArea;
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        return hashCode;
    }

    private int computeHashCode( ) {

        int result = 17;
        result = 37 * result + PrimaryFacility.FACILITY_ID.hashCode( );
        result = 37 * result + dataArea.hashCode( );
        return result;
    }

    @Override
    public String toString( ) {

        if ( toString == null ) {
            final StringBuilder sb = new StringBuilder( 64 );
            sb.append( PrimaryFacility.FACILITY_ID );
            sb.append( DiResourceIdentifierConstants.FACILITY_INSTANCE_SEPARATOR );
            sb.append( dataArea );
            toString = sb.toString( );
        }
        return toString;
    }

    public final boolean isMetamodelDataArea( ) {

        return metamodelDataArea;
    }
}