package com.sap.tc.moin.repository.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.omg.ocl.expressions.OclExpression;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.ocl.debugger.OclDebuggerNode;
import com.sap.tc.moin.repository.ocl.freestyle.ExpressionInvalidationListener;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistrationType;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * ExpressionRegistrationWrapper
 */
public class OclExpressionRegistrationWrapper extends AbstractConnectionAwareWrapper<OclExpressionRegistration> implements OclExpressionRegistration {

    private final OclExpressionRegistration oclExpressionRegistration;

    /**
     * @param actRegistration the {@link OclExpressionRegistration}
     * @param actConnection the connection
     */
    public OclExpressionRegistrationWrapper( OclExpressionRegistration actRegistration, CoreConnection actConnection ) {

        super( actConnection, actConnection.getSession( ).getWorkspaceSet( ).getSynchronizationManager( ) );
        this.oclExpressionRegistration = actRegistration;
    }

    public Object evaluateExpression( RefObject context ) throws OclManagerException {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            RefObject unwrappedContext;
            if ( context != null ) {
                unwrappedContext = ( (Wrapper<RefObject>) context ).unwrap( );
            } else {
                unwrappedContext = null;
            }

            Object result = this.oclExpressionRegistration.evaluateExpression( unwrappedContext );
            if ( result instanceof Collection<?> ) {
                if ( result instanceof JmiList<?> ) {
                    return this.connection.getWrapperForJmiList( (JmiList<?>) result );
                }
                return this.getConnectionWrappingCollection( (Collection<Object>) result );

            } else if ( result instanceof RefBaseObject ) {
                return this.connection.getWrapperForJmiObject( (RefBaseObject) result );
            }
            return result;
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public Object evaluateExpression( MRI contextMri ) throws OclManagerException {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );

            Object result = this.oclExpressionRegistration.evaluateExpression( contextMri );
            if ( result instanceof Collection ) {
                if ( result instanceof JmiList ) {
                    return this.connection.getWrapperForJmiList( (JmiList<?>) result );
                }
                return this.getConnectionWrappingCollection( (Collection) result );

            } else if ( result instanceof RefBaseObject ) {
                return this.connection.getWrapperForJmiObject( (RefBaseObject) result );
            }
            return result;
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public OclDebuggerNode debugExpression( RefObject context ) throws OclManagerException {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            RefObject unwrappedContext;
            if ( context != null ) {
                unwrappedContext = ( (Wrapper<RefObject>) context ).unwrap( );
            } else {
                unwrappedContext = null;
            }

            return this.oclExpressionRegistration.debugExpression( unwrappedContext );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public OclDebuggerNode debugExpression( MRI contextMri ) throws OclManagerException {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );

            return this.oclExpressionRegistration.debugExpression( contextMri );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    private Object getConnectionWrappingCollection( Collection<Object> collection ) {


        if ( collection instanceof LinkedHashSet<?> ) {
            Set<Object> result = new LinkedHashSet<Object>( );
            for ( Object any : collection ) {
                if ( any instanceof RefBaseObject ) {
                    result.add( this.connection.getWrapperForJmiObject( ( (RefBaseObject) any ) ) );
                } else {
                    result.add( any );
                }
            }
            return result;
        } else if ( collection instanceof Set<?> ) {
            Set<Object> result = new HashSet<Object>( );
            for ( Object any : collection ) {
                if ( any instanceof RefBaseObject ) {
                    result.add( this.connection.getWrapperForJmiObject( ( (RefBaseObject) any ) ) );
                } else {
                    result.add( any );
                }
            }
            return result;
        } else if ( collection instanceof List<?> ) {
            List<Object> result = new ArrayList<Object>( );
            for ( Object any : collection ) {
                if ( any instanceof RefBaseObject ) {
                    result.add( this.connection.getWrapperForJmiObject( ( (RefBaseObject) any ) ) );
                } else {
                    result.add( any );
                }
            }
            return result;
        } else {
            // this would then be an OclBag; we don't have an API for this,
            // so let's simply return a List for the moment
            // TODO do we need to have this in the API?
            Collection<Object> result = new ArrayList<Object>( );
            for ( Object element : collection ) {
                if ( element instanceof RefBaseObject ) {
                    result.add( this.connection.getWrapperForJmiObject( ( (RefBaseObject) element ) ) );
                } else {
                    result.add( element );
                }
            }
            return result;
        }
    }

    public boolean registerEventBasedInvalidationListener( ExpressionInvalidationListener listener, Collection<MRI> objectFilter, boolean immediate ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            return this.oclExpressionRegistration.registerEventBasedInvalidationListener( listener, objectFilter, immediate );
        }
    }

    public boolean registerEventBasedInvalidationListener( ExpressionInvalidationListener listener, boolean immediate ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            return this.oclExpressionRegistration.registerEventBasedInvalidationListener( listener, immediate );
        }
    }

    public boolean registerPartitionBasedInvalidationListener( String category, ExpressionInvalidationListener listener ) throws IllegalArgumentException {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            return this.oclExpressionRegistration.registerPartitionBasedInvalidationListener( category, listener );
        }
    }

    public boolean registerPartitionBasedInvalidationListener( String category, ExpressionInvalidationListener listener, Collection<MRI> objectFilter ) throws IllegalArgumentException {
        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            return this.oclExpressionRegistration.registerPartitionBasedInvalidationListener( category, listener, objectFilter );
        }
    }

    public boolean unregisterInvalidationListener( ExpressionInvalidationListener listener ) {
	return this.oclExpressionRegistration.unregisterInvalidationListener( listener );
    }

    public Set<String> getCategories( ) {
	return this.oclExpressionRegistration.getCategories( );
    }

    public String getName( ) {
	return this.oclExpressionRegistration.getName( );
    }

    public String getOclExpression( ) {
	return this.oclExpressionRegistration.getOclExpression( );
    }

    public OclRegistrationSeverity getSeverity( ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclExpressionRegistration.getSeverity( );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public OclRegistrationType getType( ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclExpressionRegistration.getType( );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public OclExpressionRegistration unwrap( ) {

        return this.oclExpressionRegistration;
    }

    @Override
    public Set<MRI> getAffectedModelElements(ModelChangeEvent mce, Connection conn) {
	return this.oclExpressionRegistration.getAffectedModelElements(mce, ((ConnectionWrapper)conn).getCoreConnection());
    }

    @Override
    public EventFilter getEventFilter(boolean notifyNewContextElement) {
	this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclExpressionRegistration.getEventFilter(/* notifyNewContextElement */ true);
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }    
    }

    @Override
    public RefObject getContext() {
	return connection.getWrapperForJmiObject(this.oclExpressionRegistration.getContext());
    }

    @Override
    public OclExpression getExpression() {
	return connection.getWrapperForJmiObject(this.oclExpressionRegistration.getExpression());
    }

    @Override
    public Set<MRI> getAffectedModelElements(List<ChangeEvent> events, Connection conn) {
        return this.oclExpressionRegistration.getAffectedModelElements(events, conn);
    }

    @Override
    public boolean isUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly(ChangeEvent event,
	    String replacementFor__TEMP__) {
	return this.oclExpressionRegistration.isUnaffectedDueToPrimitiveAttributeValueComparisonWithLiteralOnly(event,
		replacementFor__TEMP__);
    }
    
}