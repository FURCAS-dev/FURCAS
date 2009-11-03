package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionChangingNotPossibleException;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.spi.facility.SpiFacility;
import com.sap.tc.moin.repository.transactions.RecoverableExecutionException;

public abstract class PartitionEnsureActivityAllowedAction extends AbstractAction {

    protected PRI partitionPri;

    private SpiFacility facility;

    public PartitionEnsureActivityAllowedAction( CoreConnection aConnection, PRI partition ) {

        super( aConnection );
        partitionPri = partition;
        String facilityId = partition.getDataAreaDescriptor( ).getFacilityId( );
        this.facility = (SpiFacility) aConnection.getSession( ).getWorkspaceSet( ).getMoin( ).getFacilityById( facilityId );
    }


    protected SpiFacility getFacility( ) {

        return this.facility;
    }


    @Override
    public final void execute( ) throws RecoverableExecutionException {

        try {
            this.doExecute( );
        } catch ( PartitionChangingNotPossibleException e ) {
            throw new RecoverableExecutionException( e );
        }
    }

    protected abstract void doExecute( ) throws PartitionChangingNotPossibleException;

    public PRI getPartitionPri( ) {

        return partitionPri;
    }


    @Override
    public boolean equals( Object obj ) {

        if ( obj == this ) {
            return true;
        }
        if ( obj instanceof PartitionEnsureActivityAllowedAction ) {
            PartitionEnsureActivityAllowedAction action = (PartitionEnsureActivityAllowedAction) obj;
            return partitionPri.equals( action.partitionPri );
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        return partitionPri.hashCode( );
    }
}