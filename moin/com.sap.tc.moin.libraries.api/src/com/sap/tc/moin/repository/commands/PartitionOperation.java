package com.sap.tc.moin.repository.commands;

import com.sap.tc.moin.repository.PRI;

/**
 * Represents an operation to be performed in a
 * {@link com.sap.tc.moin.repository.ModelPartition}
 * 
 * @author d045996
 */
public final class PartitionOperation {

    /**
     * The enumeration for partition operations.
     */
    public enum Operation {
        /**
         * The create operation.
         */
        CREATE,
        /**
         * The delete operation.
         */
        DELETE,
        /**
         * The edit operation.
         */
        EDIT
    };

    private Operation op;

    private PRI partitionPRI;

    private int hash;

    /**
     * Arguments must not be null.
     * 
     * @param operation
     * @param partitionPRI
     */
    public PartitionOperation( Operation operation, PRI partitionPRI ) {

        this.op = operation;
        this.partitionPRI = partitionPRI;
        hash = ( op.toString( ) + partitionPRI.toString( ) ).hashCode( );
    }

    /**
     * @return The partition operation.
     */
    public Operation getOperation( ) {

        return op;
    }

    /**
     * @return The {@link PRI partition identifier}
     */
    public PRI getPartitionPri( ) {

        return partitionPRI;
    }

    @Override
    public boolean equals( Object o ) {

        if ( o == this ) {
            return true;
        }
        if ( o instanceof PartitionOperation ) {
            PartitionOperation p = (PartitionOperation) o;
            return ( op == p.getOperation( ) && partitionPRI.equals( p.getPartitionPri( ) ) );
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        return hash;
    }

    @Override
    public String toString( ) {

        return this.partitionPRI.getPartitionName( ) + " : " + this.op.toString( ); //$NON-NLS-1$
    }
}
