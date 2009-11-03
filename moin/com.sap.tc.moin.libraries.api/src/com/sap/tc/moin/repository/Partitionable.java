package com.sap.tc.moin.repository;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

/**
 * A model element that can be assigned to a {@link ModelPartition}. <br>
 * Every object implementing this interface also implements the regular JMI
 * {@link RefBaseObject} interface. Thus, casts between {@link Partitionable}
 * and {@link RefBaseObject} are possible.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @see ModelPartition
 * @author D043530
 */

public interface Partitionable {

    /**
     * Returns the model partition that this model element is assigned to. An
     * element must always be assigned to a model partition, therefore this
     * method always returns a model partition, never <code>null</code>.
     * <p>
     * Directly after creation, an element is assigned to the
     * {@link Connection#getNullPartition()} of the connection with which the
     * creation was done.
     * 
     * @return the model partition this element is currently assigned to, never
     * <code>null</code>.
     * @see #assign___Partition(ModelPartition)
     * @see #assign___PartitionIncludingChildren(ModelPartition)
     * @see ModelPartition#assignElement(Partitionable)
     * @see ModelPartition#assignElementIncludingChildren(Partitionable)
     */
    public ModelPartition get___Partition( );

    /**
     * Assigns this model element to the specified partition. <br>
     * This method has the same effect as calling
     * {@link ModelPartition#assignElement(Partitionable)} on the model
     * partition with this element as argument value. <br>
     * If this element is already assigned to the partition, calling this method
     * is a no-operation without any effect. <code>null</code> is not allowed as
     * argument value for the partition and will cause an exception to be
     * thrown.
     * 
     * @param mp the model partition this element is to be assigned to.
     * <code>null</code> is not allowed as argument value and will cause an
     * exception to be thrown.
     * @throws IllegalArgumentException if the model partition is
     * <code>null</code>.
     * @see ModelPartition#assignElement(Partitionable)
     */
    public void assign___Partition( ModelPartition mp );

    /**
     * Assigns this model element, as well as all of its component children
     * (direct and transitive) which were in in the same partition as this
     * element before, to the specified partition. <br>
     * This method has the same effect as calling
     * {@link ModelPartition#assignElementIncludingChildren(Partitionable)} on
     * the model partition with this element as argument value. <br>
     * If this element is already assigned to the partition, calling this method
     * is a no-operation without any effect. <code>null</code> is not allowed as
     * argument value for the partition and will cause an exception to be
     * thrown.
     * 
     * @param mp the model partition this element is to be assigned to.
     * <code>null</code> is not allowed as argument value and will cause an
     * exception to be thrown.
     * @throws IllegalArgumentException if the model partition is
     * <code>null</code>.
     * @see ModelPartition#assignElement(Partitionable)
     */
    public void assign___PartitionIncludingChildren( ModelPartition mp );

    /**
     * Returns the MRI of this model element.<br>
     * The MRI is a combination of the {@link PRI} of the {@link ModelPartition
     * model partition} this element is assigned to and the {@link LRI} of this
     * element.
     * 
     * @return the MRI of this model element.
     * @see MRI
     * @see LRI
     */
    public MRI get___Mri( );

    /**
     * Returns the MOF ID of this model element. Note, that the MOF ID alone is
     * not necessarily sufficient to guarantee uniqueness. A model element may
     * be present in more than one version at the same time. Both versions will
     * have the same MOF ID. Note, that this operation coincides with
     * {@link com.sap.tc.moin.repository.mmi.reflect.RefBaseObject#refMofId()}.
     * 
     * @return the MOF ID of this model element
     */
    public String refMofId( );

    /**
     * Returns true, if the object is still alive, otherwise false. In case the
     * object has been deleted or the according Connection has been closed, the
     * object is not alive any more.
     * 
     * @return true, if the object is still alive, otherwise false.
     */
    public boolean is___Alive( );

    /**
     * Returns the connection that is associated with the model element.
     * 
     * @return returns the connection that is associated with the model element.
     */
    public Connection get___Connection( );

    /**
     * Returns the class object of this Partitionable's JMI interface.
     * 
     * @param <T> the type of this Partitionable's JMI interface
     * @return the class object of this Partitionable's JMI interface
     */
    public <T extends RefBaseObject> Class<T> get___JmiInterface( );
}
