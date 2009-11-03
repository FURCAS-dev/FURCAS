/**
 * 
 */
package com.sap.tc.moin.js.query.service.client.impl;

import com.sap.tc.moin.js.query.service.client.QsResourceIdentifierConstants;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;


/**
 * MOIN internal MRI implementation for potentially non-resolvable references.
 * This is useful for strongly typed treatment of non-local references, e.g.,
 * from the Team Server. Uses lazy evaluation to parse components of a MRI
 * String on demand.
 * 
 * @author D044522
 */
public final class MRIStringWrapperImpl implements MRI {

    private final String mri;

    private String mofId = null;

    private PRI pri = null;

    private LRI cachedLri = null;

    public MRIStringWrapperImpl( String mri ) {

        this.mri = mri;
    }

    public MRIStringWrapperImpl( String facilityId, String dataAreaName, String containerName, String partitionName, String mofId2 ) {

        this.pri = StringWrapperResourceIdentifierFactory.getInstance( ).createPri( facilityId, dataAreaName, containerName, partitionName );
        this.mofId = mofId2;
        StringBuilder sb = new StringBuilder( pri.toString( ) );
        sb.append( QsResourceIdentifierConstants.MOF_ID_SEPARATION_CHAR );
        sb.append( mofId );
        this.mri = sb.toString( );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.MRI#getContainerName()
     */
    public String getContainerName( ) {

        if ( pri == null ) {
            doParse( );
        }
        return ( pri != null ) ? pri.getContainerName( ) : null;
    }

    private void doParse( ) {

        if ( mri != null ) {
            final int sepIdx = mri.lastIndexOf( QsResourceIdentifierConstants.MOF_ID_SEPARATION_CHAR );
            if ( sepIdx > 0 && sepIdx < mri.length( ) ) {
                pri = StringWrapperResourceIdentifierFactory.getInstance( ).createPri( mri.substring( 0, sepIdx ) );
                mofId = mri.substring( sepIdx + 1 );
            }
        }

    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.MRI#getCri()
     */
    public CRI getCri( ) {

        if ( pri == null ) {
            doParse( );
        }
        return ( pri != null ) ? pri.getCri( ) : null;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.MRI#getDataAreaDescriptor()
     */
    public DataAreaDescriptor getDataAreaDescriptor( ) {

        if ( pri == null ) {
            doParse( );
        }
        return ( pri != null ) ? pri.getDataAreaDescriptor( ) : null;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.MRI#getLri()
     */
    public LRI getLri( ) {

        if ( cachedLri == null ) {
            doParse( );
        }
        if ( pri != null && mofId != null ) {
            cachedLri = StringWrapperResourceIdentifierFactory.getInstance( ).createLri( pri.getDataAreaDescriptor( ).getFacilityId( ), pri.getDataAreaDescriptor( ).getDataAreaName( ), mofId );
        }
        return cachedLri;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.MRI#getMofId()
     */
    public String getMofId( ) {

        if ( mofId == null ) {
            doParse( );
        }
        return mofId;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.MRI#getPartitionName()
     */
    public String getPartitionName( ) {

        if ( pri == null ) {
            doParse( );
        }
        return pri != null ? pri.getPartitionName( ) : null;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.MRI#getPri()
     */
    public PRI getPri( ) {

        if ( pri == null ) {
            doParse( );
        }
        return pri;
    }

    @Override
    public String toString( ) {

        return mri;
    }

    @Override
    public int hashCode( ) {

        return mri.hashCode( );
    }

    @Override
    public boolean equals( Object o ) {

        return ( o != null ) && mri.equals( o.toString( ) );
    }

}
