package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.shared.util.IteratorKnowingCollection;
import com.sap.tc.moin.repository.spi.core.SpiStage;
import com.sap.tc.moin.repository.transactions.MicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.ConsistencyLinkDeleteMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.DataTypeAttributeAddElementMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.DataTypeAttributeChangeMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.DataTypeAttributeRemoveElementMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.DataTypeAttributeSetElementMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.ElementAssignToPartitionMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.InstanceCreateMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.InstanceDeleteMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.LinkAddElementMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.LinkRemoveElementMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.LinkSetElementMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.MicroTransactionableFactory;
import com.sap.tc.moin.repository.transactions.microtransactionables.ObjectAttributeAddElementMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.ObjectAttributeChangeMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.ObjectAttributeRemoveElementMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.ObjectAttributeSetElementMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.ObtainTransientLockMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.PartitionCreateMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.PartitionDeleteElementsMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.PartitionDeleteMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.ReferenceChangeMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.SingleInstanceDeleteMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.TransientPartitionCreateMicroTransactionable;

public class MicroTransactionableFactoryImpl implements MicroTransactionableFactory {

    public DataTypeAttributeChangeMicroTransactionable createDataTypeAttributeChangeMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, int attributeId, Object oldValue, Object newValue ) {

        return new DataTypeAttributeChangeMicroTransactionableImpl( connection, featured, attribute, attributeId, oldValue, newValue );
    }

    public DataTypeAttributeAddElementMicroTransactionable createDataTypeAttributeAddAllElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, Collection elementsToAdd ) {

        return new DataTypeAttributeAddElementMicroTransactionableImpl( connection, featured, attribute, elementsToAdd );
    }

    public DataTypeAttributeAddElementMicroTransactionable createDataTypeAttributeAddAllElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, int index, Collection elementsToAdd ) {

        return new DataTypeAttributeAddElementMicroTransactionableImpl( connection, featured, attribute, index, elementsToAdd );
    }

    public DataTypeAttributeAddElementMicroTransactionable createDataTypeAttributeAddElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, Object elementToAdd ) {

        Collection elementsToAdd = new ArrayList( 1 );
        elementsToAdd.add( elementToAdd );
        return new DataTypeAttributeAddElementMicroTransactionableImpl( connection, featured, attribute, elementsToAdd );
    }

    public DataTypeAttributeAddElementMicroTransactionable createDataTypeAttributeAddElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, int index, Object elementToAdd ) {

        Collection elementsToAdd = new ArrayList( 1 );
        elementsToAdd.add( elementToAdd );
        return new DataTypeAttributeAddElementMicroTransactionableImpl( connection, featured, attribute, index, elementsToAdd );
    }

    public DataTypeAttributeRemoveElementMicroTransactionable createDataTypeAttributeRemoveAllElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, Collection elementsToRemove, boolean removeAllOccurrences ) {

        return new DataTypeAttributeRemoveElementMicroTransactionableImpl( connection, featured, attribute, elementsToRemove, removeAllOccurrences );
    }

    public DataTypeAttributeRemoveElementMicroTransactionable createDataTypeAttributeRemoveElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, int index ) {

        return new DataTypeAttributeRemoveElementMicroTransactionableImpl( connection, featured, attribute, index );
    }

    public DataTypeAttributeRemoveElementMicroTransactionable createDataTypeAttributeRemoveElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, Object elementToRemove, boolean removeAllOccurrences ) {

        Collection elementsToRemove = new ArrayList( 1 );
        elementsToRemove.add( elementToRemove );
        return new DataTypeAttributeRemoveElementMicroTransactionableImpl( connection, featured, attribute, elementsToRemove, removeAllOccurrences );
    }

    public DataTypeAttributeSetElementMicroTransactionable createDataTypeAttributeSetElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, int index, Object elementToSet ) {

        return new DataTypeAttributeSetElementMicroTransactionableImpl( connection, featured, attribute, index, elementToSet );
    }

    public ObjectAttributeChangeMicroTransactionable createObjectAttributeChangeMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, Object newValue ) {

        return new ObjectAttributeChangeMicroTransactionableImpl( connection, featured, attribute, newValue );
    }

    public ObjectAttributeAddElementMicroTransactionable createObjectAttributeAddAllElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, Collection elementsToAdd ) {

        return new ObjectAttributeAddElementMicroTransactionableImpl( connection, featured, attribute, elementsToAdd );
    }

    public ObjectAttributeAddElementMicroTransactionable createObjectAttributeAddAllElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, int index, Collection elementsToAdd ) {

        return new ObjectAttributeAddElementMicroTransactionableImpl( connection, featured, attribute, index, elementsToAdd );
    }

    public ObjectAttributeAddElementMicroTransactionable createObjectAttributeAddElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, Object elementToAdd ) {

        Collection elementsToAdd = new ArrayList( 1 );
        elementsToAdd.add( elementToAdd );
        return new ObjectAttributeAddElementMicroTransactionableImpl( connection, featured, attribute, elementsToAdd );
    }

    public ObjectAttributeAddElementMicroTransactionable createObjectAttributeAddElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, int index, Object elementToAdd ) {

        Collection elementsToAdd = new ArrayList( 1 );
        elementsToAdd.add( elementToAdd );
        return new ObjectAttributeAddElementMicroTransactionableImpl( connection, featured, attribute, index, elementsToAdd );
    }

    public ObjectAttributeRemoveElementMicroTransactionable createObjectAttributeRemoveAllElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, Collection elementsToRemove, boolean removeAllOccurrences ) {

        return new ObjectAttributeRemoveElementMicroTransactionableImpl( connection, featured, attribute, elementsToRemove, removeAllOccurrences );
    }

    public ObjectAttributeRemoveElementMicroTransactionable createObjectAttributeRemoveElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, int index ) {

        return new ObjectAttributeRemoveElementMicroTransactionableImpl( connection, featured, attribute, index );
    }

    public ObjectAttributeRemoveElementMicroTransactionable createObjectAttributeRemoveElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, IteratorKnowingCollection<EndStorageLink> iterator, int iterationStepsBeforeRemove ) {

        return new ObjectAttributeRemoveElementMicroTransactionableImpl( connection, featured, attribute, iterator, iterationStepsBeforeRemove );
    }

    public ObjectAttributeRemoveElementMicroTransactionable createObjectAttributeRemoveElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, Object elementToRemove, boolean removeAllOccurrences ) {

        Collection elementsToRemove = new ArrayList( 1 );
        elementsToRemove.add( elementToRemove );
        return new ObjectAttributeRemoveElementMicroTransactionableImpl( connection, featured, attribute, elementsToRemove, removeAllOccurrences );
    }

    public ObjectAttributeSetElementMicroTransactionable createObjectAttributeSetElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, int index, Object newValue ) {

        return new ObjectAttributeSetElementMicroTransactionableImpl( connection, featured, attribute, index, newValue );
    }

    public LinkAddElementMicroTransactionable createLinkAddAllElementMicroTransactionable( CoreConnection connection, Association association, RefObject elementAtFromEnd, byte fromEndNumber, Collection elementsToAddAtToEnd ) {

        return new LinkAddElementMicroTransactionableImpl( connection, association, elementAtFromEnd, fromEndNumber, elementsToAddAtToEnd );
    }

    public LinkAddElementMicroTransactionable createLinkAddAllElementMicroTransactionable( CoreConnection connection, Association association, RefObject elementAtFromEnd, byte fromEndNumber, int index, Collection elementsToAddAtToEnd ) {

        return new LinkAddElementMicroTransactionableImpl( connection, association, elementAtFromEnd, fromEndNumber, index, elementsToAddAtToEnd );
    }

    public LinkAddElementMicroTransactionable createLinkAddElementMicroTransactionable( CoreConnection connection, Association association, RefObject elementAtFromEnd, Object elementToAddAtToEnd ) {

        Collection elementsToAddAtToEnd = new ArrayList( 1 );
        elementsToAddAtToEnd.add( elementToAddAtToEnd );
        return new LinkAddElementMicroTransactionableImpl( connection, association, elementAtFromEnd, elementsToAddAtToEnd );
    }

    public LinkAddElementMicroTransactionable createLinkAddElementMicroTransactionable( CoreConnection connection, Association association, RefObject elementAtFromEnd, byte fromEndNumber, Object elementToAddAtToEnd ) {

        Collection elementsToAddAtToEnd = new ArrayList( 1 );
        elementsToAddAtToEnd.add( elementToAddAtToEnd );
        return new LinkAddElementMicroTransactionableImpl( connection, association, elementAtFromEnd, fromEndNumber, elementsToAddAtToEnd );
    }

    public LinkAddElementMicroTransactionable createLinkAddElementMicroTransactionable( CoreConnection connection, Association association, RefObject elementAtFromEnd, byte fromEndNumber, int index, Object elementToAddAtToEnd ) {

        Collection elementsToAddAtToEnd = new ArrayList( 1 );
        elementsToAddAtToEnd.add( elementToAddAtToEnd );
        return new LinkAddElementMicroTransactionableImpl( connection, association, elementAtFromEnd, fromEndNumber, index, elementsToAddAtToEnd );
    }

    public MicroTransactionable createDanglingLinkAddElementMicroTransactionable( CoreConnection connection, Association association, RefObject host, byte hostEndNumber, int position, LRI target ) {

        return new LinkAddElementMicroTransactionableImpl( connection, association, host, hostEndNumber, position, target );
    }

    public LinkRemoveElementMicroTransactionable createLinkRemoveAllElementMicroTransactionable( CoreConnection connection, Association association, RefObject elementAtFromEnd, byte fromEndNumber, Collection elementsToRemoveFromToEnd ) {

        return new LinkRemoveElementMicroTransactionableImpl( connection, association, elementAtFromEnd, fromEndNumber, elementsToRemoveFromToEnd );
    }

    public LinkRemoveElementMicroTransactionable createLinkRemoveElementMicroTransactionable( CoreConnection connection, Association association, RefObject elementAtFromEnd, byte fromEndNumber, int index ) {

        return new LinkRemoveElementMicroTransactionableImpl( connection, association, elementAtFromEnd, fromEndNumber, index );
    }

    public LinkRemoveElementMicroTransactionable createLinkRemoveElementMicroTransactionable( CoreConnection connection, Association association, RefObject elementAtFromEnd, byte fromEndNumber, IteratorKnowingCollection<EndStorageLink> iterator, int iterationStepsBeforeRemove ) {

        return new LinkRemoveElementMicroTransactionableImpl( connection, association, elementAtFromEnd, fromEndNumber, iterator, iterationStepsBeforeRemove );
    }

    public LinkRemoveElementMicroTransactionable createLinkRemoveElementMicroTransactionable( CoreConnection connection, Association association, RefObject elementAtFromEnd, byte fromEndNumber, Object elementToRemoveFromToEnd ) {

        Collection elementsToRemoveFromToEnd = new ArrayList( 1 );
        elementsToRemoveFromToEnd.add( elementToRemoveFromToEnd );
        return new LinkRemoveElementMicroTransactionableImpl( connection, association, elementAtFromEnd, fromEndNumber, elementsToRemoveFromToEnd );
    }

    public LinkSetElementMicroTransactionable createLinkSetElementMicroTransactionable( CoreConnection connection, Association association, RefObject elementAtFromEnd, byte fromEndNumber, int index, Object elementToSetAtToEnd ) {

        return new LinkSetElementMicroTransactionableImpl( connection, association, elementAtFromEnd, fromEndNumber, index, elementToSetAtToEnd );
    }

    public ReferenceChangeMicroTransactionable createReferenceChangeMicroTransactionable( CoreConnection connection, RefFeatured featured, Reference aReference, Association association, Object newValue, byte addedViaReferenceOnEnd ) {

        return new ReferenceChangeMicroTransactionableImpl( connection, featured, aReference, association, newValue, addedViaReferenceOnEnd );
    }

    public ElementAssignToPartitionMicroTransactionable createElementAssignToPartitionMicroTransactionable( CoreConnection aConnection, CorePartitionable element, CoreModelPartition partition, boolean updateChildren ) {

        return new ElementAssignToPartitionMicroTransactionableImpl( aConnection, element, partition, updateChildren );
    }

    public PartitionDeleteMicroTransactionable createPartitionDeleteMicroTransactionable( CoreConnection connection, CoreModelPartition partition ) {

        return new PartitionDeleteMicroTransactionableImpl( connection, partition );
    }

    public PartitionDeleteElementsMicroTransactionable createPartitionDeleteElementsMicroTransactionable( CoreConnection connection, CoreModelPartition partition ) {

        return new PartitionDeleteElementsMicroTransactionableImpl( connection, partition );
    }

    public PartitionCreateMicroTransactionable createPartitionCreateMicroTransactionable( CoreConnection connection, PRI pri ) {

        return new PartitionCreateMicroTransactionableImpl( connection, pri );
    }

    public ObtainTransientLockMicroTransactionable createObtainTransientLockMicroTransactionable( CoreConnection connection, PRI partitionToLock, Connection owner ) {

        return new ObtainTransientLockMicroTransactionableImpl( connection, partitionToLock, owner );
    }

    public InstanceCreateMicroTransactionable createInstanceCreateMicroTransactionable( CoreConnection connection, RefClass refClass, List parameterList, CoreModelPartition partition ) {

        return new InstanceCreateMicroTransactionableImpl( connection, refClass, parameterList, partition );
    }

    public InstanceCreateMicroTransactionable createInstanceCreateMicroTransactionable( CoreConnection connection, RefClass refClass, List parameterList, CoreModelPartition partition, String calculatedMofId ) {

        return new InstanceCreateMicroTransactionableImpl( connection, refClass, parameterList, partition, calculatedMofId );
    }

    public InstanceDeleteMicroTransactionable createInstanceDeleteMicroTransactionable( CoreConnection connection, RefObject refObject ) {

        return new InstanceDeleteMicroTransactionableImpl( connection, refObject );
    }

    public TransientPartitionCreateMicroTransactionable createTransientPartitionCreateMicroTransactionable( CoreConnection connection, PRI pri, SpiStage stage, Workspace workspace, String partitionName ) {

        return new TransientPartitionCreateMicroTransactionableImpl( connection, pri, stage, workspace, partitionName );
    }

    public ConsistencyLinkDeleteMicroTransactionable createConsistencyCorrectionLinkDeleteMicroTransactionable( CoreConnection connection, EndStorageLink link ) {

        return new ConsistencyLinkDeleteMicroTransactionableImpl( connection, link );
    }

    public SingleInstanceDeleteMicroTransactionable createConsistencyCorrectionElementDeleteMicroTransactionable( CoreConnection connection, RefObject refObject ) {

        return new SingleInstanceDeleteMicroTransactionableImpl( connection, refObject );
    }

    public SingleInstanceDeleteMicroTransactionable createIsolatedInstanceDeleteMicroTransactionable( CoreConnection connection, RefObject refObject ) {

        return new IsolatedInstanceDeleteMicroTransactionableImpl( connection, refObject );
    }
}
