/**
 * 
 */
package com.sap.mi.textual.parsing;

import java.util.List;

/**
 * Stub only intended for testing. Only methods used by AbstractListbasedMetaLookup are being stubbed. 
 * Stubbed methods must be tested in MofStubtest.
 */
public class EnumerationTypeStub extends MofAnyStub implements EnumerationType {

    /**
     * 
     */
    private static final long serialVersionUID = -2321481093830443613L;
    public List<String> labels;
    public List<RefEnum> literals;

    /* (non-Javadoc)
     * @see com.sap.tc.moin.repository.mmi.model.EnumerationType#getLabels()
     */
    @Override
    public List<String> getLabels() throws JmiException {
        return labels;
    }


}
