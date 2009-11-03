/*
 * Created on February 2008
 */
package com.sap.tc.moin.repository.test.core;

import com.sap.tc.moin.repository.mmi.model.MofPackage;

import org.junit.Test;

import com.sap.company.CompanyPackage;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionCreatingNotPossibleException;
import com.sap.tc.moin.repository.PartitionDeletingNotPossibleException;
import com.sap.tc.moin.repository.PartitionEditingNotPossibleException;
import com.sap.tc.moin.repository.Partitionable;

/**
 * @author d024032
 */
public class TestMetaModelOperations extends CoreMoinTest {

    @Test( expected = PartitionEditingNotPossibleException.class )
    public void testModificationOfMetaModelElement( ) {

        MofPackage companyPackage = (MofPackage) getMOINConnection( ).getPackage( CompanyPackage.PACKAGE_DESCRIPTOR ).refMetaObject( );
        companyPackage.setName( "AnotherName" );
    }

    @Test( expected = PartitionDeletingNotPossibleException.class )
    public void testDeletionOfMetaModelPartition( ) {

        ModelPartition partition = ( (Partitionable) getMOINConnection( ).getPackage( CompanyPackage.PACKAGE_DESCRIPTOR ).refMetaObject( ) ).get___Partition( );
        partition.delete( );
    }

    @Test( expected = PartitionCreatingNotPossibleException.class )
    public void testCreationOfMetaModelPartition( ) {

        PRI pri = ( (Partitionable) getMOINConnection( ).getPackage( CompanyPackage.PACKAGE_DESCRIPTOR ).refMetaObject( ) ).get___Partition( ).getPri( );
        Facility facility = getMOINConnection( ).getSession( ).getMoin( ).getFacilityById( pri.getDataAreaDescriptor( ).getFacilityId( ) );
        PRI newPri = facility.getRIFactory( ).createPri( pri.getDataAreaDescriptor( ).getDataAreaName( ), pri.getContainerName( ), "NewPartition.moinmm" );
        getMOINConnection( ).createPartition( pri );
    }
}
