/*
 * Created on 21.09.2006
 */
package com.sap.tc.moin.repository.core;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.sap.tc.moin.repository.MRI;

public interface JmiList<E> extends List<E> {

    public boolean equals( CoreConnection connection, Object obj );

    public int hashCode( CoreConnection connection );

    public void setLinkCollection( Collection<EndStorageLink> linkCollection );

    public Collection<EndStorageLink> getLinkCollection( );

    public MRI getFromEnd( );

    public boolean isOrdered( );

    public Object getIdentity( );

    public Workspace getWorkspace( );

    public Object[] toArray( CoreConnection connection );

    public <T> T[] toArray( CoreConnection connection, T[] a );

    public void add( CoreConnection connection, int index, E element );

    public boolean add( CoreConnection connection, E element );

    public boolean addAll( CoreConnection connection, int index, Collection<? extends E> elements );

    public boolean addAll( CoreConnection connection, Collection<? extends E> elements );

    public Object set( CoreConnection connection, int index, E element );

    public boolean remove( CoreConnection connection, Object element );

    public E remove( CoreConnection connection, int index );

    public boolean removeAll( CoreConnection connection, Collection<?> elements );

    public boolean retainAll( CoreConnection connection, Collection<?> elements );

    public void clear( CoreConnection connection );

    public E get( CoreSession session, int index );

    public int size( CoreSession session );

    public boolean isEmpty( CoreSession session );

    public boolean contains( CoreConnection connection, Object o );

    public boolean containsAll( CoreConnection connection, Collection<?> c );

    public int indexOf( CoreConnection connection, Object o );

    public int lastIndexOf( CoreConnection connection, Object o );

    public ListIterator<E> listIterator( CoreConnection connection );

    public ListIterator<E> listIterator( CoreConnection connection, int index );

    public JmiList<E> subList( CoreConnection connection, int fromIndex, int toIndex );

    /**
     * Returns whether the JmiList's "fromElement" is still alive (i.e. not
     * deleted or evicted).
     */
    public boolean isValid( );

    public void invalidate( );

    public EndAndMetaObject getEndAndMetaObject( );

    public EndStorageLinkManager getLinkManager( CoreConnection connection );

    public Iterator<E> iterator( CoreConnection connection );

    public Iterator<E> iteratorReadOnly( CoreSession session );

    public boolean isDistributed( );
}
