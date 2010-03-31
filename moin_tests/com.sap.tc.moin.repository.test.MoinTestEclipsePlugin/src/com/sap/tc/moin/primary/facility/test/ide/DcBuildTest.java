package com.sap.tc.moin.primary.facility.test.ide;

import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;

import org.eclipse.core.resources.IProject;
import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.test.fw.ide.IdeRuntimeTestHelper;

/**
 * Base testcase, providing DC Build functionality.
 * 
 * @author D046220
 */
public class DcBuildTest extends FacilityIdeMoinTest {

    private static final IdeRuntimeTestHelper MOIN_IDE_TEST_HELPER = (IdeRuntimeTestHelper) getTestHelper( );

    @SuppressWarnings( "unchecked" )
    @Test
    public void testBuildDC( ) throws Exception {

        // Create test DC project and initialize MOIN for it:
        String dcVendor = "sap.com";
        String dcName = "test/moin/metamodel/dc";
        IProject eclipseProject = ( (IdeRuntimeTestHelper) getTestHelper( ) ).getOrCreateLocalMoinMetaModelDCProject( dcVendor, dcName );

        ModelPartition part = createPartition( getIdeFacilityDispatcher( ).getClientSpec( eclipseProject ), dcVendor + "/" + dcName, "moin/meta/Metamodel.xmi" );

        Connection moinConnection = getMoinConnection( );

        ModelPackage modelPkg = (ModelPackage) moinConnection.getPackage( null, "Model" );

        MofPackage p1 = (MofPackage) modelPkg.getMofPackage( ).refCreateInstance( );
        p1.setName( "p1" );

        MofClass c1 = (MofClass) modelPkg.getMofClass( ).refCreateInstance( );
        c1.setName( "c1" );

        p1.getContents( ).add( c1 );

        for ( Partitionable p : moinConnection.getNullPartition( ).getElements( ) ) {
            p.assign___Partition( part );
        }

        moinConnection.save( );

        assertFalse( "Build job failed.", MOIN_IDE_TEST_HELPER.getDcBuildUtil( ).executeDcBuildForLocalMMDc( dcVendor, dcName ) );
    }

}
