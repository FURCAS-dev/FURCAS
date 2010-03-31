package com.sap.tc.moin.repository.test.ocl.integration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.ScopeKindEnum;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;

import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.ocl.service.impl.MofConstraintInfoImpl;
import com.sap.tc.moin.repository.core.ocl.service.impl.OclMofConstraintRegistryImpl;
import com.sap.tc.moin.repository.core.ocl.service.impl.OclRegistryServiceImpl;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.ocl.OclRegistryService;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetaModelConstraintRegistration;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetamodelConstraintRegistry;
import com.sap.tc.moin.repository.ocl.mof.OclMofConstraintRegistry;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatusItem;
import com.sap.tc.moin.repository.ocl.notification.EventBasedConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.EventBasedConstraintViolationStatusItem;
import com.sap.tc.moin.repository.ocl.notification.ImmediateConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationCategory;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclIntegrationTest;
import com.sap.tc.moin.test.fw.TestMetaModels;

/**
 *
 */
@SuppressWarnings( "nls" )
public class MofConstraintRegistryTest extends BaseOclIntegrationTest {

    /**
     * @throws Exception
     */
    @Test
    public void testMofConstraintEventFilter( ) throws Exception {

        Connection conn = null;

        try {
            conn = this.createConnection( );
            CoreConnection cc = (CoreConnection) ( (Wrapper) conn ).unwrap( );
            Wrapper<OclMetamodelConstraintRegistry> rw = (Wrapper<OclMetamodelConstraintRegistry>) conn.getOclRegistryService( ).getMofConstraintRegistry( );
            OclMofConstraintRegistryImpl ri = (OclMofConstraintRegistryImpl) rw.unwrap( );
            EventFilter filter = ri.getEventFilter( cc, OclRegistrationCategory.immediate );
            System.out.println( "Immediate Mof Constraint Event filter" );
            System.out.println( filter.toString( ) );

            filter = ri.getEventFilter( cc, OclRegistrationCategory.deferred );
            System.out.println( "Deferred Mof Constraint Event filter" );
            System.out.println( filter.toString( ) );

        } finally {
            if ( conn != null ) {
                conn.close( );
            }
        }
    }

    /**
     * @throws Exception
     */
    @Test
    public void testShowMofConstraints( ) throws Exception {

        Connection conn = null;

        try {
            conn = this.createConnection( );
            Set<OclMetaModelConstraintRegistration> mofConstraints = conn.getOclRegistryService( ).getMofConstraintRegistry( ).getAvailableMofConstraints( );
            StringBuilder csv = new StringBuilder( 1000 );
            SortedMap<String, StringBuilder> perlStrings = new TreeMap<String, StringBuilder>( );
            // header line
            csv.append( "Constraint name\tConstraintType\tConstrainedElements\tExpression\n" );
            for ( OclMetaModelConstraintRegistration constraint : mofConstraints ) {
                StringBuilder testperl = new StringBuilder( 1000 );
                System.out.println( "Name: " + constraint.getName( ) );
                csv.append( constraint.getName( ) );
                csv.append( "\t" );
                testperl.append( "/****\n" );
                // TODO the c-xx
                String id = MofConstraintInfoImpl.getId( constraint.getName( ) );
                if ( id == null ) {
                    errorAndContinue( "No ID for constraint: " + constraint.getName( ) );
                    id = "NoId_" + constraint.getName( );
                }
                testperl.append( id + " " + constraint.getName( ) + "\n" );
                testperl.append( "format1: " + constraint.getName( ).toUpperCase( Locale.ENGLISH ) + "\n" );
                testperl.append( "format2: " + constraint.getName( ).toLowerCase( Locale.ENGLISH ) + "\n" );
                // TODO evaluation policy
                testperl.append( "evaluation policy: " + "Unknown" + "\n" );
                // TODO description
                testperl.append( "description: " + "Unknown" + "\n" );
                testperl.append( "\n" );
                testperl.append( "original constraint:\n" );
                System.out.println( "Type: " + constraint.getType( ) );
                csv.append( constraint.getType( ) );
                csv.append( "\t" );
                System.out.println( "ConstrainedElements: " + constraint.getType( ) );
                for ( String ce : constraint.getConstrainedElements( ) ) {
                    System.out.print( ce + " " );
                    csv.append( ce + " " );
                }
                csv.append( "\n" );
                System.out.println( "Expression: " + constraint.getOclExpression( ) );
                // we can not export the ocl expression, since it contains
                // newlines
                testperl.append( "****/\n" );
                String expr = constraint.getOclExpression( );
                // replace '"' since they cause trouble in perl
                expr = expr.replace( "\"", "\\\"" );
                testperl.append( expr );
                testperl.append( "\n" );
                StringBuilder oldOne = perlStrings.put( id, testperl );
                if ( oldOne != null ) {
                    errorAndStop( "Duplicate ID" );
                }
            }
            System.out.println( "******************** Output as tab-separated CSV (without expressions that may contain newlines): ********************" );
            System.out.println( csv.toString( ) );

            System.out.println( "******************** Output as text for the perl testscript: ********************" );
            StringBuilder testperl = new StringBuilder( 2000 );
            for ( StringBuilder perl : perlStrings.values( ) ) {
                testperl.append( perl.toString( ) );
            }
            testperl.append( "\n" );
            System.out.println( testperl.toString( ) );

        } finally {
            if ( conn != null ) {
                conn.close( );
            }
        }
    }

    /**
     * @throws Exception
     */
    @Test
    public void testClassContainmentRules( ) throws Exception {

        Connection conn = createConnection( );
        CoreConnection coreConn = getTestHelper( ).getCoreConnection( conn );

        OclMofConstraintRegistry reg = conn.getOclRegistryService( ).getMofConstraintRegistry( );
        DeferredConstraintViolationListener listener = new DeferredConstraintViolationListener( ) {

            public void notify( DeferredConstraintViolationStatus violationStatus ) {

                for ( DeferredConstraintViolationStatusItem item : violationStatus.getAll( ) ) {
                    info( item.getConstraintViolationMessage( ) + "MofID: " + item.getOffendingMRI( ).getMofId( ) );
                }
                throw new IllegalStateException( "Expected" );
            }

        };

        reg.registerDeferredConstraintViolationListenerForEvents( listener, OclRegistrationCategory.deferred );

        ModelPackage mp = (ModelPackage) conn.getPackage( TestMetaModels.MOIN_MOF_CN, "Model" );
        MofClass mc = (MofClass) mp.getMofClass( ).refCreateInstance( );
        mc.setName( "ClassName" );
        mc.setAnnotation( "" );
        mc.setRoot( false );
        mc.setLeaf( false );
        mc.setAbstract( false );
        mc.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
        mc.setSingleton( false );

        Attribute att = (Attribute) mp.getAttribute( ).refCreateInstance( );
        att.setName( "AttName" );
        att.setAnnotation( "" );
        att.setScope( ScopeKindEnum.INSTANCE_LEVEL );
        att.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
        att.setMultiplicity( coreConn.getCoreJmiHelper( ).createMultiplicityType( coreConn, 0, 1, false, false ) );
        att.setChangeable( true );
        att.setDerived( false );

        MofClass wrong = (MofClass) mp.getMofClass( ).refCreateInstance( );
        wrong.setName( "ClassName" );
        wrong.setAnnotation( "" );
        wrong.setRoot( false );
        wrong.setLeaf( false );
        wrong.setAbstract( true );
        wrong.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
        wrong.setSingleton( true );

        mc.getContents( ).add( att );

        try {
            reg.analyzeCollectedEvents( OclRegistrationCategory.deferred );
        } catch ( IllegalStateException e ) {
            if ( e.getMessage( ).equals( "Expected" ) ) {
                return;
            }

        }
        fail( "Expected Exception not thrown" );
    }

    /**
     * @throws Exception
     */
    @Test
    public void testMofConstraintRegistry( ) throws Exception {

        CoreConnection conn = null;
        //        DeferredConstraintViolationListener warningListener = null;
        //        DeferredConstraintViolationListener warningListener2 = null;
        //        OclMetamodelConstraintRegistry reg = null;
        OclRegistryServiceImpl srv = null;
        try {
            Connection c = this.createConnection( );
            if ( c instanceof Wrapper ) {
                conn = (CoreConnection) ( (Wrapper) c ).unwrap( );
            } else {
                conn = (CoreConnection) c;
            }
            srv = (OclRegistryServiceImpl) conn.getSession( ).getCoreOclRegistryService( );
            System.out.println( "*********** Service interactions ***********" );
            ModelPartition part = ( (Partitionable) conn.getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE ).refMetaObject( ) ).get___Partition( );
            Set<PRI> partitions = new HashSet<PRI>( );
            partitions.add( part.getPri( ) );
            DeferredConstraintViolationStatus result = null;
            synchronized ( this.syncObjectForWrite ) {
                result = srv.getMofConstraintRegistry( conn ).analyzeMetamodelPartitions( conn, partitions, OclRegistrationCategory.immediate, OclRegistrationCategory.deferred );
            }
            for ( DeferredConstraintViolationStatusItem item : result.getAll( ) ) {
                System.out.println( "" + item.getConstraintRegistration( ).getName( ) + ": " + item.getOffendingMRI( ) );
            }
            System.out.println( "*********** Company ***********" );
            part = ( (Partitionable) conn.getPackage( TestMetaModels.COMPANY_CN, TestMetaModels.COMPANY_TPE ).refMetaObject( ) ).get___Partition( );
            partitions = new HashSet<PRI>( );
            partitions.add( part.getPri( ) );
            result = srv.getMofConstraintRegistry( conn ).analyzeMetamodelPartitions( conn, partitions, OclRegistrationCategory.immediate, OclRegistrationCategory.deferred );
            for ( DeferredConstraintViolationStatusItem item : result.getAll( ) ) {
                System.out.println( "" + item.getConstraintRegistration( ).getName( ) + ": " + item.getOffendingMRI( ) );
            }
        } finally {
            if ( conn != null ) {
                conn.close( );
            }
        }
    }

    /**
     * @throws Exception exception
     */
    @Test
    public void testDeferredMofConstraint( ) throws Exception {

        Connection conn = null;
        DeferredConstraintViolationListener immediateListener;
        DeferredConstraintViolationListener deferredListener;

        final Set<DeferredConstraintViolationStatus> immediateStatusSet = new HashSet<DeferredConstraintViolationStatus>( );
        final Set<DeferredConstraintViolationStatus> deferredStatusSet = new HashSet<DeferredConstraintViolationStatus>( );

        OclRegistryService srv = null;
        try {
            conn = this.createConnection( );
            srv = conn.getOclRegistryService( );

            immediateListener = new DeferredConstraintViolationListener( ) {

                public void notify( DeferredConstraintViolationStatus violationStatus ) {

                    immediateStatusSet.add( violationStatus );
                }

            };

            deferredListener = new DeferredConstraintViolationListener( ) {

                public void notify( DeferredConstraintViolationStatus violationStatus ) {

                    deferredStatusSet.add( violationStatus );
                }

            };

            OclMofConstraintRegistry reg = srv.getMofConstraintRegistry( );

            reg.registerDeferredConstraintViolationListenerForEvents( deferredListener, OclRegistrationCategory.deferred );

            reg.registerDeferredConstraintViolationListenerForEvents( immediateListener, OclRegistrationCategory.immediate );

            ModelPackage mp = (ModelPackage) conn.getPackage( null, "Model" );

            // should have one constraint (not contained)
            MofClass mc = (MofClass) mp.getMofClass( ).refCreateInstance( );
            mc.setName( "NiceClass" );
            mc.setAnnotation( "" );
            mc.setRoot( true );
            mc.setLeaf( true );
            mc.setAbstract( false );
            mc.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
            mc.setSingleton( false );
            // should have two constraints (not contained and abstract can not
            // be singleton)
            MofClass mc2 = (MofClass) mp.getMofClass( ).refCreateInstance( );
            mc2.setName( "AbstractSingleton" );
            mc2.setAnnotation( "" );
            mc2.setRoot( true );
            mc2.setLeaf( true );
            mc2.setAbstract( true );
            mc2.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
            mc2.setSingleton( true );

            reg.analyzeCollectedEvents( OclRegistrationCategory.immediate );
            reg.analyzeCollectedEvents( OclRegistrationCategory.deferred );

            reg.resetEvents( OclRegistrationCategory.deferred );

            reg.analyzeCollectedEvents( OclRegistrationCategory.immediate );
            reg.analyzeCollectedEvents( OclRegistrationCategory.deferred );

            if ( !immediateStatusSet.isEmpty( ) ) {
                for ( DeferredConstraintViolationStatus status : immediateStatusSet ) {
                    for ( DeferredConstraintViolationStatusItem item : status.getAll( ) ) {
                        System.out.println( "Immediate: " + item.getConstraintViolationMessage( ) );
                    }
                }
                fail( "Unexpected immediate constraints" );
            }

            if ( deferredStatusSet.size( ) != 1 ) {
                fail( "Should have exactly one status set" );
            }

            for ( DeferredConstraintViolationStatus status : deferredStatusSet ) {
                for ( DeferredConstraintViolationStatusItem item : status.getAll( ) ) {
                    System.out.println( "Deferred: " + item.getConstraintViolationMessage( ) );
                }
            }

        } finally {
            if ( conn != null ) {
                conn.close( );
            }
        }
    }

    /**
     * @throws Exception exception
     */
    @Test
    public void testFilteredPartitionCheck( ) throws Exception {

        Connection conn = null;
        OclRegistryService srv = null;
        try {
            conn = this.createConnection( );
            srv = conn.getOclRegistryService( );

            ModelPackage mp = (ModelPackage) conn.getPackage( null, "Model" );

            // should have one constraint (not contained)
            MofClass mc = (MofClass) mp.getMofClass( ).refCreateInstance( );
            mc.setName( "NiceClass" );
            mc.setAnnotation( "" );
            mc.setRoot( true );
            mc.setLeaf( true );
            mc.setAbstract( false );
            mc.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
            mc.setSingleton( false );
            // should have three constraints (not contained and abstract can not
            // be singleton and singleton not supported)
            MofClass mc2 = (MofClass) mp.getMofClass( ).refCreateInstance( );
            mc2.setName( "AbstractSingleton" );
            mc2.setAnnotation( "" );
            mc2.setRoot( true );
            mc2.setLeaf( true );
            mc2.setAbstract( true );
            mc2.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
            mc2.setSingleton( true );

            Set<PRI> pris = new HashSet<PRI>( );
            pris.add( conn.getNullPartition( ).getPri( ) );
            DeferredConstraintViolationStatus stat = srv.getMofConstraintRegistry( ).verifyConstraints( pris, new HashSet<OclRegistrationCategory>( ) );

            if ( stat.getAll( ).size( ) != 4 ) {
                errorAndContinue( "Not the expected number of violations" );
            }

        } finally {
            if ( conn != null ) {
                conn.close( );
            }
        }
    }

    /**
     * @throws Exception
     */
    @Test
    public void testImmediateMofConstraint( ) throws Exception {

        Connection conn = null;
        DeferredConstraintViolationListener immediateListener;
        DeferredConstraintViolationListener deferredListener;

        final Set<DeferredConstraintViolationStatus> immediateStatusSet = new HashSet<DeferredConstraintViolationStatus>( );
        final Set<DeferredConstraintViolationStatus> deferredStatusSet = new HashSet<DeferredConstraintViolationStatus>( );

        OclRegistryService srv = null;
        try {
            conn = this.createConnection( );
            srv = conn.getOclRegistryService( );

            immediateListener = new DeferredConstraintViolationListener( ) {

                public void notify( DeferredConstraintViolationStatus violationStatus ) {

                    immediateStatusSet.add( violationStatus );
                }

            };

            deferredListener = new DeferredConstraintViolationListener( ) {

                public void notify( DeferredConstraintViolationStatus violationStatus ) {

                    deferredStatusSet.add( violationStatus );
                }

            };

            OclMofConstraintRegistry reg = srv.getMofConstraintRegistry( );

            ModelPackage mp = (ModelPackage) conn.getPackage( null, "Model" );

            reg.registerDeferredConstraintViolationListenerForEvents( deferredListener, OclRegistrationCategory.deferred );

            reg.registerDeferredConstraintViolationListenerForEvents( immediateListener, OclRegistrationCategory.immediate );

            Association assoc1 = (Association) mp.getAssociation( ).refCreateInstance( );
            assoc1.setName( "ass1" );
            assoc1.setAnnotation( "" );
            assoc1.setRoot( true );
            assoc1.setLeaf( true );
            assoc1.setAbstract( false );
            assoc1.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
            assoc1.setDerived( false );

            reg.analyzeCollectedEvents( OclRegistrationCategory.immediate );

            // reg.analyzeCollectedEvents(OclRegistrationCategory.deferred);

            reg.resetEvents( OclRegistrationCategory.immediate );

            if ( immediateStatusSet.size( ) != 1 ) {
                fail( "Should have one violation set" );
            }

            reg.analyzeCollectedEvents( OclRegistrationCategory.immediate );

            if ( immediateStatusSet.size( ) != 1 ) {
                fail( "Should have one violation set" );
            }

            for ( DeferredConstraintViolationStatus status : immediateStatusSet ) {
                for ( DeferredConstraintViolationStatusItem item : status.getAll( ) ) {
                    System.out.println( "Immediate: " + item.getConstraintViolationMessage( ) );
                }
            }

            if ( !deferredStatusSet.isEmpty( ) ) {
                fail( "Should not have deferred events" );
            }

            reg.analyzeCollectedEvents( OclRegistrationCategory.deferred );
            for ( DeferredConstraintViolationStatus status : deferredStatusSet ) {
                for ( DeferredConstraintViolationStatusItem item : status.getAll( ) ) {
                    System.out.println( "Deferred: " + item.getConstraintViolationMessage( ) );
                }
            }

        } finally {
            if ( conn != null ) {
                conn.close( );
            }
        }
    }

    /**
     * @throws Exception
     */
    @Test
    public void testImmediateListener( ) throws Exception {

        Connection conn = createConnection( );
        CoreConnection coreConn = getTestHelper( ).getCoreConnection( conn );

        final List<EventBasedConstraintViolationStatusItem> items = new ArrayList<EventBasedConstraintViolationStatusItem>( );

        ImmediateConstraintViolationListener listener = new ImmediateConstraintViolationListener( ) {

            public void notify( EventBasedConstraintViolationStatus violationStatus ) {

                for ( EventBasedConstraintViolationStatusItem item : violationStatus.getAll( ) ) {
                    items.add( item );
                }
            }
        };

        conn.getOclRegistryService( ).getMofConstraintRegistry( ).registerImmediateConstraintViolationListener( listener );

        ModelPackage mp = (ModelPackage) conn.getPackage( TestMetaModels.MOIN_MOF_CN, "Model" );

        Attribute attribute = (Attribute) mp.getAttribute( ).refCreateInstance( );
        attribute.setName( "SomeName" );
        attribute.setAnnotation( "" );
        attribute.setScope( ScopeKindEnum.CLASSIFIER_LEVEL );
        attribute.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
        attribute.setMultiplicity( coreConn.getCoreJmiHelper( ).createMultiplicityType( coreConn, 1, 1, false, false ) );
        attribute.setChangeable( true );
        attribute.setDerived( false );

        verify( items.size( ) > 0, "No violation detected" );

    }
}
