package com.sap.tc.moin.repository.jmx;


public interface IndexDbDumpedMBean extends IndexDumpedMBean {

    /**
     * Checks if the index is corrupt and a re-indexing is required.
     * 
     * @return
     */
    @Description( "Signals if the index is corrupt and needs to be rebuild." )
    public boolean isCorrupt( );
}
