package com.sap.tc.moin.repository.core;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.localization.LocalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Localized Messages in alphabetical order:
 * <ol>
 * <li>JmiInstantiationFailed_XMSG: A JMI Object could not be instantiated, root cause: {0}</li>
 * <li>RecoverableExceptionOccuredX_XMSG: A recoverable Exception was encountered: "{0}"</li>
 * <li>UnexpectedOclRegistrytionType_XMSG: An unexpected subclass of OclRegistration was encountered</li>
 * <li>CannotUseXFromConnection_XMSG: Cannot use {0} from connection {1} in context of connection {2}</li>
 * <li>CollectionInvalid_XMSG: Collection for element with LRI "{0}" is no longer valid, connection: {1}</li>
 * <li>ConnectionIsInvalid_XMSG: Connection cannot be used because it is not alive. Connection id {0}, label {1}.</li>
 * <li>ConnectionIsNull_XMSG: Connection is null</li>
 * <li>OclMMConstraintRegistryInitError_XMSG: Could not initialize the metamodel constraint registry</li>
 * <li>ModelElementNotResolvedFromSession_XMSG: Element with MRI "{0}" could not be resolved in session "{1}"</li>
 * <li>ElementDeleted_XMSG: Element with the MofId "{0}" has been deleted, therefore this corresponding attribute collection is no longer valid. Connection: "{1}"</li>
 * <li>LRINotResolved_XMSG: LRI "{0}" could not be resolved</li>
 * <li>MRINotResolved_XMSG: MRI "{0}" could not be resolved</li>
 * <li>PRINotResolved_XMSG: PRI "{0}" could not be resolved</li>
 * <li>PartitionConnectionNull_XMSG: Partition with PRI "{0}" can not be used as the connection is null or invalid</li>
 * <li>PartitionNotResolvedFromSession_XMSG: Partition with PRI "{0}" could not be resolved in session "{1}"</li>
 * <li>PartitionRetrieveNull_XMSG: Partition with PRI "{0}" could not be retrieved from the wrapper reference</li>
 * <li>PartitionIsInvalid_XMSG: Partition with PRI "{0}" is invalid</li>
 * <li>ReadOnlyPartitionCannotBeChanged_XMSG: Read-Only partition cannot be changed {0}</li>
 * <li>SessionIsInvalid_XMSG: Session is not alive</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from JmiCoreMessages.properties
 */
 
public enum JmiCoreMessages implements MoinLocalizedString {


    /**
     * Message: "Cannot use {0} from connection {1} in context of connection {2}"
     */
    CANNOTUSEXFROMCONNECTION("CannotUseXFromConnection_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Collection for element with LRI "{0}" is no longer valid, connection: {1}"
     */
    COLLECTIONINVALID("CollectionInvalid_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Connection cannot be used because it is not alive. Connection id {0}, label {1}."
     */
    CONNECTIONISINVALID("ConnectionIsInvalid_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Connection is null"
     */
    CONNECTIONISNULL("ConnectionIsNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Element with the MofId "{0}" has been deleted, therefore this corresponding attribute collection is no longer valid. Connection: "{1}""
     */
    ELEMENTDELETED("ElementDeleted_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A JMI Object could not be instantiated, root cause: {0}"
     */
    JMIINSTANTIATIONFAILED("JmiInstantiationFailed_XMSG"), //$NON-NLS-1$

    /**
     * Message: "LRI "{0}" could not be resolved"
     */
    LRINOTRESOLVED("LRINotResolved_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MRI "{0}" could not be resolved"
     */
    MRINOTRESOLVED("MRINotResolved_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Element with MRI "{0}" could not be resolved in session "{1}""
     */
    MODELELEMENTNOTRESOLVEDFROMSESSION("ModelElementNotResolvedFromSession_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not initialize the metamodel constraint registry"
     */
    OCLMMCONSTRAINTREGISTRYINITERROR("OclMMConstraintRegistryInitError_XMSG"), //$NON-NLS-1$

    /**
     * Message: "PRI "{0}" could not be resolved"
     */
    PRINOTRESOLVED("PRINotResolved_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition with PRI "{0}" can not be used as the connection is null or invalid"
     */
    PARTITIONCONNECTIONNULL("PartitionConnectionNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition with PRI "{0}" is invalid"
     */
    PARTITIONISINVALID("PartitionIsInvalid_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition with PRI "{0}" could not be resolved in session "{1}""
     */
    PARTITIONNOTRESOLVEDFROMSESSION("PartitionNotResolvedFromSession_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Partition with PRI "{0}" could not be retrieved from the wrapper reference"
     */
    PARTITIONRETRIEVENULL("PartitionRetrieveNull_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Read-Only partition cannot be changed {0}"
     */
    READONLYPARTITIONCANNOTBECHANGED("ReadOnlyPartitionCannotBeChanged_XMSG"), //$NON-NLS-1$

    /**
     * Message: "A recoverable Exception was encountered: "{0}""
     */
    RECOVERABLEEXCEPTIONOCCUREDX("RecoverableExceptionOccuredX_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Session is not alive"
     */
    SESSIONISINVALID("SessionIsInvalid_XMSG"), //$NON-NLS-1$

    /**
     * Message: "An unexpected subclass of OclRegistration was encountered"
     */
    UNEXPECTEDOCLREGISTRYTIONTYPE("UnexpectedOclRegistrytionType_XMSG"); //$NON-NLS-1$

    private final static LocalizedResourceBundleAccessor ACCESSOR = new LocalizedResourceBundleAccessor( JmiCoreMessages.class );

    private final String myKey;

    private JmiCoreMessages( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );
    }

    public String getLocalizedMessage( Locale locale ) {

        try {
            return ACCESSOR.getMessageText( locale, this.myKey );
        } catch ( RuntimeException e ) {
            return "Localization failed for ResourceBundle " + JmiCoreMessages.class.getName( ) + " Key: " + this.myKey; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}  