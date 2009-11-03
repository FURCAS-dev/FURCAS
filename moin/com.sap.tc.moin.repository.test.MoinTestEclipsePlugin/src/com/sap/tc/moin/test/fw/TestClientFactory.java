package com.sap.tc.moin.test.fw;

/**
 * Factory for {@link TestClient}s.
 * <p>
 * Since the implementation of a test client depends on the facility and
 * deployment scenario, they are instantiated via a factory. The implementation
 * class of the factory is loaded dynamically by the test framework according to
 * the test configuration.
 * <p>
 * The implementation classes of the TestCleintFactory have to implement a
 * public, non-arguments constructor.
 * 
 * @author D032434
 */
public interface TestClientFactory {

    /**
     * Gets a test client for the specified user and client spec index.
     * <p>
     * Users and client specs are not passed by name, because this depends on
     * the actual runtime environment and should be abstracted from the test
     * cases. Using the index, a test case can simulate multiple users and
     * client-specs.
     * 
     * @param userIndex the index of the user for this test client (starting by
     * 0)
     * @param clientSpecIndex the index of the client-spec for this test client
     * (starting by 0)
     * @param newInstance flag indicating if a new TestClient instance shall be
     * created or an existing instance from a previous call be returned
     * @return a test client for the specified user and client spec index
     * @throws IndexOutOfBoundsException if the userIndex or the clientIndex
     * exceeds the number of users or clientspecs specified in the
     * {@link TestConfiguration}
     */
    public TestClient getTestClient( int userIndex, int clientSpecIndex, boolean newInstance );

    public void removeTestClient( int userIndex, int clientSpecIndex );

    /**
     * Resets all test clients, i.e. closes all open connections and removes all
     * client instances.
     */
    public void clear( );

}
