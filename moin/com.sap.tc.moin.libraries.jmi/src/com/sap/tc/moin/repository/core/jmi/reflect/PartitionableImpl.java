/*
 * Created on 19.12.2005
 */
package com.sap.tc.moin.repository.core.jmi.reflect;

import java.util.Map;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.exception.MoinIllegalNullArgumentException;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;

/**
 * Implementation of the {@link com.sap.tc.moin.repository.core.Partitionable}
 * and {@link com.sap.tc.moin.repository.core.CorePartitionable} interfaces. <br>
 * All actions concering partitioning are located in this class as well as the
 * data structures where the partition assignment information is stored.
 * Therefore, it is the base class for all
 * {@link com.sap.tc.moin.repository.mmi.reflect.RefBaseObjectImpl model
 * elements} because every model element must be able to be assigned to
 * partitions.
 * 
 * @author d044711
 */
public abstract class PartitionableImpl extends RefFoundationImpl implements CorePartitionable {

    /**
     * A model element always knows the partition it belongs to. So the actual
     * assignment is stored in this variable.
     */
    private CoreModelPartition ___actualModelPartition = null;

    protected MRI ___mri = null;

    // ---------------CorePartitionable Implementations--------------

    /**
     * Common implementation for implicit and explicit partition assignment
     * 
     * @param mp the model partition to assign
     * @param explicit for distinguishing between implicit and explicit
     */
    public final void set___PartitionAssignment( CoreModelPartition mp ) {

        if ( mp == null ) {
            // TODO proper exception handling
            throw new MoinIllegalNullArgumentException( "modelPartition" ); //$NON-NLS-1$
        }

        mp.addElement( this );
    }

    /**
     * @see CorePartitionable#remove___PartitionAssignment()
     */
    public final void remove___PartitionAssignment( ) {

        this.___actualModelPartition.removeElement( this );
        // the above method already called
        // this.set___PartitionAssignmentInternal(null), therefore the call
        // this.___actualModelPartition = null would be superflous here
    }

    public final void set___PartitionAssignmentInternal( CoreModelPartition mp ) {

        this.___actualModelPartition = mp;
        this.___mri = null;
    }

    // ------------------Partitionable Implementations-------------------------

    public abstract <T extends RefBaseObject> Class<T> get___JmiInterface( );

    /**
     * Returns the partition this model element is currently assigned to. If
     * this model element is explicitly assigned to a partition, this partition
     * will be returned. Not being explicitly assigned to a partition means that
     * this model element is implicitly assigned to the partition its composite
     * parent (if existing) is assigned to. The composite parent in turn is also
     * either explicitly assigned to a partition or implicitly assigned to its
     * composite parent's partition and so on. The method call is pretty cheap
     * as it is a simple getter. The method does NOT climb up the composition
     * hierarchy and therefore does NOT compute the partition assignment
     * dynamically. So it is save to call this method as no endless recursion
     * can occur. The needed information about this model element's partition is
     * updated when it or one of its composite parent objects is explicitly
     * assigned to a partition.
     * 
     * @see com.sap.tc.moin.repository.core.Partitionable#get___Partition()
     */
    public final CoreModelPartition get___Partition( ) {

        return this.___actualModelPartition;
    }

    /**
     * Implementation of
     * {@link com.sap.tc.moin.repository.core.Partitionable#assign___Partition(ModelPartition)}
     * .
     * 
     * @see #assign___Partition(CoreModelPartition, Map)
     */
    @Deprecated
    public final void assign___Partition( ModelPartition mp ) {

        this.assign___Partition( ( (CoreModelPartition) mp ).getWorkspace( ).getWorkspaceSet( ).getMoin( ).getCurrentConnection( ), mp, false );
    }

    /**
     * Implementation of
     * {@link com.sap.tc.moin.repository.core.Partitionable#assign___Partition(ModelPartition)}
     * .
     * 
     * @see #assign___Partition(CoreModelPartition, Map)
     */
    public final void assign___Partition( CoreConnection connection, ModelPartition mp ) {

        this.assign___Partition( connection, mp, false );
    }

    @Deprecated
    public final void assign___PartitionIncludingChildren( ModelPartition mp ) {

        this.assign___Partition( ( (CoreModelPartition) mp ).getWorkspace( ).getWorkspaceSet( ).getMoin( ).getCurrentConnection( ), mp, true );
    }

    public final void assign___PartitionIncludingChildren( CoreConnection connection, ModelPartition mp ) {

        this.assign___Partition( connection, mp, true );
    }

    private void assign___Partition( CoreConnection connection, ModelPartition mp, boolean includeChildren ) {

        if ( mp == null ) {
            throw new MoinIllegalNullArgumentException( "modelPartition" ); //$NON-NLS-1$
        }
        if ( includeChildren ) {
            ( (CoreModelPartition) mp ).assignElementIncludingChildren( connection, this );
        } else {
            ( (CoreModelPartition) mp ).assignElement( connection, this );
        }
    }

    public boolean is___Alive( ) {

        return true;
    }

    public boolean is___Deleted( ) {

        return false;
    }

    public final Connection get___Connection( ) {

        return get___CurrentConnection( );
    }

    public final SpiJmiHelper get___JmiHelper( ) {

        return this.get___Workspace( ).getWorkspaceSet( ).getMoin( ).getJmiHelper( );
    }

    public void delete___Isolated( CoreConnection connection ) {

        //only valid implementation is in RefObjectImpl
        throw new MoinUnsupportedOperationException( JmiReflectMessages.ONLYDELETIONOFREFOBJECTISPOSSIBLE, this.getClass( ).getSimpleName( ) );

    }
}