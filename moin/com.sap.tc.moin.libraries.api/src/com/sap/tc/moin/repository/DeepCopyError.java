package com.sap.tc.moin.repository;

/**
 * A deep copy error represents an error that has happened during the copy
 * process. The error did not cause the copy process to stop. The decision is
 * left to the client whether to roll back the copy process or to ignore the
 * error.
 * 
 * @author d046918
 */
public final class DeepCopyError {

    /**
     * Classification for deep copy errors:
     * <p>
     * ERR_001: unspecific error<br>
     * ERR_002: copy policy not set<br>
     * ERR_003: custom element is NULL<br>
     * ERR_004: handler tries to change STOP or CUSTOM<br>
     * ERR_005: handler tries to change FULL_COPY->REF_COPY<br>
     * ERR_006: custom element has wrong type<br>
     * ERR_007: wrong cardinalities when creating links<br>
     * ERR_008: partition locked when trying to create link<br>
     * ERR_009: two different connections when creating link <br>
     * ERR_010: custom element not resolvable <br>
     */
    public enum DeepCopyErrorType {
        /**
         * unspecific error
         */
        ERR_001,
        /**
         * copy policy not set
         */
        ERR_002,
        /**
         * custom element is NULL
         */
        ERR_003,
        /**
         * handler tries to change STOP or CUSTOM
         */
        ERR_004,
        /**
         * handler tries to change FULL_COPY->REF_COPY
         */
        ERR_005,
        /**
         * custom element has wrong type
         */
        ERR_006,
        /**
         * wrong cardinalities when creating links
         */
        ERR_007,
        /**
         * partition locked when trying to create link
         */
        ERR_008,
        /**
         * two different connections when creating link
         */
        ERR_009,
        /**
         * custom element not accessible from current connection
         */
        ERR_010
    }

    private DeepCopyErrorType errorType;

    private MRI mriOfElementInError;

    private LRI lriOfLinkedElement;

    private PRI priOfPartitionInError;

    private String errorMessage;


    /**
     * @param errorType The Classification of the error.
     * @param mriOfElementInError The MRI of the element for which the error
     * occurred.
     * @param lriOfLinkedElement The LRI of the linked element, if error occured
     * during link creation (can be null).
     * @param priOfPartitionInError The PRI of the affected partition (can be
     * null).
     * @param errorMessage Additional error message text (can be empty).
     */

    public DeepCopyError( DeepCopyErrorType errorType, MRI mriOfElementInError, LRI lriOfLinkedElement, PRI priOfPartitionInError, String errorMessage ) {

        this.errorType = errorType;
        this.mriOfElementInError = mriOfElementInError;
        this.lriOfLinkedElement = lriOfLinkedElement;
        this.priOfPartitionInError = priOfPartitionInError;
        this.errorMessage = errorMessage;
    }

    /**
     * non-specific deep copy error
     * 
     * @param errorMessage The message that is passed on as an error message
     */
    public DeepCopyError( String errorMessage ) {

        this.errorType = DeepCopyErrorType.ERR_001;
        this.errorMessage = errorMessage;
    }

    /**
     * Returns the type of the error.
     * 
     * @return the type of the error.
     */
    public DeepCopyErrorType getErrorType( ) {

        return this.errorType;
    }

    /**
     * Returns a textual description of the error
     * 
     * @return a textual description of the error
     */
    @SuppressWarnings( "nls" )
    // this is purely technical
    public String getMessage( ) {

        switch ( this.errorType ) {
            case ERR_001:
                return errorMessage;
            case ERR_002:
                return "The copy policy for the element " + mriOfElementInError.toString( ) + " has not been set.";
            case ERR_003:
                return "In a CUSTOM policy, the custom element cannot be NULL. Please use the policy STOP instead.";
            case ERR_004:
                return "The policies STOP and CUSTOM cannot be changed.";
            case ERR_005:
                return "A policy cannot be changed from FULL_COPY to REF_COPY. (Element: " + mriOfElementInError.toString( ) + ")  " + "The default policy was used instead.";
            case ERR_006:
                return "The custom element " + mriOfElementInError.toString( ) + " does not match the required type.";
            case ERR_007:
                return "The link between element " + mriOfElementInError.toString( ) + " and element " + lriOfLinkedElement.toString( ) + "could not be created:" + errorMessage;
            case ERR_008:
                return "The partition " + priOfPartitionInError.toString( ) + " is locked and could not be modified: " + errorMessage;
            case ERR_009:
                return "The element with the MRI " + mriOfElementInError.toString( ) + "could not be resolved, so the" + "element cannot be referenced.";
            case ERR_010:
                return "The element with the MRI " + mriOfElementInError.toString( ) + "could not be resolved, so the" + "element cannot be referenced.";
            default:
                return "";
        }

    }

    @Override
    @SuppressWarnings( "nls" )
    // this is purely technical
    public String toString( ) {

        return "DeepCopy Error " + errorType.toString( ) + ": " + this.getMessage( );
    }

    /**
     * @return the MRI of the element in error
     */
    public MRI getMriOfElementInError( ) {

        return mriOfElementInError;
    }

    /**
     * @return the LRI of the linked element
     */
    public LRI getLriOfLinkedElement( ) {

        return lriOfLinkedElement;
    }

    /**
     * @return the PRI the element in error belongs to
     */
    public PRI getPriOfElementInError( ) {

        return priOfPartitionInError;
    }

}
