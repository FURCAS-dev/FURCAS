package com.sap.tc.moin.repository.runtimehost.deployment;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>CannotConstructJsContentDeploymentData__ParameterContentArchiveMustNotBeNull_XMSG: Cannot construct JsContentDeployment data - parameter contentArchive must not be null</li>
 * <li>ContentDeploymentDataForContainerAreClosed_XMSG: Content deployment data for container {0} are closed</li>
 * <li>DEFAULT_PARSER_NOT_REGISTERED: Default parser/serializer not registered correctly</li>
 * <li>DEPLOYMENT_ID_NULL: Deployment id must not be null</li>
 * <li>ReferencedFacilityNotFound_XMSG: Facility '{0}' referenced by content archive '{1}' not found</li>
 * <li>InstancesCannotBeOverwritten_XMSG: Instances cannot be overwritten</li>
 * <li>InvalidPartitionNamePattern_XMSG: Invalid model partition name: The name "{0}" does not match a registered partition name pattern. Currently valid patterns are: {1}</li>
 * <li>PartitionInformationNotInitialized_XMSG: Metamodel deployment. The partition information not initialized. Can not find related partition (XMI file) - PRI: {0}</li>
 * <li>PATTERN_COLLISION_XMSG: Pattern {0} is already registered for serialization id {1}. Registration of {2} skipped</li>
 * <li>RemoveNotSupportedByErrorHandlerRegistry_XMSG: Remove not supported by error handler registry</li>
 * <li>GetPartitionStreamFailed_XMSG: getPartitionStream failed</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from RuntimeHostDeploymentMessages.properties
 */
 
public enum RuntimeHostDeploymentMessages implements MoinLocalizedString {


    /**
     * Message: "Cannot construct JsContentDeployment data - parameter contentArchive must not be null"
     */
    CANNOTCONSTRUCTJSCONTENTDEPLOYMENTDATA__PARAMETERCONTENTARCHIVEMUSTNOTBENULL("CannotConstructJsContentDeploymentData__ParameterContentArchiveMustNotBeNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Content deployment data for container {0} are closed"
     */
    CONTENTDEPLOYMENTDATAFORCONTAINERARECLOSED("ContentDeploymentDataForContainerAreClosed_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Default parser/serializer not registered correctly"
     */
    DEFAULT_PARSER_NOT_REGISTERED("DEFAULT_PARSER_NOT_REGISTERED"), //$NON-NLS-1$

    /**
     * Message: "Deployment id must not be null"
     */
    DEPLOYMENT_ID_NULL("DEPLOYMENT_ID_NULL"), //$NON-NLS-1$

    /**
     * Message: "getPartitionStream failed"
     */
    GETPARTITIONSTREAMFAILED("GetPartitionStreamFailed_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Instances cannot be overwritten"
     */
    INSTANCESCANNOTBEOVERWRITTEN("InstancesCannotBeOverwritten_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Invalid model partition name: The name "{0}" does not match a registered partition name pattern. Currently valid patterns are: {1}"
     */
    INVALIDPARTITIONNAMEPATTERN("InvalidPartitionNamePattern_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Pattern {0} is already registered for serialization id {1}. Registration of {2} skipped"
     */
    PATTERN_COLLISION("PATTERN_COLLISION_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Metamodel deployment. The partition information not initialized. Can not find related partition (XMI file) - PRI: {0}"
     */
    PARTITIONINFORMATIONNOTINITIALIZED("PartitionInformationNotInitialized_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Facility '{0}' referenced by content archive '{1}' not found"
     */
    REFERENCEDFACILITYNOTFOUND("ReferencedFacilityNotFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Remove not supported by error handler registry"
     */
    REMOVENOTSUPPORTEDBYERRORHANDLERREGISTRY("RemoveNotSupportedByErrorHandlerRegistry_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( RuntimeHostDeploymentMessages.class );

    private final String myKey;

    private RuntimeHostDeploymentMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + RuntimeHostDeploymentMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  