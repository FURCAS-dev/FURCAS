/**
 * 
 */
package com.sap.tc.moin.test.fw;

import com.sap.tc.moin.facility.primary.ipi.IpiDataArea;
import com.sap.tc.moin.facility.primary.ipi.IpiPrimaryFacility;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.spi.facility.SpiDataArea;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityException;
import com.sap.tc.moin.test.testcase.MoinTestCase;

/**
 * Default {@link TestClient} implementation for the
 * {@link com.sap.tc.moin.repository.core.impl.IpiPrimaryFacility}.
 * 
 * @author D032434
 */
@SuppressWarnings( "nls" )
public class NwdiTestClientImpl extends AbstractTestClient {

    // constant for the base name of the DC property group
    public static final String BASENAME_DC = "DC";

    // DC sub properties
    public static final String SUBPROPERTY_VENDOR = "vendor";

    public static final String SUBPROPERTY_NAME = "name";

    // Default test DCs (are created as DcProjects in IDE scenario in IdeNwdiTestClientImpl)
    public static final VendorNamePair DEFAULT_DC = new VendorNamePair( "test.sap.com", "tc/moin/repository/test" );

    public static final VendorNamePair DEFAULT_DC_2 = new VendorNamePair( "test.sap.com", "tc/moin/repository/test_2" );

    // partition root path
    public static final String PARTITION_ROOT_PATH = "src/moin_unit_test";

    // partition counter
    private int _partitionCounter = 1;

    /**
     * Vendor and name of a Development or Software component. TODO: overwrite
     * equals, hashcode; move to NWDI Facility API
     */
    public static class VendorNamePair {

        private String _vendor;

        private String _name;

        public VendorNamePair( String vendor, String name ) {

            _vendor = vendor;
            _name = name;
        }

        /**
         * @return Returns the name.
         */
        public String getName( ) {

            return _name;
        }

        /**
         * @return Returns the vendor.
         */
        public String getVendor( ) {

            return _vendor;
        }

        /*
         * (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString( ) {

            StringBuffer sb = new StringBuffer( _vendor.length( ) + _name.length( ) + 1 );
            sb.append( _vendor ).append( '/' ).append( _name );
            return sb.toString( );
        }
    }

    public NwdiTestClientImpl( TestClientFactory factory, int userIndex, int clientSpecIndex ) {

        super( factory, userIndex, clientSpecIndex );
    }

    /**
     * @param userId
     * @param password
     * @param clientSpecId
     */
    public NwdiTestClientImpl( String facilityId, String password, String clientSpecId, String dataAreaName, TestClientFactory factory, int userIndex, int clientSpecIndex ) {

        super( facilityId, password, clientSpecId, dataAreaName, factory, userIndex, clientSpecIndex );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.test.fw.AbstractTestClient#getOrCreateClientSpec()
     */
    @Override
    protected ClientSpec getOrCreateClientSpec( ) throws SpiFacilityException {

        // create spi client spec
        SpiClientSpec clientSpec = (SpiClientSpec) getIpiDataArea( ).getClientSpec( getClientId( ) );

        //        if (clientSpec == null) {
        //            clientSpec = getIpiDataArea().createClientSpec(getClientId());
        //            clientSpec.save();
        //        }

        return clientSpec;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.test.fw.TestClient#createPartition(java.lang.String)
     */
    public synchronized ModelPartition getOrCreatePartition( String testName, boolean useCounter ) {

        // look for the first DC in the configuration; if there is none, we use a default
        VendorNamePair dc = DEFAULT_DC;
        //        if (getDcSize() > 0) {
        //            dc = getDcVendorNamePair(3);
        //        }

        // the partition path is set up by the test case name and the current counter + 1
        String partitionPath = PARTITION_ROOT_PATH + "/" + testName;

        // only if useCounter is true though;
        if ( useCounter ) {
            partitionPath = partitionPath + "_" + _partitionCounter;
            _partitionCounter++;
        } else if ( testName == null ) {
            throw new IllegalStateException( "Cannot create or get partition name \"null\" for test client " + this );
        }

        // Take care for partition suffix in PRI:
        partitionPath += MoinTestHelper.TEST_PARTITION_SUFFIX;

        ResourceIdentifierFactory riFactory = getFacility( ).getRIFactory( );
        IpiDataArea dataArea = getIpiDataArea( );
        PRI pri = riFactory.createPri( dataArea.getName( ), dc.toString( ), partitionPath );
        try {
            ModelPartition mp = getConnection( ).getPartition( pri );
            if ( mp == null ) {
                mp = getConnection( ).createPartition( pri );
            }
            return mp;
        } catch ( Exception e ) {
            // don't deal with checked exceptions in test cases
            throw new IllegalStateException( "Failed to create new model partition for MRI " + pri + " and test client " + this, e );
        }
    }

    public synchronized ModelPartition getOrCreatePartitionStable( String testName, String containerName ) {

        // look for the first DC in the configuration; if there is none, we use a default
        // the partition path is set up by the test case name and the current counter + 1
        String partitionPath = PARTITION_ROOT_PATH + "/" + testName;

        if ( testName == null ) {
            throw new IllegalStateException( "Cannot create or get partition name \"null\" for test client " + this );
        }

        // Take care for partition suffix in PRI:
        partitionPath += MoinTestHelper.TEST_PARTITION_SUFFIX;

        ResourceIdentifierFactory riFactory = getFacility( ).getRIFactory( );
        IpiDataArea dataArea = getIpiDataArea( );
        PRI pri = riFactory.createPri( dataArea.getName( ), containerName, partitionPath );
        try {
            ModelPartition mp = getConnection( ).getPartition( pri );
            if ( mp == null ) {
                mp = getConnection( ).createPartition( pri );
            }
            return mp;
        } catch ( Exception e ) {
            // don't deal with checked exceptions in test cases
            throw new IllegalStateException( "Failed to create new model partition for MRI " + pri + " and test client " + this, e );
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.test.fw.TestClient#getOrCreatePartition(java.lang.String)
     */
    public synchronized ModelPartition getOrCreatePartition( String testName ) {

        return getOrCreatePartition( testName, true );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.test.fw.TestClient#getOrCreatePartitionStable(java.lang
     * .String)
     */
    public synchronized ModelPartition getOrCreatePartitionStable( String testPartitionName ) {

        return getOrCreatePartition( testPartitionName, false );
    }

    /**
     * Casts the unspecific data area of the abstract base class to a
     * NwdiDataArea and throws an approrpiate exception if the cast fails.
     * 
     * @return the {@link com.sap.tc.moin.repository.core.impl.DataArea} of this
     * client as {@link IpiDataArea}.
     */
    public IpiDataArea getIpiDataArea( ) {

        try {
            return (IpiDataArea) getDataArea( );
        } catch ( ClassCastException e ) {
            throw new IllegalStateException( "Data area of test client " + this + " must be instance of " + IpiDataArea.class.getName( ) + ", but is instance of " + getDataArea( ).getClass( ).getName( ) );
        }
    }

    public IpiPrimaryFacility getNwdiFacility( ) {

        Facility facility = null;
        try {
            facility = MoinTestCase.getTestHelper( ).getMoin( ).getFacilityById( IpiPrimaryFacility.FACILITY_ID );
            return (IpiPrimaryFacility) facility;
        } catch ( ClassCastException e ) {
            throw new IllegalStateException( "Facility of test client " + this + " must be instance of " + IpiPrimaryFacility.class.getName( ) + ", but is instance of " + facility.getClass( ).getName( ) );
        }
    }

    public Facility getFacility( ) {

        return this.getClientFacility( );
    }

    //    public VendorNamePair getDcVendorNamePair(int index) {
    //
    //        List<PropertyGroupImpl> dcPropertyGroupList = getDcPropertyGroupList();
    //        if (dcPropertyGroupList == null) {
    //            throw new IllegalStateException("Bad test configuration: no DCs specified in "
    //                + MoinTestHelper.getInstance().getTestConfiguration().getName());
    //        }
    //
    //        PropertyGroupImpl dcPropertyGroup = dcPropertyGroupList.get(index);
    //
    //        return new VendorNamePair(dcPropertyGroup.getSubProperties().getProperty(SUBPROPERTY_VENDOR), dcPropertyGroup
    //            .getSubProperties().getProperty(SUBPROPERTY_NAME));
    //
    //    }

    //    public int getDcSize() {
    //
    //        List<PropertyGroupImpl> dcPropertyGroupList = getDcPropertyGroupList();
    //        return dcPropertyGroupList != null ? getDcPropertyGroupList().size() : 0;
    //    }

    //    /**
    //     * @return the property group list for the DC basename
    //     */
    //    protected List<PropertyGroupImpl> getDcPropertyGroupList() {
    //
    //        List<PropertyGroupImpl> dcPropertyGroupList = MoinTestHelper.getInstance().getTestConfiguration()
    //            .getPropertyGroupList(BASENAME_DC);
    //        return dcPropertyGroupList;
    //    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.test.fw.AbstractTestClient#clear()
     */
    @Override
    public synchronized void clear( ) {

        // reset counter
        _partitionCounter = 1;

        // do the rest
        super.clear( );
    }

    public ModelPartition createPartition( String partitionNameFragment ) {

        // look for the first DC in the configuration; if there is none, we use a default
        VendorNamePair dc = DEFAULT_DC;
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

        ResourceIdentifierFactory riFactory = getFacility( ).getRIFactory( );
        SpiDataArea dataArea = getIpiDataArea( );
        PRI pri = riFactory.createPri( dataArea.getName( ), dc.toString( ), partitionPath );
        return getConnection( ).createPartition( pri );
    }

    public String getDefaultContainerName( ) {

        return DEFAULT_DC.toString( );
    }

    public String getContainer2Name( ) {

        return DEFAULT_DC_2.toString( );
    }

}
