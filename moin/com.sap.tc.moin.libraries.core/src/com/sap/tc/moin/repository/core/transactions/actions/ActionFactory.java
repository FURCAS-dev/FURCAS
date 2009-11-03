package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.shared.util.IteratorKnowingCollection;
import com.sap.tc.moin.repository.spi.core.SpiStage;

public class ActionFactory {

    public static PartitionEnsureCreationAllowedAction createEnsureCreationAllowedAction( CoreConnection connection, PRI partitionPri ) {

        return new PartitionEnsureCreationAllowedAction( connection, partitionPri );
    }

    public static PartitionEnsureDeletionAllowedAction createEnsureDeletionAllowedAction( CoreConnection connection, PRI partitionPri ) {

        return new PartitionEnsureDeletionAllowedAction( connection, partitionPri );
    }

    public static PartitionEnsureEditingAllowedAction createEnsureEditingAllowedAction( CoreConnection connection, PRI partitionPri ) {

        return new PartitionEnsureEditingAllowedAction( connection, partitionPri );
    }

    public static DataTypeAttributeChangeAction createDataTypeAttributeChangeAction( CoreConnection connection, MRI featuredMri, String featureName, int featureId, Object oldValue, Object newValue ) {

        return new DataTypeAttributeChangeAction( connection, featuredMri, featureName, featureId, oldValue, newValue );
    }

    public static DataTypeAttributeAddElementAction createDataTypeAttributeAddElementAction( CoreConnection connection, MRI featuredMri, String featureName, int anIndex, Object aValue ) {

        return new DataTypeAttributeAddElementAction( connection, featuredMri, featureName, anIndex, aValue );
    }

    public static DataTypeAttributeChangeElementAction createDataTypeAttributeChangeElementAction( CoreConnection connection, MRI featuredMri, String featureName, int index, Object oldValue, Object newValue ) {

        return new DataTypeAttributeChangeElementAction( connection, featuredMri, featureName, index, oldValue, newValue );
    }

    public static DataTypeAttributeRemoveElementAction createDataTypeAttributeRemoveElementAction( CoreConnection connection, MRI featuredMri, String featureName, int index, Object value ) {

        return new DataTypeAttributeRemoveElementAction( connection, featuredMri, featureName, index, value );
    }

//    public static LinkAddAction createLinkAddAction( CoreConnection connection, Link link ) {
//
//        return new LinkAddAction( connection, link );
//    }
//
//    public static LinkAddAction createLinkAddAction( CoreConnection connection, EndStorageLink link, int anIndex, boolean isOrdered ) {
//
//        return new LinkAddAction( connection, link, anIndex, isOrdered );
//    }
//
//    public static LinkRemoveAction createLinkRemoveAction( CoreConnection connection, Link link ) {
//
//        return new LinkRemoveAction( connection, link );
//    }
//
//    public static LinkRemoveAction createLinkRemoveAction( CoreConnection connection, Link link, IteratorKnowingCollection<EndStorageLink> iterator ) {
//
//        return new LinkRemoveAction( connection, link, iterator );
//    }
//
//    public static LinkRemoveAction createLinkRemoveAction( CoreConnection connection, EndStorageLink link, int index ) {
//
//        return new LinkRemoveAction( connection, link, index );
//    }

    public static PartitionLockObtainAction createPartitionEditLockAction( CoreConnection connection, PRI partitionPri ) {

        return new PartitionLockObtainAction( connection, partitionPri, connection, PartitionLockObtainAction.PARTITION_CHANGE_MODE_EDIT );
    }

    public static PartitionLockObtainAction createPartitionLockAction( CoreConnection connection, PRI partitionPri, Object owner ) {

        return new PartitionLockObtainAction( connection, partitionPri, owner );
    }

    public static PartitionLockReleaseAction createPartitionLockReleaseAction( CoreConnection connection, PRI partitionPri, Object owner ) {

        return new PartitionLockReleaseAction( connection, partitionPri, owner );
    }

    public static PartitionLockReleaseAction createPartitionLockReleaseAction( CoreConnection connection, PRI partitionPri ) {

        return new PartitionLockReleaseAction( connection, partitionPri, connection );
    }

    public static PartitionLockObtainAction createPartitionDeleteLockAction( CoreConnection connection, PRI partitionPri ) {

        return new PartitionLockObtainAction( connection, partitionPri, connection, PartitionLockObtainAction.PARTITION_CHANGE_MODE_DELETE );
    }

    public static PartitionMarkDirtyAction createPartitionMarkDirtyAction( CoreConnection connection, PRI partitionPri ) {

        return new PartitionMarkDirtyAction( connection, partitionPri );
    }

    public static PartitionClearDirtyAction createPartitionClearDirtyAction( CoreConnection connection, PRI partitionPri ) {

        return new PartitionClearDirtyAction( connection, partitionPri );
    }

    public static PartitionableAssignPartitionAction createPartitionableAssignPartitionAction( CoreConnection connection, MRI partitionableMri, PRI oldPartitionPri, PRI newPartitionPri ) {

        return new PartitionableAssignPartitionAction( connection, partitionableMri, oldPartitionPri, newPartitionPri );
    }

    public static InstanceCreateAction createInstanceCreateAction( CoreConnection connection, MRI refClassMri, MRI instanceMri, PRI partitionPri, Workspace workspace ) {

        return new InstanceCreateAction( connection, refClassMri, instanceMri, partitionPri, workspace );
    }

    public static InstanceDeleteAction createInstanceDeleteAction( CoreConnection connection, MRI instanceMri ) {

        return new InstanceDeleteAction( connection, instanceMri );
    }

    public static PartitionDeleteAction createPartitionDeleteAction( CoreConnection connection, PRI pri ) {

        return new PartitionDeleteAction( connection, pri );
    }

    public static PartitionCreateAction createPartitionCreateAction( CoreConnection connection, PRI pri, SpiStage stage, Workspace workspace, boolean isReadOnly ) {

        return new PartitionCreateAction( connection, pri, stage, workspace, isReadOnly );
    }

    public static TransientPartitionCreateAction createTransientPartitionCreateAction( CoreConnection connection, PRI pri, SpiStage stage, Workspace workspace ) {

        return new TransientPartitionCreateAction( connection, pri, stage, workspace );
    }

    public static TransientPartitionDeleteAction createTransientPartitionDeleteAction( CoreConnection connection, PRI pri ) {

        return new TransientPartitionDeleteAction( connection, pri );
    }

    // NGLM changes / additions

    public static EndStorageLinkAddAction createEndStorageLinkAddAction( CoreConnection connection, MRI aFeaturedMri, String anAttributeOrAssociationEndMofId, EndStorageLink aLink, int anIndex ) {

        return new EndStorageLinkAddAction( connection, aFeaturedMri, anAttributeOrAssociationEndMofId, aLink, anIndex );
    }

    public static EndStorageLinkRemoveAction createEndStorageLinkRemoveAction( CoreConnection connection, MRI aFeaturedMri, String anAttributeOrAssociationEndMofId, EndStorageLink aLink, int anIndex ) {

        return new EndStorageLinkRemoveAction( connection, aFeaturedMri, anAttributeOrAssociationEndMofId, aLink, anIndex );
    }

    public static EndStorageLinkRemoveAction createEndStorageLinkRemoveAction( CoreConnection connection, MRI aFeaturedMri, String anAttributeOrAssociationEndMofId, EndStorageLink aLink, int anIndex, IteratorKnowingCollection<EndStorageLink> iterator ) {

        return new EndStorageLinkRemoveAction( connection, aFeaturedMri, anAttributeOrAssociationEndMofId, aLink, anIndex, iterator );
    }

    public static UpdateConsistencyRegistryAction createUpdateConsistencyRegistryAction( CoreConnection connection, MRI mriToBeUsed ) {

        return new UpdateConsistencyRegistryAction( connection, mriToBeUsed );
    }
}