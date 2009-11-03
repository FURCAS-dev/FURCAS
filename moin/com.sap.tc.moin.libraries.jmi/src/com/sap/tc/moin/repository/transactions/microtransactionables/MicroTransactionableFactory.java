package com.sap.tc.moin.repository.transactions.microtransactionables;

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

public interface MicroTransactionableFactory {

    public DataTypeAttributeChangeMicroTransactionable createDataTypeAttributeChangeMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, int attributeId, Object oldValue, Object newValue );

    public DataTypeAttributeAddElementMicroTransactionable createDataTypeAttributeAddAllElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, Collection elementsToAdd );

    public DataTypeAttributeAddElementMicroTransactionable createDataTypeAttributeAddAllElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, int index, Collection elementsToAdd );

    public DataTypeAttributeAddElementMicroTransactionable createDataTypeAttributeAddElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, Object elementToAdd );

    public DataTypeAttributeAddElementMicroTransactionable createDataTypeAttributeAddElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, int index, Object elementToAdd );

    public DataTypeAttributeRemoveElementMicroTransactionable createDataTypeAttributeRemoveAllElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, Collection elementsToRemove, boolean removeAllOccurrences );

    public DataTypeAttributeRemoveElementMicroTransactionable createDataTypeAttributeRemoveElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, int index );

    public DataTypeAttributeRemoveElementMicroTransactionable createDataTypeAttributeRemoveElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, Object elementToRemove, boolean removeAllOccurrences );

    public DataTypeAttributeSetElementMicroTransactionable createDataTypeAttributeSetElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, int index, Object elementToSet );

    public ObjectAttributeChangeMicroTransactionable createObjectAttributeChangeMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, Object newValue );

    public ObjectAttributeAddElementMicroTransactionable createObjectAttributeAddAllElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, Collection elementsToAdd );

    public ObjectAttributeAddElementMicroTransactionable createObjectAttributeAddAllElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, int index, Collection elementsToAdd );

    public ObjectAttributeAddElementMicroTransactionable createObjectAttributeAddElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, Object elementToAdd );

    public ObjectAttributeAddElementMicroTransactionable createObjectAttributeAddElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, int index, Object elementToAdd );

    public ObjectAttributeRemoveElementMicroTransactionable createObjectAttributeRemoveAllElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, Collection elementsToRemove, boolean removeAllOccurrences );

    public ObjectAttributeRemoveElementMicroTransactionable createObjectAttributeRemoveElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, int index );

    public ObjectAttributeRemoveElementMicroTransactionable createObjectAttributeRemoveElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, IteratorKnowingCollection<EndStorageLink> iterator, int iterationStepsBeforeRemove );

    public ObjectAttributeRemoveElementMicroTransactionable createObjectAttributeRemoveElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, Object elementToRemove, boolean removeAllOccurrences );

    public ObjectAttributeSetElementMicroTransactionable createObjectAttributeSetElementMicroTransactionable( CoreConnection connection, RefFeatured featured, Attribute attribute, int index, Object newValue );

    public LinkAddElementMicroTransactionable createLinkAddAllElementMicroTransactionable( CoreConnection connection, Association association, RefObject elementAtFromEnd, byte fromEndNumber, Collection elementsToAddAtToEnd );

    public LinkAddElementMicroTransactionable createLinkAddAllElementMicroTransactionable( CoreConnection connection, Association association, RefObject elementAtFromEnd, byte fromEndNumber, int index, Collection elementsToAddAtToEnd );

    public LinkAddElementMicroTransactionable createLinkAddElementMicroTransactionable( CoreConnection connection, Association association, RefObject elementAtFromEnd, Object elementToAddAtToEnd );

    public LinkAddElementMicroTransactionable createLinkAddElementMicroTransactionable( CoreConnection connection, Association association, RefObject elementAtFromEnd, byte fromEndNumber, Object elementToAddAtToEnd );

    public LinkAddElementMicroTransactionable createLinkAddElementMicroTransactionable( CoreConnection connection, Association association, RefObject elementAtFromEnd, byte fromEndNumber, int index, Object elementToAddAtToEnd );

    public MicroTransactionable createDanglingLinkAddElementMicroTransactionable( CoreConnection connection, Association association, RefObject host, byte hostEndNumber, int position, LRI target );

    public LinkRemoveElementMicroTransactionable createLinkRemoveAllElementMicroTransactionable( CoreConnection connection, Association association, RefObject elementAtFromEnd, byte fromEndNumber, Collection elementsToRemoveFromToEnd );

    public LinkRemoveElementMicroTransactionable createLinkRemoveElementMicroTransactionable( CoreConnection connection, Association association, RefObject elementAtFromEnd, byte fromEndNumber, int index );

    public LinkRemoveElementMicroTransactionable createLinkRemoveElementMicroTransactionable( CoreConnection connection, Association association, RefObject elementAtFromEnd, byte fromEndNumber, IteratorKnowingCollection<EndStorageLink> iterator, int iterationStepsBeforeRemove );

    public LinkRemoveElementMicroTransactionable createLinkRemoveElementMicroTransactionable( CoreConnection connection, Association association, RefObject elementAtFromEnd, byte fromEndNumber, Object elementToRemoveFromToEnd );

    public LinkSetElementMicroTransactionable createLinkSetElementMicroTransactionable( CoreConnection connection, Association association, RefObject elementAtFromEnd, byte fromEndNumber, int index, Object elementToSetAtToEnd );

    public ReferenceChangeMicroTransactionable createReferenceChangeMicroTransactionable( CoreConnection connection, RefFeatured featured, Reference reference, Association association, Object newValue, byte addedViaReferenceOnEnd );

    public ElementAssignToPartitionMicroTransactionable createElementAssignToPartitionMicroTransactionable( CoreConnection aConnection, CorePartitionable element, CoreModelPartition partition, boolean updateChildren );

    public PartitionDeleteMicroTransactionable createPartitionDeleteMicroTransactionable( CoreConnection connection, CoreModelPartition partition );

    public PartitionDeleteElementsMicroTransactionable createPartitionDeleteElementsMicroTransactionable( CoreConnection connection, CoreModelPartition partition );

    public PartitionCreateMicroTransactionable createPartitionCreateMicroTransactionable( CoreConnection connection, PRI pri );

    public ObtainTransientLockMicroTransactionable createObtainTransientLockMicroTransactionable( CoreConnection currentConnection, PRI partitionToLock, Connection owner );

    public InstanceCreateMicroTransactionable createInstanceCreateMicroTransactionable( CoreConnection connection, RefClass refClass, List parameterList, CoreModelPartition partition );

    public InstanceCreateMicroTransactionable createInstanceCreateMicroTransactionable( CoreConnection connection, RefClass refClass, List parameterList, CoreModelPartition partition, String calculatedMofId );

    public InstanceDeleteMicroTransactionable createInstanceDeleteMicroTransactionable( CoreConnection connection, RefObject refObject );

    public ConsistencyLinkDeleteMicroTransactionable createConsistencyCorrectionLinkDeleteMicroTransactionable( CoreConnection connection, EndStorageLink link );

    public SingleInstanceDeleteMicroTransactionable createConsistencyCorrectionElementDeleteMicroTransactionable( CoreConnection connection, RefObject refObject );

    public TransientPartitionCreateMicroTransactionable createTransientPartitionCreateMicroTransactionable( CoreConnection connection, PRI pri, SpiStage stage, Workspace workspace, String partitionName );

    public SingleInstanceDeleteMicroTransactionable createIsolatedInstanceDeleteMicroTransactionable( CoreConnection connection, RefObject refObject );

}
