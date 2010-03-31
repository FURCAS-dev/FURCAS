package com.sap.tc.moin.test.fw;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;

/**
 * A test client stands for an abstract simulated "client" of MOIN which
 * executes diverse operations. It is stateful and is assigned to one user, one
 * client-spec and one connection. Setting a client as current client means that
 * the corresponding user is the currently active user and the connection of the
 * test client is attached to the current thread.
 * <p>
 * This interface should enable test cases to simulate different users (with
 * different client specs), but abstracts from the concrete facility
 * implementation, i.e. the test case does not itself need to create a client
 * spec (which currently affords facility-specific coding). The same applies for
 * creating partitions - the concrete MRI implemenations are not relevant for
 * the test case, so this is handled by the test framework behind the scenes.
 * <p>
 * The implementation of the test client depends on the facility type or even on
 * the facility implementaion. Test clients are instantiated via the
 * {@link TestClientFactory}, which is loaded dynamically from the
 * {@link com.sap.tc.moin.test.fw.MoinTestHelper} according to the
 * configuration.
 */
public interface TestClient {

    /**
     * Gets a connection for this client.
     * <p>
     * The first call of this method will lazily create a new connection.
     * Subsequent calls will always return the same connection instance, unless
     * the connection has been closed. In this case, the next call of
     * {@link #getConnection()} would create a new connection.
     * 
     * @return the connection for this client
     */
    public Connection getConnection( );


    /**
     * Creates a new {@link ModelPartition} in the client-specific workspace of
     * this client. Every call of this method will create a new partition. The
     * {@link PRI} of the partition depends on the facility-specific
     * implementation of the TestClient interface, and is generated
     * appropriately.
     * 
     * @param testName the name of the test requesting the partition; can be
     * <code>null</code>
     * @return a new {@link ModelPartition}
     */
    public ModelPartition getOrCreatePartition( String testName );


    /**
     * Get or creates a new {@link ModelPartition} in the client-specific
     * workspace of this client. The {@link PRI} of the partition depends on the
     * facility-specific implementation of the TestClient interface, and is
     * generated appropriately.
     * 
     * @param testName the name of the test requesting the partition; can be
     * <code>null</code>
     * @return a new {@link ModelPartition}
     */
    public ModelPartition getOrCreatePartitionStable( String testName );


    /**
     * Get or creates a new {@link ModelPartition} in the client-specific
     * workspace of this client. The {@link PRI} of the partition depends on the
     * facility-specific implementation of the TestClient interface, and is
     * generated appropriately.
     * 
     * @param testName the name of the test requesting the partition; can be
     * <code>null</code>
     * @param containerName the name of the container the partition; can be
     * <code>null</code>
     * @return a new {@link ModelPartition}
     */
    public ModelPartition getOrCreatePartitionStable( String testName, String containerName );


    /**
     * Creates a new {@link ModelPartition} in the client-specific workspace of
     * this client.
     * 
     * @param partitionNameFragment the fragment of the partition name shall
     * contain.
     * @return a new {@link ModelPartition}
     */
    public ModelPartition createPartition( String partitionNameFragment );


    /**
     * Sets this client as the current client.
     * <p>
     * This means that the corsesponding user will be set as active user (and
     * authenticated if necessary), and the connection of this client will be
     * attached to the current thread.
     */
    public void setAsCurrentClient( );


    /**
     * Gets the client spec for this test client.
     * 
     * @return the client spec for this test client
     */
    public SpiClientSpec getClientSpec( );


    /**
     * Returns the facility of the test client. Currently, the test client makes
     * only use of one facility.
     * 
     * @return
     */
    public Facility getFacility( );


    /**
     * Closes the connection (if open) and resets all lazily initialized data of
     * this test client.
     */
    public void clear( );


    /**
     * Returns the name of the default model container (DcName), which is
     * provided by the test framework. This model container is used by the test
     * client per default for the creation of partitions (e.g. with method
     * <code>getOrCreatePartition</code>).
     */
    public String getDefaultContainerName( );


    /**
     * Returns the name of a second model container (DcName), which is provided
     * by the test framework.
     */
    public String getContainer2Name( );

    /**
     * clears the test client and removes it from the test client factory
     */
    public void delete( );

    /**
     * allows a reset of the test client to the new constructed state
     */
    public void reset( );
}
