package com.sap.tc.moin.repository.test.ocl.integration;

import static com.sap.tc.moin.repository.shared.util.MoinSystemPropertyKeys.MOIN_IMPORT_OCL_CONSTRAINTS;
import static com.sap.tc.moin.repository.shared.util.MoinSystemPropertyKeys.OCL_SHOW_JMI_TREE;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;

import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.MoinPackage;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.test.fw.MoinTestHelper;
import com.sap.tc.moin.test.testcase.MoinTestCase;

/**
 * This will force the ServiceInteraction metamodel import. Depending on System
 * property "moin.importOclConstraint", the constraints contained in this
 * meatmodel will be imported and converted into OCL constraints.
 * 
 * @author d022737
 */
public class MofConstraintImportTest extends MoinTestCase {

    private MoinPackage mofPkg;

    private ModelPackage modelPackage;

    private boolean showJmiTree = false;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        boolean oclConstraints = "true".equalsIgnoreCase( System.getProperty( MOIN_IMPORT_OCL_CONSTRAINTS, "false" ) );
        //MoinTestHelper.setTestConfigurationFile( "nwdiTestConfiguration.properties" );
        super.beforeTestMethod( );

        Connection connection = createConnection( );

        this.mofPkg = (MoinPackage) connection.getPackage( MoinPackage.PACKAGE_DESCRIPTOR );
        this.modelPackage = this.mofPkg.getModel( );
        this.showJmiTree = "true".equalsIgnoreCase( System.getProperty( OCL_SHOW_JMI_TREE ) );

        if ( !oclConstraints ) {
            Connection conn = createConnection( );
            Collection<Partitionable> partitionables = ( (CoreConnection) conn ).getNullPartition( ).getElements( );
            if ( !partitionables.isEmpty( ) ) {
                // this could happen if there was some import with immediate constraints before
                // right now, only ServiceInteractions and Company are relevant, so we clenup
                // the transient partition and do a forced reimport
                Set<ModelElement> elements = new HashSet<ModelElement>( );
                for ( Iterator<Partitionable> partIt = partitionables.iterator( ); partIt.hasNext( ); ) {
                    Partitionable next = partIt.next( );
                    if ( next instanceof ModelElement ) {
                        elements.add( (ModelElement) next );
                    }
                }
                for ( ModelElement element : elements ) {
                    try {
                        element.refDelete( );
                    } catch ( RuntimeException e ) {
                        // $JL-EXC$ ignore it
                    }
                }
            }
            conn.close( );
        }
    }

    /**
     * Just see if the constraints are there
     * 
     * @throws Exception
     */
    @Test
    public void testMofConstraintsFound( ) throws Exception {

        Connection conn = this.createConnection( );
        try {
            ( (CoreConnection) conn ).getTopLevelPackages( );
            if ( this.getConstraints( this.createConnection( ), "MOF" ).size( ) == 0 ) {
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
