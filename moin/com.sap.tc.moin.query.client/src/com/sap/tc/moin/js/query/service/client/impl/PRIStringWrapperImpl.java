/**
 * 
 */
package com.sap.tc.moin.js.query.service.client.impl;

import com.sap.tc.moin.js.query.service.client.QsResourceIdentifierConstants;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;


/**
 * MOIN internal PRI implementation for potentially non-resolvable references.
 * This is useful for strongly typed treatment of non-local references, e.g.,
 * from the Team Server. Uses lazy evaluation to parse components of a PRI
 * String on demand.
 * 
 * @author D044522
 */
public final class PRIStringWrapperImpl implements PRI {

    private final String pri;

    private CRI cri;

    private String partitionName;

    public PRIStringWrapperImpl( String pri2 ) {

        this.pri = pri2;
    }

    public PRIStringWrapperImpl( String facilityId, String dataAreaName, String containerName, String partitionName ) {

        this.cri = StringWrapperResourceIdentifierFactory.getInstance( ).createCri( facilityId, dataAreaName, containerName );
        this.partitionName = partitionName;
        StringBuilder sb = new StringBuilder( cri.toString( ) );
        sb.append( QsResourceIdentifierConstants.DC_NAME_PART_SUFFIX );
        sb.append( partitionName );
        this.pri = sb.toString( );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.PRI#createMri(java.lang.String)
     */
    public MRI createMri( String mofId ) {

        return StringWrapperResourceIdentifierFactory.getInstance( ).createMri( this.getDataAreaDescriptor( ).getDataAreaName( ), this.getContainerName( ), this.getPartitionName( ), mofId );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.PRI#getContainerName()
     */
    public String getContainerName( ) {

        if ( cri == null ) {
            doParse( );
        }
        return ( cri != null ) ? cri.getContainerName( ) : null;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.PRI#getCri()
     */
    public CRI getCri( ) {

        if ( cri == null ) {
            doParse( );
        }
        return cri;
    }

    private void doParse( ) {

        if ( pri != null ) {
            final int sepIdx = pri.lastIndexOf( QsResourceIdentifierConstants.DC_NAME_PART_SUFFIX );
            if ( sepIdx > 0 && sepIdx < pri.length( ) ) {
                cri = StringWrapperResourceIdentifierFactory.getInstance( ).createCri( pri.substring( 0, sepIdx ) );
                partitionName = pri.substring( sepIdx + QsResourceIdentifierConstants.DC_NAME_PART_SUFFIX.length( ) );
            }
        }

    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.PRI#getDataAreaDescriptor()
     */
    public DataAreaDescriptor getDataAreaDescriptor( ) {

        if ( cri == null ) {
            doParse( );
        }
        return ( cri != null ) ? cri.getDataAreaDescriptor( ) : null;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.PRI#getPartitionName()
     */
    public String getPartitionName( ) {

        if ( partitionName == null ) {
            doParse( );
        }
        return partitionName;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.PRI#isMetaModelPartition()
     */
    public boolean isMetaModelPartition( ) {

        // TODO Auto-generated method stub
        return false;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.PRI#isNullPartition()
     */
    public boolean isNullPartition( ) {

        // TODO Auto-generated method stub
        return false;
    }

    public boolean isTransientPartition( ) {

        return isVolatilePartition( );
    }

    public boolean isVolatilePartition( ) {

        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean equals( Object obj ) {

        return ( obj != null ) && pri.equals( obj.toString( ) );
    }

    @Override
    public int hashCode( ) {

        return pri.hashCode( );
    }

    @Override
    public String toString( ) {

        return pri;
    }

}
