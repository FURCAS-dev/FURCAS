package com.sap.tc.moin.repository.test.ocl.integration;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.junit.Test;

import com.sap.serviceinteractions.Message;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.events.VetoException;
import com.sap.tc.moin.repository.ocl.OclRegistryService;
import com.sap.tc.moin.repository.ocl.freestyle.ExpressionInvalidationListener;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;
import com.sap.tc.moin.repository.ocl.freestyle.OclFreestyleRegistry;
import com.sap.tc.moin.repository.ocl.freestyle.OclInvariantRegistration;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistrationType;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.EventBasedConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.EventBasedConstraintViolationStatusItem;
import com.sap.tc.moin.repository.ocl.notification.ImmediateConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclIntegrationTest;
import com.sap.tc.moin.test.fw.TestMetaModels;

/**
 * @author d022737
 */
@SuppressWarnings( "nls" )
public class OclConstraintRegistryTest extends BaseOclIntegrationTest {

    private class ExpectedException extends VetoException {

        private static final long serialVersionUID = 1L;

        // just so that it passes the event framework
        /**
         * 
         */
        public ExpectedException( ) {

            super( "This is expected" );
        }
    }

    private Message createMessage( Connection conn, boolean isFault, java.lang.String type ) {

        Message message = conn.createElementInPartition( Message.class, null );
        message.setFault( isFault );
        message.setType( type );
        return message;
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void testDeferredInvariantRegistration( ) throws Exception {

        Connection c = this.createConnection( );

        OclRegistryService regsrv = c.getOclRegistryService( );
        OclFreestyleRegistry registry = regsrv.getFreestyleRegistry( );

        RefPackage targetPackage = c.getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE );
        RefClass messageClass = targetPackage.refClass( "Message" );
        RefPackage[] types = new RefPackage[] { targetPackage };

        OclInvariantRegistration errorRegistration = registry.createInvariantRegistration( "SomeErrorName", "inv: self.reply_to.reply_to->excludes(self)", OclRegistrationSeverity.Error, new String[] { "MyCategory", "MyErrorCategory" }, messageClass, types );

        // registration methods tests

        verify( errorRegistration.getCategories( ).contains( "MyCategory" ), "Category not found" );
        verify( errorRegistration.getName( ).equals( "SomeErrorName" ), "Name wrong" );
        verify( errorRegistration.getOclExpression( ).equals( "inv: self.reply_to.reply_to->excludes(self)" ), "OclExpression wrong" );
        verify( errorRegistration.getSeverity( ).equals( OclRegistrationSeverity.Error ), "Severity is wrong" );
        verify( errorRegistration.getType( ).equals( OclRegistrationType.Invariant ), "Type is wrong" );

        OclInvariantRegistration warningRegistration = registry.createInvariantRegistration( "SomeWarningName", "inv: self.reply_to.reply_to->excludes(self)", OclRegistrationSeverity.Warning, new String[] { "MyCategory", "MyWarningCategory" }, messageClass, types );

        DeferredConstraintViolationListener warninglistener = new DeferredConstraintViolationListener( ) {

            public void notify( DeferredConstraintViolationStatus event ) {

                if ( event.hasErrors( ) ) {
                    errorAndContinue( "Error instead of warning received" );
                } else if ( event.hasWarnings( ) ) {
                    throw new ExpectedException( );
                }
            }
        };

        DeferredConstraintViolationListener errorlistener = new DeferredConstraintViolationListener( ) {

            public void notify( DeferredConstraintViolationStatus event ) {

                if ( event.hasWarnings( ) ) {
                    errorAndContinue( "Warning instead of error received" );
                } else if ( event.hasErrors( ) ) {
                    throw new ExpectedException( );
                }
            }

        };

        Message msg1 = createMessage( c, false, "response" );
        Message msg2 = createMessage( c, false, "response" );
        msg1.setReplyTo( msg2 );
        msg2.setReplyTo( msg1 );

        registry.registerDeferredConstraintViolationListenerForPartitions( "MyWarningCategory", warninglistener );

        registry.registerDeferredConstraintViolationListenerForPartitions( "MyErrorCategory", errorlistener );

        Set<PRI> partitions = new HashSet<PRI>( );
        partitions.add( c.getNullPartition( ).getPri( ) );

        try {
            regsrv.analyzeModelPartitions( "MyErrorCategory", partitions );
            errorAndContinue( "Expected Exception not thrown" );
        } catch ( ExpectedException e ) {
            info( "Expected Exception thrown" );
        }
        try {
            regsrv.analyzeModelPartitions( "MyWarningCategory", partitions );
            errorAndContinue( "Expected Exception not thrown" );
        } catch ( ExpectedException e ) {
            info( "Expected Exception thrown" );
        }
        registry.unregisterDeferredConstraintViolationListener( warninglistener );
        registry.unregisterDeferredConstraintViolationListener( errorlistener );

        try {
            regsrv.analyzeModelPartitions( "MyCategory", partitions );
            regsrv.analyzeModelPartitions( "MyOtherCategory", partitions );
        } catch ( RuntimeException e ) {
            errorAndContinue( "Unexpected Exception" );
        }
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void testDeferredEventBasedInvariantRegistration( ) throws Exception {

        Connection c = this.createConnection( );


        OclRegistryService srv = c.getOclRegistryService( );
        OclFreestyleRegistry registry = srv.getFreestyleRegistry( );

        RefPackage targetPackage = c.getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE );
        RefClass messageClass = targetPackage.refClass( "Message" );
        RefPackage[] types = new RefPackage[] { targetPackage };

        OclInvariantRegistration registration = registry.createInvariantRegistration( "SomeName", "inv: self.reply_to.reply_to->excludes(self)", OclRegistrationSeverity.Warning, new String[] { "OtherCategory" }, messageClass, types );

        DeferredConstraintViolationListener warninglistener = new DeferredConstraintViolationListener( ) {

            public void notify( DeferredConstraintViolationStatus event ) {

                if ( event.hasErrors( ) ) {
                    errorAndContinue( "Error instead of warning received" );
                } else if ( event.hasWarnings( ) ) {
                    throw new ExpectedException( );
                }
            }
        };

        Message msg1 = createMessage( c, false, "response" );
        Message msg2 = createMessage( c, false, "response" );

        msg1.setReplyTo( msg2 );

        registry.registerDeferredConstraintViolationListenerForEvents( "OtherCategory", warninglistener );

        msg2.setReplyTo( msg1 );

        try {
            srv.analyzeCollectedEvents( "OtherCategory" );
            errorAndContinue( "Expected Exception not thrown" );
        } catch ( ExpectedException e ) {
            info( "Expected Exception thrown" );
        }

        srv.resetEvents( "OtherCategory" );

        try {
            srv.analyzeCollectedEvents( "OtherCategory" );
        } catch ( ExpectedException e ) {
            errorAndContinue( "Unexpected Exception" );
        }
        registry.unregisterDeferredConstraintViolationListener( warninglistener );

        try {
            srv.analyzeCollectedEvents( "OtherCategory" );
            srv.analyzeCollectedEvents( "OtherCategory" );
        } catch ( RuntimeException e ) {
            errorAndContinue( "Unexpected Exception" );
        }
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void testImmediateInvariantRegistration( ) throws Exception {

        Connection c = this.createConnection( );

        OclFreestyleRegistry registry = c.getOclRegistryService( ).getFreestyleRegistry( );

        RefPackage targetPackage = c.getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE );
        RefClass messageClass = targetPackage.refClass( "Message" );
        RefPackage[] types = new RefPackage[] { targetPackage };

        OclInvariantRegistration registration = registry.createInvariantRegistration( "SomeName", "inv: self.reply_to.reply_to->excludes(self)", OclRegistrationSeverity.Error, new String[] { "someImmediate" }, messageClass, types );

        ImmediateConstraintViolationListener listener = new ImmediateConstraintViolationListener( ) {

            public void notify( EventBasedConstraintViolationStatusItem event ) {

                System.out.println( "Violation found, MRI: " + event.getOffendingMRI( ) );
                throw new ExpectedException( );
            }

            public void notify( EventBasedConstraintViolationStatus event ) {

                if ( event.hasErrors( ) ) {
                    System.out.println( "Violation found" );
                    throw new ExpectedException( );
                }
                System.out.println( "Warning found" );
                List<EventBasedConstraintViolationStatusItem> warnings = event.getWarnings( );
                for ( EventBasedConstraintViolationStatusItem warning : warnings ) {
                    System.out.println( "MRI: " + warning.getOffendingMRI( ) );
                }
                errorAndContinue( "Warnint instead of Error received" );
            }

        };

        Message msg1 = createMessage( c, false, "response" );
        Message msg2 = createMessage( c, false, "response" );
        msg1.setReplyTo( msg2 );

        registry.registerImmediateConstraintViolationListener( "someImmediate", listener );

        try {
            msg2.setReplyTo( msg1 );
            errorAndContinue( "Expected Exception not thrown" );
        } catch ( ExpectedException e ) {
            info( "Expected Exception thrown" );
        }

    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void testDeferredExpressionRegistration( ) throws Exception {

        Connection c = this.createConnection( );

        OclRegistryService srv = c.getOclRegistryService( );
        OclFreestyleRegistry registry = srv.getFreestyleRegistry( );

        RefPackage targetPackage = c.getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE );
        RefClass messageClass = targetPackage.refClass( "Message" );
        RefPackage[] types = new RefPackage[] { targetPackage };

        final OclExpressionRegistration registration = registry.createExpressionRegistration( "SomeName", "self.type", OclRegistrationSeverity.Warning, new String[] { "TheCategory" }, messageClass, types );

        ExpressionInvalidationListener listener = new ExpressionInvalidationListener( ) {

            public void notify( Collection<MRI> objectsToReEvaluate, OclExpressionRegistration registration ) {

                System.out.println( registration.getSeverity( ) + ": Invalidated Objects: " );
                for ( MRI element : objectsToReEvaluate ) {
                    try {
                        System.out.println( "MofId: " + element.getMofId( ) + " new Value: " + registration.evaluateExpression( element ) );
                    } catch ( OclManagerException e ) {
                        e.printStackTrace( );
                    }
                }
                throw new ExpectedException( );
            }

        };

        registration.registerPartitionBasedInvalidationListener( "TheCategory", listener );

        Message msg1 = createMessage( c, false, "response" );
        Message msg2 = createMessage( c, false, "request" );

        Set<PRI> partitions = new HashSet<PRI>( );
        partitions.add( c.getNullPartition( ).getPri( ) );

        try {
            srv.analyzeModelPartitions( "TheCategory", partitions );
            errorAndContinue( "ExpectedException not thrown" );
        } catch ( ExpectedException e ) {
            info( "ExpectedException thrown" );
        }

        msg2.setType( "test" );
        try {
            srv.analyzeModelPartitions( "TheCategory", partitions );
            errorAndContinue( "ExpectedException not thrown" );
        } catch ( ExpectedException e ) {
            info( "ExpectedException thrown" );
        }

        try {
            srv.analyzeModelPartitions( "TheCategory", partitions );
        } catch ( ExpectedException e1 ) {
            errorAndContinue( "Unexpected Exception thrown: " + e1.getMessage( ) );
        }

        msg1.setType( "request" );

        try {
            srv.analyzeModelPartitions( "TheCategory", partitions );
        } catch ( ExpectedException e ) {
            info( "ExpectedException thrown" );
        }
    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void testImmediateExpressionRegistration( ) throws Exception {

        Connection c = this.createConnection( );

        OclFreestyleRegistry registry = c.getOclRegistryService( ).getFreestyleRegistry( );

        RefPackage targetPackage = c.getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE );
        RefClass messageClass = targetPackage.refClass( "Message" );
        RefPackage[] types = new RefPackage[] { targetPackage };

        final OclExpressionRegistration registration = registry.createExpressionRegistration( "SomeName", "self.type", OclRegistrationSeverity.Error, new String[] { "SomeImmediate" }, messageClass, types );

        ExpressionInvalidationListener listener = new ExpressionInvalidationListener( ) {

            public void notify( Collection<MRI> objectsToReEvaluate, OclExpressionRegistration registration ) {

                System.out.println( registration.getSeverity( ).name( ) + " Invalidated Objects: " );
                for ( MRI element : objectsToReEvaluate ) {
                    try {
                        System.out.println( "MofId: " + element.getMofId( ) + " new Value: " + registration.evaluateExpression( element ) );
                    } catch ( OclManagerException e ) {
                        e.printStackTrace( );
                    }
                }
                throw new ExpectedException( );
            }
        };
        Message msg = createMessage( c, false, "response" );

        registration.registerEventBasedInvalidationListener( listener, true );

        try {
            msg.setType( "response" );
            errorAndContinue( "ExpectedException not thrown" );
        } catch ( ExpectedException e ) {
            info( "Expected Exception thrown" );
        }

        try {
            msg.setType( "request" );
            errorAndContinue( "ExpectedException not thrown" );
        } catch ( ExpectedException e ) {
            info( "Expected Exception thrown" );
        }

    }

    /**
     * @throws Exception cover all
     */
    @Test
    public void testDeferredEventBasedExpressionRegistration( ) throws Exception {

        Connection c = this.createConnection( );

        OclRegistryService srv = c.getOclRegistryService( );
        OclFreestyleRegistry registry = srv.getFreestyleRegistry( );

        RefPackage targetPackage = c.getPackage( TestMetaModels.SERVICE_INTERACTIONS_CN, TestMetaModels.SERVICE_INTERACTIONS_TPE );
        RefClass messageClass = targetPackage.refClass( "Message" );
        RefPackage[] types = new RefPackage[] { targetPackage };

        final OclExpressionRegistration registration = (OclExpressionRegistration) registry.createExpressionRegistration( "SomeName", "self.type", OclRegistrationSeverity.Error, new String[] { "SomeDeferred" }, messageClass, types );

        ExpressionInvalidationListener listener = new ExpressionInvalidationListener( ) {

            public void notify( Collection<MRI> objectsToReEvaluate, OclExpressionRegistration registration ) {

                System.out.println( registration.getSeverity( ).name( ) + " Invalidated Objects: " );
                for ( MRI element : objectsToReEvaluate ) {
                    try {
                        System.out.println( "MofId: " + element.getMofId( ) + " new Value: " + registration.evaluateExpression( element ) );
                    } catch ( OclManagerException e ) {
                        e.printStackTrace( );
                    }
                }
                throw new ExpectedException( );
            }
        };
        Message msg = createMessage( c, false, "response" );

        registration.registerEventBasedInvalidationListener( listener, false );

        msg.setType( "response" );
        msg.setType( "request" );

        try {
            srv.analyzeCollectedEvents( "SomeDeferred" );
            errorAndContinue( "ExpectedException not thrown" );
        } catch ( ExpectedException e ) {
            info( "ExpectedException thrown" );
        }

        srv.resetEvents( "SomeDeferred" );

        try {
            srv.analyzeCollectedEvents( "SomeDeferred" );
        } catch ( RuntimeException e ) {
            errorAndContinue( "Unexcpected Exception" );
        }

    }
}
