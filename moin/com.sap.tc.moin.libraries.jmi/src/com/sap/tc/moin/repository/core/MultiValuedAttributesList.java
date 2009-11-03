package com.sap.tc.moin.repository.core;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;



public interface MultiValuedAttributesList<E> extends List<E> {

    public RefFeatured getRefFeatured( );

    public String getAttributeMofId( );

    public boolean add( CoreConnection connection, E anElement );

    public void add( CoreConnection connection, int anIndex, E anElement );

    public boolean addAll( CoreConnection connection, Collection<? extends E> theElements );

    public boolean addAll( CoreConnection connection, int anIndex, Collection<? extends E> theElements );

    public void clear( CoreConnection connection );

    public boolean remove( CoreConnection connection, Object anElement );

    public E remove( CoreConnection connection, int anIndex );

    public boolean removeAll( CoreConnection connection, Collection<?> theElements );

    public boolean retainAll( CoreConnection connection, Collection<?> elements );

    public E set( CoreConnection connection, int anIndex, E anElement );

    public E get( int anIndex );

    public int size( );

    public Iterator<E> iterator( CoreConnection connection );

    public ListIterator<E> listIterator( CoreConnection connection, int index );

    public List<E> subList( int fromIndex, int toIndex );

    public Object clone( );

    /**
     * This method is used to replace the content of the {@link List}. Logically
     * it does: <code>clear(); addAll(c);</code>.
     */
    public void replace( Collection<? extends E> theElements );

    public void ___add( int anIndex, E anElement );

    public void ___add( E anElement );

    public E ___remove( int anIndex );

    public boolean ___remove( Object anElement );

    public void ___replace( Collection<? extends E> theElements );

    public E ___set( int anIndex, E anElement );


}