package com.sap.tc.moin.repository.jmx;

import java.io.IOException;

import javax.management.openmbean.CompositeData;

/**
 * The JMX instrumentation of {@link Connection} instances.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ConnectionMBean {

    /**
     * Returns the id of the connection.
     * 
     * @return the id of the connection
     * @throws IOException in case of network communication issues
     */
    @Description( "The id of this connection." )
    public String getId( ) throws IOException;

    /**
     * Returns the label of the connection.
     * 
     * @return the label of the connection
     * @throws IOException in case of network communication issues
     */
    @Description( "The label of this connection." )
    public String getLabel( ) throws IOException;

    /**
     * Returns whether this connection is alive or already closed.
     * 
     * @return whether this connection is alive or already closed
     * @throws IOException in case of network communication issues
     */
    @Description( "Whether this connection is alive or already closed." )
    public boolean isAlive( ) throws IOException;

    /**
     * Returns the number of model elements currently assigned to this
     * connection's null-partition.
     * 
     * @return the number of model elements currently assigned to this
     * connection's null-partition
     * @throws IOException in case of network communication issues
     */
    @Description( "The number of model elements currently assigned to this connection's null-partition." )
    public int getNumberOfElementsInNullPartition( ) throws IOException;

    /**
     * Returns the {@link MRI} Strings of all elements in the model partition
     * identified by the given {@link PRI} string.
     * 
     * @param priString the {@link PRI} String of the model partition in
     * question
     * @return an array of {@link MRI} Strings of all elements in the model
     * partition identified by the given PRI string
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns the MRI Strings of all elements in the model partition identified by the given PRI string." )
    public String[] getElementsInPartition( @ParameterName( "priString" ) String priString ) throws IOException; //$NON-NLS$

    /**
     * Returns the {@link MRI} Strings of all root elements in the model
     * partition identified by the given PRI string, i.e. all elements which
     * have no composite parent in the given partition.
     * 
     * @param priString the {@link PRI} String of the model partition in
     * question
     * @return an array of {@link MRI} Strings of all root elements in the model
     * partition identified by the given {@link PRI} string
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns the MRI Strings of all root elements in the model partition identified by the given PRI string." )
    public String[] getRootElementsInPartition( @ParameterName( "priString" ) String priString ) throws IOException; //$NON-NLS$

    /**
     * Returns information about the model element identified by the given
     * {@link MRI} String.
     * 
     * @param mriString the {@link MRI} String of the model element in question
     * @return a {@link CompositeData} instance containing detailed information
     * about the model element, including current values of primitive attributes
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns information about the model element identified by the given MRI String." )
    public CompositeData getElementByMRI( @ParameterName( "mriString" ) String mriString ) throws IOException; //$NON-NLS$

    /**
     * Returns information about the model element identified by the given
     * {@link LRI} String.
     * 
     * @param lriString the {@link LRI} String of the model element in question
     * @return a {@link CompositeData} instance containing detailed information
     * about the model element, including current values of primitive attributes
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns information about the model element identified by the given LRI String." )
    public CompositeData getElementByLRI( @ParameterName( "lriString" ) String lriString ) throws IOException; //$NON-NLS$

    /**
     * Returns the {@link PRI} String identifying the connection's
     * null-partition.
     * 
     * @return the {@link PRI} String identifying the connection's
     * null-partition
     * @throws IOException in case of network communication issues
     */
    @Description( "The PRI String identifying the connection's null-partition." )
    public String getNullPartition( ) throws IOException;

    /**
     * Returns the {@link PRI} Strings identifying the connection's modified
     * partitions. This includes regular partitions and the connection's
     * null-partition, but no transient partitions.
     * 
     * @return the {@link PRI} Strings identifying the connection's modified
     * partitions
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns the PRI Strings of this connection's modified partitions. This includes regular partitions and the connection's null-partition, but no transient partitions." )
    public String[] getDirtyPartitions( ) throws IOException;

    /**
     * Returns the {@link PRI} Strings identifying the connection's transient
     * partitions, including the connection's null-partition.
     * 
     * @return the {@link PRI} Strings identifying the connection's transient
     * partitions, including the connection's null-partition
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns the PRI Strings of this connection's transient partitions, including the connection's null-partition." )
    public String[] getTransientPartitions( ) throws IOException;

    /**
     * Returns a String representation of the current delta of the model
     * partition identified by the given {@link PRI} String, compared to the
     * persistent state.
     * 
     * @return a String representation of the current delta of the model
     * @param priString the {@link PRI} String of the model partition in
     * question partition identified by the given {@link PRI} String
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns a String representation of the current delta of the model partition identified by the given PRI String, compared to the persistent state." )
    public String showPartitionDelta( @ParameterName( "priString" ) String priString ) throws IOException; //$NON-NLS$

    /**
     * Returns a String representation of all current deltas of dirty model
     * partitions, compared to their persistent state.
     * 
     * @return a String representation of all current deltas of dirty model
     * partitions
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns a String representation of all current deltas of dirty model partitions, compared to their persistent state." )
    public String showAllPartitionDeltas( ) throws IOException;

    /**
     * Deletes all model elements from the connection's null-partition. <br>
     * <b>Caution</b> - this can result in loss of data!
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Deletes all model elements from the connection's null-partition. CAUTION - this can result in loss of data!!!" )
    public void deleteAllElementsInNullPartition( ) throws IOException;

    /**
     * Deletes all model elements from the connection's null-partition. <br>
     * <b>Caution</b> - this can result in loss of data!
     * 
     * @return the stacktrace where the connection was allocated, given as an
     * array of {@link StackTraceElement}
     * @throws IOException in case of network communication issues
     */
    @Description( "Where the connection was allocated." )
    public StackTraceElement[] getAllocationStackTrace( ) throws IOException;

    /**
     * Returns the content of the model partition identified by the given
     * {@link PRI} String as an XML String. The MOIN partition format serializer
     * is used for serialization of the content.
     * 
     * @param priString the {@link PRI} String of the model partition in
     * question
     * @return the content of the model partition as an XML String
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns the content of the model partition identified by the given PRI String as an XML String. The MOIN partition format serializer is used for serialization of the content." )
    public String showContentOfPartition( @ParameterName( "priString" ) String priString ) throws IOException;

    /**
     * Returns the content of the model partition identified by the given
     * {@link PRI} String as an XML String. The MOIN partition format serializer
     * is used for serialization of the content, using the specified file format
     * version.
     * 
     * @param priString the {@link PRI} String of the model partition in
     * question
     * @param version the file format version to use for serialization
     * @return the content of the model partition as an XML String
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns the content of the model partition identified by the given PRI String as an XML String. The MOIN partition format serializer is used for serialization of the content, using the specified file format version." )
    public String showContentOfPartition( @ParameterName( "priString" ) String priString, @ParameterName( "version" ) String version ) throws IOException;

    /**
     * Returns the content of the model partition identified by the given
     * {@link PRI} String as String. The custom serializer associated with the
     * given PRI is used for serialization of the content.
     * 
     * @param priString the {@link PRI} String of the model partition in
     * question
     * @return the content of the model partition as an XML String
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns the content of the model partition identified by the given PRI String as String. The custom serializer associated with the given PRI is used for serialization of the content." )
    public String showContentOfPartitionInNativeFormat( @ParameterName( "priString" ) String priString ) throws IOException;

    /**
     * Saves the connection.
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Saves the connection." )
    public void save( ) throws IOException;

    /**
     * Reverts the connection.<br>
     * <b>Caution</b> - this can result in loss of data!
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Reverts the connection. CAUTION - this can result in loss of data!!!" )
    public void revert( ) throws IOException;

    /**
     * Closes the connection.<br>
     * <b>Caution</b> - this can result in loss of data!
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Closes the connection. CAUTION - this can result in loss of data!!!" )
    public void close( ) throws IOException;

    /**
     * Returns the number of partition wrappers cached by this connection.
     * 
     * @return the number of partition wrappers cached by this connection
     * @throws IOException in case of network communication issues
     */
    @Description( "The number of partition wrappers cached by this connection." )
    public int getCachedPartitionWrappers( ) throws IOException;

    /**
     * Returns the number of JMI wrappers cached by this connection.
     * 
     * @return the number of JMI wrappers cached by this connection
     * @throws IOException in case of network communication issues
     */
    @Description( "The number of JMI wrappers cached by this connection." )
    public int getCachedJmiWrappers( ) throws IOException;

    /**
     * Returns the number of JmiList wrappers cached by this connection.
     * 
     * @return the number of JmiList wrappers cached by this connection
     * @throws IOException in case of network communication issues
     */
    @Description( "The number of JmiList wrappers cached by this connection." )
    public int getCachedJmiListWrappers( ) throws IOException;

    /**
     * Returns the {@link PRI} Strings of all partition wrappers cached by this
     * connection.
     * 
     * @return an array of {@link PRI} Strings of all partition wrappers cached
     * by this connection
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns the PRI Strings of all partition wrappers cached by this connection." )
    public String[] showCachedPartitionWrappers( ) throws IOException;

    /**
     * Returns the {@link MRI} Strings of all JMI wrappers cached by this
     * connection.
     * 
     * @return an array of {@link MRI} Strings of all JMI wrappers cached by
     * this connection
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns the MRI Strings of all JMI wrappers cached by this connection." )
    public String[] showCachedJmiWrappers( ) throws IOException;

    /**
     * Initializes the {@link MQLProcessor} of the connection (if not already
     * done), which in turn results in the creation of the corresponding
     * {@link MqlProcessorMBean}.
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Initializes the MQL processor MBean of the connection, if not already done." )
    public void initializeMqlProcessor( ) throws IOException;
}
