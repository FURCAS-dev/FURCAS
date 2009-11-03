package com.sap.tc.moin.repository.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import com.sap.tc.moin.repository.InvalidConnectionException;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.shared.util.Utilities;
import com.sap.tc.moin.repository.spi.core.Wrapper;

public abstract class AbstractConnectionAwareWrapper<T> implements Wrapper<T> {

    protected CoreConnection connection;

    protected SynchronizationManager synchronizationManager;

    protected AbstractConnectionAwareWrapper( final CoreConnection connection, final SynchronizationManager synchronizationManager ) {

        if ( connection == null ) {
            throw new InvalidConnectionException( JmiCoreMessages.CONNECTIONISNULL );
        }
        this.connection = connection;
        this.synchronizationManager = synchronizationManager;
    }

    public final SynchronizationManager getSynchronizationManager( ) {

        return this.synchronizationManager;
    }

    public final void assertConnectionAlive( ) {

        if ( !connection.isAlive( ) ) {
            String id = connection.getId( );
            String label = connection.getLabel( );
            throw new InvalidConnectionException( JmiCoreMessages.CONNECTIONISINVALID, id, label );
        }
    }

    public final void attachConnectionIfRequired( ) {


    }

    @SuppressWarnings( "unchecked" )
    protected final <P> P unwrapArg( P wrapperOrObject ) {

        if ( ( wrapperOrObject instanceof List ) || ( wrapperOrObject instanceof JmiListWrapper ) ) {
            int size = 0;
            Iterator iter = null;
            if ( wrapperOrObject instanceof List ) {
                List list = (List) wrapperOrObject;
                size = list.size( );
                iter = list.iterator( );
            } else { // JmiListWrapper
                JmiList list = ( (JmiListWrapper) wrapperOrObject ).unwrap( );
                size = list.size( this.connection.getSession( ) );
                iter = list.iteratorReadOnly( this.connection.getSession( ) );
            }

            List result = new ArrayList( size );
            for ( ; iter.hasNext( ); ) {
                result.add( this.unwrapArg( iter.next( ) ) );
            }
            return (P) result;
        }

        if ( wrapperOrObject instanceof AbstractConnectionAwareWrapper ) {
            AbstractConnectionAwareWrapper<P> other = (AbstractConnectionAwareWrapper) wrapperOrObject;
            if ( other.connection.getSession( ) == this.connection.getSession( ) ) {
                return other.unwrap( );
            } else {
                //argument is from other session, therefore resolve it in context of this connection
                return other.resolveWrappedElement( this.connection );
            }
        }

        if ( wrapperOrObject instanceof Set ) {
            Set result;
            if ( wrapperOrObject instanceof SortedSet ) {
                result = new TreeSet( );
            } else {
                result = new HashSet( Utilities.calcInitialCapacity( ( (Set) wrapperOrObject ).size( ) ) );
            }
            for ( Object item : (Set) wrapperOrObject ) {
                if ( item instanceof RefBaseObject ) {
                    result.add( this.unwrapArg( (RefBaseObject) item ) );
                } else {
                    result.add( item );
                }
            }
            return (P) result;
        }

        if ( wrapperOrObject instanceof Wrapper ) {
            return (P) ( (Wrapper) wrapperOrObject ).unwrap( );
        }

        return wrapperOrObject;
    }

    //subclasses must override if they can meaningfully resolve themselves in context of a different connection 
    protected T resolveWrappedElement( CoreConnection connection ) {

        T unwrapped = this.unwrap( );
        throw new MoinIllegalArgumentException( JmiCoreMessages.CANNOTUSEXFROMCONNECTION, unwrapped, this.connection, connection );
    }

    public final CoreConnection getCoreConnection( ) {

        return this.connection;
    }
}