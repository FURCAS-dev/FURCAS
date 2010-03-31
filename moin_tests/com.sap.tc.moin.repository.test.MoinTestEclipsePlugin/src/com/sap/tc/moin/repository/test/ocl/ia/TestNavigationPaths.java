package com.sap.tc.moin.repository.test.ocl.ia;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.ocl.ia.ImpactAnalyzer;
import com.sap.tc.moin.ocl.ia.events.DeleteET;
import com.sap.tc.moin.ocl.ia.events.DeleteRT;
import com.sap.tc.moin.ocl.ia.events.InsertET;
import com.sap.tc.moin.ocl.ia.events.InsertRT;
import com.sap.tc.moin.ocl.ia.events.InternalEvent;
import com.sap.tc.moin.ocl.ia.events.InternalEventFactory;
import com.sap.tc.moin.ocl.ia.events.UpdateAttribute;
import com.sap.tc.moin.ocl.ia.relevance.NavigationPath;
import com.sap.tc.moin.ocl.ia.relevance.Relevance;
import com.sap.tc.moin.ocl.ia.tag.ExpressionKind;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.impl.OclSerializationException;
import com.sap.tc.moin.repository.test.ocl.ia.helper.BaseDepartmentTest;

/**
 * This class tests the navigation paths created by the IA. To do so for each
 * statement a set of expected navigation paths is supplied which is then
 * compared with the set of navigation paths returned. If the sets are different
 * the test fails and prints the missing statements and the excess statements.
 */
public class TestNavigationPaths extends BaseDepartmentTest {

    private class RelevanceImpl extends Relevance {

        /**
         * @param stmt
         * @param event
         */
        public RelevanceImpl( OclStatement stmt, InternalEvent event ) {

            super( stmt, event );
        }

    }

    private static final ExpressionKind INSTANCE = ExpressionKind.INSTANCE;

    private static final ExpressionKind CLASS = ExpressionKind.CLASS;

    // we use the InternalEventFactory, so we can create InternalEvents here
    // and compare them to the events created by the IA
    private InternalEventFactory eventFactory = new InternalEventFactory( );

    /**
     * Tests the navigation paths for the bossHighestSalary constraint.
     * 
     * @throws Exception
     */
    @Test
    public void testBossHighestSalary( ) throws Exception {

        // context Department inv BossHighestSalary:
        // self.employee->select(
        // e|e.salary >= self.boss.salary)->size() <= 1
        // build expected relevance
        HashSet<Relevance> relevances = new HashSet<Relevance>( );
        // InsertET<Department>
        InsertET iET = this.eventFactory.createInsertET( this.department );
        Relevance rel = new RelevanceImpl( this.bossHighestSalaryAST, iET );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // InsertRT(employee)
        InsertRT iRT = this.eventFactory.createInsertRT( coreConnection, this.employeeRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.bossHighestSalaryAST, iRT );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );
        // DeleteRT(employee)
        DeleteRT dRT = this.eventFactory.createDeleteRT( coreConnection, this.employeeRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.bossHighestSalaryAST, dRT );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // InsertRT(boss)
        iRT = this.eventFactory.createInsertRT( coreConnection, this.bossRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.bossHighestSalaryAST, iRT );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );
        // DeleteRT(boss)
        dRT = this.eventFactory.createDeleteRT( coreConnection, this.bossRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.bossHighestSalaryAST, dRT );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // UpdateAttribute(salary)
        UpdateAttribute updAttr = this.eventFactory.createUpdateAttribute( coreConnection, this.employeeSalary );
        rel = new RelevanceImpl( this.bossHighestSalaryAST, updAttr );
        rel.setKind( INSTANCE );
        NavigationPath navPath = new NavigationPath( );
        // navpath <self, employee>
        navPath.add( this.employeeRef.getReferencedEnd( coreConnection ) );
        rel.getNavigationPaths( ).add( navPath );
        // navpath <self, boss>
        navPath = new NavigationPath( );
        navPath.add( this.bossRef.getReferencedEnd( coreConnection ) );
        rel.getNavigationPaths( ).add( navPath );
        relevances.add( rel );

        // start the test
        checkNavPaths( this.bossHighestSalaryAST, relevances );
    }

    /**
     * Tests the navigation paths for the NotBossFreeance constraint.
     * 
     * @throws Exception
     */
    @Test
    public void testNotBossFreelance( ) throws Exception {

        // context Department
        // inv NotBossFreelance:
        // not self.boss.oclIsTypeOf(Freelance)

        // build expected relevance
        HashSet<Relevance> relevances = new HashSet<Relevance>( );
        // InsertET<Department>
        InsertET iET = this.eventFactory.createInsertET( this.department );
        Relevance rel = new RelevanceImpl( this.notBossFreelanceAST, iET );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // InsertRT(boss)
        InsertRT iRT = this.eventFactory.createInsertRT( coreConnection, this.bossRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.notBossFreelanceAST, iRT );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // DeleteRT(boss)
        DeleteRT dRT = this.eventFactory.createDeleteRT( coreConnection, this.bossRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.notBossFreelanceAST, dRT );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // start the test
        checkNavPaths( this.notBossFreelanceAST, relevances );
    }

    /**
     * Tests the navigation paths of the OldEmployee constraint.
     * 
     * @throws Exception
     */
    @Test
    public void testOldEmployee( ) throws Exception {

        // context Department
        // inv OldEmployee:
        // self.employee->exists(e | e.age > 45)

        // build expected relevance
        HashSet<Relevance> relevances = new HashSet<Relevance>( );

        // InsertET<Department>
        InsertET iET = this.eventFactory.createInsertET( this.department );
        Relevance rel = new RelevanceImpl( this.oldEmployeeAST, iET );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // InsertRT(employee)
        InsertRT iRT = this.eventFactory.createInsertRT( coreConnection, this.employeeRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.oldEmployeeAST, iRT );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // DeleteRT(employee)
        DeleteRT dRT = this.eventFactory.createDeleteRT( coreConnection, this.employeeRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.oldEmployeeAST, dRT );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // UpdateAttribute(age)
        UpdateAttribute updAttr = this.eventFactory.createUpdateAttribute( coreConnection, this.employeeAge );
        rel = new RelevanceImpl( this.oldEmployeeAST, updAttr );
        rel.setKind( INSTANCE );
        NavigationPath navPath = new NavigationPath( );
        // navpath <self, employee>
        navPath.add( this.employeeRef.getReferencedEnd( coreConnection ) );
        rel.getNavigationPaths( ).add( navPath );
        relevances.add( rel );

        // start the test
        checkNavPaths( this.oldEmployeeAST, relevances );
    }

    /**
     * Tests the navigation paths of the UniqueNames constraint.
     * 
     * @throws Exception
     */
    @Test
    public void testUniqueNames( ) throws Exception {

        // context Employee
        // inv UniqueNames:
        // Employee.allInstances()->forAll(e |
        // e <> self implies e.name <> self.name)

        // build expected relevance
        HashSet<Relevance> relevances = new HashSet<Relevance>( );

        // InsertET<Employee>
        InsertET iET = this.eventFactory.createInsertET( this.employee );
        Relevance rel = new RelevanceImpl( this.uniqueNamesAST, iET );
        rel.setKind( CLASS );
        relevances.add( rel );

        // DeleteET<Employee>
        DeleteET dET = this.eventFactory.createDeleteET( this.employee );
        rel = new RelevanceImpl( this.uniqueNamesAST, dET );
        rel.setKind( CLASS );
        relevances.add( rel );

        // InsertET<Freelance>
        iET = this.eventFactory.createInsertET( this.freelance );
        rel = new RelevanceImpl( this.uniqueNamesAST, iET );
        rel.setKind( CLASS );
        relevances.add( rel );

        // DeleteET<Freelance>
        dET = this.eventFactory.createDeleteET( this.freelance );
        rel = new RelevanceImpl( this.uniqueNamesAST, dET );
        rel.setKind( CLASS );
        relevances.add( rel );

        // InsertET<Student>
        iET = this.eventFactory.createInsertET( this.student );
        rel = new RelevanceImpl( this.uniqueNamesAST, iET );
        rel.setKind( CLASS );
        relevances.add( rel );

        // DeleteET<Student>
        dET = this.eventFactory.createDeleteET( this.student );
        rel = new RelevanceImpl( this.uniqueNamesAST, dET );
        rel.setKind( CLASS );
        relevances.add( rel );

        // UpdateAttribute(name)
        UpdateAttribute updAttr = this.eventFactory.createUpdateAttribute( coreConnection, this.employeeName );
        rel = new RelevanceImpl( this.uniqueNamesAST, updAttr );
        rel.setKind( CLASS );
        relevances.add( rel );

        // start the test
        checkNavPaths( this.uniqueNamesAST, relevances );
    }

    /**
     * Tests the navigation paths of the ValidAssignment constraint.
     * 
     * @throws Exception
     */
    @Test
    public void testValidAssignment( ) throws Exception {

        // context Freelance
        // inv ValidAssignment:
        // self.assignment >= 5 and self.assignment <= 30

        // build expected relevance
        HashSet<Relevance> relevances = new HashSet<Relevance>( );

        // InsertET<Freelance>
        InsertET iET = this.eventFactory.createInsertET( this.freelance );
        Relevance rel = new RelevanceImpl( this.validAssignmentAST, iET );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // UpdateAttribute(assignment)
        UpdateAttribute updAttr = this.eventFactory.createUpdateAttribute( coreConnection, this.freelanceAssignment );
        rel = new RelevanceImpl( this.validAssignmentAST, updAttr );
        rel.setKind( INSTANCE );
        NavigationPath navPath = new NavigationPath( );
        // navpath <self>
        rel.getNavigationPaths( ).add( navPath );
        relevances.add( rel );

        // start the test
        checkNavPaths( this.validAssignmentAST, relevances );
    }

    /**
     * Tests the navigation paths of the Boss10YearsOlderThanJunior constraint.
     * 
     * @throws Exception
     */
    @Test
    public void testBoss10YearsOlderThanJunior( ) throws Exception {

        // context Department
        // inv tupleTest:
        // let t=Tuple(boss=self.boss,
        // junior=self.employee->sortedBy(age)->first()) in
        // t.boss.age > t.junior.age + 10
        // build expected relevance
        HashSet<Relevance> relevances = new HashSet<Relevance>( );

        // InsertET<Department>
        InsertET iET = this.eventFactory.createInsertET( this.department );
        Relevance rel = new RelevanceImpl( this.boss10YearsOlderThanJuniorAST, iET );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // InsertRT(employee)
        InsertRT iRT = this.eventFactory.createInsertRT( coreConnection, this.employeeRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.boss10YearsOlderThanJuniorAST, iRT );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // DeleteRT(employee)
        DeleteRT dRT = this.eventFactory.createDeleteRT( coreConnection, this.employeeRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.boss10YearsOlderThanJuniorAST, dRT );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // UpdateAttribute(age)
        UpdateAttribute updAttr = this.eventFactory.createUpdateAttribute( coreConnection, this.employeeAge );
        rel = new RelevanceImpl( this.boss10YearsOlderThanJuniorAST, updAttr );
        rel.setKind( INSTANCE );
        NavigationPath navPath = new NavigationPath( );
        // navpath <self, employee>
        navPath.add( this.employeeRef.getReferencedEnd( coreConnection ) );
        rel.getNavigationPaths( ).add( navPath );
        navPath = new NavigationPath( );
        // navpath <self, boss>
        navPath.add( this.bossRef.getReferencedEnd( coreConnection ) );
        rel.getNavigationPaths( ).add( navPath );
        relevances.add( rel );

        // InsertRT(boss)
        iRT = this.eventFactory.createInsertRT( coreConnection, this.bossRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.boss10YearsOlderThanJuniorAST, iRT );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // DeleteRT(boss)
        dRT = this.eventFactory.createDeleteRT( coreConnection, this.bossRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.boss10YearsOlderThanJuniorAST, dRT );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // start the test
        checkNavPaths( this.boss10YearsOlderThanJuniorAST, relevances );
    }

    /**
     * Tests the navigation paths of the MaxJuniors constraint.
     * 
     * @throws Exception
     */
    @Test
    public void testMaxJuniors( ) throws Exception {

        // context Department inv MaxJuniors:
        // self.employee->select(e|e.age < 15)->size() < self.maxJuniors

        // build expected relevance
        HashSet<Relevance> relevances = new HashSet<Relevance>( );

        // InsertET<Department>
        InsertET iET = this.eventFactory.createInsertET( this.department );
        Relevance rel = new RelevanceImpl( this.maxJuniorsAST, iET );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // InsertRT(employee)
        InsertRT iRT = this.eventFactory.createInsertRT( coreConnection, this.employeeRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.maxJuniorsAST, iRT );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // DeleteRT(employee)
        DeleteRT dRT = this.eventFactory.createDeleteRT( coreConnection, this.employeeRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.maxJuniorsAST, dRT );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // UpdateAttribute(age)
        UpdateAttribute updAttr = this.eventFactory.createUpdateAttribute( coreConnection, this.employeeAge );
        rel = new RelevanceImpl( this.maxJuniorsAST, updAttr );
        rel.setKind( INSTANCE );
        NavigationPath navPath = new NavigationPath( );
        // navpath <self, employee>
        navPath.add( this.employeeRef.getReferencedEnd( coreConnection ) );
        rel.getNavigationPaths( ).add( navPath );
        relevances.add( rel );

        // UpdateAttribute(maxJuniors)
        updAttr = this.eventFactory.createUpdateAttribute( coreConnection, this.departmentMaxJuniors );
        rel = new RelevanceImpl( this.maxJuniorsAST, updAttr );
        rel.setKind( INSTANCE );
        navPath = new NavigationPath( );
        // navpath <self>
        rel.getNavigationPaths( ).add( navPath );
        relevances.add( rel );

        // start the test
        checkNavPaths( this.maxJuniorsAST, relevances );
    }

    /**
     * Tests the navigation paths of the BossIsOldest constraint.
     * 
     * @throws Exception
     */
    @Test
    public void testBossIsOldest( ) throws Exception {

        // context Employee inv BossIsOldest:
        // self.age <= self.employer.boss.age

        // build expected relevance
        HashSet<Relevance> relevances = new HashSet<Relevance>( );

        // InsertET<Employee>
        InsertET iET = this.eventFactory.createInsertET( this.employee );
        Relevance rel = new RelevanceImpl( this.bossIsOldestAST, iET );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // InsertET<Freelance>
        iET = this.eventFactory.createInsertET( this.freelance );
        rel = new RelevanceImpl( this.bossIsOldestAST, iET );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // InsertET<Student>
        iET = this.eventFactory.createInsertET( this.student );
        rel = new RelevanceImpl( this.bossIsOldestAST, iET );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // InsertRT(employer)
        InsertRT iRT = this.eventFactory.createInsertRT( coreConnection, this.employerRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.bossIsOldestAST, iRT );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // DeleteRT(employer)
        DeleteRT dRT = this.eventFactory.createDeleteRT( coreConnection, this.employerRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.bossIsOldestAST, dRT );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // InsertRT(boss)
        iRT = this.eventFactory.createInsertRT( coreConnection, this.bossRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.bossIsOldestAST, iRT );
        rel.setKind( INSTANCE );
        NavigationPath navPath = new NavigationPath( );
        navPath.add( this.employerRef.getReferencedEnd( coreConnection ) );
        rel.getNavigationPaths( ).add( navPath );
        relevances.add( rel );

        // DeleteRT(boss)
        dRT = this.eventFactory.createDeleteRT( coreConnection, this.bossRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.bossIsOldestAST, dRT );
        rel.setKind( INSTANCE );
        navPath = new NavigationPath( );
        navPath.add( this.employerRef.getReferencedEnd( coreConnection ) );
        rel.getNavigationPaths( ).add( navPath );
        relevances.add( rel );

        // UpdateAttribute(age)
        UpdateAttribute updAttr = this.eventFactory.createUpdateAttribute( coreConnection, this.employeeAge );
        rel = new RelevanceImpl( this.bossIsOldestAST, updAttr );
        rel.setKind( INSTANCE );
        navPath = new NavigationPath( );
        // navpath <self, employer, boss>
        navPath.add( this.employerRef.getReferencedEnd( coreConnection ) );
        navPath.add( this.bossRef.getReferencedEnd( coreConnection ) );
        rel.getNavigationPaths( ).add( navPath );
        // navpaths <self>
        navPath = new NavigationPath( );
        rel.getNavigationPaths( ).add( navPath );
        relevances.add( rel );

        // start the test
        checkNavPaths( this.bossIsOldestAST, relevances );
    }

    /**
     * Tests the navigation paths of the nasty constraint.
     * 
     * @throws Exception
     */
    @Test
    public void testNastyConstraint( ) throws Exception {

        // context Division
        // inv nasty:
        // self.department->collect(d|d.employee->including(d.boss)).salary->sum()

        // build expected relevance
        HashSet<Relevance> relevances = new HashSet<Relevance>( );

        // InsertET<Division>
        InsertET iET = this.eventFactory.createInsertET( this.division );
        Relevance rel = new RelevanceImpl( this.nastyConstraintAST, iET );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // InsertRT<department>
        InsertRT iRT = this.eventFactory.createInsertRT( coreConnection, this.departmentRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.nastyConstraintAST, iRT );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );
        // DeleteRT<department>
        DeleteRT dRT = this.eventFactory.createDeleteRT( coreConnection, this.departmentRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.nastyConstraintAST, dRT );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // InsertRT(employee)
        iRT = this.eventFactory.createInsertRT( coreConnection, this.employeeRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.nastyConstraintAST, iRT );
        rel.setKind( INSTANCE );
        NavigationPath navPath = new NavigationPath( );
        navPath.add( this.departmentRef.getReferencedEnd( coreConnection ) );
        rel.getNavigationPaths( ).add( navPath );
        relevances.add( rel );

        // DeleteRT(employee)
        dRT = this.eventFactory.createDeleteRT( coreConnection, this.employeeRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.nastyConstraintAST, dRT );
        rel.setKind( INSTANCE );
        navPath = new NavigationPath( );
        navPath.add( this.departmentRef.getReferencedEnd( coreConnection ) );
        rel.getNavigationPaths( ).add( navPath );
        relevances.add( rel );

        // InsertRT<boss>
        iRT = this.eventFactory.createInsertRT( coreConnection, this.bossRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.nastyConstraintAST, iRT );
        rel.setKind( INSTANCE );
        navPath = new NavigationPath( );
        navPath.add( this.departmentRef.getReferencedEnd( coreConnection ) );
        rel.getNavigationPaths( ).add( navPath );
        relevances.add( rel );
        // DeleteRT<boss>
        dRT = this.eventFactory.createDeleteRT( coreConnection, this.bossRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.nastyConstraintAST, dRT );
        rel.setKind( INSTANCE );
        navPath = new NavigationPath( );
        navPath.add( this.departmentRef.getReferencedEnd( coreConnection ) );
        rel.getNavigationPaths( ).add( navPath );
        relevances.add( rel );
        // UpdateAttribute(salary)
        UpdateAttribute updAttr = this.eventFactory.createUpdateAttribute( coreConnection, this.employeeSalary );
        rel = new RelevanceImpl( this.nastyConstraintAST, updAttr );
        rel.setKind( INSTANCE );
        navPath = new NavigationPath( );
        // navpath <self, department, employee>
        navPath.add( this.departmentRef.getReferencedEnd( coreConnection ) );
        navPath.add( this.employeeRef.getReferencedEnd( coreConnection ) );
        rel.getNavigationPaths( ).add( navPath );
        // navpath <self, department, boss>
        navPath = new NavigationPath( );
        navPath.add( this.departmentRef.getReferencedEnd( coreConnection ) );
        navPath.add( this.bossRef.getReferencedEnd( coreConnection ) );
        rel.getNavigationPaths( ).add( navPath );
        relevances.add( rel );
        // UpdateAttribute(budget)
        updAttr = this.eventFactory.createUpdateAttribute( coreConnection, this.divisionBudget );
        rel = new RelevanceImpl( this.nastyConstraintAST, updAttr );
        rel.setKind( INSTANCE );
        navPath = new NavigationPath( );
        // navpath <self>
        rel.getNavigationPaths( ).add( navPath );
        relevances.add( rel );

        checkNavPaths( this.nastyConstraintAST, relevances );
    }

    /**
     * @throws Exception
     */
    @Test
    public void testDivBossSecretary( ) throws Exception {

        // context Employee
        // inv divBossSecretary:
        // if self.directed->isEmpty() then
        // not self.secretary.oclIsUndefined() else
        // self.secretary.oclIsUndefined() endif
        HashSet<Relevance> relevances = new HashSet<Relevance>( );
        // insertET<Employee>
        InsertET iET = this.eventFactory.createInsertET( this.employee );
        Relevance rel = new RelevanceImpl( this.divisionBossSecretaryAST, iET );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // insertET<Freelance>
        iET = this.eventFactory.createInsertET( this.freelance );
        rel = new RelevanceImpl( this.divisionBossSecretaryAST, iET );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // insertET<Student>
        iET = this.eventFactory.createInsertET( this.student );
        rel = new RelevanceImpl( this.divisionBossSecretaryAST, iET );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // insertRT<directed>
        InsertRT iRT = this.eventFactory.createInsertRT( coreConnection, this.directedRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.divisionBossSecretaryAST, iRT );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );
        // deleteRT<directed>
        DeleteRT dRT = this.eventFactory.createDeleteRT( coreConnection, this.directedRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.divisionBossSecretaryAST, dRT );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // updateAttribute(Employee, secretary)
        UpdateAttribute updAttr = this.eventFactory.createUpdateAttribute( coreConnection, this.employeeSecretary );
        rel = new RelevanceImpl( this.divisionBossSecretaryAST, updAttr );
        rel.setKind( INSTANCE );
        // navpath <self>
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        checkNavPaths( this.divisionBossSecretaryAST, relevances );
    }

    /**
     * This test tests the reverse navigation through attributes
     * 
     * @throws Exception
     */
    @Test
    public void testSecretaryOlderThanBoss( ) throws Exception {

        // context Employee
        // inv secretaryOlderThanBoss:
        // if self.directed->notEmpty() and
        // not self.secretary.oclIsUndefined() then
        // self.age < self.secretary.age else true endif

        HashSet<Relevance> relevances = new HashSet<Relevance>( );
        // insertET<Employee>
        InsertET iET = this.eventFactory.createInsertET( this.employee );
        Relevance rel = new RelevanceImpl( this.secretaryOlderThanBossAST, iET );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // insertET<Freelance>
        iET = this.eventFactory.createInsertET( this.freelance );
        rel = new RelevanceImpl( this.secretaryOlderThanBossAST, iET );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // insertET<Student>
        iET = this.eventFactory.createInsertET( this.student );
        rel = new RelevanceImpl( this.secretaryOlderThanBossAST, iET );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // insertRT<directed>
        InsertRT iRT = this.eventFactory.createInsertRT( coreConnection, this.directedRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.secretaryOlderThanBossAST, iRT );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );
        // deleteRT<directed>
        DeleteRT dRT = this.eventFactory.createDeleteRT( coreConnection, this.directedRef.getReferencedEnd( coreConnection ) );
        rel = new RelevanceImpl( this.secretaryOlderThanBossAST, dRT );
        rel.setKind( INSTANCE );
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // updateAttribute(Employee, secretary)
        UpdateAttribute updAttr = this.eventFactory.createUpdateAttribute( coreConnection, this.employeeSecretary );
        rel = new RelevanceImpl( this.secretaryOlderThanBossAST, updAttr );
        rel.setKind( INSTANCE );
        // navpath <self>
        rel.getNavigationPaths( ).add( new NavigationPath( ) );
        relevances.add( rel );

        // updateAttribute(Employee, age)
        updAttr = this.eventFactory.createUpdateAttribute( coreConnection, this.employeeAge );
        rel = new RelevanceImpl( this.secretaryOlderThanBossAST, updAttr );
        rel.setKind( INSTANCE );
        // navpath <self, secretary>
        NavigationPath navPath = new NavigationPath( );
        navPath.add( this.employeeSecretary );
        rel.getNavigationPaths( ).add( navPath );
        // navpath <self>
        navPath = new NavigationPath( );
        rel.getNavigationPaths( ).add( navPath );

        relevances.add( rel );

        checkNavPaths( this.secretaryOlderThanBossAST, relevances );
    }

    /**
     * Anaylzes stmt and compares the returned navigation paths with the set of
     * expected navigation paths.
     * 
     * @param stmt the statement to analyze
     * @param expectedNavPaths the set of expected navigation paths
     * @throws Exception
     */
    private void checkNavPaths( OclStatement stmt, HashSet<Relevance> expectedNavPaths ) throws Exception {

        this.info( "==============================================================\n" );
        this.info( "checking navigation paths for:\n" );
        this.info( this.serializerNoPackageNames.serialize( stmt ) + "\n" );
        this.info( "\n" );
        synchronized ( this.syncObjectForWrite ) {
            ImpactAnalyzer ia = new ImpactAnalyzer( false );
            Set<OclStatement> stmts = new HashSet<OclStatement>( );
            stmts.add( stmt );
            ia.analyze( stmts, this.myJmiCreator );
            HashSet<Relevance> relevances = ia.testingGetRelevances( );

            compareRelevance( expectedNavPaths, relevances );
        }
        this.info( "\n" );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.jtools.jver.framework.Test#prepare()
     */
    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
    }

    /**
     * Checks whether the two sets of relevances are equivalent. If they are not
     * equivalent, the missing and the excess relevances are printed out.
     * 
     * @param expectedRelevances
     * @param actualRelevances
     */
    private void compareRelevance( HashSet<Relevance> expectedRelevances, HashSet<Relevance> actualRelevances ) {

        if ( expectedRelevances.equals( actualRelevances ) ) {
            // print out the returned relevances
            for ( Iterator<Relevance> i = actualRelevances.iterator( ); i.hasNext( ); ) {
                Relevance r = i.next( );

                Set<OclStatement> revNavPaths = r.turnIntoOcl( r.getStmt( ).getContext( ), this.myJmiCreator );
                for ( Iterator<OclStatement> i2 = revNavPaths.iterator( ); i2.hasNext( ); ) {
                    OclStatement s = i2.next( );
                    try {
                        this.info( "" + r.toString( ) + "\n" );
                        this.info( "" + this.serializerNoPackageNames.serialize( s ) + "\n" );
                    } catch ( OclSerializationException e ) {
                        e.printStackTrace( );
                    }
                }
            }

            this.info( ">>SUCCESS\n" );
            this.info( "\n" );
        } else {
            // print out missing relevances
            this.info( "Missing Relevances:\n" );
            HashSet<Relevance> missing = (HashSet) expectedRelevances.clone( );
            missing.removeAll( actualRelevances );
            for ( Iterator<Relevance> i = missing.iterator( ); i.hasNext( ); ) {
                this.info( "  " + i.next( ).toString( ) + "\n" );
            }
            this.info( "\n" );
            // print out excess relevances
            this.info( "Excess Relevances:\n" );
            HashSet<Relevance> exess = (HashSet) actualRelevances.clone( );
            exess.removeAll( expectedRelevances );
            for ( Iterator<Relevance> i = exess.iterator( ); i.hasNext( ); ) {
                this.info( "  " + i.next( ).toString( ) + "\n" );
            }
            this.info( ">>FAILURE\n" );
            this.info( "\n" );
            flop( "Too many or missing relevances." );
        }
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        this.eventFactory = null;
        super.afterTestMethod( );
    }
}
