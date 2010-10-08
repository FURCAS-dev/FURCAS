/**
 * 
 */
package com.sap.tc.moin.textual.moinadapter.adapter.stub;

import static org.junit.Assert.fail;

/**
 *
 */
public class PRIStub implements PRI {

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.PRI#createMri(java.lang.String)
     */
    public MRI createMri(String mofId) {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.PRI#getContainerName()
     */
    public String getContainerName() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.PRI#getCri()
     */
    public CRI getCri() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.PRI#getDataAreaDescriptor()
     */
    public DataAreaDescriptor getDataAreaDescriptor() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.PRI#getPartitionName()
     */
    public String getPartitionName() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.PRI#isMetaModelPartition()
     */
    public boolean isMetaModelPartition() {
        fail("not implemented yet");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.PRI#isNullPartition()
     */
    public boolean isNullPartition() {
        fail("not implemented yet");
        return false;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.PRI#isTransientPartition()
     */
    public boolean isTransientPartition() {
        fail("not implemented yet");
        return false;
    }

	@Override
	public boolean isVolatilePartition() {
        fail("not implemented yet");
		return false;
	}

}
