package com.sap.tc.moin.repository.test.core;

import java.net.URI;
import java.net.URISyntaxException;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;

public class MockPriImpl implements PRI, Cloneable {

    private String partitionName;

    // empty constructor is not for public usage
    protected MockPriImpl( ) {

        // nothing to do
    }

    public MockPriImpl( String mriString ) {

        int hashIdx = mriString.indexOf( '#' );
        if ( hashIdx < 0 ) {
            this.partitionName = mriString;
        } else {
            throw new InvalidResourceIdentifierException( RepositoryCoreMessages.PRI_MUST_NOT_CONTAIN_MOF_ID, mriString );
        }
    }

    private static String INTERNAL_FACILITY_PREFIX = "com.sap.tc.moin.Internal";

    private static String INTERNAL_DATA_AREA_ID = "TransientDataArea";

    public DataAreaDescriptor getDataAreaDescriptor( ) {

        return new DataAreaDescriptor( ) {

            public String getDataAreaName( ) {

                return INTERNAL_DATA_AREA_ID;
            }

            public String getFacilityId( ) {

                return INTERNAL_FACILITY_PREFIX;
            }

            public boolean isMetamodelDataArea( ) {

                return false;
            }

        };
    }

    /**
     * @see com.sap.tc.moin.repository.core.impl.MRI#toURI()
     */
    public URI toURI( ) throws URISyntaxException {

        return new URI( this.toString( ) );
    }

    @Override
    public String toString( ) {

        return this.partitionName;
    }

    @Override
    public boolean equals( Object o ) {

        if ( o instanceof MockPriImpl ) {
            return ( (MockPriImpl) o ).partitionName.equals( this.partitionName );
        } else {
            return false;
        }
    }

    @Override
    public int hashCode( ) {

        int hash = this.partitionName.hashCode( );

        return hash;
    }

    /**
     * Since class implements Cloneable clone() has been overriden, delegates to
     * parent clone and sets visibility to public
     */
    @Override
    public Object clone( ) throws CloneNotSupportedException {

        return super.clone( );
    }

    public MRI createMri( String mofId ) {

        MockMriImpl newMri = null;
        try {
            newMri = new MockMriImpl( new URI( this.toString( ) ) );
        } catch ( URISyntaxException e ) {
            return null;
        }
        return newMri.getModelElementMri( mofId );
    }

    public boolean isMetaModelPartition( ) {

        throw new UnsupportedOperationException( );
    }

    public boolean isNullPartition( ) {

        throw new UnsupportedOperationException( );
    }

    public boolean isTransientPartition( ) {

        throw new UnsupportedOperationException( );
    }

    public boolean isVolatilePartition( ) {

        throw new UnsupportedOperationException( );
    }

    public CRI getCri( ) {

        throw new UnsupportedOperationException( );
    }

    public String getContainerName( ) {

        return null;
    }

    public String getPartitionName( ) {

        return this.partitionName;
    }

}