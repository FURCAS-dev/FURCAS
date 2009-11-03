package com.sap.tc.moin.repository.core.impl;

import java.lang.ref.WeakReference;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.spi.core.SpiStage;

/**
 * @see com.sap.tc.moin.repository.core.impl.CoreTransientPartition
 */
public class TransientPartition extends ModelPartitionImpl {

    /**
     * The connection this partition belongs to as weak reference because we
     * don't want to prevent the gc from collecting the connection.
     */
    private WeakReference<Connection> owningConnection;

    private String owningConnectionId;

    /**
     * Create NoPartition with MRI and hosting Workspace. Workspace has to be
     * provided on construction since it must not be changed afterwards.
     * 
     * @param mri partition mri
     * @param ws workspace hosting this nopartition
     */
    public TransientPartition( Connection owningConnection, Workspace workspace, PRI pri, SpiStage stage ) {

        super( pri, stage, workspace );
        this.owningConnection = owningConnection != null ? new WeakReference<Connection>( owningConnection ) : null;
        this.owningConnectionId = owningConnection != null ? owningConnection.getId( ) : null;
    }

    /**
     * Nothing has to be done, especially the connection must not be informed as
     * it is done in the super class.
     */
    @Override
    public final boolean markDirty( CoreConnection connection ) {

        return isDirty( ); // the state does never change
    }

    /**
     * This method has no effect as this kind of partition is always considered
     * dirty because it is never persisted.
     */
    @Override
    public final void clearDirty( CoreConnection connection ) {

        // do nothing as this partition will always be considered dirty
    }

    /**
     * This implementation always returns <code>true</code> as soon as the
     * partition is not empty.
     */
    @Override
    public final boolean isDirty( ) {

        return !this.isEmpty( );
    }

    public Connection getOwningConnection( ) {

        if ( this.owningConnection == null ) {
            return null;
        }
        return this.owningConnection.get( );
    }

    public String getOwningConnectionId( ) {

        return this.owningConnectionId;
    }
}