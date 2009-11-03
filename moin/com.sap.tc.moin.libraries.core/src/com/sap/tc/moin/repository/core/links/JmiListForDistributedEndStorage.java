/*
 * Created on 17.03.2005
 */
package com.sap.tc.moin.repository.core.links;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndAndMetaObject;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.MriReference;
import com.sap.tc.moin.repository.core.QueryLinkManager;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.shared.util.EmptyIterator;
import com.sap.tc.moin.repository.shared.util.WeakSet;
import com.sap.tc.moin.repository.spi.facility.SpiPersistence;
import com.sap.tc.moin.repository.transactions.microtransactionables.LinkRemoveElementMicroTransactionable;

/**
 * This specialization of {@link JmiList} can be used to manage the link set
 * connected to a model element by an end that doesn't have storage on that end.
 * An example is the list that has to be constructed when asking a
 * {@link com.sap.tc.moin.repository.mmi.model.ModelElement} for its attached
 * {@link com.sap.tc.moin.repository.mmi.model.Tag}s. The corresponding association has storage only
 * on the tag's side. Therefore, a query to the {@link SpiPersistence} is
 * required to obtain an authoritative answer regarding the link set.
 * <p>
 * As compared to {@link JmiList}, this implementation incurs a significantly
 * increased runtime penalty due to the access to the persistence layer that it
 * requires. It should therefore only be used when constructing a collection for
 * an association end that doesn't have local storage.
 * 
 * @author D044771, D046074
 */
public class JmiListForDistributedEndStorage extends JmiListImpl {

    /**
     * Flag which indicates if this collection has been changed and therefore
     * has to reload its contents.
     */
    private boolean dirty = true;

    /**
     * Iterator which is used if the backing collection is empty.
     */
    protected final static Iterator EMPTY_ITERATOR = new EmptyIterator( "JmiListForDistributedEndStorage iterator" ); //$NON-NLS-1$

    /**
     * Structure for holding the given out iterators as we must have the
     * possibility to invalidate them.
     */
    private WeakSet iterators;

    public JmiListForDistributedEndStorage( CoreSession session, EndAndMetaObject endAndMetaObject, MriReference fromElement, Workspace workspace ) {

        super( session, endAndMetaObject, fromElement, workspace );
    }

    // -----------------------------------------------------------------------------------------------------------------


    private void manageIterator( ManageableIterator iterator ) {

        if ( this.iterators == null ) {
            // lazy initialization of the set as it might not be needed at all
            this.iterators = new WeakSet( );
        }
        // remember the iterator in order to be able to invalidate it later
        this.iterators.add( iterator );
    }

    @Override
    protected Iterator internalWritableIterator( CoreConnection connection ) {

        WritableIteratorForDistributedEndStorage result = new WritableIteratorForDistributedEndStorage( connection );
        manageIterator( result );
        return result;
    }

    @Override
    protected Iterator internalReadOnlyIterator( CoreSession session ) {

        ReadOnlyIteratorForDistributedEndStorage result = new ReadOnlyIteratorForDistributedEndStorage( session );
        manageIterator( result );
        return result;
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Method to inform this list that its current contents are no longer valid.
     */
    public void invalidate( Iterator iteratorWhichDidTheChange ) {

        this.invalidateIterators( iteratorWhichDidTheChange );
        this.dirty = true; // this will lead to a new query on next access
    }



    @Override
    protected final void prepareReadAccess( CoreSession session ) {

        this.prepareReadWriteAccess( session );
    }

    @Override
    protected final void prepareWriteAccess( CoreConnection connection ) {

        this.prepareReadWriteAccess( connection != null ? connection.getSession( ) : null );
    }

    private void prepareReadWriteAccess( CoreSession session ) {

        if ( this.dirty ) {
            Collection<EndStorageLink> links = null;
            links = queryLinks( session );
            this.setLinkCollection( links );
            this.dirty = false;
        }
    }

    @Override
    protected CorePartitionable getToEnd( CoreSession session, EndStorageLink link ) {

        // in the distributed end storage case, it is always the storageEnd
        // which is the "toEnd"
        return getWithInconsistencyHandling( session, link, link.getEndNumberOfStorageEnd( ) );
    }

    /**
     * Invalidates all given out iterators of this list.
     */
    private void invalidateIterators( Iterator iteratorWhichDidTheChange ) {

        if ( this.iterators != null ) {
            for ( Iterator iteratorsOfThisList = this.iterators.iterator( ); iteratorsOfThisList.hasNext( ); ) {
                ManageableIterator givenOutIterator = (ManageableIterator) iteratorsOfThisList.next( );
                givenOutIterator.invalidate( iteratorWhichDidTheChange );
                if ( givenOutIterator.isTouched( ) ) {
                    // this iterator will no longer be useful for anybody,
                    // because it will
                    // throw an exception on any access method as it was
                    // touched, but the
                    // backing link set was changed. Therefore, it is
                    // permanently invalid
                    // and can be removed from the set of iterators.
                    iteratorsOfThisList.remove( );
                }

            }
        }
    }

    private Collection<EndStorageLink> queryLinks( CoreSession session ) {

        CorePartitionable resolvedFromElement = this.fromElement.getWithoutException( session );
        if ( resolvedFromElement == null ) {
            // if it can't be resolved, it seems to have been deleted, so there
            // can't be any more links
            return null;
        }
        QueryLinkManager queryLinkManager = this.workspace.getQueryLinkManager( );
        boolean ignorePersistence = false;

        //FIXME HACK!!! reimplement logic at session instead of connection
//        if ( connection.isNewElement( resolvedFromElement ) ) {
//            // the element has not been stored yet, therefore there can't be any
//            // elements in the persistence linking to
//            // it, therefore persistence can be ignored
//            ignorePersistence = true;
//        }

        // the collection of MRIs consists both of the persisted ones and those
        // of the current dirty state of the
        // connection
        Collection<EndStorageLink> result = queryLinkManager.getLinksForEndAndMetaObject( session, this.endAndMetaObject, resolvedFromElement, ignorePersistence );

        return result;
    }

    @Override
    public QueryLinkManager getLinkManager( CoreConnection connection ) {

        return workspace.getQueryLinkManager( );
    }

    private interface ManageableIterator {

        public boolean isTouched( );

        public void invalidate( Iterator iteratorWhichDidTheChange );
    }

    @Override
    public boolean isDistributed( ) {

        return true;
    }


    public void setFromElement( MriReference newFromElement ) {

        this.fromElement = newFromElement;
    }

    private class ReadOnlyIteratorForDistributedEndStorage implements Iterator, ManageableIterator {

        /**
         * The backing iterator.
         */
        protected Iterator linkCollectionIterator = null;

        /**
         * Flag to indicate if next() has been called before remove(), because
         * if not, an exception must be thrown.
         */
        protected boolean nextWasCalled = false;


        /**
         * Flag to indicate if this iterator is still valid or if the underlying
         * collection has changed (i.e. then it is invalid).
         */
        private boolean valid = true;

        /**
         * Flag to tell if this iterator is initialized. This will only once be
         * set to <code>true</code> and never again to <code>false</code>.
         */
        private boolean initialized = false;

        /**
         * Flag to indicate if this iterator was touched (i.e. one of its
         * interface methods were already called).
         */
        protected boolean touched = false;

        /**
         * The current link of this iterator.
         */
        protected EndStorageLink currentLink = null;

        protected final CoreSession session;

        public ReadOnlyIteratorForDistributedEndStorage( CoreSession session ) {

            this.session = session;
        }

        public boolean hasNext( ) {

            checkConcurrentModification( session );
            this.touched = true;
            return this.linkCollectionIterator.hasNext( );
        }

        public Object next( ) {

            checkConcurrentModification( session );
            this.touched = true;
            this.nextWasCalled = true;
            this.currentLink = (EndStorageLink) this.linkCollectionIterator.next( );
            return getToEnd( session, this.currentLink );
        }

        public void remove( ) {

            throw new MoinUnsupportedOperationException( CoreLinksMessages.CHANGINGNOTALLOWEDWITHTHISITERATOR );
        }

        /**
         * Tells if this iterator was already "touched", i.e. one of its
         * interface methods have been called.
         * 
         * @return <code>true</code> if already touched, <code>false</code>
         * otherwise.
         */
        public boolean isTouched( ) {

            return touched;
        }

        /**
         * Method to inform this iterator that it is no longer valid.
         */
        public void invalidate( Iterator iteratorWhichDidTheChange ) {

            if ( this != iteratorWhichDidTheChange ) {
                this.valid = false;
            }
        }

        /**
         * Checks if there were modifications which affected this list. If
         * that's the case and the iterator wasn't touched yet, the backing list
         * is dynamically recalculated and this iterator can be used. If it was
         * touched already, {@link ConcurrentModificationException} is thrown.
         */
        protected void checkConcurrentModification( CoreSession session ) {

            if ( !valid ) {// something has changed in the backing links
                if ( touched ) {
                    throw new ConcurrentModificationException( );
                } else {
                    this.refreshContentIfNecessary( session );
                    valid = true;
                }
            } else {
                if ( !initialized ) {
                    this.refreshContentIfNecessary( session );
                    initialized = true;
                }
            }

        }

        private void refreshContentIfNecessary( CoreSession session ) {

            prepareReadAccess( session );// with this call, we make sure, that
            // the link collection is either already
            // set or will be set now (by executing a new query)
            if ( getLinkCollection( ) != null ) {
                this.linkCollectionIterator = getLinkCollection( ).iterator( );
            } else {
                this.linkCollectionIterator = EMPTY_ITERATOR;
            }
        }
    }

    private class WritableIteratorForDistributedEndStorage extends ReadOnlyIteratorForDistributedEndStorage {

        private CoreConnection connection;

        public WritableIteratorForDistributedEndStorage( CoreConnection connection ) {

            super( connection != null ? connection.getSession( ) : null );
            this.connection = connection;
        }


        @Override
        public void remove( ) {

            checkConcurrentModification( session );
            if ( !nextWasCalled ) {
                throw new MoinIllegalStateException( CoreLinksMessages.ITERATORREMOVECALLEDBEFORENEXT );
            }
            LinkRemoveElementMicroTransactionable mtx = getMicroTransactionableFactory( ).createLinkRemoveElementMicroTransactionable( connection, (Association) endAndMetaObject.getMetaObject( workspace.getWorkspaceSet( ).getMoin( ) ).get( connection.getSession( ) ),
                                                                                                                                       (RefObject) fromElement.get( connection.getSession( ) ), endAndMetaObject.getFromEnd( ), getToEnd( connection.getSession( ), currentLink ) );
            connection.getSession( ).getTransactionManager( ).runInMicroTransaction( mtx );

            this.linkCollectionIterator.remove( );
            this.touched = true;
            this.nextWasCalled = false;
        }
    }
}