package com.sap.tc.moin.repository.core;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.sap.tc.moin.repository.mmi.reflect.InvalidObjectException;

import com.sap.tc.moin.repository.MRI;

@SuppressWarnings( "unchecked" )
public class AttributeValuesWrapper extends AbstractConnectionAwareWrapper<MultiValuedAttributesList> implements List {

    protected final boolean synchronize;

    /**
     * Do NOT access field directly but always via getter as it is essential for
     * sublist to overwrite the getter method!
     */
    private MriReference featured;

    private String attributeMofId;


    public AttributeValuesWrapper( CoreConnection connection, SynchronizationManager synchronizationManager, MriReference featured, String attributeMofId ) {

        super( connection, synchronizationManager );
        this.attributeMofId = attributeMofId;
        this.featured = featured;
        CorePartitionable refFeatured = featured.get( connection.getSession( ) );
        boolean createUnsynchronizedWrapper = !( refFeatured instanceof Extent ) && refFeatured.get___Workspace( ).isMetamodelWorkspace( );
        this.synchronize = !createUnsynchronizedWrapper;
    }

    protected MriReference getFeatured( ) {

        return this.featured;
    }


    protected final void assertValidity( ) {

        assertConnectionAlive( );
        if ( getFeatured( ).getWithoutException( connection.getSession( ) ) == null ) {
            throw new InvalidObjectException( null, JmiCoreMessages.ELEMENTDELETED, getAttributeValuesList( ).getRefFeatured( ).refMofId( ), connection.toString( ) );
        }
    }

    public final MRI getMriOfFeatured( ) {

        return getFeatured( ).getMri( );
    }

    public final String getAttributeMofId( ) {

        return attributeMofId;
    }

    protected MultiValuedAttributesList getAttributeValuesList( ) {


        CorePartitionable element = getFeatured( ).getWithoutException( connection.getSession( ) );
        if ( element == null ) {
            throw new InvalidObjectException( null, JmiCoreMessages.ELEMENTDELETED, getFeatured( ).getMri( ).toString( ), connection.toString( ) );
        }
        MultiValuedAttributesList list = connection.getMultiValueAttributesList( element, attributeMofId );
        return list;
    }

    public final void setFeatured( MriReference featured ) {

        this.featured = featured;
    }

    @Override
    public final boolean equals( Object obj ) {

        assertValidity( );
        if ( obj == this ) {
            return true;
        }
        if ( obj instanceof List ) {
            return getAttributeValuesList( ).equals( obj );
        }
        return false;
    }

    @Override
    public final int hashCode( ) {

        assertValidity( );
        return getAttributeValuesList( ).hashCode( );
    }

    @Override
    public final String toString( ) {

        assertValidity( );
        if ( getAttributeValuesList( ) == null ) {
            return "null"; //$NON-NLS-1$
        }

        return getAttributeValuesList( ).toString( );
    }


    public final MultiValuedAttributesList unwrap( ) {

        assertValidity( );
        return getAttributeValuesList( );
    }

    public final boolean add( Object o ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertValidity( );
            attachConnectionIfRequired( );
            return this.getAttributeValuesList( ).add( connection, unwrapArg( o ) );
        }
    }

    public final void add( int index, Object o ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertValidity( );
            attachConnectionIfRequired( );
            this.getAttributeValuesList( ).add( connection, index, unwrapArg( o ) );
        }
    }

    public final boolean addAll( Collection c ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertValidity( );
            attachConnectionIfRequired( );
            return this.getAttributeValuesList( ).addAll( connection, unwrapArg( c ) );
        }
    }

    public final boolean addAll( int index, Collection c ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertValidity( );
            attachConnectionIfRequired( );
            return this.getAttributeValuesList( ).addAll( connection, index, unwrapArg( c ) );
        }
    }

    public final void clear( ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertValidity( );
            attachConnectionIfRequired( );
            this.getAttributeValuesList( ).clear( connection );
        }
    }

    public final Object remove( int index ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertValidity( );
            attachConnectionIfRequired( );
            return this.getAttributeValuesList( ).remove( connection, index );
        }
    }

    public final Object set( int index, Object o ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertValidity( );
            attachConnectionIfRequired( );
            return this.getAttributeValuesList( ).set( connection, index, o );
        }
    }

    public final boolean contains( Object o ) {

        if ( synchronize ) {
            synchronizationManager.acquireReadLock( );
            try {
                assertValidity( );
                return this.getAttributeValuesList( ).contains( unwrapArg( o ) );
            } finally {
                synchronizationManager.releaseReadLock( );
            }
        }
        assertValidity( );
        return this.getAttributeValuesList( ).contains( unwrapArg( o ) );
    }

    public final boolean containsAll( Collection c ) {

        if ( synchronize ) {
            synchronizationManager.acquireReadLock( );
            try {
                assertValidity( );
                return this.getAttributeValuesList( ).containsAll( unwrapArg( c ) );
            } finally {
                synchronizationManager.releaseReadLock( );
            }
        }
        assertValidity( );
        return this.getAttributeValuesList( ).containsAll( unwrapArg( c ) );
    }

    public final boolean isEmpty( ) {

        if ( synchronize ) {
            synchronizationManager.acquireReadLock( );
            try {
                assertValidity( );
                return this.getAttributeValuesList( ).isEmpty( );
            } finally {
                synchronizationManager.releaseReadLock( );
            }
        }
        assertValidity( );
        return this.getAttributeValuesList( ).isEmpty( );
    }

    public final Iterator iterator( ) {

        assertValidity( );
        return new Itr( this.getAttributeValuesList( ).iterator( connection ) );
    }

    public final boolean remove( Object o ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertValidity( );
            attachConnectionIfRequired( );
            return this.getAttributeValuesList( ).remove( connection, unwrapArg( o ) );
        }
    }

    public final boolean removeAll( Collection c ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertValidity( );
            attachConnectionIfRequired( );
            return this.getAttributeValuesList( ).removeAll( connection, unwrapArg( c ) );
        }
    }

    public final boolean retainAll( Collection c ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertValidity( );
            attachConnectionIfRequired( );
            return this.getAttributeValuesList( ).retainAll( connection, unwrapArg( c ) );
        }
    }

    public final int size( ) {

        if ( synchronize ) {
            synchronizationManager.acquireReadLock( );
            try {
                assertValidity( );
                return this.getAttributeValuesList( ).size( );
            } finally {
                synchronizationManager.releaseReadLock( );
            }
        }
        assertValidity( );
        return this.getAttributeValuesList( ).size( );
    }

    public final Object[] toArray( ) {

        if ( synchronize ) {
            synchronizationManager.acquireReadLock( );
            try {
                assertValidity( );
                return this.getAttributeValuesList( ).toArray( );
            } finally {
                synchronizationManager.releaseReadLock( );
            }
        }
        assertValidity( );
        return this.getAttributeValuesList( ).toArray( );
    }

    public final Object[] toArray( Object[] a ) {

        if ( synchronize ) {
            synchronizationManager.acquireReadLock( );
            try {
                assertValidity( );
                return this.getAttributeValuesList( ).toArray( a );
            } finally {
                synchronizationManager.releaseReadLock( );
            }
        }
        assertValidity( );
        return this.getAttributeValuesList( ).toArray( a );
    }

    public final Object get( int index ) {

        if ( synchronize ) {
            synchronizationManager.acquireReadLock( );
            try {
                assertValidity( );
                return this.getAttributeValuesList( ).get( index );
            } finally {
                synchronizationManager.releaseReadLock( );
            }
        }
        assertValidity( );
        return this.getAttributeValuesList( ).get( index );
    }

    public final int indexOf( Object o ) {

        if ( synchronize ) {
            synchronizationManager.acquireReadLock( );
            try {
                assertValidity( );
                return this.getAttributeValuesList( ).indexOf( o );
            } finally {
                synchronizationManager.releaseReadLock( );
            }
        }
        assertValidity( );
        return this.getAttributeValuesList( ).indexOf( o );
    }

    public final int lastIndexOf( Object o ) {

        if ( synchronize ) {
            synchronizationManager.acquireReadLock( );
            try {
                assertValidity( );
                return this.getAttributeValuesList( ).lastIndexOf( o );
            } finally {
                synchronizationManager.releaseReadLock( );
            }
        }
        assertValidity( );
        return this.getAttributeValuesList( ).lastIndexOf( o );
    }

    public final ListIterator listIterator( ) {

        return listIterator( 0 );
    }

    public final ListIterator listIterator( int index ) {

        assertValidity( );
        return new ListItr( this.getAttributeValuesList( ).listIterator( connection, index ) );
    }

    public final List subList( int fromIndex, int toIndex ) {

        if ( synchronize ) {
            synchronizationManager.acquireReadLock( );
            try {
                assertValidity( );
                return new SubList( this, connection, synchronizationManager, getFeatured( ), attributeMofId, fromIndex, toIndex );
            } finally {
                synchronizationManager.releaseReadLock( );
            }
        }
        assertValidity( );
        return new SubList( this, connection, synchronizationManager, getFeatured( ), attributeMofId, fromIndex, toIndex );
    }

    private static final class SubList extends AttributeValuesWrapper {

        private int fromIndex;

        private int toIndex;

        private AttributeValuesWrapper mainList;

        public SubList( AttributeValuesWrapper list, CoreConnection connection, SynchronizationManager synchronizationManager, MriReference featured, String attributeMofId, int fromIndex, int toIndex ) {

            super( connection, synchronizationManager, featured, attributeMofId );
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
            this.mainList = list;
        }

        @Override
        protected MultiValuedAttributesList getAttributeValuesList( ) {

            MultiValuedAttributesList attributeValuesList = mainList.getAttributeValuesList( );
            MultiValuedAttributesList result = (MultiValuedAttributesList) attributeValuesList.subList( fromIndex, toIndex );
            return result;
        }

        @Override
        protected MriReference getFeatured( ) {

            return mainList.getFeatured( );
        }
    }

    private class Itr implements Iterator {

        protected final Iterator wrappedIterator;

        public Itr( Iterator wrappedIterator ) {

            this.wrappedIterator = wrappedIterator;
        }

        public boolean hasNext( ) {

            if ( synchronize ) {
                synchronizationManager.acquireReadLock( );
                try {
                    assertValidity( );
                    return wrappedIterator.hasNext( );
                } finally {
                    synchronizationManager.releaseReadLock( );
                }
            }
            assertValidity( );
            return wrappedIterator.hasNext( );
        }

        public Object next( ) {

            if ( synchronize ) {
                synchronizationManager.acquireReadLock( );
                try {
                    assertValidity( );
                    return wrappedIterator.next( );
                } finally {
                    synchronizationManager.releaseReadLock( );
                }
            }
            assertValidity( );
            return wrappedIterator.next( );
        }

        public void remove( ) {

            synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
                assertValidity( );
                attachConnectionIfRequired( );
                wrappedIterator.remove( );
            }
        }
    }

    private class ListItr extends Itr implements ListIterator {

        public ListItr( ListIterator wrappedIterator ) {

            super( wrappedIterator );
        }

        public void add( Object o ) {

            synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
                assertValidity( );
                attachConnectionIfRequired( );
                ( (ListIterator) wrappedIterator ).add( unwrapArg( o ) );
            }
        }

        public boolean hasPrevious( ) {

            if ( synchronize ) {
                synchronizationManager.acquireReadLock( );
                try {
                    assertValidity( );
                    return ( (ListIterator) wrappedIterator ).hasPrevious( );
                } finally {
                    synchronizationManager.releaseReadLock( );
                }
            }
            assertValidity( );
            return ( (ListIterator) wrappedIterator ).hasPrevious( );
        }

        public int nextIndex( ) {

            if ( synchronize ) {
                synchronizationManager.acquireReadLock( );
                try {
                    assertValidity( );
                    return ( (ListIterator) wrappedIterator ).nextIndex( );
                } finally {
                    synchronizationManager.releaseReadLock( );
                }
            }
            assertValidity( );
            return ( (ListIterator) wrappedIterator ).nextIndex( );
        }

        public Object previous( ) {

            if ( synchronize ) {
                synchronizationManager.acquireReadLock( );
                try {
                    assertValidity( );
                    return ( (ListIterator) wrappedIterator ).previous( );
                } finally {
                    synchronizationManager.releaseReadLock( );
                }
            }
            assertValidity( );
            return ( (ListIterator) wrappedIterator ).previous( );
        }

        public int previousIndex( ) {

            if ( synchronize ) {
                synchronizationManager.acquireReadLock( );
                try {
                    assertValidity( );
                    return ( (ListIterator) wrappedIterator ).previousIndex( );
                } finally {
                    synchronizationManager.releaseReadLock( );
                }
            }
            assertValidity( );
            return ( (ListIterator) wrappedIterator ).previousIndex( );
        }

        public void set( Object o ) {

            synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
                assertValidity( );
                attachConnectionIfRequired( );
                ( (ListIterator) wrappedIterator ).set( unwrapArg( o ) );
            }
        }
    }


}
