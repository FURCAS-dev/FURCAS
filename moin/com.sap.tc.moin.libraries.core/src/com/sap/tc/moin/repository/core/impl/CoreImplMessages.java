package com.sap.tc.moin.repository.core.impl;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>LriHasToBeResolvedInScopeOfSession_XMSG: A LRI {0} has to be resolved in the scope of a session.</li>
 * <li>AMriHasToBeResolvedInScopeOfSession_XMSG: A MRI {0} has to be resolved in scope of a session, or has to be in the metamodel data area.</li>
 * <li>SessionHasToBeProvided_XMSG: A session has to be provided for resolving non-metamodel data area {0}</li>
 * <li>ArgumentIsNotAResolvedStructureType_XMSG: Argument is not a resolved structured type</li>
 * <li>AssociationEndForHostMustHaveStorage_XMSG: AssociationEnd for host ({0}) must have storage</li>
 * <li>AttemptToCloseASessionWhereStillConnectionsOpen_XMSG: Attempt to call close() on a session with {0} connections still open</li>
 * <li>CannotGetPartitionForArgumentPriEqualsNull_XMSG: Cannot get Partition for argument PRI == null </li>
 * <li>CannotGetElementForArgumentLriEqualsNull_XMSG: Cannot get element for argument LRI == null</li>
 * <li>CannotGetElementForArgumentMriEqualsNull_XMSG: Cannot get element for argument MRI == null</li>
 * <li>CannotResolveMofPackageMri_XMSG: Cannot resolve MOF package MRI {0}</li>
 * <li>CannotResolveMofPackageMriResolvedElementNotInstanceOf_XMSG: Cannot resolve MOF package MRI {0} :  resolved element {1} is not instance of {2}.</li>
 * <li>NotPossibleToDetermineWhichNullPartitionToUse_XMSG: Connection is null and element has no partition, not possible to determine which null partition to use</li>
 * <li>CouldNotGetStageForDataAreaFromWorkspace_XMSG: Couldn't get stage for data area {0} from workspace {1}</li>
 * <li>PrivateCopyFailure_XMSG: Creation of private copy failed as loaded partition {0} couldn't be loaded to session workspace</li>
 * <li>DifferentDataAreas_XMSG: Different data areas! PRI has {0}, stage has {1}</li>
 * <li>ExtentPartitionOnlyAvailableAtMMWorkspace_XMSG: Extent partition is only availabe at metamodel workspace</li>
 * <li>FacilityWithoutMQLQueryService_XMSG: Facility without MQL Query service</li>
 * <li>ForTargetAssociationEndPositionIsNotAllowed_XMSG: For an ordered or multiplicity-1 Target AssociationEnd (like {0}, position {1} is not allowed, only -1</li>
 * <li>HostElementMustNotBeNull_XMSG: Host element must not be null</li>
 * <li>IllegalCallToConnectionWhileCommandIsRunning_XMSG: Illegal call to Connection while Command is running.</li>
 * <li>InvalidMriReturnedByDuplicateElementInconsistencyHandling_XMSG: Invalid MRI returned by the duplicate element inconsistency handling</li>
 * <li>InvalidLockHandle_XMSG: Invalid lock handle!</li>
 * <li>MofRomNotLoadedAtThisTime_XMSG: MOIN finalization break-down: MOFROM not loaded at this point!</li>
 * <li>MetamodelDataAreaOrFacilityNotFound_XMSG: Metamodel data area or facility could not be found.</li>
 * <li>MetamodelLriReferenceCanOnlyBeRequestedForMMWorkspace_XMSG: Metamodel lri reference can only be requested for metamodel workspace</li>
 * <li>MetamodelMriReferenceCanOnlyBeRequestedForMMWorkspace_XMSG: Metamodel mri reference can only be requested for metamodel workspace</li>
 * <li>MetamodelWsSetMustNotBeAskedForNonMMWorkspaces_XMSG: Metamodel workspace set must not be asked for non-metamodel workspaces.</li>
 * <li>MethodNotAvailable_XMSG: Method not available on core connection</li>
 * <li>MoinIsAlreadyInitialized_XMSG: Moin is already initialized - shutdown has to be called before reinitialization.</li>
 * <li>NoJavaClassFoundForElement_XMSG: No Java class could be found for the following element: {0}</li>
 * <li>NoLongerSupported_XMSG: No longer supported in the Core</li>
 * <li>NoQualifiedNameSpecified_XMSG: No qualified name specified in 'Connection.getPackage'</li>
 * <li>NotSupportedInCore_XMSG: Not supported in the Core</li>
 * <li>PartitionNameIsIllegal_XMSG: Partition name {0} is illegal. It must not be null, empty or must only contain ASCII letters, digits or '_'</li>
 * <li>PartitionsToEvictGroupedByStageMustNotBeNull_XMSG: Partitions to evict grouped by stage must not be null</li>
 * <li>PriReferenceRequestedByNonMMSharedWorkspace_XMSG: PriReference requested by a non-metamodel SharedWorkspace</li>
 * <li>SaveNotAllowedInMemoryChangeOnlyConnection_XMSG: Saving a connection that is in memory-change-only mode is not allowed</li>
 * <li>SessionCanOnlyBeSetOnce_XMSG: Session can only be set once for SessionWorkspace</li>
 * <li>SharedStagesHaveNoClientspecId_XMSG: Shared stages have no clientspec-id</li>
 * <li>NoClientspecId_XMSG: Shared stages have no clientspec-id!</li>
 * <li>TargetAssociationEndMustNotBeNull_XMSG: Target AssociationEnd must not be null</li>
 * <li>TargetLRIMustNotBeNull_XMSG: Target LRI must not be null</li>
 * <li>ClientSpecificSessionCouldNotBeFound_XMSG: The client-specific Workspace for Session {0} could not be found and removed from the WorkspaceSet.</li>
 * <li>TheMMWorkspaceDoesNotProvideAnyServices_XMSG: The metamodel workspace set does not provide any services</li>
 * <li>InstanceDoesNotSupportQueryLinkManager_XMSG: This instance doesn't support a QueryLinkManager</li>
 * <li>ThisMethodShouldNotBeCalledInternally__CoreConnection_getCoreJmiHelper_XMSG: This method should not be called internally, use CoreConnection.getCoreJmiHelper() instead</li>
 * <li>UnexpectedOldRefPackageJavaProxyElementFound_XMSG: Unexpected old RefPackage Java proxy element found</li>
 * <li>UnexpectedOperationType_XMSG: Unexpected operation type {0}</li>
 * <li>UnexpectedSaveOperationType_XMSG: Unexpected save operation type {0}</li>
 * <li>UnwrappedModelExporterNotSupported_XMSG: Unwrapped Model Exporter not supported</li>
 * <li>UnwrappedModelImporterNotSupported_XMSG: Unwrapped Model Importer not supported</li>
 * <li>WorkspaceOfPartitionIsNull_XMSG: Workspace of partition {0} is null</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from CoreImplMessages.properties
 */
 
public enum CoreImplMessages implements MoinLocalizedString {


    /**
     * Message: "A MRI {0} has to be resolved in scope of a session, or has to be in the metamodel data area."
     */
    AMRIHASTOBERESOLVEDINSCOPEOFSESSION("AMriHasToBeResolvedInScopeOfSession_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Argument is not a resolved structured type"
     */
    ARGUMENTISNOTARESOLVEDSTRUCTURETYPE("ArgumentIsNotAResolvedStructureType_XMSG"), //$NON-NLS-1$

    /**
     * Message: "AssociationEnd for host ({0}) must have storage"
     */
    ASSOCIATIONENDFORHOSTMUSTHAVESTORAGE("AssociationEndForHostMustHaveStorage_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Attempt to call close() on a session with {0} connections still open"
     */
    ATTEMPTTOCLOSEASESSIONWHERESTILLCONNECTIONSOPEN("AttemptToCloseASessionWhereStillConnectionsOpen_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Cannot get element for argument LRI == null"
     */
    CANNOTGETELEMENTFORARGUMENTLRIEQUALSNULL("CannotGetElementForArgumentLriEqualsNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Cannot get element for argument MRI == null"
     */
    CANNOTGETELEMENTFORARGUMENTMRIEQUALSNULL("CannotGetElementForArgumentMriEqualsNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Cannot get Partition for argument PRI == null "
     */
    CANNOTGETPARTITIONFORARGUMENTPRIEQUALSNULL("CannotGetPartitionForArgumentPriEqualsNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Cannot resolve MOF package MRI {0} :  resolved element {1} is not instance of {2}."
     */
    CANNOTRESOLVEMOFPACKAGEMRIRESOLVEDELEMENTNOTINSTANCEOF("CannotResolveMofPackageMriResolvedElementNotInstanceOf_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Cannot resolve MOF package MRI {0}"
     */
    CANNOTRESOLVEMOFPACKAGEMRI("CannotResolveMofPackageMri_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The client-specific Workspace for Session {0} could not be found and removed from the WorkspaceSet."
     */
    CLIENTSPECIFICSESSIONCOULDNOTBEFOUND("ClientSpecificSessionCouldNotBeFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Couldn't get stage for data area {0} from workspace {1}"
     */
    COULDNOTGETSTAGEFORDATAAREAFROMWORKSPACE("CouldNotGetStageForDataAreaFromWorkspace_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Different data areas! PRI has {0}, stage has {1}"
     */
    DIFFERENTDATAAREAS("DifferentDataAreas_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Extent partition is only availabe at metamodel workspace"
     */
    EXTENTPARTITIONONLYAVAILABLEATMMWORKSPACE("ExtentPartitionOnlyAvailableAtMMWorkspace_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Facility without MQL Query service"
     */
    FACILITYWITHOUTMQLQUERYSERVICE("FacilityWithoutMQLQueryService_XMSG"), //$NON-NLS-1$

    /**
     * Message: "For an ordered or multiplicity-1 Target AssociationEnd (like {0}, position {1} is not allowed, only -1"
     */
    FORTARGETASSOCIATIONENDPOSITIONISNOTALLOWED("ForTargetAssociationEndPositionIsNotAllowed_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Host element must not be null"
     */
    HOSTELEMENTMUSTNOTBENULL("HostElementMustNotBeNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Illegal call to Connection while Command is running."
     */
    ILLEGALCALLTOCONNECTIONWHILECOMMANDISRUNNING("IllegalCallToConnectionWhileCommandIsRunning_XMSG"), //$NON-NLS-1$

    /**
     * Message: "This instance doesn't support a QueryLinkManager"
     */
    INSTANCEDOESNOTSUPPORTQUERYLINKMANAGER("InstanceDoesNotSupportQueryLinkManager_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Invalid lock handle!"
     */
    INVALIDLOCKHANDLE("InvalidLockHandle_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Invalid MRI returned by the duplicate element inconsistency handling"
     */
    INVALIDMRIRETURNEDBYDUPLICATEELEMENTINCONSISTENCYHANDLING("InvalidMriReturnedByDuplicateElementInconsistencyHandling_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A LRI {0} has to be resolved in the scope of a session."
     */
    LRIHASTOBERESOLVEDINSCOPEOFSESSION("LriHasToBeResolvedInScopeOfSession_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Metamodel data area or facility could not be found."
     */
    METAMODELDATAAREAORFACILITYNOTFOUND("MetamodelDataAreaOrFacilityNotFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Metamodel lri reference can only be requested for metamodel workspace"
     */
    METAMODELLRIREFERENCECANONLYBEREQUESTEDFORMMWORKSPACE("MetamodelLriReferenceCanOnlyBeRequestedForMMWorkspace_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Metamodel mri reference can only be requested for metamodel workspace"
     */
    METAMODELMRIREFERENCECANONLYBEREQUESTEDFORMMWORKSPACE("MetamodelMriReferenceCanOnlyBeRequestedForMMWorkspace_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Metamodel workspace set must not be asked for non-metamodel workspaces."
     */
    METAMODELWSSETMUSTNOTBEASKEDFORNONMMWORKSPACES("MetamodelWsSetMustNotBeAskedForNonMMWorkspaces_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Method not available on core connection"
     */
    METHODNOTAVAILABLE("MethodNotAvailable_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MOIN finalization break-down: MOFROM not loaded at this point!"
     */
    MOFROMNOTLOADEDATTHISTIME("MofRomNotLoadedAtThisTime_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Moin is already initialized - shutdown has to be called before reinitialization."
     */
    MOINISALREADYINITIALIZED("MoinIsAlreadyInitialized_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Shared stages have no clientspec-id!"
     */
    NOCLIENTSPECID("NoClientspecId_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No Java class could be found for the following element: {0}"
     */
    NOJAVACLASSFOUNDFORELEMENT("NoJavaClassFoundForElement_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No longer supported in the Core"
     */
    NOLONGERSUPPORTED("NoLongerSupported_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No qualified name specified in 'Connection.getPackage'"
     */
    NOQUALIFIEDNAMESPECIFIED("NoQualifiedNameSpecified_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Connection is null and element has no partition, not possible to determine which null partition to use"
     */
    NOTPOSSIBLETODETERMINEWHICHNULLPARTITIONTOUSE("NotPossibleToDetermineWhichNullPartitionToUse_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Not supported in the Core"
     */
    NOTSUPPORTEDINCORE("NotSupportedInCore_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition name {0} is illegal. It must not be null, empty or must only contain ASCII letters, digits or '_'"
     */
    PARTITIONNAMEISILLEGAL("PartitionNameIsIllegal_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partitions to evict grouped by stage must not be null"
     */
    PARTITIONSTOEVICTGROUPEDBYSTAGEMUSTNOTBENULL("PartitionsToEvictGroupedByStageMustNotBeNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "PriReference requested by a non-metamodel SharedWorkspace"
     */
    PRIREFERENCEREQUESTEDBYNONMMSHAREDWORKSPACE("PriReferenceRequestedByNonMMSharedWorkspace_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Creation of private copy failed as loaded partition {0} couldn't be loaded to session workspace"
     */
    PRIVATECOPYFAILURE("PrivateCopyFailure_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Saving a connection that is in memory-change-only mode is not allowed"
     */
    SAVENOTALLOWEDINMEMORYCHANGEONLYCONNECTION("SaveNotAllowedInMemoryChangeOnlyConnection_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Session can only be set once for SessionWorkspace"
     */
    SESSIONCANONLYBESETONCE("SessionCanOnlyBeSetOnce_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A session has to be provided for resolving non-metamodel data area {0}"
     */
    SESSIONHASTOBEPROVIDED("SessionHasToBeProvided_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Shared stages have no clientspec-id"
     */
    SHAREDSTAGESHAVENOCLIENTSPECID("SharedStagesHaveNoClientspecId_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Target AssociationEnd must not be null"
     */
    TARGETASSOCIATIONENDMUSTNOTBENULL("TargetAssociationEndMustNotBeNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Target LRI must not be null"
     */
    TARGETLRIMUSTNOTBENULL("TargetLRIMustNotBeNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The metamodel workspace set does not provide any services"
     */
    THEMMWORKSPACEDOESNOTPROVIDEANYSERVICES("TheMMWorkspaceDoesNotProvideAnyServices_XMSG"), //$NON-NLS-1$

    /**
     * Message: "This method should not be called internally, use CoreConnection.getCoreJmiHelper() instead"
     */
    THISMETHODSHOULDNOTBECALLEDINTERNALLY__CORECONNECTION_GETCOREJMIHELPER("ThisMethodShouldNotBeCalledInternally__CoreConnection_getCoreJmiHelper_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected old RefPackage Java proxy element found"
     */
    UNEXPECTEDOLDREFPACKAGEJAVAPROXYELEMENTFOUND("UnexpectedOldRefPackageJavaProxyElementFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected operation type {0}"
     */
    UNEXPECTEDOPERATIONTYPE("UnexpectedOperationType_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected save operation type {0}"
     */
    UNEXPECTEDSAVEOPERATIONTYPE("UnexpectedSaveOperationType_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unwrapped Model Exporter not supported"
     */
    UNWRAPPEDMODELEXPORTERNOTSUPPORTED("UnwrappedModelExporterNotSupported_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unwrapped Model Importer not supported"
     */
    UNWRAPPEDMODELIMPORTERNOTSUPPORTED("UnwrappedModelImporterNotSupported_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Workspace of partition {0} is null"
     */
    WORKSPACEOFPARTITIONISNULL("WorkspaceOfPartitionIsNull_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( CoreImplMessages.class );

    private final String myKey;

    private CoreImplMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + CoreImplMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  