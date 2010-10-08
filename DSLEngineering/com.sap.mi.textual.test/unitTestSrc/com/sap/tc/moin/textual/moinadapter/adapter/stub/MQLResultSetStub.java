/**
 * 
 */
package com.sap.tc.moin.textual.moinadapter.adapter.stub;

import static org.junit.Assert.fail;

import java.io.Writer;

/**
 *
 */
public class MQLResultSetStub implements MQLResultSet {

    public RefObject[] refObjects;

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLResultSet#asCSV(java.io.Writer)
     */
    @Override
    public void asCSV(Writer writer) throws MQLResultException {
        fail("not implemented yet");
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLResultSet#getAttribute(int, java.lang.String, java.lang.String)
     */
    @Override
    public Object getAttribute(int position, String alias, String attrName)
            throws MQLResultException {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLResultSet#getAttributes(int, java.lang.String)
     */
    @Override
    public Object[] getAttributes(int position, String alias)
            throws MQLResultException {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLResultSet#getMri(int, java.lang.String)
     */
    @Override
    public MRI getMri(int position, String alias) throws MQLResultException {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLResultSet#getMris(java.lang.String)
     */
    @Override
    public MRI[] getMris(String alias) throws MQLResultException {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLResultSet#getQueryColumnTypes()
     */
    @Override
    public MQLColumnType[] getQueryColumnTypes() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLResultSet#getRefObject(int, java.lang.String)
     */
    @Override
    public RefObject getRefObject(int position, String alias)
            throws MQLResultException {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLResultSet#getRefObjects(java.lang.String)
     */
    @Override
    public RefObject[] getRefObjects(String alias) throws MQLResultException {
        return refObjects;
    }

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mql.MQLResultSet#getSize()
     */
    @Override
    public int getSize() {
        return refObjects.length;
    }

	@Override
	public boolean isEmpty() {
        fail("not implemented yet");
		return false;
	}

	@Override
	public int removeRow(int position) throws MQLResultException {
        fail("not implemented yet");
		return 0;
	}

}
