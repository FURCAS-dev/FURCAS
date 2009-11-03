package com.sap.tc.moin.repository;

import java.util.Collection;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;

/**
 * A model partition owns a set of model elements and a set of links between
 * model elements. Note, that links may be owned by more than one model
 * partition.
 * <p>
 * Model elements are always assigned to a model partition, but the assignment
 * can be changed.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author d043530
 */
public interface ModelPartition {

    /**
     * Returns the {@link PRI} of this model partition.
     * 
     * @return the {@link PRI} of this model partition.
     */
    public PRI getPri( );

    /**
     * A partition is considered dirty if its representation in memory logically
     * differs from its representation in the persistent store. If a partition
     * is newly created in memory, it is dirty by definition because it doesn’t
     * have a representation in the persistent store (yet). After saving it, the
     * dirty state is false. As soon as there are logical changes made to that
     * partition in memory, it is considered dirty again.<br>
     * If a model partition is {@link #delete() deleted}, it's not directly
     * removed from the persistent store, but is also considered dirty and will
     * only be deleted in the persistent store after {@link Connection#save()}
     * has been called. <br>
     * The {@link Connection#getNullPartition() NullPartition} is always dirty
     * as it is never persisted.
     * 
     * @return <code>true</code> if this model partition is considered dirty,
     * <code>false</code> otherwise.
     */
    public boolean isDirty( );

    /**
     * Indicates if the partition has been deleted in memory via
     * {@link #delete()}.
     * 
     * @return <code>true</code> if this model partition was {@link #delete()
     * deleted} in memory, <code>false</code> otherwise.
     */
    public boolean isAlive( );

    /**
     * Assigns a model element to this partition. <br>
     * This method has the same effect as calling
     * {@link Partitionable#assign___Partition(ModelPartition)} on the model
     * element with this partition as argument value. <br>
     * If the element is already assigned to this partition, calling this method
     * is a no-operation without any effect. <code>null</code> is not allowed as
     * argument value and will cause an exception to be thrown.
     * 
     * @param element the model element to be assigned to this partition.
     * <code>null</code> is not allowed as argument value and will cause an
     * exception to be thrown.
     * @throws IllegalArgumentException if the element to assign is
     * <code>null</code>.
     * @see Partitionable#assign___Partition(ModelPartition)
     */
    public void assignElement( Partitionable element );

    /**
     * Assigns a model element to this partition as well as all of the element's
     * component children (direct and transitive) which were in in the same
     * partition as the element before. <br>
     * This method has the same effect as calling
     * {@link Partitionable#assign___PartitionIncludingChildren(ModelPartition)}
     * on the model element with this partition as argument value. <br>
     * 
     * @param element the model element which will be assigned to this
     * partition. <code>null</code> is not allowed as argument value and will
     * cause an exception to be thrown.
     * @throws IllegalArgumentException if the element to assign is
     * <code>null</code>.
     * @see Partitionable#assign___Partition(ModelPartition)
     */
    public void assignElementIncludingChildren( Partitionable element );

    /**
     * Returns all model elements contained in this partition.
     * 
     * @return the model elements of this partition.
     */
    public Collection<Partitionable> getElements( );

    /**
     * Deletes the partition. If the partition is not empty, all contained model
     * elements will be removed before (via
     * {@link com.sap.tc.moin.repository.mmi.reflect.RefObject#refDelete()}.
     */
    public void delete( );

    /**
     * Deletes all elements of this partition via
     * {@link com.sap.tc.moin.repository.mmi.reflect.RefObject#refDelete()}. Due to delete
     * propagation for composite elements, elements of other partitions might be
     * deleted as well.
     */
    public void deleteElements( );


    /**
     * Creates an element in the partition that has the type of the given
     * <code>classDescriptor</code>.
     * 
     * @param <T> the type of the element to be created
     * @param classDescriptor the type of the element that shall be created
     * @return the newly created element
     */
    public <T extends RefObject> T createElement( ClassDescriptor<? extends RefClass, T> classDescriptor );

    /**
     * Creates an element in the partition that has the type of the given class
     * interface.
     * 
     * @param <T> the type of the element to be created
     * @param clazz the type of the element that shall be created
     * @return the newly created element
     */
    public <T extends RefObject> T createElement( Class<T> clazz );

    /**
     * Returns <code>true</code> if all of the following conditions hold, and
     * <code>false</code> otherwise:
     * <ul>
     * <li>the partition already exists in the persistence</li> <li>the
     * partition has been loaded from the persistence</li> <li>during load,
     * errors were detected indicating incompatible metamodel changes</li>
     * </ul>
     * Either the errors have been corrected on-the-fly by some registered error
     * handler, or have resulted in data loss. In any case, however, as a result
     * the memory state differs from the persistent state, and a subsequent
     * modification followed by a {@link Connection#save() save} would
     * ultimately "migrate" the partition in the persistence. This could make it
     * impossible to open the partition with an older version of the toolset /
     * metamodel. If this possibility is required, tools can use the information
     * from this method in conjunction with the result of
     * {@link #hadUnhandledErrorsDuringLoad()} to forbid modifications of such
     * partitions.
     */
    public boolean isMemoryStateDifferentFromPersistentStateAfterLoad( );

    /**
     * Returns <code>true</code> if all of the following conditions hold, and
     * <code>false</code> otherwise:
     * <ul>
     * <li>the partition already exists in the persistence</li> <li>the
     * partition has been loaded from the persistence</li> <li>during load,
     * errors were detected indicating incompatible metamodel changes</li> <li>
     * at least one of these errors could not be corrected by the registered
     * error handlers</li>
     * </ul>
     * The unhandled errors most likely resulted in data loss. Tools can use the
     * information from this method to forbid modifications of such partitions.
     */
    public boolean hadUnhandledErrorsDuringLoad( );

    /**
     * This method retrieves the metamodels and their versions that are used in
     * the <b>persisted</b> state of this partition. This information is based
     * on the {@link RefBaseObject#refMetaObject() meta-objects} of the elements
     * and links contained in this partition.
     * <p>
     * Note the following important restrictions:
     * <ul>
     * <li>Calling this method on a {@link PRI#isVolatilePartition() volatile}
     * or a newly created but not yet persisted partition always returns an
     * empty result.</li>
     * <li>Not all persistence formats support the retrieval of this information
     * (the MOIN persistence format does, though). Therefore the return value
     * might be empty even if the partition is not.</li>
     * <li>The return value only reflects the state directly after the partition
     * has been loaded. Later modifications of the partition's content are not
     * considered.</li>
     * </ul>
     * 
     * @return the collection of used metamodels (including their version) of
     * this partition. The collection is empty (and therefore never
     * <code>null</code>) if the partition is empty or if the information is not
     * available.
     */
    public Map<CRI, String> getUsedMetamodels( );
}