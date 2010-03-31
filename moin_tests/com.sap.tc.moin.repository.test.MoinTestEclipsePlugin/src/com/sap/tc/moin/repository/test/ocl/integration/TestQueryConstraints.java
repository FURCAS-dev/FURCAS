package com.sap.tc.moin.repository.test.ocl.integration;

import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.Tag;

import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.mql.FromEntry;
import com.sap.tc.moin.repository.mql.FromType;
import com.sap.tc.moin.repository.mql.LocalWhereEntry;
import com.sap.tc.moin.repository.mql.MQLPreparedQuery;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLQuery;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.mql.Operation;
import com.sap.tc.moin.repository.mql.SelectAttrs;
import com.sap.tc.moin.repository.mql.SelectEntry;
import com.sap.tc.moin.repository.mql.WhereEntry;
import com.sap.tc.moin.repository.mql.WhereString;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclTest;

/**
 * @author d022737
 */
public class TestQueryConstraints extends BaseOclTest {

    /**
     * @throws Exception
     */
    @Test
    public void testGetConstraintsViaQuery( ) throws Exception {

        Connection conn = null;
        try {
            conn = this.createConnection( );

            MQLProcessor processor = conn.getMQLProcessor( );

            PRI[] globalPartitionScope = null;

            FromType oclConstraints = new FromType( "constraint", new String[] { "Model", "Constraint" }, "sap.com/tc/moin/mof_1.4", false );
            FromEntry[] fromEntries = new FromEntry[] { oclConstraints };

            // select clause
            SelectAttrs selectEmployeeName = new SelectAttrs( "constraint", new String[] { "name" } );

            SelectEntry[] selectEntries = new SelectEntry[] { selectEmployeeName };

            // where entries
            WhereString whereYoung = new WhereString( "name", Operation.LIKE, "*" );
            WhereEntry whereEmYoung = new LocalWhereEntry( "constraint", whereYoung );
            WhereEntry[] whereEntries = new WhereEntry[] { whereEmYoung };

            // the actual query
            MQLQuery query = new MQLQuery( selectEntries, fromEntries, whereEntries );

            MQLPreparedQuery preparedQuery = processor.prepare( query );

            MQLResultSet constraints = processor.execute( preparedQuery );

            if ( constraints.getSize( ) == 0 ) {
                fail( "No OCL Constraints found" );
            }

            for ( int i = 0; i < constraints.getSize( ); i++ ) {
                MRI mri = constraints.getMri( i, "constraint" );
                Constraint constraint = (Constraint) conn.getElement( mri );
                System.out.println( "Constraint: " + constraint.getQualifiedName( ).toString( ) );

            }
        } finally {
            if ( conn != null ) {
                conn.close( );
                conn = null;
            }
        }
    }

    /**
     * @throws Exception
     */
    @Test
    public void testTagsViaQuery( ) throws Exception {

        Connection conn = null;
        try {
            conn = this.createConnection( );

            MQLProcessor processor = conn.getMQLProcessor( );

            FromType tags = new FromType( "tags", new String[] { "Model", "Tag" }, "sap.com/tc/moin/mof_1.4", false );
            FromEntry[] fromEntries = new FromEntry[] { tags };

            // select clause
            SelectAttrs selectTagId = new SelectAttrs( "tags", new String[] { "tagId" } );
            SelectEntry[] selectEntries = new SelectEntry[] { selectTagId };

            // where entries
            WhereString whereId = new WhereString( "tagId", Operation.EQUAL, "org.omg.sap2mof.constraintCategory" );
            //WhereString whereId = new WhereString("tagId", Operation.EQUAL, "org.omg.sap2mof.deferredConstraintViolationSeverity");
            WhereEntry whereIdEntry = new LocalWhereEntry( "tags", whereId );

            WhereEntry[] whereEntries = new WhereEntry[] { whereIdEntry };

            // the actual query
            MQLQuery query = new MQLQuery( selectEntries, fromEntries, whereEntries );

            MQLPreparedQuery preparedQuery = processor.prepare( query );

            MQLResultSet foundTags = processor.execute( preparedQuery );

            if ( foundTags.getSize( ) == 0 ) {
                fail( "No Tags found" );
            }

            for ( int i = 0; i < foundTags.getSize( ); i++ ) {
                MRI mri = foundTags.getMri( i, "tags" );
                Tag tag = (Tag) conn.getElement( mri );
                System.out.println( "Values: " + tag.getValues( ).toString( ) );
                System.out.println( "Elements: " + tag.getElements( ).toString( ) );

            }
        } finally {
            if ( conn != null ) {
                conn.close( );
                conn = null;
            }
        }
    }
}