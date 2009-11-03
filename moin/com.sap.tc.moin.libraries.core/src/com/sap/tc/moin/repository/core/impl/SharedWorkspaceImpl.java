package com.sap.tc.moin.repository.core.impl;

import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.core.SharedWorkspace;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.spi.core.SpiStage;

/**
 * A shared workspace is responsible for exactly one shared stage of one single
 * data area.
 * 
 * @author d020383
 */
public class SharedWorkspaceImpl extends WorkspaceImpl implements SharedWorkspace {

    private SpiStage stage;

    public SharedWorkspaceImpl( WorkspaceSet workspaceSet, SpiStage stage ) {

        super( workspaceSet );
        this.stage = stage;
    }

    public SpiStage getStage( DataAreaDescriptor dataAreaDescriptor ) {

        if ( this.stage.getDataAreaDescriptor( ).equals( dataAreaDescriptor ) ) {
            return this.stage;
        }
        return null;
    }

    @Override
    protected void toStringInternal( StringBuilder sb ) {

        super.toStringInternal( sb );
        sb.append( ", stage = " ); //$NON-NLS-1$
        sb.append( this.stage.toString( ) );
    }

    public boolean isShared( ) {

        return true;
    }

    public SpiStage getStage( ) {

        return this.stage;
    }
}