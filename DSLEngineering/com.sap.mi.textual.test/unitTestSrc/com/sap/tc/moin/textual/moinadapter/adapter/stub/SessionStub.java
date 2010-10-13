/**
 * 
 */
package com.sap.tc.moin.textual.moinadapter.adapter.stub;

import java.util.Collection;

import org.eclipse.core.internal.jobs.LockManager;

/**
 *
 */
public class SessionStub implements Session {

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Session#createConnection()
     */
    @Override
    public Connection createConnection() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Session#createConnection(java.lang.String)
     */
    @Override
    public Connection createConnection(String label) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Session#getCompoundClientSpec()
     */
    @Override
    public CompoundClientSpec getCompoundClientSpec() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Session#getEventRegistry()
     */
    @Override
    public EventRegistry getEventRegistry() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Session#getInnerPartitions(com.sap.tc.moin.repository.CRI)
     */
    @Override
    public Collection<PRI> getInnerPartitions(CRI cri) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Session#getLockManager()
     */
    @Override
    public LockManager getLockManager() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Session#getMoin()
     */
    @Override
    public Moin getMoin() {
        // TODO Auto-generated method stub
        return new Moin() {

            @Override
            public CRI createCri(String cri)
                    throws InvalidResourceIdentifierException {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public CRI createCri(String facilityId, String dataAreaName,
                    String containerName) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public LRI createLri(String lri)
                    throws InvalidResourceIdentifierException {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public LRI createLri(String facilityId, String dataAreaName,
                    String mofId) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public MRI createMri(String mri)
                    throws InvalidResourceIdentifierException {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public MRI createMri(String facilityId, String dataAreaName,
                    String containerName, String partitionName, String mofId) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public PRI createPri(String pri)
                    throws InvalidResourceIdentifierException {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public PRI createPri(String facilityId, String dataAreaName,
                    String containerName, String partitionName) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Session createSession(CompoundClientSpec compoundClientSpec) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public CompoundDataAreaManager getCompoundDataAreaManager() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Version getCoreRuntimeVersion() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Collection<Facility> getFacilities() {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public Facility getFacilityById(String facilityId) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            public MetaModelCatalog getMetamodelCatalog() {
                // TODO Auto-generated method stub
                return null;
            }};
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Session#getOuterPartitions(com.sap.tc.moin.repository.CRI)
     */
    @Override
    public Collection<PRI> getOuterPartitions(CRI cri) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Session#getReferencedContainers(com.sap.tc.moin.repository.CRI)
     */
    @Override
    public Collection<CRI> getReferencedContainers(CRI cri) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Session#hasCrossPartitionLinks(com.sap.tc.moin.repository.PRI, com.sap.tc.moin.repository.PRI[])
     */
    @Override
    public boolean hasCrossPartitionLinks(PRI priOne, PRI... otherPris) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.Session#isAlive()
     */
    @Override
    public boolean isAlive() {
        // TODO Auto-generated method stub
        return false;
    }

	@Override
	public boolean isContainerModifiable(CRI cri) {
		// TODO Auto-generated method stub
		return false;
	}

}
