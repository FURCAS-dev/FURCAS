package com.sap.tc.moin.repository.core.ocl.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.omg.ocl.expressions.OclExpression;

import com.sap.tc.moin.ocl.evaluator.EvaluationContext;
import com.sap.tc.moin.ocl.evaluator.EvaluationContextImpl;
import com.sap.tc.moin.ocl.evaluator.StackedEvaluator;
import com.sap.tc.moin.ocl.evaluator.expr.ExpressionEvaluator;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclCollection;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclFactory;
import com.sap.tc.moin.ocl.evaluator.stdlib.impl.OclVoidImpl;
import com.sap.tc.moin.ocl.ia.ImpactAnalyzer;
import com.sap.tc.moin.ocl.ia.Statistics;
import com.sap.tc.moin.ocl.ia.result.EvaluationUnit;
import com.sap.tc.moin.ocl.parser.IOclParser;
import com.sap.tc.moin.ocl.parser.OclParserFactory;
import com.sap.tc.moin.ocl.utils.OclStatement;
import com.sap.tc.moin.ocl.utils.localization.OclServiceExceptions;
import com.sap.tc.moin.ocl.utils.localization.OclServiceTraces;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.events.VetoException;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.ocl.debugger.OclDebuggerNode;
import com.sap.tc.moin.repository.ocl.exceptions.InvalidValueException;
import com.sap.tc.moin.repository.ocl.exceptions.ParsingException;
import com.sap.tc.moin.repository.ocl.freestyle.ExpressionInvalidationListener;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistrationType;
import com.sap.tc.moin.repository.ocl.notification.OclConstraintManagerException;
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
public class OclExpressionRegistrationImpl extends OclRegistrationImpl implements OclExpressionRegistration, ChangeListener {

    private final static MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE_OCL, OclExpressionRegistrationImpl.class );

    private final Map<String, Map<ExpressionInvalidationListener, Set<MRI>>> myCategoryListeners = new HashMap<String, Map<ExpressionInvalidationListener, Set<MRI>>>( );

    private final Map<ExpressionInvalidationListener, Set<MRI>> myImmediateEventListeners = new HashMap<ExpressionInvalidationListener, Set<MRI>>( );

    private final Map<ExpressionInvalidationListener, Set<MRI>> myDeferredEventListeners = new HashMap<ExpressionInvalidationListener, Set<MRI>>( );

    private final Map<MRI, ValueInvalidationTuple> expressionValues = new HashMap<MRI, ValueInvalidationTuple>( );

    private boolean registeredInEventFramework = false;

    private EventFilter myEventFilter;

    private ImpactAnalyzer analyzer;

    private final EvaluationHelper evalHelper;

    final Set<ModelChangeEvent> collectedEvents = new HashSet<ModelChangeEvent>( );

    private static final class ValueInvalidationTuple {

        private Object value;

        private Object newValue;

        private boolean isValid = true;

        ValueInvalidationTuple( Object theValue ) {

            this.value = theValue;
        }

        boolean isValid( ) {

            return this.isValid;
        }

        void setNewValue( Object theNewValue ) {

            this.newValue = theNewValue;
            if ( ( this.newValue != null && !this.newValue.equals( this.value ) ) || ( this.value != null && !this.value.equals( this.newValue ) ) ) {
                this.isValid = false;
            }
        }

        void refresh( ) {

            if ( !this.isValid( ) ) {
                this.value = this.newValue;
                this.isValid = true;
            }
        }

        Object getValue( ) {

            return this.value;
        }
    }

    /**
     * @param connection Connection
     * @param name Name
     * @param oclExpression Expression
     * @param severity Severity
     * @param categories categories
     * @param context context
     * @param typesPackages typesPackages
     * @throws OclManagerException Exception
     */
    public OclExpressionRegistrationImpl( CoreConnection connection, String name, String oclExpression, OclRegistrationSeverity severity, String[] categories, RefObject context, RefPackage[] typesPackages ) throws OclManagerException {

        super( connection, name, OclRegistrationType.Expression, severity, categories, oclExpression, context, "ExpressionRegistration" ); //$NON-NLS-1$
        this.evalHelper = new EvaluationHelper( );
        IOclParser parser = OclParserFactory.create( this.myJmiCreator );
        try {
            Set<OclStatement> parserResult = parser.parseString( this.getOclExpression( ), this.parsingConext, typesPackages );
            if ( parserResult.size( ) != 1 ) {
                throw new OclManagerException( OclServiceExceptions.MUSTPARSETOONE, name, parserResult.size( ), this.getOclExpression( ) );
            }
            for ( OclStatement theStmt : parserResult ) {
                if ( theStmt.getKind( ) != OclStatement.EXPRESSION ) {
                    throw new OclManagerException( OclServiceExceptions.OCLEXPRDOESNOTEVALUATETOEXPR );
                }
                this.statement = theStmt;
            }
        } catch ( ParsingException e ) {
            throw new OclConstraintManagerException( (Throwable) e, OclServiceExceptions.EXPRESSIONNOTPARSABLE, this.getOclExpression( ) );
        }
    }

    public Object evaluateExpression( RefObject context ) throws OclManagerException {

        return this.evaluateExpression( context, false );
    }

    public Object evaluateExpression( MRI contextMri ) throws OclManagerException {

        return this.evaluateExpression( (RefObject) this.myConnection.getElement( contextMri ), false );
    }

    public OclDebuggerNode debugExpression( RefObject context ) {

        try {

            OclAny oclContext;
            if ( context != null ) {
                oclContext = OclFactory.instance( ).create( context );
            } else {
                oclContext = OclVoidImpl.OCL_UNDEFINED;
            }


            OclExpression expression = this.statement.getExpression( );

            EvaluationContext evalCtx = new EvaluationContextImpl( oclContext );

            return new StackedEvaluator( ).debug( this.myConnection, expression, evalCtx );

        } finally {
            // Reset the current context so that the current thread can create
            // a new one later if required.
            EvaluationContext.CurrentContext.reset( );
        }

    }

    public OclDebuggerNode debugExpression( MRI contextMri ) {

        try {

            OclAny oclContext;
            RefBaseObject context = this.myConnection.getElement( contextMri );
            if ( context != null ) {
                oclContext = OclFactory.instance( ).create( context );
            } else {
                oclContext = OclVoidImpl.OCL_UNDEFINED;
            }


            OclExpression expression = this.statement.getExpression( );

            EvaluationContext evalCtx = new EvaluationContextImpl( oclContext );

            return new StackedEvaluator( ).debug( this.myConnection, expression, evalCtx );

        } finally {
            // Reset the current context so that the current thread can create
            // a new one later if required.
            EvaluationContext.CurrentContext.reset( );
        }

    }

    private Object evaluateExpression( RefObject context, boolean forceEvaluation ) throws OclManagerException {

        MRI mri = null;
        if ( context != null ) {
            mri = context.get___Mri( );
        }
        boolean reevaluate = forceEvaluation || !this.expressionValues.containsKey( mri );
        if ( !reevaluate ) {
            ValueInvalidationTuple tuple = this.expressionValues.get( mri );
            if ( tuple.isValid( ) ) {
                return tuple.getValue( );
            }
        }

        try {
            OclAny oclContext;
            if ( context != null ) {
                oclContext = OclFactory.instance( ).create( context );
            } else {
                oclContext = OclVoidImpl.OCL_UNDEFINED;
            }
            EvaluationContext ctxt = new EvaluationContextImpl( oclContext );
            OclAny oclResult = ExpressionEvaluator.instance( ).evaluate( this.myConnection, this.statement.getExpression( ), ctxt );
            if ( oclResult instanceof OclCollection ) {
                OclCollection coll = (OclCollection) oclResult;
                return coll.getUnwrappingCollection( false );
            }
            Object result = null;
            try {
                result = oclResult.getWrappedObject( );

            } catch ( InvalidValueException e ) {
                throw new OclManagerException( OclServiceExceptions.INVALIDVALUEEXCEPTION );
            }
            if ( this.expressionValues.containsKey( mri ) ) {
                ValueInvalidationTuple tuple = this.expressionValues.get( mri );
                tuple.setNewValue( result );
            }
            return result;
        } catch ( RuntimeException re ) {
            throw new OclManagerException( re, OclServiceExceptions.OCLEVALRTEX, re.getMessage( ) );
        } finally {
            EvaluationContext.CurrentContext.reset( );
        }

    }

    public boolean registerPartitionBasedInvalidationListener( String category, ExpressionInvalidationListener listener ) {

        return this.registerPartitionBasedInvalidationListener( category, listener, new HashSet<MRI>( ) );
    }

    public synchronized boolean registerPartitionBasedInvalidationListener( String category, ExpressionInvalidationListener listener, Collection<MRI> objectFilter ) {

        // TODO check with valueOf?
        if ( category.equals( OclRegistrationCategory.immediate.name( ) ) ) {
            throw new MoinIllegalArgumentException( OclServiceExceptions.USEREGISTEREVENTBASEDMETHOD );
        }

        if ( !this.getCategories( ).contains( category ) ) {
            if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                LOGGER.trace( MoinSeverity.INFO, OclServiceTraces.REGISTERFORNONEXISTINGCATEGORY, category );
            }
            return false;
        }

        Map<ExpressionInvalidationListener, Set<MRI>> listeners = this.myCategoryListeners.get( category );
        if ( listeners == null ) {
            listeners = new HashMap<ExpressionInvalidationListener, Set<MRI>>( );
            this.myCategoryListeners.put( category, listeners );
        }
        // simply overwrite the old listener, if it was the same
        Set<MRI> filter = new HashSet<MRI>( );
        filter.addAll( objectFilter );
        listeners.put( listener, filter );
        return true;

    }

    void triggerDeferredOclEvaluation( String category, Set<ModelPartition> partitions ) throws OclManagerException {

        Map<ExpressionInvalidationListener, Set<MRI>> categoryListeners = this.myCategoryListeners.get( category );

        if ( categoryListeners == null || categoryListeners.isEmpty( ) ) {
            return;
        }

        Set<RefObject> checkObjects = new HashSet<RefObject>( );
        Set<EvaluationUnit> units = this.getImpactAnalyzer( ).filterForClasses( this.getClassifiersFromPartition( partitions ) );

        for ( EvaluationUnit unit : units ) {
            Set<OclAny> instances = this.evalHelper.getAffectedInstances( this.myConnection, unit );
            for ( OclAny resultObject : instances ) {
                if ( resultObject.getWrappedObject( ) instanceof RefObject ) {
                    checkObjects.add( (RefObject) resultObject.getWrappedObject( ) );
                }
            }
        }

        Set<MRI> invalidObjects = new HashSet<MRI>( );
        for ( RefObject checkObject : checkObjects ) {
            if ( this.expressionValues.containsKey( checkObject.get___Mri( ) ) ) {
                ValueInvalidationTuple tuple = this.expressionValues.get( checkObject.get___Mri( ) );
                tuple.setNewValue( this.evaluateExpression( checkObject, true ) );
                if ( !tuple.isValid( ) ) {
                    tuple.refresh( );
                    invalidObjects.add( checkObject.get___Mri( ) );
                }
            } else {
                ValueInvalidationTuple tuple = new ValueInvalidationTuple( this.evaluateExpression( checkObject, true ) );
                this.expressionValues.put( checkObject.get___Mri( ), tuple );
                invalidObjects.add( checkObject.get___Mri( ) );
            }
        }

        if ( invalidObjects.isEmpty( ) ) {
            return;
        }

        VetoException vetoException = null;

        for ( Map.Entry<ExpressionInvalidationListener, Set<MRI>> listenerEntry : categoryListeners.entrySet( ) ) {

            ExpressionInvalidationListener listener = listenerEntry.getKey( );
            Set<MRI> filter = listenerEntry.getValue( );
            if ( filter.isEmpty( ) ) {
                try {
                    listener.notify( invalidObjects, this , this.myConnection );
                } catch ( VetoException e ) {
                    vetoException = e;
                }
            } else {
                Set<MRI> mEsToReevaluate = new HashSet<MRI>( );
                for ( MRI filterEntry : filter ) {
                    if ( invalidObjects.contains( filterEntry ) ) {
                        mEsToReevaluate.add( filterEntry );
                    }
                }
                if ( !mEsToReevaluate.isEmpty( ) ) {
                    try {
                        listener.notify( mEsToReevaluate, this , this.myConnection );
                    } catch ( VetoException e ) {
                        vetoException = e;
                    }
                }
            }

        }

        // reset the invalidation information
        for ( MRI invalidMe : invalidObjects ) {
            ValueInvalidationTuple tuple = this.expressionValues.get( invalidMe );
            if ( tuple != null ) {
                tuple.refresh( );
            }
        }

        if ( vetoException != null ) {
            throw vetoException;
        }

    }

    private Map<Boolean, Map<ExpressionInvalidationListener, Set<MRI>>> getEventListeners( ) {

        Map<Boolean, Map<ExpressionInvalidationListener, Set<MRI>>> eventListeners = new HashMap<Boolean, Map<ExpressionInvalidationListener, Set<MRI>>>( );

        if ( !this.myImmediateEventListeners.isEmpty( ) ) {
            eventListeners.put( Boolean.TRUE, this.myImmediateEventListeners );
        }
        if ( !this.myDeferredEventListeners.isEmpty( ) ) {
            eventListeners.put( Boolean.FALSE, this.myDeferredEventListeners );
        }
        return eventListeners;
    }

    public synchronized boolean unregisterInvalidationListener( ExpressionInvalidationListener listener ) {

        boolean unregistered = false;
        Collection<Map<ExpressionInvalidationListener, Set<MRI>>> maps = this.myCategoryListeners.values( );
        for ( Map<ExpressionInvalidationListener, Set<MRI>> map : maps ) {
            unregistered = ( map.remove( listener ) != null ) || unregistered;
        }

        unregistered = ( this.myImmediateEventListeners.remove( listener ) != null ) || unregistered;
        unregistered = ( this.myDeferredEventListeners.remove( listener ) != null ) || unregistered;

        if ( this.registeredInEventFramework && this.getEventListeners( ).isEmpty( ) ) {
            this.myConnection.getSession( ).getEventRegistry( ).deregister( this );
            this.registeredInEventFramework = false;
        }
        return unregistered;
    }

    @Override
    public synchronized void close( ) {

        super.close( );
        this.collectedEvents.clear( );
        this.myCategoryListeners.clear( );
        if ( this.registeredInEventFramework ) {
            this.myConnection.getSession( ).getEventRegistry( ).deregister( this );
            this.registeredInEventFramework = false;
        }
        this.expressionValues.clear( );
        this.myImmediateEventListeners.clear( );
        this.myDeferredEventListeners.clear( );
        // TODO cleanup in the transient partition? In the super class?
    }

    void reset( ) {

        this.collectedEvents.clear( );
    }

    public void notify( ChangeEvent event ) {

        if ( !( event instanceof ModelChangeEvent ) ) {
            return;
        }

        Map<Boolean, Map<ExpressionInvalidationListener, Set<MRI>>> eventListeners = getEventListeners( );
        if ( eventListeners.isEmpty( ) ) {
            return;
        }

        boolean collectEvents = false;
        boolean evaluateEvents = false;

        for ( Boolean immediate : eventListeners.keySet( ) ) {
            if ( !collectEvents && !immediate.booleanValue( ) ) {
                // at least one not immediate tuple
                collectEvents = true;
            }
            if ( !evaluateEvents && immediate.booleanValue( ) ) {
                // at least one immediate tuple
                evaluateEvents = true;
            }
        }

        ModelChangeEvent mce = (ModelChangeEvent) event;
        if ( collectEvents ) {
            this.collectedEvents.add( mce );
        }
        if ( !evaluateEvents ) {
            return;
        }

        Set<MRI> affectedModelElements = getAffectedModelElements(mce, this.myConnection);

        if ( affectedModelElements.isEmpty( ) ) {
            return;
        }

        VetoException vetoException = null;

        for ( Map.Entry<Boolean, Map<ExpressionInvalidationListener, Set<MRI>>> entry : eventListeners.entrySet( ) ) {
            Boolean immediate = entry.getKey( );
            if ( !immediate.booleanValue( ) ) {
                // not immediate
                continue;
            }
            Map<ExpressionInvalidationListener, Set<MRI>> listeners = entry.getValue( );

            for ( Map.Entry<ExpressionInvalidationListener, Set<MRI>> listenerEntry : listeners.entrySet( ) ) {

                ExpressionInvalidationListener listener = listenerEntry.getKey( );
                Set<MRI> filter = listenerEntry.getValue( );
                if ( filter.isEmpty( ) ) {
                    try {
                        listener.notify( affectedModelElements, this , event.getEventTriggerConnection());
                    } catch ( VetoException e ) {
                        vetoException = e;
                    }
                } else {
                    Set<MRI> mEsToReevaluate = new HashSet<MRI>( );
                    for ( MRI filterEntry : filter ) {
                        if ( affectedModelElements.contains( filterEntry ) ) {
                            mEsToReevaluate.add( filterEntry );
                        }
                    }
                    if ( !mEsToReevaluate.isEmpty( ) ) {
                        try {
                            listener.notify( mEsToReevaluate, this , event.getEventTriggerConnection());
                        } catch ( VetoException e ) {
                            vetoException = e;
                        }
                    }
                }

            }
        }
        if ( vetoException != null ) {
            throw vetoException;
        }
    }

    @Override
    public Set<MRI> getAffectedModelElements(ModelChangeEvent mce, Connection conn) {
	Statistics.getInstance().receivedEvent(this, mce);
	Set<EvaluationUnit> units = this.getImpactAnalyzer( ).filter( (CoreConnection) conn, mce );
        Set<MRI> affectedModelElements = new HashSet<MRI>( );

        for ( EvaluationUnit unit : units ) {
            Set<OclAny> instances = this.evalHelper.getAffectedInstances( (CoreConnection) conn, unit );
            for ( OclAny resultObject : instances ) {
                if ( resultObject.getWrappedObject( ) instanceof RefObject ) {
                    affectedModelElements.add( ( (RefObject) resultObject.getWrappedObject( ) ).get___Mri( ) );
                }
            }
        }
	return affectedModelElements;
    }

    private void registerInEventFramework( ) {

        this.myConnection.getSession( ).getEventRegistry( ).registerListener( this, this.getEventFilter( ) );
        this.registeredInEventFramework = true;
    }

    public boolean registerEventBasedInvalidationListener( ExpressionInvalidationListener listener, boolean immediate ) {

        return this.registerEventBasedInvalidationListener( listener, new HashSet<MRI>( ), immediate );
    }

    public synchronized boolean registerEventBasedInvalidationListener( ExpressionInvalidationListener listener, Collection<MRI> objectFilter, boolean immediate ) {

        Set<MRI> filter = new HashSet<MRI>( );
        filter.addAll( objectFilter );

        if ( immediate ) {
            this.myImmediateEventListeners.put( listener, filter );
        } else {
            this.myDeferredEventListeners.put( listener, filter );
        }

        if ( !this.registeredInEventFramework ) {
            this.registerInEventFramework( );
        }
        return true;
    }

    void triggerEvaluationForCollectedEvents( ) {

        if ( this.collectedEvents.isEmpty( ) ) {
            return;
        }

        Map<Boolean, Map<ExpressionInvalidationListener, Set<MRI>>> eventListeners = this.getEventListeners( );

        if ( eventListeners.isEmpty( ) ) {
            return;
        }

        boolean notifyRequired = false;

        for ( Boolean immediate : eventListeners.keySet( ) ) {
            if ( !immediate.booleanValue( ) ) {
                // non-immediate
                notifyRequired = true;
            }
        }

        if ( !notifyRequired ) {
            return;
        }

        Set<EvaluationUnit> units = this.getImpactAnalyzer( ).filter( this.myConnection, this.collectedEvents );
        Set<MRI> affectedModelElements = new HashSet<MRI>( );

        for ( EvaluationUnit unit : units ) {
            Set<OclAny> instances = this.evalHelper.getAffectedInstances( this.myConnection, unit );
            for ( OclAny resultObject : instances ) {
                if ( resultObject.getWrappedObject( ) instanceof RefObject ) {
                    affectedModelElements.add( ( (RefObject) resultObject.getWrappedObject( ) ).get___Mri( ) );
                }
            }
        }

        if ( affectedModelElements.isEmpty( ) ) {
            return;
        }

        VetoException vetoException = null;

        for ( Map.Entry<Boolean, Map<ExpressionInvalidationListener, Set<MRI>>> entry : eventListeners.entrySet( ) ) {
            Boolean immediate = entry.getKey( );
            if ( immediate.booleanValue( ) ) {
                // immediate
                continue;
            }
            Map<ExpressionInvalidationListener, Set<MRI>> listeners = entry.getValue( );

            for ( Map.Entry<ExpressionInvalidationListener, Set<MRI>> listenerEntry : listeners.entrySet( ) ) {

                ExpressionInvalidationListener listener = listenerEntry.getKey( );
                Set<MRI> filter = listenerEntry.getValue( );
                if ( filter.isEmpty( ) ) {
                    try {
                        listener.notify( affectedModelElements, this , this.myConnection );
                    } catch ( VetoException e ) {
                        vetoException = e;
                    }
                } else {
                    Set<MRI> mEsToReevaluate = new HashSet<MRI>( );
                    for ( MRI filterEntry : filter ) {
                        if ( affectedModelElements.contains( filterEntry ) ) {
                            mEsToReevaluate.add( filterEntry );
                        }
                    }
                    if ( !mEsToReevaluate.isEmpty( ) ) {
                        try {
                            listener.notify( mEsToReevaluate, this , this.myConnection );
                        } catch ( VetoException e ) {
                            vetoException = e;
                        }
                    }
                }

            }
        }
        if ( vetoException != null ) {
            throw vetoException;
        }

    }

    @Override
    public EventFilter getEventFilter( ) {

        if ( this.myEventFilter == null ) {
            this.getImpactAnalyzer( );
        }
        return this.myEventFilter;
    }

    private ImpactAnalyzer getImpactAnalyzer( ) {

        if ( this.analyzer == null ) {
            Set<OclStatement> stmts = new HashSet<OclStatement>( );
            stmts.add( this.statement );
            this.analyzer = new ImpactAnalyzer( false );
            this.myEventFilter = this.analyzer.analyze( stmts, this.myJmiCreator );
        }
        return this.analyzer;
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
}
