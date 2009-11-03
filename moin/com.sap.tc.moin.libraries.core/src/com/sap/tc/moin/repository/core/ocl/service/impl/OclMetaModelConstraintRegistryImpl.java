package com.sap.tc.moin.repository.core.ocl.service.impl;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.model.__impl.ClassifierInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ConstraintImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.omg.ocl.attaching.OclConstraint;
import org.omg.ocl.attaching.__impl.OclConstraintImpl;
import org.omg.ocl.attaching.__impl.OclConstraintInternal;
import org.omg.ocl.expressions.OclExpression;

import com.sap.tc.moin.ocl.evaluator.EvaluationContext;
import com.sap.tc.moin.ocl.evaluator.EvaluationContextImpl;
import com.sap.tc.moin.ocl.evaluator.ExpressionUndefinedException;
import com.sap.tc.moin.ocl.evaluator.OclConstraintEvaluator;
import com.sap.tc.moin.ocl.evaluator.expr.ExpressionEvaluator;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclBoolean;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclFactory;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclString;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclVoid;
import com.sap.tc.moin.ocl.ia.ImpactAnalyzer;
import com.sap.tc.moin.ocl.ia.result.EvaluationUnit;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.jmi.JmiCreator;
import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;
import com.sap.tc.moin.ocl.utils.localization.OclServiceExceptions;
import com.sap.tc.moin.ocl.utils.localization.OclServiceTraces;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreOclMetamodelConstraintRegistry;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.checks.MoinAndMofConstraints;
import com.sap.tc.moin.repository.core.events.VetoException;
import com.sap.tc.moin.repository.core.impl.WorkspaceSetImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.jmi.util.MoinMetamodelCode;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistration;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetaModelConstraintRegistration;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatusItem;
import com.sap.tc.moin.repository.ocl.notification.EventBasedConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.ImmediateConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.OclConstraintManagerException;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationCategory;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.shared.util.QualifiedName;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * The meta model constraint registration implementation
 */
public class OclMetaModelConstraintRegistryImpl implements CoreOclMetamodelConstraintRegistry {

    private static final String VIOLATION_MESSAGE_RESKEY_EXTENSION = "ViolationMessage"; //$NON-NLS-1$

    private static final String LISTENER_TYPE_IMMEDIATE = "Immediate"; //$NON-NLS-1$

    private static final String LISTENER_TYPE_DEFERRED_FOR_EVENTS = "DeferredForEvents"; //$NON-NLS-1$

    private static final String LISTENER_TYPE_PARITITON_BASED = "ParititonBased"; //$NON-NLS-1$

    static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE_OCL, OclMetaModelConstraintRegistryImpl.class );

    final CoreSession mySession;

    private final Map<String, DeferredListenerWrapper> deferredListeners = new HashMap<String, DeferredListenerWrapper>( );

    private Map<String, EventCollectingListenerWrapper> eventCollectionListeners = new HashMap<String, EventCollectingListenerWrapper>( );

    private final Map<String, ImmediateListenerWrapper> immediateListeners = new HashMap<String, ImmediateListenerWrapper>( );

    final OclConstraintEvaluator immediateEvaluator = new OclConstraintEvaluator( );

    final OclRegistryServiceImpl registryService;

    private final class DeferredListenerWrapper {

        private final ImpactAnalyzer ia;

        private final Set<DeferredConstraintViolationListener> myListeners = new HashSet<DeferredConstraintViolationListener>( );

        private final Set<String> MOFPACKAGES = new HashSet<String>( );

        private final Map<OclStatement, String> stmtToConstraintMofd;

        DeferredListenerWrapper( CoreConnection connection, Map<OclStatement, OclRegistrationSeverity> severityMap, Map<OclStatement, String> stmtConstraintMap ) throws OclManagerException {

            if ( severityMap.isEmpty( ) ) {
                throw new OclManagerException( OclServiceExceptions.NOREGISTRATIONSFOUND );
            }
            this.stmtToConstraintMofd = stmtConstraintMap;
            this.ia = new ImpactAnalyzer( true );
            this.ia.analyze( severityMap.keySet( ), getJmiCreator( connection ) );
            this.MOFPACKAGES.add( OclConstants.P_MODEL );
            this.MOFPACKAGES.add( OclConstants.P_OCL );
        }

        boolean triggerConstraintEvaluation( CoreConnection connection, Set<ModelPartition> partitions ) {

            boolean evaluated = false;

            EvaluationHelper helper = new EvaluationHelper( );

            Set<Classifier> classifiers = this.getClassifiersFromPartition( connection, partitions );

            DeferredConstraintViolationStatusImpl violationInfo = new DeferredConstraintViolationStatusImpl( );

            for ( EvaluationUnit unit : DeferredListenerWrapper.this.ia.filterForClasses( classifiers ) ) {
                OclMetaModelConstraintRegistration info = null;
                OclStatement statement = unit.getAffectedStatement( );
                Set<OclAny> instances = helper.getAffectedInstances( connection, unit );

                for ( OclAny oclAny : instances ) {
                    evaluated = true;
                    try {
                        boolean result = this.evaluateInvariant( connection, statement, oclAny );
                        if ( !result ) {
                            if ( info == null ) {
                                String constraintMof = DeferredListenerWrapper.this.stmtToConstraintMofd.get( statement );
                                info = OclMetaModelConstraintRegistryImpl.this.getWsRegistry( connection ).getInfo( constraintMof );
                            }

                            violationInfo.addItem( connection, info, ( (Partitionable) oclAny.getWrappedObject( ) ).get___Mri( ) );
                        }
                    } catch ( OclManagerException e ) {
                        if ( info == null ) {
                            String constraintMof = DeferredListenerWrapper.this.stmtToConstraintMofd.get( statement );
                            info = OclMetaModelConstraintRegistryImpl.this.getWsRegistry( connection ).getInfo( constraintMof );
                        }
                        if ( oclAny instanceof OclVoid ) {
                            violationInfo.addItem( connection, info, null, e );
                        } else {
                            violationInfo.addItem( connection, info, ( (Partitionable) oclAny.getWrappedObject( ) ).get___Mri( ), e );
                        }
                    }
                }
            }
            this.dispatchEvent( violationInfo );
            return evaluated;
        }

        boolean registerListener( DeferredConstraintViolationListener listener ) {

            return this.myListeners.add( listener );
        }

        boolean unregisterListener( DeferredConstraintViolationListener listener ) {

            return this.myListeners.remove( listener );
        }

        private void dispatchEvent( DeferredConstraintViolationStatusImpl event ) {

            if ( !event.hasItems( ) ) {
                return;
            }
            if ( JMX_ENABLED && OclMetaModelConstraintRegistryImpl.this.registryService.jmxNotificationsEnabled ) {
                OclMetaModelConstraintRegistryImpl.this.registryService.constraintViolationsDetected( event );
            }
            for ( Iterator<DeferredConstraintViolationListener> it = this.myListeners.iterator( ); it.hasNext( ); ) {
                it.next( ).notify( event );
            }
        }

        private Set<Classifier> getClassifiersFromPartition( CoreConnection connection, Set<ModelPartition> partitions ) {

            Set<Classifier> result = new HashSet<Classifier>( );

            for ( ModelPartition partition : partitions ) {
                for ( Partitionable partitionable : partition.getElements( ) ) {
                    if ( partitionable instanceof RefObject ) {
                        RefObject meta = ( (RefObject) partitionable ).refMetaObject( );
                        if ( meta instanceof Classifier ) {
                            if ( result.contains( meta ) ) {
                                continue;
                            }
                        }
                        String firstNameComp = ( (ClassifierInternal) meta ).getQualifiedName( connection ).get( 0 );
                        // TODO we need to filter differently, somehow
                        if ( !this.MOFPACKAGES.contains( firstNameComp ) ) {
                            result.add( (Classifier) meta );
                        }
                    }
                }
            }
            return result;
        }

        private boolean evaluateInvariant( CoreConnection connection, OclStatement statement, OclAny context ) throws OclManagerException {

            try {
                EvaluationContext ctxt = new EvaluationContextImpl( context );
                OclAny oclResult = ExpressionEvaluator.instance( ).evaluate( connection, statement.getExpression( ), ctxt );
                if ( oclResult instanceof OclBoolean ) {
                    return ( (OclBoolean) oclResult ).getWrappedBoolean( ).booleanValue( );
                }
                throw new OclManagerException( new ExpressionUndefinedException( OclServiceExceptions.EXPEVALUATESTOUNDEFINED ) );
            } finally {
                EvaluationContext.CurrentContext.reset( );
            }
        }
    }

    private final class ImmediateListenerWrapper {

        private final Set<ImmediateConstraintViolationListener> myListeners = new HashSet<ImmediateConstraintViolationListener>( );

        final Map<OclStatement, OclRegistrationSeverity> severityMap;

        final ImpactAnalyzer ia;

        final OclConstraintEvaluator evaluator;

        private final EventFilter myFilter;

        private final ChangeListener myListener;

        final Map<OclStatement, String> stmtToConstraintMofId;

        ImmediateListenerWrapper( CoreConnection connection, Map<OclStatement, OclRegistrationSeverity> theSeverityMap, Map<OclStatement, String> actStmtToConstraintMofId ) throws OclManagerException {

            if ( theSeverityMap.isEmpty( ) ) {
                throw new OclManagerException( OclServiceExceptions.NOREGISTRATIONSFOUND );
            }
            this.severityMap = theSeverityMap;
            this.stmtToConstraintMofId = actStmtToConstraintMofId;

            this.ia = new ImpactAnalyzer( false );
            this.evaluator = new OclConstraintEvaluator( );

            this.myListener = new ChangeListener( ) {

                public void notify( ChangeEvent event ) {

                    if ( event instanceof ModelChangeEvent ) {
                        if ( OclMetaModelConstraintRegistryImpl.LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                            OclMetaModelConstraintRegistryImpl.LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.EVTRECEIVEDIMMEDIATEWRAPPER, event, this.toString( ) );
                        }
                        ModelChangeEvent offendingEvent = (ModelChangeEvent) event;

                        EventBasedConstraintViolationStatusImpl violationInfo = new EventBasedConstraintViolationStatusImpl( );
                        Connection econn = event.getEventTriggerConnection( );
                        CoreConnection cconn;
                        if ( econn instanceof Wrapper ) {
                            cconn = (CoreConnection) ( (Wrapper) econn ).unwrap( );
                        } else {
                            cconn = (CoreConnection) econn;
                        }
                        for ( Iterator<EvaluationUnit> eus = ImmediateListenerWrapper.this.ia.filter( cconn, offendingEvent ).iterator( ); eus.hasNext( ); ) {
                            EvaluationUnit unit = eus.next( );
                            OclStatement statement = unit.getAffectedStatement( );

                            EvaluationHelper helper = new EvaluationHelper( );
                            Set<OclAny> instances = helper.getAffectedInstances( cconn, unit );

                            for ( OclAny oclAny : instances ) {
                                RefObject obj = (RefObject) oclAny.getWrappedObject( );
                                try {
                                    boolean result = ImmediateListenerWrapper.this.evaluator.evaluate( cconn, statement.getExpression( ), obj );

                                    if ( !result ) {
                                        // a violation was detected
                                        String constraintMof = ImmediateListenerWrapper.this.stmtToConstraintMofId.get( statement );
                                        OclRegistration info = OclMetaModelConstraintRegistryImpl.this.getWsRegistry( cconn ).getInfo( constraintMof );
                                        violationInfo.addItem( info, offendingEvent, ( (Partitionable) obj ).get___Mri( ) );
                                    }
                                } catch ( ClassCastException e ) {
                                    event.veto( "Class Cast exception" ); //$NON-NLS-1$
                                } catch ( ExpressionUndefinedException e ) {
                                    event.veto( "The expression is undefined" ); //$NON-NLS-1$
                                }
                            }
                        }
                        // the first Exception thrown by a listener will be rethrown
                        ImmediateListenerWrapper.this.dispatchEvent( violationInfo );
                    }
                }

            };

            // TODO Exception???
            this.myFilter = ImmediateListenerWrapper.this.ia.analyze( this.severityMap.keySet( ), OclMetaModelConstraintRegistryImpl.this.getJmiCreator( connection ) );
            OclMetaModelConstraintRegistryImpl.this.mySession.getEventRegistry( ).registerListener( this.myListener, this.myFilter );

        }

        /**
         * @param listener
         */
        boolean registerListener( ImmediateConstraintViolationListener listener ) {

            return this.myListeners.add( listener );
        }

        void registerChangeListener( CoreConnection connection, ChangeListener additionalChangeListener ) {

            connection.getSession( ).getEventRegistry( ).registerListener( additionalChangeListener, this.myFilter );
        }

        void unregisterChangeListener( CoreConnection connection, ChangeListener additionalChangeListener ) {

            connection.getSession( ).getEventRegistry( ).deregister( additionalChangeListener );
        }

        boolean unregisterListener( ImmediateConstraintViolationListener listener ) {

            return this.myListeners.remove( listener );
        }

        void dispatchEvent( EventBasedConstraintViolationStatus event ) {

            if ( JMX_ENABLED && OclMetaModelConstraintRegistryImpl.this.registryService.jmxNotificationsEnabled ) {
                OclMetaModelConstraintRegistryImpl.this.registryService.constraintViolationsDetected( event );
            }
            VetoException exceptionToThrow = null;
            for ( Iterator<ImmediateConstraintViolationListener> it = this.myListeners.iterator( ); it.hasNext( ); ) {
                try {
                    it.next( ).notify( event );
                } catch ( VetoException ve ) {
                    if ( exceptionToThrow == null ) {
                        exceptionToThrow = ve;
                    }
                } catch ( RuntimeException e ) {
                    // $JL-EXC$
                }
            }
            if ( exceptionToThrow != null ) {
                throw exceptionToThrow;
            }
        }

        void evaluateImpactAnalysisEvents( CoreConnection connection, Set<ModelChangeEvent> events, ImmediateConstraintViolationListener listener ) {

            EventBasedConstraintViolationStatusImpl violationInfo = new EventBasedConstraintViolationStatusImpl( );

            EvaluationHelper helper = new EvaluationHelper( );

            for ( ModelChangeEvent event : events ) {
                for ( Iterator<EvaluationUnit> eus = this.ia.filter( connection, event ).iterator( ); eus.hasNext( ); ) {
                    EvaluationUnit unit = eus.next( );
                    OclStatement statement = unit.getAffectedStatement( );
                    Set<OclAny> instances = helper.getAffectedInstances( connection, unit );
                    for ( OclAny oclAny : instances ) {
                        RefObject obj = (RefObject) oclAny.getWrappedObject( );
                        try {
                            boolean result = this.evaluator.evaluate( connection, statement.getExpression( ), obj );
                            if ( !result ) {

                                String constraintMof = this.stmtToConstraintMofId.get( statement );
                                OclRegistration info = OclMetaModelConstraintRegistryImpl.this.getWsRegistry( connection ).getInfo( constraintMof );
                                violationInfo.addItem( info, event, ( (Partitionable) obj ).get___Mri( ) );
                            }
                        } catch ( ClassCastException e ) {
                            event.veto( "Class Cast exception" ); //$NON-NLS-1$
                        } catch ( ExpressionUndefinedException e ) {
                            event.veto( "The expression is undefined" ); //$NON-NLS-1$
                        }
                    }
                }
            }
            if ( violationInfo.hasItems( ) ) {
                if ( JMX_ENABLED && OclMetaModelConstraintRegistryImpl.this.registryService.jmxNotificationsEnabled ) {
                    OclMetaModelConstraintRegistryImpl.this.registryService.constraintViolationsDetected( violationInfo );
                }
                listener.notify( violationInfo );
            }

        }
    }

    private final class EventCollectingListenerWrapper {

        private final Set<DeferredConstraintViolationListener> myListeners = new HashSet<DeferredConstraintViolationListener>( );

        private final Map<OclStatement, String> stmtToConstraintMofd;

        final Map<OclStatement, OclRegistrationSeverity> severityMap;

        final Set<ModelChangeEvent> myEvents = new HashSet<ModelChangeEvent>( );

        final ImpactAnalyzer ia;

        final OclConstraintEvaluator evaluator;

        private final ChangeListener myListener;

        EventCollectingListenerWrapper( CoreConnection connection, Map<OclStatement, OclRegistrationSeverity> theSeverityMap, Map<OclStatement, String> stmtToConstraintMofId ) throws OclManagerException {

            if ( theSeverityMap.isEmpty( ) ) {
                throw new OclManagerException( OclServiceExceptions.NOREGISTRATIONSFOUND );
            }
            this.severityMap = theSeverityMap;
            this.stmtToConstraintMofd = stmtToConstraintMofId;

            this.ia = new ImpactAnalyzer( false );
            this.evaluator = new OclConstraintEvaluator( );

            this.myListener = new ChangeListener( ) {

                public void notify( ChangeEvent event ) {

                    if ( event instanceof ModelChangeEvent ) {
                        if ( OclMetaModelConstraintRegistryImpl.LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                            OclMetaModelConstraintRegistryImpl.LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.EVTRECEIVEDEVTCOLLLISTWRAPPER, event, EventCollectingListenerWrapper.this.toString( ) );
                        }
                        ModelChangeEvent offendingEvent = (ModelChangeEvent) event;
                        EventCollectingListenerWrapper.this.myEvents.add( offendingEvent );
                    }
                }
            };

            EventFilter filter = EventCollectingListenerWrapper.this.ia.analyze( this.severityMap.keySet( ), OclMetaModelConstraintRegistryImpl.this.getJmiCreator( connection ) );
            if ( OclMetaModelConstraintRegistryImpl.LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                OclMetaModelConstraintRegistryImpl.LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.REGISTEREVTCOLLECTINGWRAPPER, this.toString( ), filter.toString( ) );
            }
            OclMetaModelConstraintRegistryImpl.this.mySession.getEventRegistry( ).registerListener( this.myListener, filter );

        }

        /**
         * @param listener
         */
        boolean registerListener( DeferredConstraintViolationListener listener ) {

            return this.myListeners.add( listener );
        }

        void unregisterChangeListener( CoreConnection connection, ChangeListener additionalChangeListener ) {

            connection.getSession( ).getEventRegistry( ).deregister( additionalChangeListener );
        }

        boolean unregisterListener( DeferredConstraintViolationListener listener ) {

            return this.myListeners.remove( listener );
        }

        /**
         * Called by the OclMetaModelConstraintRegistryImpl
         */
        public void resetEvents( ) {

            this.myEvents.clear( );
        }

        boolean evaluateCollectedEvents( CoreConnection connection ) {

            if ( this.myListeners.isEmpty( ) ) {
                return false;
            }

            DeferredConstraintViolationStatusImpl violationInfo = new DeferredConstraintViolationStatusImpl( );

            EvaluationHelper helper = new EvaluationHelper( );

            for ( EvaluationUnit unit : this.ia.filter( connection, this.myEvents ) ) {
                OclStatement statement = unit.getAffectedStatement( );
                Set<OclAny> instances = helper.getAffectedInstances( connection, unit );
                for ( OclAny oclAny : instances ) {
                    RefObject obj = (RefObject) oclAny.getWrappedObject( );
                    try {

                        boolean result = this.evaluator.evaluate( connection, statement.getExpression( ), obj );
                        if ( !result ) {
                            String constraintMof = this.stmtToConstraintMofd.get( statement );
                            OclRegistration info = OclMetaModelConstraintRegistryImpl.this.getWsRegistry( connection ).getInfo( constraintMof );
                            violationInfo.addItem( connection, info, ( (Partitionable) obj ).get___Mri( ) );
                        }
                    } catch ( ExpressionUndefinedException e ) {
                        String constraintMof = this.stmtToConstraintMofd.get( statement );
                        OclRegistration info = OclMetaModelConstraintRegistryImpl.this.getWsRegistry( connection ).getInfo( constraintMof );
                        violationInfo.addItem( connection, info, ( (Partitionable) obj ).get___Mri( ), new OclManagerException( e ) );
                    }
                }
            }

            if ( violationInfo.hasItems( ) ) {
                if ( JMX_ENABLED && OclMetaModelConstraintRegistryImpl.this.registryService.jmxNotificationsEnabled ) {
                    OclMetaModelConstraintRegistryImpl.this.registryService.constraintViolationsDetected( violationInfo );
                }
                for ( DeferredConstraintViolationListener listener : this.myListeners ) {
                    listener.notify( violationInfo );
                }
            }
            return true;
        }
    }

    /**
     * The constructor needs the session
     * 
     * @param actRegistryService service
     * @param session session
     */
    public OclMetaModelConstraintRegistryImpl( OclRegistryServiceImpl actRegistryService, CoreSession session ) {

        this.registryService = actRegistryService;
        this.mySession = session;
    }

    OclMetaModelConstraintWorkspaceSetRegistry getWsRegistry( CoreConnection connection ) {

        WorkspaceSetImpl wsi = (WorkspaceSetImpl) this.mySession.getWorkspaceSet( );
        return wsi.getOrCreateOclMMConstraintRegistry( connection );
    }

    MoinJmiCreator getJmiCreator( CoreConnection connection ) throws OclManagerException {

        return new JmiCreator( connection, true, connection.getOrCreateTransientPartition( "OclMMRegistry" ) ); //$NON-NLS-1$
    }

    public synchronized boolean registerPartitionBasedConstraintViolationListener( CoreConnection connection, String category, DeferredConstraintViolationListener listener ) {

        if ( listener == null ) {
            LOGGER.trace( MoinSeverity.WARNING, OclServiceTraces.IGNORINGNULLLISTENER );
            return false;
        }

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.REGISTERLISTENEROFTYPE, LISTENER_TYPE_PARITITON_BASED, category, listener.toString( ) );
        }

        if ( this.deferredListeners.containsKey( category ) ) {
            return this.deferredListeners.get( category ).registerListener( listener );
        }

        try {
            this.getWsRegistry( connection ).getSeverityMap( connection, category );
        } catch ( OclConstraintManagerException e1 ) {
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( MoinSeverity.INFO, OclServiceTraces.REGISTERFORNONEXISTINGCATEGORY, category );
            }
            return false;
        }

        DeferredListenerWrapper wrapper;
        try {
            wrapper = new DeferredListenerWrapper( connection, this.getWsRegistry( connection ).getSeverityMap( connection, category ), this.getWsRegistry( connection ).getStmtConstraintMap( ) );
            this.deferredListeners.put( category, wrapper );
            return wrapper.registerListener( listener );
        } catch ( OclManagerException e ) {
            LOGGER.trace( MoinSeverity.ERROR, OclServiceTraces.EXCEPTIONLISTENERWRAPPER, category );
        }
        return false;


    }

    public boolean registerDeferredConstraintViolationListenerForEvents( CoreConnection connection, String category, DeferredConstraintViolationListener listener ) {

        if ( listener == null ) {
            LOGGER.trace( MoinSeverity.WARNING, OclServiceTraces.IGNORINGNULLLISTENER );
            return false;
        }

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.REGISTERLISTENEROFTYPE, LISTENER_TYPE_DEFERRED_FOR_EVENTS, category, listener.toString( ) );
        }

        try {
            this.getWsRegistry( connection ).getSeverityMap( connection, category );
        } catch ( OclConstraintManagerException e1 ) {
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( MoinSeverity.INFO, OclServiceTraces.REGISTERFORNONEXISTINGCATEGORY, category );
            }
            return false;
        }

        try {
            EventCollectingListenerWrapper listenerWrapper = this.getOrCreateEventCollectingListenerWrapper( connection, category );
            return listenerWrapper.registerListener( listener );
        } catch ( OclConstraintManagerException e ) {
            LOGGER.trace( MoinSeverity.ERROR, OclServiceTraces.EXCEPTIONLISTENERWRAPPER, category );
        }
        return false;

    }

    /**
     * Used by the OclRegistryServiceImpl
     * 
     * @param connection connection
     * @param category category
     * @param partitionPris partitions
     * @return true if something was evaluated
     */
    public boolean triggerCategoryEvaluation( CoreConnection connection, String category, Set<PRI> partitionPris ) {

        if ( partitionPris.isEmpty( ) ) {
            return false;
        }
        try {
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.STARTCATEGORYEVALUATION, category, Integer.valueOf( partitionPris.size( ) ) );
            }
            DeferredListenerWrapper wrapper = this.deferredListeners.get( category );
            if ( wrapper == null ) {
                if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                    LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.NOLISTENER, category );
                }
                return false;
            }
            Set<ModelPartition> partitions = new HashSet<ModelPartition>( );
            for ( PRI pri : partitionPris ) {
                partitions.add( connection.getPartition( pri ) );
            }
            return wrapper.triggerConstraintEvaluation( connection, partitions );
        } finally {
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.ENDCATEGORYEVALUATION, category );
            }
        }
    }

    /**
     * Called by the OclRegistrySericeImpl
     * 
     * @param category category
     */
    public void resetEvents( String category ) {

        EventCollectingListenerWrapper wrapper = this.eventCollectionListeners.get( category );
        if ( wrapper != null ) {
            wrapper.resetEvents( );
        }
        this.registryService.eventsReset( category );
    }

    /**
     * Called by the OclRegistryServiceImpl
     * 
     * @param connection connection
     * @param category category
     * @return true if anything was evaluated
     */
    public boolean analyzeCollectedEvents( CoreConnection connection, String category ) {

        EventCollectingListenerWrapper wrapper = this.eventCollectionListeners.get( category );
        if ( wrapper == null ) {
            return false;
        }

        return wrapper.evaluateCollectedEvents( connection );
    }

    /**
     * The implementation for RefBaseObject refVerifyConstraints (shallow)
     * 
     * @param connection connection
     * @param targetObject object
     * @param categories filter, if empty, all constraints are checked
     * @return a possibly empty Collection of detected violations
     */
    public DeferredConstraintViolationStatus verifyConstraints( CoreConnection connection, RefBaseObject targetObject, Set<String> categories ) {

        Set<String> nonVirtualCategories = new HashSet<String>( );
        nonVirtualCategories.addAll( categories );
        nonVirtualCategories.remove( OclRegistrationCategory.virtual.name( ) );

        Set<RefBaseObject> objectsToCheck = new HashSet<RefBaseObject>( );
        objectsToCheck.add( targetObject );

        DeferredConstraintViolationStatusImpl status = new DeferredConstraintViolationStatusImpl( );

        boolean violationDetected = false;

        Set<List<String>> constraintsToCheck = new HashSet<List<String>>( );
        // TODO this seems to be unused
        Set<List<String>> metamodelConstraintsToCheck = new HashSet<List<String>>( );

        ModelElement metaObject = (ModelElement) targetObject.refMetaObject( );

        JmiList<Constraint> constraints = (JmiList<Constraint>) ( (ModelElementInternal) metaObject ).getConstraints( connection );

        for ( Iterator<Constraint> it = constraints.iterator( connection ); it.hasNext( ); ) {
            Constraint constraint = it.next( );
            String language = constraint.getLanguage( );
            // TODO this wrongly uses the "constrained element" association, but should use
            // the "invariant Of" association in which case the check for the Language would
            // not be needed            
            if ( !( OclConstants.L_OCL.equals( language ) ) ) {
                continue;
            }
            if ( constraint instanceof OclConstraint ) {
                constraintsToCheck.add( ( (OclConstraintImpl) constraint ).getQualifiedName( connection ) );
            } else {
                List<String> qname = ( (ConstraintImpl) constraint ).getQualifiedName( connection );
                if ( OclConstants.P_MODEL.equals( qname.get( 0 ) ) || OclConstants.P_OCL.equals( qname.get( 0 ) ) ) {
                    metamodelConstraintsToCheck.add( qname );
                }
            }
        }

        if ( metaObject instanceof GeneralizableElement ) {
            List<GeneralizableElement> supertypes = MoinMetamodelCode.allSupertypes( connection, (GeneralizableElement) metaObject, (RefObjectImpl) metaObject );
            for ( GeneralizableElement supertype : supertypes ) {
                JmiList<Constraint> supertypeConstraints = (JmiList<Constraint>) ( (ModelElementInternal) supertype ).getConstraints( connection );
                for ( Iterator<Constraint> it = supertypeConstraints.iterator( connection ); it.hasNext( ); ) {
                    Constraint constraint = it.next( );
                    // TODO this wrongly uses the "constrained element" association, see above
                    String language = constraint.getLanguage( );
                    if ( !( OclConstants.L_OCL.equals( language ) ) ) {
                        continue;
                    }
                    if ( constraint instanceof OclConstraint ) {
                        constraintsToCheck.add( ( (OclConstraintImpl) constraint ).getQualifiedName( connection ) );
                    } else {
                        List<String> qname = ( (ConstraintImpl) constraint ).getQualifiedName( connection );
                        if ( OclConstants.P_MODEL.equals( qname.get( 0 ) ) || OclConstants.P_OCL.equals( qname.get( 0 ) ) ) {
                            metamodelConstraintsToCheck.add( qname );
                        }
                    }
                }
            }
        }

        for ( List<String> name : constraintsToCheck ) {
            OclConstraintInternal c = (OclConstraintInternal) this.getWsRegistry( connection ).getConstraint( name );
            if ( c == null ) {
                LOGGER.trace( MoinSeverity.ERROR, OclServiceExceptions.CONSTRAINTNOTFOUNDINREGISTRY, name.toString( ) );
                continue;
            }
            try {

                OclMetaModelConstraintRegistration reg = this.getWsRegistry( connection ).getInfo( c.refMofId( ) );

                if ( !nonVirtualCategories.isEmpty( ) ) {
                    boolean evaluate = false;
                    Set<String> constraintCategories = reg.getCategories( );
                    for ( String category : nonVirtualCategories ) {
                        if ( constraintCategories.contains( category ) ) {
                            evaluate = true;
                            break;
                        }
                    }
                    if ( !evaluate ) {
                        continue;
                    }
                }

                OclAny context = OclFactory.instance( ).create( targetObject );

                EvaluationContext ctxt = new EvaluationContextImpl( context );
                OclAny oclResult = ExpressionEvaluator.instance( ).evaluate( connection, c.getOclExpression( connection ), ctxt );
                if ( oclResult instanceof OclBoolean ) {
                    boolean errorFound = !( (OclBoolean) oclResult ).getWrappedBoolean( ).booleanValue( );
                    if ( errorFound ) {
                        status.addItem( connection, reg, ( (Partitionable) targetObject ).get___Mri( ) );
                    }
                    violationDetected = violationDetected || errorFound;
                } else {

                    status.addItem( connection, reg, ( (Partitionable) targetObject ).get___Mri( ), new OclManagerException( OclServiceExceptions.INVMUSTEVALTOBOOLEAN ) );
                }

            } finally {
                EvaluationContext.CurrentContext.reset( );
            }
        }

        Set<OclRegistrationCategory> moinAndMofCats = new HashSet<OclRegistrationCategory>( );
        if ( categories.isEmpty( ) || categories.contains( OclRegistrationCategory.immediate.name( ) ) || categories.contains( OclRegistrationCategory.virtual.name( ) ) ) {
            moinAndMofCats.add( OclRegistrationCategory.immediate );
        }
        if ( categories.isEmpty( ) || categories.contains( OclRegistrationCategory.deferred.name( ) ) || categories.contains( OclRegistrationCategory.virtual.name( ) ) ) {
            moinAndMofCats.add( OclRegistrationCategory.deferred );
        }
        if ( moinAndMofCats.size( ) > 0 ) {
            Map<StructuralFeature, Set<RefBaseObject>> checked = new HashMap<StructuralFeature, Set<RefBaseObject>>( );

            MoinAndMofConstraints checker = new MoinAndMofConstraints( connection );
            List<DeferredConstraintViolationStatusItem> exceptions = checker.checkManualConstraints( targetObject, checked, moinAndMofCats.toArray( new OclRegistrationCategory[moinAndMofCats.size( )] ) );
            for ( DeferredConstraintViolationStatusItem exception : exceptions ) {

                if ( !categories.isEmpty( ) ) {
                    Set<String> constraintCategories = exception.getConstraintRegistration( ).getCategories( );
                    for ( String category : categories ) {
                        if ( constraintCategories.contains( category ) ) {
                            status.addItem( exception );
                            break;
                        }
                    }
                } else {
                    status.addItem( exception );
                }

            }
        }
        if ( status.hasItems( ) ) {
            if ( JMX_ENABLED && this.registryService.jmxNotificationsEnabled ) {
                this.registryService.constraintViolationsDetected( status );
            }
        }
        return status;
    }

    public Set<OclMetaModelConstraintRegistration> getAvailableMetamodelConstraints( CoreConnection connection ) {

        return this.getWsRegistry( connection ).getAvailableMetamodelConstraints( );
    }

    public Map<String, Set<OclMetaModelConstraintRegistration>> getRegistry( CoreConnection connection ) {

        Map<String, Set<OclMetaModelConstraintRegistration>> result = new HashMap<String, Set<OclMetaModelConstraintRegistration>>( );
        Map<String, Set<OclConstraint>> registryTab = this.getWsRegistry( connection ).getRegistryInternal( );

        for ( Entry<String, Set<OclConstraint>> entry : registryTab.entrySet( ) ) {
            String category = entry.getKey( );
            Set<OclMetaModelConstraintRegistration> infos = new HashSet<OclMetaModelConstraintRegistration>( );
            Set<OclConstraint> constraints = entry.getValue( );
            for ( OclConstraint constraint : constraints ) {
                infos.add( this.getWsRegistry( connection ).getInfo( constraint.refMofId( ) ) );
            }
            result.put( category, infos );
        }

        return result;
    }

    public boolean registerImmediateConstraintViolationListener( CoreConnection connection, String category, ImmediateConstraintViolationListener listener ) throws IllegalArgumentException {

        if ( listener == null ) {
            LOGGER.trace( MoinSeverity.WARNING, OclServiceTraces.IGNORINGNULLLISTENER );
            return false;
        }

        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.REGISTERLISTENEROFTYPE, LISTENER_TYPE_IMMEDIATE, category, listener.toString( ) );
        }

        if ( OclRegistrationCategory.immediate.toString( ).equals( category ) ) {
            throw new MoinIllegalArgumentException( OclServiceExceptions.CANNOTREGISTERLISTENERSFORIMMEDIATECATEGORY );
        }
        try {
            this.getWsRegistry( connection ).getSeverityMap( connection, category );
        } catch ( OclConstraintManagerException e1 ) {
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( MoinSeverity.INFO, OclServiceTraces.REGISTERFORNONEXISTINGCATEGORY, category );
            }
            return false;
        }

        try {
            ImmediateListenerWrapper wrapper = this.getOrCreateImmediateListenerWrapper( connection, category );
            this.immediateListeners.put( category, wrapper );
            return wrapper.registerListener( listener );
        } catch ( OclConstraintManagerException e ) {
            LOGGER.trace( MoinSeverity.ERROR, OclServiceTraces.EXCEPTIONLISTENERWRAPPER, category );
        }
        return false;

    }

    private ImmediateListenerWrapper getOrCreateImmediateListenerWrapper( CoreConnection connection, String category ) throws OclConstraintManagerException {

        if ( this.immediateListeners.containsKey( category ) ) {
            return this.immediateListeners.get( category );
        }
        try {
            return new ImmediateListenerWrapper( connection, this.getWsRegistry( connection ).getSeverityMap( connection, category ), this.getWsRegistry( connection ).getStmtConstraintMap( ) );
        } catch ( OclManagerException e ) {
            throw new OclConstraintManagerException( e );
        }
    }

    public boolean unregisterDeferredListener( CoreConnection connection, DeferredConstraintViolationListener listener ) {

        boolean unregistered = false;
        for ( Iterator<DeferredListenerWrapper> wrappers = this.deferredListeners.values( ).iterator( ); wrappers.hasNext( ); ) {
            unregistered = wrappers.next( ).unregisterListener( listener ) || unregistered;
        }
        for ( Iterator<EventCollectingListenerWrapper> wrappers = this.eventCollectionListeners.values( ).iterator( ); wrappers.hasNext( ); ) {
            unregistered = wrappers.next( ).unregisterListener( listener ) || unregistered;
        }
        return unregistered;
    }

    public boolean unregisterImmediateListener( CoreConnection connection, ImmediateConstraintViolationListener listener ) {

        boolean unregistered = false;
        for ( Iterator<ImmediateListenerWrapper> wrappers = this.immediateListeners.values( ).iterator( ); wrappers.hasNext( ); ) {
            unregistered = wrappers.next( ).unregisterListener( listener ) || unregistered;
        }
        return unregistered;
    }

    private EventCollectingListenerWrapper getOrCreateEventCollectingListenerWrapper( CoreConnection connection, String category ) throws OclConstraintManagerException {

        if ( this.eventCollectionListeners.containsKey( category ) ) {
            return this.eventCollectionListeners.get( category );
        }
        try {

            EventCollectingListenerWrapper wrapper = new EventCollectingListenerWrapper( connection, this.getWsRegistry( connection ).getSeverityMap( connection, category ), this.getWsRegistry( connection ).getStmtConstraintMap( ) );
            this.eventCollectionListeners.put( category, wrapper );
            return wrapper;
        } catch ( OclManagerException e ) {
            throw new OclConstraintManagerException( e );
        }
    }

    /**
     * Called back by the StatusItemImpls
     * 
     * @param locale Locale
     * @param connection connection
     * @param constraintMRI MRI
     * @param expressions expressions
     * @param evaluationContext context
     * @return the evaluated message
     * @throws OclManagerException Exception
     */
    public String evaluateViolationMessageExpresssion( Locale locale, CoreConnection connection, MRI constraintMRI, List<OclExpression> expressions, RefObject evaluationContext ) throws OclManagerException {

        int index = 0;
        String localizedTemplate;

        try {
            OclConstraintInternal constraint = (OclConstraintInternal) connection.getElement( constraintMRI );
            String name = QualifiedName.toDotSeparatedString( constraint.getQualifiedName( connection ) );
            String resourceKey = name + OclConstants.DOT + VIOLATION_MESSAGE_RESKEY_EXTENSION;
            localizedTemplate = connection.getSession( ).getMoin( ).getMetaModelRegistry( ).getLocalizedString( constraintMRI.getCri( ), locale, resourceKey );
        } catch ( Exception e1 ) {
            // TODO tracing etc
            localizedTemplate = null;
        }

        if ( localizedTemplate == null ) {
            String messageTemplate = OclConstants.EMPTY;
            List<Object> args = new ArrayList<Object>( );

            for ( OclExpression expression : expressions ) {
                try {
                    OclAny context = OclFactory.instance( ).create( evaluationContext );
                    EvaluationContext ctxt = new EvaluationContextImpl( context );
                    OclAny oclResult = ExpressionEvaluator.instance( ).evaluate( connection, expression, ctxt );
                    if ( index == 0 && oclResult instanceof OclString ) {
                        messageTemplate = ( (OclString) oclResult ).getWrappedString( );
                    } else if ( index == 0 ) {
                        // the first one must always be a String
                        throw new OclManagerException( new ExpressionUndefinedException( OclServiceExceptions.EXPEVALUATESTOUNDEFINED ) );
                    } else {
                        try {
                            args.add( oclResult.getWrappedObject( ) );
                        } catch ( RuntimeException e ) {
                            args.add( OclConstants.UNDEFINED );
                        }
                    }
                } finally {
                    EvaluationContext.CurrentContext.reset( );
                }
                index++;
                // we skip the rest (no support for parameterized messages)
                break;
            }

            return messageTemplate;
        }

        List<Object> args = new ArrayList<Object>( );

        for ( OclExpression expression : expressions ) {
            try {
                OclAny context = OclFactory.instance( ).create( evaluationContext );
                EvaluationContext ctxt = new EvaluationContextImpl( context );
                OclAny oclResult = ExpressionEvaluator.instance( ).evaluate( connection, expression, ctxt );
                try {
                    args.add( oclResult.getWrappedObject( ) );
                } catch ( RuntimeException e ) {
                    args.add( OclConstants.UNDEFINED );
                }

            } finally {
                EvaluationContext.CurrentContext.reset( );
            }
            index++;

        }

        if ( args.size( ) > 0 ) {
            Object[] arguments = new Object[args.size( )];
            args.toArray( arguments );
            MessageFormat format = new MessageFormat( localizedTemplate, locale );
            return format.format( arguments );
        }

        return localizedTemplate;

    }

    public DeferredConstraintViolationStatus verifyConstraints( CoreConnection connection, Set<PRI> pris, Set<String> categories ) throws OclManagerException {

        long start = System.nanoTime( );
        DeferredConstraintViolationStatusImpl status = new DeferredConstraintViolationStatusImpl( );

        try {

            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.STARTREGSRVVERIFYCONSTRAINTS, Integer.valueOf( pris.size( ) ), Integer.valueOf( categories.size( ) ) );
            }

            for ( PRI pri : pris ) {
                for ( Partitionable e : connection.getPartition( pri ).getElements( ) ) {
                    if ( !( e instanceof ModelElement ) ) {
                        DeferredConstraintViolationStatus stat = verifyConstraints( connection, (RefBaseObject) e, categories );
                        for ( DeferredConstraintViolationStatusItem item : stat.getAll( ) ) {
                            status.addItem( item );
                        }
                    }
                }
            }
        } catch ( RuntimeException re ) {
            OclManagerException e = new OclManagerException( OclServiceExceptions.EXCEPTIONWHILEVERIFYCONSTRAINTS );
            e.initCause( re );
            throw e;
        } finally {
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.COMPLETEREGSRVVERIFYCONSTRAINTS, new Long( System.nanoTime( ) - start ), new Integer( status.getAll( ).size( ) ) );
            }
        }

        return status;
    }
}
