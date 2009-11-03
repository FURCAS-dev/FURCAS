package com.sap.tc.moin.repository;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.DeepCopyPolicy.DeepCopyPolicyOption;

/**
 * A DeepCopyMappingEntry is used in the {@link DeepCopyMap} to represent one
 * mapping. It contains the default (original) and modified policies and the
 * mapping target. If the modified policy is STOP, the mapping target is NULL.
 * 
 * @see DeepCopyMap
 * @author d046918
 */
public final class DeepCopyMappingEntry {

    private DeepCopyPolicy originalPolicy;

    private DeepCopyPolicy modifiedPolicy;

    private RefObject mappingTarget;

    /**
     * Creates a new entry for the Deep Copy Mapping Table.
     * 
     * @param originalPolicy The default policy before altered by the policy
     * handler
     * @param modifiedPolicy The policy that the policy handler returned
     * @param mappingTarget The target element of the mapping (is set to null if
     * the modified policy is {@link DeepCopyPolicyOption#STOP}
     */
    public DeepCopyMappingEntry( DeepCopyPolicy originalPolicy, DeepCopyPolicy modifiedPolicy, RefObject mappingTarget ) {

        this.originalPolicy = originalPolicy;
        this.modifiedPolicy = modifiedPolicy;
        if ( modifiedPolicy.getDeepCopyPolicyOption( ) == DeepCopyPolicyOption.STOP ) {
            this.mappingTarget = null;
        } else {
            this.mappingTarget = mappingTarget;
        }
    }


    /**
     * @return the modified policy
     */
    public DeepCopyPolicy getModifiedPolicy( ) {

        return modifiedPolicy;
    }


    /**
     * @return the mapping target
     */
    public RefObject getMappingTarget( ) {

        return mappingTarget;
    }

    /**
     * @return the original policy
     */
    public DeepCopyPolicy getOriginalPolicy( ) {

        return originalPolicy;
    }

    /**
     * @param other the entry with which to compare
     * @return <code>true</code> if this entry is equal to the other entry,
     * <code>false</code> otherwise.
     */
    public boolean equals( DeepCopyMappingEntry other ) {

        if ( other == this ) {
            return true;
        }

        return this.originalPolicy.equals( other.getOriginalPolicy( ) ) && this.modifiedPolicy.equals( other.getModifiedPolicy( ) ) && this.mappingTarget.equals( other.getMappingTarget( ) );
    }

    @Override
    public boolean equals( Object obj ) {

        if ( obj instanceof DeepCopyMappingEntry ) {
            return equals( (DeepCopyMappingEntry) obj );
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( this.mappingTarget == null ) ? 0 : this.mappingTarget.hashCode( ) );
        result = prime * result + ( ( this.modifiedPolicy == null ) ? 0 : this.modifiedPolicy.hashCode( ) );
        result = prime * result + ( ( this.originalPolicy == null ) ? 0 : this.originalPolicy.hashCode( ) );
        return result;
    }



}
