/*
 * Created on 01.03.2005
 */
package com.sap.tc.moin.repository.test.core;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.company.CompanyPackage;
import com.sap.company.Department;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.test.fw.TestMetaModels;

/**
 * Performs a number of tests on the functionality of the workspace, including
 * model element relocation and partition eviction.
 * 
 * @author D043530
 */
public class TestCreateElement extends CoreMoinTest {

    /**
     * The first model partition
     */
    private ModelPartition mp1;

    /**
     * The second model partition
     */
    private ModelPartition mp2;

    Connection conn;


    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        mp1 = getPartitionOne( );
        mp2 = getPartitionTwo( );
        conn = getMOINConnection( );

    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        this.mp1 = null;
        this.mp2 = null;

        super.afterTestMethod( );
    }

    ////////////////////////
    // Tests
    ////////////////////////

    @Test
    public void testCreateElementWithClassProxyAndPackage( ) throws Exception {

        // Three lines needed
        CompanyPackage cp = (CompanyPackage) getMOINConnection( ).getPackage( TestMetaModels.COMPANY_CN, TestMetaModels.COMPANY_TPE );
        RefClass departmentClass = cp.getDepartment( );
        Department department = (Department) departmentClass.refCreateInstanceInPartition( mp1 );

        // Checks
        assertEquals( mp1.getPri( ), ( (Partitionable) department ).get___Mri( ).getPri( ) );
    }


    @Test
    public void testCreateElementWithClassProxyAndCast( ) throws Exception {

        // Two lines and cast needed
        RefClass departmentClass = conn.getClass( Department.CLASS_DESCRIPTOR );
        Department department = (Department) departmentClass.refCreateInstanceInPartition( mp1 );

        // Checks
        assertEquals( mp1.getPri( ), ( (Partitionable) department ).get___Mri( ).getPri( ) );
    }



    @Test
    public void testCreateElementWithClassProxy( ) throws Exception {

        // Two lines needed. No cast
        RefClass departmentClass = conn.getClass( Department.CLASS_DESCRIPTOR );
        Department department = (Department) departmentClass.refCreateInstanceInPartition( mp1 );

        // Checks
        assertEquals( mp1.getPri( ), ( (Partitionable) department ).get___Mri( ).getPri( ) );
    }



    @Test
    public void testCreateElementWithConnection( ) throws Exception {

        // One line needed. Access to connection required
        Department department = conn.createElementInPartition( Department.CLASS_DESCRIPTOR, mp1 );

        // Checks
        assertEquals( mp1.getPri( ), ( (Partitionable) department ).get___Mri( ).getPri( ) );
    }


    @Test
    public void testCreateElementWithPartition( ) throws Exception {

        // One line needed. No access to connection required. No cast needed
        Department department = mp1.createElement( Department.CLASS_DESCRIPTOR );

        // Checks
        assertEquals( mp1.getPri( ), ( (Partitionable) department ).get___Mri( ).getPri( ) );
    }

    @Test
    public void testCreateElementWithConnectionAndClass( ) throws Exception {

        // One line needed. Access to connection required
        Department department = conn.createElementInPartition( Department.class, mp1 );

        // Checks
        assertEquals( mp1.getPri( ), ( (Partitionable) department ).get___Mri( ).getPri( ) );
    }

    @Test
    public void testCreateElementWithPartitionAndClass( ) throws Exception {

        // One line needed. No access to connection required. No cast needed
        Department department = mp1.createElement( Department.class );

        // Checks
        assertEquals( mp1.getPri( ), ( (Partitionable) department ).get___Mri( ).getPri( ) );
    }


    @Test
    public void testCreateElementInNullPartition( ) throws Exception {

        Department department1 = getMOINConnection( ).createElementInPartition( Department.class, null );
        assertEquals( department1.get___Partition( ), getMOINConnection( ).getNullPartition( ) );

        Department department2 = getMOINConnection( ).createElement( Department.class );
        assertEquals( department2.get___Partition( ), getMOINConnection( ).getNullPartition( ) );

        Department department3 = getMOINConnection( ).createElement( Department.CLASS_DESCRIPTOR );
        assertEquals( department3.get___Partition( ), getMOINConnection( ).getNullPartition( ) );

    }

}