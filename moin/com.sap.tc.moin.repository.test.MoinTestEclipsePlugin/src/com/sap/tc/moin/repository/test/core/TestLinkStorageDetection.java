/*
 * Created on 27.01.2005
 */
package com.sap.tc.moin.repository.test.core;

import java.util.List;
import java.util.TreeSet;

import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.AttachesTo;
import com.sap.tc.moin.repository.mmi.model.Contains;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.testcases.case006.C6;
import com.sap.tc.moin.testcases.case006.Case006Package;
import com.sap.tc.moin.testcases.case006.ReferenceAtComponent;

/**
 * Creates a little MOF model and creates links with varying storage (some based
 * on the existence of an exposing reference on the corresponding association
 * end, some based on explicit mark-up).
 * 
 * @author D043530
 */
public class TestLinkStorageDetection extends CoreMoinTest {

    /**
     * A class to which a tag is attached
     */
    private MofClass clazz;

    private JmiHelper jmiHelper;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        ModelPackage mp = (ModelPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );

        clazz = (MofClass) mp.getMofClass( ).refCreateInstance( );
        jmiHelper = getMOINConnection( ).getJmiHelper( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        clazz = null;
    }

    @Test
    public void testLinkWithImplicitStorage( ) {

        Contains c = ( (ModelPackage) clazz.refImmediatePackage( ) ).getContains( );
        Association a = (Association) c.refMetaObject( );

        verify( jmiHelper.isEndStored( 0, a ), "ERROR: only first end of Contains must be stored!" );
    }

    @Test
    public void testLinkWithImplicitNoStorage( ) {

        AttachesTo c = ( (ModelPackage) clazz.refImmediatePackage( ) ).getAttachesTo( );
        Association a = (Association) c.refMetaObject( );

        verify( !jmiHelper.isEndStored( 0, a ) && jmiHelper.isEndStored( 1, a ), "ERROR: only first end of AttachesTo must be stored!" );
    }

    @Test
    public void testLinkWithExplicitStorage( ) {

        C6 c6 = getMOINConnection( ).createElementInPartition( C6.class, null );

        ReferenceAtComponent rc = ( (Case006Package) c6.refImmediatePackage( ) ).getReferenceAtComponent( );
        Association a = (Association) rc.refMetaObject( );

        verify( jmiHelper.isEndStored( 0, a ) && !jmiHelper.isEndStored( 1, a ), "ERROR: only first end of Association must be stored" );
    }

    @Test
    public void testShowAllAssociationsWithDoubleStorage( ) throws Exception {

        String ALL_ASSOCIATIONS = "select assoc, pkg from Model::Association as assoc, Model::Package as pkg where assoc.container = pkg where for pkg ( not name like 'OclGenerated*')";
        Connection connection = getMOINConnection( );
        JmiHelper jmiHelper = connection.getJmiHelper( );
        MQLResultSet resultSet = connection.getMQLProcessor( ).execute( ALL_ASSOCIATIONS );
        RefObject[] refObjects = resultSet.getRefObjects( "assoc" );
        TreeSet<String> result = new TreeSet<String>( );
        boolean doubleStorageFound = false;
        for ( RefObject refObject : refObjects ) {
            Association assoc = (Association) refObject;
            List<AssociationEnd> ends = jmiHelper.getAssociationEnds( assoc );
            String match = "MRI: " + ( (Partitionable) assoc ).get___Mri( ).toString( ) + ", Association: " + assoc.getQualifiedName( ) + " End0: " + ends.get( 0 ).getName( ) + ", End1: " + ends.get( 1 ).getName( );
            if ( jmiHelper.isEndStored( 0, assoc ) && jmiHelper.isEndStored( 1, assoc ) ) {
                doubleStorageFound = true;
                // Use opposite side of ordered end 
                if ( ends.get( 0 ).getMultiplicity( ).isOrdered( ) ) {
                    match += " --> Use non-ordered end as storage end: " + ends.get( 1 ).getName( );
                } else {
                    if ( ends.get( 1 ).getMultiplicity( ).isOrdered( ) ) {
                        match += " --> Use non-ordered end as storage end: " + ends.get( 0 ).getName( );
                    } else {
                        if ( ends.get( 0 ).getAggregation( ) == AggregationKindEnum.COMPOSITE ) {
                            match += " --> Use composite end as storage end: " + ends.get( 0 ).getName( );
                        } else {
                            if ( ends.get( 1 ).getAggregation( ) == AggregationKindEnum.COMPOSITE ) {
                                match += " --> Use composite end as storage end: " + ends.get( 1 ).getName( );
                            } else {
                                match += " ==> Use most called start-end of nagivation as storage end";
                            }
                        }
                    }
                }
                result.add( match );
            }
        }
        for ( String match : result ) {
            System.out.println( match );
        }

        assertFalse( doubleStorageFound );
    }


}
