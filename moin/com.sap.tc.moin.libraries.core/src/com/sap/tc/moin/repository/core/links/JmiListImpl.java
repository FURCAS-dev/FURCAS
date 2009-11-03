/*
 * Created on 17.03.2005
 */
package com.sap.tc.moin.repository.core.links;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndAndMetaObject;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.EndStorageLinkManager;
import com.sap.tc.moin.repository.core.JmiCoreMessages;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.MoinReference;
import com.sap.tc.moin.repository.core.MriReference;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.exception.MoinIndexOutOfBoundsException;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.reflect.InvalidObjectException;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.shared.util.IteratorKnowingCollection;
import com.sap.tc.moin.repository.transactions.MicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.LinkAddElementMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.LinkRemoveElementMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.LinkSetElementMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.MicroTransactionableFactory;
import com.sap.tc.moin.repository.transactions.microtransactionables.ObjectAttributeAddElementMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.ObjectAttributeRemoveElementMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.ObjectAttributeSetElementMicroTransactionable;


public class JmiListImpl<E> implements JmiList<E> {

    /**
     * The collection of {@link EndStorageLink} elements on which this JMI list
     * is based. May be <tt>null</tt>, meaning that there are currently no
     * corresponding links known to the LinkContainer {@link #lc}.
     */
    protected Collection<EndStorageLink> linkCollection;

    /**
     * Points to the model element from which navigation starts.
     */
    protected MriReference fromElement;

    /**
     * Is true, if the metaObject is an association. If false, the metaObject
     * must be an attribute.
     */
    protected final boolean association;

    /**
     * Combines the end number of the element where the navigation starts and
     * the corresponding metaobject (Attribute or Association).
     */
    protected final EndAndMetaObject endAndMetaObject;

    protected final Workspace workspace;

    protected final boolean ordered;

    /**
     * The object serving as Java identity of this JmiListImpl instance. This
     * identity is exposed via {@link #getIdentity()} and can for example be
     * used as the key in an {@link IdentityHashMap}, instead of storing a hard
     * reference to the JmiList (preventing the JmiList from being
     * garbage-collected).
     */
    private final Object identity;

    protected transient int modCount = 0;

    private boolean valid;

    /**
     * Constructs a "virtual" model element list that is determined by the link
     * list managed by the associations container passed as argument <tt>lc</tt>
     * . Registers this list with the associations container by calling
     * LinkContainer.registerJmiList(JmiList, RefObject, MoinReference, int).
     * 
     * @param metaObject the {@link Association} or {@link Attribute} that can
     * be navigates / manipulated using the list
     * @param from points to the model element from where navigation with with
     * this list originates
     * @param lc the associations container containing the link set on which
     * this JMI list is based
     * @param fromEnd the number of the end in which the element pointed to by
     * the <tt>from</tt> reference occurs in the <tt>metaObject</tt>
     * @param toEnd the number of the end to which to navigate. Expected to be
     * different from <tt>fromEnd</tt>.
     */
    public JmiListImpl( CoreSession session, EndAndMetaObject endAndMetaObject, MriReference fromElement, Workspace workspace ) {

        this.endAndMetaObject = endAndMetaObject;
        this.fromElement = fromElement;
        this.workspace = workspace;
        this.identity = new Object( );
        CorePartitionable metaObject = endAndMetaObject.getMetaObject( workspace.getWorkspaceSet( ).getMoin( ) ).get( session );
        this.association = ( metaObject instanceof Association );
        this.ordered = workspace.getWorkspaceSet( ).getMoin( ).getJmiHelper( ).isOrdered( session, (RefObject) metaObject, endAndMetaObject.getToEnd( ) );
        this.valid = true;
    }

    @Override
    @SuppressWarnings( "unchecked" )
    public boolean equals( Object obj ) {

        if ( obj == this ) {
            return true;
        }
        if ( obj instanceof JmiListImpl ) {
            return identity == ( (JmiListImpl<E>) obj ).identity;
        }
        return false;
    }

    @SuppressWarnings( "unchecked" )
    public boolean equals( CoreConnection connection, Object obj ) {

        if ( obj == this ) {
            return true;
        }
        if ( obj instanceof List || obj instanceof JmiList ) {
            prepareReadAccess( connection.getSession( ) );
            ListIterator<E> e1 = listIterator( connection );
            ListIterator<E> e2;
            if ( obj instanceof JmiList ) {
                e2 = ( (JmiList) obj ).listIterator( connection );
            } else {
                e2 = ( (List<E>) obj ).listIterator( );
            }

            while ( e1.hasNext( ) && e2.hasNext( ) ) {
                E o1 = e1.next( );
                E o2 = e2.next( );
                if ( !( o1 == null ? o2 == null : o1.equals( o2 ) ) ) {
                    return false;
                }
            }
            return !( e1.hasNext( ) || e2.hasNext( ) );
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        return identity.hashCode( );
    }

    public int hashCode( CoreConnection connection ) {

        //TODO change signature to session
        CoreSession session = connection != null ? connection.getSession( ) : null;
        prepareReadAccess( session );
        int hashCode = 17;
        if ( ordered ) {
            for ( int i = 0, n = internalSize( ); i < n; i++ ) {
                Object obj = getElement( session, i );
                hashCode = 37 * hashCode + ( obj == null ? 0 : obj.hashCode( ) );
            }
        } else {
            Iterator<E> it = internalReadOnlyIterator( session );
            while ( it.hasNext( ) ) {
                E obj = it.next( );
                hashCode = 37 * hashCode + ( obj == null ? 0 : obj.hashCode( ) );
            }
        }
        return hashCode;
    }

    private CoreConnection getCurrentConnection( ) {

        throw new MoinUnsupportedOperationException( CoreLinksMessages.THISMETHODSHOULDNEVERBECALLED );
        //return this.workspace.getWorkspaceSet( ).getMoin( ).getCurrentConnection( );
    }

    private CoreSession getCurrentSession( ) {

        CoreConnection currentConnection = getCurrentConnection( );
        if ( currentConnection != null ) {
            return currentConnection.getSession( );
        }

        return null;
    }


    @Deprecated
    public boolean contains( Object o ) {

        return this.contains( getCurrentConnection( ), o );
    }

    public boolean contains( CoreConnection connection, Object o ) {

        //TODO change signature to session
        CoreSession session = connection != null ? connection.getSession( ) : null;
        prepareReadAccess( session );
        if ( ordered ) {
            if ( o == null ) {
                for ( int i = 0, n = internalSize( ); i < n; i++ ) {
                    CorePartitionable element = getElement( session, i );
                    if ( element == null ) {
                        return true;
                    }
                }
            } else {
                for ( int i = 0, n = internalSize( ); i < n; i++ ) {
                    CorePartitionable element = getElement( session, i );
                    if ( o.equals( element ) ) {
                        return true;
                    }
                }
            }
            return false;
        }
        Iterator<E> it = internalReadOnlyIterator( session );
        if ( o == null ) {
            while ( it.hasNext( ) ) {
                if ( it.next( ) == null ) {
                    return true;
                }
            }
        } else {
            while ( it.hasNext( ) ) {
                if ( o.equals( it.next( ) ) ) {
                    return true;
                }
            }
        }
        return false;
    }

    @Deprecated
    public boolean containsAll( Collection<?> c ) {

        return containsAll( getCurrentConnection( ), c );
    }

    public boolean containsAll( CoreConnection connection, Collection<?> c ) {

        CoreSession session = connection != null ? connection.getSession( ) : null;
        prepareReadAccess( session );
        Iterator<E> it = c instanceof JmiList ? ( (JmiList) c ).iteratorReadOnly( session ) : c.iterator( );
        while ( it.hasNext( ) ) {
            E element = it.next( );
            if ( !this.contains( connection, element ) ) {
                return false;
            }
        }
        return true;
    }

    @Deprecated
    public int indexOf( Object o ) {

        return indexOf( getCurrentConnection( ), o );
    }

    public final int indexOf( CoreConnection connection, Object o ) {

        prepareReadAccess( connection.getSession( ) );
        if ( o == null ) {
            for ( int i = 0, n = internalSize( ); i < n; i++ ) {
                if ( getElement( connection.getSession( ), i ) == null ) {
                    return i;
                }
            }
        } else {
            for ( int i = 0, n = internalSize( ); i < n; i++ ) {
                if ( o.equals( getElement( connection.getSession( ), i ) ) ) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Deprecated
    public boolean isEmpty( ) {

        return this.isEmpty( getCurrentSession( ) );
    }

    public boolean isEmpty( CoreSession session ) {

        return size( session ) == 0;
    }

    @Deprecated
    public int lastIndexOf( Object o ) {

        return this.lastIndexOf( getCurrentConnection( ), o );
    }

    public int lastIndexOf( CoreConnection connection, Object o ) {

        prepareReadAccess( connection.getSession( ) );
        if ( o == null ) {
            for ( int i = internalSize( ) - 1; i >= 0; i-- ) {
                if ( getElement( connection.getSession( ), i ) == null ) {
                    return i;
                }
            }
        } else {
            for ( int i = internalSize( ) - 1; i >= 0; i-- ) {
                if ( o.equals( getElement( connection.getSession( ), i ) ) ) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Deprecated
    public ListIterator<E> listIterator( ) {

        return this.listIterator( getCurrentConnection( ) );
    }

    public ListIterator<E> listIterator( CoreConnection connection ) {

        return listIterator( connection, 0 );
    }

    @Deprecated
    public ListIterator<E> listIterator( int index ) {

        return this.listIterator( getCurrentConnection( ), index );
    }

    public ListIterator<E> listIterator( CoreConnection connection, int index ) {

        prepareReadAccess( connection.getSession( ) );
        if ( index < 0 || index > internalSize( ) ) {
            throw new MoinIndexOutOfBoundsException( index, internalSize( ) );
        }
        return new WritableListIterator( connection, index );
    }

    @Deprecated
    public List<E> subList( int fromIndex, int toIndex ) {

        return this.subList( getCurrentConnection( ), fromIndex, toIndex );
    }

    public JmiList<E> subList( CoreConnection connection, int fromIndex, int toIndex ) {

        CoreSession session = connection.getSession( );
        prepareReadAccess( session );
        return new SubList<E>( session, this, fromIndex, toIndex );
    }

    @Deprecated
    public Object[] toArray( ) {

        return this.toArray( getCurrentConnection( ) );
    }

    public Object[] toArray( CoreConnection connection ) {

        //TODO change signature to session
        CoreSession session = connection != null ? connection.getSession( ) : null;
        prepareReadAccess( session );
        int size = internalSize( );
        Object[] result = new Object[size];
        if ( ordered ) {
            for ( int i = 0; i < size; i++ ) {
                result[i] = getElement( session, i );
            }
        } else {
            Iterator<E> it = internalReadOnlyIterator( session );
            for ( int i = 0; it.hasNext( ); i++ ) {
                result[i] = it.next( );
            }
        }
        return result;
    }

    @Deprecated
    public <T> T[] toArray( T[] a ) {

        return this.toArray( getCurrentConnection( ), a );
    }

    @SuppressWarnings( "unchecked" )
    public <T> T[] toArray( CoreConnection connection, T[] a ) {

        //TODO change signature to session
        if ( a == null ) {
            throw new MoinNullPointerException( CoreLinksMessages.SPECIFIEDARRAYISNULL );
        }
        CoreSession session = connection != null ? connection.getSession( ) : null;
        prepareReadAccess( session );
        int size = internalSize( );
        T[] result = a;
        Class arrayComponentType = a.getClass( ).getComponentType( );
        if ( a.length < size ) {
            result = (T[]) java.lang.reflect.Array.newInstance( arrayComponentType, size );
        }
        if ( ordered ) {
            for ( int i = 0; i < size; i++ ) {
                CorePartitionable element = getElement( session, i );
                if ( !arrayComponentType.isInstance( element ) ) {
                    throw new ArrayStoreException( "The runtime type of the specified array (" + arrayComponentType + ") is not compatible to the runtime type of the list element (" + element.getClass( ) + ")" ); //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
                }
                result[i] = (T) element;
            }
        } else {
            Iterator<E> it = internalReadOnlyIterator( session );
            for ( int i = 0; i < size; i++ ) {
                E element = it.next( );
                if ( !arrayComponentType.isInstance( element ) ) {
                    if ( element != null ) {
                        throw new ArrayStoreException( "The runtime type of the specified array (" + arrayComponentType + ") is not compatible to the runtime type of the list element (" + element.getClass( ) + ")" ); //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
                    }
                }
                result[i] = (T) element;
            }
        }
        if ( a.length > size ) {
            result[size] = null;
        }
        return result;
    }

    public final Object getIdentity( ) {

        return identity;
    }

    public final Workspace getWorkspace( ) {

        return workspace;
    }

    public final boolean isOrdered( ) {

        return this.ordered;
    }

    public final MRI getFromEnd( ) {

        return this.fromElement.getMri( );
    }

    protected final MicroTransactionableFactory getMicroTransactionableFactory( ) {

        return this.workspace.getWorkspaceSet( ).getMoin( ).getMicroTransactionableFactory( );
    }



    @Deprecated
    public void add( int index, E element ) {

        this.add( getCurrentConnection( ), index, element );
    }

    public void add( CoreConnection connection, int index, E element ) {

        prepareWriteAccess( connection );
        assertIndexForAdd( index );
        MicroTransactionable mtx = null;
        if ( this.association ) {
            mtx = getMicroTransactionableFactory( ).createLinkAddElementMicroTransactionable( connection, (Association) endAndMetaObject.getMetaObject( workspace.getWorkspaceSet( ).getMoin( ) ).get( connection.getSession( ) ), (RefObject) fromElement.get( connection.getSession( ) ),
                                                                                              endAndMetaObject.getFromEnd( ), index, element );
        } else {
            mtx = getMicroTransactionableFactory( ).createObjectAttributeAddElementMicroTransactionable( connection, (RefFeatured) fromElement.get( connection.getSession( ) ), (Attribute) endAndMetaObject.getMetaObject( workspace.getWorkspaceSet( ).getMoin( ) ).get( connection.getSession( ) ),
                                                                                                         index, element );
        }
        connection.getSession( ).getTransactionManager( ).runInMicroTransaction( mtx );
    }


    @Deprecated
    public boolean add( E element ) {

        return this.add( getCurrentConnection( ), element );
    }

    public boolean add( CoreConnection connection, E element ) {

        prepareWriteAccess( connection );
        boolean returnValue = true;
        if ( this.association ) {
            LinkAddElementMicroTransactionable mtx = getMicroTransactionableFactory( ).createLinkAddElementMicroTransactionable( connection, (Association) endAndMetaObject.getMetaObject( workspace.getWorkspaceSet( ).getMoin( ) ).get( connection.getSession( ) ),
                                                                                                                                 (RefObject) fromElement.get( connection.getSession( ) ), endAndMetaObject.getFromEnd( ), element );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( mtx );
            returnValue = mtx.linkSetChanged( );
        } else {
            ObjectAttributeAddElementMicroTransactionable mtx = getMicroTransactionableFactory( ).createObjectAttributeAddElementMicroTransactionable( connection, (RefFeatured) fromElement.get( connection.getSession( ) ),
                                                                                                                                                       (Attribute) endAndMetaObject.getMetaObject( workspace.getWorkspaceSet( ).getMoin( ) ).get( connection.getSession( ) ), element );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( mtx );
            returnValue = mtx.attributeChanged( );
        }
        return returnValue;
    }

    @Deprecated
    public boolean addAll( int index, Collection<? extends E> elements ) {

        return addAll( getCurrentConnection( ), index, elements );
    }

    public boolean addAll( CoreConnection connection, int index, Collection<? extends E> elements ) {

        prepareWriteAccess( connection );
        assertIndexForAdd( index );
        boolean returnValue = true;
        if ( this.association ) {
            LinkAddElementMicroTransactionable mtx = getMicroTransactionableFactory( ).createLinkAddAllElementMicroTransactionable( connection, (Association) endAndMetaObject.getMetaObject( workspace.getWorkspaceSet( ).getMoin( ) ).get( connection.getSession( ) ),
                                                                                                                                    (RefObject) fromElement.get( connection.getSession( ) ), endAndMetaObject.getFromEnd( ), index, elements );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( mtx );
            returnValue = mtx.linkSetChanged( );
        } else {
            ObjectAttributeAddElementMicroTransactionable mtx = getMicroTransactionableFactory( ).createObjectAttributeAddAllElementMicroTransactionable( connection, (RefFeatured) fromElement.get( connection.getSession( ) ),
                                                                                                                                                          (Attribute) endAndMetaObject.getMetaObject( workspace.getWorkspaceSet( ).getMoin( ) ).get( connection.getSession( ) ), index, elements );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( mtx );
            returnValue = mtx.attributeChanged( );
        }
        return returnValue;
    }

    @Deprecated
    public boolean addAll( Collection<? extends E> elements ) {

        return this.addAll( getCurrentConnection( ), elements );
    }

    public boolean addAll( CoreConnection connection, Collection<? extends E> elements ) {

        prepareWriteAccess( connection );
        boolean returnValue = true;
        if ( this.association ) {
            LinkAddElementMicroTransactionable mtx = getMicroTransactionableFactory( ).createLinkAddAllElementMicroTransactionable( connection, (Association) endAndMetaObject.getMetaObject( workspace.getWorkspaceSet( ).getMoin( ) ).get( connection.getSession( ) ),
                                                                                                                                    (RefObject) fromElement.get( connection.getSession( ) ), endAndMetaObject.getFromEnd( ), elements );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( mtx );
            returnValue = mtx.linkSetChanged( );
        } else {
            ObjectAttributeAddElementMicroTransactionable mtx = getMicroTransactionableFactory( ).createObjectAttributeAddAllElementMicroTransactionable( connection, (RefFeatured) fromElement.get( connection.getSession( ) ),
                                                                                                                                                          (Attribute) endAndMetaObject.getMetaObject( workspace.getWorkspaceSet( ).getMoin( ) ).get( connection.getSession( ) ), elements );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( mtx );
            returnValue = mtx.attributeChanged( );
        }
        return returnValue;
    }

    /**
     * Replace the link at position <tt>index</tt> with the one that connects
     * the model element pointed to by the {@link #fromElement} reference with
     * the model element <tt>element</tt>.
     * 
     * @param element the model element to add to this list; expected to be a
     * {@link RefObject}.
     * @return the model element previously at index <tt>i</tt>
     */
    @Deprecated
    public E set( int index, E element ) {

        return this.set( getCurrentConnection( ), index, element );
    }

    @SuppressWarnings( "unchecked" )
    public E set( CoreConnection connection, int index, E element ) {

        this.prepareWriteAccess( connection );
        assertIndexForGetRemoveSet( index );
        E returnValue = null;
        if ( this.association ) {
            LinkSetElementMicroTransactionable mtx = getMicroTransactionableFactory( ).createLinkSetElementMicroTransactionable( connection, (Association) endAndMetaObject.getMetaObject( workspace.getWorkspaceSet( ).getMoin( ) ).get( connection.getSession( ) ),
                                                                                                                                 (RefObject) fromElement.get( connection.getSession( ) ), endAndMetaObject.getFromEnd( ), index, element );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( mtx );
            returnValue = (E) mtx.getElementReplaced( );
        } else {
            ObjectAttributeSetElementMicroTransactionable mtx = getMicroTransactionableFactory( ).createObjectAttributeSetElementMicroTransactionable( connection, (RefFeatured) fromElement.get( connection.getSession( ) ),
                                                                                                                                                       (Attribute) endAndMetaObject.getMetaObject( workspace.getWorkspaceSet( ).getMoin( ) ).get( connection.getSession( ) ), index, element );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( mtx );
            returnValue = (E) mtx.getElementReplaced( );
        }
        return returnValue;
    }


    @Deprecated
    public boolean remove( Object element ) {

        return this.remove( getCurrentConnection( ), element );
    }

    public boolean remove( CoreConnection connection, Object element ) {

        prepareWriteAccess( connection );
        boolean returnValue = true;
        if ( this.association ) {
            LinkRemoveElementMicroTransactionable mtx = getMicroTransactionableFactory( ).createLinkRemoveElementMicroTransactionable( connection, (Association) endAndMetaObject.getMetaObject( workspace.getWorkspaceSet( ).getMoin( ) ).get( connection.getSession( ) ),
                                                                                                                                       (RefObject) fromElement.get( connection.getSession( ) ), endAndMetaObject.getFromEnd( ), element );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( mtx );
            returnValue = mtx.linkSetChanged( );
        } else {
            ObjectAttributeRemoveElementMicroTransactionable mtx = getMicroTransactionableFactory( ).createObjectAttributeRemoveElementMicroTransactionable( connection, (RefFeatured) fromElement.get( connection.getSession( ) ),
                                                                                                                                                             (Attribute) endAndMetaObject.getMetaObject( workspace.getWorkspaceSet( ).getMoin( ) ).get( connection.getSession( ) ), element, false );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( mtx );
            returnValue = mtx.attributeChanged( );
        }
        return returnValue;
    }

    @Deprecated
    public E remove( int index ) {

        return this.remove( getCurrentConnection( ), index );
    }

    @SuppressWarnings( "unchecked" )
    public E remove( CoreConnection connection, int index ) {

        prepareWriteAccess( connection );
        assertIndexForGetRemoveSet( index );
        E returnValue = null;
        if ( this.association ) {
            LinkRemoveElementMicroTransactionable mtx = getMicroTransactionableFactory( ).createLinkRemoveElementMicroTransactionable( connection, (Association) endAndMetaObject.getMetaObject( workspace.getWorkspaceSet( ).getMoin( ) ).get( connection.getSession( ) ),
                                                                                                                                       (RefObject) fromElement.get( connection.getSession( ) ), endAndMetaObject.getFromEnd( ), index );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( mtx );
            returnValue = (E) mtx.getElementsRemoved( ).get( 0 );
        } else {
            ObjectAttributeRemoveElementMicroTransactionable mtx = getMicroTransactionableFactory( ).createObjectAttributeRemoveElementMicroTransactionable( connection, (RefFeatured) fromElement.get( connection.getSession( ) ),
                                                                                                                                                             (Attribute) endAndMetaObject.getMetaObject( workspace.getWorkspaceSet( ).getMoin( ) ).get( connection.getSession( ) ), index );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( mtx );
            returnValue = (E) mtx.getElementsRemoved( ).get( 0 );
        }
        return returnValue;
    }

    @Deprecated
    public boolean removeAll( Collection<?> elements ) {

        return this.removeAll( getCurrentConnection( ), elements );
    }

    public boolean removeAll( CoreConnection connection, Collection<?> elements ) {

        // TODO at super.removeAll and super.retainAll the logic in the JMI List Iterator Itr is used, try to move that logic into the TA framework
        // but clear does not go over that iterator, why?
        prepareWriteAccess( connection );
        boolean returnValue = true;
        if ( this.association ) {
            LinkRemoveElementMicroTransactionable mtx = getMicroTransactionableFactory( ).createLinkRemoveAllElementMicroTransactionable( connection, (Association) endAndMetaObject.getMetaObject( workspace.getWorkspaceSet( ).getMoin( ) ).get( connection.getSession( ) ),
                                                                                                                                          (RefObject) fromElement.get( connection.getSession( ) ), endAndMetaObject.getFromEnd( ), elements );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( mtx );
            returnValue = mtx.linkSetChanged( );
        } else {
            ObjectAttributeRemoveElementMicroTransactionable mtx = getMicroTransactionableFactory( ).createObjectAttributeRemoveAllElementMicroTransactionable( connection, (RefFeatured) fromElement.get( connection.getSession( ) ),
                                                                                                                                                                (Attribute) endAndMetaObject.getMetaObject( workspace.getWorkspaceSet( ).getMoin( ) ).get( connection.getSession( ) ), elements, true );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( mtx );
            returnValue = mtx.attributeChanged( );
        }
        return returnValue;
    }

    @Deprecated
    public boolean retainAll( Collection<?> elements ) {

        return this.retainAll( getCurrentConnection( ), elements );
    }

    public boolean retainAll( CoreConnection connection, Collection<?> elements ) {

        prepareWriteAccess( connection );
        Collection<Object> elementsToRemove = new ArrayList<Object>( );
        boolean isCollectionJmiList = ( elements instanceof JmiList );
        if ( ordered ) {
            for ( int i = 0, n = internalSize( ); i < n; i++ ) {
                CorePartitionable element = getElement( connection.getSession( ), i );
                boolean retain = isCollectionJmiList ? ( (JmiList) elements ).contains( connection, element ) : elements.contains( element );
                if ( !retain ) {
                    elementsToRemove.add( element );
                }
            }
        } else {
            for ( Iterator<E> it = internalReadOnlyIterator( connection.getSession( ) ); it.hasNext( ); ) {
                E element = it.next( );
                boolean retain = isCollectionJmiList ? ( (JmiList) elements ).contains( connection, element ) : elements.contains( element );
                if ( !retain ) {
                    elementsToRemove.add( element );
                }
            }
        }
        boolean returnValue = true;
        if ( this.association ) {
            LinkRemoveElementMicroTransactionable mtx = getMicroTransactionableFactory( ).createLinkRemoveAllElementMicroTransactionable( connection, (Association) endAndMetaObject.getMetaObject( workspace.getWorkspaceSet( ).getMoin( ) ).get( connection.getSession( ) ),
                                                                                                                                          (RefObject) fromElement.get( connection.getSession( ) ), endAndMetaObject.getFromEnd( ), elementsToRemove );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( mtx );
            returnValue = mtx.linkSetChanged( );
        } else {
            ObjectAttributeRemoveElementMicroTransactionable mtx = getMicroTransactionableFactory( ).createObjectAttributeRemoveAllElementMicroTransactionable( connection, (RefFeatured) fromElement.get( connection.getSession( ) ),
                                                                                                                                                                (Attribute) endAndMetaObject.getMetaObject( workspace.getWorkspaceSet( ).getMoin( ) ).get( connection.getSession( ) ), elementsToRemove,
                                                                                                                                                                true );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( mtx );
            returnValue = mtx.attributeChanged( );
        }
        return returnValue;
    }

    @Deprecated
    public void clear( ) {

        this.clear( getCurrentConnection( ) );
    }

    public void clear( CoreConnection connection ) {

        retainAll( connection, Collections.emptyList( ) );
    }

    private final void assertIndexForGetRemoveSet( int index ) {

        if ( index < 0 || ( index >= internalSize( ) ) ) {
            throw new MoinIndexOutOfBoundsException( index, internalSize( ) );
        }
    }

    private final void assertIndexForAdd( int index ) {

        if ( index < 0 || ( index > internalSize( ) ) ) {
            throw new MoinIndexOutOfBoundsException( index, internalSize( ) );
        }
    }

    @Deprecated
    public E get( int index ) {

        return get( getCurrentSession( ), index );
    }

    @SuppressWarnings( "unchecked" )
    public E get( CoreSession session, int index ) {

        prepareReadAccess( session );
        assertIndexForGetRemoveSet( index );
        return (E) getElement( session, index );
    }

    private final CorePartitionable getElement( CoreSession session, int index ) {

        CorePartitionable result = null;
        EndStorageLink link = getLink( index );
        if ( link != null ) {
            result = this.getToEnd( session, link );
        }
        return result;
    }

    protected CorePartitionable getToEnd( CoreSession session, EndStorageLink link ) {

        // in the "memory" case, the non-storage end (aka otherEnd) is the "toEnd"
        return getWithInconsistencyHandling( session, link, link.getEndNumberOfOtherEnd( ) );
    }

    protected CorePartitionable getWithInconsistencyHandling( CoreSession session, EndStorageLink link, int numberOfEndToGet ) {

        MoinReference endToGet = link.getEnd( numberOfEndToGet );
        CorePartitionable result = endToGet.getWithoutException( session );
        if ( result == null && session != null ) {
            // trigger inconsistency handling
            session.getConsistencyViolationRegistry( ).notifyDanglingLinkInconsistency( endToGet.getLri( ), link );
        }
        return result;
    }

    /**
     * Obtains the <tt>index</tt> -th link that lead from the model element
     * referenced by {@link #from} to an object in the association/attribute
     * identified by {@link #metaObject}. If <tt>index</tt> is negative or
     * greater than or equal to the number of objects contained in this list,
     * <tt>null</tt> is returned.
     */
    private EndStorageLink getLink( int index ) {

        EndStorageLink link = null;
        if ( this.linkCollection != null ) {
            if ( ordered ) {
                // we know that the underlying collection is a randomly
                // accessible List
                return ( (List<EndStorageLink>) this.linkCollection ).get( index );
            }
            Iterator<EndStorageLink> iter = linkCollection.iterator( );
            for ( int i = 0; i < index && iter.hasNext( ); i++ ) {
                iter.next( );
            }
            if ( iter.hasNext( ) ) {
                link = iter.next( );
            }
        }
        return link;
    }

    private final Collection<EndStorageLink> updateLinkCollectionIfNecessary( CoreSession session ) {

        if ( this.linkCollection == null ) {

            CorePartitionable fromElementResolved = this.fromElement.getWithoutException( session );
            if ( fromElementResolved == null ) {
                // couldn't be resolved, it is most likely that a revert took
                // place after repartitioning the from
                // element. Therefore, the mri was unresolved and due to the
                // revert it now cannot be resolved again.
                // Try to get it with the LRI only.
                fromElementResolved = this.resolveWithoutExceptionUsingLri( session );
                if ( fromElementResolved == null || ( !fromElementResolved.is___Alive( ) ) ) {
                    throw new InvalidObjectException( null, JmiCoreMessages.COLLECTIONINVALID, fromElement.getLri( ).toString( ) );
                }
                // fromElementResolved is not null and alive
                // We found the model element in a different partition. Ask
                // the ReferenceManager for an
                // up-to-date MriReference and update the fromElement.
                fromElement = this.workspace.getWorkspaceSet( ).getReferenceManager( ).getMriReference( fromElementResolved, workspace );
                // TODO what about the keying in the AbstractLinkManager as
                // this JmiList will still be found under
                // the "old" MRI (which is key)
            }
            this.linkCollection = ( (MemoryLinkManagerImpl) fromElementResolved.get___Workspace( ).getMemoryLinkManager( ) ).getLinkCollectionForEndAndMetaObject( session, endAndMetaObject, fromElementResolved );
        }
        return this.linkCollection;
    }

    private final CorePartitionable resolveWithoutExceptionUsingLri( CoreSession session ) {

        CorePartitionable result;
        LRI lri = fromElement.getLri( );
        result = workspace.getWorkspaceSet( ).resolveLri( session, lri );
        return result;
    }

    @Deprecated
    public int size( ) {

        return this.size( getCurrentSession( ) );
    }

    public int size( CoreSession session ) {

        prepareReadAccess( session );
        return internalSize( );
    }

    private final int internalSize( ) {

        if ( this.linkCollection != null ) {
            return linkCollection.size( );
        }
        return 0;
    }

    /**
     * Sets the link collection on which this JMI list is based. Used as a
     * callback whenever a new collection of {@link EndStorageLink}s is created
     * for the <tt>from</tt> object of this JMI list and the corresponding meta
     * object and end, or when that collection is dropped because it became
     * empty.
     */
    public final void setLinkCollection( Collection<EndStorageLink> linkCollection ) {

        this.linkCollection = linkCollection;
    }

    public final Collection<EndStorageLink> getLinkCollection( ) {

        return this.linkCollection;
    }

    /**
     * Returns an iterator that creates and delegates to an iterator on the
     * contained {@link #linkCollection}.
     */
    @Deprecated
    public Iterator<E> iterator( ) {

        return this.iterator( getCurrentConnection( ) );
    }

    public Iterator<E> iterator( CoreConnection connection ) {

        prepareWriteAccess( connection );
        return internalWritableIterator( connection );
    }

    protected Iterator<E> internalWritableIterator( CoreConnection connection ) {

        return new WritableIterator( connection );
    }

    public Iterator<E> iteratorReadOnly( CoreSession session ) {

        prepareReadAccess( session );
        return internalReadOnlyIterator( session );
    }

    protected Iterator<E> internalReadOnlyIterator( CoreSession session ) {

        return new ReadOnlyIterator( session );
    }



    /**
     * Iterator for JMI list that delegates to an iterator on the contained
     * {@link #linkCollection}.
     */
    private class ReadOnlyIterator implements Iterator<E> {

        /**
         * The index the current iterator is at.
         */
        protected int currentIndex = 0;



        /**
         * Index of element returned by most recent call to next or previous.
         * Reset to -1 if this element is deleted by a call to remove.
         */
        protected int lastRet = -1;

        /**
         * iterator delegating to the iterator of {@link JmiList#linkCollection}
         */
        protected Iterator<EndStorageLink> linkCollectionIterator;

        /**
         * current link of the iterator
         */
        protected EndStorageLink nextLink = null;

        protected final CoreSession session;

        /**
         * No args constructor which sets its {@link #linkCollectionIterator}
         * attribute to the iterator of the {@link JmiList#iterator()} if
         * {@link JmiList#linkCollection} is not null
         * 
         * @param connection
         */
        public ReadOnlyIterator( CoreSession session ) {

            this.session = session;
            if ( linkCollection != null ) {
                linkCollectionIterator = linkCollection.iterator( );
            }
        }

        /**
         * Returns true if the iteration has more elements. (In other words,
         * returns true if next would return an element rather than throwing an
         * exception.)
         * 
         * @return true if the iterator has more elements.
         */
        public boolean hasNext( ) {

            if ( linkCollectionIterator != null ) {
                return linkCollectionIterator.hasNext( );
            }
            return false;
        }

        /**
         * Returns the next element in the link collection by going to the next
         * link and getting the element at the toEnd
         * 
         * @return the next element in the iteration.
         * @throws NoSuchElementException iteration has no more elements
         */
        @SuppressWarnings( "unchecked" )
        public E next( ) {

            if ( linkCollectionIterator != null ) {
                this.nextLink = linkCollectionIterator.next( );
                lastRet = currentIndex++;
                E result = (E) getWithInconsistencyHandling( session, this.nextLink, this.nextLink.getEndNumberOfOtherEnd( ) );
                return result;
            }
            throw new NoSuchElementException( );
        }

        public void remove( ) {

            throw new MoinUnsupportedOperationException( CoreLinksMessages.CHANGINGNOTALLOWEDWITHTHISITERATOR );
        }
    }

    private class WritableIterator extends ReadOnlyIterator {

        protected final CoreConnection connection;

        /**
         * The number of remove calls.
         */
        private int removeCalls = 0;

        public WritableIterator( CoreConnection connection ) {

            super( connection.getSession( ) );
            this.connection = connection;
        }

        @Override
        public void remove( ) {

            if ( this.nextLink != null ) {
                MicroTransactionable mtx = null;
                if ( JmiListImpl.this.association ) {
                    mtx = getMicroTransactionableFactory( ).createLinkRemoveElementMicroTransactionable( connection, (Association) endAndMetaObject.getMetaObject( workspace.getWorkspaceSet( ).getMoin( ) ).get( connection.getSession( ) ), (RefObject) fromElement.get( connection.getSession( ) ),
                                                                                                         endAndMetaObject.getFromEnd( ), new IteratorKnowingCollection<EndStorageLink>( linkCollectionIterator, linkCollection ), currentIndex - removeCalls );
                } else {
                    mtx = getMicroTransactionableFactory( ).createObjectAttributeRemoveElementMicroTransactionable( connection, (RefFeatured) fromElement.get( connection.getSession( ) ),
                                                                                                                    (Attribute) endAndMetaObject.getMetaObject( workspace.getWorkspaceSet( ).getMoin( ) ).get( connection.getSession( ) ),
                                                                                                                    new IteratorKnowingCollection<EndStorageLink>( linkCollectionIterator, linkCollection ), currentIndex - removeCalls );
                }
                connection.getSession( ).getTransactionManager( ).runInMicroTransaction( mtx );
            } else {
                throw new MoinIllegalStateException( CoreLinksMessages.ITERATORREMOVECALLEDBEFORENEXT );
            }
            this.nextLink = null;
            removeCalls++;
            lastRet = -1;
        }
    }


    private class WritableListIterator extends WritableIterator implements ListIterator<E> {

        /**
         * The modCount value that the iterator believes that the backing List
         * should have. If this expectation is violated, the iterator has
         * detected concurrent modification.
         */
        int expectedModCount = modCount;

        WritableListIterator( CoreConnection connection, int index ) {

            super( connection );
            if ( ordered && linkCollection != null ) {
                linkCollectionIterator = ( (List) linkCollection ).listIterator( index );
            }
            currentIndex = index;
        }

        @Override
        public void remove( ) {

            if ( lastRet == -1 ) {
                throw new IllegalStateException( );
            }
            super.remove( );
        }

        public boolean hasPrevious( ) {

            return currentIndex != 0;
        }

        public E previous( ) {

            checkForComodification( );
            try {
                int i = currentIndex - 1;
                EndStorageLink previousLink = ( (ListIterator<EndStorageLink>) linkCollectionIterator ).previous( );

                E result = (E) getWithInconsistencyHandling( session, previousLink, previousLink.getEndNumberOfOtherEnd( ) );
                lastRet = currentIndex = i;
                return result;
            } catch ( IndexOutOfBoundsException e ) {
                checkForComodification( );
                throw new NoSuchElementException( );
            }
        }

        public int nextIndex( ) {

            return currentIndex;
        }

        public int previousIndex( ) {

            return currentIndex - 1;
        }

        public void set( E o ) {

            if ( lastRet == -1 ) {
                throw new IllegalStateException( );
            }
            checkForComodification( );
            try {
                JmiListImpl.this.set( connection, lastRet, o );
                expectedModCount = modCount;
            } catch ( IndexOutOfBoundsException e ) {
                throw new ConcurrentModificationException( );
            }
        }

        public void add( E o ) {

            checkForComodification( );
            try {
                JmiListImpl.this.add( connection, currentIndex, o );
                currentIndex++;
                lastRet = -1;
                expectedModCount = modCount;
            } catch ( IndexOutOfBoundsException e ) {
                throw new ConcurrentModificationException( );
            }
        }

        private final void checkForComodification( ) {

            if ( modCount != expectedModCount ) {
                throw new ConcurrentModificationException( );
            }
        }
    }

    /**
     * Is called before every read/write access to give subclasses the
     * possibility to hook in.
     * 
     * @param connection
     */
    protected void prepareReadAccess( CoreSession session ) {

        this.updateLinkCollectionIfNecessary( session );
    }

    protected void prepareWriteAccess( CoreConnection connection ) {

        this.prepareReadAccess( connection.getSession( ) );
    }

    public boolean isValid( ) {

        return valid;
    }

    public void invalidate( ) {

        valid = false;
    }

    public final EndAndMetaObject getEndAndMetaObject( ) {

        return endAndMetaObject;
    }

    public EndStorageLinkManager getLinkManager( CoreConnection connection ) {

        return workspace.getMemoryLinkManager( );
    }

    public boolean isDistributed( ) {

        return false;
    }
}

@SuppressWarnings( "unchecked" )
final class SubList<E> extends JmiListImpl<E> {

    protected JmiListImpl<E> l;

    protected int offset;

    protected int size;

    protected int expectedModCount;

    SubList( CoreSession session, JmiListImpl<E> list, int fromIndex, int toIndex ) {

        super( session, list.endAndMetaObject, list.fromElement, list.workspace );
        if ( fromIndex < 0 ) {
            throw new MoinIndexOutOfBoundsException( CoreLinksMessages.FROMINDEX, fromIndex );
        }
        if ( toIndex > list.size( session ) ) {
            throw new MoinIndexOutOfBoundsException( CoreLinksMessages.TOINDEX, toIndex );
        }
        if ( fromIndex > toIndex ) {
            throw new MoinIllegalArgumentException( CoreLinksMessages.FROMINDEX_GT_TOINDEX, fromIndex, toIndex );
        }
        l = list;
        offset = fromIndex;
        size = toIndex - fromIndex;
        expectedModCount = l.modCount;
    }

    @Override
    public boolean isValid( ) {

        return super.isValid( ) && l.isValid( );
    }



    @Override
    public boolean contains( CoreConnection connection, Object o ) {

        int index = indexOf( connection, o );
        return index >= offset && index < offset + size;
    }

    @Override
    public E set( CoreConnection connection, int index, E element ) {

        rangeCheck( index );
        checkForComodification( );
        return l.set( connection, index + offset, element );
    }

    @Override
    public E get( CoreSession session, int index ) {

        rangeCheck( index );
        checkForComodification( );
        return l.get( session, index + offset );
    }

    @Override
    public int size( CoreSession session ) {

        checkForComodification( );
        return size;
    }

    @Override
    public void clear( CoreConnection connection ) {

        checkForComodification( );
        int oldSize = size;
        for ( int index = 0; index < oldSize; index++ ) {
            l.remove( connection, offset );
            expectedModCount = l.modCount;
            size--;
            modCount++;
        }
    }

    @Override
    public void add( CoreConnection connection, int index, E element ) {

        if ( index < 0 || index > size ) {
            throw new IndexOutOfBoundsException( );
        }
        checkForComodification( );
        l.add( connection, index + offset, element );
        expectedModCount = l.modCount;
        size++;
        modCount++;
    }

    @Override
    public E remove( CoreConnection connection, int index ) {

        rangeCheck( index );
        checkForComodification( );
        E result = l.remove( connection, index + offset );
        expectedModCount = l.modCount;
        size--;
        modCount++;
        return result;
    }

    @Override
    public boolean addAll( CoreConnection connection, Collection<? extends E> c ) {

        return addAll( connection, size, c );
    }

    @Override
    public boolean addAll( CoreConnection connection, int index, Collection<? extends E> c ) {

        if ( index < 0 || index > size ) {
            throw new MoinIndexOutOfBoundsException( index, size );
        }
        int cSize = c.size( );
        if ( cSize == 0 ) {
            return false;
        }
        checkForComodification( );
        l.addAll( connection, offset + index, c );
        expectedModCount = l.modCount;
        size += cSize;
        modCount++;
        return true;
    }

    @Override
    public Iterator<E> iterator( CoreConnection connection ) {

        return listIterator( connection, offset );
    }

    @Override
    public ListIterator<E> listIterator( final CoreConnection connection, final int index ) {

        checkForComodification( );
        if ( index < offset || index >= offset + size ) {
            throw new MoinIndexOutOfBoundsException( index, size );
        }
        return new ListIterator<E>( ) {

            private ListIterator<E> i = l.listIterator( connection, index );

            public boolean hasNext( ) {

                return nextIndex( ) < offset + size;
            }

            public E next( ) {

                if ( hasNext( ) ) {
                    return i.next( );
                }
                throw new NoSuchElementException( );
            }

            public boolean hasPrevious( ) {

                return previousIndex( ) >= 0;
            }

            public E previous( ) {

                if ( hasPrevious( ) ) {
                    return i.previous( );
                }
                throw new NoSuchElementException( );
            }

            public int nextIndex( ) {

                return i.nextIndex( );
            }

            public int previousIndex( ) {

                return i.previousIndex( );
            }

            public void remove( ) {

                i.remove( );
                expectedModCount = l.modCount;
                size--;
                modCount++;
            }

            public void set( E o ) {

                i.set( o );
            }

            public void add( E o ) {

                i.add( o );
                expectedModCount = l.modCount;
                size++;
                modCount++;
            }
        };
    }

    @Override
    public JmiList<E> subList( CoreConnection connection, int fromIndex, int toIndex ) {

        return new SubList<E>( connection.getSession( ), this, fromIndex, toIndex );
    }

    private void rangeCheck( int index ) {

        if ( index < 0 || index >= size ) {
            throw new MoinIndexOutOfBoundsException( index, size );
        }
    }

    private void checkForComodification( ) {

        if ( l.modCount != expectedModCount ) {
            throw new ConcurrentModificationException( );
        }
    }
}
