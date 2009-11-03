package com.sap.tc.moin.repository.test.core;

import java.net.URI;
import java.net.URISyntaxException;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;

public class MockMriImpl implements MRI, Cloneable {

    private URI uri;

    public MockMriImpl( URI uri ) {

        this.uri = uri;
    }

    /**
     * @see MRI#getFacilityId()
     */
    public String getFacilityId( ) {

        return null;
    }

    /**
     * @see MRI#getContainerName()
     */
    public String getContainerName( ) {

        return null;
    }

    /**
     * @see MRI#getPartitionName()
     */
    public String getPartitionName( ) {

        try {
            return URIHelper.getURIHelper( ).getPartitionURI( this.uri ).toString( );
        } catch ( URISyntaxException e ) {
            return null;
        }
    }

    /**
     * @see MRI#getMofId()
     */
    public String getMofId( ) {

        return URIHelper.getURIHelper( ).getMofId( this.uri );
    }

    /**
     * @see MRI#getPartitionMri()
     */
    public MRI getPartitionMri( ) {

        try {
            MockMriImpl newMri = (MockMriImpl) this.clone( );
            newMri.uri = URIHelper.getURIHelper( ).getPartitionURI( this.uri );
            return newMri;
        } catch ( CloneNotSupportedException e ) {
            return null;
        } catch ( URISyntaxException e ) {
            return null;
        }
    }

    /**
     * @see MRI#getModelElementMri(java.lang.String)
     */
    public MRI getModelElementMri( String mofId ) throws InvalidResourceIdentifierException {

        if ( this.getMofId( ) != null ) {
            throw new InvalidResourceIdentifierException( RepositoryCoreMessages.MOFID_CANNOT_BE_OVERWRITTEN_001 );
        }

        try {
            MockMriImpl newMri = (MockMriImpl) this.getPartitionMri( );
            newMri.uri = new URI( newMri.toString( ) + "#" + mofId );
            return newMri;
        } catch ( URISyntaxException e ) {
            return null;
        }
    }

    /**
     * @see MRI#setMofId(java.lang.String)
     */
    public void setMofId( String mofId ) {

        try {
            this.uri = new URI( this.uri.toString( ) + "#" + mofId );
        } catch ( URISyntaxException e ) {
            e.printStackTrace( );
        }
    }

    /**
     * @see MRI#toURI()
     */
    public URI toURI( ) throws URISyntaxException {

        return this.uri;
    }

    @Override
    public boolean equals( Object obj ) {

        if ( obj instanceof MockMriImpl ) {
            return this.uri.equals( ( (MockMriImpl) obj ).uri );
        } else {
            return false;
        }
    }

    @Override
    public int hashCode( ) {

        return this.uri.hashCode( );
    }

    @Override
    public String toString( ) {

        return this.uri.toString( );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.core.impl.MRI#getDataAreaId()
     */
    public String getDataAreaId( ) {

        return null;
    }

    public DataAreaDescriptor getDataAreaDescriptor( ) {

        return new DataAreaDescriptor( ) {

            public String getDataAreaName( ) {

                return getDataAreaId( );
            }

            public String getFacilityId( ) {

                return getFacilityId( );
            }

            public boolean isMetamodelDataArea( ) {

                return false;
            }

        };
    }

    public PRI getPri( ) {

        return new MockPriImpl( this.getPartitionMri( ).toString( ) );
    }

    public LRI getLri( ) {

        return null;
    }

    public CRI getCri( ) {

        return getPri( ).getCri( );
    }
}
