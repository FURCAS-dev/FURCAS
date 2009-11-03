package com.sap.tc.moin.repository.core.impl;

import static com.sap.tc.moin.repository.shared.util.Utilities.calcInitialCapacity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.core.AbstractConnectionAwareWrapper;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.JmiListWrapper;
import com.sap.tc.moin.repository.core.ModelPartitionWrapper;
import com.sap.tc.moin.repository.core.MultiValuedAttributesList;
import com.sap.tc.moin.repository.core.OrderedJmiListWrapper;
import com.sap.tc.moin.repository.core.PriReference;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.WrapperManager;
import com.sap.tc.moin.repository.core.jmi.reflect.RefAssociationImpl;
import com.sap.tc.moin.repository.core.jmi.reflect.RefBaseObjectImpl;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * The WrapperManager is able to return wrappers for JMI objects, JmiLists and
 * MOIN-specific entities all of which are handed out to clients via API calls.
 */
public final class WrapperManagerImpl implements WrapperManager {

    private final WorkspaceSet workspaceSet;

    WrapperManagerImpl( WorkspaceSet actWorkspaceSet ) {

        this.workspaceSet = actWorkspaceSet;
    }

    /**
     * Returns a {@link com.sap.tc.moin.repository.spi.core.Wrapper wrapper} for
     * the given {@link ModelPartition} in the context of the given connection.
     * <p>
     * Must only be called by {@link ConnectionImpl} !
     */
    public ModelPartition getWrapperForModelPartition( CoreConnection connection, ModelPartition partition ) {

        if ( partition == null ) {
            return null;
        } // null is not wrapped
        CoreModelPartition corePartition = (CoreModelPartition) partition;
        PriReference priReference = this.workspaceSet.getReferenceManager( ).getPriReference( corePartition, corePartition.getWorkspace( ) );
        return new ModelPartitionWrapper( this.workspaceSet, connection, priReference );
    }

    /**
     * Returns a {@link com.sap.tc.moin.repository.spi.core.Wrapper wrapper} for
     * the given {@link RefBaseObject} in the context of the given connection.
     * <p>
     * Must only be called by {@link ConnectionImpl} !
     */
    public <T extends RefBaseObject> T getWrapperForJmiObject( CoreConnection connection, T refBaseObject ) {

        if ( refBaseObject == null ) {
            // null is not wrapped
            return null;
        }
        return (T) ( (RefBaseObjectImpl) refBaseObject ).createWrapper( connection, true /*
                                                                                          * TODO
                                                                                          * remove
                                                                                          * parameter
                                                                                          * from
                                                                                          * signature
                                                                                          */);
    }

    /**
     * Returns a {@link com.sap.tc.moin.repository.spi.core.Wrapper wrapper} for
     * the given {@link JmiList} in the context of the given connection.
     * <p>
     * Must only be called by {@link ConnectionImpl} !
     */
    public AbstractConnectionAwareWrapper getWrapperForJmiList( CoreConnection connection, JmiList jmiList ) {

        if ( jmiList == null ) {
            return null;
        } // null is not wrapped
        if ( jmiList.isOrdered( ) ) {
            return new OrderedJmiListWrapper( connection, workspaceSet.getSynchronizationManager( ), jmiList );
        }
        return new JmiListWrapper( connection, workspaceSet.getSynchronizationManager( ), jmiList );
    }

    @SuppressWarnings( "unchecked" )
    private Collection wrapCollection( CoreConnection connection, Collection collection ) {

        if ( collection == null ) {
            return collection;
        }
        Collection result = null;
        if ( collection instanceof Set ) {
            result = new LinkedHashSet( calcInitialCapacity( collection.size( ) ) );
        } else if ( !( collection instanceof MultiValuedAttributesList ) ) {
            result = new ArrayList( collection.size( ) );
        }

        for ( Iterator it = collection.iterator( ); it.hasNext( ); ) {
            Object obj = it.next( );
            Object wrapped = wrapObject( connection, obj );
            result.add( wrapped );
        }

        // Check whether an unmodifiable collection is required.
        if ( collection.getClass( ).getName( ).indexOf( "Unmodifiable" ) != -1 ) { //$NON-NLS-1$
            // TODO HACK... What we really want is an 'instanceof' check for our
            // own Unmodifiable* interfaces.
            if ( collection instanceof List ) {
                return Collections.unmodifiableList( (List) result );
            }
            return Collections.unmodifiableCollection( result );
        }
        return result;
    }

    @SuppressWarnings( "unchecked" )
    private <K, V> Map wrapMap( CoreConnection connection, Map<K, V> map ) {

        if ( map == null || map.isEmpty( ) ) {
            return map;
        }
        Map<K, V> result = new LinkedHashMap<K, V>( calcInitialCapacity( map.size( ) ) );
        for ( Entry<K, V> entry : map.entrySet( ) ) {
            K wrappedKey = (K) wrapObject( connection, entry.getKey( ) );
            V wrappedValue = (V) wrapObject( connection, entry.getValue( ) );
            result.put( wrappedKey, wrappedValue );
        }
        return result;
    }

    public void wrapJmiExceptionAttributes( CoreConnection connection, JmiException jmiException ) {

        Object objectInError = jmiException.getObjectInError( );
        if ( objectInError != null && !( objectInError instanceof Wrapper ) ) {
            jmiException.setObjectInError( wrapObject( connection, objectInError ) );
        }
        RefObject elementInError = jmiException.getElementInError( );
        if ( elementInError != null && !( elementInError instanceof Wrapper ) ) {
            jmiException.setElementInError( (RefObject) wrapObject( connection, elementInError ) );
        }
    }

    @SuppressWarnings( "unchecked" )
    public Object wrapObject( CoreConnection connection, Object object ) {

        if ( object == null ) {
            return null;
        } // null is not wrapped
        if ( object instanceof RefBaseObject ) {
            // JMI object
            RefBaseObject rbo = (RefBaseObject) object;
            assert rbo.is___Alive( ) : "Attempt to request a wrapper for the dead JMI object " + rbo.toString( ); //$NON-NLS-1$
            return connection.getWrapperForJmiObject( rbo );
        } else if ( object instanceof JmiList ) {
            if ( object instanceof RefAssociationImpl.IterableOnlyJmiList ) {
                // special case: derived association; return unmanaged JmiListWrapper
                return getWrapperForJmiList( connection, (RefAssociationImpl.IterableOnlyJmiList) object );
            }
            // JmiList
            return connection.getWrapperForJmiList( (JmiList) object );
        } else if ( object instanceof MultiValuedAttributesList ) {
            return connection.getWrapperForMultiValuedAttributesList( (MultiValuedAttributesList) object );
        } else if ( object instanceof Collection ) {
            // e.g. RefFeatured.refInvokeOperation()
            return wrapCollection( connection, (Collection) object );
        } else if ( object instanceof Map ) {
            return wrapMap( connection, (Map) object );
        } else if ( object instanceof CoreModelPartition ) {
            // Example: Partitionable.get___Partition()
            return connection.getWrapperForModelPartition( (ModelPartition) object );
        } else if ( object instanceof CoreConnection ) {
            // Example: Partitionable.get___Connection()
            return ( (CoreConnection) object ).getWrapper( );
        } else {
            return object;
        }
    }



}
