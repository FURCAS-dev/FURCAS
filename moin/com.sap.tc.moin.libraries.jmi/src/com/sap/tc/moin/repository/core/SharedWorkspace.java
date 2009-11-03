package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.spi.core.SpiStage;


/**
 * A shared workspace is responsible for exactly one shared stage of one single
 * data area.
 * 
 * @author d020383
 */
public interface SharedWorkspace extends Workspace {

    public SpiStage getStage( );
}
