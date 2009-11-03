package com.sap.tc.moin.repository.core.transactions;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Classifier;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;

public abstract class AbstractTransactionObject {

    protected final CoreConnection connection;

    private WorkspaceSet workspaceSet;

    protected AbstractTransactionObject( CoreConnection aConnection ) {

        connection = aConnection;
    }

    protected AbstractTransactionObject( CoreConnection aConnection, WorkspaceSet workspaceSet ) {

        this( aConnection );
        this.workspaceSet = workspaceSet;
    }

    protected final boolean checkTypeCompatibility( Classifier classifier, Object objectToCheck ) {

        return getJmiHelper( ).checkTypeCompatibility( connection, classifier, objectToCheck );
    }

    /**
     * Eliminates duplicates and preserves the order of the elements in the
     * given <code>collection</code>
     */
    @SuppressWarnings( "unchecked" )
    protected final void eliminateDuplicates( Collection collection ) {

        if ( collection.size( ) > 1 ) {
            Set set = new HashSet( );
            for ( Iterator it = collection.iterator( ); it.hasNext( ); ) {
                Object element = it.next( );
                if ( !set.add( element ) ) {
                    it.remove( );
                }
            }
        }
    }

    protected final SpiJmiHelper getJmiHelper( ) {

        if ( this.workspaceSet == null ) {
            return connection.getSession( ).getWorkspaceSet( ).getMoin( ).getJmiHelper( );
        }

        return workspaceSet.getMoin( ).getJmiHelper( );
    }
}
