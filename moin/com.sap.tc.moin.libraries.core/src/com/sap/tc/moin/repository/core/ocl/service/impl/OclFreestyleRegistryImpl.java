package com.sap.tc.moin.repository.core.ocl.service.impl;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.ocl.evaluator.EvaluationContext;
import com.sap.tc.moin.ocl.evaluator.EvaluationContextImpl;
import com.sap.tc.moin.ocl.evaluator.expr.ExpressionEvaluator;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclBoolean;
import com.sap.tc.moin.ocl.ia.ImpactAnalyzer;
import com.sap.tc.moin.ocl.ia.result.EvaluationUnit;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.jmi.JmiCreator;
import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;
import com.sap.tc.moin.ocl.utils.localization.OclServiceExceptions;
import com.sap.tc.moin.ocl.utils.localization.OclServiceTraces;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;
import com.sap.tc.moin.repository.ocl.freestyle.OclFreestyleRegistry;
import com.sap.tc.moin.repository.ocl.freestyle.OclInvariantRegistration;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistration;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.ImmediateConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationCategory;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

/**
 * @author d022737
 */
public class OclFreestyleRegistryImpl implements OclFreestyleRegistry {

    private final static MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE_OCL, OclFreestyleRegistryImpl.class );

    private final Map<String, OclRegistration> categoryRegistrationMap = new HashMap<String, OclRegistration>( );

    private final Map<String, CategoryInvariantHandler> categoryInvariantHandlerMapping = new HashMap<String, CategoryInvariantHandler>( );

    private final Map<String, Set<OclExpressionRegistrationImpl>> categoryExpressionRegistrationMapping = new HashMap<String, Set<OclExpressionRegistrationImpl>>( );

    // non-private for inner class access
    final CoreConnection connection;

    final OclRegistryServiceImpl registryService;

    private final class CategoryInvariantHandler {

        @SuppressWarnings( "unused" )
        private final String myCategory;

        final Set<ModelChangeEvent> collectedEvents = new HashSet<ModelChangeEvent>( );

        final Set<DeferredConstraintViolationListener> myEventListeners = new HashSet<DeferredConstraintViolationListener>( );

        final Set<DeferredConstraintViolationListener> myPartitionListeners = new HashSet<DeferredConstraintViolationListener>( );

        final Set<ImmediateConstraintViolationListener> myImmediateListeners = new HashSet<ImmediateConstraintViolationListener>( );

        private final Set<OclInvariantRegistrationImpl> myRegistrations = new HashSet<OclInvariantRegistrationImpl>( );

        final Map<OclStatement, OclInvariantRegistrationImpl> stmtRegistrationMap = new HashMap<OclStatement, OclInvariantRegistrationImpl>( );

        private final MoinJmiCreator myJmiCreator;

        final ImpactAnalyzer analyzer;

        final EvaluationHelper evalHelper;

        private boolean isRegisteredInEventFramework = false;

        private EventFilter filter = null;

        private final ChangeListener myListener;

        /**
         * @param category category
         * @throws OclManagerException Exception
         */
        public CategoryInvariantHandler( String category ) throws OclManagerException {

            this.analyzer = new ImpactAnalyzer( false );
            this.myCategory = category;
            this.myJmiCreator = new JmiCreator( OclFreestyleRegistryImpl.this.connection, false, OclFreestyleRegistryImpl.this.connection.getOrCreateTransientPartitionNonTransactional( "OclTransientPartition" ) ); //$NON-NLS-1$
            this.evalHelper = new EvaluationHelper( );

            this.myListener = new ChangeListener( ) {

                public void notify( ChangeEvent event ) {

                    if ( event instanceof ModelChangeEvent ) {

                        ModelChangeEvent mce = (ModelChangeEvent) event;
                        boolean collectEvents = false;
                        boolean evaluateEvents = false;

                        if ( !CategoryInvariantHandler.this.myImmediateListeners.isEmpty( ) ) {
                            evaluateEvents = true;
                        }

                        if ( !CategoryInvariantHandler.this.myEventListeners.isEmpty( ) ) {
                            collectEvents = true;
                        }

                        if ( !evaluateEvents && !collectEvents ) {
                            return;
                        }

                        if ( collectEvents ) {
                            CategoryInvariantHandler.this.collectedEvents.add( mce );
                            if ( !evaluateEvents ) {
                                return;
                            }
                        }

                        EventBasedConstraintViolationStatusImpl status = new EventBasedConstraintViolationStatusImpl( );

                        Set<EvaluationUnit> units = CategoryInvariantHandler.this.analyzer.filter( OclFreestyleRegistryImpl.this.connection, mce );

                        for ( EvaluationUnit unit : units ) {
                            OclStatement statement = unit.getAffectedStatement( );
                            OclRegistration registration = CategoryInvariantHandler.this.stmtRegistrationMap.get( statement );
                            Set<OclAny> instances = CategoryInvariantHandler.this.evalHelper.getAffectedInstances( OclFreestyleRegistryImpl.this.connection, unit );
                            for ( OclAny instance : instances ) {
                                try {
                                    boolean result = CategoryInvariantHandler.this.evaluateInvariant( statement, instance );
                                    if ( !result ) {
                                        status.addItem( registration, mce, ( ( (Partitionable) instance.getWrappedObject( ) ).get___Mri( ) ) );
                                    }
                                } catch ( OclManagerException e ) {
                                    status.addItem( registration, mce, ( ( (Partitionable) instance.getWrappedObject( ) ).get___Mri( ) ), e );
                                }
                            }
                        }

                        if ( status.hasItems( ) ) {
                            if ( JMX_ENABLED && OclFreestyleRegistryImpl.this.registryService.jmxNotificationsEnabled ) {
                                OclFreestyleRegistryImpl.this.registryService.constraintViolationsDetected( status );
                            }
                            for ( ImmediateConstraintViolationListener listener : CategoryInvariantHandler.this.myImmediateListeners ) {
                                listener.notify( status );
                            }
                        }
                    }
                }
            };
        }

        private void registerInEventFramework( ) {

            this.myJmiCreator.getConnection( ).getSession( ).getEventRegistry( ).registerListener( this.myListener, this.filter );
            this.isRegisteredInEventFramework = true;
        }

        private void unregisterInEventFramework( ) {

            this.myJmiCreator.getConnection( ).getSession( ).getEventRegistry( ).deregister( this.myListener );
        }

        private void registerInEventFrameworkIfNecessary( boolean registrationsChanged ) {

            if ( registrationsChanged ) {
                Set<OclStatement> oclStatements = this.stmtRegistrationMap.keySet( );
                this.analyzer.reset( );

                this.filter = this.analyzer.analyze( oclStatements, this.myJmiCreator );
                if ( this.isRegisteredInEventFramework ) {
                    this.unregisterInEventFramework( );
                }

            }
            if ( this.isRegisteredInEventFramework ) {
                // we can unregister if no listeners are there anymore
                if ( this.myEventListeners.isEmpty( ) && this.myImmediateListeners.isEmpty( ) ) {
                    this.unregisterInEventFramework( );
                }
            } else {
                // we need to register if at least one listener exists
                if ( !this.myEventListeners.isEmpty( ) || !this.myImmediateListeners.isEmpty( ) ) {
                    this.registerInEventFramework( );
                }
            }
        }

        private Set<Classifier> getClassifiersFromPartition( Set<ModelPartition> partitions ) {

            Set<Classifier> result = new HashSet<Classifier>( );

            for ( ModelPartition partition : partitions ) {
                for ( Partitionable partitionable : partition.getElements( ) ) {
                    if ( partitionable instanceof RefObject ) {
                        RefObject meta = ( (RefObject) partitionable ).refMetaObject( );
                        if ( meta instanceof Classifier ) {
                            result.add( (Classifier) meta );
                        }
                    }
                }
            }
            return result;
        }

        boolean registerDeferredConstraintViolationListenerForEvents( DeferredConstraintViolationListener listener ) {

            boolean added = this.myEventListeners.add( listener );
            this.registerInEventFrameworkIfNecessary( false );
            return added;
        }

        boolean registerDeferredConstraintViolationListenerForPartitions( DeferredConstraintViolationListener listener ) {

            return this.myPartitionListeners.add( listener );
        }

        boolean registerImmediateConstraintViolationListener( ImmediateConstraintViolationListener listener ) {

            boolean added = this.myImmediateListeners.add( listener );
            this.registerInEventFrameworkIfNecessary( false );
            return added;
        }

        void reset( ) {

            this.collectedEvents.clear( );
        }

        synchronized boolean unregisterDeferredConstraintViolationListener( DeferredConstraintViolationListener listener ) {

            boolean removed = false;
            removed = this.myEventListeners.remove( listener );
            removed = this.myPartitionListeners.remove( listener ) || removed;
            this.registerInEventFrameworkIfNecessary( false );
            return removed;
        }

        synchronized boolean unregisterImmediateConstraintViolationListener( ImmediateConstraintViolationListener listener ) {

            boolean removed = this.myImmediateListeners.remove( listener );
            this.registerInEventFrameworkIfNecessary( false );
            return removed;
        }

        boolean evaluateInvariant( OclStatement statement, OclAny context ) throws OclManagerException {

            try {
                EvaluationContext ctxt = new EvaluationContextImpl( context );
                OclAny oclResult = ExpressionEvaluator.instance( ).evaluate( this.myJmiCreator.getConnection( ), statement.getExpression( ), ctxt );
                if ( oclResult instanceof OclBoolean ) {
                    return ( (OclBoolean) oclResult ).getWrappedBoolean( ).booleanValue( );
                }
                throw new OclManagerException( OclServiceExceptions.INVMUSTEVALTOBOOLEAN );
            } finally {
                EvaluationContext.CurrentContext.reset( );
            }
        }

        boolean evaluatePartitions( Set<ModelPartition> partitions ) throws OclManagerException {

            if ( CategoryInvariantHandler.this.myPartitionListeners.isEmpty( ) ) {
                return false;
            }

            DeferredConstraintViolationStatusImpl violationInfo = new DeferredConstraintViolationStatusImpl( );

            Set<EvaluationUnit> units = this.analyzer.filterForClasses( this.getClassifiersFromPartition( partitions ) );

            for ( EvaluationUnit unit : units ) {
                Set<OclAny> checkObjects = this.evalHelper.getAffectedInstances( this.myJmiCreator.getConnection( ), unit );
                OclStatement statement = unit.getAffectedStatement( );
                OclRegistration registration = CategoryInvariantHandler.this.stmtRegistrationMap.get( statement );

                for ( OclAny context : checkObjects ) {
                    boolean result = this.evaluateInvariant( statement, context );
                    if ( !result ) {
                        violationInfo.addItem( this.myJmiCreator.getConnection( ), registration, ( (Partitionable) context.getWrappedObject( ) ).get___Mri( ) );
                    }
                }
            }
            if ( violationInfo.hasItems( ) ) {
                if ( JMX_ENABLED && OclFreestyleRegistryImpl.this.registryService.jmxNotificationsEnabled ) {
                    OclFreestyleRegistryImpl.this.registryService.constraintViolationsDetected( violationInfo );
                }
                for ( DeferredConstraintViolationListener listener : CategoryInvariantHandler.this.myPartitionListeners ) {
                    listener.notify( violationInfo );
                }
            }
            return true;
        }

        boolean addOclRegistration( OclInvariantRegistrationImpl registration ) {

            boolean added = false;
            added = this.myRegistrations.add( registration );

            if ( added ) {
                this.stmtRegistrationMap.put( registration.getOclStatement( ), registration );
                this.registerInEventFrameworkIfNecessary( true );
            }
            return added;
        }

        boolean removeOclRegistration( OclInvariantRegistrationImpl registration ) {

            boolean removed = false;
            removed = this.myRegistrations.remove( registration );

            if ( removed ) {
                this.stmtRegistrationMap.remove( registration.getOclStatement( ) );
                this.registerInEventFrameworkIfNecessary( true );
            }
            return removed;
        }

        boolean evaluateCollectedEvents( ) throws OclManagerException {

            if ( CategoryInvariantHandler.this.myEventListeners.isEmpty( ) || this.collectedEvents.isEmpty( ) ) {
                return false;
            }

            DeferredConstraintViolationStatusImpl violationInfo = new DeferredConstraintViolationStatusImpl( );

            Set<EvaluationUnit> units = this.analyzer.filter( OclFreestyleRegistryImpl.this.connection, this.collectedEvents );

            for ( EvaluationUnit unit : units ) {
                Set<OclAny> checkObjects = this.evalHelper.getAffectedInstances( this.myJmiCreator.getConnection( ), unit );
                OclStatement statement = unit.getAffectedStatement( );
                OclRegistration registration = CategoryInvariantHandler.this.stmtRegistrationMap.get( statement );

                for ( OclAny context : checkObjects ) {
                    boolean result = this.evaluateInvariant( statement, context );
                    if ( !result ) {
                        violationInfo.addItem( this.myJmiCreator.getConnection( ), registration, ( (Partitionable) context.getWrappedObject( ) ).get___Mri( ) );
                    }
                }
            }
            if ( violationInfo.hasItems( ) ) {
                if ( JMX_ENABLED && OclFreestyleRegistryImpl.this.registryService.jmxNotificationsEnabled ) {
                    OclFreestyleRegistryImpl.this.registryService.constraintViolationsDetected( violationInfo );
                }
                for ( DeferredConstraintViolationListener listener : CategoryInvariantHandler.this.myEventListeners ) {
                    listener.notify( violationInfo );
                }
            }
            return true;
        }
    }

    /**
     * @param actRegistryService service
     * @param actConnection connection
     */
    public OclFreestyleRegistryImpl( OclRegistryServiceImpl actRegistryService, CoreConnection actConnection ) {

        this.registryService = actRegistryService;
        this.connection = actConnection;
    }

    public OclInvariantRegistration createInvariantRegistration( String name, String oclExpression, OclRegistrationSeverity severity, String[] categories, RefClass context, RefPackage[] typesPackages ) throws OclManagerException {

        synchronized ( this.categoryRegistrationMap ) {
            if ( this.categoryRegistrationMap.containsKey( name ) ) {
                throw new OclManagerException( OclServiceExceptions.REGISTRATIONEXISTS, name );
            }
            OclInvariantRegistrationImpl registration = new OclInvariantRegistrationImpl( this.connection, name, oclExpression, severity, categories, context.refMetaObject( ), typesPackages );
            this.categoryRegistrationMap.put( name, registration );
            for ( String category : categories ) {
                CategoryInvariantHandler handler = this.getOrCreateCategoryInvariantHandler( category );
                handler.addOclRegistration( registration );
            }
            return registration;
        }
    }
    
    public OclExpressionRegistration createExpressionRegistration( String name, String oclExpression, OclRegistrationSeverity severity, String[] categories, RefObject contextMetaClass, RefPackage[] typesPackages ) throws OclManagerException {

        synchronized ( this.categoryRegistrationMap ) {
            if ( this.categoryRegistrationMap.containsKey( name ) ) {
                throw new OclManagerException( OclServiceExceptions.REGISTRATIONEXISTS, name );
            }
            OclExpressionRegistrationImpl registration = new OclExpressionRegistrationImpl(this.connection, name,
		    oclExpression, severity, categories, contextMetaClass, typesPackages);
            this.categoryRegistrationMap.put( name, registration );
            for ( String category : categories ) {
                Set<OclExpressionRegistrationImpl> registrations = this.categoryExpressionRegistrationMapping.get( category );
                if ( registrations == null ) {
                    registrations = new HashSet<OclExpressionRegistrationImpl>( );
                    this.categoryExpressionRegistrationMapping.put( category, registrations );
                }
                registrations.add( registration );
            }
            return registration;
        }
    }
    
    public OclExpressionRegistration createExpressionRegistration( String name, String oclExpression, OclRegistrationSeverity severity, String[] categories, RefObject contextMetaClass, MofPackage[] packages) throws OclManagerException {

        synchronized ( this.categoryRegistrationMap ) {
            if ( this.categoryRegistrationMap.containsKey( name ) ) {
                throw new OclManagerException( OclServiceExceptions.REGISTRATIONEXISTS, name );
            }
            OclExpressionRegistrationImpl registration = new OclExpressionRegistrationImpl( this.connection, name, oclExpression, severity, categories, contextMetaClass, packages);
            this.categoryRegistrationMap.put( name, registration );
            for ( String category : categories ) {
                Set<OclExpressionRegistrationImpl> registrations = this.categoryExpressionRegistrationMapping.get( category );
                if ( registrations == null ) {
                    registrations = new HashSet<OclExpressionRegistrationImpl>( );
                    this.categoryExpressionRegistrationMapping.put( category, registrations );
                }
                registrations.add( registration );
            }
            return registration;
        }
    }

    public OclExpressionRegistration createExpressionRegistration( String name, String oclExpression, OclRegistrationSeverity severity, String[] categories, RefClass context, RefPackage[] typesPackages ) throws OclManagerException {

        return createExpressionRegistration(name, oclExpression, severity, categories, context.refMetaObject(), typesPackages);
    }

    public OclRegistration getRegistration( String name ) {

        synchronized ( this.categoryRegistrationMap ) {
            return this.categoryRegistrationMap.get( name );
        }
    }

    public boolean deleteRegistration( String name ) {

        synchronized ( this.categoryRegistrationMap ) {
            boolean removed = false;
            OclRegistration registration = this.categoryRegistrationMap.remove( name );
            if ( registration != null ) {
                removed = true;
                if ( registration instanceof OclInvariantRegistrationImpl ) {
                    OclInvariantRegistrationImpl regImpl = (OclInvariantRegistrationImpl) registration;
                    for ( CategoryInvariantHandler handler : this.categoryInvariantHandlerMapping.values( ) ) {
                        handler.removeOclRegistration( regImpl );
                    }
                }
                ( (OclRegistrationImpl) registration ).close( );
            }
            return removed;
        }
    }

    public Set<String> getRegistrationNames( ) {

        synchronized ( this.categoryRegistrationMap ) {
            return this.categoryRegistrationMap.keySet( );
        }
    }

    /**
     * Called by the OclRegistryServiceImpl
     * 
     * @param category category
     * @param partitionPris partitions
     * @return true if anything was evaluated
     * @throws OclManagerException Exception
     */
    public boolean evaluatePartitions( String category, Set<PRI> partitionPris ) throws OclManagerException {

        if ( partitionPris.isEmpty( ) ) {
            return false;
        }
        boolean evaluated = false;
        Set<ModelPartition> partitions = new HashSet<ModelPartition>( );
        for ( PRI pri : partitionPris ) {
            partitions.add( this.connection.getPartition( pri ) );
        }
        Set<OclExpressionRegistrationImpl> expRegs = this.categoryExpressionRegistrationMapping.get( category );
        if ( expRegs != null ) {
            for ( OclExpressionRegistrationImpl expressionRegistration : expRegs ) {
                expressionRegistration.triggerDeferredOclEvaluation( category, partitions );
                evaluated = true;
            }
        }

        CategoryInvariantHandler handler = this.getOrCreateCategoryInvariantHandler( category );
        evaluated = handler.evaluatePartitions( partitions ) || evaluated;
        return evaluated;
    }

    public boolean registerDeferredConstraintViolationListenerForEvents( String category, DeferredConstraintViolationListener listener ) {

        if ( category.equals( OclRegistrationCategory.immediate.name( ) ) ) {
            throw new MoinIllegalArgumentException( OclServiceExceptions.CANNOTREGISTERDEFERREDLISTENERONIMMEDIATECATEGORY );
        }
        try {
            return this.getOrCreateCategoryInvariantHandler( category ).registerDeferredConstraintViolationListenerForEvents( listener );
        } catch ( OclManagerException e ) {
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( MoinSeverity.INFO, OclServiceTraces.EXCEPTIONCREATINGCATINVHANDLER, category );
            }
            return false;
        }
    }

    public boolean registerDeferredConstraintViolationListenerForPartitions( String category, DeferredConstraintViolationListener listener ) {

        try {
            return this.getOrCreateCategoryInvariantHandler( category ).registerDeferredConstraintViolationListenerForPartitions( listener );
        } catch ( OclManagerException e ) {
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( MoinSeverity.INFO, OclServiceTraces.EXCEPTIONCREATINGCATINVHANDLER, category );
            }
            return false;
        }
    }

    public boolean registerImmediateConstraintViolationListener( String category, ImmediateConstraintViolationListener listener ) throws IllegalArgumentException {

        if ( category.equals( OclRegistrationCategory.immediate.name( ) ) ) {
            throw new MoinIllegalArgumentException( OclServiceExceptions.CANNOTREGISTERDEFERREDLISTENERONIMMEDIATECATEGORY );
        }
        try {
            return this.getOrCreateCategoryInvariantHandler( category ).registerImmediateConstraintViolationListener( listener );
        } catch ( OclManagerException e ) {
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( MoinSeverity.INFO, OclServiceTraces.EXCEPTIONCREATINGCATINVHANDLER, category );
            }
            return false;
        }
    }

    public synchronized boolean unregisterDeferredConstraintViolationListener( DeferredConstraintViolationListener listener ) {

        boolean removed = false;
        for ( CategoryInvariantHandler handler : this.categoryInvariantHandlerMapping.values( ) ) {
            removed = handler.unregisterDeferredConstraintViolationListener( listener ) || removed;
        }
        return removed;
    }

    public synchronized boolean unregisterImmediateConstraintViolationListener( ImmediateConstraintViolationListener listener ) {

        boolean removed = false;
        for ( CategoryInvariantHandler handler : this.categoryInvariantHandlerMapping.values( ) ) {
            removed = handler.unregisterImmediateConstraintViolationListener( listener ) || removed;
        }
        return removed;

    }

    /**
     * Called by the OclRegistryServiceImpl
     * 
     * @param category category
     * @return true if anything was evaluated
     * @throws OclManagerException Exception
     */
    public boolean evaluateCollectedEvents( String category ) throws OclManagerException {

        boolean evaluated = false;
        Set<OclExpressionRegistrationImpl> expRegs = this.categoryExpressionRegistrationMapping.get( category );
        if ( expRegs != null ) {
            for ( OclExpressionRegistrationImpl expressionRegistration : expRegs ) {
                expressionRegistration.triggerEvaluationForCollectedEvents( );
                evaluated = true;
            }
        }

        CategoryInvariantHandler handler = getOrCreateCategoryInvariantHandler( category );
        evaluated = handler.evaluateCollectedEvents( ) || evaluated;
        return evaluated;
    }

    private CategoryInvariantHandler getOrCreateCategoryInvariantHandler( String category ) throws OclManagerException {

        synchronized ( this.categoryInvariantHandlerMapping ) {

            if ( this.categoryInvariantHandlerMapping.containsKey( category ) ) {
                return this.categoryInvariantHandlerMapping.get( category );
            }
            CategoryInvariantHandler handler = new CategoryInvariantHandler( category );
            this.categoryInvariantHandlerMapping.put( category, handler );
            return handler;
        }
    }

    /**
     * @param category category
     * @throws OclManagerException Exception
     */
    public void resetEvents( String category ) {

        Set<OclExpressionRegistrationImpl> expRegs = this.categoryExpressionRegistrationMapping.get( category );
        if ( expRegs != null ) {
            for ( OclExpressionRegistrationImpl expressionRegistration : expRegs ) {
                expressionRegistration.reset( );
            }
        }

        CategoryInvariantHandler handler = this.categoryInvariantHandlerMapping.get( category );
        if ( handler != null ) {
            handler.reset( );
        }

    }
}
