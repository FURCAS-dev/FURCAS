package com.sap.tc.moin.primary.facility.test.ide;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.sap.company.CompanyPackage;
import com.sap.company.Employee;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.spi.core.SpiStage;
import com.sap.tc.moin.repository.spi.facility.SpiDataArea;

/**
 * Tests if the core prevents the eviction of dirty partitions on facility
 * triggered events.
 * 
 * @author d024032
 * @author D046220
 */
public class TestDirtyPartitionEviction extends FacilityIdeMoinTest {

    @Test
    public void testDirtyPartitionEviction( ) throws Exception {

        Connection conn = getMoinConnection( );

        ModelPartition mp = this._testClient1.createPartition( "test/partition.xmi" );

        CompanyPackage compPkg = (CompanyPackage) conn.getPackage( CompanyPackage.PACKAGE_DESCRIPTOR );

        Employee emp = mp.createElement( Employee.class );

        CoreConnection coreConn = getTestHelper( ).getCoreConnection( conn );

        String daName = mp.getPri( ).getDataAreaDescriptor( ).getDataAreaName( );

        SpiStage stage = ( (SpiDataArea) this.getFacility( ).getDataAreaByName( daName ) ).getSingleStage( );
        List<PRI> pris = Collections.singletonList( mp.getPri( ) );

        coreConn.getSession( ).getMoin( ).getCore( ).getPartitionService( ).evictPartitions( Collections.singletonMap( stage, pris ) );

        assertTrue( "Partitions is dirty and therefore should not be evicted.", mp.isAlive( ) );
        assertTrue( "The object has been located in a dirty partition and and should be alive after eviction.", ( (Partitionable) emp ).is___Alive( ) );
    }
}
