package com.sap.tc.moin.repository;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * The DeepCopyPolicy determines how a model element will be processed during a
 * deep copy.
 * 
 * @see Connection#deepCopy(java.util.Collection, DeepCopyPolicyHandler,
 * boolean)
 * @author D045996
 */
public final class DeepCopyPolicy {

    /**
     * 
     *
     */
    public enum DeepCopyPolicyOption {
        /**
         * Duplicates (copy) the original element including every attribute
         * value. References to the original element are redirected to the
         * duplicate.
         */
        FULL_COPY,
        /**
         * Do not duplicate the element. Other duplicated elements reference
         * this original element.
         */
        REF_COPY,
        /**
         * Do not duplicate the element. Any reference to this element is
         * ignored.
         */
        STOP,
        /**
         * Uses a client-provided element as copy for the original element.
         * References are handled as FULL_COPY
         */
        CUSTOM
    }

    private DeepCopyPolicyOption option;

    private RefObject customElement;

    /**
     * Creates a new Deep Copying Policy. If the given "option" is
     * {@link DeepCopyPolicyOption#CUSTOM}, the "customElement" is stored inside
     * the policy. Otherwise, the "customElement" is set to NULL.
     * 
     * @param option The policy option
     * @param customElement The custom element, if policy is
     * {@link DeepCopyPolicyOption#CUSTOM}
     */
    public DeepCopyPolicy( DeepCopyPolicyOption option, RefObject customElement ) {

        this.option = option;
        this.customElement = customElement;
    }

    /**
     * Returns the policy option.
     * 
     * @return the policy option.
     */
    public DeepCopyPolicyOption getDeepCopyPolicyOption( ) {

        return option;
    }

    /**
     * A custom element is only used for the CUSTOM option.
     * 
     * @return the custom element
     */
    public RefObject getCustomElement( ) {

        return customElement;
    }

    @Override
    public String toString( ) {

        switch ( option ) {
            case FULL_COPY:
                return "FULL_COPY"; //$NON-NLS-1$
            case REF_COPY:
                return "REF_COPY"; //$NON-NLS-1$
            case STOP:
                return "STOP"; //$NON-NLS-1$
            case CUSTOM:
                return "CUSTOM"; //$NON-NLS-1$
        }

        return ""; //$NON-NLS-1$
    }

    /**
     * @param other the other policy with which to compare.
     * @return <code>true</code> if this policy is equal to the other policy,
     * <code>false</code> otherwise.
     */
    public boolean equals( DeepCopyPolicy other ) {

        if ( other == this ) {
            return true;
        }

        if ( this.option == DeepCopyPolicyOption.CUSTOM ) {

            boolean equal;
            equal = this.option.equals( other.getDeepCopyPolicyOption( ) );
            if ( this.customElement == null ) {
                equal &= ( other.getCustomElement( ) == null );
            } else {
                equal &= this.customElement.equals( other.getCustomElement( ) );
            }
            return equal;

        }
        return ( this.option.equals( other.getDeepCopyPolicyOption( ) ) );

    }

    @Override
    public boolean equals( Object obj ) {

        if ( obj instanceof DeepCopyPolicy ) {
            return equals( (DeepCopyPolicy) obj );
        }

        return false;
    }

    @Override
    public int hashCode( ) {

        return option.hashCode( );
    }


}
