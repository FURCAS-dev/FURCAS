package com.sap.tc.moin.repository.core.events;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.PartitionChangeEvent;

/**
 * This is the implementation of
 * {@link com.sap.tc.moin.repository.events.type.PartitionChangeEvent}
 * 
 * @author Daniel Vocke (D044825)
 */
public abstract class PartitionChangeEventImpl extends ChangeEventImpl implements PartitionChangeEvent {

    private PRI affectedPartitionPri = null;

    /**
     * @param affectedPartitionMri - the {@link PRI} of the changed partition
     */
    protected PartitionChangeEventImpl( CoreConnection triggeringConnection, PRI affectedPartitionPri ) {

        super( triggeringConnection );
        this.affectedPartitionPri = affectedPartitionPri;
    }

    // convenience constructor
    /**
     * @param affectedPartition - the changed partition
     */
    protected PartitionChangeEventImpl( CoreConnection triggeringConnection, ModelPartition affectedPartition ) {

        super( triggeringConnection );
        affectedPartitionPri = affectedPartition.getPri( );
    }

    /**
     * @return the <code>PRI</code> of the partition that was touched
     */
    public PRI getAffectedPartitionPri( ) {

        return affectedPartitionPri;
    }

    /*
     * @see com.sap.tc.moin.repository.events.PartitionChangedEvent#getAffectedPartition(com.sap.tc.moin.repository.core.impl.Connection)
     */
    public ModelPartition getAffectedPartition( Connection resolvingConnection ) {

        return resolvingConnection.getPartition( getAffectedPartitionPri( ) );
    }

    /**
     * @see com.sap.tc.moin.repository.events.ChangeEventImpl#getAffectedPartitionsMRIs()
     * @return the same as {@link #getAffectedPartitionMRI()}
     */
    public Object getAffectedPartitionsPRIs( ) {

        return getAffectedPartitionPri( );
    }

    @Override
    protected String getParameterString( ) {

        return "PRI=" + affectedPartitionPri.toString( ); //$NON-NLS-1$
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.sap.tc.moin.repository.core.events.ChangeEventImpl#getTypeString()
     */
    @Override
    protected String getTypeString( ) {

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int hashCode( ) {

        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ( ( affectedPartitionPri == null ) ? 0 : affectedPartitionPri.hashCode( ) );
        return result;
    }

    @Override
    public boolean equals( Object obj ) {

        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass( ) != obj.getClass( ) )
            return false;
        final PartitionChangeEventImpl other = (PartitionChangeEventImpl) obj;
        if ( affectedPartitionPri == null ) {
            if ( other.affectedPartitionPri != null )
                return false;
        } else if ( !affectedPartitionPri.equals( other.affectedPartitionPri ) )
            return false;
        return true;
    }

}
