package com.sap.tc.moin.facility.primary.test.index;

import org.junit.Test;

public class TestDummy extends IndexTestCase {

    /**
     * This "test" ensures that MOIN is started and the index is available what
     * is necessary since its existence is tested in the IndexOnly attribute to
     * decide whether to ignore the test or not. This dummy can be removed if
     * there is only one index version.
     */
    @Test
    public void testDummyMustBeRunBeforeAllOtherIndexTests( ) {

    }
}
