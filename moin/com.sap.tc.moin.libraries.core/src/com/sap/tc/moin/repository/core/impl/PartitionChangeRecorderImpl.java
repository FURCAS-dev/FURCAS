package com.sap.tc.moin.repository.core.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndAndMetaObject;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.MriReference;
import com.sap.tc.moin.repository.core.PartitionChangeRecorder;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.jmi.extension.RefFeaturedExtension;
import com.sap.tc.moin.repository.core.jmi.reflect.RefFeaturedImpl;
import com.sap.tc.moin.repository.spi.core.SpiEndAndMetaObject;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.SpiLink;
import com.sap.tc.moin.repository.spi.core.SpiModelPartition;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionDelta;
import com.sap.tc.moin.repository.spi.util.SpiMutableInteger;

/**
 * If a model partition has already been stored to the persistence, subsequent
 * storage might be accelerated substantially (depending on the capabilities of
 * the persistence implementation) by only storing the delta between the current
 * in-memory state and the persistent state. On-demand computation of this delta
 * is performed by the {@link PartitionChangeRecorder}.
 * <p>
 * It accomplishes this by continuously recording each single change during the
 * modification of the model. When a delta is requested via
 * {@link #getDeltaForPartition(SpiModelPartition)} (usually during the
 * {@link Connection#save()} call, but also for example via JMX), the collected
 * information is condensed and the delta is returned.
 */
public final class PartitionChangeRecorderImpl implements PartitionChangeRecorder {

    private static class KeyTuple<K1 extends MRI, K2 extends Partitionable> {

        K1 mri;

        K2 cp;

        protected KeyTuple( K1 key1, K2 key2 ) {

            this.mri = key1;
            this.cp = key2;
        }

        protected K2 getCorePartitionable( ) {

            return this.cp;
        }
    }

    /**
     * Maps a model partition to its computed delta.
     */
    private Map<CoreModelPartition, PartitionDeltaImpl> partitionDeltas;

    /**
     * If an already existing (i.e. not newly created) model element was
     * re-assigned from a persistent partition to a different partition, or
     * stems from a persistent partition and was deleted, this map stores its
     * original partition, its "persistent home partition".
     * <p>
     * See also:
     * {@link #elementAssigned(CoreModelPartition, CoreModelPartition, CorePartitionable)}
     */
    private Map<KeyTuple<MRI, CorePartitionable>, CoreModelPartition> persistentHomeOfElement;

    /**
     * If an already existing (i.e. not newly created) model element was
     * re-assigned from a transient partition to a different partition, this map
     * stores its original partition, its "transient home partition".
     * <p>
     * See also:
     * {@link #elementAssigned(CoreModelPartition, CoreModelPartition, CorePartitionable)}
     */
    private Map<KeyTuple<MRI, CorePartitionable>, CoreModelPartition> transientHomeOfElement;

    /**
     * This map holds for each model element the names of those attributes whose
     * value has changed, plus the original value prior to the very first
     * modification of an attribute. This value, the "persistent value", is
     * required during delta computation to determine whether the current value
     * of an attribute actually differs from the persistent one.
     */
    private Map<KeyTuple<MRI, CorePartitionable>, Map<String /* attributeName */, Object /* persistentValue */>> changedAttributes;

    /**
     * This map counts the number of creations of a given model element (note
     * that creations can be undone and redone in command scenarios; thus, the
     * same model element can theoretically be created any number of times).
     */
    private Map<KeyTuple<MRI, CorePartitionable>, SpiMutableInteger> createdElements;

    /**
     * This map counts the number of deletions of a given model element (note
     * that deletions can be undone and redone in command scenarios; thus, the
     * same model element can theoretically be deleted any number of times).
     */
    private Map<KeyTuple<MRI, CorePartitionable>, SpiMutableInteger> deletedElements;

    /**
     * 
     */
    private Map<MRI, KeyTuple<MRI, CorePartitionable>> mriToKeyTuples;

    /**
     * This map counts the number of additions of a given link (note that link
     * additions can be undone and redone using both regular JMI calls and
     * commands; thus, the same link can theoretically be added any number of
     * times).
     */
    private Map<SpiLink, SpiMutableInteger> addedLinks;

    /**
     * This map counts the number of removals of a given link (note that link
     * removals can be undone and redone using both regular JMI calls and
     * commands; thus, the same link can theoretically be removed any number of
     * times).
     */
    private Map<SpiLink, SpiMutableInteger> removedLinks;

    /**
     * This map stores the original links of ordered link collections prior to
     * the first modification. It is required to accurately produce
     * modifiedOrderedLinkCollection deltas if links change their list position
     * only. Without this information, a move of a link from position x to
     * position y within the same link collection would not appear in the delta
     * at all, because the link removal and addition would eliminate each other.
     */
    private Map<MRI, Map<SpiEndAndMetaObject, List<SpiLink>>> persistentOrderedLinkCollections;

    /**
     * Whether a re-computation of all deltas is necessary or not. Directly
     * after a computation, this flag is set to <code>true</code>, and each
     * subsequent model change resets it to <code>false</code>.
     */
    private boolean deltasUpToDate;

    private final CoreConnection connection;

    PartitionChangeRecorderImpl( CoreConnection connection ) {

        this.connection = connection;
        initCollections( );
    }

    /**
     * Resets the {@link PartitionChangeRecorder}'s internal state. This method
     * is usually called after {@link Connection#save()} and
     * {@link Connection#revert()}.
     */
    public void clear( ) {

        initCollections( );
    }

    /**
     * (Re-)Initializes the internal state.
     */
    private void initCollections( ) {

        partitionDeltas = new LinkedHashMap<CoreModelPartition, PartitionDeltaImpl>( );
        persistentHomeOfElement = new IdentityHashMap<KeyTuple<MRI, CorePartitionable>, CoreModelPartition>( );
        transientHomeOfElement = new IdentityHashMap<KeyTuple<MRI, CorePartitionable>, CoreModelPartition>( );
        changedAttributes = new IdentityHashMap<KeyTuple<MRI, CorePartitionable>, Map<String, Object>>( );
        createdElements = new IdentityHashMap<KeyTuple<MRI, CorePartitionable>, SpiMutableInteger>( );
        deletedElements = new IdentityHashMap<KeyTuple<MRI, CorePartitionable>, SpiMutableInteger>( );
        mriToKeyTuples = new LinkedHashMap<MRI, KeyTuple<MRI, CorePartitionable>>( );
        addedLinks = new LinkedHashMap<SpiLink, SpiMutableInteger>( );
        removedLinks = new LinkedHashMap<SpiLink, SpiMutableInteger>( );
        persistentOrderedLinkCollections = new LinkedHashMap<MRI, Map<SpiEndAndMetaObject, List<SpiLink>>>( );
        deltasUpToDate = true;
    }

    private KeyTuple<MRI, CorePartitionable> getElemKey( MRI mri, CorePartitionable element ) {

        KeyTuple<MRI, CorePartitionable> elemKey = mriToKeyTuples.get( mri );
        if ( elemKey == null ) {
            elemKey = new KeyTuple<MRI, CorePartitionable>( mri, element );
            mriToKeyTuples.put( mri, elemKey );
        } else {
            elemKey.cp = element;
        }
        return elemKey;
    }

    public void attributeValueChanged( CorePartitionable element, String attributeName, Object oldValue ) {

        KeyTuple<MRI, CorePartitionable> elemKey = this.getElemKey( element.get___Mri( ), element );
        if ( createdElements.containsKey( elemKey ) ) {
            // Do not record attribute changes if we know that the element has just been created.
            return;
        }
        deltasUpToDate = false;
        Map<String, Object> map = changedAttributes.get( elemKey );
        if ( map == null ) {
            changedAttributes.put( elemKey, map = new LinkedHashMap<String, Object>( 4 ) );
            map.put( attributeName, oldValue );
        } else {
            if ( !map.containsKey( attributeName ) ) {
                // Store the old value only on the very first call!
                map.put( attributeName, oldValue );
            }
        }
    }

    public void elementAssigned( CoreModelPartition oldPartition, CoreModelPartition newPartition, CorePartitionable element ) {

        KeyTuple<MRI, CorePartitionable> elemKey = getElemKey( oldPartition.getPri( ).createMri( element.refMofId( ) ), element );
        deltasUpToDate = false;
        if ( !connection.isNewElement( element ) ) {
            // Newly created elements are no candidates for persistent/transientHomeOfElement.
            if ( oldPartition.isPersisted( ) && !persistentHomeOfElement.containsKey( elemKey ) && !transientHomeOfElement.containsKey( elemKey ) ) {
                // When a persisted element is assigned to a different partition for the very first time, remember its "persistent home partition".
                persistentHomeOfElement.put( elemKey, oldPartition );
            }
            if ( oldPartition.getPri( ).isVolatilePartition( ) && !oldPartition.getPri( ).isNullPartition( ) && !transientHomeOfElement.containsKey( elemKey ) && !persistentHomeOfElement.containsKey( elemKey ) ) {
                // When a transient element is assigned to a different partition for the very first time, remember its "transient home partition".
                transientHomeOfElement.put( elemKey, oldPartition );
            }
        }
        this.mriToKeyTuples.remove( elemKey.mri );
        elemKey.mri = element.get___Mri( ); // set the new location in the key tuple
        KeyTuple<MRI, CorePartitionable> oldElemKey;
        if ( ( oldElemKey = this.mriToKeyTuples.put( elemKey.mri, elemKey ) ) != null ) {
            /*
             * This occurs if there was already an element with the same MRI
             * that has been deleted. The KeyTuple for an MRI must be unique in
             * the system. Therefore the old one has to be replaced with the new
             * one. An example is the deletion and recreation of an element with
             * calculated MofId. This code is also executed in case of undo of a
             * deletion. The reason is, that elements can only be created in the
             * null partition and then be moved into another partition. The
             * first MRI of an newly created element points to the null
             * partition, so although the MRIs of an deleted and the created
             * element are equal after moving the new element into the right
             * partition, a new KeyTuple will be created for the
             * null-partition-MRI. So, after moving there will be two KeyTuple
             * instances with the same MRI. Since it is possible to move an
             * element back to the null partition, it is NOT sufficient to check
             * if the source partition is the null partition and then take the
             * old KeyTuple as key. The new KeyTuple might already be added to
             * multiple tables.
             */
            this.replaceOldWithNewElemKeyInstance( oldElemKey, elemKey );
        }
    }

    private void replaceOldWithNewElemKeyInstance( KeyTuple<MRI, CorePartitionable> oldElemKey, KeyTuple<MRI, CorePartitionable> newElemKey ) {

        CoreModelPartition persisted = persistentHomeOfElement.remove( oldElemKey );
        if ( persisted != null ) {
            persistentHomeOfElement.put( newElemKey, persisted );
        }
        CoreModelPartition trans = transientHomeOfElement.remove( oldElemKey );
        if ( trans != null ) {
            transientHomeOfElement.put( newElemKey, trans );
        }
        Map<String, Object> changed = changedAttributes.remove( oldElemKey );
        if ( changed != null ) {
            changedAttributes.put( newElemKey, changed );
        }
        SpiMutableInteger created = createdElements.remove( oldElemKey );
        if ( created != null ) {
            createdElements.put( newElemKey, created );
        }
        SpiMutableInteger deleted = deletedElements.remove( oldElemKey );
        if ( deleted != null ) {
            deletedElements.put( newElemKey, deleted );
        }
    }

    public void elementCreated( CorePartitionable element ) {

        deltasUpToDate = false;
        KeyTuple<MRI, CorePartitionable> elemKey = this.getElemKey( element.get___Mri( ), element );
        SpiMutableInteger count = createdElements.remove( elemKey );
        if ( count != null ) {
            count.increment( );
        } else {
            count = new SpiMutableInteger( 1 );
        }
        createdElements.put( elemKey, count );
    }

    public void undoElementCreated( CorePartitionable element ) {

        deltasUpToDate = false;
        KeyTuple<MRI, CorePartitionable> elemKey = this.getElemKey( element.get___Mri( ), element );
        SpiMutableInteger count = createdElements.get( elemKey );
        if ( count.getValue( ) > 1 ) {
            count.decrement( );
        } else {
            createdElements.remove( elemKey );
        }
    }

    public void elementDeleted( CorePartitionable element ) {

        deltasUpToDate = false;
        KeyTuple<MRI, CorePartitionable> elemKey = this.getElemKey( element.get___Mri( ), element );
        SpiMutableInteger count = deletedElements.remove( elemKey );
        if ( count != null ) {
            count.increment( );
        } else {
            count = new SpiMutableInteger( 1 );
        }
        deletedElements.put( elemKey, count );
        if ( count.getValue( ) == 1 ) {
            // This must be the first deletion of this element. If its original (!) partition is persisted, record that partition
            // (if not already recorded as the result of a partition re-assignment).
            CoreModelPartition partition = element.get___Partition( );
            if ( partition.isPersisted( ) && !persistentHomeOfElement.containsKey( elemKey ) ) {
                persistentHomeOfElement.put( elemKey, partition );
            } else if ( partition.getPri( ).isVolatilePartition( ) && !partition.getPri( ).isNullPartition( ) && !transientHomeOfElement.containsKey( elemKey ) ) {
                transientHomeOfElement.put( elemKey, partition );
            }
        }
    }

    public void undoElementDeleted( CorePartitionable element ) {

        deltasUpToDate = false;
        KeyTuple<MRI, CorePartitionable> elemKey = this.getElemKey( element.get___Mri( ), element );
        SpiMutableInteger count = deletedElements.get( elemKey );
        if ( count.getValue( ) > 1 ) {
            count.decrement( );
        } else {
            deletedElements.remove( elemKey );
        }
    }

    public void linkAdded( EndStorageLink link ) {

        deltasUpToDate = false;
        SpiMutableInteger count = addedLinks.remove( link );
        if ( count != null ) {
            count.increment( );
        } else {
            count = new SpiMutableInteger( 1 );
        }
        addedLinks.put( link, count );
        if ( isOrdered( link ) ) {
            storePersistentOrderedLinkCollection( link );
        }
    }

    public void undoLinkAdded( EndStorageLink link ) {

        deltasUpToDate = false;
        SpiMutableInteger count = addedLinks.get( link );
        if ( count.getValue( ) > 1 ) {
            count.decrement( );
        } else {
            addedLinks.remove( link );
        }
    }

    public void linkRemoved( EndStorageLink link ) {

        deltasUpToDate = false;
        SpiMutableInteger count = removedLinks.remove( link );
        if ( count != null ) {
            count.increment( );
        } else {
            count = new SpiMutableInteger( 1 );
        }
        removedLinks.put( link, count );
        if ( isOrdered( link ) ) {
            storePersistentOrderedLinkCollection( link );
        }
    }

    public void undoLinkRemoved( EndStorageLink link ) {

        deltasUpToDate = false;
        SpiMutableInteger count = removedLinks.get( link );
        if ( count.getValue( ) > 1 ) {
            count.decrement( );
        } else {
            removedLinks.remove( link );
        }
    }

    public SpiPartitionDelta getDeltaForPartition( SpiModelPartition partition ) {

        if ( !deltasUpToDate ) {
            computeDeltas( );
        }
        return getOrCreateDelta( (CoreModelPartition) partition );
    }

    private void storePersistentOrderedLinkCollection( SpiLink link ) {

        EndStorageLink endStorageLink = (EndStorageLink) link;
        int orderedEnd = endStorageLink.getOrderedEnd( );
        int storageEnd = endStorageLink.getEndNumberOfStorageEnd( );
        if ( orderedEnd != storageEnd ) {
            Workspace workspace = connection.getSession( ).getWorkspace( );
            EndAndMetaObject endAndMetaObject = workspace.getWorkspaceSet( ).getEndAndMetaObjectPool( ).getEndAndMetaObject( link.getEndNumberOfStorageEnd( ), endStorageLink.getMetaObject( ) );
            MRI mriOfElementAtStorageEnd = endStorageLink.getStorageEnd( ).getMri( );
            MRI mriForMap = mriOfElementAtStorageEnd;
            if ( mriOfElementAtStorageEnd.getPri( ).isVolatilePartition( ) ) {
                for ( Entry<KeyTuple<MRI, CorePartitionable>, CoreModelPartition> entry : persistentHomeOfElement.entrySet( ) ) {
                    KeyTuple<MRI, CorePartitionable> elemKey = entry.getKey( );
                    if ( elemKey.mri.equals( mriOfElementAtStorageEnd ) ) {
                        mriForMap = entry.getValue( ).getPri( ).createMri( mriOfElementAtStorageEnd.getMofId( ) );
                        break;
                    }
                }
            }
            Map<SpiEndAndMetaObject, List<SpiLink>> mapOfLinkCollections = persistentOrderedLinkCollections.get( mriForMap );
            if ( mapOfLinkCollections != null && mapOfLinkCollections.containsKey( endAndMetaObject ) ) {
                // We already recorded this link collection.
                return;
            }
            Collection<EndStorageLink> linksForEndAndMetaObject = workspace.getMemoryLinkManager( ).getLinksForEndAndMetaObject( connection.getSession( ), endAndMetaObject, mriOfElementAtStorageEnd );
            if ( mapOfLinkCollections == null ) {
                persistentOrderedLinkCollections.put( mriForMap, mapOfLinkCollections = new LinkedHashMap<SpiEndAndMetaObject, List<SpiLink>>( ) );
                mapOfLinkCollections.put( endAndMetaObject, new ArrayList<SpiLink>( linksForEndAndMetaObject ) );
            }
        }
    }

    private void computeDeltas( ) {

        partitionDeltas.clear( );
        Set<CorePartitionable> notDeleted = new HashSet<CorePartitionable>( );
        Set<SpiLink> notRemoved = new HashSet<SpiLink>( );
        // Handle createdElements and deletedElements.
        for ( Entry<KeyTuple<MRI, CorePartitionable>, SpiMutableInteger> entry : createdElements.entrySet( ) ) {
            KeyTuple<MRI, CorePartitionable> elemKey = entry.getKey( );
            CorePartitionable element = elemKey.getCorePartitionable( );
            if ( deletedElements.containsKey( elemKey ) ) {
                // The same element has also been deleted at least once => compare the counters.
                int created = entry.getValue( ).getValue( );
                int deleted = deletedElements.get( elemKey ).getValue( );
                if ( created > deleted ) {
                    // The number of creations of this element is greater than or equal to the number of deletions.
                    // If it currently lives in a persistent partition, we need to produce a creation delta.
                    CoreModelPartition partition = element.get___Partition( );
                    if ( !partition.getPri( ).isVolatilePartition( ) ) {
                        getOrCreateDelta( partition ).elementCreated( element );
                    }
                    notDeleted.add( element );
                } else if ( created == deleted ) {
                    // The element was created and deleted the same number of times => no delta, but mark it as not to be deleted.
                    notDeleted.add( element );
                }
            } else {
                // The element has been created and never been deleted. If it currently lives in a persistent partition we need
                // to produce a creation delta.
                CoreModelPartition partition = element.get___Partition( );
                if ( !partition.getPri( ).isVolatilePartition( ) ) {
                    getOrCreateDelta( partition ).elementCreated( element );
                }
            }
        }
        // Now process all elements in the deletedElements collection.
        for ( Entry<KeyTuple<MRI, CorePartitionable>, SpiMutableInteger> entry : deletedElements.entrySet( ) ) {
            KeyTuple<MRI, CorePartitionable> elemKey = entry.getKey( );
            CorePartitionable element = elemKey.getCorePartitionable( );
            if ( notDeleted.contains( element ) ) {
                // The element deletion was cancelled in the 'createdElements' loop above.
                continue;
            }
            // The element has been deleted. Since it is not contained in createdElements, it cannot be new. One of two 
            // situations must exist here: either the element originates in a persistent partition, or the element originates
            // in a transient partition. Only in the first case a deletion delta needs to be produced.
            if ( !transientHomeOfElement.containsKey( elemKey ) ) {
                CoreModelPartition homePartition = persistentHomeOfElement.get( elemKey );
                // homePartition must be != null now!
                assert homePartition != null : "Failed to determine home partition"; //$NON-NLS-1$
                getOrCreateDelta( homePartition ).elementDeleted( elemKey.mri );
            }
        }
        // Handle addedLinks and removedLinks.
        for ( Entry<SpiLink, SpiMutableInteger> entry : addedLinks.entrySet( ) ) {
            EndStorageLink link = (EndStorageLink) entry.getKey( );
            if ( removedLinks.containsKey( link ) ) {
                // The same link has also been removed at least once => compare the counters.
                int added = entry.getValue( ).getValue( );
                int removed = removedLinks.get( link ).getValue( );
                if ( added > removed ) {
                    notRemoved.add( link );
                    // The link has been added. If its storage end currently lives in a persistent partition, we need to produce
                    // a link addition delta.
                    CoreModelPartition partition = link.getStorageEnd( ).get( connection.getSession( ) ).get___Partition( );
                    if ( !partition.getPri( ).isVolatilePartition( ) ) {
                        getOrCreateDelta( partition ).linkAdded( link );
                        if ( isOrdered( link ) ) {
                            // The link is ordered => we need to produce a modifiedOrderedLinkCollection delta.
                            getOrCreateDelta( partition ).orderedLinkCollectionModified( link );
                        }
                    }
                } else if ( added == removed ) {
                    // The link was added and removed the same number of times => no link addition delta, but mark it as
                    // not to be removed for the loop over the removedLinks collection below.
                    notRemoved.add( link );
                }
            } else {
                // The link has been added but never removed. If its storage end currently lives in a persistent partition, 
                // we need to produce a link addition delta.
                CoreModelPartition partition = link.getStorageEnd( ).get( connection.getSession( ) ).get___Partition( );
                if ( !partition.getPri( ).isVolatilePartition( ) ) {
                    getOrCreateDelta( partition ).linkAdded( link );
                    if ( isOrdered( link ) ) {
                        // The link is ordered => we need to produce a modifiedOrderedLinkCollection delta.
                        getOrCreateDelta( partition ).orderedLinkCollectionModified( link );
                    }
                }
            }
        }
        // Now process all links in 'removedLinks'.
        for ( Entry<SpiLink, SpiMutableInteger> entry : removedLinks.entrySet( ) ) {
            EndStorageLink link = (EndStorageLink) entry.getKey( );
            if ( notRemoved.contains( link ) ) {
                // The link removal was cancelled in the 'addedLinks' loop above.
                continue;
            }
            // The link has been removed. Note that the two linked model elements do not necessarily exist any more, the link 
            // removal can be the result of a model element deletion. In any case, if the link's storage end originates in a 
            // persistent partition, we need to produce a link removal delta.
            CoreModelPartition homePartition = null;
            MriReference storageEnd = link.getStorageEnd( );
            if ( storageEnd.isCached( ) ) {
                CorePartitionable element = storageEnd.get( connection.getSession( ) );
                KeyTuple<MRI, CorePartitionable> elemKey = this.getElemKey( element.get___Mri( ), element );
                // Did the element move away from a persistent partition via assignment?
                homePartition = persistentHomeOfElement.get( elemKey );
                if ( homePartition == null ) {
                    // The element did not move away from a persistent partition.
                    homePartition = element.get___Partition( );
                }
            } else {
                MRI mri = storageEnd.getMri( );
                for ( Entry<KeyTuple<MRI, CorePartitionable>, CoreModelPartition> entry2 : persistentHomeOfElement.entrySet( ) ) {
                    if ( entry2.getKey( ).mri.equals( mri ) ) {
                        homePartition = entry2.getValue( );
                        break;
                    }
                }
                if ( homePartition == null ) {
                    homePartition = connection.getPartition( mri.getPri( ) );
                }
            }
            if ( homePartition != null && homePartition.isPersisted( ) ) {
                getOrCreateDelta( homePartition ).linkRemoved( link );
                if ( isOrdered( link ) ) {
                    // The link is ordered => we need to produce a modifiedOrderedLinkCollection delta.
                    getOrCreateDelta( homePartition ).orderedLinkCollectionModified( link );
                }
            }
        }
        // Look for attributes whose value actually did not change compared to their persistent value.
        for ( Entry<KeyTuple<MRI, CorePartitionable>, Map<String, Object>> elementEntry : changedAttributes.entrySet( ) ) {
            KeyTuple<MRI, CorePartitionable> elemKey = elementEntry.getKey( );
            CorePartitionable element = elemKey.getCorePartitionable( );
            if ( element.is___Alive( ) ) {
                // Deletion or creation of the model element carrying the attribute has a higher relevance than the attribute
                // change. Note that Connection.isNewElement() answers 'true' if the element was newly created as well as if 
                // the element was created as the result of the undo of a deletion, so we have to distinguish these cases!
                boolean isNew = connection.isNewElement( element ) && !deletedElements.containsKey( elemKey );
                if ( !isNew ) {
                    CoreModelPartition partition = element.get___Partition( );
                    if ( !partition.getPri( ).isVolatilePartition( ) ) {
                        // The current partition of the attributes' owning
                        // element is transient => we can skip this delta.
                        Map<String, Object> attributes = elementEntry.getValue( );
                        SpiJmiHelper jmiHelper = connection.getCoreJmiHelper( );
                        for ( Entry<String, Object> attributeEntry : attributes.entrySet( ) ) {
                            String attributeName = attributeEntry.getKey( );
                            Object newValue = ( (RefFeaturedImpl) element ).refGetValue( connection, attributeName );
                            Object oldValue = attributeEntry.getValue( );
                            if ( !( ( oldValue == null && newValue == null ) || ( oldValue != null && newValue != null && oldValue.equals( newValue ) ) ) ) {
                                Attribute attribute = jmiHelper.getAttributeByName( connection, (MofClass) ( (RefObject) element ).refMetaObject( ), attributeName, true /* includeSupertypes */);
                                getOrCreateDelta( partition ).attributeChanged( element, attribute, oldValue );
                            }
                        }
                    }
                }
            }
        }
        // Handle assignments of elements between partitions. The following three use cases are handled here: 
        // 1. An element moved between two persistent partitions. In that case, an unassignment delta for the
        // source partition and an assignment delta for the target partition need to be produced. 
        // 2. A persistent element was assigned to a transient partition. In that case, deletion deltas for the 
        // element and links connected to it need to be produced. 
        // 3. An element was assigned from a transient partition to a persistent partition. In that case, a 
        // creation delta for the element and link addition deltas for the links connected to it need to be produced.
        for ( Entry<KeyTuple<MRI, CorePartitionable>, CoreModelPartition> entry : persistentHomeOfElement.entrySet( ) ) {
            KeyTuple<MRI, CorePartitionable> elemKey = entry.getKey( );
            CorePartitionable element = elemKey.getCorePartitionable( );
            if ( element.is___Alive( ) ) {
                CoreModelPartition homePartition = entry.getValue( );
                CoreModelPartition currentPartition = element.get___Partition( );
                if ( currentPartition != null && !currentPartition.equals( homePartition ) ) {
                    if ( currentPartition.isPersisted( ) || ( !currentPartition.getPri( ).isVolatilePartition( ) ) ) {
                        // Use case 1 described above.
                        PartitionDeltaImpl homePartitionDelta = getOrCreateDelta( homePartition );
                        homePartitionDelta.elementUnassigned( element, currentPartition );
                        PartitionDeltaImpl currentPartitionDelta = getOrCreateDelta( currentPartition );
                        currentPartitionDelta.elementAssigned( element, homePartition );
                        List<EndStorageLink> linksStoredAtElement = ( (RefFeaturedExtension) element ).get___AllStoredLinks( );
                        if ( linksStoredAtElement != null ) {
                            for ( int i = 0, n = linksStoredAtElement.size( ); i < n; i++ ) {
                                EndStorageLink link = linksStoredAtElement.get( i );
                                homePartitionDelta.linkUnassigned( link, currentPartition );
                                currentPartitionDelta.linkAssigned( link, homePartition );
                            }
                        }
                    } else {
                        // Use case 2 described above.
                        getOrCreateDelta( homePartition ).elementDeleted( element.get___Mri( ) );
                        Collection<SpiLink> links = currentPartition.getLinks( );
                        for ( SpiLink link : links ) {
                            CorePartitionable partitionable = ( (EndStorageLink) link ).getStorageEnd( ).get( connection.getSession( ) );
                            if ( partitionable.equals( element ) ) {
                                getOrCreateDelta( homePartition ).linkRemoved( link );
                                if ( isOrdered( (EndStorageLink) link ) ) {
                                    getOrCreateDelta( homePartition ).orderedLinkCollectionModified( link );
                                }
                            }
                        }
                    }
                }
            }
        }
        for ( Entry<KeyTuple<MRI, CorePartitionable>, CoreModelPartition> entry : transientHomeOfElement.entrySet( ) ) {
            KeyTuple<MRI, CorePartitionable> elemKey = entry.getKey( );
            CorePartitionable element = elemKey.getCorePartitionable( );
            if ( element.is___Alive( ) ) {
                CoreModelPartition homePartition = entry.getValue( );
                CoreModelPartition currentPartition = element.get___Partition( );
                if ( currentPartition != null && !currentPartition.equals( homePartition ) ) {
                    if ( currentPartition.isPersisted( ) ) {
                        // Use case 3.
                        getOrCreateDelta( currentPartition ).elementCreated( element );
                        Collection<SpiLink> links = currentPartition.getLinks( );
                        for ( SpiLink link : links ) {
                            CorePartitionable partitionable = ( (EndStorageLink) link ).getStorageEnd( ).get( connection.getSession( ) );
                            if ( partitionable.equals( element ) ) {
                                getOrCreateDelta( currentPartition ).linkAdded( link );
                                if ( isOrdered( (EndStorageLink) link ) ) {
                                    getOrCreateDelta( currentPartition ).orderedLinkCollectionModified( link );
                                }
                            }
                        }
                    }
                }
            }
        }
        // We still need to handle the special case that ordered link collections were permutated by moving links around, without 
        // actually adding new links or removing existing links. The "normal" case of arbitrary additions and removals of ordered 
        // links has already been handled by the code above.
        //
        // The 'persistentOrderedLinkCollections' collection contains all ordered link collections for which at least one
        // link addition or removal has taken place. We need to iterate over it and compare the persistent link collection
        // with the current in-memory state. If a different order is detected (and nothing else!), we need to produce a 
        // modifiedOrderedLinkCollection delta.
        Workspace workspace = connection.getSession( ).getWorkspace( );
        for ( Entry<MRI, Map<SpiEndAndMetaObject, List<SpiLink>>> entry : persistentOrderedLinkCollections.entrySet( ) ) {
            MRI mriOfElementAtStorageEnd = entry.getKey( );
            Map<SpiEndAndMetaObject, List<SpiLink>> mapOfLinkCollections = entry.getValue( );
            for ( Entry<SpiEndAndMetaObject, List<SpiLink>> entry2 : mapOfLinkCollections.entrySet( ) ) {
                boolean produceDelta = false;
                List<SpiLink> persistentLinksForEndAndMetaObject = entry2.getValue( );
                List<SpiLink> currentLinksForEndAndMetaObject = new ArrayList<SpiLink>( workspace.getMemoryLinkManager( ).getLinksForEndAndMetaObject( connection.getSession( ), (EndAndMetaObject) entry2.getKey( ), mriOfElementAtStorageEnd ) );
                Set<SpiLink> persistentSet = new HashSet<SpiLink>( persistentLinksForEndAndMetaObject );
                Set<SpiLink> currentSet = new HashSet<SpiLink>( currentLinksForEndAndMetaObject );
                if ( persistentSet.containsAll( currentSet ) && currentSet.containsAll( persistentSet ) ) {
                    for ( int i = 0, n = persistentLinksForEndAndMetaObject.size( ); i < n; i++ ) {
                        SpiLink persistentLink = persistentLinksForEndAndMetaObject.get( i );
                        SpiLink currentLink = currentLinksForEndAndMetaObject.get( i );
                        if ( !persistentLink.equals( currentLink ) ) {
                            produceDelta = true;
                            break;
                        }
                    }
                }
                if ( produceDelta ) {
                    CoreModelPartition partition = connection.getPartition( mriOfElementAtStorageEnd.getPri( ) );
                    getOrCreateDelta( partition ).orderedLinkCollectionModified( mriOfElementAtStorageEnd, entry2.getKey( ), currentLinksForEndAndMetaObject );
                }
            }
        }
        deltasUpToDate = true;
    }

    public void dirtyPartitionEvicted( CoreModelPartition partition ) {

        // Clean all collections by throwing out elements and links of the
        // partition to be evicted.
        for ( Partitionable element : partition.getElements( ) ) {
            KeyTuple<MRI, CorePartitionable> elemKey = this.mriToKeyTuples.get( element.get___Mri( ) );
            persistentHomeOfElement.remove( elemKey );
            transientHomeOfElement.remove( elemKey );
            changedAttributes.remove( elemKey );
            createdElements.remove( elemKey );
            deletedElements.remove( elemKey );
        }
        for ( SpiLink link : partition.getLinks( ) ) {
            addedLinks.remove( link );
            removedLinks.remove( link );
        }
        partitionDeltas.remove( partition );
    }

    private PartitionDeltaImpl getOrCreateDelta( CoreModelPartition partition ) {

        PartitionDeltaImpl delta = partitionDeltas.get( partition );
        if ( delta == null ) {
            partitionDeltas.put( partition, delta = new PartitionDeltaImpl( connection, partition ) );
        }
        return delta;
    }

    private boolean isOrdered( EndStorageLink link ) {

        return link.getOrderedEnd( ) != -1;
    }
}