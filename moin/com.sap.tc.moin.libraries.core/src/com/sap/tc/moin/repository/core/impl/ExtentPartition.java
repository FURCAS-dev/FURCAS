/*
 * Created on 13.12.2005
 */
package com.sap.tc.moin.repository.core.impl;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionEditingNotPossibleException;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.spi.core.SpiStage;

/**
 * A specialized model partition implementation that cannot be saved and which is used as partition by a workspace for
 * extents
 * <p>
 */
public class ExtentPartition extends TransientPartition {

    public ExtentPartition( PRI pri, Workspace ws, SpiStage stage ) {

        super( null, ws, pri, stage );
    }

    @Override
    public boolean isExtentPartition( ) {

        return true;
    }
}