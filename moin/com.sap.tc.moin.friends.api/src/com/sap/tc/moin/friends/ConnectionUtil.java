package com.sap.tc.moin.friends;

import java.io.InputStream;

import com.sap.tc.moin.friends.merge.OperationInvoker;
import com.sap.tc.moin.friends.merge.OperationInvokerConfiguration;
import com.sap.tc.moin.friends.ocl.OclActivator;
import com.sap.tc.moin.friends.ocl.editor.OclEditorService;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;


/**
 * ConnectionUtil is an interface that provides extended functionality for the
 * {@link Connection} interface.
 */
public interface ConnectionUtil {

    /**
     * Sets the callback interface {@link CommandStackObserver}
     * 
     * @param connection The connection to be observed
     * @param observer The callback interface to be called
     */
    void setCommandStackObserver( Connection connection, CommandStackObserver observer );

    /**
     * Sets the {@link ProgressMonitor} to be used during command execution
     * 
     * @param connection the connection
     * @param progressMonitor The progress monitor to be used
     */
    void setProgressMonitor( Connection connection, ProgressMonitor progressMonitor );

    /**
     * This service is used by the OCL Editor
     * 
     * @param connection the connection
     * @return the service
     */
    OclEditorService getOclEditorService( Connection connection );

    /**
     * Handles OCL Constraint activation in metamodels
     * 
     * @param connection
     * @return
     */
    OclActivator getOclActivator( Connection connection );

    /**
     * Loads the specified stream into the memory state of the MOIN repository.
     * The stream is loaded as the content of the given partition. Any previous
     * content of the PRI is "shadowed" by the content of the stream. To mark
     * the partition's memory state to be superior over the partition's state on
     * the persistence, the partition is marked as dirty. I.e. the partition is
     * contained in {@link Connection#getPartitionsToBeSaved()}.<br>
     * The unload such loaded partitions from the repository's memory
     * {@link Connection#revert()} must be called.
     * 
     * @param connection the connection to be used for loading the stream into
     * the {@link Connection#getPartitionsToBeSaved()}
     * @param pri the partition to be used for loading to the stream
     * @param stream the stream containing the partition content
     * @return The loaded ModelPartition. <code>null</code> id the partition
     * could not be loaded.
     */
    public ModelPartition loadPartition( Connection connection, PRI pri, InputStream stream );

    /**
     * Instantiates an {@link OperationInvoker} for executing merge operations
     * on a {@link ModelPartition}
     * 
     * @param sourcePartition the source partition
     * @param targetPartition the target partition
     * @param config the invoker configuration
     * @return the invoker
     */
    public OperationInvoker getMergeOperationInvoker( ModelPartition sourcePartition, ModelPartition targetPartition, OperationInvokerConfiguration config );
}
