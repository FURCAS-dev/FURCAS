/*
 * Created on 02.11.2005
 */
package com.sap.tc.moin.repository.core.jmi.reflect;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.jmi.extension.RefFoundation;
import com.sap.tc.moin.repository.transactions.microtransactionables.MicroTransactionableFactory;
import com.sap.tc.moin.repository.transactions.transactionables.TransactionableFactory;

/**
 * This class acts as a common base class for all MOF repository classes.
 * {@link RefBaseObjectImpl} is a base class for most of the Ref classes, but
 * not for {@link RefStructImpl}. This base class does not yet provide any
 * services.
 * 
 * @author d024227
 */
public abstract class RefFoundationImpl implements RefFoundation {

    /**
     * Returns the Workspace of this RefBaseObject
     * 
     * @return the Workspace of this RefBaseObject
     */
    public abstract Workspace get___Workspace( );


    /**
     * Returns the current Connection
     * 
     * @return the current Connection
     */
    protected final CoreConnection get___CurrentConnection( ) {

        if ( get___Workspace( ).isMetamodelWorkspace( ) ) {
            //FIXME this is just a temporary solution until the MetamodelService in CPS
            //no longer uses MOF JMI interfaces
            return null;
        } else {
            return get___Workspace( ).getWorkspaceSet( ).getMoin( ).getCurrentConnection( );
        }
    }

    /**
     * Returns the Micro Transactionable Factory
     */
    protected final MicroTransactionableFactory get___MicroTransactionableFactory( ) {

        return get___Workspace( ).getWorkspaceSet( ).getMoin( ).getMicroTransactionableFactory( );
    }

    /**
     * Returns the Transactionable Factory
     */
    protected final TransactionableFactory get___TransactionableFactory( ) {

        return get___Workspace( ).getWorkspaceSet( ).getMoin( ).getTransactionableFactory( );
    }

}