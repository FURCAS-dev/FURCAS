/*
 * Created on 09.02.2005
 */
package com.sap.tc.moin.repository;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.consistency.ConsistencyViolationListenerRegistry;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.mmi.descriptors.AssociationDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.MetamodelElementDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.PackageDescriptor;
import com.sap.tc.moin.repository.mql.MQLNotSupportedException;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.ocl.OclRegistryService;
import com.sap.tc.moin.repository.xm.ie.ModelExporter;
import com.sap.tc.moin.repository.xm.ie.ModelImporter;
import com.sap.tc.moin.repository.xm.parser.XmParserConfiguration;
import com.sap.tc.moin.repository.xm.serializer.XmSerializerConfiguration;
import com.sap.tc.moin.repository.xmi.XmiReader;
import com.sap.tc.moin.repository.xmi.XmiWriter;

/**
 * Represents a connection to MOIN.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface Connection {

    /**
     * Returns the session this connection is assigned to
     * 
     * @return the session this Connection is assigned to.
     */
    public Session getSession( );

    /**
     * Saves the changes done via this connection.
     * <p>
     * If a partition couldn't be saved the method continues nonetheless and
     * tries to save the remaining modified partitions. The partitions which
     * couldn't be saved are collected and a corresponding
     * {@link PartitionsNotSavedException exception} is thrown from which the
     * not saved partitions can be retrieved.
     * 
     * @throws PartitionsNotSavedException thrown if one or more of the
     * partitions which were changed by this connection could not be saved. This
     * does NOT mean that there were no partitions saved at all. The exception
     * only contains the partitions which were definitely not saved, other
     * partitions might have been saved successfully.
     * @throws NullPartitionNotEmptyException thrown if the
     * {@link #getNullPartition() null-partition} of this connection is not
     * empty which means that there are model elements that are not assigned to
     * a regular partition yet. This assignment has to be done before saving. If
     * this exception is thrown, no save took place at all.
     * @throws ReferencedTransientElementsException thrown if there is at least
     * one element which is assigned to a {@link #getTransientPartitions()
     * transient partition} and is still referenced by one or more elements
     * which are assigned to a non-transient partition. If you want to make sure
     * that this exception will not be thrown, you should use
     * {@link #hasReferencedTransientElements()} before calling this method.
     */
    public void save( ) throws PartitionsNotSavedException, NullPartitionNotEmptyException, ReferencedTransientElementsException;

    /**
     * Reverts the changes done via this connection since the last
     * {@link #save() save} was done.
     */
    public void revert( );

    /**
     * Returns <code>true</code> if this connection is still alive. This method
     * can be called safely (i.e. no exception will be thrown) even if this
     * connection was already {@link #close() closed}.
     * 
     * @return <code>true</code> if the <code>Connection</code> is still alive
     * or <code>false</code> if the <code>Connection</code> has been
     * {@link #close() closed} already.
     */
    public boolean isAlive( );

    /**
     * Closes this <code>Connection</code> and releases resources.
     * <p>
     * If there are still partitions existing which have been modified by this
     * connection but haven't been saved, {@link #revert()} is called before
     * releasing the resources. After a call to this method, {@link #isAlive()}
     * will return <code>false</code> from then on and most other methods will
     * throw an {@link InvalidConnectionException} when being called except for
     * {@link #getId()}, {@link #getLabel()}, {@link #isAlive()} and this method
     * itself. Calling this method again after the connection was closed has no
     * effect.
     */
    public void close( );

    /**
     * Searches a MOF package with the specified qualified name and returns the
     * according package extent for it. Only those MOF packages are considered,
     * which are hosted in in the specified model container. The model container
     * is specified by its name.<br>
     * 
     * @param modelContainerName The name of the model container, in which the
     * MOF package is searched. May be null which then triggers a search among
     * all model containers and therefore may result in an
     * {@link AmbiguousPackageNameException}.
     * @param qualifiedName The qualified name of the MOF package to be searched
     * @return The package extent or <code>null</code> if nothing has been found
     * @throws AmbiguousPackageNameException is thrown if no model container was
     * specified and there is more than one {@link RefPackage} with the
     * specified qualified name
     */
    public RefPackage getPackage( String modelContainerName, String... qualifiedName ) throws AmbiguousPackageNameException;

    /**
     * Searches a MOF package with the specified {@link PackageDescriptor} and
     * returns the corresponding package extent for it.<br>
     * 
     * @param <T> the type of the {@link RefPackage} to be returned
     * @param packageDescriptor The descriptor of the requested package
     * @return The package extent or <code>null</code> if nothing has been found
     */
    public <T extends RefPackage> T getPackage( PackageDescriptor<T> packageDescriptor );

    /**
     * Searches a MOF class with the specified {@link ClassDescriptor} and
     * returns the corresponding class extent for it.<br>
     * 
     * @param <T> the type of the {@link RefClass} to be returned
     * @param classDescriptor The descriptor of the requested class
     * @return The class extent or <code>null</code> if nothing has been found
     */
    public <T extends RefClass> T getClass( ClassDescriptor<T, ? extends RefObject> classDescriptor );

    /**
     * Searches a MOF association with the specified
     * {@link AssociationDescriptor} and returns the corresponding association
     * extent for it.<br>
     * 
     * @param <T> the type of the {@link RefAssociation} to be returned
     * @param associationDescriptor The descriptor of the requested association
     * @return The association extent or <code>null</code> if nothing has been
     * found
     */
    public <T extends RefAssociation> T getAssociation( AssociationDescriptor<T> associationDescriptor );

    /**
     * Searches a metamodel element with the specified
     * {@link MetamodelElementDescriptor} and returns it.<br>
     * 
     * @param metamodelElementDescriptor the descriptor of the requested
     * metamodel element
     * @return metamodel element with the specified MetamodelElementDescriptor
     */
    public <T extends RefBaseObject> T getMetamodelElement( MetamodelElementDescriptor<T> metamodelElementDescriptor );

    /**
     * Retrieves a model element via its MRI.
     * 
     * @param mri the MRI for the model element to be retrieved
     * @return The instance of the element requested or <code>null</code> if it
     * doesn't exist.
     * @throws IllegalArgumentException if the MRI argument is <code>null</code>
     * .
     */
    public RefBaseObject getElement( MRI mri );

    /**
     * Retrieves a model element via its LRI.
     * 
     * @param lri the LRI for the model element to be retrieved
     * @return The instance of the element requested or <code>null</code> if it
     * doesn't exist.
     * @throws IllegalArgumentException if the LRI argument is <code>null</code>
     * .
     */
    public RefBaseObject getElement( LRI lri );

    /**
     * Checks if an element with the given {@link MRI} exists. Unlike the method
     * {@link #getElement(MRI)} this method does not load the element's
     * partition into memory.
     * 
     * @param mri the MRI of the element to be looked up.
     * @return true if the element exists
     */
    public boolean elementExists( MRI mri );

    /**
     * Checks if an element with the given {@link LRI} exists. Unlike the method
     * {@link #getElement(LRI)} this method does not load the element's
     * partition into memory.
     * 
     * @param lri the {@link LRI} of the element to be looked up
     * @return true if the element exists
     */
    public boolean elementExists( LRI lri );

    /**
     * Creates an element in the partition that has the type of the given
     * <code>classDescriptor</code>. After creation, the element is inside the
     * {@link #getNullPartition()}.
     * 
     * @param <T> the type of the element to be created
     * @param classDescriptor the type of the element that shall be created
     * @return the newly created element
     */
    public <T extends RefObject> T createElement( ClassDescriptor<? extends RefClass, T> classDescriptor );

    /**
     * Creates an element in the partition that has the type of the given
     * interface. After creation, the element is inside the
     * {@link #getNullPartition()}.
     * 
     * @param <T> the type of the element to be created
     * @param clazz the type of the element to be created
     * @return the newly created element
     */
    public <T extends RefObject> T createElement( Class<T> clazz );

    /**
     * Creates an element in the partition that has the type of the given
     * <code>classDescriptor</code>.
     * 
     * @param <T> the type of the element to be created
     * @param classDescriptor the type of the element that shall be created
     * @param partition the partition to which the new element will be assigned
     * to. If this parameter is <code>null</code> then the element will be
     * assigned to the {@link #getNullPartition()}.
     * @return the newly created element
     */
    public <T extends RefObject> T createElementInPartition( ClassDescriptor<? extends RefClass, T> classDescriptor, ModelPartition partition );

    /**
     * Creates an element in the partition that has the type of the given
     * interface.
     * 
     * @param <T> the type of the element to be created
     * @param clazz the type of the element to be created
     * @param partition the partition to which the new element will be assigned
     * to. If this parameter is <code>null</code> then the element will be
     * assigned to the {@link #getNullPartition()}.
     * @return the newly created element
     */
    public <T extends RefObject> T createElementInPartition( Class<T> clazz, ModelPartition partition );

    /**
     * Creates a model partition with the given PRI.
     * 
     * @param pri the PRI for the model partition to be created
     * @return a newly created model partition with the given PRI
     * @throws InvalidResourceIdentifierException if the given PRI is invalid
     * @throws PartitionCreatingNotPossibleException if the creation of the
     * partition is not possible
     */
    public ModelPartition createPartition( PRI pri ) throws InvalidResourceIdentifierException, PartitionCreatingNotPossibleException;

    /**
     * Retrieves a model partition with the given PRI. If the partition is not
     * already loaded in memory, the loading will be triggered by this call.
     * <p>
     * If you just want to check if a certain partition exists, you should use
     * {@link #partitionExists(PRI)}.
     * 
     * @param pri the PRI of the partition to be retrieved
     * @return the model partition with the given PRI, <code>null</code> if not
     * existing.
     */
    public ModelPartition getPartition( PRI pri );

    /**
     * Checks if a partition with the given {@link PRI} exists. Unlike the
     * method {@link #getPartition(PRI)} this method does not load the partition
     * into memory.
     * 
     * @param pri the PRI of the partition to be looked up.
     * @return <code>true</code> if the partition exists.
     */
    public boolean partitionExists( PRI pri );

    /**
     * Returns the {@link XmiWriter} instance of this connection.
     * 
     * @return the {@link XmiWriter} instance of this connection
     */
    public XmiWriter getXmiWriter( );

    /**
     * Returns the {@link XmiReader} instance of this connection.
     * 
     * @return the {@link XmiReader} instance of this connection
     */
    public XmiReader getXmiReader( );

    /**
     * Returns a new Model Importer instance of this connection.
     * <p>
     * The returned instance allocates memory. It is in the responsibility of
     * the user to release the instance to the garbage collector to free the
     * memory when the instance is no longer needed.
     * <p>
     * If you use a Model Importer instance in different threads, the Model
     * Importer instance will serialize the import calls. Therefore we recommend
     * to use different Model Importer instances in different threads.
     * 
     * @param configuration configuration of the model importer, you get an
     * instance via
     * {@link XmParserConfiguration#getInstance(com.sap.tc.moin.repository.xm.parser.XmParserHandler, javax.xml.validation.Schema, com.sap.tc.moin.repository.xm.parser.ParserErrorHandler)}
     * @return model importer
     * @throws NullPointerException if the parameter is <tt>null</tt>
     */
    ModelImporter createModelImporter( XmParserConfiguration configuration );

    /**
     * Returns a new Model Exporter instance of this connection.
     * <p>
     * The returned instance allocates memory. It is in the responsibility of
     * the user to release the instance to the garbage collector to free the
     * memory when the instance is no longer needed.
     * <p>
     * If you use a Model Exporter instance in different threads, the Model
     * Exporter instance will serialize the export calls. Therefore we recommend
     * to use different Model Exporter instances in different threads.
     * 
     * @param configuration of the model importer, you get an instance via
     * {@link XmSerializerConfiguration#getInstance(com.sap.tc.moin.repository.xm.serializer.XmCustomSerializer)}
     * @return model exporter
     * @throws NullPointerException if the parameter is <tt>null</tt>
     */
    ModelExporter createModelExporter( XmSerializerConfiguration configuration );



    /**
     * Returns the {@link MQLProcessor} instance of this connection. If no MQL
     * processor is available for the current setup of MOIN,
     * {@link MQLNotSupportedException} will be thrown.
     * 
     * @return the {@link MQLProcessor} instance of this connection
     * @throws MQLNotSupportedException If no MQL processor is available for the
     * current setup of MOIN
     */
    public MQLProcessor getMQLProcessor( ) throws MQLNotSupportedException;

    /**
     * Returns the OCL registry service.
     * 
     * @return the OCL registry service
     */
    public OclRegistryService getOclRegistryService( );

    /**
     * Returns the consistency violation registry.
     * 
     * @return the consistency violation registry
     */
    public ConsistencyViolationListenerRegistry getConsistencyViolationListenerRegistry( );

    /**
     * Returns the {@link CommandStack} instance of this connection.
     * 
     * @return the {@link CommandStack} instance of this connection.
     */
    public CommandStack getCommandStack( );

    /**
     * Returns a JmiHelper object.
     * 
     * @return a JmiHelper object
     */
    public JmiHelper getJmiHelper( );

    /**
     * Duplicates a set of linked model elements based on the policies for deep
     * copying. The default policies for deep copy include duplication of all
     * elements in the given seed set, duplication of all composite children
     * (recursively) of these elements, and referencing of all elements to which
     * the elements in the seed set have links. <br>
     * A {@link DeepCopyPolicyHandler} can be provided by the client to modify
     * the default policies in order to control the copy process. <br>
     * If an exception occurs during the copy process, the execution is not
     * stopped. The exceptions can be obtained from the
     * {@link DeepCopyResultSet#getCopyErrors()}. As the deep copy process is
     * executed in one (sub)Command, depending on the reported errors, the
     * client can undo the copy in the standard way ({@link CommandStack}).<br>
     * Note: Dangling links are not considered by "deepCopy".
     * 
     * @param elementsToBeCopied The elements to be copied (seed set)
     * @param policyHandler The handler that supplies the copying policies for
     * each element. If it is null, the default policy handler is used.
     * @param includeExternalCompositeParents indicates if external compositions
     * (parents) should be considered
     * @return the result of the copy process including direct and inverse
     * mapping and any error
     */
    public DeepCopyResultSet deepCopy( Collection<RefObject> elementsToBeCopied, DeepCopyPolicyHandler policyHandler, boolean includeExternalCompositeParents );

    /**
     * Returns <code>true</code> if this connection has unsaved changes i.e.
     * that {@link #getPartitionsToBeSaved()} is not empty or the
     * {@link #getNullPartition() null partition} is not empty or both.
     * 
     * @return <code>true</code> if this connection has unsaved changes,
     * <code>false</code> otherwise.
     */
    public boolean isDirty( );

    /**
     * Returns the "NullPartition". The NullPartition contains all model
     * elements that have not been assigned to a regular {@link ModelPartition}.
     * 
     * @return the "NullPartition" of this connection.
     */
    public ModelPartition getNullPartition( );

    /**
     * Gets the event registry for the Session of this Connection. Listeners
     * that are registered via this EventRegistry will automatically be
     * deregistered when the connection is closed. Thus it is not necessary to
     * hold references to the listeners. However it is still possible to
     * deregister listeners if they are not needed anymore.
     * 
     * @return the event registry for this session
     */
    public EventRegistry getEventRegistry( );

    /**
     * Gets (if already existing) or creates (if not existing yet) a so called
     * "transient" partition. Transient means that this partition only exists in
     * memory and is never saved. It is connection specific and its lifecycle is
     * bound to the lifecycle of the corresponding connection. The
     * {@link #save()} will work even if there are still elements in transient
     * partitions in contrast to the failing save if there are still elements in
     * the {@link #getNullPartition() NullPartition}.<br>
     * The specified name must be
     * {@link #isLegalNameForTransientPartition(String) legal} otherwise an
     * exception is thrown.
     * 
     * @param partitionName the String which will be part of the PRI of the
     * transient partition.
     * @return a transient partition which has the given String as part of its
     * PRI, never <code>null</code>.
     * @throws IllegalArgumentException thrown if the specified name is not
     * {@link #isLegalNameForTransientPartition(String) legal}.
     */
    public ModelPartition getOrCreateTransientPartition( String partitionName ) throws IllegalArgumentException;

    /**
     * Tells if the specified String is legal for use within
     * {@link #getOrCreateTransientPartition(String)}. The String must not be
     * <code>null</code>, must not be the empty and must only contain ASCII
     * letters, digits or "_" (without the quotes).
     * 
     * @param partitionName the String to check if it is legal for use within
     * {@link #getOrCreateTransientPartition(String)}.
     * @return <code>true</code> if the specified String is legal for use within
     * {@link #getOrCreateTransientPartition(String)}, <code>false</code>
     * otherwise.
     */
    public boolean isLegalNameForTransientPartition( String partitionName );

    /**
     * Returns all transient partitions of this connection.
     * 
     * @return all transient partitions of this connection.
     */
    public Collection<ModelPartition> getTransientPartitions( );

    /**
     * Tells if this connection has modified non-transient partitions which
     * contain at least one element which references an element that is assigned
     * to a {@link #getTransientPartitions() transient partition}. If there is
     * such a reference, the calling of {@link #save()} will result in a
     * {@link ReferencedTransientElementsException}. So in order to make sure
     * that saving will be successful, this method should be called before
     * calling {@link #save()} because in most cases it is more efficient than
     * calling {@link #getReferencedTransientElements()} and checking if the
     * returned collection is empty.
     * 
     * @return <code>true</code> if this connection has modified non-transient
     * partitions which contain at least one element which references an element
     * that is assigned to a {@link #getTransientPartitions() transient
     * partition}, <code>false</code> otherwise.
     */
    public boolean hasReferencedTransientElements( );

    /**
     * Returns all elements which are assigned to
     * {@link #getTransientPartitions() transient partitions} and are still
     * referenced by one or more elements which are assigned to non-transient
     * partitions. If there are such elements, the calling of {@link #save()}
     * will result in a {@link ReferencedTransientElementsException}. But in
     * order to guarantee that the save call will be successful, rather
     * {@link #hasReferencedTransientElements()} should be called because in
     * most cases that method is more efficient than getting all the referenced
     * elements and checking if it is empty. This method should only be called
     * if you are really interested in all the transient elements which are
     * linked from a non-transient element.
     * 
     * @return all elements which are assigned to
     * {@link #getTransientPartitions() transient partitions} and are still
     * referenced by one or more elements which are assigned to non-transient
     * partitions. If there are no such elements, an empty Collection is
     * returned, never <code>null</code>.
     */
    public Collection<MRI> getReferencedTransientElements( );

    /**
     * Returns all partitions which will be tried to save when {@link #save} is
     * called.<br>
     * This means that neither the {@link #getNullPartition() NullPartition} nor
     * any {@link #getTransientPartitions() transient partition} is part of the
     * returned collection. The returned collection is a snapshot and not live.
     * 
     * @return all partitions which will be tried to save when {@link #save} is
     * called.
     */
    public Collection<ModelPartition> getPartitionsToBeSaved( );

    /**
     * Returns an arbitrary human readable label
     * 
     * @return the label
     */
    public String getLabel( );

    /**
     * Sets an arbitrary human readable label
     * 
     * @param label new label
     */
    public void setLabel( String label );

    /**
     * Returns the internal id
     * 
     * @return internal id
     */
    public String getId( );

    /**
     * @param priOne
     * @param otherPris
     * @return true or false
     * @deprecated use {@link Session#hasCrossPartitionLinks(PRI, PRI...)}
     */
    @Deprecated
    public boolean hasCrossPartitionLinks( PRI priOne, PRI... otherPris );

    /**
     * 
     */
    public void enableMemoryChangeOnly( );

    /**
     * @return
     * @see #enableMemoryChangeOnly()
     */
    public boolean isMemoryChangeOnlyEnabled( );



}
