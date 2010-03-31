/**
 * 
 */
package com.sap.tc.moin.repository.test.core;

import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case008.A8;
import com.sap.tc.moin.testcases.case008.Case008Package;
import com.sap.tc.moin.testcases.case008.S8;

/**
 * This test is only used to provide comparison figures between RefObjects and
 * RefStructs. We provide creation-times, time required to add elements into a
 * multi-valued attribute/association and time required to access the elements.
 * 
 * @author d045996
 */
public class TestStructs extends CoreMoinTest {

    private TestcasesPackage tp;

    private ModelPartition partition;

    private ModelPackage mofModelPackage;

    private final int objectCount = 10000;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        // make sure you get a new clean partition
        partition = getPartitionOne( );
        if ( !partition.getElements( ).isEmpty( ) ) {
            partition.deleteElements( );
            getMOINConnection( ).save( );
        }
        tp = (TestcasesPackage) getMOINConnection( ).getPackage( TestMetaModels.TESTCASES_CN, TestMetaModels.TESTCASES_TPE );

        mofModelPackage = (ModelPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );

    }

    @Test
    public void testStructCreate( ) throws NullPartitionNotEmptyException, PartitionsNotSavedException {

        Connection connection = getMOINConnection( );
        emptyTransientPartitions( connection );

        A8 a8 = connection.createElementInPartition( A8.class, null );
        ( (Partitionable) a8 ).assign___PartitionIncludingChildren( partition );
        Case008Package s8C = tp.getCase008( );

        long time = System.currentTimeMillis( );
        for ( int i = 0; i < objectCount; i++ ) {
            StructureFieldContainer<S8> contS8 = new StructureFieldContainer<S8>( );
            contS8.put( S8.DESCRIPTORS.FIELD1( ), 1 ).put( S8.DESCRIPTORS.FIELD2( ), "1" );
            s8C.createS8( contS8 );
        }
        System.out.println( "Create Time: " + ( System.currentTimeMillis( ) - time ) );

    }

    @Test
    public void testStructCreateAndAdd( ) throws NullPartitionNotEmptyException, PartitionsNotSavedException {

        Connection connection = getMOINConnection( );
        emptyTransientPartitions( connection );

        A8 a8 = connection.createElementInPartition( A8.class, null );
        ( (Partitionable) a8 ).assign___PartitionIncludingChildren( partition );
        Case008Package s8C = tp.getCase008( );
        Collection<S8> manyStructureS = a8.getManyStructureS( );

        long time = System.currentTimeMillis( );
        for ( int i = 0; i < objectCount; i++ ) {
            StructureFieldContainer<S8> contS8 = new StructureFieldContainer<S8>( );
            contS8.put( S8.DESCRIPTORS.FIELD1( ), 1 ).put( S8.DESCRIPTORS.FIELD2( ), "1" );
            manyStructureS.add( s8C.createS8( contS8 ) );
        }
        System.out.println( "Create and Add Time: " + ( System.currentTimeMillis( ) - time ) );

        time = System.currentTimeMillis( );
        for ( S8 s8 : manyStructureS ) {

            s8.getField1( );
            s8.getField2( );
        }
        System.out.println( "Read Time: " + ( System.currentTimeMillis( ) - time ) );

    }

    @Test
    public void testObjectCreate( ) throws NullPartitionNotEmptyException, PartitionsNotSavedException {

        Connection connection = getMOINConnection( );
        emptyTransientPartitions( connection );

        MofClass c1 = (MofClass) mofModelPackage.getMofClass( ).refCreateInstance( );
        ( (Partitionable) c1 ).assign___PartitionIncludingChildren( partition );
        RefClass constC = mofModelPackage.getConstraint( );

        long time = System.currentTimeMillis( );
        for ( int i = 0; i < objectCount; i++ ) {
            Constraint constraint = (Constraint) constC.refCreateInstance( );
            constraint.setName( "co1" );
            constraint.setAnnotation( "ano1" );
            constraint.setExpression( null );
            constraint.setLanguage( null );
            constraint.setEvaluationPolicy( null );
        }
        System.out.println( "Create Time: " + ( System.currentTimeMillis( ) - time ) );
    }

    @Test
    public void testObjectCreateAndAdd( ) throws NullPartitionNotEmptyException, PartitionsNotSavedException {

        Connection connection = getMOINConnection( );
        emptyTransientPartitions( connection );

        MofClass c1 = (MofClass) mofModelPackage.getMofClass( ).refCreateInstance( );
        ( (Partitionable) c1 ).assign___PartitionIncludingChildren( partition );
        RefClass constC = mofModelPackage.getConstraint( );
        List<ModelElement> contents = c1.getContents( );

        long time = System.currentTimeMillis( );
        for ( int i = 0; i < objectCount; i++ ) {
            Constraint constraint = (Constraint) constC.refCreateInstance( );
            constraint.setName( "co1" );
            constraint.setAnnotation( "ano1" );
            constraint.setExpression( null );
            constraint.setLanguage( null );
            constraint.setEvaluationPolicy( null );
            contents.add( constraint );
        }
        System.out.println( "Create And Add Time: " + ( System.currentTimeMillis( ) - time ) );

        time = System.currentTimeMillis( );
        for ( ModelElement me : contents ) {
            me.getName( );
            me.getAnnotation( );
        }
        System.out.println( "Read Time: " + ( System.currentTimeMillis( ) - time ) );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        partition = null;

    }

    private void emptyTransientPartitions( Connection connection ) {

        for ( ModelPartition transientPartition : connection.getTransientPartitions( ) ) {
            transientPartition.deleteElements( );
        }
    }

}
