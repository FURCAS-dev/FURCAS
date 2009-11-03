package com.sap.tc.moin.repository.core.ocl.service.impl;

import static com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper.JMX_ENABLED;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.model.__impl.ConstraintInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.GeneralizableElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.ocl.evaluator.EvaluationContext;
import com.sap.tc.moin.ocl.evaluator.EvaluationContextImpl;
import com.sap.tc.moin.ocl.evaluator.ExpressionUndefinedException;
import com.sap.tc.moin.ocl.evaluator.expr.ExpressionEvaluator;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclBoolean;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclFactory;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclModelElement;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclVoid;
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
import com.sap.tc.moin.repository.core.CoreOclMofConstraintRegistry;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.checks.MoinAndMofConstraints;
import com.sap.tc.moin.repository.core.impl.WorkspaceSetImpl;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.PreCommitListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistration;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetaModelConstraintRegistration;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatusItem;
import com.sap.tc.moin.repository.ocl.notification.ImmediateConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.OclConstraintManagerException;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationCategory;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * The OclMofConstraintRegistry implementation
 */
public class OclMofConstraintRegistryImpl implements CoreOclMofConstraintRegistry {

    private final static MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE_OCL, OclMofConstraintRegistryImpl.class );

    private final Set<ImmediateConstraintViolationListener> registeredImmediateConstraintListeners = new HashSet<ImmediateConstraintViolationListener>( );

    private final Set<DeferredConstraintViolationListener> registeredListenersForDeferred = new HashSet<DeferredConstraintViolationListener>( );

    private final Set<DeferredConstraintViolationListener> registeredListenersForImmediate = new HashSet<DeferredConstraintViolationListener>( );

    // non-private due to inner class access
    final Set<ModelChangeEvent> collectedEventsForImmediate = new HashSet<ModelChangeEvent>( );

    // non-private due to inner class access
    final Set<ModelChangeEvent> collectedEventsForDeferred = new HashSet<ModelChangeEvent>( );

    private final ChangeListener immediateCollectListener = new ChangeListener( ) {

        public void notify( ChangeEvent event ) {

            if ( event instanceof ModelChangeEvent ) {
                OclMofConstraintRegistryImpl.this.collectedEventsForImmediate.add( (ModelChangeEvent) event );
            }
        }

    };

    private final ChangeListener deferredCollectListener = new ChangeListener( ) {

        public void notify( ChangeEvent event ) {

            if ( event instanceof ModelChangeEvent ) {
                OclMofConstraintRegistryImpl.this.collectedEventsForDeferred.add( (ModelChangeEvent) event );
            }
        }

    };

    private final PreCommitListener immediateDispatcherListener = new PreCommitListener( ) {

        public void prepareCommit( EventChain events ) {

            try {
                analyzeImmediateEvent( events );
            } catch ( OclManagerException e ) {
                // $JL-EXC$ TODO trace this (but this ist not functional anyway)
            }
        }

    };

    private final OclRegistryServiceImpl registryService;

    /**
     * The default constructor
     * 
     * @param actRegistryService service
     */
    public OclMofConstraintRegistryImpl( OclRegistryServiceImpl actRegistryService ) {

        this.registryService = actRegistryService;

        // lazy initialization
    }

    private OclMofConstraintWorkspaceSetRegistry getWsRegistry( CoreConnection connection ) throws OclManagerException {

        WorkspaceSetImpl wsi = (WorkspaceSetImpl) connection.getSession( ).getWorkspaceSet( );
        OclMofConstraintWorkspaceSetRegistry sreg = wsi.getOrCreateOclConstraintRegistry( connection );
        return sreg;
    }

    /**
     * Do the actual checks
     * 
     * @param partitionPris partitions
     * @return the result of the checks
     */
    public DeferredConstraintViolationStatus analyzeMetamodelPartitions( CoreConnection connection, Set<PRI> partitionPris, OclRegistrationCategory... category ) throws OclManagerException {

        if ( JMX_ENABLED && this.registryService.jmxNotificationsEnabled ) {
            String[] categories = new String[category.length];
            for ( int i = 0; i < category.length; i++ ) {
                categories[i] = category[i].toString( );
            }
            this.registryService.analyzeModelPartitionsStart( categories );
        }

        Map<RefObject, Set<RefObject>> classifierMap = this.getClassifiersFromPartition( connection, partitionPris );
        DeferredConstraintViolationStatusImpl violationInfo = new DeferredConstraintViolationStatusImpl( );
        Map<StructuralFeature, Set<RefBaseObject>> alreadyChecked = new HashMap<StructuralFeature, Set<RefBaseObject>>( );
        Map<OclStatement, OclMetaModelConstraintRegistration> stmtToInfoMapping = this.getWsRegistry( connection ).getStmtToInfoMapping( );

        long totalTime = 0l;
        long evaluatorTime = 0l;
        int numEvaluations = 0;

        long startTotal = System.nanoTime( );

        OclFactory fact = OclFactory.instance( );

        Set<EvaluationUnit> units = new HashSet<EvaluationUnit>( );

        for ( int i = 0; i < category.length; i++ ) {
            units.addAll( this.getWsRegistry( connection ).getCategoryImpactAnalyzerMap( ).get( category[i] ).filterForClasses( null ) );
        }

        for ( EvaluationUnit unit : units ) {

            OclMetaModelConstraintRegistration info = null;
            OclStatement statement = unit.getAffectedStatement( );
            Set<OclAny> instances = new HashSet<OclAny>( );
            try {
                // TODO let's ignore IA for the moment (refAllOfClass again)
                // for (InstanceSet set : unit.getInstanceSets()) {
                // RefObject context =
                // set.getNavigationStatement().getContext();
                // if (classifierMap.containsKey(context)) {
                // Set<RefObject> iaInstances = classifierMap.get(context);
                // instances.addAll(this.helper.evaluate(set.getNavigationStatement().getExpression(),
                // iaInstances));
                // }
                // }

                for ( Entry<RefObject, Set<RefObject>> entry : classifierMap.entrySet( ) ) {
                    RefObject classifier = entry.getKey( );
                    if ( classifier.equals( statement.getContext( ) ) ) {
                        for ( RefObject obj : entry.getValue( ) ) {
                            instances.add( fact.create( obj ) );
                        }
                    } else if ( classifier instanceof GeneralizableElementInternal ) {
                        GeneralizableElementInternal ge = (GeneralizableElementInternal) classifier;
                        if ( ge.allSupertypes( connection ).contains( statement.getContext( ) ) ) {
                            for ( RefObject obj : entry.getValue( ) ) {
                                instances.add( fact.create( obj ) );
                            }
                        }
                    }
                }

                if ( LOGGER.isTraced( MoinSeverity.DEBUG ) && instances.isEmpty( ) ) {
                    LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.NOINSTANCESFOUND, statement.getContext( ).refMofId( ) );
                }

                for ( OclAny oclAny : instances ) {
                    try {
                        long evalstart = System.nanoTime( );
                        numEvaluations++;
                        boolean result = this.evaluateInvariant( connection, statement, oclAny );
                        evaluatorTime = evaluatorTime + System.nanoTime( ) - evalstart;
                        if ( !result ) {
                            if ( info == null ) {
                                info = stmtToInfoMapping.get( statement );
                            }
                            violationInfo.addItem( connection, info, ( (Partitionable) oclAny.getWrappedObject( ) ).get___Mri( ) );
                        }
                    } catch ( OclManagerException e ) {
                        if ( info == null ) {
                            info = stmtToInfoMapping.get( statement );
                        }
                        if ( oclAny instanceof OclVoid ) {
                            violationInfo.addItem( connection, info, null, e );
                        } else {
                            violationInfo.addItem( connection, info, ( (Partitionable) oclAny.getWrappedObject( ) ).get___Mri( ), e );
                        }
                    } catch ( Exception e ) {
                        LOGGER.trace( e, MoinSeverity.WARNING, OclServiceTraces.EXCEPTIONEVALMMPARTITIONS, oclAny );
                    }

                    checkManualConstraints( connection, (RefObject) oclAny.getWrappedObject( ), violationInfo, alreadyChecked, category );

                }

            } catch ( RuntimeException e1 ) {
                LOGGER.trace( e1, MoinSeverity.WARNING, OclServiceTraces.RTEXGETINSTMOFCONSTRAINTCHECKS );
                continue;
            }

        }

        for ( Entry<RefObject, Set<RefObject>> classifierMapEntry : classifierMap.entrySet( ) ) {

            RefObject refclass = classifierMapEntry.getKey( );

            String classname;
            Set<OclAny> instances = new HashSet<OclAny>( );
            // The Equals implementation of RefStruct makes this necessary
            Map<OclAny, List<Partitionable>> partitionableMap = new HashMap<OclAny, List<Partitionable>>( );

            if ( refclass instanceof MofClass ) {
                classname = ( (MofClass) refclass ).getName( );
            } else {
                continue;
            }

            if ( OclConstants.T_PARAMETER.equals( classname ) ) {
                for ( RefObject obj : classifierMapEntry.getValue( ) ) {
                    OclAny instance = fact.create( ( (Parameter) obj ).getMultiplicity( ) );
                    instances.add( instance );
                    List<Partitionable> part = partitionableMap.get( instance );
                    if ( part == null ) {
                        part = new ArrayList<Partitionable>( );
                        partitionableMap.put( instance, part );
                    }
                    part.add( obj );
                }
            } else if ( OclConstants.T_ASSOCIATIONEND.equals( classname ) ) {
                for ( RefObject obj : classifierMap.get( refclass ) ) {
                    OclAny instance = fact.create( ( (AssociationEnd) obj ).getMultiplicity( ) );
                    instances.add( instance );
                    List<Partitionable> part = partitionableMap.get( instance );
                    if ( part == null ) {
                        part = new ArrayList<Partitionable>( );
                        partitionableMap.put( instance, part );
                    }
                    part.add( obj );
                }
            } else if ( OclConstants.T_STRUCTURALFEATURE.equals( classname ) ) {
                for ( RefObject obj : classifierMap.get( refclass ) ) {
                    OclAny instance = fact.create( ( (StructuralFeature) obj ).getMultiplicity( ) );
                    instances.add( instance );
                    List<Partitionable> part = partitionableMap.get( instance );
                    if ( part == null ) {
                        part = new ArrayList<Partitionable>( );
                        partitionableMap.put( instance, part );
                    }
                    part.add( obj );
                }
            } else {
                continue;
            }

            for ( OclStatement statement : this.getWsRegistry( connection ).getMultiplicityStatements( ) ) {

                OclMetaModelConstraintRegistration info = null;
                int index = 0;

                for ( OclAny oclAny : instances ) {
                    try {
                        long evalstart = System.nanoTime( );
                        numEvaluations++;
                        boolean result = this.evaluateInvariant( connection, statement, oclAny );
                        evaluatorTime = evaluatorTime + System.nanoTime( ) - evalstart;
                        if ( !result ) {
                            if ( info == null ) {
                                info = stmtToInfoMapping.get( statement );
                            }

                            List<Partitionable> ps = partitionableMap.get( oclAny );
                            for ( Partitionable p : ps ) {
                                violationInfo.addItem( connection, info, p.get___Mri( ) );
                            }
                        }
                    } catch ( OclManagerException e ) {
                        if ( info == null ) {
                            info = stmtToInfoMapping.get( statement );
                        }
                        if ( oclAny instanceof OclVoid ) {
                            violationInfo.addItem( connection, info, null, e );
                        } else {
                            List<Partitionable> ps = partitionableMap.get( oclAny );
                            for ( Partitionable p : ps ) {
                                violationInfo.addItem( connection, info, p.get___Mri( ), e );
                            }
                        }
                    } catch ( Exception e ) {
                        LOGGER.trace( e, MoinSeverity.WARNING, OclServiceTraces.UNEXPECTEDEXMULTIPCHECKS, oclAny );
                    }
                    index++;
                }

            }

        }

        if ( JMX_ENABLED && this.registryService.jmxNotificationsEnabled ) {
            totalTime = System.nanoTime( ) - startTotal;
            this.registryService.analyzeModelPartitionsEnd( partitionPris, totalTime / 1000000, evaluatorTime / 1000000, numEvaluations );
        }

        if ( violationInfo.hasItems( ) ) {
            if ( JMX_ENABLED && this.registryService.jmxNotificationsEnabled ) {
                this.registryService.constraintViolationsDetected( violationInfo );
            }
        }

        return violationInfo;
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

    private Map<RefObject, Set<RefObject>> getClassifiersFromPartition( CoreConnection connection, Set<PRI> partitionPris ) {

        Map<RefObject, Set<RefObject>> result = new HashMap<RefObject, Set<RefObject>>( );
        for ( PRI partitionPri : partitionPris ) {
            ModelPartition partition = connection.getPartition( partitionPri );
            for ( Partitionable partitionable : partition.getElements( ) ) {
                if ( partitionable instanceof RefObject ) {
                    RefObject instance = (RefObject) partitionable;
                    RefObject meta = instance.refMetaObject( );
                    Set<RefObject> instances = result.get( meta );
                    if ( instances == null ) {
                        instances = new HashSet<RefObject>( );
                        result.put( meta, instances );
                    }
                    instances.add( instance );
                }
            }
        }
        return result;
    }

    /**
     * Externally used for testing only
     * 
     * @param connection connection
     * @param category category
     * @return the event filter
     * @throws OclManagerException Exception
     */
    public EventFilter getEventFilter( CoreConnection connection, OclRegistrationCategory category ) throws OclManagerException {

        MoinJmiCreator jmiCreator = new JmiCreator( connection );
        return this.getWsRegistry( connection ).getCategoryImpactAnalyzerMap( ).get( category ).analyze( new HashSet<OclStatement>( ), jmiCreator );

    }

    /**
     * Used by the OclRegistryServiceImpl
     * 
     * @param connection connection
     * @param actObject object
     * @param categories filter, if empty, all constraints are checked
     * @return the status
     * @throws OclManagerException Exception
     */
    public DeferredConstraintViolationStatus verifyConstraints( CoreConnection connection, ModelElementInternal actObject, Set<OclRegistrationCategory> categories ) throws OclManagerException {

        Map<StructuralFeature, Set<RefBaseObject>> alreadyChecked = new HashMap<StructuralFeature, Set<RefBaseObject>>( );
        Map<OclStatement, OclMetaModelConstraintRegistration> stmtToInfoMapping = this.getWsRegistry( connection ).getStmtToInfoMapping( );

        Set<RefBaseObject> objectsToCheck = new HashSet<RefBaseObject>( );
        objectsToCheck.add( actObject );

        boolean violationDetected = false;

        Set<List<String>> metamodelConstraintsToCheck = new HashSet<List<String>>( );

        ModelElement metaObject = (ModelElement) actObject.refMetaObject( );

        JmiList<Constraint> constraints = (JmiList<Constraint>) ( (ModelElementInternal) metaObject ).getConstraints( connection );
        for ( Iterator<Constraint> it = constraints.iterator( connection ); it.hasNext( ); ) {
            Constraint obj = it.next( );
            List<String> qname = ( (ConstraintInternal) obj ).getQualifiedName( connection );
            if ( OclConstants.L_OCL.equals( obj.getLanguage( ) ) && ( OclConstants.P_MODEL.equals( qname.get( 0 ) ) || OclConstants.P_OCL.equals( qname.get( 0 ) ) ) ) {
                metamodelConstraintsToCheck.add( qname );
            }
        }

        if ( metaObject instanceof GeneralizableElement ) {
            List<GeneralizableElement> supertypes = ( (GeneralizableElementInternal) metaObject ).allSupertypes( connection );
            for ( GeneralizableElement supertype : supertypes ) {
                JmiList<Constraint> supertypeConstraints = (JmiList<Constraint>) ( (ModelElementInternal) supertype ).getConstraints( connection );
                for ( Iterator<Constraint> it = supertypeConstraints.iterator( connection ); it.hasNext( ); ) {
                    Constraint obj = it.next( );
                    List<String> qname = ( (ConstraintInternal) obj ).getQualifiedName( connection );
                    if ( OclConstants.L_OCL.equals( obj.getLanguage( ) ) && ( OclConstants.P_MODEL.equals( qname.get( 0 ) ) || OclConstants.P_OCL.equals( qname.get( 0 ) ) ) ) {
                        metamodelConstraintsToCheck.add( qname );
                    }

                }
            }
        }

        DeferredConstraintViolationStatusImpl status = new DeferredConstraintViolationStatusImpl( );

        Map<List<String>, Map<List<String>, OclStatement>> qnameToStmtMapping = this.getWsRegistry( connection ).getQnameToStmtMapping( );

        for ( List<String> name : metamodelConstraintsToCheck ) {
            Map<List<String>, OclStatement> ctxStmtMap = qnameToStmtMapping.get( name );

            OclStatement c = ctxStmtMap.get( ( (ModelElementInternal) metaObject ).getQualifiedName( connection ) );

            if ( c == null && metaObject instanceof GeneralizableElement ) {
                List<GeneralizableElement> supertypes = ( (GeneralizableElementInternal) metaObject ).allSupertypes( connection );
                for ( GeneralizableElement supertype : supertypes ) {
                    c = ctxStmtMap.get( ( (ModelElementInternal) supertype ).getQualifiedName( connection ) );
                    if ( c != null ) {
                        break;
                    }
                }
            }

            if ( c == null ) {
                OclManagerException e = new OclManagerException( OclServiceExceptions.CONSTRAINTNOTFOUNDINREGISTRY, name.toString( ) );
                // TODO replace with e:
                LOGGER.trace( e, MoinSeverity.ERROR );
                throw new MoinLocalizedBaseRuntimeException( e );
            }

            if ( !categories.isEmpty( ) ) {
                Set<String> constraintCategories = stmtToInfoMapping.get( c ).getCategories( );

                boolean evaluate = false;
                for ( OclRegistrationCategory category : categories ) {
                    if ( constraintCategories.contains( category.name( ) ) ) {
                        evaluate = true;
                        break;
                    }
                }
                if ( !evaluate ) {
                    continue;
                }
            }

            try {
                OclAny context = OclFactory.instance( ).create( actObject );

                EvaluationContext ctxt = new EvaluationContextImpl( context );
                if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                    LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.VERIFYINGMMC, name, actObject.getQualifiedName( connection ).toString( ) );

                }
                OclAny oclResult = ExpressionEvaluator.instance( ).evaluate( connection, c.getExpression( ), ctxt );
                if ( oclResult instanceof OclBoolean ) {
                    boolean errorFound = !( (OclBoolean) oclResult ).getWrappedBoolean( ).booleanValue( );
                    if ( errorFound ) {
                        OclMetaModelConstraintRegistration reg = stmtToInfoMapping.get( c );
                        MRI mri = ( (Partitionable) actObject ).get___Mri( );
                        status.addItem( connection, reg, mri );
                    }
                    violationDetected = violationDetected || errorFound;
                } else {
                    OclMetaModelConstraintRegistration reg = stmtToInfoMapping.get( c );
                    MRI mri = ( (Partitionable) actObject ).get___Mri( );
                    status.addItem( connection, reg, mri, new OclManagerException( OclServiceExceptions.INVMUSTEVALTOBOOLEAN ) );
                }

            } finally {
                EvaluationContext.CurrentContext.reset( );
            }
        }

        Set<OclRegistrationCategory> moinAndMofCats = new HashSet<OclRegistrationCategory>( );
        if ( categories.isEmpty( ) || categories.contains( OclRegistrationCategory.immediate.name( ) ) ) {
            moinAndMofCats.add( OclRegistrationCategory.immediate );
        }
        if ( categories.isEmpty( ) || categories.contains( OclRegistrationCategory.deferred.name( ) ) ) {
            moinAndMofCats.add( OclRegistrationCategory.deferred );
        }
        if ( moinAndMofCats.size( ) > 0 ) {

            checkManualConstraints( connection, actObject, status, alreadyChecked, moinAndMofCats.toArray( new OclRegistrationCategory[moinAndMofCats.size( )] ) );
        }

        if ( status.hasItems( ) ) {
            if ( JMX_ENABLED && this.registryService.jmxNotificationsEnabled ) {
                this.registryService.constraintViolationsDetected( status );
            }
        }

        return status;
    }

    private void checkManualConstraints( CoreConnection connection, RefBaseObject objectToCheck, DeferredConstraintViolationStatusImpl status, Map<StructuralFeature, Set<RefBaseObject>> alreadyChecked, OclRegistrationCategory... categories ) {

        MoinAndMofConstraints checker = new MoinAndMofConstraints( connection );
        List<DeferredConstraintViolationStatusItem> exceptions = checker.checkManualConstraints( objectToCheck, alreadyChecked, categories );
        for ( DeferredConstraintViolationStatusItem exception : exceptions ) {
            status.addItem( exception );
        }

    }

    public void analyzeCollectedEvents( CoreConnection connection, OclRegistrationCategory... category ) throws OclManagerException {

        long timestamp = 0;
        if ( JMX_ENABLED && this.registryService.jmxNotificationsEnabled ) {
            String[] categories = new String[category.length];
            for ( int i = 0; i < category.length; i++ ) {
                categories[i] = category[i].toString( );
            }
            this.registryService.analyzeCollectedEventsStart( categories );
            timestamp = System.nanoTime( );
        }

        // TODO this will not take MultiplicityType into account
        Map<StructuralFeature, Set<RefBaseObject>> alreadyChecked = new HashMap<StructuralFeature, Set<RefBaseObject>>( );
        DeferredConstraintViolationStatusImpl statusDeferred = new DeferredConstraintViolationStatusImpl( );
        DeferredConstraintViolationStatusImpl statusImmediate = new DeferredConstraintViolationStatusImpl( );
        Map<OclStatement, OclMetaModelConstraintRegistration> stmtToInfoMapping = this.getWsRegistry( connection ).getStmtToInfoMapping( );

        EvaluationHelper helper = new EvaluationHelper( );

        boolean checkImmediate = false;
        boolean checkDeferred = false;

        for ( int i = 0; i < category.length; i++ ) {
            switch ( category[i] ) {
                case immediate:
                    checkImmediate = true;
                    break;
                case deferred:
                    checkDeferred = true;
                    break;
                default:
                    break;
            }
        }

        if ( !checkImmediate && !checkDeferred ) {
            throw new OclManagerException( OclServiceExceptions.NOVALIDCATEGORY );
        }

        Set<EvaluationUnit> units = new HashSet<EvaluationUnit>( );
        if ( checkImmediate ) {
            units.addAll( this.getWsRegistry( connection ).getCategoryImpactAnalyzerMap( ).get( OclRegistrationCategory.immediate ).filter( connection, this.collectedEventsForImmediate ) );
        }
        if ( checkDeferred ) {
            units.addAll( this.getWsRegistry( connection ).getCategoryImpactAnalyzerMap( ).get( OclRegistrationCategory.deferred ).filter( connection, this.collectedEventsForDeferred ) );
        }

        for ( EvaluationUnit unit : units ) {
            OclRegistration info = stmtToInfoMapping.get( unit.getAffectedStatement( ) );
            boolean immediate = info.getCategories( ).contains( OclRegistrationCategory.immediate.toString( ) );
            DeferredConstraintViolationStatusImpl status;
            if ( immediate ) {
                status = statusImmediate;
            } else {
                status = statusDeferred;
            }

            OclStatement statement = unit.getAffectedStatement( );
            Set<OclAny> instances = helper.getAffectedInstances( connection, unit );

            for ( OclAny oclAny : instances ) {
                try {
                    OclModelElement ome = (OclModelElement) oclAny;
                    if ( !ome.getWrappedRefObject( ).refMetaObject( ).equals( statement.getContext( ) ) ) {
                        continue;
                    }
                    EvaluationContext ctxt = new EvaluationContextImpl( oclAny );
                    OclAny oclResult = ExpressionEvaluator.instance( ).evaluate( connection, statement.getExpression( ), ctxt );
                    if ( oclResult instanceof OclBoolean ) {
                        if ( !( (OclBoolean) oclResult ).getWrappedBoolean( ).booleanValue( ) ) {
                            MRI mri = ( (Partitionable) oclAny.getWrappedObject( ) ).get___Mri( );
                            status.addItem( connection, info, mri );
                        }
                    } else {
                        MRI mri = ( (Partitionable) oclAny.getWrappedObject( ) ).get___Mri( );
                        status.addItem( connection, info, mri, new OclManagerException( OclServiceExceptions.INVMUSTEVALTOBOOLEAN ) );
                    }
                } finally {
                    EvaluationContext.CurrentContext.reset( );
                }

                Object obj = oclAny.getWrappedObject( );
                if ( obj instanceof RefObject ) {
                    checkManualConstraints( connection, (RefObject) obj, status, alreadyChecked, category );
                }

            }
        }
        if ( statusImmediate.hasItems( ) ) {
            if ( JMX_ENABLED && this.registryService.jmxNotificationsEnabled ) {
                this.registryService.constraintViolationsDetected( statusImmediate );
            }
            for ( DeferredConstraintViolationListener listener : this.registeredListenersForImmediate ) {
                listener.notify( statusImmediate );
            }
        }
        if ( statusDeferred.hasItems( ) ) {
            if ( JMX_ENABLED && this.registryService.jmxNotificationsEnabled ) {
                this.registryService.constraintViolationsDetected( statusDeferred );
            }
            for ( DeferredConstraintViolationListener listener : this.registeredListenersForDeferred ) {
                listener.notify( statusDeferred );
            }
        }

        if ( JMX_ENABLED && this.registryService.jmxNotificationsEnabled ) {
            long duration = ( System.nanoTime( ) - timestamp ) / 1000000;
            this.registryService.analyzeCollectedEventsEnd( duration, true /* evaluationPerformed */);
        }
    }

    /**
     * @param evt
     */
    protected void analyzeImmediateEvent( EventChain events ) throws OclManagerException {

        EventBasedConstraintViolationStatusImpl status = new EventBasedConstraintViolationStatusImpl( );

        for ( ChangeEvent event : events.getEvents( ) ) {

            if ( !( event instanceof ModelChangeEvent ) ) {
                continue;
            }

            CoreConnection connection;
            Connection conn = event.getEventTriggerConnection( );
            if ( conn instanceof CoreConnection ) {
                connection = (CoreConnection) event.getEventTriggerConnection( );
            } else {
                connection = (CoreConnection) ( (Wrapper<?>) conn ).unwrap( );
            }

            EvaluationHelper helper = new EvaluationHelper( );
            ModelChangeEvent evt = (ModelChangeEvent) event;

            Set<EvaluationUnit> units = this.getWsRegistry( connection ).getCategoryImpactAnalyzerMap( ).get( OclRegistrationCategory.immediate ).filter( connection, evt );

            for ( EvaluationUnit unit : units ) {

                OclRegistration info = this.getWsRegistry( connection ).getStmtToInfoMapping( ).get( unit.getAffectedStatement( ) );

                OclStatement statement = unit.getAffectedStatement( );
                Set<OclAny> instances = helper.getAffectedInstances( connection, unit );

                for ( OclAny oclAny : instances ) {
                    try {
                        EvaluationContext ctxt = new EvaluationContextImpl( oclAny );
                        OclAny oclResult = ExpressionEvaluator.instance( ).evaluate( connection, statement.getExpression( ), ctxt );
                        if ( oclResult instanceof OclBoolean ) {
                            if ( !( (OclBoolean) oclResult ).getWrappedBoolean( ).booleanValue( ) ) {
                                MRI mri = ( (Partitionable) oclAny.getWrappedObject( ) ).get___Mri( );
                                status.addItem( info, evt, mri );
                            }
                        } else {
                            MRI mri = ( (Partitionable) oclAny.getWrappedObject( ) ).get___Mri( );
                            status.addItem( info, evt, mri, new OclManagerException( OclServiceExceptions.INVMUSTEVALTOBOOLEAN ) );
                        }
                    } finally {
                        EvaluationContext.CurrentContext.reset( );
                    }

                    Object obj = oclAny.getWrappedObject( );
                    if ( obj instanceof RefObject ) {

                        DeferredConstraintViolationStatusImpl manualStatus = new DeferredConstraintViolationStatusImpl( );

                        checkManualConstraints( connection, (RefObject) obj, manualStatus, new HashMap<StructuralFeature, Set<RefBaseObject>>( ), OclRegistrationCategory.immediate );

                        for ( DeferredConstraintViolationStatusItem item : manualStatus.getAll( ) ) {
                            status.addItem( item.getConstraintRegistration( ), evt, item.getOffendingMRI( ) );
                        }
                    }

                }
            }
        }

        if ( status.hasItems( ) ) {
            if ( JMX_ENABLED && this.registryService.jmxNotificationsEnabled ) {
                this.registryService.constraintViolationsDetected( status );
            }
            for ( ImmediateConstraintViolationListener listener : this.registeredImmediateConstraintListeners ) {
                listener.notify( status );
            }
        }
    }

    public Set<OclMetaModelConstraintRegistration> getAvailableMofConstraints( CoreConnection connection ) throws OclConstraintManagerException {

        Set<OclMetaModelConstraintRegistration> result = new HashSet<OclMetaModelConstraintRegistration>( );
        try {
            result.addAll( this.getWsRegistry( connection ).getStmtToInfoMapping( ).values( ) );
        } catch ( OclManagerException e ) {
            throw new OclConstraintManagerException( e );
        }
        return result;
    }

    public boolean registerDeferredConstraintViolationListenerForEvents( CoreConnection connection, DeferredConstraintViolationListener listener, OclRegistrationCategory... category ) throws OclManagerException {

        boolean registered = false;
        for ( int i = 0; i < category.length; i++ ) {
            switch ( category[i] ) {
                case deferred:
                    if ( this.registeredListenersForDeferred.isEmpty( ) ) {
                        connection.getSession( ).getEventRegistry( ).registerListener( this.deferredCollectListener, this.getEventFilter( connection, OclRegistrationCategory.deferred ) );
                    }
                    registered = registered | this.registeredListenersForDeferred.add( listener );
                    break;
                case immediate:
                    if ( this.registeredListenersForImmediate.isEmpty( ) ) {
                        connection.getSession( ).getEventRegistry( ).registerListener( this.immediateCollectListener, this.getEventFilter( connection, OclRegistrationCategory.immediate ) );
                    }
                    registered = registered | this.registeredListenersForImmediate.add( listener );
                    break;
                default:
                    return false;
            }
        }
        return registered;
    }

    public boolean registerImmediateConstraintViolationListener( CoreConnection connection, ImmediateConstraintViolationListener listener ) throws OclManagerException {

        boolean registered = false;
        if ( this.registeredImmediateConstraintListeners.isEmpty( ) ) {
            connection.getSession( ).getEventRegistry( ).registerPreCommitListener( this.immediateDispatcherListener, getEventFilter( connection, OclRegistrationCategory.immediate ) );
        }
        registered = this.registeredImmediateConstraintListeners.add( listener );
        return registered;
    }

    public void resetEvents( CoreConnection connection, OclRegistrationCategory... category ) throws OclManagerException {

        boolean immediate = false;
        boolean deferred = false;
        for ( int i = 0; i < category.length; i++ ) {
            switch ( category[i] ) {
                case immediate:
                    this.collectedEventsForImmediate.clear( );
                    immediate = true;
                    break;
                case deferred:
                    this.collectedEventsForDeferred.clear( );
                    deferred = true;
                    break;
                default:
                    break;
            }
        }
        this.registryService.eventsReset( immediate ? "immediate" : null, deferred ? "deferred" : null ); //$NON-NLS-1$ //$NON-NLS-2$
    }

    public boolean unregisterDeferredConstraintViolationListener( CoreConnection connection, DeferredConstraintViolationListener listener ) {

        boolean removed = this.registeredListenersForDeferred.remove( listener );
        if ( this.registeredListenersForDeferred.isEmpty( ) ) {
            connection.getSession( ).getEventRegistry( ).deregister( this.deferredCollectListener );
            this.collectedEventsForDeferred.clear( );
        }
        removed = removed || this.registeredListenersForImmediate.remove( listener );
        if ( this.registeredListenersForImmediate.isEmpty( ) ) {
            connection.getSession( ).getEventRegistry( ).deregister( this.immediateCollectListener );
            this.collectedEventsForImmediate.clear( );
        }
        return removed;
    }

    public boolean unregisterImmediateConstraintViolationListener( CoreConnection connection, ImmediateConstraintViolationListener listener ) {

        boolean removed = this.registeredImmediateConstraintListeners.remove( listener );
        if ( this.registeredImmediateConstraintListeners.isEmpty( ) ) {
            connection.getSession( ).getEventRegistry( ).deregister( this.immediateDispatcherListener );
        }
        return removed;
    }


    public DeferredConstraintViolationStatus verifyConstraints( CoreConnection connection, Set<PRI> pris, Set<OclRegistrationCategory> categories ) throws OclManagerException {

        long start = System.nanoTime( );
        DeferredConstraintViolationStatusImpl status = new DeferredConstraintViolationStatusImpl( );

        try {
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( MoinSeverity.DEBUG, OclServiceTraces.STARTREGSRVVERIFYCONSTRAINTS, Integer.valueOf( pris.size( ) ), Integer.valueOf( categories.size( ) ) );
            }


            for ( PRI pri : pris ) {
                // we only look at meta model partitions (model partitions are dealt with by the OclMetaModelConstraintRegistry)
                for ( Partitionable e : connection.getPartition( pri ).getElements( ) ) {
                    if ( e instanceof ModelElement ) {
                        DeferredConstraintViolationStatus stat = verifyConstraints( connection, (ModelElementInternal) e, categories );
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
