package com.sap.tc.moin.repository.core.eviction;

import com.sap.tc.moin.repository.core.CoreModelPartition.CoreModelPartitionIdentity;

public class PartitionStatistics {

    // Partition name
    private Object partitionIdentifier = null;

    // Partition call statistic
    protected long callNumber = 0;

    // Partition size
    protected int size = 0;

    public PartitionStatistics( Object partitionIdentifier ) {

        this.partitionIdentifier = partitionIdentifier;
    }

    @Override
    public String toString( ) {

        if ( this.partitionIdentifier instanceof CoreModelPartitionIdentity ) {
            return ( (CoreModelPartitionIdentity) this.partitionIdentifier ).getCoreModelPartition( ).getPri( ).getPartitionName( );
        } else {
            return this.partitionIdentifier.toString( );
        }
    }

    public Object getPartitionIdentifier( ) {

        return this.partitionIdentifier;
    }

    public long getCallNumber( ) {

        return this.callNumber;
    }

    public int getSize( ) {

        return this.size;
    }
}
