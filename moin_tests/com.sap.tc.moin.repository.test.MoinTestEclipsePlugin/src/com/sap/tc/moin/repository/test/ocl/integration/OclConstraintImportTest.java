package com.sap.tc.moin.repository.test.ocl.integration;

import static com.sap.tc.moin.repository.shared.util.MoinSystemPropertyKeys.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.Namespace;

import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclIntegrationTest;

/**
 * This will force the ServiceInteraction metamodel import. Depending on System property "moin.importOclConstraint", the
 * constraints contained in this meatmodel will be imported and converted into OCL constraints.
 * 
 * @author d022737
 */
public class OclConstraintImportTest extends BaseOclIntegrationTest {

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( true );
    }

    /**
     * Just see if the constraints are there
     * 
     * @throws Exception
     */
    @Test
    public void testServiceInteractionConstraintsFound( ) throws Exception {

        Connection conn = this.createConnection( );
        try {
            if ( this.getConstraints( this.createConnection( ), "ServiceInteractions" ).size( ) == 0 ) {
                errorAndStop( "No constraints found" );
            }
        } finally {
            conn.close( );
        }
    }

    // /**
    // * Just see if the constraints are there
    // *
    // * @throws Exception
    // */
    // @Test public void testCompanyConstraintsFound() throws Exception {
    //
    // Connection conn = this.createConnection();
    // try {
    // if (this.getConstraints(this.createConnection(), "Company").size() == 0) {
    // errorAndStop("No constraints found");
    // }
    // } finally {
    // conn.close();
    // }
    // }

    @SuppressWarnings( "unchecked" )
    private Set getConstraints( Connection connection, String topLevelPackageName ) throws Exception {

        String[] pkgName;
        String className;

        boolean oclConstraints = "true".equalsIgnoreCase( System.getProperty( MOIN_IMPORT_OCL_CONSTRAINTS, "false" ) );

        if ( oclConstraints ) {
            // in this case, we want to find OCL constraints (parsed ones)
            pkgName = new String[] { "OCL", "Attaching" };
            className = "OclConstraint";
        } else {
            // here we look for the unparsed constraints
            pkgName = new String[] { "Model" };
            className = "Constraint";
        }

        Set resultset = new HashSet( );
        // RefPackage pkg = connection.selectRefPackage(new String[] { "ServiceInteractions" });
        // List content = ((com.sap.tc.moin.repository.mmi.model.MofPackage) pkg.refMetaObject()).getContents();
        //
        // this.getConstraints(content, resultset);

        Collection result = connection.getPackage( null, pkgName ).refClass( className ).refAllOfClass( );
        for ( Iterator<Constraint> constraints = result.iterator( ); constraints.hasNext( ); ) {
            Constraint next = constraints.next( );
            if ( next.getQualifiedName( ).get( 0 ).equals( topLevelPackageName ) ) {
                resultset.add( next );
            }
        }

        return resultset;
    }

    private void getConstraints( List content, Set resultset ) {

        Iterator children = content.iterator( );
        while ( children.hasNext( ) ) {
            Object child = children.next( );
            if ( child instanceof Constraint ) {
                resultset.add( child );
            } else if ( child instanceof Namespace ) {
                Namespace childns = (Namespace) child;
                this.getConstraints( childns.getContents( ), resultset );
            }
        }

    }
}
