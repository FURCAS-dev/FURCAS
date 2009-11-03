package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.consistency.DanglingLinkConsistencyViolation;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.consistency.ConsistencyViolationRegistry;

public class NotifyDanglingLinkAction extends AbstractAction {


    private final LRI missingElementLri;

    private final EndStorageLink link;



    public NotifyDanglingLinkAction( CoreConnection connection, EndStorageLink link, LRI missingElementLri ) {

        super( connection );
        this.missingElementLri = missingElementLri;
        this.link = link;
    }

    @Override
    public void execute( ) throws JmiException {

        this.connection.getConsistencyViolationRegistry( ).notifyDanglingLinkInconsistency( missingElementLri, link );
    }

    @Override
    public void revert( ) throws JmiException {

        ConsistencyViolationRegistry consistencyViolationRegistry = this.connection.getConsistencyViolationRegistry( );
        DanglingLinkConsistencyViolation violation = consistencyViolationRegistry.checkRegisteredDanglingLink( link, false, this.connection );
        consistencyViolationRegistry.notifyResolvedConsistencyViolation( violation );
    }

    @Override
    public int hashCode( ) {

        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( link == null ) ? 0 : link.hashCode( ) );
        result = prime * result + ( ( missingElementLri == null ) ? 0 : missingElementLri.hashCode( ) );
        return result;
    }

    @Override
    public boolean equals( Object obj ) {

        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass( ) != obj.getClass( ) ) {
            return false;
        }
        final NotifyDanglingLinkAction other = (NotifyDanglingLinkAction) obj;
        if ( link == null ) {
            if ( other.link != null ) {
                return false;
            }
        } else if ( !link.equals( other.link ) ) {
            return false;
        }
        if ( missingElementLri == null ) {
            if ( other.missingElementLri != null ) {
                return false;
            }
        } else if ( !missingElementLri.equals( other.missingElementLri ) ) {
            return false;
        }
        return true;
    }


}