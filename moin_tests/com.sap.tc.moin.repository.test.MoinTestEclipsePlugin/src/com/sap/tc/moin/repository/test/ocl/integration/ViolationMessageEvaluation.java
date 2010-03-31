package com.sap.tc.moin.repository.test.ocl.integration;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.sap.company.CompanyPackage;
import com.sap.company.Department;
import com.sap.company.Division;
import com.sap.company.Employee;
import com.sap.company.Freelance;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ocl.OclRegistryService;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetamodelConstraintRegistry;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatusItem;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclIntegrationTest;
import com.sap.tc.moin.test.fw.TestMetaModels;

public class ViolationMessageEvaluation extends BaseOclIntegrationTest {

    private Freelance createFreelance( Connection conn, java.lang.String name, int age, int salary, com.sap.company.Employee secretary, int assignment ) {

        Freelance freelance = conn.createElementInPartition( Freelance.class, null );
        freelance.setName( name );
        freelance.setAge( age );
        freelance.setSalary( salary );
        freelance.setSecretary( secretary );
        freelance.setAssignment( assignment );
        return freelance;
    }

    private Employee createEmployee( Connection conn, java.lang.String name, int age, int salary, com.sap.company.Employee secretary ) {

        Employee employee = conn.createElementInPartition( Employee.class, null );
        employee.setName( name );
        employee.setAge( age );
        employee.setSalary( salary );
        employee.setSecretary( secretary );
        return employee;
    }

    private Department createDepartment( Connection conn, java.lang.String name, int maxJuniors, int budget ) {

        Department department = conn.createElementInPartition( Department.class, null );
        department.setName( name );
        department.setMaxJuniors( maxJuniors );
        department.setBudget( budget );
        return department;
    }

    private Division createDivision( Connection conn, java.lang.String name, int budget ) {

        Division division = conn.createElementInPartition( Division.class, null );
        division.setName( name );
        division.setBudget( budget );
        return division;
    }

    /**
     *
     */
    @Test
    public void testStringLiteralExpression( ) throws Exception {

        Connection conn = null;
        DeferredConstraintViolationListener deferredListener = null;

        OclMetamodelConstraintRegistry reg = null;
        OclRegistryService srv = null;

        try {
            conn = this.createConnection( );
            srv = conn.getOclRegistryService( );
            reg = srv.getMetamodelConstraintRegistry( );

            reg.registerPartitionBasedConstraintViolationListener( "deferred", deferredListener );

            CompanyPackage companyPackage = (CompanyPackage) conn.getPackage( TestMetaModels.COMPANY_CN, TestMetaModels.COMPANY_TPE );
            Division div1 = createDivision( conn, "FirstDivision", 1000000 );
            Department dep1 = createDepartment( conn, "Department1", 3, 50000 );
            Employee boss1 = createEmployee( conn, "Bond", 52, 6000, null );
            // Boss10YearsOlderThanJunior (a yellow constraint)
            Employee oldEmployee = createEmployee( conn, "Older", 48, 2800, null );

            div1.getDepartment( ).add( dep1 );
            dep1.getEmployee( ).add( oldEmployee );
            dep1.setBoss( boss1 );

            Set<PRI> partitions = new HashSet<PRI>( );
            partitions.add( conn.getNullPartition( ).getPri( ) );

            DeferredConstraintViolationStatus stat = srv.verifyConstraints( dep1 );
            verify( stat.getAll( ).size( ) == 1, "There should have been exactly one message" );
            for ( DeferredConstraintViolationStatusItem item : stat.getAll( ) ) {
                verify( item.getConstraintViolationMessage( ).equals( "The Junior must at least be 10 years younger than the boss" ), "The message does not conform to the expected one: " + item.getConstraintViolationMessage( ) );
            }

        } finally {
            if ( conn != null ) {
                if ( reg != null ) {
                    reg.unregisterDeferredListener( deferredListener );
                }
                conn.close( );
            }
        }
    }

    /**
     *
     */
    @Test
    public void testComposedExpression( ) throws Exception {

        Connection conn = null;
        DeferredConstraintViolationListener deferredListener = null;

        OclMetamodelConstraintRegistry reg = null;
        OclRegistryService srv = null;

        try {
            conn = this.createConnection( );
            srv = conn.getOclRegistryService( );
            reg = srv.getMetamodelConstraintRegistry( );

            reg.registerPartitionBasedConstraintViolationListener( "deferred", deferredListener );

            CompanyPackage companyPackage = (CompanyPackage) conn.getPackage( TestMetaModels.COMPANY_CN, TestMetaModels.COMPANY_TPE );

            Employee boss1 = createEmployee( conn, "Bond", 52, 6000, null );
            Department dep1 = createDepartment( conn, "Department1", 1, 50000 );
            Employee jun1 = createEmployee( conn, "Junior1", 22, 1800, null );
            Employee jun2 = createEmployee( conn, "Junior2", 24, 2000, null );
            Employee oldEmployee = createEmployee( conn, "Older", 48, 2800, null );

            dep1.getEmployee( ).add( jun1 );
            dep1.getEmployee( ).add( jun2 );
            dep1.getEmployee( ).add( oldEmployee );
            dep1.setBoss( boss1 );

            Employee boss2 = createEmployee( conn, "Bond2", 52, 6000, null );
            Department dep2 = createDepartment( conn, "Department2", 1, 50000 );
            Employee jun12 = createEmployee( conn, "Junior12", 22, 1800, null );
            Employee jun22 = createEmployee( conn, "Junior22", 24, 2000, null );
            Employee oldEmployee2 = createEmployee( conn, "Older2", 48, 2800, null );

            dep2.getEmployee( ).add( jun12 );
            dep2.getEmployee( ).add( jun22 );
            dep2.getEmployee( ).add( oldEmployee2 );
            dep2.setBoss( boss2 );

            Set<PRI> partitions = new HashSet<PRI>( );
            partitions.add( conn.getNullPartition( ).getPri( ) );

            DeferredConstraintViolationStatus stat = srv.verifyConstraints( dep1 );
            verify( stat.getErrors( ).size( ) == 1, "There should have been exactly one error" );
            for ( DeferredConstraintViolationStatusItem item : stat.getErrors( ) ) {
                verify( item.getConstraintViolationMessage( ).equals( "Department Department1 has too many Juniors" ), "The message does not conform to the expected one: " + item.getConstraintViolationMessage( ) );
            }

            stat = srv.verifyConstraints( dep2 );
            verify( stat.getErrors( ).size( ) == 1, "There should have been exactly one error" );
            for ( DeferredConstraintViolationStatusItem item : stat.getErrors( ) ) {
                verify( item.getConstraintViolationMessage( ).equals( "Department Department2 has too many Juniors" ), "The message does not conform to the expected one: " + item.getConstraintViolationMessage( ) );
            }

        } finally {
            if ( conn != null ) {
                if ( reg != null ) {
                    reg.unregisterDeferredListener( deferredListener );
                }
                conn.close( );
            }
        }
    }
    // TODO no support for this right now
    // /**
    // *
    // */
    // @Test
    // public void testParameterizedExpression() throws Exception {
    //
    // Connection conn = null;
    // DeferredConstraintViolationListener deferredListener = null;
    //
    // OclMetamodelConstraintRegistry reg = null;
    // OclRegistryService srv = null;
    //
    // try {
    // conn = this.createConnection();
    // srv = conn.getOclRegistryService();
    // reg = srv.getMetamodelConstraintRegistry();
    //
    // reg.registerPartitionBasedConstraintViolationListener("deferred", deferredListener);
    //
    // CompanyPackage companyPackage = (CompanyPackage) conn.getPackage(TestMetaModels.COMPANY_CN,
    // TestMetaModels.COMPANY_TPE);
    //
    // Employee boss1 = companyPackage.getEmployee().createEmployee("Bond", 52, 6000, null);
    // Department dep1 = companyPackage.getDepartment().createDepartment("Department1", 3, 50000);
    // Employee jun1 = companyPackage.getEmployee().createEmployee("Junior1", 22, 1800, null);
    // Employee jun2 = companyPackage.getEmployee().createEmployee("Junior2", 24, 2000, null);
    // Employee oldEmployee = companyPackage.getEmployee().createEmployee("Older", 48, 2800, null);
    //
    // dep1.getEmployee().add(jun1);
    // dep1.getEmployee().add(jun2);
    // dep1.getEmployee().add(oldEmployee);
    // dep1.setBoss(boss1);
    //
    // Set<PRI> partitions = new HashSet<PRI>();
    // partitions.add(conn.getNullPartition().getPri());
    //
    // DeferredConstraintViolationStatus stat = srv.verifyConstraints(dep1);
    // verify(stat.getAll().size() == 1, "There should have been exactly one error");
    // for (DeferredConstraintViolationStatusItem item : stat.getAll()) {
    //
    // verify(
    // item
    // .getConstraintViolationMessage()
    // .equals(
    // "Department 'Department1' is supposed have at most 3 juniors; right now, there are 2 juniors assigned"),
    // "The message does not conform to the expected one: " + item.getConstraintViolationMessage());
    // }
    // } finally {
    // if (conn != null) {
    // if (reg != null) {
    // reg.unregisterDeferredListener(deferredListener);
    // }
    // conn.close();
    // }
    // }
    // }

}
