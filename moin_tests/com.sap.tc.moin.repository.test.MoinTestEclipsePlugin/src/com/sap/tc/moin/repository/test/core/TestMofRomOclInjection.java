/*
 * Created on 14.11.2005
 */
package com.sap.tc.moin.repository.test.core;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.MoinPackage;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.impl.WorkspaceSetImpl;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.mql.QueryScopeProvider;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.test.fw.TestMetaModels;

/**
 * Class to test the MOF ROM
 * 
 * @author d024227
 * @author d046220
 */
public class TestMofRomOclInjection extends CoreMoinTest {

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
    }

    @SuppressWarnings( "unchecked" )
    @Test
    public void testGetOclPackageReflective( ) {

        getTestHelper( ).reset( );

        assertNotNull( getMOINConnection( ).getPackage( "sap.com/tc/moin/mof_1.4", "Model" ) );

        CoreConnection coreConn = ( (Wrapper<CoreConnection>) getMOINConnection( ) ).unwrap( );
        WorkspaceSetImpl wsImpl = (WorkspaceSetImpl) coreConn.getSession( ).getWorkspaceSet( );
        //assertFalse( wsImpl.getMoin( ).isSecondStageInjected( ) );

        assertNotNull( getMOINConnection( ).getPackage( "sap.com/tc/moin/mof_1.4", "OCL" ) );
    }

    @SuppressWarnings( "unchecked" )
    @Test
    public void testGetOclPackageGenerated( ) {

        getTestHelper( ).reset( );

        MoinPackage moinPackage = (MoinPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MOIN );

        CoreConnection coreConn = ( (Wrapper<CoreConnection>) getMOINConnection( ) ).unwrap( );
        WorkspaceSet wsImpl = coreConn.getSession( ).getWorkspaceSet( );
        //assertFalse( wsImpl.getMoin( ).isSecondStageInjected( ) );

        assertNotNull( moinPackage.getOcl( ) );

        assertTrue( wsImpl.getMoin( ).isSecondStageInjected( ) );
    }

    @SuppressWarnings( "unchecked" )
    @Test
    public void testGetMetaModelConstraintRegistry( ) {

        getTestHelper( ).reset( );

        CoreConnection coreConn = ( (Wrapper<CoreConnection>) getMOINConnection( ) ).unwrap( );
        WorkspaceSet wsImpl = coreConn.getSession( ).getWorkspaceSet( );
        //assertFalse( wsImpl.getMoin( ).isSecondStageInjected( ) );

        try {
            getMOINConnection( ).getOclRegistryService( ).getMetamodelConstraintRegistry( ).getRegistry( );
        } catch ( OclManagerException e ) {
            fail( e.getMessage( ) );
        }

        assertTrue( wsImpl.getMoin( ).isSecondStageInjected( ) );
    }

    @SuppressWarnings( "unchecked" )
    @Test
    public void testGetMofConstraintRegistry( ) {

        getTestHelper( ).reset( );

        CoreConnection coreConn = ( (Wrapper<CoreConnection>) getMOINConnection( ) ).unwrap( );
        WorkspaceSet wsImpl = coreConn.getSession( ).getWorkspaceSet( );
        //assertFalse( wsImpl.getMoin( ).isSecondStageInjected( ) );

        try {
            getMOINConnection( ).getOclRegistryService( ).getMofConstraintRegistry( ).getAvailableMofConstraints( );
        } catch ( OclManagerException e ) {
            fail( e.getMessage( ) );
        }

        assertTrue( wsImpl.getMoin( ).isSecondStageInjected( ) );
    }

    @SuppressWarnings( "unchecked" )
    @Test
    public void testIndexVisibilityOfMofRom( ) {

        getTestHelper( ).reset( );

        QueryScopeProvider scope = getMOINConnection( ).getMQLProcessor( ).getInclusiveContainerScopeProvider( TestMetaModels.MOIN_MOF_CN );
        String query = "select el from Model::Package as el where for el(name='OCL')";

        CoreConnection coreConn = ( (Wrapper<CoreConnection>) getMOINConnection( ) ).unwrap( );
        WorkspaceSet wsImpl = coreConn.getSession( ).getWorkspaceSet( );

//        wsImpl.getMoin( ).injectSecondMofRomStage( );

        // check that the OCL package is now query visible
        assertFalse( 0 == getMOINConnection( ).getMQLProcessor( ).execute( query, scope ).getSize( ) );

    }

    @Test
    public void testInjectionOfOclOnVariousApiCalls( ) throws Exception {

        getTestHelper( ).reset( );

        CoreConnection coreConn = ( (Wrapper<CoreConnection>) getMOINConnection( ) ).unwrap( );
        WorkspaceSet wsImpl = coreConn.getSession( ).getWorkspaceSet( );
        PRI oclPri = wsImpl.getMoin( ).createPri( "PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/OCL.moinmm" );
        CoreModelPartition oclPartition = coreConn.getPartition( oclPri );
        assertNotNull( oclPartition );

        Partitionable oclElement = oclPartition.getElements( ).iterator( ).next( );
        String mriOfOclElement = oclElement.get___Mri( ).toString( );

        getTestHelper( ).reset( );
        coreConn = ( (Wrapper<CoreConnection>) getMOINConnection( ) ).unwrap( );
        wsImpl = coreConn.getSession( ).getWorkspaceSet( );
        MRI oclElementMri = wsImpl.getMoin( ).createMri( mriOfOclElement );
        RefBaseObject element = coreConn.getElement( oclElementMri );
        assertNotNull( element );

        getTestHelper( ).reset( );
        coreConn = ( (Wrapper<CoreConnection>) getMOINConnection( ) ).unwrap( );
        wsImpl = coreConn.getSession( ).getWorkspaceSet( );
        oclElementMri = wsImpl.getMoin( ).createMri( mriOfOclElement );
        assertTrue( coreConn.elementExists( oclElementMri ) );

        getTestHelper( ).reset( );
        coreConn = ( (Wrapper<CoreConnection>) getMOINConnection( ) ).unwrap( );
        wsImpl = coreConn.getSession( ).getWorkspaceSet( );
        oclElementMri = wsImpl.getMoin( ).createMri( mriOfOclElement );
        assertTrue( coreConn.partitionExists( oclElementMri.getPri( ) ) );
    }

    @Test
    public void testInjectionOfOclOnMqlQueries( ) throws Exception {

        this.getMOINConnection( ).getNullPartition( ).deleteElements( );
        this.getMOINConnection( ).save( );

        // MQL
        String query = "select instance from \"sap.com/tc/moin/mof_1.4\"#Model::Classifier as instance";
        String oclMofId = "45ED2E29CEBECB10A04946802CA69511F9804F44"; // OclExpression mof id

        getTestHelper( ).reset( );

        CoreConnection coreConn = ( (Wrapper<CoreConnection>) getMOINConnection( ) ).unwrap( );
        WorkspaceSet wsImpl = coreConn.getSession( ).getWorkspaceSet( );
        PRI oclPri = wsImpl.getMoin( ).createPri( "PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/OCL.moinmm" );

        MQLProcessor mql = coreConn.getMQLProcessor( );

        QueryScopeProvider scopeProvider = mql.getQueryScopeProvider( true, new PRI[] { getPartitionOne( ).getPri( ) }, new CRI[0] );
        mql.execute( query, scopeProvider );

        scopeProvider = mql.getQueryScopeProvider( true, new PRI[0], new CRI[] { getPartitionOne( ).getPri( ).getCri( ) } );
        mql.execute( query, scopeProvider );

        scopeProvider = mql.getQueryScopeProvider( false, new PRI[0], new CRI[] { oclPri.getCri( ) } );
        mql.execute( query, scopeProvider );

        MQLResultSet mqlResult = mql.execute( query );
        assertTrue( wsImpl.getMoin( ).isSecondStageInjected( ) );

        MRI[] resultMris = mqlResult.getMris( "instance" );
        boolean found = false;
        for ( int i = 0; i < resultMris.length; i++ ) {
            if ( resultMris[i].getMofId( ) == oclMofId ) {
                found = true;
                break;
            }
        }
        assertTrue( found );
    }

}
