package com.sap.tc.moin.test.fw.ide;

import java.util.Collection;

import org.eclipse.core.resources.IProject;

import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.cdam.ide.IdeCompoundDataAreaManager;
import com.sap.tc.moin.repository.spi.facility.SpiDataArea;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityException;
import com.sap.tc.moin.test.fw.MoinTestHelper;
import com.sap.tc.moin.test.fw.NwdiTestClientImpl;
import com.sap.tc.moin.test.fw.TestClientFactory;
import com.sap.tc.moin.test.testcase.MoinTestCase;

/**
 * @author d045397
 */
@SuppressWarnings( "nls" )
public class IdeNwdiTestClientImpl extends NwdiTestClientImpl {

    public boolean DONT_FORCED_REFRESH = false;

    // partition counter
    private int _partitionCounter = 1;

    // Current default test DC (besides the default test DCs from NwdiTestClientImpl)
    // TODO: clarify if it is necessary to this additional default-test-DC-handling
    // or if we could realize a simpler solution
    protected static VendorNamePair currentDefault_dc = DEFAULT_DC;

    /**
     * @param userId
     * @param password
     */
    public IdeNwdiTestClientImpl( String password, TestClientFactory factory, int userIndex, int clientSpecIndex ) {

        super( factory, userIndex, clientSpecIndex );
        this._password = password;
    }

    // @Override
    @Override
    protected ClientSpec getOrCreateClientSpec( ) throws SpiFacilityException {

        // TODO Auto-generated method stub
        throw new IllegalStateException( "This method should never be called." );
    }

    // @Override
    @Override
    protected Connection createConnection( ) {

        // get the eclipse moin helper for getting the connection
        //SessionUtil eclipseMoinHelper = null;

        // get the moin ide test helper for creating a local dc
        IdeRuntimeTestHelper helper = (IdeRuntimeTestHelper) MoinTestCase.getTestHelper( );

        // get the test eclipse project
        IProject testProject = null;
        try {
            testProject = helper.getOrCreateLocalMoinDCProject( DEFAULT_DC.getVendor( ), DEFAULT_DC.getName( ) );
            helper.getOrCreateLocalMoinDCProject( DEFAULT_DC_2.getVendor( ), DEFAULT_DC_2.getName( ) );
        } catch ( Exception e ) {
            e.printStackTrace( );
            throw new RuntimeException( e );
        }

        try {
            this._connection = this.createConnection( testProject );
        } catch ( Exception e ) {
            e.printStackTrace( );
            throw new RuntimeException( e );
        }

        Collection<ClientSpec> clientSpecs = this._connection.getSession( ).getCompoundClientSpec( ).getClientSpecs( );
        for ( ClientSpec spec : clientSpecs ) {
            SpiDataArea dataArea = (SpiDataArea) spec.getDataArea( );
            // the following code is applicable to FS-based scenarios only!
            if ( dataArea.hasSingleStageOnly( ) && dataArea.getSingleStage( ).isClientSpecific( ) ) {
                this._clientSpec = this.retrieveClientSpec( );
                this._clientSpecId = this._clientSpec.getClientId( );
                this._facility = dataArea.getFacility( );
                this._dataArea = dataArea;
                this._dataAreaName = dataArea.getName( );
                break;
            }
        }
        return this._connection;
    }

    private Connection createConnection( IProject project ) {

        if ( project == null ) {
            throw new IllegalArgumentException( "NULL project in method: createConnectionFor" );
        }
        CompoundClientSpec compoundClientSpec = ( (IdeCompoundDataAreaManager) MoinTestCase.getTestHelper( ).getMoin( ).getCompoundDataAreaManager( ) ).getCompoundClientSpec( project );

        Session session = MoinTestCase.getTestHelper( ).getMoin( ).createSession( compoundClientSpec );

        return session.createConnection( );
    }

    public Connection getConnection( String dcVendor, String dcName ) {

        currentDefault_dc = new VendorNamePair( dcVendor, dcName );
        return this.createConnection( );
    }

    private ClientSpec retrieveClientSpec( ) {

        // _clientSpec
        ClientSpec clientspec = null;
        Collection<ClientSpec> clientSpecs = this._connection.getSession( ).getCompoundClientSpec( ).getClientSpecs( );
        for ( ClientSpec spec : clientSpecs ) {
            SpiDataArea dataArea = (SpiDataArea) spec.getDataArea( );
            if ( dataArea.hasSingleStageOnly( ) && dataArea.getSingleStage( ).isClientSpecific( ) ) {
                clientspec = spec;
                break;
            }
        }
        return clientspec;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.test.fw.TestClient#createPartition(java.lang.String)
     */
    @Override
    public synchronized ModelPartition getOrCreatePartition( String testName, boolean useCounter ) {

        // look for the first DC in the configuration; if there is none, we use a default
        VendorNamePair dc = currentDefault_dc;
        //        if (getDcSize() > 0) {
        //            dc = getDcVendorNamePair(3);
        //        }

        // the partition path is set up by the test case name and the current counter + 1
        String partitionPath = PARTITION_ROOT_PATH + "/" + testName;

        // only if useCounter is true though;
        if ( useCounter ) {
            partitionPath = partitionPath + "_" + this._partitionCounter;
            this._partitionCounter++;
        } else if ( testName == null ) {
            throw new IllegalStateException( "Cannot create or get partition name \"null\" for test client " + this );
        }

        // Take care for partition suffix in PRI:
        partitionPath += MoinTestHelper.TEST_PARTITION_SUFFIX;

        ResourceIdentifierFactory mriFactory = this._clientSpec.getDataArea( ).getFacility( ).getRIFactory( );
        DataArea dataArea = this._clientSpec.getDataArea( );
        PRI pri = mriFactory.createPri( dataArea.getName( ), dc.toString( ), partitionPath );
        try {
            ModelPartition mp = getConnection( ).getPartition( pri );
            if ( mp == null ) {
                mp = getConnection( ).createPartition( pri );
            }
            return mp;
        } catch ( Exception e ) {
            // don't deal with checked exceptions in test cases
            e.printStackTrace( );
            throw new IllegalStateException( "Failed to create new model partition for MRI " + pri + " and test client " + this, e );
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.test.fw.TestClient#getOrCreatePartition(java.lang.String)
     */
    @Override
    public synchronized ModelPartition getOrCreatePartition( String testName ) {

        return getOrCreatePartition( testName, true );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.test.fw.NwdiTestClientImpl#createPartition(java.lang.
     * String)
     */
    @Override
    public ModelPartition createPartition( String partitionNameFragment ) {

        // look for the first DC in the configuration; if there is none, we use a default
        VendorNamePair dc = currentDefault_dc;
        //        if (getDcSize() > 0) {
        //            dc = getDcVendorNamePair(3);
        //        }

        // the partition path is set up by the test case name and the current counter + 1
        String partitionPath = PARTITION_ROOT_PATH + "/" + partitionNameFragment;

        // Take care for partition suffix in PRI:
        partitionPath += MoinTestHelper.TEST_PARTITION_SUFFIX;

        if ( partitionNameFragment == null ) {
            throw new IllegalStateException( "Cannot create or get partition name \"null\" for test client " + this );
        }

        // NwdiRiFactoryImpl nwdiMriFactory = (NwdiRiFactoryImpl) getNwdiFacility().getRIFactory();
        ResourceIdentifierFactory riFactory = getClientSpec( ).getDataArea( ).getFacility( ).getRIFactory( );
        DataArea dataArea = this._clientSpec.getDataArea( );
        PRI pri = riFactory.createPri( dataArea.getName( ), dc.toString( ), partitionPath );
        return getConnection( ).createPartition( pri );
    }
}
