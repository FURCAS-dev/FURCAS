package com.sap.tc.moin.repository.messages.core;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>LockingExceptionEncountered_XMSG: A Locking exception occurred while calculating the partitions to be locked, PRI: "{0}"</li>
 * <li>PARAM_IS_NULL_XMSG: A parameter was null</li>
 * <li>PRI_MUST_NOT_CONTAIN_MOF_ID_XMSG: A partition identifier must not contain a MOF id</li>
 * <li>IllegalRelocateAction_XMSG: Action would relocate model element "{0}" from data area "{1}" to data area "{2}" which is illegal</li>
 * <li>moin_1011_XMSG: Adding link {0} would create a composition cycle</li>
 * <li>NO_FACILITY_DEFINED_XMSG: Cannot create MRI: no facility defined</li>
 * <li>moin_1009_XMSG: Cannot evict null partition</li>
 * <li>CouldntGetPartitionForPRI_XMSG: Could not get partition for PRI "{0}"</li>
 * <li>CouldntGetStage_XMSG: Couldn't get stage for data area "{0}" from workspace "{1}"</li>
 * <li>DUPLICATE_ELEMENT_DELETE_OTHERS_CORRECTION_XMSG: Delete all duplicate elements with id {0} except the one in partition {1}</li>
 * <li>ALL_DANGLING_LINK_DELETE_CORRECTION_XMSG: Delete all known dangling links of the partition</li>
 * <li>DUPLICATE_ELEMENT_ELEMENT_DELETE_CORRECTION_XMSG: Delete element {0} from partition {1}</li>
 * <li>DANGLING_LINK_LINK_DELETE_CORRECTION_XMSG: Delete link from {0} to {1}</li>
 * <li>moin_repository_core_2003_XMSG: Element to add to model partition must not be null</li>
 * <li>ElementToAssignNotNull_XMSG: Element to assign to partition {0} must not be null</li>
 * <li>moin_repository_core_2002_XMSG: Element to remove from model partition must not be null</li>
 * <li>moin_repository_core_2008_XMSG: Element whose component children in the same partition are to be determined must not be null</li>
 * <li>ElementDeleted_XMSG: Element with the MofId "{0}" has been deleted, therefore this corresponding attribute collection is no longer valid. Connection: "{1}".</li>
 * <li>DUPLICATE_ELEMENT_CONSISTENCY_VIOLATION_XMSG: Element {0} ({1}) is a duplicate</li>
 * <li>DUPLICATE_PARENT_CONSISTENCY_VIOLATION_XMSG: Element {1} is a duplicate composite parent of element {0}</li>
 * <li>DANGLING_LINK_CONSISTENCY_VIOLATION_XMSG: End {0} of link is missing. Existing end: {1}({2}). Missing end:{3}. Link type: {4} ({5})</li>
 * <li>FACILITY_NOT_FOUND_XMSG: Facility {0} not found</li>
 * <li>FailedToGetUtilitiesImplementation_XMSG: Failed to get the Utilities implementation via Reflection</li>
 * <li>LINK_PERMISSION_CONSISTENCY_VIOLATION_XMSG: Link from Partition {0} to partition {1} is not allowed</li>
 * <li>IllegalLinkMetamodelToModel_XMSG: Link from element "{0}" to element "{1}" on behalf of meta object (Attribute or Association "{2}") is illegal since it would create a connection between a model and a meta model</li>
 * <li>MANDATORY_PARAMETER_MISSING_XMSG: Mandatory parameter '{0}' must not be null</li>
 * <li>moin_repository_core_1010_XMSG: Model partition {0} currently cannot be evicted_ Is a transaction still using it?</li>
 * <li>MMPartitionCanNotBeChanged_XMSG: ModelPartition "{0}" of metamodel Workspace cannot be changed</li>
 * <li>MOFID_CANNOT_BE_OVERWRITTEN_001_XMSG: Mof-id of MRI cannot be overwritten</li>
 * <li>SOME_PARTITIONS_NOT_SAVED_XMSG: One or more modified partitions were not saved</li>
 * <li>DuplicatePackages_XMSG: Package name "{0}" us ambiguous</li>
 * <li>PartitionAlreadyExists_XMSG: Partition already exists, PRI: "{0}"</li>
 * <li>PartitionIsTransient_XMSG: Partition can not be created on persistence as it is transient or volatile, PRI: "{0}"</li>
 * <li>PartitionNotCreatableLM_XMSG: Partition can not be modified due to lifecycle management restrictions, PRI: "{0}"</li>
 * <li>PartitionIsInvalid_XMSG: Partition is not valid, PRI: "{0}"</li>
 * <li>PartitionModifFailedDueToFacilityException_XMSG: Partition modification failed due to a facility exception, PRI: "{0}"</li>
 * <li>PartitionToAssignNotNull_XMSG: Partition to assign element {0} must not be null</li>
 * <li>NullPartitionNotDeletable_XMSG: The "null" partition can not be deleted, PRI: "{0}"</li>
 * <li>WRONG_CONTAINER_TYPE_FOR_INSTANCES_XMSG: The instance manager is expected to use a CorePartitionable or List for holding model element instances but not a {0}</li>
 * <li>INSTANCE_ALREADY_HOSTED_XMSG: The instance {0} is already hosted in the instance manager and cannot be added again</li>
 * <li>MAX_NUMBER_OF_CONNECTIONS_REACHED_XMSG: The maximum number of Connections for Session {0} is reached. Number of Connections: 1</li>
 * <li>INSTANCE_DOES_NOT_MATCH_KEY_XMSG: The model element instance {0} has not been keyed with the LRI {1} and can therefore not be removed from the InstanceManager</li>
 * <li>NoLegalNameForTransientPartition_XMSG: The name {0} is not legal for a transient partition</li>
 * <li>TransientElementReferenced_XMSG: There are still transient elements which are referenced from non-transient partitions</li>
 * <li>MQL_NOT_AVAILABLE_XMSG: There is no MQL processor available for the current configuration of MOIN. This likely means that your MOIN configuration is broken</li>
 * <li>TransientPartitionCanNotChangedByOtherConn_XMSG: Transient partition cannot be changed by another connection, PRI: "{0}"</li>
 * <li>EventVetoed_XMSG: Veto received, reason: {0}</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from RepositoryCoreMessages.properties
 */
 
public enum RepositoryCoreMessages implements MoinLocalizedString {


    /**
     * Message: "Delete all known dangling links of the partition"
     */
    ALL_DANGLING_LINK_DELETE_CORRECTION("ALL_DANGLING_LINK_DELETE_CORRECTION_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not get partition for PRI "{0}""
     */
    COULDNTGETPARTITIONFORPRI("CouldntGetPartitionForPRI_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Couldn't get stage for data area "{0}" from workspace "{1}""
     */
    COULDNTGETSTAGE("CouldntGetStage_XMSG"), //$NON-NLS-1$

    /**
     * Message: "End {0} of link is missing. Existing end: {1}({2}). Missing end:{3}. Link type: {4} ({5})"
     */
    DANGLING_LINK_CONSISTENCY_VIOLATION("DANGLING_LINK_CONSISTENCY_VIOLATION_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Delete link from {0} to {1}"
     */
    DANGLING_LINK_LINK_DELETE_CORRECTION("DANGLING_LINK_LINK_DELETE_CORRECTION_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Element {0} ({1}) is a duplicate"
     */
    DUPLICATE_ELEMENT_CONSISTENCY_VIOLATION("DUPLICATE_ELEMENT_CONSISTENCY_VIOLATION_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Delete all duplicate elements with id {0} except the one in partition {1}"
     */
    DUPLICATE_ELEMENT_DELETE_OTHERS_CORRECTION("DUPLICATE_ELEMENT_DELETE_OTHERS_CORRECTION_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Delete element {0} from partition {1}"
     */
    DUPLICATE_ELEMENT_ELEMENT_DELETE_CORRECTION("DUPLICATE_ELEMENT_ELEMENT_DELETE_CORRECTION_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Element {1} is a duplicate composite parent of element {0}"
     */
    DUPLICATE_PARENT_CONSISTENCY_VIOLATION("DUPLICATE_PARENT_CONSISTENCY_VIOLATION_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Package name "{0}" us ambiguous"
     */
    DUPLICATEPACKAGES("DuplicatePackages_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Element with the MofId "{0}" has been deleted, therefore this corresponding attribute collection is no longer valid. Connection: "{1}"."
     */
    ELEMENTDELETED("ElementDeleted_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Element to assign to partition {0} must not be null"
     */
    ELEMENTTOASSIGNNOTNULL("ElementToAssignNotNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Veto received, reason: {0}"
     */
    EVENTVETOED("EventVetoed_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Facility {0} not found"
     */
    FACILITY_NOT_FOUND("FACILITY_NOT_FOUND_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Failed to get the Utilities implementation via Reflection"
     */
    FAILEDTOGETUTILITIESIMPLEMENTATION("FailedToGetUtilitiesImplementation_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The instance {0} is already hosted in the instance manager and cannot be added again"
     */
    INSTANCE_ALREADY_HOSTED("INSTANCE_ALREADY_HOSTED_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The model element instance {0} has not been keyed with the LRI {1} and can therefore not be removed from the InstanceManager"
     */
    INSTANCE_DOES_NOT_MATCH_KEY("INSTANCE_DOES_NOT_MATCH_KEY_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Link from element "{0}" to element "{1}" on behalf of meta object (Attribute or Association "{2}") is illegal since it would create a connection between a model and a meta model"
     */
    ILLEGALLINKMETAMODELTOMODEL("IllegalLinkMetamodelToModel_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Action would relocate model element "{0}" from data area "{1}" to data area "{2}" which is illegal"
     */
    ILLEGALRELOCATEACTION("IllegalRelocateAction_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Link from Partition {0} to partition {1} is not allowed"
     */
    LINK_PERMISSION_CONSISTENCY_VIOLATION("LINK_PERMISSION_CONSISTENCY_VIOLATION_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A Locking exception occurred while calculating the partitions to be locked, PRI: "{0}""
     */
    LOCKINGEXCEPTIONENCOUNTERED("LockingExceptionEncountered_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Mandatory parameter '{0}' must not be null"
     */
    MANDATORY_PARAMETER_MISSING("MANDATORY_PARAMETER_MISSING_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The maximum number of Connections for Session {0} is reached. Number of Connections: 1"
     */
    MAX_NUMBER_OF_CONNECTIONS_REACHED("MAX_NUMBER_OF_CONNECTIONS_REACHED_XMSG"), //$NON-NLS-1$

    /**
     * Message: "ModelPartition "{0}" of metamodel Workspace cannot be changed"
     */
    MMPARTITIONCANNOTBECHANGED("MMPartitionCanNotBeChanged_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Mof-id of MRI cannot be overwritten"
     */
    MOFID_CANNOT_BE_OVERWRITTEN_001("MOFID_CANNOT_BE_OVERWRITTEN_001_XMSG"), //$NON-NLS-1$

    /**
     * Message: "There is no MQL processor available for the current configuration of MOIN. This likely means that your MOIN configuration is broken"
     */
    MQL_NOT_AVAILABLE("MQL_NOT_AVAILABLE_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Cannot create MRI: no facility defined"
     */
    NO_FACILITY_DEFINED("NO_FACILITY_DEFINED_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The name {0} is not legal for a transient partition"
     */
    NOLEGALNAMEFORTRANSIENTPARTITION("NoLegalNameForTransientPartition_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The "null" partition can not be deleted, PRI: "{0}""
     */
    NULLPARTITIONNOTDELETABLE("NullPartitionNotDeletable_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A parameter was null"
     */
    PARAM_IS_NULL("PARAM_IS_NULL_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A partition identifier must not contain a MOF id"
     */
    PRI_MUST_NOT_CONTAIN_MOF_ID("PRI_MUST_NOT_CONTAIN_MOF_ID_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition already exists, PRI: "{0}""
     */
    PARTITIONALREADYEXISTS("PartitionAlreadyExists_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition is not valid, PRI: "{0}""
     */
    PARTITIONISINVALID("PartitionIsInvalid_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition can not be created on persistence as it is transient or volatile, PRI: "{0}""
     */
    PARTITIONISTRANSIENT("PartitionIsTransient_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition modification failed due to a facility exception, PRI: "{0}""
     */
    PARTITIONMODIFFAILEDDUETOFACILITYEXCEPTION("PartitionModifFailedDueToFacilityException_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition can not be modified due to lifecycle management restrictions, PRI: "{0}""
     */
    PARTITIONNOTCREATABLELM("PartitionNotCreatableLM_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition to assign element {0} must not be null"
     */
    PARTITIONTOASSIGNNOTNULL("PartitionToAssignNotNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "One or more modified partitions were not saved"
     */
    SOME_PARTITIONS_NOT_SAVED("SOME_PARTITIONS_NOT_SAVED_XMSG"), //$NON-NLS-1$

    /**
     * Message: "There are still transient elements which are referenced from non-transient partitions"
     */
    TRANSIENTELEMENTREFERENCED("TransientElementReferenced_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Transient partition cannot be changed by another connection, PRI: "{0}""
     */
    TRANSIENTPARTITIONCANNOTCHANGEDBYOTHERCONN("TransientPartitionCanNotChangedByOtherConn_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The instance manager is expected to use a CorePartitionable or List for holding model element instances but not a {0}"
     */
    WRONG_CONTAINER_TYPE_FOR_INSTANCES("WRONG_CONTAINER_TYPE_FOR_INSTANCES_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Cannot evict null partition"
     */
    MOIN_1009("moin_1009_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Adding link {0} would create a composition cycle"
     */
    MOIN_1011("moin_1011_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Model partition {0} currently cannot be evicted_ Is a transaction still using it?"
     */
    MOIN_REPOSITORY_CORE_1010("moin_repository_core_1010_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Element to remove from model partition must not be null"
     */
    MOIN_REPOSITORY_CORE_2002("moin_repository_core_2002_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Element to add to model partition must not be null"
     */
    MOIN_REPOSITORY_CORE_2003("moin_repository_core_2003_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Element whose component children in the same partition are to be determined must not be null"
     */
    MOIN_REPOSITORY_CORE_2008("moin_repository_core_2008_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( RepositoryCoreMessages.class );

    private final String myKey;

    private RepositoryCoreMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + RepositoryCoreMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  