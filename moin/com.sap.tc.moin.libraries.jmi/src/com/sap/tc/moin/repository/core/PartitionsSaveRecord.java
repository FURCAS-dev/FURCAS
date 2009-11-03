package com.sap.tc.moin.repository.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import com.sap.tc.moin.repository.PRI;

public class PartitionsSaveRecord {

    @Deprecated
    public Collection<PRI> partitionsToBeEdited;

    @Deprecated
    public Collection<PRI> partitionsToBeCreated;

    @Deprecated
    public Collection<PRI> partitionsToBeDeleted;

    public Collection<CoreModelPartition> editedPartitions;

    public Collection<CoreModelPartition> addedPartitions;

    public Collection<CoreModelPartition> deletedPartitions;

    public PartitionsSaveRecord( ) {

        this.partitionsToBeCreated = new LinkedList<PRI>( );
        this.partitionsToBeEdited = new LinkedList<PRI>( );
        this.partitionsToBeDeleted = new LinkedList<PRI>( );

        this.editedPartitions = new LinkedList<CoreModelPartition>( );
        this.addedPartitions = new LinkedList<CoreModelPartition>( );
        this.deletedPartitions = new LinkedList<CoreModelPartition>( );
    }

    @Override
    public int hashCode( ) {

        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( partitionsToBeCreated == null ) ? 0 : partitionsToBeCreated.hashCode( ) );
        result = prime * result + ( ( partitionsToBeDeleted == null ) ? 0 : partitionsToBeDeleted.hashCode( ) );
        result = prime * result + ( ( partitionsToBeEdited == null ) ? 0 : partitionsToBeEdited.hashCode( ) );

        result = prime * result + ( ( addedPartitions == null ) ? 0 : addedPartitions.hashCode( ) );
        result = prime * result + ( ( deletedPartitions == null ) ? 0 : deletedPartitions.hashCode( ) );
        result = prime * result + ( ( editedPartitions == null ) ? 0 : editedPartitions.hashCode( ) );

        return result;
    }

    @Override
    public boolean equals( Object obj ) {

        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass( ) != obj.getClass( ) ) {
            return false;
        }
        final PartitionsSaveRecord other = (PartitionsSaveRecord) obj;



        if ( partitionsToBeCreated == null ) {
            if ( other.partitionsToBeCreated != null ) {
                return false;
            }
        } else if ( !partitionsToBeCreated.equals( other.partitionsToBeCreated ) ) {
            return false;
        }
        if ( partitionsToBeDeleted == null ) {
            if ( other.partitionsToBeDeleted != null ) {
                return false;
            }
        } else if ( !partitionsToBeDeleted.equals( other.partitionsToBeDeleted ) ) {
            return false;
        }
        if ( partitionsToBeEdited == null ) {
            if ( other.partitionsToBeEdited != null ) {
                return false;
            }
        } else if ( !partitionsToBeEdited.equals( other.partitionsToBeEdited ) ) {
            return false;
        }



        if ( addedPartitions == null ) {
            if ( other.addedPartitions != null ) {
                return false;
            }
        } else if ( !addedPartitions.equals( other.addedPartitions ) ) {
            return false;
        }
        if ( deletedPartitions == null ) {
            if ( other.deletedPartitions != null ) {
                return false;
            }
        } else if ( !deletedPartitions.equals( other.deletedPartitions ) ) {
            return false;
        }
        if ( editedPartitions == null ) {
            if ( other.editedPartitions != null ) {
                return false;
            }
        } else if ( !editedPartitions.equals( other.editedPartitions ) ) {
            return false;
        }

        return true;
    }

    public Collection<PRI> getPrisOfCreatedPartitions( ) {

        if ( this.partitionsToBeCreated.isEmpty( ) ) {
            return this.getPrisOfPartitions( addedPartitions );
        } else {
            return this.partitionsToBeCreated;
        }
    }

    public Collection<PRI> getPrisOfEditedPartitions( ) {

        if ( this.partitionsToBeEdited.isEmpty( ) ) {
            return this.getPrisOfPartitions( editedPartitions );
        } else {
            return this.partitionsToBeEdited;
        }
    }

    public Collection<PRI> getPrisOfDeletedPartitions( ) {

        if ( this.partitionsToBeDeleted.isEmpty( ) ) {
            return this.getPrisOfPartitions( deletedPartitions );
        } else {
            return this.partitionsToBeDeleted;
        }
    }

    private Collection<PRI> getPrisOfPartitions( Collection<CoreModelPartition> partitions ) {

        if ( partitions.isEmpty( ) ) {
            return Collections.emptyList( );
        }
        ArrayList<PRI> result = new ArrayList<PRI>( partitions.size( ) );
        for ( CoreModelPartition partition : partitions ) {
            result.add( partition.getPri( ) );
        }
        return result;
    }
}
