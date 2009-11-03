package com.sap.tc.moin.test.fw;

import java.util.Date;
import java.util.NoSuchElementException;

import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundDataAreaManager;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityException;
import com.sap.tc.moin.test.testcase.MoinTestCase;

/**
 * Abstarct base class for {@link com.sap.tc.moin.test.fw.TestClient}s.
 * <p>
 * The abstract class provides a skeleton implementation for the non-facility
 * specific functionality.
 * 
 * @author D032434
 */
@SuppressWarnings( "nls" )
public abstract class AbstractTestClient implements TestClient {

    protected String facilityId;

    protected TestClientFactory factory;

    // immutable members initialized via constructor
    protected String _password;

    protected String _clientSpecId;

    // the facility has to be provided by the factory
    protected Facility _facility;

    // data area name can be specified optionally in the test configuration; if not set, the first data area is used
    protected String _dataAreaName;

    protected DataArea _dataArea;

    // connection and client spec are intialized lazy
    protected Connection _connection;

    protected ClientSpec _clientSpec;

    private int _clientSpecIndex;

    private int _userIndex;

    protected AbstractTestClient( TestClientFactory factory, int userIndex, int clientSpecIndex ) {

        this.factory = factory;
        this._userIndex = userIndex;
        this._clientSpecIndex = clientSpecIndex;
    }

    protected AbstractTestClient( String facilityId, String password, String clientSpecId, String dataAreaName, TestClientFactory testClientFactory, int userIndex, int clientSpecIndex ) {

        this( testClientFactory, userIndex, clientSpecIndex );

        this.facilityId = facilityId;

        _facility = this.getClientFacility( );

        _password = password;
        _clientSpecId = clientSpecId;
        _dataAreaName = dataAreaName;

    }

    protected Facility getClientFacility( ) {

        if ( this._facility == null ) {
            this._facility = MoinTestCase.getTestHelper( ).getMoin( ).getFacilityById( facilityId );
        }
        return _facility;
    }

    /**
     * @return the client ID, which is unique for the data area
     */
    public String getClientId( ) {

        return _clientSpecId;
    }

    public String getPassword( ) {

        return _password;
    }

    @Override
    public String toString( ) {

        return getClientId( ) + "@" + Integer.toHexString( System.identityHashCode( this ) );
    }

    /**
     * @return a client spec for this test client
     */
    public synchronized SpiClientSpec getClientSpec( ) {

        if ( _clientSpec == null || !this.isClientSpecValid( ) ) {
            try {
                _clientSpec = this.getOrCreateClientSpec( );
            } catch ( SpiFacilityException e ) {
                throw new IllegalStateException( "Could not retrieve a client-spec for test client " + this, e );
            }
        }

        return (SpiClientSpec) _clientSpec;
    }

    private boolean isClientSpecValid( ) {

        return this._clientSpec.getDataArea( ).getDescriptor( ) != null;
    }

    /**
     * @return the data area for this test client. If no data area exists, an
     * exception is thrown.
     */
    protected synchronized DataArea getDataArea( ) {

        if ( _dataArea == null ) {
            String dataAreaName = null;

            // use the data area name if set
            if ( _dataAreaName != null ) {
                dataAreaName = _dataAreaName;
            } else {
                try {
                    dataAreaName = (String) this.getClientFacility( ).getDataAreaNames( ).iterator( ).next( );
                } catch ( NoSuchElementException e ) {
                    throw new IllegalStateException( "Bad test configuration: Facility " + this.getClientFacility( ).getId( ) + " has to contain at least one data area." );
                }
            }

            _dataArea = this.getClientFacility( ).getDataAreaByName( dataAreaName );
            if ( _dataArea == null ) {
                throw new IllegalStateException( "Bad test configuration: Data Area " + dataAreaName + " not found in facility " + this.getClientFacility( ).getId( ) );
            }
        }

        return _dataArea;
    }

    /**
     * Gets a facility-specific client-spec instance for the userId and
     * clientSpecId of this test client. If no such client-spec exists, a new
     * client-spec is created. This method has to be implemented by concrete
     * subclasses.
     * 
     * @return a client spec instance
     * @throws SpiFacilityException if no client spec could be retrieved
     */
    protected abstract ClientSpec getOrCreateClientSpec( ) throws SpiFacilityException;

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.test.fw.TestClient#getConnection()
     */
    public synchronized Connection getConnection( ) {

        if ( _connection == null || !_connection.isAlive( ) ) {
            _connection = this.createConnection( );
            _connection.setLabel( new Date( System.currentTimeMillis( ) ).toString( ) );
        }

        return _connection;
    }

    /**
     * Creates a new Conncetion for this test client.
     */
    protected Connection createConnection( ) {

        try {
            Moin moin = MoinTestCase.getTestHelper( ).getMoin( );
            SpiCompoundDataAreaManager cdam = (SpiCompoundDataAreaManager) moin.getCompoundDataAreaManager( );

            CompoundClientSpec compoundClientSpec = cdam.getDefaultCompoundClientSpec( this.getClientSpec( ) );

            return moin.createSession( compoundClientSpec ).createConnection( );
        } catch ( Exception e ) {
            // wrap with RuntimeException (test cases shouldn't bother with exceptions)
            throw new IllegalStateException( "Failed to create a connection for test client " + this, e );
        }
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.test.fw.TestClient#setAsCurrentClient()
     */
    public void setAsCurrentClient( ) {

        getConnection( );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.test.fw.TestClient#clear()
     */
    public synchronized void clear( ) {

        // free all resources
        if ( _connection != null && _connection.isAlive( ) ) {
            _connection.close( );
        }
        _connection = null;
        this._clientSpec = null;
        this._clientSpecId = null;
        this._dataArea = null;
        this._dataAreaName = null;
        this._facility = null;
        this._password = null;

    }

    public synchronized void delete( ) {

        this.clear( );
        this.factory.removeTestClient( this._userIndex, this._clientSpecIndex );
    }

    public synchronized void reset( ) {

        this.clear( );

    }

}
